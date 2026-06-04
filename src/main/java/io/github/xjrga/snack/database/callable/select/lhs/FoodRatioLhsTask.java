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

public class FoodRatioLhsTask implements Callable<LhsContainer> {

    private final Connection connection;
    private final String mixid;
    private final String foodidA;
    private final String nutrientidA;
    private final BigDecimal A;
    private final String foodidB;
    private final String nutrientidB;
    private final BigDecimal B;

    public FoodRatioLhsTask(
            String mixid,
            String foodidA,
            String nutrientidA,
            BigDecimal A,
            String foodidB,
            String nutrientidB,
            BigDecimal B) {
        this.mixid = mixid;
        this.foodidA = foodidA;
        this.A = A;
        this.nutrientidA = nutrientidA;
        this.foodidB = foodidB;
        this.nutrientidB = nutrientidB;
        this.B = B;
        connection = Connect.getInstance().getConnection();
    }

    @Override
    public LhsContainer call() {
        LhsContainer container = new LhsContainer();
        try (CallableStatement proc = connection.prepareCall("{CALL public.dridev_foodratio_lhs( ?,?,?,?,?,?,? )}")) {
            proc.setString(1, mixid);
            proc.setString(2, foodidA);
            proc.setString(3, nutrientidA);
            proc.setBigDecimal(4, A);
            proc.setString(5, foodidB);
            proc.setString(6, nutrientidB);
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
            e.printStackTrace();
        }
        return container;
    }
}
