package io.github.xjrga.snack.sql;

import io.github.xjrga.snack.database.Connect;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class NutrientUpdate {

  private final Connection connection;

  public NutrientUpdate() {
    connection = Connect.getInstance().getConnection();
  }

  public void execute(String NutrientId, Integer Visible) {
    try (CallableStatement proc = connection.prepareCall("{CALL public.Nutrient_Update( ?, ? )}")) {
      proc.setString(1, NutrientId);
      proc.setInt(2, Visible);
      proc.execute();
    } catch (SQLException e) {
    }
  }
}
