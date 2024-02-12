package io.github.xjrga.snack.other;

import java.awt.event.MouseEvent;
import javax.swing.table.TableColumnModel;

public class TableHeaderGlycemic extends MyTableHeader {
  public TableHeaderGlycemic(TableColumnModel columnModel) {
    super(columnModel,
        new String[] {"Food Name", "Weight (g)", "Energy Carbohydrate (Kcal)",
            "Digestible Carbohydrate (g)", "Percent of Total Carbohydrate (%)", "Glycemic Index",
            "Glycemic Load", "Contribution to Glycemic Index of Meal"});
  }

  @Override
  public String getToolTipText(MouseEvent e) {
    return super.getToolTipText(e);
  }
}
