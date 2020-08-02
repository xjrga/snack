package org.xjrga.snack2.other;

public class AlcoholByVolumeFormula {
    private final Double milliliter;
    private final Double alcohol_by_volume;
    private final Double VOLUMETRIC_MASS_DENSITY = 789.24; //789.24 g/L

    public AlcoholByVolumeFormula(Double milliliter, Double alcohol_by_volume) {
        this.milliliter = milliliter;
        this.alcohol_by_volume = alcohol_by_volume;
    }

    public Double getStandardDrinks() {
        //In the United States, a standard drink contains about 14 grams of alcohol
        return getGrams() / 14;
    }

    public Double getGrams() {
        return milliliter / 1000 * (alcohol_by_volume / 100 * VOLUMETRIC_MASS_DENSITY);
    }
}
