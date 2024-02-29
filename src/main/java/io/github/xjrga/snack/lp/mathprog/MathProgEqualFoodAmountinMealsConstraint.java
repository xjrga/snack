package io.github.xjrga.snack.lp.mathprog;

import io.github.xjrga.snack.lp.LpUtilities;

public class MathProgEqualFoodAmountinMealsConstraint implements MathProgConstraint {
  private final StringBuilder sb;
  private final Double constraintRhsValue;

  public MathProgEqualFoodAmountinMealsConstraint(
      Integer overallConstraintCount,
      Integer constraintRelationship,
      Double constraintRhsValue,
      String constraintName,
      MathProgPoint mathprogPoint) {
    sb = new StringBuilder();
    sb.append("/* ");
    sb.append(constraintName);
    sb.append(" */");
    sb.append("\n");
    // sb.append("/* ");
    sb.append("s.t. req");
    sb.append(String.format("%1$02d", overallConstraintCount));
    sb.append("{meal in 1..MEALS}");
    sb.append(": ");
    sb.append("(MEALS * (sum{food in {");
    sb.append(mathprogPoint.getFoodPosition());
    sb.append("}} sum{nutrient in {");
    sb.append(mathprogPoint.getNutrientPosition());
    sb.append("}} c[food,nutrient] * x[food,meal]))");
    sb.append(" -\n");
    sb.append("(sum{food in {");
    sb.append(mathprogPoint.getFoodPosition());
    sb.append("}} sum{nutrient in {");
    sb.append(mathprogPoint.getNutrientPosition());
    sb.append("}} c[food,nutrient] *  sum{comida in 1..MEALS} x[food,comida])");
    sb.append(" ");
    sb.append(LpUtilities.getRelationship(constraintRelationship));
    sb.append(" ");
    sb.append(constraintRhsValue);
    sb.append(";");
    // sb.append(" */");
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
