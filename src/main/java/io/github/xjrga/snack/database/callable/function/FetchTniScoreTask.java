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
public class FetchTniScoreTask implements Callable<BigDecimal> {

    private final Connection connection;
    private final String mixid;
    private final Integer lifestageid;
    private BigDecimal tniScore;

    public FetchTniScoreTask(String mixid, Integer lifestageid) {
        connection = Connect.getInstance().getConnection();
        this.mixid = mixid;
        this.lifestageid = lifestageid;
    }

    @Override
    public BigDecimal call() throws Exception {
        try (CallableStatement proc = connection.prepareCall("{CALL public.fetchTniScore( ?, ? )}")) {
            proc.setString(1, mixid);
            proc.setInt(2, lifestageid);
            proc.execute();
            try (ResultSet set = proc.getResultSet()) {
                set.next();
                tniScore = set.getBigDecimal(1);
            }
        } catch (SQLException e) {
            LoggerImpl.INSTANCE.logProblem(e);
        }
        return tniScore;
    }

}
