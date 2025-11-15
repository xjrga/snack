package io.github.xjrga.snack.database.callable.select;

import io.github.xjrga.snack.database.Connect;
import io.github.xjrga.snack.dataobject.DriDO;
import io.github.xjrga.snack.logger.LoggerImpl;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * @author jr
 */
public class LifestageDriTask implements Callable<List<DriDO>> {

    private final Connection connection;
    private final String nutrientId;
    private final Integer lifestageId;

    public LifestageDriTask(String nutrientId, Integer lifestageId) {

        connection = Connect.getInstance().getConnection();
        this.nutrientId = nutrientId;
        this.lifestageId = lifestageId;
    }

    @Override
    public List<DriDO> call() {

        List<DriDO> table = new ArrayList();

        try (CallableStatement proc = connection.prepareCall("{CALL public.getDri( ?, ? )}")) {

            proc.setString(1, nutrientId);
            proc.setInt(2, lifestageId);
            ResultSet rs = proc.executeQuery();

            while (rs.next()) {

                DriDO o = new DriDO(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getBigDecimal(6));
                table.add(o);
            }

        } catch (Exception e) {

            LoggerImpl.INSTANCE.logProblem(e);
        }

        return table;
    }
}
