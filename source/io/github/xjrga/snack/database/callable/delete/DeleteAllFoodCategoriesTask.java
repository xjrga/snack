package io.github.xjrga.snack.database.callable.delete;

import io.github.xjrga.snack.database.Connect;
import io.github.xjrga.snack.logger.LoggerImpl;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.util.concurrent.Callable;

/**
 * @author jr
 */
public class DeleteAllFoodCategoriesTask implements Callable<Boolean> {

    private final Connection connection;


    public DeleteAllFoodCategoriesTask() {
        connection = Connect.getInstance().getConnection();
    }


    @Override
    public Boolean call() throws Exception {
        boolean completed = false;
        try ( CallableStatement proc = connection.prepareCall( "{CALL public.deleteAllFoodCategories()}" ) ) {
            proc.execute();
            completed = true;
        } catch ( Exception e ) {
            LoggerImpl.INSTANCE.logProblem( e );
        } finally {
        }
        return completed;
    }
}
