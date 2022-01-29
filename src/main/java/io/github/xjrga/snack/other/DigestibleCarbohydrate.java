package io.github.xjrga.snack.other;

public class DigestibleCarbohydrate {

    private final Double totalCarbohydrate;
    private final Double totalFiber;
    private Double digestibleCarbs;

    public DigestibleCarbohydrate(Double totalCarbohydrate, Double totalFiber) {
        this.totalCarbohydrate = totalCarbohydrate;
        this.totalFiber = totalFiber;
    }

    public double getDigestibleCarbohydrate() {
        digestibleCarbs = totalCarbohydrate - totalFiber;
        return digestibleCarbs;
    }
}
