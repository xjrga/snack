package io.github.xjrga.snack.lp.finder;

import io.github.xjrga.snack.datamodel.TableModelFoodNutrientConstraints;

public class FoodConstraintFinder {
  private TableModelFoodNutrientConstraints model;
  private Integer specificConstraintCount = 0;
  private Integer overallConstraintCount = 0;

  public FoodConstraintFinder(TableModelFoodNutrientConstraints modelConstraint) {
    this.model = modelConstraint;
  }

  public String getNextName() {
    if (specificConstraintCount >= model.getRowCount()) {
      return "";
    }
    String mixid = (String) model.getValueAt(specificConstraintCount, 0);
    String foodid = (String) model.getValueAt(specificConstraintCount, 1);
    String nutrientid = (String) model.getValueAt(specificConstraintCount, 2);
    Integer relationshipid = (Integer) model.getValueAt(specificConstraintCount, 3);
    String nutrient = (String) model.getValueAt(specificConstraintCount, 4);
    String food = (String) model.getValueAt(specificConstraintCount, 5);
    String relationship = (String) model.getValueAt(specificConstraintCount, 6);
    Double quantity = (Double) model.getValueAt(specificConstraintCount, 7);
    StringBuilder name = new StringBuilder();
    name.append(
        overallConstraintCount > 9
            ? overallConstraintCount
            : String.format("%1$ 2d", overallConstraintCount));
    name.append(") ");
    name.append(food);
    name.append(" ");
    name.append(nutrient);
    name.append(" ");
    name.append(relationship);
    name.append(" ");
    name.append(quantity);
    specificConstraintCount++;
    return name.toString();
  }

  public void setOverallConstraintCount(Integer constraintCount) {
    this.overallConstraintCount = constraintCount;
  }
}
