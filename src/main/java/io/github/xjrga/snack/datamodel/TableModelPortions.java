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

import io.github.xjrga.snack.database.DbLink;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public class TableModelPortions extends DefaultTableModel implements Round_up, Reload_mixid {
  private final DbLink dbLink;
  private Vector columns;
  private Integer precision = 0;

  public TableModelPortions(DbLink dbLink) {
    this.dbLink = dbLink;
    this.setColumnIdentifiers();
  }

  private void setColumnIdentifiers() {
    columns = new Vector();
    columns.add("MixId");
    columns.add("MealId");
    columns.add("FoodId");
    columns.add("Meal");
    columns.add("Food");
    columns.add("Pct");
    columns.add("Expected");
    columns.add("Actual");
    this.setColumnIdentifiers(columns);
  }

  @Override
  public Class getColumnClass(int i) {
    Class returnValue = Object.class;
    switch (i) {
      case 0:
        returnValue = String.class;
        break;
      case 1:
        returnValue = Integer.class;
        break;
      case 2:
        returnValue = String.class;
        break;
      case 3:
        returnValue = String.class;
        break;
      case 4:
        returnValue = String.class;
        break;
      case 5:
        returnValue = Double.class;
        break;
      case 6:
        returnValue = Double.class;
        break;
      case 7:
        returnValue = Double.class;
        break;
    }
    return returnValue;
  }

  @Override
  public boolean isCellEditable(int i, int i1) {
    return false;
  }

  @Override
  public void reload(String mixid) {
    Vector table = new Vector();
    try {
      LinkedList<HashMap> list = (LinkedList) dbLink.MealFoodPortion_select_all(mixid, precision);
      list.forEach(
          map -> {
            Vector row = new Vector();
            row.add((String) map.get("MIXID"));
            row.add((Integer) map.get("MEALID"));
            row.add((String) map.get("FOODID"));
            row.add((String) map.get("MEAL"));
            row.add((String) map.get("FOOD"));
            row.add((Double) map.get("PCT"));
            row.add((Double) map.get("EXPECTEDWT"));
            row.add((Double) map.get("ACTUALWT"));
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
}
