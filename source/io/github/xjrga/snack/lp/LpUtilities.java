package io.github.xjrga.snack.lp;

public class LpUtilities {

  public static String getRelationship(int rel) {
    String relationship = "";
    switch (rel) {
      case 1:
        relationship = ">=";
        break;
      case 2:
        relationship = "<=";
        break;
      case 3:
        relationship = "=";
        break;
    }
    return relationship;
  }
}
