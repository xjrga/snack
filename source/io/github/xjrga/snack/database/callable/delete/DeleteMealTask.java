package io.github.xjrga.snack.database.callable.delete;

import io.github.xjrga.snack.database.Connect;
import io.github.xjrga.snack.logger.LoggerImpl;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.Callable;

/**
 * @author jr
 */
public class DeleteMealTask implements Callable<Boolean> {

	private final Connection connection;
	private final String MixId;
	private final Integer MealId;

	public DeleteMealTask( String MixId, Integer MealId ) {

		connection = Connect.getInstance().getConnection();
		this.MixId = MixId;
		this.MealId = MealId;

	}

	@Override
	public Boolean call() throws Exception {

		Boolean completed = false;

		try ( CallableStatement proc = connection.prepareCall( "{CALL public.Meal_Delete( ?, ? )}" ) ) {

			proc.setString( 1, MixId );
			proc.setInt( 2, MealId );
			proc.execute();
			completed = true;

		} catch (SQLException e) {

			LoggerImpl.INSTANCE.logProblem( e );

		}

		return completed;

	}

}
