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
import io.github.xjrga.snack.dataobject.NutrientDataObject;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class Nutrient_loader implements Reload {
  private final DbLink dbLink;
  private ArrayList<NutrientDataObject> nutrient_list;

  public Nutrient_loader(DbLink dbLink) {
    this.dbLink = dbLink;
  }

  @Override
  public void reload() {
    nutrient_list = new ArrayList();
    try {
      LinkedList<HashMap> list = (LinkedList) dbLink.Nutrient_Select_All_Visible();
      list.forEach(
          row -> {
            String nutrientid = (String) row.get("NUTRIENTID");
            String name = (String) row.get("NAME");
            NutrientDataObject nutrientDataObject = new NutrientDataObject(nutrientid, name, null);
            nutrient_list.add(nutrientDataObject);
          });
    } catch (SQLException e) {
    }
  }

  public ArrayList<NutrientDataObject> get_nutrient_list() {
    return nutrient_list;
  }
}
