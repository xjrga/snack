package io.github.xjrga.snack.dataobject;

import io.github.xjrga.snack.data.ConstraintType;

public class PositionObject {
  private Integer constraintOrder;
  private final ConstraintType constraintType;
  private final String constraintName;
  private Integer food01Position = -1;
  private Integer food02Position = -1;

  public PositionObject() {
    this.constraintOrder = -1;
    this.constraintType = null;
    this.constraintName = "";
  }

  public PositionObject(
      Integer constraintOrder, ConstraintType constraintType, String constraintName) {
    this.constraintOrder = constraintOrder;
    this.constraintType = constraintType;
    this.constraintName = constraintName;
  }

  public Integer getConstraintOrder() {
    return constraintOrder;
  }

  public ConstraintType getConstraintType() {
    return constraintType;
  }

  public String getConstraintName() {
    return constraintName;
  }

  public Integer getFood01Position() {
    return food01Position;
  }

  public void setFood01Position(Integer food01Position) {
    this.food01Position = food01Position;
  }

  public Integer getFood02Position() {
    return food02Position;
  }

  public void setFood02Position(Integer food02Position) {
    this.food02Position = food02Position;
  }

  public Boolean isPositionEmpty() {
    Boolean flag = false;
    if (food01Position == -1) {
      flag = true;
    }
    return flag;
  }
}
