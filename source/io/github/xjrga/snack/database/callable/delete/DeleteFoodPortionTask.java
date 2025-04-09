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
public class DeleteFoodPortionTask implements Callable<Boolean> {

  private final Connection connection;
  private final String mixid;
  private final Integer mealid;
  private final String foodid;

  public DeleteFoodPortionTask(String mixid, Integer mealid, String foodid) {
    this.mixid = mixid;
    this.mealid = mealid;
    this.foodid = foodid;
    connection = Connect.getInstance().getConnection();
  }

  @Override
  public Boolean call() throws Exception {
    Boolean completed = false;
    try (CallableStatement proc =
        connection.prepareCall("{CALL public.MealFoodPortion_delete( ?, ?, ? )}")) {
      proc.setString(1, mixid);
      proc.setInt(2, mealid);
      proc.setString(3, foodid);
      proc.execute();
      completed = true;
    } catch (SQLException e) {
      LoggerImpl.INSTANCE.logProblem(e);
    }
    return completed;
  }
}
