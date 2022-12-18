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

import io.github.xjrga.snack.model.iface.Reload_mixid;
import io.github.xjrga.snack.data.DbLink;
import io.github.xjrga.snack.dataobject.FoodDataObject;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;
import javax.swing.*;

public class ComboBoxPortionFood
        extends DefaultComboBoxModel
        implements Reload_mixid {

    private final DbLink dbLink;

    public ComboBoxPortionFood( DbLink dbLink ) {
        this.dbLink = dbLink;
    }

    @Override
    public void reload( String mixid ) {
        this.removeAllElements();
        LinkedList<HashMap> list = null;
        try {
            list = ( LinkedList ) dbLink.MixFood_Select_All_By_Foodid( mixid );
            list.forEach( row ->
            {
                String foodid = ( String ) row.get( "FOODID" );
                String name = ( String ) row.get( "NAME" );
                FoodDataObject food = new FoodDataObject();
                food.setFoodId( foodid );
                food.setFoodName( name );
                this.addElement( food );
            } );
        } catch ( SQLException e ) {

        }
    }

    public int find_by_foodid( String foodid ) {
        int index = 0;
        int size = this.getSize();
        for ( int i = 0; i < size; i++ ) {
            FoodDataObject elementAt = ( FoodDataObject ) this.getElementAt( i );
            if ( elementAt.getFoodId().equals( foodid ) ) {
                index = i;
                break;
            }
        }
        return index;
    }
}
