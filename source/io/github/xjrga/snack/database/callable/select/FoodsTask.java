package io.github.xjrga.snack.database.callable.select;

import io.github.xjrga.snack.database.Connect;
import io.github.xjrga.snack.logger.LoggerImpl;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

/**
 * @author jr
 */
public class FoodsTask implements Callable<List<Map<String, Object>>> {

  private final Connection connection;

  public FoodsTask() {
    connection = Connect.getInstance().getConnection();
  }

  @Override
  public List<Map<String, Object>> call() {
    List<Map<String, Object>> list = new ArrayList<>();
    try (CallableStatement proc = connection.prepareCall("{CALL public.Food_Select_All()}")) {
      ResultSet rs = proc.executeQuery();
      while (rs.next()) {
        Map<String, Object> row = new HashMap<>();
        row.put("CATEGORY", rs.getObject(1));
        row.put("FOODID", rs.getObject(2));
        row.put("FOOD", rs.getObject(3));
        row.put("FOODCATEGORYID", rs.getObject(4));
        list.add(row);
      }
    } catch (SQLException e) {
      LoggerImpl.INSTANCE.logProblem(e);
    }
    return list;
  }
}
