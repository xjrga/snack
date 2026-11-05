package io.github.xjrga.snack.database.callable.select;

import io.github.xjrga.snack.database.Connect;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * @author jr
 */
public class FetchMixesToListTask implements Callable<List<List>> {

    private final Connection connection;

    public FetchMixesToListTask() {
        connection = Connect.getInstance().getConnection();
    }

    @Override
    public List<List> call() {
        List<List> lst = new ArrayList();
        try {
            CallableStatement proc = connection.prepareCall("{CALL public.Mix_Select_All()}");
            ResultSet rs = proc.executeQuery();
            while (rs.next()) {
                ArrayList row = new ArrayList();
                row.add(rs.getString(1));
                row.add(rs.getString(2));
                row.add(rs.getString(3));
                row.add(rs.getString(4));
                row.add(rs.getString(5));
                row.add(rs.getString(6));
                lst.add(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lst;
    }
}
