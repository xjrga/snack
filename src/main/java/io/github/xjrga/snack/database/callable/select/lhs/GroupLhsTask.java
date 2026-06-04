package io.github.xjrga.snack.database.callable.select.lhs;

import io.github.xjrga.snack.database.Connect;
import io.github.xjrga.snack.dataobject.Lhs;
import io.github.xjrga.snack.dataobject.LhsContainer;
import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.Callable;

public class GroupLhsTask implements Callable<LhsContainer> {

    private final String mixid;
    private final String groupid;
    private final String nutrientid;
    private final Connection connection;

    public GroupLhsTask(String mixid, String groupid, String nutrientid) {
        this.mixid = mixid;
        this.groupid = groupid;
        this.nutrientid = nutrientid;
        connection = Connect.getInstance().getConnection();
    }

    @Override
    public LhsContainer call() {
        LhsContainer container = new LhsContainer();
        try (CallableStatement proc = connection.prepareCall("{CALL public.foodgroup_lhs( ?, ?, ? )}")) {
            proc.setString(1, mixid);
            proc.setString(2, groupid);
            proc.setString(3, nutrientid);
            ResultSet rs = proc.executeQuery();
            while (rs.next()) {
                Integer rownum = rs.getInt(1);
                String name = rs.getString(2);
                BigDecimal c = rs.getBigDecimal(3);
                Lhs lhs = new Lhs(rownum, name, c);
                container.add(lhs);
            }
            proc.close();
        } catch (SQLException e) {
        }
        return container;
    }
}
