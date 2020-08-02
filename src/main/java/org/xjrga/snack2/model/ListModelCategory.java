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
package org.xjrga.snack2.model;

import org.xjrga.snack2.data.DbLink;
import org.xjrga.snack2.dataobject.FoodCategoryDataObject;
import org.xjrga.snack2.other.Log;

import javax.swing.*;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class ListModelCategory extends DefaultListModel {
    private final DbLink dbLink;

    public ListModelCategory(DbLink dbLink) {
        this.dbLink = dbLink;
    }

    public void reload() {
        this.clear();
        try {
            LinkedList all = (LinkedList) dbLink.FoodCategory_Select_All();
            Iterator it = all.iterator();
            while (it.hasNext()) {
                HashMap row = (HashMap) it.next();
                String foodcategoryid = (String) row.get("FOODCATEGORYID");
                String name = (String) row.get("NAME");
                FoodCategoryDataObject foodCategoryDataObject = new FoodCategoryDataObject();
                foodCategoryDataObject.setFoodCategoryId(foodcategoryid);
                foodCategoryDataObject.setName(name);
                this.addElement(foodCategoryDataObject);
            }
        } catch (SQLException e) {
            Log.getLog().start("files/exception.log");
            Log.getLog().logMessage(e.toString());
            Log.getLog().write();
            Log.getLog().close();
            e.printStackTrace();
        }
    }
}
