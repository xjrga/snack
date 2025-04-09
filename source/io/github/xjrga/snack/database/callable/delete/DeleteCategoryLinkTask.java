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
public class DeleteCategoryLinkTask implements Callable<Boolean> {

  private final Connection connection;
  private final String categoryid;
  private final String foodid;

  public DeleteCategoryLinkTask(String categoryid, String foodid) {
    this.categoryid = categoryid;
    this.foodid = foodid;
    connection = Connect.getInstance().getConnection();
  }

  @Override
  public Boolean call() throws Exception {
    boolean completed = false;
    try (CallableStatement proc =
        connection.prepareCall("{CALL public.CategoryLink_Delete( ?, ? )}")) {
      proc.setString(1, categoryid);
      proc.setString(2, foodid);
      proc.execute();
      completed = true;
    } catch (SQLException e) {
      LoggerImpl.INSTANCE.logProblem(e);
    }
    return completed;
  }
}
