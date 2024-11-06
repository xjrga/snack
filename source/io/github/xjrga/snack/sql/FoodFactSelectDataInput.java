package io.github.xjrga.snack.sql;

import io.github.xjrga.snack.database.Connect;
import io.github.xjrga.snack.dataobject.FoodFactSelectForDataInputDataObject;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class FoodFactSelectDataInput {

  private final Connection connection;

  public FoodFactSelectDataInput() {
    connection = Connect.getInstance().getConnection();
  }

  public List<FoodFactSelectForDataInputDataObject> execute(String foodid, Integer precision) {
    List<FoodFactSelectForDataInputDataObject> list = new LinkedList<>();
    try (CallableStatement proc =
        connection.prepareCall("{CALL public.FoodFact_Select_ForDataInput( ?, ? )}")) {
      proc.setString(1, foodid);
      proc.setInt(2, precision);
      ResultSet rs = proc.executeQuery();
      while (rs.next()) {
        FoodFactSelectForDataInputDataObject o = new FoodFactSelectForDataInputDataObject();
        o.setNutrientId(rs.getString(1));
        o.setCategory(rs.getString(2));
        o.setNutrient(rs.getString(3));
        o.setQ(rs.getDouble(4));
        list.add(o);
      }
    } catch (SQLException e) {
    }
    return list;
  }
}
