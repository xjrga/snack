package io.github.xjrga.snack.database.callable.select;

import io.github.xjrga.snack.database.Connect;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.concurrent.Callable;

public class NutrientQuantityLhsTask implements Callable<double[]> {

    private final String mixid;
    private final String nutrientid;
    private final Integer relationshipid;
    private final Connection connection;

    public NutrientQuantityLhsTask(String mixid, String nutrientid, Integer relationshipid) {

        this.mixid = mixid;
        this.nutrientid = nutrientid;
        this.relationshipid = relationshipid;
        connection = Connect.getInstance().getConnection();
    }

    @Override
    public double[] call() {

        double[] coefficients = null;

        try (CallableStatement proc = connection.prepareCall("{CALL public.nutrient_lhs( ?, ?, ? )}")) {

            proc.setString(1, mixid);
            proc.setString(2, nutrientid);
            proc.setInt(3, relationshipid);
            ResultSet rs = proc.executeQuery();
            LinkedList<Double> list = new LinkedList<>();

            while (rs.next()) {

                double c = rs.getDouble(2);
                list.add(c);
            }

            proc.close();
            int size = list.size();
            coefficients = new double[size];

            for (int i = 0; i < size; i++) {

                coefficients[i] = list.get(i);
            }

        } catch (SQLException e) {

        }

        return coefficients;
    }
}
