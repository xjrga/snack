package io.github.xjrga.snack.sql;

import io.github.xjrga.snack.database.Connect;
import io.github.xjrga.snack.dataobject.FoodDataObject;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class FoodSelect {

  private final Connection connection;

  public FoodSelect() {
    connection = Connect.getInstance().getConnection();
  }

  public List<FoodDataObject> execute(FoodDataObject foodDataObject) {
    List<FoodDataObject> list = new LinkedList<>();
    try (CallableStatement proc = connection.prepareCall("{CALL public.Food_Select( ? )}")) {
      proc.setString(1, foodDataObject.getFoodId());
      ResultSet rs = proc.executeQuery();
      while (rs.next()) {
        foodDataObject.setFoodId(rs.getString(1));
        foodDataObject.setFoodName(rs.getString(2));
        list.add(foodDataObject);
      }
    } catch (SQLException e) {
    }
    return list;
  }
}
