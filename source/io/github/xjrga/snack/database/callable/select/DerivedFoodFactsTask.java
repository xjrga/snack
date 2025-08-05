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
public class DerivedFoodFactsTask implements Callable<List<List>> {

	private final Connection connection;
	private final String foodid;

	public DerivedFoodFactsTask( String foodid ) {

		connection = Connect.getInstance().getConnection();
		this.foodid = foodid;

	}

	@Override
	public List<List> call() {

		List<List> table = new ArrayList();

		try ( CallableStatement proc = connection.prepareCall( "{CALL public.getFoodFactsForDerivedItem( ? )}" ) ) {

			proc.setString( 1, foodid );
			ResultSet rs = proc.executeQuery();

			while ( rs.next() ) {

				ArrayList row = new ArrayList();
				row.add( rs.getString( 1 ) );
				row.add( rs.getString( 2 ) );
				row.add( rs.getString( 3 ) );
				row.add( rs.getBigDecimal( 4 ) );
				table.add( row );

			}

		} catch (SQLException e) {

			LoggerImpl.INSTANCE.logProblem( e );

		}

		return table;

	}

}
