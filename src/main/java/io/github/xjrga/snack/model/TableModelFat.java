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

import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Vector;

public class TableModelFat extends DefaultTableModel implements RoundUp {

    private final DbLink dbLink;
    private Vector columns;
    private Integer precision = 0;

    public TableModelFat(DbLink dbLink) {
        this.dbLink = dbLink;
        this.setColumnIdentifiers();
    }

    private void setColumnIdentifiers() {
        columns = new Vector();
        columns.add("Name"); //0
        columns.add("Weight");
        columns.add("eFat");
        columns.add("Fat");
        columns.add("MUFA");
        columns.add("PUFA");
        columns.add("SFA");
        columns.add("Chol");
        columns.add("LA");
        columns.add("ALA");
        columns.add("DHA");
        columns.add("EPA");
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
                HashMap rowm = (HashMap) it.next();
                String Name = (String) rowm.get("Name");
                Double Weight = (Double) rowm.get(Nutrient.WEIGHT.getLabel());
                Double Fat = (Double) rowm.get(Nutrient.FAT.getLabel());
                Double Cholesterol = (Double) rowm.get(Nutrient.CHOLESTEROL.getLabel());
                Double Saturated = (Double) rowm.get(Nutrient.SFA.getLabel());
                Double DHA = (Double) rowm.get(Nutrient.DHA.getLabel());
                Double EPA = (Double) rowm.get(Nutrient.EPA.getLabel());
                Double Monounsaturated = (Double) rowm.get(Nutrient.MUFA.getLabel());
                Double Polyunsaturated = (Double) rowm.get(Nutrient.PUFA.getLabel());
                Double Linoleic = (Double) rowm.get(Nutrient.LINOLEIC.getLabel());
                Double Linolenic = (Double) rowm.get(Nutrient.LINOLENIC.getLabel());
                Double EnergyFat = (Double) rowm.get(Nutrient.ENERGYFAT.getLabel());
                row = new Vector();
                //
                row.add(Name);
                row.add(Weight);
                row.add(EnergyFat);
                row.add(Fat);
                row.add(Monounsaturated);
                row.add(Polyunsaturated);
                row.add(Saturated);
                row.add(Cholesterol);
                row.add(Linoleic);
                row.add(Linolenic);
                row.add(DHA);
                row.add(EPA);
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
