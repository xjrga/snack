package io.github.xjrga.snack.sql;

import io.github.xjrga.snack.database.Connect;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class NutrientConstraintMerge {

  private final Connection connection;

  public NutrientConstraintMerge() {
    connection = Connect.getInstance().getConnection();
  }

  public void execute(String mixid, String nutrientid, Integer relationshipid, Double b) {
    try (CallableStatement proc =
        connection.prepareCall("{CALL public.NutrientConstraint_Merge( ?, ?, ?, ? )}")) {
      proc.setString(1, mixid);
      proc.setString(2, nutrientid);
      proc.setInt(3, relationshipid);
      proc.setDouble(4, b);
      proc.execute();
    } catch (SQLException e) {
    }
  }
}
