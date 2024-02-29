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

import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public class TableModelVitamins extends DefaultTableModel implements Reload {
  private final Vector columns;
  private final Result_loader loader;

  public TableModelVitamins(Result_loader loader) {
    this.loader = loader;
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
    this.setDataVector(loader.get_vitamins_table(), columns);
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
  public void reload() {
    this.setDataVector(loader.get_vitamins_table(), columns);
  }
}
