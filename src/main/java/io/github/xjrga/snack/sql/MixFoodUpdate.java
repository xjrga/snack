package io.github.xjrga.snack.sql;

import io.github.xjrga.snack.database.Connect;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class MixFoodUpdate {

  private final Connection connection;

  public MixFoodUpdate() {
    connection = Connect.getInstance().getConnection();
  }

  public void execute(String mixid, String foodid, Double x) {
    try (CallableStatement proc =
        connection.prepareCall("{CALL public.MixFood_Update( ?, ?, ? )}")) {
      proc.setString(1, mixid);
      proc.setString(2, foodid);
      proc.setDouble(3, x);
      proc.execute();
    } catch (SQLException e) {
    }
  }
}
