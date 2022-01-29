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
import com.jgoodies.forms.layout.FormLayout;
import org.apache.commons.math3.optim.PointValuePair;
import org.apache.commons.math3.optim.linear.*;
import org.apache.commons.math3.optim.nonlinear.scalar.GoalType;
import io.github.xjrga.snack.gui.Message;
import io.github.xjrga.snack.other.GoldenRatio;
import io.github.xjrga.snack.other.Log;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

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
    private String results;
    private final CellConstraints cc = new CellConstraints();
    private JTabbedPane component;

    public LpModel() {
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
                Log.getLog().start("files/model.log");
                Log.getLog().logMessage("/*");
                Log.getLog().logMessage(getDescription());
                Log.getLog().logMessage("*/");
                Log.getLog().logMessage("");
                Log.getLog().logMessage(getModel());
                PointValuePair solution = (new SimplexSolver()).optimize(linearObjectiveFunction, linearConstraintSet, minimize, nonNegativeConstraint);
                point = solution.getPoint();
                cost = solution.getSecond();
                flag = true;
            }
        } catch (Exception e) {
            Log.getLog().logMessage("");
            Log.getLog().logMessage("/*");
            Log.getLog().logMessage(getResults());
            Log.getLog().logMessage("*/");
            Log.getLog().logMessage("");
            Log.getLog().logMessage("/*");
            Log.getLog().logMessage(getInfeasibleMessage());
            Log.getLog().logMessage("*/");
            Log.getLog().write();
            Log.getLog().close();
            JComponent[] inputs = new JComponent[]{
                component
            };
            Message.showMessage(inputs, "No Feasible Solution");
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

    public String getTitle() {
        StringBuilder sb = new StringBuilder();
        sb.append("Title: ");
        sb.append(title);
        return sb.toString();
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        StringBuilder sb = new StringBuilder();
        sb.append("Date: ");
        sb.append(date);
        return sb.toString();
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getVariables() {
        StringBuilder sb = new StringBuilder();
        sb.append("Variables: ");
        sb.append("\n");
        sb.append(variables);
        return sb.toString();
    }

    public void setVariables(String legend) {
        this.variables = legend;
    }

    public String getDescription() {
        StringBuilder sb = new StringBuilder();
        sb.append(getTitle());
        sb.append("\n");
        sb.append(getDate());
        sb.append("\n\n");
        sb.append(getVariables());
        return sb.toString();
    }

    public String getModel() {
        return lp.getModel();
    }

    public String getResults() {
        StringBuilder sb = new StringBuilder();
        sb.append("Results: ");
        sb.append("\n");
        sb.append(results);
        return sb.toString();
    }

    public void setResults(String results) {
        this.results = results;
    }

    public void save() {
        Log.getLog().logMessage("");
        Log.getLog().logMessage("/*");
        Log.getLog().logMessage(getResults());
        Log.getLog().logMessage("*/");
        Log.getLog().logMessage("");
        Log.getLog().logMessage("/*");
        Log.getLog().logMessage(getFeasibleMessage());
        Log.getLog().logMessage("*/");
        Log.getLog().write();
        Log.getLog().close();
    }

    public String getInfeasibleMessage() {
        return "Model is infeasible. No solution exists which satisfies all the constraints.";
    }

    public String getFeasibleMessage() {
        return "Model is feasible. A solution exists which satisfies all the constraints.";
    }

    public void setComponent(JTabbedPane component) {
        this.component = component;
    }
}
