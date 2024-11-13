package io.github.xjrga.snack.datamodel;

import io.github.xjrga.snack.database.Connect;
import io.github.xjrga.snack.dataobject.InventorySum;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.apache.commons.dbutils.handlers.BeanListHandler;

public class InventorySum_sel {
  private final Connection connection = Connect.getInstance().getConnection();

  public List<InventorySum> apply() {
    List<InventorySum> list = null;
    try (CallableStatement proc = connection.prepareCall("{CALL MixInventorySum_select()}"); ) {
      BeanListHandler<InventorySum> beanListHandler = new BeanListHandler<>(InventorySum.class);
      ResultSet rs = proc.executeQuery();
      list = beanListHandler.handle(rs);
    } catch (SQLException ex) {
      ex.printStackTrace();
    }
    return list;
  }
}
