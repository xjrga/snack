package io.github.xjrga.snack.database.callable.delete;

import io.github.xjrga.snack.database.Connect;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.Callable;

/**
 * @author jr
 */
public class DeleteCategoryTask implements Callable<Boolean> {

    private final Connection connection;
    private final String categoryid;

    public DeleteCategoryTask(String categoryid) {

        connection = Connect.getInstance().getConnection();
        this.categoryid = categoryid;
    }

    @Override
    public Boolean call() throws Exception {

        Boolean completed = false;

        try (CallableStatement proc = connection.prepareCall("{CALL public.FoodCategory_Delete( ? )}")) {

            proc.setString(1, categoryid);
            proc.execute();
            completed = true;

        } catch (SQLException e) {

        }

        return completed;
    }
}
