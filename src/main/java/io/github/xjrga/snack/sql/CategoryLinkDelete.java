package io.github.xjrga.snack.sql;

import io.github.xjrga.snack.database.Connect;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class CategoryLinkDelete {

  private final Connection connection;

  public CategoryLinkDelete() {
    connection = Connect.getInstance().getConnection();
  }

  public void execute(String categoryid, String foodid) {
    try (CallableStatement proc =
        connection.prepareCall("{CALL public.CategoryLink_Delete( ?, ? )}")) {
      proc.setString(1, categoryid);
      proc.setString(2, foodid);
      proc.execute();
    } catch (SQLException e) {
    }
  }
}
