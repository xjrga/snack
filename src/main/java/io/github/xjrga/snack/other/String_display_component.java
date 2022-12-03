package io.github.xjrga.snack.other;

import java.awt.*;
import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.ArrayList;
import javax.swing.JComponent;
import org.apache.commons.math3.stat.StatUtils;

public class String_display_component
        extends JComponent {

    private String text = "";

    public String_display_component() {

    }

    public String getText() {
        return text;
    }

    public void setText( String text ) {
        this.text = text;
    }

    @Override
    protected void paintComponent( Graphics g ) {
        super.paintComponent( g );
        Graphics2D g2d = ( Graphics2D ) g;
        FontMetrics m = g.getFontMetrics( getFont() );
        int y = getBounds().y;
        int hgt = m.getHeight();
        double factor = get_character_advance_width_avg( g2d ) / 0.86;
        //double factor = get_character_advance_width_mode( g2d ) / 1.25;
        Dimension d = getSize();
        String[] lines = text.split( "\n" );
        for ( String line : lines ) {
            line = line + "\n";
            ArrayList<String> list = get_list( line, d, factor );
            for ( String s : list ) {
                int x = 0;
                y = y + hgt;
                g2d.drawString( s, x, y );
            }
        }
    }

    private ArrayList<String> get_list( String txt, Dimension d, double factor ) {
        ArrayList<String> list = new ArrayList();
        int limit = ( int ) Math.round( d.width / factor );
        for ( int i = 0; i < txt.length(); i = i + limit ) {
            CharSequence subSequence;
            if ( i + limit < txt.length() - 1 ) {
                subSequence = txt.subSequence( i, i + limit );
            } else {
                subSequence = txt.subSequence( i, txt.length() );
            }
            list.add( subSequence.toString() );
        }
        return list;
    }

    private double get_character_advance_width_factor_max( String txt, Graphics2D g ) {
        StringBuilder sb = new StringBuilder();
        FontMetrics m = g.getFontMetrics( getFont() );
        CharacterIterator it = new StringCharacterIterator( txt );
        double max = 0;
        for ( char ch = it.first(); ch != CharacterIterator.DONE; ch = it.next() ) {
            sb.append( ch );
            double subwidth = m.stringWidth( sb.toString() );
            max = Math.max( max, subwidth );
            sb.setLength( 0 );
        }
        return max;
    }

    private double get_character_advance_width_factor_avg( String txt, Graphics2D g ) {
        FontMetrics m = g.getFontMetrics( getFont() );
        double subwidth = m.stringWidth( txt );
        double length = txt.length();
        double factor = subwidth / length;
        return factor;
    }

    private double get_character_advance_width_max( Graphics2D g ) {
        FontMetrics m = g.getFontMetrics( getFont() );
        return StatUtils.max( Utilities.convert_to_double_array( m.getWidths() ) );
    }

    private double get_character_advance_width_avg( Graphics2D g ) {
        FontMetrics m = g.getFontMetrics( getFont() );
        return StatUtils.mean( Utilities.convert_to_double_array( m.getWidths() ) );
    }

    private double get_character_advance_width_mode( Graphics2D g ) {
        FontMetrics m = g.getFontMetrics( getFont() );
        return StatUtils.mode( Utilities.convert_to_double_array( m.getWidths() ) )[ 0 ];
    }

}
