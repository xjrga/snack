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

public class MixDifferences {

  private final Connection connection;

  public MixDifferences() {
    connection = Connect.getInstance().getConnection();
  }

  public List<Map<String, Object>> execute(String mixid1, String mixid2, Integer precision) {
    LinkedList<Map<String, Object>> list = new LinkedList<>();
    try (CallableStatement proc = connection.prepareCall("{CALL public.Mix_getDiff( ?, ?, ? )}")) {
      proc.setString(1, mixid1);
      proc.setString(2, mixid2);
      proc.setInt(3, precision);
      ResultSet rs = proc.executeQuery();
      while (rs.next()) {
        Map<String, Object> row = new HashMap<>();
        row.put("CATEGORY", rs.getObject(1));
        row.put("NUTRIENT", rs.getObject(2));
        row.put("MIXA", rs.getObject(3));
        row.put("MIXB", rs.getObject(4));
        row.put("DIFF", rs.getObject(5));
        list.add(row);
      }
    } catch (SQLException e) {
    }
    return list;
  }
}
