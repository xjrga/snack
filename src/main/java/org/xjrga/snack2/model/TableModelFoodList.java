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
import org.xjrga.snack2.dataobject.FoodDetailsDataObject;
import org.xjrga.snack2.other.Log;

import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Vector;

public class TableModelFoodList extends DefaultTableModel implements RoundUp {
    private final DbLink dbLink;
    private Vector columns;
    private Integer precision = 0;

    public TableModelFoodList(DbLink dbLink) {
        this.dbLink = dbLink;
        this.setColumnIdentifiers();
    }

    private void setColumnIdentifiers() {
        columns = new Vector();
//
        columns.add("FoodId");
        //Food
        columns.add("Category");
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
        columns.add("GL");
        columns.add("Fiber");
        columns.add("Insoluble");
        columns.add("Soluble");
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
        columns.add("Pantothenic Acid");
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
        if (i < 3) {
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

    public void reload() {
        Vector row = null;
        Vector table = new Vector();
        try {
            LinkedList list = (LinkedList) dbLink.Food_Select_Details(precision);
            Iterator it = list.iterator();
            while (it.hasNext()) {
                FoodDetailsDataObject fooddetailsDataObject = (FoodDetailsDataObject) it.next();
                String foodId = fooddetailsDataObject.getFoodId();
                String Category = fooddetailsDataObject.getCategory();
                String Name = fooddetailsDataObject.getName();
                Double Protein = fooddetailsDataObject.getProtein();
                Double Fat = fooddetailsDataObject.getFat();
                Double Energy = fooddetailsDataObject.getEnergy();
                Double Sucrose = fooddetailsDataObject.getSucrose();
                Double Fructose = fooddetailsDataObject.getFructose();
                Double Lactose = fooddetailsDataObject.getLactose();
                Double Alcohol = fooddetailsDataObject.getAlcohol();
                Double Water = fooddetailsDataObject.getWater();
                Double Fiber = fooddetailsDataObject.getFiber();
                Double Calcium = fooddetailsDataObject.getCalcium();
                Double Iron = fooddetailsDataObject.getIron();
                Double Magnesium = fooddetailsDataObject.getMagnesium();
                Double Phosphorus = fooddetailsDataObject.getPhosphorus();
                Double Potassium = fooddetailsDataObject.getPotassium();
                Double Sodium = fooddetailsDataObject.getSodium();
                Double Zinc = fooddetailsDataObject.getZinc();
                Double Copper = fooddetailsDataObject.getCopper();
                Double Fluoride = fooddetailsDataObject.getFluoride();
                Double Manganese = fooddetailsDataObject.getManganese();
                Double Selenium = fooddetailsDataObject.getSelenium();
                Double VitaminA = fooddetailsDataObject.getVitaminA();
                Double VitaminE = fooddetailsDataObject.getVitaminE();
                Double VitaminD = fooddetailsDataObject.getVitaminD();
                Double VitaminC = fooddetailsDataObject.getVitaminC();
                Double Thiamin = fooddetailsDataObject.getThiamin();
                Double Riboflavin = fooddetailsDataObject.getRiboflavin();
                Double Niacin = fooddetailsDataObject.getNiacin();
                Double Pantothenic = fooddetailsDataObject.getPantothenic();
                Double VitaminB6 = fooddetailsDataObject.getVitaminB6();
                Double VitaminB12 = fooddetailsDataObject.getVitaminB12();
                Double Choline = fooddetailsDataObject.getCholine();
                Double VitaminK = fooddetailsDataObject.getVitaminK();
                Double Folate = fooddetailsDataObject.getFolate();
                Double Cholesterol = fooddetailsDataObject.getCholesterol();
                Double Saturated = fooddetailsDataObject.getSaturated();
                Double DHA = fooddetailsDataObject.getDHA();
                Double EPA = fooddetailsDataObject.getEPA();
                Double Monounsaturated = fooddetailsDataObject.getMonounsaturated();
                Double Polyunsaturated = fooddetailsDataObject.getPolyunsaturated();
                Double Linoleic = fooddetailsDataObject.getLinoleic();
                Double AlphaLinolenic = fooddetailsDataObject.getAlphaLinolenic();
                Double Weight = fooddetailsDataObject.getWeight();
                Double CompleteProtein = fooddetailsDataObject.getCompleteProtein();
                Double IncompleteProtein = fooddetailsDataObject.getIncompleteProtein();
                Double DigestibleCarbohydrate = fooddetailsDataObject.getDigestibleCarbohydrate();
                Double Cost = fooddetailsDataObject.getCost();
                Double FiberInsoluble = fooddetailsDataObject.getFiberInsoluble();
                Double FiberSoluble = fooddetailsDataObject.getFiberSoluble();
                Double GlycemicIndex = fooddetailsDataObject.getGlycemicIndex();
                row = new Vector();
                row.add(foodId);
                //Food
                row.add(Category);
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
                row.add(GlycemicIndex);
                row.add(Fiber);
                row.add(FiberInsoluble);
                row.add(FiberSoluble);
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

    public Integer find(String FoodId) {
        int index = 0;
        int rowNo = this.getRowCount();
        int colNo = this.getColumnCount();
        for (int j = 0; j < rowNo; j++) {
            for (int i = 0; i < colNo; i++) {
                if (FoodId.equals(this.getValueAt(j, 0))) {
                    index = j;
                }
            }
        }
        return index;
    }
}
