package io.github.xjrga.snack.sql;

import io.github.xjrga.snack.database.Connect;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class NutrientRatioDelete {

  private final Connection connection;

  public NutrientRatioDelete() {
    connection = Connect.getInstance().getConnection();
  }

  public void execute(
      String mixid, String nutrientid1, String nutrientid2, Integer relationshipid) {
    try (CallableStatement proc =
        connection.prepareCall("{CALL public.NutrientRatio_Delete( ?, ?, ?, ? )}")) {
      proc.setString(1, mixid);
      proc.setString(2, nutrientid1);
      proc.setString(3, nutrientid2);
      proc.setInt(4, relationshipid);
      proc.execute();
    } catch (SQLException e) {
    }
  }
}
