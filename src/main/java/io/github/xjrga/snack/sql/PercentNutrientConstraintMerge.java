package io.github.xjrga.snack.sql;

import io.github.xjrga.snack.database.Connect;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class PercentNutrientConstraintMerge {

  private final Connection connection;

  public PercentNutrientConstraintMerge() {
    connection = Connect.getInstance().getConnection();
  }

  public void execute(
      String mixId, String foodid, String nutrno, Integer relationshipId, Double b) {
    try (CallableStatement proc =
        connection.prepareCall("{CALL public.PercentNutrientConstraint_Merge( ?, ?, ?, ?, ? )}")) {
      proc.setString(1, mixId);
      proc.setString(2, foodid);
      proc.setString(3, nutrno);
      proc.setInt(4, relationshipId);
      proc.setDouble(5, b);
      proc.execute();
    } catch (SQLException e) {
    }
  }
}
