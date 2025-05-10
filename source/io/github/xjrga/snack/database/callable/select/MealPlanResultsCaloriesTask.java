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
public class MealPlanResultsCaloriesTask implements Callable<List<List>> {

  private final Connection connection;
  private final String mixid;

  public MealPlanResultsCaloriesTask(String mixid) {
    connection = Connect.getInstance().getConnection();
    this.mixid = mixid;
  }

  @Override
  public List<List> call() {
    ArrayList<List> table = new ArrayList();
    try (CallableStatement proc =
        connection.prepareCall("{CALL public.results_by_meal_select( ? )}")) {
      proc.setString(1, mixid);
      ResultSet rs = proc.executeQuery();
      if (rs.wasNull()) {
        return new ArrayList<List>();
      }
      while (rs.next()) {
        ArrayList row = new ArrayList();
        // name
        row.add(rs.getString(1));
        // weight
        row.add(rs.getBigDecimal(2));
        // egross
        row.add(rs.getBigDecimal(3));
        // edigest
        row.add(rs.getBigDecimal(4));
        // efat
        row.add(rs.getBigDecimal(5));
        // ecarbs
        row.add(rs.getBigDecimal(6));
        // efatcarbs
        row.add(rs.getBigDecimal(7));
        // eprotein
        row.add(rs.getBigDecimal(8));
        // ealcohol
        row.add(rs.getBigDecimal(9));
        // fat
        row.add(rs.getBigDecimal(10));
        // carbs
        row.add(rs.getBigDecimal(11));
        // protein
        row.add(rs.getBigDecimal(12));
        // complete
        row.add(rs.getBigDecimal(13));
        // alcohol
        row.add(rs.getBigDecimal(14));
        // fiber
        row.add(rs.getBigDecimal(15));
        // sodium
        row.add(rs.getBigDecimal(16));
        // potassium
        row.add(rs.getBigDecimal(17));
        table.add(row);
      }
    } catch (SQLException e) {
      LoggerImpl.INSTANCE.logProblem(e);
    }
    return table;
  }
}
