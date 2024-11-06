package io.github.xjrga.snack.other;

import java.awt.event.MouseEvent;
import javax.swing.table.TableColumnModel;

public class TableHeaderCarbs extends MyTableHeader {
  public TableHeaderCarbs(TableColumnModel columnModel) {
    super(
        columnModel,
        new String[] {
          "Food Name",
          "Weight (g)",
          "Energy Carbohydrate (Kcal)",
          "Carbohydrate By Difference (g)",
          "Fiber, Total (g)",
          "Digestible Carbohydrate (g)"
        });
  }

  @Override
  public String getToolTipText(MouseEvent e) {
    return super.getToolTipText(e);
  }
}
