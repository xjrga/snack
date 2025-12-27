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
public class DeleteFoodGroupConstraintTask implements Callable<Boolean> {

    private final Connection connection;
    private final String mixid;
    private final String groupid;
    private final String nutrientid;
    private final Integer relationshipid;

    public DeleteFoodGroupConstraintTask(
            String mixid, String groupid, String nutrientid, Integer relationshipid ) {
        connection = Connect.getInstance().getConnection();
        this.mixid = mixid;
        this.groupid = groupid;
        this.nutrientid = nutrientid;
        this.relationshipid = relationshipid;
    }

    @Override
    public Boolean call() throws Exception {
        Boolean completed = false;
        try ( CallableStatement proc
                = connection.prepareCall( "{CALL public.FoodGroupQuantityConstraint_Delete( ?, ?, ?, ? )}" ) ) {
            proc.setString( 1, mixid );
            proc.setString( 2, groupid );
            proc.setString( 3, nutrientid );
            proc.setInt( 4, relationshipid );
            proc.execute();
            completed = true;
        } catch ( SQLException e ) {
            LoggerImpl.INSTANCE.logProblem( e );
        }
        return completed;
    }
}
