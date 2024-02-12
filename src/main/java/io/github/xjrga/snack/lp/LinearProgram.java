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
import javax.swing.*;
import org.apache.commons.math3.optim.PointValuePair;
import org.apache.commons.math3.optim.linear.*;
import org.apache.commons.math3.optim.nonlinear.scalar.GoalType;

/*
 * @author Jorge R Garcia de Alba
 */
public class LinearProgram {
  public static final int GEQ = 1;
  public static final int LEQ = 2;
  public static final int EQ = 3;
  private final ArrayList constraints;
  private LinearObjectiveFunction linearObjectiveFunction;
  private double[] point;
  private double cost;
  private JPanel component;
  private LinearConstraintSet linearConstraintSet;
  public boolean flag;

  public LinearProgram() {
    flag = false;
    constraints = new ArrayList();
  }

  public void addObjectiveFunction(double[] coefficients) {
    byte constantTerm = 0;
    // Objective function
    linearObjectiveFunction = new LinearObjectiveFunction(coefficients, constantTerm);
  }

  public void addConstraint(double[] coefficients, int rel, double amount) {
    Relationship relationship = null;
    switch (rel) {
      case LinearProgram.GEQ:
        relationship = Relationship.GEQ;
        break;
      case LinearProgram.LEQ:
        relationship = Relationship.LEQ;
        break;
      case LinearProgram.EQ:
        relationship = Relationship.EQ;
        break;
      default:
        relationship = Relationship.GEQ;
        break;
    }
    // Linear Constraint
    LinearConstraint c = new LinearConstraint(coefficients, relationship, amount);
    constraints.add(c);
  }

  public boolean solve() {
    try {
      // Constraint Set
      linearConstraintSet = new LinearConstraintSet(constraints);
      // Solution
      if (!linearConstraintSet.getConstraints().isEmpty()) {
        GoalType minimize = GoalType.MINIMIZE;
        NonNegativeConstraint nonNegativeConstraint = new NonNegativeConstraint(true);
        PointValuePair solution = (new SimplexSolver()).optimize(linearObjectiveFunction,
            linearConstraintSet, minimize, nonNegativeConstraint);
        point = solution.getPoint();
        cost = solution.getSecond();
        flag = true;
      }
    } catch (Exception e) {
      JComponent[] inputs = new JComponent[] {component};
      Message.showMessage(inputs, "No Feasible Solution");
    }
    return flag;
  }

  public double[] getPoint() {
    return point;
  }

  public double getCost() {
    return cost;
  }

  public Collection<LinearConstraint> getConstraints() {
    return linearConstraintSet.getConstraints();
  }

  public void setComponent(JPanel component) {
    this.component = component;
  }

  public boolean isSolved() {
    return flag;
  }
}
