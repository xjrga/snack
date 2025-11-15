package io.github.xjrga.snack.database.callable.insert;

import io.github.xjrga.snack.database.Connect;
import io.github.xjrga.snack.logger.LoggerImpl;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.util.concurrent.Callable;

public class InsertFoodTask implements Callable<Boolean> {

    private final Connection connection;
    private final String foodid;
    private final String foodname;

    public InsertFoodTask(String foodid, String foodname) {

        connection = Connect.getInstance().getConnection();
        this.foodid = foodid;
        this.foodname = foodname;
    }

    @Override
    public Boolean call() throws Exception {

        boolean completed = false;

        try (CallableStatement proc = connection.prepareCall("{CALL public.food_insert( ?, ? )}")) {

            proc.setString(1, foodid);
            proc.setString(2, foodname);
            proc.execute();
            completed = true;

        } catch (Exception e) {

            // LoggerImpl.INSTANCE.logProblem(e);
        }

        return completed;
    }
}
