package io.github.xjrga.snack.lp.mathprog;

public class MathProgPoint {
  private final Integer foodPosition;
  private final Integer nutrientPosition;

  public MathProgPoint(Integer nutrientPos) {
    this.foodPosition = -1;
    this.nutrientPosition = nutrientPos;
  }

  public MathProgPoint(Integer foodPos, Integer nutrientPos) {
    this.foodPosition = foodPos;
    this.nutrientPosition = nutrientPos;
  }

  public Integer getFoodPosition() {
    return foodPosition;
  }

  public Integer getNutrientPosition() {
    return nutrientPosition;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("MathProgPoint{");
    sb.append("foodPosition=").append(foodPosition);
    sb.append(", nutrientPosition=").append(nutrientPosition);
    sb.append('}');
    return sb.toString();
  }
}
