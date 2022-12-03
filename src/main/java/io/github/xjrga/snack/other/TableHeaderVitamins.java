package io.github.xjrga.snack.other;

import java.awt.event.MouseEvent;
import javax.swing.table.TableColumnModel;

public class TableHeaderVitamins
        extends MyTableHeader {

    public TableHeaderVitamins( TableColumnModel columnModel ) {
        super( columnModel, new String[] {
            "Food Name",
            "Weight (g)",
            "Vitamin A (mcg)",
            "Vitamin D (mcg)",
            "Alpha-Tocopherol, Vitamin E (mg)",
            "Ascorbic Acid, Vitamin C (mg)",
            "Thiamin, Vitamin B1 (mg)",
            "Riboflavin, Vitamin B2 (mg)",
            "Niacin, Vitamin B3 (mg)",
            "Vitamin B6 (mg)",
            "Folate, Vitamin B9 (mcg)",
            "Vitamin B12 (mcg)",
            "Vitamin K (mcg)",
            "Pantothenic Acid, Vitamin B5 (mg)",
            "Choline, Vitamin B4 (mg)"
        } );
    }

    @Override
    public String getToolTipText( MouseEvent e ) {
        return super.getToolTipText( e );
    }
}
