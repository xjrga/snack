package io.github.xjrga.snack.database.callable.insert;

import io.github.xjrga.snack.database.Connect;
import io.github.xjrga.snack.logger.LoggerImpl;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;
import java.util.concurrent.Callable;

/**
 * @author jr
 */
public class CreateMealTask implements Callable<Integer> {

    private final Connection connection;
    private final String mixid;
    private final String name;
    private final Integer order;

    public CreateMealTask(String mixid, String name, Integer order) {

        connection = Connect.getInstance().getConnection();
        this.mixid = mixid;
        this.name = name;
        this.order = order;
    }

    @Override
    public Integer call() throws Exception {

        Integer out = -1;

        try (CallableStatement proc = connection.prepareCall("{CALL public.Meal_insert( ?, ?, ?, ? )}")) {

            proc.registerOutParameter(1, Types.INTEGER);
            proc.setString(2, mixid);
            proc.setString(3, name);
            proc.setInt(4, order);
            proc.execute();
            out = proc.getInt(1);

        } catch (Exception e) {

            LoggerImpl.INSTANCE.logProblem(e);
        }

        return out;
    }
}
