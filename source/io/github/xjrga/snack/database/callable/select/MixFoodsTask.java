package io.github.xjrga.snack.database.callable.select;

import io.github.xjrga.snack.database.Connect;
import io.github.xjrga.snack.logger.LoggerImpl;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

/**
 * @author jr
 */
public class MixFoodsTask implements Callable<List<Map>> {

  private final Connection connection;
  private final String mixid;

  public MixFoodsTask(String mixid) {
    this.mixid = mixid;
    connection = Connect.getInstance().getConnection();
  }

  @Override
  public List<Map> call() {
    List<Map> list = new ArrayList();
    try (CallableStatement proc = connection.prepareCall("{CALL public.MixFood_Select( ? )}")) {
      proc.setString(1, mixid);
      ResultSet rs = proc.executeQuery();
      while (rs.next()) {
        Map<String, Object> row = new HashMap<>();
        row.put("MIXID", rs.getObject(1));
        row.put("FOODID", rs.getObject(2));
        row.put("X", rs.getObject(3));
        list.add(row);
      }
    } catch (Exception e) {
      LoggerImpl.INSTANCE.logProblem(e);
    } finally {
    }
    return list;
  }
}
