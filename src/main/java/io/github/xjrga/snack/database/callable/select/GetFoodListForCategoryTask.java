package io.github.xjrga.snack.database.callable.select;

import io.github.xjrga.snack.database.Connect;
import io.github.xjrga.snack.logger.LoggerImpl;
import io.github.xjrga.snack.records.FoodListRecord;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * @author jr
 */
public class GetFoodListForCategoryTask implements Callable<List<FoodListRecord>> {

    private final Connection connection;
    private final String categoryid;

    public GetFoodListForCategoryTask(String categoryid) {
        this.categoryid = categoryid;
        connection = Connect.getInstance().getConnection();
    }

    @Override
    public List<FoodListRecord> call() {
        List<FoodListRecord> list = new ArrayList<>();
        try (CallableStatement proc = connection.prepareCall("{CALL public.getFoodListForCategory( ? )}")) {
            proc.setString(1, categoryid);
            ResultSet rs = proc.executeQuery();
            while (rs.next()) {
                String foodid = rs.getString(1);
                String name = rs.getString(2);
                FoodListRecord food = new FoodListRecord(foodid, name);
                list.add(food);
            }
        } catch (SQLException e) {
            LoggerImpl.INSTANCE.logProblem(e);
        }
        return list;
    }
}
