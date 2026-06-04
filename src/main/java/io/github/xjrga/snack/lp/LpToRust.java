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
public class LpToRust implements LpTo {

    private int counter;
    private double[] obj;
    private final List<String> names;
    private final List<double[]> lhs;
    private final List<Integer> relationships;
    private final List<Double> rhs;
    private final List<String> constraintNames;
    private String mixName;
    private String optionDescription;
    private Boolean isFeasible;
    private String[] variables;

    public LpToRust() {
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
        sb.append("use lpsolve::prelude::*;");
        sb.append("\n\n");
        sb.append("fn main() -> Result<()> {");
        sb.append("\n\n");
        String date = Utilities.formatDate(new Date());
        sb.append("// ");
        sb.append(String.format(" %1$11s %2$s", "PROBLEM:", mixName));
        sb.append("\n");
        sb.append("// ");
        sb.append(String.format(" %1$11s %2$s", "DATE:", date));
        sb.append("\n");
        sb.append("// ");
        sb.append(optionDescription);
        sb.append("\n");
        sb.append("// ");
        sb.append("\n\n");
        sb.append("// Variables");
        sb.append("\n");

        for (String s : variables) {
            sb.append("// ");
            sb.append(s);
            sb.append("\n");
        }

        sb.append("\n");
        sb.append("// Constraints");
        sb.append("\n");

        for (int i = 0; i < constraintNames.size(); i++) {
            String name = constraintNames.get(i);
            sb.append("// ");
            sb.append(String.format("%d", i));
            sb.append(") ");
            sb.append(name);
            sb.append("\n");
        }

        sb.append("\n");
        sb.append("// Create problem and assign name");
        sb.append("\n");
        sb.append(" let solution = Problem::builder()");
        sb.append("\n");
        sb.append("        .name(\"");
        sb.append(mixName);
        sb.append("\")?");
        sb.append("\n");
        sb.append("        .cols(");
        sb.append(variables.length);
        sb.append(")");
        sb.append("\n\n");
        sb.append("// Set objective function");
        sb.append("\n");
        sb.append("        .min(&[");

        for (int i = 0; i < obj.length; i++) {
            double d = obj[i];
            sb.append(d);
            sb.append(",");
        }

        sb.setLength(sb.length() - 1);
        sb.append("])");
        sb.append("\n\n");
        sb.append("// Set constraints");
        sb.append("\n");

        for (int i = 0; i < relationships.size(); i++) {
            int r = relationships.get(i);
            sb.append("        ");

            switch (r) {
                case 1 ->
                    sb.append(".ge(&[");
                case 2 ->
                    sb.append(".le(&[");
                case 3 ->
                    sb.append(".eq(&[");
                default ->
                    throw new IllegalStateException("Unexpected value: " + (r));
            };

            double[] arr = lhs.get(i);
            Double d = rhs.get(i);
            String b = BigDecimal.valueOf(d).toPlainString();

            for (int j = 0; j < arr.length; j++) {
                String cst = BigDecimal.valueOf(arr[j]).toPlainString();
                sb.append(cst);
                sb.append(",");
            }

            sb.setLength(sb.length() - 1);
            sb.append("],");
            sb.append(b);
            sb.append(")");
            sb.append("\n");
        }

        sb.append("        .non_negative()");
        sb.append("\n\n");
        sb.append("// Solve");
        sb.append("\n");
        sb.append("        .solve()?;");
        sb.append("\n\n");
        sb.append("""
                  // Calculate total nutrient index
                  let length = solution.variables().expect("").len() as i32;
                  let x: Option<f64> = solution.variable(length - 1);
                  let tni = (1.0 - x.unwrap_or(0.0)) * 100.0;

                  // Print solution
                  //println!("Variables: {:?}", solution.variables());
                  //println!("Status: {:?}", solution.status());
                  println!("");
                  println!("-----------------------------------------------------");
                  println!("Success: the objective function is {}", solution.objective_value());
                  println!("Total Nutrient Index: {:?}", tni);
                  println!("-----------------------------------------------------");
                  println!("");

                  Ok(())
                  }
                  """);
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
