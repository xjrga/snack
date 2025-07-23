package io.github.xjrga.snack.database.callable.insert;

import io.github.xjrga.snack.database.Connect;
import io.github.xjrga.snack.logger.LoggerImpl;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.Callable;

public class InsertMealTask implements Callable<Boolean> {

  private final String mixid;
  private final Integer mealid;
  private final String name;
  private final Integer order;
  private final Connection connection;

  public InsertMealTask(String mixid, Integer mealid, String name, Integer order) {
    this.mixid = mixid;
    this.mealid = mealid;
    this.name = name;
    this.order = order;
    connection = Connect.getInstance().getConnection();
  }

  @Override
  public Boolean call() throws Exception {
    boolean completed = false;
    try (CallableStatement proc =
        connection.prepareCall("{CALL public.Meal_insert_02( ?, ?, ?, ? )}")) {
      proc.setString(1, mixid);
      proc.setInt(2, mealid);
      proc.setString(3, name);
      proc.setInt(4, order);
      proc.execute();
      completed = true;
    } catch (SQLException e) {
      // LoggerImpl.INSTANCE.logProblem(e);
    }
    return completed;
  }}