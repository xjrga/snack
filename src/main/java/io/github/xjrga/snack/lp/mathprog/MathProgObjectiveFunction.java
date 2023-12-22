package io.github.xjrga.snack.lp.mathprog;

import io.github.xjrga.snack.data.MathProgPoint;

public class MathProgObjectiveFunction implements MathProgConstraint {
  private final StringBuilder sb;

  public MathProgObjectiveFunction(String name, MathProgPoint mpoint) {
    sb = new StringBuilder();
    sb.append("/* ");
    sb.append("Minimize ");
    sb.append(name);
    sb.append(" */");
    sb.append("\n");
    sb.append("minimize z: sum{j in 1..FOODS} a[j,");
    sb.append(mpoint.getNutrientPosition());
    sb.append("] * x[j];");
  }

  @Override
  public String getLhs() {
    return sb.toString();
  }

  @Override
  public Double getRhs() {
    throw new UnsupportedOperationException("Not supported yet.");
  }
}