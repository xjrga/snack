package io.github.xjrga.snack.sql;

import io.github.xjrga.snack.database.Connect;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class MealFoodPortionUpdatePct {

  private final Connection connection;

  public MealFoodPortionUpdatePct() {
    connection = Connect.getInstance().getConnection();
  }

  public void execute(String mixid, Integer mealid, String foodid, Double pct) {
    try (CallableStatement proc =
        connection.prepareCall(
            "{CALL public.MealFoodPortion_insert_and_calculate( ?, ?, ?, ? )}")) {
      proc.setString(1, mixid);
      proc.setInt(2, mealid);
      proc.setString(3, foodid);
      proc.setDouble(4, pct);
      proc.execute();
    } catch (SQLException e) {
    }
  }
}
