package io.github.xjrga.snack.completablefuture;

import io.github.xjrga.snack.completablefuture.records.Records.Mix;
import io.github.xjrga.snack.dataobject.MixDO;
import io.github.xjrga.snack.other.Namer;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 *
 * @author jr
 */
public class Tasks {

    private static Connection connection;
    private Mediator m;

    public Tasks(Connection con, Mediator mediator) {
        connection = con;
        m = mediator;
        //Namer.on();
    }

    public Supplier<MixDO> getMix = () -> {
        //TODO - DELETE
        Namer.threadName("getMix");
        return m.getMix();
    };

    public Consumer<MixDO> solveModel = (a) -> {
        m.solveModel(a);
        //TODO - DELETE
        Namer.threadName("solveModel");
    };

    public Supplier<List<Mix>> fetchMixesToRecord = () -> {
        List<Mix> lst = new ArrayList();
        try {
            CallableStatement proc = connection.prepareCall("{CALL public.Mix_Select_All()}");
            ResultSet rs = proc.executeQuery();
            while (rs.next()) {
                Mix mix = new Mix(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getBigDecimal(5),
                        rs.getBigDecimal(6)
                );
                lst.add(mix);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //TODO - DELETE
        Namer.threadName("fetchMixesToRecord");
        return lst;
    };

    public Function<List<Mix>, List<MixDO>> reloadCmbMixes = lst -> {
        //TODO - DELETE
        Namer.threadName("reloadCmbMixes");
        return m.reloadCmbMixes(lst);
    };

    public Runnable clearMixDiffSelection = () -> {
        //TODO - DELETE
        Namer.threadName("clearMixDiffSelection");
        m.clearMixDiffSelection();
    };

    public BiFunction<List<MixDO>, MixDO, MixDO> findNewMix = (lst, mix) -> {
        //TODO - DELETE
        Namer.threadName("findNewMix");
        return m.findNewMix(lst, mix);
    };

    public Runnable reloadFoods = () -> {
        //TODO - DELETE
        Namer.threadName("reloadFoods");
        m.reloadFoods();
    };

    public Supplier<List<List>> fetchMixesToList = () -> {
        List<List> lst = new ArrayList();
        try {
            CallableStatement proc = connection.prepareCall("{CALL public.Mix_Select_All()}");
            ResultSet rs = proc.executeQuery();
            while (rs.next()) {
                ArrayList row = new ArrayList();
                row.add(rs.getString(1));
                row.add(rs.getString(2));
                row.add(rs.getString(3));
                row.add(rs.getString(4));
                row.add(rs.getString(5));
                row.add(rs.getString(6));
                lst.add(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //TODO - DELETE
        Namer.threadName("fetchMixesToList");
        return lst;
    };

    public Consumer<List<List>> reloadMixes = (lst) -> {
        m.reloadMixes(lst);
        //TODO - DELETE
        Namer.threadName("reloadMixes");
    };

    public Consumer<MixDO> selectMix = mix -> {
        m.selectMix(mix);
        //TODO - DELETE
        Namer.threadName("selectMix");
    };
}
