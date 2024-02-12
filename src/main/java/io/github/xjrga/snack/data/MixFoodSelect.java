package io.github.xjrga.snack.data;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MixFoodSelect {
  private final Connection connection = Connect.getInstance().getConnection();

  public List<String> apply(String mixid) {
    List<String> list = new ArrayList<>();
    try (CallableStatement proc = connection.prepareCall("{CALL public.getMixFoods( ? )}");) {
      proc.setString(1, mixid);
      ResultSet rs = proc.executeQuery();
      while (rs.next()) {
        list.add(rs.getString(1));
      }
    } catch (SQLException ex) {
    }
    return list;
  }
}
