package io.github.xjrga.snack.sql;

import io.github.xjrga.snack.database.Connect;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class MealSelectAll implements SqlCallMixid<Map<String, Object>> {

  private final Connection connection;

  public MealSelectAll() {
    connection = Connect.getInstance().getConnection();
  }

  @Override
  public List<Map<String, Object>> execute(String mixid) {
    LinkedList<Map<String, Object>> list = new LinkedList<>();
    try (CallableStatement proc = connection.prepareCall("{CALL public.Meal_Select_All( ? )}")) {
      proc.setString(1, mixid);
      ResultSet rs = proc.executeQuery();
      while (rs.next()) {
        Map<String, Object> row = new HashMap<>();
        row.put("MIXID", rs.getObject(1));
        row.put("MEALID", rs.getObject(2));
        row.put("NAME", rs.getObject(3));
        row.put("MEALORDER", rs.getObject(4));
        list.add(row);
      }
    } catch (SQLException e) {
    }
    return list;
  }

  @Override
  public List<Map<String, Object>> execute(String mixid, Integer precision) {
    throw new UnsupportedOperationException("Not supported.");
  }
}
