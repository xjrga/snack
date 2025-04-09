package io.github.xjrga.snack.database.callable.select;

import io.github.xjrga.snack.database.Connect;
import io.github.xjrga.snack.dataobject.NutrientDO;
import io.github.xjrga.snack.logger.LoggerImpl;
import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * @author jr
 */
public class DriNutrientsTask implements Callable<List<NutrientDO>> {

  private final Connection connection;

  public DriNutrientsTask() {
    connection = Connect.getInstance().getConnection();
  }

  @Override
  public List<NutrientDO> call() {
    LinkedList<NutrientDO> list = new LinkedList<>();
    try (CallableStatement proc = connection.prepareCall("{CALL public.selectDriNutrients()}")) {
      ResultSet rs = proc.executeQuery();
      while (rs.next()) {
        list.add(new NutrientDO(rs.getString(1), rs.getString(2), new BigDecimal("-1")));
      }
    } catch (SQLException e) {
      LoggerImpl.INSTANCE.logProblem(e);
    }
    return list;
  }
}
