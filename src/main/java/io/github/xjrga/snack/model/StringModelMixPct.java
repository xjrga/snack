package io.github.xjrga.snack.model;

import io.github.xjrga.snack.model.iface.Round_up;
import io.github.xjrga.snack.model.iface.Reload_mixid;
import io.github.xjrga.snack.data.DbLink;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;

public class StringModelMixPct
        implements Round_up, Reload_mixid {

    private final DbLink dbLink;
    private Integer precision = 0;
    private StringBuilder sb;

    public StringModelMixPct( DbLink dbLink ) {
        this.dbLink = dbLink;
    }

    @Override
    public void reload( String MixId ) {
        sb = new StringBuilder();
        try {
            LinkedList<HashMap> list = ( LinkedList ) dbLink.MixResult_Select_Pct( MixId, precision );
            list.forEach( row ->
            {
                Double calories = ( Double ) row.get( "CALORIES" );
                Double fat = ( Double ) row.get( "FAT" );
                Double carbs = ( Double ) row.get( "CARBS" );
                Double protein = ( Double ) row.get( "PROTEIN" );
                Double alcohol = ( Double ) row.get( "ALCOHOL" );
                Double fq = ( Double ) row.get( "FQ" );
                Double satfat = ( Double ) row.get( "SATFAT" );
                Double monoufat = ( Double ) row.get( "MONOUFAT" );
                Double polyufat = ( Double ) row.get( "POLYUFAT" );
                //Calories calculation result is different if we choose digestible carbohydrate or carbohydrate by difference. I chose to use digestible carbohydrate.
                //It is an approximation.
                //This calories result is slightly different that the one reported because it uses digestible carbohydrate in calculation.
                //sb.append("Calories: ");
                //sb.append(mixResultDwPctDataObject.getCalories());
                sb.append( "Fat: " );
                sb.append( fat );
                sb.append( "%\n" );
                sb.append( "Carbohydrate: " );
                sb.append( carbs );
                sb.append( "%\n" );
                sb.append( "Protein: " );
                sb.append( protein );
                sb.append( "%\n" );
                sb.append( "Alcohol: " );
                sb.append( alcohol );
                sb.append( "%\n" );
                sb.append( "Saturated Fatty Acids (SFA): " );
                sb.append( satfat );
                sb.append( "%\n" );
                sb.append( "Monounsaturated Fatty Acids (MUFA): " );
                sb.append( monoufat );
                sb.append( "%\n" );
                sb.append( "Polyunsaturated Fatty Acids (PUFA): " );
                sb.append( polyufat );
                sb.append( "%\n" );
                sb.append( "Food Quotient (FQ): " );
                sb.append( fq );
                sb.append( "\n" );
            } );
        } catch ( SQLException e ) {

        }
    }

    public String get_mix_stats() {
        return sb.toString();
    }

    @Override
    public void set_precision( Integer precision ) {
        this.precision = precision;
    }
}
