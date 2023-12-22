package io.github.xjrga.snack.dataobject;

public class O_Meal {
  private String MixId;
  private Integer MealId;
  private String Name;
  private Integer MealOrder;

  public O_Meal() {}

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

  public void setName(String Name) {
    this.Name = Name;
  }

  public String getName() {
    return Name;
  }

  public void setMealOrder(Integer order) {
    MealOrder = order;
  }

  public Integer getMealOrder() {
    return MealOrder;
  }

  @Override
  public String toString() {
    return Name;
  }
}
