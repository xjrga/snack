package io.github.xjrga.snack.database.callable.other;

import io.github.xjrga.snack.database.Connect;
import io.github.xjrga.snack.dataobject.MixDO;
import io.github.xjrga.snack.logger.LoggerImpl;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.concurrent.Callable;

/**
 * @author jr
 */
public class DuplicateMixTask implements Callable<MixDO> {

    private final Connection connection;
    private final String mixid;


    public DuplicateMixTask( String mixid ) {
        connection = Connect.getInstance().getConnection();
        this.mixid = mixid;
    }


    @Override
    public MixDO call() throws Exception {
        String out = "";
        try ( CallableStatement proc = connection.prepareCall( "{CALL public.Mix_Duplicate( ?, ? )}" ) ) {
            proc.registerOutParameter( 1, Types.LONGVARCHAR );
            proc.setString( 2, mixid );
            proc.execute();
            out = proc.getString( 1 );
        } catch ( SQLException e ) {
            LoggerImpl.INSTANCE.logProblem( e );
        }
        return new MixDO( out );
    }
}
