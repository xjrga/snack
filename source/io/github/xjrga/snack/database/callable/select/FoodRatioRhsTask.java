package io.github.xjrga.snack.database.callable.select;

import io.github.xjrga.snack.database.Connect;
import io.github.xjrga.snack.logger.LoggerImpl;
import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

public class FoodRatioRhsTask implements Callable<List<Map<String, Object>>> {

	private final List<Map<String, Object>> lst;
	private final String mixid;
	private final Connection connection;

	public FoodRatioRhsTask( String mixid ) {

		this.mixid = mixid;
		lst = new ArrayList();
		connection = Connect.getInstance().getConnection();

	}

	@Override
	public List<Map<String, Object>> call() {

		try {

			CallableStatement proc = connection.prepareCall( "{CALL public.foodnutrientratio_rhs( ? )}" );
			proc.setString( 1, mixid );
			ResultSet rs = proc.executeQuery();

			while ( rs.next() ) {

				Map<String, Object> row = new HashMap();
				// Integer mixid = rs.getString(1);
				String food_id_1 = rs.getString( 2 );
				String nutrient_id_1 = rs.getString( 3 );
				String food_id_2 = rs.getString( 4 );
				String nutrient_id_2 = rs.getString( 5 );
				Integer relationshipid = rs.getInt( 6 );
				BigDecimal a = rs.getBigDecimal( 7 );
				BigDecimal b = rs.getBigDecimal( 8 );
				String food1 = rs.getString( 9 );
				String nutrient1 = rs.getString( 10 );
				String food2 = rs.getString( 11 );
				String nutrient2 = rs.getString( 12 );
				String eq = rs.getString( 13 );
				row.put( "FOOD_ID_1", food_id_1 );
				row.put( "NUTRIENT_ID_1", nutrient_id_1 );
				row.put( "FOOD_ID_2", food_id_2 );
				row.put( "NUTRIENT_ID_2", nutrient_id_2 );
				row.put( "RELATIONSHIPID", relationshipid );
				row.put( "A", a );
				row.put( "B", b );
				row.put( "FOOD1", food1 );
				row.put( "NUTRIENT1", nutrient1 );
				row.put( "FOOD2", food2 );
				row.put( "NUTRIENT2", nutrient2 );
				row.put( "EQ", eq );
				lst.add( row );

			}

		} catch (Exception e) {

			LoggerImpl.INSTANCE.logProblem( e );

		} finally {

		}

		return lst;

	}

}
