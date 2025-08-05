package io.github.xjrga.snack.database.callable.insert;

import io.github.xjrga.snack.database.Connect;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.util.concurrent.Callable;

/**
 * @author jr
 */
public class InsertCategoryTask implements Callable<Boolean> {

	private final Connection connection;
	private final String categoryname;

	public InsertCategoryTask( String categoryname ) {

		connection = Connect.getInstance().getConnection();
		this.categoryname = categoryname;

	}

	@Override
	public Boolean call() throws Exception {

		Boolean completed = false;

		try ( CallableStatement proc = connection.prepareCall( "{CALL public.FoodCategory_Insert_2( ? )}" ) ) {

			proc.setString( 1, categoryname );
			proc.execute();
			completed = true;

		} catch (Exception e) {

		}

		return completed;

	}

}
