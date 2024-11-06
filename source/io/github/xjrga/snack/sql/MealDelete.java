package io.github.xjrga.snack.sql;

import io.github.xjrga.snack.database.Connect;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class MealDelete {

  private final Connection connection;

  public MealDelete() {
    connection = Connect.getInstance().getConnection();
  }

  public void execute(String MixId, Integer MealId) {
    try (CallableStatement proc = connection.prepareCall("{CALL public.Meal_Delete( ?, ? )}")) {
      proc.setString(1, MixId);
      proc.setInt(2, MealId);
      proc.execute();
    } catch (SQLException e) {
    }
  }
}
