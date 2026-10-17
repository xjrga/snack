package io.github.xjrga.snack.jcomponents;

import io.github.xjrga.snack.dataobject.MixDO;
import java.util.List;

/**
 * @author jr
 */
public class MixFinder {

    public MixFinder() {
        //
    }

    public static MixDO find(List<?> list, String MixId) {
        MixDO o = null;
        for (int i = 0; i < list.size(); i++) {
            o = (MixDO) list.get(i);
            if (o.getMixid().equals(MixId)) {
                break;
            }
        }
        return o;
    }
}
