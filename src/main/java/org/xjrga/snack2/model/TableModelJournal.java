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

public class TableModelJournal extends DefaultTableModel {

    private final DbLink dbLink;
    private Vector columns;

    public TableModelJournal(DbLink dbLink) {
        this.dbLink = dbLink;
        this.setColumnIdentifiers();
    }

    private void setColumnIdentifiers() {

        columns = new Vector();
        columns.add("Name");
        columns.add("Quantity");
        columns.add("Calories");
        columns.add("Protein");
        columns.add("Complete");
        columns.add("Incomplete");
        columns.add("Fat");
        columns.add("Carbohydrate");
        columns.add("Fiber");
        columns.add("Saturated");
        columns.add("Monounsaturated");
        columns.add("Polyunsaturated");
        columns.add("Cholesterol");
        columns.add("Alcohol");
        columns.add("Sodium");
        columns.add("Potassium");
        columns.add("Calcium");
        columns.add("Magnesium");
        columns.add("Cost");
        this.setColumnIdentifiers(columns);

    }

    public Class getColumnClass(int i) {

        Class returnValue = Object.class;
        switch (i) {

            case 0:
                returnValue = String.class;
                break;
            case 1:
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
                returnValue = Double.class;
                break;
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
            LinkedList list = (LinkedList) dbLink.MixResultDW_Select(mixid);
            Iterator it = list.iterator();

            while (it.hasNext()) {

                HashMap rowm = (HashMap) it.next();

                String Name = (String) rowm.get("NAME");
                Double Protein = (Double) rowm.get("PROTEIN");
                Double Fat = (Double) rowm.get("FAT");
                Double Kcal = (Double) rowm.get("KCAL");
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
                Double CarbsDigestible = (Double) rowm.get("CARBSDIGESTIBLE");
                Double Cost = (Double) rowm.get("COST");


                row = new Vector();

                row.add(Name);
                row.add(Quantity);
                row.add(Kcal);
                row.add(Protein);
                row.add(Complete);
                row.add(Incomplete);
                row.add(Fat);
                row.add(CarbsDigestible);
                row.add(Fiber);
                row.add(SatFat);
                row.add(Monoufat);
                row.add(Polyufat);
                row.add(Cholesterol);
                row.add(Alcohol);
                row.add(Sodium);
                row.add(Potassium);
                row.add(Calcium);
                row.add(Magnesium);
                row.add(Cost);


                table.add(row);
            }

            this.setDataVector(table, columns);

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
