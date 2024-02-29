package io.github.xjrga.snack.sql;

import io.github.xjrga.snack.database.Connect;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CalculateRemainingPercentage {

  private final Connection connection;

  public CalculateRemainingPercentage() {
    connection = Connect.getInstance().getConnection();
  }

  public Double execute(String mixid, String foodid, Integer precision) {
    Double out = null;
    try (CallableStatement proc =
        connection.prepareCall("{CALL public.calculate_remaining_percentage( ?, ?, ? )}")) {
      proc.setString(1, mixid);
      proc.setString(2, foodid);
      proc.setInt(3, precision);
      proc.execute();
      ResultSet resultSet = proc.getResultSet();
      resultSet.next();
      out = resultSet.getDouble(1);
    } catch (SQLException e) {
    }
    return out;
  }
}
