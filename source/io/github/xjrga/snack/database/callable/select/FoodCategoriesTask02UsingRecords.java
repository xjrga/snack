package io.github.xjrga.snack.database.callable.select;

import io.github.xjrga.snack.database.Connect;
import io.github.xjrga.snack.records.TableCategoryRow;
import io.github.xjrga.snack.logger.LoggerImpl;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * @author jr
 */
public class FoodCategoriesTask02UsingRecords implements Callable<List<TableCategoryRow>> {

    private final Connection connection;
    private final String foodid;


    public FoodCategoriesTask02UsingRecords( String foodid ) {
        connection = Connect.getInstance().getConnection();
        this.foodid = foodid;
    }


    @Override
    public List<TableCategoryRow> call() {
        ArrayList<TableCategoryRow> table = new ArrayList();
        try ( CallableStatement proc = connection.prepareCall( "{CALL public.FoodCategory_Select( ? )}" ) ) {
            proc.setString( 1, foodid );
            ResultSet rs = proc.executeQuery();
            while ( rs.next() ) {
                TableCategoryRow row = new TableCategoryRow(
                        rs.getString( 1 ),
                        rs.getString( 2 ) );
                table.add( row );
            }
        } catch ( Exception e ) {
            LoggerImpl.INSTANCE.logProblem( e );
        }
        return table;
    }
}
