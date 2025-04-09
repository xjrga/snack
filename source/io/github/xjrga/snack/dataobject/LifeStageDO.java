package io.github.xjrga.snack.dataobject;

import java.util.Objects;

public class LifeStageDO {

  private String Label = "";
  private Integer LifeStageId = -1;

  public LifeStageDO(Integer LifeStageId, String Label) {
    this.LifeStageId = LifeStageId;
    this.Label = Label;
  }

  public String getLabel() {
    return Label;
  }

  public Integer getLifeStageId() {
    return LifeStageId;
  }

  public void setLabel(String Label) {
    this.Label = Label;
  }

  public void setLifeStageId(Integer LifeStageId) {
    this.LifeStageId = LifeStageId;
  }

  @Override
  public int hashCode() {
    int hash = 3;
    hash = 97 * hash + Objects.hashCode(this.LifeStageId);
    return hash;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final LifeStageDO other = (LifeStageDO) obj;
    return Objects.equals(this.LifeStageId, other.LifeStageId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(Label);
    return sb.toString();
  }
}
