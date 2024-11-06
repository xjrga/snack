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

public class RdaDifferences {

  private final Connection connection;

  public RdaDifferences() {
    connection = Connect.getInstance().getConnection();
  }

  public List<Map<String, Object>> execute(String mixid, Integer lifestage, Integer precision) {
    LinkedList<Map<String, Object>> list = new LinkedList<>();
    try (CallableStatement proc =
        connection.prepareCall("{CALL public.Mix_getRdaDiff( ?, ?, ? )}")) {
      proc.setString(1, mixid);
      proc.setInt(2, lifestage);
      proc.setInt(3, precision);
      ResultSet rs = proc.executeQuery();
      while (rs.next()) {
        Map<String, Object> row = new HashMap<>();
        row.put("NUTRIENTID", rs.getObject(1));
        row.put("NAME", rs.getObject(2));
        row.put("MIX", rs.getObject(3));
        row.put("RDA", rs.getObject(4));
        row.put("PCTRDA", rs.getObject(5));
        row.put("UL", rs.getObject(6));
        row.put("PCTUL", rs.getObject(7));
        list.add(row);
      }
    } catch (SQLException e) {
    }
    return list;
  }
}
