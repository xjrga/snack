package io.github.xjrga.snack.lp;

import io.github.xjrga.snack.other.U;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author jr
 */
public class LpToR implements LpTo {

    private int counter;
    private double[] obj;
    private final List<String> names;
    private final List<double[]> lhs;
    private final List<Integer> relationships;
    private final List<Double> rhs;
    private final List<String> constraintNames;
    private String mixName;
    private String optionDescription;
    private String foodLegend;
    private Boolean isFeasible;

    public LpToR() {
        obj = new double[]{};
        names = new ArrayList<>();
        lhs = new ArrayList<>();
        relationships = new ArrayList<>();
        rhs = new ArrayList<>();
        constraintNames = new ArrayList<>();
    }

    @Override
    public String toString() {
        return buildModel();
    }

    @Override
    public String buildModel() {
        StringBuilder sb = new StringBuilder();
        String date = U.formatDate(new Date());
        sb.append("library(lpSolve)");
        sb.append("\n");
        sb.append("\n");
        sb.append("#");
        sb.append(String.format(" %1$11s %2$s", "PROBLEM:", mixName));
        sb.append("\n");
        sb.append("#");
        sb.append(String.format(" %1$11s %2$s", "DATE:", date));
        sb.append("\n");
        sb.append("#");
        sb.append(optionDescription);
        sb.append("\n\n");
        sb.append("# Set objective coefficients");
        sb.append("\n");
        sb.append("obj <- c(");

        for (int i = 0; i < obj.length; i++) {
            double d = obj[i];
            sb.append(d);
            sb.append(",");
        }

        sb.setLength(sb.length() - 1);
        sb.append(")");
        sb.append("\n\n");
        sb.append("# Assign variable names");
        sb.append("\n");
        String[] split = foodLegend.split("\n");
        sb.append("names(obj) <- c(");

        for (String s : split) {
            sb.append("\"");
            sb.append(s);
            sb.append("\"");
            sb.append(",");
        }

        sb.setLength(sb.length() - 1);
        sb.append(")");
        sb.append("\n\n");
        sb.append("# Set constraint coefficients");
        sb.append("\n");
        sb.append("lhs <- matrix(c(");
        sb.append("\n");

        for (double[] arr : lhs) {
            for (int i = 0; i < arr.length; i++) {
                String cst = BigDecimal.valueOf(arr[i]).stripTrailingZeros().toPlainString();
                sb.append(cst);
                sb.append(",");
            }
            sb.append("\n");
        }

        sb.setLength(sb.length() - 2);
        sb.append("\n");
        sb.append("), nrow = ");
        sb.append(counter);
        sb.append(", byrow = TRUE)");
        sb.append("\n\n");
        sb.append("# Assign variable names");
        sb.append("\n");
        sb.append("colnames(lhs) <- names(obj)");
        sb.append("\n\n");
        sb.append("# Assign constraint names");
        sb.append("\n");
        sb.append("rownames(lhs) <- c(");

        for (String name : constraintNames) {
            sb.append("\"");
            sb.append(name);
            sb.append("\"");
            sb.append(",");
        }

        sb.setLength(sb.length() - 1);
        sb.append(")");
        sb.append("\n\n");
        sb.append("# Set rhs values");
        sb.append("\n");
        sb.append("rhs <- c(");

        for (Double r : rhs) {
            String cst = BigDecimal.valueOf(r).stripTrailingZeros().toPlainString();
            sb.append(cst);
            sb.append(",");
        }

        sb.setLength(sb.length() - 1);
        sb.append(")");
        sb.append("\n\n");
        sb.append("# Assign constraint names");
        sb.append("\n");
        sb.append("names(rhs) <- rownames(lhs)");
        sb.append("\n\n");
        sb.append("# Set relationships");
        sb.append("\n");
        sb.append("rel <- c(");

        for (Integer relationship : relationships) {
            sb.append(LpText.getRustRelationship(relationship));
            sb.append(",");
        }

        sb.setLength(sb.length() - 1);
        sb.append(")");
        sb.append("\n\n");
        sb.append("# Assign constraint names");
        sb.append("\n");
        sb.append("names(rel) <- rownames(lhs)");
        sb.append("\n\n");
        sb.append("# Solve");
        sb.append("\n");
        sb.append("result <- lp(\"min\", obj, lhs, rel, rhs)");
        sb.append("\n");
        sb.append("point <- result$solution");
        sb.append("\n\n");
        sb.append("# Calculate total nutrient index");
        sb.append("\n");
        sb.append("tni <- (1 - point[length(point)-1]) * 100");
        sb.append("\n\n");
        sb.append("# Assign variable names");
        sb.append("\n");
        sb.append("names(point) <- names(obj)");
        sb.append("\n");
        sb.append("names(tni) <- c(\"Total Nutrient Index\")");
        sb.append("\n\n");
        sb.append("# Print results");
        sb.append("\n");
        sb.append("#print(obj)");
        sb.append("\n");
        sb.append("#print(lhs)");
        sb.append("\n");
        sb.append("#print(rel)");
        sb.append("\n");
        sb.append("#print(rhs)");
        sb.append("\n");
        sb.append("print(point)");
        sb.append("\n");
        sb.append("print(result)");
        sb.append("\n");
        sb.append("print(tni)");
        sb.append("\n");
        return sb.toString();
    }

    /* OBJECTIVE FUNCTION */
    @Override
    public void addObjectiveFunction(double[] coefficients, String name) {
        obj = coefficients;
        names.add(name);
    }

    /*  NUTRIENT DEFICIENCY AND EXCESS CONSTRAINTS  */
    @Override
    public void addNutrientDeficiencyAndExcessConstraint(double[] coefficients, int rel, double value, String name) {
        lhs.add(coefficients);
        relationships.add(rel);
        rhs.add(value);
        constraintNames.add(name);
        counter++;
    }


    /* NUTRIENT AVERAGE DEFICIENCY AND EXCESS CONSTRAINTS */
    @Override
    public void addNutrientAverageDeficiencyAndExcessConstraint(double[] coefficients, int rel, double value, String name) {
        lhs.add(coefficients);
        relationships.add(rel);
        rhs.add(value);
        constraintNames.add(name);
        counter++;
    }


    /* NUTRIENT CONSTRAINTS */
    @Override
    public void addNutrientConstraint(double[] coefficients, int rel, double value, String name) {
        lhs.add(coefficients);
        relationships.add(rel);
        rhs.add(value);
        constraintNames.add(name);
        counter++;
    }


    /* NUTRIENT RATIO CONSTRAINTS */
    @Override
    public void addNutrientRatioConstraint(double[] coefficients, int rel, double value, String name) {
        lhs.add(coefficients);
        relationships.add(rel);
        rhs.add(value);
        constraintNames.add(name);
        counter++;
    }


    /* FOOD CONSTRAINTS */
    @Override
    public void addFoodConstraint(double[] coefficients, int rel, double value, String name) {
        lhs.add(coefficients);
        relationships.add(rel);
        rhs.add(value);
        constraintNames.add(name);
        counter++;
    }


    /* FOOD RATIO CONSTRAINTS */
    @Override
    public void addFoodRatioConstraint(double[] coefficients, int rel, double value, String name) {
        lhs.add(coefficients);
        relationships.add(rel);
        rhs.add(value);
        constraintNames.add(name);
        counter++;
    }


    /* GROUP CONSTRAINTS */
    @Override
    public void addGroupConstraint(double[] coefficients, int rel, double value, String name) {
        lhs.add(coefficients);
        relationships.add(rel);
        rhs.add(value);
        constraintNames.add(name);
        counter++;
    }

    @Override
    public void addFoodLegend(String legend) {
        foodLegend = legend;
    }

    @Override
    public void addMixLegend(String mixName) {
        this.mixName = mixName;
    }

    @Override
    public void addMixLegend(String mixName, String optionDescription) {
        this.mixName = mixName;
        this.optionDescription = optionDescription;
    }
}
