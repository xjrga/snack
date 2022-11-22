package io.github.xjrga.snack.other;

import java.awt.event.MouseEvent;
import javax.swing.table.TableColumnModel;

public class TableHeaderResultsByMealGrams extends MyTableHeader {

    public TableHeaderResultsByMealGrams( TableColumnModel columnModel ) {
        super( columnModel, new String[] {
            "Meal",
            "Weight (g)",
            "Fat (g)",
            "Digestible Carbohydrate (g)",
            "Protein (g)",
            "Complete Protein (g)",
            "Alcohol (g)",
            "Fiber, Total (g)",
            "Sodium, Na (mg)",
            "Potassium, K (mg)"
        } );
    }

    @Override
    public String getToolTipText( MouseEvent e ) {
        return super.getToolTipText( e );
    }
}
