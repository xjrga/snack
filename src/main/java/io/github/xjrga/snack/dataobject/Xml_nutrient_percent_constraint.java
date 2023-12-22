package io.github.xjrga.snack.dataobject;

public class Xml_nutrient_percent_constraint {
  private final StringBuilder sb;
  private String foodid = "";
  private String nutrientid = "";
  private Integer relationshipid = 0;
  private Double b = 0.0;

  public Xml_nutrient_percent_constraint() {
    sb = new StringBuilder();
  }

  public String getFoodid() {
    return foodid;
  }

  public void setFoodid(String foodid) {
    this.foodid = foodid;
  }

  public String getNutrientid() {
    return nutrientid;
  }

  public void setNutrientid(String nutrientid) {
    this.nutrientid = nutrientid;
  }

  public Integer getRelationshipid() {
    return relationshipid;
  }

  public void setRelationshipid(Integer relationshipid) {
    this.relationshipid = relationshipid;
  }

  public Double getB() {
    return b;
  }

  public void setB(Double b) {
    this.b = b;
  }

  @Override
  public String toString() {
    sb.append("[");
    sb.append(foodid);
    sb.append(",");
    sb.append(nutrientid);
    sb.append(",");
    sb.append(relationshipid);
    sb.append(",");
    sb.append(b);
    sb.append("]");
    return sb.toString();
  }
}
