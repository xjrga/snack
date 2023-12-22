package io.github.xjrga.snack.lp.mathprog;

import io.github.xjrga.snack.data.MixNutrientSelectAllName;
import java.util.ArrayList;
import java.util.List;

public class MathProgPrintOut {
  private final String mixid;
  private final String paramA;
  private String problemName;
  private String problemDate;
  private final List<MathProgConstraint> constraints;
  private final String nutrientNameComment;
  private String foodNameComment;
  private Integer foodCount = -1;
  private Integer nutrientCount = -1;

  public MathProgPrintOut(String mixid) {
    constraints = new ArrayList<>();
    this.mixid = mixid;
    MathProgParamA mathProgParamA = new MathProgParamA(mixid);
    List<String> nutrientNames = (new MixNutrientSelectAllName()).apply(mixid);
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < nutrientNames.size(); i++) {
      sb.append(String.format(" %1$2d) %2$s", i + 1, nutrientNames.get(i)));
      sb.append("\n");
    }
    sb.setLength(sb.length() - 1);
    nutrientNameComment = sb.toString();
    nutrientCount = nutrientNames.size();
    paramA = mathProgParamA.get();
  }

  public void addObjectiveFunction(MathProgObjectiveFunction mathprogObjectiveFunction) {
    constraints.add(mathprogObjectiveFunction);
  }

  public void addNutrientQuantityConstraint(
      MathProgNutrientQuantityConstraint mathprogNutrientQuantityConstraint) {
    constraints.add(mathprogNutrientQuantityConstraint);
  }

  public void addFoodQuantityConstraint(
      MathProgFoodQuantityConstraint mathprogFoodQuantityConstraint) {
    constraints.add(mathprogFoodQuantityConstraint);
  }

  public void addFoodRatioConstraint(MathProgFoodRatioConstraint mathProgFoodRatioConstraint) {
    constraints.add(mathProgFoodRatioConstraint);
  }

  public void addNutrientRatioConstraint(
      MathProgNutrientRatioConstraint mathProgNutrientRatioConstraint) {
    constraints.add(mathProgNutrientRatioConstraint);
  }

  public void addFoodQuantityPercentageConstraint(
      MathProgFoodPercentConstraint mathProgFoodPercentConstraint) {
    constraints.add(mathProgFoodPercentConstraint);
  }

  public void setFoodNameComment(String foodNameComment) {
    this.foodNameComment = foodNameComment;
  }

  public void setProblemName(String name) {
    this.problemName = name;
  }

  public void setProblemDate(String date) {
    this.problemDate = date;
  }

  public String getProblem() {
    StringBuilder sb = new StringBuilder();
    sb.append(getTitle());
    sb.append("\n\n");
    sb.append(getModel());
    sb.append(getData());
    sb.append("\n\n");
    sb.append(getComment());
    sb.append("\n");
    return sb.toString();
  }

  private String getTitle() {
    StringBuilder sb = new StringBuilder();
    sb.append("/*");
    sb.append("\n");
    sb.append(String.format(" %1$9s %2$s", "Problem: ", problemName));
    sb.append("\n");
    sb.append(String.format(" %1$9s %2$s", "Date: ", problemDate));
    sb.append("\n");
    sb.append("*/");
    return sb.toString();
  }

  private String getModel() {
    StringBuilder sb = new StringBuilder();
    sb.append("param FOODS;");
    sb.append("\n");
    sb.append("param NUTRIENTS;");
    sb.append("\n");
    sb.append("param CONSTRAINTS;");
    sb.append("\n");
    sb.append("param a{j in 1..FOODS,i in 1..NUTRIENTS};");
    sb.append("\n");
    sb.append("param b{i in 1..CONSTRAINTS};");
    sb.append("\n");
    sb.append("var x{j in 1..FOODS} >= 0;");
    sb.append("\n\n");
    for (MathProgConstraint c : constraints) {
      sb.append(c.getLhs());
      sb.append("\n\n");
    }
    return sb.toString();
  }

  private String getData() {
    StringBuilder sb = new StringBuilder();
    sb.append("data;");
    sb.append("\n\n");
    sb.append("param   NUTRIENTS:= ");
    sb.append(getNutrientCount());
    sb.append(";\n");
    sb.append("param       FOODS:= ");
    sb.append(getFoodCount());
    sb.append(";\n");
    sb.append("param CONSTRAINTS:= ");
    sb.append(getConstraintCount());
    sb.append(";");
    sb.append("\n\n");
    sb.append(getParamA());
    sb.append("\n\n");
    sb.append(getParamB());
    sb.append("\n\n");
    sb.append("end;");
    return sb.toString();
  }

  private int getConstraintCount() {
    return constraints.size() - 1;
  }

  private Integer getFoodCount() {
    return foodCount;
  }

  private Integer getNutrientCount() {
    return nutrientCount;
  }

  private String getComment() {
    StringBuilder sb = new StringBuilder();
    sb.append("/*");
    sb.append("\n");
    sb.append("Param a column:");
    sb.append("\n");
    sb.append(getNutrientNameComment());
    sb.append("\n\n");
    sb.append("Param a row:");
    sb.append("\n");
    sb.append(getFoodNameComment());
    sb.append("\n");
    sb.append("*/");
    return sb.toString();
  }

  private String getFoodNameComment() {
    return foodNameComment;
  }

  private String getNutrientNameComment() {
    return nutrientNameComment;
  }

  private String getParamA() {
    return paramA;
  }

  private String getParamB() {
    StringBuilder sb = new StringBuilder();
    sb.append("param : b :=");
    sb.append("\n");
    for (int i = 0; i < constraints.size(); i++) {
      if (i > 0) {
        sb.append("      ");
        sb.append(String.format("%1$2d %2$ 15.5f", i, constraints.get(i).getRhs()));
        sb.append("\n");
      }
    }
    sb.setLength(sb.length() - 1);
    sb.append(";");
    return sb.toString();
  }

  public void setFoodCount(Integer foodCount) {
    this.foodCount = foodCount;
  }
}
