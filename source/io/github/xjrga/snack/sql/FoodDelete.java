package io.github.xjrga.snack.sql;

import io.github.xjrga.snack.database.Connect;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class FoodDelete {

  private final Connection connection;

  public FoodDelete() {
    connection = Connect.getInstance().getConnection();
  }

  public void execute(String foodid) {
    try (CallableStatement proc = connection.prepareCall("{CALL public.Food_Delete( ? )}")) {
      proc.setString(1, foodid);
      proc.execute();
    } catch (SQLException e) {
    }
  }
}
