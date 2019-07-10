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

package org.xjrga.snack2.lp;

import org.apache.commons.math3.optim.PointValuePair;
import org.apache.commons.math3.optim.linear.*;
import org.apache.commons.math3.optim.nonlinear.scalar.GoalType;
import org.xjrga.snack2.gui.Message;

import java.util.ArrayList;


/*
 * @author  Jorge Garcia de Alba
 */
public class LpModel {

    public static final int GEQ = 1;
    public static final int LEQ = 2;
    public static final int EQ = 3;

    private LinearObjectiveFunction linearObjectiveFunction;
    private final ArrayList constraints;
    private double[] point;
    private double cost;
    private final LpFormat lp;

    public LpModel() {

        //commons-math3-3.6.1 library on classpath
        constraints = new ArrayList();
        lp = new LpFormat();
    }

    public void addObjective(double[] coefficients) {

        byte constantTerm = 0;
        //Objective function
        linearObjectiveFunction = new LinearObjectiveFunction(coefficients, constantTerm);
        lp.objectiveToLp(coefficients);
    }

    public void addConstraint(double[] coefficients, int rel, double amount) {

        Relationship relationship = null;

        switch (rel) {
            case LpModel.GEQ:
                relationship = Relationship.GEQ;
                //
                break;
            case LpModel.LEQ:
                //
                relationship = Relationship.LEQ;
                break;
            case LpModel.EQ:
                //
                relationship = Relationship.EQ;
                break;
            default:
                relationship = Relationship.GEQ;
                break;
        }

        //Linear Constraint
        LinearConstraint c = new LinearConstraint(coefficients, relationship, amount);
        constraints.add(c);

        lp.constraintToLp(coefficients, rel, amount);
    }

    public boolean solve() {

        boolean flag = false;

        try {

            //Constraint Set
            LinearConstraintSet linearConstraintSet = new LinearConstraintSet(constraints);

            //Solution
            if (!linearConstraintSet.getConstraints().isEmpty()) {
                GoalType minimize = GoalType.MINIMIZE;
                NonNegativeConstraint nonNegativeConstraint = new NonNegativeConstraint(true);
                PointValuePair solution = (new SimplexSolver()).optimize(linearObjectiveFunction, linearConstraintSet, minimize, nonNegativeConstraint);
                point = solution.getPoint();
                cost = solution.getSecond();
                flag = true;
            }

        } catch (Exception e) {

            StringBuilder sb = new StringBuilder();
            sb.append(e.getMessage().toUpperCase());
            sb.append("\n\n");
            sb.append("Things you can try:");
            sb.append("\n");
            sb.append("1. Delete a constraint");
            sb.append("\n");
            sb.append("2. Add a food item");
            sb.append("\n");

            Message.showMessage(sb.toString());
            //org.apache.commons.math3.optim.linear.NoFeasibleSolutionException: no feasible solution
        }

        return flag;
    }

    public double[] getPoint() {
        return point;
    }

    public double getCost() {
        return cost;
    }

    public String printModel() {

        return lp.getModel();

    }
}
