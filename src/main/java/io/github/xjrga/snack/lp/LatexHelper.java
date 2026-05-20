package io.github.xjrga.snack.lp;

/**
 *
 * @author jr
 */
public class LatexHelper {

    enum Eq {
        E( "=" ),
        GTE( "\\geq" ),
        LTE( "\\leq" );
        private final String eq;


        Eq( String eq ) {
            this.eq = eq;
        }


        public String get() {
            return eq;
        }
    }


    public String setDocumentClass() {
        return "\\documentclass{article}\n";
    }


    public String addPackages() {
        StringBuilder sb = new StringBuilder();
        sb.append( "\\usepackage[nocomma]{optidef}\n" );
        sb.append( "\\usepackage{pdflscape}\n" );
        return sb.toString();
    }


    public String beginDocument() {
        return "\\begin{document}\n";
    }


    public String endDocument() {
        return "\\end{document}\n";
    }


    public String printString( String txt ) {
        StringBuilder sb = new StringBuilder();
        sb.append( "\\[" );
        sb.append( txt );
        sb.append( "\\]" );
        return sb.toString();
    }


    public String beginLandscape() {
        StringBuilder sb = new StringBuilder();
        //\small
        //\footnotesize
        //\scriptsize
        //\tiny 
        sb.append( "\\begin{landscape}\n" );
        sb.append( "{\\small\n" );
        return sb.toString();
    }


    public String endLandscape() {
        StringBuilder sb = new StringBuilder();
        sb.append( "}\n" );
        sb.append( "\\end{landscape}\n" );
        return sb.toString();
    }


    public String beginMini() {
        return "\\begin{mini*}[0]\n";
    }


    public String endMini() {
        return "\\end{mini*}\n";
    }


    public String addObjective( String lhs ) {
        StringBuilder sb = new StringBuilder();
        sb.append( "{}" );
        sb.append( "{" );
        sb.append( lhs );
        sb.append( "}" );
        sb.append( "{}" );
        sb.append( "{}" );
        return sb.toString();
    }


    public String addConstraint( String lhs, String eq, String rhs, String name ) {
        StringBuilder sb = new StringBuilder();
        sb.append( "\\addConstraint" );
        sb.append( "{" );
        sb.append( lhs );
        sb.append( "}" );
        sb.append( "{" );
        sb.append( eq );
        sb.append( " " );
        sb.append( rhs );
        sb.append( "{" );
        sb.append( " " );
        sb.append( "\\tag{" );
        sb.append( name );
        sb.append( "}" );
        sb.append( "}" );
        return sb.toString();
    }
}
//\begin{landscape}
//    {\small
//    %{\scriptsize
//    \begin{mini*}[2]
//        {}{X20 + X21} {}{}
//            \addConstraint{0.10 X01 + 0.40 X02 + 0.05 X03 + X04  - X12 }{= 1000 \tag{calcium}}
//            \addConstraint{0.12 X01 + 0.21 X02 + 0.34 X03 + X05 - X13 }{= 420 \tag{magnesium}}
//            %\addConstraint{111x_1 + 10x_2}{\geq 0}
//    \end{mini*}
//    }
//\end{landscape}
