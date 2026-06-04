package io.github.xjrga.snack.lp;

/**
 *
 * @author jr
 */
public interface LpTo {

    void addNutrientDeficiencyAndExcessConstraint(double[] coefficients, int rel, double value, String name);

    void addNutrientAverageDeficiencyAndExcessConstraint(double[] coefficients, int rel, double value, String name);

    void addFoodConstraint(double[] coefficients, int rel, double value, String name);

    void addFoodLegend(String legend);

    void addFoodRatioConstraint(double[] coefficients, int rel, double value, String name);

    void addGroupConstraint(double[] coefficients, int rel, double value, String name);

    void addMixLegend(String mix);

    void addMixLegend(String mixname, String optionDescription);

    void addNutrientConstraint(double[] coefficients, int rel, double value, String name);

    void addNutrientRatioConstraint(double[] coefficients, int rel, double value, String name);

    void addObjectiveFunction(double[] coefficients, String name);

    String buildModel();
}
