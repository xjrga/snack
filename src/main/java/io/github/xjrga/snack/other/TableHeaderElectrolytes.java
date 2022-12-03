package io.github.xjrga.snack.other;

import java.awt.event.MouseEvent;
import javax.swing.table.TableColumnModel;

public class TableHeaderElectrolytes
        extends MyTableHeader {

    public TableHeaderElectrolytes( TableColumnModel columnModel ) {
        super( columnModel, new String[] {
            "Food Name",
            "Weight",
            "Sodium, Na (mg)",
            "Potassium, K (mg)"
        } );
    }

    @Override
    public String getToolTipText( MouseEvent e ) {
        return super.getToolTipText( e );
    }
}
