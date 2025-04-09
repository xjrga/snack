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
public class TableMinerals extends JTable {

  private TableRowSorter sorter;
  private JTextField searchField;
  private DataModel dm;

  public TableMinerals() {
    searchField = new JTextField();
    dm = new DataModel();
    dm.addColumn("MixId");
    dm.addColumn("FoodId");
    dm.addColumn("Food Name");
    dm.addColumn("Weight");
    dm.addColumn("Calcium");
    dm.addColumn("Phosporus");
    dm.addColumn("Magnesium");
    dm.addColumn("Iron");
    dm.addColumn("Zinc");
    dm.addColumn("Copper");
    dm.addColumn("Manganese");
    dm.addColumn("Selenium");
    //
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
                  List<RowFilter<Object, Object>> filters =
                      new ArrayList<RowFilter<Object, Object>>(1);
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
    int selectedRowNo = getSelectedRow();
    if (selectedRowNo == -1) {
      return true;
    } else {
      return false;
    }
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
    BigDecimal minerals_calcium = (BigDecimal) getValueAt(selectedRowNo, 4);
    BigDecimal minerals_phosphorus = (BigDecimal) getValueAt(selectedRowNo, 5);
    BigDecimal minerals_magnesium = (BigDecimal) getValueAt(selectedRowNo, 6);
    BigDecimal minerals_iron = (BigDecimal) getValueAt(selectedRowNo, 7);
    BigDecimal minerals_zinc = (BigDecimal) getValueAt(selectedRowNo, 8);
    BigDecimal minerals_copper = (BigDecimal) getValueAt(selectedRowNo, 9);
    BigDecimal minerals_manganese = (BigDecimal) getValueAt(selectedRowNo, 10);
    BigDecimal minerals_selenium = (BigDecimal) getValueAt(selectedRowNo, 11);
    Row row = new Row();
    row.setMixid(mixid);
    row.setFoodid(foodid);
    row.setFoodname(foodname);
    row.setOther_weight(other_weight);
    row.setMinerals_calcium(minerals_calcium);
    row.setMinerals_phosphorus(minerals_phosphorus);
    row.setMinerals_magnesium(minerals_magnesium);
    row.setMinerals_iron(minerals_iron);
    row.setMinerals_zinc(minerals_zinc);
    row.setMinerals_copper(minerals_copper);
    row.setMinerals_manganese(minerals_manganese);
    row.setMinerals_selenium(minerals_selenium);
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
    for (int i = 3; i < 12; i++) {
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
    revalidate();
    repaint();
  }

  public class Row {

    private String mixid;
    private String foodid;
    private String foodname;
    private BigDecimal other_weight;
    private BigDecimal minerals_calcium;
    private BigDecimal minerals_phosphorus;
    private BigDecimal minerals_magnesium;
    private BigDecimal minerals_iron;
    private BigDecimal minerals_zinc;
    private BigDecimal minerals_copper;
    private BigDecimal minerals_manganese;
    private BigDecimal minerals_selenium;

    public Row() {
      mixid = "";
      foodid = "";
      foodname = "";
      other_weight = new BigDecimal("0.0");
      minerals_calcium = new BigDecimal("0.0");
      minerals_phosphorus = new BigDecimal("0.0");
      minerals_magnesium = new BigDecimal("0.0");
      minerals_iron = new BigDecimal("0.0");
      minerals_zinc = new BigDecimal("0.0");
      minerals_copper = new BigDecimal("0.0");
      minerals_manganese = new BigDecimal("0.0");
      minerals_selenium = new BigDecimal("0.0");
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

    public BigDecimal getMinerals_calcium() {
      return minerals_calcium;
    }

    public void setMinerals_calcium(BigDecimal minerals_calcium) {
      this.minerals_calcium = minerals_calcium;
    }

    public BigDecimal getMinerals_phosphorus() {
      return minerals_phosphorus;
    }

    public void setMinerals_phosphorus(BigDecimal minerals_phosphorus) {
      this.minerals_phosphorus = minerals_phosphorus;
    }

    public BigDecimal getMinerals_magnesium() {
      return minerals_magnesium;
    }

    public void setMinerals_magnesium(BigDecimal minerals_magnesium) {
      this.minerals_magnesium = minerals_magnesium;
    }

    public BigDecimal getMinerals_iron() {
      return minerals_iron;
    }

    public void setMinerals_iron(BigDecimal minerals_iron) {
      this.minerals_iron = minerals_iron;
    }

    public BigDecimal getMinerals_zinc() {
      return minerals_zinc;
    }

    public void setMinerals_zinc(BigDecimal minerals_zinc) {
      this.minerals_zinc = minerals_zinc;
    }

    public BigDecimal getMinerals_copper() {
      return minerals_copper;
    }

    public void setMinerals_copper(BigDecimal minerals_copper) {
      this.minerals_copper = minerals_copper;
    }

    public BigDecimal getMinerals_manganese() {
      return minerals_manganese;
    }

    public void setMinerals_manganese(BigDecimal minerals_manganese) {
      this.minerals_manganese = minerals_manganese;
    }

    public BigDecimal getMinerals_selenium() {
      return minerals_selenium;
    }

    public void setMinerals_selenium(BigDecimal minerals_selenium) {
      this.minerals_selenium = minerals_selenium;
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
        "Calcium, Ca (mg)",
        "Phosphorus, P (mg)",
        "Magnesium, Mg (mg)",
        "Iron, Fe (mg)",
        "Zinc, Zn (mg)",
        "Copper, Cu (mg)",
        "Manganese, Mn (mg)",
        "Selenium, Se (mcg)"
      };
}
