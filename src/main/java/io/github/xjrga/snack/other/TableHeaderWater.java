package io.github.xjrga.snack.other;

import java.awt.event.MouseEvent;
import javax.swing.table.TableColumnModel;

public class TableHeaderWater
        extends MyTableHeader {
    public TableHeaderWater( TableColumnModel columnModel ) {
        super( columnModel, new String[] {
            "Food Name",
            "Weight (g)",
            "Water (g)"
        } );
    }
    @Override
    public String getToolTipText( MouseEvent e ) {
        return super.getToolTipText( e );
    }
}
