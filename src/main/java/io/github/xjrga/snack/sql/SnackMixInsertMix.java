package io.github.xjrga.snack.sql;

import io.github.xjrga.snack.database.Connect;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class SnackMixInsertMix {

  private final Connection connection;

  public SnackMixInsertMix() {
    connection = Connect.getInstance().getConnection();
  }

  public boolean execute(String mixid, String name, String nutrientid, String model) {
    boolean flag = false;
    try (CallableStatement proc =
        connection.prepareCall("{CALL public.snack_mix_insertmix( ?, ?, ?, ?)}")) {
      proc.setString(1, mixid);
      proc.setString(2, name);
      proc.setString(3, nutrientid);
      proc.setString(4, model);
      proc.execute();
      flag = true;
    } catch (SQLException e) {
    }
    return flag;
  }
}
