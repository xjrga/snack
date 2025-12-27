package io.github.xjrga.snack.database.callable.update;

import io.github.xjrga.snack.database.Connect;
import io.github.xjrga.snack.logger.LoggerImpl;
import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.util.concurrent.Callable;

/**
 * @author jr
 */
public class UpdateFoodPortionActualWeightTask implements Callable<Boolean> {

    private final Connection connection;
    private final String mixid;
    private final Integer mealid;
    private final String foodid;
    private final BigDecimal actualwt;

    public UpdateFoodPortionActualWeightTask( String mixid, Integer mealid, String foodid, BigDecimal actualwt ) {
        this.mixid = mixid;
        this.mealid = mealid;
        this.foodid = foodid;
        this.actualwt = actualwt;
        connection = Connect.getInstance().getConnection();
    }

    @Override
    public Boolean call() throws Exception {
        boolean completed = false;
        try ( CallableStatement proc
                = connection.prepareCall( "{CALL public.MealFoodPortion_update_actualwt( ?, ?, ?, ? )}" ) ) {
            proc.setString( 1, mixid );
            proc.setInt( 2, mealid );
            proc.setString( 3, foodid );
            proc.setBigDecimal( 4, actualwt );
            proc.execute();
            completed = true;
        } catch ( Exception e ) {
            LoggerImpl.INSTANCE.logProblem( e );
        }
        return completed;
    }
}
