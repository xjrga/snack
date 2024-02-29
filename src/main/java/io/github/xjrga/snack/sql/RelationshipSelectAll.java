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

public class RelationshipSelectAll implements SqlCall<Map<String, Object>> {

  private final Connection connection;

  public RelationshipSelectAll() {
    connection = Connect.getInstance().getConnection();
  }

  @Override
  public List<Map<String, Object>> execute() {
    LinkedList<Map<String, Object>> list = new LinkedList<>();
    try (CallableStatement proc =
        connection.prepareCall("{CALL public.Relationship_Select_All()}")) {
      ResultSet rs = proc.executeQuery();
      while (rs.next()) {
        Map<String, Object> row = new HashMap<>();
        row.put("RELATIONSHIPID", rs.getObject(1));
        row.put("NAME", rs.getObject(2));
        list.add(row);
      }
    } catch (SQLException e) {
    }
    return list;
  }

  @Override
  public List<Map<String, Object>> execute(Integer precision) {
    throw new UnsupportedOperationException("Not supported.");
  }
}
