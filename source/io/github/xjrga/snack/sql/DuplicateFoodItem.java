package io.github.xjrga.snack.sql;

import io.github.xjrga.snack.database.Connect;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class DuplicateFoodItem {
  private final Connection connection;

  public DuplicateFoodItem() {
    this.connection = Connect.getInstance().getConnection();
  }

  public void execute(String foodId) {
    try (CallableStatement proc =
        connection.prepareCall("{CALL public.DuplicateFoodItem( ? )}"); ) {
      proc.setString(1, foodId);
      proc.execute();
    } catch (SQLException ex) {
    }
  }
}
