package io.github.xjrga.snack.lp;

import io.github.xjrga.snack.other.Utilities;
import java.util.ArrayList;
import java.util.Collection;
import org.apache.commons.math3.optim.linear.LinearConstraint;

public class CplexPrintOut
        implements PrintOut {
    private final LinearProgram lpmodel;
    private String objectiveFunctionCoefficients;
    private final StringBuilder constraintCoefficients;
    private String model;
    private String title;
    private String date;
    private ArrayList<String> variables;
    private double objectiveFunctionValue;
    public CplexPrintOut( LinearProgram lpmodel ) {
        this.lpmodel = lpmodel;
        this.constraintCoefficients = new StringBuilder();
    }
    @Override
    public void setTitle( String title ) {
        this.title = title;
    }
    @Override
    public void setDate( String date ) {
        this.date = date;
    }
    @Override
    public void setVariables( ArrayList<String> variables ) {
        this.variables = variables;
    }
    @Override
    public void setObjectiveFunctionCoefficients( double[] coefficients ) {
        StringBuilder strb = new StringBuilder();
        for ( int i = 0; i < coefficients.length; i++ ) {
            double c = coefficients[ i ];
            if ( c < 0 ) {
                strb.append( String.format( " - %1$ 35.17f X%2$02d", c, i ) );
            } else {
                strb.append( String.format( " + %1$ 35.17f X%2$02d", Math.abs( c ), i ) );
            }
        }
        objectiveFunctionCoefficients = strb.toString();
    }
    @Override
    public void setConstraintCoefficients( double[] coefficients, int rel, double value ) {
        String relationship = LpUtilities.getRelationship( rel );
        constraintCoefficients.append( "" );
        for ( int i = 0; i < coefficients.length; i++ ) {
            double c = coefficients[ i ];
            if ( c < 0 ) {
                constraintCoefficients.append( String.format( " - %1$ 35.17f X%2$02d", Math.abs( c ), i ) );
            } else {
                constraintCoefficients.append( String.format( " + %1$ 35.17f X%2$02d", c, i ) );
            }
        }
        constraintCoefficients.append( " " );
        constraintCoefficients.append( String.format( "%1$2s %2$ 35.17f", relationship, value ) );
        constraintCoefficients.append( "\n" );
    }
    @Override
    public void setActualValueOfTheObjectiveFunction( double value ) {
        objectiveFunctionValue = value;
    }
    @Override
    public String getInfeasibleModel() {
        StringBuilder strb = new StringBuilder();
        strb.append( getDescription() );
        strb.append( "\n" );
        strb.append( getModel() );
        strb.append( "\n\n" );
        strb.append( "\\Model is infeasible. No solution exists which satisfies all the constraints." );
        strb.append( "\n\n" );
        return strb.toString();
    }
    @Override
    public String getFeasibleModel() {
        StringBuilder strb = new StringBuilder();
        strb.append( getDescription() );
        strb.append( "\n" );
        strb.append( getModel() );
        strb.append( "\n\n" );
        strb.append( getObjectiveFunctionValueStatement() );
        strb.append( "\n\n" );
        strb.append( getActualValuesOfTheVariablesStatement() );
        strb.append( "\n\n" );
        strb.append( getActualValuesOfTheConstraintsStatement() );
        strb.append( "\n" );
        strb.append( "\\Model is feasible. A solution exists which satisfies all the constraints." );
        strb.append( "\n\n" );
        return strb.toString();
    }
    private String getDescription() {
        StringBuilder strb = new StringBuilder();
        strb.append( "\\Title: " );
        strb.append( title );
        strb.append( "\n" );
        strb.append( "\\Date:  " );
        strb.append( date );
        strb.append( "\n\n" );
        strb.append( getVariables() );
        return strb.toString();
    }
    private String getVariables() {
        StringBuilder strb = new StringBuilder();
        variables.forEach( variable -> {
            strb.append( "\\" );
            strb.append( variable );
            strb.append( "\n" );
        } );
        return strb.toString();
    }
    @Override
    public void saveModel() {
        StringBuilder strb = new StringBuilder();
        strb.append( "Minimize" );
        strb.append( "\n" );
        strb.append( objectiveFunctionCoefficients );
        strb.append( "\n" );
        strb.append( "Subject To" );
        strb.append( "\n" );
        strb.append( constraintCoefficients.toString() );
        strb.append( "End" );
        model = strb.toString();
    }
    private String getModel() {
        return model;
    }
    private String getObjectiveFunctionValueStatement() {
        StringBuilder strb = new StringBuilder();
        strb.append( "\\Value of objective function: " );
        strb.append( Utilities.formatDecimal( objectiveFunctionValue ) );
        return strb.toString();
    }
    private String getActualValuesOfTheVariablesStatement() {
        StringBuilder strb = new StringBuilder();
        strb.append( "\\Actual values of the variables:" );
        strb.append( "\n" );
        double[] point = lpmodel.getPoint();
        for ( int i = 0; i < point.length; i++ ) {
            strb.append( String.format( "\\X%1$02d %2$ 35.17f", i, point[ i ] ) );
            strb.append( "\n" );
        }
        strb.setLength( strb.length() - 1 );
        return strb.toString();
    }
    private String getActualValuesOfTheConstraintsStatement() {
        StringBuilder strb = new StringBuilder();
        strb.append( "\\Actual values of the constraints:" );
        strb.append( "\n" );
        Collection<LinearConstraint> cs = lpmodel.getConstraints();
        int i = 1;
        for ( LinearConstraint lc : cs ) {
            double actual = Utilities.calculateDotProduct( lc.getCoefficients(), lpmodel.getPoint() );
            boolean is_binding = Utilities.isDoubleEqual( lc.getValue(), actual );
            strb.append( String.format( "\\R%1$02d %2$ 35.17f", i, actual ) );
            if ( is_binding ) {
                strb.append( ", binding" );
            }
            strb.append( "\n" );
            i++;
        }
        return strb.toString();
    }
}
