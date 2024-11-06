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

public class MealPortionSelectAll implements SqlCallMixid<Map<String, Object>> {

  private final Connection connection;

  public MealPortionSelectAll() {
    connection = Connect.getInstance().getConnection();
  }

  @Override
  public List<Map<String, Object>> execute(String mixid) {
    throw new UnsupportedOperationException("Not supported.");
  }

  @Override
  public List<Map<String, Object>> execute(String mixid, Integer precision) {
    LinkedList<Map<String, Object>> list = new LinkedList<>();
    try (CallableStatement proc =
        connection.prepareCall("{CALL public.MealFoodPortion_select_all( ?, ? )}")) {
      proc.setString(1, mixid);
      proc.setInt(2, precision);
      ResultSet rs = proc.executeQuery();
      while (rs.next()) {
        Map<String, Object> row = new HashMap<>();
        row.put("MIXID", rs.getObject(1));
        row.put("MEALID", rs.getObject(2));
        row.put("FOODID", rs.getObject(3));
        row.put("MEAL", rs.getObject(4));
        row.put("FOOD", rs.getObject(5));
        row.put("PCT", rs.getObject(6));
        row.put("EXPECTEDWT", rs.getObject(7));
        row.put("ACTUALWT", rs.getObject(8));
        list.add(row);
      }
    } catch (SQLException e) {
    }
    return list;
  }
}
