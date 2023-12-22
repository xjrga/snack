package io.github.xjrga.snack.dataobject;

import io.github.xjrga.snack.data.ConstraintType;
import io.github.xjrga.snack.data.NutrientFind;
import io.github.xjrga.snack.lp.LpUtilities;
import io.github.xjrga.snack.model.ListModelSelectedFood;

public class ConstraintName {
  private StringBuilder name;
  private final String nutrientid;
  private final String foodid;
  private final String foodid02;
  private final String nutrientid02;
  private ListModelSelectedFood modelList_selected_food = null;
  // Nutrient Quantity Constraint
  public ConstraintName(
      Integer constraintCount,
      ConstraintType type,
      String nutrientid,
      Integer relationshipid,
      Double b) {
    this.foodid = "";
    this.nutrientid = nutrientid;
    this.foodid02 = "";
    this.nutrientid02 = "";
    name = new StringBuilder();
    name.append(constraintCount);
    name.append(") ");
    name.append(NutrientFind.getNutrientName(nutrientid));
    name.append(" ");
    name.append(LpUtilities.getRelationship(relationshipid));
    name.append(" ");
    name.append(b);
  }
  // Food Quantity Constraint
  // Food Percent Constraint
  public ConstraintName(
      ListModelSelectedFood modelList_selected_food,
      Integer constraintCount,
      ConstraintType type,
      String foodid,
      String nutrientid,
      Integer relationshipid,
      Double b) {
    this.foodid = foodid;
    this.nutrientid = nutrientid;
    this.foodid02 = "";
    this.nutrientid02 = "";
    name = new StringBuilder();
    name.append(constraintCount);
    name.append(") ");
    name.append(modelList_selected_food.findName(foodid));
    name.append(" ");
    name.append(NutrientFind.getNutrientName(nutrientid));
    name.append(" ");
    name.append(LpUtilities.getRelationship(relationshipid));
    name.append(" ");
    name.append(b);
  }
  // Food Nutrient Ratio Constraint
  public ConstraintName(
      ListModelSelectedFood modelList_selected_food,
      Integer constraintCount,
      ConstraintType type,
      String foodid,
      String nutrientid,
      String foodid02,
      String nutrientid02,
      Integer relationshipid,
      Double b) {
    this.foodid = foodid;
    this.nutrientid = nutrientid;
    this.foodid02 = foodid02;
    this.nutrientid02 = nutrientid02;
    name = new StringBuilder();
    name.append(constraintCount);
    name.append(") ");
    name.append(modelList_selected_food.findName(foodid));
    name.append(" ");
    name.append(NutrientFind.getNutrientName(nutrientid));
    name.append(" : ");
    name.append(modelList_selected_food.findName(foodid02));
    name.append(" ");
    name.append(NutrientFind.getNutrientName(nutrientid02));
    name.append(" ");
    name.append(LpUtilities.getRelationship(relationshipid));
    name.append(" ");
    name.append(b);
  }
  // Nutrient Ratio Constraint
  public ConstraintName(
      Integer constraintCount,
      ConstraintType type,
      String nutrientid,
      String nutrientid02,
      Integer relationshipid,
      Double b) {
    this.foodid = "";
    this.nutrientid = nutrientid;
    this.foodid02 = "";
    this.nutrientid02 = nutrientid02;
    name = new StringBuilder();
    name.append(constraintCount);
    name.append(") ");
    name.append(NutrientFind.getNutrientName(nutrientid));
    name.append(" : ");
    name.append(NutrientFind.getNutrientName(nutrientid02));
    name.append(" ");
    name.append(LpUtilities.getRelationship(relationshipid));
    name.append(" ");
    name.append(b);
  }

  public String getFoodid() {
    return foodid;
  }

  public String getNutrientid() {
    return nutrientid;
  }

  public String getNutrientid02() {
    return nutrientid02;
  }

  public String getFoodid02() {
    return foodid02;
  }

  public String getName() {
    return name.toString();
  }
}
