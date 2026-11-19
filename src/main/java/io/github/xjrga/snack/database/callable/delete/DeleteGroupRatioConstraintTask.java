package io.github.xjrga.snack.database.callable.delete;

import io.github.xjrga.snack.database.Connect;
import io.github.xjrga.snack.logger.LoggerImpl;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.Callable;

/**
 * @author jr
 */
public class DeleteGroupRatioConstraintTask implements Callable<Boolean> {

    private final Connection connection;
    private final String MixId;
    private final String Group_Id_1;
    private final String Nutrient_Id_1;
    private final String Group_Id_2;
    private final String Nutrient_Id_2;
    private final Integer RelationshipId;

    public DeleteGroupRatioConstraintTask(
            String MixId,
            String Group_Id_1,
            String Nutrient_Id_1,
            String Group_Id_2,
            String Nutrient_Id_2,
            Integer RelationshipId) {
        connection = Connect.getInstance().getConnection();
        this.MixId = MixId;
        this.Group_Id_1 = Group_Id_1;
        this.Nutrient_Id_1 = Nutrient_Id_1;
        this.Group_Id_2 = Group_Id_2;
        this.Nutrient_Id_2 = Nutrient_Id_2;
        this.RelationshipId = RelationshipId;
    }

    @Override
    public Boolean call() throws Exception {
        Boolean completed = false;
        try (CallableStatement proc
                = connection.prepareCall("{CALL public.GroupRatio_Delete( ?, ?, ?, ?, ?, ? )}")) {
            proc.setString(1, MixId);
            proc.setString(2, Group_Id_1);
            proc.setString(3, Nutrient_Id_1);
            proc.setString(4, Group_Id_2);
            proc.setString(5, Nutrient_Id_2);
            proc.setInt(6, RelationshipId);
            proc.execute();
            completed = true;
        } catch (SQLException e) {
            LoggerImpl.INSTANCE.logProblem(e);
        }
        return completed;
    }
}
