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
public class LpToJava implements LpTo {

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

    public LpToJava() {
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
        sb.append("""
                   import java.util.ArrayList;
                   import org.apache.commons.math3.optim.PointValuePair;
                   import org.apache.commons.math3.optim.linear.LinearConstraint;
                   import org.apache.commons.math3.optim.linear.LinearConstraintSet;
                   import org.apache.commons.math3.optim.linear.LinearObjectiveFunction;
                   import org.apache.commons.math3.optim.linear.NonNegativeConstraint;
                   import org.apache.commons.math3.optim.linear.Relationship;
                   import org.apache.commons.math3.optim.linear.SimplexSolver;
                   import org.apache.commons.math3.optim.nonlinear.scalar.GoalType;

                   public class TestSnack {

                      public TestSnack() {

                   """);
        String date = U.formatDate(new Date());
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
        sb.append("// Objective Function coefficients");
        sb.append("\n");
        sb.append("double[] coefficients = new double[]{");

        for (int i = 0; i < obj.length; i++) {
            double d = obj[i];
            sb.append(d);
            sb.append(",");
        }

        sb.setLength(sb.length() - 1);
        sb.append("};");
        sb.append("\n\n");
        sb.append("// Constraint coefficients");
        sb.append("\n");

        for (int i = 0; i < lhs.size(); i++) {
            double[] arr = lhs.get(i);
            sb.append("double[] c");
            sb.append(i);
            sb.append(" = ");
            sb.append("new double[]{");

            for (int j = 0; j < arr.length; j++) {
                String cst = BigDecimal.valueOf(arr[j]).stripTrailingZeros().toPlainString();
                sb.append(cst);
                sb.append(",");
            }

            sb.setLength(sb.length() - 1);
            sb.append("};");
            sb.append("\n");
        }

        sb.append("\n");
        sb.append("// Constraint values");
        sb.append("\n");

        for (int i = 0; i < rhs.size(); i++) {
            Double d = rhs.get(i);
            String b = BigDecimal.valueOf(d).stripTrailingZeros().toPlainString();
            sb.append("double ");
            sb.append("b");
            sb.append(i);
            sb.append(" = ");
            sb.append(b);
            sb.append(";");
            sb.append("\n");
        }

        sb.append("\n");
        sb.append("// Relationships");
        sb.append("\n");

        for (int i = 0; i < relationships.size(); i++) {
            int r = relationships.get(i);

            String relstr = switch (r) {
                case 1 ->
                    "Relationship.GEQ";
                case 2 ->
                    "Relationship.LEQ";
                case 3 ->
                    "Relationship.EQ";
                default ->
                    throw new IllegalStateException("Unexpected value: " + (r));
            };

            sb.append("Relationship r");
            sb.append(i);
            sb.append(" = ");
            sb.append(relstr);
            sb.append(";");
            sb.append("\n");
        }

        sb.append("\n");
        sb.append("// Objective Function");
        sb.append("\n");
        sb.append("LinearObjectiveFunction f = new LinearObjectiveFunction(coefficients, 0);");
        sb.append("\n\n");
        sb.append("// Constraints");
        sb.append("\n");
        sb.append("ArrayList<LinearConstraint> constraints = new ArrayList<>();");
        sb.append("\n");

        for (int i = 0; i < rhs.size(); i++) {
            sb.append("// ");
            sb.append(constraintNames.get(i));
            sb.append("\n");
            sb.append("LinearConstraint ");
            sb.append("lc");
            sb.append(i);
            sb.append(" = new LinearConstraint(");
            sb.append("c");
            sb.append(i);
            sb.append(",");
            sb.append("r");
            sb.append(i);
            sb.append(",");
            sb.append("b");
            sb.append(i);
            sb.append(");");
            sb.append("\n");
            sb.append("constraints.add(");
            sb.append("lc");
            sb.append(i);
            sb.append(");");
            sb.append("\n");
        }

        sb.append("\n");
        sb.append("""
                  // Solve
                          SimplexSolver solver = new SimplexSolver();
                          PointValuePair solution
                                  = solver.optimize(f,
                                          new LinearConstraintSet(constraints),
                                          GoalType.MINIMIZE,
                                          new NonNegativeConstraint(true)
                                  );
                          double cost = solution.getSecond();
                          double[] point = solution.getPoint();

                  // Print
                          StringBuilder sb = new StringBuilder();
                          sb.append("\\n");
                          sb.append("// Solution Point");
                          sb.append("\\n");
                          for (int i = 0; i < point.length; i++) {
                              double v = point[i];
                              sb.append("point[");
                              sb.append(i);
                              sb.append("]: ");
                              sb.append(v);
                              sb.append("\\n");
                          }
                          double tni = 1.0 - point[point.length - 2];
                          sb.append("\\n");
                          sb.append("------------------------------------------------------");
                          sb.append("\\n");
                          sb.append("Success: the objective function is ");
                          sb.append(cost);
                          sb.append("\\n");
                          sb.append("Total Nutrient Index: ");
                          sb.append(tni * 100);
                          sb.append("\\n");
                          sb.append("------------------------------------------------------");
                          sb.append("\\n");
                          System.out.println(sb.toString());
                  """);
        sb.append("\n");
        sb.append("""
                     }
                    public static void main(String[] args) {
                        TestSnack test = new TestSnack();
                    }
                  }
                  """);
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
