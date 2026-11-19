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

import io.github.xjrga.snack.database.callable.select.GroupTask;
import io.github.xjrga.snack.launcher.TaskLauncher;
import io.github.xjrga.snack.logger.LoggerImpl;
import io.github.xjrga.snack.records.Records;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

public class GroupLoader implements ReloadMixid {

    private ArrayList<Records.Group> group_list;

    public GroupLoader() {
    }

    public ArrayList<Records.Group> get() {
        return group_list;
    }

    @Override
    public void reload(String mixid) {
        group_list = new ArrayList();
        try {
            Future<List<Records.Group>> task = TaskLauncher.submit(new GroupTask(mixid));
            List<Records.Group> foods = task.get();
            foods.forEach(row -> {
                group_list.add(row);
            });
        } catch (Exception e) {
            LoggerImpl.INSTANCE.logProblem(e);
        }
    }
}
