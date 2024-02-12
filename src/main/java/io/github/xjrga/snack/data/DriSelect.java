package io.github.xjrga.snack.data;

import io.github.xjrga.snack.dataobject.CoefficientMod;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.apache.commons.dbutils.handlers.BeanListHandler;

public class DriSelect {
  private final Connection connection = Connect.getInstance().getConnection();

  public List<CoefficientMod> apply() {
    List<CoefficientMod> list = null;
    BeanListHandler<CoefficientMod> beanListHandler = new BeanListHandler<>(CoefficientMod.class);
    try (CallableStatement proc = connection.prepareCall("{CALL public.getDri()}");) {
      ResultSet rs = proc.executeQuery();
      list = beanListHandler.handle(rs);
    } catch (SQLException ex) {
    }
    return list;
  }
}