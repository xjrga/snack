package io.github.xjrga.snack.sql;

import io.github.xjrga.snack.database.Connect;
import io.github.xjrga.snack.dataobject.FoodDataObject;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class FoodUpdate {

  private final Connection connection;

  public FoodUpdate() {
    connection = Connect.getInstance().getConnection();
  }

  public void execute(FoodDataObject foodDataObject) {
    try (CallableStatement proc = connection.prepareCall("{CALL public.Food_Update( ?, ? )}")) {
      proc.setString(1, foodDataObject.getFoodId());
      proc.setString(2, foodDataObject.getFoodName());
      proc.execute();
    } catch (SQLException e) {
    }
  }
}
