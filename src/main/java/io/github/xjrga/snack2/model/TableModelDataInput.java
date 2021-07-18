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
import io.github.xjrga.snack2.dataobject.FoodFactSelectForDataInputDataObject;
import io.github.xjrga.snack2.other.Log;

import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Vector;

public class TableModelDataInput extends DefaultTableModel implements RoundUp {

    private final DbLink dbLink;
    private Vector columns;
    private Integer precision = 0;

    public TableModelDataInput(DbLink dbLink) {
        this.dbLink = dbLink;
        this.setColumnIdentifiers();
    }

    private void setColumnIdentifiers() {
        columns = new Vector();
        columns.add("NutrientId");
        columns.add("Category");
        columns.add("Nutrient");
        columns.add("Weight");
        this.setColumnIdentifiers(columns);
    }

    @Override
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
    public boolean isCellEditable(int i, int j) {
        Boolean returnValue = false;
        returnValue = j >= 3;
        return returnValue;
    }

    public void reload(String FoodId) {
        Vector row = null;
        Vector table = new Vector();
        try {
            LinkedList<FoodFactSelectForDataInputDataObject> list = (LinkedList<FoodFactSelectForDataInputDataObject>) dbLink.FoodFact_Select_ForDataInput(FoodId, precision);
            Iterator it = list.iterator();
            while (it.hasNext()) {
                FoodFactSelectForDataInputDataObject foodFactSelectForDataInputDataObject = (FoodFactSelectForDataInputDataObject) it.next();
                row = new Vector();
                row.add(foodFactSelectForDataInputDataObject.getNutrientId());
                row.add(foodFactSelectForDataInputDataObject.getCategory());
                row.add(foodFactSelectForDataInputDataObject.getNutrient());
                row.add(foodFactSelectForDataInputDataObject.getQ());
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

    public Integer find(String NutrientId) {
        int index = 0;
        int rowNo = this.getRowCount();
        int colNo = this.getColumnCount();
        for (int j = 0; j < rowNo; j++) {
            for (int i = 0; i < colNo; i++) {
                if (NutrientId.equals(this.getValueAt(j, 0))) {
                    index = j;
                }
            }
        }
        return index;
    }
}
