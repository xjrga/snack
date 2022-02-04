package io.github.xjrga.snack.other;

import javax.swing.table.TableColumnModel;
import java.awt.event.MouseEvent;

public class TableHeaderNutrientLookup extends MyTableHeader {

    public TableHeaderNutrientLookup(TableColumnModel columnModel) {
        super(columnModel, new String[]{
            "Food Name",
            "Weight (g)"
        });
    }

    @Override
    public String getToolTipText(MouseEvent e) {
        return super.getToolTipText(e);
    }
}
