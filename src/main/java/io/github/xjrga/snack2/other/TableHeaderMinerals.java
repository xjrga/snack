package io.github.xjrga.snack2.other;

import javax.swing.table.TableColumnModel;
import java.awt.event.MouseEvent;

public class TableHeaderMinerals extends MyTableHeader {

    public TableHeaderMinerals(TableColumnModel columnModel) {
        super(columnModel, new String[]{
            "Food Name",
            "Weight",
            "Calcium, Ca (mg)",
            "Phosphorus, P (mg)",
            "Magnesium, Mg (mg)",
            "Iron, Fe (mg)",
            "Zinc, Zn (mg)",
            "Copper, Cu (mg)",
            "Manganese, Mn (mg)",
            "Fluoride, F (µg)",
            "Selenium, Se (µg)"
        });
    }

    public String getToolTipText(MouseEvent e) {
        return super.getToolTipText(e);
    }
}
