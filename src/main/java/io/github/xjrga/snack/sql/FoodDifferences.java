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

public class FoodDifferences {

  private final Connection connection;

  public FoodDifferences() {
    connection = Connect.getInstance().getConnection();
  }

  public List<Map<String, Object>> execute(String foodida, String foodidb, Integer precision) {
    LinkedList<Map<String, Object>> list = new LinkedList<>();
    try (CallableStatement proc =
        connection.prepareCall("{CALL public.food_differences_procedure( ?, ?, ? )}")) {
      proc.setString(1, foodida);
      proc.setString(2, foodidb);
      proc.setInt(3, precision);
      ResultSet rs = proc.executeQuery();
      while (rs.next()) {
        Map<String, Object> row = new HashMap<>();
        row.put("CATEGORY", rs.getObject(1));
        row.put("NUTRIENT", rs.getObject(2));
        row.put("FOODA", rs.getObject(3));
        row.put("FOODB", rs.getObject(4));
        row.put("DIFF", rs.getObject(5));
        list.add(row);
      }
    } catch (SQLException e) {
    }
    return list;
  }
}
