package io.github.xjrga.snack.database.callable.update;

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
public class UpdateModelOnMixTask implements Callable<Boolean> {

  private final Connection connection;
  private final String mixid;
  private final String model;

  public UpdateModelOnMixTask(String mixid, String model) {
    this.mixid = mixid;
    this.model = model;
    connection = Connect.getInstance().getConnection();
  }

  @Override
  public Boolean call() throws Exception {
    Boolean completed = false;
    try (CallableStatement proc =
        connection.prepareCall("{CALL public.Mix_Update_Other( ?, ? )}")) {
      proc.setString(1, mixid);
      proc.setString(2, model);
      proc.execute();
      completed = true;
    } catch (SQLException e) {
      LoggerImpl.INSTANCE.logProblem(e);
    }
    return completed;
  }
}
