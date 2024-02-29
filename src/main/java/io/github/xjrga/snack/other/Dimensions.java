package io.github.xjrga.snack.other;

import java.awt.Dimension;

public enum Dimensions {
  Quantity(100, 25),
  Pct(75, 25),
  D1(900, 0);

  private final Integer width;
  private final Integer height;

  Dimensions(Integer width, Integer height) {
    this.width = width;
    this.height = height;
  }

  public Integer getWidth() {
    return width;
  }

  public Integer getHeight() {
    return height;
  }

  public Dimension get() {
    return new Dimension(width, height);
  }
}
