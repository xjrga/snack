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
package io.github.xjrga.snack.datamodel;

import io.github.xjrga.snack.other.Nutrient;
import io.github.xjrga.snack.database.DbLink;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public class TableModelFoodList extends DefaultTableModel implements Round_up, Reload {
  private final DbLink dbLink;
  private Vector columns;
  private Integer precision = 0;

  public TableModelFoodList(DbLink dbLink) {
    this.dbLink = dbLink;
    this.setColumnIdentifiers();
  }

  private void setColumnIdentifiers() {
    columns = new Vector();
    columns.add("FoodId");
    columns.add("Name");
    columns.add("Weight");
    columns.add("eGross");
    columns.add("eDigest");
    columns.add("eFat");
    columns.add("eCarbs");
    columns.add("eProtein");
    columns.add("eAlcohol");
    columns.add("Fat");
    columns.add("Carbs");
    columns.add("Protein");
    columns.add("Alcohol");
    columns.add("Na");
    columns.add("K");
    columns.add("Complete");
    columns.add("CarbsByDiff");
    columns.add("Fiber");
    columns.add("Ca");
    columns.add("P");
    columns.add("Mg");
    columns.add("Fe");
    columns.add("Zn");
    columns.add("Cu");
    columns.add("Mn");
    columns.add("Se");
    columns.add("A");
    columns.add("D");
    columns.add("E");
    columns.add("C");
    columns.add("B1");
    columns.add("B2");
    columns.add("B3");
    columns.add("B5");
    columns.add("B6");
    columns.add("B12");
    columns.add("B4");
    columns.add("K");
    columns.add("B9");
    columns.add("CHOL");
    columns.add("SFA");
    columns.add("HCSFA");
    columns.add("DHA");
    columns.add("EPA");
    columns.add("MUFA");
    columns.add("PUFA");
    columns.add("LA");
    columns.add("ALA");
    columns.add("Lauric");
    columns.add("Myristic");
    columns.add("Palmitic");
    columns.add("Stearic");
    columns.add("GL");
    columns.add("Water");
    columns.add("Cost");
    this.setColumnIdentifiers(columns);
  }

  @Override
  public Class getColumnClass(int i) {
    Class returnValue = Object.class;
    if (i < 2) {
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
    Vector table = new Vector();
    try {
      LinkedList<HashMap> list = (LinkedList) dbLink.Food_Select_Details(precision);
      list.forEach(
          rowm -> {
            // Name
            String Name = (String) rowm.get("Name");
            // Mass
            Double Weight = (Double) rowm.get(Nutrient.WEIGHT.getLabel());
            // Energy
            Double EnergyGross = (Double) rowm.get(Nutrient.ENERGYGROSS.getLabel());
            Double EnergyDigestible = (Double) rowm.get(Nutrient.ENERGYDIGESTIBLE.getLabel());
            Double EnergyCarbohydrate = (Double) rowm.get(Nutrient.ENERGYCARBOHYDRATE.getLabel());
            Double EnergyProtein = (Double) rowm.get(Nutrient.ENERGYPROTEIN.getLabel());
            Double EnergyFat = (Double) rowm.get(Nutrient.ENERGYFAT.getLabel());
            Double EnergyAlcohol = (Double) rowm.get(Nutrient.ENERGYALCOHOL.getLabel());
            Double EnergyFatCarbohydrate =
                (Double) rowm.get(Nutrient.ENERGYFATCARBOHYDRATE.getLabel());
            // Macronutrient
            Double Fat = (Double) rowm.get(Nutrient.FAT.getLabel());
            Double DigestibleCarbohydrate =
                (Double) rowm.get(Nutrient.DIGESTIBLECARBOHYDRATE.getLabel());
            Double Protein = (Double) rowm.get(Nutrient.PROTEIN.getLabel());
            Double Alcohol = (Double) rowm.get(Nutrient.ALCOHOL.getLabel());
            // Electrolytes
            Double Sodium = (Double) rowm.get(Nutrient.SODIUM.getLabel());
            Double Potassium = (Double) rowm.get(Nutrient.POTASSIUM.getLabel());
            // Complete Protein
            Double CompleteProtein = (Double) rowm.get(Nutrient.COMPLETEPROTEIN.getLabel());
            // Carbohydrate
            Double CarbsByDiff = (Double) rowm.get(Nutrient.CARBOHYDRATEBYDIFFERENCE.getLabel());
            Double Fiber = (Double) rowm.get(Nutrient.FIBER.getLabel());
            // Minerals
            Double Calcium = (Double) rowm.get(Nutrient.CALCIUM.getLabel());
            Double Iron = (Double) rowm.get(Nutrient.IRON.getLabel());
            Double Magnesium = (Double) rowm.get(Nutrient.MAGNESIUM.getLabel());
            Double Phosphorus = (Double) rowm.get(Nutrient.PHOSPHORUS.getLabel());
            Double Zinc = (Double) rowm.get(Nutrient.ZINC.getLabel());
            Double Copper = (Double) rowm.get(Nutrient.COPPER.getLabel());
            Double Manganese = (Double) rowm.get(Nutrient.MANGANESE.getLabel());
            Double Selenium = (Double) rowm.get(Nutrient.SELENIUM.getLabel());
            // Vitamins
            Double VitaminA = (Double) rowm.get(Nutrient.VITAMINA.getLabel());
            Double VitaminE = (Double) rowm.get(Nutrient.VITAMINE.getLabel());
            Double VitaminD = (Double) rowm.get(Nutrient.VITAMIND.getLabel());
            Double VitaminC = (Double) rowm.get(Nutrient.VITAMINC.getLabel());
            Double Thiamin = (Double) rowm.get(Nutrient.THIAMIN.getLabel());
            Double Riboflavin = (Double) rowm.get(Nutrient.RIBOFLAVIN.getLabel());
            Double Niacin = (Double) rowm.get(Nutrient.NIACIN.getLabel());
            Double Pantothenic = (Double) rowm.get(Nutrient.PANTOTHENICACID.getLabel());
            Double VitaminB6 = (Double) rowm.get(Nutrient.VITAMINB6.getLabel());
            Double VitaminB12 = (Double) rowm.get(Nutrient.VITAMINB12.getLabel());
            Double Choline = (Double) rowm.get(Nutrient.CHOLINE.getLabel());
            Double VitaminK = (Double) rowm.get(Nutrient.VITAMINK.getLabel());
            Double Folate = (Double) rowm.get(Nutrient.FOLATE.getLabel());
            // Fatty Acids
            Double Cholesterol = (Double) rowm.get(Nutrient.CHOLESTEROL.getLabel());
            Double Saturated = (Double) rowm.get(Nutrient.SFA.getLabel());
            Double DHA = (Double) rowm.get(Nutrient.DHA.getLabel());
            Double EPA = (Double) rowm.get(Nutrient.EPA.getLabel());
            Double Monounsaturated = (Double) rowm.get(Nutrient.MUFA.getLabel());
            Double Polyunsaturated = (Double) rowm.get(Nutrient.PUFA.getLabel());
            Double Linoleic = (Double) rowm.get(Nutrient.LINOLEIC.getLabel());
            Double Linolenic = (Double) rowm.get(Nutrient.LINOLENIC.getLabel());
            Double Lauric = (Double) rowm.get(Nutrient.LAURIC.getLabel());
            Double Myristic = (Double) rowm.get(Nutrient.MYRISTIC.getLabel());
            Double Palmitic = (Double) rowm.get(Nutrient.PALMITIC.getLabel());
            Double Stearic = (Double) rowm.get(Nutrient.STEARIC.getLabel());
            Double Hcsfa = (Double) rowm.get(Nutrient.HCSFA.getLabel());
            // Glycemic
            Double GlycemicLoad = (Double) rowm.get(Nutrient.GLYCEMICLOAD.getLabel());
            // Other
            Double Water = (Double) rowm.get(Nutrient.WATER.getLabel());
            Double Cost = (Double) rowm.get(Nutrient.COST.getLabel());
            // Ids
            String FoodId = (String) rowm.get("FoodId");
            Vector row = new Vector();
            row.add(FoodId);
            row.add(Name);
            row.add(Weight);
            row.add(EnergyGross);
            row.add(EnergyDigestible);
            row.add(EnergyFat);
            row.add(EnergyCarbohydrate);
            row.add(EnergyProtein);
            row.add(EnergyAlcohol);
            row.add(Fat);
            row.add(DigestibleCarbohydrate);
            row.add(Protein);
            row.add(Alcohol);
            row.add(Sodium);
            row.add(Potassium);
            row.add(CompleteProtein);
            row.add(CarbsByDiff);
            row.add(Fiber);
            row.add(Calcium);
            row.add(Phosphorus);
            row.add(Magnesium);
            row.add(Iron);
            row.add(Zinc);
            row.add(Copper);
            row.add(Manganese);
            row.add(Selenium);
            row.add(VitaminA);
            row.add(VitaminD);
            row.add(VitaminE);
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
            row.add(Cholesterol);
            row.add(Saturated);
            row.add(Hcsfa);
            row.add(DHA);
            row.add(EPA);
            row.add(Monounsaturated);
            row.add(Polyunsaturated);
            row.add(Linoleic);
            row.add(Linolenic);
            row.add(Lauric);
            row.add(Myristic);
            row.add(Palmitic);
            row.add(Stearic);
            row.add(GlycemicLoad);
            row.add(Water);
            row.add(Cost);
            // row.add(CategoryId);
            table.add(row);
          });
      this.setDataVector(table, columns);
    } catch (SQLException e) {
    }
  }

  @Override
  public void set_precision(Integer precision) {
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
