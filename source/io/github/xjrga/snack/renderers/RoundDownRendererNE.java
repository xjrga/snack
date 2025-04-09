package io.github.xjrga.snack.renderers;

import io.github.xjrga.snack.other.Utilities;
import java.awt.Color;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

public class RoundDownRendererNE extends DefaultTableCellRenderer {

  private String txt;
  private BigDecimal bigDecimal;

  @Override
  public void setHorizontalAlignment(int alignment) {
    super.setHorizontalAlignment(SwingConstants.RIGHT);
  }

  @Override
  protected void setValue(Object value) {
    if (value != null) {
      if (value instanceof BigDecimal d) {
        DecimalFormat df = new DecimalFormat("###0.000");
        txt = df.format(d);
        if (!Utilities.equalTo(d, new BigDecimal("0"))) {
          setForeground(Color.decode("0x00FF00"));
        } else {
          setForeground(Color.decode("0xbec6cc"));
        }
      }
    }
    super.setValue(txt);
  }
}
