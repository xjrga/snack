package io.github.xjrga.snack.sql;

import io.github.xjrga.snack.database.Connect;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class MealInsert {

  private final Connection connection;

  public MealInsert() {
    connection = Connect.getInstance().getConnection();
  }

  public void execute(String mixid, String name, Integer order) {
    try (CallableStatement proc = connection.prepareCall("{CALL public.Meal_insert( ?, ?, ? )}")) {
      proc.setString(1, mixid);
      proc.setString(2, name);
      proc.setInt(3, order);
      proc.execute();
    } catch (SQLException e) {
    }
  }
}
