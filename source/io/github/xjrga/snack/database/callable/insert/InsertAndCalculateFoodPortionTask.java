package io.github.xjrga.snack.database.callable.insert;

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
public class InsertAndCalculateFoodPortionTask implements Callable<Boolean> {

  private final Connection connection;
  private final String mixid;
  private final Integer mealid;
  private final String foodid;
  private final Double pct;

  public InsertAndCalculateFoodPortionTask(String mixid, Integer mealid, String foodid, Double pct) {
    this.mixid = mixid;
    this.mealid = mealid;
    this.foodid = foodid;
    this.pct = pct;
    connection = Connect.getInstance().getConnection();
  }

  @Override
  public Boolean call() throws Exception {
    boolean execute = false;
    try (CallableStatement proc =
        connection.prepareCall(
            "{CALL public.MealFoodPortion_insert_and_calculate( ?, ?, ?, ? )}")) {
      proc.setString(1, mixid);
      proc.setInt(2, mealid);
      proc.setString(3, foodid);
      proc.setDouble(4, pct);
      proc.execute();
      execute = true;
    } catch (SQLException e) {
      LoggerImpl.INSTANCE.logProblem(e);
    }
    return execute;
  }
}
