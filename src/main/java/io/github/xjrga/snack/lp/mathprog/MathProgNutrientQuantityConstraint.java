package io.github.xjrga.snack.lp.mathprog;

import io.github.xjrga.snack.data.MathProgPoint;
import io.github.xjrga.snack.lp.LpUtilities;

public class MathProgNutrientQuantityConstraint implements MathProgConstraint {
  private final StringBuilder sb;
  private final Double constraintRhsValue;

  public MathProgNutrientQuantityConstraint(Integer overallConstraintCount,
      Integer constraintRelationship, Double constraintRhsValue, String constraintName,
      MathProgPoint mathprogPoint) {
    sb = new StringBuilder();
    sb.append("/* ");
    sb.append(constraintName);
    sb.append(" */");
    sb.append("\n");
    sb.append("s.t. req");
    sb.append(String.format("%1$02d", overallConstraintCount));
    sb.append(": sum{j in 1..FOODS} c[j,");
    sb.append(mathprogPoint.getNutrientPosition());
    sb.append("] * x[j] ");
    sb.append(LpUtilities.getRelationship(constraintRelationship));
    sb.append(" ");
    sb.append(constraintRhsValue);
    sb.append(";");
    this.constraintRhsValue = constraintRhsValue;
  }

  @Override
  public String getLhs() {
    return sb.toString();
  }

  @Override
  public String getRhs() {
    return String.valueOf(constraintRhsValue);
  }
}
