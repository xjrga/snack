package io.github.xjrga.snack.renderers;

import java.awt.Component;
import java.math.BigDecimal;
import javax.swing.AbstractCellEditor;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableCellEditor;

public class StripTrailingZerosEditor extends AbstractCellEditor implements TableCellEditor {

    private final JTextField txt;
    private BigDecimal number;

    public StripTrailingZerosEditor() {
        txt = new JTextField();
        txt.setHorizontalAlignment(JTextField.RIGHT);
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        number = (BigDecimal) value;
        txt.setText(number.stripTrailingZeros().toPlainString());
        return txt;
    }

    @Override
    public Object getCellEditorValue() {
        try {
            return new BigDecimal(txt.getText().trim());
        } catch (NumberFormatException e) {
            return number;
        }
    }
}
