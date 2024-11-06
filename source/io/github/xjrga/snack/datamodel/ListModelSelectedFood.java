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
import io.github.xjrga.snack.dataobject.FoodDataObject;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;
import javax.swing.DefaultListModel;

public class ListModelSelectedFood extends DefaultListModel implements Reload_mixid {
  private final DbLink dbLink;

  public ListModelSelectedFood(DbLink dbLink) {
    this.dbLink = dbLink;
  }

  @Override
  public void reload(String mixId) {
    this.clear();
    try {
      LinkedList<HashMap> list = (LinkedList) dbLink.MixFood_Select_All_By_Name(mixId);
      list.forEach(
          row -> {
            String foodid = (String) row.get("FOODID");
            String name = (String) row.get("NAME");
            FoodDataObject foodDataObject = new FoodDataObject(foodid, name);
            this.addElement(foodDataObject);
          });
    } catch (SQLException e) {
    }
  }

  public Integer findPosition(String FoodId) {
    int index = 0;
    int size = this.getSize();
    for (int i = 0; i < size; i++) {
      FoodDataObject foodDataObject = (FoodDataObject) this.elementAt(i);
      if (FoodId.equals(foodDataObject.getFoodId())) {
        index = i;
        break;
      }
    }
    return index + 1;
  }

  public String findName(String FoodId) {
    String name = "";
    int size = this.getSize();
    for (int i = 0; i < size; i++) {
      FoodDataObject foodDataObject = (FoodDataObject) this.elementAt(i);
      if (FoodId.equals(foodDataObject.getFoodId())) {
        name = foodDataObject.getFoodName();
        break;
      }
    }
    return name;
  }
}
