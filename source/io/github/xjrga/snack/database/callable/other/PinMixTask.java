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
public class PinMixTask implements Callable<Boolean> {

	private final Connection connection;
	private final String mixid;

	public PinMixTask( String mixid ) {

		this.mixid = mixid;
		connection = Connect.getInstance().getConnection();

	}

	@Override
	public Boolean call() throws Exception {

		boolean completed = false;

		try ( CallableStatement proc = connection.prepareCall( "{CALL public.pin_mix( ? )}" ) ) {

			proc.setString( 1, mixid );
			proc.execute();
			completed = true;

		} catch (SQLException e) {

			LoggerImpl.INSTANCE.logProblem( e );

		} finally {

		}

		return completed;

	}

}
