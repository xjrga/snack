package io.github.xjrga.snack.data;

import java.util.List;

public class MixFoodPosition {
  private List<String> list;

  public MixFoodPosition(List<String> foodList) {
    this.list = foodList;
  }

  public Integer getPosition(String foodid) {
    Integer flag = -1;
    for (int i = 0; i < list.size(); i++) {
      if (foodid.equals(list.get(i))) {
        flag = i + 1;
        break;
      }
    }
    return flag;
  }
}
