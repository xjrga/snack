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
import org.xjrga.snack2.dataobject.FoodDataObject;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class TreeModelFood extends DefaultTreeModel {

    private final DbLink dbLink;
    private DefaultMutableTreeNode node;

    public TreeModelFood(DbLink dblink) {

        super(null);
        this.dbLink = dblink;
        node = new DefaultMutableTreeNode("Food");
        this.setRoot(node);

    }

    public void reload() {

        HashMap hm = new HashMap();
        LinkedList list = null;
        try {
            list = (LinkedList) dbLink.Food_Select_All();
            Iterator it = list.iterator();

            node = new DefaultMutableTreeNode("Food");

            while (it.hasNext()) {

                HashMap row = (HashMap) it.next();

                String categoryName = (String) row.get("CATEGORY");
                String foodid = (String) row.get("FOODID");
                String foodName = (String) row.get("FOOD");

                DefaultMutableTreeNode category = new DefaultMutableTreeNode(categoryName);
                FoodDataObject foodobject = new FoodDataObject(foodid, foodName);
                DefaultMutableTreeNode food = new DefaultMutableTreeNode(foodobject);

                if (hm.containsKey(categoryName)) {

                    category = (DefaultMutableTreeNode) hm.get(categoryName);
                    category.add(food);

                } else {

                    hm.put(categoryName, category);
                    node.add(category);
                    category.add(food);

                }

            }
            this.setRoot(node);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
