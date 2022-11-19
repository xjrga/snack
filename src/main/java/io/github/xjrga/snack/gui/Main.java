package io.github.xjrga.snack.gui;

import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;
import io.github.xjrga.snack.data.DbLink;
import io.github.xjrga.snack.data.Nutrient;
import io.github.xjrga.snack.dataobject.FoodCategoryDataObject;
import io.github.xjrga.snack.dataobject.FoodDataObject;
import io.github.xjrga.snack.dataobject.MixDataObject;
import io.github.xjrga.snack.dataobject.NutrientDataObject;
import io.github.xjrga.snack.dataobject.O_Meal;
import io.github.xjrga.snack.dataobject.RdaLifeStageDataObject;
import io.github.xjrga.snack.dataobject.RelationshipDataObject;
import io.github.xjrga.snack.lp.LpModel;
import io.github.xjrga.snack.model.ComboBoxAllocationFood;
import io.github.xjrga.snack.model.ComboBoxAllocationMeal;
import io.github.xjrga.snack.model.ComboBoxModelLifeStage;
import io.github.xjrga.snack.model.ComboBoxModelNutrientsAll;
import io.github.xjrga.snack.model.ComboBoxModelNutrientsConvert;
import io.github.xjrga.snack.model.Food_legend_generator;
import io.github.xjrga.snack.model.Food_loader;
import io.github.xjrga.snack.model.ListModelAllocationMeal;
import io.github.xjrga.snack.model.ListModelCategory;
import io.github.xjrga.snack.model.ListModelFood;
import io.github.xjrga.snack.model.ListModelFood2;
import io.github.xjrga.snack.model.ListModelMix;
import io.github.xjrga.snack.model.ListModelMix0;
import io.github.xjrga.snack.model.ListModelMix1;
import io.github.xjrga.snack.model.ListModelSelectedFood;
import io.github.xjrga.snack.model.Nutrient_loader;
import io.github.xjrga.snack.model.Relationship_loader;
import io.github.xjrga.snack.model.Result_loader;
import io.github.xjrga.snack.model.StringModelMixPct;
import io.github.xjrga.snack.model.TableModelAllocation;
import io.github.xjrga.snack.model.TableModelCarbs;
import io.github.xjrga.snack.model.TableModelCheckCoefficients;
import io.github.xjrga.snack.model.TableModelCost;
import io.github.xjrga.snack.model.TableModelDataInput;
import io.github.xjrga.snack.model.TableModelElectrolytes;
import io.github.xjrga.snack.model.TableModelEnergy;
import io.github.xjrga.snack.model.TableModelFat;
import io.github.xjrga.snack.model.TableModelFoodComparison;
import io.github.xjrga.snack.model.TableModelFoodList;
import io.github.xjrga.snack.model.TableModelFoodNutrientConstraints;
import io.github.xjrga.snack.model.TableModelFoodNutrientRatioConstraints;
import io.github.xjrga.snack.model.TableModelGlycemic;
import io.github.xjrga.snack.model.TableModelMeals;
import io.github.xjrga.snack.model.TableModelMinerals;
import io.github.xjrga.snack.model.TableModelMixComparison;
import io.github.xjrga.snack.model.TableModelNutrientConstraints;
import io.github.xjrga.snack.model.TableModelNutrientLookup;
import io.github.xjrga.snack.model.TableModelNutrientRatioConstraints;
import io.github.xjrga.snack.model.TableModelPercentNutrientConstraints;
import io.github.xjrga.snack.model.TableModelProtein;
import io.github.xjrga.snack.model.TableModelRdaCheck;
import io.github.xjrga.snack.model.TableModelVitamins;
import io.github.xjrga.snack.model.TableModelWater;
import io.github.xjrga.snack.model.TreeModelFood;
import io.github.xjrga.snack.other.Alpha_linolenic_acid_required;
import io.github.xjrga.snack.other.CunninghamFormula;
import io.github.xjrga.snack.other.DigestibleCarbohydrate;
import io.github.xjrga.snack.other.DoubleTableCellEditor;
import io.github.xjrga.snack.other.ExportFoodComparison;
import io.github.xjrga.snack.other.ExportFoodList;
import io.github.xjrga.snack.other.ExportFoodMixes;
import io.github.xjrga.snack.other.ExportMealPlan;
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
import io.github.xjrga.snack.other.StringCheck;
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
    private final BufferedImage logo = ImageUtilities.readImage( "resources/images/logo.png" );
    private final DbLink dbLink = new DbLink();
    private final CellConstraints cc = new CellConstraints();
    private final ComboBoxModelLifeStage cbmdl_journal_lifestage = new ComboBoxModelLifeStage( dbLink );
    private final ComboBoxModelLifeStage cbmdl_results_lifestage = new ComboBoxModelLifeStage( dbLink );
    private final ComboBoxModelNutrientsAll modelComboBox_NutrientLookupListNutrient = new ComboBoxModelNutrientsAll( dbLink );
    private final ComboBoxModelNutrientsConvert modelComboBox_NutrientLookupListConvert = new ComboBoxModelNutrientsConvert( dbLink );
    private final DefaultComboBoxModel modelComboBox_0_FoodAtFoodNutrientRatio = new DefaultComboBoxModel();
    private final DefaultComboBoxModel modelComboBox_0_NutrientAtFoodNutrientRatio = new DefaultComboBoxModel();
    private final DefaultComboBoxModel modelComboBox_0_NutrientAtNutrientRatio = new DefaultComboBoxModel();
    private final DefaultComboBoxModel modelComboBox_1_FoodAtFoodNutrientRatio = new DefaultComboBoxModel();
    private final DefaultComboBoxModel modelComboBox_1_NutrientAtFoodNutrientRatio = new DefaultComboBoxModel();
    private final DefaultComboBoxModel modelComboBox_1_NutrientAtNutrientRatio = new DefaultComboBoxModel();
    private final ComboBoxAllocationFood modelComboBox_AllocationFood = new ComboBoxAllocationFood( dbLink );
    private final DefaultComboBoxModel modelComboBox_FoodAtNutrient = new DefaultComboBoxModel();
    private final DefaultComboBoxModel modelComboBox_FoodAtNutrientPct = new DefaultComboBoxModel();
    private final DefaultComboBoxModel modelComboBox_NutrientAtNutrientConstraint = new DefaultComboBoxModel();
    private final ComboBoxAllocationMeal modelComboBox_AllocationMeal = new ComboBoxAllocationMeal( dbLink );
    private final ListModelAllocationMeal modelList_AllocationMeal = new ListModelAllocationMeal( dbLink );
    private final DefaultComboBoxModel modelComboBox_NutrientAtNutrientPctContraint = new DefaultComboBoxModel();
    private final DefaultComboBoxModel modelComboBox_RelationshipAtFoodNutrient = new DefaultComboBoxModel();
    private final DefaultComboBoxModel modelComboBox_RelationshipAtFoodNutrientRatio = new DefaultComboBoxModel();
    private final DefaultComboBoxModel modelComboBox_RelationshipAtNutrient = new DefaultComboBoxModel();
    private final DefaultComboBoxModel modelComboBox_RelationshipAtNutrientPercent = new DefaultComboBoxModel();
    private final DefaultComboBoxModel modelComboBox_RelationshipAtNutrientRatio = new DefaultComboBoxModel();
    private final DefaultListModel modelListHighScore = new DefaultListModel();
    private final Food_legend_generator legend_generator = new Food_legend_generator( dbLink );
    private final Food_loader food_loader = new Food_loader( dbLink );
    private final JButton buttonCategoriesAdd = new JButton( "+" );
    private final JButton buttonCategoriesDelete = new JButton( "-" );
    private final JButton buttonCategoriesRename = new JButton( "u" );
    private final JButton buttonFoodListAdd = new JButton( "+" );
    private final JButton buttonFoodListDelete = new JButton( "-" );
    private final JButton buttonFoodListDuplicate = new JButton( "d" );
    private final JButton buttonFoodListUpdate = new JButton( "u" );
    private final JButton buttonAllocationAdd = new JButton( "+" );
    private final JButton buttonMealAdd = new JButton( "+" );
    private final JButton buttonFoodNutrientConstraintAdd = new JButton( "+" );
    private final JButton buttonMealDelete = new JButton( "-" );
    private final JButton buttonMealUpdate = new JButton( "u" );
    private final JButton buttonAllocationDelete = new JButton( "-" );
    private final JButton buttonAllocationUpdatePct = new JButton( "%" );
    private final JButton buttonAllocationUpdateWeight = new JButton( "w" );
    private final JButton buttonFoodNutrientConstraintDelete = new JButton( "-" );
    private final JButton buttonFoodNutrientRatioAdd = new JButton( "+" );
    private final JButton buttonFoodNutrientRatioDelete = new JButton( "-" );
    private final JButton buttonNutrientConstraintAdd = new JButton( "+" );
    private final JButton buttonNutrientConstraintDelete = new JButton( "-" );
    private final JButton buttonNutrientRatioAdd = new JButton( "+" );
    private final JButton buttonNutrientRatioDelete = new JButton( "-" );
    private final JButton buttonPercentNutrientConstraintAdd = new JButton( "+" );
    private final JButton buttonPercentNutrientConstraintDelete = new JButton( "-" );
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
    private final JCheckBox checkBoxEnergyAlcohol = new JCheckBox();
    private final JCheckBox checkBoxEnergyCarbohydrate = new JCheckBox();
    private final JCheckBox checkBoxEnergyDigestible = new JCheckBox();
    private final JCheckBox checkBoxEnergyFat = new JCheckBox();
    private final JCheckBox checkBoxEnergy = new JCheckBox();
    private final JCheckBox checkBoxEnergyProtein = new JCheckBox();
    private final JCheckBox checkBoxEPA = new JCheckBox();
    private final JCheckBox checkBoxFat = new JCheckBox();
    private final JCheckBox checkBoxFiber = new JCheckBox();
    private final JCheckBox checkBoxFolate = new JCheckBox();
    private final JCheckBox checkBoxGlycemicLoad = new JCheckBox();
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
    private final JCheckBox checkBoxVitaminB12 = new JCheckBox();
    private final JCheckBox checkBoxVitaminB6 = new JCheckBox();
    private final JCheckBox checkBoxVitaminC = new JCheckBox();
    private final JCheckBox checkBoxVitaminD = new JCheckBox();
    private final JCheckBox checkBoxVitaminE = new JCheckBox();
    private final JCheckBox checkBoxVitaminK = new JCheckBox();
    private final JCheckBox checkBoxWater = new JCheckBox();
    private final JCheckBox checkBoxWeight = new JCheckBox();
    private final JCheckBox checkBoxZinc = new JCheckBox();
    private final JCheckBox checkBoxEnergyFatCarbohydrate = new JCheckBox();
    private final JComboBox comboBoxAllocationFood = new JComboBox();
    private final JComboBox comboBoxAllocationMeal = new JComboBox();
    private final JList listAllocationMeal = new JList();
    private final JComboBox comboBoxFoodNutrientConstraintFood = new JComboBox();
    private final JComboBox comboBoxFoodNutrientConstraintNutrient = new JComboBox();
    private final JComboBox comboBoxFoodNutrientConstraintRelationship = new JComboBox();
    private final JComboBox comboBoxFoodNutrientRatioFoodA = new JComboBox();
    private final JComboBox comboBoxFoodNutrientRatioFoodB = new JComboBox();
    private final JComboBox comboBoxFoodNutrientRatioNutrientA = new JComboBox();
    private final JComboBox comboBoxFoodNutrientRatioNutrientB = new JComboBox();
    private final JComboBox comboBoxFoodNutrientRatioRelationship = new JComboBox();
    private final JComboBox cb_journal_lifestage = new JComboBox();
    private final JComboBox cb_results_lifestage = new JComboBox();
    private final JComboBox comboBoxNutrientConstraintNutrient = new JComboBox();
    private final JComboBox comboBoxNutrientConstraintRelationship = new JComboBox();
    private final JComboBox comboBoxNutrientLookupListNutrient = new JComboBox();
    private final JComboBox comboBoxNutrientRatioNutrientA = new JComboBox();
    private final JComboBox comboBoxNutrientRatioNutrientB = new JComboBox();
    private final JComboBox comboBoxNutrientRatioRelationship = new JComboBox();
    private final JComboBox comboBoxPercentNutrientConstraintFood = new JComboBox();
    private final JComboBox comboBoxPercentNutrientConstraintNutrient = new JComboBox();
    private final JComboBox comboBoxPercentNutrientRelationship = new JComboBox();
    private final JFileChooser fileChooser;
    private final JFrame frm_snack = new JFrame();
    private final JList listAllFoodItems = new JList();
    private final JList listCategories = new JList();
    private final JList list_food_compare_a = new JList();
    private final JList list_food_compare_b = new JList();
    private final JList listFoodInCategory = new JList();
    private final JList listHighScore = new JList();
    private final JList list_mix_compare_a = new JList();
    private final JList list_mix_compare_b = new JList();
    private final JList list_journal_mix = new JList();
    private final JList lst_mix = new JList();
    private final JList listSelectedFood = new JList();
    private final JMenuItem menui_export_message = new JMenuItem();
    private final JMenuItem menui_import_message = new JMenuItem();
    private final JMenuItem menui_show_mix_stats = new JMenuItem();
    private final JMenuItem menuItemAbout = new JMenuItem();
    private final JMenuItem menu_item_alpha_linolenic_acid_required = new JMenuItem();
    private final JMenuItem menuItemBmr = new JMenuItem();
    private final JMenuItem menuItemConstraintsShownInList = new JMenuItem();
    private final JMenuItem menuItemCredits = new JMenuItem();
    private final JMenuItem menuItemDigestibleCarbs = new JMenuItem();
    private final JMenuItem menuItemExit = new JMenuItem();
    private final JMenuItem menuItemExportFoodComparison = new JMenuItem();
    private final JMenuItem menuItemExportFoodList = new JMenuItem();
    private final JMenuItem menuItemExportMixComparison = new JMenuItem();
    private final JMenuItem menuItemExportMixJournal = new JMenuItem();
    private final JMenuItem menuItemExportMixJournalRda = new JMenuItem();
    private final JMenuItem menuItemExportNutrientLookup = new JMenuItem();
    private final JMenuItem menuItemExportMealPlan = new JMenuItem();
    private final JMenuItem menuItemGlycemicIndexRange = new JMenuItem();
    private final JMenuItem menuItemGlycemicLoad = new JMenuItem();
    private final JMenuItem menuItemGuide = new JMenuItem();
    private final JMenuItem menuItemKetosis = new JMenuItem();
    private final JMenuItem menuItemMicronutrientConversion = new JMenuItem();
    private final JMenuItem menuItemNitrogenBalance = new JMenuItem();
    private final JMenu menuData = new JMenu();
    private final JMenu menu_exchange = new JMenu();
    private final JMenu menuHelp = new JMenu();
    private final JMenu menuProgram = new JMenu();
    private final JMenu menuSettings = new JMenu();
    private final JMenu menu_spreadsheet = new JMenu();
    private final JMenu menuTools = new JMenu();
    private int precision = 0;
    private JScrollPane tableNutrientInputScrollPane;
    private final JTable tableCarbs = new JTable();
    private final JTable tableCheckCoefficients = new JTable();
    private final JTable tableCost = new JTable();
    private final JTable tableElectrolytes = new JTable();
    private final JTable tableEnergy = new JTable();
    private final JTable tableFats = new JTable();
    private JTable table_food_comparison;
    private final JTable tableFoodList01 = new JTable();
    private final JTable table_allocation = new JTable();
    private final JTable table_meals = new JTable();
    private final JTable tableFoodNutrientConstraint = new JTable();
    private final JTable tableFoodNutrientRatio = new JTable();
    private final JTable tableGlycemic = new JTable();
    private final JTable tableJournalCarbs = new JTable();
    private final JTable tableJournalCost = new JTable();
    private final JTable tableJournalElectrolytes = new JTable();
    private final JTable tableJournalEnergy = new JTable();
    private final JTable tableJournalFats = new JTable();
    private final JTable tableJournalGlycemic = new JTable();
    private final JTable tableJournalMinerals = new JTable();
    private final JTable tableJournalProtein = new JTable();
    private final JTable tableJournalVitamins = new JTable();
    private final JTable tableJournalWater = new JTable();
    private final JTable tableMinerals = new JTable();
    private JTable table_mix_comparison;
    private final JTable tableNutrientConstraint = new JTable();
    private final JTable tableNutrientInput = new JTable();
    private final JTable tableNutrientLookup = new JTable();
    private final JTable tableNutrientPercentConstraint = new JTable();
    private final JTable tableNutrientRatio = new JTable();
    private final JTable tableProtein = new JTable();
    private JTable tbl_journal_rda;
    private JTable tbl_results_rda;
    private final JTable tableVitamins = new JTable();
    private final JTable tableWater = new JTable();
    private final JTextArea textAreaJournalModel = new JTextArea();
    private final JTextArea textAreaModel = new JTextArea();
    private final JTextField textFieldFoodListSearch = new JTextField();
    private final JTextField textfield_allocation_remaining = new JTextField();
    private final JTextField textfield_allocation_pct = new JTextField();
    private final JTextField textfield_allocation_search = new JTextField();
    private final JTextField textFieldFoodNutrientConstraintQuantity = new JTextField();
    private final JTextField textFieldFoodNutrientRatioQuantityA = new JTextField();
    private final JTextField textFieldFoodNutrientRatioQuantityB = new JTextField();
    private final JTextField textFieldNutrientConstraintQuantity = new JTextField();
    private final JTextField textFieldNutrientLookup = new JTextField();
    private final JTextField textFieldNutrientRatioNutrientA = new JTextField();
    private final JTextField textFieldNutrientRatioNutrientB = new JTextField();
    private final JTextField textFieldNutrientSearchCheckCoefficients = new JTextField();
    private final JTextField textFieldNutrientSearch = new JTextField();
    private final JTextField textFieldPercentNutrientConstraintQuantity = new JTextField();
    private final JTree treeFoodList = new JTree();
    private final LinkedHashMap<String, JCheckBox> mapConstraintCheckboxes;
    private final ListModelCategory modelListCategory = new ListModelCategory( dbLink );
    private final ListModelFood2 modelListFoodInCategory = new ListModelFood2( dbLink );
    private final ListModelFood modelList_A_FoodDiff = new ListModelFood( dbLink );
    private final ListModelFood modelList_B_FoodDiff = new ListModelFood( dbLink );
    private final ListModelFood modelListFood = new ListModelFood( dbLink );
    private final ListModelMix1 modelList_Solve = new ListModelMix1( dbLink );
    private final ListModelMix0 modelListFoodJournal = new ListModelMix0( dbLink );
    private final ListModelMix modelList_A_MixDiff = new ListModelMix( dbLink );
    private final ListModelMix modelList_B_MixDiff = new ListModelMix( dbLink );
    private final ListModelSelectedFood modelListSelectedFood = new ListModelSelectedFood( dbLink );
    private final Nutrient_loader nutrient_loader = new Nutrient_loader( dbLink );
    private final Relationship_loader relationship_loader = new Relationship_loader( dbLink );
    private final Result_loader result_loader_journal = new Result_loader( dbLink );
    private final Result_loader result_loader = new Result_loader( dbLink );
    private String foodNameText;
    private final StringModelMixPct stringModelMixPct = new StringModelMixPct( dbLink );
    private final TableModelCarbs modelTableCarbs = new TableModelCarbs( result_loader );
    private final TableModelCarbs modelTableJournalCarbs = new TableModelCarbs( result_loader_journal );
    private final TableModelCheckCoefficients modelTableCheckCoefficients = new TableModelCheckCoefficients( dbLink );
    private final TableModelCost modelTableCost = new TableModelCost( result_loader );
    private final TableModelCost modelTableJournalCost = new TableModelCost( result_loader_journal );
    private final TableModelDataInput modelTableNutrientInput = new TableModelDataInput( dbLink );
    private final TableModelElectrolytes modelTableElectrolytes = new TableModelElectrolytes( result_loader );
    private final TableModelElectrolytes modelTableJournalElectrolytes = new TableModelElectrolytes( result_loader_journal );
    private final TableModelEnergy modelTableEnergy = new TableModelEnergy( result_loader );
    private final TableModelEnergy modelTableJournalEnergy = new TableModelEnergy( result_loader_journal );
    private final TableModelFat modelTableFats = new TableModelFat( result_loader );
    private final TableModelFat modelTableJournalFats = new TableModelFat( result_loader_journal );
    private final TableModelFoodComparison model_for_food_difference_table = new TableModelFoodComparison( dbLink );
    private final TableModelFoodList modelTableFoodList = new TableModelFoodList( dbLink );
    private final TableModelAllocation modelTableAllocation = new TableModelAllocation( dbLink );
    private final TableModelMeals modelTableMeals = new TableModelMeals( dbLink );
    private final TableModelFoodNutrientConstraints modelTableFoodNutrientConstraints = new TableModelFoodNutrientConstraints( dbLink );
    private final TableModelFoodNutrientRatioConstraints modelTableFoodNutrientRatioConstraints = new TableModelFoodNutrientRatioConstraints( dbLink );
    private final TableModelGlycemic modelTableGlycemic = new TableModelGlycemic( dbLink );
    private final TableModelGlycemic modelTableJournalGlycemic = new TableModelGlycemic( dbLink );
    private final TableModelMinerals modelTableJournalMinerals = new TableModelMinerals( result_loader_journal );
    private final TableModelMinerals modelTableMinerals = new TableModelMinerals( result_loader );
    private final TableModelMixComparison model_for_mix_difference_table = new TableModelMixComparison( dbLink );
    private final TableModelNutrientConstraints modelTableNutrientConstraints = new TableModelNutrientConstraints( dbLink );
    private final TableModelNutrientLookup modelTableNutrientLookup = new TableModelNutrientLookup( dbLink );
    private final TableModelNutrientRatioConstraints modelTableNutrientRatioConstraints = new TableModelNutrientRatioConstraints( dbLink );
    private final TableModelPercentNutrientConstraints tableModelPercentNutrientConstraints = new TableModelPercentNutrientConstraints( dbLink );
    private final TableModelProtein modelTableJournalProtein = new TableModelProtein( result_loader_journal );
    private final TableModelProtein modelTableProtein = new TableModelProtein( result_loader );
    private final TableModelRdaCheck tblmdl_journal_rda = new TableModelRdaCheck( dbLink );
    private final TableModelRdaCheck tblmdl_results_rda = new TableModelRdaCheck( dbLink );
    private final TableModelVitamins modelTableJournalVitamins = new TableModelVitamins( result_loader_journal );
    private final TableModelVitamins modelTableVitamins = new TableModelVitamins( result_loader );
    private final TableModelWater modelTableJournalWater = new TableModelWater( result_loader_journal );
    private final TableModelWater modelTableWater = new TableModelWater( result_loader );
    private final TableRowSorter food_comparison_tablesorter = new TableRowSorter<>( model_for_food_difference_table );
    private final TableRowSorter foodlist_tablesorter = new TableRowSorter<>( modelTableFoodList );
    private final TableRowSorter mix_comparison_tablesorter = new TableRowSorter<>( model_for_mix_difference_table );
    private final TableRowSorter nutrientinput_tablesorter = new TableRowSorter<>( modelTableNutrientInput );
    private final TableRowSorter nutrientlookup_tablesorter = new TableRowSorter<>( modelTableNutrientLookup );
    private final TableRowSorter allocationlookup_tablesorter = new TableRowSorter<>( modelTableAllocation );
    private final TableRowSorter tableSorterCheckCoefficients = new TableRowSorter<>( modelTableCheckCoefficients );
    private final TreeModelFood modelTreeFoodList = new TreeModelFood( dbLink );
    private final JRadioButtonMenuItem rbtn_cost = new JRadioButtonMenuItem();
    private final JRadioButtonMenuItem rbtn_calories = new JRadioButtonMenuItem();
    private JLabel lbl_Min = new JLabel();
    private JTabbedPane main_tabbed_pane = new JTabbedPane();
    private JTabbedPane results_tabbed_pane = new JTabbedPane();
    private JTabbedPane journal_results_tabbed_pane = new JTabbedPane();

    public Main() {
        fileChooser = new JFileChooser();
        FormLayout layout = new FormLayout( "min:grow", //columns
                                            "fill:min:grow,1dlu,min" //rows
        );
        frm_snack.setIconImage( logo );
        frm_snack.setJMenuBar( get_menubar() );
        main_tabbed_pane.setTabPlacement( JTabbedPane.BOTTOM );
        main_tabbed_pane.add( get_solve() );
        main_tabbed_pane.add( get_food_list() );
        main_tabbed_pane.add( get_food_comparison() );
        main_tabbed_pane.add( get_food_categories() );
        main_tabbed_pane.add( get_mix_journal() );
        main_tabbed_pane.add( get_mix_comparison() );
        main_tabbed_pane.add( get_nutrient_lookup_list() );
        main_tabbed_pane.setTitleAt( 0, "Solve" );
        main_tabbed_pane.setToolTipTextAt( 0, "Specify your mix problem here" );
        main_tabbed_pane.setTitleAt( 1, "Food List" );
        main_tabbed_pane.setToolTipTextAt( 1, "This is your list of favorite food items" );
        main_tabbed_pane.setTitleAt( 2, "Food Comparison" );
        main_tabbed_pane.setToolTipTextAt( 2, "This is where you compare two food items (100g)" );
        main_tabbed_pane.setTitleAt( 3, "Food Category" );
        main_tabbed_pane.setToolTipTextAt( 3, "This is where you categorize food items" );
        main_tabbed_pane.setTitleAt( 4, "Journal" );
        main_tabbed_pane.setToolTipTextAt( 4, "This is your list of mixes" );
        main_tabbed_pane.setTitleAt( 5, "Mix Comparison" );
        main_tabbed_pane.setToolTipTextAt( 5, "This is where you compare two mixes" );
        main_tabbed_pane.setTitleAt( 6, "Nutrient Lookup" );
        main_tabbed_pane.setToolTipTextAt( 6, "This is where you find food items that provide a specific nutrient" );
        JPanel panelF = new JPanel();
        panelF.setLayout( layout );
        panelF.add( main_tabbed_pane, cc.xy( 1, 1 ) );
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView( panelF );
        frm_snack.add( scrollPane );
        frm_snack.setDefaultCloseOperation( 3 );
        Dimension size = new Dimension( 1435, 897 );
        frm_snack.setSize( size );
        frm_snack.setVisible( true );
        frm_snack.setTitle( "Snack" );
        frm_snack.addWindowListener( new WindowAdapter() {
            @Override
            public void windowClosing( WindowEvent e ) {
                evt_mnui_exit();
            }
        } );
        reload_cbmdl_results_lifestage();
        reload_cbmdl_journal_lifestage();
        reload_nutrient_combo_boxes();
        reload_relationship_combo_boxes();
        reload_mixes();
        reload_table_model_constraints( "" );
        checkBoxCompleteProtein.setName( "Complete Protein" );
        checkBoxProtein.setName( "Protein" );
        checkBoxFat.setName( "Total Fat" );
        checkBoxCholesterol.setName( "Cholesterol (CHOL)" );
        checkBoxSaturated.setName( "Saturated (SFA)" );
        checkBoxDHA.setName( "Docosahexaenoic (DHA)" );
        checkBoxEPA.setName( "Eicosapentaenoic (EPA)" );
        checkBoxMonounsaturated.setName( "Monounsaturated (MUFA)" );
        checkBoxPolyunsaturated.setName( "Polyunsaturated (PUFA)" );
        checkBoxLinoleic.setName( "Linoleic (LA)" );
        checkBoxAlphaLinolenic.setName( "Linolenic (ALA)" );
        checkBoxDigestibleCarbs.setName( "Digestible Carbs" );
        checkBoxFiber.setName( "Fiber" );
        checkBoxVitaminA.setName( "Vitamin A" );
        checkBoxVitaminE.setName( "Vitamin E" );
        checkBoxVitaminD.setName( "Vitamin D" );
        checkBoxVitaminC.setName( "Vitamin C" );
        checkBoxThiamin.setName( "Thiamin" );
        checkBoxRiboflavin.setName( "Riboflavin" );
        checkBoxNiacin.setName( "Niacin" );
        checkBoxPantothenic.setName( "Pantothenic" );
        checkBoxVitaminB6.setName( "Vitamin B6" );
        checkBoxVitaminB12.setName( "Vitamin B12" );
        checkBoxCholine.setName( "Choline" );
        checkBoxVitaminK.setName( "Vitamin K" );
        checkBoxFolate.setName( "Folate" );
        checkBoxCalcium.setName( "Calcium" );
        checkBoxIron.setName( "Iron" );
        checkBoxMagnesium.setName( "Magnesium" );
        checkBoxPhosphorus.setName( "Phosphorus" );
        checkBoxPotassium.setName( "Potassium" );
        checkBoxSodium.setName( "Sodium" );
        checkBoxZinc.setName( "Zinc" );
        checkBoxCopper.setName( "Copper" );
        checkBoxManganese.setName( "Manganese" );
        checkBoxSelenium.setName( "Selenium" );
        checkBoxWeight.setName( "Weight" );
        checkBoxCost.setName( "Cost" );
        checkBoxEnergy.setName( "Energy, gross" );
        checkBoxAlcohol.setName( "Alcohol" );
        checkBoxWater.setName( "Water" );
        checkBoxGlycemicLoad.setName( "Glycemic Load" );
        checkBoxEnergyDigestible.setName( "Energy, digestible" );
        checkBoxEnergyCarbohydrate.setName( "Energy, carbohydrate" );
        checkBoxEnergyProtein.setName( "Energy, protein" );
        checkBoxEnergyFat.setName( "Energy, fat" );
        checkBoxEnergyAlcohol.setName( "Energy, alcohol" );
        checkBoxEnergyFatCarbohydrate.setName( "Energy, fat and carbohydrate" );
        mapConstraintCheckboxes = new LinkedHashMap<>();
        mapConstraintCheckboxes.put( Nutrient.COMPLETEPROTEIN.getNumber(), checkBoxCompleteProtein );
        mapConstraintCheckboxes.put( Nutrient.PROTEIN.getNumber(), checkBoxProtein );
        mapConstraintCheckboxes.put( Nutrient.FAT.getNumber(), checkBoxFat );
        mapConstraintCheckboxes.put( Nutrient.CHOLESTEROL.getNumber(), checkBoxCholesterol );
        mapConstraintCheckboxes.put( Nutrient.SFA.getNumber(), checkBoxSaturated );
        mapConstraintCheckboxes.put( Nutrient.DHA.getNumber(), checkBoxDHA );
        mapConstraintCheckboxes.put( Nutrient.EPA.getNumber(), checkBoxEPA );
        mapConstraintCheckboxes.put( Nutrient.MUFA.getNumber(), checkBoxMonounsaturated );
        mapConstraintCheckboxes.put( Nutrient.PUFA.getNumber(), checkBoxPolyunsaturated );
        mapConstraintCheckboxes.put( Nutrient.LINOLEIC.getNumber(), checkBoxLinoleic );
        mapConstraintCheckboxes.put( Nutrient.LINOLENIC.getNumber(), checkBoxAlphaLinolenic );
        mapConstraintCheckboxes.put( Nutrient.DIGESTIBLECARBOHYDRATE.getNumber(), checkBoxDigestibleCarbs );
        mapConstraintCheckboxes.put( Nutrient.FIBER.getNumber(), checkBoxFiber );
        mapConstraintCheckboxes.put( Nutrient.VITAMINA.getNumber(), checkBoxVitaminA );
        mapConstraintCheckboxes.put( Nutrient.VITAMINE.getNumber(), checkBoxVitaminE );
        mapConstraintCheckboxes.put( Nutrient.VITAMIND.getNumber(), checkBoxVitaminD );
        mapConstraintCheckboxes.put( Nutrient.VITAMINC.getNumber(), checkBoxVitaminC );
        mapConstraintCheckboxes.put( Nutrient.THIAMIN.getNumber(), checkBoxThiamin );
        mapConstraintCheckboxes.put( Nutrient.RIBOFLAVIN.getNumber(), checkBoxRiboflavin );
        mapConstraintCheckboxes.put( Nutrient.NIACIN.getNumber(), checkBoxNiacin );
        mapConstraintCheckboxes.put( Nutrient.PANTOTHENICACID.getNumber(), checkBoxPantothenic );
        mapConstraintCheckboxes.put( Nutrient.VITAMINB6.getNumber(), checkBoxVitaminB6 );
        mapConstraintCheckboxes.put( Nutrient.VITAMINB12.getNumber(), checkBoxVitaminB12 );
        mapConstraintCheckboxes.put( Nutrient.CHOLINE.getNumber(), checkBoxCholine );
        mapConstraintCheckboxes.put( Nutrient.VITAMINK.getNumber(), checkBoxVitaminK );
        mapConstraintCheckboxes.put( Nutrient.FOLATE.getNumber(), checkBoxFolate );
        mapConstraintCheckboxes.put( Nutrient.CALCIUM.getNumber(), checkBoxCalcium );
        mapConstraintCheckboxes.put( Nutrient.IRON.getNumber(), checkBoxIron );
        mapConstraintCheckboxes.put( Nutrient.MAGNESIUM.getNumber(), checkBoxMagnesium );
        mapConstraintCheckboxes.put( Nutrient.PHOSPHORUS.getNumber(), checkBoxPhosphorus );
        mapConstraintCheckboxes.put( Nutrient.POTASSIUM.getNumber(), checkBoxPotassium );
        mapConstraintCheckboxes.put( Nutrient.SODIUM.getNumber(), checkBoxSodium );
        mapConstraintCheckboxes.put( Nutrient.ZINC.getNumber(), checkBoxZinc );
        mapConstraintCheckboxes.put( Nutrient.COPPER.getNumber(), checkBoxCopper );
        mapConstraintCheckboxes.put( Nutrient.MANGANESE.getNumber(), checkBoxManganese );
        mapConstraintCheckboxes.put( Nutrient.SELENIUM.getNumber(), checkBoxSelenium );
        mapConstraintCheckboxes.put( Nutrient.WEIGHT.getNumber(), checkBoxWeight );
        mapConstraintCheckboxes.put( Nutrient.COST.getNumber(), checkBoxCost );
        mapConstraintCheckboxes.put( Nutrient.ENERGYGROSS.getNumber(), checkBoxEnergy );
        mapConstraintCheckboxes.put( Nutrient.ALCOHOL.getNumber(), checkBoxAlcohol );
        mapConstraintCheckboxes.put( Nutrient.WATER.getNumber(), checkBoxWater );
        mapConstraintCheckboxes.put( Nutrient.GLYCEMICLOAD.getNumber(), checkBoxGlycemicLoad );
        mapConstraintCheckboxes.put( Nutrient.ENERGYDIGESTIBLE.getNumber(), checkBoxEnergyDigestible );
        mapConstraintCheckboxes.put( Nutrient.ENERGYCARBOHYDRATE.getNumber(), checkBoxEnergyCarbohydrate );
        mapConstraintCheckboxes.put( Nutrient.ENERGYPROTEIN.getNumber(), checkBoxEnergyProtein );
        mapConstraintCheckboxes.put( Nutrient.ENERGYFAT.getNumber(), checkBoxEnergyFat );
        mapConstraintCheckboxes.put( Nutrient.ENERGYALCOHOL.getNumber(), checkBoxEnergyAlcohol );
        mapConstraintCheckboxes.put( Nutrient.ENERGYFATCARBOHYDRATE.getNumber(), checkBoxEnergyFatCarbohydrate );
        try {
            LinkedList all = ( LinkedList ) dbLink.Nutrient_Select_All();
            Iterator it = all.iterator();
            while( it.hasNext() ) {
                HashMap row = ( HashMap ) it.next();
                String nutrientid = ( String ) row.get( "NUTRIENTID" );
                int visible = ( int ) row.get( "VISIBLE" );
                if( mapConstraintCheckboxes.containsKey( nutrientid ) ) {
                    JCheckBox cb = mapConstraintCheckboxes.get( nutrientid );
                    cb.setSelected( visible == 1 );
                }
            }
        } catch( SQLException e ) {

        }
        evt_mnui_roundup();
        resize_col_tbl_meal();
        resize_col_tbl_meal_allocation();
        dbLink.startTransaction();
    }

    public static void main( String[] args ) {
        try {
            Font font = new Font( Font.DIALOG, Font.PLAIN, 12 );
            MetalLookAndFeel.setCurrentTheme( new io.github.xjrga.looks.themes.Dawn_180( font ) );
            UIManager.setLookAndFeel( "javax.swing.plaf.metal.MetalLookAndFeel" );
        } catch( ClassNotFoundException e ) {
        } catch( IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e ) {

        }
        Main main = new Main();
    }

    private void evt_btn_meal_add() {
        if( is_mix_journal_selected() ) {
            JTextField input_name = new JTextField();
            JTextField input_order = new JTextField();
            JPanel input_panel = new JPanel();
            FormLayout panelLayout = new FormLayout(
                    "24dlu,34dlu,100dlu", //columns
                    "fill:16dlu,4dlu,fill:16dlu" //rows
            );
            input_panel.setLayout( panelLayout );
            JLabel lbl_name = new JLabel( "Name: " );
            lbl_name.setHorizontalAlignment( JLabel.RIGHT );
            input_panel.add( lbl_name, cc.xy( 1, 1 ) );
            input_panel.add( input_name, cc.xyw( 2, 1, 2 ) );
            JLabel lbl_order = new JLabel( "Order: " );
            lbl_order.setHorizontalAlignment( JLabel.RIGHT );
            input_panel.add( lbl_order, cc.xy( 1, 3 ) );
            input_panel.add( input_order, cc.xy( 2, 3 ) );
            JComponent[] inputs = new JComponent[] {
                input_panel
            };
            int optionValue = Message.showOptionDialogOkCancel( inputs, "Add Meal" );
            if( optionValue == 0 ) {
                try {
                    MixDataObject mix = ( MixDataObject ) list_journal_mix.getSelectedValue();
                    String mixId = mix.getMixId();
                    String text = input_name.getText();
                    NumberCheck checkNumber = new NumberCheck();
                    checkNumber.addToUncheckedList( input_order.getText() );
                    if( checkNumber.pass() ) {
                        Integer order = Integer.valueOf( input_order.getText() );
                        dbLink.Meal_insert( mixId, text, order );
                        dbLink.stopTransaction();
                        modelTableMeals.reload( mixId );
                        resize_col_tbl_meal();
                        modelComboBox_AllocationMeal.reload( mixId );
                        modelList_AllocationMeal.reload( mixId );
                    }
                } catch( SQLException e ) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void evt_btn_meal_delete() {
        if( is_mix_journal_selected() ) {
            try {
                int selectedRow = table_meals.getSelectedRow();
                String mixid = ( String ) table_meals.getValueAt( selectedRow, 0 );
                Integer mealid = ( Integer ) table_meals.getValueAt( selectedRow, 1 );
                dbLink.Meal_delete( mixid, mealid );
                dbLink.stopTransaction();
                modelTableMeals.reload( mixid );
                modelTableAllocation.reload( mixid, precision );
                modelComboBox_AllocationMeal.reload( mixid );
                modelList_AllocationMeal.reload( mixid );
                resize_col_tbl_meal();
                resize_col_tbl_meal_allocation();
            } catch( SQLException e ) {

            }
        }
    }

    private void evt_btn_meal_update() {
        if( is_mix_journal_selected() ) {
            JTextField input_name = new JTextField();
            JTextField input_order = new JTextField();
            int selectedRow = table_meals.getSelectedRow();
            if( selectedRow != -1 ) {
                String name = ( String ) table_meals.getValueAt( selectedRow, 2 );
                Integer order = ( Integer ) table_meals.getValueAt( selectedRow, 3 );
                input_name.setText( String.valueOf( name ) );
                input_order.setText( String.valueOf( order ) );
                JPanel input_panel = new JPanel();
                FormLayout panelLayout = new FormLayout(
                        "24dlu,34dlu,100dlu", //columns
                        "fill:16dlu,4dlu,fill:16dlu" //rows
                );
                input_panel.setLayout( panelLayout );
                JLabel lbl_name = new JLabel( "Name: " );
                lbl_name.setHorizontalAlignment( JLabel.RIGHT );
                input_panel.add( lbl_name, cc.xy( 1, 1 ) );
                input_panel.add( input_name, cc.xyw( 2, 1, 2 ) );
                JLabel lbl_order = new JLabel( "Order: " );
                lbl_order.setHorizontalAlignment( JLabel.RIGHT );
                input_panel.add( lbl_order, cc.xy( 1, 3 ) );
                input_panel.add( input_order, cc.xy( 2, 3 ) );
                JComponent[] inputs = new JComponent[] {
                    input_panel
                };
                int optionValue = Message.showOptionDialogOkCancel( inputs, "Update Meal" );
                if( optionValue == 0 ) {
                    try {
                        MixDataObject mix = ( MixDataObject ) list_journal_mix.getSelectedValue();
                        String mixId = mix.getMixId();
                        String mixid = ( String ) table_meals.getValueAt( selectedRow, 0 );
                        Integer mealid = ( Integer ) table_meals.getValueAt( selectedRow, 1 );
                        NumberCheck checkNumber = new NumberCheck();
                        checkNumber.addToUncheckedList( input_order.getText() );
                        if( checkNumber.pass() ) {
                            dbLink.Meal_update( mixid, mealid, input_name.getText(), Integer.valueOf( input_order.getText() ) );
                            dbLink.stopTransaction();
                            modelTableMeals.reload( mixId );
                            modelTableAllocation.reload( mixId, precision );
                            modelComboBox_AllocationMeal.reload( mixid );
                            modelList_AllocationMeal.reload( mixid );
                            resize_col_tbl_meal();
                            resize_col_tbl_meal_allocation();
                        }
                    } catch( SQLException e ) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    private void evt_cb_meal_food_allocation() {
        if( is_mix_journal_selected() ) {
            try {
                MixDataObject mix = ( MixDataObject ) list_journal_mix.getSelectedValue();
                String mixId = mix.getMixId();
                if( comboBoxAllocationFood.getSelectedItem() != null ) {
                    String foodid = (( FoodDataObject ) comboBoxAllocationFood.getSelectedItem()).getFoodId();
                    Double remaining = dbLink.calculate_remaining_allocation( mixId, foodid, precision );
                    textfield_allocation_remaining.setText( String.valueOf( remaining ) );
                }
            } catch( SQLException e ) {
                e.printStackTrace();
            }
        }

    }

    private void evt_mnui_meal_plan_export() {
        if( is_mix_journal_selected() ) {
            MixDataObject mixDataObject = ( MixDataObject ) list_journal_mix.getSelectedValue();
            ExportMealPlan export_meal_plan = new ExportMealPlan( dbLink );
            export_meal_plan.print( mixDataObject );
        }
        else {
            Message.showMessage( "Please select a mix at the journal" );
        }
    }

    private void reload_table_model_constraints( String mixId ) {
        modelTableNutrientConstraints.reload( mixId );
        resize_col_tbl_nutrient_constraint();
        modelTableFoodNutrientConstraints.reload( mixId );
        resize_col_tbl_food_nutrient_constraint();
        modelTableNutrientRatioConstraints.reload( mixId );
        resize_col_tbl_nutrient_ratio_constraint();
        modelTableFoodNutrientRatioConstraints.reload( mixId );
        resize_col_tbl_food_nutrient_ratio_constraint();
        tableModelPercentNutrientConstraints.reload( mixId );
        resize_col_tbl_percent_nutrient_constraint();
    }

    private void reload_relationship_combo_boxes() {
        relationship_loader.reload();
        modelComboBox_RelationshipAtNutrient.removeAllElements();
        modelComboBox_RelationshipAtFoodNutrient.removeAllElements();
        modelComboBox_RelationshipAtNutrientRatio.removeAllElements();
        modelComboBox_RelationshipAtFoodNutrientRatio.removeAllElements();
        modelComboBox_RelationshipAtNutrientPercent.removeAllElements();
        modelComboBox_RelationshipAtNutrient.addAll( relationship_loader.get_relationship_list() );
        modelComboBox_RelationshipAtFoodNutrient.addAll( relationship_loader.get_relationship_list() );
        modelComboBox_RelationshipAtNutrientRatio.addAll( relationship_loader.get_relationship_list() );
        modelComboBox_RelationshipAtFoodNutrientRatio.addAll( relationship_loader.get_relationship_list() );
        modelComboBox_RelationshipAtNutrientPercent.addAll( relationship_loader.get_relationship_list() );
        comboBoxNutrientConstraintRelationship.setSelectedIndex( 0 );
        comboBoxFoodNutrientConstraintRelationship.setSelectedIndex( 0 );
        comboBoxNutrientRatioRelationship.setSelectedIndex( 0 );
        comboBoxFoodNutrientRatioRelationship.setSelectedIndex( 0 );
        comboBoxPercentNutrientRelationship.setSelectedIndex( 0 );
    }

    private JMenuBar get_menubar() {
        JMenuBar mnuBar = new JMenuBar();
        mnuBar.add( menuProgram );
        mnuBar.add( menuTools );
        mnuBar.add( menuData );
        mnuBar.add( menuHelp );
        menuProgram.add( menuSettings );
        menuProgram.add( menuItemExit );
        menuTools.add( menuItemMicronutrientConversion );
        menuTools.add( menuItemBmr );
        menuTools.add( menuItemNitrogenBalance );
        menuTools.add( menuItemKetosis );
        menuTools.add( menuItemDigestibleCarbs );
        menuTools.add( menuItemGlycemicLoad );
        menuTools.add( menuItemGlycemicIndexRange );
        menuTools.add( menu_item_alpha_linolenic_acid_required );
        menuTools.add( menui_show_mix_stats );
        menuData.add( menu_spreadsheet );
        menuData.add( menu_exchange );
        menu_spreadsheet.add( menuItemExportFoodList );
        menu_spreadsheet.add( menuItemExportFoodComparison );
        menu_spreadsheet.add( menuItemExportMixJournal );
        menu_spreadsheet.add( menuItemExportMixJournalRda );
        menu_spreadsheet.add( menuItemExportMixComparison );
        menu_spreadsheet.add( menuItemExportNutrientLookup );
        menu_spreadsheet.add( menuItemExportMealPlan );
        menu_exchange.add( menui_import_message );
        menu_exchange.add( menui_export_message );
        menuHelp.add( menuItemGuide );
        menuHelp.add( menuItemCredits );
        menuHelp.add( menuItemAbout );
        menuSettings.add( checkBoxResultRoundUp );
        menuSettings.add( menuItemConstraintsShownInList );
        menuProgram.setText( "Program" );
        menuTools.setText( "Tools" );
        menuData.setText( "Data" );
        menuHelp.setText( "Help" );
        menuSettings.setText( "Settings" );
        menuItemExit.setText( "Exit" );
        menuItemMicronutrientConversion.setText( "Daily Value (%DV) to Grams" );
        menuItemBmr.setText( "Basal Metabolic Rate Of An Individual" );
        menuItemNitrogenBalance.setText( "Complete Protein Required In A No Fat, No Carbs Regimen" );
        menuItemKetosis.setText( "Carbohydrate Required To Inhibit Ketosis" );
        menuItemDigestibleCarbs.setText( "Digestible Carbohydrate Of A Food Item" );
        menuItemGlycemicLoad.setText( "Glycemic Load Of A Food Item" );
        menu_item_alpha_linolenic_acid_required.setText( "Alpha-Linolenic Acid Required" );
        menui_show_mix_stats.setText( "Macronutrient Percentages" );
        menuItemGlycemicIndexRange.setText( "Glycemic Index Range Of A Food Item" );
        menu_spreadsheet.setText( "Spreadsheet" );
        menu_exchange.setText( "Exchange" );
        menuItemExportFoodList.setText( "Food List" );
        menuItemExportFoodComparison.setText( "Food Comparison" );
        menuItemExportMixJournal.setText( "Journal" );
        menuItemExportMixComparison.setText( "Mix Comparison" );
        menuItemExportMixJournalRda.setText( "Journal Rda" );
        menuItemExportNutrientLookup.setText( "Nutrient Lookup" );
        menuItemExportMealPlan.setText( "Meal Plan " );
        menui_import_message.setText( "Import" );
        menui_export_message.setText( "Export" );
        checkBoxResultRoundUp.setText( "Round Up" );
        menuItemConstraintsShownInList.setText( "Nutrients, Energies and Cost Shown As Constraints" );
        menuItemGuide.setText( "Guide" );
        menuItemCredits.setText( "Credits" );
        menuItemAbout.setText( "About" );
        checkBoxResultRoundUp.setSelected( true );
        menuItemMicronutrientConversion.addActionListener( ( ActionEvent e )
                -> {
            evt_mnui_micronutrient_conversion();
        } );
        menuItemBmr.addActionListener( ( ActionEvent e )
                -> {
            evt_mnui_bmr();
        } );
        menuItemNitrogenBalance.addActionListener( ( ActionEvent e )
                -> {
            evt_mnui_nitrogen_balance();
        } );
        menuItemKetosis.addActionListener( ( ActionEvent e )
                -> {
            evt_mnui_ketosis();
        } );
        menuItemDigestibleCarbs.addActionListener( ( ActionEvent e )
                -> {
            evt_mnui_digestible_carbs();
        } );
        menuItemGlycemicLoad.addActionListener( ( ActionEvent e )
                -> {
            evt_mnui_glycemic_load();
        } );
        menu_item_alpha_linolenic_acid_required.addActionListener( ( ActionEvent e )
                -> {
            evt_mnui_n3_fatty_acid_recommendations();
        } );
        menui_show_mix_stats.addActionListener( ( ActionEvent e )
                -> {
            frm_snack.setCursor( Cursor.getPredefinedCursor( Cursor.WAIT_CURSOR ) );
            evt_mnui_show_mix_stats();
            frm_snack.setCursor( Cursor.getPredefinedCursor( Cursor.DEFAULT_CURSOR ) );
        } );
        menuItemGlycemicIndexRange.addActionListener( ( ActionEvent e )
                -> {
            evt_mnui_glycemic_index_range();
        } );
        menuItemExportFoodList.addActionListener( ( ActionEvent e )
                -> {
            evt_mnui_food_list_export();
        } );
        menuItemExportFoodComparison.addActionListener( ( ActionEvent e )
                -> {
            evt_mnui_food_comparison_export();
        } );
        menuItemExportMixJournal.addActionListener( ( ActionEvent e )
                -> {
            evt_mnui_journal_export();
        } );
        menuItemExportMixComparison.addActionListener( ( ActionEvent e )
                -> {
            evt_mnui_mix_comparison_export();
        } );
        menuItemExportMixJournalRda.addActionListener( ( ActionEvent e )
                -> {
            evt_mnui_rda_check_export();
        } );
        menuItemExportNutrientLookup.addActionListener( ( ActionEvent e )
                -> {
            evt_mnui_nutrient_lookup_export();
        } );
        menuItemExportMealPlan.addActionListener( ( ActionEvent e )
                -> {
            evt_mnui_meal_plan_export();
        } );
        menui_export_message.addActionListener( ( ActionEvent e )
                -> {
            evt_mnui_send_message();
        } );
        menui_import_message.addActionListener( ( ActionEvent e )
                -> {
            frm_snack.setCursor( Cursor.getPredefinedCursor( Cursor.WAIT_CURSOR ) );
            evt_mnui_receive_message();
            frm_snack.setCursor( Cursor.getPredefinedCursor( Cursor.WAIT_CURSOR ) );
            evt_btn_solve();
            frm_snack.setCursor( Cursor.getPredefinedCursor( Cursor.DEFAULT_CURSOR ) );
        } );
        menuItemGuide.addActionListener( ( ActionEvent e )
                -> {
            evt_mnui_guide();
        } );
        menuItemCredits.addActionListener( ( ActionEvent e )
                -> {
            evt_mnui_credits();
        } );
        menuItemAbout.addActionListener( ( ActionEvent e )
                -> {
            evt_mnui_about();
        } );
        menuItemConstraintsShownInList.addActionListener( ( ActionEvent e )
                -> {
            evt_mnui_nutrients_shown_as_constraints();
        } );
        checkBoxResultRoundUp.addActionListener( ( ActionEvent e )
                -> {
            evt_mnui_roundup();
        } );
        menuItemExit.addActionListener( ( ActionEvent e )
                -> {
            evt_mnui_exit();
        } );
        return mnuBar;
    }

    private void evt_mnui_digestible_carbs() {
        JTextField totalCarbs = new JTextField();
        JTextField totalFiber = new JTextField();
        JComponent[] inputs = new JComponent[] {
            new JLabel( "What is total carbohydrate (g) of food item?" ),
            totalCarbs
        };
        int optionValue = Message.showOptionDialogOkCancel( inputs, "Digestible Carbohydrate" );
        if( optionValue == 0 ) {
            String totalCarbsText = totalCarbs.getText();
            inputs = new JComponent[] {
                new JLabel( "What is total fiber (g) in food item?" ),
                totalFiber
            };
            optionValue = Message.showOptionDialogOkCancel( inputs, "Digestible Carbohydrate" );
            if( optionValue == 0 ) {
                String totalFiberText = totalFiber.getText();
                if( totalCarbsText != null && totalCarbsText.length() > 0 ) {
                    if( totalFiberText != null && totalFiberText.length() > 0 ) {
                        StringBuilder sb = new StringBuilder();
                        NumberCheck checkNumber = new NumberCheck();
                        checkNumber.addToUncheckedList( totalCarbsText );
                        checkNumber.addToUncheckedList( totalFiberText );
                        if( checkNumber.pass() ) {
                            Double totalCarbsNumber = Double.valueOf( totalCarbsText );
                            Double totalFiberNumber = Double.valueOf( totalFiberText );
                            double digestibleCarbsNumber = new DigestibleCarbohydrate( totalCarbsNumber, totalFiberNumber ).getDigestibleCarbohydrate();
                            sb.append( "Digestible Carbohydrate: " );
                            sb.append( digestibleCarbsNumber );
                            JTextArea textArea = new JTextArea( 1, 10 );
                            textArea.setText( sb.toString() );
                            textArea.setEditable( false );
                            inputs = new JComponent[] {
                                textArea
                            };
                            Message.showOptionDialog( inputs, "Digestible Carbohydrate" );
                        }
                    }
                }
            }
        }
    }

    private void evt_mnui_glycemic_index_range() {
        JTextField txtGI = new JTextField();
        JComponent[] inputs = new JComponent[] {
            new JLabel( "What is glycemic index of food item?" ),
            txtGI
        };
        int optionValue = Message.showOptionDialogOkCancel( inputs, "Glycemic Index Range" );
        if( optionValue == 0 ) {
            String strGI = txtGI.getText();
            if( strGI != null && strGI.length() > 0 ) {
                StringBuilder sb = new StringBuilder();
                NumberCheck checkNumber = new NumberCheck();
                checkNumber.addToUncheckedList( strGI );
                if( checkNumber.pass() ) {
                    Integer gi = Integer.valueOf( strGI );
                    String range = new GlycemicIndexRange( gi ).getGlycemicIndexRange();
                    sb.append( "Glycemic Index Range: " );
                    sb.append( range );
                    JTextArea textArea = new JTextArea( 1, 10 );
                    textArea.setText( sb.toString() );
                    textArea.setEditable( false );
                    inputs = new JComponent[] {
                        textArea
                    };
                    Message.showOptionDialog( inputs, "Glycemic Index Range" );
                }
            }
        }
    }

    private void evt_mnui_bmr() {
        JTextField textFieldLbs = new JTextField();
        JComponent[] inputs = new JComponent[] {
            new JLabel( "What is your lean body mass in pounds?" ),
            textFieldLbs
        };
        int optionValue = Message.showOptionDialogOkCancel( inputs, "Basal Metabolic Rate" );
        if( optionValue == 0 ) {
            String s = textFieldLbs.getText();
            if( s != null && s.length() > 0 ) {
                StringBuilder sb = new StringBuilder();
                NumberCheck checkNumber = new NumberCheck();
                checkNumber.addToUncheckedList( s );
                if( checkNumber.pass() ) {
                    Double weightinlbs = Double.valueOf( s );
                    double rdee = new KatchMcArdleFormula( weightinlbs ).getCalories();
                    sb.append( "Katch-McArdle Formula (Resting Daily Energy Expenditure): " );
                    sb.append( Math.round( rdee ) );
                    sb.append( " Kcals" );
                    sb.append( "\n" );
                    double rdee2 = new CunninghamFormula( weightinlbs ).getCalories();
                    sb.append( "Cunningham Formula (Resting Metabolic Rate): " );
                    sb.append( Math.round( rdee2 ) );
                    sb.append( " Kcals" );
                    sb.append( "\n" );
                    JTextArea textArea = new JTextArea( 1, 40 );
                    textArea.setText( sb.toString() );
                    textArea.setEditable( false );
                    inputs = new JComponent[] {
                        textArea
                    };
                    Message.showOptionDialog( inputs, "Basal Metabolic Rate" );
                }
                else {
                    Message.showMessage( "Numbers only" );
                }
            }
        }
    }

    private void evt_mnui_nitrogen_balance() {
        JTextField textFieldLbs = new JTextField();
        JComponent[] inputs = new JComponent[] {
            new JLabel( "What is your lean body mass in pounds?" ),
            textFieldLbs
        };
        int optionValue = Message.showOptionDialogOkCancel( inputs, "Complete Protein Required" );
        if( optionValue == 0 ) {
            String s = textFieldLbs.getText();
            if( s != null && s.length() > 0 ) {
                StringBuilder sb = new StringBuilder();
                NumberCheck checkNumber = new NumberCheck();
                checkNumber.addToUncheckedList( s );
                if( checkNumber.pass() ) {
                    Double weightinlbs = Double.valueOf( s );
                    double protein = new MinimumNutrientRequirements( weightinlbs ).getProtein();
                    sb.append( "Complete protein required in a no fat, no carbs regimen is " );
                    sb.append( Math.round( protein ) );
                    sb.append( " grams" );
                    sb.append( "\n" );
                    JTextArea textArea = new JTextArea( 1, 40 );
                    textArea.setText( sb.toString() );
                    textArea.setEditable( false );
                    inputs = new JComponent[] {
                        textArea
                    };
                    Message.showOptionDialog( inputs, "Complete Protein Required (no carbs, no fats)" );
                }
                else {
                    Message.showMessage( "Numbers only" );
                }
            }
        }
    }

    private void evt_mnui_ketosis() {
        StringBuilder sb = new StringBuilder();
        double carbohydrateLow = new MinimumNutrientRequirements( 0.0 ).getCarbohydrateLow();
        double carbohydrateMedium = new MinimumNutrientRequirements( 0.0 ).getCarbohydrateMedium();
        double carbohydrateHigh = new MinimumNutrientRequirements( 0.0 ).getCarbohydrateHigh();
        sb.append( "Carbohydrate Required to Appreciably Reduce Ketosis: " );
        sb.append( carbohydrateLow );
        sb.append( " to " );
        sb.append( carbohydrateMedium );
        sb.append( " g" );
        sb.append( "\n" );
        sb.append( "Carbohydrate Required to Inhibit Ketosis: " );
        sb.append( carbohydrateMedium );
        sb.append( " to " );
        sb.append( carbohydrateHigh );
        sb.append( " g" );
        sb.append( "\n" );
        JTextArea textArea = new JTextArea( 1, 40 );
        textArea.setText( sb.toString() );
        textArea.setEditable( false );
        JComponent[] inputs = new JComponent[] {
            textArea
        };
        Message.showOptionDialog( inputs, "Carbohydrate Required to Inhibit Ketosis" );
    }

    private void evt_mnui_micronutrient_conversion() {
        FormLayout layout = new FormLayout( "min:grow,min,min:grow", //columns
                                            "fill:min:grow" //rows
        );
        JPanel panel = new JPanel();
        panel.setLayout( layout );
        JComboBox cboxNutrients = new JComboBox();
        cboxNutrients.setModel( modelComboBox_NutrientLookupListConvert );
        modelComboBox_NutrientLookupListConvert.reload();
        JTextField dailyValuePct = new JTextField();
        dailyValuePct.setMinimumSize( new Dimension( 50, 20 ) );
        panel.add( cboxNutrients, cc.xy( 1, 1 ) );
        panel.add( dailyValuePct, cc.xy( 2, 1 ) );
        panel.add( new JLabel( " %DV" ), cc.xy( 3, 1 ) );
        JComponent[] inputs = new JComponent[] {
            panel
        };
        int optionValue = Message.showOptionDialogOkCancel( inputs, "Pct Daily Value to Grams" );
        if( optionValue == 0 ) {
            String s = dailyValuePct.getText();
            if( s != null && s.length() > 0 ) {
                NutrientDataObject nutrientDataObject = ( NutrientDataObject ) cboxNutrients.getSelectedItem();
                StringBuilder sb = new StringBuilder();
                NumberCheck checkNumber = new NumberCheck();
                checkNumber.addToUncheckedList( s );
                if( checkNumber.pass() ) {
                    Double dvpct = Double.valueOf( s );
                    sb.append( dvpct * (nutrientDataObject.getQ() / 100) );
                    sb.append( " " );
                    sb.append( nutrientDataObject.getNutrdesc() );
                    sb.append( "\n" );
                    JTextArea textArea = new JTextArea( 1, 30 );
                    textArea.setText( sb.toString() );
                    textArea.setEditable( false );
                    inputs = new JComponent[] {
                        textArea
                    };
                    Message.showOptionDialog( inputs, "Pct Daily Value to Grams" );
                }
                else {
                    Message.showMessage( "Numbers only" );
                }
            }
        }
    }

    private JPanel get_solve() {
        FormLayout layout = new FormLayout( "4dlu,min:grow,4dlu", //columns
                                            "4dlu,fill:min:grow,4dlu" //rows
        );
        JPanel panel = new JPanel();
        panel.setLayout( layout );
        JSplitPane splitPane = new JSplitPane();
        splitPane.setOrientation( JSplitPane.VERTICAL_SPLIT );
        splitPane.setDividerLocation( 0.6 );
        splitPane.setOneTouchExpandable( true );
        splitPane.setTopComponent( get_results() );
        JTabbedPane bottomTabPane = new JTabbedPane();
        bottomTabPane.setBorder( new TitledBorder( "Model Definition" ) );
        bottomTabPane.setTabPlacement( JTabbedPane.BOTTOM );
        FormLayout splitpane_bottom_layout = new FormLayout( "min,min", //columns
                                                             "fill:min:grow" //rows
        );
        JPanel splitpane_bottom = new JPanel();
        splitPane.setBottomComponent( splitpane_bottom );
        splitpane_bottom.setLayout( splitpane_bottom_layout );
        splitpane_bottom.add( get_mix_list(), cc.xy( 1, 1 ) );
        splitpane_bottom.add( bottomTabPane, cc.xy( 2, 1 ) );
        bottomTabPane.add( get_mix_food() );
        bottomTabPane.add( get_nutrient_constraint() );
        bottomTabPane.add( get_food_nutrient_constraint() );
        bottomTabPane.add( get_nutrient_ratio_constraint() );
        bottomTabPane.add( get_food_nutrient_ratio_constraint() );
        bottomTabPane.add( get_percent_of_food_nutrient_constraint() );
        bottomTabPane.setTitleAt( 0, "Food" );
        bottomTabPane.setToolTipTextAt( 0, "Pick your food here" );
        bottomTabPane.setTitleAt( 1, "Nutrient" );
        bottomTabPane.setToolTipTextAt( 1, "Use this to specify amount of nutrient or calories in your mix" );
        bottomTabPane.setTitleAt( 2, "Food" );
        bottomTabPane.setToolTipTextAt( 2, "Use this to specify amount of food nutrient or food calories in your mix" );
        bottomTabPane.setTitleAt( 3, "Nutrient Ratio" );
        bottomTabPane.setToolTipTextAt( 3, "Use this to specify proportion nutrients should be in" );
        bottomTabPane.setTitleAt( 4, "Food Ratio" );
        bottomTabPane.setToolTipTextAt( 4, "Use this to specify proportion food nutrients should be in" );
        bottomTabPane.setTitleAt( 5, "Food(%)" );
        bottomTabPane.setToolTipTextAt( 5, "Use this to specify percentage of food nutrient or food calories in your mix" );
        panel.add( splitPane, cc.xy( 2, 2 ) );
        lst_mix.addListSelectionListener( ( ListSelectionEvent e )
                -> {
            if( !e.getValueIsAdjusting() ) {
                frm_snack.setCursor( Cursor.getPredefinedCursor( Cursor.WAIT_CURSOR ) );
                evt_lst_mixes( e );
                frm_snack.setCursor( Cursor.getPredefinedCursor( Cursor.DEFAULT_CURSOR ) );
            }
        } );
        lst_mix.setModel( modelList_Solve );
        Action high = new AbstractAction() {
            @Override
            public void actionPerformed( ActionEvent e ) {
                splitPane.setDividerLocation( 0.0 );
            }
        };
        Action middle = new AbstractAction() {
            @Override
            public void actionPerformed( ActionEvent e ) {
                splitPane.setDividerLocation( 0.6 );
            }
        };
        Action low = new AbstractAction() {
            @Override
            public void actionPerformed( ActionEvent e ) {
                splitPane.setDividerLocation( 1.0 );
            }
        };
        InputMap input_map = splitPane.getInputMap( JSplitPane.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT );
        ActionMap action_map = splitPane.getActionMap();
        input_map.put( KeyStroke.getKeyStroke( "control T" ), "min" );
        input_map.put( KeyStroke.getKeyStroke( "control M" ), "mid" );
        input_map.put( KeyStroke.getKeyStroke( "control B" ), "max" );
        action_map.put( "min", low );
        action_map.put( "mid", middle );
        action_map.put( "max", high );
        return panel;
    }

    private JPanel get_mix_list() {
        JPanel pnl_mix_list = new JPanel();
        FormLayout pnl_mix_list_lyo = new FormLayout( "min:grow", //columns
                                                      "fill:min:grow,min" //rows
        );
        pnl_mix_list.setLayout( pnl_mix_list_lyo );
        pnl_mix_list.setBorder( new TitledBorder( "Mixes" ) );
        JPanel pnl_buttons = new JPanel();
        FormLayout pnl_buttons_lyo = new FormLayout( "min:grow,min,min,min,min,5dlu,min,min,min,5dlu,min,min,min:grow", //columns
                                                     "min" //rows
        );
        pnl_buttons.setLayout( pnl_buttons_lyo );
        JButton btn_create_mix = new JButton( "+" );
        JButton btn_delete_mix = new JButton( "-" );
        JButton btn_rename_mix = new JButton( "r" );
        JButton btn_duplicate_mix = new JButton( "d" );
        JButton btn_archive_mix = new JButton( "j" );
        JButton btn_add_mix_to_foodlist = new JButton( "f" );
        JButton btn_minimize_option = new JButton( "m" );
        JButton btn_solve = new JButton( "Solve" );
        JButton btn_undo = new JButton( "Undo" );
        btn_create_mix.setToolTipText( "Create mix" );
        btn_delete_mix.setToolTipText( "Delete mix" );
        btn_rename_mix.setToolTipText( "Rename mix" );
        btn_minimize_option.setToolTipText( "Choose minimization option" );
        btn_duplicate_mix.setToolTipText( "Duplicate mix" );
        btn_archive_mix.setToolTipText( "Send mix to journal" );
        btn_add_mix_to_foodlist.setToolTipText( "Add to food list" );
        btn_solve.setToolTipText( "Find food combination" );
        btn_undo.setToolTipText( "Undo model definition changes" );
        pnl_buttons.add( btn_create_mix, cc.xy( 2, 1 ) );
        pnl_buttons.add( btn_delete_mix, cc.xy( 3, 1 ) );
        pnl_buttons.add( btn_rename_mix, cc.xy( 4, 1 ) );
        pnl_buttons.add( btn_duplicate_mix, cc.xy( 5, 1 ) );
        pnl_buttons.add( btn_add_mix_to_foodlist, cc.xy( 7, 1 ) );
        pnl_buttons.add( btn_minimize_option, cc.xy( 8, 1 ) );
        pnl_buttons.add( btn_archive_mix, cc.xy( 9, 1 ) );
        pnl_buttons.add( btn_solve, cc.xy( 11, 1 ) );
        pnl_buttons.add( btn_undo, cc.xy( 12, 1 ) );
        JScrollPane scr_mixes = new JScrollPane( lst_mix );
        pnl_mix_list.add( scr_mixes, cc.xy( 1, 1 ) );
        pnl_mix_list.add( pnl_buttons, cc.xy( 1, 2 ) );
        btn_create_mix.addActionListener( ( ActionEvent e )
                -> {
            evt_btn_mix_create();
        } );
        btn_delete_mix.addActionListener( ( ActionEvent e )
                -> {
            evt_btn_mix_delete();
        } );
        btn_rename_mix.addActionListener( ( ActionEvent e )
                -> {
            evt_btn_mix_rename();
        } );
        btn_duplicate_mix.addActionListener( ( ActionEvent e )
                -> {
            evt_btn_mix_duplicate();
        } );
        btn_archive_mix.addActionListener( ( ActionEvent e )
                -> {
            evt_btn_archive_mix();
        } );
        btn_minimize_option.addActionListener( ( ActionEvent e )
                -> {
            evt_btn_minimize_option();
        } );
        btn_add_mix_to_foodlist.addActionListener( ( ActionEvent e )
                -> {
            evt_btn_add_mix_to_foodlist();
        } );
        btn_solve.addActionListener( ( ActionEvent e )
                -> {
            frm_snack.setCursor( Cursor.getPredefinedCursor( Cursor.WAIT_CURSOR ) );
            evt_btn_solve();
            frm_snack.setCursor( Cursor.getPredefinedCursor( Cursor.DEFAULT_CURSOR ) );
        } );
        btn_undo.addActionListener( ( ActionEvent e )
                -> {
            evt_btn_undo();
        } );
        JPopupMenu mnu_mix_list = new JPopupMenu();
        JMenuItem mnui_pin_mix = new JMenuItem( "Pin" );
        mnu_mix_list.add( mnui_pin_mix );
        mnui_pin_mix.addActionListener( ( ActionEvent e )
                -> {
            evt_mnui_pin_mix();
        } );
        lst_mix.addMouseListener( new MouseAdapter() {
            @Override
            public void mouseClicked( MouseEvent e ) {
                super.mouseClicked( e );
                evt_lst_mixes( e, mnu_mix_list );
            }
        } );
        return pnl_mix_list;

    }

    private void evt_lst_mixes( MouseEvent e, JPopupMenu pmn ) {
        if( (e.getModifiers() & InputEvent.BUTTON3_MASK) != 0 ) {
            Component component = e.getComponent();
            pmn.show( component, e.getX(), e.getY() );
        }
    }

    private void evt_mnui_pin_mix() {
        if( is_mix_selected() ) {
            MixDataObject mix = ( MixDataObject ) lst_mix.getSelectedValue();
            String mixId = mix.getMixId();
            try {
                dbLink.pin_mix( mixId );
                reload_mixes();
                int index = modelList_Solve.find_by_mixid( mix.getMixId() );
                lst_mix.setSelectedIndex( index );
            } catch( SQLException ex ) {
            }
        }
        else {
            Message.showMessage( "Please select mix" );
        }
    }

    private void evt_btn_archive_mix() {
        if( is_mix_selected() ) {
            JComponent[] inputs = new JComponent[] {
                new JLabel( "Would you like to send mix to journal?" )
            };
            int optionValue = Message.showOptionDialogOkCancel( inputs, "Journal Mix" );
            if( optionValue == 0 ) {
                try {
                    MixDataObject mix = ( MixDataObject ) lst_mix.getSelectedValue();
                    String mixId = mix.getMixId();
                    dbLink.Mix_Update_Status( mixId, 0 );
                    dbLink.stopTransaction();
                    modelList_Solve.reload();
                    modelListFoodJournal.reload();
                    clear_model_solve_tab();
                } catch( SQLException e ) {

                }
            }
        }
    }

    private void evt_btn_mix_create() {
        JTextField input = new JTextField();
        JComponent[] inputs = new JComponent[] {
            new JLabel( "What would you like to call it?" ),
            input
        };
        int optionValue = Message.showOptionDialogOkCancel( inputs, "Create Mix" );
        if( optionValue == 0 ) {
            String mixnom = input.getText();
            String model = "";
            //Set default objective function value to minimize
            String nutrientid = "10009";
            try {
                StringCheck sc = new StringCheck();
                sc.addUncheckedList( mixnom );
                if( sc.pass() ) {
                    String mixid = dbLink.Mix_Insert( mixnom );
                    dbLink.Mix_Update_NutrientId( mixid, nutrientid );
                    dbLink.Mix_Update_Other( mixid, model );
                    dbLink.Mix_Update_Status( mixid, 1 );
                    dbLink.stopTransaction();
                    reload_mixes();
                    clear_model_all();
                    lst_mix.setSelectedIndex( lst_mix.getLastVisibleIndex() );
                }
                else {
                    Message.showMessage( "These characters are not allowed: < & > ' \"" );
                }
            } catch( SQLException e ) {

            }
        }
    }

    private void reload_mixes() {
        modelList_Solve.reload();
        modelListFoodJournal.reload();
        modelList_A_MixDiff.reload();
        modelList_B_MixDiff.reload();
    }

    private void reload_nutrient_combo_boxes() {
        nutrient_loader.reload();
        modelComboBox_NutrientAtNutrientConstraint.removeAllElements();
        modelComboBox_NutrientAtNutrientPctContraint.removeAllElements();
        modelComboBox_0_NutrientAtFoodNutrientRatio.removeAllElements();
        modelComboBox_1_NutrientAtFoodNutrientRatio.removeAllElements();
        modelComboBox_0_NutrientAtNutrientRatio.removeAllElements();
        modelComboBox_1_NutrientAtNutrientRatio.removeAllElements();
        modelComboBox_NutrientAtNutrientConstraint.addAll( nutrient_loader.get_nutrient_list() );
        modelComboBox_NutrientAtNutrientPctContraint.addAll( nutrient_loader.get_nutrient_list() );
        modelComboBox_0_NutrientAtFoodNutrientRatio.addAll( nutrient_loader.get_nutrient_list() );
        modelComboBox_1_NutrientAtFoodNutrientRatio.addAll( nutrient_loader.get_nutrient_list() );
        modelComboBox_0_NutrientAtNutrientRatio.addAll( nutrient_loader.get_nutrient_list() );
        modelComboBox_1_NutrientAtNutrientRatio.addAll( nutrient_loader.get_nutrient_list() );
        comboBoxNutrientConstraintNutrient.setSelectedIndex( 0 );
        comboBoxPercentNutrientConstraintNutrient.setSelectedIndex( 0 );
        comboBoxFoodNutrientRatioNutrientA.setSelectedIndex( 0 );
        comboBoxFoodNutrientRatioNutrientB.setSelectedIndex( 0 );
        comboBoxNutrientRatioNutrientA.setSelectedIndex( 0 );
        comboBoxNutrientRatioNutrientB.setSelectedIndex( 0 );
        //Do not include modelComboBox_NutrientLookupListNutrient, all nutrients must be on list
        //modelComboBox_NutrientLookupListNutrient.reload();
    }

    private void reload_cbmdl_results_lifestage() {
        cbmdl_results_lifestage.reload();
        cbmdl_results_lifestage.setSelectedItem( new RdaLifeStageDataObject( 22, "Daily Value" ) );
    }

    private void reload_cbmdl_journal_lifestage() {
        cbmdl_journal_lifestage.reload();
        cbmdl_journal_lifestage.setSelectedItem( new RdaLifeStageDataObject( 22, "Daily Value" ) );
    }

    private void reload_food_combo_boxes( String mixId ) {
        food_loader.reload( mixId );
        modelComboBox_0_FoodAtFoodNutrientRatio.removeAllElements();
        modelComboBox_1_FoodAtFoodNutrientRatio.removeAllElements();
        modelComboBox_FoodAtNutrient.removeAllElements();
        modelComboBox_FoodAtNutrientPct.removeAllElements();
        modelComboBox_0_FoodAtFoodNutrientRatio.addAll( food_loader.get_food_list() );
        modelComboBox_1_FoodAtFoodNutrientRatio.addAll( food_loader.get_food_list() );
        modelComboBox_FoodAtNutrient.addAll( food_loader.get_food_list() );
        modelComboBox_FoodAtNutrientPct.addAll( food_loader.get_food_list() );
        if( !food_loader.get_food_list().isEmpty() ) {
            comboBoxFoodNutrientRatioFoodA.setSelectedIndex( 0 );
            comboBoxFoodNutrientRatioFoodB.setSelectedIndex( 0 );
            comboBoxFoodNutrientConstraintFood.setSelectedIndex( 0 );
            comboBoxPercentNutrientConstraintFood.setSelectedIndex( 0 );
        }
    }

    private void reload_results_table_models() {
        if( is_mix_selected() ) {
            MixDataObject mixDataObject = ( MixDataObject ) lst_mix.getSelectedValue();
            String mixId = mixDataObject.getMixId();
            result_loader.reload( mixId );
            modelTableEnergy.set_table( result_loader.get_energy_table() );
            tableEnergy.getColumnModel().getColumn( 0 ).setMinWidth( 400 );
            tableEnergy.getColumnModel().getColumn( 0 ).setMaxWidth( 400 );
            for( int i = 1; i < 12; i++ ) {
                tableEnergy.getColumnModel().getColumn( i ).setMinWidth( 70 );
                tableEnergy.getColumnModel().getColumn( i ).setMaxWidth( 70 );
            }
            modelTableProtein.set_table( result_loader.get_protein_table() );
            tableProtein.getColumnModel().getColumn( 0 ).setMinWidth( 400 );
            tableProtein.getColumnModel().getColumn( 0 ).setMaxWidth( 400 );
            for( int i = 1; i < 5; i++ ) {
                tableProtein.getColumnModel().getColumn( i ).setMinWidth( 70 );
                tableProtein.getColumnModel().getColumn( i ).setMaxWidth( 70 );
            }
            modelTableFats.set_table( result_loader.get_fats_table() );
            tableFats.getColumnModel().getColumn( 0 ).setMinWidth( 400 );
            tableFats.getColumnModel().getColumn( 0 ).setMaxWidth( 400 );
            for( int i = 1; i < 12; i++ ) {
                tableFats.getColumnModel().getColumn( i ).setMinWidth( 70 );
                tableFats.getColumnModel().getColumn( i ).setMaxWidth( 70 );
            }
            modelTableCarbs.set_table( result_loader.get_carbs_table() );
            tableCarbs.getColumnModel().getColumn( 0 ).setMinWidth( 400 );
            tableCarbs.getColumnModel().getColumn( 0 ).setMaxWidth( 400 );
            for( int i = 1; i < 6; i++ ) {
                tableCarbs.getColumnModel().getColumn( i ).setMinWidth( 70 );
                tableCarbs.getColumnModel().getColumn( i ).setMaxWidth( 70 );
            }
            modelTableVitamins.set_table( result_loader.get_vitamins_table() );
            tableVitamins.getColumnModel().getColumn( 0 ).setMinWidth( 400 );
            tableVitamins.getColumnModel().getColumn( 0 ).setMaxWidth( 400 );
            for( int i = 1; i < 15; i++ ) {
                tableVitamins.getColumnModel().getColumn( i ).setMinWidth( 70 );
                tableVitamins.getColumnModel().getColumn( i ).setMaxWidth( 70 );
            }
            modelTableMinerals.set_table( result_loader.get_minerals_table() );
            tableMinerals.getColumnModel().getColumn( 0 ).setMinWidth( 400 );
            tableMinerals.getColumnModel().getColumn( 0 ).setMaxWidth( 400 );
            for( int i = 1; i < 10; i++ ) {
                tableMinerals.getColumnModel().getColumn( i ).setMinWidth( 70 );
                tableMinerals.getColumnModel().getColumn( i ).setMaxWidth( 70 );
            }
            modelTableWater.set_table( result_loader.get_water_table() );
            tableWater.getColumnModel().getColumn( 0 ).setMinWidth( 400 );
            tableWater.getColumnModel().getColumn( 0 ).setMaxWidth( 400 );
            for( int i = 1; i < 3; i++ ) {
                tableWater.getColumnModel().getColumn( i ).setMinWidth( 70 );
                tableWater.getColumnModel().getColumn( i ).setMaxWidth( 70 );
            }
            modelTableCost.set_table( result_loader.get_cost_table() );
            tableCost.getColumnModel().getColumn( 0 ).setMinWidth( 400 );
            tableCost.getColumnModel().getColumn( 0 ).setMaxWidth( 400 );
            for( int i = 1; i < 3; i++ ) {
                tableCost.getColumnModel().getColumn( i ).setMinWidth( 70 );
                tableCost.getColumnModel().getColumn( i ).setMaxWidth( 70 );
            }
            modelTableElectrolytes.set_table( result_loader.get_electrolytes_table() );
            tableElectrolytes.getColumnModel().getColumn( 0 ).setMinWidth( 400 );
            tableElectrolytes.getColumnModel().getColumn( 0 ).setMaxWidth( 400 );
            for( int i = 1; i < 4; i++ ) {
                tableElectrolytes.getColumnModel().getColumn( i ).setMinWidth( 70 );
                tableElectrolytes.getColumnModel().getColumn( i ).setMaxWidth( 70 );
            }
            modelTableGlycemic.reload( mixId );
            tableGlycemic.getColumnModel().getColumn( 0 ).setMinWidth( 400 );
            tableGlycemic.getColumnModel().getColumn( 0 ).setMaxWidth( 400 );
            for( int i = 1; i < 8; i++ ) {
                tableGlycemic.getColumnModel().getColumn( i ).setMinWidth( 70 );
                tableGlycemic.getColumnModel().getColumn( i ).setMaxWidth( 70 );
            }
        }
    }

    private void evt_btn_mix_delete() {
        if( is_mix_selected() ) {
            JComponent[] inputs = new JComponent[] {
                new JLabel( "Would you like to delete mix?" )
            };
            int optionValue = Message.showOptionDialogOkCancel( inputs, "Delete Mix" );
            if( optionValue == 0 ) {
                try {
                    MixDataObject mix = ( MixDataObject ) lst_mix.getSelectedValue();
                    String mixId = mix.getMixId();
                    dbLink.Mix_Delete( mixId );
                    dbLink.stopTransaction();
                    reload_mixes();
                    clear_model_all();
                } catch( SQLException e ) {

                }
            }
            else {
            }
        }
        else {
            Message.showMessage( "Select mix." );
        }
    }

    private void clear_model_all() {
        clear_model_solve_tab();
        clear_model_journal();
        clear_model_meal_plan();
        model_for_mix_difference_table.setRowCount( 0 );
        tblmdl_journal_rda.setRowCount( 0 );
        food_loader.reload( "" );
        textAreaModel.setText( "" );
    }

    private void clear_model_journal() {
        modelTableJournalEnergy.setRowCount( 0 );
        modelTableJournalProtein.setRowCount( 0 );
        modelTableJournalFats.setRowCount( 0 );
        modelTableJournalCarbs.setRowCount( 0 );
        modelTableJournalVitamins.setRowCount( 0 );
        modelTableJournalMinerals.setRowCount( 0 );
        modelTableJournalElectrolytes.setRowCount( 0 );
        modelTableJournalWater.setRowCount( 0 );
        modelTableJournalCost.setRowCount( 0 );
        modelTableJournalGlycemic.setRowCount( 0 );
    }

    private void clear_model_solve_tab() {
        modelListSelectedFood.clear();
        modelTableNutrientConstraints.setRowCount( 0 );
        modelTableFoodNutrientConstraints.setRowCount( 0 );
        modelTableNutrientRatioConstraints.setRowCount( 0 );
        modelTableFoodNutrientRatioConstraints.setRowCount( 0 );
        tableModelPercentNutrientConstraints.setRowCount( 0 );
        //
        modelTableEnergy.setRowCount( 0 );
        modelTableProtein.setRowCount( 0 );
        modelTableFats.setRowCount( 0 );
        modelTableCarbs.setRowCount( 0 );
        modelTableVitamins.setRowCount( 0 );
        modelTableMinerals.setRowCount( 0 );
        modelTableElectrolytes.setRowCount( 0 );
        modelTableWater.setRowCount( 0 );
        modelTableCost.setRowCount( 0 );
        modelTableGlycemic.setRowCount( 0 );
    }

    private void evt_btn_mix_rename() {
        if( is_mix_selected() ) {
            JTextField input = new JTextField();
            JComponent[] inputs = new JComponent[] {
                new JLabel( "What is your new mix name?" ),
                input
            };
            MixDataObject mix = ( MixDataObject ) lst_mix.getSelectedValue();
            input.setText( mix.getName() );
            int optionValue = Message.showOptionDialogOkCancel( inputs, "Update Mix" );
            if( optionValue == 0 ) {
                try {
                    String mixnom = input.getText();
                    StringCheck sc = new StringCheck();
                    sc.addUncheckedList( mixnom );
                    if( sc.pass() ) {
                        String mixId = mix.getMixId();
                        dbLink.Mix_Update_Name( mixId, mixnom );
                        dbLink.stopTransaction();
                        reload_mixes();
                        int index = modelList_Solve.find_by_mixid( mix.getMixId() );
                        lst_mix.setSelectedIndex( index );
                    }
                    else {
                        Message.showMessage( "These characters are not allowed: < & > ' \"" );
                    }
                } catch( SQLException e ) {

                }
            }
        }
    }

    private void evt_btn_mix_duplicate() {
        if( is_mix_selected() ) {
            JComponent[] inputs = new JComponent[] {
                new JLabel( "Would you like to duplicate mix?" )
            };
            int optionValue = Message.showOptionDialogOkCancel( inputs, "Duplicate Mix" );
            if( optionValue == 0 ) {
                try {
                    MixDataObject mix = ( MixDataObject ) lst_mix.getSelectedValue();
                    String mixId = mix.getMixId();
                    dbLink.Mix_Duplicate( mixId );
                    dbLink.stopTransaction();
                    reload_mixes();
                    int index = modelList_Solve.find_by_mixid( mix.getMixId() );
                    lst_mix.setSelectedIndex( index );
                } catch( SQLException e ) {

                }
            }
        }
        else {
            Message.showMessage( "Select mix." );
        }
    }

    private void evt_btn_add_mix_to_foodlist() {
        if( is_mix_selected() ) {
            JComponent[] inputs = new JComponent[] {
                new JLabel( "Would you like to add mix to food list?" ),};
            int optionValue = Message.showOptionDialogOkCancel( inputs, "Add to Food List" );
            if( optionValue == 0 ) {
                try {
                    MixDataObject mixDataObject = ( MixDataObject ) lst_mix.getSelectedValue();
                    dbLink.Food_Put( mixDataObject.getMixId() );
                    dbLink.stopTransaction();
                    reload_food_items();
                } catch( SQLException e ) {

                }
            }
        }
        else {
            Message.showMessage( "Select mix" );
        }
    }

    private JTable get_table_mix_comparison() {
        JTable table;
        table = new JTable() {
            @Override
            public Component prepareRenderer( TableCellRenderer renderer, int rowIndex, int columnIndex ) {
                JComponent component = ( JComponent ) super.prepareRenderer( renderer, rowIndex, columnIndex );
                Double valueAt;
                switch( columnIndex ) {
                    case 0:
                        component.setForeground( tableEnergy.getForeground() );
                        break;
                    case 1:
                        component.setForeground( tableEnergy.getForeground() );
                        break;
                    case 2:
                        valueAt = ( Double ) getValueAt( rowIndex, columnIndex );
                        if( valueAt <= 0 ) {
                            component.setForeground( Color.red );
                        }
                        else {
                            component.setForeground( tableEnergy.getForeground() );
                        }
                        break;
                    case 3:
                        valueAt = ( Double ) getValueAt( rowIndex, columnIndex );
                        if( valueAt <= 0 ) {
                            component.setForeground( Color.red );
                        }
                        else {
                            component.setForeground( tableEnergy.getForeground() );
                        }
                        break;
                    case 4:
                        valueAt = ( Double ) getValueAt( rowIndex, columnIndex );
                        if( valueAt < 0 ) {
                            component.setForeground( Color.red );
                        }
                        else {
                            component.setForeground( tableEnergy.getForeground() );
                        }
                        break;
                }
                return component;
            }
        };
        return table;
    }

    private JPanel get_mix_comparison() {
        JPanel panel = new JPanel();
        table_mix_comparison = get_table_mix_comparison();
        JScrollPane scrollPaneA = new JScrollPane( list_mix_compare_a );
        JScrollPane scrollPaneB = new JScrollPane( list_mix_compare_b );
        JScrollPane scrollPaneC = new JScrollPane( table_mix_comparison );
        CellConstraints cc = new CellConstraints();
        JPanel search_panel = new JPanel();
        JLabel search_label = new JLabel( "Search: " );
        JTextField search_field = new JTextField();
        //create layouts
        FormLayout layout = new FormLayout(
                "4dlu,min:grow(.62),4dlu,min:grow(.62),4dlu,min:grow,4dlu", //columns
                "4dlu,min,fill:min:grow,4dlu" //rows
        );
        FormLayout layout02 = new FormLayout(
                "min:grow(.5),min:grow(.5)", //columns
                "4dlu,fill:16dlu" //rows
        );
        panel.setLayout( layout );
        panel.add( scrollPaneA, cc.xywh( 2, 2, 1, 2 ) );
        panel.add( scrollPaneB, cc.xywh( 4, 2, 1, 2 ) );
        search_panel.setLayout( layout02 );
        search_label.setHorizontalAlignment( JLabel.RIGHT );
        search_panel.add( search_label, cc.xy( 1, 2 ) );
        search_panel.add( search_field, cc.xy( 2, 2 ) );
        panel.add( search_panel, cc.xy( 6, 2 ) );
        panel.add( scrollPaneC, cc.xy( 6, 3 ) );
        scrollPaneA.setBorder( new TitledBorder( "Mix A" ) );
        scrollPaneB.setBorder( new TitledBorder( "Mix B" ) );
        scrollPaneC.setBorder( new TitledBorder( "Mix Difference" ) );
        list_mix_compare_a.addListSelectionListener( ( ListSelectionEvent e )
                -> {
            evt_lst_mix_compare_a( e );
        } );
        list_mix_compare_b.addListSelectionListener( ( ListSelectionEvent e )
                -> {
            evt_lst_mix_compare_b( e );
        } );
        search_field.getDocument().addDocumentListener( new DocumentListener() {
            @Override
            public void changedUpdate( DocumentEvent e ) {
                mix_comparison_search_filter();
            }

            @Override
            public void insertUpdate( DocumentEvent e ) {
                mix_comparison_search_filter();
            }

            @Override
            public void removeUpdate( DocumentEvent e ) {
                mix_comparison_search_filter();
            }

            private void mix_comparison_search_filter() {
                RowFilter<TableModelMixComparison, Object> rf = null;
                try {
                    ArrayList filters = new ArrayList();
                    filters.add( RowFilter.regexFilter( "(?i)" + search_field.getText(), 0 ) );
                    filters.add( RowFilter.regexFilter( "(?i)" + search_field.getText(), 1 ) );
                    rf = RowFilter.orFilter( ( Iterable<? extends RowFilter<? super TableModelMixComparison, ? super Object>> ) filters );
                } catch( java.util.regex.PatternSyntaxException e ) {
                    return;
                }
                mix_comparison_tablesorter.setRowFilter( rf );
            }

        } );
        list_mix_compare_a.setModel( modelList_A_MixDiff );
        list_mix_compare_b.setModel( modelList_B_MixDiff );
        table_mix_comparison.setModel( model_for_mix_difference_table );
        table_mix_comparison.setSelectionMode( ListSelectionModel.SINGLE_SELECTION );
        table_mix_comparison.setFillsViewportHeight( true );
        table_mix_comparison.setRowSorter( mix_comparison_tablesorter );
        modelList_A_MixDiff.reload();
        modelList_B_MixDiff.reload();
        resize_col_tbl_mix_comparison();
        return panel;
    }

    private JTable get_table_food_comparison() {
        JTable table;
        table = new JTable() {
            @Override
            public Component prepareRenderer( TableCellRenderer renderer, int rowIndex, int columnIndex ) {
                JComponent component = ( JComponent ) super.prepareRenderer( renderer, rowIndex, columnIndex );
                Double valueAt;
                switch( columnIndex ) {
                    case 0:
                        component.setForeground( tableEnergy.getForeground() );
                        break;
                    case 1:
                        component.setForeground( tableEnergy.getForeground() );
                        break;
                    case 2:
                        valueAt = ( Double ) getValueAt( rowIndex, columnIndex );
                        if( valueAt <= 0 ) {
                            component.setForeground( Color.red );
                        }
                        else {
                            component.setForeground( tableEnergy.getForeground() );
                        }
                        break;
                    case 3:
                        valueAt = ( Double ) getValueAt( rowIndex, columnIndex );
                        if( valueAt <= 0 ) {
                            component.setForeground( Color.red );
                        }
                        else {
                            component.setForeground( tableEnergy.getForeground() );
                        }
                        break;
                    case 4:
                        valueAt = ( Double ) getValueAt( rowIndex, columnIndex );
                        if( valueAt < 0 ) {
                            component.setForeground( Color.red );
                        }
                        else {
                            component.setForeground( tableEnergy.getForeground() );
                        }
                        break;
                }
                return component;
            }
        };
        return table;
    }

    private JPanel get_food_comparison() {
        JPanel panel = new JPanel();
        table_food_comparison = get_table_food_comparison();
        JScrollPane scrollPaneC = new JScrollPane( table_food_comparison );
        CellConstraints cc = new CellConstraints();
        JPanel search_panel = new JPanel();
        JLabel search_label = new JLabel( "Search: " );
        JTextField search_field = new JTextField();
        //create layouts
        FormLayout layout = new FormLayout(
                "4dlu,min:grow(.60),4dlu,min:grow(.60),4dlu,min:grow,4dlu", //columns
                "min,fill:min:grow,4dlu" //rows
        );
        FormLayout layout02 = new FormLayout(
                "min:grow(.5),min:grow(.5)", //columns
                "4dlu,fill:16dlu,4dlu" //rows
        );
        JPanel food_list_a_panel = new JPanel();
        JPanel food_list_b_panel = new JPanel();
        FormLayout layout03 = new FormLayout(
                "min,min:grow", //columns
                "4dlu,fill:16dlu,4dlu,fill:min:grow" //rows
        );
        food_list_a_panel.setLayout( layout03 );
        JScrollPane scrollPaneA = new JScrollPane( list_food_compare_a );
        scrollPaneA.setBorder( new TitledBorder( "Food A" ) );
        JLabel label_a = new JLabel( "Search: " );
        food_list_a_panel.add( label_a, cc.xy( 1, 2 ) );
        JTextField search_field_a = new JTextField();
        food_list_a_panel.add( search_field_a, cc.xy( 2, 2 ) );
        food_list_a_panel.add( scrollPaneA, cc.xyw( 1, 4, 2 ) );
        food_list_b_panel.setLayout( layout03 );
        JScrollPane scrollPaneB = new JScrollPane( list_food_compare_b );
        scrollPaneB.setBorder( new TitledBorder( "Food B" ) );
        JLabel label_b = new JLabel( "Search: " );
        food_list_b_panel.add( label_b, cc.xy( 1, 2 ) );
        JTextField search_field_b = new JTextField();
        food_list_b_panel.add( search_field_b, cc.xy( 2, 2 ) );
        food_list_b_panel.add( scrollPaneB, cc.xyw( 1, 4, 2 ) );
        panel.setLayout( layout );
        panel.add( food_list_a_panel, cc.xywh( 2, 1, 1, 2 ) );
        panel.add( food_list_b_panel, cc.xywh( 4, 1, 1, 2 ) );
        search_panel.setLayout( layout02 );
        search_label.setHorizontalAlignment( JLabel.RIGHT );
        search_panel.add( search_label, cc.xy( 1, 2 ) );
        search_panel.add( search_field, cc.xy( 2, 2 ) );
        panel.add( search_panel, cc.xy( 6, 1 ) );
        panel.add( scrollPaneC, cc.xy( 6, 2 ) );
        scrollPaneC.setBorder( new TitledBorder( "Food Difference" ) );
        list_food_compare_a.addListSelectionListener( ( ListSelectionEvent e )
                -> {
            evt_lst_food_compare_a( e );
        } );
        list_food_compare_b.addListSelectionListener( ( ListSelectionEvent e )
                -> {
            evt_lst_food_compare_b( e );
        } );
        search_field_a.addActionListener( ( ActionEvent e )
                -> {
            evt_fld_search_a( e );
        } );
        search_field_b.addActionListener( ( ActionEvent e )
                -> {
            evt_fld_search_b( e );
        } );
        search_field.getDocument().addDocumentListener( new DocumentListener() {
            @Override
            public void changedUpdate( DocumentEvent e ) {
                food_comparison_search_filter();
            }

            @Override
            public void insertUpdate( DocumentEvent e ) {
                food_comparison_search_filter();
            }

            @Override
            public void removeUpdate( DocumentEvent e ) {
                food_comparison_search_filter();
            }

            private void food_comparison_search_filter() {
                RowFilter<TableModelMixComparison, Object> rf = null;
                try {
                    ArrayList filters = new ArrayList();
                    filters.add( RowFilter.regexFilter( "(?i)" + search_field.getText(), 0 ) );
                    filters.add( RowFilter.regexFilter( "(?i)" + search_field.getText(), 1 ) );
                    rf = RowFilter.orFilter( ( Iterable<? extends RowFilter<? super TableModelMixComparison, ? super Object>> ) filters );
                } catch( java.util.regex.PatternSyntaxException e ) {
                    return;
                }
                food_comparison_tablesorter.setRowFilter( rf );
            }

        } );
        list_food_compare_a.setModel( modelList_A_FoodDiff );
        list_food_compare_b.setModel( modelList_B_FoodDiff );
        table_food_comparison.setModel( model_for_food_difference_table );
        table_food_comparison.setSelectionMode( ListSelectionModel.SINGLE_SELECTION );
        table_food_comparison.setFillsViewportHeight( true );
        table_food_comparison.setRowSorter( food_comparison_tablesorter );
        modelList_A_FoodDiff.reload();
        modelList_B_FoodDiff.reload();
        resize_col_tbl_food_comparison();
        return panel;
    }

    private void evt_fld_search_a( ActionEvent e ) {
        modelList_A_FoodDiff.reload( (( JTextComponent ) e.getSource()).getText() );
    }

    private void evt_fld_search_b( ActionEvent e ) {
        modelList_B_FoodDiff.reload( (( JTextComponent ) e.getSource()).getText() );
    }

    private JTable get_table_rda_check() {
        JTable table;
        table = new JTable() {
            final Color offwhite = new Color( 190, 198, 204 );

            @Override
            public Component prepareRenderer( TableCellRenderer renderer, int rowIndex, int columnIndex ) {
                JComponent component = ( JComponent ) super.prepareRenderer( renderer, rowIndex, columnIndex );
                Double valueAt;
                switch( columnIndex ) {
                    case 0:

                        component.setForeground( offwhite );
                        break;
                    case 1:
                        component.setForeground( offwhite );
                        break;
                    case 2:
                        valueAt = ( Double ) getValueAt( rowIndex, columnIndex );
                        if( valueAt <= 0 ) {
                            component.setForeground( Color.red );
                        }
                        else {
                            component.setForeground( offwhite );
                        }
                        break;
                    case 3:
                        component.setForeground( offwhite );
                        break;
                    case 4:
                        valueAt = ( Double ) getValueAt( rowIndex, columnIndex );
                        if( valueAt < 100 && ( Double ) getValueAt( rowIndex, columnIndex - 1 ) > 0 ) {
                            component.setForeground( Color.red );
                        }
                        break;
                    case 5:
                        component.setForeground( offwhite );
                        break;
                    case 6:
                        valueAt = ( Double ) getValueAt( rowIndex, columnIndex );
                        if( valueAt > 100 ) {
                            component.setForeground( Color.red );
                        }
                        else {
                            component.setForeground( offwhite );
                        }
                        break;
                }
                return component;
            }
        };
        return table;
    }

    private JPanel get_mix_results_rda() {
        JPanel panel = new JPanel();
        tbl_results_rda = get_table_rda_check();
        JScrollPane scrollPaneRdaDiff = new JScrollPane( tbl_results_rda );
        CellConstraints cellc = new CellConstraints();
        FormLayout layout = new FormLayout(
                "min:grow", //columns
                "fill:min:grow" //rows
        );
        FormLayout layoutPanelRdaDiff = new FormLayout(
                "min, min:grow", //columns
                "5dlu,min,5dlu,fill:min:grow" //rows
        );
        JPanel panelRdaDiff = new JPanel();
        panelRdaDiff.setLayout( layoutPanelRdaDiff );
        panelRdaDiff.add( new JLabel( " Lifestage:" ), cellc.xy( 1, 2 ) );
        panelRdaDiff.add( cb_results_lifestage, cellc.xy( 2, 2 ) );
        panelRdaDiff.add( scrollPaneRdaDiff, cellc.xyw( 1, 4, 2 ) );
        panel.setLayout( layout );
        panel.add( panelRdaDiff, cellc.xy( 1, 1 ) );
        scrollPaneRdaDiff.setBorder( new TitledBorder( "RDA Check" ) );
        cb_results_lifestage.setModel( cbmdl_results_lifestage );
        tbl_results_rda.setModel( tblmdl_results_rda );
        tbl_results_rda.setSelectionMode( ListSelectionModel.SINGLE_SELECTION );
        tbl_results_rda.setFillsViewportHeight( true );
        tbl_results_rda.setTableHeader( new TableHeaderRdaDiff( tbl_results_rda.getColumnModel() ) );
        tbl_results_rda.setAutoCreateRowSorter( true );
        resize_col_tbl_results_rda();
        cb_results_lifestage.addActionListener( ( ActionEvent e )
                -> {
            evt_cb_results_lifestage();
        } );
        JPopupMenu popMenu = new JPopupMenu();
        JMenuItem item_01 = new JMenuItem( "Find nutrient containing foods" );
        JMenuItem item_02 = new JMenuItem( "Go to vitamins" );
        JMenuItem item_03 = new JMenuItem( "Go to minerals" );
        JMenuItem item_04 = new JMenuItem( "Go to electrolytes" );
        popMenu.add( item_01 );
        popMenu.add( item_02 );
        popMenu.add( item_03 );
        popMenu.add( item_04 );
        item_01.addActionListener( ( ActionEvent e )
                -> {
            evt_mnui_results_nutrient_lookup();
        } );
        item_02.addActionListener( ( ActionEvent e )
                -> {
            results_tabbed_pane.setSelectedIndex( 4 );
        } );
        item_03.addActionListener( ( ActionEvent e )
                -> {
            results_tabbed_pane.setSelectedIndex( 5 );
        } );
        item_04.addActionListener( ( ActionEvent e )
                -> {
            results_tabbed_pane.setSelectedIndex( 6 );
        } );
        tbl_results_rda.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked( MouseEvent e ) {
                super.mouseClicked( e );
                evt_lst_mixes( e, popMenu );
            }
        } );
        return panel;
    }

    private JPanel get_mix_journal_rda() {
        JPanel panel = new JPanel();
        tbl_journal_rda = get_table_rda_check();
        JScrollPane scrollPaneRdaDiff = new JScrollPane( tbl_journal_rda );
        CellConstraints cellc = new CellConstraints();
        FormLayout layout = new FormLayout(
                "min:grow", //columns
                "fill:min:grow" //rows
        );
        FormLayout layoutPanelRdaDiff = new FormLayout(
                "min, min:grow", //columns
                "5dlu,min,5dlu,fill:min:grow" //rows
        );
        JPanel panelRdaDiff = new JPanel();
        panelRdaDiff.setLayout( layoutPanelRdaDiff );
        panelRdaDiff.add( new JLabel( " Lifestage:" ), cellc.xy( 1, 2 ) );
        panelRdaDiff.add( cb_journal_lifestage, cellc.xy( 2, 2 ) );
        panelRdaDiff.add( scrollPaneRdaDiff, cellc.xyw( 1, 4, 2 ) );
        panel.setLayout( layout );
        panel.add( panelRdaDiff, cellc.xy( 1, 1 ) );
        scrollPaneRdaDiff.setBorder( new TitledBorder( "RDA Check" ) );
        cb_journal_lifestage.setModel( cbmdl_journal_lifestage );
        tbl_journal_rda.setModel( tblmdl_journal_rda );
        tbl_journal_rda.setSelectionMode( ListSelectionModel.SINGLE_SELECTION );
        tbl_journal_rda.setFillsViewportHeight( true );
        tbl_journal_rda.setTableHeader( new TableHeaderRdaDiff( tbl_journal_rda.getColumnModel() ) );
        tbl_journal_rda.setAutoCreateRowSorter( true );
        resize_col_tbl_journal_rda();
        cb_journal_lifestage.addActionListener( ( ActionEvent e )
                -> {
            evt_cb_journal_lifestage();
        } );
        JPopupMenu popMenu = new JPopupMenu();
        JMenuItem item_01 = new JMenuItem( "Find nutrient containing foods" );
        JMenuItem item_02 = new JMenuItem( "Go to vitamins" );
        JMenuItem item_03 = new JMenuItem( "Go to minerals" );
        JMenuItem item_04 = new JMenuItem( "Go to electrolytes" );
        popMenu.add( item_01 );
        popMenu.add( item_02 );
        popMenu.add( item_03 );
        popMenu.add( item_04 );
        item_01.addActionListener( ( ActionEvent e )
                -> {
            evt_mnui_journal_nutrient_lookup();
        } );
        item_02.addActionListener( ( ActionEvent e )
                -> {
            journal_results_tabbed_pane.setSelectedIndex( 4 );
        } );
        item_03.addActionListener( ( ActionEvent e )
                -> {
            journal_results_tabbed_pane.setSelectedIndex( 5 );
        } );
        item_04.addActionListener( ( ActionEvent e )
                -> {
            journal_results_tabbed_pane.setSelectedIndex( 6 );
        } );
        tbl_journal_rda.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked( MouseEvent e ) {
                super.mouseClicked( e );
                evt_lst_mixes( e, popMenu );
            }
        } );
        return panel;
    }

    private void evt_mnui_results_nutrient_lookup() {
        int selectedRowNo = tbl_results_rda.getSelectedRow();
        if( selectedRowNo != -1 ) {
            String nutrientid = ( String ) tbl_results_rda.getValueAt( selectedRowNo, 0 );
            String nutrient = ( String ) tbl_results_rda.getValueAt( selectedRowNo, 1 );
            Double rda = ( Double ) tbl_results_rda.getValueAt( selectedRowNo, 3 );
            textFieldNutrientLookup.setText( String.valueOf( rda ) );
            NutrientDataObject nutrientDataObject = new NutrientDataObject( nutrientid, nutrient, null );
            modelComboBox_NutrientLookupListNutrient.setSelectedItem( nutrientDataObject );
            modelTableNutrientLookup.reload( nutrientid, rda );
            resize_col_tbl_nutrient_lookup();
            main_tabbed_pane.setSelectedIndex( 6 );
        }
        else {
            Message.showMessage( "Please select nutrient" );
        }
    }

    private void evt_mnui_journal_nutrient_lookup() {
        int selectedRowNo = tbl_journal_rda.getSelectedRow();
        if( selectedRowNo != -1 ) {
            String nutrientid = ( String ) tbl_journal_rda.getValueAt( selectedRowNo, 0 );
            String nutrient = ( String ) tbl_journal_rda.getValueAt( selectedRowNo, 1 );
            Double rda = ( Double ) tbl_journal_rda.getValueAt( selectedRowNo, 3 );
            textFieldNutrientLookup.setText( String.valueOf( rda ) );
            NutrientDataObject nutrientDataObject = new NutrientDataObject( nutrientid, nutrient, null );
            modelComboBox_NutrientLookupListNutrient.setSelectedItem( nutrientDataObject );
            modelTableNutrientLookup.reload( nutrientid, rda );
            resize_col_tbl_nutrient_lookup();
            main_tabbed_pane.setSelectedIndex( 6 );
        }
        else {
            Message.showMessage( "Please select nutrient" );
        }
    }

    private void evt_cb_results_lifestage() {
        reload_results_rda_check();
    }

    private void reload_results_rda_check() {
        if( is_mix_selected() ) {
            MixDataObject mixDataObject = ( MixDataObject ) lst_mix.getSelectedValue();
            RdaLifeStageDataObject rdaLifeStageDataObject = ( RdaLifeStageDataObject ) cb_results_lifestage.getSelectedItem();
            tblmdl_results_rda.reload( mixDataObject.getMixId(), rdaLifeStageDataObject.getLifeStageId() );
            resize_col_tbl_results_rda();
        }
    }

    private void evt_cb_journal_lifestage() {
        reload_journal_rda_check();
    }

    private void reload_journal_rda_check() {
        if( is_mix_journal_selected() ) {
            MixDataObject mixDataObject = ( MixDataObject ) list_journal_mix.getSelectedValue();
            RdaLifeStageDataObject rdaLifeStageDataObject = ( RdaLifeStageDataObject ) cb_journal_lifestage.getSelectedItem();
            tblmdl_journal_rda.reload( mixDataObject.getMixId(), rdaLifeStageDataObject.getLifeStageId() );
            resize_col_tbl_journal_rda();
        }
    }

    private JPanel get_meal_allocation() {
        JPanel panel = new JPanel();
        FormLayout panelLayout = new FormLayout(
                "10px,60px,50px,155px,50px,53px,420px,60px,171px,10px", //columns
                "10px,fill:25px,10px,p,100px,10px,fill:p:grow,p" //rows
        );
        JScrollPane scroll_pane = new JScrollPane( listAllocationMeal );
        textfield_allocation_remaining.setPreferredSize( new Dimension( 100, 25 ) );
        textfield_allocation_pct.setPreferredSize( new Dimension( 100, 25 ) );
        comboBoxAllocationFood.setPreferredSize( new Dimension( 100, 25 ) );
        scroll_pane.setPreferredSize( new Dimension( 100, 100 ) );
        panel.setLayout( panelLayout );
        JScrollPane spTable = new JScrollPane( table_allocation );
        JPanel buttons = new JPanel();
        textfield_allocation_remaining.setEditable( false );
        JLabel label_search = new JLabel( "Search: " );
        label_search.setHorizontalAlignment( JLabel.RIGHT );
        //first row
        panel.add( label_search, cc.xy( 6, 2 ) );
        panel.add( textfield_allocation_search, cc.xyw( 7, 2, 3 ) );
        //second row
        JLabel label01 = new JLabel( "Out of" );
        label01.setHorizontalAlignment( JLabel.CENTER );
        panel.add( label01, cc.xy( 2, 4 ) );
        panel.add( textfield_allocation_remaining, cc.xy( 3, 4 ) );
        JLabel label02 = new JLabel( "% remaining, allocate" );
        label02.setHorizontalAlignment( JLabel.CENTER );
        panel.add( label02, cc.xy( 4, 4 ) );
        panel.add( textfield_allocation_pct, cc.xy( 5, 4 ) );
        JLabel label03 = new JLabel( "% of" );
        label03.setHorizontalAlignment( JLabel.CENTER );
        panel.add( label03, cc.xy( 6, 4 ) );
        panel.add( comboBoxAllocationFood, cc.xy( 7, 4 ) );
        JLabel label04 = new JLabel( "to meal" );
        label04.setHorizontalAlignment( JLabel.CENTER );
        panel.add( label04, cc.xy( 8, 4 ) );
        panel.add( scroll_pane, cc.xywh( 9, 4, 1, 2 ) );
        //third row
        panel.add( spTable, cc.xyw( 2, 7, 8 ) );
        buttons.add( buttonAllocationAdd );
        buttons.add( buttonAllocationDelete );
        buttons.add( buttonAllocationUpdatePct );
        buttons.add( buttonAllocationUpdateWeight );
        //fourth row
        panel.add( buttons, cc.xyw( 2, 8, 8 ) );
        spTable.setBorder( new TitledBorder( "Meal Plan" ) );
        comboBoxAllocationMeal.setMaximumRowCount( 6 );
        comboBoxAllocationMeal.setModel( modelComboBox_AllocationMeal );
        listAllocationMeal.setModel( modelList_AllocationMeal );
        comboBoxAllocationFood.setMaximumRowCount( 6 );
        comboBoxAllocationFood.setModel( modelComboBox_AllocationFood );
        table_allocation.getTableHeader().setReorderingAllowed( false );
        table_allocation.setAutoCreateRowSorter( true );
        table_allocation.setModel( modelTableAllocation );
        table_allocation.setRowSorter( allocationlookup_tablesorter );
        table_allocation.setSelectionMode( ListSelectionModel.SINGLE_SELECTION );
        buttonAllocationAdd.setToolTipText( "Allocate Food" );
        buttonAllocationDelete.setToolTipText( "Delete Food Allocation" );
        buttonAllocationUpdatePct.setToolTipText( "Update Percentage" );
        buttonAllocationUpdateWeight.setToolTipText( "Update Actual Weight" );
        buttonAllocationAdd.addActionListener( ( ActionEvent e )
                -> {
            evt_btn_meal_food_allocation_add();
        } );
        buttonAllocationDelete.addActionListener( ( ActionEvent e )
                -> {
            evt_btn_meal_food_allocation_delete();
        } );
        buttonAllocationUpdatePct.addActionListener( ( ActionEvent e )
                -> {
            evt_btn_meal_food_allocation_update_pct();
        } );
        buttonAllocationUpdateWeight.addActionListener( ( ActionEvent e )
                -> {
            evt_btn_meal_food_allocation_update_weight();
        } );
        comboBoxAllocationFood.addActionListener(( ActionEvent e )
                -> {
            evt_cb_meal_food_allocation();
        } );
        table_allocation.setFillsViewportHeight( true );
        textfield_allocation_search.getDocument().addDocumentListener( new DocumentListener() {
            @Override
            public void changedUpdate( DocumentEvent e ) {
                allocationlookup_search_filter();
            }

            @Override
            public void insertUpdate( DocumentEvent e ) {
                allocationlookup_search_filter();
            }

            @Override
            public void removeUpdate( DocumentEvent e ) {
                allocationlookup_search_filter();
            }

            private void allocationlookup_search_filter() {
                RowFilter<TableModelAllocation, Object> rf = null;
                try {
                    ArrayList filters = new ArrayList();
                    filters.add( RowFilter.regexFilter( "(?i)" + textfield_allocation_search.getText(), 3 ) );
                    filters.add( RowFilter.regexFilter( "(?i)" + textfield_allocation_search.getText(), 4 ) );
                    rf = RowFilter.orFilter( ( Iterable<? extends RowFilter<? super TableModelAllocation, ? super Object>> ) filters );
                } catch( java.util.regex.PatternSyntaxException e ) {
                    return;
                }
                allocationlookup_tablesorter.setRowFilter( rf );
            }

        } );

        return panel;
    }

    private JPanel get_meal() {
        JPanel panel = new JPanel();
        FormLayout panelLayout = new FormLayout(
                "10px,391px:grow,10px", //columns
                "10px,fill:p:grow,p" //rows
        );
        panel.setLayout( panelLayout );
        JScrollPane spTable = new JScrollPane( table_meals );
        JPanel buttons = new JPanel();
        panel.add( spTable, cc.xy( 2, 2 ) );
        buttons.add( buttonMealAdd );
        buttons.add( buttonMealDelete );
        buttons.add( buttonMealUpdate );
        panel.add( buttons, cc.xy( 2, 3 ) );
        spTable.setBorder( new TitledBorder( "Meals" ) );
        table_meals.getTableHeader().setReorderingAllowed( false );
        table_meals.setAutoCreateRowSorter( true );
        table_meals.setModel( modelTableMeals );
        table_meals.setSelectionMode( ListSelectionModel.SINGLE_SELECTION );
        buttonMealAdd.setToolTipText( "Add Meal" );
        buttonMealDelete.setToolTipText( "Delete Meal" );
        buttonMealUpdate.setToolTipText( "Update Meal" );
        buttonMealAdd.addActionListener(( ActionEvent e )
                -> {
            evt_btn_meal_add();
        } );
        buttonMealDelete.addActionListener(( ActionEvent e )
                -> {
            evt_btn_meal_delete();
        } );
        buttonMealUpdate.addActionListener(( ActionEvent e )
                -> {
            evt_btn_meal_update();
        } );
        table_meals.setFillsViewportHeight( true );
        return panel;
    }

    private JPanel get_mix_journal() {
        JPanel panel = new JPanel();
        FormLayout layout = new FormLayout(
                "4dlu,208dlu,4dlu,min:grow,4dlu", //columns
                "4dlu,fill:min:grow,4dlu" //rows
        );
        panel.setLayout( layout );
        JPanel leftComponent = new JPanel();
        FormLayout leftLayout = new FormLayout(
                "min:grow", //columns
                "fill:min:grow,4dlu,min,4dlu" //rows
        );
        leftComponent.setLayout( leftLayout );
        JPanel buttons = new JPanel();
        FormLayout buttonsLayout = new FormLayout(
                "min:grow,min,min,min:grow", //columns
                "min" //rows
        );
        buttons.setLayout( buttonsLayout );
        JButton btn_duplicate_journal_mix = new JButton( "d" );
        JButton btn_edit_journal_mix = new JButton( "e" );
        btn_duplicate_journal_mix.setToolTipText( "Duplicate mix and edit in 'Solve' area" );
        btn_edit_journal_mix.setToolTipText( "Edit mix in 'Solve' area" );
        buttons.add( btn_duplicate_journal_mix, cc.xy( 2, 1 ) );
        buttons.add( btn_edit_journal_mix, cc.xy( 3, 1 ) );
        JScrollPane mixesJournalSp = new JScrollPane( list_journal_mix );
        mixesJournalSp.setBorder( new TitledBorder( "Mix" ) );
        leftComponent.add( mixesJournalSp, cc.xy( 1, 1 ) );
        leftComponent.add( buttons, cc.xy( 1, 3 ) );
        journal_results_tabbed_pane.setBorder( new TitledBorder( "Mix Results" ) );
        journal_results_tabbed_pane.setTabPlacement( JTabbedPane.BOTTOM );
        journal_results_tabbed_pane.add( get_energy_journal() );
        journal_results_tabbed_pane.add( get_protein_journal() );
        journal_results_tabbed_pane.add( get_fats_journal() );
        journal_results_tabbed_pane.add( get_carbs_journal() );
        journal_results_tabbed_pane.add( get_vitamins_journal() );
        journal_results_tabbed_pane.add( get_minerals_journal() );
        journal_results_tabbed_pane.add( get_electrolytes_journal() );
        journal_results_tabbed_pane.add( get_water_journal() );
        journal_results_tabbed_pane.add( get_cost_journal() );
        journal_results_tabbed_pane.add( get_glycemic_journal() );
        journal_results_tabbed_pane.add( get_journal_model() );
        journal_results_tabbed_pane.add( get_mix_journal_rda() );
        journal_results_tabbed_pane.setTitleAt( 0, "Energy" );
        journal_results_tabbed_pane.setTitleAt( 1, "Protein" );
        journal_results_tabbed_pane.setTitleAt( 2, "Fats" );
        journal_results_tabbed_pane.setTitleAt( 3, "Carbohydrates" );
        journal_results_tabbed_pane.setTitleAt( 4, "Vitamins" );
        journal_results_tabbed_pane.setTitleAt( 5, "Minerals" );
        journal_results_tabbed_pane.setTitleAt( 6, "Electrolytes" );
        journal_results_tabbed_pane.setTitleAt( 7, "Water" );
        journal_results_tabbed_pane.setTitleAt( 8, "Cost" );
        journal_results_tabbed_pane.setTitleAt( 9, "Glycemic" );
        journal_results_tabbed_pane.setTitleAt( 10, "Model" );
        journal_results_tabbed_pane.setTitleAt( 11, "Rda" );
        panel.add( leftComponent, cc.xy( 2, 2 ) );
        JTabbedPane journal_tabs = new JTabbedPane();
        journal_tabs.add( "Results", journal_results_tabbed_pane );
        journal_tabs.add( "Meal Plan", get_meal_allocation() );
        journal_tabs.add( "Meals", get_meal() );
        panel.add( journal_tabs, cc.xy( 4, 2 ) );
        list_journal_mix.addListSelectionListener( e -> evt_lst_mixes_journal( e ) );
        list_journal_mix.setModel( modelListFoodJournal );
        modelListFoodJournal.reload();
        btn_edit_journal_mix.addActionListener( e -> evt_btn_journal_mix_edit() );
        btn_duplicate_journal_mix.addActionListener( e -> evt_btn_journal_mix_duplicate() );
        return panel;
    }

    private void evt_lst_mixes_journal( ListSelectionEvent e ) {
        if( !e.getValueIsAdjusting() ) {
            frm_snack.setCursor( Cursor.getPredefinedCursor( Cursor.WAIT_CURSOR ) );
            reload_journal_table_models();
            frm_snack.setCursor( Cursor.getPredefinedCursor( Cursor.DEFAULT_CURSOR ) );
        }
    }

    private void reload_journal_table_models() {
        if( is_mix_journal_selected() ) {
            MixDataObject mixDataObject = ( MixDataObject ) list_journal_mix.getSelectedValue();
            String mixId = mixDataObject.getMixId();
            String model = mixDataObject.getModel();
            result_loader_journal.reload( mixId );
            modelTableJournalEnergy.set_table( result_loader_journal.get_energy_table() );
            tableJournalEnergy.getColumnModel().getColumn( 0 ).setMinWidth( 400 );
            tableJournalEnergy.getColumnModel().getColumn( 0 ).setMaxWidth( 400 );
            for( int i = 1; i < 12; i++ ) {
                tableJournalEnergy.getColumnModel().getColumn( i ).setMinWidth( 70 );
                tableJournalEnergy.getColumnModel().getColumn( i ).setMaxWidth( 70 );
            }
            modelTableJournalProtein.set_table( result_loader_journal.get_protein_table() );
            tableJournalProtein.getColumnModel().getColumn( 0 ).setMinWidth( 400 );
            tableJournalProtein.getColumnModel().getColumn( 0 ).setMaxWidth( 400 );
            for( int i = 1; i < 5; i++ ) {
                tableJournalProtein.getColumnModel().getColumn( i ).setMinWidth( 70 );
                tableJournalProtein.getColumnModel().getColumn( i ).setMaxWidth( 70 );
            }
            modelTableJournalFats.set_table( result_loader_journal.get_fats_table() );
            tableJournalFats.getColumnModel().getColumn( 0 ).setMinWidth( 400 );
            tableJournalFats.getColumnModel().getColumn( 0 ).setMaxWidth( 400 );
            for( int i = 1; i < 12; i++ ) {
                tableJournalFats.getColumnModel().getColumn( i ).setMinWidth( 70 );
                tableJournalFats.getColumnModel().getColumn( i ).setMaxWidth( 70 );
            }
            modelTableJournalCarbs.set_table( result_loader_journal.get_carbs_table() );
            tableJournalCarbs.getColumnModel().getColumn( 0 ).setMinWidth( 400 );
            tableJournalCarbs.getColumnModel().getColumn( 0 ).setMaxWidth( 400 );
            for( int i = 1; i < 6; i++ ) {
                tableJournalCarbs.getColumnModel().getColumn( i ).setMinWidth( 70 );
                tableJournalCarbs.getColumnModel().getColumn( i ).setMaxWidth( 70 );
            }
            modelTableJournalVitamins.set_table( result_loader_journal.get_vitamins_table() );
            tableJournalVitamins.getColumnModel().getColumn( 0 ).setMinWidth( 400 );
            tableJournalVitamins.getColumnModel().getColumn( 0 ).setMaxWidth( 400 );
            for( int i = 1; i < 15; i++ ) {
                tableJournalVitamins.getColumnModel().getColumn( i ).setMinWidth( 70 );
                tableJournalVitamins.getColumnModel().getColumn( i ).setMaxWidth( 70 );
            }
            modelTableJournalMinerals.set_table( result_loader_journal.get_minerals_table() );
            tableJournalMinerals.getColumnModel().getColumn( 0 ).setMinWidth( 400 );
            tableJournalMinerals.getColumnModel().getColumn( 0 ).setMaxWidth( 400 );
            for( int i = 1; i < 10; i++ ) {
                tableJournalMinerals.getColumnModel().getColumn( i ).setMinWidth( 70 );
                tableJournalMinerals.getColumnModel().getColumn( i ).setMaxWidth( 70 );
            }
            modelTableJournalElectrolytes.set_table( result_loader_journal.get_electrolytes_table() );
            tableJournalElectrolytes.getColumnModel().getColumn( 0 ).setMinWidth( 400 );
            tableJournalElectrolytes.getColumnModel().getColumn( 0 ).setMaxWidth( 400 );
            for( int i = 1; i < 4; i++ ) {
                tableJournalElectrolytes.getColumnModel().getColumn( i ).setMinWidth( 70 );
                tableJournalElectrolytes.getColumnModel().getColumn( i ).setMaxWidth( 70 );
            }
            modelTableJournalWater.set_table( result_loader_journal.get_water_table() );
            tableJournalWater.getColumnModel().getColumn( 0 ).setMinWidth( 400 );
            tableJournalWater.getColumnModel().getColumn( 0 ).setMaxWidth( 400 );
            for( int i = 1; i < 3; i++ ) {
                tableJournalWater.getColumnModel().getColumn( i ).setMinWidth( 70 );
                tableJournalWater.getColumnModel().getColumn( i ).setMaxWidth( 70 );
            }
            modelTableJournalCost.set_table( result_loader_journal.get_cost_table() );
            tableJournalCost.getColumnModel().getColumn( 0 ).setMinWidth( 400 );
            tableJournalCost.getColumnModel().getColumn( 0 ).setMaxWidth( 400 );
            for( int i = 1; i < 3; i++ ) {
                tableJournalCost.getColumnModel().getColumn( i ).setMinWidth( 70 );
                tableJournalCost.getColumnModel().getColumn( i ).setMaxWidth( 70 );
            }
            modelTableJournalGlycemic.reload( mixId );
            tableJournalGlycemic.getColumnModel().getColumn( 0 ).setMinWidth( 400 );
            tableJournalGlycemic.getColumnModel().getColumn( 0 ).setMaxWidth( 400 );
            for( int i = 1; i < 8; i++ ) {
                tableJournalGlycemic.getColumnModel().getColumn( i ).setMinWidth( 70 );
                tableJournalGlycemic.getColumnModel().getColumn( i ).setMaxWidth( 70 );
            }
            textAreaJournalModel.setText( model );
            reload_journal_rda_check();
            reload_allocation_meal_cb();
            reload_allocation_food_cb();
            reload_meals_tbl();
            reload_allocation_tbl();
            resize_col_tbl_meal();
            resize_col_tbl_meal_allocation();
        }
    }

    private void reload_allocation_tbl() {
        if( is_mix_journal_selected() ) {
            MixDataObject mixDataObject = ( MixDataObject ) list_journal_mix.getSelectedValue();
            modelTableAllocation.reload( mixDataObject.getMixId(), precision );
        }
    }

    private void reload_meals_tbl() {
        if( is_mix_journal_selected() ) {
            MixDataObject mixDataObject = ( MixDataObject ) list_journal_mix.getSelectedValue();
            modelTableMeals.reload( mixDataObject.getMixId() );
        }
    }

    private void reload_allocation_food_cb() {
        if( is_mix_journal_selected() ) {
            MixDataObject mixDataObject = ( MixDataObject ) list_journal_mix.getSelectedValue();
            modelComboBox_AllocationFood.reload( mixDataObject.getMixId() );
        }
    }

    private void reload_allocation_meal_cb() {
        if( is_mix_journal_selected() ) {
            MixDataObject mixDataObject = ( MixDataObject ) list_journal_mix.getSelectedValue();
            modelComboBox_AllocationMeal.reload( mixDataObject.getMixId() );
            modelList_AllocationMeal.reload( mixDataObject.getMixId() );
        }
    }

    private void resize_col_tbl_meal() {
        table_meals.getColumnModel().getColumn( 0 ).setMinWidth( 0 );
        table_meals.getColumnModel().getColumn( 0 ).setMaxWidth( 0 );
        table_meals.getColumnModel().getColumn( 1 ).setMinWidth( 0 );
        table_meals.getColumnModel().getColumn( 1 ).setMaxWidth( 0 );
        table_meals.getColumnModel().getColumn( 2 ).setMinWidth( 900 );
    }

    private void resize_col_tbl_meal_allocation() {
        table_allocation.getColumnModel().getColumn( 0 ).setMinWidth( 0 );
        table_allocation.getColumnModel().getColumn( 0 ).setMaxWidth( 0 );
        table_allocation.getColumnModel().getColumn( 1 ).setMinWidth( 0 );
        table_allocation.getColumnModel().getColumn( 1 ).setMaxWidth( 0 );
        table_allocation.getColumnModel().getColumn( 2 ).setMinWidth( 0 );
        table_allocation.getColumnModel().getColumn( 2 ).setMaxWidth( 0 );
        table_allocation.getColumnModel().getColumn( 4 ).setMinWidth( 600 );
    }

    private void evt_btn_journal_mix_edit() {
        if( is_mix_journal_selected() ) {
            JComponent[] inputs = new JComponent[] {
                new JLabel( "Would you like to edit mix?" )
            };
            int optionValue = Message.showOptionDialogOkCancel( inputs, "Edit Mix" );
            if( optionValue == 0 ) {
                try {
                    MixDataObject mix = ( MixDataObject ) list_journal_mix.getSelectedValue();
                    String mixId = mix.getMixId();
                    dbLink.Mix_Update_Status( mixId, 1 );
                    dbLink.stopTransaction();
                    modelList_Solve.reload();
                    modelListFoodJournal.reload();
                    clear_model_journal();
                    clear_model_meal_plan();
                    int index = modelList_Solve.find_by_mixid( mixId );
                    lst_mix.setSelectedIndex( index );
                } catch( SQLException e ) {

                }
            }
        }
    }

    private void clear_model_meal_plan() {
        modelTableMeals.setRowCount( 0 );
        modelTableAllocation.setRowCount( 0 );
        comboBoxAllocationFood.removeAllItems();
        comboBoxAllocationMeal.removeAllItems();
    }

    private void evt_btn_journal_mix_duplicate() {
        if( is_mix_journal_selected() ) {
            JComponent[] inputs = new JComponent[] {
                new JLabel( "Would you like to copy and edit mix?" )
            };
            int optionValue = Message.showOptionDialogOkCancel( inputs, "Duplicate and Edit Mix" );
            if( optionValue == 0 ) {
                try {
                    MixDataObject mix = ( MixDataObject ) list_journal_mix.getSelectedValue();
                    String mixId = mix.getMixId();
                    dbLink.Mix_Duplicate( mixId );
                    dbLink.stopTransaction();
                    reload_mixes();
                    int index = modelList_Solve.find_by_mixid( mix.getMixId() );
                    list_journal_mix.setSelectedIndex( index );
                } catch( SQLException e ) {

                }
            }
        }
        else {
            Message.showMessage( "Select mix." );
        }
    }

    private void food_search_filter() {
        RowFilter<TableModelFoodList, Object> rf = null;
        try {
            ArrayList filters = new ArrayList();
            filters.add( RowFilter.regexFilter( "(?i)" + textFieldFoodListSearch.getText(), 1 ) );
            filters.add( RowFilter.regexFilter( "(?i)" + textFieldFoodListSearch.getText(), 2 ) );
            rf = RowFilter.orFilter( ( Iterable<? extends RowFilter<? super TableModelFoodList, ? super Object>> ) filters );
        } catch( java.util.regex.PatternSyntaxException e ) {

            return;
        }
        foodlist_tablesorter.setRowFilter( rf );
    }

    private JPanel get_food_list() {
        JPanel panel = new JPanel();
        FormLayout paneLayout = new FormLayout(
                "4dlu,min:grow,4dlu", //columns
                "min,fill:min:grow,4dlu,min,4dlu" //rows
        );
        panel.setLayout( paneLayout );
        JPanel searchPanel = new JPanel();
        FormLayout searchPanelLayout = new FormLayout(
                "min,min:grow", //columns
                "4dlu,fill:16dlu,4dlu" //rows
        );
        searchPanel.setLayout( searchPanelLayout );
        JPanel buttonPanel = new JPanel();
        FormLayout buttonPanelLayout = new FormLayout(
                "min:grow,min,min,min,min,min:grow", //columns
                "min" //rows
        );
        buttonPanel.setLayout( buttonPanelLayout );
        JScrollPane scrollPaneTable01 = new JScrollPane( tableFoodList01 );
        searchPanel.add( new JLabel( "Search: " ), cc.xy( 1, 2 ) );
        searchPanel.add( textFieldFoodListSearch, cc.xy( 2, 2 ) );
        buttonPanel.add( buttonFoodListAdd, cc.xy( 2, 1 ) );
        buttonPanel.add( buttonFoodListDelete, cc.xy( 3, 1 ) );
        buttonPanel.add( buttonFoodListUpdate, cc.xy( 4, 1 ) );
        buttonPanel.add( buttonFoodListDuplicate, cc.xy( 5, 1 ) );
        panel.add( searchPanel, cc.xy( 2, 1 ) );
        panel.add( scrollPaneTable01, cc.xy( 2, 2 ) );
        panel.add( buttonPanel, cc.xy( 2, 4 ) );
        scrollPaneTable01.setBorder( new TitledBorder( "Food List" ) );
        buttonFoodListAdd.setToolTipText( "Add food item" );
        buttonFoodListUpdate.setToolTipText( "Update food item" );
        buttonFoodListDelete.setToolTipText( "Delete food item" );
        buttonFoodListDuplicate.setToolTipText( "Duplicate food item" );
        buttonFoodListAdd.addActionListener( ( ActionEvent e )
                -> {
            evt_btn_food_list_add();
        } );
        buttonFoodListDelete.addActionListener( ( ActionEvent e )
                -> {
            evt_btn_food_list_delete();
        } );
        buttonFoodListUpdate.addActionListener( ( ActionEvent e )
                -> {
            evt_btn_food_list_update();
        } );
        buttonFoodListDuplicate.addActionListener( ( ActionEvent e )
                -> {
            evt_btn_food_list_duplicate();
        } );
        textFieldFoodListSearch.getDocument().addDocumentListener( new DocumentListener() {
            @Override
            public void changedUpdate( DocumentEvent e ) {
                food_search_filter();
            }

            @Override
            public void insertUpdate( DocumentEvent e ) {
                food_search_filter();
            }

            @Override
            public void removeUpdate( DocumentEvent e ) {
                food_search_filter();
            }
        } );
        tableFoodList01.setTableHeader( new TableHeaderFoodList( tableFoodList01.getColumnModel() ) );
        tableFoodList01.setRowSorter( foodlist_tablesorter );
        tableFoodList01.setModel( modelTableFoodList );
        tableFoodList01.setSelectionMode( ListSelectionModel.SINGLE_SELECTION );
        tableFoodList01.setFillsViewportHeight( true );
        tableFoodList01.setAutoResizeMode( JTable.AUTO_RESIZE_OFF );
        reload_food_items();
        JPopupMenu popMenu = new JPopupMenu();
        JMenuItem item = new JMenuItem( "Check coefficients" );
        popMenu.add( item );
        item.addActionListener( ( ActionEvent e )
                -> {
            int selectedRowNo = tableFoodList01.getSelectedRow();
            if( selectedRowNo != -1 ) {
                check_coefficients( ( String ) tableFoodList01.getValueAt( selectedRowNo, 0 ) );
            }
            else {
                Message.showMessage( "Please select food item" );
            }
        } );
        tableFoodList01.addMouseListener( new MouseAdapter() {
            @Override
            public void mouseClicked( MouseEvent e ) {
                super.mouseClicked( e );
                if( (e.getModifiers() & InputEvent.BUTTON3_MASK) != 0 ) {
                    Component component = e.getComponent();
                    popMenu.show( component, e.getX(), e.getY() );
                }
            }
        } );
        return panel;
    }

    private void evt_btn_food_list_duplicate() {
        int selectedRowNo = tableFoodList01.getSelectedRow();
        if( selectedRowNo != -1 ) {
            String foodId = ( String ) tableFoodList01.getValueAt( selectedRowNo, 0 );
            duplicate_food_item( foodId );
        }
    }

    private void filter_search_nutrient_coefficient_check() {
        RowFilter<TableModelCheckCoefficients, Object> rf = null;
        try {
            ArrayList filters = new ArrayList();
            filters.add( RowFilter.regexFilter( "(?i)" + textFieldNutrientSearchCheckCoefficients.getText(), 1 ) );
            filters.add( RowFilter.regexFilter( "(?i)" + textFieldNutrientSearchCheckCoefficients.getText(), 2 ) );
            rf = RowFilter.orFilter( ( Iterable<? extends RowFilter<? super TableModelCheckCoefficients, ? super Object>> ) filters );
        } catch( java.util.regex.PatternSyntaxException e ) {

            return;
        }
        tableSorterCheckCoefficients.setRowFilter( rf );
    }

    private void check_coefficients( String foodId ) {
        tableCheckCoefficients.setRowSorter( tableSorterCheckCoefficients );
        tableCheckCoefficients.setModel( modelTableCheckCoefficients );
        tableCheckCoefficients.setFillsViewportHeight( true );
        modelTableCheckCoefficients.setPrecision( 5 );
        modelTableCheckCoefficients.reload( foodId );
        resize_col_tbl_check_coefficients();
        JPanel panel = new JPanel();
        JLabel labelFoodName = new JLabel( "Food Name:" );
        JLabel labelNutrientSearch = new JLabel( "Search:" );
        JTextField textFieldFoodName = new JTextField();
        JButton buttonPrevious = new JButton( "<" );
        JButton buttonNext = new JButton( ">" );
        labelFoodName.setHorizontalAlignment( JLabel.RIGHT );
        labelNutrientSearch.setHorizontalAlignment( JLabel.RIGHT );
        buttonPrevious.setToolTipText( "Go to previous row" );
        buttonNext.setToolTipText( "Go to next row" );
        FormLayout panelLayout = new FormLayout(
                "10px,310px,5px,200px,5px,min,min,min,10px", //columns
                "10px,min,min,min,5px,fill:min:grow,10px" //rows
        );
        panel.setPreferredSize( new Dimension( 700, GoldenRatio.getShortSide( 700 ) ) );
        panel.setLayout( panelLayout );
        panel.setBorder( new TitledBorder( "Nutritional Food Facts and Coefficients" ) );
        panel.add( labelFoodName, cc.xy( 2, 2 ) );
        panel.add( textFieldFoodName, cc.xyw( 4, 2, 5 ) );
        panel.add( labelNutrientSearch, cc.xy( 2, 3 ) );
        panel.add( textFieldNutrientSearchCheckCoefficients, cc.xyw( 4, 3, 2 ) );
        panel.add( buttonPrevious, cc.xy( 6, 3 ) );
        panel.add( buttonNext, cc.xy( 7, 3 ) );
        panel.add( new JScrollPane( tableCheckCoefficients ), cc.xyw( 2, 6, 7 ) );
        textFieldFoodName.setText( ( String ) tableFoodList01.getValueAt( tableFoodList01.getSelectedRow(), 1 ) );
        JComponent[] inputs = new JComponent[] {
            panel
        };
        tableCheckCoefficients.setRowSelectionInterval( 0, 0 );
        buttonNext.addActionListener( ( ActionEvent e )
                -> {
            int selectedRowNo = tableCheckCoefficients.getSelectedRow();
            if( selectedRowNo != tableCheckCoefficients.getRowCount() - 1 ) {
                selectedRowNo++;
                scroll_to_row_using_table( tableCheckCoefficients, selectedRowNo );
            }
            else {
                select_table_row_using_table( tableCheckCoefficients, selectedRowNo );
            }
        } );
        buttonPrevious.addActionListener( ( ActionEvent e )
                -> {
            int selectedRowNo = tableCheckCoefficients.getSelectedRow();
            if( selectedRowNo > 0 && selectedRowNo < tableCheckCoefficients.getRowCount() ) {
                selectedRowNo--;
                scroll_to_row_using_table( tableCheckCoefficients, selectedRowNo );
            }
            else {
                select_table_row_using_table( tableCheckCoefficients, 0 );
            }
        } );
        textFieldNutrientSearchCheckCoefficients.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void changedUpdate( DocumentEvent e ) {
                filter_search_nutrient_coefficient_check();
            }

            @Override
            public void insertUpdate( DocumentEvent e ) {
                filter_search_nutrient_coefficient_check();
            }

            @Override
            public void removeUpdate( DocumentEvent e ) {
                filter_search_nutrient_coefficient_check();
            }
        } );
        Message.showOptionDialog( inputs, "Check Coefficients" );
    }

    private void filter_search_nutrient() {
        RowFilter<TableModelDataInput, Object> rf = null;
        try {
            ArrayList filters = new ArrayList();
            filters.add( RowFilter.regexFilter( "(?i)" + textFieldNutrientSearch.getText(), 1 ) );
            filters.add( RowFilter.regexFilter( "(?i)" + textFieldNutrientSearch.getText(), 2 ) );
            rf = RowFilter.orFilter( ( Iterable<? extends RowFilter<? super TableModelDataInput, ? super Object>> ) filters );
        } catch( java.util.regex.PatternSyntaxException e ) {

            return;
        }
        nutrientinput_tablesorter.setRowFilter( rf );
    }

    private void evt_btn_fill_complete_protein_data() {
        JTextPane instructions = new JTextPane();
        JTextField fld_protein = new JTextField();
        JTextField fld_complete_protein = new JTextField();
        JLabel lbl_protein = new JLabel( "Protein (g): " );
        JLabel lbl_complete_protein = new JLabel( "Complete Protein (g): " );
        lbl_protein.setHorizontalAlignment( JLabel.RIGHT );
        lbl_complete_protein.setHorizontalAlignment( JLabel.RIGHT );
        StringBuilder sb = new StringBuilder();
        JPanel inputsPanel = new JPanel();
        JComponent[] inputs = new JComponent[] {
            inputsPanel
        };
        FormLayout layout = new FormLayout(
                "min:grow,min:grow", //columns
                "fill:min:grow,min,min" //rows
        );
        NumberCheck checkNumber = new NumberCheck();
        //model row index is specified by sql query.
        int model_column_index = 3;
        int model_row_index_protein = modelTableNutrientInput.find( "203" );
        int model_row_index_complete_protein = modelTableNutrientInput.find( "10001" );
        fld_protein.setText( String.valueOf( modelTableNutrientInput.getValueAt( model_row_index_protein, model_column_index ) ) );
        fld_complete_protein.setText( String.valueOf( modelTableNutrientInput.getValueAt( model_row_index_complete_protein, model_column_index ) ) );
        instructions.setEditable( false );
        sb.append( "* PROTEIN *\n\n" );
        sb.append( "Please enter protein quantity in grams." );
        instructions.setText( sb.toString() );
        inputsPanel.setPreferredSize( new Dimension( 350, GoldenRatio.getShortSide( 350 ) ) );
        inputsPanel.setLayout( layout );
        inputsPanel.add( new JScrollPane( instructions ), cc.xyw( 1, 1, 2 ) );
        inputsPanel.add( lbl_protein, cc.xy( 1, 2 ) );
        inputsPanel.add( fld_protein, cc.xy( 2, 2 ) );
        inputsPanel.add( lbl_complete_protein, cc.xy( 1, 3 ) );
        inputsPanel.add( fld_complete_protein, cc.xy( 2, 3 ) );
        int optionValue = Message.showOptionDialogOkCancel( inputs, "Protein" );
        if( optionValue == 0 ) {
            String s0 = fld_protein.getText();
            if( (s0 != null && s0.length() > 0) ) {
                checkNumber.addToUncheckedList( s0 );
                if( checkNumber.pass() ) {
                    Double val_protein = Double.valueOf( fld_protein.getText() );
                    Double val_complete_protein = Double.valueOf( fld_complete_protein.getText() );
                    //model row index is specified by sql query.
                    modelTableNutrientInput.setValueAt( val_protein, model_row_index_protein, model_column_index );
                    modelTableNutrientInput.setValueAt( val_complete_protein, model_row_index_complete_protein, model_column_index );
                    select_table_row_using_model( tableNutrientInput, model_row_index_protein );
                    scroll_to_row_using_model( tableNutrientInput, model_row_index_protein );
                }
                else {
                    Message.showMessage( "Numbers only" );
                }
            }
        }
    }

    private void evt_btn_fill_fat() {
        JTextPane instructions = new JTextPane();
        JTextField totalFatText = new JTextField();
        JTextField saturatedFatText = new JTextField();
        JTextField monounsaturatedFatText = new JTextField();
        JTextField polyunsaturatedFatText = new JTextField();
        StringBuilder sb = new StringBuilder();
        JPanel inputsPanel = new JPanel();
        JComponent[] inputs = new JComponent[] {
            inputsPanel
        };
        FormLayout layout = new FormLayout(
                "min:grow,min:grow", //columns
                "fill:min:grow,min,min,min,min" //rows
        );
        JLabel totalFatLabel = new JLabel( "Total Fat (g): " );
        JLabel saturatedFatLabel = new JLabel( "Saturated Fat (g): " );
        JLabel monounsaturatedFatLabel = new JLabel( "Monounsaturated Fat (g): " );
        JLabel polyunsaturatedFatLabel = new JLabel( "Polyunsaturated Fat (g): " );
        NumberCheck checkNumber = new NumberCheck();
        //model row index is specified by sql query.
        int model_column_index = 3;
        int model_row_index_mufa = modelTableNutrientInput.find( "645" );
        int model_row_index_pufa = modelTableNutrientInput.find( "646" );
        int model_row_index_sfa = modelTableNutrientInput.find( "606" );
        int model_row_index_fat = modelTableNutrientInput.find( "204" );
        monounsaturatedFatText.setText( String.valueOf( modelTableNutrientInput.getValueAt( model_row_index_mufa, model_column_index ) ) );
        polyunsaturatedFatText.setText( String.valueOf( modelTableNutrientInput.getValueAt( model_row_index_pufa, model_column_index ) ) );
        saturatedFatText.setText( String.valueOf( modelTableNutrientInput.getValueAt( model_row_index_sfa, model_column_index ) ) );
        totalFatText.setText( String.valueOf( modelTableNutrientInput.getValueAt( model_row_index_fat, model_column_index ) ) );
        instructions.setEditable( false );
        sb.append( "* FAT *\n\n" );
        sb.append( "Please enter fat quantities in grams" );
        instructions.setText( sb.toString() );
        inputsPanel.setPreferredSize( new Dimension( 350, GoldenRatio.getShortSide( 350 ) ) );
        inputsPanel.setLayout( layout );
        JScrollPane scrollPane = new JScrollPane( instructions );
        inputsPanel.add( scrollPane, cc.xyw( 1, 1, 2 ) );
        totalFatLabel.setHorizontalAlignment( JLabel.RIGHT );
        saturatedFatLabel.setHorizontalAlignment( JLabel.RIGHT );
        monounsaturatedFatLabel.setHorizontalAlignment( JLabel.RIGHT );
        polyunsaturatedFatLabel.setHorizontalAlignment( JLabel.RIGHT );
        inputsPanel.add( totalFatLabel, cc.xy( 1, 2 ) );
        inputsPanel.add( totalFatText, cc.xy( 2, 2 ) );
        inputsPanel.add( saturatedFatLabel, cc.xy( 1, 3 ) );
        inputsPanel.add( saturatedFatText, cc.xy( 2, 3 ) );
        inputsPanel.add( monounsaturatedFatLabel, cc.xy( 1, 4 ) );
        inputsPanel.add( monounsaturatedFatText, cc.xy( 2, 4 ) );
        inputsPanel.add( polyunsaturatedFatLabel, cc.xy( 1, 5 ) );
        inputsPanel.add( polyunsaturatedFatText, cc.xy( 2, 5 ) );
        SwingUtilities.invokeLater( ()
                -> {
            scrollPane.getViewport().setViewPosition( new Point( 0, 0 ) );
        } );
        int optionValue = Message.showOptionDialogOkCancel( inputs, "Fat" );
        if( optionValue == 0 ) {
            String s0 = totalFatText.getText();
            String s1 = saturatedFatText.getText();
            String s2 = monounsaturatedFatText.getText();
            String s3 = polyunsaturatedFatText.getText();
            if( (s0 != null && s0.length() > 0) && (s1 != null && s1.length() > 0) && (s2 != null && s2.length() > 0) && (s3 != null && s3.length() > 0) ) {
                checkNumber.addToUncheckedList( s0 );
                if( checkNumber.pass() ) {
                    Double totalFat = Double.valueOf( totalFatText.getText() );
                    Double saturatedFat = Double.valueOf( saturatedFatText.getText() );
                    Double monounsaturatedFat = Double.valueOf( monounsaturatedFatText.getText() );
                    Double polyunsaturatedFat = Double.valueOf( polyunsaturatedFatText.getText() );
                    //model row index is specified by sql query.
                    modelTableNutrientInput.setValueAt( monounsaturatedFat, model_row_index_mufa, model_column_index );
                    modelTableNutrientInput.setValueAt( polyunsaturatedFat, model_row_index_pufa, model_column_index );
                    modelTableNutrientInput.setValueAt( saturatedFat, model_row_index_sfa, model_column_index );
                    modelTableNutrientInput.setValueAt( totalFat, model_row_index_fat, model_column_index );
                    select_table_row_using_model( tableNutrientInput, model_row_index_fat );
                    scroll_to_row_using_model( tableNutrientInput, model_row_index_fat );
                }
                else {
                    Message.showMessage( "Numbers only" );
                }
            }
        }
    }

    private void evt_btn_fill_carbohydrate_data() {
        JTextPane instructions = new JTextPane();
        JTextField carbsByDiffText = new JTextField();
        JTextField fiberText = new JTextField();
        StringBuilder sb = new StringBuilder();
        JPanel inputsPanel = new JPanel();
        JComponent[] inputs = new JComponent[] {
            inputsPanel
        };
        FormLayout layout = new FormLayout(
                "min:grow,min:grow", //columns
                "fill:min:grow,min,min" //rows
        );
        JLabel carbsByDiffLabel = new JLabel( "Total Carbohydrate (g): " );
        JLabel fiberLabel = new JLabel( "Dietary Fiber (g): " );
        NumberCheck checkNumber = new NumberCheck();
        //model row index is specified by sql query.
        int model_column_index = 3;
        int model_row_index_carbsbydiff = modelTableNutrientInput.find( "205" );
        int model_row_index_fiber = modelTableNutrientInput.find( "291" );
        int model_row_index_digestible_carbohydrate = modelTableNutrientInput.find( "10003" );
        carbsByDiffText.setText( String.valueOf( modelTableNutrientInput.getValueAt( model_row_index_carbsbydiff, model_column_index ) ) );
        fiberText.setText( String.valueOf( modelTableNutrientInput.getValueAt( model_row_index_fiber, model_column_index ) ) );
        instructions.setEditable( false );
        sb.append( "* CARBOHYDRATE *\n\n" );
        sb.append( "To calculate digestible carbohydrate quantity\n\n" );
        sb.append( "1. Please find 'Total Carbohydrate' quantity on nutrition facts label and enter that number\n\n" );
        sb.append( "2. Please find 'Dietary Fiber' quantity on nutrition facts label and enter that number\n\n" );
        sb.append( "3. Verify 'Digestible Carbs (g)' field has been filled\n\n" );
        sb.append( "[ Total Carbohydrate also appears as 'Carbohydrate, by difference (g)' or 'CarbsBD' ]" );
        instructions.setText( sb.toString() );
        inputsPanel.setPreferredSize( new Dimension( 350, GoldenRatio.getShortSide( 350 ) ) );
        inputsPanel.setLayout( layout );
        inputsPanel.add( new JScrollPane( instructions ), cc.xyw( 1, 1, 2 ) );
        carbsByDiffLabel.setHorizontalAlignment( JLabel.RIGHT );
        fiberLabel.setHorizontalAlignment( JLabel.RIGHT );
        inputsPanel.add( carbsByDiffLabel, cc.xy( 1, 2 ) );
        inputsPanel.add( carbsByDiffText, cc.xy( 2, 2 ) );
        inputsPanel.add( fiberLabel, cc.xy( 1, 3 ) );
        inputsPanel.add( fiberText, cc.xy( 2, 3 ) );
        int optionValue = Message.showOptionDialogOkCancel( inputs, "Digestible Carbohydrate" );
        if( optionValue == 0 ) {
            String s0 = carbsByDiffText.getText();
            String s1 = fiberText.getText();
            if( (s0 != null && s0.length() > 0) && (s1 != null && s1.length() > 0) ) {
                checkNumber.addToUncheckedList( s0 );
                if( checkNumber.pass() ) {
                    Double carbsByDiff = Double.valueOf( carbsByDiffText.getText() );
                    Double fiber = Double.valueOf( fiberText.getText() );
                    Double digestibleCarbohydrate = carbsByDiff - fiber;
                    //model row index is specified by sql query.
                    modelTableNutrientInput.setValueAt( carbsByDiff, model_row_index_carbsbydiff, model_column_index );
                    modelTableNutrientInput.setValueAt( digestibleCarbohydrate, model_row_index_digestible_carbohydrate, model_column_index );
                    modelTableNutrientInput.setValueAt( fiber, model_row_index_fiber, model_column_index );
                    select_table_row_using_model( tableNutrientInput, model_row_index_carbsbydiff );
                    scroll_to_row_using_model( tableNutrientInput, model_row_index_carbsbydiff );
                }
                else {
                    Message.showMessage( "Numbers only" );
                }
            }
        }
    }

    private void evt_btn_fill_energy_data() {
        JTextPane instructions = new JTextPane();
        JTextField proteinText = new JTextField();
        JTextField fatText = new JTextField();
        JTextField digestibleCarbohydrateText = new JTextField();
        JTextField alcoholText = new JTextField();
        StringBuilder sb = new StringBuilder();
        JPanel inputsPanel = new JPanel();
        JComponent[] inputs = new JComponent[] {
            inputsPanel
        };
        FormLayout layout = new FormLayout(
                "min:grow,min:grow", //columns
                "fill:min:grow,min,min,min,min" //rows
        );
        JLabel proteinLabel = new JLabel( "Protein (g): " );
        JLabel fatLabel = new JLabel( "Fat (g): " );
        JLabel digestibleCarbohydrateLabel = new JLabel( "Digestible Carbohydrate (g): " );
        JLabel alcoholLabel = new JLabel( "Alcohol (g): " );
        NumberCheck checkNumber = new NumberCheck();
        //
        proteinText.setEditable( false );
        fatText.setEditable( false );
        digestibleCarbohydrateText.setEditable( false );
        alcoholText.setEditable( false );
        //model row index is specified by sql query.
        int model_column_index = 3;
        int model_row_index_protein = modelTableNutrientInput.find( "203" );
        int model_row_index_fat = modelTableNutrientInput.find( "204" );
        int model_row_index_digestible_carbohydrate = modelTableNutrientInput.find( "10003" );
        int model_row_index_alcohol = modelTableNutrientInput.find( "221" );
        proteinText.setText( String.valueOf( modelTableNutrientInput.getValueAt( model_row_index_protein, model_column_index ) ) );
        fatText.setText( String.valueOf( modelTableNutrientInput.getValueAt( model_row_index_fat, model_column_index ) ) );
        digestibleCarbohydrateText.setText( String.valueOf( modelTableNutrientInput.getValueAt( model_row_index_digestible_carbohydrate, model_column_index ) ) );
        alcoholText.setText( String.valueOf( modelTableNutrientInput.getValueAt( model_row_index_alcohol, model_column_index ) ) );
        instructions.setEditable( false );
        sb.append( "* ENERGY *\n\n" );
        sb.append( "To calculate energy (kcal) values\n\n" );
        sb.append( "1. Verify displayed quantities are correct\n\n" );
        sb.append( "2. Click ok\n\n" );
        sb.append( "3. Verify energy fields have been filled" );
        instructions.setText( sb.toString() );
        inputsPanel.setPreferredSize( new Dimension( 350, GoldenRatio.getShortSide( 350 ) ) );
        inputsPanel.setLayout( layout );
        JScrollPane scrollPane = new JScrollPane( instructions );
        inputsPanel.add( scrollPane, cc.xyw( 1, 1, 2 ) );
        proteinLabel.setHorizontalAlignment( JLabel.RIGHT );
        fatLabel.setHorizontalAlignment( JLabel.RIGHT );
        digestibleCarbohydrateLabel.setHorizontalAlignment( JLabel.RIGHT );
        alcoholLabel.setHorizontalAlignment( JLabel.RIGHT );
        inputsPanel.add( proteinLabel, cc.xy( 1, 2 ) );
        inputsPanel.add( proteinText, cc.xy( 2, 2 ) );
        inputsPanel.add( fatLabel, cc.xy( 1, 3 ) );
        inputsPanel.add( fatText, cc.xy( 2, 3 ) );
        inputsPanel.add( digestibleCarbohydrateLabel, cc.xy( 1, 4 ) );
        inputsPanel.add( digestibleCarbohydrateText, cc.xy( 2, 4 ) );
        inputsPanel.add( alcoholLabel, cc.xy( 1, 5 ) );
        inputsPanel.add( alcoholText, cc.xy( 2, 5 ) );
        SwingUtilities.invokeLater( ()
                -> {
            scrollPane.getViewport().setViewPosition( new Point( 0, 0 ) );
        } );
        int optionValue = Message.showOptionDialogOkCancel( inputs, "Energy" );
        if( optionValue == 0 ) {
            String s0 = proteinText.getText();
            String s1 = fatText.getText();
            String s2 = digestibleCarbohydrateText.getText();
            String s3 = alcoholText.getText();
            if( (s0 != null && s0.length() > 0) && (s1 != null && s1.length() > 0) && (s2 != null && s2.length() > 0) && (s3 != null && s3.length() > 0) ) {
                checkNumber.addToUncheckedList( s0 );
                if( checkNumber.pass() ) {
                    Double protein = Double.valueOf( proteinText.getText() );
                    Double fat = Double.valueOf( fatText.getText() );
                    Double digestibleCarbohydrate = Double.valueOf( digestibleCarbohydrateText.getText() );
                    Double alcohol = Double.valueOf( alcoholText.getText() );
                    MacroNutrientEnergyValues energyValues = new MacroNutrientEnergyValues.Builder().protein( protein ).fat( fat ).digestibleCarbohydrate( digestibleCarbohydrate ).alcohol( alcohol ).build();
                    energyValues.getProteinEnergy();
                    //model row index is specified by sql query.
                    int model_row_index_energy_alcohol = modelTableNutrientInput.find( "10014" );
                    int model_row_index_energy_digestible_carbohydrate = modelTableNutrientInput.find( "10011" );
                    int model_row_index_energy_digestible = modelTableNutrientInput.find( "10009" );
                    int model_row_index_energy_fat = modelTableNutrientInput.find( "10013" );
                    int model_row_index_energy_fat_carbohydrate = modelTableNutrientInput.find( "10010" );
                    int model_row_index_energy_protein = modelTableNutrientInput.find( "10012" );
                    modelTableNutrientInput.setValueAt( energyValues.getAlcoholEnergy(), model_row_index_energy_alcohol, model_column_index );
                    modelTableNutrientInput.setValueAt( energyValues.getDigestibleCarbohydrateEnergy(), model_row_index_energy_digestible_carbohydrate, model_column_index );
                    modelTableNutrientInput.setValueAt( energyValues.getEnergyDigestible(), model_row_index_energy_digestible, model_column_index );
                    modelTableNutrientInput.setValueAt( energyValues.getFatEnergy(), model_row_index_energy_fat, model_column_index );
                    modelTableNutrientInput.setValueAt( energyValues.get_energy_fat_and_carbohydrate(), model_row_index_energy_fat_carbohydrate, model_column_index );
                    modelTableNutrientInput.setValueAt( energyValues.getProteinEnergy(), model_row_index_energy_protein, model_column_index );
                    Integer modelRowId = 4;
                    select_table_row_using_model( tableNutrientInput, modelRowId );
                    scroll_to_row_using_model( tableNutrientInput, modelRowId );
                }
                else {
                    Message.showMessage( "Numbers only" );
                }
            }
        }
    }

    private void evt_btn_fill_vitamin_values() {
        FormLayout layout = new FormLayout( "min:grow,min,min:grow", //columns
                                            "fill:min:grow" //rows
        );
        JPanel panel = new JPanel();
        JComponent[] inputs = new JComponent[] {
            panel
        };
        panel.setLayout( layout );
        JComboBox cboxNutrients = new JComboBox();
        JTextField dailyValuePct = new JTextField();
        NumberCheck checkNumber = new NumberCheck();
        String s0 = "";
        Double dvpct = -1.0;
        Double xgrams = -1.0;
        NutrientDataObject nutrientDataObject = null;
        //
        cboxNutrients.setModel( modelComboBox_NutrientLookupListConvert );
        modelComboBox_NutrientLookupListConvert.reload();
        dailyValuePct.setMinimumSize( new Dimension( 50, 20 ) );
        panel.add( cboxNutrients, cc.xy( 1, 1 ) );
        panel.add( dailyValuePct, cc.xy( 2, 1 ) );
        panel.add( new JLabel( " %DV" ), cc.xy( 3, 1 ) );
        int optionValue = Message.showOptionDialogOkCancel( inputs, "Vitamins And Minerals" );
        if( optionValue == 0 ) {
            s0 = dailyValuePct.getText();
            if( s0 != null && s0.length() > 0 ) {
                checkNumber.addToUncheckedList( s0 );
                if( checkNumber.pass() ) {
                    nutrientDataObject = ( NutrientDataObject ) cboxNutrients.getSelectedItem();
                    dvpct = Double.valueOf( s0 );
                    xgrams = dvpct * (nutrientDataObject.getQ() / 100);
                    //model row index is specified by sql query.
                    int model_column_index = 3;
                    Integer model_row_index_vitamin = modelTableNutrientInput.find( nutrientDataObject.getNutr_no() );
                    modelTableNutrientInput.setValueAt( xgrams, model_row_index_vitamin, model_column_index );
                    select_table_row_using_model( tableNutrientInput, model_row_index_vitamin );
                    scroll_to_row_using_model( tableNutrientInput, model_row_index_vitamin );
                }
                else {
                    Message.showMessage( "Numbers only" );
                }
            }
        }
    }

    private void evt_btn_fill_glycemic_load() {
        JTextPane instructions = new JTextPane();
        JTextField digestibleCarbohydrateText = new JTextField();
        JTextField glycemicIndexText = new JTextField();
        StringBuilder sb = new StringBuilder();
        JPanel inputsPanel = new JPanel();
        JComponent[] inputs = new JComponent[] {
            inputsPanel
        };
        FormLayout layout = new FormLayout(
                "min:grow,min:grow", //columns
                "fill:min:grow,min,min" //rows
        );
        JLabel digestibleCarbohydrateLabel = new JLabel( "Digestible Carbohydrate (g): " );
        JLabel glycemicIndexLabel = new JLabel( "Glycemic Index: " );
        NumberCheck checkNumber = new NumberCheck();
        //
        digestibleCarbohydrateText.setEditable( false );
        //model row index is specified by sql query.
        int model_column_index = 3;
        int model_row_index_digestible_carbohydrate = modelTableNutrientInput.find( "10003" );
        int model_row_index_glycemic_load = modelTableNutrientInput.find( "10006" );
        digestibleCarbohydrateText.setText( String.valueOf( modelTableNutrientInput.getValueAt( model_row_index_digestible_carbohydrate, model_column_index ) ) );
        instructions.setEditable( false );
        sb.append( "* GLYCEMIC LOAD *\n\n" );
        sb.append( "To calculate glycemic load value\n\n" );
        sb.append( "1. Verify 'Digestible Carbs (g)' value is correct\n\n" );
        sb.append( "2. Please find 'Glycemic Index' of the food and enter that number\n\n" );
        sb.append( "3. Verify 'Glycemic Load' field has been filled" );
        instructions.setText( sb.toString() );
        inputsPanel.setPreferredSize( new Dimension( 350, GoldenRatio.getShortSide( 350 ) ) );
        inputsPanel.setLayout( layout );
        inputsPanel.add( new JScrollPane( instructions ), cc.xyw( 1, 1, 2 ) );
        digestibleCarbohydrateLabel.setHorizontalAlignment( JLabel.RIGHT );
        glycemicIndexLabel.setHorizontalAlignment( JLabel.RIGHT );
        inputsPanel.add( digestibleCarbohydrateLabel, cc.xy( 1, 2 ) );
        inputsPanel.add( digestibleCarbohydrateText, cc.xy( 2, 2 ) );
        inputsPanel.add( glycemicIndexLabel, cc.xy( 1, 3 ) );
        inputsPanel.add( glycemicIndexText, cc.xy( 2, 3 ) );
        int optionValue = Message.showOptionDialogOkCancel( inputs, "Glycemic Load" );
        if( optionValue == 0 ) {
            String s0 = digestibleCarbohydrateText.getText();
            String s1 = glycemicIndexText.getText();
            if( (s0 != null && s0.length() > 0) && (s1 != null && s1.length() > 0) ) {
                checkNumber.addToUncheckedList( s0 );
                if( checkNumber.pass() ) {
                    Double digestibleCarbohydrate = Double.valueOf( digestibleCarbohydrateText.getText() );
                    Double glycemicIndex = Double.valueOf( glycemicIndexText.getText() );
                    GlycemicLoad glycemicLoad = new GlycemicLoad( glycemicIndex, digestibleCarbohydrate );
                    //Row value is determined by sql query.
                    modelTableNutrientInput.setValueAt( digestibleCarbohydrate, model_row_index_digestible_carbohydrate, model_column_index );
                    modelTableNutrientInput.setValueAt( glycemicLoad.getGlycemicLoad(), model_row_index_glycemic_load, model_column_index );
                    select_table_row_using_model( tableNutrientInput, model_row_index_glycemic_load );
                    scroll_to_row_using_model( tableNutrientInput, model_row_index_glycemic_load );
                }
                else {
                    Message.showMessage( "Numbers only" );
                }
            }
        }
    }

    private void select_table_row_using_model( JTable table, Integer modelRowId ) {
        Integer tableRowId = table.convertRowIndexToView( modelRowId );
        this.select_table_row_using_table( table, tableRowId );
    }

    private void select_table_row_using_table( JTable table, int tableRowId ) {
        table.setRowSelectionInterval( tableRowId, tableRowId );
    }

    private void scroll_to_row_using_model( JTable table, Integer modelRowId ) {
        Integer tableRowId = table.convertRowIndexToView( modelRowId );
        this.scroll_to_row_using_table( table, tableRowId );
    }

    private void scroll_to_row_using_table( JTable table, int tableRowId ) {
        table.setRowSelectionInterval( tableRowId, tableRowId );
        Rectangle rect = table.getCellRect( tableRowId, 0, true );
        table.scrollRectToVisible( rect );
    }

    private JPanel get_wizard_panel() {
        JPanel wizardPanel = new JPanel();
        FormLayout layout = new FormLayout(
                "min:grow,min,min,min,min,min,min,min,min:grow", //columns
                "min" //rows
        );
        wizardPanel.setLayout( layout );
        JButton fillCompleteProteinButton = new JButton( "Protein" );
        JButton fillFatButton = new JButton( "Fat" );
        JButton fillDigestibleCarbsButton = new JButton( "Carbs" );
        JButton fillEnergyDataButton = new JButton( "Energy" );
        JButton fillVitaminsButton = new JButton( "Vitamins" );
        JButton fillGlycemicLoadButton = new JButton( "Glycemic" );
        JButton btn_cost = new JButton( "Cost" );
        wizardPanel.add( fillCompleteProteinButton, cc.xy( 2, 1 ) );
        wizardPanel.add( fillFatButton, cc.xy( 3, 1 ) );
        wizardPanel.add( fillDigestibleCarbsButton, cc.xy( 4, 1 ) );
        wizardPanel.add( fillEnergyDataButton, cc.xy( 5, 1 ) );
        wizardPanel.add( fillVitaminsButton, cc.xy( 6, 1 ) );
        wizardPanel.add( fillGlycemicLoadButton, cc.xy( 7, 1 ) );
        wizardPanel.add( btn_cost, cc.xy( 8, 1 ) );
        layout.setColumnGroup( 2, 3, 4, 5, 6, 7, 8 );
        fillCompleteProteinButton.setToolTipText( "Complete Protein calculator assistant" );
        fillFatButton.setToolTipText( "Fat calculator assistant" );
        fillDigestibleCarbsButton.setToolTipText( "Digestible carbohydrate calculator assistant" );
        fillEnergyDataButton.setToolTipText( "Energy values calculator assistant" );
        fillVitaminsButton.setToolTipText( "Vitamin and mineral values calculator assistant" );
        fillGlycemicLoadButton.setToolTipText( "Glycemic load calculator assistant" );
        btn_cost.setToolTipText( "Cost calculator assistant" );
        fillCompleteProteinButton.addActionListener(( ActionEvent e )
                -> {
            evt_btn_fill_complete_protein_data();
        } );
        fillFatButton.addActionListener(( ActionEvent e )
                -> {
            evt_btn_fill_fat();
        } );
        fillDigestibleCarbsButton.addActionListener(( ActionEvent e )
                -> {
            evt_btn_fill_carbohydrate_data();
        } );
        fillEnergyDataButton.addActionListener(( ActionEvent e )
                -> {
            evt_btn_fill_energy_data();
        } );
        fillVitaminsButton.addActionListener(( ActionEvent e )
                -> {
            evt_btn_fill_vitamin_values();
        } );
        fillGlycemicLoadButton.addActionListener(( ActionEvent e )
                -> {
            evt_btn_fill_glycemic_load();
        } );
        btn_cost.addActionListener( ( ActionEvent e )
                -> {
            evt_btn_cost();
        } );
        return wizardPanel;
    }

    private void update_food_item( String foodId, Integer optionValue ) {
        tableNutrientInput.setRowSorter( nutrientinput_tablesorter );
        tableNutrientInput.setModel( modelTableNutrientInput );
        tableNutrientInput.setSelectionMode( ListSelectionModel.SINGLE_SELECTION );
        tableNutrientInput.setFillsViewportHeight( true );
        tableNutrientInput.setDefaultEditor( Double.class, new DoubleTableCellEditor() );
        modelTableNutrientInput.setPrecision( 5 );
        textFieldNutrientSearch.setText( "" );
        if( optionValue == -1 ) {
            modelTableNutrientInput.reload( foodId );
            resize_col_tbl_nutrient_input();
        }
        JPanel panel = new JPanel();
        JLabel labelFoodName = new JLabel( "Food Name:" );
        JLabel labelNutrientWeight = new JLabel( "Nutrient Weight:" );
        JLabel labelNutrientSearch = new JLabel( "Search:" );
        JTextField textFieldFoodName = new JTextField();
        JTextField textFieldNutrientValue = new JTextField();
        JButton buttonNutrientWeightSave = new JButton( "S" );
        JButton buttonPrevious = new JButton( "<" );
        JButton buttonNext = new JButton( ">" );
        labelFoodName.setHorizontalAlignment( JLabel.RIGHT );
        labelNutrientWeight.setHorizontalAlignment( JLabel.RIGHT );
        labelNutrientSearch.setHorizontalAlignment( JLabel.RIGHT );
        buttonNutrientWeightSave.setToolTipText( "Set nutrient value" );
        buttonPrevious.setToolTipText( "Go to previous row" );
        buttonNext.setToolTipText( "Go to next row" );
        FormLayout panelLayout = new FormLayout(
                "10px,310px,5px,200px,5px,min,min,min,10px", //columns
                "10px,min,min,min,4px,min,4px,fill:min:grow,10px" //rows
        );
        panel.setPreferredSize( new Dimension( 700, GoldenRatio.getShortSide( 700 ) ) );
        panel.setLayout( panelLayout );
        panel.setBorder( new TitledBorder( "Nutritional Food Facts" ) );
        panel.add( labelFoodName, cc.xy( 2, 2 ) );
        panel.add( textFieldFoodName, cc.xyw( 4, 2, 5 ) );
        panel.add( labelNutrientSearch, cc.xy( 2, 3 ) );
        panel.add( textFieldNutrientSearch, cc.xyw( 4, 3, 5 ) );
        panel.add( labelNutrientWeight, cc.xy( 2, 4 ) );
        panel.add( textFieldNutrientValue, cc.xyw( 4, 4, 2 ) );
        panel.add( buttonNutrientWeightSave, cc.xy( 6, 4 ) );
        panel.add( buttonPrevious, cc.xy( 7, 4 ) );
        panel.add( buttonNext, cc.xy( 8, 4 ) );
        panel.add( get_wizard_panel(), cc.xyw( 2, 6, 7 ) );
        tableNutrientInputScrollPane = new JScrollPane( tableNutrientInput );
        panel.add( tableNutrientInputScrollPane, cc.xyw( 2, 8, 7 ) );
        JComponent[] inputs = new JComponent[] {
            panel
        };
        if( optionValue == 0 ) {
            textFieldFoodName.setText( foodNameText );
        }
        else {
            try {
                FoodDataObject foodDataObject = new FoodDataObject();
                foodDataObject.setFoodId( foodId );
                LinkedList<FoodDataObject> list = ( LinkedList ) dbLink.Food_Select( foodDataObject );
                Iterator it = list.listIterator();
                foodDataObject = ( FoodDataObject ) it.next();
                textFieldFoodName.setText( foodDataObject.getFoodName() );
            } catch( SQLException e ) {

            }
        }
        buttonNext.addActionListener( ( ActionEvent e )
                -> {
            int selectedRowNo = tableNutrientInput.getSelectedRow();
            if( selectedRowNo != tableNutrientInput.getRowCount() - 1 ) {
                tableNutrientInput.getDefaultEditor( Double.class ).cancelCellEditing();
                selectedRowNo++;
                scroll_to_row_using_table( tableNutrientInput, selectedRowNo );
            }
            else {
                select_table_row_using_table( tableNutrientInput, selectedRowNo );
            }
        } );
        buttonPrevious.addActionListener( ( ActionEvent e )
                -> {
            int selectedRowNo = tableNutrientInput.getSelectedRow();
            if( selectedRowNo > 0 && selectedRowNo < tableNutrientInput.getRowCount() ) {
                tableNutrientInput.getDefaultEditor( Double.class ).cancelCellEditing();
                selectedRowNo--;
                scroll_to_row_using_table( tableNutrientInput, selectedRowNo );
            }
            else {
                select_table_row_using_table( tableNutrientInput, 0 );
            }
        } );
        buttonNutrientWeightSave.addActionListener( ( ActionEvent e )
                -> {
            int selectedRowNo = tableNutrientInput.getSelectedRow();
            if( selectedRowNo != -1 ) {
                NumberCheck numberCheck = new NumberCheck();
                numberCheck.addToUncheckedList( textFieldNutrientValue.getText() );
                if( numberCheck.pass() ) {
                    tableNutrientInput.getDefaultEditor( Double.class ).cancelCellEditing();
                    modelTableNutrientInput.setValueAt( Double.valueOf( textFieldNutrientValue.getText() ), tableNutrientInput.convertRowIndexToModel( selectedRowNo ), 3 );
                }
                else {
                    Message.showMessage( "Value must be a number greater than or equal to zero" );
                }
            }
        } );
        ListSelectionModel selectionModel = tableNutrientInput.getSelectionModel();
        selectionModel.addListSelectionListener( ( ListSelectionEvent e )
                -> {
            if( e.getValueIsAdjusting() ) {
                tableNutrientInput.getDefaultEditor( Double.class ).cancelCellEditing();
                return;
            }
            else {

            }
            int selectedRowNo = tableNutrientInput.getSelectedRow();
            if( selectedRowNo != -1 ) {
                String nutrient = ( String ) modelTableNutrientInput.getValueAt( tableNutrientInput.convertRowIndexToModel( selectedRowNo ), 2 );
                Double weight = ( Double ) modelTableNutrientInput.getValueAt( tableNutrientInput.convertRowIndexToModel( selectedRowNo ), 3 );
                textFieldNutrientValue.setText( String.valueOf( weight ) );
                labelNutrientWeight.setText( nutrient );
            }
        } );
        textFieldNutrientSearch.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void changedUpdate( DocumentEvent e ) {
                filter_search_nutrient();
            }

            @Override
            public void insertUpdate( DocumentEvent e ) {
                filter_search_nutrient();
            }

            @Override
            public void removeUpdate( DocumentEvent e ) {
                filter_search_nutrient();
            }
        } );
        //scroll to weight field
        scroll_to_row_using_table( tableNutrientInput, 33 );
        optionValue = Message.showOptionDialogOkCancel( inputs, "Add New Food Item - Would you like to save specified values?" );
        if( optionValue == 0 ) {
            Integer rowIndex = modelTableNutrientInput.find( "10000" );
            Double q = ( Double ) modelTableNutrientInput.getValueAt( rowIndex, 3 );
            if( q > 0 ) {
                try {
                    FoodDataObject foodDataObject = new FoodDataObject();
                    foodDataObject.setFoodId( foodId );
                    foodDataObject.setFoodName( textFieldFoodName.getText() );
                    dbLink.Food_Update( foodDataObject );
                    rowIndex = modelTableNutrientInput.find( "10000" );
                    q = ( Double ) modelTableNutrientInput.getValueAt( rowIndex, 3 );
                    //Weight must be first "NutrientId" updated for trigger to calculate correct nutrient coefficients. Weight is serving size.
                    dbLink.FoodFact_Merge( foodId, "10000", q );
                    int rowNo = modelTableNutrientInput.getRowCount();
                    for( int j = 0; j < rowNo; j++ ) {
                        String nutrientid = ( String ) modelTableNutrientInput.getValueAt( j, 0 );
                        //Weight was updated earlier, I do not want to update it again
                        if( !nutrientid.equals( "10000" ) ) {
                            q = ( Double ) modelTableNutrientInput.getValueAt( j, 3 );
                            dbLink.FoodFact_Merge( foodId, nutrientid, q );
                        }
                    }
                } catch( SQLException e ) {

                }
                dbLink.stopTransaction();
                reload_food_items();
                rowIndex = modelTableFoodList.find( foodId );
                scroll_to_row_using_table( tableFoodList01, tableFoodList01.convertRowIndexToView( rowIndex ) );
                foodNameText = "";
            }
            else {
                foodNameText = textFieldFoodName.getText();
                Message.showMessage( "What is serving size? Weight must be greater than zero." );
                update_food_item( foodId, optionValue );
            }
        }
        else {
            dbLink.revertTransaction();
        }
    }

    private void reload_food_items() {
        modelTableFoodList.reload();
        modelTreeFoodList.reload();
        modelListFood.reload();
        resize_col_tbl_food_list();
    }

    private void evt_btn_food_list_add() {
        try {
            String foodId = dbLink.Food_Insert_Temp( "New Food Item Name" );
            update_food_item( foodId, -1 );
        } catch( SQLException e ) {

        }
    }

    private void evt_btn_food_list_update() {
        int selectedRowNo = tableFoodList01.getSelectedRow();
        if( selectedRowNo != -1 ) {
            String foodId = ( String ) tableFoodList01.getValueAt( selectedRowNo, 0 );
            update_food_item( foodId, -1 );
        }
    }

    private void evt_btn_food_list_delete() {
        int selectedRowNo = tableFoodList01.getSelectedRow();
        if( selectedRowNo != -1 ) {
            String foodId = ( String ) tableFoodList01.getValueAt( selectedRowNo, 0 );
            delete_food_item( foodId );
        }
    }

    private void delete_food_item( String foodId ) {
        try {
            dbLink.Food_Delete( foodId );
            dbLink.stopTransaction();
            reload_food_items();
            if( !listCategories.isSelectionEmpty() ) {
                FoodCategoryDataObject foodCategoryDataObject = ( FoodCategoryDataObject ) listCategories.getSelectedValue();
                modelListFoodInCategory.reload( foodCategoryDataObject.getFoodCategoryId() );
            }
        } catch( SQLException e ) {

        }
    }

    private void duplicate_food_item( String foodId ) {
        try {
            dbLink.DuplicateFoodItem( foodId );
            dbLink.stopTransaction();
            reload_food_items();
            if( !listCategories.isSelectionEmpty() ) {
                FoodCategoryDataObject foodCategoryDataObject = ( FoodCategoryDataObject ) listCategories.getSelectedValue();
                modelListFoodInCategory.reload( foodCategoryDataObject.getFoodCategoryId() );
            }
        } catch( SQLException e ) {

        }
    }

    private JPanel get_nutrient_lookup_list() {
        JPanel panel = new JPanel();
        JLabel search_label = new JLabel( "Search: " );
        JLabel nutrient_label = new JLabel( "Nutrient: " );
        JLabel value_label = new JLabel( "Value: " );
        JTextField search_field = new JTextField();
        FormLayout panelLayout = new FormLayout(
                "4dlu,min,min:grow,2dlu,min,min:grow,min,4dlu", //columns
                "4dlu,3dlu,fill:25px,3dlu,fill:25px,1dlu,fill:min:grow,4dlu" //rows
        );
        search_label.setHorizontalAlignment( JLabel.RIGHT );
        nutrient_label.setHorizontalAlignment( JLabel.RIGHT );
        value_label.setHorizontalAlignment( JLabel.RIGHT );
        panel.setLayout( panelLayout );
        JScrollPane scrollPaneNutrientLookup = new JScrollPane( tableNutrientLookup );
        panel.add( search_label, cc.xy( 5, 3 ) );
        panel.add( search_field, cc.xyw( 6, 3, 2 ) );
        panel.add( nutrient_label, cc.xy( 2, 5 ) );
        panel.add( comboBoxNutrientLookupListNutrient, cc.xy( 3, 5 ) );
        panel.add( value_label, cc.xy( 5, 5 ) );
        panel.add( textFieldNutrientLookup, cc.xy( 6, 5 ) );
        panel.add( scrollPaneNutrientLookup, cc.xyw( 2, 7, 6 ) );
        scrollPaneNutrientLookup.setBorder( new TitledBorder( "Nutrient Lookup" ) );
        tableNutrientLookup.setToolTipText( "These food items contain the specific nutrient" );
        tableNutrientLookup.setTableHeader( new TableHeaderNutrientLookup( tableNutrientLookup.getColumnModel() ) );
        tableNutrientLookup.setAutoCreateRowSorter( true );
        textFieldNutrientLookup.addActionListener( ( ActionEvent e )
                -> {
            evt_btn_nutrient_lookup();
        } );
        search_field.getDocument().addDocumentListener( new DocumentListener() {
            @Override
            public void changedUpdate( DocumentEvent e ) {
                nutrientlookup_search_filter();
            }

            @Override
            public void insertUpdate( DocumentEvent e ) {
                nutrientlookup_search_filter();
            }

            @Override
            public void removeUpdate( DocumentEvent e ) {
                nutrientlookup_search_filter();
            }

            private void nutrientlookup_search_filter() {
                RowFilter<TableModelNutrientLookup, Object> rf = null;
                try {
                    ArrayList filters = new ArrayList();
                    filters.add( RowFilter.regexFilter( "(?i)" + search_field.getText(), 0 ) );
                    rf = RowFilter.orFilter( ( Iterable<? extends RowFilter<? super TableModelNutrientLookup, ? super Object>> ) filters );
                } catch( java.util.regex.PatternSyntaxException e ) {
                    return;
                }
                nutrientlookup_tablesorter.setRowFilter( rf );
            }

        } );
        comboBoxNutrientLookupListNutrient.setModel( modelComboBox_NutrientLookupListNutrient );
        modelComboBox_NutrientLookupListNutrient.reload();
        tableNutrientLookup.setModel( modelTableNutrientLookup );
        tableNutrientLookup.setSelectionMode( ListSelectionModel.SINGLE_SELECTION );
        tableNutrientLookup.setFillsViewportHeight( true );
        tableNutrientLookup.setRowSorter( nutrientlookup_tablesorter );
        resize_col_tbl_nutrient_lookup();
        return panel;
    }

    private void evt_mnui_roundup() {
        boolean selected = checkBoxResultRoundUp.isSelected();
        if( selected ) {
            precision = 0;
            modelTableFoodList.setPrecision( precision );
            result_loader.setPrecision( precision );
            result_loader_journal.setPrecision( precision );
            modelTableGlycemic.setPrecision( precision );
            model_for_food_difference_table.setPrecision( precision );
            model_for_mix_difference_table.setPrecision( precision );
            tblmdl_results_rda.setPrecision( precision );
            tblmdl_journal_rda.setPrecision( precision );
            stringModelMixPct.setPrecision( precision );
            modelTableNutrientLookup.setPrecision( precision );
            modelTableNutrientInput.setPrecision( 5 );
        }
        else {
            precision = 5;
            modelTableFoodList.setPrecision( precision );
            result_loader.setPrecision( precision );
            result_loader_journal.setPrecision( precision );
            modelTableGlycemic.setPrecision( precision );
            modelTableJournalGlycemic.setPrecision( precision );
            model_for_food_difference_table.setPrecision( precision );
            model_for_mix_difference_table.setPrecision( precision );
            tblmdl_results_rda.setPrecision( precision );
            tblmdl_journal_rda.setPrecision( precision );
            stringModelMixPct.setPrecision( precision );
            modelTableNutrientLookup.setPrecision( precision );
            modelTableNutrientInput.setPrecision( precision );
        }
        if( is_mix_selected() ) {
            MixDataObject mixDataObject = ( MixDataObject ) lst_mix.getSelectedValue();
            String mixId = mixDataObject.getMixId();
            reload_results_table_models();
        }
        reload_food_items();
        reload_journal_table_models();
        reload_food_comparison();
        reload_mix_comparison();
        reload_results_rda_check();
        reload_journal_rda_check();
        reload_nutrient_lookup();
    }

    private void evt_mnui_nutrients_shown_as_constraints() {
        JComponent[] inputs = new JComponent[] {
            get_constraints_panel()
        };
        int optionValue = Message.showOptionDialogOkCancel( inputs, "Nutrients, Energies and Cost Shown As Constraints" );
        if( optionValue == 0 ) {
            mapConstraintCheckboxes.forEach( ( k, v )
                    -> {
                try {
                    if( v.isSelected() ) {
                        dbLink.Nutrient_Update( k, 1 );
                    }
                    else {
                        dbLink.Nutrient_Update( k, 0 );
                    }
                    dbLink.stopTransaction();
                } catch( SQLException e ) {

                }
            }
            );
            reload_nutrient_combo_boxes();
        }
    }

    private void evt_btn_minimize_option() {
        JComponent[] inputs = new JComponent[] {
            get_minimization_options_panel()
        };
        if( is_mix_selected() ) {
            MixDataObject o = ( MixDataObject ) lst_mix.getSelectedValue();
            String nutrientid = o.getNutrientid();
            if( nutrientid.equals( "10009" ) ) {
                rbtn_calories.setSelected( true );
            }
            else {
                rbtn_cost.setSelected( true );
            }
            int optionValue = Message.showOptionDialogOkCancel( inputs, "Minimization Options" );
            if( optionValue == 0 ) {
                try {
                    if( rbtn_calories.isSelected() ) {
                        dbLink.Mix_Update_NutrientId( o.getMixId(), "10009" );
                    }
                    else {
                        dbLink.Mix_Update_NutrientId( o.getMixId(), "10005" );
                    }
                    dbLink.stopTransaction();
                    reload_mixes();
                    clear_model_all();
                    int index = modelList_Solve.find_by_mixid( o.getMixId() );
                    lst_mix.setSelectedIndex( index );
                } catch( SQLException ex ) {
                }
            }
        }
    }

    private JPanel get_constraints_panel() {
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
        panel00.setLayout( panel00Layout );
        panel00.setPreferredSize( new Dimension( 720, 220 ) );
        panel00.add( panel01, cc.xy( 2, 2 ) );
        panel01.setLayout( panel01Layout );
        Object[] it = mapConstraintCheckboxes.entrySet().toArray();
        for( int x = 1; x < it.length + 1; x++ ) {
            Map.Entry entry = ( Map.Entry ) it[ x - 1 ];
            JCheckBox cb = ( JCheckBox ) entry.getValue();
            JLabel label = new JLabel( cb.getName() );
            label.setHorizontalAlignment( SwingConstants.RIGHT );
            if( x < 11 ) {
                panel01.add( label, cc.xy( 1, x ) );
                panel01.add( cb, cc.xy( 2, x ) );
            }
            else {
                if( x < 21 ) {
                    panel01.add( label, cc.xy( 3, x - 10 ) );
                    panel01.add( cb, cc.xy( 4, x - 10 ) );
                }
                else {
                    if( x < 31 ) {
                        panel01.add( label, cc.xy( 5, x - 20 ) );
                        panel01.add( cb, cc.xy( 6, x - 20 ) );
                    }
                    else {
                        if( x < 41 ) {
                            panel01.add( label, cc.xy( 7, x - 30 ) );
                            panel01.add( cb, cc.xy( 8, x - 30 ) );
                        }
                        else {
                            if( x < 51 ) {
                                panel01.add( label, cc.xy( 9, x - 40 ) );
                                panel01.add( cb, cc.xy( 10, x - 40 ) );
                            }
                            else {
                                if( x < 61 ) {
                                    panel01.add( label, cc.xy( 11, x - 50 ) );
                                    panel01.add( cb, cc.xy( 12, x - 50 ) );
                                }
                            }
                        }
                    }
                }
            }
        }
        return panel00;
    }

    private JPanel get_minimization_options_panel() {
        JPanel panel00 = new JPanel();
        FormLayout panel00Layout = new FormLayout(
                "4px,min:grow,4px", //columns
                "4px,fill:min:grow,4px" //rows
        );
        JPanel panel01 = new JPanel();
        FormLayout panel01Layout = new FormLayout(
                "min:grow,p,p,min:grow", //columns
                "fill:min:grow,p,fill:min:grow" //rows
        );
        //
        panel00.setLayout( panel00Layout );
        panel00.setPreferredSize( new Dimension( 170, 55 ) );
        panel00.add( panel01, cc.xy( 2, 2 ) );
        panel01.setLayout( panel01Layout );
        ButtonGroup minimizationOptionGroup = new ButtonGroup();
        minimizationOptionGroup.add( rbtn_calories );
        minimizationOptionGroup.add( rbtn_cost );
        rbtn_calories.setText( "Calories" );
        rbtn_cost.setText( "Cost" );
        panel01.add( rbtn_calories, cc.xy( 2, 2 ) );
        panel01.add( rbtn_cost, cc.xy( 3, 2 ) );
        return panel00;
    }

    private void evt_mnui_exit() {
        dbLink.Shutdown();
        //frame.dispose();
        System.exit( 0 );
    }

    private void evt_mnui_food_list_export() {
        ExportFoodList exportFoodList = new ExportFoodList( dbLink );
        exportFoodList.print();
    }

    private void evt_mnui_journal_export() {
        ExportFoodMixes exportFoodMixes = new ExportFoodMixes( dbLink );
        exportFoodMixes.print();
    }

    private void evt_mnui_mix_comparison_export() {
        if( is_list_mix_compare_a_selected() && is_list_mix_compare_b_selected() ) {
            ExportMixComparison exportMixComparison = new ExportMixComparison();
            exportMixComparison.print( model_for_mix_difference_table, list_mix_compare_a, list_mix_compare_b );
        }
        else {
            Message.showMessage( "Please select mix at the mix comparison" );
        }
    }

    private void evt_mnui_food_comparison_export() {
        if( is_list_food_compare_a_selected() && is_list_food_compare_b_selected() ) {
            ExportFoodComparison exportFoodComparison = new ExportFoodComparison();
            exportFoodComparison.print( model_for_food_difference_table, list_food_compare_a, list_food_compare_b );
        }
        else {
            Message.showMessage( "Please select food item at the food comparison" );
        }
    }

    private void evt_mnui_rda_check_export() {
        if( is_mix_journal_selected() ) {
            MixDataObject mixDataObject = ( MixDataObject ) list_journal_mix.getSelectedValue();
            RdaLifeStageDataObject rdaLifeStageDataObject = ( RdaLifeStageDataObject ) cb_journal_lifestage.getSelectedItem();
            ExportRdaCheck exportRdaCheck = new ExportRdaCheck( dbLink );
            exportRdaCheck.print( mixDataObject, rdaLifeStageDataObject.getLifeStageId() );
        }
        else {
            Message.showMessage( "Please select mix at the rda check" );
        }
    }

    private void evt_mnui_nutrient_lookup_export() {
        if( !textFieldNutrientLookup.getText().isBlank() ) {
            ExportNutrientLookup exportNutrientLookup = new ExportNutrientLookup( dbLink );
            exportNutrientLookup.print( textFieldNutrientLookup, comboBoxNutrientLookupListNutrient );
        }
        else {
            Message.showMessage( "Please enter nutrient weight at the nutrient lookup" );
        }
    }

    private void evt_mnui_guide() {
        open_url( "http://xjrga.github.io/snack" );
    }

    private void evt_mnui_credits() {
        StringBuilder sb = new StringBuilder();
        sb.append( "Snack uses the following libraries:" );
        sb.append( "\n\n" );
        sb.append( "commons-math3-3.6.1.jar" );
        sb.append( "\n" );
        sb.append( "hsqldb-2.7.1.jar" );
        sb.append( "\n" );
        sb.append( "jgoodies-common-1.8.1.jar" );
        sb.append( "\n" );
        sb.append( "jgoodies-forms-1.9.0.jar" );
        sb.append( "\n" );
        sb.append( "poi-4.1.1.jar" );
        sb.append( "\n" );
        sb.append( "looks-01.jar" );
        sb.append( "\n\n\n" );
        sb.append( "Snack uses a data subset from:" );
        sb.append( "\n\n" );
        sb.append( "1) USDA National Nutrient Database for Standard Reference, Release 28" );
        sb.append( "\n\n" );
        sb.append( "2) Dietary Reference Intakes Nutrient Recommendations Report from" );
        sb.append( "\n" );
        sb.append( "   Food and Nutrition Board of the Institute of Medicine, National Academy of Sciences" );
        JTextArea textArea = new JTextArea();
        textArea.setText( sb.toString() );
        textArea.setEditable( false );
        textArea.setLineWrap( true );
        JScrollPane scrollPane = new JScrollPane( textArea );
        scrollPane.setPreferredSize( new Dimension( 700, 433 ) );
        JComponent[] inputs = new JComponent[] {
            scrollPane
        };
        Message.showOptionDialog( inputs, "Credits" );
    }

    private void evt_mnui_about() {
        StringBuilder sb = new StringBuilder();
        sb.append( "Understand Your Food Intake" );
        sb.append( "\n\n" );
        sb.append( "Snack is learning software for nutrition, a meal design tool and calculator that could facilitate achieving your health goals and objectives by first helping you understand your food intake and second by allowing you to create new food combinations that meet specific requirements." );
        sb.append( "\n\n" );
        sb.append( "Snack is a training program designed to find lowest calorie or cost food combination. It minimizes digestible energy. It lets you experiment and get faster, better, less expensive results so you can rapidly learn. Its intended audience is anyone with interest in nutrition." );
        sb.append( "\n\n" );
        String txt = "Features:\n"
                + "        - minimize calories or cost\n"
                + "        - quantify food intake\n"
                + "        - track any nutrient or compound that has an impact on health\n"
                + "        - find food items that provide a specific nutrient\n"
                + "        - keep a food journal and track progress\n"
                + "        - compare two foods or meals to see difference in nutritional value\n"
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
        sb.append( txt );
        sb.append( "\n\n" );
        sb.append( "This is build 1020" );
        sb.append( "\n\n" );
        sb.append( "Please send your comments and suggestions to jorge.r.garciadealba+snack@gmail.com" );
        JTextArea textArea = new JTextArea();
        textArea.setText( sb.toString() );
        textArea.setEditable( false );
        textArea.setLineWrap( true );
        JScrollPane scrollPane = new JScrollPane( textArea );
        scrollPane.setPreferredSize( new Dimension( 700, 433 ) );
        JComponent[] inputs = new JComponent[] {
            scrollPane
        };
        SwingUtilities.invokeLater( ()
                -> {
            scrollPane.getViewport().setViewPosition( new Point( 0, 0 ) );
        } );
        Message.showOptionDialog( inputs, "About" );
    }

    private JPanel get_results() {
        JPanel panel = new JPanel();
        FormLayout layout = new FormLayout(
                "min:grow,60dlu", //columns
                "min,fill:min:grow" //rows
        );
        panel.setLayout( layout );
        results_tabbed_pane.setBorder( new TitledBorder( "Mix Results" ) );
        results_tabbed_pane.setTabPlacement( JTabbedPane.BOTTOM );
        results_tabbed_pane.add( get_energy() );
        results_tabbed_pane.add( get_protein() );
        results_tabbed_pane.add( get_fats() );
        results_tabbed_pane.add( get_carbs() );
        results_tabbed_pane.add( get_vitamins() );
        results_tabbed_pane.add( get_minerals() );
        results_tabbed_pane.add( get_electrolytes() );
        results_tabbed_pane.add( get_water() );
        results_tabbed_pane.add( get_cost() );
        results_tabbed_pane.add( get_glycemic() );
        results_tabbed_pane.add( get_model() );
        results_tabbed_pane.add( get_mix_results_rda() );
        results_tabbed_pane.setTitleAt( 0, "Energy" );
        results_tabbed_pane.setTitleAt( 1, "Protein" );
        results_tabbed_pane.setTitleAt( 2, "Fats" );
        results_tabbed_pane.setTitleAt( 3, "Carbohydrates" );
        results_tabbed_pane.setTitleAt( 4, "Vitamins" );
        results_tabbed_pane.setTitleAt( 5, "Minerals" );
        results_tabbed_pane.setTitleAt( 6, "Electrolytes" );
        results_tabbed_pane.setTitleAt( 7, "Water" );
        results_tabbed_pane.setTitleAt( 8, "Cost" );
        results_tabbed_pane.setTitleAt( 9, "Glycemic" );
        results_tabbed_pane.setTitleAt( 10, "Model" );
        results_tabbed_pane.setTitleAt( 11, "Rda" );
        JScrollPane highScorePane = new JScrollPane( listHighScore );
        panel.add( results_tabbed_pane, cc.xywh( 1, 1, 1, 2 ) );
        panel.add( highScorePane, cc.xy( 2, 2 ) );
        JPanel minPanel = new JPanel();
        minPanel.setBorder( new TitledBorder( "Minimize" ) );
        minPanel.add( lbl_Min );
        panel.add( minPanel, cc.xy( 2, 1 ) );
        highScorePane.setBorder( new TitledBorder( "Value" ) );
        highScorePane.setMinimumSize( new Dimension( 0, 200 ) );
        highScorePane.setToolTipText( "Press delete button to clear list" );
        DefaultListCellRenderer renderer = ( DefaultListCellRenderer ) listHighScore.getCellRenderer();
        renderer.setHorizontalAlignment( SwingConstants.RIGHT );
        listHighScore.setModel( modelListHighScore );
        listHighScore.addKeyListener( new KeyListener() {
            @Override
            public void keyTyped( KeyEvent keyEvent ) {
            }

            @Override
            public void keyPressed( KeyEvent keyEvent ) {
                if( keyEvent.getKeyCode() == KeyEvent.VK_DELETE ) {
                    evt_lst_high_score();
                }
            }

            @Override
            public void keyReleased( KeyEvent keyEvent ) {
            }
        } );
        return panel;
    }

    private JScrollPane get_glycemic_journal() {
        JScrollPane scrollPane = new JScrollPane( tableJournalGlycemic );
        tableJournalGlycemic.setModel( modelTableJournalGlycemic );
        tableJournalGlycemic.setSelectionMode( ListSelectionModel.SINGLE_SELECTION );
        tableJournalGlycemic.setFillsViewportHeight( true );
        tableJournalGlycemic.setAutoResizeMode( JTable.AUTO_RESIZE_OFF );
        tableJournalGlycemic.setTableHeader( new TableHeaderGlycemic( tableJournalGlycemic.getColumnModel() ) );
        tableJournalGlycemic.setAutoCreateRowSorter( true );
        return scrollPane;
    }

    private JScrollPane get_glycemic() {
        JScrollPane scrollPane = new JScrollPane( tableGlycemic );
        tableGlycemic.setModel( modelTableGlycemic );
        tableGlycemic.setSelectionMode( ListSelectionModel.SINGLE_SELECTION );
        tableGlycemic.setFillsViewportHeight( true );
        tableGlycemic.setAutoResizeMode( JTable.AUTO_RESIZE_OFF );
        tableGlycemic.setTableHeader( new TableHeaderGlycemic( tableGlycemic.getColumnModel() ) );
        tableGlycemic.setAutoCreateRowSorter( true );
        return scrollPane;
    }

    private JScrollPane get_energy_journal() {
        JScrollPane scrollPane = new JScrollPane( tableJournalEnergy );
        tableJournalEnergy.setModel( modelTableJournalEnergy );
        tableJournalEnergy.setSelectionMode( ListSelectionModel.SINGLE_SELECTION );
        tableJournalEnergy.setFillsViewportHeight( true );
        tableJournalEnergy.setAutoResizeMode( JTable.AUTO_RESIZE_OFF );
        tableJournalEnergy.setTableHeader( new TableHeaderEnergy( tableJournalEnergy.getColumnModel() ) );
        tableJournalEnergy.setAutoCreateRowSorter( true );
        return scrollPane;
    }

    private JScrollPane get_energy() {
        JScrollPane scrollPane = new JScrollPane( tableEnergy );
        tableEnergy.setModel( modelTableEnergy );
        tableEnergy.setSelectionMode( ListSelectionModel.SINGLE_SELECTION );
        tableEnergy.setFillsViewportHeight( true );
        tableEnergy.setAutoResizeMode( JTable.AUTO_RESIZE_OFF );
        tableEnergy.setTableHeader( new TableHeaderEnergy( tableEnergy.getColumnModel() ) );
        tableEnergy.setAutoCreateRowSorter( true );
        return scrollPane;
    }

    private JScrollPane get_protein_journal() {
        JScrollPane scrollPane = new JScrollPane( tableJournalProtein );
        tableJournalProtein.setModel( modelTableJournalProtein );
        tableJournalProtein.setSelectionMode( ListSelectionModel.SINGLE_SELECTION );
        tableJournalProtein.setFillsViewportHeight( true );
        tableJournalProtein.setAutoResizeMode( JTable.AUTO_RESIZE_OFF );
        tableJournalProtein.setTableHeader( new TableHeaderEnergy( tableJournalProtein.getColumnModel() ) );
        tableJournalProtein.setAutoCreateRowSorter( true );
        return scrollPane;
    }

    private JScrollPane get_protein() {
        JScrollPane scrollPane = new JScrollPane( tableProtein );
        tableProtein.setModel( modelTableProtein );
        tableProtein.setSelectionMode( ListSelectionModel.SINGLE_SELECTION );
        tableProtein.setFillsViewportHeight( true );
        tableProtein.setAutoResizeMode( JTable.AUTO_RESIZE_OFF );
        tableProtein.setTableHeader( new TableHeaderProtein( tableProtein.getColumnModel() ) );
        tableProtein.setAutoCreateRowSorter( true );
        return scrollPane;
    }

    private JScrollPane get_fats_journal() {
        JScrollPane scrollPane = new JScrollPane( tableJournalFats );
        tableJournalFats.setModel( modelTableJournalFats );
        tableJournalFats.setSelectionMode( ListSelectionModel.SINGLE_SELECTION );
        tableJournalFats.setFillsViewportHeight( true );
        tableJournalFats.setAutoResizeMode( JTable.AUTO_RESIZE_OFF );
        tableJournalFats.setTableHeader( new TableHeaderFats( tableJournalFats.getColumnModel() ) );
        tableJournalFats.setAutoCreateRowSorter( true );
        return scrollPane;
    }

    private JScrollPane get_fats() {
        JScrollPane scrollPane = new JScrollPane( tableFats );
        tableFats.setModel( modelTableFats );
        tableFats.setSelectionMode( ListSelectionModel.SINGLE_SELECTION );
        tableFats.setFillsViewportHeight( true );
        tableFats.setAutoResizeMode( JTable.AUTO_RESIZE_OFF );
        tableFats.setTableHeader( new TableHeaderFats( tableFats.getColumnModel() ) );
        tableFats.setAutoCreateRowSorter( true );
        return scrollPane;
    }

    private JScrollPane get_carbs_journal() {
        JScrollPane scrollPane = new JScrollPane( tableJournalCarbs );
        tableJournalCarbs.setModel( modelTableJournalCarbs );
        tableJournalCarbs.setSelectionMode( ListSelectionModel.SINGLE_SELECTION );
        tableJournalCarbs.setFillsViewportHeight( true );
        tableJournalCarbs.setAutoResizeMode( JTable.AUTO_RESIZE_OFF );
        tableJournalCarbs.setTableHeader( new TableHeaderCarbs( tableJournalCarbs.getColumnModel() ) );
        tableJournalCarbs.setAutoCreateRowSorter( true );
        return scrollPane;
    }

    private JScrollPane get_carbs() {
        JScrollPane scrollPane = new JScrollPane( tableCarbs );
        tableCarbs.setModel( modelTableCarbs );
        tableCarbs.setSelectionMode( ListSelectionModel.SINGLE_SELECTION );
        tableCarbs.setFillsViewportHeight( true );
        tableCarbs.setAutoResizeMode( JTable.AUTO_RESIZE_OFF );
        tableCarbs.setTableHeader( new TableHeaderCarbs( tableCarbs.getColumnModel() ) );
        tableCarbs.setAutoCreateRowSorter( true );
        return scrollPane;
    }

    private JScrollPane get_vitamins_journal() {
        JScrollPane scrollPane = new JScrollPane( tableJournalVitamins );
        tableJournalVitamins.setModel( modelTableJournalVitamins );
        tableJournalVitamins.setSelectionMode( ListSelectionModel.SINGLE_SELECTION );
        tableJournalVitamins.setFillsViewportHeight( true );
        tableJournalVitamins.setAutoResizeMode( JTable.AUTO_RESIZE_OFF );
        tableJournalVitamins.setTableHeader( new TableHeaderVitamins( tableJournalVitamins.getColumnModel() ) );
        tableJournalVitamins.setAutoCreateRowSorter( true );
        return scrollPane;
    }

    private JScrollPane get_vitamins() {
        JScrollPane scrollPane = new JScrollPane( tableVitamins );
        tableVitamins.setModel( modelTableVitamins );
        tableVitamins.setSelectionMode( ListSelectionModel.SINGLE_SELECTION );
        tableVitamins.setFillsViewportHeight( true );
        tableVitamins.setAutoResizeMode( JTable.AUTO_RESIZE_OFF );
        tableVitamins.setTableHeader( new TableHeaderVitamins( tableVitamins.getColumnModel() ) );
        tableVitamins.setAutoCreateRowSorter( true );
        return scrollPane;
    }

    private JScrollPane get_minerals_journal() {
        JScrollPane scrollPane = new JScrollPane( tableJournalMinerals );
        tableJournalMinerals.setModel( modelTableJournalMinerals );
        tableJournalMinerals.setSelectionMode( ListSelectionModel.SINGLE_SELECTION );
        tableJournalMinerals.setFillsViewportHeight( true );
        tableJournalMinerals.setAutoResizeMode( JTable.AUTO_RESIZE_OFF );
        tableJournalMinerals.setTableHeader( new TableHeaderMinerals( tableJournalMinerals.getColumnModel() ) );
        tableJournalMinerals.setAutoCreateRowSorter( true );
        return scrollPane;
    }

    private JScrollPane get_minerals() {
        JScrollPane scrollPane = new JScrollPane( tableMinerals );
        tableMinerals.setModel( modelTableMinerals );
        tableMinerals.setSelectionMode( ListSelectionModel.SINGLE_SELECTION );
        tableMinerals.setFillsViewportHeight( true );
        tableMinerals.setAutoResizeMode( JTable.AUTO_RESIZE_OFF );
        tableMinerals.setTableHeader( new TableHeaderMinerals( tableMinerals.getColumnModel() ) );
        tableMinerals.setAutoCreateRowSorter( true );
        return scrollPane;
    }

    private JScrollPane get_electrolytes_journal() {
        JScrollPane scrollPane = new JScrollPane( tableJournalElectrolytes );
        tableJournalElectrolytes.setModel( modelTableJournalElectrolytes );
        tableJournalElectrolytes.setSelectionMode( ListSelectionModel.SINGLE_SELECTION );
        tableJournalElectrolytes.setFillsViewportHeight( true );
        tableJournalElectrolytes.setAutoResizeMode( JTable.AUTO_RESIZE_OFF );
        tableJournalElectrolytes.setTableHeader( new TableHeaderElectrolytes( tableJournalElectrolytes.getColumnModel() ) );
        tableJournalElectrolytes.setAutoCreateRowSorter( true );
        return scrollPane;
    }

    private JScrollPane get_electrolytes() {
        JScrollPane scrollPane = new JScrollPane( tableElectrolytes );
        tableElectrolytes.setModel( modelTableElectrolytes );
        tableElectrolytes.setSelectionMode( ListSelectionModel.SINGLE_SELECTION );
        tableElectrolytes.setFillsViewportHeight( true );
        tableElectrolytes.setAutoResizeMode( JTable.AUTO_RESIZE_OFF );
        tableElectrolytes.setTableHeader( new TableHeaderElectrolytes( tableElectrolytes.getColumnModel() ) );
        tableElectrolytes.setAutoCreateRowSorter( true );
        return scrollPane;
    }

    private JScrollPane get_water_journal() {
        JScrollPane scrollPane = new JScrollPane( tableJournalWater );
        tableJournalWater.setModel( modelTableJournalWater );
        tableJournalWater.setSelectionMode( ListSelectionModel.SINGLE_SELECTION );
        tableJournalWater.setFillsViewportHeight( true );
        tableJournalWater.setAutoResizeMode( JTable.AUTO_RESIZE_OFF );
        tableJournalWater.setTableHeader( new TableHeaderWater( tableJournalWater.getColumnModel() ) );
        tableJournalWater.setAutoCreateRowSorter( true );
        return scrollPane;
    }

    private JScrollPane get_water() {
        JScrollPane scrollPane = new JScrollPane( tableWater );
        tableWater.setModel( modelTableWater );
        tableWater.setSelectionMode( ListSelectionModel.SINGLE_SELECTION );
        tableWater.setFillsViewportHeight( true );
        tableWater.setAutoResizeMode( JTable.AUTO_RESIZE_OFF );
        tableWater.setTableHeader( new TableHeaderWater( tableWater.getColumnModel() ) );
        tableWater.setAutoCreateRowSorter( true );
        return scrollPane;
    }

    private JScrollPane get_cost_journal() {
        JScrollPane scrollPane = new JScrollPane( tableJournalCost );
        tableJournalCost.setModel( modelTableJournalCost );
        tableJournalCost.setSelectionMode( ListSelectionModel.SINGLE_SELECTION );
        tableJournalCost.setFillsViewportHeight( true );
        tableJournalCost.setAutoResizeMode( JTable.AUTO_RESIZE_OFF );
        tableJournalCost.setTableHeader( new TableHeaderCost( tableJournalCost.getColumnModel() ) );
        tableJournalCost.setAutoCreateRowSorter( true );
        return scrollPane;
    }

    private JScrollPane get_cost() {
        JScrollPane scrollPane = new JScrollPane( tableCost );
        tableCost.setModel( modelTableCost );
        tableCost.setSelectionMode( ListSelectionModel.SINGLE_SELECTION );
        tableCost.setFillsViewportHeight( true );
        tableCost.setAutoResizeMode( JTable.AUTO_RESIZE_OFF );
        tableCost.setTableHeader( new TableHeaderCost( tableCost.getColumnModel() ) );
        tableCost.setAutoCreateRowSorter( true );
        return scrollPane;
    }

    private void evt_lst_high_score() {
        modelListHighScore.clear();
    }

    private JPanel get_mix_food() {
        JPanel panel = new JPanel();
        FormLayout panelLayout = new FormLayout( "min:grow,min,min:grow", //columns
                                                 "fill:min:grow" //rows
        );
        panel.setLayout( panelLayout );
        JPanel buttons = new JPanel();
        FormLayout buttonLayout = new FormLayout( "min", //columns
                                                  "min:grow,min,min,min,min,min:grow" //rows
        );
        buttons.setLayout( buttonLayout );
        JScrollPane scrSelectedFood = new JScrollPane( listSelectedFood );
        scrSelectedFood.setBorder( new TitledBorder( "Food" ) );
        JScrollPane s_store = new JScrollPane( treeFoodList );
        s_store.setBorder( new TitledBorder( "Store" ) );
        modelTreeFoodList.reload();
        treeFoodList.setModel( modelTreeFoodList );
        JButton buttonAddMixFood = new JButton( "+" );
        JButton buttonDeleteMixFood = new JButton( "-" );
        JButton buttonExpandMixFood = new JButton( "e" );
        JButton buttonCollapseMixFood = new JButton( "c" );
        buttons.add( buttonAddMixFood, cc.xy( 1, 2 ) );
        buttons.add( buttonDeleteMixFood, cc.xy( 1, 3 ) );
        buttons.add( buttonExpandMixFood, cc.xy( 1, 4 ) );
        buttons.add( buttonCollapseMixFood, cc.xy( 1, 5 ) );
        panel.add( s_store, cc.xy( 1, 1 ) );
        panel.add( buttons, cc.xy( 2, 1 ) );
        panel.add( scrSelectedFood, cc.xy( 3, 1 ) );
        buttonAddMixFood.setToolTipText( "Add Food Item to Mix" );
        buttonDeleteMixFood.setToolTipText( "Delete Food Item from Mix" );
        buttonExpandMixFood.setToolTipText( "Expand Food List" );
        buttonCollapseMixFood.setToolTipText( "Collapse Food List" );
        buttonAddMixFood.addActionListener( e -> evt_btn_mix_food_add() );
        buttonDeleteMixFood.addActionListener( e -> evt_btn_mix_food_delete() );
        buttonExpandMixFood.addActionListener( e -> evt_btn_mix_food_expand() );
        buttonCollapseMixFood.addActionListener( e -> evt_btn_mix_food_collapse() );
        listSelectedFood.setModel( modelListSelectedFood );
        return panel;
    }

    private JPanel get_nutrient_constraint() {
        JPanel panel = new JPanel();
        FormLayout panelLayout = new FormLayout(
                "min,min,min", //columns
                "min,fill:min:grow,min" //rows
        );
        panel.setLayout( panelLayout );
        JScrollPane constraintList = new JScrollPane( tableNutrientConstraint );
        JPanel buttons = new JPanel();
        textFieldNutrientConstraintQuantity.setMinimumSize( new Dimension( 100, 25 ) );
        panel.add( comboBoxNutrientConstraintNutrient, cc.xy( 1, 1 ) );
        panel.add( comboBoxNutrientConstraintRelationship, cc.xy( 2, 1 ) );
        panel.add( textFieldNutrientConstraintQuantity, cc.xy( 3, 1 ) );
        panel.add( constraintList, cc.xyw( 1, 2, 3 ) );
        buttons.add( buttonNutrientConstraintAdd );
        buttons.add( buttonNutrientConstraintDelete );
        panel.add( buttons, cc.xyw( 1, 3, 3 ) );
        constraintList.setBorder( new TitledBorder( "Nutrient Constraints" ) );
        comboBoxNutrientConstraintNutrient.setMaximumRowCount( 10 );
        comboBoxNutrientConstraintNutrient.setModel( modelComboBox_NutrientAtNutrientConstraint );
        comboBoxNutrientConstraintRelationship.setMaximumRowCount( 3 );
        comboBoxNutrientConstraintRelationship.setModel( modelComboBox_RelationshipAtNutrient );
        tableNutrientConstraint.getTableHeader().setReorderingAllowed( false );
        tableNutrientConstraint.setModel( modelTableNutrientConstraints );
        tableNutrientConstraint.setSelectionMode( ListSelectionModel.SINGLE_SELECTION );
        buttonNutrientConstraintAdd.setToolTipText( "Add Constraint" );
        buttonNutrientConstraintDelete.setToolTipText( "Delete Constraint" );
        buttonNutrientConstraintAdd.addActionListener( ( ActionEvent e )
                -> {
            evt_btn_nutrient_constraint_add();
        } );
        buttonNutrientConstraintDelete.addActionListener( ( ActionEvent e )
                -> {
            evt_btn_nutrient_constraint_delete();
        } );
        tableNutrientConstraint.setFillsViewportHeight( true );
        return panel;
    }

    private JPanel get_food_nutrient_constraint() {
        JPanel panel = new JPanel();
        FormLayout panelLayout = new FormLayout(
                "min,min,min,550px", //columns
                "min,min,fill:min:grow,min" //rows
        );
        panel.setLayout( panelLayout );
        JScrollPane spTable = new JScrollPane( tableFoodNutrientConstraint );
        JPanel buttons = new JPanel();
        textFieldFoodNutrientConstraintQuantity.setMinimumSize( new Dimension( 100, 25 ) );
        panel.add( comboBoxFoodNutrientConstraintFood, cc.xyw( 1, 1, 4 ) );
        panel.add( comboBoxFoodNutrientConstraintNutrient, cc.xy( 1, 2 ) );
        panel.add( comboBoxFoodNutrientConstraintRelationship, cc.xy( 2, 2 ) );
        panel.add( textFieldFoodNutrientConstraintQuantity, cc.xy( 3, 2 ) );
        panel.add( spTable, cc.xyw( 1, 3, 4 ) );
        buttons.add( buttonFoodNutrientConstraintAdd );
        buttons.add( buttonFoodNutrientConstraintDelete );
        panel.add( buttons, cc.xyw( 1, 4, 4 ) );
        spTable.setBorder( new TitledBorder( "Food Constraints" ) );
        comboBoxFoodNutrientConstraintNutrient.setMaximumRowCount( 10 );
        comboBoxFoodNutrientConstraintNutrient.setModel( modelComboBox_NutrientAtNutrientPctContraint );
        comboBoxFoodNutrientConstraintRelationship.setMaximumRowCount( 3 );
        comboBoxFoodNutrientConstraintRelationship.setModel( modelComboBox_RelationshipAtFoodNutrient );
        comboBoxFoodNutrientConstraintFood.setMaximumRowCount( 10 );
        comboBoxFoodNutrientConstraintFood.setModel( modelComboBox_FoodAtNutrient );
        tableFoodNutrientConstraint.getTableHeader().setReorderingAllowed( false );
        tableFoodNutrientConstraint.setModel( modelTableFoodNutrientConstraints );
        tableFoodNutrientConstraint.setSelectionMode( ListSelectionModel.SINGLE_SELECTION );
        buttonFoodNutrientConstraintAdd.setToolTipText( "Add Constraint" );
        buttonFoodNutrientConstraintDelete.setToolTipText( "Delete Constraint" );
        buttonFoodNutrientConstraintAdd.addActionListener( ( ActionEvent e )
                -> {
            evt_btn_food_nutrient_constraint_add();
        } );
        buttonFoodNutrientConstraintDelete.addActionListener( ( ActionEvent e )
                -> {
            evt_btn_food_nutrient_constraint_delete();
        } );
        tableFoodNutrientConstraint.setFillsViewportHeight( true );
        return panel;
    }

    private JPanel get_nutrient_ratio_constraint() {
        JPanel panel = new JPanel();
        FormLayout panelLayout = new FormLayout(
                "660px,min,min,min:grow", //columns
                "min,min,fill:min:grow,min" //rows
        );
        panel.setLayout( panelLayout );
        JScrollPane spTable = new JScrollPane( tableNutrientRatio );
        JPanel buttons = new JPanel();
        textFieldNutrientRatioNutrientA.setMinimumSize( new Dimension( 100, 25 ) );
        textFieldNutrientRatioNutrientB.setMinimumSize( new Dimension( 100, 25 ) );
        panel.add( comboBoxNutrientRatioNutrientA, cc.xy( 1, 1 ) );
        panel.add( textFieldNutrientRatioNutrientA, cc.xy( 2, 1 ) );
        panel.add( comboBoxNutrientRatioRelationship, cc.xy( 3, 1 ) );
        panel.add( comboBoxNutrientRatioNutrientB, cc.xy( 1, 2 ) );
        panel.add( textFieldNutrientRatioNutrientB, cc.xy( 2, 2 ) );
        panel.add( spTable, cc.xyw( 1, 3, 4 ) );
        buttons.add( buttonNutrientRatioAdd );
        buttons.add( buttonNutrientRatioDelete );
        panel.add( buttons, cc.xyw( 1, 4, 4 ) );
        spTable.setBorder( new TitledBorder( "Nutrient Ratio Constraints" ) );
        comboBoxNutrientRatioNutrientA.setMaximumRowCount( 10 );
        comboBoxNutrientRatioNutrientA.setModel( modelComboBox_0_NutrientAtNutrientRatio );
        comboBoxNutrientRatioNutrientB.setMaximumRowCount( 10 );
        comboBoxNutrientRatioNutrientB.setModel( modelComboBox_1_NutrientAtNutrientRatio );
        tableNutrientRatio.getTableHeader().setReorderingAllowed( false );
        tableNutrientRatio.setModel( modelTableNutrientRatioConstraints );
        comboBoxNutrientRatioRelationship.setModel( modelComboBox_RelationshipAtNutrientRatio );
        tableNutrientRatio.setSelectionMode( ListSelectionModel.SINGLE_SELECTION );
        buttonNutrientRatioAdd.setToolTipText( "Add Constraint" );
        buttonNutrientRatioDelete.setToolTipText( "Delete Constraint" );
        buttonNutrientRatioAdd.addActionListener( ( ActionEvent e )
                -> {
            evt_btn_nutrient_ratio_add();
        } );
        buttonNutrientRatioDelete.addActionListener( ( ActionEvent e )
                -> {
            evt_btn_nutrient_ratio_delete();
        } );
        tableNutrientRatio.setFillsViewportHeight( true );
        return panel;
    }

    private JPanel get_food_nutrient_ratio_constraint() {
        JPanel panel = new JPanel();
        FormLayout panelLayout = new FormLayout(
                "min,min,min,min:grow", //columns
                "min,min,min,min,fill:min:grow,min" //rows
        );
        panel.setLayout( panelLayout );
        JScrollPane spTable = new JScrollPane( tableFoodNutrientRatio );
        JPanel buttons = new JPanel();
        textFieldFoodNutrientRatioQuantityA.setMinimumSize( new Dimension( 100, 25 ) );
        textFieldFoodNutrientRatioQuantityB.setMinimumSize( new Dimension( 100, 25 ) );
        panel.add( comboBoxFoodNutrientRatioFoodA, cc.xyw( 1, 1, 4 ) );
        panel.add( comboBoxFoodNutrientRatioNutrientA, cc.xy( 1, 2 ) );
        panel.add( textFieldFoodNutrientRatioQuantityA, cc.xy( 2, 2 ) );
        panel.add( comboBoxFoodNutrientRatioRelationship, cc.xy( 3, 2 ) );
        panel.add( comboBoxFoodNutrientRatioFoodB, cc.xyw( 1, 3, 4 ) );
        panel.add( comboBoxFoodNutrientRatioNutrientB, cc.xy( 1, 4 ) );
        panel.add( textFieldFoodNutrientRatioQuantityB, cc.xy( 2, 4 ) );
        panel.add( spTable, cc.xyw( 1, 5, 4 ) );
        buttons.add( buttonFoodNutrientRatioAdd );
        buttons.add( buttonFoodNutrientRatioDelete );
        panel.add( buttons, cc.xyw( 1, 6, 4 ) );
        spTable.setBorder( new TitledBorder( "Food Ratio Constraints" ) );
        comboBoxFoodNutrientRatioNutrientA.setMaximumRowCount( 10 );
        comboBoxFoodNutrientRatioNutrientA.setModel( modelComboBox_0_NutrientAtFoodNutrientRatio );
        comboBoxFoodNutrientRatioNutrientB.setMaximumRowCount( 10 );
        comboBoxFoodNutrientRatioNutrientB.setModel( modelComboBox_1_NutrientAtFoodNutrientRatio );
        comboBoxFoodNutrientRatioFoodA.setMaximumRowCount( 10 );
        comboBoxFoodNutrientRatioFoodA.setModel( modelComboBox_0_FoodAtFoodNutrientRatio );
        comboBoxFoodNutrientRatioFoodB.setMaximumRowCount( 10 );
        comboBoxFoodNutrientRatioFoodB.setModel( modelComboBox_1_FoodAtFoodNutrientRatio );
        tableFoodNutrientRatio.getTableHeader().setReorderingAllowed( false );
        tableFoodNutrientRatio.setModel( modelTableFoodNutrientRatioConstraints );
        tableFoodNutrientRatio.setSelectionMode( ListSelectionModel.SINGLE_SELECTION );
        buttonFoodNutrientRatioAdd.setToolTipText( "Add Constraint" );
        buttonFoodNutrientRatioDelete.setToolTipText( "Delete Constraint" );
        comboBoxFoodNutrientRatioRelationship.setModel( modelComboBox_RelationshipAtFoodNutrientRatio );
        buttonFoodNutrientRatioAdd.addActionListener( ( ActionEvent e )
                -> {
            evt_btn_food_nutrient_ratio_add();
        } );
        buttonFoodNutrientRatioDelete.addActionListener( ( ActionEvent e )
                -> {
            evt_btn_food_nutrient_ratio_delete();
        } );
        tableFoodNutrientRatio.setFillsViewportHeight( true );
        return panel;
    }

    private JPanel get_percent_of_food_nutrient_constraint() {
        JPanel panel = new JPanel();
        FormLayout panelLayout = new FormLayout(
                "min,min,min,min,550px", //columns
                "min,min,fill:min:grow,min" //rows
        );
        panel.setLayout( panelLayout );
        JScrollPane spTable = new JScrollPane( tableNutrientPercentConstraint );
        JPanel buttons = new JPanel();
        textFieldPercentNutrientConstraintQuantity.setMinimumSize( new Dimension( 100, 25 ) );
        panel.add( comboBoxPercentNutrientConstraintFood, cc.xyw( 1, 1, 5 ) );
        panel.add( comboBoxPercentNutrientConstraintNutrient, cc.xy( 1, 2 ) );
        panel.add( comboBoxPercentNutrientRelationship, cc.xy( 2, 2 ) );
        panel.add( textFieldPercentNutrientConstraintQuantity, cc.xy( 3, 2 ) );
        panel.add( new JLabel( "%" ), cc.xy( 3, 2 ) );
        panel.add( spTable, cc.xyw( 1, 3, 5 ) );
        buttons.add( buttonPercentNutrientConstraintAdd );
        buttons.add( buttonPercentNutrientConstraintDelete );
        panel.add( buttons, cc.xyw( 1, 4, 5 ) );
        spTable.setBorder( new TitledBorder( "Foods Constraints (%)" ) );
        comboBoxPercentNutrientConstraintNutrient.setMaximumRowCount( 10 );
        comboBoxPercentNutrientConstraintNutrient.setModel( modelComboBox_NutrientAtNutrientPctContraint );
        comboBoxPercentNutrientConstraintFood.setMaximumRowCount( 10 );
        comboBoxPercentNutrientConstraintFood.setModel( modelComboBox_FoodAtNutrientPct );
        comboBoxPercentNutrientRelationship.setModel( modelComboBox_RelationshipAtNutrientPercent );
        tableNutrientPercentConstraint.getTableHeader().setReorderingAllowed( false );
        tableNutrientPercentConstraint.setModel( tableModelPercentNutrientConstraints );
        tableNutrientPercentConstraint.setSelectionMode( ListSelectionModel.SINGLE_SELECTION );
        buttonPercentNutrientConstraintAdd.setToolTipText( "Add Constraint" );
        buttonPercentNutrientConstraintDelete.setToolTipText( "Delete Constraint" );
        buttonPercentNutrientConstraintAdd.addActionListener( ( ActionEvent e )
                -> {
            evt_btn_percent_nutrient_constraint_add();
        } );
        buttonPercentNutrientConstraintDelete.addActionListener( ( ActionEvent e )
                -> {
            evt_btn_percent_nutrient_constraint_delete();
        } );
        tableNutrientPercentConstraint.setFillsViewportHeight( true );
        return panel;
    }

    private void evt_btn_percent_nutrient_constraint_delete() {
        if( is_mix_selected() ) {
            try {
                int selectedRow = tableNutrientPercentConstraint.getSelectedRow();
                String mixid = ( String ) tableNutrientPercentConstraint.getValueAt( selectedRow, 0 );
                String foodid = ( String ) tableNutrientPercentConstraint.getValueAt( selectedRow, 1 );
                String nutrientid = ( String ) tableNutrientPercentConstraint.getValueAt( selectedRow, 2 );
                Integer relationshipid = ( Integer ) tableNutrientPercentConstraint.getValueAt( selectedRow, 3 );
                dbLink.PercentNutrientConstraint_Delete( mixid, foodid, nutrientid, relationshipid );
                tableModelPercentNutrientConstraints.reload( mixid );
                resize_col_tbl_percent_nutrient_constraint();
            } catch( SQLException e ) {

            }
        }
    }

    private void evt_btn_percent_nutrient_constraint_add() {
        if( is_mix_selected() ) {
            if( is_it_ready_to_add_percent_nutrient_constraint() ) {
                NumberCheck numberCheck = new NumberCheck();
                numberCheck.addToUncheckedList( textFieldPercentNutrientConstraintQuantity.getText() );
                if( numberCheck.pass() ) {
                    try {
                        MixDataObject mix = ( MixDataObject ) lst_mix.getSelectedValue();
                        FoodDataObject foodDataObject = ( FoodDataObject ) comboBoxPercentNutrientConstraintFood.getSelectedItem();
                        NutrientDataObject nutrientDataObject = ( NutrientDataObject ) comboBoxPercentNutrientConstraintNutrient.getSelectedItem();
                        RelationshipDataObject relationshipDataObject = ( RelationshipDataObject ) comboBoxPercentNutrientRelationship.getSelectedItem();
                        Double b = Double.parseDouble( textFieldPercentNutrientConstraintQuantity.getText() );
                        dbLink.NutrientPercentConstraint_Merge( mix.getMixId(), foodDataObject.getFoodId(), nutrientDataObject.getNutr_no(), relationshipDataObject.getRelationshipid(), b );
                        tableModelPercentNutrientConstraints.reload( mix.getMixId() );
                        resize_col_tbl_percent_nutrient_constraint();
                    } catch( SQLException e ) {

                    }
                }
                else {
                    Message.showMessage( "Value must be a number greater than or equal to zero" );
                }
            }
        }
    }

    private void resize_col_tbl_percent_nutrient_constraint() {
        tableNutrientPercentConstraint.getColumnModel().getColumn( 0 ).setMinWidth( 0 );
        tableNutrientPercentConstraint.getColumnModel().getColumn( 0 ).setMaxWidth( 0 );
        tableNutrientPercentConstraint.getColumnModel().getColumn( 1 ).setMinWidth( 0 );
        tableNutrientPercentConstraint.getColumnModel().getColumn( 1 ).setMaxWidth( 0 );
        tableNutrientPercentConstraint.getColumnModel().getColumn( 2 ).setMinWidth( 0 );
        tableNutrientPercentConstraint.getColumnModel().getColumn( 2 ).setMaxWidth( 0 );
        tableNutrientPercentConstraint.getColumnModel().getColumn( 3 ).setMinWidth( 0 );
        tableNutrientPercentConstraint.getColumnModel().getColumn( 3 ).setMaxWidth( 0 );
        tableNutrientPercentConstraint.getColumnModel().getColumn( 4 ).setMinWidth( 480 );
        tableNutrientPercentConstraint.getColumnModel().getColumn( 4 ).setMaxWidth( 480 );
        tableNutrientPercentConstraint.getColumnModel().getColumn( 5 ).setMinWidth( 250 );
        tableNutrientPercentConstraint.getColumnModel().getColumn( 5 ).setMaxWidth( 250 );
        tableNutrientPercentConstraint.getColumnModel().getColumn( 6 ).setMinWidth( 21 );
        tableNutrientPercentConstraint.getColumnModel().getColumn( 6 ).setMaxWidth( 21 );
    }

    private boolean is_it_ready_to_add_percent_nutrient_constraint() {
        Boolean flag_isReady = false;
        Boolean flag_listFood = false;
        Boolean flag_listNutrient = false;
        Boolean flag_quantity = false;
        if( comboBoxPercentNutrientConstraintFood.getSelectedIndex() != -1 ) {
            flag_listFood = true;
        }
        else {
            Message.showMessage( "Select food" );
        }
        if( comboBoxPercentNutrientConstraintNutrient.getSelectedIndex() != -1 ) {
            flag_listNutrient = true;
        }
        else {
            Message.showMessage( "Select nutrient" );
        }
        if( !textFieldPercentNutrientConstraintQuantity.getText().isEmpty() ) {
            flag_quantity = true;
        }
        else {
            Message.showMessage( "Specify amount" );
        }
        if( flag_listFood && flag_listNutrient && flag_quantity ) {
            flag_isReady = true;
        }
        return flag_isReady;
    }

    private JPanel get_journal_model() {
        JPanel panel = new JPanel();
        //create layouts
        FormLayout layout = new FormLayout(
                "min:grow", //columns
                "fill:pref:grow" //rows
        );
        //specify layouts
        panel.setLayout( layout );
        //place components
        textAreaJournalModel.setLineWrap( false );
        JScrollPane scrollPane = new JScrollPane( textAreaJournalModel );
        scrollPane.setPreferredSize( new Dimension( 0, 0 ) );
        panel.add( scrollPane, cc.xy( 1, 1 ) );
        return panel;
    }

    private JPanel get_model() {
        JPanel panel = new JPanel();
        FormLayout layout = new FormLayout(
                "min:grow", //columns
                "fill:pref:grow" //rows
        );
        panel.setLayout( layout );
        textAreaModel.setLineWrap( false );
        JScrollPane scrollPane = new JScrollPane( textAreaModel );
        scrollPane.setPreferredSize( new Dimension( 0, 0 ) );
        panel.add( scrollPane, cc.xy( 1, 1 ) );
        return panel;
    }

    private void evt_lst_mixes( ListSelectionEvent e ) {
        if( !e.getValueIsAdjusting() ) {
            if( is_mix_selected() ) {
                MixDataObject mixDataObject = ( MixDataObject ) lst_mix.getSelectedValue();
                String mixId = mixDataObject.getMixId();
                modelListSelectedFood.reload( mixId );
                legend_generator.reload( mixId );
                reload_results_table_models();
                reload_food_combo_boxes( mixId );
                reload_table_model_constraints( mixId );
                textAreaModel.setText( mixDataObject.getModel() );
                if( mixDataObject.getNutrientid().equals( "10009" ) ) {
                    lbl_Min.setText( "Calories" );
                }
                else {
                    lbl_Min.setText( "Cost" );
                }
                reload_results_rda_check();
            }
        }
    }

    private void resize_col_tbl_nutrient_constraint() {
        for( int i = 0; i < 3; i++ ) {
            tableNutrientConstraint.getColumnModel().getColumn( i ).setMinWidth( 0 );
            tableNutrientConstraint.getColumnModel().getColumn( i ).setMaxWidth( 0 );
        }
        //Columns missing on purpose
        tableNutrientConstraint.getColumnModel().getColumn( 4 ).setMinWidth( 21 );
        tableNutrientConstraint.getColumnModel().getColumn( 4 ).setMaxWidth( 21 );
    }

    private void evt_lst_mix_compare_a( ListSelectionEvent e ) {
        if( !e.getValueIsAdjusting() ) {
            reload_mix_comparison();
        }
    }

    private void evt_lst_mix_compare_b( ListSelectionEvent e ) {
        if( !e.getValueIsAdjusting() ) {
            reload_mix_comparison();
        }
    }

    private void reload_mix_comparison() {
        if( is_list_mix_compare_a_selected() && is_list_mix_compare_b_selected() ) {
            MixDataObject mix1 = ( MixDataObject ) list_mix_compare_a.getSelectedValue();
            String mixId1 = mix1.getMixId();
            MixDataObject mix2 = ( MixDataObject ) list_mix_compare_b.getSelectedValue();
            String mixId2 = mix2.getMixId();
            model_for_mix_difference_table.reload( mixId1, mixId2 );
            mix_comparison_tablesorter.toggleSortOrder( 1 );
            mix_comparison_tablesorter.sort();
            mix_comparison_tablesorter.toggleSortOrder( 0 );
            mix_comparison_tablesorter.sort();
            resize_col_tbl_mix_comparison();
        }
    }

    private void evt_lst_food_compare_a( ListSelectionEvent e ) {
        if( !e.getValueIsAdjusting() ) {
            reload_food_comparison();
        }
    }

    private void evt_lst_food_compare_b( ListSelectionEvent e ) {
        if( !e.getValueIsAdjusting() ) {
            reload_food_comparison();
        }
    }

    private void reload_food_comparison() {
        if( is_list_food_compare_a_selected() && is_list_food_compare_b_selected() ) {
            FoodDataObject food_a = ( FoodDataObject ) list_food_compare_a.getSelectedValue();
            String food_id_a = food_a.getFoodId();
            FoodDataObject food_b = ( FoodDataObject ) list_food_compare_b.getSelectedValue();
            String food_id_b = food_b.getFoodId();
            model_for_food_difference_table.reload( food_id_a, food_id_b );
            resize_col_tbl_food_comparison();
        }
    }

    private JPanel get_food_categories() {
        JPanel panel = new JPanel();
        FormLayout layout = new FormLayout(
                "4dlu,min:grow,4dlu,min:grow,4dlu,min:grow,4dlu", //columns
                "4dlu,fill:min:grow,4dlu" //rows
        );
        panel.setLayout( layout );
        JPanel buttons00 = new JPanel();
        FormLayout panelButtonsLayout = new FormLayout(
                "min:grow,min,min,min,min:grow", //columns
                "fill:min:grow" //rows
        );
        buttons00.setLayout( panelButtonsLayout );
        buttons00.add( buttonCategoriesAdd, cc.xy( 2, 1 ) );
        buttons00.add( buttonCategoriesDelete, cc.xy( 3, 1 ) );
        buttons00.add( buttonCategoriesRename, cc.xy( 4, 1 ) );
        buttonCategoriesAdd.setToolTipText( "Create category" );
        buttonCategoriesDelete.setToolTipText( "Delete category" );
        buttonCategoriesRename.setToolTipText( "Rename category" );
        JScrollPane list00 = new JScrollPane( listCategories );
        //
        JPanel buttons01 = new JPanel();
        FormLayout panelButtons01Layout = new FormLayout(
                "min:grow,min,min,min:grow", //columns
                "fill:min:grow" //rows
        );
        buttons01.setLayout( panelButtons01Layout );
        JButton buttonAddFoodToCategory = new JButton( "+" );
        JButton buttonDeleteFoodFromCategory = new JButton( "-" );
        buttons01.add( buttonAddFoodToCategory, cc.xy( 2, 1 ) );
        buttons01.add( buttonDeleteFoodFromCategory, cc.xy( 3, 1 ) );
        buttonAddFoodToCategory.setToolTipText( "Add 'All Food Item' to category" );
        buttonDeleteFoodFromCategory.setToolTipText( "Remove food item from category" );
        JScrollPane sp01 = new JScrollPane( listFoodInCategory );
        //
        JPanel panel00 = new JPanel();
        FormLayout layout00 = new FormLayout(
                "min:grow", //columns
                "fill:min:grow,4dlu,min" //rows
        );
        panel00.setLayout( layout00 );
        panel00.add( list00, cc.xy( 1, 1 ) );
        panel00.add( buttons00, cc.xy( 1, 3 ) );
        panel00.setBorder( new TitledBorder( "Categories" ) );
        //
        JPanel panel01 = new JPanel();
        panel01.setLayout( layout00 );
        panel01.add( sp01, cc.xy( 1, 1 ) );
        panel01.add( buttons01, cc.xy( 1, 3 ) );
        panel01.setBorder( new TitledBorder( "Food Items in Category" ) );
        //
        JPanel panel02 = new JPanel();
        FormLayout layout02 = new FormLayout(
                "min,min:grow", //columns
                "fill:16dlu,6dlu,fill:min:grow" //rows
        );
        panel02.setLayout( layout02 );
        JScrollPane sp02 = new JScrollPane( listAllFoodItems );
        JLabel label = new JLabel( "Search: " );
        panel02.add( label, cc.xy( 1, 1 ) );
        JTextField textFieldSearch = new JTextField();
        panel02.add( textFieldSearch, cc.xy( 2, 1 ) );
        panel02.add( sp02, cc.xyw( 1, 3, 2 ) );
        panel02.setBorder( new TitledBorder( "All Food Item" ) );
        //
        panel.add( panel00, cc.xy( 2, 2 ) );
        panel.add( panel01, cc.xy( 4, 2 ) );
        panel.add( panel02, cc.xy( 6, 2 ) );
        //
        listCategories.setModel( modelListCategory );
        modelListCategory.reload();
        listFoodInCategory.setModel( modelListFoodInCategory );
        listAllFoodItems.setModel( modelListFood );
        reload_food_items();
        //
        buttonCategoriesAdd.addActionListener( ( ActionEvent e )
                -> {
            evt_btn_categories_add();
        } );
        buttonCategoriesRename.addActionListener( ( ActionEvent e )
                -> {
            evt_btn_categories_rename();
        } );
        buttonCategoriesDelete.addActionListener( ( ActionEvent e )
                -> {
            evt_btn_categories_delete();
        } );
        listCategories.addListSelectionListener( ( ListSelectionEvent e )
                -> {
            evt_lst_categories( e );
        } );
        buttonAddFoodToCategory.addActionListener( ( ActionEvent e )
                -> {
            evt_btn_category_add_food();
        } );
        buttonDeleteFoodFromCategory.addActionListener( ( ActionEvent e )
                -> {
            evt_btn_category_delete_food();
        } );
        textFieldSearch.addActionListener( ( ActionEvent e )
                -> {
            evt_fld_search( e );
        } );
        return panel;
    }

    private void evt_fld_search( ActionEvent e ) {
        modelListFood.reload( (( JTextComponent ) e.getSource()).getText() );
    }

    private void evt_btn_category_delete_food() {
        if( !listCategories.isSelectionEmpty() ) {
            try {
                FoodCategoryDataObject foodCategoryDataObject = ( FoodCategoryDataObject ) listCategories.getSelectedValue();
                int[] selectedRows = listFoodInCategory.getSelectedIndices();
                for( int i = 0; i < selectedRows.length; i++ ) {
                    FoodDataObject foodDataObject = ( FoodDataObject ) modelListFoodInCategory.get( selectedRows[ i ] );
                    dbLink.CategoryLink_Delete( foodCategoryDataObject.getFoodCategoryId(), foodDataObject.getFoodId() );
                    dbLink.stopTransaction();
                }
                reload_food_items();
                modelListFoodInCategory.reload( foodCategoryDataObject.getFoodCategoryId() );
            } catch( SQLException e ) {

            }
        }
    }

    private void evt_btn_category_add_food() {
        if( !listCategories.isSelectionEmpty() ) {
            if( !listAllFoodItems.isSelectionEmpty() ) {
                try {
                    FoodCategoryDataObject foodCategoryDataObject = ( FoodCategoryDataObject ) listCategories.getSelectedValue();
                    int[] selectedRows = listAllFoodItems.getSelectedIndices();
                    for( int i = 0; i < selectedRows.length; i++ ) {
                        FoodDataObject foodDataObject = ( FoodDataObject ) modelListFood.get( selectedRows[ i ] );
                        Integer count = dbLink.CategoryLink_Count( foodCategoryDataObject.getFoodCategoryId(), foodDataObject.getFoodId() );
                        if( count == 0 ) {
                            dbLink.CategoryLink_Insert( foodCategoryDataObject.getFoodCategoryId(), foodDataObject.getFoodId() );
                            dbLink.stopTransaction();
                            reload_food_items();
                            modelListFoodInCategory.reload( foodCategoryDataObject.getFoodCategoryId() );
                        }
                    }
                } catch( SQLException e ) {

                }
            }
        }
    }

    private void evt_lst_categories( ListSelectionEvent e ) {
        if( !e.getValueIsAdjusting() ) {
            if( !listCategories.isSelectionEmpty() ) {
                FoodCategoryDataObject foodCategoryDataObject = ( FoodCategoryDataObject ) listCategories.getSelectedValue();
                String foodCategoryId = foodCategoryDataObject.getFoodCategoryId();
                modelListFoodInCategory.reload( foodCategoryId );
            }
        }
    }

    private void evt_btn_nutrient_lookup() {
        reload_nutrient_lookup();
    }

    private void reload_nutrient_lookup() {
        NutrientDataObject nutrientDataObject = ( NutrientDataObject ) comboBoxNutrientLookupListNutrient.getSelectedItem();
        try {
            String text = textFieldNutrientLookup.getText();
            if( !text.isBlank() ) {
                Double q = Double.parseDouble( text );
                modelTableNutrientLookup.reload( nutrientDataObject.getNutr_no(), q );
                resize_col_tbl_nutrient_lookup();
            }
        } catch( NumberFormatException e ) {
            Message.showMessage( e.toString() );
        }
    }

    private void evt_btn_mix_food_add() {
        if( is_mix_selected() ) {
            MixDataObject mix = ( MixDataObject ) lst_mix.getSelectedValue();
            DefaultMutableTreeNode node = ( DefaultMutableTreeNode ) treeFoodList.getLastSelectedPathComponent();
            if( node == null ) {
                return;
            }
            FoodDataObject food = ( FoodDataObject ) node.getUserObject();
            if( node.isLeaf() ) {
                try {
                    String mixId = mix.getMixId();
                    dbLink.MixFood_Insert( mixId, food.getFoodId() );
                    modelListSelectedFood.reload( mixId );
                    legend_generator.reload( mixId );
                    reload_food_combo_boxes( mixId );
                } catch( SQLException e ) {

                }
            }
        }
        else {
            Message.showMessage( "Select mix" );
        }
    }

    private void evt_btn_mix_food_delete() {
        if( is_mix_selected() ) {
            if( is_food_selected() ) {
                try {
                    MixDataObject mix = ( MixDataObject ) lst_mix.getSelectedValue();
                    FoodDataObject foodDataObject = ( FoodDataObject ) listSelectedFood.getSelectedValue();
                    String mixId = mix.getMixId();
                    dbLink.MixFood_Delete( mixId, foodDataObject.getFoodId() );
                    modelListSelectedFood.reload( mixId );
                    legend_generator.reload( mixId );
                    reload_food_combo_boxes( mixId );
                    reload_table_model_constraints( mixId );
                    reload_results_table_models();
                } catch( SQLException e ) {

                }
            }
        }
    }

    private void evt_btn_mix_food_expand() {
        int rowCount = treeFoodList.getRowCount();
        this.expand_all_nodes( treeFoodList, 0, rowCount );
    }

    private void expand_all_nodes( JTree tree, int startingIndex, int rowCount ) {
        for( int i = startingIndex; i < rowCount; ++i ) {
            tree.expandRow( i );
        }
        if( tree.getRowCount() != rowCount ) {
            expand_all_nodes( tree, rowCount, tree.getRowCount() );
        }
    }

    private void evt_btn_mix_food_collapse() {
        int rowCount = treeFoodList.getRowCount();
        for( int i = 1; i < rowCount; i++ ) {
            treeFoodList.collapseRow( i );
        }
    }

    private void evt_btn_undo() {
        if( is_mix_selected() ) {
            MixDataObject mix = ( MixDataObject ) lst_mix.getSelectedValue();
            dbLink.revertTransaction();
            reload_mixes();
            int index = modelList_Solve.find_by_mixid( mix.getMixId() );
            lst_mix.setSelectedIndex( index );
        }
        else {
            Message.showMessage( "Select mix." );
        }

    }

    private void evt_btn_solve() {
        if( is_mix_selected() ) {
            try {
                MixDataObject mix = ( MixDataObject ) lst_mix.getSelectedValue();
                String mixId = mix.getMixId();
                textAreaModel.setText( "" );
                LpModel lpModel = new LpModel();
                lpModel.setComponent( get_no_feasible_solution_panel() );
                //Add objective
                lpModel.addObjective( dbLink.objective_lhs( mixId ) );
                //Add nutrient constraint
                LinkedList nutrient_constraints = ( LinkedList ) dbLink.nutrient_rhs( mixId );
                for( int i = 0; i < nutrient_constraints.size(); i++ ) {
                    HashMap row = ( HashMap ) nutrient_constraints.get( i );
                    String nutrientid = ( String ) row.get( "NUTRIENTID" );
                    Integer relationshipid = ( Integer ) row.get( "RELATIONSHIPID" );
                    Double b = ( Double ) row.get( "B" );
                    lpModel.addConstraint( dbLink.nutrient_lhs( mixId, nutrientid, relationshipid ), relationshipid, b );
                }
                //Add food nutrient constraint
                LinkedList foodnutrientRhsList = ( LinkedList ) dbLink.foodnutrient_rhs( mixId );
                for( int i = 0; i < foodnutrientRhsList.size(); i++ ) {
                    HashMap row = ( HashMap ) foodnutrientRhsList.get( i );
                    String foodid = ( String ) row.get( "FOODID" );
                    String nutrientid = ( String ) row.get( "NUTRIENTID" );
                    Integer relationshipid = ( Integer ) row.get( "RELATIONSHIPID" );
                    Double b = ( double ) row.get( "B" );
                    lpModel.addConstraint( dbLink.foodnutrient_lhs( mixId, foodid, nutrientid, relationshipid ), relationshipid, b );
                }
                //Add food nutrient ratio constraint
                LinkedList foodnutrientratioRhsList = ( LinkedList ) dbLink.foodnutrientratio_rhs( mixId );
                for( int i = 0; i < foodnutrientratioRhsList.size(); i++ ) {
                    HashMap row = ( HashMap ) foodnutrientratioRhsList.get( i );
                    String foodid1 = ( String ) row.get( "FOOD_ID_1" );
                    String nutrientid1 = ( String ) row.get( "NUTRIENT_ID_1" );
                    String foodid2 = ( String ) row.get( "FOOD_ID_2" );
                    String nutrientid2 = ( String ) row.get( "NUTRIENT_ID_2" );
                    int relationshipid = ( int ) row.get( "RELATIONSHIPID" );
                    Double b = ( Double ) row.get( "B" );
                    lpModel.addConstraint( dbLink.foodnutrientratio_lhs( mixId, foodid1, nutrientid1, foodid2, nutrientid2, relationshipid ), relationshipid, b );
                }
                //Add nutrient ratio constraint
                LinkedList nutrientratioRhsList = ( LinkedList ) dbLink.nutrientratio_rhs( mixId );
                for( int i = 0; i < nutrientratioRhsList.size(); i++ ) {
                    HashMap row = ( HashMap ) nutrientratioRhsList.get( i );
                    String nutrientid1 = ( String ) row.get( "NUTRIENT_ID_1" );
                    String nutrientid2 = ( String ) row.get( "NUTRIENT_ID_2" );
                    int relationshipid = ( int ) row.get( "RELATIONSHIPID" );
                    Double b = ( Double ) row.get( "B" );
                    lpModel.addConstraint( dbLink.nutrientratio_lhs( mixId, nutrientid1, nutrientid2, relationshipid ), relationshipid, b );
                }
                //Add percent of total nutrient constraint
                LinkedList percentnutrientRhsList = ( LinkedList ) dbLink.percentnutrient_rhs( mixId );
                for( int i = 0; i < percentnutrientRhsList.size(); i++ ) {
                    HashMap row = ( HashMap ) percentnutrientRhsList.get( i );
                    String foodid = ( String ) row.get( "FOODID" );
                    String nutrientid = ( String ) row.get( "NUTRIENTID" );
                    Integer relationshipid = ( Integer ) row.get( "RELATIONSHIPID" );;
                    Double b = ( double ) row.get( "B" );
                    lpModel.addConstraint( dbLink.percentnutrient_lhs( mixId, foodid, nutrientid, b ), relationshipid, 0 );
                }
                String pattern = "yyyy-MMMMM-dd'_at_'HH-mm-ss";
                SimpleDateFormat dateFormat = new SimpleDateFormat( pattern );
                Date date = new Date();
                String stringDate = dateFormat.format( date );
                lpModel.setTitle( mix.getName() );
                lpModel.setDate( stringDate );
                lpModel.setVariables( get_food_legend( mixId ) );
                StringBuilder sbResults = new StringBuilder();
                StringBuilder sbAll = new StringBuilder();
                if( lpModel.solve() ) {
                    double objective_function_value = lpModel.getCost();
                    double[] point = lpModel.getPoint();
                    DecimalFormat formatter = new DecimalFormat( "####.###" );
                    modelListHighScore.addElement( formatter.format( objective_function_value ) );
                    listHighScore.ensureIndexIsVisible( modelListHighScore.getSize() - 1 );
                    listHighScore.setSelectedIndex( listHighScore.getLastVisibleIndex() );
                    sbResults.append( lbl_Min.getText() ).append( ": " ).append( formatter.format( objective_function_value ) );
                    sbResults.append( "\n" );
                    DecimalFormat formatter2 = new DecimalFormat( "####.###" );
                    for( int i = 0; i < point.length; i++ ) {
                        sbResults.append( "x" );
                        sbResults.append( i );
                        sbResults.append( " = " );
                        sbResults.append( formatter2.format( point[ i ] ) );
                        sbResults.append( " g " );
                        sbResults.append( " = " );
                        sbResults.append( formatter2.format( point[ i ] / 28.3495 ) );
                        sbResults.append( " oz" );
                        sbResults.append( "\n" );
                    }
                    sbResults.setLength( sbResults.length() - 1 );
                    LinkedList mixfoodlist = ( LinkedList ) dbLink.MixFood_Select( mixId );
                    for( int i = 0; i < mixfoodlist.size(); i++ ) {
                        HashMap row = ( HashMap ) mixfoodlist.get( i );
                        String foodid = ( String ) row.get( "FOODID" );
                        double v = point[ i ];
                        dbLink.MixFood_Update( mixId, foodid, v );
                    }
                    dbLink.fill_mixresult( mixId );
                    dbLink.delete_mixresultdn( mixId );
                    dbLink.fill_mixresultdn( mixId );
                    lpModel.setResults( sbResults.toString() );
                    lpModel.save();
                    sbAll.append( "/*\n" );
                    sbAll.append( lpModel.getDescription() );
                    sbAll.append( "\n*/" );
                    sbAll.append( "\n\n" );
                    sbAll.append( lpModel.getModel() );
                    sbAll.append( "\n\n" );
                    sbAll.append( "/*\n" );
                    sbAll.append( lpModel.getResults() );
                    sbAll.append( "\n*/" );
                    sbAll.append( "\n\n" );
                    sbAll.append( "/*\n" );
                    sbAll.append( lpModel.getFeasibleMessage() );
                    sbAll.append( "\n*/" );
                    dbLink.Mix_Update_Time( mixId );
                    dbLink.Mix_Update_Other( mixId, sbAll.toString() );
                    reload_results_table_models();
                    reload_food_comparison();
                    reload_mix_comparison();
                    reload_results_rda_check();
                    dbLink.allocate( mixId );
                    int journal_mix_index = list_journal_mix.getSelectedIndex();
                    reload_mixes();
                    list_journal_mix.setSelectedIndex( journal_mix_index );
                    int mix_index = modelList_Solve.find_by_mixid( mixId );
                    lst_mix.setSelectedIndex( mix_index );
                    dbLink.stopTransaction();
                }
                else {
                    sbAll.append( "/*\n" );
                    sbAll.append( lpModel.getDescription() );
                    sbAll.append( "\n*/" );
                    sbAll.append( "\n\n" );
                    sbAll.append( lpModel.getModel() );
                    sbAll.append( "\n\n" );
                    sbAll.append( "/*\n" );
                    sbAll.append( lpModel.getResults() );
                    sbAll.append( "\n*/" );
                    sbAll.append( "\n\n" );
                    sbAll.append( "/*\n" );
                    sbAll.append( lpModel.getInfeasibleMessage() );
                    sbAll.append( "\n*/" );
                    dbLink.Mix_Update_Time( mixId );
                    dbLink.Mix_Update_Other( mixId, sbAll.toString() );
                }
                textAreaModel.setText( sbAll.toString() );
            } catch( SQLException e ) {

            }
        }
    }

    private String get_food_legend( String mixId ) throws SQLException {
        StringBuilder sb = new StringBuilder();
        Object[] objects = legend_generator.toArray();
        int size = objects.length;
        for( int i = 0; i < size; i++ ) {
            FoodDataObject food = ( FoodDataObject ) objects[ i ];
            sb.append( "x" );
            sb.append( i );
            sb.append( ": " );
            sb.append( food.getFoodName() );
            sb.append( "\n" );
        }
        if( sb.length() > 0 ) {
            sb.setLength( sb.length() - 1 );
        }
        return sb.toString();
    }

    private void evt_btn_nutrient_constraint_add() {
        if( is_mix_selected() ) {
            if( is_it_ready_to_add_nutrient_constraint() ) {
                NumberCheck numberCheck = new NumberCheck();
                numberCheck.addToUncheckedList( textFieldNutrientConstraintQuantity.getText() );
                if( numberCheck.pass() ) {
                    try {
                        MixDataObject mix = ( MixDataObject ) lst_mix.getSelectedValue();
                        NutrientDataObject nutrientDataObject = ( NutrientDataObject ) comboBoxNutrientConstraintNutrient.getSelectedItem();
                        RelationshipDataObject relationshipDataObject = ( RelationshipDataObject ) comboBoxNutrientConstraintRelationship.getSelectedItem();
                        double b = Double.parseDouble( textFieldNutrientConstraintQuantity.getText() );
                        dbLink.NutrientConstraint_Merge( mix.getMixId(), nutrientDataObject.getNutr_no(), relationshipDataObject.getRelationshipid(), b );
                        modelTableNutrientConstraints.reload( mix.getMixId() );
                        resize_col_tbl_nutrient_constraint();
                    } catch( SQLException e ) {

                    }
                }
                else {
                    Message.showMessage( "Value must be a number greater than or equal to zero" );
                }
            }
        }
        else {
            Message.showMessage( "Select mix" );
        }
    }

    private Boolean is_it_ready_to_add_nutrient_constraint() {
        Boolean flag_isReady = false;
        Boolean flag_listNutrient = false;
        Boolean flag_listNutrientRelationship = false;
        Boolean flag_textFieldNutrientConstraint = false;
        if( comboBoxNutrientConstraintNutrient.getSelectedIndex() != -1 ) {
            flag_listNutrient = true;
        }
        else {
            Message.showMessage( "Select nutrient" );
        }
        if( comboBoxNutrientConstraintRelationship.getSelectedIndex() != -1 ) {
            flag_listNutrientRelationship = true;
        }
        else {
            Message.showMessage( "Select relationship" );
        }
        if( !textFieldNutrientConstraintQuantity.getText().isEmpty() ) {
            flag_textFieldNutrientConstraint = true;
        }
        else {
            Message.showMessage( "Specify amount" );
        }
        if( flag_listNutrient && flag_listNutrientRelationship && flag_textFieldNutrientConstraint ) {
            flag_isReady = true;
        }
        return flag_isReady;
    }

    private void evt_btn_nutrient_constraint_delete() {
        if( is_mix_selected() ) {
            try {
                int selectedRow = tableNutrientConstraint.getSelectedRow();
                String mixid = ( String ) tableNutrientConstraint.getValueAt( selectedRow, 0 );
                String nutrientid = ( String ) tableNutrientConstraint.getValueAt( selectedRow, 1 );
                Integer relationshipid = ( Integer ) tableNutrientConstraint.getValueAt( selectedRow, 2 );
                dbLink.NutrientConstraint_Delete( mixid, nutrientid, relationshipid );
                modelTableNutrientConstraints.reload( mixid );
                resize_col_tbl_nutrient_constraint();
            } catch( SQLException e ) {

            }
        }
    }

    private void evt_btn_food_nutrient_constraint_add() {
        if( is_mix_selected() ) {
            if( is_it_ready_to_add_food_nutrient_constraint() ) {
                NumberCheck numberCheck = new NumberCheck();
                numberCheck.addToUncheckedList( textFieldFoodNutrientConstraintQuantity.getText() );
                if( numberCheck.pass() ) {
                    try {
                        MixDataObject mix = ( MixDataObject ) lst_mix.getSelectedValue();
                        FoodDataObject foodDataObject = ( FoodDataObject ) comboBoxFoodNutrientConstraintFood.getSelectedItem();
                        NutrientDataObject nutrientDataObject = ( NutrientDataObject ) comboBoxFoodNutrientConstraintNutrient.getSelectedItem();
                        RelationshipDataObject relationshipDataObject = ( RelationshipDataObject ) comboBoxFoodNutrientConstraintRelationship.getSelectedItem();
                        double b = Double.parseDouble( textFieldFoodNutrientConstraintQuantity.getText() );
                        dbLink.FoodNutrientConstraint_Merge( mix.getMixId(), foodDataObject.getFoodId(), nutrientDataObject.getNutr_no(), relationshipDataObject.getRelationshipid(), b );
                        modelTableFoodNutrientConstraints.reload( mix.getMixId() );
                        resize_col_tbl_food_nutrient_constraint();
                    } catch( SQLException e ) {

                    }
                }
                else {
                    Message.showMessage( "Value must be a number greater than or equal to zero" );
                }
            }
        }
    }

    private void evt_btn_meal_food_allocation_add() {
        if( is_mix_journal_selected() ) {
            try {
                MixDataObject mix = ( MixDataObject ) list_journal_mix.getSelectedValue();
                String mixId = mix.getMixId();
                String foodid = (( FoodDataObject ) comboBoxAllocationFood.getSelectedItem()).getFoodId();
                ArrayList selectedValuesList = ( ArrayList ) listAllocationMeal.getSelectedValuesList();
                for( Object o : selectedValuesList ) {
                    O_Meal meal = ( O_Meal ) o;
                    Integer mealid = meal.getMealid();
                    NumberCheck checkNumber = new NumberCheck();
                    checkNumber.addToUncheckedList( textfield_allocation_pct.getText() );
                    if( checkNumber.pass() ) {
                        Double pct = Double.valueOf( textfield_allocation_pct.getText() );
                        int n = selectedValuesList.size();
                        Double pcti = pct / n;
                        dbLink.MealFoodAllocation_insert_and_calculate( mixId, mealid, foodid, pcti );
                        modelTableAllocation.reload( mixId, precision );
                        resize_col_tbl_meal_allocation();
                        Double remaining = dbLink.calculate_remaining_allocation( mixId, foodid, precision );
                        textfield_allocation_remaining.setText( String.valueOf( remaining ) );
                    }
                }
                dbLink.stopTransaction();
            } catch( SQLException e ) {
                e.printStackTrace();
            }
        }
    }

    private Boolean is_it_ready_to_add_food_nutrient_constraint() {
        Boolean flag_isReady = false;
        Boolean flag_listFood = false;
        Boolean flag_listNutrient = false;
        Boolean flag_listRelationship = false;
        Boolean flag_quantity = false;
        if( comboBoxFoodNutrientConstraintFood.getSelectedIndex() != -1 ) {
            flag_listFood = true;
        }
        else {
            Message.showMessage( "Select food" );
        }
        if( comboBoxFoodNutrientConstraintNutrient.getSelectedIndex() != -1 ) {
            flag_listNutrient = true;
        }
        else {
            Message.showMessage( "Select nutrient" );
        }
        if( comboBoxFoodNutrientConstraintRelationship.getSelectedIndex() != -1 ) {
            flag_listRelationship = true;
        }
        else {
            Message.showMessage( "Select relationship" );
        }
        if( !textFieldFoodNutrientConstraintQuantity.getText().isEmpty() ) {
            flag_quantity = true;
        }
        else {
            Message.showMessage( "Specify amount" );
        }
        if( flag_listFood && flag_listNutrient && flag_listRelationship && flag_quantity ) {
            flag_isReady = true;
        }
        return flag_isReady;
    }

    private void resize_col_tbl_food_nutrient_constraint() {
        for( int i = 0; i < 4; i++ ) {
            tableFoodNutrientConstraint.getColumnModel().getColumn( i ).setMinWidth( 0 );
            tableFoodNutrientConstraint.getColumnModel().getColumn( i ).setMaxWidth( 0 );
        }
        tableFoodNutrientConstraint.getColumnModel().getColumn( 4 ).setMinWidth( 480 );
        tableFoodNutrientConstraint.getColumnModel().getColumn( 4 ).setMaxWidth( 480 );
        tableFoodNutrientConstraint.getColumnModel().getColumn( 5 ).setMinWidth( 250 );
        tableFoodNutrientConstraint.getColumnModel().getColumn( 5 ).setMaxWidth( 250 );
        tableFoodNutrientConstraint.getColumnModel().getColumn( 6 ).setMinWidth( 21 );
        tableFoodNutrientConstraint.getColumnModel().getColumn( 6 ).setMaxWidth( 21 );
    }

    private void evt_btn_meal_food_allocation_update_pct() {
        if( is_mix_journal_selected() ) {
            int selectedRow = table_allocation.getSelectedRow();
            if( selectedRow != -1 ) {
                JTextField input = new JTextField();
                input.setPreferredSize( new Dimension( 50, 25 ) );
                JPanel input_panel = new JPanel();
                input_panel.add( new JLabel( "Allocation Pct: " ) );
                input_panel.add( input );
                JComponent[] inputs = new JComponent[] {
                    input_panel
                };
                int optionValue = Message.showOptionDialogOkCancel( inputs, "Update Allocation Percent" );
                if( optionValue == 0 ) {
                    try {
                        MixDataObject mix = ( MixDataObject ) list_journal_mix.getSelectedValue();
                        String mixId = mix.getMixId();
                        String mixid = ( String ) table_allocation.getValueAt( selectedRow, 0 );
                        Integer mealid = ( Integer ) table_allocation.getValueAt( selectedRow, 1 );
                        String foodid = ( String ) table_allocation.getValueAt( selectedRow, 2 );
                        dbLink.MealFoodAllocation_update_pct( mixid, mealid, foodid, Double.valueOf( input.getText() ) );
                        dbLink.stopTransaction();
                        modelTableAllocation.reload( mixId, precision );
                        resize_col_tbl_meal_allocation();
                        Double remaining = dbLink.calculate_remaining_allocation( mixId, foodid, precision );
                        textfield_allocation_remaining.setText( String.valueOf( remaining ) );
                        int index_food = modelComboBox_AllocationFood.find_by_foodid( foodid );
                        //int index_meal = modelComboBox_AllocationMeal.find_by_mealid( mealid );
                        int index_meal = modelList_AllocationMeal.find_by_mealid( mealid );
                        comboBoxAllocationFood.setSelectedIndex( index_food );
                        //comboBoxAllocationMeal.setSelectedIndex( index_meal );
                        listAllocationMeal.setSelectedIndex( index_meal );
                    } catch( SQLException e ) {

                    }
                }
            }
        }
    }

    private void evt_btn_meal_food_allocation_update_weight() {
        if( is_mix_journal_selected() ) {
            JTextField input = new JTextField();
            input.setPreferredSize( new Dimension( 50, 25 ) );
            int selectedRow = table_allocation.getSelectedRow();
            if( selectedRow != -1 ) {
                Double actualwt = ( Double ) table_allocation.getValueAt( selectedRow, 7 );
                input.setText( String.valueOf( actualwt ) );
                JPanel input_panel = new JPanel();
                input_panel.add( new JLabel( "Actual Weight: " ) );
                input_panel.add( input );
                JComponent[] inputs = new JComponent[] {
                    input_panel
                };
                int optionValue = Message.showOptionDialogOkCancel( inputs, "Update Actual Weight" );
                if( optionValue == 0 ) {
                    try {
                        MixDataObject mix = ( MixDataObject ) list_journal_mix.getSelectedValue();
                        String mixId = mix.getMixId();
                        String mixid = ( String ) table_allocation.getValueAt( selectedRow, 0 );
                        Integer mealid = ( Integer ) table_allocation.getValueAt( selectedRow, 1 );
                        String foodid = ( String ) table_allocation.getValueAt( selectedRow, 2 );
                        dbLink.MealFoodAllocation_update_actualwt( mixid, mealid, foodid, Double.valueOf( input.getText() ) );
                        dbLink.stopTransaction();
                        modelTableAllocation.reload( mixId, precision );
                        resize_col_tbl_meal_allocation();
                    } catch( SQLException e ) {

                    }
                }
            }
        }
    }

    private void evt_btn_meal_food_allocation_delete() {
        if( is_mix_journal_selected() ) {
            try {
                MixDataObject mix = ( MixDataObject ) list_journal_mix.getSelectedValue();
                String mixId = mix.getMixId();
                int selectedRow = table_allocation.getSelectedRow();
                if( selectedRow != -1 ) {
                    String mixid = ( String ) table_allocation.getValueAt( selectedRow, 0 );
                    Integer mealid = ( Integer ) table_allocation.getValueAt( selectedRow, 1 );
                    String foodid = ( String ) table_allocation.getValueAt( selectedRow, 2 );
                    dbLink.MealFoodAllocation_delete( mixid, mealid, foodid );
                    dbLink.stopTransaction();
                    modelTableAllocation.reload( mixId, precision );
                    resize_col_tbl_meal_allocation();
                    Double remaining = dbLink.calculate_remaining_allocation( mixId, foodid, precision );
                    textfield_allocation_remaining.setText( String.valueOf( remaining ) );
                    int index_food = modelComboBox_AllocationFood.find_by_foodid( foodid );
                    int index_meal = modelList_AllocationMeal.find_by_mealid( mealid );
                    comboBoxAllocationFood.setSelectedIndex( index_food );
                    //comboBoxAllocationMeal.setSelectedIndex( index_meal );
                    listAllocationMeal.setSelectedIndex( index_meal );
                }
            } catch( SQLException e ) {

            }
        }
    }

    private void evt_btn_food_nutrient_constraint_delete() {
        if( is_mix_selected() ) {
            try {
                int selectedRow = tableFoodNutrientConstraint.getSelectedRow();
                String mixid = ( String ) tableFoodNutrientConstraint.getValueAt( selectedRow, 0 );
                String foodid = ( String ) tableFoodNutrientConstraint.getValueAt( selectedRow, 1 );
                String nutrientid = ( String ) tableFoodNutrientConstraint.getValueAt( selectedRow, 2 );
                Integer relationshipid = ( Integer ) tableFoodNutrientConstraint.getValueAt( selectedRow, 3 );
                dbLink.FoodNutrientConstraint_Delete( mixid, foodid, nutrientid, relationshipid );
                modelTableFoodNutrientConstraints.reload( mixid );
                resize_col_tbl_food_nutrient_constraint();
            } catch( SQLException e ) {

            }
        }
    }

    private void evt_btn_nutrient_ratio_add() {
        if( is_mix_selected() ) {
            if( is_it_ready_to_add_nutrient_ratio_constraint() ) {
                NumberCheck numberCheck = new NumberCheck();
                numberCheck.addToUncheckedList( textFieldNutrientRatioNutrientA.getText() );
                numberCheck.addToUncheckedList( textFieldNutrientRatioNutrientB.getText() );
                if( numberCheck.pass() ) {
                    try {
                        MixDataObject mix = ( MixDataObject ) lst_mix.getSelectedValue();
                        NutrientDataObject nutrientDataObjectA = ( NutrientDataObject ) comboBoxNutrientRatioNutrientA.getSelectedItem();
                        NutrientDataObject nutrientDataObjectB = ( NutrientDataObject ) comboBoxNutrientRatioNutrientB.getSelectedItem();
                        RelationshipDataObject relationshipDataObject = ( RelationshipDataObject ) comboBoxNutrientRatioRelationship.getSelectedItem();
                        Double a = Double.parseDouble( textFieldNutrientRatioNutrientA.getText() );
                        Double b = Double.parseDouble( textFieldNutrientRatioNutrientB.getText() );
                        dbLink.NutrientRatio_Merge( mix.getMixId(), nutrientDataObjectA.getNutr_no(), nutrientDataObjectB.getNutr_no(), relationshipDataObject.getRelationshipid(), a, b );
                        modelTableNutrientRatioConstraints.reload( mix.getMixId() );
                        resize_col_tbl_nutrient_ratio_constraint();
                    } catch( SQLException e ) {

                    }
                }
                else {
                    Message.showMessage( "Value must be a number greater than zero" );
                }
            }
        }
    }

    private Boolean is_it_ready_to_add_nutrient_ratio_constraint() {
        Boolean flag_isReady = false;
        Boolean flag_listNutrientA = false;
        Boolean flag_listNutrientB = false;
        Boolean flag_quantityA = false;
        Boolean flag_quantityB = false;
        if( comboBoxNutrientRatioNutrientA.getSelectedIndex() != -1 ) {
            flag_listNutrientA = true;
        }
        else {
            Message.showMessage( "Select nutrient A" );
        }
        if( comboBoxNutrientRatioNutrientA.getSelectedIndex() != -1 ) {
            flag_listNutrientB = true;
        }
        else {
            Message.showMessage( "Select nutrient B" );
        }
        if( !textFieldNutrientRatioNutrientA.getText().isEmpty() ) {
            flag_quantityA = true;
        }
        else {
            Message.showMessage( "Specify amount A" );
        }
        if( !textFieldNutrientRatioNutrientB.getText().isEmpty() ) {
            flag_quantityB = true;
        }
        else {
            Message.showMessage( "Specify amount B" );
        }
        if( flag_listNutrientA && flag_listNutrientB && flag_quantityA && flag_quantityB ) {
            flag_isReady = true;
        }
        return flag_isReady;
    }

    private void resize_col_tbl_nutrient_ratio_constraint() {
        for( int i = 0; i < 4; i++ ) {
            tableNutrientRatio.getColumnModel().getColumn( i ).setMinWidth( 0 );
            tableNutrientRatio.getColumnModel().getColumn( i ).setMaxWidth( 0 );
        }
        //Columns missing on purpose
        tableNutrientRatio.getColumnModel().getColumn( 7 ).setMinWidth( 21 );
        tableNutrientRatio.getColumnModel().getColumn( 7 ).setMaxWidth( 21 );
    }

    private void resize_col_tbl_food_comparison() {
        table_food_comparison.getColumnModel().getColumn( 0 ).setMinWidth( 120 );
        table_food_comparison.getColumnModel().getColumn( 0 ).setMaxWidth( 120 );
        table_food_comparison.getColumnModel().getColumn( 1 ).setMinWidth( 250 );
        table_food_comparison.getColumnModel().getColumn( 1 ).setMaxWidth( 250 );
        for( int i = 2; i < 5; i++ ) {
            table_food_comparison.getColumnModel().getColumn( i ).setMinWidth( 75 );
            table_food_comparison.getColumnModel().getColumn( i ).setMaxWidth( 75 );
        }
    }

    private void resize_col_tbl_mix_comparison() {
        table_mix_comparison.getColumnModel().getColumn( 0 ).setMinWidth( 120 );
        table_mix_comparison.getColumnModel().getColumn( 0 ).setMaxWidth( 120 );
        table_mix_comparison.getColumnModel().getColumn( 1 ).setMinWidth( 250 );
        table_mix_comparison.getColumnModel().getColumn( 1 ).setMaxWidth( 250 );
        for( int i = 2; i < 5; i++ ) {
            table_mix_comparison.getColumnModel().getColumn( i ).setMinWidth( 75 );
            table_mix_comparison.getColumnModel().getColumn( i ).setMaxWidth( 75 );
        }
    }

    private void resize_col_tbl_results_rda() {
        tbl_results_rda.getColumnModel().getColumn( 0 ).setMinWidth( 0 );
        tbl_results_rda.getColumnModel().getColumn( 0 ).setMaxWidth( 0 );
        tbl_results_rda.getColumnModel().getColumn( 1 ).setMinWidth( 310 );
        tbl_results_rda.getColumnModel().getColumn( 1 ).setMaxWidth( 310 );
        for( int i = 2; i < 7; i++ ) {
            tbl_results_rda.getColumnModel().getColumn( i ).setMinWidth( 75 );
            tbl_results_rda.getColumnModel().getColumn( i ).setMaxWidth( 75 );
        }
    }

    private void resize_col_tbl_journal_rda() {
        tbl_journal_rda.getColumnModel().getColumn( 0 ).setMinWidth( 0 );
        tbl_journal_rda.getColumnModel().getColumn( 0 ).setMaxWidth( 0 );
        tbl_journal_rda.getColumnModel().getColumn( 1 ).setMinWidth( 310 );
        tbl_journal_rda.getColumnModel().getColumn( 1 ).setMaxWidth( 310 );
        for( int i = 2; i < 7; i++ ) {
            tbl_journal_rda.getColumnModel().getColumn( i ).setMinWidth( 75 );
            tbl_journal_rda.getColumnModel().getColumn( i ).setMaxWidth( 75 );
        }
    }

    private void resize_col_tbl_nutrient_lookup() {
        tableNutrientLookup.getColumnModel().getColumn( 0 ).setMinWidth( 250 );
        tableNutrientLookup.getColumnModel().getColumn( 0 ).setMaxWidth( 550 );
        tableNutrientLookup.getColumnModel().getColumn( 1 ).setMinWidth( 75 );
        tableNutrientLookup.getColumnModel().getColumn( 1 ).setMaxWidth( 75 );
        tableNutrientLookup.getColumnModel().getColumn( 2 ).setMinWidth( 75 );
        tableNutrientLookup.getColumnModel().getColumn( 2 ).setMaxWidth( 75 );
    }

    private void resize_col_tbl_nutrient_input() {
        tableNutrientInput.getColumnModel().getColumn( 0 ).setMinWidth( 0 );
        tableNutrientInput.getColumnModel().getColumn( 0 ).setMaxWidth( 0 );
        tableNutrientInput.getColumnModel().getColumn( 1 ).setMaxWidth( 150 );
        tableNutrientInput.getColumnModel().getColumn( 2 ).setMaxWidth( 320 );
        tableNutrientInput.getColumnModel().getColumn( 3 ).setMaxWidth( 100 );
    }

    private void resize_col_tbl_check_coefficients() {
        tableCheckCoefficients.getColumnModel().getColumn( 0 ).setMinWidth( 0 );
        tableCheckCoefficients.getColumnModel().getColumn( 0 ).setMaxWidth( 0 );
        tableCheckCoefficients.getColumnModel().getColumn( 1 ).setMaxWidth( 150 );
        tableCheckCoefficients.getColumnModel().getColumn( 2 ).setMaxWidth( 320 );
        tableCheckCoefficients.getColumnModel().getColumn( 3 ).setMaxWidth( 100 );
        tableCheckCoefficients.getColumnModel().getColumn( 4 ).setMaxWidth( 100 );
    }

    private void resize_col_tbl_food_list() {
        tableFoodList01.getColumnModel().getColumn( 0 ).setMinWidth( 0 );
        tableFoodList01.getColumnModel().getColumn( 0 ).setMaxWidth( 0 );
        tableFoodList01.getColumnModel().getColumn( 1 ).setMinWidth( 350 );
    }

    private void evt_btn_nutrient_ratio_delete() {
        if( is_mix_selected() ) {
            try {
                int selectedRow = tableNutrientRatio.getSelectedRow();
                String mixid = ( String ) tableNutrientRatio.getValueAt( selectedRow, 0 );
                String nutrientidA = ( String ) tableNutrientRatio.getValueAt( selectedRow, 1 );
                String nutrientidB = ( String ) tableNutrientRatio.getValueAt( selectedRow, 2 );
                Integer relationshipid = ( Integer ) tableNutrientRatio.getValueAt( selectedRow, 3 );
                dbLink.NutrientRatio_Delete( mixid, nutrientidA, nutrientidB, relationshipid );
                modelTableNutrientRatioConstraints.reload( mixid );
                resize_col_tbl_nutrient_ratio_constraint();
            } catch( SQLException e ) {

            }
        }
    }

    private void evt_btn_food_nutrient_ratio_add() {
        if( is_mix_selected() ) {
            if( is_it_ready_to_add_food_nutrient_ratio_constraint() ) {
                NumberCheck numberCheck = new NumberCheck();
                numberCheck.addToUncheckedList( textFieldFoodNutrientRatioQuantityA.getText() );
                numberCheck.addToUncheckedList( textFieldFoodNutrientRatioQuantityB.getText() );
                if( numberCheck.pass() ) {
                    try {
                        MixDataObject mix = ( MixDataObject ) lst_mix.getSelectedValue();
                        FoodDataObject foodDataObjectA = ( FoodDataObject ) comboBoxFoodNutrientRatioFoodA.getSelectedItem();
                        NutrientDataObject nutrientDataObjectA = ( NutrientDataObject ) comboBoxFoodNutrientRatioNutrientA.getSelectedItem();
                        FoodDataObject foodDataObjectB = ( FoodDataObject ) comboBoxFoodNutrientRatioFoodB.getSelectedItem();
                        NutrientDataObject nutrientDataObjectB = ( NutrientDataObject ) comboBoxFoodNutrientRatioNutrientB.getSelectedItem();
                        Double a = Double.parseDouble( textFieldFoodNutrientRatioQuantityA.getText() );
                        Double b = Double.parseDouble( textFieldFoodNutrientRatioQuantityB.getText() );
                        RelationshipDataObject relationshipDataObject = ( RelationshipDataObject ) comboBoxFoodNutrientRatioRelationship.getSelectedItem();
                        dbLink.FoodNutrientRatio_Merge( mix.getMixId(), foodDataObjectA.getFoodId(), nutrientDataObjectA.getNutr_no(), foodDataObjectB.getFoodId(), nutrientDataObjectB.getNutr_no(), relationshipDataObject.getRelationshipid(), a, b );
                        modelTableFoodNutrientRatioConstraints.reload( mix.getMixId() );
                        resize_col_tbl_food_nutrient_ratio_constraint();
                    } catch( SQLException e ) {

                    }
                }
                else {
                    Message.showMessage( "Value must be number greater than zero" );
                }
            }
        }
    }

    private Boolean is_it_ready_to_add_food_nutrient_ratio_constraint() {
        Boolean flag_isReady = false;
        Boolean flag_listFoodA = false;
        Boolean flag_listNutrientA = false;
        Boolean flag_quantityA = false;
        Boolean flag_listFoodB = false;
        Boolean flag_listNutrientB = false;
        Boolean flag_quantityB = false;
        if( comboBoxFoodNutrientRatioFoodA.getSelectedIndex() != -1 ) {
            flag_listFoodA = true;
        }
        else {
            Message.showMessage( "Select food A" );
        }
        if( comboBoxFoodNutrientRatioNutrientA.getSelectedIndex() != -1 ) {
            flag_listNutrientA = true;
        }
        else {
            Message.showMessage( "Select nutrient A" );
        }
        if( !textFieldFoodNutrientRatioQuantityA.getText().isEmpty() ) {
            flag_quantityA = true;
        }
        else {
            Message.showMessage( "Specify amount A" );
        }
        if( comboBoxFoodNutrientRatioFoodB.getSelectedIndex() != -1 ) {
            flag_listFoodB = true;
        }
        else {
            Message.showMessage( "Select food B" );
        }
        if( comboBoxFoodNutrientRatioNutrientB.getSelectedIndex() != -1 ) {
            flag_listNutrientB = true;
        }
        else {
            Message.showMessage( "Select nutrient B" );
        }
        if( !textFieldFoodNutrientRatioQuantityB.getText().isEmpty() ) {
            flag_quantityB = true;
        }
        else {
            Message.showMessage( "Specify amount B" );
        }
        if( flag_listFoodA && flag_listNutrientA && flag_quantityA && flag_listFoodB && flag_listNutrientB && flag_quantityB ) {
            flag_isReady = true;
        }
        return flag_isReady;
    }

    private void resize_col_tbl_food_nutrient_ratio_constraint() {
        for( int i = 0; i < 6; i++ ) {
            tableFoodNutrientRatio.getColumnModel().getColumn( i ).setMinWidth( 0 );
            tableFoodNutrientRatio.getColumnModel().getColumn( i ).setMaxWidth( 0 );
        }
        //Columns missing on purpose
        tableFoodNutrientRatio.getColumnModel().getColumn( 11 ).setMinWidth( 21 );
        tableFoodNutrientRatio.getColumnModel().getColumn( 11 ).setMaxWidth( 21 );
    }

    private void evt_btn_food_nutrient_ratio_delete() {
        if( is_mix_selected() ) {
            try {
                int selectedRow = tableFoodNutrientRatio.getSelectedRow();
                String mixid = ( String ) tableFoodNutrientRatio.getValueAt( selectedRow, 0 );
                String foodidA = ( String ) tableFoodNutrientRatio.getValueAt( selectedRow, 1 );
                String nutrientidA = ( String ) tableFoodNutrientRatio.getValueAt( selectedRow, 2 );
                String foodidB = ( String ) tableFoodNutrientRatio.getValueAt( selectedRow, 3 );
                String nutrientidB = ( String ) tableFoodNutrientRatio.getValueAt( selectedRow, 4 );
                Integer relationshipid = ( Integer ) tableFoodNutrientRatio.getValueAt( selectedRow, 5 );
                dbLink.FoodNutrientRatio_Delete( mixid, foodidA, nutrientidA, foodidB, nutrientidB, relationshipid );
                modelTableFoodNutrientRatioConstraints.reload( mixid );
                resize_col_tbl_food_nutrient_ratio_constraint();
            } catch( SQLException e ) {

            }
        }
    }

    private boolean is_food_selected() {
        return !listSelectedFood.isSelectionEmpty();
    }

    private boolean is_mix_selected() {
        return !lst_mix.isSelectionEmpty();
    }

    private boolean is_mix_journal_selected() {
        return !list_journal_mix.isSelectionEmpty();
    }

    private boolean is_list_food_compare_a_selected() {
        return !list_food_compare_a.isSelectionEmpty();
    }

    private boolean is_list_food_compare_b_selected() {
        return !list_food_compare_b.isSelectionEmpty();
    }

    private boolean is_list_mix_compare_a_selected() {
        return !list_mix_compare_a.isSelectionEmpty();
    }

    private boolean is_list_mix_compare_b_selected() {
        return !list_mix_compare_b.isSelectionEmpty();
    }

    private void evt_btn_categories_add() {
        JTextField input = new JTextField();
        JComponent[] inputs = new JComponent[] {
            new JLabel( "What is your new category name?" ),
            input
        };
        int optionValue = Message.showOptionDialog( inputs, "New Category" );
        if( optionValue == 0 ) {
            String category_name = input.getText();
            if( category_name != null && category_name.length() > 0 ) {
                try {
                    dbLink.FoodCategory_Insert_2( category_name );
                    dbLink.stopTransaction();
                    modelListCategory.reload();
                    reload_food_items();
                } catch( SQLException e ) {

                }
            }
        }
    }

    private void evt_btn_categories_rename() {
        if( !listCategories.isSelectionEmpty() ) {
            JTextField input = new JTextField();
            JComponent[] inputs = new JComponent[] {
                new JLabel( "What is your new category name?" ),
                input
            };
            int optionValue = Message.showOptionDialog( inputs, "Update Category" );
            if( optionValue == 0 ) {
                String category_name = input.getText();
                if( category_name != null && category_name.length() > 0 ) {
                    try {
                        FoodCategoryDataObject foodCategoryDataObject = ( FoodCategoryDataObject ) listCategories.getSelectedValue();
                        String foodCategoryId = foodCategoryDataObject.getFoodCategoryId();
                        dbLink.FoodCategory_Update( foodCategoryId, category_name );
                        dbLink.stopTransaction();
                        modelListCategory.reload();
                        reload_food_items();
                    } catch( SQLException e ) {

                    }
                }
            }
        }
    }

    private void evt_btn_categories_delete() {
        if( !listCategories.isSelectionEmpty() ) {
            try {
                FoodCategoryDataObject foodCategoryDataObject = ( FoodCategoryDataObject ) listCategories.getSelectedValue();
                String foodCategoryId = foodCategoryDataObject.getFoodCategoryId();
                dbLink.FoodCategory_Delete( foodCategoryId );
                dbLink.stopTransaction();
                modelListCategory.reload();
                reload_food_items();
                modelListFoodInCategory.reload( "-1" );
            } catch( SQLException e ) {

            }
        }
    }

    private void open_url( String url ) {
        try {
            Desktop.getDesktop().browse( new URL( url ).toURI() );
        } catch( IOException | URISyntaxException e ) {

        }
    }

    private void evt_mnui_glycemic_load() {
        JTextField textFieldGI = new JTextField();
        JTextField textFieldCarbs = new JTextField();
        JComponent[] inputs = new JComponent[] {
            new JLabel( "What is glycemic index of food item?" ),
            textFieldGI
        };
        int optionValue = Message.showOptionDialogOkCancel( inputs, "Glycemic Load" );
        if( optionValue == 0 ) {
            String strGI = textFieldGI.getText();
            inputs = new JComponent[] {
                new JLabel( "How many digestible carbs (g) in food item?" ),
                textFieldCarbs
            };
            optionValue = Message.showOptionDialogOkCancel( inputs, "Glycemic Load" );
            if( optionValue == 0 ) {
                String strCarbs = textFieldCarbs.getText();
                if( strGI != null && strGI.length() > 0 ) {
                    if( strCarbs != null && strCarbs.length() > 0 ) {
                        StringBuilder sb = new StringBuilder();
                        NumberCheck checkNumber = new NumberCheck();
                        checkNumber.addToUncheckedList( strGI );
                        checkNumber.addToUncheckedList( strCarbs );
                        if( checkNumber.pass() ) {
                            Double gi = Double.valueOf( strGI );
                            Double carbs = Double.valueOf( strCarbs );
                            double gl = new GlycemicLoad( gi, carbs ).getGlycemicLoad();
                            sb.append( "Glycemic Load: " );
                            sb.append( gl );
                            JTextArea textArea = new JTextArea( 1, 10 );
                            textArea.setText( sb.toString() );
                            textArea.setEditable( false );
                            inputs = new JComponent[] {
                                textArea
                            };
                            Message.showOptionDialog( inputs, "Glycemic Load" );
                        }
                    }
                }
            }
        }
    }

    private void evt_mnui_n3_fatty_acid_recommendations() {
        JTextField energy = new JTextField();
        JComponent[] inputs = new JComponent[] {
            new JLabel( "What is your optimal calorie intake?" ),
            energy
        };
        int optionValue = Message.showOptionDialogOkCancel( inputs, "Alpha-Linolenic Acid (ALA)" );
        if( optionValue == 0 ) {
            String s = energy.getText();
            if( s != null && s.length() > 0 ) {
                StringBuilder sb = new StringBuilder();
                NumberCheck checkNumber = new NumberCheck();
                checkNumber.addToUncheckedList( s );
                if( checkNumber.pass() ) {
                    Double energy_in_kcal = Double.valueOf( s );
                    final Alpha_linolenic_acid_required n3_fatty_acid_recommendation = new Alpha_linolenic_acid_required( energy_in_kcal );
                    BigDecimal ala_low = n3_fatty_acid_recommendation.get_low_in_grams();
                    BigDecimal ala_high = n3_fatty_acid_recommendation.get_high_in_grams();
                    sb.append( "Alpha-linolenic acid (ALA) required is between " );
                    sb.append( ala_low.setScale( 1, RoundingMode.HALF_UP ) );
                    sb.append( " - " );
                    sb.append( ala_high.setScale( 1, RoundingMode.HALF_UP ) );
                    sb.append( " grams" );
                    JTextArea textArea = new JTextArea( 1, 40 );
                    textArea.setText( sb.toString() );
                    textArea.setEditable( false );
                    inputs = new JComponent[] {
                        textArea
                    };
                    Message.showOptionDialog( inputs, "Alpha-Linolenic Acid (ALA)" );
                }
                else {
                    Message.showMessage( "Numbers only" );
                }
            }
        }
    }

    private JTabbedPane get_no_feasible_solution_panel() {
        FormLayout layout = new FormLayout(
                "pref:grow", //columns
                "fill:pref:grow" //rows
        );
        StringBuilder sbPanel1 = new StringBuilder();
        StringBuilder sbPanel2 = new StringBuilder();
        sbPanel1.append( get_no_feasible_solution_text() );
        sbPanel2.append( "One or more of these constraints makes the solution unfeasible." );
        sbPanel2.append( "\n\n" );
        sbPanel2.append( get_nutrient_constraint_text() );
        sbPanel2.append( get_nutrient_percent_constraint_text() );
        sbPanel2.append( get_food_constraint_text() );
        sbPanel2.append( get_food_ratio_text() );
        sbPanel2.append( get_nutrient_ratio_text() );
        JTabbedPane tp = new JTabbedPane();
        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JTextArea messageArea = new JTextArea( sbPanel1.toString() );
        JTextArea constraintsArea = new JTextArea( sbPanel2.toString() );
        messageArea.setEditable( false );
        constraintsArea.setEditable( false );
        tp.setTabPlacement( JTabbedPane.BOTTOM );
        tp.setPreferredSize( new Dimension( GoldenRatio.getLongSide( 500 ), 500 ) );
        tp.add( p1 );
        tp.add( p2 );
        tp.setTitleAt( 0, "Message" );
        tp.setTitleAt( 1, "Details" );
        p1.setLayout( layout );
        p2.setLayout( layout );
        messageArea.setLineWrap( false );
        p1.add( new JScrollPane( messageArea ), cc.xy( 1, 1 ) );
        constraintsArea.setLineWrap( false );
        JScrollPane spConstraintsArea = new JScrollPane( constraintsArea );
        spConstraintsArea.setPreferredSize( new Dimension( 700, 433 ) );
        p2.add( spConstraintsArea, cc.xy( 1, 1 ) );
        return tp;
    }

    private String get_nutrient_ratio_text() {
        StringBuilder sb = new StringBuilder();
        if( tableNutrientRatio.getRowCount() > 0 ) {
            sb.append( "Nutrient Ratio" );
            sb.append( "\n" );
            sb.append( "-----------------------------" );
            sb.append( "\n" );
            for( int i = 0; i < tableNutrientRatio.getRowCount(); i++ ) {
                String nutrientA = ( String ) tableNutrientRatio.getValueAt( i, 4 );
                String nutrientB = ( String ) tableNutrientRatio.getValueAt( i, 5 );
                Double a = ( Double ) tableNutrientRatio.getValueAt( i, 6 );
                String rel = ( String ) tableNutrientRatio.getValueAt( i, 7 );
                Double b = ( Double ) tableNutrientRatio.getValueAt( i, 8 );
                sb.append( nutrientA );
                sb.append( " " );
                sb.append( a );
                sb.append( " " );
                sb.append( rel );
                sb.append( " " );
                sb.append( nutrientB );
                sb.append( " " );
                sb.append( b );
                sb.append( "\n" );
            }
            sb.append( "\n" );
        }
        return sb.toString();
    }

    private String get_food_ratio_text() {
        StringBuilder sb = new StringBuilder();
        if( tableFoodNutrientRatio.getRowCount() > 0 ) {
            sb.append( "Food Ratio" );
            sb.append( "\n" );
            sb.append( "-----------------------------" );
            sb.append( "\n" );
            for( int i = 0; i < tableFoodNutrientRatio.getRowCount(); i++ ) {
                String foodA = ( String ) tableFoodNutrientRatio.getValueAt( i, 6 );
                String nutrientA = ( String ) tableFoodNutrientRatio.getValueAt( i, 7 );
                String foodB = ( String ) tableFoodNutrientRatio.getValueAt( i, 8 );
                String nutrientB = ( String ) tableFoodNutrientRatio.getValueAt( i, 9 );
                Double a = ( Double ) tableFoodNutrientRatio.getValueAt( i, 10 );
                String rel = ( String ) tableFoodNutrientRatio.getValueAt( i, 11 );
                Double b = ( Double ) tableFoodNutrientRatio.getValueAt( i, 12 );
                sb.append( foodA );
                sb.append( " " );
                sb.append( nutrientA );
                sb.append( " " );
                sb.append( a );
                sb.append( " " );
                sb.append( rel );
                sb.append( " " );
                sb.append( foodB );
                sb.append( " " );
                sb.append( nutrientB );
                sb.append( " " );
                sb.append( b );
                sb.append( "\n" );
            }
            sb.append( "\n" );
        }
        return sb.toString();
    }

    private String get_nutrient_percent_constraint_text() {
        StringBuilder sb = new StringBuilder();
        if( tableNutrientPercentConstraint.getRowCount() > 0 ) {
            sb.append( "Nutrient Percent Constraint" );
            sb.append( "\n" );
            sb.append( "--------------------------" );
            sb.append( "\n" );
            for( int i = 0; i < tableNutrientPercentConstraint.getRowCount(); i++ ) {
                String food = ( String ) tableNutrientPercentConstraint.getValueAt( i, 4 );
                String nutrient = ( String ) tableNutrientPercentConstraint.getValueAt( i, 5 );
                String relationship = ( String ) tableNutrientPercentConstraint.getValueAt( i, 6 );
                Double constraint = ( Double ) tableNutrientPercentConstraint.getValueAt( i, 7 );
                sb.append( food );
                sb.append( " " );
                sb.append( nutrient );
                sb.append( " " );
                sb.append( relationship );
                sb.append( " " );
                sb.append( constraint );
                sb.append( "\n" );
            }
            sb.append( "\n" );
        }
        return sb.toString();
    }

    private String get_food_constraint_text() {
        StringBuilder sb = new StringBuilder();
        if( tableFoodNutrientConstraint.getRowCount() > 0 ) {
            sb.append( "Food Constraint" );
            sb.append( "\n" );
            sb.append( "--------------------------" );
            sb.append( "\n" );
            for( int i = 0; i < tableFoodNutrientConstraint.getRowCount(); i++ ) {
                String food = ( String ) tableFoodNutrientConstraint.getValueAt( i, 4 );
                String nutrient = ( String ) tableFoodNutrientConstraint.getValueAt( i, 5 );
                String equality = ( String ) tableFoodNutrientConstraint.getValueAt( i, 6 );
                Double value = ( Double ) tableFoodNutrientConstraint.getValueAt( i, 7 );
                sb.append( food );
                sb.append( " " );
                sb.append( nutrient );
                sb.append( " " );
                sb.append( equality );
                sb.append( " " );
                sb.append( value );
                sb.append( "\n" );
            }
            sb.append( "\n" );
        }
        return sb.toString();
    }

    private String get_nutrient_constraint_text() {
        StringBuilder sb = new StringBuilder();
        if( tableNutrientConstraint.getRowCount() > 0 ) {
            sb.append( "Nutrient Constraint" );
            sb.append( "\n" );
            sb.append( "--------------------------" );
            sb.append( "\n" );
            for( int i = 0; i < tableNutrientConstraint.getRowCount(); i++ ) {
                String nutrient = ( String ) tableNutrientConstraint.getValueAt( i, 3 );
                String equality = ( String ) tableNutrientConstraint.getValueAt( i, 4 );
                Double value = ( Double ) tableNutrientConstraint.getValueAt( i, 5 );
                sb.append( nutrient );
                sb.append( " " );
                sb.append( equality );
                sb.append( " " );
                sb.append( value );
                sb.append( "\n" );
            }
            sb.append( "\n" );
        }
        return sb.toString();
    }

    private String get_no_feasible_solution_text() {
        StringBuilder sb = new StringBuilder();
        for( int i = 0; i < 8; i++ ) {
            sb.append( "\n" );
        }
        for( int i = 0; i < 83; i++ ) {
            sb.append( " " );
        }
        sb.append( "No Feasible Solution" );
        sb.append( "\n\n" );
        for( int i = 0; i < 83; i++ ) {
            sb.append( " " );
        }
        sb.append( "Things you can try:" );
        sb.append( "\n\n" );
        for( int i = 0; i < 83; i++ ) {
            sb.append( " " );
        }
        sb.append( "1. Delete a constraint" );
        sb.append( "\n\n" );
        for( int i = 0; i < 83; i++ ) {
            sb.append( " " );
        }
        sb.append( "2. Add a food item" );
        return sb.toString();
    }

    private void evt_mnui_send_message() {
        final int selectedIndex = main_tabbed_pane.getSelectedIndex();
        switch( selectedIndex ) {
            case 0:
                if( is_mix_selected() ) {
                    try {
                        MixDataObject mix = ( MixDataObject ) lst_mix.getSelectedValue();
                        frm_snack.setCursor( Cursor.getPredefinedCursor( Cursor.WAIT_CURSOR ) );
                        Xml_send send = new Xml_send( dbLink, mix.getMixId() );
                        frm_snack.setCursor( Cursor.getPredefinedCursor( Cursor.DEFAULT_CURSOR ) );
                        show_message_sent();
                    } catch( Exception e ) {
                    }
                }
                break;
            case 4:
                if( is_mix_journal_selected() ) {
                    try {
                        MixDataObject mix = ( MixDataObject ) list_journal_mix.getSelectedValue();
                        frm_snack.setCursor( Cursor.getPredefinedCursor( Cursor.WAIT_CURSOR ) );
                        Xml_send send = new Xml_send( dbLink, mix.getMixId() );
                        frm_snack.setCursor( Cursor.getPredefinedCursor( Cursor.DEFAULT_CURSOR ) );
                        show_message_sent();
                    } catch( Exception e ) {
                    }
                }
                break;
        }
    }

    private void show_message_sent() {
        JComponent[] inputs = new JComponent[] {
            new JLabel( "Data exchange document is in model directory." )
        };
        Message.showOptionDialog( inputs, "Data Exchange" );
    }

    private void evt_mnui_receive_message() {
        fileChooser.setAcceptAllFileFilterUsed( false );
        fileChooser.addChoosableFileFilter( new FileNameExtensionFilter( "Xml Document", "xml" ) );
        int returnVal = fileChooser.showOpenDialog( frm_snack );
        if( returnVal == JFileChooser.APPROVE_OPTION ) {
            File file = fileChooser.getSelectedFile();
            String path = file.getAbsolutePath();
            fileChooser.setCurrentDirectory( new File( path ) );
            HashSet set_without = new HashSet();
            HashSet set_with = new HashSet();
            final int old_size = modelList_Solve.size();
            for( int i = 0; i < old_size; i++ ) {
                MixDataObject o = ( MixDataObject ) modelList_Solve.get( i );
                set_without.add( o.getMixId() );
            }
            Xml_receive receive = new Xml_receive( dbLink );
            receive.import_snack_data( path );
            reload_mixes();
            reload_food_items();
            modelListCategory.reload();
            for( int i = 0; i < modelList_Solve.size(); i++ ) {
                MixDataObject o = ( MixDataObject ) modelList_Solve.get( i );
                set_with.add( o.getMixId() );
            }
            if( set_with.removeAll( set_without ) ) {
                int index = modelList_Solve.find_by_mixid( ( String ) set_with.toArray()[ 0 ] );
                lst_mix.setSelectedIndex( index );
            }
            else {
                lst_mix.setSelectedIndex( 0 );
            }
        }
    }

    private void evt_mnui_show_mix_stats() {
        if( is_mix_selected() ) {
            try {
                MixDataObject mix = ( MixDataObject ) lst_mix.getSelectedValue();
                JTextArea textArea = new JTextArea( 1, 24 );
                textArea.setText( stringModelMixPct.reload( mix.getMixId() ) );
                textArea.setEditable( false );
                JComponent[] inputs = new JComponent[] {
                    textArea
                };
                Message.showOptionDialog( inputs, "Macronutrient Percentages" );
            } catch( Exception e ) {
            }
        }

    }

    private void evt_btn_cost() {
        JTextPane instructions = new JTextPane();
        JTextField fld_price = new JTextField();
        JTextField fld_total_weight = new JTextField();
        StringBuilder sb = new StringBuilder();
        JPanel inputsPanel = new JPanel();
        JComponent[] inputs = new JComponent[] {
            inputsPanel
        };
        FormLayout layout = new FormLayout(
                "min:grow,min:grow", //columns
                "fill:min:grow,min,min" //rows
        );
        JLabel lbl_price = new JLabel( "Product price ($): " );
        JLabel lbl_total_weight = new JLabel( "Product net weight (g): " );
        NumberCheck checkNumber = new NumberCheck();
        instructions.setEditable( false );
        sb.append( "* COST *\n\n" );
        sb.append( "To calculate cost per serving\n\n" );
        sb.append( "1. Please find product price ($)\n\n" );
        sb.append( "2. Please find product net weight (g)\n\n" );
        instructions.setText( sb.toString() );
        inputsPanel.setPreferredSize( new Dimension( 350, GoldenRatio.getShortSide( 350 ) ) );
        inputsPanel.setLayout( layout );
        inputsPanel.add( new JScrollPane( instructions ), cc.xyw( 1, 1, 2 ) );
        lbl_price.setHorizontalAlignment( JLabel.RIGHT );
        lbl_total_weight.setHorizontalAlignment( JLabel.RIGHT );
        inputsPanel.add( lbl_price, cc.xy( 1, 2 ) );
        inputsPanel.add( fld_price, cc.xy( 2, 2 ) );
        inputsPanel.add( lbl_total_weight, cc.xy( 1, 3 ) );
        inputsPanel.add( fld_total_weight, cc.xy( 2, 3 ) );
        int optionValue = Message.showOptionDialogOkCancel( inputs, "Cost" );
        if( optionValue == 0 ) {
            String s0 = fld_price.getText();
            String s1 = fld_total_weight.getText();
            if( (s0 != null && s0.length() > 0) && (s1 != null && s1.length() > 0) ) {
                checkNumber.addToUncheckedList( s0 );
                if( checkNumber.pass() ) {
                    Double price = Double.valueOf( fld_price.getText() );
                    Double total_weight = Double.valueOf( fld_total_weight.getText() );
                    //model row index is specified by sql query.
                    int model_column_index = 3;
                    int model_row_index_weight = modelTableNutrientInput.find( "10000" );
                    int model_row_index_cost = modelTableNutrientInput.find( "10005" );
                    Double weight = ( Double ) modelTableNutrientInput.getValueAt( model_row_index_weight, model_column_index );
                    Double cost = (price / total_weight) * weight;
                    modelTableNutrientInput.setValueAt( cost, model_row_index_cost, model_column_index );
                    select_table_row_using_model( tableNutrientInput, model_row_index_cost );
                    scroll_to_row_using_model( tableNutrientInput, model_row_index_cost );
                }
                else {
                    Message.showMessage( "Numbers only" );
                }
            }
        }
    }
}
