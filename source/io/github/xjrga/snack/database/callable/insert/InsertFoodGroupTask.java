package io.github.xjrga.snack.database.callable.insert;

import io.github.xjrga.snack.database.Connect;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;
import java.util.concurrent.Callable;

/**
 * @author jr
 */
public class InsertFoodGroupTask implements Callable<String> {

    private final Connection connection;
    private final String mixid;
    private final String name;
    private String out;

    public InsertFoodGroupTask( String mixid, String name ) {
        connection = Connect.getInstance().getConnection();
        this.mixid = mixid;
        this.name = name;
    }

    @Override
    public String call() throws Exception {
        try ( CallableStatement proc = connection.prepareCall( "{CALL public.FoodGroup_Insert( ?, ?, ? )}" ) ) {
            proc.registerOutParameter( 1, Types.LONGNVARCHAR );
            proc.setString( 2, mixid );
            proc.setString( 3, name );
            proc.execute();
            out = proc.getString( 1 );
        } catch ( Exception e ) {
        }
        return out;
    }
}
