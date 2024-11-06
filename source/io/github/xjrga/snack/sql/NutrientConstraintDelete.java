package io.github.xjrga.snack.sql;

import io.github.xjrga.snack.database.Connect;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class NutrientConstraintDelete {

  private final Connection connection;

  public NutrientConstraintDelete() {
    connection = Connect.getInstance().getConnection();
  }

  public void execute(String mixid, String nutrientid, Integer relationshipid) {
    try (CallableStatement proc =
        connection.prepareCall("{CALL public.NutrientConstraint_Delete( ?, ?, ? )}")) {
      proc.setString(1, mixid);
      proc.setString(2, nutrientid);
      proc.setInt(3, relationshipid);
      proc.execute();
    } catch (SQLException e) {
    }
  }
}
