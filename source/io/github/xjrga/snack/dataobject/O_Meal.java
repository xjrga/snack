package io.github.xjrga.snack.dataobject;

public class O_Meal {

  private Integer MealId;
  private Integer MealOrder;
  private String MixId;
  private String Name;

  public O_Meal() {}

  public Integer getMealid() {
    return MealId;
  }

  public Integer getMealOrder() {
    return MealOrder;
  }

  public String getMixid() {
    return MixId;
  }

  public String getName() {
    return Name;
  }

  public void setMealid(Integer MealId) {
    this.MealId = MealId;
  }

  public void setMealOrder(Integer order) {
    MealOrder = order;
  }

  public void setMixid(String MixId) {
    this.MixId = MixId;
  }

  public void setName(String Name) {
    this.Name = Name;
  }

  @Override
  public String toString() {
    return Name;
  }
}
