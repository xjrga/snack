package io.github.xjrga.snack.database.callable.insert;

import io.github.xjrga.snack.database.Connect;
import io.github.xjrga.snack.logger.LoggerImpl;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.Callable;

public class InsertGroupFoodTask implements Callable<String> {

    private final Connection connection;
    private final String mixid;
    private final String groupid;
    private final String foodid;

    public InsertGroupFoodTask(String mixid, String groupid, String foodid) {

        connection = Connect.getInstance().getConnection();
        this.mixid = mixid;
        this.groupid = groupid;
        this.foodid = foodid;
    }

    @Override
    public String call() throws Exception {

        try (CallableStatement proc = connection.prepareCall("{CALL public.FoodGroupList_Insert( ?, ?, ? )}")) {

            proc.setString(1, groupid);
            proc.setString(2, mixid);
            proc.setString(3, foodid);
            proc.execute();

        } catch (SQLException e) {

            LoggerImpl.INSTANCE.logProblem(e);
        }

        return foodid;
    }
}
