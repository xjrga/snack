package io.github.xjrga.snack.database.query;

import io.github.xjrga.snack.database.Connect;
import io.github.xjrga.snack.logger.LoggerImpl;
import java.lang.*;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author jr
 */
public class AllocateAction {

    private final Connection connection;
    private final String mixid;

    public AllocateAction(String mixid) {

        this.mixid = mixid;
        connection = Connect.getInstance().getConnection();
    }

    public void execute() {

        try (CallableStatement proc = connection.prepareCall("{CALL public.allocate( ? )}")) {

            proc.setString(1, mixid);
            proc.execute();

        } catch (SQLException e) {

            LoggerImpl.INSTANCE.logProblem(e);
        }
    }
}
