package io.github.xjrga.snack.sql;

import io.github.xjrga.snack.database.Connect;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class MealFoodPortionDelete {

  private final Connection connection;

  public MealFoodPortionDelete() {
    connection = Connect.getInstance().getConnection();
  }

  public void execute(String mixid, Integer mealid, String foodid) {
    try (CallableStatement proc =
        connection.prepareCall("{CALL public.MealFoodPortion_delete( ?, ?, ? )}")) {
      proc.setString(1, mixid);
      proc.setInt(2, mealid);
      proc.setString(3, foodid);
      proc.execute();
    } catch (SQLException e) {
    }
  }
}
