package io.github.xjrga.snack.database.callable.insert;

import io.github.xjrga.snack.database.Connect;
import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.Callable;

public class InsertFoodPortionTask implements Callable<Boolean> {

    private final String mixid;
    private final Integer mealid;
    private final String foodid;
    private final BigDecimal pct;
    private final BigDecimal expectedwt;
    private final BigDecimal actualwt;
    private final Connection connection;


    public InsertFoodPortionTask(
            String mixid, Integer mealid, String foodid, BigDecimal pct, BigDecimal expectedwt, BigDecimal actualwt ) {
        this.mixid = mixid;
        this.mealid = mealid;
        this.foodid = foodid;
        this.pct = pct;
        this.expectedwt = expectedwt;
        this.actualwt = actualwt;
        connection = Connect.getInstance().getConnection();
    }


    @Override
    public Boolean call() throws Exception {
        boolean completed = false;
        try ( CallableStatement proc
                = connection.prepareCall( "{CALL public.MealFoodPortion_insert( ?, ?, ?, ?, ?, ? )}" ) ) {
            proc.setString( 1, mixid );
            proc.setInt( 2, mealid );
            proc.setString( 3, foodid );
            proc.setBigDecimal( 4, pct );
            proc.setBigDecimal( 5, expectedwt );
            proc.setBigDecimal( 6, actualwt );
            proc.execute();
            completed = true;
        } catch ( SQLException e ) {
            // LoggerImpl.INSTANCE.logProblem(e);
        } finally {
        }
        return completed;
    }
}
