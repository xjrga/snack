package io.github.xjrga.snack.database.callable.select;

import io.github.xjrga.snack.database.Connect;
import io.github.xjrga.snack.logger.LoggerImpl;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * @author jr
 */
public class MealPlanPortionsTask implements Callable<List<List>> {

    private final Connection connection;
    private final String mixid;

    public MealPlanPortionsTask(String mixid) {

        connection = Connect.getInstance().getConnection();
        this.mixid = mixid;
    }

    @Override
    public List<List> call() {

        ArrayList<List> table = new ArrayList();

        try (CallableStatement proc = connection.prepareCall("{CALL public.MealFoodPortion_select_all( ? )}")) {

            proc.setString(1, mixid);
            ResultSet rs = proc.executeQuery();

            while (rs.next()) {

                ArrayList row = new ArrayList();
                row.add(rs.getString(1));
                row.add(rs.getInt(2));
                row.add(rs.getString(3));
                row.add(rs.getString(4));
                row.add(rs.getString(5));
                row.add(rs.getBigDecimal(6));
                row.add(rs.getBigDecimal(7));
                row.add(rs.getBigDecimal(8));
                row.add(rs.getInt(9));
                table.add(row);
            }

        } catch (SQLException e) {

            LoggerImpl.INSTANCE.logProblem(e);
        }

        return table;
    }
}
