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
public class TableVitamins extends JTable {

  private TableRowSorter sorter;
  private JTextField searchField;
  private DataModel dm;

  public TableVitamins() {
    searchField = new JTextField();
    dm = new DataModel();
    dm.addColumn("MixId");
    dm.addColumn("FoodId");
    dm.addColumn("Name");
    dm.addColumn("Weight");
    dm.addColumn("A");
    dm.addColumn("D");
    dm.addColumn("E");
    dm.addColumn("C");
    dm.addColumn("Thiamin");
    dm.addColumn("Riboflavin");
    dm.addColumn("Niacin");
    dm.addColumn("B6");
    dm.addColumn("Folate");
    dm.addColumn("B12");
    dm.addColumn("K");
    dm.addColumn("Pantothenic Acid");
    dm.addColumn("Choline");
    setModel(dm);
    setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    setFillsViewportHeight(true);
    setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
    getTableHeader().setReorderingAllowed(false);
    sorter = new TableRowSorter<>(dm);
    setRowSorter(sorter);
    searchField
        .getDocument()
        .addDocumentListener(
            new DocumentListener() {
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

  public boolean isSelectionEmpty() {
    int[] rows = getSelectedRows();
    return rows.length == 0;
  }

  public boolean isEmpty() {
    return !(getRowCount() > 0);
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

  public Row getSelectedValue() {
    if (isEmpty()) {
      return new NullRow();
    }
    if (isSelectionEmpty()) {
      return new NullRow();
    }
    return getRow(getSelectedRow());
  }

  public List<Row> getSelectedValues() {
    ArrayList<Row> results = new ArrayList<Row>();
    if (isSelectionEmpty()) {
      return results;
    }
    int[] rows = this.getSelectedRows();
    for (int i = 0; i < rows.length; i++) {
      Row foodfacts = getRow(i);
      results.add(foodfacts);
    }
    return results;
  }

  private Row getRow(int selectedRowNo) {
    String mixid = (String) getValueAt(selectedRowNo, 0);
    String foodid = (String) getValueAt(selectedRowNo, 1);
    String foodname = (String) getValueAt(selectedRowNo, 2);
    BigDecimal other_weight = (BigDecimal) getValueAt(selectedRowNo, 3);
    BigDecimal vitamins_vitamin_a = (BigDecimal) getValueAt(selectedRowNo, 4);
    BigDecimal vitamins_vitamin_d = (BigDecimal) getValueAt(selectedRowNo, 5);
    BigDecimal vitamins_vitamin_e = (BigDecimal) getValueAt(selectedRowNo, 6);
    BigDecimal vitamins_vitamin_c = (BigDecimal) getValueAt(selectedRowNo, 7);
    BigDecimal vitamins_thiamin = (BigDecimal) getValueAt(selectedRowNo, 8);
    BigDecimal vitamins_riboflavin = (BigDecimal) getValueAt(selectedRowNo, 9);
    BigDecimal vitamins_niacin = (BigDecimal) getValueAt(selectedRowNo, 10);
    BigDecimal vitamins_vitamin_b6 = (BigDecimal) getValueAt(selectedRowNo, 11);
    BigDecimal vitamins_folate = (BigDecimal) getValueAt(selectedRowNo, 12);
    BigDecimal vitamins_vitamin_b12 = (BigDecimal) getValueAt(selectedRowNo, 13);
    BigDecimal vitamins_vitamin_k = (BigDecimal) getValueAt(selectedRowNo, 14);
    BigDecimal vitamins_pantothenic_acid = (BigDecimal) getValueAt(selectedRowNo, 15);
    BigDecimal vitamins_choline = (BigDecimal) getValueAt(selectedRowNo, 16);
    Row row = new Row();
    row.setMixid(mixid);
    row.setFoodid(foodid);
    row.setFoodname(foodname);
    row.setOther_weight(other_weight);
    row.setVitamins_vitamin_a(vitamins_vitamin_a);
    row.setVitamins_vitamin_d(vitamins_vitamin_d);
    row.setVitamins_vitamin_e(vitamins_vitamin_e);
    row.setVitamins_vitamin_c(vitamins_vitamin_c);
    row.setVitamins_thiamin(vitamins_thiamin);
    row.setVitamins_riboflavin(vitamins_riboflavin);
    row.setVitamins_niacin(vitamins_niacin);
    row.setVitamins_vitamin_b6(vitamins_vitamin_b6);
    row.setVitamins_folate(vitamins_folate);
    row.setVitamins_vitamin_b12(vitamins_vitamin_b12);
    row.setVitamins_vitamin_k(vitamins_vitamin_k);
    row.setVitamins_pantothenic_acid(vitamins_pantothenic_acid);
    row.setVitamins_choline(vitamins_choline);
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
    getColumnModel().getColumn(0).setMinWidth(0);
    getColumnModel().getColumn(0).setMaxWidth(0);
    getColumnModel().getColumn(1).setMinWidth(0);
    getColumnModel().getColumn(1).setMaxWidth(0);
    getColumnModel().getColumn(2).setMinWidth(300);
    for (int i = 3; i < 17; i++) {
      getColumnModel().getColumn(i).setMinWidth(70);
    }
  }

  public int find(String foodid) {
    int index = 0;
    int r = this.getRowCount();
    for (int j = 0; j < r; j++) {
      if (foodid.equals(getValueAt(j, 1))) {
        index = j;
      }
    }
    return index;
  }

  public void roundUp() {
    roundQuantity(new RoundUpRenderer());
  }

  public void roundDown() {
    roundQuantity(new RoundDownRenderer());
  }

  private void roundQuantity(DefaultTableCellRenderer renderer) {
    getColumnModel().getColumn(3).setCellRenderer(renderer);
    getColumnModel().getColumn(4).setCellRenderer(renderer);
    getColumnModel().getColumn(5).setCellRenderer(renderer);
    getColumnModel().getColumn(6).setCellRenderer(renderer);
    getColumnModel().getColumn(7).setCellRenderer(renderer);
    getColumnModel().getColumn(8).setCellRenderer(renderer);
    getColumnModel().getColumn(9).setCellRenderer(renderer);
    getColumnModel().getColumn(10).setCellRenderer(renderer);
    getColumnModel().getColumn(11).setCellRenderer(renderer);
    getColumnModel().getColumn(12).setCellRenderer(renderer);
    getColumnModel().getColumn(13).setCellRenderer(renderer);
    getColumnModel().getColumn(14).setCellRenderer(renderer);
    getColumnModel().getColumn(15).setCellRenderer(renderer);
    getColumnModel().getColumn(16).setCellRenderer(renderer);
    revalidate();
    repaint();
  }

  public class Row {

    private String mixid;
    private String foodid;
    private String foodname;
    private BigDecimal other_weight;
    private BigDecimal vitamins_vitamin_a;
    private BigDecimal vitamins_vitamin_d;
    private BigDecimal vitamins_vitamin_e;
    private BigDecimal vitamins_vitamin_c;
    private BigDecimal vitamins_thiamin;
    private BigDecimal vitamins_riboflavin;
    private BigDecimal vitamins_niacin;
    private BigDecimal vitamins_vitamin_b6;
    private BigDecimal vitamins_folate;
    private BigDecimal vitamins_vitamin_b12;
    private BigDecimal vitamins_vitamin_k;
    private BigDecimal vitamins_pantothenic_acid;
    private BigDecimal vitamins_choline;

    public Row() {
      mixid = "";
      foodid = "";
      foodname = "";
      other_weight = new BigDecimal("0.0");
      vitamins_vitamin_a = new BigDecimal("0.0");
      vitamins_vitamin_d = new BigDecimal("0.0");
      vitamins_vitamin_e = new BigDecimal("0.0");
      vitamins_vitamin_c = new BigDecimal("0.0");
      vitamins_thiamin = new BigDecimal("0.0");
      vitamins_riboflavin = new BigDecimal("0.0");
      vitamins_niacin = new BigDecimal("0.0");
      vitamins_vitamin_b6 = new BigDecimal("0.0");
      vitamins_folate = new BigDecimal("0.0");
      vitamins_vitamin_b12 = new BigDecimal("0.0");
      vitamins_vitamin_k = new BigDecimal("0.0");
      vitamins_pantothenic_acid = new BigDecimal("0.0");
      vitamins_choline = new BigDecimal("0.0");
    }

    public String getMixid() {
      return mixid;
    }

    public void setMixid(String mixid) {
      this.mixid = mixid;
    }

    public String getFoodid() {
      return foodid;
    }

    public void setFoodid(String foodid) {
      this.foodid = foodid;
    }

    public String getFoodname() {
      return foodname;
    }

    public void setFoodname(String foodname) {
      this.foodname = foodname;
    }

    public BigDecimal getOther_weight() {
      return other_weight;
    }

    public void setOther_weight(BigDecimal other_weight) {
      this.other_weight = other_weight;
    }

    public BigDecimal getVitamins_vitamin_a() {
      return vitamins_vitamin_a;
    }

    public void setVitamins_vitamin_a(BigDecimal vitamins_vitamin_a) {
      this.vitamins_vitamin_a = vitamins_vitamin_a;
    }

    public BigDecimal getVitamins_vitamin_d() {
      return vitamins_vitamin_d;
    }

    public void setVitamins_vitamin_d(BigDecimal vitamins_vitamin_d) {
      this.vitamins_vitamin_d = vitamins_vitamin_d;
    }

    public BigDecimal getVitamins_vitamin_e() {
      return vitamins_vitamin_e;
    }

    public void setVitamins_vitamin_e(BigDecimal vitamins_vitamin_e) {
      this.vitamins_vitamin_e = vitamins_vitamin_e;
    }

    public BigDecimal getVitamins_vitamin_c() {
      return vitamins_vitamin_c;
    }

    public void setVitamins_vitamin_c(BigDecimal vitamins_vitamin_c) {
      this.vitamins_vitamin_c = vitamins_vitamin_c;
    }

    public BigDecimal getVitamins_thiamin() {
      return vitamins_thiamin;
    }

    public void setVitamins_thiamin(BigDecimal vitamins_thiamin) {
      this.vitamins_thiamin = vitamins_thiamin;
    }

    public BigDecimal getVitamins_riboflavin() {
      return vitamins_riboflavin;
    }

    public void setVitamins_riboflavin(BigDecimal vitamins_riboflavin) {
      this.vitamins_riboflavin = vitamins_riboflavin;
    }

    public BigDecimal getVitamins_niacin() {
      return vitamins_niacin;
    }

    public void setVitamins_niacin(BigDecimal vitamins_niacin) {
      this.vitamins_niacin = vitamins_niacin;
    }

    public BigDecimal getVitamins_vitamin_b6() {
      return vitamins_vitamin_b6;
    }

    public void setVitamins_vitamin_b6(BigDecimal vitamins_vitamin_b6) {
      this.vitamins_vitamin_b6 = vitamins_vitamin_b6;
    }

    public BigDecimal getVitamins_folate() {
      return vitamins_folate;
    }

    public void setVitamins_folate(BigDecimal vitamins_folate) {
      this.vitamins_folate = vitamins_folate;
    }

    public BigDecimal getVitamins_vitamin_b12() {
      return vitamins_vitamin_b12;
    }

    public void setVitamins_vitamin_b12(BigDecimal vitamins_vitamin_b12) {
      this.vitamins_vitamin_b12 = vitamins_vitamin_b12;
    }

    public BigDecimal getVitamins_vitamin_k() {
      return vitamins_vitamin_k;
    }

    public void setVitamins_vitamin_k(BigDecimal vitamins_vitamin_k) {
      this.vitamins_vitamin_k = vitamins_vitamin_k;
    }

    public BigDecimal getVitamins_pantothenic_acid() {
      return vitamins_pantothenic_acid;
    }

    public void setVitamins_pantothenic_acid(BigDecimal vitamins_pantothenic_acid) {
      this.vitamins_pantothenic_acid = vitamins_pantothenic_acid;
    }

    public BigDecimal getVitamins_choline() {
      return vitamins_choline;
    }

    public void setVitamins_choline(BigDecimal vitamins_choline) {
      this.vitamins_choline = vitamins_choline;
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
        case 0, 1, 2 -> {
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

  protected String[] columnToolTips =
      new String[] {
        "Mix Id",
        "Food Id",
        "Food Name",
        "Weight (g)",
        "Vitamin A (mcg)",
        "Vitamin D (mcg)",
        "Alpha-Tocopherol, Vitamin E (mg)",
        "Ascorbic Acid, Vitamin C (mg)",
        "Thiamin, Vitamin B1 (mg)",
        "Riboflavin, Vitamin B2 (mg)",
        "Niacin, Vitamin B3 (mg)",
        "Vitamin B6 (mg)",
        "Folate, Vitamin B9 (mcg)",
        "Vitamin B12 (mcg)",
        "Vitamin K (mcg)",
        "Pantothenic Acid, Vitamin B5 (mg)",
        "Choline, Vitamin B4 (mg)"
      };
}
