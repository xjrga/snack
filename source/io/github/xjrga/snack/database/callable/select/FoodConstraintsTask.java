package io.github.xjrga.snack.database.callable.select;

import io.github.xjrga.snack.database.Connect;
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
public class FoodConstraintsTask implements Callable<List<List>> {

    private final Connection connection;
    private final String mixid;

    public FoodConstraintsTask(String mixid) {

        connection = Connect.getInstance().getConnection();
        this.mixid = mixid;
    }

    @Override
    public List<List> call() {

        ArrayList<List> table = new ArrayList();

        try (CallableStatement proc = connection.prepareCall("{CALL public.FoodNutrientConstraint_Select( ? )}")) {

            proc.setString(1, mixid);
            ResultSet rs = proc.executeQuery();

            while (rs.next()) {

                ArrayList row = new ArrayList();
                row.add(rs.getString(1));
                row.add(rs.getString(2));
                row.add(rs.getString(3));
                row.add(rs.getInt(4));
                row.add(rs.getString(5));
                row.add(rs.getString(6));
                row.add(rs.getString(7));
                row.add(rs.getBigDecimal(8));
                table.add(row);
            }

        } catch (Exception e) {

            LoggerImpl.INSTANCE.logProblem(e);
        }

        return table;
    }
}
