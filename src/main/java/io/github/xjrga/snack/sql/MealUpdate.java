package io.github.xjrga.snack.sql;

import io.github.xjrga.snack.database.Connect;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class MealUpdate {

  private final Connection connection;

  public MealUpdate() {
    connection = Connect.getInstance().getConnection();
  }

  public void execute(String mixid, Integer mealid, String name, Integer order) {
    try (CallableStatement proc =
        connection.prepareCall("{CALL public.Meal_update( ?, ?, ?, ? )}")) {
      proc.setString(1, mixid);
      proc.setInt(2, mealid);
      proc.setString(3, name);
      proc.setInt(4, order);
      proc.execute();
    } catch (SQLException e) {
    }
  }
}
