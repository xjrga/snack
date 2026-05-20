package io.github.xjrga.snack.database.callable.delete;

import io.github.xjrga.snack.database.Connect;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.Callable;

/**
 * @author jr
 */
public class DeleteFoodGroupTask implements Callable<Boolean> {

    private final Connection connection;
    private final String mixid;
    private final String groupid;


    public DeleteFoodGroupTask( String mixid, String groupid ) {
        connection = Connect.getInstance().getConnection();
        this.mixid = mixid;
        this.groupid = groupid;
    }


    @Override
    public Boolean call() throws Exception {
        Boolean completed = false;
        try ( CallableStatement proc = connection.prepareCall( "{CALL public.FoodGroup_Delete( ?, ? )}" ) ) {
            proc.setString( 1, mixid );
            proc.setString( 2, groupid );
            proc.execute();
            completed = true;
        } catch ( SQLException e ) {
        }
        return completed;
    }
}
