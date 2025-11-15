package io.github.xjrga.snack.database.callable.select;

import io.github.xjrga.snack.database.Connect;
import io.github.xjrga.snack.logger.LoggerImpl;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.concurrent.Callable;

public class NutrientRatioLhsTask implements Callable<double[]> {

    private final String mixid;
    private final String nutrientid1;
    private final String nutrientid2;
    private final Integer relationshipid;
    private final Connection connection;

    public NutrientRatioLhsTask(String mixid, String nutrientid1, String nutrientid2, Integer relationshipid) {

        this.mixid = mixid;
        this.nutrientid1 = nutrientid1;
        this.nutrientid2 = nutrientid2;
        this.relationshipid = relationshipid;
        connection = Connect.getInstance().getConnection();
    }

    @Override
    public double[] call() {

        double[] coefficients = null;

        try (CallableStatement proc = connection.prepareCall("{CALL public.nutrientratio_lhs( ?, ?, ?, ? )}")) {

            proc.setString(1, mixid);
            proc.setString(2, nutrientid1);
            proc.setString(3, nutrientid2);
            proc.setInt(4, relationshipid);
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

            LoggerImpl.INSTANCE.logProblem(e);
        }

        return coefficients;
    }
}
