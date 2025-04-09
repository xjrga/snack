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
public class TableEnergy extends JTable {

  private TableRowSorter sorter;
  private JTextField searchField;
  private DataModel dm;

  public TableEnergy() {
    searchField = new JTextField();
    dm = new DataModel();
    dm.addColumn("MixId");
    dm.addColumn("FoodId");
    dm.addColumn("Name");
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
    BigDecimal energy_gross = (BigDecimal) getValueAt(selectedRowNo, 4);
    BigDecimal energy_digestible = (BigDecimal) getValueAt(selectedRowNo, 5);
    BigDecimal energy_fat = (BigDecimal) getValueAt(selectedRowNo, 6);
    BigDecimal energy_carbohydrate = (BigDecimal) getValueAt(selectedRowNo, 7);
    BigDecimal energy_fat_and_carbohydrate = (BigDecimal) getValueAt(selectedRowNo, 8);
    BigDecimal energy_protein = (BigDecimal) getValueAt(selectedRowNo, 9);
    BigDecimal energy_alcohol = (BigDecimal) getValueAt(selectedRowNo, 10);
    Row result = new Row();
    result.setMixid(mixid);
    result.setFoodid(foodid);
    result.setFoodname(foodname);
    result.setOther_weight(other_weight);
    result.setEnergy_gross(energy_gross);
    result.setEnergy_digestible(energy_digestible);
    result.setEnergy_fat(energy_fat);
    result.setEnergy_carbohydrate(energy_carbohydrate);
    result.setEnergy_fat_and_carbohydrate(energy_fat_and_carbohydrate);
    result.setEnergy_protein(energy_protein);
    result.setEnergy_alcohol(energy_alcohol);
    return result;
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
    for (int i = 3; i < 11; i++) {
      getColumnModel().getColumn(i).setMinWidth(90);
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
    revalidate();
    repaint();
  }

  public class Row {

    private String mixid;
    private String foodid;
    private String foodname;
    private BigDecimal other_weight;
    private BigDecimal energy_gross;
    private BigDecimal energy_digestible;
    private BigDecimal energy_fat;
    private BigDecimal energy_carbohydrate;
    private BigDecimal energy_fat_and_carbohydrate;
    private BigDecimal energy_protein;
    private BigDecimal energy_alcohol;

    public Row() {
      mixid = "";
      foodid = "";
      foodname = "";
      other_weight = new BigDecimal("0.0");
      energy_gross = new BigDecimal("0.0");
      energy_digestible = new BigDecimal("0.0");
      energy_fat = new BigDecimal("0.0");
      energy_carbohydrate = new BigDecimal("0.0");
      energy_fat_and_carbohydrate = new BigDecimal("0.0");
      energy_protein = new BigDecimal("0.0");
      energy_alcohol = new BigDecimal("0.0");
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

    public BigDecimal getEnergy_gross() {
      return energy_gross;
    }

    public void setEnergy_gross(BigDecimal energy_gross) {
      this.energy_gross = energy_gross;
    }

    public BigDecimal getEnergy_digestible() {
      return energy_digestible;
    }

    public void setEnergy_digestible(BigDecimal energy_digestible) {
      this.energy_digestible = energy_digestible;
    }

    public BigDecimal getEnergy_fat() {
      return energy_fat;
    }

    public void setEnergy_fat(BigDecimal energy_fat) {
      this.energy_fat = energy_fat;
    }

    public BigDecimal getEnergy_carbohydrate() {
      return energy_carbohydrate;
    }

    public void setEnergy_carbohydrate(BigDecimal energy_carbohydrate) {
      this.energy_carbohydrate = energy_carbohydrate;
    }

    public BigDecimal getEnergy_fat_and_carbohydrate() {
      return energy_fat_and_carbohydrate;
    }

    public void setEnergy_fat_and_carbohydrate(BigDecimal energy_fat_and_carbohydrate) {
      this.energy_fat_and_carbohydrate = energy_fat_and_carbohydrate;
    }

    public BigDecimal getEnergy_protein() {
      return energy_protein;
    }

    public void setEnergy_protein(BigDecimal energy_protein) {
      this.energy_protein = energy_protein;
    }

    public BigDecimal getEnergy_alcohol() {
      return energy_alcohol;
    }

    public void setEnergy_alcohol(BigDecimal energy_alcohol) {
      this.energy_alcohol = energy_alcohol;
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
        "Energy Gross (Kcal)",
        "Energy Digestible (Kcal)",
        "Energy Fat (Kcal)",
        "Energy Carbohydrate (Kcal)",
        "Energy Fat and Carbohydrate (Kcal)",
        "Energy Protein (Kcal)",
        "Energy Alcohol (Kcal)"
      };
}
