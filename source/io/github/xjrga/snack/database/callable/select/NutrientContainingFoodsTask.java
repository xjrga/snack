package io.github.xjrga.snack.database.callable.select;

import io.github.xjrga.snack.database.Connect;
import io.github.xjrga.snack.logger.LoggerImpl;
import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * @author jr
 */
public class NutrientContainingFoodsTask implements Callable<List<List>> {

  private final Connection connection;
  private final String nutrientid;
  private final BigDecimal value;

  public NutrientContainingFoodsTask(String nutrientid, BigDecimal value) {
    connection = Connect.getInstance().getConnection();
    this.nutrientid = nutrientid;
    this.value = value;
  }

  @Override
  public List<List> call() {
    ArrayList<List> table = new ArrayList();
    try (CallableStatement proc =
        connection.prepareCall("{CALL public.Nutrient_Lookup_List( ?, ? )}")) {
      proc.setString(1, nutrientid);
      proc.setBigDecimal(2, value);
      ResultSet rs = proc.executeQuery();
      while (rs.next()) {
        ArrayList row = new ArrayList();
        row.add(rs.getString(1));
        row.add(rs.getBigDecimal(2));
        row.add(rs.getBigDecimal(3));
        table.add(row);
      }
    } catch (Exception e) {
      LoggerImpl.INSTANCE.logProblem(e);
    }
    return table;
  }
}
