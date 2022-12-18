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
import io.github.xjrga.snack.data.DbLink;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public class TableModelRdaCheck
        extends DefaultTableModel
        implements Round_up {

    private final DbLink dbLink;
    private Vector columns;
    private Integer precision = 0;

    public TableModelRdaCheck( DbLink dbLink ) {
        this.dbLink = dbLink;
        this.setColumnIdentifiers();
    }

    private void setColumnIdentifiers() {
        columns = new Vector();
        columns.add( "NutrientId" );
        columns.add( "Nutrient" );
        columns.add( "Mix" );
        columns.add( "RDA" );
        columns.add( "% RDA" );
        columns.add( "UL" );
        columns.add( "% UL" );
        this.setColumnIdentifiers( columns );
    }

    @Override
    public Class getColumnClass( int i ) {
        Class returnValue = Object.class;
        if ( i < 2 ) {
            returnValue = String.class;
        } else {
            returnValue = Double.class;
        }
        return returnValue;
    }

    @Override
    public boolean isCellEditable( int i, int i1 ) {
        return false;
    }

    public void reload( String MixId, Integer LifeStageId ) {
        Vector table = new Vector();
        try {
            LinkedList<HashMap> list = ( LinkedList ) dbLink.Mix_GetRdaDiff( MixId, LifeStageId, precision );
            list.forEach( rowm ->
            {
                String nutrientid = ( String ) rowm.get( "NUTRIENTID" );
                String nutrient = ( String ) rowm.get( "NAME" );
                Double mix = ( Double ) rowm.get( "MIX" );
                Double rda = ( Double ) rowm.get( "RDA" );
                Double pctrda = ( Double ) rowm.get( "PCTRDA" );
                Double ul = ( Double ) rowm.get( "UL" );
                Double pctul = ( Double ) rowm.get( "PCTUL" );
                Vector row = new Vector();
                row.add( nutrientid );
                row.add( nutrient );
                row.add( mix );
                row.add( rda );
                row.add( pctrda );
                row.add( ul );
                row.add( pctul );
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
}
