package io.github.xjrga.snack.data;

import io.github.xjrga.snack.dataobject.MixFoodFactCoefficient;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.apache.commons.dbutils.handlers.BeanListHandler;

public class MixFoodFactCoefficientsSelectAll {
  private final Connection connection = Connect.getInstance().getConnection();

  public List<MixFoodFactCoefficient> apply(String mixid) {
    List<MixFoodFactCoefficient> list = null;
    BeanListHandler<MixFoodFactCoefficient> beanListHandler =
        new BeanListHandler<>(MixFoodFactCoefficient.class);
    try (CallableStatement proc =
        connection.prepareCall("{CALL public.getMixCoefficientsAll( ? )}"); ) {
      proc.setString(1, mixid);
      ResultSet rs = proc.executeQuery();
      list = beanListHandler.handle(rs);
    } catch (SQLException ex) {
    }
    return list;
  }
}
