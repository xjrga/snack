package org.xjrga.snack2.gui;

import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;
import org.xjrga.snack2.data.DbLink;
import org.xjrga.snack2.data.Nutrient;
import org.xjrga.snack2.dataobject.*;
import org.xjrga.snack2.lp.LpModel;
import org.xjrga.snack2.model.*;
import org.xjrga.snack2.other.*;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableRowSorter;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import org.xjrga.looks.Dawn;

public class Main {
    private final BufferedImage logo = ImageUtilities.readImage("resources/images/apple.png");
    private final CellConstraints cc = new CellConstraints();
    private final DbLink dbLink = new DbLink();
    private final ComboBoxModelFood modelComboBox_1_FoodAtFoodNutrientRatio = new ComboBoxModelFood(dbLink);
    private final ComboBoxModelFood modelComboBox_0_FoodAtFoodNutrientRatio = new ComboBoxModelFood(dbLink);
    private final ComboBoxModelFood modelComboBox_FoodAtNutrient = new ComboBoxModelFood(dbLink);
    private final ComboBoxModelFood modelComboBox_FoodAtNutrientPct = new ComboBoxModelFood(dbLink);
    private final ComboBoxModelLifeStage modelComboBoxLifeStage = new ComboBoxModelLifeStage(dbLink);
    private final ComboBoxModelNutrients modelComboBox_1_NutrientAtFoodNutrientRatio = new ComboBoxModelNutrients(dbLink);
    private final ComboBoxModelNutrients modelComboBox_1_NutrientAtNutrientRatio = new ComboBoxModelNutrients(dbLink);
    private final ComboBoxModelNutrients modelComboBox_0_NutrientAtFoodNutrientRatio = new ComboBoxModelNutrients(dbLink);
    private final ComboBoxModelNutrients modelComboBox_0_NutrientAtNutrientRatio = new ComboBoxModelNutrients(dbLink);
    private final ComboBoxModelNutrients modelComboBox_NutrientAtNutrientConstraint = new ComboBoxModelNutrients(dbLink);
    private final ComboBoxModelNutrients modelComboBox_NutrientAtNutrientPctContraint = new ComboBoxModelNutrients(dbLink);
    private final ComboBoxModelNutrientsAll modelComboBox_NutrientLookupListNutrient = new ComboBoxModelNutrientsAll(dbLink);
    private final ComboBoxModelNutrientsConvert modelComboBox_NutrientLookupListConvert = new ComboBoxModelNutrientsConvert(dbLink);
    private final ComboBoxModelRelationships modelComboBox_RelationshipAtFoodNutrient = new ComboBoxModelRelationships(dbLink);
    private final ComboBoxModelRelationships modelComboBox_RelationshipAtNutrient = new ComboBoxModelRelationships(dbLink);
    private final DefaultListModel modelListHighScore = new DefaultListModel();
    private final JButton buttonCategoriesAdd = new JButton("+");
    private final JButton buttonCategoriesDelete = new JButton("-");
    private final JButton buttonCategoriesRename = new JButton("u");
    private final JButton buttonFoodListAdd = new JButton("+");
    private final JButton buttonFoodListDelete = new JButton("-");
    private final JButton buttonFoodListUpdate = new JButton("u");
    private final JButton buttonFoodListDuplicate = new JButton("d");
    private final JButton buttonFoodNutrientConstraintAdd = new JButton("+");
    private final JButton buttonFoodNutrientConstraintDelete = new JButton("-");
    private final JButton buttonFoodNutrientRatioAdd = new JButton("+");
    private final JButton buttonFoodNutrientRatioDelete = new JButton("-");
    private final JButton buttonNutrientConstraintAdd = new JButton("+");
    private final JButton buttonNutrientConstraintDelete = new JButton("-");
    private final JButton buttonNutrientLookupListRun = new JButton("Run");
    private final JButton buttonNutrientRatioAdd = new JButton("+");
    private final JButton buttonNutrientRatioDelete = new JButton("-");
    private final JButton buttonPercentNutrientConstraintAdd = new JButton("+");
    private final JButton buttonPercentNutrientConstraintDelete = new JButton("-");
    private final JCheckBox checkBoxAlcohol = new JCheckBox();
    private final JCheckBox checkBoxAlphaLinolenic = new JCheckBox();
    private final JCheckBox checkBoxCalcium = new JCheckBox();
    private final JCheckBox checkBoxCholesterol = new JCheckBox();
    private final JCheckBox checkBoxCholine = new JCheckBox();
    private final JCheckBox checkBoxCompleteProtein = new JCheckBox();
    private final JCheckBox checkBoxCopper = new JCheckBox();
    private final JCheckBox checkBoxCost = new JCheckBox();
    private final JCheckBox checkBoxDHA = new JCheckBox();
    private final JCheckBox checkBoxDigestibleCarbs = new JCheckBox();
    private final JCheckBox checkBoxEnergy = new JCheckBox();
    private final JCheckBox checkBoxEPA = new JCheckBox();
    private final JCheckBox checkBoxFat = new JCheckBox();
    private final JCheckBox checkBoxFiber = new JCheckBox();
    private final JCheckBox checkBoxFluoride = new JCheckBox();
    private final JCheckBox checkBoxFolate = new JCheckBox();
    private final JCheckBox checkBoxFructose = new JCheckBox();
    private final JCheckBox checkBoxIncompleteProtein = new JCheckBox();
    private final JCheckBox checkBoxIron = new JCheckBox();
    private final JCheckBox checkBoxLactose = new JCheckBox();
    private final JCheckBox checkBoxLinoleic = new JCheckBox();
    private final JCheckBox checkBoxMagnesium = new JCheckBox();
    private final JCheckBox checkBoxManganese = new JCheckBox();
    private final JCheckBox checkBoxMonounsaturated = new JCheckBox();
    private final JCheckBox checkBoxNiacin = new JCheckBox();
    private final JCheckBox checkBoxPantothenic = new JCheckBox();
    private final JCheckBox checkBoxPhosphorus = new JCheckBox();
    private final JCheckBox checkBoxPolyunsaturated = new JCheckBox();
    private final JCheckBox checkBoxPotassium = new JCheckBox();
    private final JCheckBox checkBoxProtein = new JCheckBox();
    private final JCheckBox checkBoxResultRoundUp = new JCheckBox();
    private final JCheckBox checkBoxRiboflavin = new JCheckBox();
    private final JCheckBox checkBoxSaturated = new JCheckBox();
    private final JCheckBox checkBoxSelenium = new JCheckBox();
    private final JCheckBox checkBoxSodium = new JCheckBox();
    private final JCheckBox checkBoxSucrose = new JCheckBox();
    private final JCheckBox checkBoxThiamin = new JCheckBox();
    private final JCheckBox checkBoxVitaminA = new JCheckBox();
    private final JCheckBox checkBoxVitaminB6 = new JCheckBox();
    private final JCheckBox checkBoxVitaminB12 = new JCheckBox();
    private final JCheckBox checkBoxVitaminC = new JCheckBox();
    private final JCheckBox checkBoxVitaminD = new JCheckBox();
    private final JCheckBox checkBoxVitaminE = new JCheckBox();
    private final JCheckBox checkBoxVitaminK = new JCheckBox();
    private final JCheckBox checkBoxWater = new JCheckBox();
    private final JCheckBox checkBoxWeight = new JCheckBox();
    private final JCheckBox checkBoxZinc = new JCheckBox();
    private final JCheckBox checkBoxFiberInsoluble = new JCheckBox();
    private final JCheckBox checkBoxFiberSoluble = new JCheckBox();
    private final JCheckBox checkBoxGlycemicLoad = new JCheckBox();
    private final JComboBox comboBoxFoodNutrientConstraintFood = new JComboBox();
    private final JComboBox comboBoxFoodNutrientConstraintNutrient = new JComboBox();
    private final JComboBox comboBoxFoodNutrientConstraintRelationship = new JComboBox();
    private final JComboBox comboBoxFoodNutrientRatioFoodA = new JComboBox();
    private final JComboBox comboBoxFoodNutrientRatioFoodB = new JComboBox();
    private final JComboBox comboBoxFoodNutrientRatioNutrientA = new JComboBox();
    private final JComboBox comboBoxFoodNutrientRatioNutrientB = new JComboBox();
    private final JComboBox comboBoxLifeStage = new JComboBox();
    private final JComboBox comboBoxNutrientConstraintNutrient = new JComboBox();
    private final JComboBox comboBoxNutrientConstraintRelationship = new JComboBox();
    private final JComboBox comboBoxNutrientLookupListNutrient = new JComboBox();
    private final JComboBox comboBoxNutrientRatioNutrientA = new JComboBox();
    private final JComboBox comboBoxNutrientRatioNutrientB = new JComboBox();
    private final JComboBox comboBoxPercentNutrientConstraintFood = new JComboBox();
    private final JComboBox comboBoxPercentNutrientConstraintNutrient = new JComboBox();
    private final JFrame frameSnack = new JFrame();
    private final JList listAllFoodItems = new JList();
    private final JList listCategories = new JList();
    private final JList listCompareA = new JList();
    private final JList listCompareB = new JList();
    private final JList listFoodInCategory = new JList();
    private final JList listHighScore = new JList();
    private final JList listMixes = new JList();
    private final JList listMixesJournal = new JList();
    private final JList listRdaCheck = new JList();
    private final JList listSelectedFood = new JList();
    private final JMenu menuData = new JMenu();
    private final JMenu menuExport = new JMenu();
    private final JMenu menuHelp = new JMenu();
    private final JMenu menuProgram = new JMenu();
    private final JMenu menuSettings = new JMenu();
    private final JMenu menuTools = new JMenu();
    private final JMenuItem menuItemAbout = new JMenuItem();
    private final JMenuItem menuItemMicronutrientConversion = new JMenuItem();
    private final JMenuItem menuItemBmr = new JMenuItem();
    private final JMenuItem menuItemNitrogenBalance = new JMenuItem();
    private final JMenuItem menuItemKetosis = new JMenuItem();
    private final JMenuItem menuItemGlycemicIndexRange = new JMenuItem();
    private final JMenuItem menuItemDigestibleCarbs = new JMenuItem();
    private final JMenuItem menuItemGlycemicLoad = new JMenuItem();
    private final JMenuItem menuItemConstraintsShownInList = new JMenuItem();
    private final JMenuItem menuItemCredits = new JMenuItem();
    private final JMenuItem menuItemExit = new JMenuItem();
    private final JMenuItem menuItemExportFoodList = new JMenuItem();
    private final JMenuItem menuItemExportFoodMixes = new JMenuItem();
    private final JMenuItem menuItemExportMixCompare = new JMenuItem();
    private final JMenuItem menuItemExportNutrientLookup = new JMenuItem();
    private final JMenuItem menuItemExportRdaCompare = new JMenuItem();
    private final JMenuItem menuItemGuide = new JMenuItem();
    private final JPanel panelStatusBar = new JPanel();
    private final JTable tableGlycemic = new JTable();
    private final JTable tableCarbs = new JTable();
    private final JTable tableCheckCoefficients = new JTable();
    private final JTable tableCost = new JTable();
    private final JTable tableEnergy = new JTable();
    private final JTable tableFat = new JTable();
    private final JTable tableFoodList = new JTable();
    private final JTable tableFoodNutrientConstraint = new JTable();
    private final JTable tableFoodNutrientRatio = new JTable();
    private final JTable tableJournal = new JTable();
    private final JTable tableMinerals = new JTable();
    private final JTable tableElectrolytes = new JTable();
    private final JTable tableNutrientConstraint = new JTable();
    private final JTable tableNutrientInput = new JTable();
    private final JTable tableNutrientLookup = new JTable();
    private final JTable tableNutrientRatio = new JTable();
    private final JTable tableNutrientPercentConstraint = new JTable();
    private final JTable tableProtein = new JTable();
    private final JTable tableVitamins = new JTable();
    private final JTable tableWater = new JTable();
    private final JTextArea textAreaLPModel = new JTextArea();
    private final JTextArea textAreaNote = new JTextArea();
    private final JTextField textFieldFoodListSearch = new JTextField();
    private final JTextField textFieldFoodNutrientConstraintQuantity = new JTextField();
    private final JTextField textFieldFoodNutrientRatioQuantityA = new JTextField();
    private final JTextField textFieldFoodNutrientRatioQuantityB = new JTextField();
    private final JTextField textFieldNutrientConstraintQuantity = new JTextField();
    private final JTextField textFieldNutrientLookup = new JTextField();
    private final JTextField textFieldNutrientRatioNutrientA = new JTextField();
    private final JTextField textFieldNutrientRatioNutrientB = new JTextField();
    private final JTextField textFieldNutrientSearch = new JTextField();
    private final JTextField textFieldNutrientSearchCheckCoefficients = new JTextField();
    private final JTextField textFieldPercentNutrientConstraintQuantity = new JTextField();
    private final JTree treeFoodList = new JTree();
    private final LinkedHashMap<String, JCheckBox> mapConstraintCheckboxes;
    private final ListModelCategory modelListCategory = new ListModelCategory(dbLink);
    private final ListModelFood modelListFood = new ListModelFood(dbLink);
    private final ListModelFood2 modelListFoodInCategory = new ListModelFood2(dbLink);
    private final ListModelMix modelList_A_MixDiff = new ListModelMix(dbLink);
    private final ListModelMix modelList_B_MixDiff = new ListModelMix(dbLink);
    private final ListModelMix modelListFoodJournal = new ListModelMix(dbLink);
    private final ListModelMix modelListRda = new ListModelMix(dbLink);
    private final ListModelMix1 modelList_Solve = new ListModelMix1(dbLink);
    private final ListModelSelectedFood modelListSelectedFood = new ListModelSelectedFood(dbLink);
    private final StringModelMixPct stringModelMixPct = new StringModelMixPct(dbLink);
    private final TableModelCarbs modelTableCarbs = new TableModelCarbs(dbLink);
    private final TableModelGlycemic modelTableGlycemic = new TableModelGlycemic(dbLink);
    private final TableModelCheckCoefficients modelTableCheckCoefficients = new TableModelCheckCoefficients(dbLink);
    private final TableModelCost modelTableCost = new TableModelCost(dbLink);
    private final TableModelDataInput modelTableNutrientInput = new TableModelDataInput(dbLink);
    private final TableModelEnergy modelTableEnergy = new TableModelEnergy(dbLink);
    private final TableModelFat modelTableFat = new TableModelFat(dbLink);
    private final TableModelFoodList modelTableFoodList = new TableModelFoodList(dbLink);
    private final TableModelFoodNutrientConstraints modelTableFoodNutrientConstraints = new TableModelFoodNutrientConstraints(dbLink);
    private final TableModelFoodNutrientRatioConstraints modelTableFoodNutrientRatioConstraints = new TableModelFoodNutrientRatioConstraints(dbLink);
    private final TableModelJournal modelTableFoodJournal = new TableModelJournal(dbLink);
    private final TableModelMinerals modelTableMinerals = new TableModelMinerals(dbLink);
    private final TableModelElectrolytes modelTableElectrolytes = new TableModelElectrolytes(dbLink);
    private final TableModelMixComparison modelTableMixDiff = new TableModelMixComparison(dbLink);
    private final TableModelNutrientConstraints modelTableNutrientConstraints = new TableModelNutrientConstraints(dbLink);
    private final TableModelNutrientLookup modelTableNutrientLookup = new TableModelNutrientLookup(dbLink);
    private final TableModelNutrientRatioConstraints modelTableNutrientRatioConstraints = new TableModelNutrientRatioConstraints(dbLink);
    private final TableModelPercentNutrientConstraints tableModelPercentNutrientConstraints = new TableModelPercentNutrientConstraints(dbLink);
    private final TableModelProtein modelTableProtein = new TableModelProtein(dbLink);
    private final TableModelRdaCheck modelTableRda = new TableModelRdaCheck(dbLink);
    private final TableModelResults modelResultsTable = new TableModelResults(dbLink);
    private final TableModelVitamins modelTableVitamins = new TableModelVitamins(dbLink);
    private final TableModelWater modelTableWater = new TableModelWater(dbLink);
    private final TableRowSorter tableSorterCheckCoefficients = new TableRowSorter<>(modelTableCheckCoefficients);
    private final TableRowSorter tableSorterFoodList = new TableRowSorter<>(modelTableFoodList);
    private final TableRowSorter tableSorterNutrientInput = new TableRowSorter<>(modelTableNutrientInput);
    private final TreeModelFood modelTreeFoodList = new TreeModelFood(dbLink);
    private JTable tableMixComparison;
    private JTable tableRdaCheck;
    private String foodNameText;

    public Main() {
        FormLayout layout = new FormLayout("min:grow", //columns
                "fill:min:grow,1dlu,min" //rows
        );
        frameSnack.setIconImage(logo);
        frameSnack.setJMenuBar(getMenuBar());
        JTabbedPane mainTabbedPane = new JTabbedPane();
        mainTabbedPane.setTabPlacement(JTabbedPane.BOTTOM);
        mainTabbedPane.add(getSolve());
        mainTabbedPane.add(getFoodList());
        mainTabbedPane.add(getCategories());
        mainTabbedPane.add(getFoodJournal());
        mainTabbedPane.add(getMixComparison());
        mainTabbedPane.add(getRdaCheck());
        mainTabbedPane.add(getNutrientLookupList());
        mainTabbedPane.setTitleAt(0, "Solve");
        mainTabbedPane.setToolTipTextAt(0, "Specify your mix problem here");
        mainTabbedPane.setTitleAt(1, "Food List");
        mainTabbedPane.setToolTipTextAt(1, "This is your list of favorite food items");
        mainTabbedPane.setTitleAt(2, "Food Category");
        mainTabbedPane.setToolTipTextAt(2, "This is your list of food categories");
        mainTabbedPane.setTitleAt(3, "Food Journal");
        mainTabbedPane.setToolTipTextAt(3, "This is your list of mixes");
        mainTabbedPane.setTitleAt(4, "Mix Comparison");
        mainTabbedPane.setToolTipTextAt(4, "This is where you compare mixes");
        mainTabbedPane.setTitleAt(5, "RDA Check");
        mainTabbedPane.setToolTipTextAt(5, "This is where you compare mix against the Dietary Reference Intake");
        mainTabbedPane.setTitleAt(6, "Nutrient Lookup");
        mainTabbedPane.setToolTipTextAt(6, "This is where you find food items that provide a specific nutrient");
        JPanel panelF = new JPanel();
        panelF.setLayout(layout);
        panelF.add(mainTabbedPane, cc.xy(1, 1));
        panelStatusBar.setBorder(new LineBorder(Color.GRAY));
        panelStatusBar.add(new Label(""));
        panelF.add(panelStatusBar, cc.xy(1, 3));
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(panelF);
        frameSnack.add(scrollPane);
        frameSnack.setDefaultCloseOperation(3);
        Dimension size = new Dimension(1435, 897);
        frameSnack.setSize(size);
        frameSnack.setVisible(true);
        frameSnack.setTitle("Snack");
        frameSnack.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                event_menuItemExit();
            }
        });
        reloadLifeStageComboBox();
        reloadNutrientComboBoxes();
        reloadRelationshipComboBoxes();
        reloadMixes();
        reloadTableModelConstraints(-1);
        resizeColumns();
        checkBoxCompleteProtein.setName("CompleteProtein");
        checkBoxIncompleteProtein.setName("IncompleteProtein");
        checkBoxProtein.setName("Protein");
        checkBoxFat.setName("Fat");
        checkBoxCholesterol.setName("Cholesterol");
        checkBoxSaturated.setName("Saturated");
        checkBoxDHA.setName("DHA");
        checkBoxEPA.setName("EPA");
        checkBoxMonounsaturated.setName("Monounsaturated");
        checkBoxPolyunsaturated.setName("Polyunsaturated");
        checkBoxLinoleic.setName("Linoleic");
        checkBoxAlphaLinolenic.setName("AlphaLinolenic");
        checkBoxDigestibleCarbs.setName("DigestibleCarbs");
        checkBoxSucrose.setName("Sucrose");
        checkBoxFructose.setName("Fructose");
        checkBoxLactose.setName("Lactose");
        checkBoxFiber.setName("Fiber");
        checkBoxVitaminA.setName("VitaminA");
        checkBoxVitaminE.setName("VitaminE");
        checkBoxVitaminD.setName("VitaminD");
        checkBoxVitaminC.setName("VitaminC");
        checkBoxThiamin.setName("Thiamin");
        checkBoxRiboflavin.setName("Riboflavin");
        checkBoxNiacin.setName("Niacin");
        checkBoxPantothenic.setName("Pantothenic");
        checkBoxVitaminB6.setName("VitaminB6");
        checkBoxVitaminB12.setName("VitaminB12");
        checkBoxCholine.setName("Choline");
        checkBoxVitaminK.setName("VitaminK");
        checkBoxFolate.setName("Folate");
        checkBoxCalcium.setName("Calcium");
        checkBoxIron.setName("Iron");
        checkBoxMagnesium.setName("Magnesium");
        checkBoxPhosphorus.setName("Phosphorus");
        checkBoxPotassium.setName("Potassium");
        checkBoxSodium.setName("Sodium");
        checkBoxZinc.setName("Zinc");
        checkBoxCopper.setName("Copper");
        checkBoxFluoride.setName("Fluoride");
        checkBoxManganese.setName("Manganese");
        checkBoxSelenium.setName("Selenium");
        checkBoxWeight.setName("Weight");
        checkBoxCost.setName("Cost");
        checkBoxEnergy.setName("Energy");
        checkBoxAlcohol.setName("Alcohol");
        checkBoxWater.setName("Water");
        checkBoxFiberInsoluble.setName("Insoluble Fiber");
        checkBoxFiberSoluble.setName("Soluble Fiber");
        checkBoxGlycemicLoad.setName("Glycemic Load");
        mapConstraintCheckboxes = new LinkedHashMap<>();
        mapConstraintCheckboxes.put(Nutrient.COMPLETEPROTEIN.getNumber(), checkBoxCompleteProtein);
        mapConstraintCheckboxes.put(Nutrient.INCOMPLETEPROTEIN.getNumber(), checkBoxIncompleteProtein);
        mapConstraintCheckboxes.put(Nutrient.PROTEIN.getNumber(), checkBoxProtein);
        mapConstraintCheckboxes.put(Nutrient.FAT.getNumber(), checkBoxFat);
        mapConstraintCheckboxes.put(Nutrient.CHOLESTEROL.getNumber(), checkBoxCholesterol);
        mapConstraintCheckboxes.put(Nutrient.SATURATED.getNumber(), checkBoxSaturated);
        mapConstraintCheckboxes.put(Nutrient.DHA.getNumber(), checkBoxDHA);
        mapConstraintCheckboxes.put(Nutrient.EPA.getNumber(), checkBoxEPA);
        mapConstraintCheckboxes.put(Nutrient.MONOUNSATURATED.getNumber(), checkBoxMonounsaturated);
        mapConstraintCheckboxes.put(Nutrient.POLYUNSATURATED.getNumber(), checkBoxPolyunsaturated);
        mapConstraintCheckboxes.put(Nutrient.LINOLEIC.getNumber(), checkBoxLinoleic);
        mapConstraintCheckboxes.put(Nutrient.ALPHALINOLENIC.getNumber(), checkBoxAlphaLinolenic);
        mapConstraintCheckboxes.put(Nutrient.DIGESTIBLECARBS.getNumber(), checkBoxDigestibleCarbs);
        mapConstraintCheckboxes.put(Nutrient.SUCROSE.getNumber(), checkBoxSucrose);
        mapConstraintCheckboxes.put(Nutrient.FRUCTOSE.getNumber(), checkBoxFructose);
        mapConstraintCheckboxes.put(Nutrient.LACTOSE.getNumber(), checkBoxLactose);
        mapConstraintCheckboxes.put(Nutrient.FIBER.getNumber(), checkBoxFiber);
        mapConstraintCheckboxes.put(Nutrient.VITAMINA.getNumber(), checkBoxVitaminA);
        mapConstraintCheckboxes.put(Nutrient.VITAMINE.getNumber(), checkBoxVitaminE);
        mapConstraintCheckboxes.put(Nutrient.VITAMIND.getNumber(), checkBoxVitaminD);
        mapConstraintCheckboxes.put(Nutrient.VITAMINC.getNumber(), checkBoxVitaminC);
        mapConstraintCheckboxes.put(Nutrient.THIAMIN.getNumber(), checkBoxThiamin);
        mapConstraintCheckboxes.put(Nutrient.RIBOFLAVIN.getNumber(), checkBoxRiboflavin);
        mapConstraintCheckboxes.put(Nutrient.NIACIN.getNumber(), checkBoxNiacin);
        mapConstraintCheckboxes.put(Nutrient.PANTOTHENIC.getNumber(), checkBoxPantothenic);
        mapConstraintCheckboxes.put(Nutrient.VITAMINB6.getNumber(), checkBoxVitaminB6);
        mapConstraintCheckboxes.put(Nutrient.VITAMINB12.getNumber(), checkBoxVitaminB12);
        mapConstraintCheckboxes.put(Nutrient.CHOLINE.getNumber(), checkBoxCholine);
        mapConstraintCheckboxes.put(Nutrient.VITAMINK.getNumber(), checkBoxVitaminK);
        mapConstraintCheckboxes.put(Nutrient.FOLATE.getNumber(), checkBoxFolate);
        mapConstraintCheckboxes.put(Nutrient.CALCIUM.getNumber(), checkBoxCalcium);
        mapConstraintCheckboxes.put(Nutrient.IRON.getNumber(), checkBoxIron);
        mapConstraintCheckboxes.put(Nutrient.MAGNESIUM.getNumber(), checkBoxMagnesium);
        mapConstraintCheckboxes.put(Nutrient.PHOSPHORUS.getNumber(), checkBoxPhosphorus);
        mapConstraintCheckboxes.put(Nutrient.POTASSIUM.getNumber(), checkBoxPotassium);
        mapConstraintCheckboxes.put(Nutrient.SODIUM.getNumber(), checkBoxSodium);
        mapConstraintCheckboxes.put(Nutrient.ZINC.getNumber(), checkBoxZinc);
        mapConstraintCheckboxes.put(Nutrient.COPPER.getNumber(), checkBoxCopper);
        mapConstraintCheckboxes.put(Nutrient.FLUORIDE.getNumber(), checkBoxFluoride);
        mapConstraintCheckboxes.put(Nutrient.MANGANESE.getNumber(), checkBoxManganese);
        mapConstraintCheckboxes.put(Nutrient.SELENIUM.getNumber(), checkBoxSelenium);
        mapConstraintCheckboxes.put(Nutrient.WEIGHT.getNumber(), checkBoxWeight);
        mapConstraintCheckboxes.put(Nutrient.COST.getNumber(), checkBoxCost);
        mapConstraintCheckboxes.put(Nutrient.ENERGY.getNumber(), checkBoxEnergy);
        mapConstraintCheckboxes.put(Nutrient.ALCOHOL.getNumber(), checkBoxAlcohol);
        mapConstraintCheckboxes.put(Nutrient.WATER.getNumber(), checkBoxWater);
        mapConstraintCheckboxes.put(Nutrient.FIBERINSOLUBLE.getNumber(), checkBoxFiberInsoluble);
        mapConstraintCheckboxes.put(Nutrient.FIBERSOLUBLE.getNumber(), checkBoxFiberSoluble);
        mapConstraintCheckboxes.put(Nutrient.GLYCEMICLOAD.getNumber(), checkBoxGlycemicLoad);
        try {
            LinkedList all = (LinkedList) dbLink.Nutrient_Select_All();
            Iterator it = all.iterator();
            while (it.hasNext()) {
                HashMap row = (HashMap) it.next();
                String nutrientid = (String) row.get("NUTRIENTID");
                int visible = (int) row.get("VISIBLE");
                if (mapConstraintCheckboxes.containsKey(nutrientid)) {
                    JCheckBox cb = mapConstraintCheckboxes.get(nutrientid);
                    cb.setSelected(visible == 1);
                }
            }
        } catch (SQLException e) {
            Log.getLog().start("files/exception.log");
            Log.getLog().logMessage(e.toString());
            Log.getLog().write();
            Log.getLog().close();
            e.printStackTrace();
        }
        event_menuItemRoundUp();
        selectFirstItemOnList();
    }

    private void selectFirstItemOnList() {
        listMixesJournal.setSelectedIndex(0);
        listCompareA.setSelectedIndex(0);
        listCompareB.setSelectedIndex(0);
        listRdaCheck.setSelectedIndex(0);
    }

    public static void main(String[] args) {
        try {            
            MetalLookAndFeel.setCurrentTheme(new Dawn());
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");           
        } catch (ClassNotFoundException e) {
        } catch (IllegalAccessException e) {
            Log.getLog().start("files/exception.log");
            Log.getLog().logMessage(e.toString());
            Log.getLog().write();
            Log.getLog().close();
            e.printStackTrace();
        } catch (InstantiationException e) {
            Log.getLog().start("files/exception.log");
            Log.getLog().logMessage(e.toString());
            Log.getLog().write();
            Log.getLog().close();
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            Log.getLog().start("files/exception.log");
            Log.getLog().logMessage(e.toString());
            Log.getLog().write();
            Log.getLog().close();
            e.printStackTrace();
        }
        Main main = new Main();
    }

    private void reloadTableModelConstraints(int mixId) {
        modelTableNutrientConstraints.reload(mixId);
        resizeColumns_NutrientConstraintTableColumns();
        modelTableFoodNutrientConstraints.reload(mixId);
        resizeColumns_FoodNutrientConstraintTableColumns();
        modelTableNutrientRatioConstraints.reload(mixId);
        resizeColumns_NutrientRatioConstraintTableColumns();
        modelTableFoodNutrientRatioConstraints.reload(mixId);
        resizeColumns_FoodNutrientRatioConstraintTableColumns();
        tableModelPercentNutrientConstraints.reload(mixId);
        resizeColumns_PercentNutrientConstraintTableColumns();
    }

    private void reloadRelationshipComboBoxes() {
        modelComboBox_RelationshipAtNutrient.reload();
        modelComboBox_RelationshipAtFoodNutrient.reload();
    }

    private JMenuBar getMenuBar() {
        JMenuBar mnuBar = new JMenuBar();
        mnuBar.add(menuProgram);
        mnuBar.add(menuTools);
        mnuBar.add(menuData);
        mnuBar.add(menuHelp);
        menuProgram.add(menuSettings);
        menuProgram.add(menuItemExit);
        menuTools.add(menuItemMicronutrientConversion);
        menuTools.add(menuItemBmr);
        menuTools.add(menuItemNitrogenBalance);
        menuTools.add(menuItemKetosis);
        menuTools.add(menuItemDigestibleCarbs);
        menuTools.add(menuItemGlycemicLoad);
        menuTools.add(menuItemGlycemicIndexRange);
        menuData.add(menuExport);
        menuExport.add(menuItemExportFoodList);
        menuExport.add(menuItemExportFoodMixes);
        menuExport.add(menuItemExportMixCompare);
        menuExport.add(menuItemExportRdaCompare);
        menuExport.add(menuItemExportNutrientLookup);
        menuHelp.add(menuItemGuide);
        menuHelp.add(menuItemCredits);
        menuHelp.add(menuItemAbout);
        menuSettings.add(checkBoxResultRoundUp);
        menuSettings.add(menuItemConstraintsShownInList);
        menuProgram.setText("Program");
        menuTools.setText("Tools");
        menuData.setText("Data");
        menuHelp.setText("Help");
        menuSettings.setText("Settings");
        menuItemExit.setText("Exit");
        menuItemMicronutrientConversion.setText("Percent Daily Value (%DV) to Grams");
        menuItemBmr.setText("Calculate Basal Metabolic Rate");
        menuItemNitrogenBalance.setText("Calculate Complete Protein Required (no fat, no carbs regimen)");
        menuItemKetosis.setText("Check Carbohydrate Required (to inhibit ketosis)");
        menuItemDigestibleCarbs.setText("Calculate Digestible Carbohydrate");
        menuItemGlycemicLoad.setText("Calculate Glycemic Load");
        menuItemGlycemicIndexRange.setText("Check Glycemic Index Range");
        menuExport.setText("Export");
        menuItemExportFoodList.setText("Food List");
        menuItemExportFoodMixes.setText("Food Mixes");
        menuItemExportMixCompare.setText("Mix Comparison");
        menuItemExportRdaCompare.setText("RDA Check");
        menuItemExportNutrientLookup.setText("Nutrient Lookup");
        checkBoxResultRoundUp.setText("Round Up");
        menuItemConstraintsShownInList.setText("Nutrients Shown As Constraints");
        menuItemGuide.setText("Guide");
        menuItemCredits.setText("Credits");
        menuItemAbout.setText("About");
        checkBoxResultRoundUp.setSelected(true);
        menuItemMicronutrientConversion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                event_menuItemMicronutrientConversion();
            }
        });
        menuItemBmr.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                event_menuItemBmr();
            }
        });
        menuItemNitrogenBalance.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                event_menuItemNitrogenBalance();
            }
        });
        menuItemKetosis.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                event_menuItemKetosis();
            }
        });
        menuItemDigestibleCarbs.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                event_menuItemDigestibleCarbs();
            }
        });
        menuItemGlycemicLoad.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                event_menuItemGlycemicLoad();
            }
        });
        menuItemGlycemicIndexRange.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                event_menuItemGlycemicIndexRange();
            }
        });
        menuItemExportFoodList.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                event_menuItemFoodListExport();
            }
        });
        menuItemExportFoodMixes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                event_menuItemFoodMixesExport();
            }
        });
        menuItemExportMixCompare.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                event_menuItemMixComparisonExport();
            }
        });
        menuItemExportRdaCompare.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                event_menuItemRdaCheckExport();
            }
        });
        menuItemExportNutrientLookup.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                event_menuItemNutrientLookupExport();
            }
        });
        menuItemGuide.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                event_menuItemGuide();
            }
        });
        menuItemCredits.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                event_menuItemCredits();
            }
        });
        menuItemAbout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                event_menuItemAbout();
            }
        });
        menuItemConstraintsShownInList.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                event_menuItemNutrientsShownAsConstraints();
            }
        });
        checkBoxResultRoundUp.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                event_menuItemRoundUp();
            }
        });
        menuItemExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                event_menuItemExit();
            }
        });
        return mnuBar;
    }

    private void event_menuItemDigestibleCarbs() {
        JTextField totalCarbs = new JTextField();
        JTextField totalFiber = new JTextField();
        JComponent[] inputs = new JComponent[]{
                new JLabel("What is total carbohydrate (g) of food item?"),
                totalCarbs
        };
        Message.showOptionDialog(inputs, "Digestible Carbohydrate");
        String totalCarbsText = totalCarbs.getText();
        inputs = new JComponent[]{
                new JLabel("What is total fiber (g) in food item?"),
                totalFiber
        };
        Message.showOptionDialog(inputs, "Digestible Carbohydrate");
        String totalFiberText = totalFiber.getText();
        if (totalCarbsText != null && totalCarbsText.length() > 0) {
            if (totalFiberText != null && totalFiberText.length() > 0) {
                StringBuffer sb = new StringBuffer();
                NumberCheck checkNumber = new NumberCheck();
                checkNumber.addToUncheckedList(totalCarbsText);
                checkNumber.addToUncheckedList(totalFiberText);
                if (checkNumber.pass()) {
                    Double totalCarbsNumber = Double.valueOf(totalCarbsText);
                    Double totalFiberNumber = Double.valueOf(totalFiberText);
                    double digestibleCarbsNumber = new DigestibleCarbohydrate(totalCarbsNumber,totalFiberNumber).getDigestibleCarbohydrate();
                    sb.append("Digestible Carbohydrate: ");
                    sb.append(digestibleCarbsNumber);
                    JTextArea textArea = new JTextArea(1, 10);
                    textArea.setText(sb.toString());
                    textArea.setEditable(false);
                    inputs = new JComponent[]{
                            textArea
                    };
                    Message.showOptionDialog(inputs, "Digestible Carbohydrate");
                }
            }
        }
    }

    private void event_menuItemGlycemicIndexRange() {
        JTextField txtGI = new JTextField();
        JComponent[] inputs = new JComponent[]{
                new JLabel("What is glycemic index of food item?"),
                txtGI
        };
        Message.showOptionDialog(inputs, "Glycemic Index Range");
        String strGI = txtGI.getText();
        if (strGI != null && strGI.length() > 0) {
            if (strGI != null && strGI.length() > 0) {
                StringBuffer sb = new StringBuffer();
                NumberCheck checkNumber = new NumberCheck();
                checkNumber.addToUncheckedList(strGI);
                if (checkNumber.pass()) {
                    Integer gi = Integer.valueOf(strGI);
                    String range = new GlycemicIndexRange(gi).getGlycemicIndexRange();
                    sb.append("Glycemic Index Range: ");
                    sb.append(range);
                    JTextArea textArea = new JTextArea(1, 10);
                    textArea.setText(sb.toString());
                    textArea.setEditable(false);
                    inputs = new JComponent[]{
                            textArea
                    };
                    Message.showOptionDialog(inputs, "Glycemic Index Range");
                }
            }
        }
    }

    private void event_menuItemBmr() {
        JTextField textFieldLbs = new JTextField();
        JComponent[] inputs = new JComponent[]{
                new JLabel("What is your lean body mass in pounds?"),
                textFieldLbs
        };
        Message.showOptionDialog(inputs, "Basal Metabolic Rate");
        String s = textFieldLbs.getText();
        if (s != null && s.length() > 0) {
            StringBuffer sb = new StringBuffer();
            NumberCheck checkNumber = new NumberCheck();
            checkNumber.addToUncheckedList(s);
            if (checkNumber.pass()) {
                Double weightinlbs = Double.valueOf(s);
                double rdee = new KatchMcArdleFormula(weightinlbs).getCalories();
                sb.append("Katch-McArdle Formula (Resting Daily Energy Expenditure): ");
                sb.append(Math.round(rdee));
                sb.append(" Kcals");
                sb.append("\n");
                double rdee2 = new CunninghamFormula(weightinlbs).getCalories();
                sb.append("Cunningham Formula (Resting Metabolic Rate): ");
                sb.append(Math.round(rdee2));
                sb.append(" Kcals");
                sb.append("\n");
                JTextArea textArea = new JTextArea(1, 40);
                textArea.setText(sb.toString());
                textArea.setEditable(false);
                inputs = new JComponent[]{
                        textArea
                };
                Message.showOptionDialog(inputs, "Basal Metabolic Rate");
            } else {
                Message.showMessage("Numbers only");
            }
        }
    }

    private void event_menuItemNitrogenBalance() {
        JTextField textFieldLbs = new JTextField();
        JComponent[] inputs = new JComponent[]{
                new JLabel("What is your lean body mass in pounds?"),
                textFieldLbs
        };
        Message.showOptionDialog(inputs, "Complete Protein Required");
        String s = textFieldLbs.getText();
        if (s != null && s.length() > 0) {
            StringBuffer sb = new StringBuffer();
            NumberCheck checkNumber = new NumberCheck();
            checkNumber.addToUncheckedList(s);
            if (checkNumber.pass()) {
                Double weightinlbs = Double.valueOf(s);
                double protein = new MinimumNutrientRequirements(weightinlbs).getProtein();
                sb.append("Complete Protein Required (no carbs, no fats): ");
                sb.append(Math.round(protein));
                sb.append(" g");
                sb.append("\n");
                JTextArea textArea = new JTextArea(1, 20);
                textArea.setText(sb.toString());
                textArea.setEditable(false);
                inputs = new JComponent[]{
                        textArea
                };
                Message.showOptionDialog(inputs, "Complete Protein Required (no carbs, no fats)");
            } else {
                Message.showMessage("Numbers only");
            }
        }
    }

    private void event_menuItemKetosis() {
        StringBuffer sb = new StringBuffer();
        double carbohydrateLow = new MinimumNutrientRequirements(0.0).getCarbohydrateLow();
        double carbohydrateMedium = new MinimumNutrientRequirements(0.0).getCarbohydrateMedium();
        double carbohydrateHigh = new MinimumNutrientRequirements(0.0).getCarbohydrateHigh();
        sb.append("Carbohydrate Required to Appreciably Reduce Ketosis: ");
        sb.append(carbohydrateLow);
        sb.append(" to ");
        sb.append(carbohydrateMedium);
        sb.append(" g");
        sb.append("\n");
        sb.append("Carbohydrate Required to Inhibit Ketosis: ");
        sb.append(carbohydrateMedium);
        sb.append(" to ");
        sb.append(carbohydrateHigh);
        sb.append(" g");
        sb.append("\n");
        JTextArea textArea = new JTextArea(1, 40);
        textArea.setText(sb.toString());
        textArea.setEditable(false);
        JComponent[] inputs = new JComponent[]{
                textArea
        };
        Message.showOptionDialog(inputs, "Carbohydrate Required to Inhibit Ketosis");
    }

    private void event_menuItemMicronutrientConversion() {
        FormLayout layout = new FormLayout("min:grow,min,min:grow", //columns
                "fill:min:grow" //rows
        );
        JPanel panel = new JPanel();
        panel.setLayout(layout);
        JComboBox cboxNutrients = new JComboBox();
        cboxNutrients.setModel(modelComboBox_NutrientLookupListConvert);
        modelComboBox_NutrientLookupListConvert.reload();
        JTextField dailyValuePct = new JTextField();
        dailyValuePct.setMinimumSize(new Dimension(50, 20));
        panel.add(cboxNutrients, cc.xy(1, 1));
        panel.add(dailyValuePct, cc.xy(2, 1));
        panel.add(new JLabel(" %DV"), cc.xy(3, 1));
        JComponent[] inputs = new JComponent[]{
                panel
        };
        Message.showOptionDialog(inputs, "Percent Daily Value (%DV) to Grams");
        String s = dailyValuePct.getText();
        if (s != null && s.length() > 0) {
            NutrientDataObject nutrientDataObject = (NutrientDataObject)cboxNutrients.getSelectedItem();
            StringBuffer sb = new StringBuffer();
            NumberCheck checkNumber = new NumberCheck();
            checkNumber.addToUncheckedList(s);
            if (checkNumber.pass()) {
                Double dvpct = Double.valueOf(s);
                sb.append(dvpct * (nutrientDataObject.getQ() / 100));
                sb.append(" ");
                sb.append(nutrientDataObject.getNutrdesc());
                sb.append("\n");
                JTextArea textArea = new JTextArea(1, 20);
                textArea.setText(sb.toString());
                textArea.setEditable(false);
                inputs = new JComponent[]{
                        textArea
                };
                Message.showOptionDialog(inputs, "Percent Daily Value (%DV) to Grams");
            } else {
                Message.showMessage("Numbers only");
            }
        }
    }

    private JPanel getSolve() {
        FormLayout panelLayout = new FormLayout("min:grow", //columns
                "fill:min:grow" //rows
        );
        FormLayout bottomLayout = new FormLayout("min:grow", //columns
                "fill:min:grow" //rows
        );
        JPanel panel = new JPanel();
        JPanel bottom = new JPanel();
        panel.setLayout(panelLayout);
        bottom.setLayout(bottomLayout);
        JSplitPane splitPane = new JSplitPane();
        splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
        splitPane.setResizeWeight(.5d);
        splitPane.setTopComponent(getResults());
        splitPane.setBottomComponent(bottom);
        JSplitPane splitPane1 = new JSplitPane();
        splitPane1.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
        JTabbedPane bottomTabPane = new JTabbedPane();
        bottomTabPane.setBorder(new TitledBorder("Model Definition"));
        bottomTabPane.setTabPlacement(JTabbedPane.BOTTOM);
        splitPane1.setLeftComponent(getMixList());
        splitPane1.setRightComponent(bottomTabPane);
        bottom.add(splitPane1, cc.xy(1, 1));
        bottomTabPane.add(getMixFood());
        bottomTabPane.add(getAmountOfNutrientConstraint());
        bottomTabPane.add(getPercentOfNutrientConstraint());
        bottomTabPane.add(getAmountOfFoodNutrientConstraint());
        bottomTabPane.add(getFoodNutrientRatioConstraint());
        bottomTabPane.add(getNutrientRatioConstraint());
        bottomTabPane.add(getModel());
        bottomTabPane.add(getNote());
        bottomTabPane.setTitleAt(0, "Food");
        bottomTabPane.setToolTipTextAt(0, "Pick your food items here");
        bottomTabPane.setTitleAt(1, "Nutrient(g)");
        bottomTabPane.setToolTipTextAt(1, "Use this to specify the amount of nutrient in your mix");
        bottomTabPane.setTitleAt(2, "Nutrient(%)");
        bottomTabPane.setToolTipTextAt(2, "Use this to specify the percentage of nutrient in your mix");
        bottomTabPane.setTitleAt(3, "Food(g)");
        bottomTabPane.setToolTipTextAt(3, "Use this to specify the amount of nutrient a food item will contribute to your mix");
        bottomTabPane.setTitleAt(4, "Food Ratio");
        bottomTabPane.setToolTipTextAt(4, "Use this to specify what proportion food items should be in");
        bottomTabPane.setTitleAt(5, "Nutrient Ratio");
        bottomTabPane.setToolTipTextAt(5, "Use this to specify what proportion nutrients should be in");
        bottomTabPane.setTitleAt(6, "Model");
        bottomTabPane.setToolTipTextAt(6, "Use this linear programming model to verify results");
        bottomTabPane.setTitleAt(7, "Note");
        bottomTabPane.setToolTipTextAt(7, "Use this to add notes");
        panel.add(splitPane, cc.xy(1, 1));
        listMixes.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                event_listMixes(e);
            }
        });
        listMixes.setModel(modelList_Solve);
        return panel;
    }

    private JPanel getMixList() {
        JPanel panel = new JPanel();
        FormLayout layout = new FormLayout("min:grow", //columns
                "fill:min:grow,min" //rows
        );
        panel.setLayout(layout);
        panel.setBorder(new TitledBorder("Mixes"));
        JPanel panelButtons = new JPanel();
        FormLayout layout00 = new FormLayout("min:grow,min,min,min,min,10dlu,min,min,10dlu,min,min:grow", //columns
                "min" //rows
        );
        panelButtons.setLayout(layout00);
        JButton buttonCreateMix = new JButton("+");
        JButton buttonDeleteMix = new JButton("-");
        JButton buttonRenameMix = new JButton("r");
        JButton buttonDuplicateMix = new JButton("d");
        JButton buttonArchiveMix = new JButton("a");
        JButton buttonAddMixToFoodList = new JButton("f");
        JButton buttonSolve = new JButton("Solve");
        buttonCreateMix.setToolTipText("Create mix");
        buttonDeleteMix.setToolTipText("Delete mix");
        buttonRenameMix.setToolTipText("Rename mix");
        buttonDuplicateMix.setToolTipText("Duplicate mix");
        buttonArchiveMix.setToolTipText("Archive mix");
        buttonAddMixToFoodList.setToolTipText("Add to Food List");
        buttonSolve.setToolTipText("Find lowest calorie food combination");
        panelButtons.add(buttonCreateMix, cc.xy(2, 1));
        panelButtons.add(buttonDeleteMix, cc.xy(3, 1));
        panelButtons.add(buttonRenameMix, cc.xy(4, 1));
        panelButtons.add(buttonDuplicateMix, cc.xy(5, 1));
        panelButtons.add(buttonAddMixToFoodList, cc.xy(7, 1));
        panelButtons.add(buttonArchiveMix, cc.xy(8, 1));
        panelButtons.add(buttonSolve, cc.xy(10, 1));
        JScrollPane s_mixes = new JScrollPane(listMixes);
        panel.add(s_mixes, cc.xy(1, 1));
        panel.add(panelButtons, cc.xy(1, 2));
        buttonCreateMix.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                event_buttonAddMix();
            }
        });
        buttonDeleteMix.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                event_buttonDeleteMix();
            }
        });
        buttonRenameMix.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                event_buttonRenameMix();
            }
        });
        buttonDuplicateMix.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                event_buttonDuplicateMix();
            }
        });
        buttonArchiveMix.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                event_buttonArchiveMix();
            }
        });
        buttonAddMixToFoodList.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                event_buttonAddMixToFoodList();
            }
        });
        buttonSolve.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                event_buttonSolve();
            }
        });
        return panel;
    }

    private void event_buttonArchiveMix() {
        if (isMixSelected()) {
            try {
                MixDataObject mix = (MixDataObject) listMixes.getSelectedValue();
                Integer mixId = mix.getMixId();
                dbLink.Mix_Update_Status(mixId, 0);
                reloadMixes();
                clearAllModels();
            } catch (SQLException e) {
                Log.getLog().start("files/exception.log");
                Log.getLog().logMessage(e.toString());
                Log.getLog().write();
                Log.getLog().close();
                e.printStackTrace();
            }
        }
    }

    private void reloadStatusBar(Integer mixId) {
        panelStatusBar.removeAll();
        panelStatusBar.add(new JLabel(stringModelMixPct.reload(mixId)));
        panelStatusBar.revalidate();
        panelStatusBar.repaint();
    }

    private void event_buttonAddMix() {
        JTextField input = new JTextField();
        JComponent[] inputs = new JComponent[]{
                new JLabel("What would you like to call it?"),
                input
        };
        int optionValue = Message.showOptionDialogYesNo(inputs, "Create Mix");
        if (optionValue == 0) {
            String mixnom = input.getText();
            String model = "";
            String note = "";
            String nutrientid = "208";
            try {
                Integer mixid = dbLink.Mix_Insert(mixnom);
                dbLink.Mix_Update_NutrientId(mixid,nutrientid);
                dbLink.Mix_Update_Other(mixid, model, note);
                dbLink.Mix_Update_Status(mixid, 1);
                reloadMixes();
                clearAllModels();
                listMixes.setSelectedIndex(listMixes.getLastVisibleIndex());
            } catch (SQLException e) {
                Log.getLog().start("files/exception.log");
                Log.getLog().logMessage(e.toString());
                Log.getLog().write();
                Log.getLog().close();
                e.printStackTrace();
            }
        }
    }

    private void reloadMixes() {
        modelList_Solve.reload();
        modelListFoodJournal.reload();
        modelList_A_MixDiff.reload();
        modelList_B_MixDiff.reload();
        modelListRda.reload();
    }

    private void reloadNutrientComboBoxes() {
        modelComboBox_NutrientAtNutrientConstraint.reload();
        modelComboBox_NutrientAtNutrientPctContraint.reload();
        modelComboBox_0_NutrientAtFoodNutrientRatio.reload();
        modelComboBox_1_NutrientAtFoodNutrientRatio.reload();
        modelComboBox_0_NutrientAtNutrientRatio.reload();
        modelComboBox_1_NutrientAtNutrientRatio.reload();
        //Do not include modelComboBox_NutrientLookupListNutrient, all nutrients must be on list
        //modelComboBox_NutrientLookupListNutrient.reload();
    }

    private void reloadLifeStageComboBox() {
        modelComboBoxLifeStage.reload();
        modelComboBoxLifeStage.setSelectedItem(new RdaLifeStageDataObject(22, "Daily Value"));
    }


    private void reloadFoodComboBoxes(Integer mixId) {
        modelComboBox_FoodAtNutrient.reload(mixId);
        modelComboBox_FoodAtNutrientPct.reload(mixId);
        modelComboBox_0_FoodAtFoodNutrientRatio.reload(mixId);
        modelComboBox_1_FoodAtFoodNutrientRatio.reload(mixId);
    }

    private void reloadTableModelsThatNeedMixId(Integer mixId) {
        modelTableEnergy.reload(mixId);
        modelTableProtein.reload(mixId);
        modelTableFat.reload(mixId);
        modelTableCarbs.reload(mixId);
        modelTableVitamins.reload(mixId);
        modelTableMinerals.reload(mixId);
        modelTableWater.reload(mixId);
        modelTableCost.reload(mixId);
        modelTableElectrolytes.reload(mixId);
        modelTableFoodJournal.reload(mixId);
        modelTableGlycemic.reload(mixId);
        resizeColumns_JournalTable();
        reloadStatusBar(mixId);
    }

    private void resizeColumns() {
        resizeColumns_EnergyTable();
        resizeColumns_ProteinTable();
        resizeColumns_FatTable();
        resizeColumns_CarbsTable();
        resizeColumns_VitaminsTable();
        resizeColumns_MineralsTable();
        resizeColumns_WaterTable();
        resizeColumns_CostTable();
        resizeColumns_ElectrolytesTable();
        resizeColumns_JournalTable();
        resizeColumns_GlycemicTable();
    }

    private void event_buttonDeleteMix() {
        if (isMixSelected()) {
            JComponent[] inputs = new JComponent[]{
                    new JLabel("Would you like to delete mix?")
            };
            int optionValue = Message.showOptionDialogYesNo(inputs, "Delete Mix");
            if (optionValue == 0) {
                try {
                    MixDataObject mix = (MixDataObject) listMixes.getSelectedValue();
                    Integer mixId = mix.getMixId();
                    dbLink.Mix_Delete(mixId);
                    reloadMixes();
                    clearAllModels();
                    reloadStatusBar(-1);
                } catch (SQLException e) {
                    Log.getLog().start("files/exception.log");
                    Log.getLog().logMessage(e.toString());
                    Log.getLog().write();
                    Log.getLog().close();
                    e.printStackTrace();
                }
            } else {
            }
        } else {
            Message.showMessage("Select mix.");
        }
    }

    private void clearAllModels() {
        modelListSelectedFood.clear();
        modelTableNutrientConstraints.setRowCount(0);
        modelTableFoodNutrientConstraints.setRowCount(0);
        modelTableNutrientRatioConstraints.setRowCount(0);
        modelTableFoodNutrientRatioConstraints.setRowCount(0);
        tableModelPercentNutrientConstraints.setRowCount(0);
        modelTableEnergy.setRowCount(0);
        modelTableProtein.setRowCount(0);
        modelTableFat.setRowCount(0);
        modelTableCarbs.setRowCount(0);
        modelTableGlycemic.setRowCount(0);
        modelTableVitamins.setRowCount(0);
        modelTableMinerals.setRowCount(0);
        modelTableWater.setRowCount(0);
        modelTableCost.setRowCount(0);
        modelTableElectrolytes.setRowCount(0);
        modelTableFoodJournal.setRowCount(0);
        modelTableMixDiff.setRowCount(0);
        modelTableRda.setRowCount(0);
        modelComboBox_FoodAtNutrient.reload(-1);
        modelComboBox_FoodAtNutrientPct.reload(-1);
        modelComboBox_0_FoodAtFoodNutrientRatio.reload(-1);
        modelComboBox_1_FoodAtFoodNutrientRatio.reload(-1);
        textAreaLPModel.setText("");
    }

    private void event_buttonRenameMix() {
        if (isMixSelected()) {
            JTextField input = new JTextField();
            JComponent[] inputs = new JComponent[]{
                    new JLabel("What is your new mix name?"),
                    input
            };
            MixDataObject mix = (MixDataObject) listMixes.getSelectedValue();
            int selectedIndex = listMixes.getSelectedIndex();
            input.setText(mix.getName());
            int optionValue = Message.showOptionDialog(inputs, "Update Mix");
            if (optionValue == 0) {
                try {
                    String mixnom = input.getText();
                    Integer mixId = mix.getMixId();
                    dbLink.Mix_Update_Name(mixId, mixnom);
                    reloadMixes();
                    listMixes.setSelectedIndex(selectedIndex);
                } catch (SQLException e) {
                    Log.getLog().start("files/exception.log");
                    Log.getLog().logMessage(e.toString());
                    Log.getLog().write();
                    Log.getLog().close();
                    e.printStackTrace();
                }
            }
        }
    }

    private void event_buttonDuplicateMix() {
        if (isMixSelected()) {
            try {
                MixDataObject mix = (MixDataObject) listMixes.getSelectedValue();
                Integer mixId = mix.getMixId();
                dbLink.Mix_Duplicate(mixId);
                reloadMixes();
            } catch (SQLException e) {
                Log.getLog().start("files/exception.log");
                Log.getLog().logMessage(e.toString());
                Log.getLog().write();
                Log.getLog().close();
                e.printStackTrace();
            }
        } else {
            Message.showMessage("Select mix.");
        }
    }

    private void event_buttonAddMixToFoodList() {
        if (isMixSelected()) {
            JComponent[] inputs = new JComponent[]{
                    new JLabel("Would you like to add mix to food list?"),
            };
            int optionValue = Message.showOptionDialogYesNo(inputs, "Add to Food List");
            if (optionValue == 0) {
                try {
                    MixDataObject mixDataObject = (MixDataObject) listMixes.getSelectedValue();
                    dbLink.Food_Put(mixDataObject.getMixId());
                    reloadFoodItems();
                } catch (SQLException e) {
                    Log.getLog().start("files/exception.log");
                    Log.getLog().logMessage(e.toString());
                    Log.getLog().write();
                    Log.getLog().close();
                    e.printStackTrace();
                }
            }
        } else {
            Message.showMessage("Select mix");
        }
    }

    private JTable getTableMixComparison() {
        JTable table;
        table = new JTable() {
            public Component prepareRenderer(TableCellRenderer renderer, int rowIndex, int columnIndex) {
                JComponent component = (JComponent) super.prepareRenderer(renderer, rowIndex, columnIndex);
                Double valueAt;
                switch (columnIndex) {
                    case 0:
                        component.setForeground(Color.white);
                        break;
                    case 1:
                        valueAt = (Double) getValueAt(rowIndex, columnIndex);
                        if (valueAt <= 0) {
                            component.setForeground(Color.red);
                        } else {
                            component.setForeground(Color.white);
                        }
                        break;
                    case 2:
                        valueAt = (Double) getValueAt(rowIndex, columnIndex);
                        if (valueAt <= 0) {
                            component.setForeground(Color.red);
                        } else {
                            component.setForeground(Color.white);
                        }
                        break;
                    case 3:
                        valueAt = (Double) getValueAt(rowIndex, columnIndex);
                        if (valueAt < 0) {
                            component.setForeground(Color.red);
                        } else {
                            component.setForeground(Color.white);
                        }
                        break;
                }
                return component;
            }
        };
        return table;
    }

    private JPanel getMixComparison() {
        JPanel panel = new JPanel();
        tableMixComparison = getTableMixComparison();
        JScrollPane scrollPaneA = new JScrollPane(listCompareA);
        JScrollPane scrollPaneB = new JScrollPane(listCompareB);
        JScrollPane scrollPaneC = new JScrollPane(tableMixComparison);
        CellConstraints cc = new CellConstraints();
        //create layouts
        FormLayout layout = new FormLayout(
                "min:grow(.25),min:grow(.25),min:grow", //columns
                "fill:min:grow" //rows
        );
        panel.setLayout(layout);
        panel.add(scrollPaneA, cc.xy(1, 1));
        panel.add(scrollPaneB, cc.xy(2, 1));
        panel.add(scrollPaneC, cc.xy(3, 1));
        layout.setColumnGroup(1, 2);
        scrollPaneA.setBorder(new TitledBorder("Mix 1"));
        scrollPaneB.setBorder(new TitledBorder("Mix 2"));
        scrollPaneC.setBorder(new TitledBorder("Mix Difference"));
        listCompareA.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                event_listCompareA(e);
            }
        });
        listCompareB.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                event_listCompareB(e);
            }
        });
        listCompareA.setModel(modelList_A_MixDiff);
        listCompareB.setModel(modelList_B_MixDiff);
        tableMixComparison.setModel(modelTableMixDiff);
        tableMixComparison.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tableMixComparison.setFillsViewportHeight(true);
        tableMixComparison.getTableHeader().setReorderingAllowed(false);
        modelList_A_MixDiff.reload();
        modelList_B_MixDiff.reload();
        resizeColumns_MixComparisonTable();
        return panel;
    }

    private JTable getTableRdaCheck() {
        JTable table;
        table = new JTable() {
            public Component prepareRenderer(TableCellRenderer renderer, int rowIndex, int columnIndex) {
                JComponent component = (JComponent) super.prepareRenderer(renderer, rowIndex, columnIndex);
                Double valueAt;
                switch (columnIndex) {
                    case 0:
                        component.setForeground(Color.white);
                        break;
                    case 1:
                        component.setForeground(Color.white);
                        break;
                    case 2:
                        valueAt = (Double) getValueAt(rowIndex, columnIndex);
                        if (valueAt <= 0) {
                            component.setForeground(Color.red);
                        } else {
                            component.setForeground(Color.white);
                        }
                        break;
                    case 3:
                        component.setForeground(Color.white);
                        break;
                    case 4:
                        valueAt = (Double) getValueAt(rowIndex, columnIndex);
                        if (valueAt < 100) {
                            component.setForeground(Color.red);
                        }
                        break;
                    case 5:
                        component.setForeground(Color.white);
                        break;
                    case 6:
                        valueAt = (Double) getValueAt(rowIndex, columnIndex);
                        if (valueAt > 100) {
                            component.setForeground(Color.red);
                        } else {
                            component.setForeground(Color.white);
                        }
                        break;
                }
                return component;
            }
        };
        return table;
    }

    private JPanel getRdaCheck() {
        JPanel panel = new JPanel();
        JScrollPane scrollPaneMix = new JScrollPane(listRdaCheck);
        tableRdaCheck = getTableRdaCheck();
        JScrollPane scrollPaneRdaDiff = new JScrollPane(tableRdaCheck);
        CellConstraints cc = new CellConstraints();
        FormLayout layout = new FormLayout(
                "min:grow(.25),min:grow", //columns
                "fill:min:grow" //rows
        );
        FormLayout layoutPanelRdaDiff = new FormLayout(
                "min, min, min:grow", //columns
                "5dlu,min,5dlu,fill:min:grow" //rows
        );
        JPanel panelRdaDiff = new JPanel();
        panelRdaDiff.setLayout(layoutPanelRdaDiff);
        panelRdaDiff.add(new JLabel(" Lifestage:"), cc.xy(1, 2));
        panelRdaDiff.add(comboBoxLifeStage, cc.xy(2, 2));
        panelRdaDiff.add(scrollPaneRdaDiff, cc.xyw(1, 4, 3));
        panel.setLayout(layout);
        panel.add(scrollPaneMix, cc.xy(1, 1));
        panel.add(panelRdaDiff, cc.xy(2, 1));
        scrollPaneMix.setBorder(new TitledBorder("Mix"));
        scrollPaneRdaDiff.setBorder(new TitledBorder("RDA Check"));
        listRdaCheck.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                event_ListRdaDiff(e);
            }
        });
        comboBoxLifeStage.setModel(modelComboBoxLifeStage);
        listRdaCheck.setModel(modelListRda);
        tableRdaCheck.setModel(modelTableRda);
        tableRdaCheck.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tableRdaCheck.setFillsViewportHeight(true);
        tableRdaCheck.setTableHeader(new TableHeaderRdaDiff(tableRdaCheck.getColumnModel()));
        tableRdaCheck.getTableHeader().setReorderingAllowed(false);
        modelListRda.reload();
        resizeColumns_RdaCheckTable();
        comboBoxLifeStage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                event_comboBoxLifeStage();
            }
        });
        JPopupMenu popMenu = new JPopupMenu();
        JMenuItem item = new JMenuItem("Do Nutrient Lookup");
        popMenu.add(item);
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRowNo = tableRdaCheck.getSelectedRow();
                if (selectedRowNo != -1) {
                    String nutrientid = (String) tableRdaCheck.getValueAt(selectedRowNo, 0);
                    String nutrient = (String) tableRdaCheck.getValueAt(selectedRowNo, 1);
                    Double rda = (Double) tableRdaCheck.getValueAt(selectedRowNo, 3);
                    textFieldNutrientLookup.setText(String.valueOf(rda));
                    NutrientDataObject nutrientDataObject = new NutrientDataObject(nutrientid, nutrient,null);
                    modelComboBox_NutrientLookupListNutrient.setSelectedItem(nutrientDataObject);
                    modelTableNutrientLookup.reload(nutrientid, rda);
                    resizeColumns_NutrientLookupTable();
                    resizeColumns_RdaCheckTable();
                } else {
                    Message.showMessage("Please select nutrient");
                }
            }
        });
        tableRdaCheck.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if ((e.getModifiers() & InputEvent.BUTTON3_MASK) != 0) {
                    Component component = e.getComponent();
                    popMenu.show(component, e.getX(), e.getY());
                }
            }
        });
        return panel;
    }

    private void event_comboBoxLifeStage() {
        reloadRdaCheck();
    }

    private void reloadRdaCheck() {
        if (isRdaMixSelected()) {
            MixDataObject mixDataObject = (MixDataObject) listRdaCheck.getSelectedValue();
            RdaLifeStageDataObject rdaLifeStageDataObject = (RdaLifeStageDataObject) comboBoxLifeStage.getSelectedItem();
            modelTableRda.reload(mixDataObject.getMixId(), rdaLifeStageDataObject.getLifeStageId());
            resizeColumns_RdaCheckTable();
        }
    }

    private void event_ListRdaDiff(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()) {
            reloadRdaCheck();
        }
    }

    private JPanel getFoodJournal() {
        JPanel panel = new JPanel();
        FormLayout layout = new FormLayout(
                "min:grow", //columns
                "fill:min:grow" //rows
        );
        panel.setLayout(layout);
        JPanel leftComponent = new JPanel();
        FormLayout leftLayout = new FormLayout(
                "min:grow", //columns
                "fill:min:grow,min" //rows
        );
        leftComponent.setLayout(leftLayout);
        JPanel buttons = new JPanel();
        FormLayout buttonsLayout = new FormLayout(
                "min:grow,min,min:grow", //columns
                "min" //rows
        );
        buttons.setLayout(buttonsLayout);
        JButton buttonEditMix = new JButton("e");
        buttonEditMix.setToolTipText("Edit Mix (in Solve Panel)");
        buttons.add(buttonEditMix, cc.xy(2, 1));
        JScrollPane mixesJournalSp = new JScrollPane(listMixesJournal);
        mixesJournalSp.setBorder(new TitledBorder("Mix"));
        leftComponent.add(mixesJournalSp, cc.xy(1, 1));
        leftComponent.add(buttons, cc.xy(1, 2));
        JSplitPane splitPane = new JSplitPane();
        splitPane.setDividerLocation(250);
        splitPane.setLeftComponent(leftComponent);
        JScrollPane tableJournalSp = new JScrollPane(tableJournal);
        tableJournalSp.setBorder(new TitledBorder("Mix Nutritional Facts"));
        splitPane.setRightComponent(tableJournalSp);
        panel.add(splitPane, cc.xy(1, 1));
        buttonEditMix.addActionListener(e -> event_buttonEditMix());
        tableJournal.setTableHeader(new TableHeaderFoodJournal(tableJournal.getColumnModel()));
        tableJournal.getTableHeader().setReorderingAllowed(false);
        tableJournal.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tableJournal.setModel(modelTableFoodJournal);
        tableJournal.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tableJournal.setFillsViewportHeight(true);
        listMixesJournal.addListSelectionListener(e -> event_listMixesJournal(e));
        listMixesJournal.setModel(modelListFoodJournal);
        modelListFoodJournal.reload();
        return panel;
    }

    private void event_listMixesJournal(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()) {
            reloadFoodJournal();
        }
    }

    private void reloadFoodJournal() {
        if (isMixJournalSelected()) {
            MixDataObject mixDataObject = (MixDataObject) listMixesJournal.getSelectedValue();
            Integer mixId = mixDataObject.getMixId();
            modelTableFoodJournal.reload(mixId);
            resizeColumns_JournalTable();
        }
    }

    private void event_buttonEditMix() {
        if (!listMixesJournal.isSelectionEmpty()) {
            try {
                MixDataObject mix = (MixDataObject) listMixesJournal.getSelectedValue();
                int selectedIndex = listMixesJournal.getSelectedIndex();
                Integer mixId = mix.getMixId();
                dbLink.Mix_Update_Status(mixId, 1);
                reloadMixes();
                clearAllModels();
                listMixesJournal.setSelectedIndex(selectedIndex);
            } catch (SQLException e) {
                Log.getLog().start("files/exception.log");
                Log.getLog().logMessage(e.toString());
                Log.getLog().write();
                Log.getLog().close();
                e.printStackTrace();
            }
        }
    }

    private void foodSearchFilter() {
        RowFilter<TableModelFoodList, Object> rf = null;
        try {
            ArrayList filters = new ArrayList();
            filters.add(RowFilter.regexFilter("(?i)" + textFieldFoodListSearch.getText(), 1));
            filters.add(RowFilter.regexFilter("(?i)" + textFieldFoodListSearch.getText(), 2));
            rf = RowFilter.orFilter((Iterable<? extends RowFilter<? super TableModelFoodList, ? super Object>>) filters);
        } catch (java.util.regex.PatternSyntaxException e) {
            Log.getLog().start("files/exception.log");
            Log.getLog().logMessage(e.toString());
            Log.getLog().write();
            Log.getLog().close();
            e.printStackTrace();
            return;
        }
        tableSorterFoodList.setRowFilter(rf);
    }

    private JPanel getFoodList() {
        JPanel panel = new JPanel();
        FormLayout paneLayout = new FormLayout(
                "min:grow", //columns
                "min,fill:min:grow,min" //rows
        );
        panel.setLayout(paneLayout);
        JPanel searchPanel = new JPanel();
        FormLayout searchPanelLayout = new FormLayout(
                "min,min:grow", //columns
                "min" //rows
        );
        searchPanel.setLayout(searchPanelLayout);
        JPanel buttonPanel = new JPanel();
        FormLayout buttonPanelLayout = new FormLayout(
                "min:grow,min,min,min,min,min:grow", //columns
                "min" //rows
        );
        buttonPanel.setLayout(buttonPanelLayout);
        JScrollPane scrollPaneTable = new JScrollPane(tableFoodList);
        searchPanel.add(new JLabel("Search:"), cc.xy(1, 1));
        searchPanel.add(textFieldFoodListSearch, cc.xy(2, 1));
        buttonPanel.add(buttonFoodListAdd, cc.xy(2, 1));
        buttonPanel.add(buttonFoodListDelete, cc.xy(3, 1));
        buttonPanel.add(buttonFoodListUpdate, cc.xy(4, 1));
        buttonPanel.add(buttonFoodListDuplicate, cc.xy(5, 1));
        panel.add(searchPanel, cc.xy(1, 1));
        panel.add(scrollPaneTable, cc.xy(1, 2));
        panel.add(buttonPanel, cc.xy(1, 3));
        scrollPaneTable.setBorder(new TitledBorder("Food List"));
        buttonFoodListAdd.setToolTipText("Add Food Item");
        buttonFoodListUpdate.setToolTipText("Update Food Item");
        buttonFoodListDelete.setToolTipText("Delete Food Item");
        buttonFoodListDuplicate.setToolTipText("Duplicate Food Item");
        buttonFoodListAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                event_buttonFoodListAdd();
            }
        });
        buttonFoodListDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                event_buttonFoodListDelete();
            }
        });
        buttonFoodListUpdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                event_buttonFoodListUpdate();
            }
        });
        buttonFoodListDuplicate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                event_buttonFoodListDuplicate();
            }
        });
        textFieldFoodListSearch.getDocument().addDocumentListener(
                new DocumentListener() {
                    public void changedUpdate(DocumentEvent e) {
                        foodSearchFilter();
                    }

                    public void insertUpdate(DocumentEvent e) {
                        foodSearchFilter();
                    }

                    public void removeUpdate(DocumentEvent e) {
                        foodSearchFilter();
                    }
                });
        tableFoodList.setTableHeader(new TableHeaderFoodList(tableFoodList.getColumnModel()));
        tableFoodList.getTableHeader().setReorderingAllowed(false);
        tableFoodList.setRowSorter(tableSorterFoodList);
        tableFoodList.setModel(modelTableFoodList);
        tableFoodList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tableFoodList.setFillsViewportHeight(true);
        tableFoodList.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        reloadFoodItems();
        JPopupMenu popMenu = new JPopupMenu();
        JMenuItem item = new JMenuItem("Check Coefficients");
        popMenu.add(item);
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRowNo = tableFoodList.getSelectedRow();
                if (selectedRowNo != -1) {
                    checkCoefficients((String) tableFoodList.getValueAt(selectedRowNo, 0));
                } else {
                    Message.showMessage("Please select food item");
                }
            }
        });
        tableFoodList.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if ((e.getModifiers() & InputEvent.BUTTON3_MASK) != 0) {
                    Component component = e.getComponent();
                    popMenu.show(component, e.getX(), e.getY());
                }
            }
        });
        return panel;
    }

    private void event_buttonFoodListDuplicate() {
        int selectedRowNo = tableFoodList.getSelectedRow();
        if (selectedRowNo != -1) {
            String foodId = (String) tableFoodList.getValueAt(selectedRowNo, 0);
            duplicateFoodItem(foodId);
        }
    }

    private void nutrientSearchCheckCoefficientsFilter() {
        RowFilter<TableModelCheckCoefficients, Object> rf = null;
        try {
            ArrayList filters = new ArrayList();
            filters.add(RowFilter.regexFilter("(?i)" + textFieldNutrientSearchCheckCoefficients.getText(), 1));
            filters.add(RowFilter.regexFilter("(?i)" + textFieldNutrientSearchCheckCoefficients.getText(), 2));
            rf = RowFilter.orFilter((Iterable<? extends RowFilter<? super TableModelCheckCoefficients, ? super Object>>) filters);
        } catch (java.util.regex.PatternSyntaxException e) {
            Log.getLog().start("files/exception.log");
            Log.getLog().logMessage(e.toString());
            Log.getLog().write();
            Log.getLog().close();
            e.printStackTrace();
            return;
        }
        tableSorterCheckCoefficients.setRowFilter(rf);
    }

    private void checkCoefficients(String foodId) {
        tableCheckCoefficients.getTableHeader().setReorderingAllowed(false);
        tableCheckCoefficients.setRowSorter(tableSorterCheckCoefficients);
        tableCheckCoefficients.setModel(modelTableCheckCoefficients);
        tableCheckCoefficients.setFillsViewportHeight(true);
        modelTableCheckCoefficients.setPrecision(5);
        modelTableCheckCoefficients.reload(foodId);
        resizeColumns_CheckCoefficientsTable();
        JPanel panel = new JPanel();
        JLabel labelFoodName = new JLabel("Food Name:");
        JLabel labelNutrientSearch = new JLabel("Search:");
        JTextField textFieldFoodName = new JTextField();
        JButton buttonPrevious = new JButton("<");
        JButton buttonNext = new JButton(">");
        labelFoodName.setHorizontalAlignment(JLabel.RIGHT);
        labelNutrientSearch.setHorizontalAlignment(JLabel.RIGHT);
        buttonPrevious.setToolTipText("Go to previous row");
        buttonNext.setToolTipText("Go to next row");
        FormLayout panelLayout = new FormLayout(
                "10px,310px,5px,200px,5px,min,min,min,10px", //columns
                "10px,min,min,min,5px,fill:min:grow,10px" //rows
        );
        panel.setPreferredSize(new Dimension(700, GoldenRatio.getShortSide(700)));
        panel.setLayout(panelLayout);
        panel.setBorder(new TitledBorder("Nutritional Food Facts and Coefficients"));
        panel.add(labelFoodName, cc.xy(2, 2));
        panel.add(textFieldFoodName, cc.xyw(4, 2, 5));
        panel.add(labelNutrientSearch, cc.xy(2, 3));
        panel.add(textFieldNutrientSearchCheckCoefficients, cc.xyw(4, 3, 2));
        panel.add(buttonPrevious, cc.xy(6, 3));
        panel.add(buttonNext, cc.xy(7, 3));
        panel.add(new JScrollPane(tableCheckCoefficients), cc.xyw(2, 6, 7));
        textFieldFoodName.setText((String) tableFoodList.getValueAt(tableFoodList.getSelectedRow(), 2));
        JComponent[] inputs = new JComponent[]{
                panel
        };
        buttonNext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRowNo = tableCheckCoefficients.getSelectedRow();
                if (selectedRowNo != tableCheckCoefficients.getRowCount() - 1) {
                    selectedRowNo++;
                    scrollToRow(selectedRowNo, tableCheckCoefficients);
                } else {
                    tableCheckCoefficients.setRowSelectionInterval(selectedRowNo, selectedRowNo);
                }
            }
        });
        buttonPrevious.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRowNo = tableCheckCoefficients.getSelectedRow();
                if (selectedRowNo > 0 && selectedRowNo < tableCheckCoefficients.getRowCount()) {
                    selectedRowNo--;
                    scrollToRow(selectedRowNo, tableCheckCoefficients);
                } else {
                    tableCheckCoefficients.setRowSelectionInterval(0, 0);
                }
            }
        });
        ListSelectionModel selectionModel = tableCheckCoefficients.getSelectionModel();
        selectionModel.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (e.getValueIsAdjusting()) {
                    return;
                }
                int selectedRowNo = tableCheckCoefficients.getSelectedRow();
                if (selectedRowNo != -1) {
                    String nutrient = (String) tableCheckCoefficients.getValueAt(selectedRowNo, 2);
                    Double weight = (Double) tableCheckCoefficients.getValueAt(selectedRowNo, 3);
                }
            }
        });
        textFieldNutrientSearchCheckCoefficients.getDocument().addDocumentListener(
                new DocumentListener() {
                    public void changedUpdate(DocumentEvent e) {
                        nutrientSearchCheckCoefficientsFilter();
                    }

                    public void insertUpdate(DocumentEvent e) {
                        nutrientSearchCheckCoefficientsFilter();
                    }

                    public void removeUpdate(DocumentEvent e) {
                        nutrientSearchCheckCoefficientsFilter();
                    }
                });
        tableCheckCoefficients.setRowSelectionInterval(0, 0);
        int optionValue = Message.showOptionDialog(inputs, "Check Coefficients");
        if (optionValue == 0) {
        }
    }

    private void nutrientSearchFilter() {
        RowFilter<TableModelDataInput, Object> rf = null;
        try {
            ArrayList filters = new ArrayList();
            filters.add(RowFilter.regexFilter("(?i)" + textFieldNutrientSearch.getText(), 1));
            filters.add(RowFilter.regexFilter("(?i)" + textFieldNutrientSearch.getText(), 2));
            rf = RowFilter.orFilter((Iterable<? extends RowFilter<? super TableModelDataInput, ? super Object>>) filters);
        } catch (java.util.regex.PatternSyntaxException e) {
            Log.getLog().start("files/exception.log");
            Log.getLog().logMessage(e.toString());
            Log.getLog().write();
            Log.getLog().close();
            e.printStackTrace();
            return;
        }
        tableSorterNutrientInput.setRowFilter(rf);
    }

    private void updateFoodItem(String foodId, Integer optionValue) {
        tableNutrientInput.getTableHeader().setReorderingAllowed(false);
        tableNutrientInput.setRowSorter(tableSorterNutrientInput);
        tableNutrientInput.setModel(modelTableNutrientInput);
        tableNutrientInput.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tableNutrientInput.setFillsViewportHeight(true);
        modelTableNutrientInput.setPrecision(5);
        textFieldNutrientSearch.setText("");
        if (optionValue == -1) {
            modelTableNutrientInput.reload(foodId);
            resizeColumns_NutrientInputTable();
        }
        JPanel panel = new JPanel();
        JLabel labelFoodName = new JLabel("Food Name:");
        JLabel labelNutrientWeight = new JLabel("Nutrient Weight:");
        JLabel labelNutrientSearch = new JLabel("Search:");
        JTextField textFieldFoodName = new JTextField();
        JTextField textFieldNutrientValue = new JTextField();
        JButton buttonNutrientWeightSave = new JButton("S");
        JButton buttonPrevious = new JButton("<");
        JButton buttonNext = new JButton(">");
        labelFoodName.setHorizontalAlignment(JLabel.RIGHT);
        labelNutrientWeight.setHorizontalAlignment(JLabel.RIGHT);
        labelNutrientSearch.setHorizontalAlignment(JLabel.RIGHT);
        buttonNutrientWeightSave.setToolTipText("Set nutrient value");
        buttonPrevious.setToolTipText("Go to previous row");
        buttonNext.setToolTipText("Go to next row");
        FormLayout panelLayout = new FormLayout(
                "10px,310px,5px,200px,5px,min,min,min,10px", //columns
                "10px,min,min,min,5px,fill:min:grow,10px" //rows
        );
        panel.setPreferredSize(new Dimension(700, GoldenRatio.getShortSide(700)));
        panel.setLayout(panelLayout);
        panel.setBorder(new TitledBorder("Nutritional Food Facts"));
        panel.add(labelFoodName, cc.xy(2, 2));
        panel.add(textFieldFoodName, cc.xyw(4, 2, 5));
        panel.add(labelNutrientSearch, cc.xy(2, 3));
        panel.add(textFieldNutrientSearch, cc.xyw(4, 3, 5));
        panel.add(labelNutrientWeight, cc.xy(2, 4));
        panel.add(textFieldNutrientValue, cc.xyw(4, 4, 2));
        panel.add(buttonNutrientWeightSave, cc.xy(6, 4));
        panel.add(buttonPrevious, cc.xy(7, 4));
        panel.add(buttonNext, cc.xy(8, 4));
        panel.add(new JScrollPane(tableNutrientInput), cc.xyw(2, 6, 7));
        JComponent[] inputs = new JComponent[]{
                panel
        };
        if (optionValue == 0) {
            textFieldFoodName.setText(foodNameText);
        } else {
            try {
                FoodDataObject foodDataObject = new FoodDataObject();
                foodDataObject.setFoodId(foodId);
                LinkedList<FoodDataObject> list = (LinkedList) dbLink.Food_Select(foodDataObject);
                Iterator it = list.listIterator();
                foodDataObject = (FoodDataObject) it.next();
                textFieldFoodName.setText(foodDataObject.getFoodName());
            } catch (SQLException e) {
                Log.getLog().start("files/exception.log");
                Log.getLog().logMessage(e.toString());
                Log.getLog().write();
                Log.getLog().close();
                e.printStackTrace();
            }
        }
        buttonNext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRowNo = tableNutrientInput.getSelectedRow();
                if (selectedRowNo != tableNutrientInput.getRowCount() - 1) {
                    selectedRowNo++;
                    scrollToRow(selectedRowNo, tableNutrientInput);
                } else {
                    tableNutrientInput.setRowSelectionInterval(selectedRowNo, selectedRowNo);
                }
            }
        });
        buttonPrevious.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRowNo = tableNutrientInput.getSelectedRow();
                if (selectedRowNo > 0 && selectedRowNo < tableNutrientInput.getRowCount()) {
                    selectedRowNo--;
                    scrollToRow(selectedRowNo, tableNutrientInput);
                } else {
                    tableNutrientInput.setRowSelectionInterval(0, 0);
                }
            }
        });
        buttonNutrientWeightSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRowNo = tableNutrientInput.getSelectedRow();
                if (selectedRowNo != -1) {
                    NumberCheck numberCheck = new NumberCheck();
                    numberCheck.addToUncheckedList(textFieldNutrientValue.getText());
                    if (numberCheck.pass()) {
                        tableNutrientInput.setValueAt(Double.valueOf(textFieldNutrientValue.getText()), selectedRowNo, 3);
                    } else {
                        Message.showMessage("Value must be a number greater than or equal to zero");
                    }
                }
            }
        });
        ListSelectionModel selectionModel = tableNutrientInput.getSelectionModel();
        selectionModel.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (e.getValueIsAdjusting()) {
                    return;
                }
                int selectedRowNo = tableNutrientInput.getSelectedRow();
                if (selectedRowNo != -1) {
                    String nutrient = (String) tableNutrientInput.getValueAt(selectedRowNo, 2);
                    Double weight = (Double) tableNutrientInput.getValueAt(selectedRowNo, 3);
                    textFieldNutrientValue.setText(String.valueOf(weight));
                    labelNutrientWeight.setText(nutrient);
                }
            }
        });
        textFieldNutrientSearch.getDocument().addDocumentListener(
                new DocumentListener() {
                    public void changedUpdate(DocumentEvent e) {
                        nutrientSearchFilter();
                    }

                    public void insertUpdate(DocumentEvent e) {
                        nutrientSearchFilter();
                    }

                    public void removeUpdate(DocumentEvent e) {
                        nutrientSearchFilter();
                    }
                });
        tableNutrientInput.setRowSelectionInterval(0, 0);
        optionValue = Message.showOptionDialogYesNo(inputs, "Add New Food Item - Would you like to save specified values?");
        if (optionValue == 0) {
            Integer rowIndex = modelTableNutrientInput.find("10000");
            Double q = (Double) modelTableNutrientInput.getValueAt(rowIndex, 3);
            if (q > 0) {
                try {
                    FoodDataObject foodDataObject = new FoodDataObject();
                    foodDataObject.setFoodId(foodId);
                    foodDataObject.setFoodName(textFieldFoodName.getText());
                    dbLink.Food_Update(foodDataObject);
                    rowIndex = modelTableNutrientInput.find("10000");
                    q = (Double) modelTableNutrientInput.getValueAt(rowIndex, 3);
                    //Weight must be first "NutrientId" updated for trigger to calculate correct nutrient coefficients. Weight is serving size.
                    dbLink.FoodFact_Merge(foodId, "10000", q);
                    int rowNo = modelTableNutrientInput.getRowCount();
                    for (int j = 0; j < rowNo; j++) {
                        String nutrientid = (String) modelTableNutrientInput.getValueAt(j, 0);
                        //Weight was updated earlier, I do not want to update it again
                        if (nutrientid != "10000") {
                            q = (Double) modelTableNutrientInput.getValueAt(j, 3);
                            dbLink.FoodFact_Merge(foodId, nutrientid, q);
                        }
                    }
                } catch (SQLException e) {
                    Log.getLog().start("files/exception.log");
                    Log.getLog().logMessage(e.toString());
                    Log.getLog().write();
                    Log.getLog().close();
                    e.printStackTrace();
                }
                dbLink.stopTransaction();
                reloadFoodItems();
                rowIndex = modelTableFoodList.find(foodId);
                scrollToRow(tableFoodList.convertRowIndexToView(rowIndex), tableFoodList);
                foodNameText = "";
            } else {
                foodNameText = textFieldFoodName.getText();
                Message.showMessage("What is serving size? Weight must be greater than zero.");
                updateFoodItem(foodId, optionValue);
            }
        } else {
            dbLink.revertTransaction();
        }
    }

    private void scrollToRow(int rowNo, JTable table) {
        table.setRowSelectionInterval(rowNo, rowNo);
        Rectangle rect = table.getCellRect(rowNo, 0, true);
        table.scrollRectToVisible(rect);
    }

    private void reloadFoodItems() {
        modelTableFoodList.reload();
        modelTreeFoodList.reload();
        modelListFood.reload();
        resizeColumns_FoodListTable();
    }

    private void event_buttonFoodListAdd() {
        try {
            dbLink.startTransaction();
            String foodId = dbLink.Food_Insert_Temp("New Food Item Name");
            updateFoodItem(foodId, -1);
        } catch (SQLException e) {
            Log.getLog().start("files/exception.log");
            Log.getLog().logMessage(e.toString());
            Log.getLog().write();
            Log.getLog().close();
            e.printStackTrace();
        }
    }

    private void event_buttonFoodListUpdate() {
        int selectedRowNo = tableFoodList.getSelectedRow();
        if (selectedRowNo != -1) {
            String foodId = (String) tableFoodList.getValueAt(selectedRowNo, 0);
            updateFoodItem(foodId, -1);
        }
    }

    private void event_buttonFoodListDelete() {
        int selectedRowNo = tableFoodList.getSelectedRow();
        if (selectedRowNo != -1) {
            String foodId = (String) tableFoodList.getValueAt(selectedRowNo, 0);
            deleteFoodItem(foodId);
        }
    }

    private void deleteFoodItem(String foodId) {
        try {
            dbLink.Food_Delete(foodId);
            reloadFoodItems();
            if (!listCategories.isSelectionEmpty()) {
                FoodCategoryDataObject foodCategoryDataObject = (FoodCategoryDataObject) listCategories.getSelectedValue();
                modelListFoodInCategory.reload(foodCategoryDataObject.getFoodCategoryId());
            }
        } catch (SQLException e) {
            Log.getLog().start("files/exception.log");
            Log.getLog().logMessage(e.toString());
            Log.getLog().write();
            Log.getLog().close();
            e.printStackTrace();
        }
    }

    private void duplicateFoodItem(String foodId) {
        try {
            dbLink.DuplicateFoodItem(foodId);
            reloadFoodItems();
            if (!listCategories.isSelectionEmpty()) {
                FoodCategoryDataObject foodCategoryDataObject = (FoodCategoryDataObject) listCategories.getSelectedValue();
                modelListFoodInCategory.reload(foodCategoryDataObject.getFoodCategoryId());
            }
        } catch (SQLException e) {
            Log.getLog().start("files/exception.log");
            Log.getLog().logMessage(e.toString());
            Log.getLog().write();
            Log.getLog().close();
            e.printStackTrace();
        }
    }

    private JPanel getNutrientLookupList() {
        JPanel panel = new JPanel();
        FormLayout panelLayout = new FormLayout(
                "min,min:grow,2dlu,min,min:grow,min", //columns
                "1dlu,min,1dlu,fill:min:grow" //rows
        );
        panel.setLayout(panelLayout);
        JScrollPane scrollPaneNutrientLookup = new JScrollPane(tableNutrientLookup);
        panel.add(new JLabel("Nutrient: "), cc.xy(1, 2));
        panel.add(comboBoxNutrientLookupListNutrient, cc.xy(2, 2));
        panel.add(new JLabel("Value: "), cc.xy(4, 2));
        panel.add(textFieldNutrientLookup, cc.xy(5, 2));
        panel.add(buttonNutrientLookupListRun, cc.xy(6, 2));
        panel.add(scrollPaneNutrientLookup, cc.xyw(1, 4, 6));
        scrollPaneNutrientLookup.setBorder(new TitledBorder("Nutrient Lookup"));
        tableNutrientLookup.setToolTipText("This is where you find food items that provide a specific nutrient");
        tableNutrientLookup.setTableHeader(new TableHeaderNutrientLookup(tableNutrientLookup.getColumnModel()));
        tableNutrientLookup.getTableHeader().setReorderingAllowed(false);
        buttonNutrientLookupListRun.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                event_buttonNutrientLookupListRun();
            }
        });
        comboBoxNutrientLookupListNutrient.setModel(modelComboBox_NutrientLookupListNutrient);
        modelComboBox_NutrientLookupListNutrient.reload();
        tableNutrientLookup.setModel(modelTableNutrientLookup);
        tableNutrientLookup.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tableNutrientLookup.setFillsViewportHeight(true);
        resizeColumns_NutrientLookupTable();
        return panel;
    }

    private void event_menuItemRoundUp() {
        boolean selected = checkBoxResultRoundUp.isSelected();
        if (selected) {
            modelTableEnergy.setPrecision(0);
            modelTableProtein.setPrecision(0);
            modelTableFat.setPrecision(0);
            modelTableCarbs.setPrecision(0);
            modelTableGlycemic.setPrecision(0);
            modelTableVitamins.setPrecision(0);
            modelTableMinerals.setPrecision(0);
            modelTableElectrolytes.setPrecision(0);
            modelTableWater.setPrecision(0);
            modelTableCost.setPrecision(0);
            modelTableFoodList.setPrecision(0);
            modelTableFoodJournal.setPrecision(0);
            modelTableMixDiff.setPrecision(0);
            modelTableRda.setPrecision(0);
            stringModelMixPct.setPrecision(0);
            modelTableNutrientLookup.setPrecision(0);
            modelTableNutrientInput.setPrecision(5);
        } else {
            modelTableEnergy.setPrecision(5);
            modelTableProtein.setPrecision(5);
            modelTableFat.setPrecision(5);
            modelTableCarbs.setPrecision(5);
            modelTableGlycemic.setPrecision(5);
            modelTableVitamins.setPrecision(5);
            modelTableMinerals.setPrecision(5);
            modelTableElectrolytes.setPrecision(5);
            modelTableWater.setPrecision(5);
            modelTableCost.setPrecision(5);
            modelTableFoodList.setPrecision(5);
            modelTableFoodJournal.setPrecision(5);
            modelTableMixDiff.setPrecision(5);
            modelTableRda.setPrecision(5);
            stringModelMixPct.setPrecision(5);
            modelTableNutrientLookup.setPrecision(5);
            modelTableNutrientInput.setPrecision(5);
        }
        if (isMixSelected()) {
            MixDataObject mixDataObject = (MixDataObject) listMixes.getSelectedValue();
            Integer mixId = mixDataObject.getMixId();
            reloadTableModelsThatNeedMixId(mixId);
            resizeColumns();
        }
        reloadFoodItems();
        reloadFoodJournal();
        reloadMixComparison();
        reloadRdaCheck();
        reloadNutrientLookup();
    }

    private void event_menuItemNutrientsShownAsConstraints() {
        JPanel panel = new JPanel();
        FormLayout layout = new FormLayout(
                "min:grow", //columns
                "fill:min:grow" //rows
        );
        panel.setBorder(new TitledBorder("Pick nutrients to be shown as constraints"));
        panel.setLayout(layout);
        panel.add(getConstraintsPanel(), cc.xy(1, 1));
        panel.setPreferredSize(new Dimension(600, 265));
        JComponent[] inputs = new JComponent[]{
                panel
        };
        int optionValue = Message.showOptionDialog(inputs, "Nutrients Shown As Constraints");
        if (optionValue == 0) {
            mapConstraintCheckboxes.forEach((k, v) -> {
                        try {
                            if (v.isSelected()) {
                                dbLink.Nutrient_Update(k, 1);
                            } else {
                                dbLink.Nutrient_Update(k, 0);
                            }
                        } catch (SQLException e) {
                            Log.getLog().start("files/exception.log");
                            Log.getLog().logMessage(e.toString());
                            Log.getLog().write();
                            Log.getLog().close();
                            e.printStackTrace();
                        }
                    }
            );
            reloadNutrientComboBoxes();
        }
    }

    private JPanel getConstraintsPanel() {
        JPanel panel00 = new JPanel();
        FormLayout panel00Layout = new FormLayout(
                "min:grow", //columns
                "fill:min:grow" //rows
        );
        panel00.setLayout(panel00Layout);
        JPanel panel01 = new JPanel();
        FormLayout panel01Layout = new FormLayout(
                "min,min,min,min,min,min,min,min,min,min,min,min", //columns
                "min,min,min,min,min,min,min,min,min,min" //rows
        );
        panel01.setLayout(panel01Layout);
        panel00.add(new JScrollPane(panel01), cc.xy(1, 1));
        Object[] it = mapConstraintCheckboxes.entrySet().toArray();
        for (int x = 1; x < it.length + 1; x++) {
            Map.Entry entry = (Map.Entry) it[x - 1];
            JCheckBox cb = (JCheckBox) entry.getValue();
            JLabel label = new JLabel(cb.getName());
            label.setHorizontalAlignment(SwingConstants.RIGHT);
            if (x < 11) {
                panel01.add(label, cc.xy(1, x));
                panel01.add(cb, cc.xy(2, x));
            } else if (x < 21) {
                panel01.add(label, cc.xy(3, x - 10));
                panel01.add(cb, cc.xy(4, x - 10));
            } else if (x < 31) {
                panel01.add(label, cc.xy(5, x - 20));
                panel01.add(cb, cc.xy(6, x - 20));
            } else if (x < 41) {
                panel01.add(label, cc.xy(7, x - 30));
                panel01.add(cb, cc.xy(8, x - 30));
            } else if (x < 51) {
                panel01.add(label, cc.xy(9, x - 40));
                panel01.add(cb, cc.xy(10, x - 40));
            }
        }
        return panel00;
    }

    private void event_menuItemExit() {
        dbLink.Shutdown();
        //frame.dispose();
        System.exit(0);
    }

    private void event_menuItemFoodListExport() {
        ExportFoodList exportFoodList = new ExportFoodList(dbLink);
        exportFoodList.print();
    }

    private void event_menuItemFoodMixesExport() {
        ExportFoodMixes exportFoodMixes = new ExportFoodMixes(dbLink);
        exportFoodMixes.print();
    }

    private void event_menuItemMixComparisonExport() {
        if (isListCompareASelected() && isListCompareBSelected()) {
            ExportMixComparison exportMixComparison = new ExportMixComparison(dbLink);
            exportMixComparison.print(modelTableMixDiff, listCompareA, listCompareB);
        } else {
            Message.showMessage("Please select mix at Mix Comparison Panel\nand try again");
        }
    }

    private void event_menuItemRdaCheckExport() {
        if (isRdaMixSelected()) {
            MixDataObject mixDataObject = (MixDataObject) listRdaCheck.getSelectedValue();
            RdaLifeStageDataObject rdaLifeStageDataObject = (RdaLifeStageDataObject) comboBoxLifeStage.getSelectedItem();
            ExportRdaCheck exportRdaCheck = new ExportRdaCheck(dbLink);
            exportRdaCheck.print(mixDataObject, rdaLifeStageDataObject.getLifeStageId());
        } else {
            Message.showMessage("Please select mix at RDA Check Panel\nand try again");
        }
    }

    private void event_menuItemNutrientLookupExport() {
        if (!textFieldNutrientLookup.getText().isBlank()) {
            ExportNutrientLookup exportNutrientLookup = new ExportNutrientLookup(dbLink);
            exportNutrientLookup.print(textFieldNutrientLookup, comboBoxNutrientLookupListNutrient);
        } else {
            Message.showMessage("Please enter nutrient weight at Nutrient Lookup Tab\nand try again");
        }
    }

    private void event_menuItemGuide() {
        openUrl("http://x-jrga.github.io/snack");
    }

    private void event_menuItemCredits() {
        StringBuffer sb = new StringBuffer();
        sb.append("Snack uses the following libraries:");
        sb.append("\n\n");
        sb.append("commons-math3-3.6.1.jar");
        sb.append("\n");
        sb.append("hsqldb-2.5.1.jar");
        sb.append("\n");
        sb.append("jgoodies-common-1.8.1.jar");
        sb.append("\n");
        sb.append("jgoodies-forms-1.8.0.jar");
        sb.append("\n");
        sb.append("poi-4.1.0.jar");
        sb.append("\n\n\n");
        sb.append("Snack uses a data subset from:");
        sb.append("\n\n");
        sb.append("1) USDA National Nutrient Database for Standard Reference, Release 28");
        sb.append("\n\n");
        sb.append("2) Dietary Reference Intakes Nutrient Recommendations Report from");
        sb.append("\n");
        sb.append("   Food and Nutrition Board of the Institute of Medicine, National Academy of Sciences");
        JTextArea textArea = new JTextArea();
        textArea.setText(sb.toString());
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(700, 433));
        JComponent[] inputs = new JComponent[]{
                scrollPane
        };
        Message.showOptionDialog(inputs, "Credits");
    }

    private void event_menuItemAbout() {
        StringBuffer sb = new StringBuffer();
        String txt = "Features:\n" +
                "        - quantify food intake\n" +
                "        - track any nutrient or compound that has an impact on health\n" +
                "        - find food items that provide a specific nutrient\n" +
                "        - keep a food journal and track progress\n" +
                "        - compare two meals to see difference in nutritional value\n" +
                "        - compare meals against Required Daily Allowance (RDA) values\n" +
                "        - compare meals against Upper Limit (UL) values       \n" +
                "        - export data and create reports in spreadsheet      \n" +
                "        - quantify any popular diet for comparison and research purposes       \n" +
                "        - annotate mixes\n" +
                "        - calculate basal metabolic rate (BMR)\n" +
                "        - calculate glycemic index (GI) and glycemic load (GL) of a meal\n" +
                "        - check glycemic index range\n" +
                "        - calculate food quotient (FQ)                \n" +
                "        - convert percent daily value (%DV) to grams\n" +
                "        - facilitate learning/teaching anyone with interest in nutrition\n" +
                "        - is free and open source\n" +
                "    \n" +
                "    Requirements:\n" +
                "       - Java 11";
        sb.append(txt);
        sb.append("\n\n");
        sb.append("This is build 631");
        sb.append("\n\n");
        sb.append("Please send your comments and suggestions to jorge.r.garciadealba+snack@gmail.com");
        JTextArea textArea = new JTextArea();
        textArea.setText(sb.toString());
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(700, 433));
        JComponent[] inputs = new JComponent[]{
                scrollPane
        };
        Message.showOptionDialog(inputs, "About");
    }

    private JPanel getResults() {
        JPanel panel = new JPanel();
        //create layouts
        FormLayout layout = new FormLayout(
                "min:grow,40dlu", //columns
                "fill:min:grow" //rows
        );
        panel.setLayout(layout);
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.setBorder(new TitledBorder("Mix Results"));
        tabbedPane.setTabPlacement(JTabbedPane.BOTTOM);
        tabbedPane.add(getEnergy());
        tabbedPane.add(getProtein());
        tabbedPane.add(getFats());
        tabbedPane.add(getCarbs());
        tabbedPane.add(getVitamins());
        tabbedPane.add(getMinerals());
        tabbedPane.add(getElectrolytes());
        tabbedPane.add(getWater());
        tabbedPane.add(getCost());
        tabbedPane.add(getGlycemic());
        tabbedPane.setTitleAt(0, "Energy");
        tabbedPane.setTitleAt(1, "Protein");
        tabbedPane.setTitleAt(2, "Fats");
        tabbedPane.setTitleAt(3, "Carbohydrates");
        tabbedPane.setTitleAt(4, "Vitamins");
        tabbedPane.setTitleAt(5, "Minerals");
        tabbedPane.setTitleAt(6, "Electrolytes");
        tabbedPane.setTitleAt(7, "Water");
        tabbedPane.setTitleAt(8, "Cost");
        tabbedPane.setTitleAt(9, "Glycemic");
        JScrollPane highScorePane = new JScrollPane(listHighScore);
        panel.add(tabbedPane, cc.xy(1, 1));
        panel.add(highScorePane, cc.xy(2, 1));
        highScorePane.setBorder(new TitledBorder("Calories"));
        highScorePane.setMinimumSize(new Dimension(0, 200));
        highScorePane.setToolTipText("Total calories in mix");
        DefaultListCellRenderer renderer = (DefaultListCellRenderer) listHighScore.getCellRenderer();
        renderer.setHorizontalAlignment(SwingConstants.RIGHT);
        listHighScore.setModel(modelListHighScore);
        listHighScore.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent keyEvent) {
            }

            @Override
            public void keyPressed(KeyEvent keyEvent) {
                if (keyEvent.getKeyCode() == KeyEvent.VK_DELETE) {
                    event_listHighScore();
                }
            }

            @Override
            public void keyReleased(KeyEvent keyEvent) {
            }
        });
        return panel;
    }

    private JScrollPane getGlycemic() {
        JScrollPane scrollPane = new JScrollPane(tableGlycemic);
        tableGlycemic.setModel(modelTableGlycemic);
        tableGlycemic.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tableGlycemic.setFillsViewportHeight(true);
        tableGlycemic.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tableGlycemic.setTableHeader(new TableHeaderGlycemic(tableGlycemic.getColumnModel()));
        tableGlycemic.getTableHeader().setReorderingAllowed(false);
        return scrollPane;
    }

    private JScrollPane getEnergy() {
        JScrollPane scrollPane = new JScrollPane(tableEnergy);
        tableEnergy.setModel(modelTableEnergy);
        tableEnergy.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tableEnergy.setFillsViewportHeight(true);
        tableEnergy.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tableEnergy.setTableHeader(new TableHeaderEnergy(tableEnergy.getColumnModel()));
        tableEnergy.getTableHeader().setReorderingAllowed(false);
        return scrollPane;
    }

    private JScrollPane getProtein() {
        JScrollPane scrollPane = new JScrollPane(tableProtein);
        tableProtein.setModel(modelTableProtein);
        tableProtein.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tableProtein.setFillsViewportHeight(true);
        tableProtein.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tableProtein.setTableHeader(new TableHeaderProtein(tableProtein.getColumnModel()));
        tableProtein.getTableHeader().setReorderingAllowed(false);
        return scrollPane;
    }

    private JScrollPane getFats() {
        JScrollPane scrollPane = new JScrollPane(tableFat);
        tableFat.setModel(modelTableFat);
        tableFat.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tableFat.setFillsViewportHeight(true);
        tableFat.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tableFat.setTableHeader(new TableHeaderFats(tableFat.getColumnModel()));
        tableFat.getTableHeader().setReorderingAllowed(false);
        return scrollPane;
    }

    private JScrollPane getCarbs() {
        JScrollPane scrollPane = new JScrollPane(tableCarbs);
        tableCarbs.setModel(modelTableCarbs);
        tableCarbs.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tableCarbs.setFillsViewportHeight(true);
        tableCarbs.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tableCarbs.setTableHeader(new TableHeaderCarbs(tableCarbs.getColumnModel()));
        tableCarbs.getTableHeader().setReorderingAllowed(false);
        return scrollPane;
    }

    private JScrollPane getVitamins() {
        JScrollPane scrollPane = new JScrollPane(tableVitamins);
        tableVitamins.setModel(modelTableVitamins);
        tableVitamins.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tableVitamins.setFillsViewportHeight(true);
        tableVitamins.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tableVitamins.setTableHeader(new TableHeaderVitamins(tableVitamins.getColumnModel()));
        tableVitamins.getTableHeader().setReorderingAllowed(false);
        return scrollPane;
    }

    private JScrollPane getMinerals() {
        JScrollPane scrollPane = new JScrollPane(tableMinerals);
        tableMinerals.setModel(modelTableMinerals);
        tableMinerals.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tableMinerals.setFillsViewportHeight(true);
        tableMinerals.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tableMinerals.setTableHeader(new TableHeaderMinerals(tableMinerals.getColumnModel()));
        tableMinerals.getTableHeader().setReorderingAllowed(false);
        return scrollPane;
    }

    private JScrollPane getElectrolytes() {
        JScrollPane scrollPane = new JScrollPane(tableElectrolytes);
        tableElectrolytes.setModel(modelTableElectrolytes);
        tableElectrolytes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tableElectrolytes.setFillsViewportHeight(true);
        tableElectrolytes.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tableElectrolytes.setTableHeader(new TableHeaderElectrolytes(tableElectrolytes.getColumnModel()));
        tableElectrolytes.getTableHeader().setReorderingAllowed(false);
        return scrollPane;
    }

    private JScrollPane getWater() {
        JScrollPane scrollPane = new JScrollPane(tableWater);
        tableWater.setModel(modelTableWater);
        tableWater.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tableWater.setFillsViewportHeight(true);
        tableWater.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tableWater.setTableHeader(new TableHeaderWater(tableWater.getColumnModel()));
        tableWater.getTableHeader().setReorderingAllowed(false);
        return scrollPane;
    }

    private JScrollPane getCost() {
        JScrollPane scrollPane = new JScrollPane(tableCost);
        tableCost.setModel(modelTableCost);
        tableCost.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tableCost.setFillsViewportHeight(true);
        tableCost.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tableCost.setTableHeader(new TableHeaderCost(tableCost.getColumnModel()));
        tableCost.getTableHeader().setReorderingAllowed(false);
        return scrollPane;
    }

    private void event_listHighScore() {
        modelListHighScore.clear();
    }

    private JPanel getMixFood() {
        JPanel panel = new JPanel();
        FormLayout panelLayout = new FormLayout("min:grow,min,min:grow", //columns
                "fill:min:grow" //rows
        );
        panel.setLayout(panelLayout);
        JPanel buttons = new JPanel();
        FormLayout buttonLayout = new FormLayout("min", //columns
                "min:grow,min,min,min,min,min:grow" //rows
        );
        buttons.setLayout(buttonLayout);
        JScrollPane scrSelectedFood = new JScrollPane(listSelectedFood);
        scrSelectedFood.setBorder(new TitledBorder("Food"));
        JScrollPane s_store = new JScrollPane(treeFoodList);
        s_store.setBorder(new TitledBorder("Store"));
        //database
        modelTreeFoodList.reload();
        treeFoodList.setModel(modelTreeFoodList);
        JButton buttonAddMixFood = new JButton("+");
        JButton buttonDeleteMixFood = new JButton("-");
        JButton buttonExpandMixFood = new JButton("e");
        JButton buttonCollapseMixFood = new JButton("c");
        buttons.add(buttonAddMixFood, cc.xy(1, 2));
        buttons.add(buttonDeleteMixFood, cc.xy(1, 3));
        buttons.add(buttonExpandMixFood, cc.xy(1, 4));
        buttons.add(buttonCollapseMixFood, cc.xy(1, 5));
        panel.add(s_store, cc.xy(1, 1));
        panel.add(buttons, cc.xy(2, 1));
        panel.add(scrSelectedFood, cc.xy(3, 1));
        buttonAddMixFood.setToolTipText("Add Food Item to Mix");
        buttonDeleteMixFood.setToolTipText("Delete Food Item from Mix");
        buttonExpandMixFood.setToolTipText("Expand Food List");
        buttonCollapseMixFood.setToolTipText("Collapse Food List");
        buttonAddMixFood.addActionListener(e -> event_buttonAddMixFood());
        buttonDeleteMixFood.addActionListener(e -> event_buttonDeleteMixFood());
        buttonExpandMixFood.addActionListener(e -> event_buttonExpandMixFood());
        buttonCollapseMixFood.addActionListener(e -> event_buttonCollapseMixFood());
        listSelectedFood.setModel(modelListSelectedFood);
        return panel;
    }

    private JPanel getAmountOfNutrientConstraint() {
        JPanel panel = new JPanel();
        FormLayout panelLayout = new FormLayout(
                "min,min,min", //columns
                "min,fill:min:grow,min" //rows
        );
        panel.setLayout(panelLayout);
        JScrollPane constraintList = new JScrollPane(tableNutrientConstraint);
        JPanel buttons = new JPanel();
        textFieldNutrientConstraintQuantity.setMinimumSize(new Dimension(100, 25));
        panel.add(comboBoxNutrientConstraintNutrient, cc.xy(1, 1));
        panel.add(comboBoxNutrientConstraintRelationship, cc.xy(2, 1));
        panel.add(textFieldNutrientConstraintQuantity, cc.xy(3, 1));
        panel.add(constraintList, cc.xyw(1, 2, 3));
        buttons.add(buttonNutrientConstraintAdd);
        buttons.add(buttonNutrientConstraintDelete);
        panel.add(buttons, cc.xyw(1, 3, 3));
        constraintList.setBorder(new TitledBorder("Nutrient Constraints"));
        comboBoxNutrientConstraintNutrient.setMaximumRowCount(10);
        comboBoxNutrientConstraintNutrient.setModel(modelComboBox_NutrientAtNutrientConstraint);
        comboBoxNutrientConstraintRelationship.setMaximumRowCount(3);
        comboBoxNutrientConstraintRelationship.setModel(modelComboBox_RelationshipAtNutrient);
        tableNutrientConstraint.getTableHeader().setReorderingAllowed(false);
        tableNutrientConstraint.setModel(modelTableNutrientConstraints);
        tableNutrientConstraint.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        buttonNutrientConstraintAdd.setToolTipText("Add Constraint");
        buttonNutrientConstraintDelete.setToolTipText("Delete Constraint");
        buttonNutrientConstraintAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                event_buttonNutrientConstraintAdd();
            }
        });
        buttonNutrientConstraintDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                event_buttonNutrientConstraintDelete();
            }
        });
        tableNutrientConstraint.setFillsViewportHeight(true);
        return panel;
    }

    private JPanel getAmountOfFoodNutrientConstraint() {
        JPanel panel = new JPanel();
        FormLayout panelLayout = new FormLayout(
                "min,min,min,550px", //columns
                "min,min,fill:min:grow,min" //rows
        );
        panel.setLayout(panelLayout);
        JScrollPane spTable = new JScrollPane(tableFoodNutrientConstraint);
        JPanel buttons = new JPanel();
        textFieldFoodNutrientConstraintQuantity.setMinimumSize(new Dimension(100, 25));
        panel.add(comboBoxFoodNutrientConstraintFood, cc.xyw(1, 1, 4));
        panel.add(comboBoxFoodNutrientConstraintNutrient, cc.xy(1, 2));
        panel.add(comboBoxFoodNutrientConstraintRelationship, cc.xy(2, 2));
        panel.add(textFieldFoodNutrientConstraintQuantity, cc.xy(3, 2));
        panel.add(spTable, cc.xyw(1, 3, 4));
        buttons.add(buttonFoodNutrientConstraintAdd);
        buttons.add(buttonFoodNutrientConstraintDelete);
        panel.add(buttons, cc.xyw(1, 4, 4));
        spTable.setBorder(new TitledBorder("Food Nutrient Constraints"));
        comboBoxFoodNutrientConstraintNutrient.setMaximumRowCount(10);
        comboBoxFoodNutrientConstraintNutrient.setModel(modelComboBox_NutrientAtNutrientPctContraint);
        comboBoxFoodNutrientConstraintRelationship.setMaximumRowCount(3);
        comboBoxFoodNutrientConstraintRelationship.setModel(modelComboBox_RelationshipAtFoodNutrient);
        comboBoxFoodNutrientConstraintFood.setMaximumRowCount(10);
        comboBoxFoodNutrientConstraintFood.setModel(modelComboBox_FoodAtNutrient);
        tableFoodNutrientConstraint.getTableHeader().setReorderingAllowed(false);
        tableFoodNutrientConstraint.setModel(modelTableFoodNutrientConstraints);
        tableFoodNutrientConstraint.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        buttonFoodNutrientConstraintAdd.setToolTipText("Add Constraint");
        buttonFoodNutrientConstraintDelete.setToolTipText("Delete Constraint");
        buttonFoodNutrientConstraintAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                event_buttonFoodNutrientConstraintAdd();
            }
        });
        buttonFoodNutrientConstraintDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                event_buttonFoodNutrientConstraintDelete();
            }
        });
        tableFoodNutrientConstraint.setFillsViewportHeight(true);
        return panel;
    }

    private JPanel getNutrientRatioConstraint() {
        JPanel panel = new JPanel();
        FormLayout panelLayout = new FormLayout(
                "660px,min", //columns
                "min,min,fill:min:grow,min" //rows
        );
        panel.setLayout(panelLayout);
        JScrollPane spTable = new JScrollPane(tableNutrientRatio);
        JPanel buttons = new JPanel();
        textFieldNutrientRatioNutrientA.setMinimumSize(new Dimension(100, 25));
        textFieldNutrientRatioNutrientB.setMinimumSize(new Dimension(100, 25));
        panel.add(comboBoxNutrientRatioNutrientA, cc.xy(1, 1));
        panel.add(textFieldNutrientRatioNutrientA, cc.xy(2, 1));
        panel.add(comboBoxNutrientRatioNutrientB, cc.xy(1, 2));
        panel.add(textFieldNutrientRatioNutrientB, cc.xy(2, 2));
        panel.add(spTable, cc.xyw(1, 3, 2));
        buttons.add(buttonNutrientRatioAdd);
        buttons.add(buttonNutrientRatioDelete);
        panel.add(buttons, cc.xyw(1, 4, 2));
        spTable.setBorder(new TitledBorder("Nutrient Ratio Constraints"));
        comboBoxNutrientRatioNutrientA.setMaximumRowCount(10);
        comboBoxNutrientRatioNutrientA.setModel(modelComboBox_0_NutrientAtNutrientRatio);
        comboBoxNutrientRatioNutrientB.setMaximumRowCount(10);
        comboBoxNutrientRatioNutrientB.setModel(modelComboBox_1_NutrientAtNutrientRatio);
        tableNutrientRatio.getTableHeader().setReorderingAllowed(false);
        tableNutrientRatio.setModel(modelTableNutrientRatioConstraints);
        tableNutrientRatio.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        buttonNutrientRatioAdd.setToolTipText("Add Constraint");
        buttonNutrientRatioDelete.setToolTipText("Delete Constraint");
        buttonNutrientRatioAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                event_buttonNutrientRatioAdd();
            }
        });
        buttonNutrientRatioDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                event_buttonNutrientRatioDelete();
            }
        });
        tableNutrientRatio.setFillsViewportHeight(true);
        return panel;
    }

    private JPanel getFoodNutrientRatioConstraint() {
        JPanel panel = new JPanel();
        FormLayout panelLayout = new FormLayout(
                "min,min,min:grow", //columns
                "min,min,min,min,fill:min:grow,min" //rows
        );
        panel.setLayout(panelLayout);
        JScrollPane spTable = new JScrollPane(tableFoodNutrientRatio);
        JPanel buttons = new JPanel();
        textFieldFoodNutrientRatioQuantityA.setMinimumSize(new Dimension(100, 25));
        textFieldFoodNutrientRatioQuantityB.setMinimumSize(new Dimension(100, 25));
        panel.add(comboBoxFoodNutrientRatioFoodA, cc.xyw(1, 1, 3));
        panel.add(comboBoxFoodNutrientRatioNutrientA, cc.xy(1, 2));
        panel.add(textFieldFoodNutrientRatioQuantityA, cc.xy(2, 2));
        panel.add(comboBoxFoodNutrientRatioFoodB, cc.xyw(1, 3, 3));
        panel.add(comboBoxFoodNutrientRatioNutrientB, cc.xy(1, 4));
        panel.add(textFieldFoodNutrientRatioQuantityB, cc.xy(2, 4));
        panel.add(spTable, cc.xyw(1, 5, 3));
        buttons.add(buttonFoodNutrientRatioAdd);
        buttons.add(buttonFoodNutrientRatioDelete);
        panel.add(buttons, cc.xyw(1, 6, 3));
        spTable.setBorder(new TitledBorder("Food Nutrient Ratio Constraints"));
        comboBoxFoodNutrientRatioNutrientA.setMaximumRowCount(10);
        comboBoxFoodNutrientRatioNutrientA.setModel(modelComboBox_0_NutrientAtFoodNutrientRatio);
        comboBoxFoodNutrientRatioNutrientB.setMaximumRowCount(10);
        comboBoxFoodNutrientRatioNutrientB.setModel(modelComboBox_1_NutrientAtFoodNutrientRatio);
        comboBoxFoodNutrientRatioFoodA.setMaximumRowCount(10);
        comboBoxFoodNutrientRatioFoodA.setModel(modelComboBox_0_FoodAtFoodNutrientRatio);
        comboBoxFoodNutrientRatioFoodB.setMaximumRowCount(10);
        comboBoxFoodNutrientRatioFoodB.setModel(modelComboBox_1_FoodAtFoodNutrientRatio);
        tableFoodNutrientRatio.getTableHeader().setReorderingAllowed(false);
        tableFoodNutrientRatio.setModel(modelTableFoodNutrientRatioConstraints);
        tableFoodNutrientRatio.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        buttonFoodNutrientRatioAdd.setToolTipText("Add Constraint");
        buttonFoodNutrientRatioDelete.setToolTipText("Delete Constraint");
        buttonFoodNutrientRatioAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                event_buttonFoodNutrientRatioAdd();
            }
        });
        buttonFoodNutrientRatioDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                event_buttonFoodNutrientRatioDelete();
            }
        });
        tableFoodNutrientRatio.setFillsViewportHeight(true);
        return panel;
    }

    private JPanel getPercentOfNutrientConstraint() {
        JPanel panel = new JPanel();
        FormLayout panelLayout = new FormLayout(
                "min,min,min,550px", //columns
                "min,min,fill:min:grow,min" //rows
        );
        panel.setLayout(panelLayout);
        JScrollPane spTable = new JScrollPane(tableNutrientPercentConstraint);
        JPanel buttons = new JPanel();
        textFieldPercentNutrientConstraintQuantity.setMinimumSize(new Dimension(100, 25));
        panel.add(comboBoxPercentNutrientConstraintFood, cc.xyw(1, 1, 4));
        panel.add(comboBoxPercentNutrientConstraintNutrient, cc.xy(1, 2));
        panel.add(textFieldPercentNutrientConstraintQuantity, cc.xy(2, 2));
        panel.add(new JLabel("%"), cc.xy(3, 2));
        panel.add(spTable, cc.xyw(1, 3, 4));
        buttons.add(buttonPercentNutrientConstraintAdd);
        buttons.add(buttonPercentNutrientConstraintDelete);
        panel.add(buttons, cc.xyw(1, 4, 4));
        spTable.setBorder(new TitledBorder("Percent of Nutrient Constraints"));
        comboBoxPercentNutrientConstraintNutrient.setMaximumRowCount(10);
        comboBoxPercentNutrientConstraintNutrient.setModel(modelComboBox_NutrientAtNutrientPctContraint);
        comboBoxPercentNutrientConstraintFood.setMaximumRowCount(10);
        comboBoxPercentNutrientConstraintFood.setModel(modelComboBox_FoodAtNutrientPct);
        tableNutrientPercentConstraint.getTableHeader().setReorderingAllowed(false);
        tableNutrientPercentConstraint.setModel(tableModelPercentNutrientConstraints);
        tableNutrientPercentConstraint.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        buttonPercentNutrientConstraintAdd.setToolTipText("Add Constraint");
        buttonPercentNutrientConstraintDelete.setToolTipText("Delete Constraint");
        buttonPercentNutrientConstraintAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                event_buttonPercentNutrientConstraintAdd();
            }
        });
        buttonPercentNutrientConstraintDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                event_buttonPercentNutrientConstraintDelete();
            }
        });
        tableNutrientPercentConstraint.setFillsViewportHeight(true);
        return panel;
    }

    private void event_buttonPercentNutrientConstraintDelete() {
        if (isMixSelected()) {
            try {
                int selectedRow = tableNutrientPercentConstraint.getSelectedRow();
                Integer mixid = (Integer) tableNutrientPercentConstraint.getValueAt(selectedRow, 0);
                String foodid = (String) tableNutrientPercentConstraint.getValueAt(selectedRow, 1);
                String nutrientid = (String) tableNutrientPercentConstraint.getValueAt(selectedRow, 2);
                dbLink.PercentNutrientConstraint_Delete(mixid, foodid, nutrientid);
                tableModelPercentNutrientConstraints.reload(mixid);
                resizeColumns_PercentNutrientConstraintTableColumns();
            } catch (SQLException e) {
                Log.getLog().start("files/exception.log");
                Log.getLog().logMessage(e.toString());
                Log.getLog().write();
                Log.getLog().close();
                e.printStackTrace();
            }
        }
    }

    private void event_buttonPercentNutrientConstraintAdd() {
        if (isMixSelected()) {
            if (isItReadyToAddPercentNutrientConstraint()) {
                NumberCheck numberCheck = new NumberCheck();
                numberCheck.addToUncheckedList(textFieldPercentNutrientConstraintQuantity.getText());
                if (numberCheck.pass()) {
                    try {
                        MixDataObject mix = (MixDataObject) listMixes.getSelectedValue();
                        FoodDataObject foodDataObject = (FoodDataObject) comboBoxPercentNutrientConstraintFood.getSelectedItem();
                        NutrientDataObject nutrientDataObject = (NutrientDataObject) comboBoxPercentNutrientConstraintNutrient.getSelectedItem();
                        Double b = Double.parseDouble(textFieldPercentNutrientConstraintQuantity.getText());
                        dbLink.PercentNutrientConstraint_Merge(mix.getMixId(), foodDataObject.getFoodId(), nutrientDataObject.getNutr_no(), b);
                        tableModelPercentNutrientConstraints.reload(mix.getMixId());
                        resizeColumns_PercentNutrientConstraintTableColumns();
                    } catch (SQLException e) {
                        Log.getLog().start("files/exception.log");
                        Log.getLog().logMessage(e.toString());
                        Log.getLog().write();
                        Log.getLog().close();
                        e.printStackTrace();
                    }
                } else {
                    Message.showMessage("Value must be a number greater than or equal to zero");
                }
            }
        }
    }

    private void resizeColumns_PercentNutrientConstraintTableColumns() {
        tableNutrientPercentConstraint.getColumnModel().getColumn(0).setMinWidth(0);
        tableNutrientPercentConstraint.getColumnModel().getColumn(0).setMaxWidth(0);
        tableNutrientPercentConstraint.getColumnModel().getColumn(1).setMinWidth(0);
        tableNutrientPercentConstraint.getColumnModel().getColumn(1).setMaxWidth(0);
        tableNutrientPercentConstraint.getColumnModel().getColumn(2).setMinWidth(0);
        tableNutrientPercentConstraint.getColumnModel().getColumn(2).setMaxWidth(0);
        tableNutrientPercentConstraint.getColumnModel().getColumn(3).setMinWidth(480);
        tableNutrientPercentConstraint.getColumnModel().getColumn(3).setMaxWidth(480);
        tableNutrientPercentConstraint.getColumnModel().getColumn(4).setMinWidth(250);
        tableNutrientPercentConstraint.getColumnModel().getColumn(4).setMaxWidth(250);
        tableNutrientPercentConstraint.getColumnModel().getColumn(5).setMinWidth(50);
        tableNutrientPercentConstraint.getColumnModel().getColumn(5).setMaxWidth(50);
    }

    private boolean isItReadyToAddPercentNutrientConstraint() {
        Boolean flag_isReady = false;
        Boolean flag_listFood = false;
        Boolean flag_listNutrient = false;
        Boolean flag_quantity = false;
        if (comboBoxPercentNutrientConstraintFood.getSelectedIndex() != -1) {
            flag_listFood = true;
        } else {
            Message.showMessage("Select food");
        }
        if (comboBoxPercentNutrientConstraintNutrient.getSelectedIndex() != -1) {
            flag_listNutrient = true;
        } else {
            Message.showMessage("Select nutrient");
        }
        if (!textFieldPercentNutrientConstraintQuantity.getText().isEmpty()) {
            flag_quantity = true;
        } else {
            Message.showMessage("Specify amount");
        }
        if (flag_listFood && flag_listNutrient && flag_quantity) {
            flag_isReady = true;
        }
        return flag_isReady;
    }

    private JPanel getModel() {
        JPanel panel = new JPanel();
        //create layouts
        FormLayout layout = new FormLayout(
                "min:grow", //columns
                "fill:pref:grow" //rows
        );
        //specify layouts
        panel.setLayout(layout);
        //place components
        textAreaLPModel.setLineWrap(false);
        JScrollPane scrollPane = new JScrollPane(textAreaLPModel);
        scrollPane.setPreferredSize(new Dimension(0, 0));
        panel.add(scrollPane, cc.xy(1, 1));
        scrollPane.setBorder(new TitledBorder("Model"));
        return panel;
    }

    private JPanel getNote() {
        JPanel panel = new JPanel();
        //create layouts
        FormLayout layout = new FormLayout(
                "min:grow", //columns
                "fill:pref:grow" //rows
        );
        //specify layouts
        panel.setLayout(layout);
        //place components
        textAreaNote.setLineWrap(false);
        JScrollPane scrollPane = new JScrollPane(textAreaNote);
        scrollPane.setPreferredSize(new Dimension(0, 0));
        panel.add(scrollPane, cc.xy(1, 1));
        scrollPane.setBorder(new TitledBorder("Note"));
        return panel;
    }

    private void event_listMixes(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()) {
            if (isMixSelected()) {
                MixDataObject mixDataObject = (MixDataObject) listMixes.getSelectedValue();
                Integer mixId = mixDataObject.getMixId();
                Integer selectedIndex = listMixes.getSelectedIndex();
                modelListSelectedFood.reload(mixId);
                reloadFoodComboBoxes(mixId);
                reloadTableModelConstraints(mixId);
                reloadTableModelsThatNeedMixId(mixId);
                resizeColumns();
                textAreaLPModel.setText(getLinearProgrammingModel(mixId));
                textAreaNote.setText(getNote(mixId));
            }
        }
    }

    private String getLinearProgrammingModel(Integer mixId) {
        String model = "";
        try {
            LinkedList all = (LinkedList) dbLink.Mix_Select_Other(mixId);
            Iterator it = all.iterator();
            HashMap row = (HashMap) it.next();
            model = (String) row.get("MODEL");
        } catch (SQLException e) {
            Log.getLog().start("files/exception.log");
            Log.getLog().logMessage(e.toString());
            Log.getLog().write();
            Log.getLog().close();
            e.printStackTrace();
        }
        return model;
    }

    private String getNote(Integer mixId) {
        String note = "";
        try {
            LinkedList all = (LinkedList) dbLink.Mix_Select_Other(mixId);
            Iterator it = all.iterator();
            HashMap row = (HashMap) it.next();
            note = (String) row.get("NOTE");
        } catch (SQLException e) {
            Log.getLog().start("files/exception.log");
            Log.getLog().logMessage(e.toString());
            Log.getLog().write();
            Log.getLog().close();
            e.printStackTrace();
        }
        return note;
    }

    private void resizeColumns_NutrientConstraintTableColumns() {
        for (int i = 0; i < 3; i++) {
            tableNutrientConstraint.getColumnModel().getColumn(i).setMinWidth(0);
            tableNutrientConstraint.getColumnModel().getColumn(i).setMaxWidth(0);
        }
        //Columns missing on purpose
        tableNutrientConstraint.getColumnModel().getColumn(4).setMinWidth(21);
        tableNutrientConstraint.getColumnModel().getColumn(4).setMaxWidth(21);
        tableNutrientConstraint.getColumnModel().getColumn(5).setMinWidth(60);
        tableNutrientConstraint.getColumnModel().getColumn(5).setMaxWidth(60);
    }

    private void event_listCompareA(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()) {
            reloadMixComparison();
        }
    }

    private void reloadMixComparison() {
        if (isListCompareASelected() && isListCompareBSelected()) {
            MixDataObject mix1 = (MixDataObject) listCompareA.getSelectedValue();
            Integer mixId1 = mix1.getMixId();
            MixDataObject mix2 = (MixDataObject) listCompareB.getSelectedValue();
            Integer mixId2 = mix2.getMixId();
            modelTableMixDiff.reload(mixId1, mixId2);
            resizeColumns_MixComparisonTable();
        }
    }

    private void event_listCompareB(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()) {
            reloadMixComparison();
        }
    }

    private JPanel getCategories() {
        JPanel panel = new JPanel();
        FormLayout layout = new FormLayout(
                "min:grow,min:grow,min:grow", //columns
                "fill:min:grow" //rows
        );
        panel.setLayout(layout);
        JPanel buttons00 = new JPanel();
        FormLayout panelButtonsLayout = new FormLayout(
                "min:grow,min,min,min,min:grow", //columns
                "fill:min:grow" //rows
        );
        buttons00.setLayout(panelButtonsLayout);
        buttons00.add(buttonCategoriesAdd, cc.xy(2, 1));
        buttons00.add(buttonCategoriesDelete, cc.xy(3, 1));
        buttons00.add(buttonCategoriesRename, cc.xy(4, 1));
        buttonCategoriesAdd.setToolTipText("Create Category");
        buttonCategoriesDelete.setToolTipText("Delete Category");
        buttonCategoriesRename.setToolTipText("Rename Category");
        JScrollPane list00 = new JScrollPane(listCategories);
        //
        JPanel buttons01 = new JPanel();
        FormLayout panelButtons01Layout = new FormLayout(
                "min:grow,min,min,min:grow", //columns
                "fill:min:grow" //rows
        );
        buttons01.setLayout(panelButtons01Layout);
        JButton buttonAddFoodToCategory = new JButton("+");
        JButton buttonDeleteFoodFromCategory = new JButton("-");
        buttons01.add(buttonAddFoodToCategory, cc.xy(2, 1));
        buttons01.add(buttonDeleteFoodFromCategory, cc.xy(3, 1));
        buttonAddFoodToCategory.setToolTipText("Put Food Item in Category");
        buttonDeleteFoodFromCategory.setToolTipText("Remove Food Item from Category");
        JScrollPane sp01 = new JScrollPane(listFoodInCategory);
        //
        JPanel panel00 = new JPanel();
        FormLayout layout00 = new FormLayout(
                "min:grow", //columns
                "fill:min:grow,min" //rows
        );
        panel00.setLayout(layout00);
        panel00.add(list00, cc.xy(1, 1));
        panel00.add(buttons00, cc.xy(1, 2));
        panel00.setBorder(new TitledBorder("Categories"));
        //
        JPanel panel01 = new JPanel();
        panel01.setLayout(layout00);
        panel01.add(sp01, cc.xy(1, 1));
        panel01.add(buttons01, cc.xy(1, 2));
        panel01.setBorder(new TitledBorder("Food Items in Category"));
        //
        JPanel panel02 = new JPanel();
        FormLayout layout02 = new FormLayout(
                "min,min:grow", //columns
                "min,fill:min:grow" //rows
        );
        panel02.setLayout(layout02);
        JScrollPane sp02 = new JScrollPane(listAllFoodItems);
        JLabel label = new JLabel("Search: ");
        panel02.add(label, cc.xy(1, 1));
        JTextField textFieldSearch = new JTextField();
        panel02.add(textFieldSearch, cc.xy(2, 1));
        panel02.add(sp02, cc.xyw(1, 2, 2));
        panel02.setBorder(new TitledBorder("All Food Items"));
        //
        panel.add(panel00, cc.xy(1, 1));
        panel.add(panel01, cc.xy(2, 1));
        panel.add(panel02, cc.xy(3, 1));
        //
        listCategories.setModel(modelListCategory);
        modelListCategory.reload();
        listFoodInCategory.setModel(modelListFoodInCategory);
        listAllFoodItems.setModel(modelListFood);
        reloadFoodItems();
        //
        buttonCategoriesAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                event_buttonCategoriesAdd();
            }
        });
        buttonCategoriesRename.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                event_buttonCategoriesRename();
            }
        });
        buttonCategoriesDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                event_buttonCategoriesDelete();
            }
        });
        listCategories.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                event_listCategories(e);
            }
        });
        buttonAddFoodToCategory.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                event_buttonAddFoodToCategory();
            }
        });
        buttonDeleteFoodFromCategory.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                event_buttonDeleteFoodFromCategory();
            }
        });
        textFieldSearch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                event_textFieldSearch(e);
            }
        });
        return panel;
    }

    private void event_textFieldSearch(ActionEvent e) {
        modelListFood.reload(((JTextField) e.getSource()).getText());
    }

    private void event_buttonDeleteFoodFromCategory() {
        if (!listCategories.isSelectionEmpty()) {
            try {
                FoodCategoryDataObject foodCategoryDataObject = (FoodCategoryDataObject) listCategories.getSelectedValue();
                int[] selectedRows = listFoodInCategory.getSelectedIndices();
                for (int i = 0; i < selectedRows.length; i++) {
                    FoodDataObject foodDataObject = (FoodDataObject) modelListFoodInCategory.get(selectedRows[i]);
                    dbLink.CategoryLink_Delete(foodCategoryDataObject.getFoodCategoryId(), foodDataObject.getFoodId());
                }
                reloadFoodItems();
                modelListFoodInCategory.reload(foodCategoryDataObject.getFoodCategoryId());
            } catch (SQLException e) {
                Log.getLog().start("files/exception.log");
                Log.getLog().logMessage(e.toString());
                Log.getLog().write();
                Log.getLog().close();
                e.printStackTrace();
            }
        }
    }

    private void event_buttonAddFoodToCategory() {
        if (!listCategories.isSelectionEmpty()) {
            if (!listAllFoodItems.isSelectionEmpty()) {
                try {
                    FoodCategoryDataObject foodCategoryDataObject = (FoodCategoryDataObject) listCategories.getSelectedValue();
                    int[] selectedRows = listAllFoodItems.getSelectedIndices();
                    for (int i = 0; i < selectedRows.length; i++) {
                        FoodDataObject foodDataObject = (FoodDataObject) modelListFood.get(selectedRows[i]);
                        Integer count = dbLink.CategoryLink_Count(foodCategoryDataObject.getFoodCategoryId(), foodDataObject.getFoodId());
                        if (count == 0) {
                            dbLink.CategoryLink_Insert(foodCategoryDataObject.getFoodCategoryId(), foodDataObject.getFoodId());
                            reloadFoodItems();
                            modelListFoodInCategory.reload(foodCategoryDataObject.getFoodCategoryId());
                        }
                    }
                } catch (SQLException e) {
                    Log.getLog().start("files/exception.log");
                    Log.getLog().logMessage(e.toString());
                    Log.getLog().write();
                    Log.getLog().close();
                    e.printStackTrace();
                }
            }
        }
    }

    private void event_listCategories(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()) {
            if (!listCategories.isSelectionEmpty()) {
                FoodCategoryDataObject foodCategoryDataObject = (FoodCategoryDataObject) listCategories.getSelectedValue();
                String foodCategoryId = foodCategoryDataObject.getFoodCategoryId();
                modelListFoodInCategory.reload(foodCategoryId);
            }
        }
    }

    private void event_buttonNutrientLookupListRun() {
        reloadNutrientLookup();
    }

    private void reloadNutrientLookup() {
        NutrientDataObject nutrientDataObject = (NutrientDataObject) comboBoxNutrientLookupListNutrient.getSelectedItem();
        try {
            String text = textFieldNutrientLookup.getText();
            if (!text.isBlank()) {
                Double q = Double.parseDouble(text);
                modelTableNutrientLookup.reload(nutrientDataObject.getNutr_no(), q);
                resizeColumns_NutrientLookupTable();
            }
        } catch (NumberFormatException e) {
            Log.getLog().start("files/exception.log");
            Log.getLog().logMessage(e.toString());
            Log.getLog().write();
            Log.getLog().close();
            e.printStackTrace();
            Message.showMessage(e.toString());
        }
    }

    private void event_buttonAddMixFood() {
        if (isMixSelected()) {
            MixDataObject mix = (MixDataObject) listMixes.getSelectedValue();
            DefaultMutableTreeNode node = (DefaultMutableTreeNode) treeFoodList.getLastSelectedPathComponent();
            if (node == null) {
                return;
            }
            FoodDataObject food = (FoodDataObject) node.getUserObject();
            if (node.isLeaf()) {
                try {
                    Integer mixId = mix.getMixId();
                    dbLink.MixFood_Insert(mixId, food.getFoodId());
                    modelListSelectedFood.reload(mixId);
                    reloadFoodComboBoxes(mixId);
                } catch (SQLException e) {
                    Log.getLog().start("files/exception.log");
                    Log.getLog().logMessage(e.toString());
                    Log.getLog().write();
                    Log.getLog().close();
                    e.printStackTrace();
                }
            }
        } else {
            Message.showMessage("Select mix");
        }
    }

    private void event_buttonDeleteMixFood() {
        if (isMixSelected()) {
            try {
                MixDataObject mix = (MixDataObject) listMixes.getSelectedValue();
                FoodDataObject foodDataObject = (FoodDataObject) listSelectedFood.getSelectedValue();
                Integer mixId = mix.getMixId();
                dbLink.MixFood_Delete(mixId, foodDataObject.getFoodId());
                modelListSelectedFood.reload(mixId);
                reloadFoodComboBoxes(mixId);
                reloadTableModelConstraints(mixId);
                reloadTableModelsThatNeedMixId(mixId);
                resizeColumns();
            } catch (SQLException e) {
                Log.getLog().start("files/exception.log");
                Log.getLog().logMessage(e.toString());
                Log.getLog().write();
                Log.getLog().close();
                e.printStackTrace();
            }
        }
    }

    private void event_buttonExpandMixFood() {
        int rowCount = treeFoodList.getRowCount();
        this.expandAllNodes(treeFoodList, 0, rowCount);
    }

    private void expandAllNodes(JTree tree, int startingIndex, int rowCount) {
        for (int i = startingIndex; i < rowCount; ++i) {
            tree.expandRow(i);
        }
        if (tree.getRowCount() != rowCount) {
            expandAllNodes(tree, rowCount, tree.getRowCount());
        }
    }

    private void event_buttonCollapseMixFood() {
        int rowCount = treeFoodList.getRowCount();
        for (int i = 1; i < rowCount; i++) {
            treeFoodList.collapseRow(i);
        }
    }

    private void event_buttonSolve() {
        if (isMixSelected()) {
            try {
                MixDataObject mix = (MixDataObject) listMixes.getSelectedValue();
                Integer mixId = mix.getMixId();
                Integer selectedIndex = listMixes.getSelectedIndex();
                textAreaLPModel.setText("");
                LpModel lpModel = new LpModel();
                lpModel.setComponent(getNoFeasibleSolutionPanel());
                //Add objective
                lpModel.addObjective(dbLink.objective_lhs(mixId));
                //Add nutrient constraint
                LinkedList nutrient_constraints = (LinkedList) dbLink.nutrient_rhs(mixId);
                for (int i = 0; i < nutrient_constraints.size(); i++) {
                    HashMap row = (HashMap) nutrient_constraints.get(i);
                    String nutrientid = (String) row.get("NUTRIENTID");
                    Integer relationshipid = (Integer) row.get("RELATIONSHIPID");
                    Double b = (Double) row.get("B");
                    lpModel.addConstraint(dbLink.nutrient_lhs(mixId, nutrientid, relationshipid), relationshipid, b);
                }
                //Add food nutrient constraint
                LinkedList foodnutrientRhsList = (LinkedList) dbLink.foodnutrient_rhs(mixId);
                for (int i = 0; i < foodnutrientRhsList.size(); i++) {
                    HashMap row = (HashMap) foodnutrientRhsList.get(i);
                    String foodid = (String) row.get("FOODID");
                    String nutrientid = (String) row.get("NUTRIENTID");
                    Integer relationshipid = (Integer) row.get("RELATIONSHIPID");
                    Double b = (double) row.get("B");
                    lpModel.addConstraint(dbLink.foodnutrient_lhs(mixId, foodid, nutrientid, relationshipid), relationshipid, b);
                }
                //Add food nutrient ratio constraint
                LinkedList foodnutrientratioRhsList = (LinkedList) dbLink.foodnutrientratio_rhs(mixId);
                for (int i = 0; i < foodnutrientratioRhsList.size(); i++) {
                    HashMap row = (HashMap) foodnutrientratioRhsList.get(i);
                    String foodid1 = (String) row.get("FOOD_ID_1");
                    String nutrientid1 = (String) row.get("NUTRIENT_ID_1");
                    String foodid2 = (String) row.get("FOOD_ID_2");
                    String nutrientid2 = (String) row.get("NUTRIENT_ID_2");
                    int relationshipid = (int) row.get("RELATIONSHIPID");
                    Double b = (Double) row.get("B");
                    lpModel.addConstraint(dbLink.foodnutrientratio_lhs(mixId, foodid1, nutrientid1, foodid2, nutrientid2, relationshipid), relationshipid, b);
                }
                //Add nutrient ratio constraint
                LinkedList nutrientratioRhsList = (LinkedList) dbLink.nutrientratio_rhs(mixId);
                for (int i = 0; i < nutrientratioRhsList.size(); i++) {
                    HashMap row = (HashMap) nutrientratioRhsList.get(i);
                    String nutrientid1 = (String) row.get("NUTRIENT_ID_1");
                    String nutrientid2 = (String) row.get("NUTRIENT_ID_2");
                    int relationshipid = (int) row.get("RELATIONSHIPID");
                    Double b = (Double) row.get("B");
                    lpModel.addConstraint(dbLink.nutrientratio_lhs(mixId, nutrientid1, nutrientid2, relationshipid), relationshipid, b);
                }
                //Add percent of total nutrient constraint
                LinkedList percentnutrientRhsList = (LinkedList) dbLink.percentnutrient_rhs(mixId);
                for (int i = 0; i < percentnutrientRhsList.size(); i++) {
                    HashMap row = (HashMap) percentnutrientRhsList.get(i);
                    String foodid = (String) row.get("FOODID");
                    String nutrientid = (String) row.get("NUTRIENTID");
                    Integer relationshipid = 3;
                    Double b = (double) row.get("B");
                    lpModel.addConstraint(dbLink.percentnutrient_lhs(mixId, foodid, nutrientid, b), relationshipid, 0);
                }
                String pattern = "yyyy-MMMMM-dd'_at_'HH-mm-ss";
                SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
                Date date = new Date();
                String stringDate = dateFormat.format(date);
                lpModel.setTitle(mix.getName());
                lpModel.setDate(stringDate);
                lpModel.setVariables(getFoodLegend(mixId));
                StringBuilder sbResults = new StringBuilder();
                StringBuilder sbAll = new StringBuilder();
                if (lpModel.solve()) {
                    double cost = lpModel.getCost();
                    double[] point = lpModel.getPoint();
                    DecimalFormat formatter = new DecimalFormat("#,###");
                    modelListHighScore.addElement(formatter.format(cost));
                    listHighScore.ensureIndexIsVisible(modelListHighScore.getSize() - 1);
                    listHighScore.setSelectedIndex(listHighScore.getLastVisibleIndex());
                    sbResults.append("Total Calories are: " + formatter.format(cost));
                    sbResults.append("\n");
                    DecimalFormat formatter2 = new DecimalFormat("####.#");
                    for (int i = 0; i < point.length; i++) {
                        sbResults.append("x");
                        sbResults.append(i);
                        sbResults.append(" = ");
                        sbResults.append(formatter2.format(point[i]));
                        sbResults.append(" g ");
                        sbResults.append(" = ");
                        sbResults.append(formatter2.format(point[i] / 28.3495));
                        sbResults.append(" oz");
                        sbResults.append("\n");
                    }
                    sbResults.setLength(sbResults.length() - 1);
                    LinkedList mixfoodlist = (LinkedList) dbLink.MixFood_Select(mixId);
                    for (int i = 0; i < mixfoodlist.size(); i++) {
                        HashMap row = (HashMap) mixfoodlist.get(i);
                        String foodid = (String) row.get("FOODID");
                        double v = point[i];
                        dbLink.MixFood_Update(mixId, foodid, v);
                    }
                    dbLink.FillMixResults(mixId);
                    reloadTableModelsThatNeedMixId(mixId);
                    reloadFoodJournal();
                    reloadMixComparison();
                    reloadRdaCheck();
                    resizeColumns();
                    lpModel.setResults(sbResults.toString());
                    lpModel.save();
                    sbAll.append("/*\n");
                    sbAll.append(lpModel.getDescription());
                    sbAll.append("\n*/");
                    sbAll.append("\n\n");
                    sbAll.append(lpModel.getModel());
                    sbAll.append("\n\n");
                    sbAll.append("/*\n");
                    sbAll.append(lpModel.getResults());
                    sbAll.append("\n*/");
                    sbAll.append("\n\n");
                    sbAll.append("/*\n");
                    sbAll.append(lpModel.getFeasibleMessage());
                    sbAll.append("\n*/");
                    dbLink.Mix_Update_Time(mixId);
                    dbLink.Mix_Update_Other(mixId, sbAll.toString(), textAreaNote.getText());
                } else {
                    sbAll.append("/*\n");
                    sbAll.append(lpModel.getDescription());
                    sbAll.append("\n*/");
                    sbAll.append("\n\n");
                    sbAll.append(lpModel.getModel());
                    sbAll.append("\n\n");
                    sbAll.append("/*\n");
                    sbAll.append(lpModel.getResults());
                    sbAll.append("\n*/");
                    sbAll.append("\n\n");
                    sbAll.append("/*\n");
                    sbAll.append(lpModel.getInfeasibleMessage());
                    sbAll.append("\n*/");
                    dbLink.Mix_Update_Time(mixId);
                    dbLink.Mix_Update_Other(mixId, sbAll.toString(), textAreaNote.getText());
                }
                textAreaLPModel.setText(sbAll.toString());
            } catch (SQLException e) {
                Log.getLog().start("files/exception.log");
                Log.getLog().logMessage(e.toString());
                Log.getLog().write();
                Log.getLog().close();
                e.printStackTrace();
            }
        }
    }

    private String getFoodLegend(Integer mixId) throws SQLException {
        StringBuilder sb = new StringBuilder();
        Object[] objects = modelListSelectedFood.toArray();
        int size = objects.length;
        for (int i = 0; i < size; i++) {
            FoodDataObject food = (FoodDataObject) objects[i];
            sb.append("x");
            sb.append(i);
            sb.append(": ");
            sb.append(food.getFoodName());
            sb.append("\n");
        }
        if(sb.length()>0) {
            sb.setLength(sb.length() - 1);
        }
        return sb.toString();
    }

    private void event_buttonNutrientConstraintAdd() {
        if (isMixSelected()) {
            if (isItReadyToAddNutrientConstraint()) {
                NumberCheck numberCheck = new NumberCheck();
                numberCheck.addToUncheckedList(textFieldNutrientConstraintQuantity.getText());
                if (numberCheck.pass()) {
                    try {
                        MixDataObject mix = (MixDataObject) listMixes.getSelectedValue();
                        NutrientDataObject nutrientDataObject = (NutrientDataObject) comboBoxNutrientConstraintNutrient.getSelectedItem();
                        RelationshipDataObject relationshipDataObject = (RelationshipDataObject) comboBoxNutrientConstraintRelationship.getSelectedItem();
                        double b = Double.parseDouble(textFieldNutrientConstraintQuantity.getText());
                        dbLink.NutrientConstraint_Merge(mix.getMixId(), nutrientDataObject.getNutr_no(), relationshipDataObject.getRelationshipid(), b);
                        modelTableNutrientConstraints.reload(mix.getMixId());
                        resizeColumns_NutrientConstraintTableColumns();
                    } catch (SQLException e) {
                        Log.getLog().start("files/exception.log");
                        Log.getLog().logMessage(e.toString());
                        Log.getLog().write();
                        Log.getLog().close();
                        e.printStackTrace();
                    }
                } else {
                    Message.showMessage("Value must be a number greater than or equal to zero");
                }
            }
        } else {
            Message.showMessage("Select mix");
        }
    }

    private Boolean isItReadyToAddNutrientConstraint() {
        Boolean flag_isReady = false;
        Boolean flag_listNutrient = false;
        Boolean flag_listNutrientRelationship = false;
        Boolean flag_textFieldNutrientConstraint = false;
        if (comboBoxNutrientConstraintNutrient.getSelectedIndex() != -1) {
            flag_listNutrient = true;
        } else {
            Message.showMessage("Select nutrient");
        }
        if (comboBoxNutrientConstraintRelationship.getSelectedIndex() != -1) {
            flag_listNutrientRelationship = true;
        } else {
            Message.showMessage("Select relationship");
        }
        if (!textFieldNutrientConstraintQuantity.getText().isEmpty()) {
            flag_textFieldNutrientConstraint = true;
        } else {
            Message.showMessage("Specify amount");
        }
        if (flag_listNutrient && flag_listNutrientRelationship && flag_textFieldNutrientConstraint) {
            flag_isReady = true;
        }
        return flag_isReady;
    }

    private void event_buttonNutrientConstraintDelete() {
        if (isMixSelected()) {
            try {
                int selectedRow = tableNutrientConstraint.getSelectedRow();
                Integer mixid = (Integer) tableNutrientConstraint.getValueAt(selectedRow, 0);
                String nutrientid = (String) tableNutrientConstraint.getValueAt(selectedRow, 1);
                Integer relationshipid = (Integer) tableNutrientConstraint.getValueAt(selectedRow, 2);
                dbLink.NutrientConstraint_Delete(mixid, nutrientid, relationshipid);
                modelTableNutrientConstraints.reload(mixid);
                resizeColumns_NutrientConstraintTableColumns();
            } catch (SQLException e) {
                Log.getLog().start("files/exception.log");
                Log.getLog().logMessage(e.toString());
                Log.getLog().write();
                Log.getLog().close();
                e.printStackTrace();
            }
        }
    }

    private void event_buttonFoodNutrientConstraintAdd() {
        if (isMixSelected()) {
            if (isItReadyToAddFoodNutrientConstraint()) {
                NumberCheck numberCheck = new NumberCheck();
                numberCheck.addToUncheckedList(textFieldFoodNutrientConstraintQuantity.getText());
                if (numberCheck.pass()) {
                    try {
                        MixDataObject mix = (MixDataObject) listMixes.getSelectedValue();
                        FoodDataObject foodDataObject = (FoodDataObject) comboBoxFoodNutrientConstraintFood.getSelectedItem();
                        NutrientDataObject nutrientDataObject = (NutrientDataObject) comboBoxFoodNutrientConstraintNutrient.getSelectedItem();
                        RelationshipDataObject relationshipDataObject = (RelationshipDataObject) comboBoxFoodNutrientConstraintRelationship.getSelectedItem();
                        double b = Double.parseDouble(textFieldFoodNutrientConstraintQuantity.getText());
                        dbLink.FoodNutrientConstraint_Merge(mix.getMixId(), foodDataObject.getFoodId(), nutrientDataObject.getNutr_no(), relationshipDataObject.getRelationshipid(), b);
                        modelTableFoodNutrientConstraints.reload(mix.getMixId());
                        resizeColumns_FoodNutrientConstraintTableColumns();
                    } catch (SQLException e) {
                        Log.getLog().start("files/exception.log");
                        Log.getLog().logMessage(e.toString());
                        Log.getLog().write();
                        Log.getLog().close();
                        e.printStackTrace();
                    }
                } else {
                    Message.showMessage("Value must be a number greater than or equal to zero");
                }
            }
        }
    }

    private Boolean isItReadyToAddFoodNutrientConstraint() {
        Boolean flag_isReady = false;
        Boolean flag_listFood = false;
        Boolean flag_listNutrient = false;
        Boolean flag_listRelationship = false;
        Boolean flag_quantity = false;
        if (comboBoxFoodNutrientConstraintFood.getSelectedIndex() != -1) {
            flag_listFood = true;
        } else {
            Message.showMessage("Select food");
        }
        if (comboBoxFoodNutrientConstraintNutrient.getSelectedIndex() != -1) {
            flag_listNutrient = true;
        } else {
            Message.showMessage("Select nutrient");
        }
        if (comboBoxFoodNutrientConstraintRelationship.getSelectedIndex() != -1) {
            flag_listRelationship = true;
        } else {
            Message.showMessage("Select relationship");
        }
        if (!textFieldFoodNutrientConstraintQuantity.getText().isEmpty()) {
            flag_quantity = true;
        } else {
            Message.showMessage("Specify amount");
        }
        if (flag_listFood && flag_listNutrient && flag_listRelationship && flag_quantity) {
            flag_isReady = true;
        }
        return flag_isReady;
    }

    private void resizeColumns_FoodNutrientConstraintTableColumns() {
        for (int i = 0; i < 4; i++) {
            tableFoodNutrientConstraint.getColumnModel().getColumn(i).setMinWidth(0);
            tableFoodNutrientConstraint.getColumnModel().getColumn(i).setMaxWidth(0);
        }
        tableFoodNutrientConstraint.getColumnModel().getColumn(4).setMinWidth(480);
        tableFoodNutrientConstraint.getColumnModel().getColumn(4).setMaxWidth(480);
        tableFoodNutrientConstraint.getColumnModel().getColumn(5).setMinWidth(250);
        tableFoodNutrientConstraint.getColumnModel().getColumn(5).setMaxWidth(250);
        tableFoodNutrientConstraint.getColumnModel().getColumn(6).setMinWidth(21);
        tableFoodNutrientConstraint.getColumnModel().getColumn(6).setMaxWidth(21);
        tableFoodNutrientConstraint.getColumnModel().getColumn(7).setMinWidth(50);
        tableFoodNutrientConstraint.getColumnModel().getColumn(7).setMaxWidth(50);
    }

    private void event_buttonFoodNutrientConstraintDelete() {
        if (isMixSelected()) {
            try {
                int selectedRow = tableFoodNutrientConstraint.getSelectedRow();
                Integer mixid = (Integer) tableFoodNutrientConstraint.getValueAt(selectedRow, 0);
                String foodid = (String) tableFoodNutrientConstraint.getValueAt(selectedRow, 1);
                String nutrientid = (String) tableFoodNutrientConstraint.getValueAt(selectedRow, 2);
                Integer relationshipid = (Integer) tableFoodNutrientConstraint.getValueAt(selectedRow, 3);
                dbLink.FoodNutrientConstraint_Delete(mixid, foodid, nutrientid, relationshipid);
                modelTableFoodNutrientConstraints.reload(mixid);
                resizeColumns_FoodNutrientConstraintTableColumns();
            } catch (SQLException e) {
                Log.getLog().start("files/exception.log");
                Log.getLog().logMessage(e.toString());
                Log.getLog().write();
                Log.getLog().close();
                e.printStackTrace();
            }
        }
    }

    private void event_buttonNutrientRatioAdd() {
        if (isMixSelected()) {
            if (isItReadyToAddNutrientRatioConstraint()) {
                NumberCheck numberCheck = new NumberCheck();
                numberCheck.addToUncheckedList(textFieldNutrientRatioNutrientA.getText());
                numberCheck.addToUncheckedList(textFieldNutrientRatioNutrientB.getText());
                if (numberCheck.pass()) {
                    try {
                        MixDataObject mix = (MixDataObject) listMixes.getSelectedValue();
                        NutrientDataObject nutrientDataObjectA = (NutrientDataObject) comboBoxNutrientRatioNutrientA.getSelectedItem();
                        NutrientDataObject nutrientDataObjectB = (NutrientDataObject) comboBoxNutrientRatioNutrientB.getSelectedItem();
                        Double a = Double.parseDouble(textFieldNutrientRatioNutrientA.getText());
                        Double b = Double.parseDouble(textFieldNutrientRatioNutrientB.getText());
                        dbLink.NutrientRatio_Merge(mix.getMixId(), nutrientDataObjectA.getNutr_no(), nutrientDataObjectB.getNutr_no(), 3, a, b);
                        modelTableNutrientRatioConstraints.reload(mix.getMixId());
                        resizeColumns_NutrientRatioConstraintTableColumns();
                    } catch (SQLException e) {
                        Log.getLog().start("files/exception.log");
                        Log.getLog().logMessage(e.toString());
                        Log.getLog().write();
                        Log.getLog().close();
                        e.printStackTrace();
                    }
                } else {
                    Message.showMessage("Value must be a number greater than zero");
                }
            }
        }
    }

    private Boolean isItReadyToAddNutrientRatioConstraint() {
        Boolean flag_isReady = false;
        Boolean flag_listNutrientA = false;
        Boolean flag_listNutrientB = false;
        Boolean flag_quantityA = false;
        Boolean flag_quantityB = false;
        if (comboBoxNutrientRatioNutrientA.getSelectedIndex() != -1) {
            flag_listNutrientA = true;
        } else {
            Message.showMessage("Select nutrient A");
        }
        if (comboBoxNutrientRatioNutrientA.getSelectedIndex() != -1) {
            flag_listNutrientB = true;
        } else {
            Message.showMessage("Select nutrient B");
        }
        if (!textFieldNutrientRatioNutrientA.getText().isEmpty()) {
            flag_quantityA = true;
        } else {
            Message.showMessage("Specify amount A");
        }
        if (!textFieldNutrientRatioNutrientB.getText().isEmpty()) {
            flag_quantityB = true;
        } else {
            Message.showMessage("Specify amount B");
        }
        if (flag_listNutrientA && flag_listNutrientB && flag_quantityA && flag_quantityB) {
            flag_isReady = true;
        }
        return flag_isReady;
    }

    private void resizeColumns_GlycemicTable() {
        tableGlycemic.getColumnModel().getColumn(0).setMinWidth(500);
        tableGlycemic.getColumnModel().getColumn(0).setMaxWidth(500);
        for (int i = 1; i < 3; i++) {
            tableGlycemic.getColumnModel().getColumn(i).setMinWidth(75);
            tableGlycemic.getColumnModel().getColumn(i).setMaxWidth(75);
        }
    }

    private void resizeColumns_NutrientRatioConstraintTableColumns() {
        for (int i = 0; i < 4; i++) {
            tableNutrientRatio.getColumnModel().getColumn(i).setMinWidth(0);
            tableNutrientRatio.getColumnModel().getColumn(i).setMaxWidth(0);
        }
        //Columns missing on purpose
        for (int i = 6; i < 8; i++) {
            tableNutrientRatio.getColumnModel().getColumn(i).setMinWidth(60);
            tableNutrientRatio.getColumnModel().getColumn(i).setMaxWidth(60);
        }
    }

    private void resizeColumns_EnergyTable() {
        tableEnergy.getColumnModel().getColumn(0).setMinWidth(500);
        tableEnergy.getColumnModel().getColumn(0).setMaxWidth(500);
        for (int i = 1; i < 7; i++) {
            tableEnergy.getColumnModel().getColumn(i).setMinWidth(75);
            tableEnergy.getColumnModel().getColumn(i).setMaxWidth(75);
        }
    }

    private void resizeColumns_ProteinTable() {
        tableProtein.getColumnModel().getColumn(0).setMinWidth(500);
        tableProtein.getColumnModel().getColumn(0).setMaxWidth(500);
        for (int i = 1; i < 5; i++) {
            tableProtein.getColumnModel().getColumn(i).setMinWidth(75);
            tableProtein.getColumnModel().getColumn(i).setMaxWidth(75);
        }
    }

    private void resizeColumns_FatTable() {
        tableFat.getColumnModel().getColumn(0).setMinWidth(500);
        tableFat.getColumnModel().getColumn(0).setMaxWidth(500);
        for (int i = 1; i < 11; i++) {
            tableFat.getColumnModel().getColumn(i).setMinWidth(75);
            tableFat.getColumnModel().getColumn(i).setMaxWidth(75);
        }
    }

    private void resizeColumns_CarbsTable() {
        tableCarbs.getColumnModel().getColumn(0).setMinWidth(500);
        tableCarbs.getColumnModel().getColumn(0).setMaxWidth(500);
        for (int i = 1; i < 7; i++) {
            tableCarbs.getColumnModel().getColumn(i).setMinWidth(75);
            tableCarbs.getColumnModel().getColumn(i).setMaxWidth(75);
        }
    }

    private void resizeColumns_VitaminsTable() {
        tableVitamins.getColumnModel().getColumn(0).setMinWidth(500);
        tableVitamins.getColumnModel().getColumn(0).setMaxWidth(500);
        for (int i = 1; i < 14; i++) {
            tableVitamins.getColumnModel().getColumn(i).setMinWidth(75);
            tableVitamins.getColumnModel().getColumn(i).setMaxWidth(75);
        }
    }

    private void resizeColumns_MineralsTable() {
        tableMinerals.getColumnModel().getColumn(0).setMinWidth(500);
        tableMinerals.getColumnModel().getColumn(0).setMaxWidth(500);
        for (int i = 1; i < 11; i++) {
            tableMinerals.getColumnModel().getColumn(i).setMinWidth(75);
            tableMinerals.getColumnModel().getColumn(i).setMaxWidth(75);
        }
    }

    private void resizeColumns_ElectrolytesTable() {
        tableElectrolytes.getColumnModel().getColumn(0).setMinWidth(500);
        tableElectrolytes.getColumnModel().getColumn(0).setMaxWidth(500);
        for (int i = 1; i < 4; i++) {
            tableElectrolytes.getColumnModel().getColumn(i).setMinWidth(75);
            tableElectrolytes.getColumnModel().getColumn(i).setMaxWidth(75);
        }
    }

    private void resizeColumns_WaterTable() {
        tableWater.getColumnModel().getColumn(0).setMinWidth(500);
        tableWater.getColumnModel().getColumn(0).setMaxWidth(500);
        for (int i = 1; i < 2; i++) {
            tableWater.getColumnModel().getColumn(i).setMinWidth(75);
            tableWater.getColumnModel().getColumn(i).setMaxWidth(75);
        }
    }

    private void resizeColumns_CostTable() {
        tableCost.getColumnModel().getColumn(0).setMinWidth(500);
        tableCost.getColumnModel().getColumn(0).setMaxWidth(500);
        for (int i = 1; i < 2; i++) {
            tableCost.getColumnModel().getColumn(i).setMinWidth(75);
            tableCost.getColumnModel().getColumn(i).setMaxWidth(75);
        }
    }

    private void resizeColumns_JournalTable() {
        tableJournal.getColumnModel().getColumn(0).setMinWidth(500);
        tableJournal.getColumnModel().getColumn(0).setMaxWidth(500);
        for (int i = 1; i < 18; i++) {
            tableJournal.getColumnModel().getColumn(i).setMinWidth(75);
            tableJournal.getColumnModel().getColumn(i).setMaxWidth(75);
        }
    }

    private void resizeColumns_MixComparisonTable() {
        tableMixComparison.getColumnModel().getColumn(0).setMinWidth(310);
        tableMixComparison.getColumnModel().getColumn(0).setMaxWidth(310);
        for (int i = 1; i < 4; i++) {
            tableMixComparison.getColumnModel().getColumn(i).setMinWidth(75);
            tableMixComparison.getColumnModel().getColumn(i).setMaxWidth(75);
        }
    }

    private void resizeColumns_RdaCheckTable() {
        tableRdaCheck.getColumnModel().getColumn(0).setMinWidth(0);
        tableRdaCheck.getColumnModel().getColumn(0).setMaxWidth(0);
        tableRdaCheck.getColumnModel().getColumn(1).setMinWidth(310);
        tableRdaCheck.getColumnModel().getColumn(1).setMaxWidth(310);
        for (int i = 2; i < 7; i++) {
            tableRdaCheck.getColumnModel().getColumn(i).setMinWidth(75);
            tableRdaCheck.getColumnModel().getColumn(i).setMaxWidth(75);
        }
    }

    private void resizeColumns_NutrientLookupTable() {
        tableNutrientLookup.getColumnModel().getColumn(0).setMinWidth(250);
        tableNutrientLookup.getColumnModel().getColumn(0).setMaxWidth(550);
        tableNutrientLookup.getColumnModel().getColumn(1).setMinWidth(75);
        tableNutrientLookup.getColumnModel().getColumn(1).setMaxWidth(75);
    }

    private void resizeColumns_NutrientInputTable() {
        tableNutrientInput.getColumnModel().getColumn(0).setMinWidth(0);
        tableNutrientInput.getColumnModel().getColumn(0).setMaxWidth(0);
        tableNutrientInput.getColumnModel().getColumn(1).setMaxWidth(150);
        tableNutrientInput.getColumnModel().getColumn(2).setMaxWidth(320);
        tableNutrientInput.getColumnModel().getColumn(3).setMaxWidth(100);
    }

    private void resizeColumns_CheckCoefficientsTable() {
        tableCheckCoefficients.getColumnModel().getColumn(0).setMinWidth(0);
        tableCheckCoefficients.getColumnModel().getColumn(0).setMaxWidth(0);
        tableCheckCoefficients.getColumnModel().getColumn(1).setMaxWidth(150);
        tableCheckCoefficients.getColumnModel().getColumn(2).setMaxWidth(320);
        tableCheckCoefficients.getColumnModel().getColumn(3).setMaxWidth(100);
        tableCheckCoefficients.getColumnModel().getColumn(4).setMaxWidth(100);
    }

    private void resizeColumns_FoodListTable() {
        tableFoodList.getColumnModel().getColumn(0).setMinWidth(0);
        tableFoodList.getColumnModel().getColumn(0).setMaxWidth(0);
        tableFoodList.getColumnModel().getColumn(2).setMinWidth(350);
    }

    private void event_buttonNutrientRatioDelete() {
        if (isMixSelected()) {
            try {
                int selectedRow = tableNutrientRatio.getSelectedRow();
                Integer mixid = (Integer) tableNutrientRatio.getValueAt(selectedRow, 0);
                String nutrientidA = (String) tableNutrientRatio.getValueAt(selectedRow, 1);
                String nutrientidB = (String) tableNutrientRatio.getValueAt(selectedRow, 2);
                Integer relationshipid = (Integer) tableNutrientRatio.getValueAt(selectedRow, 3);
                dbLink.NutrientRatio_Delete(mixid, nutrientidA, nutrientidB, relationshipid);
                modelTableNutrientRatioConstraints.reload(mixid);
                resizeColumns_NutrientRatioConstraintTableColumns();
            } catch (SQLException e) {
                Log.getLog().start("files/exception.log");
                Log.getLog().logMessage(e.toString());
                Log.getLog().write();
                Log.getLog().close();
                e.printStackTrace();
            }
        }
    }

    private void event_buttonFoodNutrientRatioAdd() {
        if (isMixSelected()) {
            if (isItReadyToAddFoodNutrientRatioConstraint()) {
                NumberCheck numberCheck = new NumberCheck();
                numberCheck.addToUncheckedList(textFieldFoodNutrientRatioQuantityA.getText());
                numberCheck.addToUncheckedList(textFieldFoodNutrientRatioQuantityB.getText());
                if (numberCheck.pass()) {
                    try {
                        MixDataObject mix = (MixDataObject) listMixes.getSelectedValue();
                        FoodDataObject foodDataObjectA = (FoodDataObject) comboBoxFoodNutrientRatioFoodA.getSelectedItem();
                        NutrientDataObject nutrientDataObjectA = (NutrientDataObject) comboBoxFoodNutrientRatioNutrientA.getSelectedItem();
                        FoodDataObject foodDataObjectB = (FoodDataObject) comboBoxFoodNutrientRatioFoodB.getSelectedItem();
                        NutrientDataObject nutrientDataObjectB = (NutrientDataObject) comboBoxFoodNutrientRatioNutrientB.getSelectedItem();
                        Double a = Double.parseDouble(textFieldFoodNutrientRatioQuantityA.getText());
                        Double b = Double.parseDouble(textFieldFoodNutrientRatioQuantityB.getText());
                        dbLink.FoodNutrientRatio_Merge(mix.getMixId(), foodDataObjectA.getFoodId(), nutrientDataObjectA.getNutr_no(), foodDataObjectB.getFoodId(), nutrientDataObjectB.getNutr_no(), 3, a, b);
                        modelTableFoodNutrientRatioConstraints.reload(mix.getMixId());
                        resizeColumns_FoodNutrientRatioConstraintTableColumns();
                    } catch (SQLException e) {
                        Log.getLog().start("files/exception.log");
                        Log.getLog().logMessage(e.toString());
                        Log.getLog().write();
                        Log.getLog().close();
                        e.printStackTrace();
                    }
                } else {
                    Message.showMessage("Value must be number greater than zero");
                }
            }
        }
    }

    private Boolean isItReadyToAddFoodNutrientRatioConstraint() {
        Boolean flag_isReady = false;
        Boolean flag_listFoodA = false;
        Boolean flag_listNutrientA = false;
        Boolean flag_quantityA = false;
        Boolean flag_listFoodB = false;
        Boolean flag_listNutrientB = false;
        Boolean flag_quantityB = false;
        if (comboBoxFoodNutrientRatioFoodA.getSelectedIndex() != -1) {
            flag_listFoodA = true;
        } else {
            Message.showMessage("Select food A");
        }
        if (comboBoxFoodNutrientRatioNutrientA.getSelectedIndex() != -1) {
            flag_listNutrientA = true;
        } else {
            Message.showMessage("Select nutrient A");
        }
        if (!textFieldFoodNutrientRatioQuantityA.getText().isEmpty()) {
            flag_quantityA = true;
        } else {
            Message.showMessage("Specify amount A");
        }
        if (comboBoxFoodNutrientRatioFoodB.getSelectedIndex() != -1) {
            flag_listFoodB = true;
        } else {
            Message.showMessage("Select food B");
        }
        if (comboBoxFoodNutrientRatioNutrientB.getSelectedIndex() != -1) {
            flag_listNutrientB = true;
        } else {
            Message.showMessage("Select nutrient B");
        }
        if (!textFieldFoodNutrientRatioQuantityB.getText().isEmpty()) {
            flag_quantityB = true;
        } else {
            Message.showMessage("Specify amount B");
        }
        if (flag_listFoodA && flag_listNutrientA && flag_quantityA && flag_listFoodB && flag_listNutrientB && flag_quantityB) {
            flag_isReady = true;
        }
        return flag_isReady;
    }

    private void resizeColumns_FoodNutrientRatioConstraintTableColumns() {
        for (int i = 0; i < 6; i++) {
            tableFoodNutrientRatio.getColumnModel().getColumn(i).setMinWidth(0);
            tableFoodNutrientRatio.getColumnModel().getColumn(i).setMaxWidth(0);
        }
        //Columns missing on purpose
        for (int i = 10; i < 12; i++) {
            tableFoodNutrientRatio.getColumnModel().getColumn(i).setMinWidth(60);
            tableFoodNutrientRatio.getColumnModel().getColumn(i).setMaxWidth(60);
        }
    }

    private void event_buttonFoodNutrientRatioDelete() {
        if (isMixSelected()) {
            try {
                int selectedRow = tableFoodNutrientRatio.getSelectedRow();
                Integer mixid = (Integer) tableFoodNutrientRatio.getValueAt(selectedRow, 0);
                String foodidA = (String) tableFoodNutrientRatio.getValueAt(selectedRow, 1);
                String nutrientidA = (String) tableFoodNutrientRatio.getValueAt(selectedRow, 2);
                String foodidB = (String) tableFoodNutrientRatio.getValueAt(selectedRow, 3);
                String nutrientidB = (String) tableFoodNutrientRatio.getValueAt(selectedRow, 4);
                Integer relationshipid = (Integer) tableFoodNutrientRatio.getValueAt(selectedRow, 5);
                dbLink.FoodNutrientRatio_Delete(mixid, foodidA, nutrientidA, foodidB, nutrientidB, relationshipid);
                modelTableFoodNutrientRatioConstraints.reload(mixid);
                resizeColumns_FoodNutrientRatioConstraintTableColumns();
            } catch (SQLException e) {
                Log.getLog().start("files/exception.log");
                Log.getLog().logMessage(e.toString());
                Log.getLog().write();
                Log.getLog().close();
                e.printStackTrace();
            }
        }
    }

    private boolean isMixSelected() {
        return !listMixes.isSelectionEmpty();
    }

    private boolean isMixJournalSelected() {
        return !listMixesJournal.isSelectionEmpty();
    }

    private boolean isListCompareASelected() {
        return !listCompareA.isSelectionEmpty();
    }

    private boolean isListCompareBSelected() {
        return !listCompareB.isSelectionEmpty();
    }

    private boolean isRdaMixSelected() {
        return !listRdaCheck.isSelectionEmpty();
    }

    private void event_buttonCategoriesAdd() {
        JTextField input = new JTextField();
        JComponent[] inputs = new JComponent[]{
                new JLabel("What is your new category name?"),
                input
        };
        int optionValue = Message.showOptionDialog(inputs, "New Category");
        if (optionValue == 0) {
            String category_name = input.getText();
            if (category_name != null && category_name.length() > 0) {
                try {
                    dbLink.FoodCategory_Insert_2(category_name);
                    modelListCategory.reload();
                    reloadFoodItems();
                } catch (SQLException e) {
                    Log.getLog().start("files/exception.log");
                    Log.getLog().logMessage(e.toString());
                    Log.getLog().write();
                    Log.getLog().close();
                    e.printStackTrace();
                }
            }
        }
    }

    private void event_buttonCategoriesRename() {
        if (!listCategories.isSelectionEmpty()) {
            JTextField input = new JTextField();
            JComponent[] inputs = new JComponent[]{
                    new JLabel("What is your new category name?"),
                    input
            };
            int optionValue = Message.showOptionDialog(inputs, "Update Category");
            if (optionValue == 0) {
                String category_name = input.getText();
                if (category_name != null && category_name.length() > 0) {
                    try {
                        FoodCategoryDataObject foodCategoryDataObject = (FoodCategoryDataObject) listCategories.getSelectedValue();
                        String foodCategoryId = foodCategoryDataObject.getFoodCategoryId();
                        dbLink.FoodCategory_Update(foodCategoryId, category_name);
                        modelListCategory.reload();
                        reloadFoodItems();
                    } catch (SQLException e) {
                        Log.getLog().start("files/exception.log");
                        Log.getLog().logMessage(e.toString());
                        Log.getLog().write();
                        Log.getLog().close();
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    private void event_buttonCategoriesDelete() {
        if (!listCategories.isSelectionEmpty()) {
            try {
                FoodCategoryDataObject foodCategoryDataObject = (FoodCategoryDataObject) listCategories.getSelectedValue();
                String foodCategoryId = foodCategoryDataObject.getFoodCategoryId();
                dbLink.FoodCategory_Delete(foodCategoryId);
                modelListCategory.reload();
                reloadFoodItems();
                modelListFoodInCategory.reload("-1");
            } catch (SQLException e) {
                Log.getLog().start("files/exception.log");
                Log.getLog().logMessage(e.toString());
                Log.getLog().write();
                Log.getLog().close();
                e.printStackTrace();
            }
        }
    }

    private void openUrl(String url) {
        try {
            Desktop.getDesktop().browse(new URL(url).toURI());
        } catch (Exception e) {
            Log.getLog().start("files/exception.log");
            Log.getLog().logMessage(e.toString());
            Log.getLog().write();
            Log.getLog().close();
            e.printStackTrace();
        }
    }

    private void event_menuItemGlycemicLoad() {
        JTextField textFieldGI = new JTextField();
        JTextField textFieldCarbs = new JTextField();
        JComponent[] inputs = new JComponent[]{
                new JLabel("What is glycemic index of food item?"),
                textFieldGI
        };
        Message.showOptionDialog(inputs, "Glycemic Load");
        String strGI = textFieldGI.getText();
        inputs = new JComponent[]{
                new JLabel("How many digestible carbs (g) in food item?"),
                textFieldCarbs
        };
        Message.showOptionDialog(inputs, "Glycemic Load");
        String strCarbs = textFieldCarbs.getText();
        if (strGI != null && strGI.length() > 0) {
            if (strCarbs != null && strCarbs.length() > 0) {
                StringBuffer sb = new StringBuffer();
                NumberCheck checkNumber = new NumberCheck();
                checkNumber.addToUncheckedList(strGI);
                checkNumber.addToUncheckedList(strCarbs);
                if (checkNumber.pass()) {
                    Double gi = Double.valueOf(strGI);
                    Double carbs = Double.valueOf(strCarbs);
                    double gl = new GlycemicLoad(gi,carbs).getGlycemicLoad();
                    sb.append("Glycemic Load: ");
                    sb.append(gl);
                    JTextArea textArea = new JTextArea(1, 10);
                    textArea.setText(sb.toString());
                    textArea.setEditable(false);
                    inputs = new JComponent[]{
                            textArea
                    };
                    Message.showOptionDialog(inputs, "Glycemic Load");
                }
            }
        }
    }

    private JTabbedPane getNoFeasibleSolutionPanel() {
        FormLayout layout = new FormLayout(
                "pref:grow", //columns
                "fill:pref:grow" //rows
        );
        StringBuilder sbPanel1 = new StringBuilder();
        StringBuilder sbPanel2 = new StringBuilder();
        sbPanel1.append(getNoFeasibleSolutionText());
        sbPanel2.append("One or more of these constraints makes the solution unfeasible.");
        sbPanel2.append("\n\n");
        sbPanel2.append(getNutrientConstraintText());
        sbPanel2.append(getNutrientPercentConstraintText());
        sbPanel2.append(getFoodConstraintText());
        sbPanel2.append(getFoodRatioText());
        sbPanel2.append(getNutrientRatioText());
        JTabbedPane tp = new JTabbedPane();
        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JTextArea messageArea = new JTextArea(sbPanel1.toString());
        JTextArea constraintsArea = new JTextArea(sbPanel2.toString());
        messageArea.setEditable(false);
        constraintsArea.setEditable(false);
        tp.setTabPlacement(JTabbedPane.BOTTOM);
        tp.setPreferredSize(new Dimension(GoldenRatio.getLongSide(500),500));
        tp.add(p1);
        tp.add(p2);
        tp.setTitleAt(0,"Message");
        tp.setTitleAt(1,"Details");
        p1.setLayout(layout);
        p2.setLayout(layout);
        messageArea.setLineWrap(false);
        p1.add(new JScrollPane(messageArea),cc.xy(1, 1));
        constraintsArea.setLineWrap(false);
        JScrollPane spConstraintsArea = new JScrollPane(constraintsArea);
        spConstraintsArea.setPreferredSize(new Dimension(700, 433));
        p2.add(spConstraintsArea,cc.xy(1, 1));
        return tp;
    }

    private String getNutrientRatioText() {
        StringBuilder sb = new StringBuilder();
        if(tableNutrientRatio.getRowCount()>0){
            sb.append("Nutrient Ratio");
            sb.append("\n");
            sb.append("-----------------------------");
            sb.append("\n");
            for (int i = 0; i < tableNutrientRatio.getRowCount(); i++) {
                String nutrientA = (String)tableNutrientRatio.getValueAt(i,4);
                String nutrientB = (String)tableNutrientRatio.getValueAt(i,5);
                Double a = (Double)tableNutrientRatio.getValueAt(i,6);
                Double b = (Double)tableNutrientRatio.getValueAt(i,7);

                sb.append(nutrientA);
                sb.append(" and ");
                sb.append(nutrientB);
                sb.append("\n");
                sb.append("should be found in the mix in a ratio of ");
                sb.append(a);
                sb.append(":");
                sb.append(b);
                sb.append("\n");
                sb.append("\n");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    private String getFoodRatioText() {
        StringBuilder sb = new StringBuilder();
        if(tableFoodNutrientRatio.getRowCount()>0){
            sb.append("Food Ratio");
            sb.append("\n");
            sb.append("-----------------------------");
            sb.append("\n");
            for (int i = 0; i < tableFoodNutrientRatio.getRowCount(); i++) {
                String foodA = (String)tableFoodNutrientRatio.getValueAt(i,6);
                String nutrientA = (String)tableFoodNutrientRatio.getValueAt(i,7);
                String foodB = (String)tableFoodNutrientRatio.getValueAt(i,8);
                String nutrientB = (String)tableFoodNutrientRatio.getValueAt(i,9);
                Double a = (Double)tableFoodNutrientRatio.getValueAt(i,10);
                Double b = (Double)tableFoodNutrientRatio.getValueAt(i,11);

                sb.append(nutrientA);
                sb.append(" contributed by ");
                sb.append(foodA);
                sb.append(" and ");
                sb.append("\n");
                sb.append(nutrientB);
                sb.append(" contributed by ");
                sb.append(foodB);
                sb.append("\n");
                sb.append("should be found in the mix in a ratio of ");
                sb.append(a);
                sb.append(":");
                sb.append(b);
                sb.append("\n");
                sb.append("\n");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    private String getNutrientPercentConstraintText() {
        StringBuilder sb = new StringBuilder();
        if(tableNutrientPercentConstraint.getRowCount()>0) {
            sb.append("Nutrient Percent Constraint");
            sb.append("\n");
            sb.append("--------------------------");
            sb.append("\n");
            for (int i = 0; i < tableNutrientPercentConstraint.getRowCount(); i++) {
                String food = (String) tableNutrientPercentConstraint.getValueAt(i, 3);
                String nutrient = (String) tableNutrientPercentConstraint.getValueAt(i, 4);
                Double constraint = (Double) tableNutrientPercentConstraint.getValueAt(i, 5);
                sb.append(nutrient);
                sb.append(" contributed to the mix by ");
                sb.append(food);
                sb.append("\n");
                sb.append("should be ");
                sb.append(constraint);
                sb.append("% of all ");
                sb.append(nutrient);
                sb.append(" in mix");
                sb.append("\n");
                sb.append("\n");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    private String getFoodConstraintText() {
        StringBuilder sb = new StringBuilder();
        if(tableFoodNutrientConstraint.getRowCount()>0){
            sb.append("Food Constraint");
            sb.append("\n");
            sb.append("--------------------------");
            sb.append("\n");
            for (int i = 0; i < tableFoodNutrientConstraint.getRowCount(); i++) {
                String food = (String)tableFoodNutrientConstraint.getValueAt(i,4);
                String nutrient = (String)tableFoodNutrientConstraint.getValueAt(i,5);
                String equality = (String)tableFoodNutrientConstraint.getValueAt(i,6);
                Double value = (Double)tableFoodNutrientConstraint.getValueAt(i,7);
                sb.append(nutrient);
                sb.append(" contributed to the mix by ");
                sb.append(food);
                sb.append("\n");
                sb.append("should be ");
                sb.append(getTranslation(equality));
                sb.append(" ");
                sb.append(value);
                sb.append("\n");
                sb.append("\n");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    private String getNutrientConstraintText() {
        StringBuilder sb = new StringBuilder();
        if(tableNutrientConstraint.getRowCount()>0){
            sb.append("Nutrient Constraint");
            sb.append("\n");
            sb.append("--------------------------");
            sb.append("\n");
            for (int i = 0; i < tableNutrientConstraint.getRowCount(); i++) {
                String nutrient = (String)tableNutrientConstraint.getValueAt(i,3);
                String equality = (String)tableNutrientConstraint.getValueAt(i,4);
                Double value = (Double)tableNutrientConstraint.getValueAt(i,5);
                sb.append("Total ");
                sb.append(nutrient);
                sb.append(" in the mix");
                sb.append("\n");
                sb.append("should be ");
                sb.append(getTranslation(equality));
                sb.append(" ");
                sb.append(value);
                sb.append("\n");
                sb.append("\n");
            }
            sb.append("\n");
        }
        return sb.toString();
    }


    private String getTranslation(String equality){
        String translatedText = "";

        switch(equality){
            case "=":
                translatedText = "equal to";
                break;
            case ">":
                translatedText = "greater than or equal to";
                break;
            case "<":
                translatedText = "less than or equal to";
                break;
        }

        return translatedText;
    }

    private String getNoFeasibleSolutionText() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            sb.append("\n");
        }
        for (int i = 0; i < 83; i++) {
            sb.append(" ");
        }
        sb.append("No Feasible Solution");
        sb.append("\n\n");
        for (int i = 0; i < 83; i++) {
            sb.append(" ");
        }
        sb.append("Things you can try:");
        sb.append("\n\n");
        for (int i = 0; i < 83; i++) {
            sb.append(" ");
        }
        sb.append("1. Delete a constraint");
        sb.append("\n\n");
        for (int i = 0; i < 83; i++) {
            sb.append(" ");
        }
        sb.append("2. Add a food item");
        return sb.toString();
    }


}