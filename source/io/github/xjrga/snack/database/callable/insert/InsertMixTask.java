package io.github.xjrga.snack.database.callable.insert;

import io.github.xjrga.snack.database.Connect;
import io.github.xjrga.snack.dataobject.MixDO;
import io.github.xjrga.snack.logger.LoggerImpl;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.Callable;

public class InsertMixTask implements Callable<Boolean> {

	private final Connection connection;
	private final String mixid;
	private final String name;
	private final Integer lifestageid;
	private final String model;

	public InsertMixTask( MixDO mix ) {

		this.mixid = mix.getMixid();
		this.name = mix.getName();
		this.lifestageid = mix.getLifestageid();
		this.model = mix.getModel();
		connection = Connect.getInstance().getConnection();

	}

	@Override
	public Boolean call() throws Exception {

		boolean completed = false;

		try ( CallableStatement proc = connection.prepareCall( "{CALL public.snack_mix_insertmix( ?, ?, ?, ?)}" ) ) {

			proc.setString( 1, mixid );
			proc.setString( 2, name );
			proc.setString( 3, String.valueOf( lifestageid ) );
			proc.setString( 4, model );
			proc.execute();
			completed = true;

		} catch (SQLException e) {

			// LoggerImpl.INSTANCE.logProblem(e);
		}

		return completed;

	}

}
