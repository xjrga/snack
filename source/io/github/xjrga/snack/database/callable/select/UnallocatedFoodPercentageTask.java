package io.github.xjrga.snack.database.callable.select;

import io.github.xjrga.snack.database.Connect;
import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.Callable;

/**
 * @author jr
 */
public class UnallocatedFoodPercentageTask implements Callable<BigDecimal> {

    private final String mixid;
    private final String foodid;
    private final Connection connection;

    public UnallocatedFoodPercentageTask( String mixid, String foodid ) {
        this.mixid = mixid;
        this.foodid = foodid;
        connection = Connect.getInstance().getConnection();
    }

    @Override
    public BigDecimal call() throws Exception {
        BigDecimal out = null;
        try ( CallableStatement proc = connection.prepareCall( "{CALL public.calculate_remaining_percentage( ?, ? )}" ) ) {
            proc.setString( 1, mixid );
            proc.setString( 2, foodid );
            proc.execute();
            ResultSet resultSet = proc.getResultSet();
            resultSet.next();
            out = resultSet.getBigDecimal( 1 );
        } catch ( SQLException e ) {
        }
        return out;
    }
}
