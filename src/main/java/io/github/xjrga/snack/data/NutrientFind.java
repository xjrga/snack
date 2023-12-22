package io.github.xjrga.snack.data;

public class NutrientFind {
  public NutrientFind() {}

  public static String getNutrientName(String id) {
    String name = "Not found";
    for (Nutrient nutrient : Nutrient.values()) {
      if (nutrient.getNumber().equals(id)) {
        name = nutrient.getName();
        break;
      }
    }
    return name;
  }

  public static String getNutrientLabel(String id) {
    String name = "Not found";
    for (Nutrient nutrient : Nutrient.values()) {
      if (nutrient.getNumber().equals(id)) {
        name = nutrient.getLabel();
        break;
      }
    }
    return name;
  }

  public static String getNutrientIdUsingName(String name) {
    String id = "Not found";
    for (Nutrient nutrient : Nutrient.values()) {
      if (nutrient.getName().equals(name)) {
        id = nutrient.getNumber();
        break;
      }
    }
    return id;
  }

  public static String getNutrientIdUsingLabel(String label) {
    String id = "Not found";
    for (Nutrient nutrient : Nutrient.values()) {
      if (nutrient.getLabel().equals(label)) {
        id = nutrient.getNumber();
        break;
      }
    }
    return id;
  }
}
