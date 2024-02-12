package io.github.xjrga.snack.lp.mathprog;

import io.github.xjrga.snack.data.MathProgPoint;
import io.github.xjrga.snack.lp.LpUtilities;

public class MathProgFoodQuantityConstraint implements MathProgConstraint {
  private final StringBuilder sb;
  private final Double constraintRhsValue;

  public MathProgFoodQuantityConstraint(Integer overallConstraintCount,
      Integer constraintRelationship, Double constraintRhsValue, String constraintName,
      MathProgPoint mathprogPoint) {
    sb = new StringBuilder();
    sb.append("/* ");
    sb.append(constraintName);
    sb.append(" */");
    sb.append("\n");
    sb.append("s.t. req");
    sb.append(String.format("%1$02d", overallConstraintCount));
    sb.append(": c[");
    sb.append(mathprogPoint.getFoodPosition());
    sb.append(",");
    sb.append(mathprogPoint.getNutrientPosition());
    sb.append("]");
    sb.append(" * ");
    sb.append("x[");
    sb.append(mathprogPoint.getFoodPosition());
    sb.append("] ");
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
