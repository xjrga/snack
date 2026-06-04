package io.github.xjrga.snack.database.callable.select.lhs;

import io.github.xjrga.snack.database.Connect;
import io.github.xjrga.snack.dataobject.Lhs;
import io.github.xjrga.snack.dataobject.LhsContainer;
import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.concurrent.Callable;

public class FoodLhsTask implements Callable<LhsContainer> {

    private final String mixid;
    private final String foodid;
    private final String nutrientid;
    private final Integer relationshipid;
    private final Connection connection;

    public FoodLhsTask(String mixid, String foodid, String nutrientid, Integer relationshipid) {
        this.mixid = mixid;
        this.foodid = foodid;
        this.nutrientid = nutrientid;
        this.relationshipid = relationshipid;
        connection = Connect.getInstance().getConnection();
    }

    @Override
    public LhsContainer call() {
        LhsContainer container = new LhsContainer();
        try (CallableStatement proc = connection.prepareCall("{CALL public.foodnutrient_lhs( ?, ?, ?, ? )}")) {
            proc.setString(1, mixid);
            proc.setString(2, foodid);
            proc.setString(3, nutrientid);
            proc.setInt(4, relationshipid);
            ResultSet rs = proc.executeQuery();
            LinkedList<Double> list = new LinkedList<>();
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
