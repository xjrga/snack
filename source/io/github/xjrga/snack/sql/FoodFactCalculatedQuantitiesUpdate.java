package io.github.xjrga.snack.sql;

import io.github.xjrga.snack.database.Connect;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class FoodFactCalculatedQuantitiesUpdate {
  private final Connection connection;

  public FoodFactCalculatedQuantitiesUpdate() {
    this.connection = Connect.getInstance().getConnection();
  }

  public void execute(String foodid) {
    try (CallableStatement proc =
        connection.prepareCall("{CALL public.foodfact_calculated_quantities_update( ? )}"); ) {
      proc.setString(1, foodid);
      proc.execute();
    } catch (SQLException ex) {
    }
  }
}
