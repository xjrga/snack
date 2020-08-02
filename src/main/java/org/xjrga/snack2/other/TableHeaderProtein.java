package org.xjrga.snack2.other;

import javax.swing.table.TableColumnModel;
import java.awt.event.MouseEvent;

public class TableHeaderProtein extends MyTableHeader {
    public TableHeaderProtein(TableColumnModel columnModel) {
        super(columnModel, new String[]{
                "Food Name",
                "Weight (g)",
                "Protein (g)",
                "Complete Protein (g)",
                "Incomplete Protein (g)"
        });
    }

    public String getToolTipText(MouseEvent e) {
        return super.getToolTipText(e);
    }
}