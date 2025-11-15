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

public class NutrientQuantityRhsTask implements Callable<List<Map<String, Object>>> {

    private final List<Map<String, Object>> lst;
    private final String mixid;
    private final Connection connection;

    public NutrientQuantityRhsTask(String mixid) {

        this.mixid = mixid;
        lst = new ArrayList();
        connection = Connect.getInstance().getConnection();
    }

    @Override
    public List<Map<String, Object>> call() {

        try {

            CallableStatement proc = connection.prepareCall("{CALL public.nutrient_rhs( ? )}");
            proc.setString(1, mixid);
            ResultSet rs = proc.executeQuery();

            while (rs.next()) {

                HashMap<String, Object> row = new HashMap();
                // Integer mixid = rs.getString(1);
                String nutrientid = rs.getString(2);
                Integer relationshipid = rs.getInt(3);
                Double b = rs.getDouble(4);
                String nutrient = rs.getString(5);
                String eq = rs.getString(6);
                row.put("NUTRIENTID", nutrientid);
                row.put("RELATIONSHIPID", relationshipid);
                row.put("B", b);
                row.put("NUTRIENT", nutrient);
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
