package io.github.xjrga.snack.database.query;

import io.github.xjrga.snack.database.Connect;
import io.github.xjrga.snack.logger.LoggerImpl;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author jr
 */
public class UpdateMixTniScore {

    private final Connection connection;
    private final String mixid;
    private final Integer lifestageid;

    public UpdateMixTniScore(
            String mixid,
            Integer lifestageid
    ) {
        this.mixid = mixid;
        this.lifestageid = lifestageid;
        connection = Connect.getInstance().getConnection();
    }

    public void execute() {
        try (CallableStatement proc = connection.prepareCall("{CALL public.updateTniScore( ?, ? )}")) {
            proc.setString(1, mixid);
            proc.setInt(2, lifestageid);
            proc.execute();
        } catch (SQLException e) {
            LoggerImpl.INSTANCE.logProblem(e);
        }
    }
}
