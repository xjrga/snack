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
public class TablePufa extends JTable {

  private TableRowSorter sorter;
  private JTextField searchField;
  private DataModel dm;

  public TablePufa() {
    searchField = new JTextField();
    dm = new DataModel();
    dm.addColumn("MixId");
    dm.addColumn("FoodId");
    dm.addColumn("Name");
    dm.addColumn("Weight");
    dm.addColumn("PUFA");
    dm.addColumn("LA");
    dm.addColumn("ALA");
    dm.addColumn("EPA");
    dm.addColumn("DHA");
    dm.addColumn("LCN3PUFA");
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
    BigDecimal fats_polyunsaturated = (BigDecimal) getValueAt(selectedRowNo, 4);
    BigDecimal fats_linoleic = (BigDecimal) getValueAt(selectedRowNo, 5);
    BigDecimal fats_linolenic = (BigDecimal) getValueAt(selectedRowNo, 6);
    BigDecimal fats_epa = (BigDecimal) getValueAt(selectedRowNo, 7);
    BigDecimal fats_dha = (BigDecimal) getValueAt(selectedRowNo, 8);
    BigDecimal fats_lcn3pufa = (BigDecimal) getValueAt(selectedRowNo, 9);
    Row row = new Row();
    row.setMixid(mixid);
    row.setFoodid(foodid);
    row.setFoodname(foodname);
    row.setOther_weight(other_weight);
    row.setFats_polyunsaturated(fats_polyunsaturated);
    row.setFats_linoleic(fats_linoleic);
    row.setFats_linolenic(fats_linolenic);
    row.setFats_epa(fats_epa);
    row.setFats_dha(fats_dha);
    row.setFats_lcn3pufa(fats_lcn3pufa);
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
    for (int i = 3; i < 10; i++) {
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
    revalidate();
    repaint();
  }

  public class Row {

    private String mixid;
    private String foodid;
    private String foodname;
    private BigDecimal other_weight;
    private BigDecimal fats_polyunsaturated;
    private BigDecimal fats_linoleic;
    private BigDecimal fats_linolenic;
    private BigDecimal fats_epa;
    private BigDecimal fats_dha;
    private BigDecimal fats_lcn3pufa;

    public Row() {
      mixid = "";
      foodid = "";
      foodname = "";
      other_weight = new BigDecimal("0.0");
      fats_polyunsaturated = new BigDecimal("0.0");
      fats_linoleic = new BigDecimal("0.0");
      fats_linolenic = new BigDecimal("0.0");
      fats_epa = new BigDecimal("0.0");
      fats_dha = new BigDecimal("0.0");
      fats_lcn3pufa = new BigDecimal("0.0");
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

    public BigDecimal getFats_polyunsaturated() {
      return fats_polyunsaturated;
    }

    public void setFats_polyunsaturated(BigDecimal fats_polyunsaturated) {
      this.fats_polyunsaturated = fats_polyunsaturated;
    }

    public BigDecimal getFats_linoleic() {
      return fats_linoleic;
    }

    public void setFats_linoleic(BigDecimal fats_linoleic) {
      this.fats_linoleic = fats_linoleic;
    }

    public BigDecimal getFats_linolenic() {
      return fats_linolenic;
    }

    public void setFats_linolenic(BigDecimal fats_linolenic) {
      this.fats_linolenic = fats_linolenic;
    }

    public BigDecimal getFats_epa() {
      return fats_epa;
    }

    public void setFats_epa(BigDecimal fats_epa) {
      this.fats_epa = fats_epa;
    }

    public BigDecimal getFats_dha() {
      return fats_dha;
    }

    public void setFats_dha(BigDecimal fats_dha) {
      this.fats_dha = fats_dha;
    }

    public BigDecimal getFats_lcn3pufa() {
      return fats_lcn3pufa;
    }

    public void setFats_lcn3pufa(BigDecimal fats_lcn3pufa) {
      this.fats_lcn3pufa = fats_lcn3pufa;
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
        "Polyunsaturated Fat (g)",
        "Linoleic Acid, 18:2n-6 (g). It is an essential fat.",
        "Alpha-Linolenic Acid, 18:3n−3 (g) It is an essential fat.",
        "Eicosapentaenoic Acid, 20:5n−3 (g)",
        "Docosahexaenoic Acid,  22:6n−3 (g)",
        "Long Chain n-3 PUFA (g)"
      };
}
