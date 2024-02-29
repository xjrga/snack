package io.github.xjrga.snack.sql;

import io.github.xjrga.snack.database.Connect;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

public class MixInsert {

  private final Connection connection;

  public MixInsert() {
    connection = Connect.getInstance().getConnection();
  }

  public String execute(String Name) {
    String out = null;
    try (CallableStatement proc = connection.prepareCall("{CALL public.Mix_Insert( ?, ?)}")) {
      proc.registerOutParameter(1, Types.INTEGER);
      proc.setString(2, Name);
      proc.execute();
      out = proc.getString(1);
    } catch (SQLException e) {
    }
    return out;
  }
}
