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
public class TableCarbs extends JTable {

  private TableRowSorter sorter;
  private JTextField searchField;
  private DataModel dm;

  public TableCarbs() {
    searchField = new JTextField();
    dm = new DataModel();
    dm.addColumn("MixId");
    dm.addColumn("FoodId");
    dm.addColumn("Name");
    dm.addColumn("Weight");
    dm.addColumn("eCarbs");
    dm.addColumn("CarbsByDiff");
    dm.addColumn("Fiber");
    dm.addColumn("FiberIns");
    dm.addColumn("FiberSol");
    dm.addColumn("Carbs");
    dm.addColumn("Starch");
    dm.addColumn("Sugars");
    dm.addColumn("Sucrose");
    dm.addColumn("Lactose");
    dm.addColumn("Fructose");
    dm.addColumn("Glucose");
    dm.addColumn("GL");
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
    BigDecimal energy_carbohydrate = (BigDecimal) getValueAt(selectedRowNo, 4);
    BigDecimal carbohydrates_carbs_by_diff = (BigDecimal) getValueAt(selectedRowNo, 5);
    BigDecimal carbohydrates_fiber = (BigDecimal) getValueAt(selectedRowNo, 6);
    BigDecimal carbohydrates_fiber_insoluble = (BigDecimal) getValueAt(selectedRowNo, 7);
    BigDecimal carbohydrates_fiber_soluble = (BigDecimal) getValueAt(selectedRowNo, 8);
    BigDecimal carbohydrates_digestible = (BigDecimal) getValueAt(selectedRowNo, 9);
    BigDecimal carbohydrates_starch = (BigDecimal) getValueAt(selectedRowNo, 10);
    BigDecimal carbohydrates_sugars = (BigDecimal) getValueAt(selectedRowNo, 11);
    BigDecimal carbohydrates_sucrose = (BigDecimal) getValueAt(selectedRowNo, 12);
    BigDecimal carbohydrates_lactose = (BigDecimal) getValueAt(selectedRowNo, 13);
    BigDecimal carbohydrates_fructose = (BigDecimal) getValueAt(selectedRowNo, 14);
    BigDecimal carbohydrates_glucose = (BigDecimal) getValueAt(selectedRowNo, 15);
    BigDecimal carbohydrates_glycemic_load = (BigDecimal) getValueAt(selectedRowNo, 16);
    Row result = new Row();
    result.setMixid(mixid);
    result.setFoodid(foodid);
    result.setFoodname(foodname);
    result.setOther_weight(other_weight);
    result.setEnergy_carbohydrate(energy_carbohydrate);
    result.setCarbohydrates_carbs_by_diff(carbohydrates_carbs_by_diff);
    result.setCarbohydrates_fiber(carbohydrates_fiber);
    result.setCarbohydrates_fiber_insoluble(carbohydrates_fiber_insoluble);
    result.setCarbohydrates_fiber_soluble(carbohydrates_fiber_soluble);
    result.setCarbohydrates_digestible(carbohydrates_digestible);
    result.setCarbohydrates_starch(carbohydrates_starch);
    result.setCarbohydrates_sugars(carbohydrates_sugars);
    result.setCarbohydrates_sucrose(carbohydrates_sucrose);
    result.setCarbohydrates_lactose(carbohydrates_lactose);
    result.setCarbohydrates_fructose(carbohydrates_fructose);
    result.setCarbohydrates_glucose(carbohydrates_glucose);
    result.setCarbohydrates_glycemic_load(carbohydrates_glycemic_load);
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
    private BigDecimal energy_carbohydrate;
    private BigDecimal carbohydrates_carbs_by_diff;
    private BigDecimal carbohydrates_fiber;
    private BigDecimal carbohydrates_fiber_insoluble;
    private BigDecimal carbohydrates_fiber_soluble;
    private BigDecimal carbohydrates_digestible;
    private BigDecimal carbohydrates_starch;
    private BigDecimal carbohydrates_sugars;
    private BigDecimal carbohydrates_sucrose;
    private BigDecimal carbohydrates_lactose;
    private BigDecimal carbohydrates_fructose;
    private BigDecimal carbohydrates_glucose;
    private BigDecimal carbohydrates_glycemic_load;

    public Row() {
      mixid = "";
      foodid = "";
      foodname = "";
      other_weight = new BigDecimal("0.0");
      energy_carbohydrate = new BigDecimal("0.0");
      carbohydrates_carbs_by_diff = new BigDecimal("0.0");
      carbohydrates_fiber = new BigDecimal("0.0");
      carbohydrates_fiber_insoluble = new BigDecimal("0.0");
      carbohydrates_fiber_soluble = new BigDecimal("0.0");
      carbohydrates_digestible = new BigDecimal("0.0");
      carbohydrates_starch = new BigDecimal("0.0");
      carbohydrates_sugars = new BigDecimal("0.0");
      carbohydrates_sucrose = new BigDecimal("0.0");
      carbohydrates_lactose = new BigDecimal("0.0");
      carbohydrates_fructose = new BigDecimal("0.0");
      carbohydrates_glucose = new BigDecimal("0.0");
      carbohydrates_glycemic_load = new BigDecimal("0.0");
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

    public BigDecimal getEnergy_carbohydrate() {
      return energy_carbohydrate;
    }

    public void setEnergy_carbohydrate(BigDecimal energy_carbohydrate) {
      this.energy_carbohydrate = energy_carbohydrate;
    }

    public BigDecimal getCarbohydrates_carbs_by_diff() {
      return carbohydrates_carbs_by_diff;
    }

    public void setCarbohydrates_carbs_by_diff(BigDecimal carbohydrates_carbs_by_diff) {
      this.carbohydrates_carbs_by_diff = carbohydrates_carbs_by_diff;
    }

    public BigDecimal getCarbohydrates_fiber() {
      return carbohydrates_fiber;
    }

    public void setCarbohydrates_fiber(BigDecimal carbohydrates_fiber) {
      this.carbohydrates_fiber = carbohydrates_fiber;
    }

    public BigDecimal getCarbohydrates_fiber_insoluble() {
      return carbohydrates_fiber_insoluble;
    }

    public void setCarbohydrates_fiber_insoluble(BigDecimal carbohydrates_fiber_insoluble) {
      this.carbohydrates_fiber_insoluble = carbohydrates_fiber_insoluble;
    }

    public BigDecimal getCarbohydrates_fiber_soluble() {
      return carbohydrates_fiber_soluble;
    }

    public void setCarbohydrates_fiber_soluble(BigDecimal carbohydrates_fiber_soluble) {
      this.carbohydrates_fiber_soluble = carbohydrates_fiber_soluble;
    }

    public BigDecimal getCarbohydrates_digestible() {
      return carbohydrates_digestible;
    }

    public void setCarbohydrates_digestible(BigDecimal carbohydrates_digestible) {
      this.carbohydrates_digestible = carbohydrates_digestible;
    }

    public BigDecimal getCarbohydrates_starch() {
      return carbohydrates_starch;
    }

    public void setCarbohydrates_starch(BigDecimal carbohydrates_starch) {
      this.carbohydrates_starch = carbohydrates_starch;
    }

    public BigDecimal getCarbohydrates_sugars() {
      return carbohydrates_sugars;
    }

    public void setCarbohydrates_sugars(BigDecimal carbohydrates_sugars) {
      this.carbohydrates_sugars = carbohydrates_sugars;
    }

    public BigDecimal getCarbohydrates_sucrose() {
      return carbohydrates_sucrose;
    }

    public void setCarbohydrates_sucrose(BigDecimal carbohydrates_sucrose) {
      this.carbohydrates_sucrose = carbohydrates_sucrose;
    }

    public BigDecimal getCarbohydrates_lactose() {
      return carbohydrates_lactose;
    }

    public void setCarbohydrates_lactose(BigDecimal carbohydrates_lactose) {
      this.carbohydrates_lactose = carbohydrates_lactose;
    }

    public BigDecimal getCarbohydrates_fructose() {
      return carbohydrates_fructose;
    }

    public void setCarbohydrates_fructose(BigDecimal carbohydrates_fructose) {
      this.carbohydrates_fructose = carbohydrates_fructose;
    }

    public BigDecimal getCarbohydrates_glucose() {
      return carbohydrates_glucose;
    }

    public void setCarbohydrates_glucose(BigDecimal carbohydrates_glucose) {
      this.carbohydrates_glucose = carbohydrates_glucose;
    }

    public BigDecimal getCarbohydrates_glycemic_load() {
      return carbohydrates_glycemic_load;
    }

    public void setCarbohydrates_glycemic_load(BigDecimal carbohydrates_glycemic_load) {
      this.carbohydrates_glycemic_load = carbohydrates_glycemic_load;
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
        "Energy Carbohydrate (Kcal)",
        "Carbohydrates By Difference (g)",
        "Fiber (g)",
        "Insoluble Fiber (g)",
        "Soluble Fiber (g)",
        "Digestible Carbohydrates (g)",
        "Starch (g)",
        "Sugars (g)",
        "Sucrose (g)",
        "Lactose (g)",
        "Fructose (g)",
        "Glucose (g)",
        "Glycemic Load (g)"
      };
}
