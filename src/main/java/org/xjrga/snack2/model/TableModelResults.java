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
package io.github.xjrga.snack2.model;

import io.github.xjrga.snack2.data.DbLink;
import io.github.xjrga.snack2.other.Log;

import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Vector;

public class TableModelResults extends DefaultTableModel implements RoundUp {
    private final DbLink dbLink;
    private final boolean numberRounding = false;
    private Vector columns;
    private Integer precision = 0;

    public TableModelResults(DbLink dbLink) {
        this.dbLink = dbLink;
        this.setColumnIdentifiers();
    }

    private void setColumnIdentifiers() {
        columns = new Vector();
        columns.add("Name"); //0
        columns.add("Protein");
        columns.add("Fat");
        columns.add("CarbsByDiff");
        columns.add("Energy");
        columns.add("Sucrose");
        columns.add("Fructose");
        columns.add("Lactose");
        columns.add("Alcohol");
        columns.add("Water");
        columns.add("Caffeine");
        columns.add("Theobromine");
        columns.add("Fiber");
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
        columns.add("VitaminA");
        columns.add("VitaminE");
        columns.add("VitaminD");
        columns.add("Lutein");
        columns.add("VitaminC");
        columns.add("Thiamin");
        columns.add("Riboflavin");
        columns.add("Niacin");
        columns.add("Pantothenic");
        columns.add("VitaminB6");
        columns.add("VitaminB12");
        columns.add("VitaminK");
        columns.add("Folate");
        columns.add("Tryptophan");
        columns.add("Threonine");
        columns.add("Isoleucine");
        columns.add("Leucine");
        columns.add("Lysine");
        columns.add("Methionine");
        columns.add("Cystine");
        columns.add("Phenylalanine");
        columns.add("Tyrosine");
        columns.add("Valine");
        columns.add("Arginine");
        columns.add("Histidine");
        columns.add("Alanine");
        columns.add("Aspartic");
        columns.add("Glutamic");
        columns.add("Glycine");
        columns.add("Proline");
        columns.add("Serine");
        columns.add("Hydroxyproline");
        columns.add("Cholesterol");
        columns.add("Saturated");
        columns.add("DHA");
        columns.add("EPA");
        columns.add("Monounsaturated");
        columns.add("Polyunsaturated");
        columns.add("Linoleic");
        columns.add("AlphaLinolenic");
        columns.add("Weight");
        columns.add("CompleteProtein");
        columns.add("IncompleteProtein");
        columns.add("DigestibleCarbohydrate");
        columns.add("Cost"); //68
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
            LinkedList list = (LinkedList) dbLink.MixResult_Select(mixid, precision);
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
                Double Caffeine = (Double) rowm.get("Caffeine");
                Double Theobromine = (Double) rowm.get("Theobromine");
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
                Double Lutein = (Double) rowm.get("Lutein");
                Double VitaminC = (Double) rowm.get("VitaminC");
                Double Thiamin = (Double) rowm.get("Thiamin");
                Double Riboflavin = (Double) rowm.get("Riboflavin");
                Double Niacin = (Double) rowm.get("Niacin");
                Double Pantothenic = (Double) rowm.get("Pantothenic");
                Double VitaminB6 = (Double) rowm.get("VitaminB6");
                Double VitaminB12 = (Double) rowm.get("VitaminB12");
                Double VitaminK = (Double) rowm.get("VitaminK");
                Double Folate = (Double) rowm.get("Folate");
                Double Tryptophan = (Double) rowm.get("Tryptophan");
                Double Threonine = (Double) rowm.get("Threonine");
                Double Isoleucine = (Double) rowm.get("Isoleucine");
                Double Leucine = (Double) rowm.get("Leucine");
                Double Lysine = (Double) rowm.get("Lysine");
                Double Methionine = (Double) rowm.get("Methionine");
                Double Cystine = (Double) rowm.get("Cystine");
                Double Phenylalanine = (Double) rowm.get("Phenylalanine");
                Double Tyrosine = (Double) rowm.get("Tyrosine");
                Double Valine = (Double) rowm.get("Valine");
                Double Arginine = (Double) rowm.get("Arginine");
                Double Histidine = (Double) rowm.get("Histidine");
                Double Alanine = (Double) rowm.get("Alanine");
                Double Aspartic = (Double) rowm.get("Aspartic");
                Double Glutamic = (Double) rowm.get("Glutamic");
                Double Glycine = (Double) rowm.get("Glycine");
                Double Proline = (Double) rowm.get("Proline");
                Double Serine = (Double) rowm.get("Serine");
                Double Hydroxyproline = (Double) rowm.get("Hydroxyproline");
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
                Double DigestibleCarbohydrate = (Double) rowm.get("DigestibleCarbohydrate");
                Double Cost = (Double) rowm.get("Cost"); //68
                if (numberRounding) {
                    Protein = Double.valueOf(Math.round(Protein));
                    Fat = Double.valueOf(Math.round(Fat));
                    CarbsByDiff = Double.valueOf(Math.round(CarbsByDiff));
                    Energy = Double.valueOf(Math.round(Energy));
                    Sucrose = Double.valueOf(Math.round(Sucrose));
                    Fructose = Double.valueOf(Math.round(Fructose));
                    Lactose = Double.valueOf(Math.round(Lactose));
                    Alcohol = Double.valueOf(Math.round(Alcohol));
                    Water = Double.valueOf(Math.round(Water));
                    Caffeine = Double.valueOf(Math.round(Caffeine));
                    Theobromine = Double.valueOf(Math.round(Theobromine));
                    Fiber = Double.valueOf(Math.round(Fiber));
                    Calcium = Double.valueOf(Math.round(Calcium));
                    Iron = Double.valueOf(Math.round(Iron));
                    Magnesium = Double.valueOf(Math.round(Magnesium));
                    Phosphorus = Double.valueOf(Math.round(Phosphorus));
                    Potassium = Double.valueOf(Math.round(Potassium));
                    Sodium = Double.valueOf(Math.round(Sodium));
                    Zinc = Double.valueOf(Math.round(Zinc));
                    Copper = Double.valueOf(Math.round(Copper));
                    Fluoride = Double.valueOf(Math.round(Fluoride));
                    Manganese = Double.valueOf(Math.round(Manganese));
                    Selenium = Double.valueOf(Math.round(Selenium));
                    VitaminA = Double.valueOf(Math.round(VitaminA));
                    VitaminE = Double.valueOf(Math.round(VitaminE));
                    VitaminD = Double.valueOf(Math.round(VitaminD));
                    Lutein = Double.valueOf(Math.round(Lutein));
                    VitaminC = Double.valueOf(Math.round(VitaminC));
                    Thiamin = Double.valueOf(Math.round(Thiamin));
                    Riboflavin = Double.valueOf(Math.round(Riboflavin));
                    Niacin = Double.valueOf(Math.round(Niacin));
                    Pantothenic = Double.valueOf(Math.round(Pantothenic));
                    VitaminB6 = Double.valueOf(Math.round(VitaminB6));
                    VitaminB12 = Double.valueOf(Math.round(VitaminB12));
                    VitaminK = Double.valueOf(Math.round(VitaminK));
                    Folate = Double.valueOf(Math.round(Folate));
                    Tryptophan = Double.valueOf(Math.round(Tryptophan));
                    Threonine = Double.valueOf(Math.round(Threonine));
                    Isoleucine = Double.valueOf(Math.round(Isoleucine));
                    Leucine = Double.valueOf(Math.round(Leucine));
                    Lysine = Double.valueOf(Math.round(Lysine));
                    Methionine = Double.valueOf(Math.round(Methionine));
                    Cystine = Double.valueOf(Math.round(Cystine));
                    Phenylalanine = Double.valueOf(Math.round(Phenylalanine));
                    Tyrosine = Double.valueOf(Math.round(Tyrosine));
                    Valine = Double.valueOf(Math.round(Valine));
                    Arginine = Double.valueOf(Math.round(Arginine));
                    Histidine = Double.valueOf(Math.round(Histidine));
                    Alanine = Double.valueOf(Math.round(Alanine));
                    Aspartic = Double.valueOf(Math.round(Aspartic));
                    Glutamic = Double.valueOf(Math.round(Glutamic));
                    Glycine = Double.valueOf(Math.round(Glycine));
                    Proline = Double.valueOf(Math.round(Proline));
                    Serine = Double.valueOf(Math.round(Serine));
                    Hydroxyproline = Double.valueOf(Math.round(Hydroxyproline));
                    Cholesterol = Double.valueOf(Math.round(Cholesterol));
                    Saturated = Double.valueOf(Math.round(Saturated));
                    DHA = Double.valueOf(Math.round(DHA));
                    EPA = Double.valueOf(Math.round(EPA));
                    Monounsaturated = Double.valueOf(Math.round(Monounsaturated));
                    Polyunsaturated = Double.valueOf(Math.round(Polyunsaturated));
                    Linoleic = Double.valueOf(Math.round(Linoleic));
                    AlphaLinolenic = Double.valueOf(Math.round(AlphaLinolenic));
                    Weight = Double.valueOf(Math.round(Weight));
                    CompleteProtein = Double.valueOf(Math.round(CompleteProtein));
                    IncompleteProtein = Double.valueOf(Math.round(IncompleteProtein));
                    DigestibleCarbohydrate = Double.valueOf(Math.round(DigestibleCarbohydrate));
                    Cost = Double.valueOf(Math.round(Cost)); //68
                }
                row = new Vector();
                row.add(Name);
                row.add(Protein);
                row.add(Fat);
                row.add(CarbsByDiff);
                row.add(Energy);
                row.add(Sucrose);
                row.add(Fructose);
                row.add(Lactose);
                row.add(Alcohol);
                row.add(Water);
                row.add(Caffeine);
                row.add(Theobromine);
                row.add(Fiber);
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
                row.add(VitaminA);
                row.add(VitaminE);
                row.add(VitaminD);
                row.add(Lutein);
                row.add(VitaminC);
                row.add(Thiamin);
                row.add(Riboflavin);
                row.add(Niacin);
                row.add(Pantothenic);
                row.add(VitaminB6);
                row.add(VitaminB12);
                row.add(VitaminK);
                row.add(Folate);
                row.add(Tryptophan);
                row.add(Threonine);
                row.add(Isoleucine);
                row.add(Leucine);
                row.add(Lysine);
                row.add(Methionine);
                row.add(Cystine);
                row.add(Phenylalanine);
                row.add(Tyrosine);
                row.add(Valine);
                row.add(Arginine);
                row.add(Histidine);
                row.add(Alanine);
                row.add(Aspartic);
                row.add(Glutamic);
                row.add(Glycine);
                row.add(Proline);
                row.add(Serine);
                row.add(Hydroxyproline);
                row.add(Cholesterol);
                row.add(Saturated);
                row.add(DHA);
                row.add(EPA);
                row.add(Monounsaturated);
                row.add(Polyunsaturated);
                row.add(Linoleic);
                row.add(AlphaLinolenic);
                row.add(Weight);
                row.add(CompleteProtein);
                row.add(IncompleteProtein);
                row.add(DigestibleCarbohydrate);
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
