package io.github.xjrga.snack.sql;

import io.github.xjrga.snack.database.Connect;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class MixResultSelectPct implements SqlCallMixid<Map<String, Object>> {

  private final Connection connection;

  public MixResultSelectPct() {
    connection = Connect.getInstance().getConnection();
  }

  @Override
  public List<Map<String, Object>> execute(String mixid) {
    throw new UnsupportedOperationException("Not supported.");
  }

  @Override
  public List<Map<String, Object>> execute(String mixid, Integer precision) {
    LinkedList<Map<String, Object>> list = new LinkedList<>();
    try (CallableStatement proc =
        connection.prepareCall("{CALL public.MixResult_Select_Pct( ?, ? )}")) {
      proc.setString(1, mixid);
      proc.setInt(2, precision);
      ResultSet rs = proc.executeQuery();
      while (rs.next()) {
        Map<String, Object> row = new HashMap<>();
        row.put("CALORIES", rs.getObject(1));
        row.put("FATPCT", rs.getObject(2));
        row.put("CARBPCT", rs.getObject(3));
        row.put("PROTEINPCT", rs.getObject(4));
        row.put("ALCOHOLPCT", rs.getObject(5));
        row.put("FQ", rs.getObject(6));
        row.put("SATFATPCT", rs.getObject(7));
        row.put("MONOUFATPCT", rs.getObject(8));
        row.put("POLYUFATPCT", rs.getObject(9));
        row.put("ESSENTIALFATRATIO", rs.getObject(10));
        row.put("ELECTROLYTERATIO", rs.getObject(11));
        row.put("LAPCT", rs.getObject(12));
        row.put("ALAPCT", rs.getObject(13));
        row.put("PSRATIO", rs.getObject(14));
        row.put("MSRATIO", rs.getObject(15));
        list.add(row);
      }
    } catch (SQLException e) {
    }
    return list;
  }
}
