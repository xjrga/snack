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

public class FoodSelectAllLike {

  private final Connection connection;

  public FoodSelectAllLike() {
    connection = Connect.getInstance().getConnection();
  }

  public List<Map<String, Object>> execute(String txt) {
    LinkedList<Map<String, Object>> list = new LinkedList<>();
    try (CallableStatement proc =
        connection.prepareCall("{CALL public.Food_Select_All_Like( ? )}")) {
      proc.setString(1, txt);
      ResultSet rs = proc.executeQuery();
      while (rs.next()) {
        Map<String, Object> row = new HashMap<>();
        row.put("FOODID", rs.getObject(1));
        row.put("NAME", rs.getObject(2));
        list.add(row);
      }
    } catch (SQLException e) {
    }
    return list;
  }
}
