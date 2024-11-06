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

public class MixGetMealGi implements SqlCallMixid<Map<String, Object>> {

  private final Connection connection;

  public MixGetMealGi() {
    connection = Connect.getInstance().getConnection();
  }

  @Override
  public List<Map<String, Object>> execute(String mixid) {
    throw new UnsupportedOperationException("Not supported.");
  }

  @Override
  public List<Map<String, Object>> execute(String mixid, Integer precision) {
    LinkedList<Map<String, Object>> list = new LinkedList<>();
    try (CallableStatement proc = connection.prepareCall("{CALL public.Mix_getMealGI( ?, ? )}")) {
      proc.setString(1, mixid);
      proc.setInt(2, precision);
      ResultSet rs = proc.executeQuery();
      while (rs.next()) {
        Map<String, Object> row = new HashMap<>();
        String name = rs.getString(1);
        Double weight = rs.getDouble(2);
        Double carbs = rs.getDouble(3);
        Double pct = rs.getDouble(4);
        Double gl = rs.getDouble(5);
        Double gi = rs.getDouble(6);
        Double mealgi = rs.getDouble(7);
        Double ecarbs = rs.getDouble(8);
        row.put("name", name);
        row.put("weight", weight);
        row.put("carbs", carbs);
        row.put("pct", pct);
        row.put("gl", gl);
        row.put("gi", gi);
        row.put("mealgi", mealgi);
        row.put("ecarbs", ecarbs);
        list.add(row);
      }
    } catch (SQLException e) {
    }
    return list;
  }
}
