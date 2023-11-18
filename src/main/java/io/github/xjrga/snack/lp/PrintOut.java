package io.github.xjrga.snack.lp;

import java.util.ArrayList;

public interface PrintOut {
    void setTitle( String title );
    void setDate( String date );
    void setVariables( ArrayList<String> variables );
    void setObjectiveFunctionCoefficients( double[] coefficients );
    void setConstraintCoefficients( double[] coefficients, int rel, double value );
    void saveModel();
    void setActualValueOfTheObjectiveFunction( double value );
    String getInfeasibleModel();
    String getFeasibleModel();
}
