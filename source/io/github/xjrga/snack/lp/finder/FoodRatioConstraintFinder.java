package io.github.xjrga.snack.lp.finder;

import io.github.xjrga.snack.datamodel.TableModelFoodNutrientRatioConstraints;

public class FoodRatioConstraintFinder {
  private TableModelFoodNutrientRatioConstraints model;
  private Integer specificConstraintCount = 0;
  private Integer overallConstraintCount = 0;
  private String mixid = "";
  private String foodid_a = "";
  private String nutrientid_a = "";
  private String foodid_b = "";
  private String nutrientid_b = "";
  private Integer relationshipid = -1;
  private String food_a = "";
  private String nutrient_a = "";
  private Double a = -1.0;
  private String relationship = "";
  private String food_b = "";
  private String nutrient_b = "";
  private Double b = -1.0;
  private String name;

  public FoodRatioConstraintFinder(TableModelFoodNutrientRatioConstraints modelConstraint) {
    this.model = modelConstraint;
  }

  public void find() {
    if (specificConstraintCount >= model.getRowCount()) {
      return;
    }
    mixid = (String) model.getValueAt(specificConstraintCount, 0);
    foodid_a = (String) model.getValueAt(specificConstraintCount, 1);
    nutrientid_a = (String) model.getValueAt(specificConstraintCount, 2);
    foodid_b = (String) model.getValueAt(specificConstraintCount, 3);
    nutrientid_b = (String) model.getValueAt(specificConstraintCount, 4);
    relationshipid = (Integer) model.getValueAt(specificConstraintCount, 5);
    food_a = (String) model.getValueAt(specificConstraintCount, 6);
    nutrient_a = (String) model.getValueAt(specificConstraintCount, 7);
    a = (Double) model.getValueAt(specificConstraintCount, 8);
    relationship = (String) model.getValueAt(specificConstraintCount, 9);
    food_b = (String) model.getValueAt(specificConstraintCount, 10);
    nutrient_b = (String) model.getValueAt(specificConstraintCount, 11);
    b = (Double) model.getValueAt(specificConstraintCount, 12);
    StringBuilder sbName = new StringBuilder();
    sbName.append(
        overallConstraintCount > 9
            ? overallConstraintCount
            : String.format("%1$ 2d", overallConstraintCount));
    sbName.append(") ");
    sbName.append(a);
    sbName.append(" ");
    sbName.append(food_a);
    sbName.append(" ");
    sbName.append(nutrient_a);
    sbName.append(" / ");
    sbName.append(b);
    sbName.append(" ");
    sbName.append(food_b);
    sbName.append(" ");
    sbName.append(nutrient_b);
    sbName.append(" ");
    sbName.append(relationship);
    sbName.append(" ");
    sbName.append(a / b);
    specificConstraintCount++;
    name = sbName.toString();
  }

  public void setOverallConstraintCount(Integer constraintCount) {
    this.overallConstraintCount = constraintCount;
  }

  public Double getA() {
    return a;
  }

  public Double getB() {
    return b;
  }

  public String getName() {
    return name;
  }
}
