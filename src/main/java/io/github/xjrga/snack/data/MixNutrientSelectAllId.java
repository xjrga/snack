package io.github.xjrga.snack.data;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MixNutrientSelectAllId {
  private final Connection connection = Connect.getInstance().getConnection();

  public List<String> apply(String mixid) {
    ArrayList<String> list = new ArrayList<>();
    try (CallableStatement proc =
        connection.prepareCall("{CALL public.getMixNutrientsAll( ? )}"); ) {
      proc.setString(1, mixid);
      ResultSet rs = proc.executeQuery();
      while (rs.next()) {
        String string = rs.getString(1);
        list.add(string);
      }
    } catch (SQLException ex) {
      ex.printStackTrace();
    }
    return list;
  }
}
