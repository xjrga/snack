package io.github.xjrga.snack.database.callable.select;

import io.github.xjrga.snack.database.Connect;
import io.github.xjrga.snack.logger.LoggerImpl;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.concurrent.Callable;

public class ObjectiveLhsTask implements Callable<double[]> {
  private final String mixid;
  private final Connection connection;

  public ObjectiveLhsTask(String mixid) {
    this.mixid = mixid;
    connection = Connect.getInstance().getConnection();
  }

  @Override
  public double[] call() {
    double[] coefficients = null;
    try (CallableStatement proc = connection.prepareCall("{CALL public.objective_lhs( ? )}")) {
      proc.setString(1, mixid);
      ResultSet rs = proc.executeQuery();
      LinkedList<Double> lst = new LinkedList<>();
      while (rs.next()) {
        double c = rs.getDouble(2);
        lst.add(c);
      }
      proc.close();
      int size = lst.size();
      coefficients = new double[size];
      for (int i = 0; i < size; i++) {
        coefficients[i] = lst.get(i);
      }
    } catch (SQLException e) {
      LoggerImpl.INSTANCE.logProblem(e);
    }
    return coefficients;
  }
}