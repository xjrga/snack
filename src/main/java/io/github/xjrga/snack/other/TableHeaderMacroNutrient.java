package io.github.xjrga.snack.other;

import java.awt.event.MouseEvent;
import javax.swing.table.TableColumnModel;

public class TableHeaderMacroNutrient
        extends MyTableHeader {

    public TableHeaderMacroNutrient( TableColumnModel columnModel ) {
        super( columnModel, new String[] {
            "Food Name",
            "Weight (g)",
            "Fat (g)",
            "Digestible Carbohydrate (g)",
            "Protein (g)",
            "Alcohol (g)"
        } );
    }

    @Override
    public String getToolTipText( MouseEvent e ) {
        return super.getToolTipText( e );
    }
}
