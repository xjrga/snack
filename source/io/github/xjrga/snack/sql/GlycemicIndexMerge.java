package io.github.xjrga.snack.sql;

import io.github.xjrga.snack.database.Connect;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class GlycemicIndexMerge {

  private final Connection connection;

  public GlycemicIndexMerge() {
    connection = Connect.getInstance().getConnection();
  }

  public void execute(String foodid, Double gi) {
    try (CallableStatement proc =
        connection.prepareCall("{CALL public.GlycemicIndex_Merge( ?, ? )}")) {
      proc.setString(1, foodid);
      proc.setDouble(2, gi);
      proc.execute();
    } catch (SQLException e) {
    }
  }
}
