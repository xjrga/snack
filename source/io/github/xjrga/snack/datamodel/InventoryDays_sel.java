package io.github.xjrga.snack.datamodel;

import io.github.xjrga.snack.database.Connect;
import io.github.xjrga.snack.dataobject.InventoryDays;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.apache.commons.dbutils.handlers.BeanListHandler;

public class InventoryDays_sel {
  private final Connection connection = Connect.getInstance().getConnection();

  public List<InventoryDays> apply() {
    List<InventoryDays> list = null;
    try {
      BeanListHandler<InventoryDays> beanListHandler = new BeanListHandler<>(InventoryDays.class);
      PreparedStatement proc = connection.prepareStatement("select * from MixInventoryDays");
      ResultSet rs = proc.executeQuery();
      list = beanListHandler.handle(rs);
    } catch (SQLException ex) {
      ex.printStackTrace();
    }
    return list;
  }
}
