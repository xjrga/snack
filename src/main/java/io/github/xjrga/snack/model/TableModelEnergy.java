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
import io.github.xjrga.snack.data.Nutrient;
import io.github.xjrga.snack.other.Log;

import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Vector;

public class TableModelEnergy extends DefaultTableModel implements RoundUp {

    private final DbLink dbLink;
    private Vector columns;
    private Integer precision = 0;

    public TableModelEnergy(DbLink dbLink) {
        this.dbLink = dbLink;
        this.setColumnIdentifiers();
    }

    private void setColumnIdentifiers() {
        columns = new Vector();
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

    public void reload(Integer mixid) {
        Vector row = null;
        Vector table = new Vector();
        try {
            LinkedList list = (LinkedList) dbLink.MixResult_Select(mixid, precision);
            Iterator it = list.iterator();
            while (it.hasNext()) {
                HashMap rowm = (HashMap) it.next();
                String Name = (String) rowm.get("Name");
                //Mass
                Double Weight = (Double) rowm.get(Nutrient.WEIGHT.getLabel());
                //Energy
                Double EnergyGross = (Double) rowm.get(Nutrient.ENERGYGROSS.getLabel());
                Double EnergyDigestible = (Double) rowm.get(Nutrient.ENERGYDIGESTIBLE.getLabel());
                Double EnergyNoProtein = (Double) rowm.get(Nutrient.ENERGYNOPROTEIN.getLabel());
                Double EnergyFat = (Double) rowm.get(Nutrient.ENERGYFAT.getLabel());
                Double EnergyCarbohydrate = (Double) rowm.get(Nutrient.ENERGYCARBOHYDRATE.getLabel());
                Double EnergyProtein = (Double) rowm.get(Nutrient.ENERGYPROTEIN.getLabel());
                Double EnergyAlcohol = (Double) rowm.get(Nutrient.ENERGYALCOHOL.getLabel());
                //Macronutrient
                Double Fat = (Double) rowm.get(Nutrient.FAT.getLabel());
                Double DigestibleCarbohydrate = (Double) rowm.get(Nutrient.DIGESTIBLECARBOHYDRATE.getLabel());
                Double Protein = (Double) rowm.get(Nutrient.PROTEIN.getLabel());
                Double Alcohol = (Double) rowm.get(Nutrient.ALCOHOL.getLabel());
                //
                row = new Vector();
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

    @Override
    public void setPrecision(Integer precision) {
        this.precision = precision;
    }
}
