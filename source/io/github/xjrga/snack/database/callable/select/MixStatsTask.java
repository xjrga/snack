package io.github.xjrga.snack.database.callable.select;

import io.github.xjrga.snack.database.Connect;
import io.github.xjrga.snack.logger.LoggerImpl;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

/**
 * @author jr
 */
public class MixStatsTask implements Callable<List<Map<String, Object>>> {

    private final Connection connection;
    private final String mixid;

    public MixStatsTask( String mixid ) {
        connection = Connect.getInstance().getConnection();
        this.mixid = mixid;
    }

    @Override
    public List<Map<String, Object>> call() {
        LinkedList<Map<String, Object>> list = new LinkedList<>();
        try ( CallableStatement proc = connection.prepareCall( "{CALL public.MixResult_Select_Pct( ? )}" ) ) {
            proc.setString( 1, mixid );
            ResultSet rs = proc.executeQuery();
            while ( rs.next() ) {
                Map<String, Object> row = new HashMap<>();
                row.put( "CALORIES", rs.getBigDecimal( 1 ) );
                row.put( "FATPCT", rs.getBigDecimal( 2 ) );
                row.put( "CARBPCT", rs.getBigDecimal( 3 ) );
                row.put( "PROTEINPCT", rs.getBigDecimal( 4 ) );
                row.put( "ALCOHOLPCT", rs.getBigDecimal( 5 ) );
                row.put( "FQ", rs.getBigDecimal( 6 ) );
                row.put( "SATFATPCT", rs.getBigDecimal( 7 ) );
                row.put( "MONOUFATPCT", rs.getBigDecimal( 8 ) );
                row.put( "POLYUFATPCT", rs.getBigDecimal( 9 ) );
                row.put( "ESSENTIALFATRATIO", rs.getBigDecimal( 10 ) );
                row.put( "ELECTROLYTERATIO", rs.getBigDecimal( 11 ) );
                row.put( "LAPCT", rs.getBigDecimal( 12 ) );
                row.put( "ALAPCT", rs.getBigDecimal( 13 ) );
                row.put( "PSRATIO", rs.getBigDecimal( 14 ) );
                row.put( "MSRATIO", rs.getBigDecimal( 15 ) );
                list.add( row );
            }
        } catch ( Exception e ) {
            LoggerImpl.INSTANCE.logProblem( e );
        }
        return list;
    }
}
