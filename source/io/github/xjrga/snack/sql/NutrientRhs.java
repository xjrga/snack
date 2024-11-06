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

public class NutrientRhs implements SqlCallMixid<Map<String, Object>> {

  private final Connection connection;

  public NutrientRhs() {
    connection = Connect.getInstance().getConnection();
  }

  @Override
  public List<Map<String, Object>> execute(String mixid) {
    LinkedList<Map<String, Object>> list = new LinkedList<>();
    try (CallableStatement proc = connection.prepareCall("{CALL public.nutrient_rhs( ? )}")) {
      proc.setString(1, mixid);
      ResultSet rs = proc.executeQuery();
      while (rs.next()) {
        HashMap<String, Object> row = new HashMap();
        // Integer mixid = rs.getString(1);
        String nutrientid = rs.getString(2);
        Integer relationshipid = rs.getInt(3);
        Double b = rs.getDouble(4);
        row.put("NUTRIENTID", nutrientid);
        row.put("RELATIONSHIPID", relationshipid);
        row.put("B", b);
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
