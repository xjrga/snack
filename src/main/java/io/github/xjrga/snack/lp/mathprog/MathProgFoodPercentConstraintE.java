package io.github.xjrga.snack.lp.mathprog;

import io.github.xjrga.snack.data.MathProgPoint;
import io.github.xjrga.snack.lp.LpUtilities;

public class MathProgFoodPercentConstraintE implements MathProgConstraint {
  private final StringBuilder sb;
  private final Double constraintRhsValue;

  public MathProgFoodPercentConstraintE(Integer overallConstraintCount,
      Integer constraintRelationship, Double constraintRhsValue, String constraintName,
      MathProgPoint mathprogPoint, Double pct) {
    sb = new StringBuilder();
    sb.append("/* ");
    sb.append(constraintName);
    sb.append(" */");
    sb.append("\n");
    sb.append("s.t. req");
    sb.append(String.format("%1$02d", overallConstraintCount));
    sb.append(": ");
    sb.append("sum{food in {");
    sb.append(mathprogPoint.getFoodPosition());
    sb.append("}} sum{nutrient in {");
    sb.append(mathprogPoint.getNutrientPosition());
    sb.append("}} c[food,nutrient] * sum{meal in 1..MEALS} x[food,meal] - ");
    sb.append(pct / 100);
    sb.append(" * sum{food in 1..FOODS} sum{nutrient in {");
    sb.append(mathprogPoint.getNutrientPosition());
    sb.append("}} c[food,nutrient] * sum{meal in 1..MEALS} x[food,meal]");
    sb.append(" ");
    sb.append(LpUtilities.getRelationship(constraintRelationship));
    sb.append(" ");
    sb.append(0);
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
