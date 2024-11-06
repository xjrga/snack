package io.github.xjrga.snack.sql;

import io.github.xjrga.snack.database.Connect;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class MixCostMerge {

  private final Connection connection;

  public MixCostMerge() {
    connection = Connect.getInstance().getConnection();
  }

  public void execute(String mixid, double cost) {
    try (CallableStatement proc = connection.prepareCall("{CALL public.MixCost_merge( ?, ? )}")) {
      proc.setString(1, mixid);
      proc.setDouble(2, cost);
      proc.execute();
    } catch (SQLException e) {
    }
  }
}
