package io.github.xjrga.snack.lp;

import io.github.xjrga.snack.dataobject.FoodDataObject;
import java.util.ArrayList;
import java.util.Iterator;

public class PrintOutSelector {
    private final LpsolvePrintOut lpsolve;
    private final CplexPrintOut cplex;
    private boolean lpsolveSelect;
    private boolean cplexSelect;
    public PrintOutSelector( LinearProgram lpmodel ) {
        lpsolve = new LpsolvePrintOut( lpmodel );
        cplex = new CplexPrintOut( lpmodel );
        lpsolveSelect = false;
        cplexSelect = false;
    }
    public void setActualValueOfTheObjectiveFunction( double value ) {
        lpsolve.setActualValueOfTheObjectiveFunction( value );
        cplex.setActualValueOfTheObjectiveFunction( value );
    }
    public void addObjectiveFunction( double[] coefficients ) {
        lpsolve.setObjectiveFunctionCoefficients( coefficients );
        cplex.setObjectiveFunctionCoefficients( coefficients );
    }
    public void addConstraint( double[] coefficients, int rel, double value ) {
        lpsolve.setConstraintCoefficients( coefficients, rel, value );
        cplex.setConstraintCoefficients( coefficients, rel, value );
    }
    public void saveModel() {
        lpsolve.saveModel();
        cplex.saveModel();
    }
    public void setTitle( String title ) {
        lpsolve.setTitle( title );
        cplex.setTitle( title );
    }
    public void setDate( String date ) {
        lpsolve.setDate( date );
        cplex.setDate( date );
    }
    public void setVariables( Iterator it ) {
        ArrayList<String> variables = new ArrayList();
        int i = 0;
        while ( it.hasNext() ) {
            FoodDataObject next = ( FoodDataObject ) it.next();
            variables.add( String.format( "X%1$02d %2$s", i, next.getFoodName() ) );
            i++;
        }
        lpsolve.setVariables( variables );
        cplex.setVariables( variables );
    }
    public String getInfeasibleModel() {
        StringBuilder sb = new StringBuilder();
        if ( lpsolveSelect ) {
            sb.append( lpsolve.getInfeasibleModel() );
        }
        if ( lpsolveSelect && cplexSelect ) {
            sb.append( "\n\n" );
        }
        if ( cplexSelect ) {
            sb.append( cplex.getInfeasibleModel() );
        }
        return sb.toString();
    }
    public String getFeasibleModel() {
        StringBuilder sb = new StringBuilder();
        if ( lpsolveSelect ) {
            sb.append( lpsolve.getFeasibleModel() );
        }
        if ( lpsolveSelect && cplexSelect ) {
            sb.append( "\n\n" );
        }
        if ( cplexSelect ) {
            sb.append( cplex.getFeasibleModel() );
        }
        return sb.toString();
    }
    public void selectCplex() {
        cplexSelect = true;
    }
    public void selectLpsolve() {
        lpsolveSelect = true;
    }
    public String getLpsolveFeasibleModel() {
        return lpsolve.getFeasibleModel();
    }
    public String getCplexFeasibleModel() {
        return cplex.getFeasibleModel();
    }
}
