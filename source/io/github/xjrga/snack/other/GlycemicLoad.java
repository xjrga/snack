package io.github.xjrga.snack.other;

public class GlycemicLoad {

  private final Double digestibleCarbs;
  private final Double glycemicIndex;

  public GlycemicLoad(Double glycemicIndex, Double digestibleCarbs) {
    this.glycemicIndex = glycemicIndex;
    this.digestibleCarbs = digestibleCarbs;
  }

  public double getGlycemicLoad() {
    return (glycemicIndex * digestibleCarbs) / 100;
  }
}
