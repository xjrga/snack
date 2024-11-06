package io.github.xjrga.snack.sql;

import io.github.xjrga.snack.database.Connect;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoryLinkCount {

  private final Connection connection;

  public CategoryLinkCount() {
    connection = Connect.getInstance().getConnection();
  }

  public Integer execute(String foodid, String foodcategoryid) {
    Integer out = null;
    try (CallableStatement proc =
        connection.prepareCall("{CALL public.CategoryLink_Count( ?, ? )}")) {
      proc.setString(1, foodid);
      proc.setString(2, foodcategoryid);
      proc.execute();
      ResultSet resultSet = proc.getResultSet();
      resultSet.next();
      out = resultSet.getInt(1);
    } catch (SQLException e) {
    }
    return out;
  }
}
