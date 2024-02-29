package io.github.xjrga.snack.sql;

import io.github.xjrga.snack.database.Connect;
import io.github.xjrga.snack.dataobject.FoodFactSelectForCheckCoefficientsDataObject;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class FoodFactSelectCheckCoefficients {

  private final Connection connection;

  public FoodFactSelectCheckCoefficients() {
    connection = Connect.getInstance().getConnection();
  }

  public List<FoodFactSelectForCheckCoefficientsDataObject> execute(
      String foodid, Integer precision) {
    List<FoodFactSelectForCheckCoefficientsDataObject> list = new LinkedList<>();
    try (CallableStatement proc =
        connection.prepareCall("{CALL public.FoodFact_Select_ForCheckCoefficient( ?, ? )}")) {
      proc.setString(1, foodid);
      proc.setInt(2, precision);
      ResultSet rs = proc.executeQuery();
      while (rs.next()) {
        FoodFactSelectForCheckCoefficientsDataObject o =
            new FoodFactSelectForCheckCoefficientsDataObject();
        o.setNutrientId(rs.getString(1));
        o.setCategory(rs.getString(2));
        o.setNutrient(rs.getString(3));
        o.setQ(rs.getDouble(4));
        o.setC(rs.getDouble(5));
        list.add(o);
      }
    } catch (SQLException e) {
    }
    return list;
  }
}
