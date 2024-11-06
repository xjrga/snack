package io.github.xjrga.snack.sql;

import io.github.xjrga.snack.database.Connect;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class SnackFoodInsert {

  private final Connection connection;

  public SnackFoodInsert() {
    connection = Connect.getInstance().getConnection();
  }

  public boolean execute(String foodid, String foodName) {
    boolean flag = false;
    try (CallableStatement proc =
        connection.prepareCall("{CALL public.snack_food_insertfood( ?, ? )}")) {
      proc.setString(1, foodid);
      proc.setString(2, foodName);
      proc.execute();
      flag = true;
    } catch (SQLException ex) {
    }
    return flag;
  }
}
