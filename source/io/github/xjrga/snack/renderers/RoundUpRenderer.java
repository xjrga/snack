package io.github.xjrga.snack.renderers;

import java.math.BigDecimal;
import java.text.DecimalFormat;
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
        DecimalFormat df = new DecimalFormat("####");
        txt = df.format(bigDecimal);
      }
    }
    super.setValue(txt);
  }
}
