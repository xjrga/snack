package io.github.xjrga.snack.data;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class ZffSave {
  private final Connection connection = Connect.getInstance().getConnection();

  public void apply(String mixid) {

    try (CallableStatement proc = connection.prepareCall("{CALL public.save_zff(?)}");) {
      proc.setString(1, mixid);
      proc.execute();
    } catch (SQLException ex) {
    }
  }
}
