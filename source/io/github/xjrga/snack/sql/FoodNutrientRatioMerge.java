package io.github.xjrga.snack.sql;

import io.github.xjrga.snack.database.Connect;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class FoodNutrientRatioMerge {

  private final Connection connection;

  public FoodNutrientRatioMerge() {
    connection = Connect.getInstance().getConnection();
  }

  public void execute(
      String mixid,
      String foodid1,
      String nutrientid1,
      String foodid2,
      String nutrientid2,
      Integer relationshipid,
      Double A,
      Double B) {
    try (CallableStatement proc =
        connection.prepareCall("{CALL public.FoodNutrientRatio_Merge( ?, ?, ?, ?, ?, ?, ?, ? )}")) {
      proc.setString(1, mixid);
      proc.setString(2, foodid1);
      proc.setString(3, nutrientid1);
      proc.setString(4, foodid2);
      proc.setString(5, nutrientid2);
      proc.setInt(6, relationshipid);
      proc.setDouble(7, A);
      proc.setDouble(8, B);
      proc.execute();
    } catch (SQLException e) {
    }
  }
}
