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

public class FoodStatistics {

  private final Connection connection;

  public FoodStatistics() {
    connection = Connect.getInstance().getConnection();
  }

  public List<Map<String, Object>> execute(String foodid) {
    LinkedList<Map<String, Object>> list = new LinkedList<>();
    try (CallableStatement proc =
        connection.prepareCall("{CALL public.get_food_statistics( ? )}")) {
      proc.setString(1, foodid);
      ResultSet rs = proc.executeQuery();
      while (rs.next()) {
        Map<String, Object> row = new HashMap<>();
        row.put("FATPCT", rs.getObject(1));
        row.put("CARBPCT", rs.getObject(2));
        row.put("PROTEINPCT", rs.getObject(3));
        row.put("ALCOHOLPCT", rs.getObject(4));
        row.put("SATFATPCT", rs.getObject(5));
        row.put("POLYUFATPCT", rs.getObject(6));
        row.put("MONOUFATPCT", rs.getObject(7));
        row.put("LAPCT", rs.getObject(8));
        row.put("ALAPCT", rs.getObject(9));
        row.put("PSRATIO", rs.getObject(10));
        row.put("MSRATIO", rs.getObject(11));
        row.put("ESSENTIALFATRATIO", rs.getObject(12));
        row.put("ELECTROLYTERATIO", rs.getObject(13));
        row.put("FQ", rs.getObject(14));
        list.add(row);
      }
    } catch (SQLException e) {
    }
    return list;
  }
}
