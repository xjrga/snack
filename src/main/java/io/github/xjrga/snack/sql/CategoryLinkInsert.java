package io.github.xjrga.snack.sql;

import io.github.xjrga.snack.database.Connect;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class CategoryLinkInsert {

  private final Connection connection;

  public CategoryLinkInsert() {
    connection = Connect.getInstance().getConnection();
  }

  public void execute(String categoryid, String foodid) {
    try (CallableStatement proc =
        connection.prepareCall("{CALL public.CategoryLink_Insert( ?, ? )}")) {
      // Different order in procedure
      proc.setString(1, foodid);
      proc.setString(2, categoryid);
      proc.execute();
    } catch (SQLException e) {
    }
  }
}
