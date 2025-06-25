package io.github.xjrga.snack.database.callable.update;

import io.github.xjrga.snack.database.Connect;
import io.github.xjrga.snack.logger.LoggerImpl;
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
  private final BigDecimal deficiency;
  private final BigDecimal excess;

  public UpdateCostOnMixTask(
      String mixid, BigDecimal cost, BigDecimal deficiency, BigDecimal excess) {
    this.mixid = mixid;
    this.cost = cost;
    this.deficiency = deficiency;
    this.excess = excess;
    connection = Connect.getInstance().getConnection();
  }

  @Override
  public Boolean call() throws Exception {
    Boolean completed = false;
    try (CallableStatement proc =
        connection.prepareCall("{CALL public.MixCost_update( ?, ?, ?, ? )}")) {
      proc.setString(1, mixid);
      proc.setBigDecimal(2, cost);
      proc.setBigDecimal(3, deficiency);
      proc.setBigDecimal(4, excess);
      proc.execute();
      completed = true;
    } catch (SQLException e) {
      LoggerImpl.INSTANCE.logProblem(e);
    }
    return completed;
  }
}
