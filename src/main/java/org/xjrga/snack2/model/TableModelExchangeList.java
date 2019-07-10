/*
 * Snack: Nutritional Software
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

public class TableModelExchangeList extends DefaultTableModel {

    private final DbLink dbLink;
    private Vector columns;

    public TableModelExchangeList(DbLink dbLink) {
        this.dbLink = dbLink;
        this.setColumnIdentifiers();
    }

    private void setColumnIdentifiers() {

        columns = new Vector();
        columns.add("Food");
        columns.add("Quantity");
        this.setColumnIdentifiers(columns);

    }

    public Class getColumnClass(int i) {

        Class returnValue = Object.class;
        switch (i) {
            case 0:
                returnValue = String.class;
                break;
            case 1:
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

    public void reload(String NutrientId, Double Quantity) {

        Vector row = null;
        Vector table = new Vector();

        try {
            LinkedList list = (LinkedList) dbLink.Food_Exchange_List(NutrientId, Quantity);

            Iterator it = list.iterator();

            while (it.hasNext()) {

                HashMap rowm = (HashMap) it.next();

                String foodname = (String) rowm.get("NAME");
                double value = (double) rowm.get("QUANTITY");

                row = new Vector();

                row.add(foodname);
                row.add(value);

                table.add(row);

            }

            this.setDataVector(table, columns);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
