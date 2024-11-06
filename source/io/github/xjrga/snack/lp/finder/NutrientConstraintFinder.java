package io.github.xjrga.snack.lp.finder;

import io.github.xjrga.snack.datamodel.TableModelNutrientConstraints;

public class NutrientConstraintFinder {
  private TableModelNutrientConstraints model;
  private Integer specificConstraintCount = 0;
  private Integer overallConstraintCount = 0;
  private Integer nutrientidPosition = -1;

  public NutrientConstraintFinder(TableModelNutrientConstraints model) {
    this.model = model;
  }

  public String getNextName() {
    if (specificConstraintCount >= model.getRowCount()) {
      return "";
    }
    String mixid = (String) model.getValueAt(specificConstraintCount, 0);
    String nutrientid = (String) model.getValueAt(specificConstraintCount, 1);
    Integer relationshipid = (Integer) model.getValueAt(specificConstraintCount, 2);
    String nutrient = (String) model.getValueAt(specificConstraintCount, 3);
    String relationship = (String) model.getValueAt(specificConstraintCount, 4);
    Double quantity = (Double) model.getValueAt(specificConstraintCount, 5);
    StringBuilder name = new StringBuilder();
    name.append(
        overallConstraintCount > 9
            ? overallConstraintCount
            : String.format("%1$ 2d", overallConstraintCount));
    name.append(") ");
    name.append(nutrient);
    name.append(" ");
    name.append(relationship);
    name.append(" ");
    name.append(quantity);
    specificConstraintCount++;
    return name.toString();
  }

  public Integer getNutrientidPosition() {
    return this.nutrientidPosition;
  }

  public void setNutrientidPosition(Integer nutrientidPosition) {
    this.nutrientidPosition = nutrientidPosition;
  }

  public void setOverallConstraintCount(Integer overallConstraintCount) {
    this.overallConstraintCount = overallConstraintCount;
  }

  @Override
  public String toString() {
    return "NutrientConstraintFinder [name="
        + this.getNextName()
        + ", overallConstraintCount="
        + this.overallConstraintCount
        + ", nutrientidPosition="
        + this.nutrientidPosition
        + "]";
  }
}
