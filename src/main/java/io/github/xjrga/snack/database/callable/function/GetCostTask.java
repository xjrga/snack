package io.github.xjrga.snack.database.callable.function;

import io.github.xjrga.snack.database.Connect;
import io.github.xjrga.snack.logger.LoggerImpl;
import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.Callable;

/**
 * @author jr
 */
public class GetCostTask implements Callable<BigDecimal> {

    private final Connection connection;
    private final String mixid;
    private BigDecimal cost;

    public GetCostTask(String mixid) {
        connection = Connect.getInstance().getConnection();
        this.mixid = mixid;
    }

    @Override
    public BigDecimal call() throws Exception {
        try (CallableStatement proc = connection.prepareCall("{CALL public.getCost( ? )}")) {
            proc.setString(1, mixid);
            proc.execute();
            try (ResultSet set = proc.getResultSet()) {
                set.next();
                cost = set.getBigDecimal(1);
            }
        } catch (SQLException e) {
            LoggerImpl.INSTANCE.logProblem(e);
        }
        return cost;
    }

}
