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

import io.github.xjrga.snack.model.iface.Round_up;
import io.github.xjrga.snack.model.iface.Reload_foodid;
import io.github.xjrga.snack.data.DbLink;
import io.github.xjrga.snack.dataobject.FoodFactSelectForCheckCoefficientsDataObject;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public class TableModelCheckCoefficients
        extends DefaultTableModel
        implements Round_up, Reload_foodid {

    private final DbLink dbLink;
    private Vector columns;
    private Integer precision = 0;

    public TableModelCheckCoefficients( DbLink dbLink ) {
        this.dbLink = dbLink;
        this.setColumnIdentifiers();
    }

    private void setColumnIdentifiers() {
        columns = new Vector();
        columns.add( "NutrientId" );
        columns.add( "Category" );
        columns.add( "Nutrient" );
        columns.add( "Weight" );
        columns.add( "Coefficient" );
        this.setColumnIdentifiers( columns );
    }

    @Override
    public Class getColumnClass( int i ) {
        Class returnValue = Object.class;
        if ( i < 3 ) {
            returnValue = String.class;
        } else {
            returnValue = Double.class;
        }
        return returnValue;
    }

    @Override
    public boolean isCellEditable( int i, int j ) {
        Boolean returnValue = false;
        returnValue = j >= 3;
        return returnValue;
    }

    @Override
    public void reload( String FoodId ) {
        Vector table = new Vector();
        try {
            LinkedList<FoodFactSelectForCheckCoefficientsDataObject> list = ( LinkedList<FoodFactSelectForCheckCoefficientsDataObject> ) dbLink.FoodFact_Select_ForCheckCoefficients( FoodId, precision );
            list.forEach( foodFactSelectForCheckCoefficientsDataObject ->
            {
                Vector row = new Vector();
                row.add( foodFactSelectForCheckCoefficientsDataObject.getNutrientId() );
                row.add( foodFactSelectForCheckCoefficientsDataObject.getCategory() );
                row.add( foodFactSelectForCheckCoefficientsDataObject.getNutrient() );
                row.add( foodFactSelectForCheckCoefficientsDataObject.getQ() );
                row.add( foodFactSelectForCheckCoefficientsDataObject.getC() );
                table.add( row );
            } );
            this.setDataVector( table, columns );
        } catch ( SQLException e ) {

        }
    }

    @Override
    public void set_precision( Integer precision ) {
        this.precision = precision;
    }

    public Integer find( String NutrientId ) {
        int index = 0;
        int rowNo = this.getRowCount();
        int colNo = this.getColumnCount();
        for ( int j = 0; j < rowNo; j++ ) {
            for ( int i = 0; i < colNo; i++ ) {
                if ( NutrientId.equals( this.getValueAt( j, 0 ) ) ) {
                    index = j;
                }
            }
        }
        return index;
    }
}
