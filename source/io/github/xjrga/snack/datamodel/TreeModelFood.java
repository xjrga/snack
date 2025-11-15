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

import io.github.xjrga.snack.dataobject.MixFoodDO;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

public class TreeModelFood extends DefaultTreeModel {

    private DefaultMutableTreeNode node;

    public TreeModelFood() {

        super(null);
        node = new DefaultMutableTreeNode("Food");
        this.setRoot(node);
    }

    public void reload(List<Map<String, Object>> list) {

        HashMap hm = new HashMap();
        node = new DefaultMutableTreeNode("Food");
        list.forEach(row -> {
            String categoryName = (String) row.get("CATEGORY");
            String foodid = (String) row.get("FOODID");
            String foodName = (String) row.get("FOOD");
            String foodcategoryid = (String) row.get("FOODCATEGORYID");
            DefaultMutableTreeNode category = new DefaultMutableTreeNode(categoryName);
            MixFoodDO foodobject = new MixFoodDO(foodid, foodName);
            DefaultMutableTreeNode food = new DefaultMutableTreeNode(foodobject);

            if (hm.containsKey(foodcategoryid)) {

                category = (DefaultMutableTreeNode) hm.get(foodcategoryid);

            } else {

                hm.put(foodcategoryid, category);
                node.add(category);
            }

            category.add(food);
        });
        this.setRoot(node);
    }

    public void clear() {

        node = new DefaultMutableTreeNode("Food");
        this.setRoot(node);
    }
}
