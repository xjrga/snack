package io.github.xjrga.snack2.other;

import javax.swing.table.TableColumnModel;
import java.awt.event.MouseEvent;

public class TableHeaderEnergy extends MyTableHeader {
    public TableHeaderEnergy(TableColumnModel columnModel) {
        super(columnModel, new String[]{
                "Food Name",
                "Weight (g)",
                "Energy (Kcal)",
                "Protein (g)",
                "Fat (g)",
                "Digestible Carbohydrate (g)",
                "Alcohol (g)"
        });
    }

    public String getToolTipText(MouseEvent e) {
        return super.getToolTipText(e);
    }
}