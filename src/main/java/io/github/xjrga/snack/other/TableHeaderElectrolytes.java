package io.github.xjrga.snack.other;

import javax.swing.table.TableColumnModel;
import java.awt.event.MouseEvent;

public class TableHeaderElectrolytes extends MyTableHeader {

    public TableHeaderElectrolytes(TableColumnModel columnModel) {
        super(columnModel, new String[]{
            "Food Name",
            "Weight",
            "Sodium, Na (mg)",
            "Potassium, K (mg)"
        });
    }

    public String getToolTipText(MouseEvent e) {
        return super.getToolTipText(e);
    }
}
