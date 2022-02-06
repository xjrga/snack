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

public class TableModelPercentNutrientConstraints extends DefaultTableModel {

    private final DbLink dbLink;
    private Vector columns;

    public TableModelPercentNutrientConstraints(DbLink dbLink) {
        this.dbLink = dbLink;
        this.setColumnIdentifiers();
    }

    private void setColumnIdentifiers() {
        columns = new Vector();
        columns.add("MixId");
        columns.add("FoodId");
        columns.add("NutrientId");
        columns.add("Food");
        columns.add("Nutrient");
        columns.add("%");
        this.setColumnIdentifiers(columns);
    }

    @Override
    public Class getColumnClass(int i) {
        Class returnValue = Object.class;
        switch (i) {
            case 0:
                //mixid
                returnValue = Integer.class;
                break;
            case 1:
                //foodid
                returnValue = String.class;
                break;
            case 2:
                //nutrientid
                returnValue = String.class;
                break;
            case 3:
                //Food Name
                returnValue = String.class;
                break;
            case 4:
                //Nutrient Name
                returnValue = String.class;
                break;
            case 5:
                //Value
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
            LinkedList list = (LinkedList) dbLink.PercentNutrientConstraint_Select(mixid);
            Iterator it = list.iterator();
            while (it.hasNext()) {
                HashMap rowm = (HashMap) it.next();
                Integer mixid2 = (Integer) rowm.get("MIXID");
                String foodid = (String) rowm.get("FOODID");
                String nutrientid = (String) rowm.get("NUTRIENTID");
                String food = (String) rowm.get("FOOD");
                String nutrient = (String) rowm.get("NUTRIENT");
                Double value = (Double) rowm.get("B");
                row = new Vector();
                row.add(mixid2);
                row.add(foodid);
                row.add(nutrientid);
                row.add(food);
                row.add(nutrient);
                row.add(value);
                table.add(row);
            }
            this.setDataVector(table, columns);
        } catch (SQLException e) {

        }
    }
}
