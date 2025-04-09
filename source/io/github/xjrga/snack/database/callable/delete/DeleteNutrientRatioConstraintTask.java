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
public class DeleteNutrientRatioConstraintTask implements Callable<Boolean> {

  private final Connection connection;
  private final String mixid;
  private final String nutrientid1;
  private final String nutrientid2;
  private final Integer relationshipid;

  public DeleteNutrientRatioConstraintTask(
      String mixid, String nutrientid1, String nutrientid2, Integer relationshipid) {
    connection = Connect.getInstance().getConnection();
    this.mixid = mixid;
    this.nutrientid1 = nutrientid1;
    this.nutrientid2 = nutrientid2;
    this.relationshipid = relationshipid;
  }

  @Override
  public Boolean call() throws Exception {
    Boolean completed = false;
    try (CallableStatement proc =
        connection.prepareCall("{CALL public.NutrientRatio_Delete( ?, ?, ?, ? )}")) {
      proc.setString(1, mixid);
      proc.setString(2, nutrientid1);
      proc.setString(3, nutrientid2);
      proc.setInt(4, relationshipid);
      proc.execute();
      completed = true;
    } catch (SQLException e) {
      LoggerImpl.INSTANCE.logProblem(e);
    }
    return completed;
  }
}
