package io.github.xjrga.snack.database.callable.select;

import io.github.xjrga.snack.database.Connect;
import io.github.xjrga.snack.logger.LoggerImpl;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.Callable;

public class FoodCategoryCountTask implements Callable<Integer> {

    private Connection connection;
    private final String foodid;
    private final String foodcategoryid;

    public FoodCategoryCountTask(String foodid, String foodcategoryid) {

        connection = Connect.getInstance().getConnection();
        this.foodid = foodid;
        this.foodcategoryid = foodcategoryid;
    }

    @Override
    public Integer call() throws Exception {

        Integer out = 0;

        try (CallableStatement proc = connection.prepareCall("{CALL public.CategoryLink_Count( ?, ? )}")) {

            proc.setString(1, foodid);
            proc.setString(2, foodcategoryid);
            proc.execute();
            ResultSet resultSet = proc.getResultSet();
            resultSet.next();
            out = resultSet.getInt(1);

        } catch (SQLException e) {

            LoggerImpl.INSTANCE.logProblem(e);

        } finally {

        }

        return out;
    }
}
