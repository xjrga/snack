package io.github.xjrga.snack.completablefuture;

import io.github.xjrga.snack.database.Connect;
import io.github.xjrga.snack.dataobject.MixDO;
import io.github.xjrga.snack.other.Namer;
import java.sql.Connection;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import javax.swing.SwingUtilities;

/**
 *
 * @author jr
 */
public class Operations {

    private static final Executor SWING_EXECUTOR = SwingUtilities::invokeLater;
    private final Tasks tasks;
    private Mediator m;

    public Operations(Mediator mediator) {
        Connection connection = Connect.getInstance().getConnection();
        m = mediator;
        tasks = new Tasks(connection, mediator);
    }

    public void importMix() {

        CompletableFuture
                .runAsync(tasks.clearMixDiffSelection, SWING_EXECUTOR);

        CompletableFuture<MixDO> gotMixDO = CompletableFuture
                .supplyAsync(tasks.getMix);

        gotMixDO
                .thenAcceptAsync(tasks.solveModel)
                .join();

        CompletableFuture
                .supplyAsync(tasks.fetchMixesToRecord)
                .thenApplyAsync(tasks.reloadCmbMixes, SWING_EXECUTOR)
                .thenCombineAsync(gotMixDO, tasks.findNewMix, SWING_EXECUTOR)
                .thenAccept(tasks.selectMix)
                .whenComplete((a, b) -> {
                    Namer.separator();
                });

        CompletableFuture.runAsync(tasks.reloadFoods, SWING_EXECUTOR);

        CompletableFuture.supplyAsync(tasks.fetchMixesToList)
                .thenAcceptAsync(tasks.reloadMixes, SWING_EXECUTOR);
    }

    public void solve() {

        CompletableFuture
                .runAsync(tasks.clearMixDiffSelection, SWING_EXECUTOR);

        CompletableFuture
                .supplyAsync(tasks.getMix)
                .thenAcceptAsync(tasks.solveModel)
                .join();

        CompletableFuture
                .supplyAsync(tasks.getMix)
                .thenAcceptAsync(tasks.selectMix, SWING_EXECUTOR)
                .whenComplete((a, b) -> {
                    Namer.separator();
                });

    }
}
