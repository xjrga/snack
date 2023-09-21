package io.github.xjrga.snack.data;

public enum Nutrient {
    PROTEIN( "203", "Protein (g)", "Protein" ),
    FAT( "204", "Total lipid (Fat) (g)", "Fat" ),
    CARBOHYDRATEBYDIFFERENCE( "205", "Carbohydrate, by difference (g)", "CarbsByDiff" ),
    ENERGYGROSS( "208", "Energy, gross (Kcal)", "EnergyGross" ),
    ALCOHOL( "221", "Alcohol, ethyl (g)", "Alcohol" ),
    WATER( "255", "Water (g)", "Water" ),
    FIBER( "291", "Fiber, total dietary (g)", "Fiber" ),
    CALCIUM( "301", "Calcium, Ca (mg)", "Calcium" ),
    IRON( "303", "Iron, Fe (mg)", "Iron" ),
    MAGNESIUM( "304", "Magnesium, Mg (mg)", "Magnesium" ),
    PHOSPHORUS( "305", "Phosphorus, P (mg)", "Phosphorus" ),
    POTASSIUM( "306", "Potassium, K (mg)", "Potassium" ),
    SODIUM( "307", "Sodium, Na (mg)", "Sodium" ),
    ZINC( "309", "Zinc, Zn (mg)", "Zinc" ),
    COPPER( "312", "Copper, Cu (mg)", "Copper" ),
    MANGANESE( "315", "Manganese, Mn (mg)", "Manganese" ),
    SELENIUM( "317", "Selenium, Se (µg)", "Selenium" ),
    VITAMINA( "320", "Vitamin A, RAE (µg)", "VitaminA" ),
    VITAMINE( "323", "Vitamin E (Alpha-Tocopherol) (mg)", "VitaminE" ),
    VITAMIND( "328", "Vitamin D (D2 + D3) (µg)", "VitaminD" ),
    VITAMINC( "401", "Vitamin C, total (Ascorbic Acid) (mg)", "VitaminC" ),
    THIAMIN( "404", "Thiamin (mg)", "Thiamin" ),
    RIBOFLAVIN( "405", "Riboflavin (mg)", "Riboflavin" ),
    NIACIN( "406", "Niacin (mg)", "Niacin" ),
    PANTOTHENICACID( "410", "Pantothenic acid (mg)", "Pantothenic" ),
    VITAMINB6( "415", "Vitamin B-6 (mg)", "VitaminB6" ),
    VITAMINB12( "418", "Vitamin B-12 (µg)", "VitaminB12" ),
    CHOLINE( "421", "Choline, total (mg)", "Choline" ),
    VITAMINK( "430", "Vitamin K (Phylloquinone) (µg)", "VitaminK" ),
    FOLATE( "435", "Folate, DFE (µg)", "Folate" ),
    CHOLESTEROL( "601", "Cholesterol (mg)", "Cholesterol" ),
    SFA( "606", "Fatty acids, total saturated (g)", "Saturated" ),
    LAURIC( "611", "Lauric, 12:0 (g)", "Lauric" ),
    MYRISTIC( "612", "Myristic, 14:0 (g)", "Myristic" ),
    PALMITIC( "613", "Palmitic, 16:0 (g)", "Palmitic" ),
    STEARIC( "614", "Stearic, 18:0 (g)", "Stearic" ),
    DHA( "621", "22:6 n-3 (DHA) (g)", "DHA" ),
    EPA( "629", "20:5 n-3 (EPA) (g)", "EPA" ),
    MUFA( "645", "Fatty acids, total monounsaturated (g)", "Monounsaturated" ),
    PUFA( "646", "Fatty acids, total polyunsaturated (g)", "Polyunsaturated" ),
    LINOLEIC( "618", "18:2 undifferentiated (Linoleic) (g)", "Linoleic" ),
    LINOLENIC( "619", "18:3 undifferentiated (Linolenic) (g)", "Linolenic" ),
    WEIGHT( "10000", "Weight (g)", "Weight" ),
    COMPLETEPROTEIN( "10001", "Complete Protein  (g)", "CompleteProtein" ),
    DIGESTIBLECARBOHYDRATE( "10003", "Digestible Carbs (g)", "DigestibleCarbs" ),
    COST( "10005", "Cost  (g)", "Cost" ),
    GLYCEMICLOAD( "10006", "Glycemic Load", "GlycemicLoad" ),
    ENERGYDIGESTIBLE( "10009", "Energy, digestible (Kcal)", "EnergyDigestible" ),
    ENERGYFATCARBOHYDRATE( "10010", "Energy, fat and carbohydrate (Kcal)", "EnergyFatCarbohydrate" ),
    ENERGYCARBOHYDRATE( "10011", "Energy, carbohydrate (Kcal)", "EnergyCarbohydrate" ),
    ENERGYPROTEIN( "10012", "Energy, protein (Kcal)", "EnergyProtein" ),
    ENERGYFAT( "10013", "Energy, fat (Kcal)", "EnergyFat" ),
    ENERGYALCOHOL( "10014", "Energy, alcohol (Kcal)", "EnergyAlcohol" ), //
    //LINOLEIC("675", "18:2 n-6 c,c (LA) (g)", "Linoleic"),
    //ALPHALINOLENIC("851", "18:3 n-3 c,c,c (ALA) (g)", "AlphaLinolenic"),
    ;
    private final String Number;
    private final String Name;
    private final String Label;
    Nutrient( String number, String name, String label ) {
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
