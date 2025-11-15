package io.github.xjrga.snack.database.callable.insert;

import io.github.xjrga.snack.database.Connect;
import io.github.xjrga.snack.logger.LoggerImpl;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.Callable;

/**
 * @author jr
 */
public class MergeMealPlanUsageTask implements Callable<Boolean> {

    private final Connection connection;
    private final String mixid;
    private final Double days;

    public MergeMealPlanUsageTask(String mixid, Double days) {

        connection = Connect.getInstance().getConnection();
        this.mixid = mixid;
        this.days = days;
    }

    @Override
    public Boolean call() throws Exception {

        Boolean completed = false;

        try (CallableStatement proc = connection.prepareCall("{call MixInventory_merge(?,?)}")) {

            proc.setString(1, mixid);
            proc.setDouble(2, days);
            proc.execute();
            completed = true;

        } catch (SQLException e) {

            LoggerImpl.INSTANCE.logProblem(e);
        }

        return completed;
    }
}
