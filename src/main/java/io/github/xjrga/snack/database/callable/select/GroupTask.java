package io.github.xjrga.snack.database.callable.select;

import io.github.xjrga.snack.database.Connect;
import io.github.xjrga.snack.logger.LoggerImpl;
import io.github.xjrga.snack.records.Records;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * @author jr
 */
public class GroupTask implements Callable<List<Records.Group>> {

    private final Connection connection;
    private final String mixid;

    public GroupTask(String mixid) {
        connection = Connect.getInstance().getConnection();
        this.mixid = mixid;
    }

    @Override
    public List<Records.Group> call() {
        ArrayList<Records.Group> table = new ArrayList();
        try (CallableStatement proc = connection.prepareCall("{CALL public.Group_Select_All_By_Name(?)}")) {
            proc.setString(1, mixid);
            ResultSet rs = proc.executeQuery();
            if (rs.wasNull()) {
                return new ArrayList<Records.Group>();
            }
            while (rs.next()) {
                Records.Group group = new Records.Group(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3));
                table.add(group);
            }
        } catch (Exception e) {
            LoggerImpl.INSTANCE.logProblem(e);
        }
        return table;
    }
}
