package io.github.xjrga.snack.database.callable.insert;

import io.github.xjrga.snack.database.Connect;
import io.github.xjrga.snack.logger.LoggerImpl;
import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.Callable;

public class MergeFoodConstraintTask implements Callable<Boolean> {

    private final String mixid;
    private final String foodid;
    private final String nutrientid;
    private final Integer relationshipid;
    private final BigDecimal b;
    private final Connection connection;


    public MergeFoodConstraintTask(
            String mixid, String foodid, String nutrientid, Integer relationshipid, BigDecimal b ) {
        this.mixid = mixid;
        this.foodid = foodid;
        this.nutrientid = nutrientid;
        this.relationshipid = relationshipid;
        this.b = b;
        connection = Connect.getInstance().getConnection();
    }


    @Override
    public Boolean call() throws Exception {
        boolean completed = false;
        try ( CallableStatement proc
                = connection.prepareCall( "{CALL public.FoodNutrientConstraint_Merge( ?, ?, ?, ?, ? )}" ) ) {
            proc.setString( 1, mixid );
            proc.setString( 2, foodid );
            proc.setString( 3, nutrientid );
            proc.setInt( 4, relationshipid );
            proc.setBigDecimal( 5, b );
            proc.execute();
            completed = true;
        } catch ( SQLException e ) {
            LoggerImpl.INSTANCE.logProblem( e );
        }
        return completed;
    }
}
