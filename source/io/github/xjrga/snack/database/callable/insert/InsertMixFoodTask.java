package io.github.xjrga.snack.database.callable.insert;

import io.github.xjrga.snack.database.Connect;
import io.github.xjrga.snack.logger.LoggerImpl;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.Callable;

/**
 * @author jr
 */
public class InsertMixFoodTask implements Callable<Boolean> {

	private final Connection connection;
	private final String foodid;
	private final String mixid;

	public InsertMixFoodTask( String mixid, String foodid ) {

		connection = Connect.getInstance().getConnection();
		this.mixid = mixid;
		this.foodid = foodid;

	}

	@Override
	public Boolean call() throws Exception {

		boolean completed = false;

		try ( CallableStatement proc = connection.prepareCall( "{CALL public.MixFood_Insert( ?, ? )}" ) ) {

			proc.setString( 1, mixid );
			proc.setString( 2, foodid );
			proc.execute();
			completed = true;

		} catch (SQLException e) {

			// LoggerImpl.INSTANCE.logProblem(e);
		} finally {

		}

		return completed;

	}

}
