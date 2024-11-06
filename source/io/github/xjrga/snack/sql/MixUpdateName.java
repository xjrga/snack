package io.github.xjrga.snack.sql;

import io.github.xjrga.snack.database.Connect;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class MixUpdateName {

  private final Connection connection;

  public MixUpdateName() {
    connection = Connect.getInstance().getConnection();
  }

  public void execute(String mixid, String name) {
    try (CallableStatement proc = connection.prepareCall("{CALL public.Mix_Update_Name( ?, ? )}")) {
      proc.setString(1, mixid);
      proc.setString(2, name);
      proc.execute();
    } catch (SQLException e) {
    }
  }
}
