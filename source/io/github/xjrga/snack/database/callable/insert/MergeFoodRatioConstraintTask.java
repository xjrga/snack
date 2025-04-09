package io.github.xjrga.snack.database.callable.insert;

import io.github.xjrga.snack.database.Connect;
import io.github.xjrga.snack.logger.LoggerImpl;
import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.Callable;

public class MergeFoodRatioConstraintTask implements Callable<Boolean> {
  private final String mixid;
  private final String foodid1;
  private final String nutrientid1;
  private final String foodid2;
  private final String nutrientid2;
  private final Integer relationshipid;
  private final BigDecimal A;
  private final BigDecimal B;
  private final Connection connection;

  public MergeFoodRatioConstraintTask(
      String mixid,
      String foodid1,
      String nutrientid1,
      String foodid2,
      String nutrientid2,
      Integer relationshipid,
      BigDecimal A,
      BigDecimal B) {
    this.mixid = mixid;
    this.foodid1 = foodid1;
    this.nutrientid1 = nutrientid1;
    this.foodid2 = foodid2;
    this.nutrientid2 = nutrientid2;
    this.relationshipid = relationshipid;
    this.A = A;
    this.B = B;
    connection = Connect.getInstance().getConnection();
  }

  @Override
  public Boolean call() throws Exception {
    boolean completed = false;
    try (CallableStatement proc =
        connection.prepareCall("{CALL public.FoodNutrientRatio_Merge( ?, ?, ?, ?, ?, ?, ?, ? )}")) {
      proc.setString(1, mixid);
      proc.setString(2, foodid1);
      proc.setString(3, nutrientid1);
      proc.setString(4, foodid2);
      proc.setString(5, nutrientid2);
      proc.setInt(6, relationshipid);
      proc.setBigDecimal(7, A);
      proc.setBigDecimal(8, B);
      proc.execute();
      completed = true;
    } catch (SQLException e) {
      LoggerImpl.INSTANCE.logProblem(e);
    }
    return completed;
  }  }