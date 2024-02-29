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

public class MixFoodSelectAllByFoodid implements SqlCallMixid<Map<String, String>> {

  private final Connection connection;

  public MixFoodSelectAllByFoodid() {
    connection = Connect.getInstance().getConnection();
  }

  @Override
  public List<Map<String, String>> execute(String mixid) {
    LinkedList<Map<String, String>> list = new LinkedList<>();
    try (CallableStatement proc =
        connection.prepareCall("{CALL public.MixFood_Select_All_By_FoodId(?)}")) {
      proc.setString(1, mixid);
      ResultSet rs = proc.executeQuery();
      while (rs.next()) {
        Map<String, String> row = new HashMap<>();
        row.put("FOODID", rs.getString(1));
        row.put("NAME", rs.getString(2));
        list.add(row);
      }
    } catch (SQLException e) {
    }
    return list;
  }

  @Override
  public List<Map<String, String>> execute(String mixid, Integer precision) {
    throw new UnsupportedOperationException("Not supported.");
  }
}
