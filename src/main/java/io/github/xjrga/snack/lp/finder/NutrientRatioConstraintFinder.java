package io.github.xjrga.snack.lp.finder;

import io.github.xjrga.snack.model.TableModelNutrientRatioConstraints;

public class NutrientRatioConstraintFinder {
  private TableModelNutrientRatioConstraints model;
  private Integer specificConstraintCount = 0;
  private Integer overallConstraintCount = 0;
  private String nutrient_b = "";
  private String relationship = "";
  private Double a = -1.0;
  private Double b = -1.0;
  private String nutrient_a = "";
  private Integer relationshipid = -1;
  private String nutrientid_b = "";
  private String nutrientid_a = "";
  private String mixid = "";
  private String name = "";

  public NutrientRatioConstraintFinder(TableModelNutrientRatioConstraints modelConstraint) {
    this.model = modelConstraint;
  }

  public void setOverallConstraintCount(Integer constraintCount) {
    this.overallConstraintCount = constraintCount;
  }

  public void find() {
    if (specificConstraintCount >= model.getRowCount()) {
      return;
    }
    nutrient_b = (String) model.getValueAt(specificConstraintCount, 7);
    relationship = (String) model.getValueAt(specificConstraintCount, 6);
    a = (Double) model.getValueAt(specificConstraintCount, 5);
    b = (Double) model.getValueAt(specificConstraintCount, 8);
    nutrient_a = (String) model.getValueAt(specificConstraintCount, 4);
    relationshipid = (Integer) model.getValueAt(specificConstraintCount, 3);
    nutrientid_b = (String) model.getValueAt(specificConstraintCount, 2);
    nutrientid_a = (String) model.getValueAt(specificConstraintCount, 1);
    mixid = (String) model.getValueAt(specificConstraintCount, 0);
    StringBuilder sbName = new StringBuilder();
    sbName.append(
        overallConstraintCount > 9
            ? overallConstraintCount
            : String.format("%1$ 2d", overallConstraintCount));
    sbName.append(") ");
    sbName.append(a);
    sbName.append(" ");
    sbName.append(nutrient_a);
    sbName.append(" / ");
    sbName.append(b);
    sbName.append(" ");
    sbName.append(nutrient_b);
    sbName.append(" ");
    sbName.append(relationship);
    sbName.append(" ");
    sbName.append(a / b);

    specificConstraintCount++;
    name = sbName.toString();
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
