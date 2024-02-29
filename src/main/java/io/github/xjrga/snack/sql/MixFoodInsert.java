package io.github.xjrga.snack.sql;

import io.github.xjrga.snack.database.Connect;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class MixFoodInsert {

  private final Connection connection;

  public MixFoodInsert() {
    connection = Connect.getInstance().getConnection();
  }

  public void execute(String mixid, String foodid) {
    try (CallableStatement proc = connection.prepareCall("{CALL public.MixFood_Insert( ?, ? )}")) {
      proc.setString(1, mixid);
      proc.setString(2, foodid);
      proc.execute();
    } catch (SQLException e) {
    }
  }
}
