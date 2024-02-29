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

public class FoodNutrientConstraintSelect implements SqlCallMixid<Map<String, Object>> {

  private final Connection connection;

  public FoodNutrientConstraintSelect() {
    connection = Connect.getInstance().getConnection();
  }

  @Override
  public List<Map<String, Object>> execute(String mixid) {
    LinkedList<Map<String, Object>> list = new LinkedList<>();
    try (CallableStatement proc =
        connection.prepareCall("{CALL public.FoodNutrientConstraint_Select( ? )}")) {
      proc.setString(1, mixid);
      ResultSet rs = proc.executeQuery();
      while (rs.next()) {
        Map<String, Object> row = new HashMap<>();
        row.put("MIXID", rs.getObject(1));
        row.put("FOODID", rs.getObject(2));
        row.put("NUTRIENTID", rs.getObject(3));
        row.put("RELATIONSHIPID", rs.getObject(4));
        row.put("FOOD", rs.getObject(5));
        row.put("NUTRIENT", rs.getObject(6));
        row.put("RELATIONSHIP", rs.getObject(7));
        row.put("B", rs.getObject(8));
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
