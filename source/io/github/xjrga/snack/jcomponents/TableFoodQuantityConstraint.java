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
public class TableFoodQuantityConstraint extends JTable {

  private TableRowSorter sorter;
  private JTextField searchField;
  private DataModel dm;

  public TableFoodQuantityConstraint() {
    searchField = new JTextField();
    dm = new DataModel();
    dm.addColumn("MixId");
    dm.addColumn("FoodId");
    dm.addColumn("NutrientId");
    dm.addColumn("RelationshipId");
    dm.addColumn("Food");
    dm.addColumn("Nutrient");
    dm.addColumn("Eq");
    dm.addColumn("Q");
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
                      new ArrayList<RowFilter<Object, Object>>(2);
                  filters.add(RowFilter.regexFilter("(?i)" + searchField.getText(), 4));
                  filters.add(RowFilter.regexFilter("(?i)" + searchField.getText(), 5));
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
    String foodid = (String) getValueAt(selectedRowNo, 1);
    String nutrientid = (String) getValueAt(selectedRowNo, 2);
    Integer relationshipid = (Integer) getValueAt(selectedRowNo, 3);
    String food = (String) getValueAt(selectedRowNo, 4);
    String nutrient = (String) getValueAt(selectedRowNo, 5);
    String relationship = (String) getValueAt(selectedRowNo, 6);
    BigDecimal b = (BigDecimal) getValueAt(selectedRowNo, 7);
    Row row = new Row();
    row.setMixid(mixid);
    row.setFoodid(foodid);
    row.setNutrientid(nutrientid);
    row.setRelationshipid(relationshipid);
    row.setFood(food);
    row.setNutrient(nutrient);
    row.setRelationship(relationship);
    row.setB(b);
    return row;
  }

  public JTextField getSearchField() {
    return searchField;
  }

  public void reload(List<List> data) {
    dm.reload(data);
    adjustColumnWidth();
  }

  public void clear() {
    dm.clear();
  }

  private void adjustColumnWidth() {
    for (int i = 0; i < 4; i++) {
      getColumnModel().getColumn(i).setMinWidth(0);
      getColumnModel().getColumn(i).setMaxWidth(0);
    }
    getColumnModel().getColumn(4).setMinWidth(550);
    getColumnModel().getColumn(4).setMaxWidth(550);
    getColumnModel().getColumn(5).setMinWidth(350);
    getColumnModel().getColumn(5).setMaxWidth(350);
    getColumnModel().getColumn(6).setMinWidth(21);
    getColumnModel().getColumn(6).setMaxWidth(21);
    getColumnModel().getColumn(7).setMinWidth(90);
    getColumnModel().getColumn(7).setMaxWidth(90);
  }

  public void roundUp() {
    roundQuantity(new RoundUpRenderer());
  }

  public void roundDown() {
    roundQuantity(new RoundDownRenderer());
  }

  private void roundQuantity(DefaultTableCellRenderer renderer) {
    getColumnModel().getColumn(7).setCellRenderer(renderer);
    revalidate();
    repaint();
  }

  public class Row {

    private String mixid;
    private String foodid;
    private String nutrientid;
    private Integer relationshipid;
    private String food;
    private String nutrient;
    private String relationship;
    private BigDecimal b;

    public Row() {
      mixid = null;
      foodid = null;
      nutrientid = null;
      relationshipid = null;
      food = null;
      nutrient = null;
      relationship = null;
      b = null;
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

    public String getNutrientid() {
      return nutrientid;
    }

    public void setNutrientid(String nutrientid) {
      this.nutrientid = nutrientid;
    }

    public Integer getRelationshipid() {
      return relationshipid;
    }

    public void setRelationshipid(Integer relationshipid) {
      this.relationshipid = relationshipid;
    }

    public String getFood() {
      return food;
    }

    public void setFood(String food) {
      this.food = food;
    }

    public String getNutrient() {
      return nutrient;
    }

    public void setNutrient(String nutrient) {
      this.nutrient = nutrient;
    }

    public String getRelationship() {
      return relationship;
    }

    public void setRelationship(String relationship) {
      this.relationship = relationship;
    }

    public BigDecimal getB() {
      return b;
    }

    public void setB(BigDecimal b) {
      this.b = b;
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
      Class columnClass = String.class;
      switch (c) {
        case 3 -> {
          columnClass = Integer.class;
        }
        case 7 -> {
          columnClass = BigDecimal.class;
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
      fireTableRowsInserted(r, c);
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
        "MixId", "FoodId", "NutrientId", "RelationshipId", "Food", "Nutrient", "Relationship", "Q"
      };
}
