package io.github.xjrga.snack.database.callable.select;

import io.github.xjrga.snack.database.Connect;
import io.github.xjrga.snack.logger.LoggerImpl;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

/**
 * @author jr
 */
public class NamedMixFoodSortedByIdTask implements Callable<List<Map<String, String>>> {

    private final Connection connection;
    private final String mixid;

    public NamedMixFoodSortedByIdTask( String mixid ) {
        connection = Connect.getInstance().getConnection();
        this.mixid = mixid;
    }

    @Override
    public List<Map<String, String>> call() {
        ArrayList<Map<String, String>> list = new ArrayList<>();
        try ( CallableStatement proc = connection.prepareCall( "{CALL public.MixFood_Select_All_By_FoodId(?)}" ) ) {
            proc.setString( 1, mixid );
            ResultSet rs = proc.executeQuery();
            while ( rs.next() ) {
                Map<String, String> row = new HashMap<>();
                row.put( "FOODID", rs.getString( 1 ) );
                row.put( "NAME", rs.getString( 2 ) );
                list.add( row );
            }
        } catch ( SQLException e ) {
            LoggerImpl.INSTANCE.logProblem( e );
        }
        return list;
    }
}
