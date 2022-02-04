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

public class TableModelMinerals extends DefaultTableModel implements RoundUp {

    private final DbLink dbLink;
    private Vector columns;
    private Integer precision = 0;

    public TableModelMinerals(DbLink dbLink) {
        this.dbLink = dbLink;
        this.setColumnIdentifiers();
    }

    private void setColumnIdentifiers() {
        columns = new Vector();
        columns.add("Name");
        columns.add("Weight");
        columns.add("Ca");
        columns.add("P");
        columns.add("Mg");
        columns.add("Fe");
        columns.add("Zn");
        columns.add("Cu");
        columns.add("Mn");
        columns.add("F");
        columns.add("Se");
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
                Double Calcium = (Double) rowm.get(Nutrient.CALCIUM.getLabel());
                Double Iron = (Double) rowm.get(Nutrient.IRON.getLabel());
                Double Magnesium = (Double) rowm.get(Nutrient.MAGNESIUM.getLabel());
                Double Phosphorus = (Double) rowm.get(Nutrient.PHOSPHORUS.getLabel());
                Double Zinc = (Double) rowm.get(Nutrient.ZINC.getLabel());
                Double Copper = (Double) rowm.get(Nutrient.COPPER.getLabel());
                Double Fluoride = (Double) rowm.get(Nutrient.FLUORIDE.getLabel());
                Double Manganese = (Double) rowm.get(Nutrient.MANGANESE.getLabel());
                Double Selenium = (Double) rowm.get(Nutrient.SELENIUM.getLabel());
                Double Weight = (Double) rowm.get(Nutrient.WEIGHT.getLabel());
                row = new Vector();
                //
                row.add(Name);
                row.add(Weight);
                row.add(Calcium);
                row.add(Phosphorus);
                row.add(Magnesium);
                row.add(Iron);
                row.add(Zinc);
                row.add(Copper);
                row.add(Manganese);
                row.add(Fluoride);
                row.add(Selenium);
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
