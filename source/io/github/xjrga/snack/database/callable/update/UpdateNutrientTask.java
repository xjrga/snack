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
public class UpdateNutrientTask implements Callable<Boolean> {

  private final Connection connection;
  private final String nutrientid;
  private final Integer visible;

  public UpdateNutrientTask(String nutrientid, Integer visible) {
    connection = Connect.getInstance().getConnection();
    this.nutrientid = nutrientid;
    this.visible = visible;
  }

  @Override
  public Boolean call() throws Exception {
    Boolean completed = false;
    try (CallableStatement proc = connection.prepareCall("{CALL public.Nutrient_Update( ?, ? )}")) {
      proc.setString(1, nutrientid);
      proc.setInt(2, visible);
      proc.execute();
      completed = true;
    } catch (SQLException e) {
      LoggerImpl.INSTANCE.logProblem(e);
    }
    return completed;
  }
}
