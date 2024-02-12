package io.github.xjrga.snack.data;

public enum Nutrient {
  PROTEIN("203", "Protein, Total Protein (g)", "Protein"), FAT("204", "Fats, Total Fat (g)",
      "Fat"), CARBOHYDRATEBYDIFFERENCE("205", "Carbohydrates, By Difference (g)",
          "CarbsByDiff"), ENERGYGROSS("208", "Energy, Gross (kcal)", "EnergyGross"), ALCOHOL("221",
              "Other, Alcohol (g)", "Alcohol"), WATER("255", "Other, Water (g)", "Water"), FIBER(
                  "291", "Carbohydrates, Fiber (g)",
                  "Fiber"), CALCIUM("301", "Minerals, Calcium (mg)", "Calcium"), IRON("303",
                      "Minerals, Iron (mg)", "Iron"), MAGNESIUM("304", "Minerals, Magnesium (mg)",
                          "Magnesium"), PHOSPHORUS("305", "Minerals, Phosphorus (mg)",
                              "Phosphorus"), POTASSIUM("306", "Minerals, Potassium (mg)",
                                  "Potassium"), SODIUM("307", "Minerals, Sodium (mg)",
                                      "Sodium"), ZINC("309", "Minerals, Zinc (mg)", "Zinc"), COPPER(
                                          "312", "Minerals, Copper (mg)",
                                          "Copper"), MANGANESE("315", "Minerals, Manganese (mg)",
                                              "Manganese"), SELENIUM("317",
                                                  "Minerals, Selenium (µg)", "Selenium"), VITAMINA(
                                                      "320", "Vitamins, A, RAE (µg)",
                                                      "VitaminA"), VITAMINE("323",
                                                          "Vitamins, E (mg)", "VitaminE"), VITAMIND(
                                                              "328", "Vitamins, D (µg)",
                                                              "VitaminD"), VITAMINC("401",
                                                                  "Vitamins, C (mg)",
                                                                  "VitaminC"), THIAMIN("404",
                                                                      "Vitamins, Thiamin (mg)",
                                                                      "Thiamin"), RIBOFLAVIN("405",
                                                                          "Vitamins, Riboflavin (mg)",
                                                                          "Riboflavin"), NIACIN(
                                                                              "406",
                                                                              "Vitamins, Niacin (mg)",
                                                                              "Niacin"), PANTOTHENICACID(
                                                                                  "410",
                                                                                  "Vitamins, Pantothenic Acid (mg)",
                                                                                  "Pantothenic"), VITAMINB6(
                                                                                      "415",
                                                                                      "Vitamins, B6 (mg)",
                                                                                      "VitaminB6"), VITAMINB12(
                                                                                          "418",
                                                                                          "Vitamins, B12 (µg)",
                                                                                          "VitaminB12"), CHOLINE(
                                                                                              "421",
                                                                                              "Vitamins, Choline (mg)",
                                                                                              "Choline"), VITAMINK(
                                                                                                  "430",
                                                                                                  "Vitamins, K (µg)",
                                                                                                  "VitaminK"), FOLATE(
                                                                                                      "435",
                                                                                                      "Vitamins, Folate, DFE (µg)",
                                                                                                      "Folate"), CHOLESTEROL(
                                                                                                          "601",
                                                                                                          "Fats, Cholesterol (mg)",
                                                                                                          "Cholesterol"), SFA(
                                                                                                              "606",
                                                                                                              "Fats, Saturated Fat, SFA (g)",
                                                                                                              "Saturated"), LAURIC(
                                                                                                                  "611",
                                                                                                                  "Fats, Lauric Acid, 12:0 (g)",
                                                                                                                  "Lauric"), MYRISTIC(
                                                                                                                      "612",
                                                                                                                      "Fats, Myristic Acid, 14:0 (g)",
                                                                                                                      "Myristic"), PALMITIC(
                                                                                                                          "613",
                                                                                                                          "Fats, Palmitic Acid, 16:0 (g)",
                                                                                                                          "Palmitic"), STEARIC(
                                                                                                                              "614",
                                                                                                                              "Fats, Stearic Acid, 18:0 (g)",
                                                                                                                              "Stearic"), DHA(
                                                                                                                                  "621",
                                                                                                                                  "Fats, Docosahexaenoic Acid, DHA, 22:6 n-3 (g)",
                                                                                                                                  "DHA"), EPA(
                                                                                                                                      "629",
                                                                                                                                      "Fats, Eicosapentaenoic Acid, EPA, 20:5 n-3 (g)",
                                                                                                                                      "EPA"), MUFA(
                                                                                                                                          "645",
                                                                                                                                          "Fats, Monounsaturated Fat, MUFA (g)",
                                                                                                                                          "Monounsaturated"), PUFA(
                                                                                                                                              "646",
                                                                                                                                              "Fats, Polyunsaturated Fat, PUFA (g)",
                                                                                                                                              "Polyunsaturated"), LINOLEIC(
                                                                                                                                                  "618",
                                                                                                                                                  "Fats, Linoleic Acid, LA, 18:2 n-6 (g)",
                                                                                                                                                  "Linoleic"), LINOLENIC(
                                                                                                                                                      "619",
                                                                                                                                                      "Fats, Alpha-linolenic Acid, ALA, 18:3 n-3 (g)",
                                                                                                                                                      "Linolenic"), WEIGHT(
                                                                                                                                                          "10000",
                                                                                                                                                          "Other, Weight (g)",
                                                                                                                                                          "Weight"), COMPLETEPROTEIN(
                                                                                                                                                              "10001",
                                                                                                                                                              "Protein, Complete Protein (g)",
                                                                                                                                                              "CompleteProtein"), DIGESTIBLECARBOHYDRATE(
                                                                                                                                                                  "10003",
                                                                                                                                                                  "Carbohydrates, Digestible (g)",
                                                                                                                                                                  "DigestibleCarbs"), COST(
                                                                                                                                                                      "10005",
                                                                                                                                                                      "Cost  (g)",
                                                                                                                                                                      "Other, Cost (g)"), GLYCEMICLOAD(
                                                                                                                                                                          "10006",
                                                                                                                                                                          "Carbohydrates, Glycemic Load (g)",
                                                                                                                                                                          "GlycemicLoad"), ENERGYDIGESTIBLE(
                                                                                                                                                                              "10009",
                                                                                                                                                                              "Energy, Digestible (kcal)",
                                                                                                                                                                              "EnergyDigestible"), ENERGYFATCARBOHYDRATE(
                                                                                                                                                                                  "10010",
                                                                                                                                                                                  "Energy, Fat and Carbohydrate (kcal)",
                                                                                                                                                                                  "EnergyFatCarbohydrate"), ENERGYCARBOHYDRATE(
                                                                                                                                                                                      "10011",
                                                                                                                                                                                      "Energy, Carbohydrate (kcal)",
                                                                                                                                                                                      "EnergyCarbohydrate"), ENERGYPROTEIN(
                                                                                                                                                                                          "10012",
                                                                                                                                                                                          "Energy, Protein (kcal)",
                                                                                                                                                                                          "EnergyProtein"), ENERGYFAT(
                                                                                                                                                                                              "10013",
                                                                                                                                                                                              "Energy, Fat (kcal)",
                                                                                                                                                                                              "EnergyFat"), ENERGYALCOHOL(
                                                                                                                                                                                                  "10014",
                                                                                                                                                                                                  "Energy, Alcohol (kcal)",
                                                                                                                                                                                                  "EnergyAlcohol"), //
  // LINOLEIC("675", "18:2 n-6 c,c (LA) (g)", "Linoleic"),
  // ALPHALINOLENIC("851", "18:3 n-3 c,c,c (ALA) (g)", "AlphaLinolenic"),
  HCSFA("10015", "Fats, Hypercholesterolemic Fat (g)", "HCSFA");

  private final String Number;
  private final String Name;
  private final String Label;

  Nutrient(String number, String name, String label) {
    this.Number = number;
    this.Name = name;
    this.Label = label;
  }

  public String getNumber() {
    return Number;
  }

  public String getName() {
    return Name;
  }

  public String getLabel() {
    return Label;
  }
}
