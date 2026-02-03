package io.github.xjrga.snack.database.callable.update;

import io.github.xjrga.snack.database.Connect;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.Callable;

/**
 * @author jr
 */
public class UpdateFoodGroupTask implements Callable<Boolean> {

    private final Connection connection;
    private final String mixid;
    private final String foodgroupid;
    private final String foodgroupname;


    public UpdateFoodGroupTask( String mixid, String categoryid, String categoryname ) {
        connection = Connect.getInstance().getConnection();
        this.mixid = mixid;
        this.foodgroupid = categoryid;
        this.foodgroupname = categoryname;
    }


    @Override
    public Boolean call() throws Exception {
        Boolean completed = false;
        try ( CallableStatement proc = connection.prepareCall( "{CALL public.FoodGroup_Update( ?, ?, ? )}" ) ) {
            proc.setString( 1, mixid );
            proc.setString( 2, foodgroupid );
            proc.setString( 3, foodgroupname );
            proc.execute();
            completed = true;
        } catch ( SQLException e ) {
        }
        return completed;
    }
}
