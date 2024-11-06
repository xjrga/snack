package io.github.xjrga.snack.other;

import java.awt.event.MouseEvent;
import javax.swing.table.TableColumnModel;

public class TableHeaderFats extends MyTableHeader {
  public TableHeaderFats(TableColumnModel columnModel) {
    super(
        columnModel,
        new String[] {
          "Food Name",
          "Weight (g)",
          "Energy Fat (Kcal)",
          "Fat (g)",
          "Monounsaturated Fat (g)",
          "Polyunsaturated Fat (g)",
          "Saturated Fat (g)",
          "Cholesterol (mg)"
        });
  }

  @Override
  public String getToolTipText(MouseEvent e) {
    return super.getToolTipText(e);
  }
}
