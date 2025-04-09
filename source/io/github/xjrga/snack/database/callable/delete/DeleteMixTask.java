package io.github.xjrga.snack.database.callable.delete;

import io.github.xjrga.snack.database.Connect;
import io.github.xjrga.snack.logger.LoggerImpl;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.Callable;

/**
 * @author jr
 */
public class DeleteMixTask implements Callable<Boolean> {

  private final Connection connection;
  private final String mixid;

  public DeleteMixTask(String mixid) {
    connection = Connect.getInstance().getConnection();
    this.mixid = mixid;
  }

  @Override
  public Boolean call() throws Exception {
    Boolean completed = false;
    try (CallableStatement proc = connection.prepareCall("{CALL public.Mix_Delete( ? )}")) {
      proc.setString(1, mixid);
      proc.execute();
      completed = true;
    } catch (SQLException e) {
      LoggerImpl.INSTANCE.logProblem(e);
    }
    return completed;
  }
}
