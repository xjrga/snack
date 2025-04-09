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

import io.github.xjrga.snack.database.callable.BackgroundExec;
import io.github.xjrga.snack.database.callable.select.VisibleNutrientsTask;
import io.github.xjrga.snack.dataobject.NutrientDO;
import io.github.xjrga.snack.logger.LoggerImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;

public class NutrientLoader implements Reload {

  private ArrayList<NutrientDO> nutrient_list;

  public NutrientLoader() {}

  public ArrayList<NutrientDO> getList() {
    return nutrient_list;
  }

  @Override
  public void reload() {
    nutrient_list = new ArrayList();
    try {
      Future<List<Map<String, Object>>> task = BackgroundExec.submit(new VisibleNutrientsTask());
      List<Map<String, Object>> list = task.get();
      if (list.isEmpty()) {
        return;
      }
      list.forEach(
          row -> {
            String nutrientid = (String) row.get("NUTRIENTID");
            String name = (String) row.get("NAME");
            NutrientDO nutrientDataObject = new NutrientDO(nutrientid, name, null);
            nutrient_list.add(nutrientDataObject);
          });
    } catch (Exception e) {
      LoggerImpl.INSTANCE.logProblem(e);
    }
  }
}
