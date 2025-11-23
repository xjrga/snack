package io.github.xjrga.snack.jcomponents;

import io.github.xjrga.snack.logger.LoggerImpl;
import io.github.xjrga.snack.other.Reload;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableRowSorter;

/**
 * @author jr
 */
public class TableCategory extends JTable {

    private TableRowSorter sorter;
    private JTextField searchTextField;
    private DataModel dm;

    public TableCategory() {

        searchTextField = new JTextField();
        dm = new DataModel();
        dm.addColumn("Id");
        dm.addColumn("Category");
        setModel(dm);
        setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        setFillsViewportHeight(true);
        setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        getTableHeader().setReorderingAllowed(false);
        sorter = new TableRowSorter<>(dm);
        setRowSorter(sorter);
        searchTextField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void changedUpdate(DocumentEvent e) {

                filter();
            }

            @Override
            public void insertUpdate(DocumentEvent e) {

                filter();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {

                filter();
            }

            private void filter() {

                RowFilter<Object, Object> rf = null;

                try {

                    List<RowFilter<Object, Object>> filters = new ArrayList<>();
                    filters.add(RowFilter.regexFilter("(?i)" + searchTextField.getText(), 0));
                    filters.add(RowFilter.regexFilter("(?i)" + searchTextField.getText(), 1));
                    rf = RowFilter.orFilter(filters);

                } catch (java.util.regex.PatternSyntaxException e) {

                    LoggerImpl.INSTANCE.logProblem(e);
                }

                sorter.setRowFilter(rf);
            }
        });
        adjustColumnWidth();
    }

    @Override
    public void setValueAt(Object aValue, int row, int column) {

        dm.setValueAt(aValue, convertRowIndexToModel(row), convertColumnIndexToModel(column));
    }

    public void selectRow(int RowNo) {

        setRowSelectionInterval(RowNo, RowNo);
    }

    public void showRow(int RowNo) {

        Rectangle rect = getCellRect(RowNo, 0, true);
        scrollRectToVisible(rect);
    }

    public boolean isSelectionEmpty() {

        int[] rows = getSelectedRows();
        return rows.length == 0;
    }

    public boolean isEmpty() {

        return !(getRowCount() > 0);
    }

    public Row getSelectedValue() {

        if (isEmpty()) {

            return new NullRow();
        }

        if (isSelectionEmpty()) {

            return new NullRow();
        }

        int row = getSelectedRow();
        return getRow(row);
    }

    public List<Row> getSelectedValues() {

        int[] selectedRows = getSelectedRows();
        ArrayList<Row> rows = new ArrayList<Row>();

        if (getSelectedRowCount() == 0) {

            return rows;
        }

        for (int i = 0; i < selectedRows.length; i++) {

            Row row = getRow(selectedRows[i]);
            rows.add(row);
        }

        return rows;
    }

    private Row getRow(int selectedRowNo) {

        String foodid = (String) getValueAt(selectedRowNo, 0);
        String foodname = (String) getValueAt(selectedRowNo, 1);
        Row category = new Row(foodid, foodname);
        return category;
    }

    public JTextField getTxtSearch() {

        return searchTextField;
    }

    public void reload(List<List> data) {

        dm.clear();
        dm.reload(data);
        adjustColumnWidth();
    }

    private void adjustColumnWidth() {

        getColumnModel().getColumn(0).setMinWidth(0);
        getColumnModel().getColumn(0).setMaxWidth(0);
    }

    public void clear() {

        dm.clear();
    }

    public class Row {

        private String categoryid;
        private String categoryname;

        public Row() {

            categoryid = "";
            categoryname = "";
        }

        public Row(String foodid, String foodname) {

            this.categoryid = foodid;
            this.categoryname = foodname;
        }

        public String getCategoryid() {

            return categoryid;
        }

        public String getCategoryname() {

            return categoryname;
        }

        public boolean isNull() {

            return false;
        }

        @Override
        public String toString() {

            return "Row{" + "categoryid=" + categoryid + ", categoryname=" + categoryname + '}';
        }
    }

    public class NullRow extends Row {

        public boolean isNull() {

            return true;
        }
    }

    public class DataModel extends AbstractTableModel implements Reload {

        private List<List> data;
        private List<String> columns;
        private int rowcount;

        public DataModel() {

            data = new ArrayList<List>();
            columns = new ArrayList<String>();
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

            return data.get(r).get(c);
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

            data.get(r).set(c, o);
            fireTableDataChanged();
        }

        public void reload(List<List> data) {

            this.data = data;
            setRowCount();
            fireTableDataChanged();
        }

        @Override
        public void clear() {

            data.clear();
            setRowCount();
            fireTableDataChanged();
        }

        private void setRowCount() {

            rowcount = data.size();
        }
    }

    @Override
    protected JTableHeader createDefaultTableHeader() {

        return new JTableHeader(columnModel) {
            @Override
            public String getToolTipText(MouseEvent e) {

                java.awt.Point p = e.getPoint();
                int index = columnModel.getColumnIndexAtX(p.x);

                if (index == -1) {

                    return "";
                }

                int realIndex = columnModel.getColumn(index).getModelIndex();
                return columnToolTips[realIndex];
            }
        };
    }

    public int find(String id) {

        int index = 0;
        int r = this.getRowCount();

        for (int j = 0; j < r; j++) {

            if (id.equals(getValueAt(j, 0))) {

                index = j;
            }
        }

        return index;
    }

    protected String[] columnToolTips = new String[] {"Category Id", "Category Name"};
}
