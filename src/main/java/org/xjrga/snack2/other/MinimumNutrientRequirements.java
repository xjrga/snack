package org.xjrga.snack2.other;

public class MinimumNutrientRequirements {
    private final Double weightinlbs;

    public MinimumNutrientRequirements(Double weightinlbs) {
        this.weightinlbs = weightinlbs;
    }

    public double getProtein() {
        /*Complete Protein Required For Nitrogen Balance Under A No Carbohydrate Regimen*/
        return 1.3D * (double) weightinlbs.intValue() / 2.20462262185D;
    }

    public double getCarbohydrateLow() {
        /*Amount of Carbohydrate Needed to Appreciably Reduce Ketosis*/
        /*
        * Gamble, James L. "Physiological information gained from studies on the life raft ration." Nutrition Reviews 47.7 (1989): 199-201.
        */
        return 50.0D;
    }

    public double getCarbohydrateMedium() {
        /*Amount of Carbohydrate Needed to Appreciably Reduce Ketosis*/
        /*
        * Gamble, James L. "Physiological information gained from studies on the life raft ration." Nutrition Reviews 47.7 (1989): 199-201.
        */
        /*Amount of Carbohydrate Needed to Inhibit Ketosis*/
        /*
        * Flatt, Jean‐Pierre. "Macronutrient composition and food selection." Obesity research 9.S11 (2001): 256S-262S.
        */
        return 100.0D;
    }

    public double getCarbohydrateHigh() {
        /*Amount of Carbohydrate Needed to Inhibit Ketosis*/
        /*
         * Flatt, Jean‐Pierre. "Macronutrient composition and food selection." Obesity research 9.S11 (2001): 256S-262S.
         */
        return 150.0D;
    }
}

