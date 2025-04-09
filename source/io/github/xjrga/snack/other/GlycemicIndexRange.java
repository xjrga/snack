package io.github.xjrga.snack.other;

public class GlycemicIndexRange {

  private final Integer glycemicIndex;

  public GlycemicIndexRange(Integer glycemicIndex) {
    this.glycemicIndex = glycemicIndex;
  }

  public String getGlycemicIndexRange() {
    /* Glycemic index scale goes from 0 to 100 */
    String range = "";
    if (glycemicIndex > 100) {
      range = "Out of Range";
    } else if (glycemicIndex > 69) {
      range = "High";
    } else if (glycemicIndex > 55) {
      range = "Medium";
    } else {
      if (glycemicIndex >= 0) {
        range = "Low";
      } else {
        range = "Out of Range";
      }
    }
    return range;
  }
}
