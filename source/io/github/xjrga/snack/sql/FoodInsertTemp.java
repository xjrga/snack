package io.github.xjrga.snack.sql;

import io.github.xjrga.snack.database.Connect;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

public class FoodInsertTemp {

  private final Connection connection;

  public FoodInsertTemp() {
    connection = Connect.getInstance().getConnection();
  }

  public String execute(String foodName) {
    String out = null;
    try (CallableStatement proc =
        connection.prepareCall("{CALL public.Food_Insert_Temp ( ?, ? )}")) {
      proc.registerOutParameter(1, Types.LONGVARCHAR);
      proc.setString(2, foodName);
      proc.execute();
      out = proc.getString(1);
    } catch (SQLException e) {
    }
    return out;
  }
}
