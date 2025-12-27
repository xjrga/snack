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
public class UpdateMixAction {

    private final Connection connection;
    private final String mixid;
    private final Integer lifestageid;
    private final String model;
    private final BigDecimal cost;
    private final BigDecimal deficiency;
    private final BigDecimal excess;

    public UpdateMixAction(
            String mixid,
            Integer lifestageid,
            String model,
            BigDecimal cost,
            BigDecimal deficiency,
            BigDecimal excess ) {
        this.mixid = mixid;
        this.lifestageid = lifestageid;
        this.model = model;
        this.cost = cost;
        this.deficiency = deficiency;
        this.excess = excess;
        connection = Connect.getInstance().getConnection();
    }

    public void execute() {
        try ( CallableStatement proc = connection.prepareCall( "{CALL public.updateMix( ?, ?, ?, ?, ?, ? )}" ) ) {
            proc.setString( 1, mixid );
            proc.setInt( 2, lifestageid );
            proc.setString( 3, model );
            proc.setBigDecimal( 4, cost );
            proc.setBigDecimal( 5, deficiency );
            proc.setBigDecimal( 6, excess );
            proc.execute();
        } catch ( SQLException e ) {
            LoggerImpl.INSTANCE.logProblem( e );
        }
    }
}
