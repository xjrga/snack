package io.github.xjrga.snack.other;

import javax.swing.table.TableColumnModel;
import java.awt.event.MouseEvent;

public class TableHeaderGlycemic extends MyTableHeader {

    public TableHeaderGlycemic(TableColumnModel columnModel) {
        super(columnModel, new String[]{
            "Food Name",
            "Weight (g)",
            "Energy Carbohydrate (Kcal)",
            "Digestible Carbohydrate (g)",
            "Percent of Total Carbohydrate (%)",
            "Glycemic Index",
            "Glycemic Load",
            "Contribution to Glycemic Index of Meal"
        });
    }

    public String getToolTipText(MouseEvent e) {
        return super.getToolTipText(e);
    }
}
