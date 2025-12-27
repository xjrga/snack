package io.github.xjrga.snack.database.query;

import io.github.xjrga.snack.database.Connect;
import io.github.xjrga.snack.logger.LoggerImpl;
import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author jr
 */
public class UpdateMixFoodAction {

    private final Connection connection;
    private final String mixid;
    private final String foodid;
    private final BigDecimal x;

    public UpdateMixFoodAction( String mixid, String foodid, BigDecimal x ) {
        this.mixid = mixid;
        this.foodid = foodid;
        this.x = x;
        connection = Connect.getInstance().getConnection();
    }

    public void execute() {
        try ( CallableStatement proc = connection.prepareCall( "{CALL public.MixFood_Update( ?, ?, ? )}" ) ) {
            proc.setString( 1, mixid );
            proc.setString( 2, foodid );
            proc.setBigDecimal( 3, x );
            proc.execute();
        } catch ( SQLException e ) {
            LoggerImpl.INSTANCE.logProblem( e );
        }
    }
}
