package io.github.xjrga.snack.dataobject;

import java.math.BigDecimal;

public class Xml_nutrient_constraint {

  private BigDecimal b = new BigDecimal("0.0");
  private String nutrientid = "";
  private Integer relationshipid = 0;
  private final StringBuilder sb;

  public Xml_nutrient_constraint() {
    sb = new StringBuilder();
  }

  public BigDecimal getB() {
    return b;
  }

  public String getNutrientid() {
    return nutrientid;
  }

  public Integer getRelationshipid() {
    return relationshipid;
  }

  public void setB(BigDecimal b) {
    this.b = b;
  }

  public void setNutrientid(String nutrientid) {
    this.nutrientid = nutrientid;
  }

  public void setRelationshipid(Integer relationshipid) {
    this.relationshipid = relationshipid;
  }

  @Override
  public String toString() {
    sb.append("[");
    sb.append(nutrientid);
    sb.append(",");
    sb.append(relationshipid);
    sb.append(",");
    sb.append(b);
    sb.append("]");
    return sb.toString();
  }
}
