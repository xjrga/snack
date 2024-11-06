package io.github.xjrga.snack.sql;

import io.github.xjrga.snack.database.Connect;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class FoodNutrientLhs {

  private final Connection connection;

  public FoodNutrientLhs() {
    connection = Connect.getInstance().getConnection();
  }

  public double[] execute(String mixid, String foodid, String nutrientid, Integer relationshipid) {
    double[] coefficients = null;
    try (CallableStatement proc =
        connection.prepareCall("{CALL public.foodnutrient_lhs( ?, ?, ?, ? )}")) {
      proc.setString(1, mixid);
      proc.setString(2, foodid);
      proc.setString(3, nutrientid);
      proc.setInt(4, relationshipid);
      ResultSet rs = proc.executeQuery();
      LinkedList<Double> list = new LinkedList<>();
      while (rs.next()) {
        // String foodid = rs.getString(1);
        double c = rs.getDouble(3);
        list.add(c);
      }
      proc.close();
      int size = list.size();
      coefficients = new double[size];
      for (int i = 0; i < size; i++) {
        coefficients[i] = list.get(i).doubleValue();
      }
    } catch (SQLException e) {
    }
    return coefficients;
  }
}
