package io.github.xjrga.snack.database.callable.select;

import io.github.xjrga.snack.database.Connect;
import io.github.xjrga.snack.logger.LoggerImpl;
import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

/**
 * @author jr
 */
public class FoodStatisticsTask implements Callable<List<Map<String, BigDecimal>>> {

    private final Connection connection;
    private final String foodid;


    public FoodStatisticsTask( String foodid ) {
        connection = Connect.getInstance().getConnection();
        this.foodid = foodid;
    }


    @Override
    public List<Map<String, BigDecimal>> call() {
        List<Map<String, BigDecimal>> list = new ArrayList<>();
        try ( CallableStatement proc = connection.prepareCall( "{CALL public.get_food_statistics( ? )}" ) ) {
            proc.setString( 1, foodid );
            ResultSet rs = proc.executeQuery();
            while ( rs.next() ) {
                Map<String, BigDecimal> row = new HashMap<>();
                row.put( "FATPCT", rs.getBigDecimal( 1 ) );
                row.put( "CARBPCT", rs.getBigDecimal( 2 ) );
                row.put( "PROTEINPCT", rs.getBigDecimal( 3 ) );
                row.put( "ALCOHOLPCT", rs.getBigDecimal( 4 ) );
                row.put( "SATFATPCT", rs.getBigDecimal( 5 ) );
                row.put( "POLYUFATPCT", rs.getBigDecimal( 6 ) );
                row.put( "MONOUFATPCT", rs.getBigDecimal( 7 ) );
                row.put( "LAPCT", rs.getBigDecimal( 8 ) );
                row.put( "ALAPCT", rs.getBigDecimal( 9 ) );
                row.put( "PSRATIO", rs.getBigDecimal( 10 ) );
                row.put( "MSRATIO", rs.getBigDecimal( 11 ) );
                row.put( "ESSENTIALFATRATIO", rs.getBigDecimal( 12 ) );
                row.put( "ELECTROLYTERATIO", rs.getBigDecimal( 13 ) );
                row.put( "FQ", rs.getBigDecimal( 14 ) );
                list.add( row );
            }
        } catch ( Exception e ) {
            LoggerImpl.INSTANCE.logProblem( e );
        }
        return list;
    }
}
