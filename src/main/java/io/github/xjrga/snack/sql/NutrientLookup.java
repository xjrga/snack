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

public class NutrientLookup {

  private final Connection connection;

  public NutrientLookup() {
    connection = Connect.getInstance().getConnection();
  }

  public List<Map<String, Object>> execute(String nutrientid, Double value, Integer precision) {
    LinkedList<Map<String, Object>> list = new LinkedList<>();
    try (CallableStatement proc =
        connection.prepareCall("{CALL public.Nutrient_Lookup_List( ?, ?, ? )}")) {
      proc.setString(1, nutrientid);
      proc.setDouble(2, value);
      proc.setInt(3, precision);
      ResultSet rs = proc.executeQuery();
      while (rs.next()) {
        Map<String, Object> row = new HashMap<>();
        row.put("NAME", rs.getObject(1));
        row.put("CALORIES", rs.getObject(2));
        row.put("WEIGHT", rs.getObject(3));
        list.add(row);
      }
    } catch (SQLException e) {
    }
    return list;
  }
}
