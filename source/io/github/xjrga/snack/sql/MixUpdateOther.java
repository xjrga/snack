package io.github.xjrga.snack.sql;

import io.github.xjrga.snack.database.Connect;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class MixUpdateOther {

  private final Connection connection;

  public MixUpdateOther() {
    connection = Connect.getInstance().getConnection();
  }

  public void execute(String mixid, String model) {
    try (CallableStatement proc =
        connection.prepareCall("{CALL public.Mix_Update_Other( ?, ? )}")) {
      proc.setString(1, mixid);
      proc.setString(2, model);
      proc.execute();
    } catch (SQLException e) {
    }
  }
}
