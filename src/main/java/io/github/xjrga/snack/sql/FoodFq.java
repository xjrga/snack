package io.github.xjrga.snack.sql;

import io.github.xjrga.snack.database.Connect;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FoodFq {

  private final Connection connection;

  public FoodFq() {
    connection = Connect.getInstance().getConnection();
  }

  public Double execute(String foodid) {
    Double out = null;
    try (CallableStatement proc = connection.prepareCall("{CALL public.get_food_fq( ? )}")) {
      proc.setString(1, foodid);
      proc.execute();
      ResultSet resultSet = proc.getResultSet();
      resultSet.next();
      out = resultSet.getDouble(1);
    } catch (SQLException e) {
    }
    return out;
  }
}
