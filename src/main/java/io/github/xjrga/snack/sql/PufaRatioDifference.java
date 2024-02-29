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

public class PufaRatioDifference {

  private final Connection connection;

  public PufaRatioDifference() {
    connection = Connect.getInstance().getConnection();
  }

  public List<Map<String, Object>> execute(String MixId1, String MixId2, Integer Precision) {
    LinkedList<Map<String, Object>> list = new LinkedList<>();
    try (CallableStatement proc =
        connection.prepareCall("{CALL public.get_polyufat_ratio_difference( ?, ?, ? )}")) {
      proc.setString(1, MixId1);
      proc.setString(2, MixId2);
      proc.setInt(3, Precision);
      ResultSet rs = proc.executeQuery();
      while (rs.next()) {
        Map<String, Object> row = new HashMap<>();
        row.put("NUTRIENT", rs.getObject(1));
        row.put("MIX1", rs.getObject(2));
        row.put("MIX2", rs.getObject(3));
        row.put("DIFF", rs.getObject(4));
        list.add(row);
      }
    } catch (SQLException e) {
    }
    return list;
  }
}
