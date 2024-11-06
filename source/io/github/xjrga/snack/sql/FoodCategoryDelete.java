package io.github.xjrga.snack.sql;

import io.github.xjrga.snack.database.Connect;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class FoodCategoryDelete {

  private final Connection connection;

  public FoodCategoryDelete() {
    connection = Connect.getInstance().getConnection();
  }

  public void execute(String categoryid) {
    try (CallableStatement proc =
        connection.prepareCall("{CALL public.FoodCategory_Delete( ? )}")) {
      proc.setString(1, categoryid);
      proc.execute();
    } catch (SQLException e) {
    }
  }
}
