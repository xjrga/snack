package io.github.xjrga.snack.database.callable.select;

import io.github.xjrga.snack.database.Connect;
import io.github.xjrga.snack.logger.LoggerImpl;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * @author jr
 */
public class DriDiffTask implements Callable<List<List>> {

    private final Connection connection;
    private final String mixid;
    private final Integer lifestage;


    public DriDiffTask( String mixid, Integer lifestage ) {
        connection = Connect.getInstance().getConnection();
        this.mixid = mixid;
        this.lifestage = lifestage;
    }


    @Override
    public List<List> call() {
        List<List> table = new ArrayList();
        try ( CallableStatement proc = connection.prepareCall( "{CALL public.Mix_getDriDiff( ?, ? )}" ) ) {
            proc.setString( 1, mixid );
            proc.setInt( 2, lifestage );
            ResultSet rs = proc.executeQuery();
            while ( rs.next() ) {
                ArrayList row = new ArrayList();
                row.add( rs.getString( 1 ) );
                row.add( rs.getString( 2 ) );
                row.add( rs.getBigDecimal( 3 ) );
                row.add( rs.getBigDecimal( 4 ) );
                row.add( rs.getBigDecimal( 5 ) );
                row.add( rs.getBigDecimal( 6 ) );
                row.add( rs.getBigDecimal( 7 ) );
                table.add( row );
            }
        } catch ( Exception e ) {
            LoggerImpl.INSTANCE.logProblem( e );
        }
        return table;
    }
}
