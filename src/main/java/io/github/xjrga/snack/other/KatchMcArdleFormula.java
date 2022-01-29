package io.github.xjrga.snack.other;

public class KatchMcArdleFormula {

    private final Double weightinlbs;

    public KatchMcArdleFormula(Double weightinlbs) {
        this.weightinlbs = weightinlbs;
    }

    public double getCalories() {
        return 370.0D + 21.6D * (double) weightinlbs.intValue() / 2.20462262185D;
    }
}
