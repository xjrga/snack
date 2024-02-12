package io.github.xjrga.snack.other;

import java.awt.event.MouseEvent;
import javax.swing.table.TableColumnModel;

public class TableHeaderMinerals extends MyTableHeader {
  public TableHeaderMinerals(TableColumnModel columnModel) {
    super(columnModel,
        new String[] {"Food Name", "Weight (g)", "Calcium, Ca (mg)", "Phosphorus, P (mg)",
            "Magnesium, Mg (mg)", "Iron, Fe (mg)", "Zinc, Zn (mg)", "Copper, Cu (mg)",
            "Manganese, Mn (mg)", "Selenium, Se (mcg)"});
  }

  @Override
  public String getToolTipText(MouseEvent e) {
    return super.getToolTipText(e);
  }
}
