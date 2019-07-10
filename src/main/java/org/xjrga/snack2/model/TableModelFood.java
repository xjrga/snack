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

package org.xjrga.snack2.model;

import org.xjrga.snack2.data.DbLink;

import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Vector;

public class TableModelFood extends DefaultTableModel {

    private final DbLink dbLink;
    private Vector columns;

    public TableModelFood(DbLink dbLink) {
        this.dbLink = dbLink;
        this.setColumnIdentifiers();
    }

    private void setColumnIdentifiers() {

        columns = new Vector();
        columns.add("Category");
        columns.add("Food");
        columns.add("Protein");
        columns.add("Fat");
        columns.add("Carbohydrate");
        columns.add("Calories");
        columns.add("Alcohol");
        columns.add("Fiber");
        columns.add("Calcium");
        columns.add("Magnesium");
        columns.add("Potassium");
        columns.add("Sodium");
        columns.add("Cholesterol");
        columns.add("Saturated");
        columns.add("Monounsaturated");
        columns.add("Polyunsaturated");
        columns.add("Quantity");
        columns.add("Complete");
        columns.add("Incomplete");
        //columns.add("CarbsDigestible");
        columns.add("Cost");
        columns.add("FoodCategoryId");
        columns.add("FoodId");
        this.setColumnIdentifiers(columns);

    }

    public Class getColumnClass(int i) {

        Class returnValue = Object.class;
        switch (i) {
            case 0:
            case 1:
                returnValue = String.class;
                break;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
                returnValue = Double.class;
                break;
            case 20:
            case 21:
                returnValue = String.class;
                break;

        }
        return returnValue;
    }

    @Override
    public boolean isCellEditable(int i, int i1) {
        return false;
    }

    public void reload() {

        Vector row = null;
        Vector table = new Vector();

        try {
            LinkedList list = (LinkedList) dbLink.Food_Select_Details();
            Iterator it = list.iterator();

            while (it.hasNext()) {

                HashMap rowm = (HashMap) it.next();
                String Category = (String) rowm.get("CATEGORY");
                String Food = (String) rowm.get("FOOD");
                Double Protein = (Double) rowm.get("PROTEIN");
                Double Fat = (Double) rowm.get("FAT");
                Double CarbsDigestible = (Double) rowm.get("CARBSDIGESTIBLE");
                //Double Carbohydrate = (Double)rowm.get("CARBOHYDRATE");
                Double Calories = (Double) rowm.get("CALORIES");
                Double Alcohol = (Double) rowm.get("ALCOHOL");
                Double Fiber = (Double) rowm.get("FIBER");
                Double Calcium = (Double) rowm.get("CALCIUM");
                Double Magnesium = (Double) rowm.get("MAGNESIUM");
                Double Potassium = (Double) rowm.get("POTASSIUM");
                Double Sodium = (Double) rowm.get("SODIUM");
                Double Cholesterol = (Double) rowm.get("CHOLESTEROL");
                Double SatFat = (Double) rowm.get("SATFAT");
                Double Monoufat = (Double) rowm.get("MONOUFAT");
                Double Polyufat = (Double) rowm.get("POLYUFAT");
                Double Quantity = (Double) rowm.get("QUANTITY");
                Double Complete = (Double) rowm.get("COMPLETE");
                Double Incomplete = (Double) rowm.get("INCOMPLETE");
                Double Cost = (Double) rowm.get("COST");
                String FoodCategoryId = (String) rowm.get("FOODCATEGORYID");
                String FoodId = (String) rowm.get("FOODID");

                row = new Vector();

                row.add(Category);
                row.add(Food);
                row.add(Protein);
                row.add(Fat);
                row.add(CarbsDigestible);
                //row.add(Carbohydrate);
                row.add(Calories);
                row.add(Alcohol);
                row.add(Fiber);
                row.add(Calcium);
                row.add(Magnesium);
                row.add(Potassium);
                row.add(Sodium);
                row.add(Cholesterol);
                row.add(SatFat);
                row.add(Monoufat);
                row.add(Polyufat);
                row.add(Quantity);
                row.add(Complete);
                row.add(Incomplete);
                row.add(Cost);
                row.add(FoodCategoryId);
                row.add(FoodId);

                table.add(row);
            }

            this.setDataVector(table, columns);

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
