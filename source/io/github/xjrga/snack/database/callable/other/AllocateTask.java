package io.github.xjrga.snack.database.callable.other;

import io.github.xjrga.snack.database.Connect;
import io.github.xjrga.snack.logger.LoggerImpl;
import java.lang.*;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.Callable;

/**
 * @author jr
 */
public class AllocateTask implements Callable<Boolean> {

  private final Connection connection;
  private final String mixid;

  public AllocateTask(String mixid) {
    this.mixid = mixid;
    connection = Connect.getInstance().getConnection();
  }

  @Override
  public Boolean call() throws Exception {
    boolean execute = false;
    try (CallableStatement proc = connection.prepareCall("{CALL public.allocate( ? )}")) {
      proc.setString(1, mixid);
      proc.execute();
      execute = true;
    } catch (SQLException e) {
      LoggerImpl.INSTANCE.logProblem(e);
    } finally {
    }
    return execute;
  }
}
