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

public class TableModelVitamins extends DefaultTableModel implements RoundUp {

    private final DbLink dbLink;
    private Vector columns;
    private Integer precision = 0;

    public TableModelVitamins(DbLink dbLink) {
        this.dbLink = dbLink;
        this.setColumnIdentifiers();
    }

    private void setColumnIdentifiers() {
        columns = new Vector();
        columns.add("Name");
        columns.add("Weight");
        columns.add("A");
        columns.add("D");
        columns.add("E");
        columns.add("C");
        columns.add("B1");
        columns.add("B2");
        columns.add("B3");
        columns.add("B6");
        columns.add("B9");
        columns.add("B12");
        columns.add("K");
        columns.add("B5");
        columns.add("B4");
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
                String Name = (String) rowm.get("Name"); //0
                Double VitaminA = (Double) rowm.get(Nutrient.VITAMINA.getLabel());
                Double VitaminE = (Double) rowm.get(Nutrient.VITAMINE.getLabel());
                Double VitaminD = (Double) rowm.get(Nutrient.VITAMIND.getLabel());
                Double VitaminC = (Double) rowm.get(Nutrient.VITAMINC.getLabel());
                Double Thiamin = (Double) rowm.get(Nutrient.THIAMIN.getLabel());
                Double Riboflavin = (Double) rowm.get(Nutrient.RIBOFLAVIN.getLabel());
                Double Niacin = (Double) rowm.get(Nutrient.NIACIN.getLabel());
                Double Pantothenic = (Double) rowm.get(Nutrient.PANTOTHENIC.getLabel());
                Double VitaminB6 = (Double) rowm.get(Nutrient.VITAMINB6.getLabel());
                Double VitaminB12 = (Double) rowm.get(Nutrient.VITAMINB12.getLabel());
                Double Choline = (Double) rowm.get(Nutrient.CHOLINE.getLabel());
                Double VitaminK = (Double) rowm.get(Nutrient.VITAMINK.getLabel());
                Double Folate = (Double) rowm.get(Nutrient.FOLATE.getLabel());
                Double Weight = (Double) rowm.get(Nutrient.WEIGHT.getLabel());
                row = new Vector();
                //
                row.add(Name);
                row.add(Weight);
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

    public void setPrecision(Integer precision) {
        this.precision = precision;
    }
}
