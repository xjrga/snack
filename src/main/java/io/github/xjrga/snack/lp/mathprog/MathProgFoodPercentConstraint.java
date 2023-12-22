package io.github.xjrga.snack.lp.mathprog;

import io.github.xjrga.snack.data.MathProgPoint;
import io.github.xjrga.snack.lp.LpUtilities;

public class MathProgFoodPercentConstraint implements MathProgConstraint {
  private final StringBuilder sb;
  private final Double constraintRhsValue;

  public MathProgFoodPercentConstraint(
      Integer overallConstraintCount,
      Integer constraintRelationship,
      Double constraintRhsValue,
      String constraintName,
      MathProgPoint mathprogPoint,
      Double pct) {
    sb = new StringBuilder();
    sb.append("/* ");
    sb.append(constraintName);
    sb.append(" */");
    sb.append("\n");
    sb.append("s.t. req");
    sb.append(String.format("%1$02d", overallConstraintCount));
    sb.append(": a[");
    sb.append(mathprogPoint.getFoodPosition());
    sb.append(",");
    sb.append(mathprogPoint.getNutrientPosition());
    sb.append("]");
    sb.append(" * ");
    sb.append("x[");
    sb.append(mathprogPoint.getFoodPosition());
    sb.append("] ");
    sb.append(" - ");
    sb.append(pct / 100);
    sb.append(" * ");
    sb.append("sum{j in 1..FOODS} ");
    sb.append("a[j,");
    sb.append(mathprogPoint.getNutrientPosition());
    sb.append("])");
    sb.append(" * ");
    sb.append("x[j] ");
    sb.append(LpUtilities.getRelationship(constraintRelationship));
    sb.append(" b[");
    sb.append(overallConstraintCount);
    sb.append("];");
    this.constraintRhsValue = constraintRhsValue;
  }

  @Override
  public String getLhs() {
    return sb.toString();
  }

  @Override
  public Double getRhs() {
    return constraintRhsValue;
  }
}
