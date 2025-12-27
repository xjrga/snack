package io.github.xjrga.snack.database.callable.select;

import io.github.xjrga.snack.database.Connect;
import io.github.xjrga.snack.logger.LoggerImpl;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class MixDiffTask implements Callable<List<List>> {

    private final Connection connection;
    private final String mixid1;
    private final String mixid2;

    public MixDiffTask( String mixdiffida, String mixdiffidb ) {
        connection = Connect.getInstance().getConnection();
        this.mixid1 = mixdiffida;
        this.mixid2 = mixdiffidb;
    }

    @Override
    public List<List> call() {
        ArrayList<List> table = new ArrayList();
        try ( CallableStatement proc = connection.prepareCall( "{CALL public.compareMixes( ?, ? )}" ) ) {
            proc.setString( 1, mixid1 );
            proc.setString( 2, mixid2 );
            ResultSet rs = proc.executeQuery();
            while ( rs.next() ) {
                ArrayList row = new ArrayList();
                row.add( rs.getString( 1 ) );
                row.add( rs.getString( 2 ) );
                row.add( rs.getBigDecimal( 3 ) );
                row.add( rs.getBigDecimal( 4 ) );
                row.add( rs.getBigDecimal( 5 ) );
                table.add( row );
            }
        } catch ( SQLException e ) {
            LoggerImpl.INSTANCE.logProblem( e );
        }
        return table;
    }
}
