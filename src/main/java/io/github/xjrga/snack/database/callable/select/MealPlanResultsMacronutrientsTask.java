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
public class MealPlanResultsMacronutrientsTask implements Callable<List<List>> {

    private final Connection connection;
    private final String mixid;

    public MealPlanResultsMacronutrientsTask(String mixid) {
        connection = Connect.getInstance().getConnection();
        this.mixid = mixid;
    }

    @Override
    public List<List> call() {
        ArrayList<List> table = new ArrayList();
        try (CallableStatement proc = connection.prepareCall("{CALL public.results_by_meal_select( ? )}")) {
            proc.setString(1, mixid);
            ResultSet rs = proc.executeQuery();
            if (rs.wasNull()) {
                return new ArrayList<List>();
            }
            while (rs.next()) {
                ArrayList row = new ArrayList();
                // meal order
                row.add(rs.getInt(1));
                // name
                row.add(rs.getString(2));
                // weight
                row.add(rs.getBigDecimal(3));
                // fat
                row.add(rs.getBigDecimal(11));
                // carbs
                row.add(rs.getBigDecimal(12));
                // protein
                row.add(rs.getBigDecimal(13));
                // complete
                row.add(rs.getBigDecimal(14));
                // alcohol
                row.add(rs.getBigDecimal(15));
                // fiber
                row.add(rs.getBigDecimal(16));
                // sodium
                row.add(rs.getBigDecimal(17));
                // potassium
                row.add(rs.getBigDecimal(18));
                table.add(row);
            }
        } catch (SQLException e) {
            LoggerImpl.INSTANCE.logProblem(e);
        }
        return table;
    }
}
