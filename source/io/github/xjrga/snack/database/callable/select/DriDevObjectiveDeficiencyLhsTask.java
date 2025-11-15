package io.github.xjrga.snack.database.callable.select;

import io.github.xjrga.snack.database.Connect;
import io.github.xjrga.snack.dataobject.Lhs;
import io.github.xjrga.snack.dataobject.LhsContainer;
import io.github.xjrga.snack.logger.LoggerImpl;
import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.Callable;

public class DriDevObjectiveDeficiencyLhsTask implements Callable<LhsContainer> {

    private final String mixid;
    private final Connection connection;

    public DriDevObjectiveDeficiencyLhsTask(String mixid) {

        this.mixid = mixid;
        connection = Connect.getInstance().getConnection();
    }

    @Override
    public LhsContainer call() {

        LhsContainer container = new LhsContainer();

        try (CallableStatement proc = connection.prepareCall("{CALL public.dridev_objective_deficiency_lhs( ? )}")) {

            proc.setString(1, mixid);
            ResultSet rs = proc.executeQuery();

            while (rs.next()) {

                Integer rownum = rs.getInt(1);
                String name = rs.getString(2);
                BigDecimal c = rs.getBigDecimal(3);
                Lhs lhs = new Lhs(rownum, name, c);
                container.add(lhs);
            }

            proc.close();

        } catch (SQLException e) {

            LoggerImpl.INSTANCE.logProblem(e);
        }

        return container;
    }
}
