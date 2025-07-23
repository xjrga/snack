package io.github.xjrga.snack.renderers;

import java.awt.Component;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

public class RoundUpRenderer extends DefaultTableCellRenderer {

  private String txt;

  @Override
  public void setHorizontalAlignment(int alignment) {
    super.setHorizontalAlignment(SwingConstants.RIGHT);
  }

  @Override
  protected void setValue(Object value) {
    if (value != null) {
      if (value instanceof BigDecimal bigDecimal) {
        DecimalFormat df = new DecimalFormat("###0.0");
        txt = df.format(bigDecimal);
      }
    }
    super.setValue(txt);
  }

  @Override
  public Component getTableCellRendererComponent(
      JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
    JLabel c =
        (JLabel)
            super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
    c.setToolTipText("" + value);
    return c;
  }
}
