package io.github.xjrga.snack.lp.mathprog;

public interface PrintOut {
  void addEqualFoodAmountinMealsConstraint(MathProgConstraint constraint);

  void addFoodQuantityConstraint(MathProgConstraint constraint);

  void addFoodQuantityPercentageConstraint(MathProgConstraint constraint);

  void addFoodRatioConstraint(MathProgConstraint constraint);

  void addNutrientQuantityConstraint(MathProgConstraint constraint);

  void addNutrientRatioConstraint(MathProgConstraint constraint);

  void addObjectiveFunction(MathProgConstraint constraint);

  void setFoodCount(Integer count);

  void setFoodNameComment(String comment);

  void setProblemDate(String date);

  void setProblemName(String name);

  void setCvsFileName(String name);

  void setReportFileName(String name);

  void setParamC(String param);

  void setParamF(String param);

  void setParamD(String param);
}
