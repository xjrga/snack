package io.github.xjrga.snack.dataobject;

public class InventoryDays {

  private String mixid;
  private String name;
  private Double days;

  public InventoryDays() {
    mixid = "";
    name = "";
    days = 0.0;
  }

  public void setMixid(String mixid) {
    this.mixid = mixid;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setDays(Double days) {
    this.days = days;
  }

  public String getMixid() {
    return mixid;
  }

  public String getName() {
    return name;
  }

  public Double getDays() {
    return days;
  }
}
