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
package io.github.xjrga.snack.model;

import io.github.xjrga.snack.data.DbLink;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public class TableModelNutrientLookup
        extends DefaultTableModel
        implements RoundUp {

    private final DbLink dbLink;
    private Vector columns;
    private Integer precision = 0;

    public TableModelNutrientLookup( DbLink dbLink ) {
        this.dbLink = dbLink;
        this.setColumnIdentifiers();
    }

    private void setColumnIdentifiers() {
        columns = new Vector();
        columns.add( "Food" );
        columns.add( "Weight" );
        columns.add( "Calories" );
        this.setColumnIdentifiers( columns );
    }

    @Override
    public Class getColumnClass( int i ) {
        Class returnValue = Object.class;
        switch ( i ) {
            case 0:
                returnValue = String.class;
                break;
            case 1:
            case 2:
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

    public void reload( String NutrientId, Double Weight ) {
        Vector table = new Vector();
        try {
            LinkedList<HashMap> list = ( LinkedList ) dbLink.Nutrient_Lookup_List( NutrientId, Weight, precision );
            list.forEach( rowm ->
            {
                String foodname = ( String ) rowm.get( "NAME" );
                Double calories = ( Double ) rowm.get( "CALORIES" );
                Double weight = ( Double ) rowm.get( "WEIGHT" );
                Vector row = new Vector();
                row.add( foodname );
                row.add( weight );
                row.add( calories );
                table.add( row );
            } );
            this.setDataVector( table, columns );
        } catch ( SQLException e ) {

        }
    }

    @Override
    public void setPrecision( Integer precision ) {
        this.precision = precision;
    }
}
