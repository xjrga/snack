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

public class NutrientRatioRhs implements SqlCallMixid<Map<String, Object>> {

  private final Connection connection;

  public NutrientRatioRhs() {
    connection = Connect.getInstance().getConnection();
  }

  @Override
  public List<Map<String, Object>> execute(String mixid) {
    LinkedList<Map<String, Object>> list = new LinkedList<>();
    try (CallableStatement proc = connection.prepareCall("{CALL public.nutrientratio_rhs( ? )}")) {
      proc.setString(1, mixid);
      ResultSet rs = proc.executeQuery();
      while (rs.next()) {
        HashMap<String, Object> row = new HashMap();
        // Integer mixid = rs.getString(1);
        String nutrient_id_1 = rs.getString(2);
        String nutrient_id_2 = rs.getString(3);
        Integer relationshipid = rs.getInt(4);
        Double b = rs.getDouble(5);
        row.put("NUTRIENT_ID_1", nutrient_id_1);
        row.put("NUTRIENT_ID_2", nutrient_id_2);
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
