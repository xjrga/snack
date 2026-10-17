package io.github.xjrga.snack.completablefuture;

import io.github.xjrga.snack.completablefuture.records.Records.Mix;
import io.github.xjrga.snack.database.query.AllocateAction;
import io.github.xjrga.snack.dataobject.MixDO;
import io.github.xjrga.snack.gui.Main;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author jr
 */
public class Mediator {

    private Main main;
    private MixDO mix;

    public Mediator() {
    }

    public void registerMain(Main main) {
        this.main = main;
    }

    public MixDO solveModel(MixDO mix) {
        Optional<MixDO> solveModel = main.solveModel(mix);
        if (!solveModel.isEmpty()) {
            (new AllocateAction(mix.getMixid())).execute();
        }
        MixDO orElse = solveModel.orElse(mix);
        return orElse;
    }

    public void clearMixDiffSelection() {
        main.clearMixDiffSelection();
    }

    public void selectMix(MixDO mix) {
        main.selectMix(mix);
    }

    public void setMix(MixDO mix) {
        //Mix is set on cmbMixes selection event
        //and on mniImportMixModel action event
        this.mix = mix;
    }

    public MixDO getMix() {
        return mix;
    }

    public void reloadFoods() {
        main.reloadFoods();
    }

    public void reloadMixes(List<List> lst) {
        main.reloadMixes(lst);
    }

    public List<MixDO> reloadCmbMixes(List<Mix> lst) {
        return main.reloadCmbMixes(lst);
    }

    public MixDO findNewMix(List<MixDO> mixesList, MixDO mix) {
        return main.findNewMix(mixesList, mix);
    }
}
