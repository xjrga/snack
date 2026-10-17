package io.github.xjrga.snack.database.callable.select;

import io.github.xjrga.snack.completablefuture.records.Records.Mix;
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
public class MixesTask2 implements Callable<List<Mix>> {

    private final Connection connection;

    public MixesTask2() {
        connection = Connect.getInstance().getConnection();
    }

    @Override
    public List<Mix> call() {
        List<Mix> lst = new ArrayList();
        try {
            CallableStatement proc = connection.prepareCall("{CALL public.Mix_Select_All()}");
            ResultSet rs = proc.executeQuery();
            while (rs.next()) {
                Mix mix = new Mix(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getBigDecimal(5),
                        rs.getBigDecimal(6)
                );
                lst.add(mix);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lst;
    }
}
