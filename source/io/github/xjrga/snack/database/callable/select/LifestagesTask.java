package io.github.xjrga.snack.database.callable.select;

import io.github.xjrga.snack.database.Connect;
import io.github.xjrga.snack.dataobject.LifeStageDO;
import io.github.xjrga.snack.logger.LoggerImpl;
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
public class LifestagesTask implements Callable<List<LifeStageDO>> {

    private final Connection connection;

    public LifestagesTask() {

        connection = Connect.getInstance().getConnection();
    }

    @Override
    public List<LifeStageDO> call() {

        ArrayList<LifeStageDO> list = new ArrayList();

        try (CallableStatement proc = connection.prepareCall("{CALL public.RdaLifeStage_Select_All()}")) {

            ResultSet rs = proc.executeQuery();

            while (rs.next()) {

                LifeStageDO lifestage = new LifeStageDO(rs.getInt(1), rs.getString(2));
                list.add(lifestage);
            }

        } catch (SQLException e) {

            LoggerImpl.INSTANCE.logProblem(e);
        }

        return list;
    }
}
