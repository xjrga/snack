package io.github.xjrga.snack.other;

import javax.swing.table.TableColumnModel;
import java.awt.event.MouseEvent;

public class TableHeaderFats extends MyTableHeader {

    public TableHeaderFats(TableColumnModel columnModel) {
        super(columnModel, new String[]{
            "Food Name",
            "Weight (g)",
            "Energy Fat (Kcal)",
            "Fat (g)",
            "Monounsaturated Fat (g)",
            "Polyunsaturated Fat (g)",
            "Saturated Fat (g)",
            "Cholesterol (mg)",
            "Linoleic Acid (g)",
            "Alpha-Linolenic Acid (g)",
            "DHA (g)",
            "EPA (g)"
        });
    }

    public String getToolTipText(MouseEvent e) {
        return super.getToolTipText(e);
    }
}
