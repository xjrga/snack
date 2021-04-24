package io.github.xjrga.snack2.other;

import javax.swing.table.TableColumnModel;
import java.awt.event.MouseEvent;

public class TableHeaderCarbs extends MyTableHeader {
    public TableHeaderCarbs(TableColumnModel columnModel) {
        super(columnModel, new String[]{
                "Food Name",
                "Weight (g)",
                "Digestible Carbohydrate (g)",
                "Fiber, Total (g)",
                "Fiber, Insoluble (g)",
                "Fiber, Soluble (g)",
                "Sucrose (g)",
                "Fructose (g)",
                "Lactose (g)"
        });
    }

    public String getToolTipText(MouseEvent e) {
        return super.getToolTipText(e);
    }
}