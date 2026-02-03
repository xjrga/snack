package io.github.xjrga.snack.database.callable.other;

import io.github.xjrga.snack.database.Connect;
import io.github.xjrga.snack.logger.LoggerImpl;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.Callable;

/**
 * @author jr
 */
public class DenormalizeFoodFactsTask implements Callable<Boolean> {

    private final Connection connection;
    private final String foodid;


    public DenormalizeFoodFactsTask( String foodid ) {
        connection = Connect.getInstance().getConnection();
        this.foodid = foodid;
    }


    @Override
    public Boolean call() throws Exception {
        Boolean completed = false;
        try ( CallableStatement proc = connection.prepareCall( "{CALL CopyFoodFactsToDenormalizedTable( ? )}" ) ) {
            proc.setString( 1, foodid );
            proc.execute();
            completed = true;
        } catch ( SQLException e ) {
            LoggerImpl.INSTANCE.logProblem( e );
        }
        return completed;
    }
}
