package io.github.xjrga.snack.database.callable.select;

import io.github.xjrga.snack.database.Connect;
import io.github.xjrga.snack.logger.LoggerImpl;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

public class DriDevTniRhsTask implements Callable<List<Map<String, Object>>> {

    private final List<Map<String, Object>> lst;
    private final String mixid;
    private final Integer lifestyleid;
    private final Connection connection;

    public DriDevTniRhsTask(String mixid, Integer lifestyleid) {

        this.mixid = mixid;
        this.lifestyleid = lifestyleid;
        lst = new ArrayList();
        connection = Connect.getInstance().getConnection();
    }

    @Override
    public List<Map<String, Object>> call() {

        try {

            CallableStatement proc = connection.prepareCall("{CALL public.dridev_tni_rhs( ?, ? )}");
            proc.setString(1, mixid);
            proc.setInt(2, lifestyleid);
            ResultSet rs = proc.executeQuery();

            while (rs.next()) {

                HashMap<String, Object> row = new HashMap();
                String nutrientid = rs.getString(2);
                Integer relationshipid = rs.getInt(3);
                Double b = rs.getDouble(4);
                String nutrient = rs.getString(5);
                String nutrientlabel = rs.getString(6);
                String eq = rs.getString(7);
                row.put("NUTRIENTID", nutrientid);
                row.put("RELATIONSHIPID", relationshipid);
                row.put("B", b);
                row.put("NUTRIENT", nutrient);
                row.put("NUTRIENTLABEL", nutrientlabel);
                row.put("EQ", eq);
                lst.add(row);
            }

        } catch (Exception e) {

            LoggerImpl.INSTANCE.logProblem(e);

        } finally {

        }

        return lst;
    }
}
