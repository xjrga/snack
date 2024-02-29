package io.github.xjrga.snack.sql;

import io.github.xjrga.snack.database.Connect;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class NutrientRatioMerge {

  private final Connection connection;

  public NutrientRatioMerge() {
    connection = Connect.getInstance().getConnection();
  }

  public void execute(
      String MixId,
      String Nutrient_Id_1,
      String Nutrient_Id_2,
      Integer RelationshipId,
      Double A,
      Double B) {
    try (CallableStatement proc =
        connection.prepareCall("{CALL public.NutrientRatio_Merge( ?, ?, ?, ?, ?, ? )}")) {
      proc.setString(1, MixId);
      proc.setString(2, Nutrient_Id_1);
      proc.setString(3, Nutrient_Id_2);
      proc.setInt(4, RelationshipId);
      proc.setDouble(5, A);
      proc.setDouble(6, B);
      proc.execute();
    } catch (SQLException e) {
    }
  }
}
