package io.github.xjrga.snack.jcomponents;

import io.github.xjrga.snack.logger.LoggerImpl;
import io.github.xjrga.snack.other.Reload;
import io.github.xjrga.snack.renderers.RoundDownRenderer;
import io.github.xjrga.snack.renderers.RoundDownRendererGT;
import io.github.xjrga.snack.renderers.RoundDownRendererLT;
import io.github.xjrga.snack.renderers.RoundUpRenderer;
import io.github.xjrga.snack.renderers.RoundUpRendererGT;
import io.github.xjrga.snack.renderers.RoundUpRendererLT;
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
import javax.swing.table.JTableHeader;
import javax.swing.table.TableRowSorter;

/**
 * @author jr
 */
public class TableDri extends JTable {

  private TableRowSorter sorter;
  private JTextField searchField;
  private DataModel dm;

  public TableDri() {
    searchField = new JTextField();
    dm = new DataModel();
    dm.addColumn("NutrientId");
    dm.addColumn("Nutrient");
    dm.addColumn("Mix");
    dm.addColumn("DRI");
    dm.addColumn("%DRI");
    dm.addColumn("UL");
    dm.addColumn("%UL");
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
    String nutrientid = (String) getValueAt(selectedRowNo, 0);
    String nutrient = (String) getValueAt(selectedRowNo, 1);
    BigDecimal mix = (BigDecimal) getValueAt(selectedRowNo, 2);
    BigDecimal dri = (BigDecimal) getValueAt(selectedRowNo, 3);
    BigDecimal pctdri = (BigDecimal) getValueAt(selectedRowNo, 4);
    BigDecimal ul = (BigDecimal) getValueAt(selectedRowNo, 5);
    BigDecimal pctul = (BigDecimal) getValueAt(selectedRowNo, 6);
    Row row = new Row();
    row.setNutrientid(nutrientid);
    row.setNutrient(nutrient);
    row.setMix(mix);
    row.setDri(dri);
    row.setPctdri(pctdri);
    row.setUl(ul);
    row.setPctul(pctul);
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
    getColumnModel().getColumn(1).setMinWidth(310);
    for (int i = 2; i < 7; i++) {
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
    RoundUpRenderer renderer = new RoundUpRenderer();
    getColumnModel().getColumn(2).setCellRenderer(renderer);
    getColumnModel().getColumn(3).setCellRenderer(renderer);
    getColumnModel().getColumn(4).setCellRenderer(new RoundUpRendererLT());
    getColumnModel().getColumn(5).setCellRenderer(renderer);
    getColumnModel().getColumn(6).setCellRenderer(new RoundUpRendererGT());
    revalidate();
    repaint();
  }

  public void roundDown() {
    RoundDownRenderer renderer = new RoundDownRenderer();
    getColumnModel().getColumn(2).setCellRenderer(renderer);
    getColumnModel().getColumn(3).setCellRenderer(renderer);
    getColumnModel().getColumn(4).setCellRenderer(new RoundDownRendererLT());
    getColumnModel().getColumn(5).setCellRenderer(renderer);
    getColumnModel().getColumn(6).setCellRenderer(new RoundDownRendererGT());
    revalidate();
    repaint();
  }

  public class Row {

    private String nutrientid;
    private String nutrient;
    private BigDecimal mix;
    private BigDecimal dri;
    private BigDecimal pctdri;
    private BigDecimal ul;
    private BigDecimal pctul;

    public Row() {
      nutrientid = "";
      nutrient = "";
      mix = new BigDecimal("0.0");
      dri = new BigDecimal("0.0");
      pctdri = new BigDecimal("0.0");
      ul = new BigDecimal("0.0");
      pctul = new BigDecimal("0.0");
    }

    public String getNutrientid() {
      return nutrientid;
    }

    public void setNutrientid(String nutrientid) {
      this.nutrientid = nutrientid;
    }

    public String getNutrient() {
      return nutrient;
    }

    public void setNutrient(String nutrient) {
      this.nutrient = nutrient;
    }

    public BigDecimal getMix() {
      return mix;
    }

    public void setMix(BigDecimal mix) {
      this.mix = mix;
    }

    public BigDecimal getDri() {
      return dri;
    }

    public void setDri(BigDecimal dri) {
      this.dri = dri;
    }

    public BigDecimal getPctdri() {
      return pctdri;
    }

    public void setPctdri(BigDecimal pctdri) {
      this.pctdri = pctdri;
    }

    public BigDecimal getUl() {
      return ul;
    }

    public void setUl(BigDecimal ul) {
      this.ul = ul;
    }

    public BigDecimal getPctul() {
      return pctul;
    }

    public void setPctul(BigDecimal pctul) {
      this.pctul = pctul;
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
        "NutrientId",
        "Nutrient",
        "Mix",
        "Dietary Reference Intake",
        "Percent Dietary Reference Intake",
        "Tolerable Upper Intake Level",
        "Percent Tolerable Upper Intake Level"
      };
}
