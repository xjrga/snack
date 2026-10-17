package io.github.xjrga.snack.database.query;

import io.github.xjrga.snack.database.Connect;
import io.github.xjrga.snack.logger.LoggerImpl;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author jr
 */
public class UpdateMixAction {

    private final Connection connection;
    private final String mixid;
    private final Integer lifestageid;
    private final String model;

    public UpdateMixAction(
            String mixid,
            Integer lifestageid,
            String model
    ) {
        this.mixid = mixid;
        this.lifestageid = lifestageid;
        this.model = model;
        connection = Connect.getInstance().getConnection();
    }

    public void execute() {
        try (CallableStatement proc = connection.prepareCall("{CALL public.updateMix( ?, ?, ? )}")) {
            proc.setString(1, mixid);
            proc.setInt(2, lifestageid);
            proc.setString(3, model);
            proc.execute();
        } catch (SQLException e) {
            LoggerImpl.INSTANCE.logProblem(e);
        }
    }
}
