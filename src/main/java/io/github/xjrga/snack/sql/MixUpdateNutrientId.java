package io.github.xjrga.snack.sql;

import io.github.xjrga.snack.database.Connect;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class MixUpdateNutrientId {

  private final Connection connection;

  public MixUpdateNutrientId() {
    connection = Connect.getInstance().getConnection();
  }

  public void execute(String mixid, String nutrientid) {
    try (CallableStatement proc =
        connection.prepareCall("{CALL public.Mix_Update_NutrientId( ?, ? )}")) {
      proc.setString(1, mixid);
      proc.setString(2, nutrientid);
      proc.execute();
    } catch (SQLException e) {
    }
  }
}
