package io.github.xjrga.snack.sql;

import io.github.xjrga.snack.database.Connect;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class MealInsert02 {

  private final Connection connection;

  public MealInsert02() {
    connection = Connect.getInstance().getConnection();
  }

  public void execute(String mixid, Integer mealid, String name, Integer order) {
    try (CallableStatement proc =
        connection.prepareCall("{CALL public.Meal_insert_02( ?, ?, ?, ? )}")) {
      proc.setString(1, mixid);
      proc.setInt(2, mealid);
      proc.setString(3, name);
      proc.setInt(4, order);
      proc.execute();
    } catch (SQLException e) {
    }
  }
}
