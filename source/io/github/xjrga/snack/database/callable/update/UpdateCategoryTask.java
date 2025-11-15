package io.github.xjrga.snack.database.callable.update;

import io.github.xjrga.snack.database.Connect;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.Callable;

/**
 * @author jr
 */
public class UpdateCategoryTask implements Callable<Boolean> {

    private final Connection connection;
    private final String categoryid;
    private final String categoryname;

    public UpdateCategoryTask(String categoryid, String categoryname) {

        connection = Connect.getInstance().getConnection();
        this.categoryid = categoryid;
        this.categoryname = categoryname;
    }

    @Override
    public Boolean call() throws Exception {

        Boolean completed = false;

        try (CallableStatement proc = connection.prepareCall("{CALL public.FoodCategory_Update( ?, ? )}")) {

            proc.setString(1, categoryid);
            proc.setString(2, categoryname);
            proc.execute();
            completed = true;

        } catch (SQLException e) {

        }

        return completed;
    }
}
