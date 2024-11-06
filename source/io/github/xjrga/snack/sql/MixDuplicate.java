package io.github.xjrga.snack.sql;

import io.github.xjrga.snack.database.Connect;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class MixDuplicate {

  private final Connection connection;

  public MixDuplicate() {
    connection = Connect.getInstance().getConnection();
  }

  public void execute(String mixid) {
    try (CallableStatement proc = connection.prepareCall("{CALL public.Mix_Duplicate( ? )}")) {
      proc.setString(1, mixid);
      proc.execute();
    } catch (SQLException e) {
    }
  }
}
