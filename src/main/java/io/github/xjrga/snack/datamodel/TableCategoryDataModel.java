package io.github.xjrga.snack.datamodel;

import io.github.xjrga.snack.records.TableCategoryRow;
import java.util.ArrayList;
import java.util.List;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author jr
 */
public final class TableCategoryDataModel extends AbstractTableModel {

    private List<TableCategoryRow> data;
    private List<String> columns;
    private int rowcount;

    public TableCategoryDataModel() {
        data = new ArrayList<TableCategoryRow>();
        columns = new ArrayList<String>();
        addColumn("Id");
        addColumn("Category");
        setRowCount();
    }

    public void addColumn(String col) {
        columns.add(col);
    }

    @Override
    public void addTableModelListener(TableModelListener l) {
        super.addTableModelListener(l);
    }

    @Override
    public Class<?> getColumnClass(int c) {
        Class columnClass = String.class;
        return columnClass;
    }

    @Override
    public int getColumnCount() {
        return columns.size();
    }

    @Override
    public String getColumnName(int c) {
        return columns.get(c);
    }

    @Override
    public int getRowCount() {
        return rowcount;
    }

    @Override
    public Object getValueAt(int r, int c) {
        if (data.isEmpty()) {
            return "";
        }
        TableCategoryRow row = data.get(r);
        String value = "";
        switch (c) {
            case 0 -> {
                value = row.categoryId();
            }
            case 1 -> {
                value = row.categoryName();
            }
        }
        return value;
    }

    @Override
    public boolean isCellEditable(int r, int c) {
        return false;
    }

    @Override
    public void removeTableModelListener(TableModelListener l) {
        super.removeTableModelListener(l);
    }

    @Override
    public void setValueAt(Object o, int r, int c) {
        TableCategoryRow row = data.get(r);
        String categoryId = row.categoryId();
        String categoryName = row.categoryName();
        switch (c) {
            case 0 -> {
                categoryId = (String) o;
            }
            case 1 -> {
                categoryName = (String) o;
            }
        }
        data.set(r, new TableCategoryRow(categoryId, categoryName));
        fireTableDataChanged();
    }

    public void reload(List<TableCategoryRow> data) {
        this.data = data;
        setRowCount();
        fireTableDataChanged();
    }

    public void clear() {
        data.clear();
        setRowCount();
        fireTableDataChanged();
    }

    private void setRowCount() {
        rowcount = data.size();
    }
}
