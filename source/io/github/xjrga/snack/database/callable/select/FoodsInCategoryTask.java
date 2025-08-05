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
public class FoodsInCategoryTask implements Callable<List<List>> {

	private final Connection connection;
	private final String categoryid;

	public FoodsInCategoryTask( String categoryid ) {

		connection = Connect.getInstance().getConnection();
		this.categoryid = categoryid;

	}

	@Override
	public List<List> call() {

		List<List> table = new ArrayList();

		try ( CallableStatement proc = connection.prepareCall( "{CALL public.Food_Select_By_Category( ? )}" ) ) {

			proc.setString( 1, categoryid );
			ResultSet rs = proc.executeQuery();

			while ( rs.next() ) {

				ArrayList row = new ArrayList();
				row.add( rs.getString( 1 ) );
				row.add( rs.getString( 2 ) );
				table.add( row );

			}

		} catch (SQLException e) {

			LoggerImpl.INSTANCE.logProblem( e );

		}

		return table;

	}

}
