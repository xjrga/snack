package io.github.xjrga.snack.database.callable.insert;

import io.github.xjrga.snack.database.Connect;
import io.github.xjrga.snack.logger.LoggerImpl;
import java.lang.*;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.concurrent.Callable;

/**
 * @author jr
 */
public class CreateMixTask implements Callable<String> {

  private final Connection connection;
  private final String _mixName;

  public CreateMixTask(String mixName) {
    _mixName = mixName;
    connection = Connect.getInstance().getConnection();
  }

  @Override
  public String call() throws Exception {
    String out = "";
    try (CallableStatement proc = connection.prepareCall("{CALL public.Mix_Insert( ?, ? )}")) {
      proc.registerOutParameter(1, Types.INTEGER);
      proc.setString(2, _mixName);
      proc.execute();
      out = proc.getString(1);
    } catch (SQLException e) {
      LoggerImpl.INSTANCE.logProblem(e);
    }
    return out;
  }
}
