package io.github.xjrga.snack.other;

import java.awt.Dimension;

public enum Dimensions {
  D1(900, 0),
  Pct(75, 25),
  Quantity(100, 25);
  private final Integer height;
  private final Integer width;

  Dimensions(Integer width, Integer height) {
    this.width = width;
    this.height = height;
  }

  public Dimension get() {
    return new Dimension(width, height);
  }

  public Integer getHeight() {
    return height;
  }

  public Integer getWidth() {
    return width;
  }
}
