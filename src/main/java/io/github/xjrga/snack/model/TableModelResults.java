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

import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Vector;

public class TableModelResults extends DefaultTableModel implements RoundUp {

    private final DbLink dbLink;
    private Vector columns;
    private Integer precision = 0;

    public TableModelResults(DbLink dbLink) {
        this.dbLink = dbLink;
        this.setColumnIdentifiers();
    }

    private void setColumnIdentifiers() {
        columns = new Vector();
        columns.add("Name");
        columns.add("Weight");
        columns.add("*Digestible");
        columns.add("*NoProtein");
        columns.add("*Fat");
        columns.add("*Carbohydrate");
        columns.add("*Protein");
        columns.add("*Alcohol");
        columns.add("Fat");
        columns.add("Carbohydrate");
        columns.add("Protein");
        columns.add("Alcohol");
        columns.add("CompleteProtein");
        columns.add("Monounsaturated");
        columns.add("Polyunsaturated");
        columns.add("Saturated");
        columns.add("Cholesterol");
        columns.add("Linoleic");
        columns.add("AlphaLinolenic");
        columns.add("DHA");
        columns.add("EPA");
        columns.add("Gross");
        columns.add("Fiber");
        columns.add("VitaminA");
        columns.add("VitaminD");
        columns.add("VitaminE");
        columns.add("VitaminC");
        columns.add("Thiamin");
        columns.add("Riboflavin");
        columns.add("Niacin");
        columns.add("VitaminB6");
        columns.add("Folate");
        columns.add("VitaminB12");
        columns.add("VitaminK");
        columns.add("Pantothenic Acid");
        columns.add("Choline");
        columns.add("Calcium");
        columns.add("Phosphorus");
        columns.add("Magnesium");
        columns.add("Iron");
        columns.add("Zinc");
        columns.add("Copper");
        columns.add("Manganese");
        columns.add("Fluoride");
        columns.add("Selenium");
        columns.add("Sodium");
        columns.add("Potassium");
        columns.add("Water");
        columns.add("Cost");
//        columns.add("%");
//        columns.add("GI");
//        columns.add("GL");
//        columns.add("Meal GI");
        this.setColumnIdentifiers(columns);
    }

    @Override
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

    public void reload(String mixid) {
        Vector row = null;
        Vector table = new Vector();
        try {
            LinkedList list = (LinkedList) dbLink.MixResult_Select(mixid, precision);
            Iterator it = list.iterator();
            while (it.hasNext()) {
                //Get values
                HashMap rowm = (HashMap) it.next();
                String Name = (String) rowm.get("Name");
                Double Weight = (Double) rowm.get("Weight");
                Double EnergyDigestible = (Double) rowm.get("EnergyDigestible");
                Double EnergyNoProtein = (Double) rowm.get("EnergyNoProtein");
                Double EnergyFat = (Double) rowm.get("EnergyFat");
                Double EnergyCarbohydrate = (Double) rowm.get("EnergyCarbohydrate");
                Double EnergyProtein = (Double) rowm.get("EnergyProtein");
                Double EnergyAlcohol = (Double) rowm.get("EnergyAlcohol");
                Double Fat = (Double) rowm.get("Fat");
                Double DigestibleCarbohydrate = (Double) rowm.get("DigestibleCarbs");
                Double Protein = (Double) rowm.get("Protein");
                Double Alcohol = (Double) rowm.get("Alcohol");
                Double CompleteProtein = (Double) rowm.get("CompleteProtein");
                Double Cholesterol = (Double) rowm.get("Cholesterol");
                Double Saturated = (Double) rowm.get("Saturated");
                Double DHA = (Double) rowm.get("DHA");
                Double EPA = (Double) rowm.get("EPA");
                Double Monounsaturated = (Double) rowm.get("Monounsaturated");
                Double Polyunsaturated = (Double) rowm.get("Polyunsaturated");
                Double Linoleic = (Double) rowm.get("Linoleic");
                Double AlphaLinolenic = (Double) rowm.get("AlphaLinolenic");
                Double CarbsByDiff = (Double) rowm.get("CarbsByDiff");
                Double Fiber = (Double) rowm.get("Fiber");
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
                Double Calcium = (Double) rowm.get("Calcium");
                Double Iron = (Double) rowm.get("Iron");
                Double Magnesium = (Double) rowm.get("Magnesium");
                Double Phosphorus = (Double) rowm.get("Phosphorus");
                Double Zinc = (Double) rowm.get("Zinc");
                Double Copper = (Double) rowm.get("Copper");
                Double Fluoride = (Double) rowm.get("Fluoride");
                Double Manganese = (Double) rowm.get("Manganese");
                Double Selenium = (Double) rowm.get("Selenium");
                Double Potassium = (Double) rowm.get("Potassium");
                Double Sodium = (Double) rowm.get("Sodium");
                Double Water = (Double) rowm.get("Water");
                Double Cost = (Double) rowm.get("Cost");
//                Double Pct = (Double) rowm.get("pct");
//                Double GlycemicIndex = (Double) rowm.get("gi");
//                Double GlycemicLoad = (Double) rowm.get("gl");
//                Double MealGI = (Double) rowm.get("mealgi");
                //Add row
                row = new Vector();
                row.add(Name);
                row.add(Weight);
                row.add(EnergyDigestible);
                row.add(EnergyNoProtein);
                row.add(EnergyFat);
                row.add(EnergyCarbohydrate);
                row.add(EnergyProtein);
                row.add(EnergyAlcohol);
                row.add(Fat);
                row.add(DigestibleCarbohydrate);
                row.add(Protein);
                row.add(Alcohol);
                row.add(CompleteProtein);
                row.add(Monounsaturated);
                row.add(Polyunsaturated);
                row.add(Saturated);
                row.add(Cholesterol);
                row.add(Linoleic);
                row.add(AlphaLinolenic);
                row.add(DHA);
                row.add(EPA);
                row.add(CarbsByDiff);
                row.add(Fiber);
                row.add(VitaminA);
                row.add(VitaminD);
                row.add(VitaminE);
                row.add(VitaminC);
                row.add(Thiamin);
                row.add(Riboflavin);
                row.add(Niacin);
                row.add(VitaminB6);
                row.add(Folate);
                row.add(VitaminB12);
                row.add(VitaminK);
                row.add(Pantothenic);
                row.add(Choline);
                row.add(Calcium);
                row.add(Phosphorus);
                row.add(Magnesium);
                row.add(Iron);
                row.add(Zinc);
                row.add(Copper);
                row.add(Manganese);
                row.add(Fluoride);
                row.add(Selenium);
                row.add(Sodium);
                row.add(Potassium);
                row.add(Water);
                row.add(Cost);
//                row.add(Pct);
//                row.add(GlycemicIndex);
//                row.add(GlycemicLoad);
//                row.add(MealGI);
                table.add(row);
            }
            this.setDataVector(table, columns);
        } catch (SQLException e) {

        }
    }

    @Override
    public void setPrecision(Integer precision) {
        this.precision = precision;
    }
}
