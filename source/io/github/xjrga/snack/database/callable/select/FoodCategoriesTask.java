package io.github.xjrga.snack.database.callable.select;

import io.github.xjrga.snack.database.Connect;
import io.github.xjrga.snack.logger.LoggerImpl;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * @author jr
 */
public class FoodCategoriesTask implements Callable<List<List>> {

	private final Connection connection;

	public FoodCategoriesTask() {

		connection = Connect.getInstance().getConnection();

	}

	@Override
	public List<List> call() {

		ArrayList<List> table = new ArrayList();

		try ( CallableStatement proc = connection.prepareCall( "{CALL public.FoodCategory_Select_All()}" ) ) {

			ResultSet rs = proc.executeQuery();

			while ( rs.next() ) {

				ArrayList row = new ArrayList();
				row.add( rs.getString( 1 ) );
				row.add( rs.getString( 2 ) );
				table.add( row );

			}

		} catch (Exception e) {

			LoggerImpl.INSTANCE.logProblem( e );

		}

		return table;

	}

}
