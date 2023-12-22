package io.github.xjrga.snack.data;

import io.github.xjrga.snack.dataobject.FoodDataObject;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MixFoods {
  private final DbLink dbLink;
  private Map<Integer, FoodDataObject> map;
  private Integer counter = 1;
  private Integer position = 0;

  public MixFoods(DbLink dbLink, String mixId) {
    this.dbLink = dbLink;
    map = this.getMixFood(mixId);
  }

  public Map<Integer, FoodDataObject> getMixFood(String mixId) {
    map = new HashMap<>();
    try {
      List<Map<String, String>> all = dbLink.MixFood_Select_All_By_Foodid(mixId);
      all.forEach(
          row -> {
            String foodid = row.get("FOODID");
            String name = row.get("NAME");
            map.put(counter, new FoodDataObject(foodid, name));
            counter++;
          });
      counter = 1;
    } catch (SQLException e) {
    }
    return map;
  }

  public Integer findPosition(String foodid) {
    map.entrySet()
        .forEach(
            entry -> {
              FoodDataObject value = entry.getValue();
              if (foodid.equals(value.getFoodId())) {
                position = entry.getKey();
              }
            });
    return position;
  }
}
