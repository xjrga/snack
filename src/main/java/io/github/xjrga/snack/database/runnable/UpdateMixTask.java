package io.github.xjrga.snack.database.runnable;

import io.github.xjrga.snack.database.Connect;
import io.github.xjrga.snack.logger.LoggerImpl;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author jr
 */
public class UpdateMixTask implements Runnable {

    private final Connection connection;
    private final String mixid;
    private final Integer lifestageid;
    private final String model;
    private final Double deficiency_Ca;
    private final Double deficiency_Mg;
    private final Double deficiency_K;
    private final Double deficiency_Na;
    private final Double deficiency_VitA;
    private final Double deficiency_VitE;
    private final Double deficiency_VitD;
    private final Double deficiency_VitC;
    private final Double deficiency_Choline;
    private final Double excess_Ca;
    private final Double excess_Mg;
    private final Double excess_K;
    private final Double excess_Na;
    private final Double excess_VitA;
    private final Double excess_VitE;
    private final Double excess_VitD;
    private final Double excess_VitC;
    private final Double excess_Choline;
    private final Double avg_deficiency;
    private final Double avg_excess;
    private final Double cost;

    public UpdateMixTask(
            String mixid,
            Integer lifestageid,
            String model,
            Double deficiency_Ca,
            Double deficiency_Mg,
            Double deficiency_K,
            Double deficiency_Na,
            Double deficiency_VitA,
            Double deficiency_VitE,
            Double deficiency_VitD,
            Double deficiency_VitC,
            Double deficiency_Choline,
            Double excess_Ca,
            Double excess_Mg,
            Double excess_K,
            Double excess_Na,
            Double excess_VitA,
            Double excess_VitE,
            Double excess_VitD,
            Double excess_VitC,
            Double excess_Choline,
            Double avg_deficiency,
            Double avg_excess,
            Double cost
    ) {
        this.mixid = mixid;
        this.lifestageid = lifestageid;
        this.model = model;
        this.deficiency_Ca = deficiency_Ca;
        this.deficiency_Mg = deficiency_Mg;
        this.deficiency_K = deficiency_K;
        this.deficiency_Na = deficiency_Na;
        this.deficiency_VitA = deficiency_VitA;
        this.deficiency_VitE = deficiency_VitE;
        this.deficiency_VitD = deficiency_VitD;
        this.deficiency_VitC = deficiency_VitC;
        this.deficiency_Choline = deficiency_Choline;
        this.excess_Ca = excess_Ca;
        this.excess_Mg = excess_Mg;
        this.excess_K = excess_K;
        this.excess_Na = excess_Na;
        this.excess_VitA = excess_VitA;
        this.excess_VitE = excess_VitE;
        this.excess_VitD = excess_VitD;
        this.excess_VitC = excess_VitC;
        this.excess_Choline = excess_Choline;
        this.avg_deficiency = avg_deficiency;
        this.avg_excess = avg_excess;
        this.cost = cost;
        connection = Connect.getInstance().getConnection();
    }

    @Override
    public void run() {
        try (CallableStatement proc = connection.prepareCall("{CALL public.Mix_Update( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}")) {
            proc.setString(1, mixid);
            proc.setInt(2, lifestageid);
            proc.setString(3, model);
            proc.setDouble(4, deficiency_Ca);
            proc.setDouble(5, deficiency_Mg);
            proc.setDouble(6, deficiency_K);
            proc.setDouble(7, deficiency_Na);
            proc.setDouble(8, deficiency_VitA);
            proc.setDouble(9, deficiency_VitE);
            proc.setDouble(10, deficiency_VitD);
            proc.setDouble(11, deficiency_VitC);
            proc.setDouble(12, deficiency_Choline);
            proc.setDouble(13, excess_Ca);
            proc.setDouble(14, excess_Mg);
            proc.setDouble(15, excess_K);
            proc.setDouble(16, excess_Na);
            proc.setDouble(17, excess_VitA);
            proc.setDouble(18, excess_VitE);
            proc.setDouble(19, excess_VitD);
            proc.setDouble(20, excess_VitC);
            proc.setDouble(21, excess_Choline);
            proc.setDouble(22, avg_deficiency);
            proc.setDouble(23, avg_excess);
            proc.setDouble(24, cost);
            proc.execute();
        } catch (SQLException e) {
            LoggerImpl.INSTANCE.logProblem(e);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CALL public.Mix_Update(").append("\n");
        sb.append("'").append(mixid).append("'").append(",").append("\n");
        sb.append(lifestageid).append(",").append("\n");
        sb.append("'").append(model).append("'").append(",").append("\n");
        sb.append(deficiency_Ca).append(",").append("\n");
        sb.append(deficiency_Mg).append(",").append("\n");
        sb.append(deficiency_K).append(",").append("\n");
        sb.append(deficiency_Na).append(",").append("\n");
        sb.append(deficiency_VitA).append(",").append("\n");
        sb.append(deficiency_VitE).append(",").append("\n");
        sb.append(deficiency_VitD).append(",").append("\n");
        sb.append(deficiency_VitC).append(",").append("\n");
        sb.append(deficiency_Choline).append(",").append("\n");
        sb.append(excess_Ca).append(",").append("\n");
        sb.append(excess_Mg).append(",").append("\n");
        sb.append(excess_K).append(",").append("\n");
        sb.append(excess_Na).append(",").append("\n");
        sb.append(excess_VitA).append(",").append("\n");
        sb.append(excess_VitE).append(",").append("\n");
        sb.append(excess_VitD).append(",").append("\n");
        sb.append(excess_VitC).append(",").append("\n");
        sb.append(excess_Choline).append(",").append("\n");
        sb.append(avg_deficiency).append(",").append("\n");
        sb.append(avg_excess).append(",").append("\n");
        sb.append(cost).append("\n");
        sb.append(')');
        return sb.toString();
    }

}
