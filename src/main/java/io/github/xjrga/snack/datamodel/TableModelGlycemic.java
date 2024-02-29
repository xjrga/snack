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

public class TableModelGlycemic extends DefaultTableModel implements Round_up, Reload_mixid {
  private final DbLink dbLink;
  private Vector columns;
  private Integer precision = 0;

  public TableModelGlycemic(DbLink dbLink) {
    this.dbLink = dbLink;
    this.setColumnIdentifiers();
  }

  private void setColumnIdentifiers() {
    columns = new Vector();
    columns.add("Name");
    columns.add("Weight");
    columns.add("eCarbs");
    columns.add("Carbs");
    columns.add("%");
    columns.add("GI");
    columns.add("GL");
    columns.add("Meal GI");
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

  @Override
  public void reload(String mixid) {
    Vector table = new Vector();
    try {
      LinkedList<HashMap> list = (LinkedList) dbLink.Mix_GetMealGi(mixid, precision);
      list.forEach(
          rowm -> {
            String Name = (String) rowm.get("name");
            Double Weight = (Double) rowm.get("weight");
            Double DigestibleCarbohydrate = (Double) rowm.get("carbs");
            Double Pct = (Double) rowm.get("pct");
            Double GlycemicIndex = (Double) rowm.get("gi");
            Double GlycemicLoad = (Double) rowm.get("gl");
            Double MealGI = (Double) rowm.get("mealgi");
            Double ecarbs = (Double) rowm.get("ecarbs");
            Vector row = new Vector();
            row.add(Name);
            row.add(Weight);
            row.add(ecarbs);
            row.add(DigestibleCarbohydrate);
            row.add(Pct);
            row.add(GlycemicIndex);
            row.add(GlycemicLoad);
            row.add(MealGI);
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
