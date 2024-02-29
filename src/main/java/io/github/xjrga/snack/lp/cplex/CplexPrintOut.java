package io.github.xjrga.snack.lp.cplex;

import io.github.xjrga.snack.lp.LpUtilities;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CplexPrintOut {
  private String foodNameComment;
  private final StringBuilder objectiveFunctionCoefficients;
  private final StringBuilder constraintCoefficients;
  private String model;
  private String title;
  private String date;

  public CplexPrintOut() {
    this.objectiveFunctionCoefficients = new StringBuilder();
    this.constraintCoefficients = new StringBuilder();
  }

  public void setProblemName(String title) {
    this.title = title;
  }

  public void setProblemDate(String date) {
    this.date = date;
  }

  private void setObjectiveFunctionCoefficients(double[] coefficients) {
    for (int i = 0; i < coefficients.length; i++) {
      double c = coefficients[i];
      if (c < 0) {
        objectiveFunctionCoefficients.append(
            String.format(" - %1$ 35.17f X%2$02d", Math.abs(c), i + 1));
      } else {
        objectiveFunctionCoefficients.append(
            String.format(" + %1$ 35.17f X%2$02d", Math.abs(c), i + 1));
      }
    }
  }

  public void setObjectiveFunction(double[] coefficients, String name) {
    objectiveFunctionCoefficients.append("\\");
    objectiveFunctionCoefficients.append(name);
    objectiveFunctionCoefficients.append("\n");
    setObjectiveFunctionCoefficients(coefficients);
  }

  private void setConstraintCoefficients(double[] coefficients, int rel, double value) {
    String relationship = LpUtilities.getRelationship(rel);
    constraintCoefficients.append("");
    for (int i = 0; i < coefficients.length; i++) {
      double c = coefficients[i];
      if (c < 0) {
        constraintCoefficients.append(String.format(" - %1$ 35.17f X%2$02d", Math.abs(c), i + 1));
      } else {
        constraintCoefficients.append(String.format(" + %1$ 35.17f X%2$02d", Math.abs(c), i + 1));
      }
    }
    constraintCoefficients.append(" ");
    constraintCoefficients.append(String.format("%1$2s %2$ 35.17f", relationship, value));
    constraintCoefficients.append("\n");
  }

  public void addConstraint(double[] coefficients, int rel, double value, String name) {
    constraintCoefficients.append("\\ ");
    constraintCoefficients.append(name);
    constraintCoefficients.append("\n");
    setConstraintCoefficients(coefficients, rel, value);
  }

  public String getProblem() {
    StringBuilder strb = new StringBuilder();
    strb.append(getDescription());
    strb.append("\n\n");
    strb.append(getModel());
    strb.append("\n");
    return strb.toString();
  }

  public void endConstraints() {
    StringBuilder strb = new StringBuilder();
    strb.append("Minimize");
    strb.append("\n");
    strb.append(objectiveFunctionCoefficients.toString());
    strb.append("\n");
    strb.append("Subject To");
    strb.append("\n");
    strb.append(constraintCoefficients.toString());
    strb.append("End");
    model = strb.toString();
  }

  private String getDescription() {
    StringBuilder strb = new StringBuilder();
    strb.append(String.format("\\%1$9s %2$s", "Problem: ", title));
    strb.append("\n");
    strb.append(String.format("\\%1$9s %2$s", "Date: ", date));
    strb.append("\n\n");
    strb.append(getFoodNameComment());
    return strb.toString();
  }

  private String getFoodNameComment() {
    Pattern p = Pattern.compile("^ ?(\\d\\d?\\))", Pattern.MULTILINE);
    Matcher m = p.matcher(foodNameComment);
    return m.replaceAll("\\\\$1");
  }

  private String getModel() {
    return model;
  }

  public void setFoodNameComment(String foodNameComment) {
    this.foodNameComment = foodNameComment;
  }
}
