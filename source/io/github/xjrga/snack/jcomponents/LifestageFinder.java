package io.github.xjrga.snack.jcomponents;

import io.github.xjrga.snack.dataobject.LifeStageDO;
import java.util.List;

/**
 * @author jr
 */
public class LifestageFinder {

    public LifestageFinder() {

        //
    }

    public static LifeStageDO find(List<?> list, int LifeStageId) {

        LifeStageDO o = null;

        for (int i = 0; i < list.size(); i++) {

            o = (LifeStageDO) list.get(i);

            if (o.getLifeStageId() == LifeStageId) {

                break;
            }
        }

        return o;
    }
}
