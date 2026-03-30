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
public class GetFoodXmlTask implements Callable<String> {

    private final Connection connection;
    private final String foodid;


    public GetFoodXmlTask( String foodid ) {
        this.foodid = foodid;
        connection = Connect.getInstance().getConnection();
    }


    @Override
    public String call() {
        String xml = "";
        try ( CallableStatement proc = connection.prepareCall( "{CALL public.getFoodXml( ? )}" ) ) {
            proc.setString( 1, foodid );
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
