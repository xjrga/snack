package io.github.xjrga.snack.database.callable.insert;

import io.github.xjrga.snack.database.Connect;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;
import java.util.concurrent.Callable;

/**
 * @author jr
 */
public class InsertCategoryTask implements Callable<String> {

    private final Connection connection;
    private final String categoryname;
    private String out;


    public InsertCategoryTask( String categoryname ) {
        connection = Connect.getInstance().getConnection();
        this.categoryname = categoryname;
    }


    @Override
    public String call() throws Exception {
        try ( CallableStatement proc = connection.prepareCall( "{CALL public.FoodCategory_Insert_2( ?, ? )}" ) ) {
            proc.registerOutParameter( 1, Types.LONGNVARCHAR );
            proc.setString( 2, categoryname );
            proc.execute();
            out = proc.getString( 1 );
        } catch ( Exception e ) {
        }
        return out;
    }
}
