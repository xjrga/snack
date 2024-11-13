package io.github.xjrga.snack.datamodel;

import io.github.xjrga.snack.database.Connect;
import io.github.xjrga.snack.dataobject.MixDataObject;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class InventoryDays_ins {
  private final Connection connection = Connect.getInstance().getConnection();

  public void apply(MixDataObject mix, Double days) {
    try (CallableStatement proc = connection.prepareCall("{call MixInventory_merge(?,?)}")) {
      proc.setString(1, mix.getMixId());
      proc.setDouble(2, days);
      proc.execute();
    } catch (SQLException ex) {
      ex.printStackTrace();
    }
  }
}
