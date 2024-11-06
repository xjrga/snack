package io.github.xjrga.snack.sql;

import io.github.xjrga.snack.database.Connect;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Shutdown {

  private final Connection connection;

  public Shutdown() {
    connection = Connect.getInstance().getConnection();
  }

  public void execute() {
    String sql = "SHUTDOWN COMPACT;";
    try (Statement stmt = connection.createStatement()) {
      stmt.executeUpdate(sql);
    } catch (SQLException e) {
    }
  }
}
