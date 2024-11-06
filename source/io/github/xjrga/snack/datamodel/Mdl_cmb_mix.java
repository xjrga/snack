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
import io.github.xjrga.snack.dataobject.MixDataObject;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;
import javax.swing.DefaultComboBoxModel;

public class Mdl_cmb_mix extends DefaultComboBoxModel implements Reload {
  private final DbLink dbLink;

  public Mdl_cmb_mix(DbLink dbLink) {
    this.dbLink = dbLink;
  }

  @Override
  public void reload() {
    this.removeAllElements();
    try {
      LinkedList<HashMap> list = (LinkedList) dbLink.Mix_Select_All();
      list.forEach(
          row -> {
            String mixid = (String) row.get("MIXID");
            String name = (String) row.get("NAME");
            String nutrientid = (String) row.get("NUTRIENTID");
            String model = (String) row.get("MODEL");
            MixDataObject mixDataObject = new MixDataObject();
            mixDataObject.setMixId(mixid);
            mixDataObject.setName(name);
            mixDataObject.setNutrientid(nutrientid);
            mixDataObject.setModel(model);
            this.addElement(mixDataObject);
          });
    } catch (SQLException e) {
    }
  }

  public int find_by_mixid(String mixid) {
    int index = -1;
    int size = getSize();
    for (int i = 0; i < size; i++) {
      MixDataObject elementAt = (MixDataObject) getElementAt(i);
      if (elementAt.getMixId().equals(mixid)) {
        index = i;
        break;
      }
    }
    return index;
  }
}
