package io.github.xjrga.snack.other;

import java.awt.event.MouseEvent;
import javax.swing.table.TableColumnModel;

public class TableHeaderEnergy extends MyTableHeader {

    public TableHeaderEnergy( TableColumnModel columnModel ) {
        super( columnModel, new String[] {
            "Food Name",
            "Weight (g)",
            "Energy Gross (Kcal)",
            "Energy Digestible (Kcal)",
            "Energy Fat (Kcal)",
            "Energy Carbohydrate (Kcal)",
            "Energy Protein (Kcal)",
            "Energy Alcohol (Kcal)",
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
