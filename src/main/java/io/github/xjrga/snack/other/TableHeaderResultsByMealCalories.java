package io.github.xjrga.snack.other;

import java.awt.event.MouseEvent;
import javax.swing.table.TableColumnModel;

public class TableHeaderResultsByMealCalories extends MyTableHeader {
  public TableHeaderResultsByMealCalories(TableColumnModel columnModel) {
    super(columnModel,
        new String[] {"Meal", "Weight (g)", "Energy Gross (Kcal)", "Energy Digestible (Kcal)",
            "Energy Fat (Kcal)", "Energy Carbohydrate (Kcal)", "Energy Fat and Carbohydrate (Kcal)",
            "Energy Protein (Kcal)", "Energy Alcohol (Kcal)"});
  }

  @Override
  public String getToolTipText(MouseEvent e) {
    return super.getToolTipText(e);
  }
}
