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
import org.xjrga.snack2.other.Log;

import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Vector;

public class TableModelJournal extends DefaultTableModel implements RoundUp {
    private final DbLink dbLink;
    private Vector columns;
    private Integer precision = 0;

    public TableModelJournal(DbLink dbLink) {
        this.dbLink = dbLink;
        this.setColumnIdentifiers();
    }

    private void setColumnIdentifiers() {
        columns = new Vector();
        //Food
        columns.add("Name");
        columns.add("Weight");
        //Energy
        columns.add("Energy");
        //Protein
        columns.add("Protein");
        columns.add("Complete");
        columns.add("Incomplete");
        //Fats
        columns.add("Fat");
        columns.add("Monounsaturated");
        columns.add("Polyunsaturated");
        columns.add("Saturated");
        columns.add("Cholesterol");
        columns.add("Linoleic");
        columns.add("Alpha-Linolenic");
        columns.add("DHA");
        columns.add("EPA");
        //Carbohydrates
        columns.add("Carbohydrate");
        columns.add("Fiber");
        columns.add("Sucrose");
        columns.add("Fructose");
        columns.add("Lactose");
        //Vitamins
        columns.add("Vitamin A");
        columns.add("Vitamin E");
        columns.add("Vitamin D");
        columns.add("Vitamin C");
        columns.add("Thiamin");
        columns.add("Riboflavin");
        columns.add("Niacin");
        columns.add("Pantothenic");
        columns.add("Vitamin B6");
        columns.add("Vitamin B12");
        columns.add("Choline");
        columns.add("Vitamin K");
        columns.add("Folate");
        //Minerals
        columns.add("Calcium");
        columns.add("Iron");
        columns.add("Magnesium");
        columns.add("Phosphorus");
        columns.add("Potassium");
        columns.add("Sodium");
        columns.add("Zinc");
        columns.add("Copper");
        columns.add("Fluoride");
        columns.add("Manganese");
        columns.add("Selenium");
        //Other
        columns.add("Alcohol");
        columns.add("Water");
        columns.add("Cost");
        this.setColumnIdentifiers(columns);
    }

    public Class getColumnClass(int i) {
        Class returnValue = Object.class;
        if (i == 0) {
            returnValue = String.class;
        } else {
            returnValue = Double.class;
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
            LinkedList list = (LinkedList) dbLink.MixResultDW_Select(mixid, precision);
            Iterator it = list.iterator();
            while (it.hasNext()) {
                HashMap rowm = (HashMap) it.next();
                String Name = (String) rowm.get("Name"); //0
                Double Protein = (Double) rowm.get("Protein");
                Double Fat = (Double) rowm.get("Fat");
                Double CarbsByDiff = (Double) rowm.get("CarbsByDiff");
                Double Energy = (Double) rowm.get("Energy");
                Double Sucrose = (Double) rowm.get("Sucrose");
                Double Fructose = (Double) rowm.get("Fructose");
                Double Lactose = (Double) rowm.get("Lactose");
                Double Alcohol = (Double) rowm.get("Alcohol");
                Double Water = (Double) rowm.get("Water");
                Double Fiber = (Double) rowm.get("Fiber");
                Double Calcium = (Double) rowm.get("Calcium");
                Double Iron = (Double) rowm.get("Iron");
                Double Magnesium = (Double) rowm.get("Magnesium");
                Double Phosphorus = (Double) rowm.get("Phosphorus");
                Double Potassium = (Double) rowm.get("Potassium");
                Double Sodium = (Double) rowm.get("Sodium");
                Double Zinc = (Double) rowm.get("Zinc");
                Double Copper = (Double) rowm.get("Copper");
                Double Fluoride = (Double) rowm.get("Fluoride");
                Double Manganese = (Double) rowm.get("Manganese");
                Double Selenium = (Double) rowm.get("Selenium");
                Double VitaminA = (Double) rowm.get("VitaminA");
                Double VitaminE = (Double) rowm.get("VitaminE");
                Double VitaminD = (Double) rowm.get("VitaminD");
                Double VitaminC = (Double) rowm.get("VitaminC");
                Double Thiamin = (Double) rowm.get("Thiamin");
                Double Riboflavin = (Double) rowm.get("Riboflavin");
                Double Niacin = (Double) rowm.get("Niacin");
                Double Pantothenic = (Double) rowm.get("Pantothenic");
                Double VitaminB6 = (Double) rowm.get("VitaminB6");
                Double VitaminB12 = (Double) rowm.get("VitaminB12");
                Double Choline = (Double) rowm.get("Choline");
                Double VitaminK = (Double) rowm.get("VitaminK");
                Double Folate = (Double) rowm.get("Folate");
                Double Cholesterol = (Double) rowm.get("Cholesterol");
                Double Saturated = (Double) rowm.get("Saturated");
                Double DHA = (Double) rowm.get("DHA");
                Double EPA = (Double) rowm.get("EPA");
                Double Monounsaturated = (Double) rowm.get("Monounsaturated");
                Double Polyunsaturated = (Double) rowm.get("Polyunsaturated");
                Double Linoleic = (Double) rowm.get("Linoleic");
                Double AlphaLinolenic = (Double) rowm.get("AlphaLinolenic");
                Double Weight = (Double) rowm.get("Weight");
                Double CompleteProtein = (Double) rowm.get("CompleteProtein");
                Double IncompleteProtein = (Double) rowm.get("IncompleteProtein");
                Double DigestibleCarbohydrate = (Double) rowm.get("DigestibleCarbs");
                Double Cost = (Double) rowm.get("Cost"); //68
                row = new Vector();
//Food
                row.add(Name);
                row.add(Weight);
                //Energy
                row.add(Energy);
                //Protein
                row.add(Protein);
                row.add(CompleteProtein);
                row.add(IncompleteProtein);
                //Fats
                row.add(Fat);
                row.add(Monounsaturated);
                row.add(Polyunsaturated);
                row.add(Saturated);
                row.add(Cholesterol);
                row.add(Linoleic);
                row.add(AlphaLinolenic);
                row.add(DHA);
                row.add(EPA);
                //Carbohydrates
                row.add(DigestibleCarbohydrate);
                row.add(Fiber);
                row.add(Sucrose);
                row.add(Fructose);
                row.add(Lactose);
                //Vitamins
                row.add(VitaminA);
                row.add(VitaminE);
                row.add(VitaminD);
                row.add(VitaminC);
                row.add(Thiamin);
                row.add(Riboflavin);
                row.add(Niacin);
                row.add(Pantothenic);
                row.add(VitaminB6);
                row.add(VitaminB12);
                row.add(Choline);
                row.add(VitaminK);
                row.add(Folate);
                //Minerals
                row.add(Calcium);
                row.add(Iron);
                row.add(Magnesium);
                row.add(Phosphorus);
                row.add(Potassium);
                row.add(Sodium);
                row.add(Zinc);
                row.add(Copper);
                row.add(Fluoride);
                row.add(Manganese);
                row.add(Selenium);
                //Other
                row.add(Alcohol);
                row.add(Water);
                row.add(Cost);
                table.add(row);
            }
            this.setDataVector(table, columns);
        } catch (SQLException e) {
            Log.getLog().start("files/exception.log");
            Log.getLog().logMessage(e.toString());
            Log.getLog().write();
            Log.getLog().close();
            e.printStackTrace();
        }
    }

    public void setPrecision(Integer precision) {
        this.precision = precision;
    }
}
