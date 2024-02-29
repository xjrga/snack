package io.github.xjrga.snack.sql;

import io.github.xjrga.snack.database.Connect;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class FoodNutrientRatioLhs {

  private final Connection connection;

  public FoodNutrientRatioLhs() {
    connection = Connect.getInstance().getConnection();
  }

  public double[] execute(
      String mixid,
      String foodid1,
      String nutrientid1,
      String foodid2,
      String nutrientid2,
      Integer relationshipid) {
    double[] coefficients = null;
    try (CallableStatement proc =
        connection.prepareCall("{CALL public.foodnutrientratio_lhs( ?, ?, ?, ?, ?, ? )}")) {
      proc.setString(1, mixid);
      proc.setString(2, foodid1);
      proc.setString(3, nutrientid1);
      proc.setString(4, foodid2);
      proc.setString(5, nutrientid2);
      proc.setInt(6, relationshipid);
      ResultSet rs = proc.executeQuery();
      LinkedList<Double> list = new LinkedList<>();
      while (rs.next()) {
        // String foodid = rs.getString(1);
        double c = rs.getDouble(2);
        list.add(c);
      }
      proc.close();
      int size = list.size();
      coefficients = new double[size];
      for (int i = 0; i < size; i++) {
        coefficients[i] = list.get(i);
      }
    } catch (SQLException e) {
    }
    return coefficients;
  }
}
