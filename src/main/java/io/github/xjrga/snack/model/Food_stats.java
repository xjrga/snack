package io.github.xjrga.snack.model;

import io.github.xjrga.snack.data.DbLink;
import io.github.xjrga.snack.model.iface.Reload_mixid;
import io.github.xjrga.snack.model.iface.Round_up;
import io.github.xjrga.snack.other.Formatted;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;

public class Food_stats
        implements Round_up, Reload_mixid {
    private final DbLink dbLink;
    private Integer precision = 1;
    private StringBuilder sb;
    public Food_stats( DbLink dbLink ) {
        this.dbLink = dbLink;
    }
    @Override
    public void reload( String foodid ) {
        sb = new StringBuilder();
        try {
            LinkedList<HashMap> list = ( LinkedList ) dbLink.get_food_statistics( foodid );
            list.forEach( row
                    -> {
                Formatted fatpct = new Formatted( ( Double ) row.get( "FATPCT" ), precision );
                Formatted carbpct = new Formatted( ( Double ) row.get( "CARBPCT" ), precision );
                Formatted proteinpct = new Formatted( ( Double ) row.get( "PROTEINPCT" ), precision );
                Formatted alcoholpct = new Formatted( ( Double ) row.get( "ALCOHOLPCT" ), precision );
                Formatted fq = new Formatted( ( Double ) row.get( "FQ" ), 3 );
                Formatted satfatpct = new Formatted( ( Double ) row.get( "SATFATPCT" ), precision );
                Formatted monoufatpct = new Formatted( ( Double ) row.get( "MONOUFATPCT" ), precision );
                Formatted polyufatpct = new Formatted( ( Double ) row.get( "POLYUFATPCT" ), precision );
                Formatted essentialfatratio = new Formatted( ( Double ) row.get( "ESSENTIALFATRATIO" ), precision );
                Formatted electrolyteratio = new Formatted( ( Double ) row.get( "ELECTROLYTERATIO" ), precision );
                Formatted lapct = new Formatted( ( Double ) row.get( "LAPCT" ), precision );
                Formatted alapct = new Formatted( ( Double ) row.get( "ALAPCT" ), precision );
                Formatted psratio = new Formatted( ( Double ) row.get( "PSRATIO" ), precision );
                Formatted msratio = new Formatted( ( Double ) row.get( "MSRATIO" ), precision );
                sb.append( "Fat: " );
                sb.append( fatpct );
                sb.append( "%\n" );
                sb.append( "Carbohydrate: " );
                sb.append( carbpct );
                sb.append( "%\n" );
                sb.append( "Protein: " );
                sb.append( proteinpct );
                sb.append( "%\n" );
                sb.append( "Alcohol: " );
                sb.append( alcoholpct );
                sb.append( "%\n" );
                sb.append( "Saturated Fat: " );
                sb.append( satfatpct );
                sb.append( "%\n" );
                sb.append( "Polyunsaturated Fat: " );
                sb.append( polyufatpct );
                sb.append( "%\n" );
                sb.append( "Monounsaturated Fat: " );
                sb.append( monoufatpct );
                sb.append( "%\n" );
                sb.append( "Linoleic Acid: " );
                sb.append( lapct );
                sb.append( "%\n" );
                sb.append( "α-Linolenic Acid: " );
                sb.append( alapct );
                sb.append( "%\n" );
                sb.append( "Ratio PUFA/SFA: " );
                sb.append( psratio );
                sb.append( "\n" );
                sb.append( "Ratio MUFA/SFA: " );
                sb.append( msratio );
                sb.append( "\n" );
                sb.append( "Ratio LA/ALA: " );
                sb.append( essentialfatratio );
                sb.append( "\n" );
                sb.append( "Ratio K/Na: " );
                sb.append( electrolyteratio );
                sb.append( "\n" );
                sb.append( "Food Quotient (FQ): " );
                sb.append( fq );
                sb.append( "\n" );
            } );
        } catch ( SQLException e ) {
        }
    }
    public String get_stats() {
        return sb.toString();
    }
    @Override
    public void set_precision( Integer precision ) {
        this.precision = precision;
    }
}
