package io.github.xjrga.snack.other;

import javax.swing.table.TableColumnModel;
import java.awt.event.MouseEvent;

public class TableHeaderProtein extends MyTableHeader {

    public TableHeaderProtein(TableColumnModel columnModel) {
        super(columnModel, new String[]{
            "Food Name",
            "Weight (g)",
            "Energy Protein (Kcal)",
            "Protein (g)",
            "Complete Protein (g)"
        });
    }

    @Override
    public String getToolTipText(MouseEvent e) {
        return super.getToolTipText(e);
    }
}
