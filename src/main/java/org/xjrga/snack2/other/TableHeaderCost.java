package org.xjrga.snack2.other;

import javax.swing.table.TableColumnModel;
import java.awt.event.MouseEvent;

public class TableHeaderCost extends MyTableHeader {
    public TableHeaderCost(TableColumnModel columnModel) {
        super(columnModel, new String[]{
                "Food Name",
                "Weight (g)",
                "Cost ($)"
        });
    }

    public String getToolTipText(MouseEvent e) {
        return super.getToolTipText(e);
    }
}