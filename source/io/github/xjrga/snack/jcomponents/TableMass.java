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
public class TableMass extends JTable {

  private TableRowSorter sorter;
  private JTextField searchField;
  private DataModel dm;

  public TableMass() {
    searchField = new JTextField();
    dm = new DataModel();
    dm.addColumn("MixId");
    dm.addColumn("FoodId");
    dm.addColumn("Name");
    dm.addColumn("Weight");
    dm.addColumn("Fat");
    dm.addColumn("Carbs");
    dm.addColumn("Protein");
    dm.addColumn("Alcohol");
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
    BigDecimal fats_total = (BigDecimal) getValueAt(selectedRowNo, 4);
    BigDecimal carbohydrates_digestible = (BigDecimal) getValueAt(selectedRowNo, 5);
    BigDecimal protein_total = (BigDecimal) getValueAt(selectedRowNo, 6);
    BigDecimal other_alcohol = (BigDecimal) getValueAt(selectedRowNo, 7);
    Row row = new Row();
    row.setMixid(mixid);
    row.setFoodid(foodid);
    row.setFoodname(foodname);
    row.setOther_weight(other_weight);
    row.setFats_total(fats_total);
    row.setCarbohydrates_digestible(carbohydrates_digestible);
    row.setProtein_total(protein_total);
    row.setOther_alcohol(other_alcohol);
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
    for (int i = 3; i < 8; i++) {
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
    revalidate();
    repaint();
  }

  public class Row {

    private String mixid;
    private String foodid;
    private String foodname;
    private BigDecimal other_weight;
    private BigDecimal fats_total;
    private BigDecimal carbohydrates_digestible;
    private BigDecimal protein_total;
    private BigDecimal other_alcohol;

    public Row() {}

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

    public BigDecimal getCarbohydrates_digestible() {
      return carbohydrates_digestible;
    }

    public void setCarbohydrates_digestible(BigDecimal carbohydrates_digestible) {
      this.carbohydrates_digestible = carbohydrates_digestible;
    }

    public BigDecimal getFats_total() {
      return fats_total;
    }

    public void setFats_total(BigDecimal fats_total) {
      this.fats_total = fats_total;
    }

    public BigDecimal getProtein_total() {
      return protein_total;
    }

    public void setProtein_total(BigDecimal protein_total) {
      this.protein_total = protein_total;
    }

    public BigDecimal getOther_alcohol() {
      return other_alcohol;
    }

    public void setOther_alcohol(BigDecimal other_alcohol) {
      this.other_alcohol = other_alcohol;
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
        "Fat (g)",
        "Digestible Carbohydrate (g)",
        "Protein (g)",
        "Alcohol (g)"
      };
}
