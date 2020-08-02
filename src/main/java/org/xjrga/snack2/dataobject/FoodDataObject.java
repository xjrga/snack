/*
 * Snack: Nutritional Software
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
package org.xjrga.snack2.dataobject;

public class FoodDataObject {
    private String foodid;
    private String foodname;

    public FoodDataObject() {
    }

    public FoodDataObject(String foodid, String foodname) {
        this.setFoodId(foodid);
        this.setFoodName(foodname);
    }

    public String getFoodId() {
        return foodid;
    }

    public void setFoodId(String foodid) {
        this.foodid = foodid;
    }

    @Override
    public String toString() {
        return getFoodName();
    }

    public String getFoodName() {
        return foodname;
    }

    public void setFoodName(String foodname) {
        this.foodname = foodname;
    }
}
