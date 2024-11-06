package io.github.xjrga.snack.sql;

import io.github.xjrga.snack.database.Connect;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MixExport {

  private final Connection connection;

  public MixExport() {
    connection = Connect.getInstance().getConnection();
  }

  public String execute(String mixid) {
    String out = null;
    try (CallableStatement proc = connection.prepareCall("{CALL public.Export_xml( ? )}")) {
      proc.setString(1, mixid);
      ResultSet rs = proc.executeQuery();
      while (rs.next()) {
        out = rs.getString(1);
      }
    } catch (SQLException e) {
    }
    return out;
  }
}
