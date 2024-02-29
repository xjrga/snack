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

public class FoodNutrientRatioSelect implements SqlCallMixid<Map<String, Object>> {

  private final Connection connection;

  public FoodNutrientRatioSelect() {
    connection = Connect.getInstance().getConnection();
  }

  @Override
  public List<Map<String, Object>> execute(String mixid) {
    LinkedList<Map<String, Object>> list = new LinkedList<>();
    try (CallableStatement proc =
        connection.prepareCall("{CALL public.FoodNutrientRatio_Select( ? )}")) {
      proc.setString(1, mixid);
      ResultSet rs = proc.executeQuery();
      while (rs.next()) {
        Map<String, Object> row = new HashMap<>();
        row.put("MIXID", rs.getObject(1));
        row.put("FOOD_ID_1", rs.getObject(2));
        row.put("NUTRIENT_ID_1", rs.getObject(3));
        row.put("FOOD_ID_2", rs.getObject(4));
        row.put("NUTRIENT_ID_2", rs.getObject(5));
        row.put("RELATIONSHIPID", rs.getObject(6));
        row.put("FOODA", rs.getObject(7));
        row.put("NUTRIENTA", rs.getObject(8));
        row.put("FOODB", rs.getObject(9));
        row.put("NUTRIENTB", rs.getObject(10));
        row.put("A", rs.getObject(11));
        row.put("B", rs.getObject(12));
        row.put("RELATIONSHIP", rs.getObject(13));
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
