package io.github.xjrga.snack.other;

import javax.swing.table.TableColumnModel;
import java.awt.event.MouseEvent;

public class TableHeaderVitamins extends MyTableHeader {

    public TableHeaderVitamins(TableColumnModel columnModel) {
        super(columnModel, new String[]{
            "Food Name",
            "Weight (g)",
            "Vitamin A, RAE (µg)",
            "Vitamin D (D2 + D3) (µg)",
            "Vitamin E (Alpha-Tocopherol) (mg)",
            "Vitamin C (Ascorbic Acid) (mg)",
            "Thiamin (mg)",
            "Riboflavin (mg)",
            "Niacin (mg)",
            "Vitamin B6 (mg)",
            "Folate, DFE (µg)",
            "Vitamin B12 (µg)",
            "Vitamin K (µg)",
            "Pantothenic Acid (mg)",
            "Choline (mg)"
        });
    }

    public String getToolTipText(MouseEvent e) {
        return super.getToolTipText(e);
    }
}
