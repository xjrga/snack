package io.github.xjrga.snack.other;

import java.awt.event.MouseEvent;
import javax.swing.table.TableColumnModel;

public class TableHeaderProtein
        extends MyTableHeader {
    public TableHeaderProtein( TableColumnModel columnModel ) {
        super( columnModel, new String[] {
            "Food Name",
            "Weight (g)",
            "Energy Protein (Kcal)",
            "Protein (g)",
            "Complete Protein (g)"
        } );
    }
    @Override
    public String getToolTipText( MouseEvent e ) {
        return super.getToolTipText( e );
    }
}
