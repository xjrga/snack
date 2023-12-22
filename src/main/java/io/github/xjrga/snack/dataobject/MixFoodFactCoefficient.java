package io.github.xjrga.snack.dataobject;

public class MixFoodFactCoefficient {
  private String foodid;
  private String nutrientid;
  private Integer coefficient;

  public MixFoodFactCoefficient() {}

  public String getFoodid() {
    return foodid;
  }

  public void setFoodid(String foodid) {
    this.foodid = foodid;
  }

  public String getNutrientid() {
    return nutrientid;
  }

  public void setNutrientid(String mixid) {
    this.nutrientid = mixid;
  }

  public Integer getCoefficient() {
    return coefficient;
  }

  public void setCoefficient(Integer coefficient) {
    this.coefficient = coefficient;
  }
}
