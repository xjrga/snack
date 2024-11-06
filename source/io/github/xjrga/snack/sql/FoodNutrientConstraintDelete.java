package io.github.xjrga.snack.sql;

import io.github.xjrga.snack.database.Connect;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class FoodNutrientConstraintDelete {

  private final Connection connection;

  public FoodNutrientConstraintDelete() {
    connection = Connect.getInstance().getConnection();
  }

  public void execute(String mixid, String foodid, String nutrientid, Integer relationshipid) {
    try (CallableStatement proc =
        connection.prepareCall("{CALL public.FoodNutrientConstraint_Delete( ?, ?, ?, ? )}")) {
      proc.setString(1, mixid);
      proc.setString(2, foodid);
      proc.setString(3, nutrientid);
      proc.setInt(4, relationshipid);
      proc.execute();
    } catch (SQLException e) {
    }
  }
}
