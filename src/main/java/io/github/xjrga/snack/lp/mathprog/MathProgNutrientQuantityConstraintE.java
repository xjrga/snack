package io.github.xjrga.snack.lp.mathprog;

import io.github.xjrga.snack.data.MathProgPoint;
import io.github.xjrga.snack.lp.LpUtilities;

public class MathProgNutrientQuantityConstraintE implements MathProgConstraint {
  private final StringBuilder sb;
  private final Double constraintRhsValue;

  public MathProgNutrientQuantityConstraintE(Integer overallConstraintCount,
      Integer constraintRelationship, Double constraintRhsValue, String constraintName,
      MathProgPoint mathprogPoint) {
    sb = new StringBuilder();
    sb.append("/* ");
    sb.append(constraintName);
    sb.append(" */");
    sb.append("\n");
    sb.append("s.t. req");
    sb.append(String.format("%1$02d", overallConstraintCount));
    sb.append(": sum{food in 1..FOODS} sum{nutrient in {");
    sb.append(mathprogPoint.getNutrientPosition());
    sb.append("}} c[food,nutrient] * sum{meal in 1..MEALS} x[food,meal] ");
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
