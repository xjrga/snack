package io.github.xjrga.snack.other;

import java.awt.event.MouseEvent;
import javax.swing.table.TableColumnModel;

public class TableHeaderRda extends MyTableHeader {
  public TableHeaderRda(TableColumnModel columnModel) {
    super(
        columnModel,
        new String[] {
          "NutrientId",
          "Nutrient",
          "Mix",
          "Recommended Dietary Allowance",
          "Percent Recommended Dietary Allowance",
          "Tolerable Upper Intake Level",
          "Percent Tolerable Upper Intake Level"
        });
  }

  @Override
  public String getToolTipText(MouseEvent e) {
    return super.getToolTipText(e);
  }
}
