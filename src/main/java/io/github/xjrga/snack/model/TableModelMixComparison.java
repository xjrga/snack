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
import io.github.xjrga.snack.model.iface.Round_up;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public class TableModelMixComparison
        extends DefaultTableModel
        implements Round_up {
    public static int c = 0;
    private final DbLink dbLink;
    private Vector columns;
    private Integer precision = 0;
    public TableModelMixComparison( DbLink dbLink ) {
        this.dbLink = dbLink;
        this.setColumnIdentifiers();
    }
    private void setColumnIdentifiers() {
        columns = new Vector();
        columns.add( "Category" );
        columns.add( "Nutrient" );
        columns.add( "Mix A" );
        columns.add( "Mix B" );
        columns.add( "Diff" );
        this.setColumnIdentifiers( columns );
    }
    @Override
    public Class getColumnClass( int i ) {
        Class returnValue = Object.class;
        switch ( i ) {
            case 0:
                //Category
                returnValue = String.class;
                break;
            case 1:
                //Nutrient
                returnValue = String.class;
                break;
            case 2:
                //Mix 1 Value
                returnValue = Double.class;
                break;
            case 3:
                //Mix 2 Value
                returnValue = Double.class;
                break;
            case 4:
                //Difference
                returnValue = Double.class;
                break;
        }
        return returnValue;
    }
    @Override
    public boolean isCellEditable( int i, int i1 ) {
        return false;
    }
    public void reload( String mixid_a, String mixid_b ) {
        Vector table = new Vector();
        try {
            LinkedList<HashMap> list = ( LinkedList ) dbLink.Mix_GetDiff( mixid_a, mixid_b, precision );
            list.forEach( rowm
                    -> {
                String category = ( String ) rowm.get( "CATEGORY" );
                String nutrient = ( String ) rowm.get( "NUTRIENT" );
                double mix1 = ( double ) rowm.get( "MIXA" );
                double mix2 = ( double ) rowm.get( "MIXB" );
                double diff = ( double ) rowm.get( "DIFF" );
                Vector row = new Vector();
                row.add( category );
                row.add( nutrient );
                row.add( mix1 );
                row.add( mix2 );
                row.add( diff );
                table.add( row );
            } );
            list = ( LinkedList ) dbLink.Mix_GetMealGIDiff( mixid_a, mixid_b, precision );
            list.forEach( rowm
                    -> {
                String nutrient = ( String ) rowm.get( "NUTRIENT" );
                double mix1 = ( double ) rowm.get( "MIX1" );
                double mix2 = ( double ) rowm.get( "MIX2" );
                double diff = ( double ) rowm.get( "DIFF" );
                Vector row = new Vector();
                row.add( "Carbohydrates" );
                row.add( "Carbohydrates, " + nutrient );
                row.add( mix1 );
                row.add( mix2 );
                row.add( diff );
                table.add( row );
            } );
            list = ( LinkedList ) dbLink.Mix_get_essential_fat_ratio_diff( mixid_a, mixid_b, 2 );
            list.forEach( rowm
                    -> {
                String nutrient = ( String ) rowm.get( "NUTRIENT" );
                double mix1 = ( double ) rowm.get( "MIX1" );
                double mix2 = ( double ) rowm.get( "MIX2" );
                double diff = ( double ) rowm.get( "DIFF" );
                Vector row = new Vector();
                row.add( "Fats" );
                row.add( "Fats, " + nutrient );
                row.add( mix1 );
                row.add( mix2 );
                row.add( diff );
                table.add( row );
            } );
            list = ( LinkedList ) dbLink.Mix_get_electrolyte_ratio_diff( mixid_a, mixid_b, 2 );
            list.forEach( rowm
                    -> {
                String nutrient = ( String ) rowm.get( "NUTRIENT" );
                double mix1 = ( double ) rowm.get( "MIX1" );
                double mix2 = ( double ) rowm.get( "MIX2" );
                double diff = ( double ) rowm.get( "DIFF" );
                Vector row = new Vector();
                row.add( "Minerals" );
                row.add( "Minerals, " + nutrient );
                row.add( mix1 );
                row.add( mix2 );
                row.add( diff );
                table.add( row );
            } );
            list = ( LinkedList ) dbLink.Mix_get_polyufat_ratio_diff( mixid_a, mixid_b, 2 );
            list.forEach( rowm
                    -> {
                String nutrient = ( String ) rowm.get( "NUTRIENT" );
                double mix1 = ( double ) rowm.get( "MIX1" );
                double mix2 = ( double ) rowm.get( "MIX2" );
                double diff = ( double ) rowm.get( "DIFF" );
                Vector row = new Vector();
                row.add( "Fats" );
                row.add( "Fats, " + nutrient );
                row.add( mix1 );
                row.add( mix2 );
                row.add( diff );
                table.add( row );
            } );
            list = ( LinkedList ) dbLink.Mix_get_monoufat_ratio_diff( mixid_a, mixid_b, 2 );
            list.forEach( rowm
                    -> {
                String nutrient = ( String ) rowm.get( "NUTRIENT" );
                double mix1 = ( double ) rowm.get( "MIX1" );
                double mix2 = ( double ) rowm.get( "MIX2" );
                double diff = ( double ) rowm.get( "DIFF" );
                Vector row = new Vector();
                row.add( "Fats" );
                row.add( "Fats, " + nutrient );
                row.add( mix1 );
                row.add( mix2 );
                row.add( diff );
                table.add( row );
            } );
            list = ( LinkedList ) dbLink.Mix_GetFQDiff( mixid_a, mixid_b );
            list.forEach( rowm
                    -> {
                String nutrient = ( String ) rowm.get( "NUTRIENT" );
                double mix1 = ( double ) rowm.get( "MIX1" );
                double mix2 = ( double ) rowm.get( "MIX2" );
                double diff = ( double ) rowm.get( "DIFF" );
                Vector row = new Vector();
                row.add( "Energy" );
                row.add( "Energy, " + nutrient + ", FQ" );
                row.add( mix1 );
                row.add( mix2 );
                row.add( diff );
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
