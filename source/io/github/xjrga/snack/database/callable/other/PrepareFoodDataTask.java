package io.github.xjrga.snack.database.callable.other;

import io.github.xjrga.snack.database.Connect;
import io.github.xjrga.snack.logger.LoggerImpl;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.util.concurrent.Callable;

public class PrepareFoodDataTask implements Callable<Boolean> {
  private final Connection connection;
  private final String foodid;

  public PrepareFoodDataTask(String foodid) {
    connection = Connect.getInstance().getConnection();
    this.foodid = foodid;
  }

  @Override
  public Boolean call() throws Exception {
    boolean completed = false;
    try (CallableStatement proc = connection.prepareCall("{CALL public.preparefooddata( ? )}")) {
      proc.setString(1, foodid);
      proc.execute();
      completed = true;
    } catch (Exception e) {
      LoggerImpl.INSTANCE.logProblem(e);
    }
    return completed;
  }}