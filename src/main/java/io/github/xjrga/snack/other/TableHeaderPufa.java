package io.github.xjrga.snack.other;

import java.awt.event.MouseEvent;
import javax.swing.table.TableColumnModel;

public class TableHeaderPufa
        extends MyTableHeader {
    public TableHeaderPufa( TableColumnModel columnModel ) {
        super( columnModel, new String[] {
            "Food Name",
            "Weight (g)",
            "Polyunsaturated Fat (g)",
            "Linoleic Acid, 18:2n-6 (g)",
            "Alpha-Linolenic Acid, 18:3n−3 (g)",
            "Eicosapentaenoic Acid, 20:5n−3 (g)",
            "Docosahexaenoic Acid,  22:6n−3 (g)"
        } );
    }
    @Override
    public String getToolTipText( MouseEvent e ) {
        return super.getToolTipText( e );
    }
}
