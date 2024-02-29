package io.github.xjrga.snack.sql;

import io.github.xjrga.snack.database.Connect;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class FoodFactMerge {
  private final Connection connection;

  public FoodFactMerge() {
    this.connection = Connect.getInstance().getConnection();
  }

  public void execute(String foodid, String nutrientid, Double q) {
    try (CallableStatement proc =
        connection.prepareCall("{CALL public.FoodFact_Merge( ?, ?, ? )}"); ) {
      proc.setString(1, foodid);
      proc.setString(2, nutrientid);
      proc.setDouble(3, q);
      proc.execute();
    } catch (SQLException ex) {
    }
  }
}
