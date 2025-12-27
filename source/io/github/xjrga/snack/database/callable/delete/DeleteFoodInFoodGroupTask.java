package io.github.xjrga.snack.database.callable.delete;

import io.github.xjrga.snack.database.Connect;
import io.github.xjrga.snack.logger.LoggerImpl;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.Callable;

/**
 * @author jr
 */
public class DeleteFoodInFoodGroupTask implements Callable<Boolean> {

    private final Connection connection;
    private final String groupid;
    private final String mixid;
    private final String foodid;

    public DeleteFoodInFoodGroupTask( String groupid, String mixid, String foodid ) {
        this.groupid = groupid;
        this.mixid = mixid;
        this.foodid = foodid;
        connection = Connect.getInstance().getConnection();
    }

    @Override
    public Boolean call() throws Exception {
        boolean completed = false;
        try ( CallableStatement proc = connection.prepareCall( "{CALL public.FoodGroupList_Delete( ?, ?, ? )}" ) ) {
            proc.setString( 1, groupid );
            proc.setString( 2, mixid );
            proc.setString( 3, foodid );
            proc.execute();
            completed = true;
        } catch ( SQLException e ) {
            LoggerImpl.INSTANCE.logProblem( e );
        }
        return completed;
    }
}
