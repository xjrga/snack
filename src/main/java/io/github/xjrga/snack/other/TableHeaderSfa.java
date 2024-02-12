package io.github.xjrga.snack.other;

import java.awt.event.MouseEvent;
import javax.swing.table.TableColumnModel;

public class TableHeaderSfa extends MyTableHeader {
  public TableHeaderSfa(TableColumnModel columnModel) {
    super(columnModel,
        new String[] {"Food Name", "Weight (g)", "Saturated Fat (g)",
            "Hypercholesterolemic Fat, Lauric + Myristic + Palmitic (g)", "Lauric Acid, 12:0 (g)",
            "Myristic Acid, 14:0 (g)", "Palmitic Acid, 16:0 (g)", "Stearic Acid, 18:0 (g)"});
  }

  @Override
  public String getToolTipText(MouseEvent e) {
    return super.getToolTipText(e);
  }
}
