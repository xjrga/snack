package io.github.xjrga.snack2.other;

public class CunninghamFormula {
    private final Double weightinlbs;

    public CunninghamFormula(Double weightinlbs) {
        this.weightinlbs = weightinlbs;
    }

    public double getCalories() {
        return 500.0D + (double) (22 * weightinlbs.intValue()) / 2.20462262185D;
    }
}
