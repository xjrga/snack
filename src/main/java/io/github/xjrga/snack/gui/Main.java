package io.github.xjrga.snack.gui;

import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;
import io.github.xjrga.snack.data.DbLink;
import io.github.xjrga.snack.data.Nutrient;
import io.github.xjrga.snack.dataobject.FoodCategoryDataObject;
import io.github.xjrga.snack.dataobject.FoodDataObject;
import io.github.xjrga.snack.dataobject.MixDataObject;
import io.github.xjrga.snack.dataobject.NutrientDataObject;
import io.github.xjrga.snack.dataobject.RdaLifeStageDataObject;
import io.github.xjrga.snack.dataobject.RelationshipDataObject;
import io.github.xjrga.snack.lp.LpModel;
import io.github.xjrga.snack.model.ComboBoxModelFood;
import io.github.xjrga.snack.model.ComboBoxModelLifeStage;
import io.github.xjrga.snack.model.ComboBoxModelNutrients;
import io.github.xjrga.snack.model.ComboBoxModelNutrientsAll;
import io.github.xjrga.snack.model.ComboBoxModelNutrientsConvert;
import io.github.xjrga.snack.model.ComboBoxModelRelationships;
import io.github.xjrga.snack.model.ListModelCategory;
import io.github.xjrga.snack.model.ListModelFood;
import io.github.xjrga.snack.model.ListModelFood2;
import io.github.xjrga.snack.model.ListModelMix;
import io.github.xjrga.snack.model.ListModelMix1;
import io.github.xjrga.snack.model.ListModelSelectedFood;
import io.github.xjrga.snack.model.StringModelMixPct;
import io.github.xjrga.snack.model.TableModelCarbs;
import io.github.xjrga.snack.model.TableModelCheckCoefficients;
import io.github.xjrga.snack.model.TableModelCost;
import io.github.xjrga.snack.model.TableModelDataInput;
import io.github.xjrga.snack.model.TableModelElectrolytes;
import io.github.xjrga.snack.model.TableModelEnergy;
import io.github.xjrga.snack.model.TableModelFat;
import io.github.xjrga.snack.model.TableModelFoodList;
import io.github.xjrga.snack.model.TableModelFoodNutrientConstraints;
import io.github.xjrga.snack.model.TableModelFoodNutrientRatioConstraints;
import io.github.xjrga.snack.model.TableModelGlycemic;
import io.github.xjrga.snack.model.TableModelMinerals;
import io.github.xjrga.snack.model.TableModelMixComparison;
import io.github.xjrga.snack.model.TableModelNutrientConstraints;
import io.github.xjrga.snack.model.TableModelNutrientLookup;
import io.github.xjrga.snack.model.TableModelNutrientRatioConstraints;
import io.github.xjrga.snack.model.TableModelPercentNutrientConstraints;
import io.github.xjrga.snack.model.TableModelProtein;
import io.github.xjrga.snack.model.TableModelRdaCheck;
import io.github.xjrga.snack.model.TableModelResults;
import io.github.xjrga.snack.model.TableModelVitamins;
import io.github.xjrga.snack.model.TableModelWater;
import io.github.xjrga.snack.model.TreeModelFood;
import io.github.xjrga.snack.other.Alpha_linolenic_acid_required;
import io.github.xjrga.snack.other.CunninghamFormula;
import io.github.xjrga.snack.other.DigestibleCarbohydrate;
import io.github.xjrga.snack.other.DoubleTableCellEditor;
import io.github.xjrga.snack.other.ExportFoodList;
import io.github.xjrga.snack.other.ExportFoodMixes;
import io.github.xjrga.snack.other.ExportMixComparison;
import io.github.xjrga.snack.other.ExportNutrientLookup;
import io.github.xjrga.snack.other.ExportRdaCheck;
import io.github.xjrga.snack.other.GlycemicIndexRange;
import io.github.xjrga.snack.other.GlycemicLoad;
import io.github.xjrga.snack.other.GoldenRatio;
import io.github.xjrga.snack.other.ImageUtilities;
import io.github.xjrga.snack.other.KatchMcArdleFormula;
import io.github.xjrga.snack.other.MacroNutrientEnergyValues;
import io.github.xjrga.snack.other.MinimumNutrientRequirements;
import io.github.xjrga.snack.other.NumberCheck;
import io.github.xjrga.snack.other.TableHeaderCarbs;
import io.github.xjrga.snack.other.TableHeaderCost;
import io.github.xjrga.snack.other.TableHeaderElectrolytes;
import io.github.xjrga.snack.other.TableHeaderEnergy;
import io.github.xjrga.snack.other.TableHeaderFats;
import io.github.xjrga.snack.other.TableHeaderFoodList;
import io.github.xjrga.snack.other.TableHeaderGlycemic;
import io.github.xjrga.snack.other.TableHeaderMinerals;
import io.github.xjrga.snack.other.TableHeaderNutrientLookup;
import io.github.xjrga.snack.other.TableHeaderProtein;
import io.github.xjrga.snack.other.TableHeaderRdaDiff;
import io.github.xjrga.snack.other.TableHeaderVitamins;
import io.github.xjrga.snack.other.TableHeaderWater;
import io.github.xjrga.snack.other.Xml_receive;
import io.github.xjrga.snack.other.Xml_send;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableRowSorter;
import javax.swing.text.JTextComponent;
import javax.swing.tree.DefaultMutableTreeNode;

public class Main {

    private final BufferedImage logo = ImageUtilities.readImage("resources/images/logo.png");
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
    private final ComboBoxModelRelationships modelComboBox_RelationshipAtNutrientRatio = new ComboBoxModelRelationships(dbLink);
    private final ComboBoxModelRelationships modelComboBox_RelationshipAtFoodNutrientRatio = new ComboBoxModelRelationships(dbLink);
    private final ComboBoxModelRelationships modelComboBox_RelationshipAtNutrientPercent = new ComboBoxModelRelationships(dbLink);
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
    private final JCheckBox checkBoxIron = new JCheckBox();
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
    private final JCheckBox checkBoxGlycemicLoad = new JCheckBox();
    private final JCheckBox checkBoxEnergyDigestible = new JCheckBox();
    private final JCheckBox checkBoxEnergyCarbohydrate = new JCheckBox();
    private final JCheckBox checkBoxEnergyProtein = new JCheckBox();
    private final JCheckBox checkBoxEnergyFat = new JCheckBox();
    private final JCheckBox checkBoxEnergyAlcohol = new JCheckBox();
    private final JComboBox comboBoxFoodNutrientConstraintFood = new JComboBox();
    private final JComboBox comboBoxFoodNutrientConstraintNutrient = new JComboBox();
    private final JComboBox comboBoxFoodNutrientConstraintRelationship = new JComboBox();
    private final JComboBox comboBoxFoodNutrientRatioFoodA = new JComboBox();
    private final JComboBox comboBoxFoodNutrientRatioFoodB = new JComboBox();
    private final JComboBox comboBoxFoodNutrientRatioNutrientA = new JComboBox();
    private final JComboBox comboBoxFoodNutrientRatioNutrientB = new JComboBox();
    private final JComboBox comboBoxFoodNutrientRatioRelationship = new JComboBox();
    private final JComboBox comboBoxLifeStage = new JComboBox();
    private final JComboBox comboBoxNutrientConstraintNutrient = new JComboBox();
    private final JComboBox comboBoxNutrientConstraintRelationship = new JComboBox();
    private final JComboBox comboBoxNutrientLookupListNutrient = new JComboBox();
    private final JComboBox comboBoxNutrientRatioNutrientA = new JComboBox();
    private final JComboBox comboBoxNutrientRatioNutrientB = new JComboBox();
    private final JComboBox comboBoxNutrientRatioRelationship = new JComboBox();
    private final JComboBox comboBoxPercentNutrientConstraintFood = new JComboBox();
    private final JComboBox comboBoxPercentNutrientConstraintNutrient = new JComboBox();
    private final JComboBox comboBoxPercentNutrientRelationship = new JComboBox();
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
    private final JMenu menu_spreadsheet = new JMenu();
    private final JMenu menu_exchange = new JMenu();
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
    private final JMenuItem menu_item_alpha_linolenic_acid_required = new JMenuItem();
    private final JMenuItem menuItemConstraintsShownInList = new JMenuItem();
    private final JMenuItem menuItemCredits = new JMenuItem();
    private final JMenuItem menuItemExit = new JMenuItem();
    private final JMenuItem menuItemExportFoodList = new JMenuItem();
    private final JMenuItem menuItemExportFoodMixes = new JMenuItem();
    private final JMenuItem menuItemExportMixCompare = new JMenuItem();
    private final JMenuItem menuItemExportNutrientLookup = new JMenuItem();
    private final JMenuItem menuItemExportRdaCompare = new JMenuItem();
    private final JMenuItem menui_import_message = new JMenuItem();
    private final JMenuItem menui_export_message = new JMenuItem();
    private final JMenuItem menui_show_mix_stats = new JMenuItem();
    private final JMenuItem menuItemGuide = new JMenuItem();
    private final JPanel panelStatusBar = new JPanel();
    private final JTable tableGlycemic = new JTable();
    private final JTable tableCarbs = new JTable();
    private final JTable tableCheckCoefficients = new JTable();
    private final JTable tableCost = new JTable();
    private final JTable tableEnergy = new JTable();
    private final JTable tableFats = new JTable();
    private final JTable tableFoodList01 = new JTable();
    private final JTable tableFoodNutrientConstraint = new JTable();
    private final JTable tableFoodNutrientRatio = new JTable();
    private final JTable tableJournalEnergy = new JTable();
    private final JTable tableJournalProtein = new JTable();
    private final JTable tableJournalFats = new JTable();
    private final JTable tableJournalCarbs = new JTable();
    private final JTable tableJournalVitamins = new JTable();
    private final JTable tableJournalMinerals = new JTable();
    private final JTable tableJournalElectrolytes = new JTable();
    private final JTable tableJournalWater = new JTable();
    private final JTable tableJournalCost = new JTable();
    private final JTable tableJournalGlycemic = new JTable();
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
    private final JTextArea textAreaModel = new JTextArea();
    private final JTextArea textAreaNote = new JTextArea();
    private final JTextArea textAreaJournalModel = new JTextArea();
    private final JTextArea textAreaJournalNote = new JTextArea();
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
    private final TableModelFat modelTableFats = new TableModelFat(dbLink);
    private final TableModelFoodList modelTableFoodList = new TableModelFoodList(dbLink);
    private final TableModelFoodNutrientConstraints modelTableFoodNutrientConstraints = new TableModelFoodNutrientConstraints(dbLink);
    private final TableModelFoodNutrientRatioConstraints modelTableFoodNutrientRatioConstraints = new TableModelFoodNutrientRatioConstraints(dbLink);
    private final TableModelEnergy modelTableJournalEnergy = new TableModelEnergy(dbLink);
    private final TableModelProtein modelTableJournalProtein = new TableModelProtein(dbLink);
    private final TableModelFat modelTableJournalFats = new TableModelFat(dbLink);
    private final TableModelCarbs modelTableJournalCarbs = new TableModelCarbs(dbLink);
    private final TableModelVitamins modelTableJournalVitamins = new TableModelVitamins(dbLink);
    private final TableModelMinerals modelTableJournalMinerals = new TableModelMinerals(dbLink);
    private final TableModelElectrolytes modelTableJournalElectrolytes = new TableModelElectrolytes(dbLink);
    private final TableModelWater modelTableJournalWater = new TableModelWater(dbLink);
    private final TableModelCost modelTableJournalCost = new TableModelCost(dbLink);
    private final TableModelGlycemic modelTableJournalGlycemic = new TableModelGlycemic(dbLink);
    private final TableModelMinerals modelTableMinerals = new TableModelMinerals(dbLink);
    private final TableModelElectrolytes modelTableElectrolytes = new TableModelElectrolytes(dbLink);
    private final TableModelMixComparison modelTableMixDiff = new TableModelMixComparison(dbLink);
    private final TableModelNutrientConstraints modelTableNutrientConstraints = new TableModelNutrientConstraints(dbLink);
    private final TableModelNutrientLookup modelTableNutrientLookup = new TableModelNutrientLookup(dbLink);
    private final TableModelNutrientRatioConstraints modelTableNutrientRatioConstraints = new TableModelNutrientRatioConstraints(dbLink);
    private final TableModelPercentNutrientConstraints tableModelPercentNutrientConstraints = new TableModelPercentNutrientConstraints(dbLink);
    private final TableModelProtein modelTableProtein = new TableModelProtein(dbLink);
    private final TableModelRdaCheck modelTableRda = new TableModelRdaCheck(dbLink);
    private final TableModelResults modelTableResults = new TableModelResults(dbLink);
    private final TableModelVitamins modelTableVitamins = new TableModelVitamins(dbLink);
    private final TableModelWater modelTableWater = new TableModelWater(dbLink);
    private final TableRowSorter tableSorterCheckCoefficients = new TableRowSorter<>(modelTableCheckCoefficients);
    private final TableRowSorter tableSorterFoodList = new TableRowSorter<>(modelTableFoodList);
    private final TableRowSorter tableSorterNutrientInput = new TableRowSorter<>(modelTableNutrientInput);
    private final TreeModelFood modelTreeFoodList = new TreeModelFood(dbLink);
    private JTable tableMixComparison;
    private JTable tableRdaCheck;
    private String foodNameText;
    private JScrollPane tableNutrientInputScrollPane;
    private final JFileChooser fileChooser;

    public Main() {
        fileChooser = new JFileChooser();
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
        mainTabbedPane.add(getJournal());
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
            @Override
            public void windowClosing(WindowEvent e) {
                event_menuItemExit();
            }
        });
        reloadLifeStageComboBox();
        reloadNutrientComboBoxes();
        reloadRelationshipComboBoxes();
        reloadMixes();
        reloadTableModelConstraints("");
        checkBoxCompleteProtein.setName("Complete Protein");
        checkBoxProtein.setName("Protein");
        checkBoxFat.setName("Fat");
        checkBoxCholesterol.setName("Cholesterol");
        checkBoxSaturated.setName("SFA");
        checkBoxDHA.setName("DHA");
        checkBoxEPA.setName("EPA");
        checkBoxMonounsaturated.setName("MUFA");
        checkBoxPolyunsaturated.setName("PUFA");
        checkBoxLinoleic.setName("LA");
        checkBoxAlphaLinolenic.setName("ALA");
        checkBoxDigestibleCarbs.setName("Digestible Carbs");
        checkBoxFiber.setName("Fiber");
        checkBoxVitaminA.setName("Vit A");
        checkBoxVitaminE.setName("Vit E");
        checkBoxVitaminD.setName("Vit D");
        checkBoxVitaminC.setName("Vit C");
        checkBoxThiamin.setName("Thiamin");
        checkBoxRiboflavin.setName("Riboflavin");
        checkBoxNiacin.setName("Niacin");
        checkBoxPantothenic.setName("Pantothenic");
        checkBoxVitaminB6.setName("Vit B6");
        checkBoxVitaminB12.setName("Vit B12");
        checkBoxCholine.setName("Choline");
        checkBoxVitaminK.setName("Vit K");
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
        checkBoxEnergy.setName("Energy, gross");
        checkBoxAlcohol.setName("Alcohol");
        checkBoxWater.setName("Water");
        checkBoxGlycemicLoad.setName("Glycemic Load");
        checkBoxEnergyDigestible.setName("Energy, digestible");
        checkBoxEnergyCarbohydrate.setName("Energy, carbohydrate");
        checkBoxEnergyProtein.setName("Energy, protein");
        checkBoxEnergyFat.setName("Energy, fat");
        checkBoxEnergyAlcohol.setName("Energy, alcohol");
        mapConstraintCheckboxes = new LinkedHashMap<>();
        mapConstraintCheckboxes.put(Nutrient.COMPLETEPROTEIN.getNumber(), checkBoxCompleteProtein);
        mapConstraintCheckboxes.put(Nutrient.PROTEIN.getNumber(), checkBoxProtein);
        mapConstraintCheckboxes.put(Nutrient.FAT.getNumber(), checkBoxFat);
        mapConstraintCheckboxes.put(Nutrient.CHOLESTEROL.getNumber(), checkBoxCholesterol);
        mapConstraintCheckboxes.put(Nutrient.SFA.getNumber(), checkBoxSaturated);
        mapConstraintCheckboxes.put(Nutrient.DHA.getNumber(), checkBoxDHA);
        mapConstraintCheckboxes.put(Nutrient.EPA.getNumber(), checkBoxEPA);
        mapConstraintCheckboxes.put(Nutrient.MUFA.getNumber(), checkBoxMonounsaturated);
        mapConstraintCheckboxes.put(Nutrient.PUFA.getNumber(), checkBoxPolyunsaturated);
        mapConstraintCheckboxes.put(Nutrient.LINOLEIC.getNumber(), checkBoxLinoleic);
        mapConstraintCheckboxes.put(Nutrient.LINOLENIC.getNumber(), checkBoxAlphaLinolenic);
        mapConstraintCheckboxes.put(Nutrient.DIGESTIBLECARBOHYDRATE.getNumber(), checkBoxDigestibleCarbs);
        mapConstraintCheckboxes.put(Nutrient.FIBER.getNumber(), checkBoxFiber);
        mapConstraintCheckboxes.put(Nutrient.VITAMINA.getNumber(), checkBoxVitaminA);
        mapConstraintCheckboxes.put(Nutrient.VITAMINE.getNumber(), checkBoxVitaminE);
        mapConstraintCheckboxes.put(Nutrient.VITAMIND.getNumber(), checkBoxVitaminD);
        mapConstraintCheckboxes.put(Nutrient.VITAMINC.getNumber(), checkBoxVitaminC);
        mapConstraintCheckboxes.put(Nutrient.THIAMIN.getNumber(), checkBoxThiamin);
        mapConstraintCheckboxes.put(Nutrient.RIBOFLAVIN.getNumber(), checkBoxRiboflavin);
        mapConstraintCheckboxes.put(Nutrient.NIACIN.getNumber(), checkBoxNiacin);
        mapConstraintCheckboxes.put(Nutrient.PANTOTHENICACID.getNumber(), checkBoxPantothenic);
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
        mapConstraintCheckboxes.put(Nutrient.ENERGYGROSS.getNumber(), checkBoxEnergy);
        mapConstraintCheckboxes.put(Nutrient.ALCOHOL.getNumber(), checkBoxAlcohol);
        mapConstraintCheckboxes.put(Nutrient.WATER.getNumber(), checkBoxWater);
        mapConstraintCheckboxes.put(Nutrient.GLYCEMICLOAD.getNumber(), checkBoxGlycemicLoad);
        mapConstraintCheckboxes.put(Nutrient.ENERGYDIGESTIBLE.getNumber(), checkBoxEnergyDigestible);
        mapConstraintCheckboxes.put(Nutrient.ENERGYCARBOHYDRATE.getNumber(), checkBoxEnergyCarbohydrate);
        mapConstraintCheckboxes.put(Nutrient.ENERGYPROTEIN.getNumber(), checkBoxEnergyProtein);
        mapConstraintCheckboxes.put(Nutrient.ENERGYFAT.getNumber(), checkBoxEnergyFat);
        mapConstraintCheckboxes.put(Nutrient.ENERGYALCOHOL.getNumber(), checkBoxEnergyAlcohol);
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

        }
        event_menuItemRoundUp();
    }

    public static void main(String[] args) {
        try {
            Font font = new Font(Font.DIALOG, Font.PLAIN, 12);
            //MetalLookAndFeel.setCurrentTheme(new io.github.xjrga.looks.roughdraft.Theme(font));
            MetalLookAndFeel.setCurrentTheme(new io.github.xjrga.looks.themes.Dawn_135(font));
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (ClassNotFoundException e) {
        } catch (IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e) {

        }
        Main main = new Main();
    }

    private void reloadTableModelConstraints(String mixId) {
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
        modelComboBox_RelationshipAtNutrientRatio.reload();
        modelComboBox_RelationshipAtFoodNutrientRatio.reload();
        modelComboBox_RelationshipAtNutrientPercent.reload();
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
        menuTools.add(menu_item_alpha_linolenic_acid_required);
        menuTools.add(menui_show_mix_stats);
        menuData.add(menu_spreadsheet);
        menuData.add(menu_exchange);
        menu_spreadsheet.add(menuItemExportFoodList);
        menu_spreadsheet.add(menuItemExportFoodMixes);
        menu_spreadsheet.add(menuItemExportMixCompare);
        menu_spreadsheet.add(menuItemExportRdaCompare);
        menu_spreadsheet.add(menuItemExportNutrientLookup);
        menu_exchange.add(menui_import_message);
        menu_exchange.add(menui_export_message);
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
        menuItemMicronutrientConversion.setText("Daily Value (%DV) to Grams");
        menuItemBmr.setText("Basal Metabolic Rate Of An Individual");
        menuItemNitrogenBalance.setText("Complete Protein Required In A No Fat, No Carbs Regimen");
        menuItemKetosis.setText("Carbohydrate Required To Inhibit Ketosis");
        menuItemDigestibleCarbs.setText("Digestible Carbohydrate Of A Food Item");
        menuItemGlycemicLoad.setText("Glycemic Load Of A Food Item");
        menu_item_alpha_linolenic_acid_required.setText("Alpha-Linolenic Acid Required");
        menui_show_mix_stats.setText("Macronutrient Percentages");
        menuItemGlycemicIndexRange.setText("Glycemic Index Range Of A Food Item");
        menu_spreadsheet.setText("Spreadsheet");
        menu_exchange.setText("Exchange");
        menuItemExportFoodList.setText("Food List");
        menuItemExportFoodMixes.setText("Food Mixes");
        menuItemExportMixCompare.setText("Mix Comparison");
        menuItemExportRdaCompare.setText("RDA Check");
        menuItemExportNutrientLookup.setText("Nutrient Lookup");
        menui_import_message.setText("Import");
        menui_export_message.setText("Export");
        checkBoxResultRoundUp.setText("Round Up");
        menuItemConstraintsShownInList.setText("Nutrients Shown As Constraints");
        menuItemGuide.setText("Guide");
        menuItemCredits.setText("Credits");
        menuItemAbout.setText("About");
        checkBoxResultRoundUp.setSelected(true);
        menuItemMicronutrientConversion.addActionListener((ActionEvent e) -> {
            event_menuItemMicronutrientConversion();
        });
        menuItemBmr.addActionListener((ActionEvent e) -> {
            event_menuItemBmr();
        });
        menuItemNitrogenBalance.addActionListener((ActionEvent e) -> {
            event_menuItemNitrogenBalance();
        });
        menuItemKetosis.addActionListener((ActionEvent e) -> {
            event_menuItemKetosis();
        });
        menuItemDigestibleCarbs.addActionListener((ActionEvent e) -> {
            event_menuItemDigestibleCarbs();
        });
        menuItemGlycemicLoad.addActionListener((ActionEvent e) -> {
            event_menuItemGlycemicLoad();
        });
        menu_item_alpha_linolenic_acid_required.addActionListener((ActionEvent e) -> {
            event_menu_item_n3_fatty_acid_recommendations();
        });
        menui_show_mix_stats.addActionListener((ActionEvent e) -> {
            frameSnack.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
            event_menui_show_mix_stats();
            frameSnack.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        });
        menuItemGlycemicIndexRange.addActionListener((ActionEvent e) -> {
            event_menuItemGlycemicIndexRange();
        });
        menuItemExportFoodList.addActionListener((ActionEvent e) -> {
            event_menuItemFoodListExport();
        });
        menuItemExportFoodMixes.addActionListener((ActionEvent e) -> {
            event_menuItemFoodMixesExport();
        });
        menuItemExportMixCompare.addActionListener((ActionEvent e) -> {
            event_menuItemMixComparisonExport();
        });
        menuItemExportRdaCompare.addActionListener((ActionEvent e) -> {
            event_menuItemRdaCheckExport();
        });
        menuItemExportNutrientLookup.addActionListener((ActionEvent e) -> {
            event_menuItemNutrientLookupExport();
        });
        menui_export_message.addActionListener((ActionEvent e) -> {
            event_send_message();
        });
        menui_import_message.addActionListener((ActionEvent e) -> {
            frameSnack.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
            event_receive_message();
            event_buttonSolve();
            frameSnack.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        });
        menuItemGuide.addActionListener((ActionEvent e) -> {
            event_menuItemGuide();
        });
        menuItemCredits.addActionListener((ActionEvent e) -> {
            event_menuItemCredits();
        });
        menuItemAbout.addActionListener((ActionEvent e) -> {
            event_menuItemAbout();
        });
        menuItemConstraintsShownInList.addActionListener((ActionEvent e) -> {
            event_menuItemNutrientsShownAsConstraints();
        });
        checkBoxResultRoundUp.addActionListener((ActionEvent e) -> {
            event_menuItemRoundUp();
        });
        menuItemExit.addActionListener((ActionEvent e) -> {
            event_menuItemExit();
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
        int optionValue = Message.showOptionDialog(inputs, "Digestible Carbohydrate");
        if (optionValue == 0) {
            String totalCarbsText = totalCarbs.getText();
            inputs = new JComponent[]{
                new JLabel("What is total fiber (g) in food item?"),
                totalFiber
            };
            optionValue = Message.showOptionDialog(inputs, "Digestible Carbohydrate");
            if (optionValue == 0) {
                String totalFiberText = totalFiber.getText();
                if (totalCarbsText != null && totalCarbsText.length() > 0) {
                    if (totalFiberText != null && totalFiberText.length() > 0) {
                        StringBuilder sb = new StringBuilder();
                        NumberCheck checkNumber = new NumberCheck();
                        checkNumber.addToUncheckedList(totalCarbsText);
                        checkNumber.addToUncheckedList(totalFiberText);
                        if (checkNumber.pass()) {
                            Double totalCarbsNumber = Double.valueOf(totalCarbsText);
                            Double totalFiberNumber = Double.valueOf(totalFiberText);
                            double digestibleCarbsNumber = new DigestibleCarbohydrate(totalCarbsNumber, totalFiberNumber).getDigestibleCarbohydrate();
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
        }
    }

    private void event_menuItemGlycemicIndexRange() {
        JTextField txtGI = new JTextField();
        JComponent[] inputs = new JComponent[]{
            new JLabel("What is glycemic index of food item?"),
            txtGI
        };
        int optionValue = Message.showOptionDialog(inputs, "Glycemic Index Range");
        if (optionValue == 0) {
            String strGI = txtGI.getText();
            if (strGI != null && strGI.length() > 0) {
                StringBuilder sb = new StringBuilder();
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
        int optionValue = Message.showOptionDialog(inputs, "Basal Metabolic Rate");
        if (optionValue == 0) {
            String s = textFieldLbs.getText();
            if (s != null && s.length() > 0) {
                StringBuilder sb = new StringBuilder();
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
    }

    private void event_menuItemNitrogenBalance() {
        JTextField textFieldLbs = new JTextField();
        JComponent[] inputs = new JComponent[]{
            new JLabel("What is your lean body mass in pounds?"),
            textFieldLbs
        };
        int optionValue = Message.showOptionDialog(inputs, "Complete Protein Required");
        if (optionValue == 0) {
            String s = textFieldLbs.getText();
            if (s != null && s.length() > 0) {
                StringBuilder sb = new StringBuilder();
                NumberCheck checkNumber = new NumberCheck();
                checkNumber.addToUncheckedList(s);
                if (checkNumber.pass()) {
                    Double weightinlbs = Double.valueOf(s);
                    double protein = new MinimumNutrientRequirements(weightinlbs).getProtein();
                    sb.append("Complete protein required in a no fat, no carbs regimen is ");
                    sb.append(Math.round(protein));
                    sb.append(" grams");
                    sb.append("\n");
                    JTextArea textArea = new JTextArea(1, 40);
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
    }

    private void event_menuItemKetosis() {
        StringBuilder sb = new StringBuilder();
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
        int optionValue = Message.showOptionDialog(inputs, "Pct Daily Value to Grams");
        if (optionValue == 0) {
            String s = dailyValuePct.getText();
            if (s != null && s.length() > 0) {
                NutrientDataObject nutrientDataObject = (NutrientDataObject) cboxNutrients.getSelectedItem();
                StringBuilder sb = new StringBuilder();
                NumberCheck checkNumber = new NumberCheck();
                checkNumber.addToUncheckedList(s);
                if (checkNumber.pass()) {
                    Double dvpct = Double.valueOf(s);
                    sb.append(dvpct * (nutrientDataObject.getQ() / 100));
                    sb.append(" ");
                    sb.append(nutrientDataObject.getNutrdesc());
                    sb.append("\n");
                    JTextArea textArea = new JTextArea(1, 30);
                    textArea.setText(sb.toString());
                    textArea.setEditable(false);
                    inputs = new JComponent[]{
                        textArea
                    };
                    Message.showOptionDialog(inputs, "Pct Daily Value to Grams");
                } else {
                    Message.showMessage("Numbers only");
                }
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
        JTabbedPane bottomTabPane = new JTabbedPane();
        bottomTabPane.setBorder(new TitledBorder("Model Definition"));
        bottomTabPane.setTabPlacement(JTabbedPane.BOTTOM);
        FormLayout splitPanelReplacementLayout = new FormLayout("360px,min:grow", //columns
                "fill:min:grow" //rows
        );
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(splitPanelReplacementLayout);
        bottomPanel.add(getMixList(), cc.xy(1, 1));
        bottomPanel.add(bottomTabPane, cc.xy(2, 1));
        bottom.add(bottomPanel, cc.xy(1, 1));
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
        listMixes.addListSelectionListener((ListSelectionEvent e) -> {
            if (!e.getValueIsAdjusting()) {
                frameSnack.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
                event_listMixes(e);
                frameSnack.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
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
        buttonCreateMix.addActionListener((ActionEvent e) -> {
            event_buttonAddMix();
        });
        buttonDeleteMix.addActionListener((ActionEvent e) -> {
            event_buttonDeleteMix();
        });
        buttonRenameMix.addActionListener((ActionEvent e) -> {
            event_buttonRenameMix();
        });
        buttonDuplicateMix.addActionListener((ActionEvent e) -> {
            event_buttonDuplicateMix();
        });
        buttonArchiveMix.addActionListener((ActionEvent e) -> {
            event_buttonArchiveMix();
        });
        buttonAddMixToFoodList.addActionListener((ActionEvent e) -> {
            event_buttonAddMixToFoodList();
        });
        buttonSolve.addActionListener((ActionEvent e) -> {
            frameSnack.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
            event_buttonSolve();
            frameSnack.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        });
        return panel;
    }

    private void event_buttonArchiveMix() {
        if (isMixSelected()) {
            try {
                MixDataObject mix = (MixDataObject) listMixes.getSelectedValue();
                String mixId = mix.getMixId();
                dbLink.Mix_Update_Status(mixId, 0);
                reloadMixes();
                clearAllModels();
            } catch (SQLException e) {

            }
        }
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
            //Model minimizes this value (objective)
            String nutrientid = "10009";
            try {
                String mixid = dbLink.Mix_Insert(mixnom);
                dbLink.Mix_Update_NutrientId(mixid, nutrientid);
                dbLink.Mix_Update_Other(mixid, model, note);
                dbLink.Mix_Update_Status(mixid, 1);
                reloadMixes();
                clearAllModels();
                listMixes.setSelectedIndex(listMixes.getLastVisibleIndex());
            } catch (SQLException e) {

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

    private void reloadFoodComboBoxes(String mixId) {
        modelComboBox_FoodAtNutrient.reload(mixId);
        modelComboBox_FoodAtNutrientPct.reload(mixId);
        modelComboBox_0_FoodAtFoodNutrientRatio.reload(mixId);
        modelComboBox_1_FoodAtFoodNutrientRatio.reload(mixId);
    }

    private void reloadTableModels() {
        if (isMixSelected()) {
            MixDataObject mixDataObject = (MixDataObject) listMixes.getSelectedValue();
            String mixId = mixDataObject.getMixId();
            modelTableEnergy.reload(mixId);
            tableEnergy.getColumnModel().getColumn(0).setMinWidth(400);
            tableEnergy.getColumnModel().getColumn(0).setMaxWidth(400);
            for (int i = 1; i < 12; i++) {
                tableEnergy.getColumnModel().getColumn(i).setMinWidth(70);
                tableEnergy.getColumnModel().getColumn(i).setMaxWidth(70);
            }
            modelTableProtein.reload(mixId);
            tableProtein.getColumnModel().getColumn(0).setMinWidth(400);
            tableProtein.getColumnModel().getColumn(0).setMaxWidth(400);
            for (int i = 1; i < 5; i++) {
                tableProtein.getColumnModel().getColumn(i).setMinWidth(70);
                tableProtein.getColumnModel().getColumn(i).setMaxWidth(70);
            }
            modelTableFats.reload(mixId);
            tableFats.getColumnModel().getColumn(0).setMinWidth(400);
            tableFats.getColumnModel().getColumn(0).setMaxWidth(400);
            for (int i = 1; i < 12; i++) {
                tableFats.getColumnModel().getColumn(i).setMinWidth(70);
                tableFats.getColumnModel().getColumn(i).setMaxWidth(70);
            }
            modelTableCarbs.reload(mixId);
            tableCarbs.getColumnModel().getColumn(0).setMinWidth(400);
            tableCarbs.getColumnModel().getColumn(0).setMaxWidth(400);
            for (int i = 1; i < 6; i++) {
                tableCarbs.getColumnModel().getColumn(i).setMinWidth(70);
                tableCarbs.getColumnModel().getColumn(i).setMaxWidth(70);
            }
            modelTableVitamins.reload(mixId);
            tableVitamins.getColumnModel().getColumn(0).setMinWidth(400);
            tableVitamins.getColumnModel().getColumn(0).setMaxWidth(400);
            for (int i = 1; i < 15; i++) {
                tableVitamins.getColumnModel().getColumn(i).setMinWidth(70);
                tableVitamins.getColumnModel().getColumn(i).setMaxWidth(70);
            }
            modelTableMinerals.reload(mixId);
            tableMinerals.getColumnModel().getColumn(0).setMinWidth(400);
            tableMinerals.getColumnModel().getColumn(0).setMaxWidth(400);
            for (int i = 1; i < 11; i++) {
                tableMinerals.getColumnModel().getColumn(i).setMinWidth(70);
                tableMinerals.getColumnModel().getColumn(i).setMaxWidth(70);
            }
            modelTableWater.reload(mixId);
            tableWater.getColumnModel().getColumn(0).setMinWidth(400);
            tableWater.getColumnModel().getColumn(0).setMaxWidth(400);
            for (int i = 1; i < 3; i++) {
                tableWater.getColumnModel().getColumn(i).setMinWidth(70);
                tableWater.getColumnModel().getColumn(i).setMaxWidth(70);
            }
            modelTableCost.reload(mixId);
            tableCost.getColumnModel().getColumn(0).setMinWidth(400);
            tableCost.getColumnModel().getColumn(0).setMaxWidth(400);
            for (int i = 1; i < 3; i++) {
                tableCost.getColumnModel().getColumn(i).setMinWidth(70);
                tableCost.getColumnModel().getColumn(i).setMaxWidth(70);
            }
            modelTableElectrolytes.reload(mixId);
            tableElectrolytes.getColumnModel().getColumn(0).setMinWidth(400);
            tableElectrolytes.getColumnModel().getColumn(0).setMaxWidth(400);
            for (int i = 1; i < 4; i++) {
                tableElectrolytes.getColumnModel().getColumn(i).setMinWidth(70);
                tableElectrolytes.getColumnModel().getColumn(i).setMaxWidth(70);
            }
            modelTableGlycemic.reload(mixId);
            tableGlycemic.getColumnModel().getColumn(0).setMinWidth(400);
            tableGlycemic.getColumnModel().getColumn(0).setMaxWidth(400);
            for (int i = 1; i < 8; i++) {
                tableGlycemic.getColumnModel().getColumn(i).setMinWidth(70);
                tableGlycemic.getColumnModel().getColumn(i).setMaxWidth(70);
            }
        }
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
                    String mixId = mix.getMixId();
                    dbLink.Mix_Delete(mixId);
                    reloadMixes();
                    clearAllModels();
                } catch (SQLException e) {

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
        //
        modelTableEnergy.setRowCount(0);
        modelTableProtein.setRowCount(0);
        modelTableFats.setRowCount(0);
        modelTableCarbs.setRowCount(0);
        modelTableVitamins.setRowCount(0);
        modelTableMinerals.setRowCount(0);
        modelTableElectrolytes.setRowCount(0);
        modelTableWater.setRowCount(0);
        modelTableCost.setRowCount(0);
        modelTableGlycemic.setRowCount(0);
        //
        modelTableJournalEnergy.setRowCount(0);
        modelTableJournalProtein.setRowCount(0);
        modelTableJournalFats.setRowCount(0);
        modelTableJournalCarbs.setRowCount(0);
        modelTableJournalVitamins.setRowCount(0);
        modelTableJournalMinerals.setRowCount(0);
        modelTableJournalElectrolytes.setRowCount(0);
        modelTableJournalWater.setRowCount(0);
        modelTableJournalCost.setRowCount(0);
        modelTableJournalGlycemic.setRowCount(0);
        //
        modelTableResults.setRowCount(0);
        modelTableMixDiff.setRowCount(0);
        modelTableRda.setRowCount(0);
        modelComboBox_FoodAtNutrient.reload("");
        modelComboBox_FoodAtNutrientPct.reload("");
        modelComboBox_0_FoodAtFoodNutrientRatio.reload("");
        modelComboBox_1_FoodAtFoodNutrientRatio.reload("");
        textAreaModel.setText("");
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
                    String mixId = mix.getMixId();
                    dbLink.Mix_Update_Name(mixId, mixnom);
                    reloadMixes();
                    listMixes.setSelectedIndex(selectedIndex);
                } catch (SQLException e) {

                }
            }
        }
    }

    private void event_buttonDuplicateMix() {
        if (isMixSelected()) {
            try {
                MixDataObject mix = (MixDataObject) listMixes.getSelectedValue();
                String mixId = mix.getMixId();
                dbLink.Mix_Duplicate(mixId);
                reloadMixes();
            } catch (SQLException e) {

            }
        } else {
            Message.showMessage("Select mix.");
        }
    }

    private void event_buttonAddMixToFoodList() {
        if (isMixSelected()) {
            JComponent[] inputs = new JComponent[]{
                new JLabel("Would you like to add mix to food list?"),};
            int optionValue = Message.showOptionDialogYesNo(inputs, "Add to Food List");
            if (optionValue == 0) {
                try {
                    MixDataObject mixDataObject = (MixDataObject) listMixes.getSelectedValue();
                    dbLink.Food_Put(mixDataObject.getMixId());
                    reloadFoodItems();
                } catch (SQLException e) {

                }
            }
        } else {
            Message.showMessage("Select mix");
        }
    }

    private JTable getTableMixComparison() {
        JTable table;
        table = new JTable() {
            @Override
            public Component prepareRenderer(TableCellRenderer renderer, int rowIndex, int columnIndex) {
                JComponent component = (JComponent) super.prepareRenderer(renderer, rowIndex, columnIndex);
                Double valueAt;
                switch (columnIndex) {
                    case 0:
                        component.setForeground(tableEnergy.getForeground());
                        break;
                    case 1:
                        valueAt = (Double) getValueAt(rowIndex, columnIndex);
                        if (valueAt <= 0) {
                            component.setForeground(Color.red);
                        } else {
                            component.setForeground(tableEnergy.getForeground());
                        }
                        break;
                    case 2:
                        valueAt = (Double) getValueAt(rowIndex, columnIndex);
                        if (valueAt <= 0) {
                            component.setForeground(Color.red);
                        } else {
                            component.setForeground(tableEnergy.getForeground());
                        }
                        break;
                    case 3:
                        valueAt = (Double) getValueAt(rowIndex, columnIndex);
                        if (valueAt < 0) {
                            component.setForeground(Color.red);
                        } else {
                            component.setForeground(tableEnergy.getForeground());
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
        CellConstraints cellc = new CellConstraints();
        //create layouts
        FormLayout layout = new FormLayout(
                "min:grow(.25),min:grow(.25),min:grow", //columns
                "fill:min:grow" //rows
        );
        panel.setLayout(layout);
        panel.add(scrollPaneA, cellc.xy(1, 1));
        panel.add(scrollPaneB, cellc.xy(2, 1));
        panel.add(scrollPaneC, cellc.xy(3, 1));
        layout.setColumnGroup(1, 2);
        scrollPaneA.setBorder(new TitledBorder("Mix 1"));
        scrollPaneB.setBorder(new TitledBorder("Mix 2"));
        scrollPaneC.setBorder(new TitledBorder("Mix Difference"));
        listCompareA.addListSelectionListener((ListSelectionEvent e) -> {
            event_listCompareA(e);
        });
        listCompareB.addListSelectionListener((ListSelectionEvent e) -> {
            event_listCompareB(e);
        });
        listCompareA.setModel(modelList_A_MixDiff);
        listCompareB.setModel(modelList_B_MixDiff);
        tableMixComparison.setModel(modelTableMixDiff);
        tableMixComparison.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tableMixComparison.setFillsViewportHeight(true);
        tableMixComparison.setAutoCreateRowSorter(true);
        modelList_A_MixDiff.reload();
        modelList_B_MixDiff.reload();
        resizeColumns_MixComparisonTable();
        return panel;
    }

    private JTable getTableRdaCheck() {
        JTable table;
        table = new JTable() {
            @Override
            public Component prepareRenderer(TableCellRenderer renderer, int rowIndex, int columnIndex) {
                JComponent component = (JComponent) super.prepareRenderer(renderer, rowIndex, columnIndex);
                Double valueAt;
                switch (columnIndex) {
                    case 0:
                        component.setForeground(tableEnergy.getForeground());
                        break;
                    case 1:
                        component.setForeground(tableEnergy.getForeground());
                        break;
                    case 2:
                        valueAt = (Double) getValueAt(rowIndex, columnIndex);
                        if (valueAt <= 0) {
                            component.setForeground(Color.red);
                        } else {
                            component.setForeground(tableEnergy.getForeground());
                        }
                        break;
                    case 3:
                        component.setForeground(tableEnergy.getForeground());
                        break;
                    case 4:
                        valueAt = (Double) getValueAt(rowIndex, columnIndex);
                        if (valueAt < 100) {
                            component.setForeground(Color.red);
                        }
                        break;
                    case 5:
                        component.setForeground(tableEnergy.getForeground());
                        break;
                    case 6:
                        valueAt = (Double) getValueAt(rowIndex, columnIndex);
                        if (valueAt > 100) {
                            component.setForeground(Color.red);
                        } else {
                            component.setForeground(tableEnergy.getForeground());
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
        CellConstraints cellc = new CellConstraints();
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
        panelRdaDiff.add(new JLabel(" Lifestage:"), cellc.xy(1, 2));
        panelRdaDiff.add(comboBoxLifeStage, cellc.xy(2, 2));
        panelRdaDiff.add(scrollPaneRdaDiff, cellc.xyw(1, 4, 3));
        panel.setLayout(layout);
        panel.add(scrollPaneMix, cellc.xy(1, 1));
        panel.add(panelRdaDiff, cellc.xy(2, 1));
        scrollPaneMix.setBorder(new TitledBorder("Mix"));
        scrollPaneRdaDiff.setBorder(new TitledBorder("RDA Check"));
        listRdaCheck.addListSelectionListener((ListSelectionEvent e) -> {
            event_ListRdaDiff(e);
        });
        comboBoxLifeStage.setModel(modelComboBoxLifeStage);
        listRdaCheck.setModel(modelListRda);
        tableRdaCheck.setModel(modelTableRda);
        tableRdaCheck.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tableRdaCheck.setFillsViewportHeight(true);
        tableRdaCheck.setTableHeader(new TableHeaderRdaDiff(tableRdaCheck.getColumnModel()));
        tableRdaCheck.setAutoCreateRowSorter(true);
        modelListRda.reload();
        resizeColumns_RdaCheckTable();
        comboBoxLifeStage.addActionListener((ActionEvent e) -> {
            event_comboBoxLifeStage();
        });
        JPopupMenu popMenu = new JPopupMenu();
        JMenuItem item = new JMenuItem("Do Nutrient Lookup");
        popMenu.add(item);
        item.addActionListener((ActionEvent e) -> {
            int selectedRowNo = tableRdaCheck.getSelectedRow();
            if (selectedRowNo != -1) {
                String nutrientid = (String) tableRdaCheck.getValueAt(selectedRowNo, 0);
                String nutrient = (String) tableRdaCheck.getValueAt(selectedRowNo, 1);
                Double rda = (Double) tableRdaCheck.getValueAt(selectedRowNo, 3);
                textFieldNutrientLookup.setText(String.valueOf(rda));
                NutrientDataObject nutrientDataObject = new NutrientDataObject(nutrientid, nutrient, null);
                modelComboBox_NutrientLookupListNutrient.setSelectedItem(nutrientDataObject);
                modelTableNutrientLookup.reload(nutrientid, rda);
                resizeColumns_NutrientLookupTable();
                resizeColumns_RdaCheckTable();
            } else {
                Message.showMessage("Please select nutrient");
            }
        });
        tableRdaCheck.addMouseListener(new MouseAdapter() {
            @Override
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

    private JPanel getJournal() {
        JPanel panel = new JPanel();
        FormLayout layout = new FormLayout(
                "200px,min:grow", //columns
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
        JTabbedPane rightComponent = new JTabbedPane();
        rightComponent.setBorder(new TitledBorder("Mix Results"));
        rightComponent.setTabPlacement(JTabbedPane.BOTTOM);
        rightComponent.add(getEnergyJournal());
        rightComponent.add(getProteinJournal());
        rightComponent.add(getFatsJournal());
        rightComponent.add(getCarbsJournal());
        rightComponent.add(getVitaminsJournal());
        rightComponent.add(getMineralsJournal());
        rightComponent.add(getElectrolytesJournal());
        rightComponent.add(getWaterJournal());
        rightComponent.add(getCostJournal());
        rightComponent.add(getGlycemicJournal());
        rightComponent.add(getJournalModel());
        rightComponent.add(getJournalNote());
        rightComponent.setTitleAt(0, "Energy");
        rightComponent.setTitleAt(1, "Protein");
        rightComponent.setTitleAt(2, "Fats");
        rightComponent.setTitleAt(3, "Carbohydrates");
        rightComponent.setTitleAt(4, "Vitamins");
        rightComponent.setTitleAt(5, "Minerals");
        rightComponent.setTitleAt(6, "Electrolytes");
        rightComponent.setTitleAt(7, "Water");
        rightComponent.setTitleAt(8, "Cost");
        rightComponent.setTitleAt(9, "Glycemic");
        rightComponent.setTitleAt(10, "Model");
        rightComponent.setTitleAt(11, "Note");
        panel.add(leftComponent, cc.xy(1, 1));
        panel.add(rightComponent, cc.xy(2, 1));
        listMixesJournal.addListSelectionListener(e -> event_listMixesJournal(e));
        listMixesJournal.setModel(modelListFoodJournal);
        modelListFoodJournal.reload();
        buttonEditMix.addActionListener(e -> event_buttonEditMix());
        return panel;
    }

    private void event_listMixesJournal(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()) {
            frameSnack.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
            reloadTableModelsJournal();
            frameSnack.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        }
    }

    private void reloadTableModelsJournal() {
        if (isMixJournalSelected()) {
            MixDataObject mixDataObject = (MixDataObject) listMixesJournal.getSelectedValue();
            String mixId = mixDataObject.getMixId();
            modelTableResults.reload(mixId);
            modelTableJournalEnergy.reload(mixId);
            tableJournalEnergy.getColumnModel().getColumn(0).setMinWidth(400);
            tableJournalEnergy.getColumnModel().getColumn(0).setMaxWidth(400);
            for (int i = 1; i < 12; i++) {
                tableJournalEnergy.getColumnModel().getColumn(i).setMinWidth(70);
                tableJournalEnergy.getColumnModel().getColumn(i).setMaxWidth(70);
            }
            modelTableJournalProtein.reload(mixId);
            tableJournalProtein.getColumnModel().getColumn(0).setMinWidth(400);
            tableJournalProtein.getColumnModel().getColumn(0).setMaxWidth(400);
            for (int i = 1; i < 5; i++) {
                tableJournalProtein.getColumnModel().getColumn(i).setMinWidth(70);
                tableJournalProtein.getColumnModel().getColumn(i).setMaxWidth(70);
            }
            modelTableJournalFats.reload(mixId);
            tableJournalFats.getColumnModel().getColumn(0).setMinWidth(400);
            tableJournalFats.getColumnModel().getColumn(0).setMaxWidth(400);
            for (int i = 1; i < 12; i++) {
                tableJournalFats.getColumnModel().getColumn(i).setMinWidth(70);
                tableJournalFats.getColumnModel().getColumn(i).setMaxWidth(70);
            }
            modelTableJournalCarbs.reload(mixId);
            tableJournalCarbs.getColumnModel().getColumn(0).setMinWidth(400);
            tableJournalCarbs.getColumnModel().getColumn(0).setMaxWidth(400);
            for (int i = 1; i < 6; i++) {
                tableJournalCarbs.getColumnModel().getColumn(i).setMinWidth(70);
                tableJournalCarbs.getColumnModel().getColumn(i).setMaxWidth(70);
            }
            modelTableJournalVitamins.reload(mixId);
            tableJournalVitamins.getColumnModel().getColumn(0).setMinWidth(400);
            tableJournalVitamins.getColumnModel().getColumn(0).setMaxWidth(400);
            for (int i = 1; i < 15; i++) {
                tableJournalVitamins.getColumnModel().getColumn(i).setMinWidth(70);
                tableJournalVitamins.getColumnModel().getColumn(i).setMaxWidth(70);
            }
            modelTableJournalMinerals.reload(mixId);
            tableJournalMinerals.getColumnModel().getColumn(0).setMinWidth(400);
            tableJournalMinerals.getColumnModel().getColumn(0).setMaxWidth(400);
            for (int i = 1; i < 11; i++) {
                tableJournalMinerals.getColumnModel().getColumn(i).setMinWidth(70);
                tableJournalMinerals.getColumnModel().getColumn(i).setMaxWidth(70);
            }
            modelTableJournalElectrolytes.reload(mixId);
            tableJournalElectrolytes.getColumnModel().getColumn(0).setMinWidth(400);
            tableJournalElectrolytes.getColumnModel().getColumn(0).setMaxWidth(400);
            for (int i = 1; i < 4; i++) {
                tableJournalElectrolytes.getColumnModel().getColumn(i).setMinWidth(70);
                tableJournalElectrolytes.getColumnModel().getColumn(i).setMaxWidth(70);
            }
            modelTableJournalWater.reload(mixId);
            tableJournalWater.getColumnModel().getColumn(0).setMinWidth(400);
            tableJournalWater.getColumnModel().getColumn(0).setMaxWidth(400);
            for (int i = 1; i < 3; i++) {
                tableJournalWater.getColumnModel().getColumn(i).setMinWidth(70);
                tableJournalWater.getColumnModel().getColumn(i).setMaxWidth(70);
            }
            modelTableJournalCost.reload(mixId);
            tableJournalCost.getColumnModel().getColumn(0).setMinWidth(400);
            tableJournalCost.getColumnModel().getColumn(0).setMaxWidth(400);
            for (int i = 1; i < 3; i++) {
                tableJournalCost.getColumnModel().getColumn(i).setMinWidth(70);
                tableJournalCost.getColumnModel().getColumn(i).setMaxWidth(70);
            }
            modelTableJournalGlycemic.reload(mixId);
            tableJournalGlycemic.getColumnModel().getColumn(0).setMinWidth(400);
            tableJournalGlycemic.getColumnModel().getColumn(0).setMaxWidth(400);
            for (int i = 1; i < 8; i++) {
                tableJournalGlycemic.getColumnModel().getColumn(i).setMinWidth(70);
                tableJournalGlycemic.getColumnModel().getColumn(i).setMaxWidth(70);
            }
            textAreaJournalModel.setText(getLinearProgrammingModel(mixId));
            textAreaJournalNote.setText(getNote(mixId));
        }
    }

    private void event_buttonEditMix() {
        if (!listMixesJournal.isSelectionEmpty()) {
            try {
                MixDataObject mix = (MixDataObject) listMixesJournal.getSelectedValue();
                String mixId = mix.getMixId();
                dbLink.Mix_Update_Status(mixId, 1);
                reloadMixes();
                clearAllModels();
            } catch (SQLException e) {

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
        JScrollPane scrollPaneTable01 = new JScrollPane(tableFoodList01);
        searchPanel.add(new JLabel("Search:"), cc.xy(1, 1));
        searchPanel.add(textFieldFoodListSearch, cc.xy(2, 1));
        buttonPanel.add(buttonFoodListAdd, cc.xy(2, 1));
        buttonPanel.add(buttonFoodListDelete, cc.xy(3, 1));
        buttonPanel.add(buttonFoodListUpdate, cc.xy(4, 1));
        buttonPanel.add(buttonFoodListDuplicate, cc.xy(5, 1));
        panel.add(searchPanel, cc.xy(1, 1));
        panel.add(scrollPaneTable01, cc.xy(1, 2));
        panel.add(buttonPanel, cc.xy(1, 3));
        scrollPaneTable01.setBorder(new TitledBorder("Food List"));
        buttonFoodListAdd.setToolTipText("Add Food Item");
        buttonFoodListUpdate.setToolTipText("Update Food Item");
        buttonFoodListDelete.setToolTipText("Delete Food Item");
        buttonFoodListDuplicate.setToolTipText("Duplicate Food Item");
        buttonFoodListAdd.addActionListener((ActionEvent e) -> {
            event_buttonFoodListAdd();
        });
        buttonFoodListDelete.addActionListener((ActionEvent e) -> {
            event_buttonFoodListDelete();
        });
        buttonFoodListUpdate.addActionListener((ActionEvent e) -> {
            event_buttonFoodListUpdate();
        });
        buttonFoodListDuplicate.addActionListener((ActionEvent e) -> {
            event_buttonFoodListDuplicate();
        });
        textFieldFoodListSearch.getDocument().addDocumentListener(
                new DocumentListener() {
            @Override
            public void changedUpdate(DocumentEvent e) {
                foodSearchFilter();
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                foodSearchFilter();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                foodSearchFilter();
            }
        });
        tableFoodList01.setTableHeader(new TableHeaderFoodList(tableFoodList01.getColumnModel()));
        tableFoodList01.setRowSorter(tableSorterFoodList);
        tableFoodList01.setModel(modelTableFoodList);
        tableFoodList01.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tableFoodList01.setFillsViewportHeight(true);
        tableFoodList01.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        reloadFoodItems();
        JPopupMenu popMenu = new JPopupMenu();
        JMenuItem item = new JMenuItem("Check Coefficients");
        popMenu.add(item);
        item.addActionListener((ActionEvent e) -> {
            int selectedRowNo = tableFoodList01.getSelectedRow();
            if (selectedRowNo != -1) {
                checkCoefficients((String) tableFoodList01.getValueAt(selectedRowNo, 0));
            } else {
                Message.showMessage("Please select food item");
            }
        });
        tableFoodList01.addMouseListener(new MouseAdapter() {
            @Override
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
        int selectedRowNo = tableFoodList01.getSelectedRow();
        if (selectedRowNo != -1) {
            String foodId = (String) tableFoodList01.getValueAt(selectedRowNo, 0);
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

            return;
        }
        tableSorterCheckCoefficients.setRowFilter(rf);
    }

    private void checkCoefficients(String foodId) {
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
        textFieldFoodName.setText((String) tableFoodList01.getValueAt(tableFoodList01.getSelectedRow(), 1));
        JComponent[] inputs = new JComponent[]{
            panel
        };
        tableCheckCoefficients.setRowSelectionInterval(0, 0);
        int optionValue = Message.showOptionDialog(inputs, "Check Coefficients");
        if (optionValue == 0) {
        }
        buttonNext.addActionListener((ActionEvent e) -> {
            int selectedRowNo = tableCheckCoefficients.getSelectedRow();
            if (selectedRowNo != tableCheckCoefficients.getRowCount() - 1) {
                selectedRowNo++;
                scrollToRowUsingTable(tableCheckCoefficients, selectedRowNo);
            } else {
                selectTableRowUsingTable(tableCheckCoefficients, selectedRowNo);
            }
        });
        buttonPrevious.addActionListener((ActionEvent e) -> {
            int selectedRowNo = tableCheckCoefficients.getSelectedRow();
            if (selectedRowNo > 0 && selectedRowNo < tableCheckCoefficients.getRowCount()) {
                selectedRowNo--;
                scrollToRowUsingTable(tableCheckCoefficients, selectedRowNo);
            } else {
                selectTableRowUsingTable(tableCheckCoefficients, 0);
            }
        });
        textFieldNutrientSearchCheckCoefficients.getDocument().addDocumentListener(
                new DocumentListener() {
            @Override
            public void changedUpdate(DocumentEvent e) {
                nutrientSearchCheckCoefficientsFilter();
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                nutrientSearchCheckCoefficientsFilter();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                nutrientSearchCheckCoefficientsFilter();
            }
        });
    }

    private void nutrientSearchFilter() {
        RowFilter<TableModelDataInput, Object> rf = null;
        try {
            ArrayList filters = new ArrayList();
            filters.add(RowFilter.regexFilter("(?i)" + textFieldNutrientSearch.getText(), 1));
            filters.add(RowFilter.regexFilter("(?i)" + textFieldNutrientSearch.getText(), 2));
            rf = RowFilter.orFilter((Iterable<? extends RowFilter<? super TableModelDataInput, ? super Object>>) filters);
        } catch (java.util.regex.PatternSyntaxException e) {

            return;
        }
        tableSorterNutrientInput.setRowFilter(rf);
    }

    private void event_fillCompleteProteinDataButton() {
        JTextPane instructions = new JTextPane();
        JTextField proteinText = new JTextField();
        StringBuilder sb = new StringBuilder();
        JPanel inputsPanel = new JPanel();
        JComponent[] inputs = new JComponent[]{
            inputsPanel
        };
        FormLayout layout = new FormLayout(
                "min:grow,min:grow", //columns
                "fill:min:grow,min" //rows
        );
        JLabel proteinLabel = new JLabel("Protein (g): ");
        NumberCheck checkNumber = new NumberCheck();
        //
        proteinText.setText(String.valueOf(modelTableNutrientInput.getValueAt(1, 3)));
        instructions.setEditable(false);
        sb.append("To calculate complete protein value\n\n");
        sb.append("1. Please find 'Protein' value on nutrition facts label and enter that number here only if most of the food protein is from animal sources or soy\n\n");
        instructions.setText(sb.toString());
        inputsPanel.setPreferredSize(new Dimension(350, GoldenRatio.getShortSide(350)));
        inputsPanel.setLayout(layout);
        inputsPanel.add(new JScrollPane(instructions), cc.xyw(1, 1, 2));
        proteinLabel.setHorizontalAlignment(JLabel.RIGHT);
        inputsPanel.add(proteinLabel, cc.xy(1, 2));
        inputsPanel.add(proteinText, cc.xy(2, 2));
        int optionValue = Message.showOptionDialog(inputs, "Complete Protein");
        if (optionValue == 0) {
            String s0 = proteinText.getText();
            if ((s0 != null && s0.length() > 0)) {
                checkNumber.addToUncheckedList(s0);
                if (checkNumber.pass()) {
                    Double protein = Double.valueOf(proteinText.getText());
                    //Row value is determined by sql query.
                    modelTableNutrientInput.setValueAt(protein, 0, 3);
                    modelTableNutrientInput.setValueAt(protein, 1, 3);
                    Integer modelRowId = 0;
                    selectTableRowUsingModel(tableNutrientInput, modelRowId);
                    scrollToRowUsingModel(tableNutrientInput, modelRowId);
                } else {
                    Message.showMessage("Numbers only");
                }
            }
        }
    }

    private void event_fillFatButton() {
        JTextPane instructions = new JTextPane();
        JTextField totalFatText = new JTextField();
        JTextField saturatedFatText = new JTextField();
        JTextField monounsaturatedFatText = new JTextField();
        JTextField polyunsaturatedFatText = new JTextField();
        StringBuilder sb = new StringBuilder();
        JPanel inputsPanel = new JPanel();
        JComponent[] inputs = new JComponent[]{
            inputsPanel
        };
        FormLayout layout = new FormLayout(
                "min:grow,min:grow", //columns
                "fill:min:grow,min,min,min,min" //rows
        );
        JLabel totalFatLabel = new JLabel("Total Fat (g): ");
        JLabel saturatedFatLabel = new JLabel("Saturated Fat (g): ");
        JLabel monounsaturatedFatLabel = new JLabel("Monounsaturated Fat (g): ");
        JLabel polyunsaturatedFatLabel = new JLabel("Polyunsaturated Fat (g): ");
        NumberCheck checkNumber = new NumberCheck();
        //
        totalFatText.setText(String.valueOf(modelTableNutrientInput.getValueAt(2, 3)));
        saturatedFatText.setText(String.valueOf(modelTableNutrientInput.getValueAt(4, 3)));
        monounsaturatedFatText.setText(String.valueOf(modelTableNutrientInput.getValueAt(7, 3)));
        polyunsaturatedFatText.setText(String.valueOf(modelTableNutrientInput.getValueAt(8, 3)));
        instructions.setEditable(false);
        sb.append("Please enter fat quantities\n\n");
        instructions.setText(sb.toString());
        inputsPanel.setPreferredSize(new Dimension(350, GoldenRatio.getShortSide(350)));
        inputsPanel.setLayout(layout);
        JScrollPane scrollPane = new JScrollPane(instructions);
        inputsPanel.add(scrollPane, cc.xyw(1, 1, 2));
        totalFatLabel.setHorizontalAlignment(JLabel.RIGHT);
        saturatedFatLabel.setHorizontalAlignment(JLabel.RIGHT);
        monounsaturatedFatLabel.setHorizontalAlignment(JLabel.RIGHT);
        polyunsaturatedFatLabel.setHorizontalAlignment(JLabel.RIGHT);
        inputsPanel.add(totalFatLabel, cc.xy(1, 2));
        inputsPanel.add(totalFatText, cc.xy(2, 2));
        inputsPanel.add(saturatedFatLabel, cc.xy(1, 3));
        inputsPanel.add(saturatedFatText, cc.xy(2, 3));
        inputsPanel.add(monounsaturatedFatLabel, cc.xy(1, 4));
        inputsPanel.add(monounsaturatedFatText, cc.xy(2, 4));
        inputsPanel.add(polyunsaturatedFatLabel, cc.xy(1, 5));
        inputsPanel.add(polyunsaturatedFatText, cc.xy(2, 5));
        SwingUtilities.invokeLater(() -> {
            scrollPane.getViewport().setViewPosition(new Point(0, 0));
        });
        int optionValue = Message.showOptionDialog(inputs, "Fat");
        if (optionValue == 0) {
            String s0 = totalFatText.getText();
            String s1 = saturatedFatText.getText();
            String s2 = monounsaturatedFatText.getText();
            String s3 = polyunsaturatedFatText.getText();
            if ((s0 != null && s0.length() > 0) && (s1 != null && s1.length() > 0) && (s2 != null && s2.length() > 0) && (s3 != null && s3.length() > 0)) {
                checkNumber.addToUncheckedList(s0);
                if (checkNumber.pass()) {
                    Double totalFat = Double.valueOf(totalFatText.getText());
                    Double saturatedFat = Double.valueOf(saturatedFatText.getText());
                    Double monounsaturatedFat = Double.valueOf(monounsaturatedFatText.getText());
                    Double polyunsaturatedFat = Double.valueOf(polyunsaturatedFatText.getText());
                    //Row value is determined by sql query.
                    modelTableNutrientInput.setValueAt(totalFat, 2, 3);
                    modelTableNutrientInput.setValueAt(saturatedFat, 4, 3);
                    modelTableNutrientInput.setValueAt(monounsaturatedFat, 7, 3);
                    modelTableNutrientInput.setValueAt(polyunsaturatedFat, 8, 3);
                    Integer modelRowId = 2;
                    selectTableRowUsingModel(tableNutrientInput, modelRowId);
                    scrollToRowUsingModel(tableNutrientInput, modelRowId);
                } else {
                    Message.showMessage("Numbers only");
                }
            }
        }
    }

    private void event_fillCarbohydrateDataButton() {
        JTextPane instructions = new JTextPane();
        JTextField carbsByDiffText = new JTextField();
        JTextField fiberText = new JTextField();
        StringBuilder sb = new StringBuilder();
        JPanel inputsPanel = new JPanel();
        JComponent[] inputs = new JComponent[]{
            inputsPanel
        };
        FormLayout layout = new FormLayout(
                "min:grow,min:grow", //columns
                "fill:min:grow,min,min" //rows
        );
        JLabel carbsByDiffLabel = new JLabel("Total Carbohydrate (g): ");
        JLabel fiberLabel = new JLabel("Dietary Fiber (g): ");
        NumberCheck checkNumber = new NumberCheck();
        //
        carbsByDiffText.setText(String.valueOf(modelTableNutrientInput.getValueAt(13, 3)));
        fiberText.setText(String.valueOf(modelTableNutrientInput.getValueAt(14, 3)));
        instructions.setEditable(false);
        sb.append("To calculate digestible carbohydrate value\n\n");
        sb.append("1. Please find 'Total Carbohydrate' value on nutrition facts label and enter that number\n\n");
        sb.append("2. Please find 'Dietary Fiber' value on nutrition facts label and enter that number\n\n");
        sb.append("Total Carbohydrate is 'carbohydrate by difference'");
        instructions.setText(sb.toString());
        inputsPanel.setPreferredSize(new Dimension(350, GoldenRatio.getShortSide(350)));
        inputsPanel.setLayout(layout);
        inputsPanel.add(new JScrollPane(instructions), cc.xyw(1, 1, 2));
        carbsByDiffLabel.setHorizontalAlignment(JLabel.RIGHT);
        fiberLabel.setHorizontalAlignment(JLabel.RIGHT);
        inputsPanel.add(carbsByDiffLabel, cc.xy(1, 2));
        inputsPanel.add(carbsByDiffText, cc.xy(2, 2));
        inputsPanel.add(fiberLabel, cc.xy(1, 3));
        inputsPanel.add(fiberText, cc.xy(2, 3));
        int optionValue = Message.showOptionDialog(inputs, "Digestible Carbohydrate");
        if (optionValue == 0) {
            String s0 = carbsByDiffText.getText();
            String s1 = fiberText.getText();
            if ((s0 != null && s0.length() > 0) && (s1 != null && s1.length() > 0)) {
                checkNumber.addToUncheckedList(s0);
                if (checkNumber.pass()) {
                    Double carbsByDiff = Double.valueOf(carbsByDiffText.getText());
                    Double fiber = Double.valueOf(fiberText.getText());
                    Double digestibleCarbohydrate = carbsByDiff - fiber;
                    //Row value is determined by sql query.
                    modelTableNutrientInput.setValueAt(digestibleCarbohydrate, 11, 3);
                    modelTableNutrientInput.setValueAt(carbsByDiff, 13, 3);
                    modelTableNutrientInput.setValueAt(fiber, 14, 3);
                    Integer modelRowId = 11;
                    selectTableRowUsingModel(tableNutrientInput, modelRowId);
                    scrollToRowUsingModel(tableNutrientInput, modelRowId);
                } else {
                    Message.showMessage("Numbers only");
                }
            }
        }
    }

    private void event_fillEnergyDataButton() {
        JTextPane instructions = new JTextPane();
        JTextField proteinText = new JTextField();
        JTextField fatText = new JTextField();
        JTextField digestibleCarbohydrateText = new JTextField();
        JTextField alcoholText = new JTextField();
        StringBuilder sb = new StringBuilder();
        JPanel inputsPanel = new JPanel();
        JComponent[] inputs = new JComponent[]{
            inputsPanel
        };
        FormLayout layout = new FormLayout(
                "min:grow,min:grow", //columns
                "fill:min:grow,min,min,min,min" //rows
        );
        JLabel proteinLabel = new JLabel("Protein (g): ");
        JLabel fatLabel = new JLabel("Fat (g): ");
        JLabel digestibleCarbohydrateLabel = new JLabel("Digestible Carbohydrate (g): ");
        JLabel alcoholLabel = new JLabel("Alcohol (g): ");
        NumberCheck checkNumber = new NumberCheck();
        //
        proteinText.setEditable(false);
        fatText.setEditable(false);
        digestibleCarbohydrateText.setEditable(false);
        alcoholText.setEditable(false);
        proteinText.setText(String.valueOf(modelTableNutrientInput.getValueAt(1, 3)));
        fatText.setText(String.valueOf(modelTableNutrientInput.getValueAt(2, 3)));
        digestibleCarbohydrateText.setText(String.valueOf(modelTableNutrientInput.getValueAt(11, 3)));
        alcoholText.setText(String.valueOf(modelTableNutrientInput.getValueAt(41, 3)));
        instructions.setEditable(false);
        sb.append("To calculate energy values\n\n");
        sb.append("1. Verify displayed values are correct\n\n");
        sb.append("2. Click ok\n\n");
        sb.append("If displayed values are not correct, close this popup window and go back and set them.\n");
        instructions.setText(sb.toString());
        inputsPanel.setPreferredSize(new Dimension(350, GoldenRatio.getShortSide(350)));
        inputsPanel.setLayout(layout);
        JScrollPane scrollPane = new JScrollPane(instructions);
        inputsPanel.add(scrollPane, cc.xyw(1, 1, 2));
        proteinLabel.setHorizontalAlignment(JLabel.RIGHT);
        fatLabel.setHorizontalAlignment(JLabel.RIGHT);
        digestibleCarbohydrateLabel.setHorizontalAlignment(JLabel.RIGHT);
        alcoholLabel.setHorizontalAlignment(JLabel.RIGHT);
        inputsPanel.add(proteinLabel, cc.xy(1, 2));
        inputsPanel.add(proteinText, cc.xy(2, 2));
        inputsPanel.add(fatLabel, cc.xy(1, 3));
        inputsPanel.add(fatText, cc.xy(2, 3));
        inputsPanel.add(digestibleCarbohydrateLabel, cc.xy(1, 4));
        inputsPanel.add(digestibleCarbohydrateText, cc.xy(2, 4));
        inputsPanel.add(alcoholLabel, cc.xy(1, 5));
        inputsPanel.add(alcoholText, cc.xy(2, 5));
        SwingUtilities.invokeLater(() -> {
            scrollPane.getViewport().setViewPosition(new Point(0, 0));
        });
        int optionValue = Message.showOptionDialog(inputs, "Energy");
        if (optionValue == 0) {
            String s0 = proteinText.getText();
            String s1 = fatText.getText();
            String s2 = digestibleCarbohydrateText.getText();
            String s3 = alcoholText.getText();
            if ((s0 != null && s0.length() > 0) && (s1 != null && s1.length() > 0) && (s2 != null && s2.length() > 0) && (s3 != null && s3.length() > 0)) {
                checkNumber.addToUncheckedList(s0);
                if (checkNumber.pass()) {
                    Double protein = Double.valueOf(proteinText.getText());
                    Double fat = Double.valueOf(fatText.getText());
                    Double digestibleCarbohydrate = Double.valueOf(digestibleCarbohydrateText.getText());
                    Double alcohol = Double.valueOf(alcoholText.getText());
                    MacroNutrientEnergyValues energyValues = new MacroNutrientEnergyValues.Builder().protein(protein).fat(fat).digestibleCarbohydrate(digestibleCarbohydrate).alcohol(alcohol).build();
                    energyValues.getProteinEnergy();
                    //Row value is determined by sql query.
                    modelTableNutrientInput.setValueAt(energyValues.getProteinEnergy(), 45, 3);
                    modelTableNutrientInput.setValueAt(energyValues.getAlcoholEnergy(), 47, 3);
                    modelTableNutrientInput.setValueAt(energyValues.getFatEnergy(), 46, 3);
                    modelTableNutrientInput.setValueAt(energyValues.getEnergyDigestible(), 43, 3);
                    modelTableNutrientInput.setValueAt(energyValues.getDigestibleCarbohydrateEnergy(), 44, 3);
                    Integer modelRowId = 43;
                    selectTableRowUsingModel(tableNutrientInput, modelRowId);
                    scrollToRowUsingModel(tableNutrientInput, modelRowId);
                } else {
                    Message.showMessage("Numbers only");
                }
            }
        }
    }

    private void event_fillVitaminsValuesButton() {
        FormLayout layout = new FormLayout("min:grow,min,min:grow", //columns
                "fill:min:grow" //rows
        );
        JPanel panel = new JPanel();
        JComponent[] inputs = new JComponent[]{
            panel
        };
        panel.setLayout(layout);
        JComboBox cboxNutrients = new JComboBox();
        JTextField dailyValuePct = new JTextField();
        NumberCheck checkNumber = new NumberCheck();
        String s0 = "";
        Double dvpct = -1.0;
        Double xgrams = -1.0;
        NutrientDataObject nutrientDataObject = null;
        //
        cboxNutrients.setModel(modelComboBox_NutrientLookupListConvert);
        modelComboBox_NutrientLookupListConvert.reload();
        dailyValuePct.setMinimumSize(new Dimension(50, 20));
        panel.add(cboxNutrients, cc.xy(1, 1));
        panel.add(dailyValuePct, cc.xy(2, 1));
        panel.add(new JLabel(" %DV"), cc.xy(3, 1));
        int optionValue = Message.showOptionDialog(inputs, "Vitamins And Minerals");
        if (optionValue == 0) {
            s0 = dailyValuePct.getText();
            if (s0 != null && s0.length() > 0) {
                checkNumber.addToUncheckedList(s0);
                if (checkNumber.pass()) {
                    nutrientDataObject = (NutrientDataObject) cboxNutrients.getSelectedItem();
                    dvpct = Double.valueOf(s0);
                    xgrams = dvpct * (nutrientDataObject.getQ() / 100);
                    Integer modelColumnId = 3;
                    Integer modelRowId = modelTableNutrientInput.find(nutrientDataObject.getNutr_no());
                    modelTableNutrientInput.setValueAt(xgrams, modelRowId, modelColumnId);
                    selectTableRowUsingModel(tableNutrientInput, modelRowId);
                    scrollToRowUsingModel(tableNutrientInput, modelRowId);
                } else {
                    Message.showMessage("Numbers only");
                }
            }
        }
    }

    private void event_fillGlycemicLoadButton() {
        JTextPane instructions = new JTextPane();
        JTextField digestibleCarbohydrateText = new JTextField();
        JTextField glycemicIndexText = new JTextField();
        StringBuilder sb = new StringBuilder();
        JPanel inputsPanel = new JPanel();
        JComponent[] inputs = new JComponent[]{
            inputsPanel
        };
        FormLayout layout = new FormLayout(
                "min:grow,min:grow", //columns
                "fill:min:grow,min,min" //rows
        );
        JLabel digestibleCarbohydrateLabel = new JLabel("Digestible Carbohydrate (g): ");
        JLabel glycemicIndexLabel = new JLabel("Glycemic Index: ");
        NumberCheck checkNumber = new NumberCheck();
        //
        digestibleCarbohydrateText.setEditable(false);
        digestibleCarbohydrateText.setText(String.valueOf(modelTableNutrientInput.getValueAt(11, 3)));
        instructions.setEditable(false);
        sb.append("To calculate glycemic load value\n\n");
        sb.append("1. Verify 'Digestible Carbohydrate' value is correct\n\n");
        sb.append("2. Please find 'Glycemic Index' value and enter that number\n\n");
        instructions.setText(sb.toString());
        inputsPanel.setPreferredSize(new Dimension(350, GoldenRatio.getShortSide(350)));
        inputsPanel.setLayout(layout);
        inputsPanel.add(new JScrollPane(instructions), cc.xyw(1, 1, 2));
        digestibleCarbohydrateLabel.setHorizontalAlignment(JLabel.RIGHT);
        glycemicIndexLabel.setHorizontalAlignment(JLabel.RIGHT);
        inputsPanel.add(digestibleCarbohydrateLabel, cc.xy(1, 2));
        inputsPanel.add(digestibleCarbohydrateText, cc.xy(2, 2));
        inputsPanel.add(glycemicIndexLabel, cc.xy(1, 3));
        inputsPanel.add(glycemicIndexText, cc.xy(2, 3));
        int optionValue = Message.showOptionDialog(inputs, "Glycemic Load");
        if (optionValue == 0) {
            String s0 = digestibleCarbohydrateText.getText();
            String s1 = glycemicIndexText.getText();
            if ((s0 != null && s0.length() > 0) && (s1 != null && s1.length() > 0)) {
                checkNumber.addToUncheckedList(s0);
                if (checkNumber.pass()) {
                    Double digestibleCarbohydrate = Double.valueOf(digestibleCarbohydrateText.getText());
                    Double glycemicIndex = Double.valueOf(glycemicIndexText.getText());
                    GlycemicLoad glycemicLoad = new GlycemicLoad(glycemicIndex, digestibleCarbohydrate);
                    //Row value is determined by sql query.
                    modelTableNutrientInput.setValueAt(glycemicLoad.getGlycemicLoad(), 12, 3);
                    modelTableNutrientInput.setValueAt(digestibleCarbohydrate, 11, 3);
                    Integer modelRowId = 12;
                    selectTableRowUsingModel(tableNutrientInput, modelRowId);
                    scrollToRowUsingModel(tableNutrientInput, modelRowId);
                } else {
                    Message.showMessage("Numbers only");
                }
            }
        }
    }

    private void selectTableRowUsingModel(JTable table, Integer modelRowId) {
        Integer tableRowId = table.convertRowIndexToView(modelRowId);
        this.selectTableRowUsingTable(table, tableRowId);
    }

    private void selectTableRowUsingTable(JTable table, int tableRowId) {
        table.setRowSelectionInterval(tableRowId, tableRowId);
    }

    private void scrollToRowUsingModel(JTable table, Integer modelRowId) {
        Integer tableRowId = table.convertRowIndexToView(modelRowId);
        this.scrollToRowUsingTable(table, tableRowId);
    }

    private void scrollToRowUsingTable(JTable table, int tableRowId) {
        table.setRowSelectionInterval(tableRowId, tableRowId);
        Rectangle rect = table.getCellRect(tableRowId, 0, true);
        table.scrollRectToVisible(rect);
    }

    private JPanel getWizardPanel() {
        JPanel wizardPanel = new JPanel();
        FormLayout layout = new FormLayout(
                "min:grow,min,min,min,min,min,min,min:grow", //columns
                "min" //rows
        );
        wizardPanel.setLayout(layout);
        JButton fillCompleteProteinButton = new JButton("Protein");
        JButton fillFatButton = new JButton("Fat");
        JButton fillDigestibleCarbsButton = new JButton("Carbs");
        JButton fillEnergyDataButton = new JButton("Energy");
        JButton fillVitaminsButton = new JButton("Vitamins");
        JButton fillGlycemicLoadButton = new JButton("Glycemic");
        //Protein, Fat, Carbs, Energy, Vitamins, Glycemic
        wizardPanel.add(fillCompleteProteinButton, cc.xy(2, 1));
        wizardPanel.add(fillFatButton, cc.xy(3, 1));
        wizardPanel.add(fillDigestibleCarbsButton, cc.xy(4, 1));
        wizardPanel.add(fillEnergyDataButton, cc.xy(5, 1));
        wizardPanel.add(fillVitaminsButton, cc.xy(6, 1));
        wizardPanel.add(fillGlycemicLoadButton, cc.xy(7, 1));
        layout.setColumnGroup(2, 3, 4, 5, 6, 7);
        fillCompleteProteinButton.setToolTipText("Complete Protein calculator assistant");
        fillFatButton.setToolTipText("Fat calculator assistant");
        fillDigestibleCarbsButton.setToolTipText("Digestible carbohydrate calculator assistant");
        fillEnergyDataButton.setToolTipText("Energy values calculator assistant");
        fillVitaminsButton.setToolTipText("Vitamin and mineral values calculator assistant");
        fillGlycemicLoadButton.setToolTipText("Glycemic load calculator assistant");
        fillCompleteProteinButton.addActionListener((ActionEvent e) -> {
            event_fillCompleteProteinDataButton();
        });
        fillFatButton.addActionListener((ActionEvent e) -> {
            event_fillFatButton();
        });
        fillDigestibleCarbsButton.addActionListener((ActionEvent e) -> {
            event_fillCarbohydrateDataButton();
        });
        fillEnergyDataButton.addActionListener((ActionEvent e) -> {
            event_fillEnergyDataButton();
        });
        fillVitaminsButton.addActionListener((ActionEvent e) -> {
            event_fillVitaminsValuesButton();
        });
        fillGlycemicLoadButton.addActionListener((ActionEvent e) -> {
            event_fillGlycemicLoadButton();
        });

        return wizardPanel;
    }

    private void updateFoodItem(String foodId, Integer optionValue) {
        tableNutrientInput.setRowSorter(tableSorterNutrientInput);
        tableNutrientInput.setModel(modelTableNutrientInput);
        tableNutrientInput.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tableNutrientInput.setFillsViewportHeight(true);
        tableNutrientInput.setDefaultEditor(Double.class, new DoubleTableCellEditor());
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
                "10px,min,min,min,4px,min,4px,fill:min:grow,10px" //rows
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
        panel.add(getWizardPanel(), cc.xyw(2, 6, 7));
        tableNutrientInputScrollPane = new JScrollPane(tableNutrientInput);
        panel.add(tableNutrientInputScrollPane, cc.xyw(2, 8, 7));
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

            }
        }
        buttonNext.addActionListener((ActionEvent e) -> {
            int selectedRowNo = tableNutrientInput.getSelectedRow();
            if (selectedRowNo != tableNutrientInput.getRowCount() - 1) {
                tableNutrientInput.getDefaultEditor(Double.class).cancelCellEditing();
                selectedRowNo++;
                scrollToRowUsingTable(tableNutrientInput, selectedRowNo);
            } else {
                selectTableRowUsingTable(tableNutrientInput, selectedRowNo);
            }
        });
        buttonPrevious.addActionListener((ActionEvent e) -> {
            int selectedRowNo = tableNutrientInput.getSelectedRow();
            if (selectedRowNo > 0 && selectedRowNo < tableNutrientInput.getRowCount()) {
                tableNutrientInput.getDefaultEditor(Double.class).cancelCellEditing();
                selectedRowNo--;
                scrollToRowUsingTable(tableNutrientInput, selectedRowNo);
            } else {
                selectTableRowUsingTable(tableNutrientInput, 0);
            }
        });
        buttonNutrientWeightSave.addActionListener((ActionEvent e) -> {
            int selectedRowNo = tableNutrientInput.getSelectedRow();
            if (selectedRowNo != -1) {
                NumberCheck numberCheck = new NumberCheck();
                numberCheck.addToUncheckedList(textFieldNutrientValue.getText());
                if (numberCheck.pass()) {
                    tableNutrientInput.getDefaultEditor(Double.class).cancelCellEditing();
                    modelTableNutrientInput.setValueAt(Double.valueOf(textFieldNutrientValue.getText()), tableNutrientInput.convertRowIndexToModel(selectedRowNo), 3);
                } else {
                    Message.showMessage("Value must be a number greater than or equal to zero");
                }
            }
        });
        ListSelectionModel selectionModel = tableNutrientInput.getSelectionModel();
        selectionModel.addListSelectionListener((ListSelectionEvent e) -> {
            if (e.getValueIsAdjusting()) {
                tableNutrientInput.getDefaultEditor(Double.class).cancelCellEditing();
                return;
            } else {
                //if not adjusting then it throws exception
            }
            int selectedRowNo = tableNutrientInput.getSelectedRow();
            if (selectedRowNo != -1) {
                String nutrient = (String) modelTableNutrientInput.getValueAt(tableNutrientInput.convertRowIndexToModel(selectedRowNo), 2);
                Double weight = (Double) modelTableNutrientInput.getValueAt(tableNutrientInput.convertRowIndexToModel(selectedRowNo), 3);
                textFieldNutrientValue.setText(String.valueOf(weight));
                labelNutrientWeight.setText(nutrient);
            }
        });
        textFieldNutrientSearch.getDocument().addDocumentListener(
                new DocumentListener() {
            @Override
            public void changedUpdate(DocumentEvent e) {
                nutrientSearchFilter();
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                nutrientSearchFilter();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                nutrientSearchFilter();
            }
        });
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
                        if (!nutrientid.equals("10000")) {
                            q = (Double) modelTableNutrientInput.getValueAt(j, 3);
                            dbLink.FoodFact_Merge(foodId, nutrientid, q);
                        }
                    }
                } catch (SQLException e) {

                }
                dbLink.stopTransaction();
                reloadFoodItems();
                rowIndex = modelTableFoodList.find(foodId);
                scrollToRowUsingTable(tableFoodList01, tableFoodList01.convertRowIndexToView(rowIndex));
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

        }
    }

    private void event_buttonFoodListUpdate() {
        int selectedRowNo = tableFoodList01.getSelectedRow();
        if (selectedRowNo != -1) {
            String foodId = (String) tableFoodList01.getValueAt(selectedRowNo, 0);
            updateFoodItem(foodId, -1);
        }
    }

    private void event_buttonFoodListDelete() {
        int selectedRowNo = tableFoodList01.getSelectedRow();
        if (selectedRowNo != -1) {
            String foodId = (String) tableFoodList01.getValueAt(selectedRowNo, 0);
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
        tableNutrientLookup.setAutoCreateRowSorter(true);
        buttonNutrientLookupListRun.addActionListener((ActionEvent e) -> {
            event_buttonNutrientLookupListRun();
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
            modelTableFoodList.setPrecision(0);
            //
            modelTableEnergy.setPrecision(0);
            modelTableProtein.setPrecision(0);
            modelTableFats.setPrecision(0);
            modelTableCarbs.setPrecision(0);
            modelTableVitamins.setPrecision(0);
            modelTableMinerals.setPrecision(0);
            modelTableElectrolytes.setPrecision(0);
            modelTableWater.setPrecision(0);
            modelTableCost.setPrecision(0);
            modelTableGlycemic.setPrecision(0);
            //
            modelTableJournalEnergy.setPrecision(0);
            modelTableJournalProtein.setPrecision(0);
            modelTableJournalFats.setPrecision(0);
            modelTableJournalCarbs.setPrecision(0);
            modelTableJournalVitamins.setPrecision(0);
            modelTableJournalMinerals.setPrecision(0);
            modelTableJournalElectrolytes.setPrecision(0);
            modelTableJournalWater.setPrecision(0);
            modelTableJournalCost.setPrecision(0);
            modelTableJournalGlycemic.setPrecision(0);
            //
            modelTableResults.setPrecision(0);
            modelTableMixDiff.setPrecision(0);
            modelTableRda.setPrecision(0);
            stringModelMixPct.setPrecision(0);
            modelTableNutrientLookup.setPrecision(0);
            modelTableNutrientInput.setPrecision(5);
        } else {
            modelTableFoodList.setPrecision(5);
            //
            modelTableEnergy.setPrecision(5);
            modelTableProtein.setPrecision(5);
            modelTableFats.setPrecision(5);
            modelTableCarbs.setPrecision(5);
            modelTableVitamins.setPrecision(5);
            modelTableMinerals.setPrecision(5);
            modelTableElectrolytes.setPrecision(5);
            modelTableWater.setPrecision(5);
            modelTableCost.setPrecision(5);
            modelTableGlycemic.setPrecision(5);
            //
            modelTableJournalEnergy.setPrecision(5);
            modelTableJournalFats.setPrecision(5);
            modelTableJournalCarbs.setPrecision(5);
            modelTableJournalVitamins.setPrecision(5);
            modelTableJournalMinerals.setPrecision(5);
            modelTableJournalElectrolytes.setPrecision(5);
            modelTableJournalWater.setPrecision(5);
            modelTableJournalCost.setPrecision(5);
            modelTableJournalGlycemic.setPrecision(5);
            //
            modelTableResults.setPrecision(5);
            modelTableMixDiff.setPrecision(5);
            modelTableRda.setPrecision(5);
            stringModelMixPct.setPrecision(5);
            modelTableNutrientLookup.setPrecision(5);
            modelTableNutrientInput.setPrecision(5);
        }
        if (isMixSelected()) {
            MixDataObject mixDataObject = (MixDataObject) listMixes.getSelectedValue();
            String mixId = mixDataObject.getMixId();
            reloadTableModels();
        }
        reloadFoodItems();
        reloadTableModelsJournal();
        reloadMixComparison();
        reloadRdaCheck();
        reloadNutrientLookup();
    }

    private void event_menuItemNutrientsShownAsConstraints() {
        JComponent[] inputs = new JComponent[]{
            getConstraintsPanel()
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

                }
            }
            );
            reloadNutrientComboBoxes();
        }
    }

    private JPanel getConstraintsPanel() {
        JPanel panel00 = new JPanel();
        FormLayout panel00Layout = new FormLayout(
                "4px,min:grow,4px", //columns
                "4px,fill:min:grow,4px" //rows
        );
        JPanel panel01 = new JPanel();
        FormLayout panel01Layout = new FormLayout(
                "min,min,min,min,min,min,min,min,min,min,min,min,min", //columns
                "min,min,min,min,min,min,min,min,min,min" //rows
        );
        //
        panel00.setLayout(panel00Layout);
        panel00.setPreferredSize(new Dimension(620, 220));
        panel00.add(panel01, cc.xy(2, 2));
        panel01.setLayout(panel01Layout);
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
            } else if (x < 61) {
                panel01.add(label, cc.xy(11, x - 50));
                panel01.add(cb, cc.xy(12, x - 50));
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
        openUrl("http://xjrga.github.io/snack");
    }

    private void event_menuItemCredits() {
        StringBuilder sb = new StringBuilder();
        sb.append("Snack uses the following libraries:");
        sb.append("\n\n");
        sb.append("commons-math3-3.6.1.jar");
        sb.append("\n");
        sb.append("hsqldb-2.6.1.jar");
        sb.append("\n");
        sb.append("jgoodies-common-1.8.1.jar");
        sb.append("\n");
        sb.append("jgoodies-forms-1.9.0.jar");
        sb.append("\n");
        sb.append("poi-4.0.1.jar");
        sb.append("\n");
        sb.append("looks-01.jar");
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
        StringBuilder sb = new StringBuilder();
        sb.append("Understand Your Food Intake");
        sb.append("\n\n");
        sb.append("Snack is learning software for nutrition, a meal design tool and calculator that could facilitate achieving your health goals and objectives by first helping you understand your food intake and second by allowing you to create new food combinations that meet specific requirements.");
        sb.append("\n\n");
        sb.append("Snack is a training program designed to find lowest calorie food combination. It minimizes digestible energy. It lets you experiment and get faster, better, less expensive results so you can rapidly learn. Its intended audience is anyone with interest in nutrition.");
        sb.append("\n\n");
        String txt = "Features:\n"
                + "        - quantify food intake\n"
                + "        - track any nutrient or compound that has an impact on health\n"
                + "        - find food items that provide a specific nutrient\n"
                + "        - keep a food journal and track progress\n"
                + "        - compare two meals to see difference in nutritional value\n"
                + "        - compare meals against Required Daily Allowance (RDA) values\n"
                + "        - compare meals against Upper Limit (UL) values       \n"
                + "        - export data and create reports in spreadsheet      \n"
                + "        - quantify any popular diet for comparison and research purposes       \n"
                + "        - annotate mixes\n"
                + "        - calculate basal metabolic rate (BMR)\n"
                + "        - calculate glycemic index (GI) and glycemic load (GL) of a meal\n"
                + "        - check glycemic index range\n"
                + "        - calculate food quotient (FQ)                \n"
                + "        - convert percent daily value (%DV) to grams\n"
                + "        - facilitate learning/teaching anyone with interest in nutrition\n"
                + "        - exchange mix and food data easily\n"
                + "        - is free and open source\n"
                + "    \n"
                + "    Requirements:\n"
                + "       - Java 11";
        sb.append(txt);
        sb.append("\n\n");
        sb.append("This is build 780");
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
        SwingUtilities.invokeLater(() -> {
            scrollPane.getViewport().setViewPosition(new Point(0, 0));
        });
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
        highScorePane.setToolTipText("Press delete button to clear list");
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

    private JScrollPane getGlycemicJournal() {
        JScrollPane scrollPane = new JScrollPane(tableJournalGlycemic);
        tableJournalGlycemic.setModel(modelTableJournalGlycemic);
        tableJournalGlycemic.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tableJournalGlycemic.setFillsViewportHeight(true);
        tableJournalGlycemic.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tableJournalGlycemic.setTableHeader(new TableHeaderGlycemic(tableJournalGlycemic.getColumnModel()));
        tableJournalGlycemic.setAutoCreateRowSorter(true);
        return scrollPane;
    }

    private JScrollPane getGlycemic() {
        JScrollPane scrollPane = new JScrollPane(tableGlycemic);
        tableGlycemic.setModel(modelTableGlycemic);
        tableGlycemic.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tableGlycemic.setFillsViewportHeight(true);
        tableGlycemic.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tableGlycemic.setTableHeader(new TableHeaderGlycemic(tableGlycemic.getColumnModel()));
        tableGlycemic.setAutoCreateRowSorter(true);
        return scrollPane;
    }

    private JScrollPane getEnergyJournal() {
        JScrollPane scrollPane = new JScrollPane(tableJournalEnergy);
        tableJournalEnergy.setModel(modelTableJournalEnergy);
        tableJournalEnergy.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tableJournalEnergy.setFillsViewportHeight(true);
        tableJournalEnergy.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tableJournalEnergy.setTableHeader(new TableHeaderEnergy(tableJournalEnergy.getColumnModel()));
        tableJournalEnergy.setAutoCreateRowSorter(true);
        return scrollPane;
    }

    private JScrollPane getEnergy() {
        JScrollPane scrollPane = new JScrollPane(tableEnergy);
        tableEnergy.setModel(modelTableEnergy);
        tableEnergy.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tableEnergy.setFillsViewportHeight(true);
        tableEnergy.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tableEnergy.setTableHeader(new TableHeaderEnergy(tableEnergy.getColumnModel()));
        tableEnergy.setAutoCreateRowSorter(true);
        return scrollPane;
    }

    private JScrollPane getProteinJournal() {
        JScrollPane scrollPane = new JScrollPane(tableJournalProtein);
        tableJournalProtein.setModel(modelTableJournalProtein);
        tableJournalProtein.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tableJournalProtein.setFillsViewportHeight(true);
        tableJournalProtein.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tableJournalProtein.setTableHeader(new TableHeaderEnergy(tableJournalProtein.getColumnModel()));
        tableJournalProtein.setAutoCreateRowSorter(true);
        return scrollPane;
    }

    private JScrollPane getProtein() {
        JScrollPane scrollPane = new JScrollPane(tableProtein);
        tableProtein.setModel(modelTableProtein);
        tableProtein.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tableProtein.setFillsViewportHeight(true);
        tableProtein.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tableProtein.setTableHeader(new TableHeaderProtein(tableProtein.getColumnModel()));
        tableProtein.setAutoCreateRowSorter(true);
        return scrollPane;
    }

    private JScrollPane getFatsJournal() {
        JScrollPane scrollPane = new JScrollPane(tableJournalFats);
        tableJournalFats.setModel(modelTableJournalFats);
        tableJournalFats.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tableJournalFats.setFillsViewportHeight(true);
        tableJournalFats.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tableJournalFats.setTableHeader(new TableHeaderFats(tableJournalFats.getColumnModel()));
        tableJournalFats.setAutoCreateRowSorter(true);
        return scrollPane;
    }

    private JScrollPane getFats() {
        JScrollPane scrollPane = new JScrollPane(tableFats);
        tableFats.setModel(modelTableFats);
        tableFats.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tableFats.setFillsViewportHeight(true);
        tableFats.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tableFats.setTableHeader(new TableHeaderFats(tableFats.getColumnModel()));
        tableFats.setAutoCreateRowSorter(true);
        return scrollPane;
    }

    private JScrollPane getCarbsJournal() {
        JScrollPane scrollPane = new JScrollPane(tableJournalCarbs);
        tableJournalCarbs.setModel(modelTableJournalCarbs);
        tableJournalCarbs.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tableJournalCarbs.setFillsViewportHeight(true);
        tableJournalCarbs.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tableJournalCarbs.setTableHeader(new TableHeaderCarbs(tableJournalCarbs.getColumnModel()));
        tableJournalCarbs.setAutoCreateRowSorter(true);
        return scrollPane;
    }

    private JScrollPane getCarbs() {
        JScrollPane scrollPane = new JScrollPane(tableCarbs);
        tableCarbs.setModel(modelTableCarbs);
        tableCarbs.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tableCarbs.setFillsViewportHeight(true);
        tableCarbs.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tableCarbs.setTableHeader(new TableHeaderCarbs(tableCarbs.getColumnModel()));
        tableCarbs.setAutoCreateRowSorter(true);
        return scrollPane;
    }

    private JScrollPane getVitaminsJournal() {
        JScrollPane scrollPane = new JScrollPane(tableJournalVitamins);
        tableJournalVitamins.setModel(modelTableJournalVitamins);
        tableJournalVitamins.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tableJournalVitamins.setFillsViewportHeight(true);
        tableJournalVitamins.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tableJournalVitamins.setTableHeader(new TableHeaderVitamins(tableJournalVitamins.getColumnModel()));
        tableJournalVitamins.setAutoCreateRowSorter(true);
        return scrollPane;
    }

    private JScrollPane getVitamins() {
        JScrollPane scrollPane = new JScrollPane(tableVitamins);
        tableVitamins.setModel(modelTableVitamins);
        tableVitamins.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tableVitamins.setFillsViewportHeight(true);
        tableVitamins.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tableVitamins.setTableHeader(new TableHeaderVitamins(tableVitamins.getColumnModel()));
        tableVitamins.setAutoCreateRowSorter(true);
        return scrollPane;
    }

    private JScrollPane getMineralsJournal() {
        JScrollPane scrollPane = new JScrollPane(tableJournalMinerals);
        tableJournalMinerals.setModel(modelTableJournalMinerals);
        tableJournalMinerals.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tableJournalMinerals.setFillsViewportHeight(true);
        tableJournalMinerals.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tableJournalMinerals.setTableHeader(new TableHeaderMinerals(tableJournalMinerals.getColumnModel()));
        tableJournalMinerals.setAutoCreateRowSorter(true);
        return scrollPane;
    }

    private JScrollPane getMinerals() {
        JScrollPane scrollPane = new JScrollPane(tableMinerals);
        tableMinerals.setModel(modelTableMinerals);
        tableMinerals.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tableMinerals.setFillsViewportHeight(true);
        tableMinerals.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tableMinerals.setTableHeader(new TableHeaderMinerals(tableMinerals.getColumnModel()));
        tableMinerals.setAutoCreateRowSorter(true);
        return scrollPane;
    }

    private JScrollPane getElectrolytesJournal() {
        JScrollPane scrollPane = new JScrollPane(tableJournalElectrolytes);
        tableJournalElectrolytes.setModel(modelTableJournalElectrolytes);
        tableJournalElectrolytes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tableJournalElectrolytes.setFillsViewportHeight(true);
        tableJournalElectrolytes.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tableJournalElectrolytes.setTableHeader(new TableHeaderElectrolytes(tableJournalElectrolytes.getColumnModel()));
        tableJournalElectrolytes.setAutoCreateRowSorter(true);
        return scrollPane;
    }

    private JScrollPane getElectrolytes() {
        JScrollPane scrollPane = new JScrollPane(tableElectrolytes);
        tableElectrolytes.setModel(modelTableElectrolytes);
        tableElectrolytes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tableElectrolytes.setFillsViewportHeight(true);
        tableElectrolytes.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tableElectrolytes.setTableHeader(new TableHeaderElectrolytes(tableElectrolytes.getColumnModel()));
        tableElectrolytes.setAutoCreateRowSorter(true);
        return scrollPane;
    }

    private JScrollPane getWaterJournal() {
        JScrollPane scrollPane = new JScrollPane(tableJournalWater);
        tableJournalWater.setModel(modelTableJournalWater);
        tableJournalWater.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tableJournalWater.setFillsViewportHeight(true);
        tableJournalWater.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tableJournalWater.setTableHeader(new TableHeaderWater(tableJournalWater.getColumnModel()));
        tableJournalWater.setAutoCreateRowSorter(true);
        return scrollPane;
    }

    private JScrollPane getWater() {
        JScrollPane scrollPane = new JScrollPane(tableWater);
        tableWater.setModel(modelTableWater);
        tableWater.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tableWater.setFillsViewportHeight(true);
        tableWater.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tableWater.setTableHeader(new TableHeaderWater(tableWater.getColumnModel()));
        tableWater.setAutoCreateRowSorter(true);
        return scrollPane;
    }

    private JScrollPane getCostJournal() {
        JScrollPane scrollPane = new JScrollPane(tableJournalCost);
        tableJournalCost.setModel(modelTableJournalCost);
        tableJournalCost.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tableJournalCost.setFillsViewportHeight(true);
        tableJournalCost.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tableJournalCost.setTableHeader(new TableHeaderCost(tableJournalCost.getColumnModel()));
        tableJournalCost.setAutoCreateRowSorter(true);
        return scrollPane;
    }

    private JScrollPane getCost() {
        JScrollPane scrollPane = new JScrollPane(tableCost);
        tableCost.setModel(modelTableCost);
        tableCost.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tableCost.setFillsViewportHeight(true);
        tableCost.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tableCost.setTableHeader(new TableHeaderCost(tableCost.getColumnModel()));
        tableCost.setAutoCreateRowSorter(true);
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
        buttonNutrientConstraintAdd.addActionListener((ActionEvent e) -> {
            event_buttonNutrientConstraintAdd();
        });
        buttonNutrientConstraintDelete.addActionListener((ActionEvent e) -> {
            event_buttonNutrientConstraintDelete();
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
        buttonFoodNutrientConstraintAdd.addActionListener((ActionEvent e) -> {
            event_buttonFoodNutrientConstraintAdd();
        });
        buttonFoodNutrientConstraintDelete.addActionListener((ActionEvent e) -> {
            event_buttonFoodNutrientConstraintDelete();
        });
        tableFoodNutrientConstraint.setFillsViewportHeight(true);
        return panel;
    }

    private JPanel getNutrientRatioConstraint() {
        JPanel panel = new JPanel();
        FormLayout panelLayout = new FormLayout(
                "660px,min,min,min:grow", //columns
                "min,min,fill:min:grow,min" //rows
        );
        panel.setLayout(panelLayout);
        JScrollPane spTable = new JScrollPane(tableNutrientRatio);
        JPanel buttons = new JPanel();
        textFieldNutrientRatioNutrientA.setMinimumSize(new Dimension(100, 25));
        textFieldNutrientRatioNutrientB.setMinimumSize(new Dimension(100, 25));
        panel.add(comboBoxNutrientRatioNutrientA, cc.xy(1, 1));
        panel.add(comboBoxNutrientRatioRelationship, cc.xy(2, 1));
        panel.add(textFieldNutrientRatioNutrientA, cc.xy(3, 1));
        panel.add(comboBoxNutrientRatioNutrientB, cc.xy(1, 2));
        panel.add(textFieldNutrientRatioNutrientB, cc.xy(2, 2));
        panel.add(spTable, cc.xyw(1, 3, 4));
        buttons.add(buttonNutrientRatioAdd);
        buttons.add(buttonNutrientRatioDelete);
        panel.add(buttons, cc.xyw(1, 4, 4));
        spTable.setBorder(new TitledBorder("Nutrient Ratio Constraints"));
        comboBoxNutrientRatioNutrientA.setMaximumRowCount(10);
        comboBoxNutrientRatioNutrientA.setModel(modelComboBox_0_NutrientAtNutrientRatio);
        comboBoxNutrientRatioNutrientB.setMaximumRowCount(10);
        comboBoxNutrientRatioNutrientB.setModel(modelComboBox_1_NutrientAtNutrientRatio);
        tableNutrientRatio.getTableHeader().setReorderingAllowed(false);
        tableNutrientRatio.setModel(modelTableNutrientRatioConstraints);
        comboBoxNutrientRatioRelationship.setModel(modelComboBox_RelationshipAtNutrientRatio);
        tableNutrientRatio.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        buttonNutrientRatioAdd.setToolTipText("Add Constraint");
        buttonNutrientRatioDelete.setToolTipText("Delete Constraint");
        buttonNutrientRatioAdd.addActionListener((ActionEvent e) -> {
            event_buttonNutrientRatioAdd();
        });
        buttonNutrientRatioDelete.addActionListener((ActionEvent e) -> {
            event_buttonNutrientRatioDelete();
        });
        tableNutrientRatio.setFillsViewportHeight(true);
        return panel;
    }

    private JPanel getFoodNutrientRatioConstraint() {
        JPanel panel = new JPanel();
        FormLayout panelLayout = new FormLayout(
                "min,min,min,min:grow", //columns
                "min,min,min,min,fill:min:grow,min" //rows
        );
        panel.setLayout(panelLayout);
        JScrollPane spTable = new JScrollPane(tableFoodNutrientRatio);
        JPanel buttons = new JPanel();
        textFieldFoodNutrientRatioQuantityA.setMinimumSize(new Dimension(100, 25));
        textFieldFoodNutrientRatioQuantityB.setMinimumSize(new Dimension(100, 25));
        panel.add(comboBoxFoodNutrientRatioFoodA, cc.xyw(1, 1, 4));
        panel.add(comboBoxFoodNutrientRatioNutrientA, cc.xy(1, 2));
        panel.add(comboBoxFoodNutrientRatioRelationship, cc.xy(2, 2));
        panel.add(textFieldFoodNutrientRatioQuantityA, cc.xy(3, 2));
        panel.add(comboBoxFoodNutrientRatioFoodB, cc.xyw(1, 3, 4));
        panel.add(comboBoxFoodNutrientRatioNutrientB, cc.xy(1, 4));
        panel.add(textFieldFoodNutrientRatioQuantityB, cc.xy(2, 4));
        panel.add(spTable, cc.xyw(1, 5, 4));
        buttons.add(buttonFoodNutrientRatioAdd);
        buttons.add(buttonFoodNutrientRatioDelete);
        panel.add(buttons, cc.xyw(1, 6, 4));
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
        comboBoxFoodNutrientRatioRelationship.setModel(modelComboBox_RelationshipAtFoodNutrientRatio);
        buttonFoodNutrientRatioAdd.addActionListener((ActionEvent e) -> {
            event_buttonFoodNutrientRatioAdd();
        });
        buttonFoodNutrientRatioDelete.addActionListener((ActionEvent e) -> {
            event_buttonFoodNutrientRatioDelete();
        });
        tableFoodNutrientRatio.setFillsViewportHeight(true);
        return panel;
    }

    private JPanel getPercentOfNutrientConstraint() {
        JPanel panel = new JPanel();
        FormLayout panelLayout = new FormLayout(
                "min,min,min,min,550px", //columns
                "min,min,fill:min:grow,min" //rows
        );
        panel.setLayout(panelLayout);
        JScrollPane spTable = new JScrollPane(tableNutrientPercentConstraint);
        JPanel buttons = new JPanel();
        textFieldPercentNutrientConstraintQuantity.setMinimumSize(new Dimension(100, 25));
        panel.add(comboBoxPercentNutrientConstraintFood, cc.xyw(1, 1, 5));
        panel.add(comboBoxPercentNutrientConstraintNutrient, cc.xy(1, 2));
        panel.add(comboBoxPercentNutrientRelationship, cc.xy(2, 2));
        panel.add(textFieldPercentNutrientConstraintQuantity, cc.xy(3, 2));
        panel.add(new JLabel("%"), cc.xy(3, 2));
        panel.add(spTable, cc.xyw(1, 3, 5));
        buttons.add(buttonPercentNutrientConstraintAdd);
        buttons.add(buttonPercentNutrientConstraintDelete);
        panel.add(buttons, cc.xyw(1, 4, 5));
        spTable.setBorder(new TitledBorder("Percent of Nutrient Constraints"));
        comboBoxPercentNutrientConstraintNutrient.setMaximumRowCount(10);
        comboBoxPercentNutrientConstraintNutrient.setModel(modelComboBox_NutrientAtNutrientPctContraint);
        comboBoxPercentNutrientConstraintFood.setMaximumRowCount(10);
        comboBoxPercentNutrientConstraintFood.setModel(modelComboBox_FoodAtNutrientPct);
        comboBoxPercentNutrientRelationship.setModel(modelComboBox_RelationshipAtNutrientPercent);
        tableNutrientPercentConstraint.getTableHeader().setReorderingAllowed(false);
        tableNutrientPercentConstraint.setModel(tableModelPercentNutrientConstraints);
        tableNutrientPercentConstraint.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        buttonPercentNutrientConstraintAdd.setToolTipText("Add Constraint");
        buttonPercentNutrientConstraintDelete.setToolTipText("Delete Constraint");
        buttonPercentNutrientConstraintAdd.addActionListener((ActionEvent e) -> {
            event_buttonPercentNutrientConstraintAdd();
        });
        buttonPercentNutrientConstraintDelete.addActionListener((ActionEvent e) -> {
            event_buttonPercentNutrientConstraintDelete();
        });
        tableNutrientPercentConstraint.setFillsViewportHeight(true);
        return panel;
    }

    private void event_buttonPercentNutrientConstraintDelete() {
        if (isMixSelected()) {
            try {
                int selectedRow = tableNutrientPercentConstraint.getSelectedRow();
                String mixid = (String) tableNutrientPercentConstraint.getValueAt(selectedRow, 0);
                String foodid = (String) tableNutrientPercentConstraint.getValueAt(selectedRow, 1);
                String nutrientid = (String) tableNutrientPercentConstraint.getValueAt(selectedRow, 2);
                Integer relationshipid = (Integer) tableNutrientPercentConstraint.getValueAt(selectedRow, 3);
                dbLink.PercentNutrientConstraint_Delete(mixid, foodid, nutrientid, relationshipid);
                tableModelPercentNutrientConstraints.reload(mixid);
                resizeColumns_PercentNutrientConstraintTableColumns();
            } catch (SQLException e) {

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
                        RelationshipDataObject relationshipDataObject = (RelationshipDataObject) comboBoxPercentNutrientRelationship.getSelectedItem();
                        Double b = Double.parseDouble(textFieldPercentNutrientConstraintQuantity.getText());
                        dbLink.NutrientPercentConstraint_Merge(mix.getMixId(), foodDataObject.getFoodId(), nutrientDataObject.getNutr_no(), relationshipDataObject.getRelationshipid(), b);
                        tableModelPercentNutrientConstraints.reload(mix.getMixId());
                        resizeColumns_PercentNutrientConstraintTableColumns();
                    } catch (SQLException e) {

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
        tableNutrientPercentConstraint.getColumnModel().getColumn(3).setMinWidth(0);
        tableNutrientPercentConstraint.getColumnModel().getColumn(3).setMaxWidth(0);
        tableNutrientPercentConstraint.getColumnModel().getColumn(4).setMinWidth(480);
        tableNutrientPercentConstraint.getColumnModel().getColumn(4).setMaxWidth(480);
        tableNutrientPercentConstraint.getColumnModel().getColumn(5).setMinWidth(250);
        tableNutrientPercentConstraint.getColumnModel().getColumn(5).setMaxWidth(250);
        tableNutrientPercentConstraint.getColumnModel().getColumn(6).setMinWidth(21);
        tableNutrientPercentConstraint.getColumnModel().getColumn(6).setMaxWidth(21);
        tableNutrientPercentConstraint.getColumnModel().getColumn(7).setMinWidth(50);
        tableNutrientPercentConstraint.getColumnModel().getColumn(7).setMaxWidth(50);
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

    private JPanel getJournalModel() {
        JPanel panel = new JPanel();
        //create layouts
        FormLayout layout = new FormLayout(
                "min:grow", //columns
                "fill:pref:grow" //rows
        );
        //specify layouts
        panel.setLayout(layout);
        //place components
        textAreaJournalModel.setLineWrap(false);
        JScrollPane scrollPane = new JScrollPane(textAreaJournalModel);
        scrollPane.setPreferredSize(new Dimension(0, 0));
        panel.add(scrollPane, cc.xy(1, 1));
        return panel;
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
        textAreaModel.setLineWrap(false);
        JScrollPane scrollPane = new JScrollPane(textAreaModel);
        scrollPane.setPreferredSize(new Dimension(0, 0));
        panel.add(scrollPane, cc.xy(1, 1));
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
        return panel;
    }

    private JPanel getJournalNote() {
        JPanel panel = new JPanel();
        //create layouts
        FormLayout layout = new FormLayout(
                "min:grow", //columns
                "fill:pref:grow" //rows
        );
        //specify layouts
        panel.setLayout(layout);
        //place components
        textAreaJournalNote.setLineWrap(false);
        JScrollPane scrollPane = new JScrollPane(textAreaJournalNote);
        scrollPane.setPreferredSize(new Dimension(0, 0));
        panel.add(scrollPane, cc.xy(1, 1));
        return panel;
    }

    private void event_listMixes(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()) {
            if (isMixSelected()) {
                MixDataObject mixDataObject = (MixDataObject) listMixes.getSelectedValue();
                String mixId = mixDataObject.getMixId();
                modelListSelectedFood.reload(mixId);
                reloadTableModels();
                reloadFoodComboBoxes(mixId);
                reloadTableModelConstraints(mixId);
                textAreaModel.setText(getLinearProgrammingModel(mixId));
                textAreaNote.setText(getNote(mixId));
            }
        }
    }

    private String getLinearProgrammingModel(String mixId) {
        String model = "";
        try {
            LinkedList all = (LinkedList) dbLink.Mix_Select_Other(mixId);
            Iterator it = all.iterator();
            HashMap row = (HashMap) it.next();
            model = (String) row.get("MODEL");
        } catch (SQLException e) {

        }
        return model;
    }

    private String getNote(String mixId) {
        String note = "";
        try {
            LinkedList all = (LinkedList) dbLink.Mix_Select_Other(mixId);
            Iterator it = all.iterator();
            HashMap row = (HashMap) it.next();
            note = (String) row.get("NOTE");
        } catch (SQLException e) {

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
            String mixId1 = mix1.getMixId();
            MixDataObject mix2 = (MixDataObject) listCompareB.getSelectedValue();
            String mixId2 = mix2.getMixId();
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
        buttonCategoriesAdd.addActionListener((ActionEvent e) -> {
            event_buttonCategoriesAdd();
        });
        buttonCategoriesRename.addActionListener((ActionEvent e) -> {
            event_buttonCategoriesRename();
        });
        buttonCategoriesDelete.addActionListener((ActionEvent e) -> {
            event_buttonCategoriesDelete();
        });
        listCategories.addListSelectionListener((ListSelectionEvent e) -> {
            event_listCategories(e);
        });
        buttonAddFoodToCategory.addActionListener((ActionEvent e) -> {
            event_buttonAddFoodToCategory();
        });
        buttonDeleteFoodFromCategory.addActionListener((ActionEvent e) -> {
            event_buttonDeleteFoodFromCategory();
        });
        textFieldSearch.addActionListener((ActionEvent e) -> {
            event_textFieldSearch(e);
        });
        return panel;
    }

    private void event_textFieldSearch(ActionEvent e) {
        modelListFood.reload(((JTextComponent) e.getSource()).getText());
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
                    String mixId = mix.getMixId();
                    dbLink.MixFood_Insert(mixId, food.getFoodId());
                    modelListSelectedFood.reload(mixId);
                    reloadFoodComboBoxes(mixId);
                } catch (SQLException e) {

                }
            }
        } else {
            Message.showMessage("Select mix");
        }
    }

    private void event_buttonDeleteMixFood() {
        if (isMixSelected()) {
            if (isSelectedFood()) {
                try {
                    MixDataObject mix = (MixDataObject) listMixes.getSelectedValue();
                    FoodDataObject foodDataObject = (FoodDataObject) listSelectedFood.getSelectedValue();
                    String mixId = mix.getMixId();
                    dbLink.MixFood_Delete(mixId, foodDataObject.getFoodId());
                    modelListSelectedFood.reload(mixId);
                    reloadFoodComboBoxes(mixId);
                    reloadTableModelConstraints(mixId);
                    reloadTableModels();
                } catch (SQLException e) {

                }
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
                String mixId = mix.getMixId();
                textAreaModel.setText("");
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
                    Integer relationshipid = (Integer) row.get("RELATIONSHIPID");;
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
                    sbResults.append("Total Calories are: ").append(formatter.format(cost));
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
                    dbLink.fill_mixresult(mixId);
                    dbLink.delete_mixresultdn(mixId);
                    dbLink.fill_mixresultdn(mixId);
                    reloadTableModels();
                    reloadTableModelsJournal();
                    reloadMixComparison();
                    reloadRdaCheck();
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
                textAreaModel.setText(sbAll.toString());
            } catch (SQLException e) {

            }
        }
    }

    private String getFoodLegend(String mixId) throws SQLException {
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
        if (sb.length() > 0) {
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
                String mixid = (String) tableNutrientConstraint.getValueAt(selectedRow, 0);
                String nutrientid = (String) tableNutrientConstraint.getValueAt(selectedRow, 1);
                Integer relationshipid = (Integer) tableNutrientConstraint.getValueAt(selectedRow, 2);
                dbLink.NutrientConstraint_Delete(mixid, nutrientid, relationshipid);
                modelTableNutrientConstraints.reload(mixid);
                resizeColumns_NutrientConstraintTableColumns();
            } catch (SQLException e) {

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
                String mixid = (String) tableFoodNutrientConstraint.getValueAt(selectedRow, 0);
                String foodid = (String) tableFoodNutrientConstraint.getValueAt(selectedRow, 1);
                String nutrientid = (String) tableFoodNutrientConstraint.getValueAt(selectedRow, 2);
                Integer relationshipid = (Integer) tableFoodNutrientConstraint.getValueAt(selectedRow, 3);
                dbLink.FoodNutrientConstraint_Delete(mixid, foodid, nutrientid, relationshipid);
                modelTableFoodNutrientConstraints.reload(mixid);
                resizeColumns_FoodNutrientConstraintTableColumns();
            } catch (SQLException e) {

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
                        RelationshipDataObject relationshipDataObject = (RelationshipDataObject) comboBoxNutrientRatioRelationship.getSelectedItem();
                        Double a = Double.parseDouble(textFieldNutrientRatioNutrientA.getText());
                        Double b = Double.parseDouble(textFieldNutrientRatioNutrientB.getText());
                        dbLink.NutrientRatio_Merge(mix.getMixId(), nutrientDataObjectA.getNutr_no(), nutrientDataObjectB.getNutr_no(), relationshipDataObject.getRelationshipid(), a, b);
                        modelTableNutrientRatioConstraints.reload(mix.getMixId());
                        resizeColumns_NutrientRatioConstraintTableColumns();
                    } catch (SQLException e) {

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
        tableNutrientRatio.getColumnModel().getColumn(8).setMinWidth(21);
        tableNutrientRatio.getColumnModel().getColumn(8).setMaxWidth(21);
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
        tableFoodList01.getColumnModel().getColumn(0).setMinWidth(0);
        tableFoodList01.getColumnModel().getColumn(0).setMaxWidth(0);
        tableFoodList01.getColumnModel().getColumn(1).setMinWidth(350);
    }

    private void event_buttonNutrientRatioDelete() {
        if (isMixSelected()) {
            try {
                int selectedRow = tableNutrientRatio.getSelectedRow();
                String mixid = (String) tableNutrientRatio.getValueAt(selectedRow, 0);
                String nutrientidA = (String) tableNutrientRatio.getValueAt(selectedRow, 1);
                String nutrientidB = (String) tableNutrientRatio.getValueAt(selectedRow, 2);
                Integer relationshipid = (Integer) tableNutrientRatio.getValueAt(selectedRow, 3);
                dbLink.NutrientRatio_Delete(mixid, nutrientidA, nutrientidB, relationshipid);
                modelTableNutrientRatioConstraints.reload(mixid);
                resizeColumns_NutrientRatioConstraintTableColumns();
            } catch (SQLException e) {

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
                        RelationshipDataObject relationshipDataObject = (RelationshipDataObject) comboBoxFoodNutrientRatioRelationship.getSelectedItem();
                        dbLink.FoodNutrientRatio_Merge(mix.getMixId(), foodDataObjectA.getFoodId(), nutrientDataObjectA.getNutr_no(), foodDataObjectB.getFoodId(), nutrientDataObjectB.getNutr_no(), relationshipDataObject.getRelationshipid(), a, b);
                        modelTableFoodNutrientRatioConstraints.reload(mix.getMixId());
                        resizeColumns_FoodNutrientRatioConstraintTableColumns();
                    } catch (SQLException e) {

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
        tableFoodNutrientRatio.getColumnModel().getColumn(12).setMaxWidth(21);
        tableFoodNutrientRatio.getColumnModel().getColumn(12).setMaxWidth(21);
    }

    private void event_buttonFoodNutrientRatioDelete() {
        if (isMixSelected()) {
            try {
                int selectedRow = tableFoodNutrientRatio.getSelectedRow();
                String mixid = (String) tableFoodNutrientRatio.getValueAt(selectedRow, 0);
                String foodidA = (String) tableFoodNutrientRatio.getValueAt(selectedRow, 1);
                String nutrientidA = (String) tableFoodNutrientRatio.getValueAt(selectedRow, 2);
                String foodidB = (String) tableFoodNutrientRatio.getValueAt(selectedRow, 3);
                String nutrientidB = (String) tableFoodNutrientRatio.getValueAt(selectedRow, 4);
                Integer relationshipid = (Integer) tableFoodNutrientRatio.getValueAt(selectedRow, 5);
                dbLink.FoodNutrientRatio_Delete(mixid, foodidA, nutrientidA, foodidB, nutrientidB, relationshipid);
                modelTableFoodNutrientRatioConstraints.reload(mixid);
                resizeColumns_FoodNutrientRatioConstraintTableColumns();
            } catch (SQLException e) {

            }
        }
    }

    private boolean isSelectedFood() {
        return !listSelectedFood.isSelectionEmpty();
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

            }
        }
    }

    private void openUrl(String url) {
        try {
            Desktop.getDesktop().browse(new URL(url).toURI());
        } catch (IOException | URISyntaxException e) {

        }
    }

    private void event_menuItemGlycemicLoad() {
        JTextField textFieldGI = new JTextField();
        JTextField textFieldCarbs = new JTextField();
        JComponent[] inputs = new JComponent[]{
            new JLabel("What is glycemic index of food item?"),
            textFieldGI
        };
        int optionValue = Message.showOptionDialog(inputs, "Glycemic Load");
        if (optionValue == 0) {
            String strGI = textFieldGI.getText();
            inputs = new JComponent[]{
                new JLabel("How many digestible carbs (g) in food item?"),
                textFieldCarbs
            };
            Message.showOptionDialog(inputs, "Glycemic Load");
            String strCarbs = textFieldCarbs.getText();
            if (strGI != null && strGI.length() > 0) {
                if (strCarbs != null && strCarbs.length() > 0) {
                    StringBuilder sb = new StringBuilder();
                    NumberCheck checkNumber = new NumberCheck();
                    checkNumber.addToUncheckedList(strGI);
                    checkNumber.addToUncheckedList(strCarbs);
                    if (checkNumber.pass()) {
                        Double gi = Double.valueOf(strGI);
                        Double carbs = Double.valueOf(strCarbs);
                        double gl = new GlycemicLoad(gi, carbs).getGlycemicLoad();
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
    }

    private void event_menu_item_n3_fatty_acid_recommendations() {
        JTextField energy = new JTextField();
        JComponent[] inputs = new JComponent[]{
            new JLabel("What is your optimal calorie intake?"),
            energy
        };
        int optionValue = Message.showOptionDialog(inputs, "Alpha-Linolenic Acid (ALA)");
        if (optionValue == 0) {
            String s = energy.getText();
            if (s != null && s.length() > 0) {
                StringBuilder sb = new StringBuilder();
                NumberCheck checkNumber = new NumberCheck();
                checkNumber.addToUncheckedList(s);
                if (checkNumber.pass()) {
                    Double energy_in_kcal = Double.valueOf(s);
                    final Alpha_linolenic_acid_required n3_fatty_acid_recommendation = new Alpha_linolenic_acid_required(energy_in_kcal);
                    BigDecimal ala_low = n3_fatty_acid_recommendation.get_low_in_grams();
                    BigDecimal ala_high = n3_fatty_acid_recommendation.get_high_in_grams();
                    sb.append("Alpha-linolenic acid (ALA) required is between ");
                    sb.append(ala_low.setScale(1, RoundingMode.HALF_UP));
                    sb.append(" - ");
                    sb.append(ala_high.setScale(1, RoundingMode.HALF_UP));
                    sb.append(" grams");
                    JTextArea textArea = new JTextArea(1, 40);
                    textArea.setText(sb.toString());
                    textArea.setEditable(false);
                    inputs = new JComponent[]{
                        textArea
                    };
                    Message.showOptionDialog(inputs, "Alpha-Linolenic Acid (ALA)");
                } else {
                    Message.showMessage("Numbers only");
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
        tp.setPreferredSize(new Dimension(GoldenRatio.getLongSide(500), 500));
        tp.add(p1);
        tp.add(p2);
        tp.setTitleAt(0, "Message");
        tp.setTitleAt(1, "Details");
        p1.setLayout(layout);
        p2.setLayout(layout);
        messageArea.setLineWrap(false);
        p1.add(new JScrollPane(messageArea), cc.xy(1, 1));
        constraintsArea.setLineWrap(false);
        JScrollPane spConstraintsArea = new JScrollPane(constraintsArea);
        spConstraintsArea.setPreferredSize(new Dimension(700, 433));
        p2.add(spConstraintsArea, cc.xy(1, 1));
        return tp;
    }

    private String getNutrientRatioText() {
        StringBuilder sb = new StringBuilder();
        if (tableNutrientRatio.getRowCount() > 0) {
            sb.append("Nutrient Ratio");
            sb.append("\n");
            sb.append("-----------------------------");
            sb.append("\n");
            for (int i = 0; i < tableNutrientRatio.getRowCount(); i++) {
                String nutrientA = (String) tableNutrientRatio.getValueAt(i, 4);
                String nutrientB = (String) tableNutrientRatio.getValueAt(i, 5);
                String rel = (String) tableNutrientRatio.getValueAt(i, 6);
                Double a = (Double) tableNutrientRatio.getValueAt(i, 7);
                Double b = (Double) tableNutrientRatio.getValueAt(i, 8);
                sb.append(nutrientA);
                sb.append(" and ");
                sb.append(nutrientB);
                sb.append("\n");
                sb.append("should be found in the mix in a ratio of '");
                sb.append(rel);
                sb.append(" ");
                sb.append(a);
                sb.append("':");
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
        if (tableFoodNutrientRatio.getRowCount() > 0) {
            sb.append("Food Ratio");
            sb.append("\n");
            sb.append("-----------------------------");
            sb.append("\n");
            for (int i = 0; i < tableFoodNutrientRatio.getRowCount(); i++) {
                String foodA = (String) tableFoodNutrientRatio.getValueAt(i, 6);
                String nutrientA = (String) tableFoodNutrientRatio.getValueAt(i, 7);
                String foodB = (String) tableFoodNutrientRatio.getValueAt(i, 8);
                String nutrientB = (String) tableFoodNutrientRatio.getValueAt(i, 9);
                String rel = (String) tableFoodNutrientRatio.getValueAt(i, 10);
                Double a = (Double) tableFoodNutrientRatio.getValueAt(i, 11);
                Double b = (Double) tableFoodNutrientRatio.getValueAt(i, 12);
                sb.append(nutrientA);
                sb.append(" contributed by ");
                sb.append(foodA);
                sb.append(" and ");
                sb.append("\n");
                sb.append(nutrientB);
                sb.append(" contributed by ");
                sb.append(foodB);
                sb.append("\n");
                sb.append("should be found in the mix in a ratio of '");
                sb.append(rel);
                sb.append(" ");
                sb.append(a);
                sb.append("':");
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
        if (tableNutrientPercentConstraint.getRowCount() > 0) {
            sb.append("Nutrient Percent Constraint");
            sb.append("\n");
            sb.append("--------------------------");
            sb.append("\n");
            for (int i = 0; i < tableNutrientPercentConstraint.getRowCount(); i++) {
                String food = (String) tableNutrientPercentConstraint.getValueAt(i, 4);
                String nutrient = (String) tableNutrientPercentConstraint.getValueAt(i, 5);
                String relationship = (String) tableNutrientPercentConstraint.getValueAt(i, 6);
                Double constraint = (Double) tableNutrientPercentConstraint.getValueAt(i, 7);
                sb.append(nutrient);
                sb.append(" contributed to the mix by ");
                sb.append(food);
                sb.append("\n");
                sb.append("should be ");
                sb.append(relationship);
                sb.append(" ");
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
        if (tableFoodNutrientConstraint.getRowCount() > 0) {
            sb.append("Food Constraint");
            sb.append("\n");
            sb.append("--------------------------");
            sb.append("\n");
            for (int i = 0; i < tableFoodNutrientConstraint.getRowCount(); i++) {
                String food = (String) tableFoodNutrientConstraint.getValueAt(i, 4);
                String nutrient = (String) tableFoodNutrientConstraint.getValueAt(i, 5);
                String equality = (String) tableFoodNutrientConstraint.getValueAt(i, 6);
                Double value = (Double) tableFoodNutrientConstraint.getValueAt(i, 7);
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
        if (tableNutrientConstraint.getRowCount() > 0) {
            sb.append("Nutrient Constraint");
            sb.append("\n");
            sb.append("--------------------------");
            sb.append("\n");
            for (int i = 0; i < tableNutrientConstraint.getRowCount(); i++) {
                String nutrient = (String) tableNutrientConstraint.getValueAt(i, 3);
                String equality = (String) tableNutrientConstraint.getValueAt(i, 4);
                Double value = (Double) tableNutrientConstraint.getValueAt(i, 5);
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

    private String getTranslation(String equality) {
        String translatedText = "";

        switch (equality) {
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

    private void event_send_message() {
        if (isMixSelected()) {
            try {
                MixDataObject mix = (MixDataObject) listMixes.getSelectedValue();
                Xml_send send = new Xml_send(dbLink, mix.getMixId());
                show_message_sent();
            } catch (Exception e) {
            }
        }
    }

    private void show_message_sent() {
        JComponent[] inputs = new JComponent[]{
            new JLabel("Data exchange document was created.")
        };
        Message.showOptionDialog(inputs, "Data Exchange");
    }

    private void event_receive_message() {
        fileChooser.setAcceptAllFileFilterUsed(false);
        fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Xml Document", "xml"));
        int returnVal = fileChooser.showOpenDialog(frameSnack);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            String path = file.getAbsolutePath();
            fileChooser.setCurrentDirectory(new File(path));
            HashSet set01 = new HashSet();
            HashSet set02 = new HashSet();
            final int old_size = modelList_Solve.size();
            for (int i = 0; i < old_size; i++) {
                MixDataObject o = (MixDataObject) modelList_Solve.get(i);
                set01.add(o.getMixId());
            }
            Xml_receive receive = new Xml_receive();
            receive.import_snack_data(path);
            reloadMixes();
            reloadFoodItems();
            modelListCategory.reload();
            for (int i = 0; i < modelList_Solve.size(); i++) {
                MixDataObject o = (MixDataObject) modelList_Solve.get(i);
                set02.add(o.getMixId());
            }
            if (old_size > 0) {
                if (set02.removeAll(set01)) {
                    int index = modelList_Solve.find_by_mixid((String) set02.toArray()[0]);
                    listMixes.setSelectedIndex(index);
                }
            } else {
                listMixes.setSelectedIndex(0);
            }
        }
    }

    private void event_menui_show_mix_stats() {
        if (isMixSelected()) {
            try {
                MixDataObject mix = (MixDataObject) listMixes.getSelectedValue();
                JTextArea textArea = new JTextArea(1, 24);
                textArea.setText(stringModelMixPct.reload(mix.getMixId()));
                textArea.setEditable(false);
                JComponent[] inputs = new JComponent[]{
                    textArea
                };
                Message.showOptionDialog(inputs, "Macronutrient Percentages");
            } catch (Exception e) {
            }
        }

    }
}
