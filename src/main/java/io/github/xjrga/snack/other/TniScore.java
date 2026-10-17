package io.github.xjrga.snack.other;

import java.math.BigDecimal;
import java.math.MathContext;

/**
 *
 * @author jr
 */
public class TniScore {

    private double tniScore = 0;

    public TniScore(double[] solutionPoint) {
        double[] rda = new double[8];
        //choline
        rda[0] = 550.0;
        //vitC
        rda[1] = 90.0;
        //vitD
        rda[2] = 15.0;
        //vitE
        rda[3] = 15.0;
        //vitA
        rda[4] = 900.0;
        //potassium
        rda[5] = 3400.0;
        //magnesium
        rda[6] = 420.0;
        //calcium
        rda[7] = 1000.0;

        double choline = solutionPoint[solutionPoint.length - 12];
        double vitC = solutionPoint[solutionPoint.length - 13];
        double vitD = solutionPoint[solutionPoint.length - 14];
        double vitE = solutionPoint[solutionPoint.length - 15];
        double vitA = solutionPoint[solutionPoint.length - 16];
        double potassium = solutionPoint[solutionPoint.length - 18];
        double magnesium = solutionPoint[solutionPoint.length - 19];
        double calcium = solutionPoint[solutionPoint.length - 20];

        double cholineDri = rda[0];
        double vitCDri = rda[1];
        double vitDDri = rda[2];
        double vitEDri = rda[3];
        double vitADri = rda[4];
        double potassiumDri = rda[5];
        double magnesiumDri = rda[6];
        double calciumDri = rda[7];

        double cholinePct = choline / cholineDri;
        double vitCPct = vitC / vitCDri;
        double vitDPct = vitD / vitDDri;
        double vitEPct = vitE / vitEDri;
        double vitAPct = vitA / vitADri;
        double potassiumPct = potassium / potassiumDri;
        double magnesiumPct = magnesium / magnesiumDri;
        double calciumPct = calcium / calciumDri;

        double totalPct = cholinePct + vitCPct + vitDPct + vitEPct + vitAPct + potassiumPct + magnesiumPct + calciumPct;
        tniScore = (1 - totalPct / 8) * 100.0;

//        System.out.println("******************************");
//        System.out.println("choline: " + choline + " / " + cholineDri);
//        System.out.println("vitC: " + vitC + " / " + vitCDri);
//        System.out.println("vitD: " + vitD + " / " + vitDDri);
//        System.out.println("vitE: " + vitE + " / " + vitEDri);
//        System.out.println("vitA: " + vitA + " / " + vitADri);
//        System.out.println("potassium: " + potassium + " / " + potassiumDri);
//        System.out.println("magnesium: " + magnesium + " / " + magnesiumDri);
//        System.out.println("calcium: " + calcium + " / " + calciumDri);
//
//        System.out.println("tniScore: " + tniScore);
//        System.out.println("******************************");
//        System.out.println("");
//        System.out.println("");
    }

    public Double getDoubleValue() {
        return new BigDecimal(tniScore, MathContext.DECIMAL128).doubleValue();
    }

    public BigDecimal get() {
        return new BigDecimal(tniScore, MathContext.DECIMAL128);
    }

}
