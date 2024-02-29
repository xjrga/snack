package io.github.xjrga.snack.sql;

import io.github.xjrga.snack.database.Connect;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class FoodNutrientRatioDelete {

  private final Connection connection;

  public FoodNutrientRatioDelete() {
    connection = Connect.getInstance().getConnection();
  }

  public void execute(
      String MixId,
      String Food_Id_1,
      String Nutrient_Id_1,
      String Food_Id_2,
      String Nutrient_Id_2,
      Integer RelationshipId) {
    try (CallableStatement proc =
        connection.prepareCall("{CALL public.FoodNutrientRatio_Delete( ?, ?, ?, ?, ?, ? )}")) {
      proc.setString(1, MixId);
      proc.setString(2, Food_Id_1);
      proc.setString(3, Nutrient_Id_1);
      proc.setString(4, Food_Id_2);
      proc.setString(5, Nutrient_Id_2);
      proc.setInt(6, RelationshipId);
      proc.execute();
    } catch (SQLException e) {
    }
  }
}
