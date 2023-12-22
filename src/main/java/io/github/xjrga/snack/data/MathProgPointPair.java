package io.github.xjrga.snack.data;

public class MathProgPointPair {
  private Double A;
  private Double B;
  private final MathProgPoint first;
  private final MathProgPoint second;

  public MathProgPointPair(MathProgPoint first, MathProgPoint second) {
    this.first = first;
    this.second = second;
  }

  public void setA(Double a) {
    this.A = a;
  }

  public void setB(Double b) {
    this.B = b;
  }

  public Integer getFirstFoodPosition() {
    return first.getFoodPosition();
  }

  public Integer getFirstNutrientPosition() {
    return first.getNutrientPosition();
  }

  public Integer getSecondFoodPosition() {
    return second.getFoodPosition();
  }

  public Integer getSecondNutrientPosition() {
    return second.getNutrientPosition();
  }

  public Double getA() {
    return A;
  }

  public Double getB() {
    return B;
  }

  @Override
  public String toString() {
    return "MathProgPointPair{"
        + "A="
        + A
        + ", first="
        + first
        + ", B="
        + B
        + ", second="
        + second
        + '}';
  }
}
