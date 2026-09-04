package io.github.xjrga.snack.lp;

import io.github.xjrga.snack.other.U;
import java.math.BigDecimal;
import java.util.Date;

public class LpToCplexExp implements LpTo {

    private final StringBuilder sb;
    private final StringBuilder mixLegend;
    private final StringBuilder foodLegend;
    private final StringBuilder objFunction;
    private final StringBuilder driDevQuantity;
    private final StringBuilder driDevSumQuantity;
    private final StringBuilder nutrientQuantity;
    private final StringBuilder nutrientRatio;
    private final StringBuilder foodQuantity;
    private final StringBuilder foodRatio;
    private final StringBuilder groupQuantity;
    private String model;

    public LpToCplexExp() {
        sb = new StringBuilder();
        mixLegend = new StringBuilder();
        foodLegend = new StringBuilder();
        objFunction = new StringBuilder();
        driDevQuantity = new StringBuilder();
        driDevSumQuantity = new StringBuilder();
        nutrientQuantity = new StringBuilder();
        nutrientRatio = new StringBuilder();
        foodQuantity = new StringBuilder();
        foodRatio = new StringBuilder();
        groupQuantity = new StringBuilder();
        model = "";
        objFunction.append("\n");
        objFunction.append("/* ----- OBJECTIVE FUNCTION ----- */");
        objFunction.append("\n\n");
        driDevQuantity.append("\n");
        driDevQuantity.append("/* ----- NUTRIENT DEFICIENCY AND EXCESS CONSTRAINTS ----- */");
        driDevQuantity.append("\n\n");
        driDevSumQuantity.append("\n");
        driDevSumQuantity.append("/* ----- NUTRIENT AVERAGE DEFICIENCY AND EXCESS CONSTRAINTS ----- */");
        driDevSumQuantity.append("\n\n");
        nutrientQuantity.append("\n");
        nutrientQuantity.append("/* ----- NUTRIENT CONSTRAINTS ----- */");
        nutrientQuantity.append("\n\n");
        nutrientRatio.append("\n");
        nutrientRatio.append("/* ----- NUTRIENT RATIO CONSTRAINTS ----- */");
        nutrientRatio.append("\n\n");
        foodQuantity.append("\n");
        foodQuantity.append("/* ----- FOOD CONSTRAINTS ----- */");
        foodQuantity.append("\n\n");
        foodRatio.append("\n");
        foodRatio.append("/* ----- FOOD RATIO CONSTRAINTS ----- */");
        foodRatio.append("\n\n");
        groupQuantity.append("\n");
        groupQuantity.append("/* ----- GROUP CONSTRAINTS ----- */");
        groupQuantity.append("\n\n");
    }

    @Override
    public String buildModel() {
        sb.setLength(0);
        sb.append(mixLegend);
        sb.append(foodLegend);
        sb.append(objFunction);
        sb.append(driDevQuantity);
        sb.append(driDevSumQuantity);
        sb.append(nutrientQuantity);
        sb.append(nutrientRatio);
        sb.append(foodQuantity);
        sb.append(foodRatio);
        sb.append(groupQuantity);
        sb.append("\n");
        sb.append("/* Model is feasible. A solution exists which satisfies all the constraints. */");
        sb.append("\n");
        return sb.toString();
    }

    @Override
    public void addMixLegend(String mix) {
        String date = U.formatDate(new Date());
        mixLegend.append("/*\n");
        mixLegend.append(String.format(" %1$9s %2$s", "PROBLEM: ", mix));
        mixLegend.append("\n");
        mixLegend.append(String.format(" %1$9s %2$s", "DATE:    ", date));
        mixLegend.append("\n*/");
        mixLegend.append("\n\n");
    }

    @Override
    public void addMixLegend(String mixname, String optionDescription) {
        String date = U.formatDate(new Date());
        mixLegend.append("/*\n");
        mixLegend.append(String.format(" %1$11s %2$s", "PROBLEM:", mixname));
        mixLegend.append("\n");
        mixLegend.append(String.format(" %1$11s %2$s", "DATE:", date));
        mixLegend.append("\n");
        mixLegend.append(optionDescription);
        mixLegend.append("\n*/");
        mixLegend.append("\n\n");
    }

    @Override
    public void addFoodLegend(String legend) {
        foodLegend.append("/*\n");
        foodLegend.append("VARIABLES\n\n");
        foodLegend.append(legend);
        foodLegend.append("\n*/\n");
    }

    @Override
    public void addObjectiveFunction(double[] coefficients, String name) {
        objFunction.append("/* ");
        objFunction.append(name);
        objFunction.append(" */");
        objFunction.append("\n\n");
        objFunction.append("min:");
        objFunction.append("\n");
        StringBuilder isb = new StringBuilder();
        for (int i = 0; i < coefficients.length; i++) {
            double c = coefficients[i];
            String cst = BigDecimal.valueOf(Math.abs(c))
                    .stripTrailingZeros()
                    .toPlainString();
            if (c < 0) {
                isb.append(String.format(" - %1$s x%2$02d", cst, i + 1));
            } else {
                isb.append(String.format(" + %1$s x%2$02d", cst, i + 1));
            }
        }
        String constraint = isb.toString();
        objFunction.append(constraint.replaceFirst("\\+", ""));
        objFunction.append(" ");
        objFunction.append(";");
        objFunction.append("\n");
    }

    @Override
    public void addNutrientDeficiencyAndExcessConstraint(double[] coefficients, int rel, double value, String name) {
        driDevQuantity.append("/* ");
        driDevQuantity.append(name);
        driDevQuantity.append(" */");
        driDevQuantity.append("\n\n");
        setConstraintCoefficients(driDevQuantity, coefficients, rel, value);
    }

    @Override
    public void addNutrientAverageDeficiencyAndExcessConstraint(double[] coefficients, int rel, double value, String name) {
        driDevSumQuantity.append("/* ");
        driDevSumQuantity.append(name);
        driDevSumQuantity.append(" */");
        driDevSumQuantity.append("\n\n");
        setConstraintCoefficients(driDevSumQuantity, coefficients, rel, value);
    }

    @Override
    public void addNutrientConstraint(double[] coefficients, int rel, double value, String name) {
        nutrientQuantity.append("/* ");
        nutrientQuantity.append(name);
        nutrientQuantity.append(" */");
        nutrientQuantity.append("\n\n");
        setConstraintCoefficients(nutrientQuantity, coefficients, rel, value);
    }

    @Override
    public void addNutrientRatioConstraint(double[] coefficients, int rel, double value, String name) {
        nutrientRatio.append("/* ");
        nutrientRatio.append(name);
        nutrientRatio.append(" */");
        nutrientRatio.append("\n\n");
        setConstraintCoefficients(nutrientRatio, coefficients, rel, value);
    }

    @Override
    public void addFoodConstraint(double[] coefficients, int rel, double value, String name) {
        foodQuantity.append("/* ");
        foodQuantity.append(name);
        foodQuantity.append(" */");
        foodQuantity.append("\n\n");
        setConstraintCoefficients(foodQuantity, coefficients, rel, value);
    }

    @Override
    public void addFoodRatioConstraint(double[] coefficients, int rel, double value, String name) {
        foodRatio.append("/* ");
        foodRatio.append(name);
        foodRatio.append(" */");
        foodRatio.append("\n\n");
        setConstraintCoefficients(foodRatio, coefficients, rel, value);
    }

    @Override
    public void addGroupConstraint(double[] coefficients, int rel, double value, String name) {
        groupQuantity.append("/* ");
        groupQuantity.append(name);
        groupQuantity.append(" */");
        groupQuantity.append("\n\n");
        setConstraintCoefficients(groupQuantity, coefficients, rel, value);
    }

    @Override
    public String toString() {
        return buildModel();
    }

    private void setConstraintCoefficients(StringBuilder sb, double[] coefficients, int rel, double b) {
        String bPlain = U.plain(b);
        String relationship = LpText.getCplexRelationship(rel);
        StringBuilder isb = new StringBuilder();
        for (int i = 0; i < coefficients.length; i++) {
            double c = coefficients[i];
            String cst = U.plain(Math.abs(c));
            if (c < 0) {
                isb.append(String.format(" - %s x%02d", cst, i + 1));
            } else {
                isb.append(String.format(" + %s x%02d", cst, i + 1));
            }
        }
        String constraint = isb.toString();
        sb.append(constraint.replaceFirst("\\+", ""));
        sb.append(" ");
        sb.append(String.format("%2s %s", relationship, bPlain));
        sb.append(";");
        sb.append("\n\n");
    }
}
