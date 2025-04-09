package io.github.xjrga.snack.other;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ResultsByMealIndexer {

  private List<Integer> indexes;
  private HashMap<String, Integer> map;

  public ResultsByMealIndexer() {
    indexes = new ArrayList();
    map = new HashMap();
    map.put("name", 0);
    map.put("weight", 1);
    map.put("egross", 2);
    map.put("edigest", 3);
    map.put("efat", 4);
    map.put("ecarbs", 5);
    map.put("efatcarbs", 6);
    map.put("eprotein", 7);
    map.put("ealcohol", 8);
    map.put("fat", 9);
    map.put("carbs", 10);
    map.put("protein", 11);
    map.put("complete", 12);
    map.put("alcohol", 13);
    map.put("fiber", 14);
    map.put("sodium", 15);
    map.put("potassium", 16);
  }

  public void setName() {
    indexes.add(map.get("name"));
  }

  public void setWeight() {
    indexes.add(map.get("weight"));
  }

  public void setEgross() {
    indexes.add(map.get("egross"));
  }

  public void setEdigest() {
    indexes.add(map.get("edigest"));
  }

  public void setEfat() {
    indexes.add(map.get("efat"));
  }

  public void setEcarbs() {
    indexes.add(map.get("ecarbs"));
  }

  public void setEfatcarbs() {
    indexes.add(map.get("efatcarbs"));
  }

  public void setEprotein() {
    indexes.add(map.get("eprotein"));
  }

  public void setEalcohol() {
    indexes.add(map.get("ealcohol"));
  }

  public void setFat() {
    indexes.add(map.get("fat"));
  }

  public void setCarbs() {
    indexes.add(map.get("carbs"));
  }

  public void setProtein() {
    indexes.add(map.get("protein"));
  }

  public void setComplete() {
    indexes.add(map.get("complete"));
  }

  public void setAlcohol() {
    indexes.add(map.get("alcohol"));
  }

  public void setFiber() {
    indexes.add(map.get("fiber"));
  }

  public void setSodium() {
    indexes.add(map.get("sodium"));
  }

  public void setPotassium() {
    indexes.add(map.get("potassium"));
  }

  public List<Integer> get() {
    return indexes;
  }
}
