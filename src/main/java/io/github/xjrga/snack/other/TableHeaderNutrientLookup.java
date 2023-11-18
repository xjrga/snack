package io.github.xjrga.snack.other;

import java.awt.event.MouseEvent;
import javax.swing.table.TableColumnModel;

public class TableHeaderNutrientLookup
        extends MyTableHeader {
    public TableHeaderNutrientLookup( TableColumnModel columnModel ) {
        super( columnModel, new String[] {
            "Food Name",
            "Weight (g)",
            "Calories (Kcal)"
        } );
    }
    @Override
    public String getToolTipText( MouseEvent e ) {
        return super.getToolTipText( e );
    }
}
