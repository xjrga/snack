package io.github.xjrga.snack.other;

import java.awt.event.MouseEvent;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

public class MyTableHeader
        extends JTableHeader {

    String[] tooltips;

    public MyTableHeader( TableColumnModel columnModel, String[] columnTooltips ) {
        super( columnModel );
        this.tooltips = columnTooltips;
    }

    public String getToolTipText( MouseEvent e ) {
        java.awt.Point p = e.getPoint();
        int index = columnModel.getColumnIndexAtX( p.x );
        if ( index > -1 ) {
            int realIndex = columnModel.getColumn( index ).getModelIndex();
            return this.tooltips[ realIndex ];
        } else {
            return "";
        }
    }
}
