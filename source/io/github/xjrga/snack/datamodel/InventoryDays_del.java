package io.github.xjrga.snack.datamodel;

import io.github.xjrga.snack.database.Connect;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class InventoryDays_del {
  private final Connection connection = Connect.getInstance().getConnection();

  public void apply(String mixid) {
    try (CallableStatement proc = connection.prepareCall("{CALL MixInventory_delete(?)}")) {
      proc.setString(1, mixid);
      proc.execute();
    } catch (SQLException ex) {
      ex.printStackTrace();
    }
  }
}
