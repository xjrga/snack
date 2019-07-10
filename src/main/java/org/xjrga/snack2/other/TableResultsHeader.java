package org.xjrga.snack2.other;

import javax.swing.table.TableColumnModel;
import java.awt.event.MouseEvent;

public class TableResultsHeader extends MyTableHeader {
    public TableResultsHeader(TableColumnModel columnModel) {
        super(columnModel, new String[]{
                "Food Item",
                "Quantity",
                "Calories",
                "Total Protein",
                "Complete Protein",
                "Incomplete Protein",
                "Total Fat",
                "Digestible Carbohydrate",
                "Fiber",
                "Saturated Fat",
                "Monounsaturated Fat",
                "Polyunsaturated Fat",
                "Cholesterol",
                "Alcohol",
                "Sodium",
                "Potassium",
                "Calcium",
                "Magnesium",
                "Cost"
        });
    }

    public String getToolTipText(MouseEvent e) {
        return super.getToolTipText(e);
    }
}