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

import io.github.xjrga.snack.data.DbLink;
import io.github.xjrga.snack.dataobject.FoodCategoryDataObject;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;
import javax.swing.*;

public class ComboBoxModelCategory
        extends DefaultComboBoxModel {

    private final DbLink dbLink;

    public ComboBoxModelCategory( DbLink dbLink ) {
        this.dbLink = dbLink;
    }

    public void reload() {
        this.removeAllElements();
        try {
            LinkedList<HashMap> list = ( LinkedList ) dbLink.FoodCategory_Select_All();
            list.forEach( row ->
            {
                String foodcategoryid = ( String ) row.get( "FOODCATEGORYID" );
                String name = ( String ) row.get( "NAME" );
                FoodCategoryDataObject foodCategoryDataObject = new FoodCategoryDataObject();
                foodCategoryDataObject.setFoodCategoryId( foodcategoryid );
                foodCategoryDataObject.setName( name );
                this.addElement( foodCategoryDataObject );
            } );
        } catch ( SQLException e ) {

        }
    }

    public int find( FoodCategoryDataObject foodCategoryDataObject ) {
        int index = 0;
        int size = this.getSize();
        for ( int i = 0; i < size; i++ ) {
            FoodCategoryDataObject elementAt = ( FoodCategoryDataObject ) this.getElementAt( i );
            if ( elementAt.getFoodCategoryId().equals( foodCategoryDataObject.getFoodCategoryId() ) ) {
                index = i;
                break;
            }
        }
        return index;
    }
}
