package io.github.xjrga.snack.other;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Formatted {

    private String fx = null;

    public Formatted( double x, int precision ) {
        DecimalFormat formatter = new DecimalFormat();
        formatter.setRoundingMode( RoundingMode.HALF_UP );
        StringBuilder sb = new StringBuilder();
        sb.append( "#####" );
        if ( precision > 0 ) {
            sb.append( "." );
        }
        for ( int i = 0; i < precision; i++ ) {
            sb.append( "#" );
        }
        formatter.applyPattern( sb.toString() );
        fx = formatter.format( x );
    }

    @Override
    public String toString() {
        return fx;
    }
}
