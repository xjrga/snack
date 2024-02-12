package io.github.xjrga.snack.lp.mathprog;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MathProgDataObject implements PrintOut {
  private String paramC;
  private String paramF;
  private String paramD;
  private final List<MathProgConstraint> constraints;
  private String cvsFileName = "cvsFileName";
  private String problemDate = "problemDate";
  private String problemName = "problemName";
  private String reportFileName = "reportFileName";
  private String foodCount = "";
  private String foodNameComment = "";

  public MathProgDataObject(String mixid) {
    constraints = new ArrayList<>();
  }


  @Override
  public void addEqualFoodAmountinMealsConstraint(MathProgConstraint constraint) {
    //
  }


  @Override
  public void addFoodQuantityConstraint(MathProgConstraint constraint) {
    constraints.add(constraint);
  }


  @Override
  public void addFoodQuantityPercentageConstraint(MathProgConstraint constraint) {
    constraints.add(constraint);
  }


  @Override
  public void addFoodRatioConstraint(MathProgConstraint constraint) {
    constraints.add(constraint);
  }


  @Override
  public void addNutrientQuantityConstraint(MathProgConstraint constraint) {
    constraints.add(constraint);
  }


  @Override
  public void addNutrientRatioConstraint(MathProgConstraint constraint) {
    constraints.add(constraint);
  }


  @Override
  public void addObjectiveFunction(MathProgConstraint constraint) {
    constraints.add(constraint);
  }


  @Override
  public void setFoodCount(Integer foodCount) {
    this.foodCount = String.valueOf(foodCount);
  }


  @Override
  public void setFoodNameComment(String foodNameComment) {
    this.foodNameComment = foodNameComment;
  }


  @Override
  public void setProblemDate(String date) {
    this.problemDate = date;
  }


  @Override
  public void setProblemName(String name) {
    this.problemName = name;
  }


  @Override
  public void setReportFileName(String name) {
    this.reportFileName = name;
  }


  @Override
  public void setCvsFileName(String name) {
    this.cvsFileName = name;
  }


  public String getCvsFileName() {
    return cvsFileName;
  }


  public String getProblemDate() {
    return problemDate;
  }


  public String getProblemName() {
    return problemName;
  }


  public String getReportFileName() {
    return reportFileName;
  }


  public Iterator<MathProgConstraint> getConstraintsIterator() {
    return constraints.iterator();
  }


  public String getParamC() {
    return paramC;
  }


  public String getParamF() {
    return paramF;
  }


  public String getParamD() {
    return paramD;
  }


  public String getFoodCount() {
    return foodCount;
  }


  public String getFoodNameComment() {
    return foodNameComment;
  }


  @Override
  public void setParamC(String param) {
    paramC = param;
  }


  @Override
  public void setParamF(String param) {
    paramF = param;
  }


  @Override
  public void setParamD(String param) {
    paramD = param;
  }

}
