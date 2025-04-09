package io.github.xjrga.snack.database.callable.insert;

import io.github.xjrga.snack.database.Connect;
import io.github.xjrga.snack.logger.LoggerImpl;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.util.concurrent.Callable;

public class InsertFoodCategoryTask implements Callable<Boolean> {
  private final Connection connection;
  private final String categoryid;
  private final String categoryname;

  public InsertFoodCategoryTask(String categoryid, String categoryname) {
    connection = Connect.getInstance().getConnection();
    this.categoryid = categoryid;
    this.categoryname = categoryname;
  }

  @Override
  public Boolean call() throws Exception {
    boolean completed = false;
    try (CallableStatement proc =
        connection.prepareCall("{CALL public.FoodCategory_Insert( ?, ? )}")) {
      proc.setString(1, categoryid);
      proc.setString(2, categoryname);
      proc.execute();
      completed = true;
    } catch (Exception e) {
      LoggerImpl.INSTANCE.logProblem(e);
    }
    return completed;
  }
}
