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
public class FoodFactsTask implements Callable<List<List>> {

	private final Connection connection;

	public FoodFactsTask() {

		connection = Connect.getInstance().getConnection();

	}

	@Override
	public List<List> call() {

		List<List> table = new ArrayList();

		try ( CallableStatement proc = connection.prepareCall( "{CALL public.Food_Select_Details()}" ) ) {

			ResultSet rs = proc.executeQuery();

			while ( rs.next() ) {

				ArrayList row = new ArrayList();
				row.add( rs.getString( 1 ) );
				row.add( rs.getString( 2 ) );
				row.add( rs.getBigDecimal( 3 ) );
				row.add( rs.getBigDecimal( 4 ) );
				row.add( rs.getBigDecimal( 5 ) );
				row.add( rs.getBigDecimal( 6 ) );
				row.add( rs.getBigDecimal( 7 ) );
				row.add( rs.getBigDecimal( 8 ) );
				row.add( rs.getBigDecimal( 9 ) );
				row.add( rs.getBigDecimal( 10 ) );
				row.add( rs.getBigDecimal( 11 ) );
				row.add( rs.getBigDecimal( 12 ) );
				row.add( rs.getBigDecimal( 13 ) );
				row.add( rs.getBigDecimal( 14 ) );
				row.add( rs.getBigDecimal( 15 ) );
				row.add( rs.getBigDecimal( 16 ) );
				row.add( rs.getBigDecimal( 17 ) );
				row.add( rs.getBigDecimal( 18 ) );
				row.add( rs.getBigDecimal( 19 ) );
				row.add( rs.getBigDecimal( 20 ) );
				row.add( rs.getBigDecimal( 21 ) );
				row.add( rs.getBigDecimal( 22 ) );
				row.add( rs.getBigDecimal( 23 ) );
				row.add( rs.getBigDecimal( 24 ) );
				row.add( rs.getBigDecimal( 25 ) );
				row.add( rs.getBigDecimal( 26 ) );
				row.add( rs.getBigDecimal( 27 ) );
				row.add( rs.getBigDecimal( 28 ) );
				row.add( rs.getBigDecimal( 29 ) );
				// Cholesterol duplicate
				row.add( rs.getBigDecimal( 23 ) );
				row.add( rs.getBigDecimal( 30 ) );
				row.add( rs.getBigDecimal( 31 ) );
				row.add( rs.getBigDecimal( 32 ) );
				row.add( rs.getBigDecimal( 33 ) );
				row.add( rs.getBigDecimal( 34 ) );
				row.add( rs.getBigDecimal( 35 ) );
				row.add( rs.getBigDecimal( 36 ) );
				row.add( rs.getBigDecimal( 37 ) );
				row.add( rs.getBigDecimal( 38 ) );
				row.add( rs.getBigDecimal( 39 ) );
				row.add( rs.getBigDecimal( 40 ) );
				row.add( rs.getBigDecimal( 41 ) );
				row.add( rs.getBigDecimal( 42 ) );
				row.add( rs.getBigDecimal( 43 ) );
				row.add( rs.getBigDecimal( 44 ) );
				row.add( rs.getBigDecimal( 45 ) );
				row.add( rs.getBigDecimal( 46 ) );
				row.add( rs.getBigDecimal( 47 ) );
				row.add( rs.getBigDecimal( 48 ) );
				row.add( rs.getBigDecimal( 49 ) );
				row.add( rs.getBigDecimal( 50 ) );
				row.add( rs.getBigDecimal( 51 ) );
				row.add( rs.getBigDecimal( 52 ) );
				row.add( rs.getBigDecimal( 53 ) );
				row.add( rs.getBigDecimal( 54 ) );
				row.add( rs.getBigDecimal( 55 ) );
				row.add( rs.getBigDecimal( 56 ) );
				row.add( rs.getBigDecimal( 57 ) );
				row.add( rs.getBigDecimal( 58 ) );
				row.add( rs.getBigDecimal( 59 ) );
				row.add( rs.getBigDecimal( 60 ) );
				row.add( rs.getBigDecimal( 61 ) );
				row.add( rs.getBigDecimal( 62 ) );
				row.add( rs.getBigDecimal( 63 ) );
				row.add( rs.getBigDecimal( 64 ) );
				row.add( rs.getBigDecimal( 65 ) );
				row.add( rs.getBigDecimal( 66 ) );
				row.add( rs.getBigDecimal( 67 ) );
				row.add( rs.getBigDecimal( 68 ) );
				row.add( rs.getBigDecimal( 69 ) );
				row.add( rs.getBigDecimal( 70 ) );
				row.add( rs.getBigDecimal( 71 ) );
				row.add( rs.getBigDecimal( 72 ) );
				row.add( rs.getBigDecimal( 73 ) );
				row.add( rs.getBigDecimal( 74 ) );
				row.add( rs.getBigDecimal( 75 ) );
				row.add( rs.getBigDecimal( 76 ) );
				row.add( rs.getBigDecimal( 77 ) );
				row.add( rs.getBigDecimal( 78 ) );
				row.add( rs.getBigDecimal( 79 ) );
				row.add( rs.getBigDecimal( 80 ) );
				row.add( rs.getBigDecimal( 81 ) );
				row.add( rs.getBigDecimal( 82 ) );
				row.add( rs.getBigDecimal( 83 ) );
				row.add( rs.getBigDecimal( 84 ) );
				row.add( rs.getBigDecimal( 85 ) );
				row.add( rs.getBigDecimal( 86 ) );
				row.add( rs.getBigDecimal( 87 ) );
				row.add( rs.getBigDecimal( 88 ) );
				table.add( row );

			}

		} catch (Exception e) {

			LoggerImpl.INSTANCE.logProblem( e );

		} finally {

		}

		return table;

	}

}
