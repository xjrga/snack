package io.github.xjrga.snack.dataobject;

import java.util.ArrayList;

/**
 * @author jr
 */
public class LhsContainer {

    private final ArrayList<Lhs> list;


    public LhsContainer() {
        list = new ArrayList();
    }


    public void add( Lhs lhs ) {
        list.add( lhs );
    }


    public double[] getCoefficients() {
        int size = list.size();
        double[] coefficients = new double[ size ];
        for ( int i = 0; i < size; i++ ) {
            Lhs lhs = list.get( i );
            coefficients[ i ] = lhs.getCoefficient().doubleValue();
        }
        return coefficients;
    }
}
