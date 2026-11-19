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

public class GroupRatioLhsTask implements Callable<LhsContainer> {

    private final Connection connection;
    private final String mixid;
    private final String groupid1;
    private final String nutrientid1;
    private final String groupid2;
    private final String nutrientid2;
    private final BigDecimal A;
    private final BigDecimal B;

    public GroupRatioLhsTask(String mixid, String groupid1, String nutrientid1, String groupid2, String nutrientid2, BigDecimal A, BigDecimal B) {
        this.mixid = mixid;
        this.groupid1 = groupid1;
        this.nutrientid1 = nutrientid1;
        this.groupid2 = groupid2;
        this.nutrientid2 = nutrientid2;
        this.A = A;
        this.B = B;
        connection = Connect.getInstance().getConnection();
    }

    @Override
    public LhsContainer call() {
        LhsContainer container = new LhsContainer();
        try (CallableStatement proc = connection.prepareCall("{CALL public.dridev_groupratio_lhs( ?, ?, ?, ?, ?, ?, ? )}")) {
            proc.setString(1, mixid);
            proc.setString(2, groupid1);
            proc.setString(3, nutrientid1);
            proc.setString(4, groupid2);
            proc.setString(5, nutrientid2);
            proc.setBigDecimal(6, A);
            proc.setBigDecimal(7, B);
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
