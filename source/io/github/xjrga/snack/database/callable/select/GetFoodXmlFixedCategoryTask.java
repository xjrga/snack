package io.github.xjrga.snack.database.callable.select;

import io.github.xjrga.snack.database.Connect;
import io.github.xjrga.snack.logger.LoggerImpl;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.Callable;

/**
 * @author jr
 */
public class GetFoodXmlFixedCategoryTask implements Callable<String> {

    private final Connection connection;
    private final String foodId;
    private final String categoryId;


    public GetFoodXmlFixedCategoryTask( String foodId, String categoryId ) {
        this.foodId = foodId;
        this.categoryId = categoryId;
        connection = Connect.getInstance().getConnection();
    }


    @Override
    public String call() {
        String xml = "";
        try ( CallableStatement proc = connection.prepareCall( "{CALL public.getFoodXmlFixedCategory( ?, ? )}" ) ) {
            proc.setString( 1, foodId );
            proc.setString( 2, categoryId );
            ResultSet rs = proc.executeQuery();
            while ( rs.next() ) {
                xml = rs.getString( 1 );
            }
        } catch ( SQLException e ) {
            LoggerImpl.INSTANCE.logProblem( e );
        }
        return xml;
    }
}
