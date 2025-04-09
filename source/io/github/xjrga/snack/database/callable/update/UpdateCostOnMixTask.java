package io.github.xjrga.snack.database.callable.update;

import io.github.xjrga.snack.database.Connect;
import io.github.xjrga.snack.logger.LoggerImpl;
import java.lang.*;
import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.Callable;

/**
 * @author jr
 */
public class UpdateCostOnMixTask implements Callable<Boolean> {

  private final Connection connection;
  private final String mixid;
  private final BigDecimal cost;

  public UpdateCostOnMixTask(String mixid, BigDecimal cost) {
    this.mixid = mixid;
    this.cost = cost;
    connection = Connect.getInstance().getConnection();
  }

  @Override
  public Boolean call() throws Exception {
    Boolean completed = false;
    try (CallableStatement proc = connection.prepareCall("{CALL public.MixCost_update( ?, ? )}")) {
      proc.setString(1, mixid);
      proc.setBigDecimal(2, cost);
      proc.execute();
      completed = true;
    } catch (SQLException e) {
      LoggerImpl.INSTANCE.logProblem(e);
    }
    return completed;
  }
}
