package io.github.xjrga.snack.database.callable.other;

import io.github.xjrga.snack.database.Connect;
import io.github.xjrga.snack.logger.LoggerImpl;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.Callable;

/**
 * @author jr
 */
public class ExportMixTask implements Callable<String> {

    private final Connection connection;
    private final String mixid;

    public ExportMixTask(String mixid) {

        connection = Connect.getInstance().getConnection();
        this.mixid = mixid;
    }

    @Override
    public String call() throws Exception {

        String out = "";

        try (CallableStatement proc = connection.prepareCall("{CALL public.exportMixModel( ? )}")) {

            proc.setString(1, mixid);
            ResultSet rs = proc.executeQuery();

            while (rs.next()) {

                out = rs.getString(1);
            }

        } catch (SQLException e) {

            LoggerImpl.INSTANCE.logProblem(e);
        }

        return out;
    }
}
