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

public class LpFormat {

    private final StringBuilder sb;

    public LpFormat() {
        sb = new StringBuilder();
    }

    public void objectiveToLp(double[] coefficients) {
        sb.append("/* Minimize */");
        sb.append("\n");
        sb.append("min: ");
        for (int i = 0; i < coefficients.length; i++) {
            double c = coefficients[i];
            sb.append(c);
            sb.append(" ");
            sb.append("x");
            sb.append(i);
            sb.append(" + ");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.deleteCharAt(sb.length() - 1);
        sb.deleteCharAt(sb.length() - 1);
        sb.append(";");
        sb.append("\n");
        sb.append("/* Subject To */");
        sb.append("\n");
    }

    public void constraintToLp(double[] coefficients, int rel, double value) {
        String relationship = "";
        relationship = getRelationship(rel);
        for (int i = 0; i < coefficients.length; i++) {
            double c = coefficients[i];
            sb.append(c);
            sb.append(" ");
            sb.append("x");
            sb.append(i);
            sb.append(" + ");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.deleteCharAt(sb.length() - 1);
        sb.append(relationship);
        sb.append(" ");
        sb.append(value);
        sb.append(";");
        sb.append("\n");
    }

    private String getRelationship(int rel) {
        String relationship = "";
        switch (rel) {
            case 1:
                relationship = ">=";
                break;
            case 2:
                relationship = "<=";
                break;
            case 3:
                relationship = "=";
                break;
        }
        return relationship;
    }

    public String getModel() {
        return sb.toString().strip();
    }
}
