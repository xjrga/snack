package io.github.xjrga.snack.other;

import io.github.xjrga.snack.database.Connect;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Shutdown {

    private final Connection connection;

    public Shutdown() {
        connection = Connect.getInstance().getConnection();
    }

    public void execute() {
        String sql = "SHUTDOWN;";
        try ( Statement stmt = connection.createStatement() ) {
            stmt.executeUpdate( sql );
        } catch ( SQLException e ) {
        }
    }
}
