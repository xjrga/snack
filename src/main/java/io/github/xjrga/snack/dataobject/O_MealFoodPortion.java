package io.github.xjrga.snack.dataobject;

public class O_MealFoodPortion {
  private String MixId;
  private Integer MealId;
  private String FoodId;
  private Double Pct;
  private Double ExpectedWt;
  private Double ActualWt;

  public O_MealFoodPortion() {}

  public void setMixid(String MixId) {
    this.MixId = MixId;
  }

  public String getMixid() {
    return MixId;
  }

  public void setMealid(Integer MealId) {
    this.MealId = MealId;
  }

  public Integer getMealid() {
    return MealId;
  }

  public void setFoodid(String FoodId) {
    this.FoodId = FoodId;
  }

  public String getFoodid() {
    return FoodId;
  }

  public void setPct(Double Pct) {
    this.Pct = Pct;
  }

  public Double getPct() {
    return Pct;
  }

  public void setExpectedwt(Double ExpectedWt) {
    this.ExpectedWt = ExpectedWt;
  }

  public Double getExpectedwt() {
    return ExpectedWt;
  }

  public void setActualwt(Double ActualWt) {
    this.ActualWt = ActualWt;
  }

  public Double getActualwt() {
    return ActualWt;
  }

  @Override
  public String toString() {
    return "O_MealFoodAllocation{MixId=" + MixId + ", MealId=" + MealId + ", FoodId=" + FoodId
        + ", Pct=" + Pct + ", ExpectedWt=" + ExpectedWt + ", ActualWt=" + ActualWt + "}";
  }
}
