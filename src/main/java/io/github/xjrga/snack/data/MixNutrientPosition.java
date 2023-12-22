package io.github.xjrga.snack.data;

import java.util.List;

public class MixNutrientPosition {
  private List<String> list;

  public MixNutrientPosition(List<String> nutrientList) {
    this.list = nutrientList;
  }

  public Integer getPosition(String nutrientid) {
    Integer flag = -1;
    for (int i = 0; i < list.size(); i++) {
      if (nutrientid.equals(list.get(i))) {
        flag = i + 1;
        break;
      }
    }
    return flag;
  }
}
