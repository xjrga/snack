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
import io.github.xjrga.snack.dataobject.O_Meal;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import javax.swing.*;

public class ListModelAllocationMeal extends DefaultListModel {

    private final DbLink dbLink;

    public ListModelAllocationMeal( DbLink dbLink ) {
        this.dbLink = dbLink;
    }

    public void reload( String mixid ) {
        this.removeAllElements();
        LinkedList all = null;
        try {
            all = ( LinkedList ) dbLink.Meal_Select_All( mixid );
            Iterator it = all.iterator();
            while( it.hasNext() ) {
                HashMap row = ( HashMap ) it.next();
                String mixid2 = ( String ) row.get( "MIXID" );
                Integer mealid = ( Integer ) row.get( "MEALID" );
                String name = ( String ) row.get( "NAME" );
                Integer order = ( Integer ) row.get( "MEALORDER" );
                O_Meal meal = new O_Meal();
                meal.setMixid( mixid2 );
                meal.setMealid( mealid );
                meal.setName( name );
                meal.setMealOrder( order );
                this.addElement( meal );
            }
        } catch( SQLException e ) {

        }
    }

    public int find_by_mealid( Integer mealid ) {
        int index = 0;
        int size = this.getSize();
        for( int i = 0; i < size; i++ ) {
            O_Meal elementAt = ( O_Meal ) this.getElementAt( i );
            if( elementAt.getMealid().equals( mealid ) ) {
                index = i;
                break;
            }
        }
        return index;
    }
}
