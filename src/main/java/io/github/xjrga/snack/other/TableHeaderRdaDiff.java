package io.github.xjrga.snack.other;

import javax.swing.table.TableColumnModel;
import java.awt.event.MouseEvent;

public class TableHeaderRdaDiff extends MyTableHeader {

    public TableHeaderRdaDiff(TableColumnModel columnModel) {
        super(columnModel, new String[]{
            "Nutrient",
            "Mix",
            "Recommended Dietary Allowances",
            "Percent Daily Value",
            "Tolerable Upper Intake Level",
            "Percent Tolerable Upper Intake Level"
        });
    }

    @Override
    public String getToolTipText(MouseEvent e) {
        return super.getToolTipText(e);
    }
}
