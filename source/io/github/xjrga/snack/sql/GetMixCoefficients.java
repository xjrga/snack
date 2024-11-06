package io.github.xjrga.snack.sql;

import io.github.xjrga.snack.database.Connect;
import io.github.xjrga.snack.dataobject.MixFoodFactCoefficient;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class GetMixCoefficients implements SqlCallMixid<MixFoodFactCoefficient> {

  private final Connection connection;

  public GetMixCoefficients() {
    connection = Connect.getInstance().getConnection();
  }

  @Override
  public List<MixFoodFactCoefficient> execute(String mixid) {
    LinkedList<MixFoodFactCoefficient> list = new LinkedList<>();
    try (CallableStatement proc = connection.prepareCall("{CALL public.getMixCoefficients( ? )}")) {
      proc.setString(1, mixid);
      ResultSet rs = proc.executeQuery();
      while (rs.next()) {
        MixFoodFactCoefficient o = new MixFoodFactCoefficient();
        o.setFoodid(rs.getString(1));
        o.setNutrientid(rs.getString(2));
        o.setCoefficient(rs.getInt(3));
        list.add(o);
      }
    } catch (SQLException e) {
    }
    return list;
  }

  @Override
  public List<MixFoodFactCoefficient> execute(String mixid, Integer precision) {
    throw new UnsupportedOperationException("Not supported.");
  }
}
