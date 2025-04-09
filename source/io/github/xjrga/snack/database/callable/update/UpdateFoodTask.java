package io.github.xjrga.snack.database.callable.update;

import io.github.xjrga.snack.database.Connect;
import io.github.xjrga.snack.logger.LoggerImpl;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.Callable;

/**
 * @author jr
 */
public class UpdateFoodTask implements Callable<Boolean> {

  private final Connection connection;
  private final String foodid;
  private final String foodname;

  public UpdateFoodTask(String foodid, String foodname) {
    connection = Connect.getInstance().getConnection();
    this.foodid = foodid;
    this.foodname = foodname;
  }

  @Override
  public Boolean call() throws Exception {
    Boolean completed = false;
    try (CallableStatement proc = connection.prepareCall("{CALL public.Food_Update( ?, ? )}")) {
      proc.setString(1, foodid);
      proc.setString(2, foodname);
      proc.execute();
      completed = true;
    } catch (SQLException e) {
      LoggerImpl.INSTANCE.logProblem(e);
    }
    return completed;
  }
}
