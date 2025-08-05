package io.github.xjrga.snack.database.callable.select;

import io.github.xjrga.snack.database.Connect;
import io.github.xjrga.snack.logger.LoggerImpl;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * @author jr
 */
public class FoodDiffTask implements Callable<List<List>> {

	private final Connection connection;
	private final String foodida;
	private final String foodidb;

	public FoodDiffTask( String foodida, String foodidb ) {

		connection = Connect.getInstance().getConnection();
		this.foodida = foodida;
		this.foodidb = foodidb;

	}

	@Override
	public List<List> call() {

		List<List> table = new ArrayList();

		try ( CallableStatement proc = connection.prepareCall( "{CALL public.compareFoodItems( ?, ? )}" ) ) {

			proc.setString( 1, foodida );
			proc.setString( 2, foodidb );
			ResultSet rs = proc.executeQuery();

			while ( rs.next() ) {

				ArrayList row = new ArrayList();
				row.add( rs.getString( 1 ) );
				row.add( rs.getString( 2 ) );
				row.add( rs.getBigDecimal( 3 ) );
				row.add( rs.getBigDecimal( 4 ) );
				row.add( rs.getBigDecimal( 5 ) );
				table.add( row );

			}

		} catch (SQLException e) {

			LoggerImpl.INSTANCE.logProblem( e );

		}

		return table;

	}

}
