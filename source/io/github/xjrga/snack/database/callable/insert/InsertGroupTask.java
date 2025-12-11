package io.github.xjrga.snack.database.callable.insert;

import io.github.xjrga.snack.database.Connect;
import io.github.xjrga.snack.logger.LoggerImpl;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.util.concurrent.Callable;

/**
 *
 * @author jr
 */
public class InsertGroupTask implements Callable<String> {

    private final Connection connection;
    private final String mixid;
    private final String groupid;
    private final String name;

    public InsertGroupTask(String mixid, String groupid, String name) {
        connection = Connect.getInstance().getConnection();
        this.mixid = mixid;
        this.groupid = groupid;
        this.name = name;
    }

    @Override
    public String call() throws Exception {
        try (CallableStatement proc = connection.prepareCall("{CALL public.Group_Insert( ?, ?, ? )}")) {
            proc.setString(1, mixid);
            proc.setString(2, groupid);
            proc.setString(3, name);
            proc.execute();

        } catch (Exception e) {
            LoggerImpl.INSTANCE.logProblem(e);
        }

        return groupid;
    }
}
