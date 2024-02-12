package io.github.xjrga.snack.lp.mathprog;

import io.github.xjrga.snack.data.MathProgPointPair;
import io.github.xjrga.snack.lp.LpUtilities;

public class MathProgNutrientRatioConstraintE implements MathProgConstraint {
  private final StringBuilder sb;
  private final Double constraintRhsValue;

  public MathProgNutrientRatioConstraintE(Integer overallConstraintCount,
      Integer constraintRelationship, Double constraintRhsValue, String constraintName,
      MathProgPointPair mathprogPair) {
    sb = new StringBuilder();
    sb.append("/* ");
    sb.append(constraintName);
    sb.append(" */");
    sb.append("\n");
    sb.append("s.t. req");
    sb.append(String.format("%1$02d", overallConstraintCount));
    sb.append(": sum{food in 1..FOODS} (");
    sb.append(mathprogPair.getB());
    sb.append(" * ");
    //
    sb.append("sum{nutrient in {");
    sb.append(mathprogPair.getFirstNutrientPosition());
    sb.append("}} c[food,nutrient] - ");
    sb.append(mathprogPair.getA());
    sb.append(" * sum{nutrient in {");
    sb.append(mathprogPair.getSecondNutrientPosition());
    sb.append("}} c[food,nutrient]) * sum{meal in 1..MEALS} x[food,meal]");
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
