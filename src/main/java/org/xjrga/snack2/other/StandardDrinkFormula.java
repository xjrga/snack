package org.xjrga.snack2.other;

public class StandardDrinkFormula {
    private final Double drinks;

    public StandardDrinkFormula(Double drinks) {
        this.drinks = drinks;
    }

    public Double getGrams() {
        //In the United States, a standard drink contains about 14 grams of alcohol
        return drinks * 14;
    }
}

