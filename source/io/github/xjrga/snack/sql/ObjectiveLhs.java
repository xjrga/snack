package io.github.xjrga.snack.sql;

import io.github.xjrga.snack.database.Connect;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class ObjectiveLhs {

  private final Connection connection;

  public ObjectiveLhs() {
    connection = Connect.getInstance().getConnection();
  }

  public double[] execute(String MixId) {
    double[] coefficients = null;
    try (CallableStatement proc = connection.prepareCall("{CALL public.objective_lhs( ? )}")) {
      proc.setString(1, MixId);
      ResultSet rs = proc.executeQuery();
      LinkedList<Double> list = new LinkedList<>();
      while (rs.next()) {
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
