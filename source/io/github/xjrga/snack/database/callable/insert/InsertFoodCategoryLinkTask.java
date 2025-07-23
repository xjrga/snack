package io.github.xjrga.snack.database.callable.insert;

import io.github.xjrga.snack.database.Connect;
import io.github.xjrga.snack.logger.LoggerImpl;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.Callable;

public class InsertFoodCategoryLinkTask implements Callable<Boolean> {
  private final Connection connection;
  private final String categoryid;
  private final String foodid;

  public InsertFoodCategoryLinkTask(String categoryid, String foodid) {
    connection = Connect.getInstance().getConnection();
    this.categoryid = categoryid;
    this.foodid = foodid;
  }

  @Override
  public Boolean call() throws Exception {
    boolean completed = false;
    try (CallableStatement proc =
        connection.prepareCall("{CALL public.CategoryLink_Insert( ?, ? )}")) {
      proc.setString(1, foodid);
      proc.setString(2, categoryid);
      proc.execute();
      completed = true;
    } catch (SQLException e) {
      // LoggerImpl.INSTANCE.logProblem(e);
    }
    return completed;
  }}