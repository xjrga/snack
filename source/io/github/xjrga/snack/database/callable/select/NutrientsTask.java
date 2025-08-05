package io.github.xjrga.snack.database.callable.select;

import io.github.xjrga.snack.database.Connect;
import io.github.xjrga.snack.logger.LoggerImpl;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

/**
 * @author jr
 */
public class NutrientsTask implements Callable<List<Map<String, Object>>> {

	private final Connection connection;

	public NutrientsTask() {

		connection = Connect.getInstance().getConnection();

	}

	@Override
	public List<Map<String, Object>> call() {

		LinkedList<Map<String, Object>> list = new LinkedList<>();

		try ( CallableStatement proc = connection.prepareCall( "{CALL public.Nutrient_Select_All()}" ) ) {

			ResultSet rs = proc.executeQuery();

			while ( rs.next() ) {

				Map<String, Object> row = new HashMap<>();
				row.put( "NUTRIENTID", rs.getObject( 1 ) );
				row.put( "NAME", rs.getObject( 2 ) );
				row.put( "VISIBLE", rs.getObject( 3 ) );
				list.add( row );

			}

		} catch (Exception e) {

			LoggerImpl.INSTANCE.logProblem( e );

		}

		return list;

	}

}
