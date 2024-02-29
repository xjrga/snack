package io.github.xjrga.snack.sql;

import io.github.xjrga.snack.database.Connect;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MixFoodsSelect implements SqlCallMixid<String> {
  private final Connection connection = Connect.getInstance().getConnection();

  @Override
  public List<String> execute(String mixid) {
    List<String> list = new ArrayList<>();
    try (CallableStatement proc = connection.prepareCall("{CALL public.getMixFoods( ? )}"); ) {
      proc.setString(1, mixid);
      ResultSet rs = proc.executeQuery();
      while (rs.next()) {
        list.add(rs.getString(1));
      }
    } catch (SQLException ex) {
    }
    return list;
  }

  @Override
  public List<String> execute(String mixid, Integer precision) {
    throw new UnsupportedOperationException("Not supported.");
  }
}
