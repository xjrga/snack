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

import io.github.xjrga.snack.model.iface.Reload;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public class TableModelEnergy extends DefaultTableModel implements Reload {
  private final Vector columns;
  private final Result_loader loader;

  public TableModelEnergy(Result_loader loader) {
    this.loader = loader;
    columns = new Vector();
    columns.add("Name");
    columns.add("Weight");
    columns.add("eGross");
    columns.add("eDigest");
    columns.add("eFat");
    columns.add("eCarbs");
    columns.add("eFat+");
    columns.add("eProtein");
    columns.add("eAlcohol");
    this.setDataVector(loader.get_energy_table(), columns);
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
    this.setDataVector(loader.get_energy_table(), columns);
  }
}
