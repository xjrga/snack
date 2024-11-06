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

public class ResultsByMealSelect implements SqlCallMixid<Map<String, Object>> {

  private final Connection connection;

  public ResultsByMealSelect() {
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
        connection.prepareCall("{CALL public.results_by_meal_select( ?, ? )}")) {
      proc.setString(1, mixid);
      proc.setInt(2, precision);
      ResultSet rs = proc.executeQuery();
      while (rs.next()) {
        Map<String, Object> row = new HashMap<>();
        row.put("NAME", rs.getObject(1));
        row.put("WEIGHT", rs.getObject(2));
        row.put("EGROSS", rs.getObject(3));
        row.put("EDIGEST", rs.getObject(4));
        row.put("EFAT", rs.getObject(5));
        row.put("ECARBS", rs.getObject(6));
        row.put("EFATCARBS", rs.getObject(7));
        row.put("EPROTEIN", rs.getObject(8));
        row.put("EALCOHOL", rs.getObject(9));
        row.put("FAT", rs.getObject(10));
        row.put("CARBS", rs.getObject(11));
        row.put("PROTEIN", rs.getObject(12));
        row.put("COMPLETE", rs.getObject(13));
        row.put("ALCOHOL", rs.getObject(14));
        row.put("FIBER", rs.getObject(15));
        row.put("SODIUM", rs.getObject(16));
        row.put("POTASSIUM", rs.getObject(17));
        list.add(row);
      }
      proc.close();
    } catch (SQLException e) {
    }
    return list;
  }
}
