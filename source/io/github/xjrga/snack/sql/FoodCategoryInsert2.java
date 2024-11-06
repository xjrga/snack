package io.github.xjrga.snack.sql;

import io.github.xjrga.snack.database.Connect;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class FoodCategoryInsert2 {

  private final Connection connection;

  public FoodCategoryInsert2() {
    connection = Connect.getInstance().getConnection();
  }

  public void execute(String name) {
    try (CallableStatement proc =
        connection.prepareCall("{CALL public.FoodCategory_Insert_2( ? )}")) {
      proc.setString(1, name);
      proc.execute();
    } catch (SQLException e) {
    }
  }
}
