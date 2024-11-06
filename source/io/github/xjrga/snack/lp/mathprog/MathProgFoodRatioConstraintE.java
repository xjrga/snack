package io.github.xjrga.snack.lp.mathprog;

import io.github.xjrga.snack.lp.LpUtilities;

public class MathProgFoodRatioConstraintE implements MathProgConstraint {
  private final StringBuilder sb;
  private final Double constraintRhsValue;

  public MathProgFoodRatioConstraintE(
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
    sb.append(": ");
    sb.append(mathprogPair.getA());
    sb.append(" * sum{food in {");
    sb.append(mathprogPair.getFirstFoodPosition());
    sb.append("}} sum{nutrient in {");
    sb.append(mathprogPair.getFirstNutrientPosition());
    sb.append("}} c[food,nutrient] * sum{meal in 1..MEALS} x[food,meal] - ");
    sb.append(mathprogPair.getB());
    sb.append(" * sum{food in {");
    sb.append(mathprogPair.getSecondFoodPosition());
    sb.append("}} sum{nutrient in {");
    sb.append(mathprogPair.getSecondNutrientPosition());
    sb.append("}} c[food,nutrient] * sum{meal in 1..MEALS} x[food,meal]");
    sb.append(" ");
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
