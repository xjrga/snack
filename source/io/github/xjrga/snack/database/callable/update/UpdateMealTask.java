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
public class UpdateMealTask implements Callable<Boolean> {

  private final Connection connection;
  private final String mixid;
  private final Integer mealid;
  private final String mealname;
  private final Integer mealorder;

  public UpdateMealTask(String mixid, Integer mealid, String mealname, Integer mealorder) {
    connection = Connect.getInstance().getConnection();
    this.mixid = mixid;
    this.mealid = mealid;
    this.mealname = mealname;
    this.mealorder = mealorder;
  }

  @Override
  public Boolean call() throws Exception {
    Boolean completed = false;
    try (CallableStatement proc =
        connection.prepareCall("{CALL public.Meal_update( ?, ?, ?, ? )}")) {
      proc.setString(1, mixid);
      proc.setInt(2, mealid);
      proc.setString(3, mealname);
      proc.setInt(4, mealorder);
      proc.execute();
      completed = true;
    } catch (SQLException e) {
      LoggerImpl.INSTANCE.logProblem(e);
    }
    return completed;
  }
}
