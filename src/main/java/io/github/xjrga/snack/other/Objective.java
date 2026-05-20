package io.github.xjrga.snack.other;

import org.apache.commons.lang3.StringUtils;

public enum Objective {
    DRI( getDri(), getDRItip() ),
    DRIUL( getDriUL(), getDRIULtip() ),
    DRIDRI( getDriDri(), getDRIDRItip() );
    private String label;
    private String tooltip;


    Objective( String label, String tooltip ) {
        this.label = StringUtils.center( label, 18 );
        this.tooltip = tooltip;
    }


    public String label() {
        return label;
    }


    public String tooltip() {
        return tooltip;
    }


    @Override
    public String toString() {
        return label;
    }


    private static String getDri() {
        StringBuilder sb = new StringBuilder();
        sb.append( "Inad" );
        sb.append( " " );
        sb.appendCodePoint( 0x2193 );
        return sb.toString();
    }


    private static String getDriUL() {
        StringBuilder sb = new StringBuilder();
        sb.append( "Inad" );
        sb.append( " " );
        sb.appendCodePoint( 0x2193 );
        sb.append( " " );
        sb.append( "Exc" );
        sb.append( " " );
        sb.appendCodePoint( 0x2193 );
        return sb.toString();
    }


    private static String getDriDri() {
        StringBuilder sb = new StringBuilder();
        sb.append( "Inad" );
        sb.append( " " );
        sb.appendCodePoint( 0x2193 );
        sb.append( " " );
        sb.append( "Exc" );
        sb.append( " " );
        sb.appendCodePoint( 0x2193 );
        sb.appendCodePoint( 0x2193 );
        return sb.toString();
    }


    private static String getDRItip() {
        String style = """
                       <style type="text/css">
                       body{
                       font-weight: 100;
                       font-size: 10px;
                       font-family: 'Inconsolata', sans-serif;
                       }
                       </style>
                       """;
        String paragraph = """
                           <p>
                           ✓ Lower Risk of Nutrient Intake Inadequacy
                           </p>
                           """;
        StringBuilder sb = new StringBuilder();
        sb.append( "<html>" );
        sb.append( style );
        sb.append( paragraph );
        sb.append( "</html>" );
        return sb.toString();
    }


    private static String getDRIULtip() {
        String style = """
                       <style type="text/css">
                       body{
                       font-weight: 100;
                       font-size: 10px;
                       font-family: 'Inconsolata', sans-serif;
                       }
                       </style>
                       """;
        String paragraph = """
                           <p>
                           ✓ Lower Risk of Nutrient Intake Inadequacy
                           <br>
                           ✓ Lower Risk of Nutrient Intake Excess
                           </p>
                           """;
        StringBuilder sb = new StringBuilder();
        sb.append( "<html>" );
        sb.append( style );
        sb.append( paragraph );
        sb.append( "</html>" );
        return sb.toString();
    }


    private static String getDRIDRItip() {
        String style = """
                       <style type="text/css">
                       body{
                       font-weight: 100;
                       font-size: 10px;
                       font-family: 'Inconsolata', sans-serif;
                       }
                       </style>
                       """;
        String paragraph = """
                           <p>
                           ✓ Lower Risk of Nutrient Intake Inadequacy
                           <br>
                           ✓ Lowest Risk of Nutrient Intake Excess
                           </p>
                           """;
        StringBuilder sb = new StringBuilder();
        sb.append( "<html>" );
        sb.append( style );
        sb.append( paragraph );
        sb.append( "</html>" );
        return sb.toString();
    }
}
