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
public class TablePhytonutrients extends JTable {

  private TableRowSorter sorter;
  private JTextField searchField;
  private DataModel dm;

  public TablePhytonutrients() {
    searchField = new JTextField();
    dm = new DataModel();
    dm.addColumn("MixId");
    dm.addColumn("FoodId");
    dm.addColumn("Name");
    dm.addColumn("Weight");
    dm.addColumn("Flavonoids");
    dm.addColumn("Anthocyanins");
    dm.addColumn("Carotenoids");
    dm.addColumn("Flavanols");
    dm.addColumn("Flavanones");
    dm.addColumn("Flavones");
    dm.addColumn("Flavonols");
    dm.addColumn("Isoflavones");
    dm.addColumn("Phytosterols");
    dm.addColumn("BetaCarotene");
    dm.addColumn("Lutein+");
    dm.addColumn("Lycopene");
    dm.addColumn("Caffeine");
    dm.addColumn("Theobromine");
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
    BigDecimal phytonutrients_flavonoids = (BigDecimal) getValueAt(selectedRowNo, 4);
    BigDecimal phytonutrients_anthocyanins = (BigDecimal) getValueAt(selectedRowNo, 5);
    BigDecimal phytonutrients_carotenoids = (BigDecimal) getValueAt(selectedRowNo, 6);
    BigDecimal phytonutrients_flavanols = (BigDecimal) getValueAt(selectedRowNo, 7);
    BigDecimal phytonutrients_flavanones = (BigDecimal) getValueAt(selectedRowNo, 8);
    BigDecimal phytonutrients_flavones = (BigDecimal) getValueAt(selectedRowNo, 9);
    BigDecimal phytonutrients_flavonols = (BigDecimal) getValueAt(selectedRowNo, 10);
    BigDecimal phytonutrients_isoflavones = (BigDecimal) getValueAt(selectedRowNo, 11);
    BigDecimal phytonutrients_phytosterols = (BigDecimal) getValueAt(selectedRowNo, 12);
    BigDecimal phytonutrients_beta_carotene = (BigDecimal) getValueAt(selectedRowNo, 13);
    BigDecimal phytonutrients_lutein_zeaxanthin = (BigDecimal) getValueAt(selectedRowNo, 14);
    BigDecimal phytonutrients_lycopene = (BigDecimal) getValueAt(selectedRowNo, 15);
    BigDecimal phytonutrients_caffeine = (BigDecimal) getValueAt(selectedRowNo, 16);
    BigDecimal phytonutrients_theobromine = (BigDecimal) getValueAt(selectedRowNo, 17);
    Row row = new Row();
    row.setMixid(mixid);
    row.setFoodid(foodid);
    row.setFoodname(foodname);
    row.setOther_weight(other_weight);
    row.setPhytonutrients_flavonoids(phytonutrients_flavonoids);
    row.setPhytonutrients_anthocyanins(phytonutrients_anthocyanins);
    row.setPhytonutrients_carotenoids(phytonutrients_carotenoids);
    row.setPhytonutrients_flavanols(phytonutrients_flavanols);
    row.setPhytonutrients_flavanones(phytonutrients_flavanones);
    row.setPhytonutrients_flavones(phytonutrients_flavones);
    row.setPhytonutrients_flavonols(phytonutrients_flavonols);
    row.setPhytonutrients_isoflavones(phytonutrients_isoflavones);
    row.setPhytonutrients_phytosterols(phytonutrients_phytosterols);
    row.setPhytonutrients_beta_carotene(phytonutrients_beta_carotene);
    row.setPhytonutrients_lutein_zeaxanthin(phytonutrients_lutein_zeaxanthin);
    row.setPhytonutrients_lycopene(phytonutrients_lycopene);
    row.setPhytonutrients_caffeine(phytonutrients_caffeine);
    row.setPhytonutrients_theobromine(phytonutrients_theobromine);
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
    for (int i = 3; i < 18; i++) {
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
    getColumnModel().getColumn(17).setCellRenderer(renderer);
    revalidate();
    repaint();
  }

  public class Row {

    private String mixid;
    private String foodid;
    private String foodname;
    private BigDecimal other_weight;
    private BigDecimal phytonutrients_flavonoids;
    private BigDecimal phytonutrients_anthocyanins;
    private BigDecimal phytonutrients_carotenoids;
    private BigDecimal phytonutrients_flavanols;
    private BigDecimal phytonutrients_flavanones;
    private BigDecimal phytonutrients_flavones;
    private BigDecimal phytonutrients_flavonols;
    private BigDecimal phytonutrients_isoflavones;
    private BigDecimal phytonutrients_phytosterols;
    private BigDecimal phytonutrients_beta_carotene;
    private BigDecimal phytonutrients_lutein_zeaxanthin;
    private BigDecimal phytonutrients_lycopene;
    private BigDecimal phytonutrients_caffeine;
    private BigDecimal phytonutrients_theobromine;

    public Row() {
      mixid = "";
      foodid = "";
      foodname = "";
      other_weight = new BigDecimal("0.0");
      phytonutrients_flavonoids = new BigDecimal("0.0");
      phytonutrients_anthocyanins = new BigDecimal("0.0");
      phytonutrients_carotenoids = new BigDecimal("0.0");
      phytonutrients_flavanols = new BigDecimal("0.0");
      phytonutrients_flavanones = new BigDecimal("0.0");
      phytonutrients_flavones = new BigDecimal("0.0");
      phytonutrients_flavonols = new BigDecimal("0.0");
      phytonutrients_isoflavones = new BigDecimal("0.0");
      phytonutrients_phytosterols = new BigDecimal("0.0");
      phytonutrients_beta_carotene = new BigDecimal("0.0");
      phytonutrients_lutein_zeaxanthin = new BigDecimal("0.0");
      phytonutrients_lycopene = new BigDecimal("0.0");
      phytonutrients_caffeine = new BigDecimal("0.0");
      phytonutrients_theobromine = new BigDecimal("0.0");
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

    public BigDecimal getPhytonutrients_flavonoids() {
      return phytonutrients_flavonoids;
    }

    public void setPhytonutrients_flavonoids(BigDecimal phytonutrients_flavonoids) {
      this.phytonutrients_flavonoids = phytonutrients_flavonoids;
    }

    public BigDecimal getPhytonutrients_anthocyanins() {
      return phytonutrients_anthocyanins;
    }

    public void setPhytonutrients_anthocyanins(BigDecimal phytonutrients_anthocyanins) {
      this.phytonutrients_anthocyanins = phytonutrients_anthocyanins;
    }

    public BigDecimal getPhytonutrients_carotenoids() {
      return phytonutrients_carotenoids;
    }

    public void setPhytonutrients_carotenoids(BigDecimal phytonutrients_carotenoids) {
      this.phytonutrients_carotenoids = phytonutrients_carotenoids;
    }

    public BigDecimal getPhytonutrients_flavanols() {
      return phytonutrients_flavanols;
    }

    public void setPhytonutrients_flavanols(BigDecimal phytonutrients_flavanols) {
      this.phytonutrients_flavanols = phytonutrients_flavanols;
    }

    public BigDecimal getPhytonutrients_flavanones() {
      return phytonutrients_flavanones;
    }

    public void setPhytonutrients_flavanones(BigDecimal phytonutrients_flavanones) {
      this.phytonutrients_flavanones = phytonutrients_flavanones;
    }

    public BigDecimal getPhytonutrients_flavones() {
      return phytonutrients_flavones;
    }

    public void setPhytonutrients_flavones(BigDecimal phytonutrients_flavones) {
      this.phytonutrients_flavones = phytonutrients_flavones;
    }

    public BigDecimal getPhytonutrients_flavonols() {
      return phytonutrients_flavonols;
    }

    public void setPhytonutrients_flavonols(BigDecimal phytonutrients_flavonols) {
      this.phytonutrients_flavonols = phytonutrients_flavonols;
    }

    public BigDecimal getPhytonutrients_isoflavones() {
      return phytonutrients_isoflavones;
    }

    public void setPhytonutrients_isoflavones(BigDecimal phytonutrients_isoflavones) {
      this.phytonutrients_isoflavones = phytonutrients_isoflavones;
    }

    public BigDecimal getPhytonutrients_phytosterols() {
      return phytonutrients_phytosterols;
    }

    public void setPhytonutrients_phytosterols(BigDecimal phytonutrients_phytosterols) {
      this.phytonutrients_phytosterols = phytonutrients_phytosterols;
    }

    public BigDecimal getPhytonutrients_beta_carotene() {
      return phytonutrients_beta_carotene;
    }

    public void setPhytonutrients_beta_carotene(BigDecimal phytonutrients_beta_carotene) {
      this.phytonutrients_beta_carotene = phytonutrients_beta_carotene;
    }

    public BigDecimal getPhytonutrients_lutein_zeaxanthin() {
      return phytonutrients_lutein_zeaxanthin;
    }

    public void setPhytonutrients_lutein_zeaxanthin(BigDecimal phytonutrients_lutein_zeaxanthin) {
      this.phytonutrients_lutein_zeaxanthin = phytonutrients_lutein_zeaxanthin;
    }

    public BigDecimal getPhytonutrients_lycopene() {
      return phytonutrients_lycopene;
    }

    public void setPhytonutrients_lycopene(BigDecimal phytonutrients_lycopene) {
      this.phytonutrients_lycopene = phytonutrients_lycopene;
    }

    public BigDecimal getPhytonutrients_caffeine() {
      return phytonutrients_caffeine;
    }

    public void setPhytonutrients_caffeine(BigDecimal phytonutrients_caffeine) {
      this.phytonutrients_caffeine = phytonutrients_caffeine;
    }

    public BigDecimal getPhytonutrients_theobromine() {
      return phytonutrients_theobromine;
    }

    public void setPhytonutrients_theobromine(BigDecimal phytonutrients_theobromine) {
      this.phytonutrients_theobromine = phytonutrients_theobromine;
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
        "Phytonutrients, Flavonoids (mg)",
        "Phytonutrients, Anthocyanins (mg)",
        "Phytonutrients, Carotenoids (mcg)",
        "Phytonutrients, Flavanols (mg)",
        "Phytonutrients, Flavanones (mg)",
        "Phytonutrients, Flavones (mg)",
        "Phytonutrients, Flavonols (mg)",
        "Phytonutrients, Isoflavones (mg)",
        "Phytonutrients, Phytosterols (mg)",
        "Phytonutrients, Carotene, beta (mcg)",
        "Lutein + Zeaxanthin (mcg)",
        "Lycopene (mcg)",
        "Phytonutrients, Caffeine (mg)",
        "Phytonutrients, Theobromine (mg)"
      };
}
