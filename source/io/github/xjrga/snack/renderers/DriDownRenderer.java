package io.github.xjrga.snack.renderers;

import io.github.xjrga.snack.other.Utilities;
import java.awt.Color;
import java.awt.Component;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

public class DriDownRenderer extends DefaultTableCellRenderer {

    private String txt;

    @Override
    public void setHorizontalAlignment(int alignment) {

        super.setHorizontalAlignment(SwingConstants.RIGHT);
    }

    @Override
    protected void setValue(Object value) {

        if (value == null) {

            super.setValue(txt);
            return;
        }

        DecimalFormat df = new DecimalFormat("###0.0");
        final BigDecimal bValue = (BigDecimal) value;
        txt = df.format(bValue);

        if (Utilities.lessThan(bValue, new BigDecimal("99.99999"))) {

            setForeground(Color.PINK);

        } else {

            setForeground(Color.decode("0xbec6cc"));
        }

        super.setValue(txt);
    }

    @Override
    public Component getTableCellRendererComponent(
            JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

        JLabel c = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        if (value == null) {

            return c;
        }

        if (column != 4) {

            return c;
        }

        String nutrientid = (String) table.getValueAt(row, 0);

        switch (nutrientid) {
            case "301", "304", "306", "421", "320", "401", "328", "323" -> {
                if (Utilities.lessThan((BigDecimal) value, new BigDecimal("99.99999"))) {

                    setForeground(Color.RED);
                }
            }
        }

        c.setToolTipText((new DecimalFormat("######0.0#################")).format(value));

        return c;
    }
}
