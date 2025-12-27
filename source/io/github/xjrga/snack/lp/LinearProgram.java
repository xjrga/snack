/*
 * Snack: Learning Software for Nutrition Copyright (C) 2018 Jorge R Garcia de Alba License:
 * http://www.gnu.org/licenses/gpl.html GPL version 2 or higher
 *
 * This program is free software; you can redistribute it and/or modify it under the terms of the
 * GNU General Public License as published by the Free Software Foundation; either version 2 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
 * even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with this program; if
 * not, write to the Free Software Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA
 * 02110-1301, USA.
 */
package io.github.xjrga.snack.lp;

import io.github.xjrga.snack.gui.Message;
import java.util.ArrayList;
import java.util.Collection;
import javax.swing.JComponent;
import javax.swing.JPanel;
import org.apache.commons.math3.optim.PointValuePair;
import org.apache.commons.math3.optim.linear.LinearConstraint;
import org.apache.commons.math3.optim.linear.LinearConstraintSet;
import org.apache.commons.math3.optim.linear.LinearObjectiveFunction;
import org.apache.commons.math3.optim.linear.NonNegativeConstraint;
import org.apache.commons.math3.optim.linear.Relationship;
import org.apache.commons.math3.optim.linear.SimplexSolver;
import org.apache.commons.math3.optim.nonlinear.scalar.GoalType;

/*
 * @author Jorge R Garcia de Alba
 */
public class LinearProgram {

    public static final int EQ = 3;
    public static final int GEQ = 1;
    public static final int LEQ = 2;
    private JPanel component;
    private final ArrayList constraints;
    private double cost;
    public boolean flag;
    private LinearConstraintSet linearConstraintSet;
    private LinearObjectiveFunction linearObjectiveFunction;
    private double[] point;

    public LinearProgram() {
        flag = false;
        constraints = new ArrayList();
    }

    public void addConstraint( double[] coefficients, int rel, double amount ) {
        Relationship relationship = null;
        relationship = switch ( rel ) {
            case LinearProgram.GEQ ->
                Relationship.GEQ;
            case LinearProgram.LEQ ->
                Relationship.LEQ;
            case LinearProgram.EQ ->
                Relationship.EQ;
            default ->
                Relationship.GEQ;
        };
        // Linear Constraint
        LinearConstraint c = new LinearConstraint( coefficients, relationship, amount );
        constraints.add( c );
    }

    public void addObjectiveFunction( double[] coefficients ) {
        byte constantTerm = 0;
        linearObjectiveFunction = new LinearObjectiveFunction( coefficients, constantTerm );
    }

    public Collection<LinearConstraint> getConstraints() {
        return linearConstraintSet.getConstraints();
    }

    public double getCost() {
        return cost;
    }

    public double[] getPoint() {
        return point;
    }

    public boolean isSolved() {
        return flag;
    }

    public void setComponent( JPanel component ) {
        this.component = component;
    }

    public boolean solve() {
        try {
            // Constraint Set
            linearConstraintSet = new LinearConstraintSet( constraints );
            // Solution
            if ( !linearConstraintSet.getConstraints().isEmpty() ) {
                GoalType minimize = GoalType.MINIMIZE;
                NonNegativeConstraint nonNegativeConstraint = new NonNegativeConstraint( true );
                PointValuePair solution = ( new SimplexSolver() )
                        .optimize( linearObjectiveFunction, linearConstraintSet, minimize, nonNegativeConstraint );
                point = solution.getPoint();
                cost = solution.getSecond();
                flag = true;
            }
        } catch ( Exception e ) {
            JComponent[] inputs = { component };
            Message.showMessage( inputs, "No Feasible Solution" );
        }
        return flag;
    }
}
