package io.github.xjrga.snack.database.callable.insert;

import io.github.xjrga.snack.database.Connect;
import io.github.xjrga.snack.logger.LoggerImpl;
import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.util.concurrent.Callable;

public class MergeNutrientQuantityConstraintTask implements Callable<Boolean> {
  private final String mixid;
  private final String nutrientid;
  private final Integer relationshipid;
  private final BigDecimal b;
  private final Connection connection;

  public MergeNutrientQuantityConstraintTask(
      String mixid, String nutrientid, Integer relationshipid, BigDecimal b) {
    this.mixid = mixid;
    this.nutrientid = nutrientid;
    this.relationshipid = relationshipid;
    this.b = b;
    connection = Connect.getInstance().getConnection();
  }

  @Override
  public Boolean call() throws Exception {
    boolean completed = false;
    try (CallableStatement proc =
        connection.prepareCall("{CALL public.NutrientConstraint_Merge( ?, ?, ?, ? )}")) {
      proc.setString(1, mixid);
      proc.setString(2, nutrientid);
      proc.setInt(3, relationshipid);
      proc.setBigDecimal(4, b);
      proc.execute();
      completed = true;
    } catch (Exception e) {
      LoggerImpl.INSTANCE.logProblem(e);
    }

    return completed;
  }
}