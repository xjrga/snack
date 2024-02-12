package io.github.xjrga.snack.lp.mathprog;

import io.github.xjrga.snack.data.MathProgPoint;

public class MathProgObjectiveFunctionE implements MathProgConstraint {
  private final StringBuilder sb;

  public MathProgObjectiveFunctionE(String name, MathProgPoint mpoint) {
    sb = new StringBuilder();
    sb.append("/* ");
    sb.append("Minimize ");
    sb.append(name);
    sb.append(" */");
    sb.append("\n");
    sb.append("minimize z: sum{food in 1..FOODS} sum{nutrient in {");
    sb.append(mpoint.getNutrientPosition());
    sb.append("}} c[food,nutrient] * sum{meal in 1..MEALS} x[food,meal];");
  }

  @Override
  public String getLhs() {
    return sb.toString();
  }

  @Override
  public String getRhs() {
    return "";
  }
}
