package io.github.xjrga.snack.jcomponents;

import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;
import io.github.xjrga.snack.database.callable.BackgroundExec;
import io.github.xjrga.snack.database.callable.select.DriNutrientsTask;
import io.github.xjrga.snack.database.callable.select.LifestageDriTask;
import io.github.xjrga.snack.database.callable.select.LifestagesTask;
import io.github.xjrga.snack.dataobject.DriDO;
import io.github.xjrga.snack.dataobject.Food;
import io.github.xjrga.snack.dataobject.LifeStageDO;
import io.github.xjrga.snack.dataobject.NutrientDO;
import io.github.xjrga.snack.gui.Message;
import io.github.xjrga.snack.logger.LoggerImpl;
import io.github.xjrga.snack.other.MoistureContentModifier;
import io.github.xjrga.snack.other.NumberCheck;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.List;
import java.util.concurrent.Future;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import org.apache.commons.lang3.StringUtils;

/**
 * @author jr
 */
public class FoodFactInputPanel {

    private CellConstraints cc;
    private TableFoodFactInput tbl;
    private JPanel panel;
    private JTextField txtFoodName;

    public FoodFactInputPanel(TableFoodFactInput table) {

        this.tbl = table;
        tbl.roundUp();
        cc = new CellConstraints();
        panel = new JPanel();
        JLabel labelFoodName = new JLabel("Food Name:");
        JLabel labelNutrientWeight = new JLabel("No selection");
        JLabel labelNutrientSearch = new JLabel("Search:");
        txtFoodName = new JTextField();
        txtFoodName.setText("** New Item **");
        JTextField txtNutrientValue = new JTextField();
        JButton buttonSet = new JButton("Set");
        JButton buttonPrevious = new JButton("<");
        JButton buttonNext = new JButton(">");
        labelFoodName.setHorizontalAlignment(SwingConstants.RIGHT);
        labelNutrientWeight.setHorizontalAlignment(SwingConstants.RIGHT);
        labelNutrientSearch.setHorizontalAlignment(SwingConstants.RIGHT);
        buttonSet.setToolTipText("Set nutrient value");
        buttonPrevious.setToolTipText("Go to previous row");
        buttonNext.setToolTipText("Go to next row");
        FormLayout panelLayout = new FormLayout(
                "10px,300px:grow,5px,200px,5px,min,min,min,10px", // columns
                "10px,min,min,min,4px,min,4px,fill:600px:grow,10px" // rows
                );
        tbl.updateNutrientValue(txtNutrientValue);
        panel.setLayout(panelLayout);
        panel.setBorder(new TitledBorder("Nutritional Food Facts"));
        panel.add(labelFoodName, cc.xy(2, 2));
        panel.add(txtFoodName, cc.xyw(4, 2, 5));
        panel.add(labelNutrientSearch, cc.xy(2, 3));
        panel.add(tbl.getTxtSearch(), cc.xyw(4, 3, 5));
        panel.add(labelNutrientWeight, cc.xy(2, 4));
        panel.add(txtNutrientValue, cc.xyw(4, 4, 2));
        panel.add(buttonSet, cc.xy(6, 4));
        panel.add(buttonPrevious, cc.xy(7, 4));
        panel.add(buttonNext, cc.xy(8, 4));
        panel.add(getWizardPanel(), cc.xyw(2, 6, 7));
        JScrollPane tableNutrientInputScrollPane = new JScrollPane(tbl);
        panel.add(tableNutrientInputScrollPane, cc.xyw(2, 8, 7));
        buttonNext.addActionListener((ActionEvent e) -> {
            int selectedRowNo = tbl.getSelectedRow();

            if (selectedRowNo != tbl.getRowCount() - 1) {

                tbl.getDefaultEditor(BigDecimal.class).cancelCellEditing();
                selectedRowNo++;
                tbl.selectRow(selectedRowNo);
                tbl.showRow(selectedRowNo);

            } else {

                tbl.selectRow(selectedRowNo);
                tbl.showRow(selectedRowNo);
            }
        });
        buttonPrevious.addActionListener((ActionEvent e) -> {
            int selectedRowNo = tbl.getSelectedRow();

            if (selectedRowNo > 0 && selectedRowNo < tbl.getRowCount()) {

                tbl.getDefaultEditor(BigDecimal.class).cancelCellEditing();
                selectedRowNo--;
                tbl.selectRow(selectedRowNo);
                tbl.showRow(selectedRowNo);

            } else {

                tbl.selectRow(selectedRowNo);
                tbl.showRow(selectedRowNo);
            }
        });
        buttonSet.addActionListener((ActionEvent e) -> {
            int selectedRowNo = tbl.getSelectedRow();

            if (!tbl.isSelectionEmpty()) {

                NumberCheck numberCheck = new NumberCheck();
                numberCheck.addToUncheckedList(txtNutrientValue.getText());

                if (numberCheck.pass()) {

                    tbl.getDefaultEditor(BigDecimal.class).cancelCellEditing();
                    tbl.setValueAt(new BigDecimal(txtNutrientValue.getText()), selectedRowNo, 3);
                    tbl.selectRow(selectedRowNo);
                    tbl.showRow(selectedRowNo);

                } else {

                    Message.showMessage("Value must be a number greater than or equal to zero");
                }
            }
        });
        ListSelectionModel selectionModel = tbl.getSelectionModel();
        selectionModel.addListSelectionListener((ListSelectionEvent e) -> {
            if (e.getValueIsAdjusting()) {

                tbl.getDefaultEditor(BigDecimal.class).cancelCellEditing();
                return;
            }

            if (!tbl.isSelectionEmpty()) {

                int selectedRowNo = tbl.getSelectedRow();
                String food = (String) tbl.getValueAt(selectedRowNo, 1);
                String nutrient = (String) tbl.getValueAt(selectedRowNo, 2);
                Object valueAt = tbl.getValueAt(selectedRowNo, 3);
                BigDecimal weight = (BigDecimal) valueAt;
                txtNutrientValue.setText((new DecimalFormat("######0.0#################")).format(weight));
                labelNutrientWeight.setText(nutrient);
            }
        });
        int index = tbl.find("10000");
        tbl.selectRow(index);
        tbl.showRow(index);
    }

    public JPanel getPanel() {

        return panel;
    }

    private void fillWaterAmount() {

        JLabel lblMC = new JLabel("Adjust moisture content to: ");
        JTextPane txpInfo = new JTextPane();
        JTextField txtMC = new JTextField();
        StringBuilder sb = new StringBuilder();
        JPanel pnl = new JPanel();
        JComponent[] inputs = {pnl};
        FormLayout lyo = new FormLayout(
                "p:grow,p:grow", // columns
                "fill:p:grow,p" // rows
                );
        lblMC.setHorizontalAlignment(SwingConstants.RIGHT);
        txpInfo.setEditable(false);
        txtMC.setPreferredSize(new Dimension(75, 28));
        NumberCheck checkNumber = new NumberCheck();
        // model row index is specified by sql query.
        int columnIndex = 3;
        int waterIndex = tbl.find("255");
        int weightIndex = tbl.find("10000");
        BigDecimal initialWaterWeight = (BigDecimal) tbl.getValueAt(waterIndex, columnIndex);
        BigDecimal initialWeight = (BigDecimal) tbl.getValueAt(weightIndex, columnIndex);
        MoistureContentModifier mcm =
                new MoistureContentModifier(initialWeight.doubleValue(), initialWaterWeight.doubleValue(), 0.0);
        String fInitialWeight = (new DecimalFormat("###0.000")).format(mcm.getInitialWeight());
        String fInitialWaterWeight = (new DecimalFormat("###0.000")).format(mcm.getInitialWaterWeight());
        String fDryMatterWeight = (new DecimalFormat("###0.000")).format(mcm.getDryMatterWeight());
        String fInitialMoistureContent = (new DecimalFormat("###0.000")).format(mcm.getInitialMoistureContent());
        int length = txtFoodName.getText().length() + 2;
        sb.append(StringUtils.center("Moisture Content In", Math.max(length, 50)));
        sb.append("\n");
        sb.append(StringUtils.center(txtFoodName.getText(), Math.max(length, 50)));
        sb.append("\n\n");
        sb.append("Initial weight is: ");
        sb.append(fInitialWeight);
        sb.append("\n");
        sb.append("Initial water weight is: ");
        sb.append(fInitialWaterWeight);
        sb.append("\n");
        sb.append("Dry matter weight is: ");
        sb.append(fDryMatterWeight);
        sb.append("\n");
        sb.append("Initial moisture content is: ");
        sb.append(fInitialMoistureContent);
        sb.append("%");
        sb.append("\n");
        txpInfo.setText(sb.toString());
        txtMC.setText(String.valueOf(mcm.getInitialMoistureContent()));
        pnl.setLayout(lyo);
        pnl.add(new JScrollPane(txpInfo), cc.xyw(1, 1, 2));
        pnl.add(lblMC, cc.xy(1, 2));
        pnl.add(txtMC, cc.xy(2, 2));

        int optionValue = Message.showOptionDialogOkCancel(inputs, "Moisture Content");

        if (optionValue == 0) {

            String s0 = txtMC.getText();

            if ((s0 != null && s0.length() > 0)) {

                checkNumber.addToUncheckedList(s0);

                if (checkNumber.pass()) {

                    BigDecimal finalMoistureContent = new BigDecimal(txtMC.getText());
                    mcm = new MoistureContentModifier(
                            initialWeight.doubleValue(),
                            initialWaterWeight.doubleValue(),
                            finalMoistureContent.doubleValue());
                    // model row index is specified by sql query.
                    BigDecimal finalWaterWeight = new BigDecimal(mcm.getFinalWaterWeight(), MathContext.DECIMAL128);
                    BigDecimal finalWeight = new BigDecimal(mcm.getFinalWeight(), MathContext.DECIMAL128);
                    tbl.setValueAt(finalWaterWeight, waterIndex, columnIndex);
                    tbl.setValueAt(finalWeight, weightIndex, columnIndex);
                    tbl.selectRow(waterIndex);
                    tbl.showRow(waterIndex);

                } else {

                    Message.showMessage("Numbers only");
                }
            }
        }
    }

    private JPanel getWizardPanel() {

        JPanel wizardPanel = new JPanel();
        FormLayout layout = new FormLayout(
                "min:grow,min,min,min,min,min,min,min:grow", // columns
                "min" // rows
                );
        wizardPanel.setLayout(layout);
        JButton btnProtein = new JButton("Protein");
        JButton btnFat = new JButton("Fat");
        JButton btnVitamins = new JButton("Vitamins");
        JButton btnCost = new JButton("Cost");
        JButton btnMoisture = new JButton("Moisture");
        JButton btnStandardPortion = new JButton("100g");
        wizardPanel.add(btnProtein, cc.xy(2, 1));
        wizardPanel.add(btnFat, cc.xy(3, 1));
        wizardPanel.add(btnVitamins, cc.xy(4, 1));
        wizardPanel.add(btnCost, cc.xy(5, 1));
        wizardPanel.add(btnMoisture, cc.xy(6, 1));
        wizardPanel.add(btnStandardPortion, cc.xy(7, 1));
        layout.setColumnGroup(2, 3, 4, 5);
        btnProtein.setToolTipText("Complete Protein calculator assistant");
        btnFat.setToolTipText("Fat calculator assistant");
        btnVitamins.setToolTipText("Vitamin and mineral values calculator assistant");
        btnCost.setToolTipText("Cost calculator assistant");
        btnMoisture.setToolTipText("Adjust moisture");
        btnStandardPortion.setToolTipText("Adjust food nutrient values to standard 100 gram portion");
        btnProtein.addActionListener((ActionEvent e) -> {
            fillCompleteProteinAmount();
        });
        btnFat.addActionListener((ActionEvent e) -> {
            fillFatAmount();
        });
        btnVitamins.addActionListener((ActionEvent e) -> {
            fillVitaminAmount();
        });
        btnCost.addActionListener((ActionEvent e) -> {
            fillCostAmount();
        });
        btnMoisture.addActionListener((ActionEvent e) -> {
            fillWaterAmount();
        });
        btnStandardPortion.addActionListener((ActionEvent e) -> {
            standardizeTo100g();
        });
        return wizardPanel;
    }

    private void fillCompleteProteinAmount() {

        JTextField txtProtein = new JTextField();
        JTextField txtCompleteProtein = new JTextField();
        JLabel lblProtein = new JLabel("Protein (g): ");
        JLabel lblCompleteProtein = new JLabel("Complete Protein (g): ");
        lblProtein.setHorizontalAlignment(SwingConstants.RIGHT);
        lblCompleteProtein.setHorizontalAlignment(SwingConstants.RIGHT);
        JPanel pnl = new JPanel();
        JComponent[] inputs = {pnl};
        FormLayout lyo = new FormLayout(
                "p,p", // columns
                "p,p" // rows
                );
        NumberCheck checkNumber = new NumberCheck();
        txtProtein.setPreferredSize(new Dimension(75, 28));
        txtCompleteProtein.setPreferredSize(new Dimension(75, 28));

        // model row index is specified by sql query.
        int columnIndex = 3;
        int proteinIndex = tbl.find("203");
        int completeProteinIndex = tbl.find("10001");
        BigDecimal protein = (BigDecimal) tbl.getValueAt(proteinIndex, columnIndex);
        BigDecimal completeProtein = (BigDecimal) tbl.getValueAt(completeProteinIndex, columnIndex);
        txtProtein.setText((new DecimalFormat("######0.0#################")).format(protein));
        txtCompleteProtein.setText((new DecimalFormat("######0.0#################")).format(completeProtein));

        pnl.setLayout(lyo);
        pnl.add(lblProtein, cc.xy(1, 1));
        pnl.add(txtProtein, cc.xy(2, 1));
        pnl.add(lblCompleteProtein, cc.xy(1, 2));
        pnl.add(txtCompleteProtein, cc.xy(2, 2));
        int optionValue = Message.showOptionDialogOkCancel(inputs, "Protein");

        if (optionValue == 0) {

            String s0 = txtProtein.getText();

            if ((s0 != null && s0.length() > 0)) {

                checkNumber.addToUncheckedList(s0);

                if (checkNumber.pass()) {

                    protein = new BigDecimal(txtProtein.getText());
                    completeProtein = new BigDecimal(txtCompleteProtein.getText());
                    // model row index is specified by sql query.
                    tbl.setValueAt(protein, proteinIndex, columnIndex);
                    tbl.setValueAt(completeProtein, completeProteinIndex, columnIndex);
                    tbl.selectRow(proteinIndex);
                    tbl.showRow(proteinIndex);

                } else {

                    Message.showMessage("Numbers only");
                }
            }
        }
    }

    private void fillFatAmount() {

        JLabel lblFat = new JLabel("Total Fat (g): ");
        JLabel lblSfa = new JLabel("Saturated Fat (g): ");
        JLabel lblMufa = new JLabel("Monounsaturated Fat (g): ");
        JLabel lblPufa = new JLabel("Polyunsaturated Fat (g): ");
        JTextField txtFat = new JTextField();
        JTextField txtSfa = new JTextField();
        JTextField txtMufa = new JTextField();
        JTextField txtPufa = new JTextField();
        StringBuilder sb = new StringBuilder();
        JPanel pnl = new JPanel();
        JComponent[] inputs = {pnl};
        FormLayout lyo = new FormLayout(
                "p,p", // columns
                "p,p,p,p" // rows
                );
        NumberCheck checkNumber = new NumberCheck();
        lblFat.setHorizontalAlignment(SwingConstants.RIGHT);
        lblSfa.setHorizontalAlignment(SwingConstants.RIGHT);
        lblMufa.setHorizontalAlignment(SwingConstants.RIGHT);
        lblPufa.setHorizontalAlignment(SwingConstants.RIGHT);
        txtFat.setPreferredSize(new Dimension(75, 28));
        txtSfa.setPreferredSize(new Dimension(75, 28));
        txtMufa.setPreferredSize(new Dimension(75, 28));
        txtPufa.setPreferredSize(new Dimension(75, 28));
        // model row index is specified by sql query.
        int columnIndex = 3;
        int fatIndex = tbl.find("204");
        int sfaIndex = tbl.find("606");
        int mufaIndex = tbl.find("645");
        int pufaIndex = tbl.find("646");
        BigDecimal fat = (BigDecimal) tbl.getValueAt(fatIndex, columnIndex);
        BigDecimal sfa = (BigDecimal) tbl.getValueAt(sfaIndex, columnIndex);
        BigDecimal mufa = (BigDecimal) tbl.getValueAt(mufaIndex, columnIndex);
        BigDecimal pufa = (BigDecimal) tbl.getValueAt(pufaIndex, columnIndex);
        txtFat.setText((new DecimalFormat("######0.0#################")).format(fat));
        txtSfa.setText((new DecimalFormat("######0.0#################")).format(sfa));
        txtMufa.setText((new DecimalFormat("######0.0#################")).format(mufa));
        txtPufa.setText((new DecimalFormat("######0.0#################")).format(pufa));
        pnl.setLayout(lyo);
        pnl.add(lblFat, cc.xy(1, 1));
        pnl.add(txtFat, cc.xy(2, 1));
        pnl.add(lblSfa, cc.xy(1, 2));
        pnl.add(txtSfa, cc.xy(2, 2));
        pnl.add(lblMufa, cc.xy(1, 3));
        pnl.add(txtMufa, cc.xy(2, 3));
        pnl.add(lblPufa, cc.xy(1, 4));
        pnl.add(txtPufa, cc.xy(2, 4));
        int optionValue = Message.showOptionDialogOkCancel(inputs, "Fat");

        if (optionValue == 0) {

            String s0 = txtFat.getText();
            String s1 = txtSfa.getText();
            String s2 = txtMufa.getText();
            String s3 = txtPufa.getText();

            if ((s0 != null && s0.length() > 0)
                    && (s1 != null && s1.length() > 0)
                    && (s2 != null && s2.length() > 0)
                    && (s3 != null && s3.length() > 0)) {

                checkNumber.addToUncheckedList(s0);

                if (checkNumber.pass()) {

                    fat = new BigDecimal(txtFat.getText());
                    sfa = new BigDecimal(txtSfa.getText());
                    mufa = new BigDecimal(txtMufa.getText());
                    pufa = new BigDecimal(txtPufa.getText());
                    // model row index is specified by sql query.
                    tbl.setValueAt(fat, fatIndex, columnIndex);
                    tbl.setValueAt(sfa, sfaIndex, columnIndex);
                    tbl.setValueAt(mufa, mufaIndex, columnIndex);
                    tbl.setValueAt(pufa, pufaIndex, columnIndex);
                    tbl.selectRow(fatIndex);
                    tbl.showRow(fatIndex);

                } else {

                    Message.showMessage("Numbers only");
                }
            }
        }
    }

    private void fillVitaminAmount() {

        FormLayout lyo = new FormLayout(
                "min:grow,min,30dlu", // columns
                "p,fill:p" // rows
                );
        JPanel pnl = new JPanel();
        JComponent[] inputs = {pnl};
        pnl.setLayout(lyo);
        ComboBox<LifeStageDO> cmbLifeStage = new ComboBox();
        ComboBox<NutrientDO> cmbNutrients = new ComboBox();
        JTextField txtDailyValuePct = new JTextField();
        NumberCheck checkNumber = new NumberCheck();
        String s0 = "";
        Double dvpct = -1.0;
        Double xgrams = -1.0;
        NutrientDO nutrientDO = null;

        try {

            Future<List<LifeStageDO>> task = BackgroundExec.submit(new LifestagesTask());
            List<LifeStageDO> lifestages = task.get();
            cmbLifeStage.reload(lifestages);
            cmbLifeStage.setSelectedIndex(8);

        } catch (Exception e) {

            LoggerImpl.INSTANCE.logProblem(e);
        }

        try {

            Future<List<NutrientDO>> task = BackgroundExec.submit(new DriNutrientsTask());
            List<NutrientDO> list = task.get();

            if (list.isEmpty()) {

                return;
            }

            cmbNutrients.reload(list);
            cmbNutrients.setSelectedIndex(13);

        } catch (Exception e) {

            LoggerImpl.INSTANCE.logProblem(e);
        }

        cmbLifeStage.setPreferredSize(new Dimension(0, 28));
        txtDailyValuePct.setPreferredSize(new Dimension(75, 28));
        pnl.add(cmbLifeStage, cc.xyw(1, 1, 3));
        pnl.add(cmbNutrients, cc.xy(1, 2));
        pnl.add(new JLabel(StringUtils.center("%DRI", 6)), cc.xy(2, 2));
        pnl.add(txtDailyValuePct, cc.xy(3, 2));
        int optionValue = Message.showOptionDialogOkCancel(inputs, "Percent of Daily Reference Intake (DRI) to Grams");

        if (optionValue == 0) {

            s0 = txtDailyValuePct.getText();

            if (s0 != null && s0.length() > 0) {

                try {

                    Future<List<DriDO>> task = BackgroundExec.submit(new LifestageDriTask(
                            cmbNutrients.getSelectedItem().getNutr_no(),
                            cmbLifeStage.getSelectedItem().getLifeStageId()));

                    List<DriDO> driDOlist = task.get();
                    DriDO driDO = driDOlist.get(0);
                    checkNumber.addToUncheckedList(s0);

                    if (checkNumber.pass()) {

                        nutrientDO = cmbNutrients.getSelectedItem();
                        dvpct = Double.valueOf(s0);
                        xgrams = dvpct * (driDO.getNutrientQ().doubleValue() / 100);
                        // model row index is specified by sql query.
                        int columnIndex = 3;
                        Integer vitaminIndex = tbl.find(nutrientDO.getNutr_no());
                        tbl.setValueAt(new BigDecimal(xgrams, MathContext.DECIMAL32), vitaminIndex, columnIndex);
                        tbl.selectRow(vitaminIndex);
                        tbl.showRow(vitaminIndex);

                    } else {

                        Message.showMessage("Numbers only");
                    }

                } catch (Exception e) {

                    LoggerImpl.INSTANCE.logProblem(e);
                }
            }
        }
    }

    private void fillCostAmount() {

        JLabel lblPrice = new JLabel("Product price ($): ");
        JLabel lblWeight = new JLabel("Product net weight (g): ");
        JTextField txtPrice = new JTextField();
        JTextField txtWeight = new JTextField();
        JPanel pnl = new JPanel();
        JComponent[] inputs = {pnl};
        FormLayout lyo = new FormLayout(
                "p,p", // columns
                "p,p" // rows
                );
        lblPrice.setHorizontalAlignment(SwingConstants.RIGHT);
        lblWeight.setHorizontalAlignment(SwingConstants.RIGHT);
        txtPrice.setPreferredSize(new Dimension(75, 28));
        txtWeight.setPreferredSize(new Dimension(75, 28));
        NumberCheck checkNumber = new NumberCheck();
        pnl.setLayout(lyo);
        pnl.add(lblPrice, cc.xy(1, 1));
        pnl.add(txtPrice, cc.xy(2, 1));
        pnl.add(lblWeight, cc.xy(1, 2));
        pnl.add(txtWeight, cc.xy(2, 2));

        int optionValue = Message.showOptionDialogOkCancel(inputs, "Cost");

        if (optionValue == 0) {

            String s0 = txtPrice.getText();
            String s1 = txtWeight.getText();

            if ((s0 != null && s0.length() > 0) && (s1 != null && s1.length() > 0)) {

                checkNumber.addToUncheckedList(s0);

                if (checkNumber.pass()) {

                    double productPrice = Double.parseDouble(txtPrice.getText());
                    double productWeight = Double.parseDouble(txtWeight.getText());
                    // model row index is specified by sql query.
                    int columnIndex = 3;
                    int weightIndex = tbl.find("10000");
                    int costIndex = tbl.find("10005");
                    BigDecimal weight = (BigDecimal) tbl.getValueAt(weightIndex, columnIndex);
                    double cost = (productPrice / productWeight) * weight.doubleValue();
                    tbl.setValueAt(new BigDecimal(cost, MathContext.DECIMAL32), costIndex, columnIndex);
                    tbl.selectRow(costIndex);
                    tbl.showRow(costIndex);

                } else {

                    Message.showMessage("Numbers only");
                }
            }
        }
    }

    public Food getFood() {

        Food food = new Food();
        food.setFoodName(txtFoodName.getText());
        int rowNo = tbl.getRowCount();

        for (int j = 0; j < rowNo; j++) {

            String nutrientid = (String) tbl.getValueAt(j, 0);
            BigDecimal q = (BigDecimal) tbl.getValueAt(j, 3);

            switch (nutrientid) {
                case "203":
                    food.setProtein_total_nutr_no(nutrientid);
                    food.setProtein_total_quantity(q);
                    break;

                case "204":
                    food.setFats_total_nutr_no(nutrientid);
                    food.setFats_total_quantity(q);
                    break;

                case "205":
                    food.setCarbohydrates_carbs_by_diff_nutr_no(nutrientid);
                    food.setCarbohydrates_carbs_by_diff_quantity(q);
                    break;

                case "208":
                    food.setEnergy_gross_nutr_no(nutrientid);
                    food.setEnergy_gross_quantity(q);
                    break;

                case "209":
                    food.setCarbohydrates_starch_nutr_no(nutrientid);
                    food.setCarbohydrates_starch_quantity(q);
                    break;

                case "210":
                    food.setCarbohydrates_sucrose_nutr_no(nutrientid);
                    food.setCarbohydrates_sucrose_quantity(q);
                    break;

                case "211":
                    food.setCarbohydrates_glucose_nutr_no(nutrientid);
                    food.setCarbohydrates_glucose_quantity(q);
                    break;

                case "212":
                    food.setCarbohydrates_fructose_nutr_no(nutrientid);
                    food.setCarbohydrates_fructose_quantity(q);
                    break;

                case "213":
                    food.setCarbohydrates_lactose_nutr_no(nutrientid);
                    food.setCarbohydrates_lactose_quantity(q);
                    break;

                case "221":
                    food.setOther_alcohol_nutr_no(nutrientid);
                    food.setOther_alcohol_quantity(q);
                    break;

                case "255":
                    food.setOther_water_nutr_no(nutrientid);
                    food.setOther_water_quantity(q);
                    break;

                case "262":
                    food.setPhytonutrients_caffeine_nutr_no(nutrientid);
                    food.setPhytonutrients_caffeine_quantity(q);
                    break;

                case "263":
                    food.setPhytonutrients_theobromine_nutr_no(nutrientid);
                    food.setPhytonutrients_theobromine_quantity(q);
                    break;

                case "269":
                    food.setCarbohydrates_sugars_nutr_no(nutrientid);
                    food.setCarbohydrates_sugars_quantity(q);
                    break;

                case "291":
                    food.setCarbohydrates_fiber_nutr_no(nutrientid);
                    food.setCarbohydrates_fiber_quantity(q);
                    break;

                case "301":
                    food.setMinerals_calcium_nutr_no(nutrientid);
                    food.setMinerals_calcium_quantity(q);
                    break;

                case "303":
                    food.setMinerals_iron_nutr_no(nutrientid);
                    food.setMinerals_iron_quantity(q);
                    break;

                case "304":
                    food.setMinerals_magnesium_nutr_no(nutrientid);
                    food.setMinerals_magnesium_quantity(q);
                    break;

                case "305":
                    food.setMinerals_phosphorus_nutr_no(nutrientid);
                    food.setMinerals_phosphorus_quantity(q);
                    break;

                case "306":
                    food.setMinerals_potassium_nutr_no(nutrientid);
                    food.setMinerals_potassium_quantity(q);
                    break;

                case "307":
                    food.setMinerals_sodium_nutr_no(nutrientid);
                    food.setMinerals_sodium_quantity(q);
                    break;

                case "309":
                    food.setMinerals_zinc_nutr_no(nutrientid);
                    food.setMinerals_zinc_quantity(q);
                    break;

                case "312":
                    food.setMinerals_copper_nutr_no(nutrientid);
                    food.setMinerals_copper_quantity(q);
                    break;

                case "315":
                    food.setMinerals_manganese_nutr_no(nutrientid);
                    food.setMinerals_manganese_quantity(q);
                    break;

                case "317":
                    food.setMinerals_selenium_nutr_no(nutrientid);
                    food.setMinerals_selenium_quantity(q);
                    break;

                case "320":
                    food.setVitamins_vitamin_a_nutr_no(nutrientid);
                    food.setVitamins_vitamin_a_quantity(q);
                    break;

                case "321":
                    food.setPhytonutrients_beta_carotene_nutr_no(nutrientid);
                    food.setPhytonutrients_beta_carotene_quantity(q);
                    break;

                case "323":
                    food.setVitamins_vitamin_e_nutr_no(nutrientid);
                    food.setVitamins_vitamin_e_quantity(q);
                    break;

                case "328":
                    food.setVitamins_vitamin_d_nutr_no(nutrientid);
                    food.setVitamins_vitamin_d_quantity(q);
                    break;

                case "337":
                    food.setPhytonutrients_lycopene_nutr_no(nutrientid);
                    food.setPhytonutrients_lycopene_quantity(q);
                    break;

                case "338":
                    food.setPhytonutrients_lutein_zeaxanthin_nutr_no(nutrientid);
                    food.setPhytonutrients_lutein_zeaxanthin_quantity(q);
                    break;

                case "342":
                    food.setPhytonutrients_gamma_tocopherol_nutr_no(nutrientid);
                    food.setPhytonutrients_gamma_tocopherol_quantity(q);
                    break;

                case "401":
                    food.setVitamins_vitamin_c_nutr_no(nutrientid);
                    food.setVitamins_vitamin_c_quantity(q);
                    break;

                case "404":
                    food.setVitamins_thiamin_nutr_no(nutrientid);
                    food.setVitamins_thiamin_quantity(q);
                    break;

                case "405":
                    food.setVitamins_riboflavin_nutr_no(nutrientid);
                    food.setVitamins_riboflavin_quantity(q);
                    break;

                case "406":
                    food.setVitamins_niacin_nutr_no(nutrientid);
                    food.setVitamins_niacin_quantity(q);
                    break;

                case "410":
                    food.setVitamins_pantothenic_acid_nutr_no(nutrientid);
                    food.setVitamins_pantothenic_acid_quantity(q);
                    break;

                case "415":
                    food.setVitamins_vitamin_b6_nutr_no(nutrientid);
                    food.setVitamins_vitamin_b6_quantity(q);
                    break;

                case "418":
                    food.setVitamins_vitamin_b12_nutr_no(nutrientid);
                    food.setVitamins_vitamin_b12_quantity(q);
                    break;

                case "421":
                    food.setVitamins_choline_nutr_no(nutrientid);
                    food.setVitamins_choline_quantity(q);
                    break;

                case "430":
                    food.setVitamins_vitamin_k_nutr_no(nutrientid);
                    food.setVitamins_vitamin_k_quantity(q);
                    break;

                case "435":
                    food.setVitamins_folate_nutr_no(nutrientid);
                    food.setVitamins_folate_quantity(q);
                    break;

                case "601":
                    food.setFats_cholesterol_nutr_no(nutrientid);
                    food.setFats_cholesterol_quantity(q);
                    break;

                case "606":
                    food.setFats_saturated_nutr_no(nutrientid);
                    food.setFats_saturated_quantity(q);
                    break;

                case "611":
                    food.setFats_lauric_nutr_no(nutrientid);
                    food.setFats_lauric_quantity(q);
                    break;

                case "612":
                    food.setFats_myristic_nutr_no(nutrientid);
                    food.setFats_myristic_quantity(q);
                    break;

                case "613":
                    food.setFats_palmitic_nutr_no(nutrientid);
                    food.setFats_palmitic_quantity(q);
                    break;

                case "614":
                    food.setFats_stearic_nutr_no(nutrientid);
                    food.setFats_stearic_quantity(q);
                    break;

                case "618":
                    food.setFats_linoleic_nutr_no(nutrientid);
                    food.setFats_linoleic_quantity(q);
                    break;

                case "619":
                    food.setFats_linolenic_nutr_no(nutrientid);
                    food.setFats_linolenic_quantity(q);
                    break;

                case "621":
                    food.setFats_dha_nutr_no(nutrientid);
                    food.setFats_dha_quantity(q);
                    break;

                case "629":
                    food.setFats_epa_nutr_no(nutrientid);
                    food.setFats_epa_quantity(q);
                    break;

                case "636":
                    food.setPhytonutrients_phytosterols_nutr_no(nutrientid);
                    food.setPhytonutrients_phytosterols_quantity(q);
                    break;

                case "645":
                    food.setFats_monounsaturated_nutr_no(nutrientid);
                    food.setFats_monounsaturated_quantity(q);
                    break;

                case "646":
                    food.setFats_polyunsaturated_nutr_no(nutrientid);
                    food.setFats_polyunsaturated_quantity(q);
                    break;

                case "10000":
                    food.setOther_weight_nutr_no(nutrientid);
                    food.setOther_weight_quantity(q);
                    break;

                case "10001":
                    food.setProtein_complete_nutr_no(nutrientid);
                    food.setProtein_complete_quantity(q);
                    break;

                case "10005":
                    food.setOther_cost_nutr_no(nutrientid);
                    food.setOther_cost_quantity(q);
                    break;

                case "10006":
                    food.setCarbohydrates_glycemic_load_nutr_no(nutrientid);
                    food.setCarbohydrates_glycemic_load_quantity(q);
                    break;

                case "10017":
                    food.setCarbohydrates_fiber_soluble_nutr_no(nutrientid);
                    food.setCarbohydrates_fiber_soluble_quantity(q);
                    break;

                case "10018":
                    food.setCarbohydrates_fiber_insoluble_nutr_no(nutrientid);
                    food.setCarbohydrates_fiber_insoluble_quantity(q);
                    break;

                case "10019":
                    food.setPhytonutrients_carotenoids_nutr_no(nutrientid);
                    food.setPhytonutrients_carotenoids_quantity(q);
                    break;

                case "10020":
                    food.setPhytonutrients_flavonols_nutr_no(nutrientid);
                    food.setPhytonutrients_flavonols_quantity(q);
                    break;

                case "10021":
                    food.setPhytonutrients_flavones_nutr_no(nutrientid);
                    food.setPhytonutrients_flavones_quantity(q);
                    break;

                case "10022":
                    food.setPhytonutrients_flavanols_nutr_no(nutrientid);
                    food.setPhytonutrients_flavanols_quantity(q);
                    break;

                case "10023":
                    food.setPhytonutrients_flavanones_nutr_no(nutrientid);
                    food.setPhytonutrients_flavanones_quantity(q);
                    break;

                case "10024":
                    food.setPhytonutrients_anthocyanins_nutr_no(nutrientid);
                    food.setPhytonutrients_anthocyanins_quantity(q);
                    break;

                case "10025":
                    food.setPhytonutrients_isoflavones_nutr_no(nutrientid);
                    food.setPhytonutrients_isoflavones_quantity(q);
                    break;

                case "10026":
                    food.setPhytonutrients_flavonoids_nutr_no(nutrientid);
                    food.setPhytonutrients_flavonoids_quantity(q);
                    break;
            }
        }

        return food;
    }

    public void setFoodName(String name) {

        txtFoodName.setText(name);
    }

    private void standardizeTo100g() {
        int columnIndex = 3;
        int weightIndex = tbl.find("10000");
        BigDecimal weight = (BigDecimal) tbl.getValueAt(weightIndex, columnIndex);
        if (weight.compareTo(new BigDecimal("0.0")) <= 0) {
            return;
        }
        int rows = tbl.getModel().getRowCount();
        for (int i = 0; i < rows; i++) {
            BigDecimal value = (BigDecimal) tbl.getValueAt(i, columnIndex);
            BigDecimal result = value.divide(weight, 18, RoundingMode.HALF_UP).multiply(new BigDecimal("100"));
            tbl.setValueAt(result, i, columnIndex);
        }
        tbl.showRow(weightIndex);
        tbl.selectRow(weightIndex);
    }
}
