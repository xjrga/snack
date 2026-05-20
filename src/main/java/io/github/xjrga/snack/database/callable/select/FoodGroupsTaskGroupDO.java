package io.github.xjrga.snack.database.callable.select;

import io.github.xjrga.snack.database.Connect;
import io.github.xjrga.snack.dataobject.GroupDO;
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
public class FoodGroupsTaskGroupDO implements Callable<List<GroupDO>> {

    private final Connection connection;
    private final String mixid;


    public FoodGroupsTaskGroupDO( String mixid ) {
        connection = Connect.getInstance().getConnection();
        this.mixid = mixid;
    }


    @Override
    public List<GroupDO> call() {
        ArrayList<GroupDO> list = new ArrayList();
        try ( CallableStatement proc = connection.prepareCall( "{CALL public.FoodGroup_Select_All( ? )}" ) ) {
            proc.setString( 1, mixid );
            ResultSet rs = proc.executeQuery();
            while ( rs.next() ) {
                GroupDO group = new GroupDO();
                group.setGroupid( rs.getString( 1 ) );
                group.setGroupname( rs.getString( 2 ) );
                list.add( group );
            }
        } catch ( Exception e ) {
            LoggerImpl.INSTANCE.logProblem( e );
        }
        return list;
    }
}
