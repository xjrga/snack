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
import javax.swing.DefaultListSelectionModel;
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
public class TablePortion extends JTable {

  private TableRowSorter sorter;
  private JTextField searchField;
  private DataModel dm;

  public TablePortion() {
    searchField = new JTextField();
    dm = new DataModel();
    dm.addColumn("MixId");
    dm.addColumn("MealId");
    dm.addColumn("FoodId");
    dm.addColumn("Meal");
    dm.addColumn("Food");
    dm.addColumn("Pct");
    dm.addColumn("Expected");
    dm.addColumn("Actual");
    setModel(dm);
    ListSelectionModel selectionModel = new DefaultListSelectionModel();
    setSelectionMode(selectionModel.MULTIPLE_INTERVAL_SELECTION);
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
                      new ArrayList<RowFilter<Object, Object>>(2);
                  filters.add(RowFilter.regexFilter("(?i)" + searchField.getText(), 3));
                  filters.add(RowFilter.regexFilter("(?i)" + searchField.getText(), 4));
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
    if (rows.length == 0) {
      return true;
    } else {
      return false;
    }
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
    String mixid = (String) getValueAt(selectedRowNo, 0);
    Integer mealid = (Integer) getValueAt(selectedRowNo, 1);
    String foodid = (String) getValueAt(selectedRowNo, 2);
    String meal = (String) getValueAt(selectedRowNo, 3);
    String food = (String) getValueAt(selectedRowNo, 4);
    BigDecimal pct = (BigDecimal) getValueAt(selectedRowNo, 5);
    BigDecimal actual = (BigDecimal) getValueAt(selectedRowNo, 6);
    BigDecimal expected = (BigDecimal) getValueAt(selectedRowNo, 7);
    Row row = new Row();
    row.setMixid(mixid);
    row.setMealid(mealid);
    row.setFoodid(foodid);
    row.setMeal(meal);
    row.setFood(food);
    row.setPct(pct);
    row.setActual(actual);
    row.setExpected(expected);
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
    getColumnModel().getColumn(2).setMinWidth(0);
    getColumnModel().getColumn(2).setMaxWidth(0);
    getColumnModel().getColumn(3).setMinWidth(200);
    getColumnModel().getColumn(4).setMinWidth(600);
  }

  public int find(String id) {
    int index = 0;
    int r = this.getRowCount();
    for (int j = 0; j < r; j++) {
      if (id.equals(getValueAt(j, 1))) {
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
    getColumnModel().getColumn(5).setCellRenderer(renderer);
    getColumnModel().getColumn(6).setCellRenderer(renderer);
    getColumnModel().getColumn(7).setCellRenderer(renderer);
    revalidate();
    repaint();
  }

  public class Row {

    private String mixid;
    private Integer mealid;
    private String foodid;
    private String meal;
    private String food;
    private BigDecimal pct;
    private BigDecimal actual;
    private BigDecimal expected;

    public Row() {
      mixid = "";
      mealid = -1;
      foodid = "";
      meal = "";
      food = "";
      pct = new BigDecimal("0.0");
      actual = new BigDecimal("0.0");
      expected = new BigDecimal("0.0");
    }

    public String getMixid() {
      return mixid;
    }

    public void setMixid(String mixid) {
      this.mixid = mixid;
    }

    public Integer getMealid() {
      return mealid;
    }

    public void setMealid(Integer mealid) {
      this.mealid = mealid;
    }

    public String getFoodid() {
      return foodid;
    }

    public void setFoodid(String foodid) {
      this.foodid = foodid;
    }

    public String getMeal() {
      return meal;
    }

    public void setMeal(String meal) {
      this.meal = meal;
    }

    public String getFood() {
      return food;
    }

    public void setFood(String food) {
      this.food = food;
    }

    public BigDecimal getPct() {
      return pct;
    }

    public void setPct(BigDecimal pct) {
      this.pct = pct;
    }

    public BigDecimal getActual() {
      return actual;
    }

    public void setActual(BigDecimal actual) {
      this.actual = actual;
    }

    public BigDecimal getExpected() {
      return expected;
    }

    public void setExpected(BigDecimal expected) {
      this.expected = expected;
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("Row{");
      sb.append("mixid=").append(mixid);
      sb.append(", mealid=").append(mealid);
      sb.append(", foodid=").append(foodid);
      sb.append(", meal=").append(meal);
      sb.append(", food=").append(food);
      sb.append(", pct=").append(pct);
      sb.append(", actual=").append(actual);
      sb.append(", expected=").append(expected);
      sb.append('}');
      return sb.toString();
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
        case 0, 2, 3, 4 -> {
          columnClass = String.class;
        }
        case 1 -> {
          columnClass = Integer.class;
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

    public boolean isSelectionEmpty() {
      int selectedRowNo = getSelectedRow();
      if (selectedRowNo == -1) {
        return true;
      } else {
        return false;
      }
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
      new String[] {"MixId", "MealId", "FoodId", "Meal", "Food", "Pct", "Expected", "Actual"};
}
