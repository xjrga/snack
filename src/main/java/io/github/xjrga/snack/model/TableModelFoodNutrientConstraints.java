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
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public class TableModelFoodNutrientConstraints extends DefaultTableModel {

    private final DbLink dbLink;
    private Vector columns;

    public TableModelFoodNutrientConstraints( DbLink dbLink ) {
        this.dbLink = dbLink;
        this.setColumnIdentifiers();
    }

    private void setColumnIdentifiers() {
        columns = new Vector();
        columns.add( "MixId" );
        columns.add( "FoodId" );
        columns.add( "NutrientId" );
        columns.add( "RelationshipId" );
        columns.add( "Food" );
        columns.add( "Nutrient" );
        columns.add( "Eq" );
        columns.add( "Q" );
        this.setColumnIdentifiers( columns );
    }

    @Override
    public Class getColumnClass( int i ) {
        Class returnValue = Object.class;
        switch( i ) {
            case 0:
                //mixid
                returnValue = Integer.class;
                break;
            case 1:
                //foodid
                returnValue = String.class;
                break;
            case 2:
                //nutrientid
                returnValue = String.class;
                break;
            case 3:
                //relationshipid
                returnValue = Integer.class;
                break;
            case 4:
                //Food Name
                returnValue = String.class;
                break;
            case 5:
                //Nutrient Name
                returnValue = String.class;
                break;
            case 6:
                //Relationship Name
                returnValue = String.class;
                break;
            case 7:
                //Value
                returnValue = Double.class;
                break;
        }
        return returnValue;
    }

    @Override
    public boolean isCellEditable( int i, int i1 ) {
        return false;
    }

    public void reload( String mixid ) {
        Vector row = null;
        Vector table = new Vector();
        try {
            LinkedList list = ( LinkedList ) dbLink.FoodNutrientConstraint_Select( mixid );
            Iterator it = list.iterator();
            while( it.hasNext() ) {
                HashMap rowm = ( HashMap ) it.next();
                String mixid2 = ( String ) rowm.get( "MIXID" );
                String foodid = ( String ) rowm.get( "FOODID" );
                String nutrientid = ( String ) rowm.get( "NUTRIENTID" );
                Integer relationshipid = ( Integer ) rowm.get( "RELATIONSHIPID" );
                String food = ( String ) rowm.get( "FOOD" );
                String nutrient = ( String ) rowm.get( "NUTRIENT" );
                String relationship = ( String ) rowm.get( "RELATIONSHIP" );
                double value = ( double ) rowm.get( "B" );
                row = new Vector();
                row.add( mixid2 );
                row.add( foodid );
                row.add( nutrientid );
                row.add( relationshipid );
                row.add( food );
                row.add( nutrient );
                row.add( relationship );
                row.add( value );
                table.add( row );
            }
            this.setDataVector( table, columns );
        } catch( SQLException e ) {

        }
    }
}
