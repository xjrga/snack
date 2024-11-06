package io.github.xjrga.snack.sql;

import io.github.xjrga.snack.database.Connect;
import io.github.xjrga.snack.dataobject.CoefficientMod;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.apache.commons.dbutils.handlers.BeanListHandler;

public class FoodFactCoefficientData implements SqlCallMixid<CoefficientMod> {

  private final Connection connection;

  public FoodFactCoefficientData() {
    this.connection = Connect.getInstance().getConnection();
  }

  @Override
  public List<CoefficientMod> execute(String mixid) {
    List<CoefficientMod> list = null;
    BeanListHandler<CoefficientMod> beanListHandler = new BeanListHandler<>(CoefficientMod.class);
    try (CallableStatement proc = connection.prepareCall("{CALL public.get_zff(?)}"); ) {
      proc.setString(1, mixid);
      ResultSet rs = proc.executeQuery();
      list = beanListHandler.handle(rs);
    } catch (SQLException ex) {
    }
    return list;
  }

  @Override
  public List<CoefficientMod> execute(String mixid, Integer precision) {
    throw new UnsupportedOperationException("Not supported.");
  }
}
