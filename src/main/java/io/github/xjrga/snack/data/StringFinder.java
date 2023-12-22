package io.github.xjrga.snack.data;

import java.util.List;

public class StringFinder {
  private List<String> list;
  private Integer counter = 1;
  private Integer position = -1;

  public StringFinder(List<String> list) {
    this.list = list;
  }

  public Integer findPosition(String oStr) {
    list.forEach(
        iStr -> {
          if (oStr.equals(iStr)) {
            position = counter;
          }
          counter++;
        });
    return position;
  }
}
