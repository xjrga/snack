package io.github.xjrga.snack.lp.mathprog;

import io.github.xjrga.snack.lp.LpUtilities;

public class MathProgNutrientRatioConstraint implements MathProgConstraint {
  private final StringBuilder sb;
  private final Double constraintRhsValue;

  public MathProgNutrientRatioConstraint(
      Integer overallConstraintCount,
      Integer constraintRelationship,
      Double constraintRhsValue,
      String constraintName,
      MathProgPointPair mathprogPair) {
    sb = new StringBuilder();
    sb.append("/* ");
    sb.append(constraintName);
    sb.append(" */");
    sb.append("\n");
    sb.append("s.t. req");
    sb.append(String.format("%1$02d", overallConstraintCount));
    sb.append(": sum{j in 1..FOODS} (");
    sb.append(mathprogPair.getB());
    sb.append(" * ");
    sb.append("c[j,");
    sb.append(mathprogPair.getFirstNutrientPosition());
    sb.append("]");
    sb.append(" - ");
    sb.append(mathprogPair.getA());
    sb.append(" * ");
    sb.append("c[j,");
    sb.append(mathprogPair.getSecondNutrientPosition());
    sb.append("])");
    sb.append(" * ");
    sb.append("x[j] ");
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
