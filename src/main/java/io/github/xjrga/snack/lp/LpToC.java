package io.github.xjrga.snack.lp;

import io.github.xjrga.snack.other.Utilities;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author jr
 */
public class LpToC implements LpTo {

    private int counter;
    private double[] obj;
    private final List<String> names;
    private final List<double[]> lhs;
    private final List<Integer> relationships;
    private final List<Double> rhs;
    private String mixName;
    private String optionDescription;
    private String[] variables;
    private final List<String> constraints;

    public LpToC() {
        obj = new double[]{};
        names = new ArrayList<>();
        lhs = new ArrayList<>();
        relationships = new ArrayList<>();
        rhs = new ArrayList<>();
        constraints = new ArrayList<>();
    }

    @Override
    public String toString() {
        return buildModel();
    }

    @Override
    public String buildModel() {
        StringBuilder sb = new StringBuilder();
        sb.append("""
                  #include "lp_lib.h"
                  #include <stdio.h>
                  #include <stdlib.h>

                  int main() {
                  """);
        sb.append("\n");
        String date = Utilities.formatDate(new Date());
        sb.append("  // clang-format off");
        sb.append("\n");
        sb.append("  // ");
        sb.append(String.format(" %1$11s %2$s", "PROBLEM:", mixName));
        sb.append("\n");
        sb.append("  // ");
        sb.append(String.format(" %1$11s %2$s", "DATE:", date));
        sb.append("\n");
        sb.append("  // ");
        sb.append(optionDescription);
        sb.append("\n");
        sb.append("  // ");
        sb.append("\n\n");
        sb.append("  // Variables");
        sb.append("\n");

        for (String s : variables) {
            sb.append("  // ");
            sb.append(s);
            sb.append("\n");
        }

        sb.append("\n");
        sb.append("  // Constraints");
        sb.append("\n");

        for (int i = 0; i < constraints.size(); i++) {
            String name = constraints.get(i);
            sb.append("  // ");
            sb.append(String.format("%d", i));
            sb.append(") ");
            sb.append(name);
            sb.append("\n");
        }

        sb.append("  // clang-format on");
        sb.append("\n\n");
        sb.append("  // Create problem");
        sb.append("\n");
        sb.append("  lprec *lp = make_lp(0, ");
        sb.append(variables.length);
        sb.append(");");
        sb.append("\n\n");

        sb.append("  // Name problem");
        sb.append("\n");
        sb.append("  set_lp_name(lp, \"");
        sb.append(mixName);
        sb.append("\");");
        sb.append("\n\n");
        sb.append("  // Variables");
        sb.append("\n");

        for (int i = 0; i < variables.length; i++) {
            sb.append("  // ");
            sb.append(variables[i]);
            sb.append("\n");
            sb.append("  set_col_name(lp, ");
            sb.append(i + 1);
            sb.append(", ");
            sb.append("\"");
            sb.append("x");
            sb.append(i + 1);
            sb.append("\");");
            sb.append("\n");
        }

        sb.append("\n");
        sb.append("  // Objective function");
        sb.append("\n");
        sb.append("  double row[");
        sb.append(variables.length);
        sb.append("];");
        sb.append("\n");

        for (int i = 0; i < obj.length; i++) {
            double d = obj[i];
            sb.append("  row[");
            sb.append(i + 1);
            sb.append("] = ");
            sb.append(d);
            sb.append(";");
            sb.append("\n");
        }

        sb.append("  set_obj_fn(lp, row);");
        sb.append("\n\n");
        sb.append("  // ");
        sb.append("Minimize nutrient deficiency and excess");
        sb.append("\n");
        sb.append("  set_minim(lp);");
        sb.append("\n\n");
        sb.append("  // Constraints");
        sb.append("\n");

        for (int i = 0; i < relationships.size(); i++) {
            double[] arrc = lhs.get(i);
            String b = BigDecimal.valueOf(rhs.get(i)).toPlainString();
            sb.append("  // ");
            sb.append(constraints.get(i));
            sb.append("\n");

            for (int j = 0; j < arrc.length; j++) {
                String c = BigDecimal.valueOf(arrc[j]).toPlainString();
                sb.append("  row[");
                sb.append(j + 1);
                sb.append("] = ");
                sb.append(c);
                sb.append(";");
                sb.append("\n");
            }

            int r = relationships.get(i);
            sb.append("  add_constraint(lp, row, ");

            switch (r) {
                case 1 ->
                    sb.append("GE");
                case 2 ->
                    sb.append("LE");
                case 3 ->
                    sb.append("EQ");
                default ->
                    throw new IllegalStateException("Unexpected value: " + (r));
            };

            sb.append(", ");
            sb.append(b);
            sb.append(");");
            sb.append("\n\n");
        }

        sb.append("  // Solve");
        sb.append("\n");
        sb.append("  write_LP(lp, stdout);");
        sb.append("\n");
        sb.append("  int result = solve(lp);");
        sb.append("\n\n");
        sb.append("""
                    // Print
                    if (result == OPTIMAL) {
                  """);
        sb.append("    double variables[");
        sb.append(variables.length);
        sb.append("];");
        sb.append("\n");
        sb.append("    get_variables(lp, variables);");
        sb.append("\n");
        sb.append("    printf(\"Variable Values:\\n\");");
        sb.append("\n");

        for (int i = 0; i < obj.length; i++) {
            double d = obj[i];
            sb.append("    printf(\"  x");
            sb.append(i + 1);
            sb.append("= %f\\n\", variables[");
            sb.append(i);
            sb.append("]);");
            sb.append("\n");
        }

        sb.append("""
                      printf("\\n", "");
                      int index = sizeof(variables) / sizeof(variables[0]) - 2;
                      double tni = (1.0 - variables[index]) * 100.0;
                      printf("---------------------------------------------\\n", "");
                      printf("Success: the objective function is : %f\\n", get_objective(lp));
                      printf("Total Nutrient Index: %f\\n", tni);
                      printf("---------------------------------------------\\n", "");
                      printf("\\n", "");
                  """);
        sb.append("""
                    } else {
                       printf("Model is infeasible. No solution exists which satisfies all the constraints. %d\\n", result);
                    }
                  """);

        sb.append("\n");
        sb.append("""
                    delete_lp(lp);
                    return 0;
                  }""");
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
        constraints.add(name);
        counter++;
    }


    /* NUTRIENT AVERAGE DEFICIENCY AND EXCESS CONSTRAINTS */
    @Override
    public void addNutrientAverageDeficiencyAndExcessConstraint(double[] coefficients, int rel, double value, String name) {
        lhs.add(coefficients);
        relationships.add(rel);
        rhs.add(value);
        constraints.add(name);
        counter++;
    }


    /* NUTRIENT CONSTRAINTS */
    @Override
    public void addNutrientConstraint(double[] coefficients, int rel, double value, String name) {
        lhs.add(coefficients);
        relationships.add(rel);
        rhs.add(value);
        constraints.add(name);
        counter++;
    }


    /* NUTRIENT RATIO CONSTRAINTS */
    @Override
    public void addNutrientRatioConstraint(double[] coefficients, int rel, double value, String name) {
        lhs.add(coefficients);
        relationships.add(rel);
        rhs.add(value);
        constraints.add(name);
        counter++;
    }


    /* FOOD CONSTRAINTS */
    @Override
    public void addFoodConstraint(double[] coefficients, int rel, double value, String name) {
        lhs.add(coefficients);
        relationships.add(rel);
        rhs.add(value);
        constraints.add(name);
        counter++;
    }


    /* FOOD RATIO CONSTRAINTS */
    @Override
    public void addFoodRatioConstraint(double[] coefficients, int rel, double value, String name) {
        lhs.add(coefficients);
        relationships.add(rel);
        rhs.add(value);
        constraints.add(name);
        counter++;
    }


    /* GROUP CONSTRAINTS */
    @Override
    public void addGroupConstraint(double[] coefficients, int rel, double value, String name) {
        lhs.add(coefficients);
        relationships.add(rel);
        rhs.add(value);
        constraints.add(name);
        counter++;
    }

    @Override
    public void addFoodLegend(String legend) {
        variables = legend.split("\n");
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
