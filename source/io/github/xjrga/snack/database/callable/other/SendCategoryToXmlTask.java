package io.github.xjrga.snack.database.callable.other;

import io.github.xjrga.snack.database.Connect;
import io.github.xjrga.snack.logger.LoggerImpl;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.Callable;

/**
 * @author jr
 */
public class SendCategoryToXmlTask implements Callable<String> {

    private final Connection connection;
    private final String categoryid;

    public SendCategoryToXmlTask(String categoryid) {

        this.categoryid = categoryid;
        connection = Connect.getInstance().getConnection();
    }

    @Override
    public String call() throws Exception {

        String out = "";

        try (CallableStatement proc = connection.prepareCall("{CALL public.exportCategoryToXml( ? )}")) {

            proc.setString(1, categoryid);
            ResultSet rs = proc.executeQuery();
            rs.next();
            out = rs.getString(1);

        } catch (SQLException e) {

            LoggerImpl.INSTANCE.logProblem(e);

        } finally {

        }

        return out;
    }
}
