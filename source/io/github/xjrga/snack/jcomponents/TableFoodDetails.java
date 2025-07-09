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
public class TableFoodDetails extends JTable {

  private TableRowSorter sorter;
  private JTextField txtSearch;
  private DataModel dm;

  public TableFoodDetails() {
    txtSearch = new JTextField();
    dm = new DataModel();
    dm.addColumn("Id");
    dm.addColumn("Food");
    dm.addColumn("CarbsByDiff");
    dm.addColumn("FiberIns");
    dm.addColumn("FiberSol");
    dm.addColumn("Fiber");
    dm.addColumn("Fructose");
    dm.addColumn("Glucose");
    dm.addColumn("GL");
    dm.addColumn("Lactose");
    dm.addColumn("Starch");
    dm.addColumn("Sucrose");
    dm.addColumn("Sugars");
    dm.addColumn("eGross");
    dm.addColumn("Cholesterol");
    dm.addColumn("DHA");
    dm.addColumn("EPA");
    dm.addColumn("Lauric");
    dm.addColumn("LA");
    dm.addColumn("ALA");
    dm.addColumn("MUFA");
    dm.addColumn("Myristic");
    dm.addColumn("Palmitic");
    dm.addColumn("PUFA");
    dm.addColumn("SFA");
    dm.addColumn("Stearic");
    dm.addColumn("Fats");
    dm.addColumn("Calcium");
    dm.addColumn("Copper");
    dm.addColumn("Iron");
    dm.addColumn("Magnesium");
    dm.addColumn("Manganese");
    dm.addColumn("Phosphorus");
    dm.addColumn("Potassium");
    dm.addColumn("Selenium");
    dm.addColumn("Sodium");
    dm.addColumn("Zinc");
    dm.addColumn("Alcohol");
    dm.addColumn("Cost");
    dm.addColumn("Water");
    dm.addColumn("Weight");
    dm.addColumn("Anthocyanins");
    dm.addColumn("Caffeine");
    dm.addColumn("BetaCarotene");
    dm.addColumn("Carotenoids");
    dm.addColumn("Flavanols");
    dm.addColumn("Flavanones");
    dm.addColumn("Flavones");
    dm.addColumn("Flavonoids");
    dm.addColumn("Flavonols");
    dm.addColumn("Isoflavones");
    dm.addColumn("Lutein+");
    dm.addColumn("Lycopene");
    dm.addColumn("Phytosterols");
    dm.addColumn("Theobromine");
    dm.addColumn("ProteinComplete");
    dm.addColumn("Protein");
    dm.addColumn("A");
    dm.addColumn("B12");
    dm.addColumn("B6");
    dm.addColumn("C");
    dm.addColumn("Choline");
    dm.addColumn("D");
    dm.addColumn("E");
    dm.addColumn("Folate");
    dm.addColumn("K");
    dm.addColumn("Niacin");
    dm.addColumn("Pantothenic");
    dm.addColumn("Riboflavin");
    dm.addColumn("Thiamin");
    dm.addColumn("Carbs");
    dm.addColumn("eCarbs");
    dm.addColumn("eFat");
    dm.addColumn("eFat+");
    dm.addColumn("eProtein");
    dm.addColumn("eAlcohol");
    dm.addColumn("eDigestible");
    dm.addColumn("HCSFA");
    dm.addColumn("LCN3PUFA");
    setModel(dm);
    setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    setFillsViewportHeight(true);
    setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
    getTableHeader().setReorderingAllowed(false);
    sorter = new TableRowSorter<>(dm);
    setRowSorter(sorter);
    txtSearch
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
                  filters.add(RowFilter.regexFilter("(?i)" + txtSearch.getText(), 1));
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
    ArrayList<Row> row = new ArrayList<Row>();
    if (isSelectionEmpty()) {
      return row;
    }
    int[] rows = this.getSelectedRows();
    for (int i = 0; i < rows.length; i++) {
      Row foodfacts = getRow(i);
      row.add(foodfacts);
    }
    return row;
  }

  private Row getRow(int selectedRowNo) {
    String id = (String) getValueAt(selectedRowNo, 0);
    String name = (String) getValueAt(selectedRowNo, 1);
    BigDecimal carbohydrates_carbs_by_diff = (BigDecimal) getValueAt(selectedRowNo, 2);
    BigDecimal carbohydrates_fiber_insoluble = (BigDecimal) getValueAt(selectedRowNo, 3);
    BigDecimal carbohydrates_fiber_soluble = (BigDecimal) getValueAt(selectedRowNo, 4);
    BigDecimal carbohydrates_fiber = (BigDecimal) getValueAt(selectedRowNo, 5);
    BigDecimal carbohydrates_fructose = (BigDecimal) getValueAt(selectedRowNo, 6);
    BigDecimal carbohydrates_glucose = (BigDecimal) getValueAt(selectedRowNo, 7);
    BigDecimal carbohydrates_glycemic_load = (BigDecimal) getValueAt(selectedRowNo, 8);
    BigDecimal carbohydrates_lactose = (BigDecimal) getValueAt(selectedRowNo, 9);
    BigDecimal carbohydrates_starch = (BigDecimal) getValueAt(selectedRowNo, 10);
    BigDecimal carbohydrates_sucrose = (BigDecimal) getValueAt(selectedRowNo, 11);
    BigDecimal carbohydrates_sugars = (BigDecimal) getValueAt(selectedRowNo, 12);
    BigDecimal energy_gross = (BigDecimal) getValueAt(selectedRowNo, 13);
    BigDecimal fats_cholesterol = (BigDecimal) getValueAt(selectedRowNo, 14);
    BigDecimal fats_dha = (BigDecimal) getValueAt(selectedRowNo, 15);
    BigDecimal fats_epa = (BigDecimal) getValueAt(selectedRowNo, 16);
    BigDecimal fats_lauric = (BigDecimal) getValueAt(selectedRowNo, 17);
    BigDecimal fats_linoleic = (BigDecimal) getValueAt(selectedRowNo, 18);
    BigDecimal fats_linolenic = (BigDecimal) getValueAt(selectedRowNo, 19);
    BigDecimal fats_monounsaturated = (BigDecimal) getValueAt(selectedRowNo, 20);
    BigDecimal fats_myristic = (BigDecimal) getValueAt(selectedRowNo, 21);
    BigDecimal fats_palmitic = (BigDecimal) getValueAt(selectedRowNo, 22);
    BigDecimal fats_polyunsaturated = (BigDecimal) getValueAt(selectedRowNo, 23);
    BigDecimal fats_saturated = (BigDecimal) getValueAt(selectedRowNo, 24);
    BigDecimal fats_stearic = (BigDecimal) getValueAt(selectedRowNo, 25);
    BigDecimal fats_total = (BigDecimal) getValueAt(selectedRowNo, 26);
    BigDecimal minerals_calcium = (BigDecimal) getValueAt(selectedRowNo, 27);
    BigDecimal minerals_copper = (BigDecimal) getValueAt(selectedRowNo, 28);
    BigDecimal minerals_iron = (BigDecimal) getValueAt(selectedRowNo, 29);
    BigDecimal minerals_magnesium = (BigDecimal) getValueAt(selectedRowNo, 30);
    BigDecimal minerals_manganese = (BigDecimal) getValueAt(selectedRowNo, 31);
    BigDecimal minerals_phosphorus = (BigDecimal) getValueAt(selectedRowNo, 32);
    BigDecimal minerals_potassium = (BigDecimal) getValueAt(selectedRowNo, 33);
    BigDecimal minerals_selenium = (BigDecimal) getValueAt(selectedRowNo, 34);
    BigDecimal minerals_sodium = (BigDecimal) getValueAt(selectedRowNo, 35);
    BigDecimal minerals_zinc = (BigDecimal) getValueAt(selectedRowNo, 36);
    BigDecimal other_alcohol = (BigDecimal) getValueAt(selectedRowNo, 37);
    BigDecimal other_cost = (BigDecimal) getValueAt(selectedRowNo, 38);
    BigDecimal other_water = (BigDecimal) getValueAt(selectedRowNo, 39);
    BigDecimal other_weight = (BigDecimal) getValueAt(selectedRowNo, 40);
    BigDecimal phytonutrients_anthocyanins = (BigDecimal) getValueAt(selectedRowNo, 41);
    BigDecimal phytonutrients_caffeine = (BigDecimal) getValueAt(selectedRowNo, 42);
    BigDecimal phytonutrients_beta_carotene = (BigDecimal) getValueAt(selectedRowNo, 43);
    BigDecimal phytonutrients_carotenoids = (BigDecimal) getValueAt(selectedRowNo, 44);
    BigDecimal phytonutrients_flavanols = (BigDecimal) getValueAt(selectedRowNo, 45);
    BigDecimal phytonutrients_flavanones = (BigDecimal) getValueAt(selectedRowNo, 46);
    BigDecimal phytonutrients_flavones = (BigDecimal) getValueAt(selectedRowNo, 47);
    BigDecimal phytonutrients_flavonoids = (BigDecimal) getValueAt(selectedRowNo, 48);
    BigDecimal phytonutrients_flavonols = (BigDecimal) getValueAt(selectedRowNo, 49);
    BigDecimal phytonutrients_isoflavones = (BigDecimal) getValueAt(selectedRowNo, 50);
    BigDecimal phytonutrients_lutein_zeaxanthin = (BigDecimal) getValueAt(selectedRowNo, 51);
    BigDecimal phytonutrients_lycopene = (BigDecimal) getValueAt(selectedRowNo, 52);
    BigDecimal phytonutrients_phytosterols = (BigDecimal) getValueAt(selectedRowNo, 53);
    BigDecimal phytonutrients_theobromine = (BigDecimal) getValueAt(selectedRowNo, 54);
    BigDecimal protein_complete = (BigDecimal) getValueAt(selectedRowNo, 55);
    BigDecimal protein_total = (BigDecimal) getValueAt(selectedRowNo, 56);
    BigDecimal vitamins_vitamin_a = (BigDecimal) getValueAt(selectedRowNo, 57);
    BigDecimal vitamins_vitamin_b12 = (BigDecimal) getValueAt(selectedRowNo, 58);
    BigDecimal vitamins_vitamin_b6 = (BigDecimal) getValueAt(selectedRowNo, 59);
    BigDecimal vitamins_vitamin_c = (BigDecimal) getValueAt(selectedRowNo, 60);
    BigDecimal vitamins_choline = (BigDecimal) getValueAt(selectedRowNo, 61);
    BigDecimal vitamins_vitamin_d = (BigDecimal) getValueAt(selectedRowNo, 62);
    BigDecimal vitamins_vitamin_e = (BigDecimal) getValueAt(selectedRowNo, 63);
    BigDecimal vitamins_folate = (BigDecimal) getValueAt(selectedRowNo, 64);
    BigDecimal vitamins_vitamin_k = (BigDecimal) getValueAt(selectedRowNo, 65);
    BigDecimal vitamins_niacin = (BigDecimal) getValueAt(selectedRowNo, 66);
    BigDecimal vitamins_pantothenic_acid = (BigDecimal) getValueAt(selectedRowNo, 67);
    BigDecimal vitamins_riboflavin = (BigDecimal) getValueAt(selectedRowNo, 68);
    BigDecimal vitamins_thiamin = (BigDecimal) getValueAt(selectedRowNo, 69);
    BigDecimal carbohydrates_digestible = (BigDecimal) getValueAt(selectedRowNo, 70);
    BigDecimal energy_carbohydrate = (BigDecimal) getValueAt(selectedRowNo, 71);
    BigDecimal energy_fat = (BigDecimal) getValueAt(selectedRowNo, 72);
    BigDecimal energy_fat_and_carbohydrate = (BigDecimal) getValueAt(selectedRowNo, 73);
    BigDecimal energy_protein = (BigDecimal) getValueAt(selectedRowNo, 74);
    BigDecimal energy_alcohol = (BigDecimal) getValueAt(selectedRowNo, 75);
    BigDecimal energy_digestible = (BigDecimal) getValueAt(selectedRowNo, 76);
    BigDecimal fats_hcsfa = (BigDecimal) getValueAt(selectedRowNo, 77);
    BigDecimal fats_lcn3pufa = (BigDecimal) getValueAt(selectedRowNo, 78);
    Row row = new Row();
    row.setId(id);
    row.setName(name);
    row.setCarbohydrates_carbs_by_diff(carbohydrates_carbs_by_diff);
    row.setCarbohydrates_fiber_insoluble(carbohydrates_fiber_insoluble);
    row.setCarbohydrates_fiber_soluble(carbohydrates_fiber_soluble);
    row.setCarbohydrates_fiber(carbohydrates_fiber);
    row.setCarbohydrates_fructose(carbohydrates_fructose);
    row.setCarbohydrates_glucose(carbohydrates_glucose);
    row.setCarbohydrates_glycemic_load(carbohydrates_glycemic_load);
    row.setCarbohydrates_lactose(carbohydrates_lactose);
    row.setCarbohydrates_starch(carbohydrates_starch);
    row.setCarbohydrates_sucrose(carbohydrates_sucrose);
    row.setCarbohydrates_sugars(carbohydrates_sugars);
    row.setEnergy_gross(energy_gross);
    row.setFats_cholesterol(fats_cholesterol);
    row.setFats_dha(fats_dha);
    row.setFats_epa(fats_epa);
    row.setFats_lauric(fats_lauric);
    row.setFats_linoleic(fats_linoleic);
    row.setFats_linolenic(fats_linolenic);
    row.setFats_monounsaturated(fats_monounsaturated);
    row.setFats_myristic(fats_myristic);
    row.setFats_palmitic(fats_palmitic);
    row.setFats_polyunsaturated(fats_polyunsaturated);
    row.setFats_saturated(fats_saturated);
    row.setFats_stearic(fats_stearic);
    row.setFats_total(fats_total);
    row.setMinerals_calcium(minerals_calcium);
    row.setMinerals_copper(minerals_copper);
    row.setMinerals_iron(minerals_iron);
    row.setMinerals_magnesium(minerals_magnesium);
    row.setMinerals_manganese(minerals_manganese);
    row.setMinerals_phosphorus(minerals_phosphorus);
    row.setMinerals_potassium(minerals_potassium);
    row.setMinerals_selenium(minerals_selenium);
    row.setMinerals_sodium(minerals_sodium);
    row.setMinerals_zinc(minerals_zinc);
    row.setOther_alcohol(other_alcohol);
    row.setOther_cost(other_cost);
    row.setOther_water(other_water);
    row.setOther_weight(other_weight);
    row.setPhytonutrients_anthocyanins(phytonutrients_anthocyanins);
    row.setPhytonutrients_caffeine(phytonutrients_caffeine);
    row.setPhytonutrients_beta_carotene(phytonutrients_beta_carotene);
    row.setPhytonutrients_carotenoids(phytonutrients_carotenoids);
    row.setPhytonutrients_flavanols(phytonutrients_flavanols);
    row.setPhytonutrients_flavanones(phytonutrients_flavanones);
    row.setPhytonutrients_flavones(phytonutrients_flavones);
    row.setPhytonutrients_flavonoids(phytonutrients_flavonoids);
    row.setPhytonutrients_flavonols(phytonutrients_flavonols);
    row.setPhytonutrients_isoflavones(phytonutrients_isoflavones);
    row.setPhytonutrients_lutein_zeaxanthin(phytonutrients_lutein_zeaxanthin);
    row.setPhytonutrients_lycopene(phytonutrients_lycopene);
    row.setPhytonutrients_phytosterols(phytonutrients_phytosterols);
    row.setPhytonutrients_theobromine(phytonutrients_theobromine);
    row.setProtein_complete(protein_complete);
    row.setProtein_total(protein_total);
    row.setVitamins_vitamin_a(vitamins_vitamin_a);
    row.setVitamins_vitamin_b12(vitamins_vitamin_b12);
    row.setVitamins_vitamin_b6(vitamins_vitamin_b6);
    row.setVitamins_vitamin_c(vitamins_vitamin_c);
    row.setVitamins_choline(vitamins_choline);
    row.setVitamins_vitamin_d(vitamins_vitamin_d);
    row.setVitamins_vitamin_e(vitamins_vitamin_e);
    row.setVitamins_folate(vitamins_folate);
    row.setVitamins_vitamin_k(vitamins_vitamin_k);
    row.setVitamins_niacin(vitamins_niacin);
    row.setVitamins_pantothenic_acid(vitamins_pantothenic_acid);
    row.setVitamins_riboflavin(vitamins_riboflavin);
    row.setVitamins_thiamin(vitamins_thiamin);
    row.setCarbohydrates_digestible(carbohydrates_digestible);
    row.setEnergy_carbohydrate(energy_carbohydrate);
    row.setEnergy_fat(energy_fat);
    row.setEnergy_fat_and_carbohydrate(energy_fat_and_carbohydrate);
    row.setEnergy_protein(energy_protein);
    row.setEnergy_alcohol(energy_alcohol);
    row.setEnergy_digestible(energy_digestible);
    row.setFats_hcsfa(fats_hcsfa);
    row.setFats_lcn3pufa(fats_lcn3pufa);
    return row;
  }

  public JTextField getTxtSearch() {
    return txtSearch;
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
    getColumnModel().getColumn(0).setMinWidth(80);
    getColumnModel().getColumn(0).setPreferredWidth(80);
    getColumnModel().getColumn(1).setPreferredWidth(646);
  }

  public int find(String id) {
    int index = 0;
    int r = this.getRowCount();
    for (int j = 0; j < r; j++) {
      if (id.equals(getValueAt(j, 0))) {
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
    getColumnModel().getColumn(2).setCellRenderer(renderer);
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
    getColumnModel().getColumn(18).setCellRenderer(renderer);
    getColumnModel().getColumn(19).setCellRenderer(renderer);
    getColumnModel().getColumn(20).setCellRenderer(renderer);
    getColumnModel().getColumn(21).setCellRenderer(renderer);
    getColumnModel().getColumn(22).setCellRenderer(renderer);
    getColumnModel().getColumn(23).setCellRenderer(renderer);
    getColumnModel().getColumn(24).setCellRenderer(renderer);
    getColumnModel().getColumn(25).setCellRenderer(renderer);
    getColumnModel().getColumn(26).setCellRenderer(renderer);
    getColumnModel().getColumn(27).setCellRenderer(renderer);
    getColumnModel().getColumn(28).setCellRenderer(renderer);
    getColumnModel().getColumn(29).setCellRenderer(renderer);
    getColumnModel().getColumn(30).setCellRenderer(renderer);
    getColumnModel().getColumn(31).setCellRenderer(renderer);
    getColumnModel().getColumn(32).setCellRenderer(renderer);
    getColumnModel().getColumn(33).setCellRenderer(renderer);
    getColumnModel().getColumn(34).setCellRenderer(renderer);
    getColumnModel().getColumn(35).setCellRenderer(renderer);
    getColumnModel().getColumn(36).setCellRenderer(renderer);
    getColumnModel().getColumn(37).setCellRenderer(renderer);
    getColumnModel().getColumn(38).setCellRenderer(renderer);
    getColumnModel().getColumn(39).setCellRenderer(renderer);
    getColumnModel().getColumn(40).setCellRenderer(renderer);
    getColumnModel().getColumn(41).setCellRenderer(renderer);
    getColumnModel().getColumn(42).setCellRenderer(renderer);
    getColumnModel().getColumn(43).setCellRenderer(renderer);
    getColumnModel().getColumn(44).setCellRenderer(renderer);
    getColumnModel().getColumn(45).setCellRenderer(renderer);
    getColumnModel().getColumn(46).setCellRenderer(renderer);
    getColumnModel().getColumn(47).setCellRenderer(renderer);
    getColumnModel().getColumn(48).setCellRenderer(renderer);
    getColumnModel().getColumn(49).setCellRenderer(renderer);
    getColumnModel().getColumn(50).setCellRenderer(renderer);
    getColumnModel().getColumn(51).setCellRenderer(renderer);
    getColumnModel().getColumn(52).setCellRenderer(renderer);
    getColumnModel().getColumn(53).setCellRenderer(renderer);
    getColumnModel().getColumn(54).setCellRenderer(renderer);
    getColumnModel().getColumn(55).setCellRenderer(renderer);
    getColumnModel().getColumn(56).setCellRenderer(renderer);
    getColumnModel().getColumn(57).setCellRenderer(renderer);
    getColumnModel().getColumn(58).setCellRenderer(renderer);
    getColumnModel().getColumn(59).setCellRenderer(renderer);
    getColumnModel().getColumn(60).setCellRenderer(renderer);
    getColumnModel().getColumn(61).setCellRenderer(renderer);
    getColumnModel().getColumn(62).setCellRenderer(renderer);
    getColumnModel().getColumn(63).setCellRenderer(renderer);
    getColumnModel().getColumn(64).setCellRenderer(renderer);
    getColumnModel().getColumn(65).setCellRenderer(renderer);
    getColumnModel().getColumn(66).setCellRenderer(renderer);
    getColumnModel().getColumn(67).setCellRenderer(renderer);
    getColumnModel().getColumn(68).setCellRenderer(renderer);
    getColumnModel().getColumn(69).setCellRenderer(renderer);
    getColumnModel().getColumn(70).setCellRenderer(renderer);
    getColumnModel().getColumn(71).setCellRenderer(renderer);
    getColumnModel().getColumn(72).setCellRenderer(renderer);
    getColumnModel().getColumn(73).setCellRenderer(renderer);
    getColumnModel().getColumn(74).setCellRenderer(renderer);
    getColumnModel().getColumn(75).setCellRenderer(renderer);
    getColumnModel().getColumn(76).setCellRenderer(renderer);
    getColumnModel().getColumn(77).setCellRenderer(renderer);
    getColumnModel().getColumn(78).setCellRenderer(renderer);
    revalidate();
    repaint();
  }

  public class Row {

    private String id;
    private String name;
    private BigDecimal carbohydrates_carbs_by_diff;
    private BigDecimal carbohydrates_fiber_insoluble;
    private BigDecimal carbohydrates_fiber_soluble;
    private BigDecimal carbohydrates_fiber;
    private BigDecimal carbohydrates_fructose;
    private BigDecimal carbohydrates_glucose;
    private BigDecimal carbohydrates_glycemic_load;
    private BigDecimal carbohydrates_lactose;
    private BigDecimal carbohydrates_starch;
    private BigDecimal carbohydrates_sucrose;
    private BigDecimal carbohydrates_sugars;
    private BigDecimal energy_gross;
    private BigDecimal fats_cholesterol;
    private BigDecimal fats_dha;
    private BigDecimal fats_epa;
    private BigDecimal fats_lauric;
    private BigDecimal fats_linoleic;
    private BigDecimal fats_linolenic;
    private BigDecimal fats_monounsaturated;
    private BigDecimal fats_myristic;
    private BigDecimal fats_palmitic;
    private BigDecimal fats_polyunsaturated;
    private BigDecimal fats_saturated;
    private BigDecimal fats_stearic;
    private BigDecimal fats_total;
    private BigDecimal minerals_calcium;
    private BigDecimal minerals_copper;
    private BigDecimal minerals_iron;
    private BigDecimal minerals_magnesium;
    private BigDecimal minerals_manganese;
    private BigDecimal minerals_phosphorus;
    private BigDecimal minerals_potassium;
    private BigDecimal minerals_selenium;
    private BigDecimal minerals_sodium;
    private BigDecimal minerals_zinc;
    private BigDecimal other_alcohol;
    private BigDecimal other_cost;
    private BigDecimal other_water;
    private BigDecimal other_weight;
    private BigDecimal phytonutrients_anthocyanins;
    private BigDecimal phytonutrients_caffeine;
    private BigDecimal phytonutrients_beta_carotene;
    private BigDecimal phytonutrients_carotenoids;
    private BigDecimal phytonutrients_flavanols;
    private BigDecimal phytonutrients_flavanones;
    private BigDecimal phytonutrients_flavones;
    private BigDecimal phytonutrients_flavonoids;
    private BigDecimal phytonutrients_flavonols;
    private BigDecimal phytonutrients_isoflavones;
    private BigDecimal phytonutrients_lutein_zeaxanthin;
    private BigDecimal phytonutrients_lycopene;
    private BigDecimal phytonutrients_phytosterols;
    private BigDecimal phytonutrients_theobromine;
    private BigDecimal protein_complete;
    private BigDecimal protein_total;
    private BigDecimal vitamins_vitamin_a;
    private BigDecimal vitamins_vitamin_b12;
    private BigDecimal vitamins_vitamin_b6;
    private BigDecimal vitamins_vitamin_c;
    private BigDecimal vitamins_choline;
    private BigDecimal vitamins_vitamin_d;
    private BigDecimal vitamins_vitamin_e;
    private BigDecimal vitamins_folate;
    private BigDecimal vitamins_vitamin_k;
    private BigDecimal vitamins_niacin;
    private BigDecimal vitamins_pantothenic_acid;
    private BigDecimal vitamins_riboflavin;
    private BigDecimal vitamins_thiamin;
    private BigDecimal carbohydrates_digestible;
    private BigDecimal energy_carbohydrate;
    private BigDecimal energy_fat;
    private BigDecimal energy_fat_and_carbohydrate;
    private BigDecimal energy_protein;
    private BigDecimal energy_alcohol;
    private BigDecimal energy_digestible;
    private BigDecimal fats_hcsfa;
    private BigDecimal fats_lcn3pufa;

    public Row() {
      id = "";
      name = "";
      carbohydrates_carbs_by_diff = new BigDecimal("0.0");
      carbohydrates_fiber_insoluble = new BigDecimal("0.0");
      carbohydrates_fiber_soluble = new BigDecimal("0.0");
      carbohydrates_fiber = new BigDecimal("0.0");
      carbohydrates_fructose = new BigDecimal("0.0");
      carbohydrates_glucose = new BigDecimal("0.0");
      carbohydrates_glycemic_load = new BigDecimal("0.0");
      carbohydrates_lactose = new BigDecimal("0.0");
      carbohydrates_starch = new BigDecimal("0.0");
      carbohydrates_sucrose = new BigDecimal("0.0");
      carbohydrates_sugars = new BigDecimal("0.0");
      energy_gross = new BigDecimal("0.0");
      fats_cholesterol = new BigDecimal("0.0");
      fats_dha = new BigDecimal("0.0");
      fats_epa = new BigDecimal("0.0");
      fats_lauric = new BigDecimal("0.0");
      fats_linoleic = new BigDecimal("0.0");
      fats_linolenic = new BigDecimal("0.0");
      fats_monounsaturated = new BigDecimal("0.0");
      fats_myristic = new BigDecimal("0.0");
      fats_palmitic = new BigDecimal("0.0");
      fats_polyunsaturated = new BigDecimal("0.0");
      fats_saturated = new BigDecimal("0.0");
      fats_stearic = new BigDecimal("0.0");
      fats_total = new BigDecimal("0.0");
      minerals_calcium = new BigDecimal("0.0");
      minerals_copper = new BigDecimal("0.0");
      minerals_iron = new BigDecimal("0.0");
      minerals_magnesium = new BigDecimal("0.0");
      minerals_manganese = new BigDecimal("0.0");
      minerals_phosphorus = new BigDecimal("0.0");
      minerals_potassium = new BigDecimal("0.0");
      minerals_selenium = new BigDecimal("0.0");
      minerals_sodium = new BigDecimal("0.0");
      minerals_zinc = new BigDecimal("0.0");
      other_alcohol = new BigDecimal("0.0");
      other_cost = new BigDecimal("0.0");
      other_water = new BigDecimal("0.0");
      other_weight = new BigDecimal("0.0");
      phytonutrients_anthocyanins = new BigDecimal("0.0");
      phytonutrients_caffeine = new BigDecimal("0.0");
      phytonutrients_beta_carotene = new BigDecimal("0.0");
      phytonutrients_carotenoids = new BigDecimal("0.0");
      phytonutrients_flavanols = new BigDecimal("0.0");
      phytonutrients_flavanones = new BigDecimal("0.0");
      phytonutrients_flavones = new BigDecimal("0.0");
      phytonutrients_flavonoids = new BigDecimal("0.0");
      phytonutrients_flavonols = new BigDecimal("0.0");
      phytonutrients_isoflavones = new BigDecimal("0.0");
      phytonutrients_lutein_zeaxanthin = new BigDecimal("0.0");
      phytonutrients_lycopene = new BigDecimal("0.0");
      phytonutrients_phytosterols = new BigDecimal("0.0");
      phytonutrients_theobromine = new BigDecimal("0.0");
      protein_complete = new BigDecimal("0.0");
      protein_total = new BigDecimal("0.0");
      vitamins_vitamin_a = new BigDecimal("0.0");
      vitamins_vitamin_b12 = new BigDecimal("0.0");
      vitamins_vitamin_b6 = new BigDecimal("0.0");
      vitamins_vitamin_c = new BigDecimal("0.0");
      vitamins_choline = new BigDecimal("0.0");
      vitamins_vitamin_d = new BigDecimal("0.0");
      vitamins_vitamin_e = new BigDecimal("0.0");
      vitamins_folate = new BigDecimal("0.0");
      vitamins_vitamin_k = new BigDecimal("0.0");
      vitamins_niacin = new BigDecimal("0.0");
      vitamins_pantothenic_acid = new BigDecimal("0.0");
      vitamins_riboflavin = new BigDecimal("0.0");
      vitamins_thiamin = new BigDecimal("0.0");
      carbohydrates_digestible = new BigDecimal("0.0");
      energy_carbohydrate = new BigDecimal("0.0");
      energy_fat = new BigDecimal("0.0");
      energy_fat_and_carbohydrate = new BigDecimal("0.0");
      energy_protein = new BigDecimal("0.0");
      energy_alcohol = new BigDecimal("0.0");
      energy_digestible = new BigDecimal("0.0");
      fats_hcsfa = new BigDecimal("0.0");
      fats_lcn3pufa = new BigDecimal("0.0");
    }

    public String getId() {
      return id;
    }

    public void setId(String id) {
      this.id = id;
    }

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    public BigDecimal getCarbohydrates_carbs_by_diff() {
      return carbohydrates_carbs_by_diff;
    }

    public void setCarbohydrates_carbs_by_diff(BigDecimal carbohydrates_carbs_by_diff) {
      this.carbohydrates_carbs_by_diff = carbohydrates_carbs_by_diff;
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

    public BigDecimal getCarbohydrates_fiber() {
      return carbohydrates_fiber;
    }

    public void setCarbohydrates_fiber(BigDecimal carbohydrates_fiber) {
      this.carbohydrates_fiber = carbohydrates_fiber;
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

    public BigDecimal getCarbohydrates_lactose() {
      return carbohydrates_lactose;
    }

    public void setCarbohydrates_lactose(BigDecimal carbohydrates_lactose) {
      this.carbohydrates_lactose = carbohydrates_lactose;
    }

    public BigDecimal getCarbohydrates_starch() {
      return carbohydrates_starch;
    }

    public void setCarbohydrates_starch(BigDecimal carbohydrates_starch) {
      this.carbohydrates_starch = carbohydrates_starch;
    }

    public BigDecimal getCarbohydrates_sucrose() {
      return carbohydrates_sucrose;
    }

    public void setCarbohydrates_sucrose(BigDecimal carbohydrates_sucrose) {
      this.carbohydrates_sucrose = carbohydrates_sucrose;
    }

    public BigDecimal getCarbohydrates_sugars() {
      return carbohydrates_sugars;
    }

    public void setCarbohydrates_sugars(BigDecimal carbohydrates_sugars) {
      this.carbohydrates_sugars = carbohydrates_sugars;
    }

    public BigDecimal getEnergy_gross() {
      return energy_gross;
    }

    public void setEnergy_gross(BigDecimal energy_gross) {
      this.energy_gross = energy_gross;
    }

    public BigDecimal getFats_cholesterol() {
      return fats_cholesterol;
    }

    public void setFats_cholesterol(BigDecimal fats_cholesterol) {
      this.fats_cholesterol = fats_cholesterol;
    }

    public BigDecimal getFats_dha() {
      return fats_dha;
    }

    public void setFats_dha(BigDecimal fats_dha) {
      this.fats_dha = fats_dha;
    }

    public BigDecimal getFats_epa() {
      return fats_epa;
    }

    public void setFats_epa(BigDecimal fats_epa) {
      this.fats_epa = fats_epa;
    }

    public BigDecimal getFats_lauric() {
      return fats_lauric;
    }

    public void setFats_lauric(BigDecimal fats_lauric) {
      this.fats_lauric = fats_lauric;
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

    public BigDecimal getFats_monounsaturated() {
      return fats_monounsaturated;
    }

    public void setFats_monounsaturated(BigDecimal fats_monounsaturated) {
      this.fats_monounsaturated = fats_monounsaturated;
    }

    public BigDecimal getFats_myristic() {
      return fats_myristic;
    }

    public void setFats_myristic(BigDecimal fats_myristic) {
      this.fats_myristic = fats_myristic;
    }

    public BigDecimal getFats_palmitic() {
      return fats_palmitic;
    }

    public void setFats_palmitic(BigDecimal fats_palmitic) {
      this.fats_palmitic = fats_palmitic;
    }

    public BigDecimal getFats_polyunsaturated() {
      return fats_polyunsaturated;
    }

    public void setFats_polyunsaturated(BigDecimal fats_polyunsaturated) {
      this.fats_polyunsaturated = fats_polyunsaturated;
    }

    public BigDecimal getFats_saturated() {
      return fats_saturated;
    }

    public void setFats_saturated(BigDecimal fats_saturated) {
      this.fats_saturated = fats_saturated;
    }

    public BigDecimal getFats_stearic() {
      return fats_stearic;
    }

    public void setFats_stearic(BigDecimal fats_stearic) {
      this.fats_stearic = fats_stearic;
    }

    public BigDecimal getFats_total() {
      return fats_total;
    }

    public void setFats_total(BigDecimal fats_total) {
      this.fats_total = fats_total;
    }

    public BigDecimal getMinerals_calcium() {
      return minerals_calcium;
    }

    public void setMinerals_calcium(BigDecimal minerals_calcium) {
      this.minerals_calcium = minerals_calcium;
    }

    public BigDecimal getMinerals_copper() {
      return minerals_copper;
    }

    public void setMinerals_copper(BigDecimal minerals_copper) {
      this.minerals_copper = minerals_copper;
    }

    public BigDecimal getMinerals_iron() {
      return minerals_iron;
    }

    public void setMinerals_iron(BigDecimal minerals_iron) {
      this.minerals_iron = minerals_iron;
    }

    public BigDecimal getMinerals_magnesium() {
      return minerals_magnesium;
    }

    public void setMinerals_magnesium(BigDecimal minerals_magnesium) {
      this.minerals_magnesium = minerals_magnesium;
    }

    public BigDecimal getMinerals_manganese() {
      return minerals_manganese;
    }

    public void setMinerals_manganese(BigDecimal minerals_manganese) {
      this.minerals_manganese = minerals_manganese;
    }

    public BigDecimal getMinerals_phosphorus() {
      return minerals_phosphorus;
    }

    public void setMinerals_phosphorus(BigDecimal minerals_phosphorus) {
      this.minerals_phosphorus = minerals_phosphorus;
    }

    public BigDecimal getMinerals_potassium() {
      return minerals_potassium;
    }

    public void setMinerals_potassium(BigDecimal minerals_potassium) {
      this.minerals_potassium = minerals_potassium;
    }

    public BigDecimal getMinerals_selenium() {
      return minerals_selenium;
    }

    public void setMinerals_selenium(BigDecimal minerals_selenium) {
      this.minerals_selenium = minerals_selenium;
    }

    public BigDecimal getMinerals_sodium() {
      return minerals_sodium;
    }

    public void setMinerals_sodium(BigDecimal minerals_sodium) {
      this.minerals_sodium = minerals_sodium;
    }

    public BigDecimal getMinerals_zinc() {
      return minerals_zinc;
    }

    public void setMinerals_zinc(BigDecimal minerals_zinc) {
      this.minerals_zinc = minerals_zinc;
    }

    public BigDecimal getOther_alcohol() {
      return other_alcohol;
    }

    public void setOther_alcohol(BigDecimal other_alcohol) {
      this.other_alcohol = other_alcohol;
    }

    public BigDecimal getOther_cost() {
      return other_cost;
    }

    public void setOther_cost(BigDecimal other_cost) {
      this.other_cost = other_cost;
    }

    public BigDecimal getOther_water() {
      return other_water;
    }

    public void setOther_water(BigDecimal other_water) {
      this.other_water = other_water;
    }

    public BigDecimal getOther_weight() {
      return other_weight;
    }

    public void setOther_weight(BigDecimal other_weight) {
      this.other_weight = other_weight;
    }

    public BigDecimal getPhytonutrients_anthocyanins() {
      return phytonutrients_anthocyanins;
    }

    public void setPhytonutrients_anthocyanins(BigDecimal phytonutrients_anthocyanins) {
      this.phytonutrients_anthocyanins = phytonutrients_anthocyanins;
    }

    public BigDecimal getPhytonutrients_caffeine() {
      return phytonutrients_caffeine;
    }

    public void setPhytonutrients_caffeine(BigDecimal phytonutrients_caffeine) {
      this.phytonutrients_caffeine = phytonutrients_caffeine;
    }

    public BigDecimal getPhytonutrients_beta_carotene() {
      return phytonutrients_beta_carotene;
    }

    public void setPhytonutrients_beta_carotene(BigDecimal phytonutrients_beta_carotene) {
      this.phytonutrients_beta_carotene = phytonutrients_beta_carotene;
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

    public BigDecimal getPhytonutrients_flavonoids() {
      return phytonutrients_flavonoids;
    }

    public void setPhytonutrients_flavonoids(BigDecimal phytonutrients_flavonoids) {
      this.phytonutrients_flavonoids = phytonutrients_flavonoids;
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

    public BigDecimal getPhytonutrients_phytosterols() {
      return phytonutrients_phytosterols;
    }

    public void setPhytonutrients_phytosterols(BigDecimal phytonutrients_phytosterols) {
      this.phytonutrients_phytosterols = phytonutrients_phytosterols;
    }

    public BigDecimal getPhytonutrients_theobromine() {
      return phytonutrients_theobromine;
    }

    public void setPhytonutrients_theobromine(BigDecimal phytonutrients_theobromine) {
      this.phytonutrients_theobromine = phytonutrients_theobromine;
    }

    public BigDecimal getProtein_complete() {
      return protein_complete;
    }

    public void setProtein_complete(BigDecimal protein_complete) {
      this.protein_complete = protein_complete;
    }

    public BigDecimal getProtein_total() {
      return protein_total;
    }

    public void setProtein_total(BigDecimal protein_total) {
      this.protein_total = protein_total;
    }

    public BigDecimal getVitamins_vitamin_a() {
      return vitamins_vitamin_a;
    }

    public void setVitamins_vitamin_a(BigDecimal vitamins_vitamin_a) {
      this.vitamins_vitamin_a = vitamins_vitamin_a;
    }

    public BigDecimal getVitamins_vitamin_b12() {
      return vitamins_vitamin_b12;
    }

    public void setVitamins_vitamin_b12(BigDecimal vitamins_vitamin_b12) {
      this.vitamins_vitamin_b12 = vitamins_vitamin_b12;
    }

    public BigDecimal getVitamins_vitamin_b6() {
      return vitamins_vitamin_b6;
    }

    public void setVitamins_vitamin_b6(BigDecimal vitamins_vitamin_b6) {
      this.vitamins_vitamin_b6 = vitamins_vitamin_b6;
    }

    public BigDecimal getVitamins_vitamin_c() {
      return vitamins_vitamin_c;
    }

    public void setVitamins_vitamin_c(BigDecimal vitamins_vitamin_c) {
      this.vitamins_vitamin_c = vitamins_vitamin_c;
    }

    public BigDecimal getVitamins_choline() {
      return vitamins_choline;
    }

    public void setVitamins_choline(BigDecimal vitamins_choline) {
      this.vitamins_choline = vitamins_choline;
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

    public BigDecimal getVitamins_folate() {
      return vitamins_folate;
    }

    public void setVitamins_folate(BigDecimal vitamins_folate) {
      this.vitamins_folate = vitamins_folate;
    }

    public BigDecimal getVitamins_vitamin_k() {
      return vitamins_vitamin_k;
    }

    public void setVitamins_vitamin_k(BigDecimal vitamins_vitamin_k) {
      this.vitamins_vitamin_k = vitamins_vitamin_k;
    }

    public BigDecimal getVitamins_niacin() {
      return vitamins_niacin;
    }

    public void setVitamins_niacin(BigDecimal vitamins_niacin) {
      this.vitamins_niacin = vitamins_niacin;
    }

    public BigDecimal getVitamins_pantothenic_acid() {
      return vitamins_pantothenic_acid;
    }

    public void setVitamins_pantothenic_acid(BigDecimal vitamins_pantothenic_acid) {
      this.vitamins_pantothenic_acid = vitamins_pantothenic_acid;
    }

    public BigDecimal getVitamins_riboflavin() {
      return vitamins_riboflavin;
    }

    public void setVitamins_riboflavin(BigDecimal vitamins_riboflavin) {
      this.vitamins_riboflavin = vitamins_riboflavin;
    }

    public BigDecimal getVitamins_thiamin() {
      return vitamins_thiamin;
    }

    public void setVitamins_thiamin(BigDecimal vitamins_thiamin) {
      this.vitamins_thiamin = vitamins_thiamin;
    }

    public BigDecimal getCarbohydrates_digestible() {
      return carbohydrates_digestible;
    }

    public void setCarbohydrates_digestible(BigDecimal carbohydrates_digestible) {
      this.carbohydrates_digestible = carbohydrates_digestible;
    }

    public BigDecimal getEnergy_carbohydrate() {
      return energy_carbohydrate;
    }

    public void setEnergy_carbohydrate(BigDecimal energy_carbohydrate) {
      this.energy_carbohydrate = energy_carbohydrate;
    }

    public BigDecimal getEnergy_fat() {
      return energy_fat;
    }

    public void setEnergy_fat(BigDecimal energy_fat) {
      this.energy_fat = energy_fat;
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

    public BigDecimal getEnergy_digestible() {
      return energy_digestible;
    }

    public void setEnergy_digestible(BigDecimal energy_digestible) {
      this.energy_digestible = energy_digestible;
    }

    public BigDecimal getFats_hcsfa() {
      return fats_hcsfa;
    }

    public void setFats_hcsfa(BigDecimal fats_hcsfa) {
      this.fats_hcsfa = fats_hcsfa;
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
        case 0, 1 -> {
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
        "food-id",
        "food-name",
        "Carbohydrates, By Difference (g), 205, carbohydrates-carbs_by_diff",
        "Carbohydrates, Fiber, Insoluble (g), 10018, carbohydrates-fiber_insoluble",
        "Carbohydrates, Fiber, Soluble (g), 10017, carbohydrates-fiber_soluble",
        "Carbohydrates, Fiber (g), 291, carbohydrates-fiber",
        "Carbohydrates, Fructose (g), 212, carbohydrates-fructose",
        "Carbohydrates, Glucose (g), 211, carbohydrates-glucose",
        "Carbohydrates, Glycemic Load (g), 10006, carbohydrates-glycemic_load",
        "Carbohydrates, Lactose (g), 213, carbohydrates-lactose",
        "Carbohydrates, Starch (g), 209, carbohydrates-starch",
        "Carbohydrates, Sucrose (g), 210, carbohydrates-sucrose",
        "Carbohydrates, Sugars (g), 269, carbohydrates-sugars",
        "Energy, Gross (kcal), 208, energy-gross",
        "Fats, Cholesterol (mg), 601, fats-cholesterol",
        "Fats, Docosahexaenoic Acid, DHA, 22:6 n-3 (g), 621, fats-dha",
        "Fats, Eicosapentaenoic Acid, EPA, 20:5 n-3 (g), 629, fats-epa",
        "Fats, Lauric Acid, 12:0 (g), 611, fats-lauric",
        "Fats, Linoleic Acid, LA, 18:2 n-6 (g), 618, fats-linoleic",
        "Fats, Linolenic Acid, ALA, 18:3 n-3 (g), 619, fats-linolenic",
        "Fats, Monounsaturated Fat, MUFA (g), 645, fats-monounsaturated",
        "Fats, Myristic Acid, 14:0 (g), 612, fats-myristic",
        "Fats, Palmitic Acid, 16:0 (g), 613, fats-palmitic",
        "Fats, Polyunsaturated Fat, PUFA (g), 646, fats-polyunsaturated",
        "Fats, Saturated Fat, SFA (g), 606, fats-saturated",
        "Fats, Stearic Acid, 18:0 (g), 614, fats-stearic",
        "Fats, Total Fat (g), 204, fats-total",
        "Minerals, Calcium (mg), 301, minerals-calcium",
        "Minerals, Copper (mg), 312, minerals-copper",
        "Minerals, Iron (mg), 303, minerals-iron",
        "Minerals, Magnesium (mg), 304, minerals-magnesium",
        "Minerals, Manganese (mg), 315, minerals-manganese",
        "Minerals, Phosphorus (mg), 305, minerals-phosphorus",
        "Minerals, Potassium (mg), 306, minerals-potassium",
        "Minerals, Selenium (mcg), 317, minerals-selenium",
        "Minerals, Sodium (mg), 307, minerals-sodium",
        "Minerals, Zinc (mg), 309, minerals-zinc",
        "Other, Alcohol (g), 221, other-alcohol",
        "Other, Cost ($), 10005, other-cost",
        "Other, Water (g), 255, other-water",
        "Other, Weight (g), 10000, other-weight",
        "Phytonutrients, Anthocyanins (mg), 10024, phytonutrients-anthocyanins",
        "Phytonutrients, Caffeine (mg), 262, phytonutrients-caffeine",
        "Phytonutrients, Carotene, beta (mcg), 321, phytonutrients-beta_carotene",
        "Phytonutrients, Carotenoids (mcg), 10019, phytonutrients-carotenoids",
        "Phytonutrients, Flavanols (mg), 10022, phytonutrients-flavanols",
        "Phytonutrients, Flavanones (mg), 10023, phytonutrients-flavanones",
        "Phytonutrients, Flavones (mg), 10021, phytonutrients-flavones",
        "Phytonutrients, Flavonoids (mg), 10026, phytonutrients-flavonoids",
        "Phytonutrients, Flavonols (mg), 10020, phytonutrients-flavonols",
        "Phytonutrients, Isoflavones (mg), 10025, phytonutrients-isoflavones",
        "Phytonutrients, Lutein + zeaxanthin (mcg), 338, phytonutrients-lutein_zeaxanthin",
        "Phytonutrients, Lycopene (mcg), 337, phytonutrients-lycopene",
        "Phytonutrients, Phytosterols (mg), 636, phytonutrients-phytosterols",
        "Phytonutrients, Theobromine (mg), 263, phytonutrients-theobromine",
        "Protein, Complete Protein (g), 10001, protein-complete",
        "Protein, Total Protein (g), 203, protein-total",
        "Vitamins, A, RAE (mcg), 320, vitamins-vitamin_a",
        "Vitamins, B12 (mcg), 418, vitamins-vitamin_b12",
        "Vitamins, B6 (mg), 415, vitamins-vitamin_b6",
        "Vitamins, C (mg), 401, vitamins-vitamin_c",
        "Vitamins, Choline (mg), 421, vitamins-choline",
        "Vitamins, D (mcg), 328, vitamins-vitamin_d",
        "Vitamins, E (mg), 323, vitamins-vitamin_e",
        "Vitamins, Folate, DFE (mcg), 435, vitamins-folate",
        "Vitamins, K (mcg), 430, vitamins-vitamin_k",
        "Vitamins, Niacin (mg), 406, vitamins-niacin",
        "Vitamins, Pantothenic Acid (mg), 410, vitamins-pantothenic_acid",
        "Vitamins, Riboflavin (mg), 405, vitamins-riboflavin",
        "Vitamins, Thiamin (mg), 404, vitamins-thiamin",
        "Carbohydrates, digestible (g), 10003, carbohydrates-digestible",
        "Energy, Carbohydrate (kcal), 10011, energy-carbohydrate",
        "Energy, Fat (kcal), 10013, energy-fat",
        "Energy, Fat and Carbohydrate (kcal), 10010, energy-fat_and_carbohydrate",
        "Energy, Protein (kcal), 10012, energy-protein",
        "Energy, alcohol (kcal), 10014, energy-alcohol",
        "Energy, digestible (kcal), 10009, energy-digestible",
        "Fats, Hypercholesterolemic Fat (g), 10015, fats-hcsfa",
        "Fats, Long Chain n-3 PUFA (g), 10016, fats-lcn3pufa"
      };
}
