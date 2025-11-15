package io.github.xjrga.snack.database.callable.select;

import io.github.xjrga.snack.database.Connect;
import io.github.xjrga.snack.logger.LoggerImpl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * @author jr
 */
public class MealPlanUsageTask implements Callable<List<List>> {

    private final Connection connection;

    public MealPlanUsageTask() {

        connection = Connect.getInstance().getConnection();
    }

    @Override
    public List<List> call() {

        ArrayList<List> table = new ArrayList();

        try (PreparedStatement proc = connection.prepareStatement("select * from MixInventoryDays")) {

            ResultSet rs = proc.executeQuery();

            while (rs.next()) {

                ArrayList row = new ArrayList();
                row.add(rs.getString(1));
                row.add(rs.getString(2));
                row.add(rs.getBigDecimal(3));
                table.add(row);
            }

        } catch (SQLException e) {

            LoggerImpl.INSTANCE.logProblem(e);
        }

        return table;
    }
}
