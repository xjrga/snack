package io.github.xjrga.snack.sql;

import io.github.xjrga.snack.database.Connect;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FoodExport {

  private final Connection connection;

  public FoodExport() {
    connection = Connect.getInstance().getConnection();
  }

  public String execute(String foodid) {
    String out = null;
    try (CallableStatement proc = connection.prepareCall("{CALL public.Select_food_as_xml( ? )}")) {
      proc.setString(1, foodid);
      ResultSet rs = proc.executeQuery();
      while (rs.next()) {
        out = rs.getString(1);
      }
    } catch (SQLException e) {
    }
    return out;
  }
}
