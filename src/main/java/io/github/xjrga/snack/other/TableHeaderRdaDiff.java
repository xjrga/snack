package io.github.xjrga.snack.other;

import java.awt.event.MouseEvent;
import javax.swing.table.TableColumnModel;

public class TableHeaderRdaDiff extends MyTableHeader {

    public TableHeaderRdaDiff( TableColumnModel columnModel ) {
        super( columnModel, new String[] {
            "Nutrient",
            "Mix",
            "Recommended Dietary Allowances",
            "Percent Daily Value",
            "Tolerable Upper Intake Level",
            "Percent Tolerable Upper Intake Level"
        } );
    }

    @Override
    public String getToolTipText( MouseEvent e ) {
        return super.getToolTipText( e );
    }
}
