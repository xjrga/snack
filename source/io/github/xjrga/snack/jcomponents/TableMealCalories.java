package io.github.xjrga.snack.jcomponents;

import io.github.xjrga.snack.logger.LoggerImpl;
import io.github.xjrga.snack.other.Reload;
import io.github.xjrga.snack.renderers.RoundDownRenderer;
import io.github.xjrga.snack.renderers.RoundUpRenderer;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;
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
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableRowSorter;

/**
 * @author jr
 */
public class TableMealCalories extends JTable {

    private TableRowSorter sorter;
    private JTextField searchField;
    private DataModel dm;

    public TableMealCalories() {

        searchField = new JTextField();
        dm = new DataModel();
        dm.addColumn("Meal");
        dm.addColumn("Weight");
        dm.addColumn("eGross");
        dm.addColumn("eDigestible");
        dm.addColumn("eFat");
        dm.addColumn("eCarbs");
        dm.addColumn("eFat+");
        dm.addColumn("eProtein");
        dm.addColumn("eAlcohol");
        setModel(dm);
        setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        setFillsViewportHeight(true);
        setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        getTableHeader().setReorderingAllowed(false);
        sorter = new TableRowSorter<>(dm);
        setRowSorter(sorter);
        searchField.getDocument().addDocumentListener(new DocumentListener() {
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
                    filters.add(RowFilter.regexFilter("(?i)" + searchField.getText(), 0));
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

        String meal = (String) getValueAt(selectedRowNo, 0);
        BigDecimal weight = (BigDecimal) getValueAt(selectedRowNo, 1);
        BigDecimal egross = (BigDecimal) getValueAt(selectedRowNo, 2);
        BigDecimal edigest = (BigDecimal) getValueAt(selectedRowNo, 3);
        BigDecimal efat = (BigDecimal) getValueAt(selectedRowNo, 4);
        BigDecimal ecarbs = (BigDecimal) getValueAt(selectedRowNo, 5);
        BigDecimal efatplus = (BigDecimal) getValueAt(selectedRowNo, 6);
        BigDecimal eprotein = (BigDecimal) getValueAt(selectedRowNo, 7);
        BigDecimal ealcohol = (BigDecimal) getValueAt(selectedRowNo, 8);
        Row row = new Row();
        row.setMeal(meal);
        row.setWeight(weight);
        row.setEgross(egross);
        row.setEdigest(edigest);
        row.setEfat(efat);
        row.setEcarbs(ecarbs);
        row.setEfatplus(efatplus);
        row.setEprotein(eprotein);
        row.setEalcohol(ealcohol);
        return row;
    }

    public JTextField getSearchField() {

        return searchField;
    }

    public void reload(List<List> data) {

        dm.clear();
        dm.reload(data);
        adjustColumnWidth();
    }

    public void clear() {

        dm.clear();
    }

    private void adjustColumnWidth() {

        getColumnModel().getColumn(0).setMinWidth(200);
    }

    public void roundUp() {

        roundQuantity(new RoundUpRenderer());
    }

    public void roundDown() {

        roundQuantity(new RoundDownRenderer());
    }

    private void roundQuantity(DefaultTableCellRenderer renderer) {

        getColumnModel().getColumn(1).setCellRenderer(renderer);
        getColumnModel().getColumn(2).setCellRenderer(renderer);
        getColumnModel().getColumn(3).setCellRenderer(renderer);
        getColumnModel().getColumn(4).setCellRenderer(renderer);
        getColumnModel().getColumn(5).setCellRenderer(renderer);
        getColumnModel().getColumn(6).setCellRenderer(renderer);
        getColumnModel().getColumn(7).setCellRenderer(renderer);
        getColumnModel().getColumn(8).setCellRenderer(renderer);
        revalidate();
        repaint();
    }

    public class Row {

        private String meal;
        private BigDecimal weight;
        private BigDecimal egross;
        private BigDecimal edigest;
        private BigDecimal efat;
        private BigDecimal ecarbs;
        private BigDecimal efatplus;
        private BigDecimal eprotein;
        private BigDecimal ealcohol;

        public Row() {

            meal = null;
            weight = null;
            egross = null;
            edigest = null;
            efat = null;
            ecarbs = null;
            efatplus = null;
            eprotein = null;
            ealcohol = null;
        }

        public String getMeal() {

            return meal;
        }

        public void setMeal(String meal) {

            this.meal = meal;
        }

        public BigDecimal getWeight() {

            return weight;
        }

        public void setWeight(BigDecimal weight) {

            this.weight = weight;
        }

        public BigDecimal getEgross() {

            return egross;
        }

        public void setEgross(BigDecimal egross) {

            this.egross = egross;
        }

        public BigDecimal getEdigest() {

            return edigest;
        }

        public void setEdigest(BigDecimal edigest) {

            this.edigest = edigest;
        }

        public BigDecimal getEfat() {

            return efat;
        }

        public void setEfat(BigDecimal efat) {

            this.efat = efat;
        }

        public BigDecimal getEcarbs() {

            return ecarbs;
        }

        public void setEcarbs(BigDecimal ecarbs) {

            this.ecarbs = ecarbs;
        }

        public BigDecimal getEfatplus() {

            return efatplus;
        }

        public void setEfatplus(BigDecimal efatplus) {

            this.efatplus = efatplus;
        }

        public BigDecimal getEprotein() {

            return eprotein;
        }

        public void setEprotein(BigDecimal eprotein) {

            this.eprotein = eprotein;
        }

        public BigDecimal getEalcohol() {

            return ealcohol;
        }

        public void setEalcohol(BigDecimal ealcohol) {

            this.ealcohol = ealcohol;
        }

        public boolean isNull() {

            return false;
        }
    }

    public class NullRow extends Row {

        public boolean isNull() {

            return true;
        }
    }

    private class DataModel extends AbstractTableModel implements Reload {

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

            Class columnClass = BigDecimal.class;

            switch (c) {
                case 0 -> {
                    columnClass = String.class;
                }
            }

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
            fireTableCellUpdated(r, c);
            ;
        }

        @Override
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

    protected String[] columnToolTips =
            new String[] {"Meal", "Weight", "EGross", "EDigest", "EFat", "ECarbs", "EFatPlus", "EProtein", "EAlcohol"};
}
