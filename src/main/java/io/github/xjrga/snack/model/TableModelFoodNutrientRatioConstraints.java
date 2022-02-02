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
package io.github.xjrga.snack.model;

import io.github.xjrga.snack.data.DbLink;
import io.github.xjrga.snack.other.Log;

import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Vector;

public class TableModelFoodNutrientRatioConstraints extends DefaultTableModel {

    private final DbLink dbLink;
    private Vector columns;

    public TableModelFoodNutrientRatioConstraints(DbLink dbLink) {
        this.dbLink = dbLink;
        this.setColumnIdentifiers();
    }

    private void setColumnIdentifiers() {
        columns = new Vector();
        columns.add("MixId");
        columns.add("FoodIdA");
        columns.add("NutrientIdA");
        columns.add("FoodIdB");
        columns.add("NutrientIdB");
        columns.add("RelationshipId");
        columns.add("FoodA");
        columns.add("NutrientA");
        columns.add("FoodB");
        columns.add("NutrientB");
        columns.add("A");
        columns.add("B");
        columns.add("Eq");
        this.setColumnIdentifiers(columns);
    }

    @Override
    public Class getColumnClass(int i) {
        Class returnValue = Object.class;
        switch (i) {
            case 0:
                //mixid
                returnValue = Integer.class;
                break;
            case 1:
                //foodid A
                returnValue = String.class;
                break;
            case 2:
                //nutrientid A
                returnValue = String.class;
                break;
            case 3:
                //foodid B
                returnValue = String.class;
                break;
            case 4:
                //nutrientid B
                returnValue = String.class;
                break;
            case 5:
                //relationshipid
                returnValue = Integer.class;
                break;
            case 6:
                //Food Name A
                returnValue = String.class;
                break;
            case 7:
                //Nutrient Name A
                returnValue = String.class;
                break;
            case 8:
                //Food Name B
                returnValue = String.class;
                break;
            case 9:
                //Nutrient Name B
                returnValue = String.class;
                break;
            case 10:
                //A
                returnValue = Double.class;
                break;
            case 11:
                //B
                returnValue = Double.class;
                break;
            case 12:
                //Relationship
                returnValue = String.class;
                break;

        }
        return returnValue;
    }

    @Override
    public boolean isCellEditable(int i, int i1) {
        return false;
    }

    public void reload(Integer mixid) {
        Vector row = null;
        Vector table = new Vector();
        try {
            LinkedList list = (LinkedList) dbLink.FoodNutrientRatio_Select(mixid);
            Iterator it = list.iterator();
            while (it.hasNext()) {
                HashMap rowm = (HashMap) it.next();
                Integer mixid2 = (Integer) rowm.get("MIXID");
                String foodidA = (String) rowm.get("FOOD_ID_1");
                String nutrientidA = (String) rowm.get("NUTRIENT_ID_1");
                String foodidB = (String) rowm.get("FOOD_ID_2");
                String nutrientidB = (String) rowm.get("NUTRIENT_ID_2");
                Integer relationshipid = (Integer) rowm.get("RELATIONSHIPID");
                String foodA = (String) rowm.get("FOODA");
                String nutrientA = (String) rowm.get("NUTRIENTA");
                String foodB = (String) rowm.get("FOODB");
                String nutrientB = (String) rowm.get("NUTRIENTB");
                Double a = (Double) rowm.get("A");
                Double b = (Double) rowm.get("B");
                String relationship = (String) rowm.get("RELATIONSHIP");
                row = new Vector();
                row.add(mixid2);
                row.add(foodidA);
                row.add(nutrientidA);
                row.add(foodidB);
                row.add(nutrientidB);
                row.add(relationshipid);
                row.add(foodA);
                row.add(nutrientA);
                row.add(foodB);
                row.add(nutrientB);
                row.add(a);
                row.add(b);
                row.add(relationship);
                table.add(row);
            }
            this.setDataVector(table, columns);
        } catch (SQLException e) {
            Log.getLog().start("files/exception.log");
            Log.getLog().logMessage(e.toString());
            Log.getLog().write();
            Log.getLog().close();           
        }
    }
}
