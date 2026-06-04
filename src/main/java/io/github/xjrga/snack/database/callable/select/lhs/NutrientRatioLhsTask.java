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

public class NutrientRatioLhsTask implements Callable<LhsContainer> {

    private final String mixid;
    private final Connection connection;
    private final String nutrientIdA;
    private final String nutrientIdB;
    private final BigDecimal A;
    private final BigDecimal B;

    public NutrientRatioLhsTask(String mixid, String nutrientidA, String nutrientidB, BigDecimal A, BigDecimal B) {
        this.mixid = mixid;
        this.nutrientIdA = nutrientidA;
        this.nutrientIdB = nutrientidB;
        this.A = A;
        this.B = B;
        connection = Connect.getInstance().getConnection();
    }

    @Override
    public LhsContainer call() {
        LhsContainer container = new LhsContainer();
        try (CallableStatement proc = connection.prepareCall("{CALL public.dridev_nutrientratio_lhs( ?,?,?,?,? )}")) {
            proc.setString(1, mixid);
            proc.setString(2, nutrientIdA);
            proc.setString(3, nutrientIdB);
            proc.setBigDecimal(4, A);
            proc.setBigDecimal(5, B);
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
            e.printStackTrace();
        }
        return container;
    }
}
