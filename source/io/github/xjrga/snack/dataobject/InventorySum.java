package io.github.xjrga.snack.dataobject;

public class InventorySum {

  private String foodid;
  private String name;
  private Double g;
  private Double oz;
  private Double lb;
  private Double kg;

  public InventorySum() {
    foodid = "";
    name = "";
    g = 0.0;
    oz = 0.0;
    lb = 0.0;
    kg = 0.0;
  }

  public String getFoodid() {
    return foodid;
  }

  public void setFoodid(String foodid) {
    this.foodid = foodid;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Double getG() {
    return g;
  }

  public void setG(Double g) {
    this.g = g;
  }

  public Double getOz() {
    return oz;
  }

  public void setOz(Double oz) {
    this.oz = oz;
  }

  public Double getLb() {
    return lb;
  }

  public void setLb(Double lb) {
    this.lb = lb;
  }

  public Double getKg() {
    return kg;
  }

  public void setKg(Double kg) {
    this.kg = kg;
  }
}
