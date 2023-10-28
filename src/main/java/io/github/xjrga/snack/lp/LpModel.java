/*
 * Snack: Learning Software for Nutrition
 * Copyright (C) 2018 Jorge R Garcia de Alba
 * License: http://www.gnu.org/licenses/gpl.html GPL version 2 or higher
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */
package io.github.xjrga.snack.lp;

import com.jgoodies.forms.layout.CellConstraints;
import io.github.xjrga.snack.gui.Message;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import javax.swing.*;
import org.apache.commons.math3.linear.ArrayRealVector;
import org.apache.commons.math3.linear.RealVector;
import org.apache.commons.math3.optim.PointValuePair;
import org.apache.commons.math3.optim.linear.*;
import org.apache.commons.math3.optim.nonlinear.scalar.GoalType;
import org.apache.commons.math3.util.Precision;

/*
 * @author  Jorge R Garcia de Alba
 */
public class LpModel {
    public static final int GEQ = 1;
    public static final int LEQ = 2;
    public static final int EQ = 3;
    private final ArrayList constraints;
    private final LpFormat lp;
    private LinearObjectiveFunction linearObjectiveFunction;
    private double[] point;
    private double cost;
    private String title;
    private String date;
    private String variables;
    private String value_of_objective_function;
    private String actual_values_of_the_variables;
    private final CellConstraints cc = new CellConstraints();
    private JTabbedPane component;
    private LinearConstraintSet linearConstraintSet;
    private HashMap<String, String> map = new HashMap();
    public LpModel() {
        constraints = new ArrayList();
        lp = new LpFormat();
    }
    public void addObjective( double[] coefficients ) {
        byte constantTerm = 0;
        //Objective function
        linearObjectiveFunction = new LinearObjectiveFunction( coefficients, constantTerm );
        lp.objectiveToLp( coefficients );
    }
    public void addConstraint( double[] coefficients, int rel, double amount ) {
        Relationship relationship = null;
        switch ( rel ) {
            case LpModel.GEQ:
                relationship = Relationship.GEQ;
                break;
            case LpModel.LEQ:
                relationship = Relationship.LEQ;
                break;
            case LpModel.EQ:
                relationship = Relationship.EQ;
                break;
            default:
                relationship = Relationship.GEQ;
                break;
        }
        //Linear Constraint
        LinearConstraint c = new LinearConstraint( coefficients, relationship, amount );
        constraints.add( c );
        map.put( c.toString(), lp.generate_constraint_name( coefficients, rel, amount ) );
        lp.constraintToLp( coefficients, rel, amount );
    }
    public boolean solve() {
        boolean flag = false;
        try {
            //Constraint Set
            linearConstraintSet = new LinearConstraintSet( constraints );
            //Solution
            if ( !linearConstraintSet.getConstraints().isEmpty() ) {
                GoalType minimize = GoalType.MINIMIZE;
                NonNegativeConstraint nonNegativeConstraint = new NonNegativeConstraint( true );
                PointValuePair solution = (new SimplexSolver()).optimize( linearObjectiveFunction, linearConstraintSet, minimize, nonNegativeConstraint );
                point = solution.getPoint();
                cost = solution.getSecond();
                flag = true;
            }
        } catch ( Exception e ) {
            JComponent[] inputs = new JComponent[] {
                component
            };
            Message.showMessage( inputs, "No Feasible Solution" );
        }
        return flag;
    }
    public double[] getPoint() {
        return point;
    }
    public double getCost() {
        return cost;
    }
    public String getTitle() {
        StringBuilder sb = new StringBuilder();
        sb.append( "Title: " );
        sb.append( title );
        return sb.toString();
    }
    public void setTitle( String title ) {
        this.title = title;
    }
    public String getDate() {
        StringBuilder sb = new StringBuilder();
        sb.append( "Date: " );
        sb.append( date );
        return sb.toString();
    }
    public void setDate( String date ) {
        this.date = date;
    }
    public String getVariables() {
        StringBuilder sb = new StringBuilder();
        sb.append( "Variables" );
        sb.append( "\n" );
        sb.append( variables );
        return sb.toString();
    }
    public void setVariables( String legend ) {
        this.variables = legend;
    }
    public String get_description() {
        StringBuilder sb = new StringBuilder();
        sb.append( getTitle() );
        sb.append( "\n" );
        sb.append( getDate() );
        sb.append( "\n\n" );
        sb.append( getVariables() );
        return sb.toString();
    }
    public String get_model() {
        return lp.getModel();
    }
    public String get_actual_values_of_the_variables() {
        StringBuilder sb = new StringBuilder();
        sb.append( actual_values_of_the_variables );
        return sb.toString();
    }
    public void set_actual_values_of_the_variables( String txt ) {
        this.actual_values_of_the_variables = txt;
    }
    public String value_of_objective_function() {
        StringBuilder sb = new StringBuilder();
        sb.append( value_of_objective_function );
        return sb.toString();
    }
    public void set_value_of_objective_function( String txt ) {
        this.value_of_objective_function = txt;
    }
    public String get_infeasible_message() {
        return "Model is infeasible. No solution exists which satisfies all the constraints.";
    }
    public String get_feasible_message() {
        return "Model is feasible. A solution exists which satisfies all the constraints.";
    }
    public void setComponent( JTabbedPane component ) {
        this.component = component;
    }
    private double get_actual_value_of_constraint( RealVector v, double[] point ) {
        ArrayRealVector rvpoint = new ArrayRealVector( point );
        return v.dotProduct( rvpoint );
    }
    private boolean get_constraint_binding_status( double value, double dot_product ) {
        boolean flag = false;
        double epsilon = 0.000001d;
        if ( Precision.equals( value, dot_product, epsilon ) ) {
            flag = true;
        }
        return flag;
    }
    public String get_actual_values_of_the_constraints() {
        StringBuilder sb = new StringBuilder();
        sb.append( "Actual values of the constraints:" );
        sb.append( "\n" );
        Collection<LinearConstraint> cs = linearConstraintSet.getConstraints();
        int i = 1;
        for ( LinearConstraint lc : cs ) {
            double actual = get_actual_value_of_constraint( lc.getCoefficients(), point );
            boolean is_binding = get_constraint_binding_status( lc.getValue(), actual );
            sb.append( String.format( "R%1$02d %2$ 35.17f", i, actual ) );
            if ( is_binding ) {
                sb.append( ", binding" );
            }
            sb.append( "\n" );
            i++;
        }
        return sb.toString();
    }
}
