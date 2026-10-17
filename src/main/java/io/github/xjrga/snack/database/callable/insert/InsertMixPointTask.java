package io.github.xjrga.snack.database.callable.insert;

import io.github.xjrga.snack.database.Connect;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.Callable;

/**
 * @author jr
 */
public class InsertMixPointTask implements Callable<Boolean> {

    private final Connection connection;
    private final String mixid;
    private final Integer i;
    private final Double q;

    public InsertMixPointTask(String mixid, Integer i, Double q) {
        connection = Connect.getInstance().getConnection();
        this.mixid = mixid;
        this.i = i;
        this.q = q;
    }

    @Override
    public Boolean call() throws Exception {
        boolean completed = false;
        try (CallableStatement proc = connection.prepareCall("{CALL public.InsertMixPoint( ?, ?, ? )}")) {
            proc.setString(1, mixid);
            proc.setInt(2, i);
            proc.setDouble(3, q);
            proc.execute();
            completed = true;
        } catch (SQLException e) {

        } finally {
        }
        return completed;
    }
}
