package io.github.xjrga.snack.sql;

import io.github.xjrga.snack.database.Connect;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class FoodCategoryUpdate {

  private final Connection connection;

  public FoodCategoryUpdate() {
    connection = Connect.getInstance().getConnection();
  }

  public void execute(String categoryid, String categoryname) {
    try (CallableStatement proc =
        connection.prepareCall("{CALL public.FoodCategory_Update( ?, ? )}")) {
      proc.setString(1, categoryid);
      proc.setString(2, categoryname);
      proc.execute();
    } catch (SQLException e) {
    }
  }
}
