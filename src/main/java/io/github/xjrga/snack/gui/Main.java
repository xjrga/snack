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
import io.github.xjrga.snack.model.ComboBoxModelLifeStage;
import io.github.xjrga.snack.model.ComboBoxModelNutrientsAll;
import io.github.xjrga.snack.model.ComboBoxModelNutrientsConvert;
import io.github.xjrga.snack.model.ComboBoxPortionFood;
import io.github.xjrga.snack.model.Food_legend_generator;
import io.github.xjrga.snack.model.Food_loader;
import io.github.xjrga.snack.model.ListModelCategory;
import io.github.xjrga.snack.model.ListModelFood;
import io.github.xjrga.snack.model.ListModelFood2;
import io.github.xjrga.snack.model.ListModelMix;
import io.github.xjrga.snack.model.ListModelPortionMeal;
import io.github.xjrga.snack.model.ListModelSelectedFood;
import io.github.xjrga.snack.model.Nutrient_loader;
import io.github.xjrga.snack.model.Relationship_loader;
import io.github.xjrga.snack.model.Result_loader;
import io.github.xjrga.snack.model.StringModelMixPct;
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
import io.github.xjrga.snack.model.TableModelMacroNutrient;
import io.github.xjrga.snack.model.TableModelMeals;
import io.github.xjrga.snack.model.TableModelMinerals;
import io.github.xjrga.snack.model.TableModelMixComparison;
import io.github.xjrga.snack.model.TableModelNutrientConstraints;
import io.github.xjrga.snack.model.TableModelNutrientLookup;
import io.github.xjrga.snack.model.TableModelNutrientRatioConstraints;
import io.github.xjrga.snack.model.TableModelPercentNutrientConstraints;
import io.github.xjrga.snack.model.TableModelPortions;
import io.github.xjrga.snack.model.TableModelProtein;
import io.github.xjrga.snack.model.TableModelRdaCheck;
import io.github.xjrga.snack.model.TableModelResultsByMealEnergy;
import io.github.xjrga.snack.model.TableModelResultsByMealNutrient;
import io.github.xjrga.snack.model.TableModelVitamins;
import io.github.xjrga.snack.model.TableModelWater;
import io.github.xjrga.snack.model.TreeModelFood;
import io.github.xjrga.snack.model.Mdl_cmb_mix;
import io.github.xjrga.snack.other.Alpha_linolenic_acid_required;
import io.github.xjrga.snack.other.CunninghamFormula;
import io.github.xjrga.snack.other.DigestibleCarbohydrate;
import io.github.xjrga.snack.other.DoubleTableCellEditor;
import io.github.xjrga.snack.other.ExportFoodComparison;
import io.github.xjrga.snack.other.ExportFoodList;
import io.github.xjrga.snack.other.ExportMealPlan;
import io.github.xjrga.snack.other.ExportMixComparison;
import io.github.xjrga.snack.other.ExportNutrientLookup;
import io.github.xjrga.snack.other.ExportRdaCheck;
import io.github.xjrga.snack.other.GlycemicIndexRange;
import io.github.xjrga.snack.other.GlycemicLoad;
import io.github.xjrga.snack.other.GoldenRatio;
import io.github.xjrga.snack.other.ImageUtilities;
import io.github.xjrga.snack.other.KatchMcArdleFormula;
import io.github.xjrga.snack.other.MinimumNutrientRequirements;
import io.github.xjrga.snack.other.NumberCheck;
import io.github.xjrga.snack.other.Spacer_panel;
import io.github.xjrga.snack.other.StringCheck;
import io.github.xjrga.snack.other.String_display_component;
import io.github.xjrga.snack.other.TableHeaderCarbs;
import io.github.xjrga.snack.other.TableHeaderCost;
import io.github.xjrga.snack.other.TableHeaderElectrolytes;
import io.github.xjrga.snack.other.TableHeaderEnergy;
import io.github.xjrga.snack.other.TableHeaderFats;
import io.github.xjrga.snack.other.TableHeaderFoodList;
import io.github.xjrga.snack.other.TableHeaderGlycemic;
import io.github.xjrga.snack.other.TableHeaderMacroNutrient;
import io.github.xjrga.snack.other.TableHeaderMinerals;
import io.github.xjrga.snack.other.TableHeaderNutrientLookup;
import io.github.xjrga.snack.other.TableHeaderProtein;
import io.github.xjrga.snack.other.TableHeaderRdaDiff;
import io.github.xjrga.snack.other.TableHeaderResultsByMealCalories;
import io.github.xjrga.snack.other.TableHeaderResultsByMealGrams;
import io.github.xjrga.snack.other.TableHeaderVitamins;
import io.github.xjrga.snack.other.TableHeaderWater;
import io.github.xjrga.snack.other.Xml_receive;
import io.github.xjrga.snack.other.Xml_send;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeEvent;
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
import javax.swing.event.ChangeEvent;
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
    private final ComboBoxPortionFood modelComboBox_PortionFood = new ComboBoxPortionFood( dbLink );
    private final DefaultComboBoxModel modelComboBox_FoodAtFoodNutrient = new DefaultComboBoxModel();
    private final DefaultComboBoxModel modelComboBox_FoodAtNutrientPct = new DefaultComboBoxModel();
    private final DefaultComboBoxModel modelComboBox_NutrientAtNutrientConstraint = new DefaultComboBoxModel();
    private final ListModelPortionMeal modelList_PortionMeal = new ListModelPortionMeal( dbLink );
    private final DefaultComboBoxModel modelComboBox_NutrientAtFoodNutrient = new DefaultComboBoxModel();
    private final DefaultComboBoxModel modelComboBox_NutrientAtNutrientPct = new DefaultComboBoxModel();
    private final DefaultComboBoxModel modelComboBox_RelationshipAtFoodNutrient = new DefaultComboBoxModel();
    private final DefaultComboBoxModel modelComboBox_RelationshipAtFoodNutrientRatio = new DefaultComboBoxModel();
    private final DefaultComboBoxModel modelComboBox_RelationshipAtNutrient = new DefaultComboBoxModel();
    private final DefaultComboBoxModel modelComboBox_RelationshipAtNutrientPct = new DefaultComboBoxModel();
    private final DefaultComboBoxModel modelComboBox_RelationshipAtNutrientRatio = new DefaultComboBoxModel();
    private final DefaultListModel mdl_lst_high_score = new DefaultListModel();
    private final Food_legend_generator legend_generator = new Food_legend_generator( dbLink );
    private final Food_loader cb_food_loader = new Food_loader( dbLink );
    private final JButton buttonCategoriesAdd = new JButton( "+" );
    private final JButton buttonCategoriesDelete = new JButton( "-" );
    private final JButton buttonCategoriesRename = new JButton( "u" );
    private final JButton buttonFoodListAdd = new JButton( "+" );
    private final JButton buttonFoodListDelete = new JButton( "-" );
    private final JButton buttonFoodListDuplicate = new JButton( "d" );
    private final JButton buttonFoodListGi = new JButton( "gi" );
    private final JButton buttonFoodListUpdate = new JButton( "u" );
    private final JButton buttonPortionAdd = new JButton( "+" );
    private final JButton buttonMealAdd = new JButton( "+" );
    private final JButton buttonFoodNutrientConstraintAdd = new JButton( "+" );
    private final JButton buttonMealDelete = new JButton( "-" );
    private final JButton buttonMealUpdate = new JButton( "u" );
    private final JButton buttonPortionDelete = new JButton( "-" );
    private final JButton buttonPortionUpdateWeight = new JButton( "w" );
    private final JButton buttonFoodNutrientConstraintDelete = new JButton( "-" );
    private final JButton buttonFoodNutrientRatioAdd = new JButton( "+" );
    private final JButton buttonFoodNutrientRatioDelete = new JButton( "-" );
    private final JButton buttonNutrientConstraintAdd = new JButton( "+" );
    private final JButton buttonNutrientConstraintDelete = new JButton( "-" );
    private final JButton buttonNutrientRatioAdd = new JButton( "+" );
    private final JButton buttonNutrientRatioDelete = new JButton( "-" );
    private final JButton buttonPercentNutrientConstraintAdd = new JButton( "+" );
    private final JButton buttonPercentNutrientConstraintDelete = new JButton( "-" );
    private final JButton btn_undo = new JButton( "Undo" );
    private final JButton btn_solve = new JButton( "Solve" );
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
    private final JComboBox cmb_food_portion = new JComboBox();
    private final JList listPortionMeal = new JList();
    private final JComboBox comboBoxFoodNutrient_Food = new JComboBox();
    private final JComboBox comboBoxFoodNutrient_Nutrient = new JComboBox();
    private final JComboBox comboBoxFoodNutrient_Relationship = new JComboBox();
    private final JComboBox comboBoxFoodNutrientRatioFoodA = new JComboBox();
    private final JComboBox comboBoxFoodNutrientRatioFoodB = new JComboBox();
    private final JComboBox comboBoxFoodNutrientRatioNutrientA = new JComboBox();
    private final JComboBox comboBoxFoodNutrientRatioNutrientB = new JComboBox();
    private final JComboBox comboBoxFoodNutrientRatioRelationship = new JComboBox();
    private final JComboBox cb_results_lifestage = new JComboBox();
    private final JComboBox comboBoxNutrientConstraintNutrient = new JComboBox();
    private final JComboBox comboBoxNutrientConstraintRelationship = new JComboBox();
    private final JComboBox comboBoxNutrientLookupListNutrient = new JComboBox();
    private final JComboBox comboBoxNutrientRatioNutrientA = new JComboBox();
    private final JComboBox comboBoxNutrientRatioNutrientB = new JComboBox();
    private final JComboBox comboBoxNutrientRatioRelationship = new JComboBox();
    private final JComboBox comboBoxPercentNutrient_Food = new JComboBox();
    private final JComboBox comboBoxPercentNutrient_Nutrient = new JComboBox();
    private final JComboBox comboBoxPercentNutrient_Relationship = new JComboBox();
    private final JFileChooser fileChooser;
    private final JFrame frame = new JFrame();
    private final JList listAllFoodItems = new JList();
    private final JList listCategories = new JList();
    private final JList lst_food_compare_a = new JList();
    private final JList lst_food_compare_b = new JList();
    private final JList listFoodInCategory = new JList();
    private final JList lst_high_score = new JList();
    private final JList lst_mix_compare_a = new JList();
    private final JList lst_mix_compare_b = new JList();
    private final JComboBox cmb_mix = new JComboBox();
    private final JList lst_selected_food = new JList();
    private final JMenuItem mnui_export_model = new JMenuItem();
    private final JMenuItem mnui_import_model = new JMenuItem();
    private final JMenuItem mnui_show_mix_stats = new JMenuItem();
    private final JMenuItem mnui_About = new JMenuItem();
    private final JMenuItem mnui_alpha_linolenic_acid_required = new JMenuItem();
    private final JMenuItem menuItemBmr = new JMenuItem();
    private final JMenuItem menuItemConstraintsShownInList = new JMenuItem();
    private final JMenuItem menuItemCredits = new JMenuItem();
    private final JMenuItem menuItemDigestibleCarbs = new JMenuItem();
    private final JMenuItem menuItemExit = new JMenuItem();
    private final JMenuItem menuItemExportFoodComparison = new JMenuItem();
    private final JMenuItem menuItemExportFoodList = new JMenuItem();
    private final JMenuItem mnui_export_mixcomparison = new JMenuItem();
    private final JMenuItem mnui_export_rda = new JMenuItem();
    private final JMenuItem menuItemExportNutrientLookup = new JMenuItem();
    private final JMenuItem mnui_export_mealplan = new JMenuItem();
    private final JMenuItem menuItemGlycemicIndexRange = new JMenuItem();
    private final JMenuItem menuItemGlycemicLoad = new JMenuItem();
    private final JMenuItem menuItemGuide = new JMenuItem();
    private final JMenuItem menuItemKetosis = new JMenuItem();
    private final JMenuItem menuItemMicronutrientConversion = new JMenuItem();
    private final JMenuItem menuItemNitrogenBalance = new JMenuItem();
    private final JMenuItem mnui_create_mix = new JMenuItem();
    private final JMenuItem mnui_delete_mix = new JMenuItem();
    private final JMenuItem mnui_rename_mix = new JMenuItem();
    private final JMenuItem mnui_minimize_option = new JMenuItem();
    private final JMenuItem mnui_duplicate_mix = new JMenuItem();
    private final JMenuItem mnui_add_mix_to_foodlist = new JMenuItem();
    private final JMenuItem mnui_pin_mix = new JMenuItem( "Pin" );
    private final JMenu menuData = new JMenu();
    private final JMenu mnu_exchange = new JMenu();
    private final JMenu menuHelp = new JMenu();
    private final JMenu menuProgram = new JMenu();
    private final JMenu menuSettings = new JMenu();
    private final JMenu mnu_spreadsheet = new JMenu();
    private final JMenu menuTools = new JMenu();
    private final JMenu menu_mix = new JMenu();
    private int precision = 0;
    private JScrollPane tableNutrientInputScrollPane;
    private final JTable tableCarbs = new JTable();
    private final JTable tableCheckCoefficients = new JTable();
    private final JTable tableCost = new JTable();
    private final JTable tableElectrolytes = new JTable();
    private final JTable tableEnergy = new JTable();
    private final JTable tableMacronutrient = new JTable();
    private final JTable tableFats = new JTable();
    private JTable tbl_food_comparison;
    private final JTable tableFoodList01 = new JTable();
    private final JTable tbl_meal_portions = new JTable();
    private final JTable tbl_meals = new JTable();
    private final JTable tbl_results_by_meal_calories = new JTable();
    private final JTable tbl_results_by_meal_grams = new JTable();
    private final JTable tableFoodNutrient = new JTable();
    private final JTable tableFoodNutrientRatio = new JTable();
    private final JTable tableGlycemic = new JTable();
    private final JTable tableMinerals = new JTable();
    private JTable tbl_mix_comparison;
    private final JTable tableNutrientConstraint = new JTable();
    private final JTable tbl_nutrient_input = new JTable();
    private final JTable tableNutrientLookup = new JTable();
    private final JTable tableNutrientPercent = new JTable();
    private final JTable tableNutrientRatio = new JTable();
    private final JTable tableProtein = new JTable();
    private JTable tbl_results_rda;
    private final JTable tableVitamins = new JTable();
    private final JTable tableWater = new JTable();
    private final JTextArea txta_editor_model = new JTextArea();
    private final JTextField textFieldFoodListSearch = new JTextField();
    private final JTextField textfield_portion_remaining = new JTextField();
    private final JTextField textfield_portion_pct = new JTextField();
    private final JTextField textfield_portion_search = new JTextField();
    private final JTextField textFieldFoodNutrient_Quantity = new JTextField();
    private final JTextField textFieldFoodNutrientRatioQuantityA = new JTextField();
    private final JTextField textFieldFoodNutrientRatioQuantityB = new JTextField();
    private final JTextField textFieldNutrientConstraintQuantity = new JTextField();
    private final JTextField textFieldNutrientLookup = new JTextField();
    private final JTextField textFieldNutrientRatioNutrientA = new JTextField();
    private final JTextField textFieldNutrientRatioNutrientB = new JTextField();
    private final JTextField textFieldNutrientSearchCheckCoefficients = new JTextField();
    private final JTextField textFieldNutrientSearch = new JTextField();
    private final JTextField textFieldPercentNutrient_Quantity = new JTextField();
    private final JTree treeFoodList = new JTree();
    private final LinkedHashMap<String, JCheckBox> mapConstraintCheckboxes;
    private final ListModelCategory modelListCategory = new ListModelCategory( dbLink );
    private final ListModelFood2 modelListFoodInCategory = new ListModelFood2( dbLink );
    private final ListModelFood modelList_A_FoodDiff = new ListModelFood( dbLink );
    private final ListModelFood modelList_B_FoodDiff = new ListModelFood( dbLink );
    private final ListModelFood modelListFood = new ListModelFood( dbLink );
    private final ListModelMix modelList_A_MixDiff = new ListModelMix( dbLink );
    private final ListModelMix modelList_B_MixDiff = new ListModelMix( dbLink );
    private final ListModelSelectedFood modelList_selected_food = new ListModelSelectedFood( dbLink );
    private final Nutrient_loader nutrient_loader = new Nutrient_loader( dbLink );
    private final Relationship_loader relationship_loader = new Relationship_loader( dbLink );
    private final Result_loader result_loader_journal = new Result_loader( dbLink );
    private final Result_loader result_loader = new Result_loader( dbLink );
    private String foodNameText;
    private final StringModelMixPct stringModelMixPct = new StringModelMixPct( dbLink );
    private final TableModelCarbs modelTableCarbs = new TableModelCarbs( result_loader );
    private final TableModelCheckCoefficients modelTableCheckCoefficients = new TableModelCheckCoefficients( dbLink );
    private final TableModelCost modelTableCost = new TableModelCost( result_loader );
    private final TableModelDataInput modelTableNutrientInput = new TableModelDataInput( dbLink );
    private final TableModelElectrolytes modelTableElectrolytes = new TableModelElectrolytes( result_loader );
    private final TableModelEnergy modelTableEnergy = new TableModelEnergy( result_loader );
    private final TableModelMacroNutrient modelTableMacroNutrient = new TableModelMacroNutrient( result_loader );
    private final TableModelFat modelTableFats = new TableModelFat( result_loader );
    private final TableModelFoodComparison modelTableFoodDifference = new TableModelFoodComparison( dbLink );
    private final TableModelFoodList modelTableFoodList = new TableModelFoodList( dbLink );
    private final TableModelPortions modelTablePortion = new TableModelPortions( dbLink );
    private final TableModelMeals modelTableMeals = new TableModelMeals( dbLink );
    private final TableModelResultsByMealEnergy modelTableResultByMealsCalories = new TableModelResultsByMealEnergy( dbLink );
    private final TableModelResultsByMealNutrient modelTableResultByMealsGrams = new TableModelResultsByMealNutrient( dbLink );
    private final TableModelFoodNutrientConstraints modelTableFoodNutrientConstraints = new TableModelFoodNutrientConstraints( dbLink );
    private final TableModelFoodNutrientRatioConstraints modelTableFoodNutrientRatioConstraints = new TableModelFoodNutrientRatioConstraints( dbLink );
    private final TableModelGlycemic modelTableGlycemic = new TableModelGlycemic( dbLink );
    private final TableModelMinerals modelTableMinerals = new TableModelMinerals( result_loader );
    private final TableModelMixComparison modelTableMixDifference = new TableModelMixComparison( dbLink );
    private final TableModelNutrientConstraints modelTableNutrientConstraints = new TableModelNutrientConstraints( dbLink );
    private final TableModelNutrientLookup modelTableNutrientLookup = new TableModelNutrientLookup( dbLink );
    private final TableModelNutrientRatioConstraints modelTableNutrientRatioConstraints = new TableModelNutrientRatioConstraints( dbLink );
    private final TableModelPercentNutrientConstraints tableModelPercentNutrientConstraints = new TableModelPercentNutrientConstraints( dbLink );
    private final TableModelProtein modelTableProtein = new TableModelProtein( result_loader );
    private final TableModelRdaCheck modelTableRda = new TableModelRdaCheck( dbLink );
    private final TableModelVitamins modelTableVitamins = new TableModelVitamins( result_loader );
    private final TableModelWater modelTableWater = new TableModelWater( result_loader );
    private final TableRowSorter srttbl_food_comparison = new TableRowSorter<>( modelTableFoodDifference );
    private final TableRowSorter srttbl_foodlist = new TableRowSorter<>( modelTableFoodList );
    private final TableRowSorter srttbl_mix_comparison = new TableRowSorter<>( modelTableMixDifference );
    private final TableRowSorter srttbl_nutrientinput = new TableRowSorter<>( modelTableNutrientInput );
    private final TableRowSorter srttbl_nutrientlookup = new TableRowSorter<>( modelTableNutrientLookup );
    private final TableRowSorter srttbl_portionlookup = new TableRowSorter<>( modelTablePortion );
    private final TableRowSorter srttbl_CheckCoefficients = new TableRowSorter<>( modelTableCheckCoefficients );
    private final TreeModelFood modelTreeFoodList = new TreeModelFood( dbLink );
    private final JRadioButtonMenuItem mnui_cost = new JRadioButtonMenuItem();
    private final JRadioButtonMenuItem mnui_calories = new JRadioButtonMenuItem();
    private final JLabel lbl_min = new JLabel();
    private final JTabbedPane main_tabbed_pane = new JTabbedPane();
    private final JTabbedPane results_tabbed_pane = new JTabbedPane();
    private final JLabel nutrient_ratio_constraint_count = new JLabel();
    private final JLabel food_nutrient_ratio_constraint_count = new JLabel();
    private final JLabel food_nutrient_constraint_count = new JLabel();
    private final JLabel nutrient_pct_constraint_count = new JLabel();
    private final JLabel nutrient_constraint_count = new JLabel();
    private final Mdl_cmb_mix mdl_cmb_mix = new Mdl_cmb_mix( dbLink );
    private final JSplitPane split = new JSplitPane();

    public Main() {
        fileChooser = new JFileChooser();
        frame.setIconImage( logo );
        frame.setJMenuBar( get_menubar() );
        main_tabbed_pane.setTabPlacement( JTabbedPane.BOTTOM );
        main_tabbed_pane.add( get_editor() );
        main_tabbed_pane.add( get_food_list() );
        main_tabbed_pane.add( get_food_comparison() );
        main_tabbed_pane.add( get_mix_comparison() );
        main_tabbed_pane.add( get_nutrient_lookup() );
        main_tabbed_pane.add( get_food_categories() );
        main_tabbed_pane.setTitleAt( 0, "Editor" );
        main_tabbed_pane.setToolTipTextAt( 0, "Create, edit and solve your mix problem here" );
        main_tabbed_pane.setTitleAt( 1, "Food List" );
        main_tabbed_pane.setToolTipTextAt( 1, "This is your list of favorite food items" );
        main_tabbed_pane.setTitleAt( 2, "Food Comparison" );
        main_tabbed_pane.setToolTipTextAt( 2, "This is where you compare two food items (100g)" );
        main_tabbed_pane.setTitleAt( 3, "Mix Comparison" );
        main_tabbed_pane.setToolTipTextAt( 3, "This is where you compare two mixes" );
        main_tabbed_pane.setTitleAt( 4, "Nutrient Lookup" );
        main_tabbed_pane.setToolTipTextAt( 4, "This is where you find food items that provide a specific nutrient" );
        main_tabbed_pane.setTitleAt( 5, "Food Category" );
        main_tabbed_pane.setToolTipTextAt( 5, "This is where you categorize food items" );
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView( main_tabbed_pane );
        frame.add( scrollPane );
        frame.setDefaultCloseOperation( 3 );
        Dimension size = new Dimension( 1300, 870 );
        frame.setSize( size );
        frame.setVisible( true );
        frame.setTitle( "Snack" );
        frame.addWindowListener( new WindowAdapter() {
            @Override
            public void windowClosing( WindowEvent e ) {
                process_evt_mnui_exit();
            }
        } );
        set_cbmdl_editor_lifestage_to_daily_value();
        set_cbmdl_journal_lifestage_to_daily_value();
        reload_cbmdl_nutrient();
        reload_cbmdl_relationship();
        reload_lstmdl_mixes();
        reload_tblmdl_constraints( "" );
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
            LinkedList<HashMap> list = ( LinkedList ) dbLink.Nutrient_Select_All();
            list.forEach( row ->
            {
                String nutrientid = ( String ) row.get( "NUTRIENTID" );
                int visible = ( int ) row.get( "VISIBLE" );
                if ( mapConstraintCheckboxes.containsKey( nutrientid ) ) {
                    JCheckBox cb = mapConstraintCheckboxes.get( nutrientid );
                    cb.setSelected( visible == 1 );
                }
            } );
        } catch ( SQLException e ) {

        }
        resize_col_tbl_nutrient_lookup();
        resize_col_tbl_meal();
        resize_col_tbl_meal_portions();
        resize_col_tbl_results_by_meal_calories();
        resize_col_tbl_results_by_meal_grams();
        resize_tbls_constraint();
        main_tabbed_pane.addChangeListener( ( ChangeEvent e ) ->
        {
            switch ( main_tabbed_pane.getSelectedIndex() ) {
                case 0:
                    mnui_show_mix_stats.setEnabled( true );
                    mnui_export_model.setEnabled( true );
                    break;
                case 1:
                    mnui_show_mix_stats.setEnabled( true );
                    mnui_export_model.setEnabled( true );
                    break;
                default:
                    mnui_show_mix_stats.setEnabled( false );
                    mnui_export_model.setEnabled( false );
                    break;
            }
        } );
        if ( cmb_mix.getSelectedItem() != null ) {
            cmb_mix.setSelectedIndex( 0 );
        } else {
            enable_jcomponent( false );
        }
        split.setDividerLocation( 370 );
        dbLink.startTransaction();
    }

    public static void main( String[] args ) {
        try {
            Font font = new Font( Font.DIALOG, Font.PLAIN, 12 );
            MetalLookAndFeel.setCurrentTheme( new io.github.xjrga.looks.themes.Dawn_180( font ) );
            UIManager.setLookAndFeel( "javax.swing.plaf.metal.MetalLookAndFeel" );
        } catch ( ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e ) {
        }
        Main main = new Main();
    }

    private void process_evt_btn_food_list_update_gi() {
        JTextField input = new JTextField();
        input.setPreferredSize( new Dimension( 50, 25 ) );
        int selectedRow = tableFoodList01.getSelectedRow();
        if ( selectedRow != -1 ) {
            String foodid = ( String ) tableFoodList01.getValueAt( selectedRow, 0 );
            JPanel input_panel = new JPanel();
            try {
                LinkedList<HashMap> list = ( LinkedList ) dbLink.GlycemicIndex_Select( foodid );
                list.forEach( row ->
                {
                    input.setText( String.valueOf( ( double ) row.get( "Q" ) ) );
                } );
            } catch ( SQLException ex ) {
            }
            input_panel.add( new JLabel( "What is the glycemic index of food item?  " ) );
            input_panel.add( input );
            JComponent[] inputs = new JComponent[] {
                input_panel
            };
            int optionValue = Message.showOptionDialogOkCancel( inputs, "Update Glycemic Index" );
            if ( optionValue == 0 ) {
                try {
                    dbLink.GlycemicIndex_Merge( foodid, Double.valueOf( input.getText() ) );
                    dbLink.foodfact_calculated_quantities_update( foodid );
                    dbLink.stopTransaction();
                } catch ( SQLException e ) {

                }
                reload_food_items();
                resize_col_tbl_food_list();
                Integer rowIndex = modelTableFoodList.find( foodid );
                scroll_to_row_using_table( tableFoodList01, tableFoodList01.convertRowIndexToView( rowIndex ) );
            }
        }
    }

    private void process_evt_btn_meal_add() {
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
        if ( optionValue == 0 ) {
            try {
                MixDataObject mix = ( MixDataObject ) cmb_mix.getSelectedItem();
                String mixid = mix.getMixId();
                String text = input_name.getText();
                NumberCheck checkNumber = new NumberCheck();
                checkNumber.addToUncheckedList( input_order.getText() );
                if ( checkNumber.pass() ) {
                    Integer order = Integer.valueOf( input_order.getText() );
                    dbLink.Meal_insert( mixid, text, order );
                    dbLink.stopTransaction();
                    reload_tblmdl_meals();
                    resize_col_tbl_meal();
                    reload_lstmdl_portion( mixid );
                }
            } catch ( SQLException e ) {
                e.printStackTrace();
            }
        }
    }

    private void process_evt_btn_meal_delete() {
        try {
            int selectedRow = tbl_meals.getSelectedRow();
            String mixid = ( String ) tbl_meals.getValueAt( selectedRow, 0 );
            Integer mealid = ( Integer ) tbl_meals.getValueAt( selectedRow, 1 );
            dbLink.Meal_delete( mixid, mealid );
            dbLink.stopTransaction();
            reload_tblmdl_meals();
            reload_tblmdl_portion( mixid );
            reload_lstmdl_portion( mixid );
            reload_tblmdl_results_by_meal( mixid );
            resize_col_tbl_meal();
            resize_col_tbl_meal_portions();
            resize_col_tbl_results_by_meal_calories();
            resize_col_tbl_results_by_meal_grams();
        } catch ( SQLException e ) {

        }
    }

    private void process_evt_btn_meal_update() {
        JTextField input_name = new JTextField();
        JTextField input_order = new JTextField();
        int selectedRow = tbl_meals.getSelectedRow();
        if ( selectedRow != -1 ) {
            String name = ( String ) tbl_meals.getValueAt( selectedRow, 2 );
            Integer order = ( Integer ) tbl_meals.getValueAt( selectedRow, 3 );
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
            if ( optionValue == 0 ) {
                try {
                    String mixid = ( String ) tbl_meals.getValueAt( selectedRow, 0 );
                    Integer mealid = ( Integer ) tbl_meals.getValueAt( selectedRow, 1 );
                    NumberCheck checkNumber = new NumberCheck();
                    checkNumber.addToUncheckedList( input_order.getText() );
                    if ( checkNumber.pass() ) {
                        dbLink.Meal_update( mixid, mealid, input_name.getText(), Integer.valueOf( input_order.getText() ) );
                        dbLink.stopTransaction();
                        reload_tblmdl_meals();
                        reload_tblmdl_portion( mixid );
                        reload_lstmdl_portion( mixid );
                        reload_tblmdl_results_by_meal( mixid );
                        resize_col_tbl_meal();
                        resize_col_tbl_meal_portions();
                        resize_col_tbl_results_by_meal_calories();
                        resize_col_tbl_results_by_meal_grams();
                    }
                } catch ( SQLException e ) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void process_evt_mnui_assign_portion_to_meal() {
        int[] selected_portions = tbl_meal_portions.getSelectedRows();
        String mixid = "";
        if ( selected_portions.length > 0 ) {
            if ( !listPortionMeal.getSelectedValuesList().isEmpty() ) {
                Integer mealid;
                String foodid;
                Double pct;
                Double pcti;
                ArrayList<O_Meal> selected_meals = ( ArrayList ) listPortionMeal.getSelectedValuesList();
                for ( int i = 0; i < selected_portions.length; i++ ) {
                    int selected_row = selected_portions[ i ];
                    mixid = ( String ) tbl_meal_portions.getValueAt( selected_row, 0 );
                    mealid = ( Integer ) tbl_meal_portions.getValueAt( selected_row, 1 );
                    foodid = ( String ) tbl_meal_portions.getValueAt( selected_row, 2 );
                    pct = ( Double ) tbl_meal_portions.getValueAt( selected_row, 5 );
                    pcti = pct / selected_meals.size();
                    try {
                        dbLink.MealFoodPortion_delete( mixid, mealid, foodid );
                    } catch ( SQLException e ) {
                    }
                    for ( O_Meal meal : selected_meals ) {
                        try {
                            dbLink.MealFoodPortion_insert_and_calculate( mixid, meal.getMealid(), foodid, pcti );
                        } catch ( SQLException e ) {
                        }
                    }
                }
                dbLink.stopTransaction();
                reload_tblmdl_portion( mixid );
                reload_tblmdl_results_by_meal( mixid );
                resize_col_tbl_meal_portions();
                resize_col_tbl_results_by_meal_calories();
                resize_col_tbl_results_by_meal_grams();
            } else {
                Message.showMessage( "Please select one or more meals." );
            }
        }
    }

    private void process_evt_tbl_food_nutrient_constraint() {
        int selectedRow = tableFoodNutrient.getSelectedRow();
        if ( selectedRow != -1 ) {
            String foodid = ( String ) tableFoodNutrient.getValueAt( selectedRow, 1 );
            String nutrientid = ( String ) tableFoodNutrient.getValueAt( selectedRow, 2 );
            Integer relationshipid = ( Integer ) tableFoodNutrient.getValueAt( selectedRow, 3 );
            Double q = ( Double ) tableFoodNutrient.getValueAt( selectedRow, 7 );
            int index_food = find_fooddataobject( foodid, modelComboBox_FoodAtFoodNutrient );
            int index_nutrient = find_nutrientdataobject( nutrientid, modelComboBox_NutrientAtFoodNutrient );
            int index_relationship = find_relationshipdataobject( relationshipid, modelComboBox_RelationshipAtFoodNutrient );
            comboBoxFoodNutrient_Food.setSelectedIndex( index_food );
            comboBoxFoodNutrient_Nutrient.setSelectedIndex( index_nutrient );
            comboBoxFoodNutrient_Relationship.setSelectedIndex( index_relationship );
            textFieldFoodNutrient_Quantity.setText( String.valueOf( q ) );
        }
    }

    private void process_evt_tbl_food_nutrient_percent_constraint() {
        int selectedRow = tableNutrientPercent.getSelectedRow();
        if ( selectedRow != -1 ) {
            String foodid = ( String ) tableNutrientPercent.getValueAt( selectedRow, 1 );
            String nutrientid = ( String ) tableNutrientPercent.getValueAt( selectedRow, 2 );
            Integer relationshipid = ( Integer ) tableNutrientPercent.getValueAt( selectedRow, 3 );
            Double q = ( Double ) tableNutrientPercent.getValueAt( selectedRow, 7 );
            int index_food = find_fooddataobject( foodid, modelComboBox_FoodAtNutrientPct );
            int index_nutrient = find_nutrientdataobject( nutrientid, modelComboBox_NutrientAtNutrientPct );
            int index_relationship = find_relationshipdataobject( relationshipid, modelComboBox_RelationshipAtNutrientPct );
            comboBoxPercentNutrient_Food.setSelectedIndex( index_food );
            comboBoxPercentNutrient_Nutrient.setSelectedIndex( index_nutrient );
            comboBoxPercentNutrient_Relationship.setSelectedIndex( index_relationship );
            textFieldPercentNutrient_Quantity.setText( String.valueOf( q ) );
        }
    }

    private void process_evt_tbl_food_nutrient_ratio_constraint() {
        int selectedRow = tableFoodNutrientRatio.getSelectedRow();
        if ( selectedRow != -1 ) {
            String foodid_a = ( String ) tableFoodNutrientRatio.getValueAt( selectedRow, 1 );
            String nutrientid_a = ( String ) tableFoodNutrientRatio.getValueAt( selectedRow, 2 );
            String foodid_b = ( String ) tableFoodNutrientRatio.getValueAt( selectedRow, 3 );
            String nutrientid_b = ( String ) tableFoodNutrientRatio.getValueAt( selectedRow, 4 );
            Integer relationshipid = ( Integer ) tableFoodNutrientRatio.getValueAt( selectedRow, 5 );
            Double q_a = ( Double ) tableFoodNutrientRatio.getValueAt( selectedRow, 10 );
            Double q_b = ( Double ) tableFoodNutrientRatio.getValueAt( selectedRow, 12 );
            int index_food_a = find_fooddataobject( foodid_a, modelComboBox_0_FoodAtFoodNutrientRatio );
            int index_nutrient_a = find_nutrientdataobject( nutrientid_a, modelComboBox_0_NutrientAtFoodNutrientRatio );
            int index_food_b = find_fooddataobject( foodid_b, modelComboBox_1_FoodAtFoodNutrientRatio );
            int index_nutrient_b = find_nutrientdataobject( nutrientid_b, modelComboBox_1_NutrientAtFoodNutrientRatio );
            int index_relationship = find_relationshipdataobject( relationshipid, modelComboBox_RelationshipAtFoodNutrientRatio );
            comboBoxFoodNutrientRatioFoodA.setSelectedIndex( index_food_a );
            comboBoxFoodNutrientRatioNutrientA.setSelectedIndex( index_nutrient_a );
            textFieldFoodNutrientRatioQuantityA.setText( String.valueOf( q_a ) );
            comboBoxFoodNutrientRatioFoodB.setSelectedIndex( index_food_b );
            comboBoxFoodNutrientRatioNutrientB.setSelectedIndex( index_nutrient_b );
            textFieldFoodNutrientRatioQuantityB.setText( String.valueOf( q_b ) );
            comboBoxFoodNutrientRatioRelationship.setSelectedIndex( index_relationship );
        }
    }

    private void process_evt_tbl_nutrient_constraint() {
        int selectedRow = tableNutrientConstraint.getSelectedRow();
        if ( selectedRow != -1 ) {
            String nutrientid = ( String ) tableNutrientConstraint.getValueAt( selectedRow, 1 );
            Integer relationshipid = ( Integer ) tableNutrientConstraint.getValueAt( selectedRow, 2 );
            Double q = ( Double ) tableNutrientConstraint.getValueAt( selectedRow, 5 );
            int index_nutrient = find_nutrientdataobject( nutrientid, modelComboBox_NutrientAtNutrientConstraint );
            int index_relationship = find_relationshipdataobject( relationshipid, modelComboBox_RelationshipAtNutrient );
            comboBoxNutrientConstraintNutrient.setSelectedIndex( index_nutrient );
            comboBoxNutrientConstraintRelationship.setSelectedIndex( index_relationship );
            textFieldNutrientConstraintQuantity.setText( String.valueOf( q ) );
        }
    }

    private void process_evt_tbl_nutrient_ratio_constraint() {
        int selectedRow = tableNutrientRatio.getSelectedRow();
        if ( selectedRow != -1 ) {
            String nutrientid_a = ( String ) tableNutrientRatio.getValueAt( selectedRow, 1 );
            Double q_a = ( Double ) tableNutrientRatio.getValueAt( selectedRow, 6 );
            String nutrientid_b = ( String ) tableNutrientRatio.getValueAt( selectedRow, 2 );
            Double q_b = ( Double ) tableNutrientRatio.getValueAt( selectedRow, 8 );
            Integer relationshipid = ( Integer ) tableNutrientRatio.getValueAt( selectedRow, 3 );
            int index_nutrient_a = find_nutrientdataobject( nutrientid_a, modelComboBox_0_NutrientAtNutrientRatio );
            int index_nutrient_b = find_nutrientdataobject( nutrientid_b, modelComboBox_1_NutrientAtNutrientRatio );
            int index_relationship = find_relationshipdataobject( relationshipid, modelComboBox_RelationshipAtNutrientRatio );
            comboBoxNutrientRatioNutrientA.setSelectedIndex( index_nutrient_a );
            textFieldNutrientRatioNutrientA.setText( String.valueOf( q_a ) );
            comboBoxNutrientRatioNutrientB.setSelectedIndex( index_nutrient_b );
            textFieldNutrientRatioNutrientB.setText( String.valueOf( q_b ) );
            comboBoxNutrientRatioRelationship.setSelectedIndex( index_relationship );
        }
    }

    private void reload_lstmdl_portion( String mixid ) {
        modelList_PortionMeal.reload( mixid );
    }

    private void process_evt_cb_meal_food_portion() {
        try {
            if ( cmb_food_portion.getSelectedItem() != null ) {
                MixDataObject mix = ( MixDataObject ) cmb_mix.getSelectedItem();
                String mixid = mix.getMixId();
                String foodid = (( FoodDataObject ) cmb_food_portion.getSelectedItem()).getFoodId();
                Double remaining = dbLink.calculate_remaining_percentage( mixid, foodid, precision );
                textfield_portion_remaining.setText( String.valueOf( remaining ) );
            }
        } catch ( SQLException e ) {
            e.printStackTrace();
        }
    }

    private void process_evt_mnui_export_meal_plan() {
        MixDataObject mixDataObject = ( MixDataObject ) cmb_mix.getSelectedItem();
        ExportMealPlan export_meal_plan = new ExportMealPlan( dbLink );
        export_meal_plan.print( mixDataObject );
    }

    private JPanel get_editor_meal_plan() {
        JPanel panel = new JPanel();
        JTabbedPane tabs = new JTabbedPane();
        FormLayout layout = new FormLayout( "min:grow", //columns
                                            "fill:min:grow" //rows
        );
        panel.setLayout( layout );
        tabs.setTabPlacement( JTabbedPane.RIGHT );
        tabs.add( "Meal", new Spacer_panel( get_meal() ) );
        tabs.add( "Portion", new Spacer_panel( get_meal_portion() ) );
        tabs.add( "Energy", new Spacer_panel( get_meal_calories() ) );
        tabs.add( "Macronutrient+", new Spacer_panel( get_meal_grams() ) );
        tabs.setSelectedIndex( 1 );
        panel.add( tabs, cc.xy( 1, 1 ) );
        return panel;
    }

    private JPanel get_meal_calories() {
        JPanel panel = new JPanel();
        FormLayout layout = new FormLayout( "482dlu:grow", //columns
                                            "fill:min:grow" //rows
        );
        panel.setLayout( layout );
        JScrollPane spTable = new JScrollPane( tbl_results_by_meal_calories );
        tbl_results_by_meal_calories.getTableHeader().setReorderingAllowed( false );
        tbl_results_by_meal_calories.setAutoCreateRowSorter( true );
        tbl_results_by_meal_calories.setModel( modelTableResultByMealsCalories );
        tbl_results_by_meal_calories.setSelectionMode( ListSelectionModel.SINGLE_SELECTION );
        tbl_results_by_meal_calories.setFillsViewportHeight( true );
        tbl_results_by_meal_calories.setAutoResizeMode( JTable.AUTO_RESIZE_OFF );
        tbl_results_by_meal_calories.setTableHeader( new TableHeaderResultsByMealCalories( tbl_results_by_meal_calories.getColumnModel() ) );
        panel.add( spTable, cc.xy( 1, 1 ) );
        return panel;
    }

    private JPanel get_meal_grams() {
        JPanel panel = new JPanel();
        FormLayout layout = new FormLayout( "482dlu:grow", //columns
                                            "fill:min:grow" //rows
        );
        panel.setLayout( layout );
        JScrollPane spTable = new JScrollPane( tbl_results_by_meal_grams );
        tbl_results_by_meal_grams.getTableHeader().setReorderingAllowed( false );
        tbl_results_by_meal_grams.setAutoCreateRowSorter( true );
        tbl_results_by_meal_grams.setModel( modelTableResultByMealsGrams );
        tbl_results_by_meal_grams.setSelectionMode( ListSelectionModel.SINGLE_SELECTION );
        tbl_results_by_meal_grams.setFillsViewportHeight( true );
        tbl_results_by_meal_grams.setAutoResizeMode( JTable.AUTO_RESIZE_OFF );
        tbl_results_by_meal_grams.setTableHeader( new TableHeaderResultsByMealGrams( tbl_results_by_meal_grams.getColumnModel() ) );
        panel.add( spTable, cc.xy( 1, 1 ) );
        return panel;
    }

    private void reload_tblmdl_constraints( String mixid ) {
        modelTableNutrientConstraints.reload( mixid );
        modelTableFoodNutrientConstraints.reload( mixid );
        modelTableNutrientRatioConstraints.reload( mixid );
        modelTableFoodNutrientRatioConstraints.reload( mixid );
        tableModelPercentNutrientConstraints.reload( mixid );
    }

    private void reload_cbmdl_relationship() {
        relationship_loader.reload();
        modelComboBox_RelationshipAtNutrient.removeAllElements();
        modelComboBox_RelationshipAtFoodNutrient.removeAllElements();
        modelComboBox_RelationshipAtNutrientRatio.removeAllElements();
        modelComboBox_RelationshipAtFoodNutrientRatio.removeAllElements();
        modelComboBox_RelationshipAtNutrientPct.removeAllElements();
        modelComboBox_RelationshipAtNutrient.addAll( relationship_loader.get_relationship_list() );
        modelComboBox_RelationshipAtFoodNutrient.addAll( relationship_loader.get_relationship_list() );
        modelComboBox_RelationshipAtNutrientRatio.addAll( relationship_loader.get_relationship_list() );
        modelComboBox_RelationshipAtFoodNutrientRatio.addAll( relationship_loader.get_relationship_list() );
        modelComboBox_RelationshipAtNutrientPct.addAll( relationship_loader.get_relationship_list() );
        comboBoxNutrientConstraintRelationship.setSelectedIndex( 0 );
        comboBoxFoodNutrient_Relationship.setSelectedIndex( 0 );
        comboBoxNutrientRatioRelationship.setSelectedIndex( 0 );
        comboBoxFoodNutrientRatioRelationship.setSelectedIndex( 0 );
        comboBoxPercentNutrient_Relationship.setSelectedIndex( 0 );
    }

    private JMenuBar get_menubar() {
        JMenuBar mnuBar = new JMenuBar();
        mnuBar.add( menuProgram );
        mnuBar.add( menu_mix );
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
        menuTools.add( mnui_alpha_linolenic_acid_required );
        menuTools.add( mnui_show_mix_stats );
        menuData.add( mnu_spreadsheet );
        menuData.add( mnu_exchange );
        mnu_spreadsheet.add( menuItemExportFoodList );
        mnu_spreadsheet.add( menuItemExportFoodComparison );
        mnu_spreadsheet.add( mnui_export_rda );
        mnu_spreadsheet.add( mnui_export_mixcomparison );
        mnu_spreadsheet.add( menuItemExportNutrientLookup );
        mnu_spreadsheet.add( mnui_export_mealplan );
        mnu_exchange.add( mnui_import_model );
        mnu_exchange.add( mnui_export_model );
        menuHelp.add( menuItemGuide );
        menuHelp.add( menuItemCredits );
        menuHelp.add( mnui_About );
        menuSettings.add( checkBoxResultRoundUp );
        menuSettings.add( menuItemConstraintsShownInList );
        menu_mix.add( mnui_create_mix );
        menu_mix.add( mnui_delete_mix );
        menu_mix.add( mnui_rename_mix );
        menu_mix.add( mnui_duplicate_mix );
        menu_mix.add( mnui_pin_mix );
        menu_mix.add( mnui_add_mix_to_foodlist );
        menu_mix.add( mnui_minimize_option );
        menuProgram.setText( "Program" );
        menu_mix.setText( "Mix" );
        menuTools.setText( "Tools" );
        menuData.setText( "Data" );
        menuData.setToolTipText( "Find your documents in snack's model directory" );
        menuHelp.setText( "Help" );
        menuSettings.setText( "Settings" );
        menuItemExit.setText( "Exit" );
        menuItemMicronutrientConversion.setText( "Daily Value (%DV) to Grams" );
        menuItemBmr.setText( "Basal Metabolic Rate Of An Individual" );
        menuItemNitrogenBalance.setText( "Complete Protein Required In A No Fat, No Carbs Regimen" );
        menuItemKetosis.setText( "Carbohydrate Required To Inhibit Ketosis" );
        menuItemDigestibleCarbs.setText( "Digestible Carbohydrate Of A Food Item" );
        menuItemGlycemicLoad.setText( "Glycemic Load Of A Food Item" );
        mnui_alpha_linolenic_acid_required.setText( "Alpha-Linolenic Acid Required" );
        mnui_show_mix_stats.setText( "Macronutrient Percentages" );
        menuItemGlycemicIndexRange.setText( "Glycemic Index Range Of A Food Item" );
        mnu_spreadsheet.setText( "Spreadsheet" );
        mnu_exchange.setText( "Exchange" );
        menuItemExportFoodList.setText( "Food List" );
        menuItemExportFoodComparison.setText( "Food Comparison" );
        mnui_export_rda.setText( "Mix Rda" );
        mnui_export_mixcomparison.setText( "Mix Comparison" );
        menuItemExportNutrientLookup.setText( "Nutrient Lookup" );
        mnui_export_mealplan.setText( "Meal Plan " );
        mnui_import_model.setText( "Import" );
        mnui_export_model.setText( "Export" );
        checkBoxResultRoundUp.setText( "Round Up" );
        menuItemConstraintsShownInList.setText( "Nutrients, Energies and Cost Shown As Constraints" );
        menuItemGuide.setText( "Guide" );
        menuItemCredits.setText( "Credits" );
        mnui_About.setText( "About" );
        mnui_create_mix.setText( "Create mix" );
        mnui_delete_mix.setText( "Delete mix" );
        mnui_rename_mix.setText( "Rename mix" );
        mnui_minimize_option.setText( "Choose minimization option" );
        mnui_duplicate_mix.setText( "Duplicate mix" );
        mnui_add_mix_to_foodlist.setText( "Add mix to food list" );
        mnui_pin_mix.setText( "Pin mix" );
        checkBoxResultRoundUp.setSelected( true );
        menuItemMicronutrientConversion.addActionListener( ( ActionEvent e ) ->
        {
            process_evt_mnui_convert_micronutrient();
        } );
        menuItemBmr.addActionListener( ( ActionEvent e ) ->
        {
            process_evt_mnui_bmr();
        } );
        menuItemNitrogenBalance.addActionListener( ( ActionEvent e ) ->
        {
            process_evt_mnui_nitrogen_balance();
        } );
        menuItemKetosis.addActionListener( ( ActionEvent e ) ->
        {
            process_evt_mnui_ketosis();
        } );
        menuItemDigestibleCarbs.addActionListener( ( ActionEvent e ) ->
        {
            process_evt_mnui_digestible_carbs();
        } );
        menuItemGlycemicLoad.addActionListener( ( ActionEvent e ) ->
        {
            process_evt_mnui_glycemic_load();
        } );
        mnui_alpha_linolenic_acid_required.addActionListener( ( ActionEvent e ) ->
        {
            process_evt_mnui_n3_fatty_acid_recommendations();
        } );
        mnui_show_mix_stats.addActionListener( ( ActionEvent e ) ->
        {
            frame.setCursor( Cursor.getPredefinedCursor( Cursor.WAIT_CURSOR ) );
            process_evt_mnui_show_mix_stats();
            frame.setCursor( Cursor.getPredefinedCursor( Cursor.DEFAULT_CURSOR ) );
        } );
        menuItemGlycemicIndexRange.addActionListener( ( ActionEvent e ) ->
        {
            process_evt_mnui_glycemic_index_range();
        } );
        menuItemExportFoodList.addActionListener( ( ActionEvent e ) ->
        {
            process_evt_mnui_export_food_list();
        } );
        menuItemExportFoodComparison.addActionListener( ( ActionEvent e ) ->
        {
            process_evt_mnui_export_food_comparison();
        } );
        mnui_export_mixcomparison.addActionListener( ( ActionEvent e ) ->
        {
            process_evt_mnui_export_mix_comparison();
        } );
        mnui_export_rda.addActionListener( ( ActionEvent e ) ->
        {
            frame.setCursor( Cursor.getPredefinedCursor( Cursor.WAIT_CURSOR ) );
            process_evt_mnui_export_rda_check();
            frame.setCursor( Cursor.getPredefinedCursor( Cursor.DEFAULT_CURSOR ) );
        } );
        menuItemExportNutrientLookup.addActionListener( ( ActionEvent e ) ->
        {
            process_evt_mnui_export_nutrient_lookup();
        } );
        mnui_export_mealplan.addActionListener( ( ActionEvent e ) ->
        {
            frame.setCursor( Cursor.getPredefinedCursor( Cursor.WAIT_CURSOR ) );
            process_evt_mnui_export_meal_plan();
            frame.setCursor( Cursor.getPredefinedCursor( Cursor.DEFAULT_CURSOR ) );
        } );
        mnui_export_model.addActionListener( ( ActionEvent e ) ->
        {
            frame.setCursor( Cursor.getPredefinedCursor( Cursor.WAIT_CURSOR ) );
            process_evt_mnui_export_model();
            frame.setCursor( Cursor.getPredefinedCursor( Cursor.DEFAULT_CURSOR ) );
        } );
        mnui_import_model.addActionListener( ( ActionEvent e ) ->
        {
            frame.setCursor( Cursor.getPredefinedCursor( Cursor.WAIT_CURSOR ) );
            int return_val = process_evt_mnui_import_model();
            frame.setCursor( Cursor.getPredefinedCursor( Cursor.DEFAULT_CURSOR ) );
            if ( return_val == JFileChooser.APPROVE_OPTION ) {
                frame.setCursor( Cursor.getPredefinedCursor( Cursor.WAIT_CURSOR ) );
                process_evt_btn_solve();
                frame.setCursor( Cursor.getPredefinedCursor( Cursor.DEFAULT_CURSOR ) );
            }
        } );
        menuItemGuide.addActionListener( ( ActionEvent e ) ->
        {
            process_evt_mnui_guide();
        } );
        menuItemCredits.addActionListener( ( ActionEvent e ) ->
        {
            process_evt_mnui_credits();
        } );
        mnui_About.addActionListener( ( ActionEvent e ) ->
        {
            process_evt_mnui_about();
        } );
        menuItemConstraintsShownInList.addActionListener( ( ActionEvent e ) ->
        {
            process_evt_mnui_nutrients_shown_as_constraints();
        } );
        checkBoxResultRoundUp.addActionListener( ( ActionEvent e ) ->
        {
            process_evt_chkb_roundup();
        } );
        menuItemExit.addActionListener( ( ActionEvent e ) ->
        {
            process_evt_mnui_exit();
        } );
        mnui_create_mix.addActionListener( ( ActionEvent e ) ->
        {
            process_evt_mnui_mix_create();
        } );
        mnui_delete_mix.addActionListener( ( ActionEvent e ) ->
        {
            process_evt_mnui_mix_delete();
        } );
        mnui_rename_mix.addActionListener( ( ActionEvent e ) ->
        {
            process_evt_mnui_mix_rename();
        } );
        mnui_minimize_option.addActionListener( ( ActionEvent e ) ->
        {
            process_evt_mnui_choose_minimization_option();
        } );
        mnui_duplicate_mix.addActionListener( ( ActionEvent e ) ->
        {
            process_evt_mnui_mix_duplicate();
        } );
        mnui_add_mix_to_foodlist.addActionListener( ( ActionEvent e ) ->
        {
            process_evt_btn_add_mix_to_foodlist();
        } );
        mnui_pin_mix.addActionListener( ( ActionEvent e ) ->
        {
            process_evt_mnui_pin_mix();
        } );
        return mnuBar;
    }

    private void process_evt_chkb_roundup() {
        set_precision();
        reload_tblmdl_editor_results();
        reload_tblmdl_editor_rda_check();
        reload_food_items();
        reload_tblmdl_food_comparison();
        reload_tblmdl_mix_comparison();
        reload_tblmdl_nutrient_lookup();
        resize_col_tbl_meal();
        resize_col_tbl_meal_portions();
        resize_col_tbl_results_by_meal_calories();
        resize_col_tbl_results_by_meal_grams();
        resize_col_tbl_editor_rda_check();
        resize_col_tbl_food_list();
        resize_tbl_editor_results();
    }

    private void process_evt_mnui_digestible_carbs() {
        FormLayout layout = new FormLayout( "min,30dlu", //columns
                                            "min,16dlu" //rows
        );
        JPanel input_panel = new JPanel();
        input_panel.setLayout( layout );
        JTextField total_carbs = new JTextField();
        JTextField total_fiber = new JTextField();
        JLabel total_carbs_label = new JLabel( "What is total carbohydrate (g) of food item? " );
        JLabel total_fiber_label = new JLabel( "What is total fiber (g) in food item? " );
        total_carbs_label.setHorizontalAlignment( JLabel.RIGHT );
        total_fiber_label.setHorizontalAlignment( JLabel.RIGHT );
        input_panel.add( total_carbs_label, cc.xy( 1, 1 ) );
        input_panel.add( total_carbs, cc.xy( 2, 1 ) );
        input_panel.add( total_fiber_label, cc.xy( 1, 2 ) );
        input_panel.add( total_fiber, cc.xy( 2, 2 ) );
        JComponent[] inputs = new JComponent[] {
            input_panel
        };
        int optionValue = Message.showOptionDialogOkCancel( inputs, "Digestible Carbohydrate" );
        if ( optionValue == 0 ) {
            String totalCarbsText = total_carbs.getText();
            String totalFiberText = total_fiber.getText();
            if ( totalCarbsText != null && totalCarbsText.length() > 0 ) {
                if ( totalFiberText != null && totalFiberText.length() > 0 ) {
                    StringBuilder sb = new StringBuilder();
                    NumberCheck checkNumber = new NumberCheck();
                    checkNumber.addToUncheckedList( totalCarbsText );
                    checkNumber.addToUncheckedList( totalFiberText );
                    if ( checkNumber.pass() ) {
                        Double totalCarbsNumber = Double.valueOf( totalCarbsText );
                        Double totalFiberNumber = Double.valueOf( totalFiberText );
                        double digestibleCarbsNumber = new DigestibleCarbohydrate( totalCarbsNumber, totalFiberNumber ).getDigestibleCarbohydrate();
                        sb.append( "There are " );
                        sb.append( digestibleCarbsNumber );
                        sb.append( " grams of digestible carbohydrates." );
                        String_display_component component = new String_display_component();
                        component.setText( sb.toString() );
                        component.setPreferredSize( new Dimension( 314, 40 ) );
                        inputs = new JComponent[ 1 ];
                        inputs[ 0 ] = component;
                        Message.showOptionDialog( inputs, "Digestible Carbohydrate" );
                    }
                }
            }
        }
    }

    private void process_evt_mnui_glycemic_index_range() {
        JTextField input = new JTextField();
        JPanel input_panel = new JPanel();
        input.setPreferredSize( new Dimension( 50, 25 ) );
        input_panel.add( new JLabel( "What is glycemic index of food item?" ) );
        input_panel.add( input );
        JComponent[] inputs = new JComponent[] {
            input_panel
        };
        int optionValue = Message.showOptionDialogOkCancel( inputs, "Glycemic Index Range" );
        if ( optionValue == 0 ) {
            String strGI = input.getText();
            if ( strGI != null && strGI.length() > 0 ) {
                StringBuilder sb = new StringBuilder();
                NumberCheck checkNumber = new NumberCheck();
                checkNumber.addToUncheckedList( strGI );
                if ( checkNumber.pass() ) {
                    Integer gi = Integer.valueOf( strGI );
                    String range = new GlycemicIndexRange( gi ).getGlycemicIndexRange();
                    sb.append( "The glycemic index is in " );
                    sb.append( range.toLowerCase() );
                    sb.append( " range." );
                    String_display_component component = new String_display_component();
                    component.setText( sb.toString() );
                    component.setPreferredSize( new Dimension( 275, 40 ) );
                    inputs = new JComponent[ 1 ];
                    inputs[ 0 ] = component;
                    Message.showOptionDialog( inputs, "Glycemic Index Range" );
                }
            }
        }
    }

    private void process_evt_mnui_bmr() {
        JTextField input = new JTextField();
        JPanel input_panel = new JPanel();
        input.setPreferredSize( new Dimension( 50, 25 ) );
        input_panel.add( new JLabel( "What is your lean body mass in pounds?" ) );
        input_panel.add( input );
        JComponent[] inputs = new JComponent[] {
            input_panel
        };
        int optionValue = Message.showOptionDialogOkCancel( inputs, "Basal Metabolic Rate" );
        if ( optionValue == 0 ) {
            String s = input.getText();
            if ( s != null && s.length() > 0 ) {
                StringBuilder sb = new StringBuilder();
                NumberCheck checkNumber = new NumberCheck();
                checkNumber.addToUncheckedList( s );
                if ( checkNumber.pass() ) {
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
                    String_display_component component = new String_display_component();
                    component.setText( sb.toString() );
                    component.setPreferredSize( new Dimension( 500, 40 ) );
                    inputs = new JComponent[ 1 ];
                    inputs[ 0 ] = component;
                    Message.showOptionDialog( inputs, "Basal Metabolic Rate" );
                } else {
                    Message.showMessage( "Numbers only" );
                }
            }
        }
    }

    private void process_evt_mnui_nitrogen_balance() {
        JTextField textFieldLbs = new JTextField();
        textFieldLbs.setPreferredSize( new Dimension( 50, 25 ) );
        JPanel input_panel = new JPanel();
        input_panel.add( new JLabel( "What is your lean body mass in pounds?" ) );
        input_panel.add( textFieldLbs );
        JComponent[] inputs = new JComponent[] {
            input_panel
        };
        int optionValue = Message.showOptionDialogOkCancel( inputs, "Complete Protein Required" );
        if ( optionValue == 0 ) {
            String s = textFieldLbs.getText();
            if ( s != null && s.length() > 0 ) {
                StringBuilder sb = new StringBuilder();
                NumberCheck checkNumber = new NumberCheck();
                checkNumber.addToUncheckedList( s );
                if ( checkNumber.pass() ) {
                    Double weightinlbs = Double.valueOf( s );
                    double protein = new MinimumNutrientRequirements( weightinlbs ).getProtein();
                    sb.append( "The amount of complete protein required in a no fat, no carbs regimen to maintain nitrogen balance is " );
                    sb.append( Math.round( protein ) );
                    sb.append( " grams." );
                    sb.append( "\n" );
                    String_display_component component = new String_display_component();
                    component.setText( sb.toString() );
                    component.setPreferredSize( new Dimension( 760, 40 ) );
                    inputs = new JComponent[ 1 ];
                    inputs[ 0 ] = component;
                    Message.showOptionDialog( inputs, "Complete Protein Required (no carbs, no fats)" );
                } else {
                    Message.showMessage( "Numbers only" );
                }
            }
        }
    }

    private void process_evt_mnui_ketosis() {
        StringBuilder sb = new StringBuilder();
        double carbohydrateLow = new MinimumNutrientRequirements( 0.0 ).getCarbohydrateLow();
        double carbohydrateMedium = new MinimumNutrientRequirements( 0.0 ).getCarbohydrateMedium();
        double carbohydrateHigh = new MinimumNutrientRequirements( 0.0 ).getCarbohydrateHigh();
        sb.append( "The carbohydrate amount required to appreciably reduce ketosis is between " );
        sb.append( carbohydrateLow );
        sb.append( " to " );
        sb.append( carbohydrateMedium );
        sb.append( " grams." );
        sb.append( "\n" );
        sb.append( "The carbohydrate amount required to inhibit ketosis is between " );
        sb.append( carbohydrateMedium );
        sb.append( " to " );
        sb.append( carbohydrateHigh );
        sb.append( " grams." );
        sb.append( "\n" );
        String_display_component component = new String_display_component();
        component.setText( sb.toString() );
        component.setPreferredSize( new Dimension( 670, 40 ) );
        JComponent[] inputs = new JComponent[ 1 ];
        inputs[ 0 ] = component;
        Message.showOptionDialog( inputs, "Carbohydrate Required to Inhibit Ketosis" );
    }

    private void process_evt_mnui_convert_micronutrient() {
        FormLayout layout = new FormLayout( "min:grow,30dlu,min", //columns
                                            "fill:16dlu" //rows
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
        if ( optionValue == 0 ) {
            String s = dailyValuePct.getText();
            if ( s != null && s.length() > 0 ) {
                NutrientDataObject nutrientDataObject = ( NutrientDataObject ) cboxNutrients.getSelectedItem();
                StringBuilder sb = new StringBuilder();
                NumberCheck checkNumber = new NumberCheck();
                checkNumber.addToUncheckedList( s );
                if ( checkNumber.pass() ) {
                    Double dvpct = Double.valueOf( s );
                    sb.append( dvpct * (nutrientDataObject.getQ() / 100) );
                    sb.append( " " );
                    sb.append( nutrientDataObject.getNutrdesc() );
                    sb.append( "\n" );
                    String_display_component component = new String_display_component();
                    component.setText( sb.toString() );
                    component.setPreferredSize( new Dimension( 275, 40 ) );
                    inputs = new JComponent[ 1 ];
                    inputs[ 0 ] = component;
                    Message.showOptionDialog( inputs, "Pct Daily Value to Grams" );
                } else {
                    Message.showMessage( "Numbers only" );
                }
            }
        }
    }

    private JTabbedPane get_constraints_tab_pane() {
        JTabbedPane constraints_tab_pane = new JTabbedPane();
        constraints_tab_pane.setBorder( new TitledBorder( "Mix Definition" ) );
        constraints_tab_pane.setTabPlacement( JTabbedPane.RIGHT );
        constraints_tab_pane.add( "Food List", get_mix_food() );
        constraints_tab_pane.add( "Nutrient", new Spacer_panel( get_constraint_nutrient() ) );
        constraints_tab_pane.add( "Food Nutrient", new Spacer_panel( get_constraint_food_nutrient() ) );
        constraints_tab_pane.add( "Nutrient Ratio", new Spacer_panel( get_constraint_nutrient_ratio() ) );
        constraints_tab_pane.add( "Food Nutrient Ratio", new Spacer_panel( get_constraint_food_nutrient_ratio() ) );
        constraints_tab_pane.add( "Food Nutrient Percent", new Spacer_panel( get_constraint_food_nutrient_percent() ) );
        constraints_tab_pane.setToolTipTextAt( 0, "Add food items to this list" );
        constraints_tab_pane.setToolTipTextAt( 1, "Specify limit for mix" );
        constraints_tab_pane.setToolTipTextAt( 2, "Specify limit for food" );
        constraints_tab_pane.setToolTipTextAt( 3, "Specify proportion between nutrients" );
        constraints_tab_pane.setToolTipTextAt( 4, "Specify proportion between foods" );
        constraints_tab_pane.setToolTipTextAt( 5, "Specify limit for food using percentage" );
        return constraints_tab_pane;
    }

    private JTabbedPane get_editor_solution() {
        JTabbedPane pane = new JTabbedPane();
        pane.setTabPlacement( JTabbedPane.BOTTOM );
        pane.add( "Model", get_editor_results() );
        pane.add( "Meal Plan", get_editor_meal_plan() );
        return pane;
    }

    private JPanel get_editor() {
        JPanel panel = new JPanel();
        FormLayout layout = new FormLayout( "min:grow", //columns
                                            "fill:min:grow,min" //rows
        );
        panel.setLayout( layout );
        panel.add( get_editor_solution(), cc.xy( 1, 1 ) );
        panel.add( get_editor_mixes(), cc.xy( 1, 2 ) );
        cmb_mix.addActionListener( ( ActionEvent e ) ->
        {
            if ( cmb_mix.getSelectedItem() != null ) {
                enable_jcomponent( true );
                frame.setCursor( Cursor.getPredefinedCursor( Cursor.WAIT_CURSOR ) );
                process_evt_cmb_mix();
                frame.setCursor( Cursor.getPredefinedCursor( Cursor.DEFAULT_CURSOR ) );
            } else {
                enable_jcomponent( false );
            }
        } );
        cmb_mix.setModel( mdl_cmb_mix );
        return panel;
    }

    private void enable_jcomponent( boolean value ) {
        mnui_delete_mix.setEnabled( value );
        mnui_rename_mix.setEnabled( value );
        mnui_minimize_option.setEnabled( value );
        mnui_duplicate_mix.setEnabled( value );
        mnui_add_mix_to_foodlist.setEnabled( value );
        btn_solve.setEnabled( value );
        btn_undo.setEnabled( value );
        mnui_show_mix_stats.setEnabled( value );
        mnui_export_rda.setEnabled( value );
        mnui_export_mealplan.setEnabled( value );
        mnui_export_model.setEnabled( value );
        cmb_food_portion.setEnabled( value );
        mnui_export_mixcomparison.setEnabled( value );
    }

    private JPanel get_editor_mixes() {
        JPanel pnl_mix_list = new JPanel();
        FormLayout pnl_mix_list_lyo = new FormLayout( "min:grow,min", //columns
                                                      "fill:min:grow" //rows
        );
        pnl_mix_list.setLayout( pnl_mix_list_lyo );
        pnl_mix_list.setBorder( new TitledBorder( "Mix" ) );
        JPanel pnl_buttons = new JPanel();
        FormLayout pnl_buttons_lyo = new FormLayout( "min,min", //columns
                                                     "min" //rows
        );
        pnl_buttons.setLayout( pnl_buttons_lyo );
        btn_solve.setToolTipText( "Find food combination" );
        btn_undo.setToolTipText( "Undo model definition changes" );
        pnl_buttons.add( btn_solve, cc.xy( 1, 1 ) );
        pnl_buttons.add( btn_undo, cc.xy( 2, 1 ) );
        pnl_mix_list.add( cmb_mix, cc.xy( 1, 1 ) );
        pnl_mix_list.add( pnl_buttons, cc.xy( 2, 1 ) );
        btn_solve.addActionListener( ( ActionEvent e ) ->
        {
            frame.setCursor( Cursor.getPredefinedCursor( Cursor.WAIT_CURSOR ) );
            process_evt_btn_solve();
            frame.setCursor( Cursor.getPredefinedCursor( Cursor.DEFAULT_CURSOR ) );

        } );
        btn_undo.addActionListener( ( ActionEvent e ) ->
        {
            process_evt_btn_undo();
        } );
        return pnl_mix_list;

    }

    private void process_evt_lst_mixes( MouseEvent e, JPopupMenu pmn ) {
        if ( (e.getModifiers() & InputEvent.BUTTON3_MASK) != 0 ) {
            Component component = e.getComponent();
            pmn.show( component, e.getX(), e.getY() );
        }
    }

    private void process_evt_mnui_pin_mix() {
        MixDataObject mix = ( MixDataObject ) mdl_cmb_mix.getSelectedItem();
        String mixid = mix.getMixId();
        try {
            dbLink.pin_mix( mixid );
            reload_lstmdl_mixes();
            int index = mdl_cmb_mix.find_by_mixid( mix.getMixId() );
            cmb_mix.setSelectedIndex( index );
        } catch ( SQLException ex ) {
        }
    }

    private void process_evt_mnui_mix_create() {
        JTextField input = new JTextField();
        JComponent[] inputs = new JComponent[] {
            new JLabel( "What would you like to call it?" ),
            input
        };
        int optionValue = Message.showOptionDialogOkCancel( inputs, "Create Mix" );
        if ( optionValue == 0 ) {
            String mixnom = input.getText();
            String model = "";
            //Set default objective function value to minimize
            String nutrientid = "10009";
            try {
                StringCheck sc = new StringCheck();
                sc.addUncheckedList( mixnom );
                if ( sc.pass() ) {
                    String mixid = dbLink.Mix_Insert( mixnom );
                    dbLink.Mix_Update_NutrientId( mixid, nutrientid );
                    dbLink.Mix_Update_Other( mixid, model );
                    dbLink.Mix_Update_Status( mixid, 1 );
                    dbLink.stopTransaction();
                    reload_lstmdl_mixes();
                    clear_model_all();
                    cmb_mix.setSelectedIndex( 0 );
                } else {
                    Message.showMessage( "These characters are not allowed: < & > ' \"" );
                }
            } catch ( SQLException e ) {

            }
        }
    }

    private void reload_lstmdl_mixes() {
        mdl_cmb_mix.reload();
        modelList_A_MixDiff.reload();
        modelList_B_MixDiff.reload();
    }

    private void reload_cbmdl_nutrient() {
        nutrient_loader.reload();
        modelComboBox_NutrientAtNutrientConstraint.removeAllElements();
        modelComboBox_NutrientAtFoodNutrient.removeAllElements();
        modelComboBox_NutrientAtNutrientPct.removeAllElements();
        modelComboBox_0_NutrientAtFoodNutrientRatio.removeAllElements();
        modelComboBox_1_NutrientAtFoodNutrientRatio.removeAllElements();
        modelComboBox_0_NutrientAtNutrientRatio.removeAllElements();
        modelComboBox_1_NutrientAtNutrientRatio.removeAllElements();
        modelComboBox_NutrientAtNutrientConstraint.addAll( nutrient_loader.get_nutrient_list() );
        modelComboBox_NutrientAtFoodNutrient.addAll( nutrient_loader.get_nutrient_list() );
        modelComboBox_NutrientAtNutrientPct.addAll( nutrient_loader.get_nutrient_list() );
        modelComboBox_0_NutrientAtFoodNutrientRatio.addAll( nutrient_loader.get_nutrient_list() );
        modelComboBox_1_NutrientAtFoodNutrientRatio.addAll( nutrient_loader.get_nutrient_list() );
        modelComboBox_0_NutrientAtNutrientRatio.addAll( nutrient_loader.get_nutrient_list() );
        modelComboBox_1_NutrientAtNutrientRatio.addAll( nutrient_loader.get_nutrient_list() );
        comboBoxNutrientConstraintNutrient.setSelectedIndex( 0 );
        comboBoxFoodNutrient_Nutrient.setSelectedIndex( 0 );
        comboBoxPercentNutrient_Nutrient.setSelectedIndex( 0 );
        comboBoxFoodNutrientRatioNutrientA.setSelectedIndex( 0 );
        comboBoxFoodNutrientRatioNutrientB.setSelectedIndex( 0 );
        comboBoxNutrientRatioNutrientA.setSelectedIndex( 0 );
        comboBoxNutrientRatioNutrientB.setSelectedIndex( 0 );
        //Do not include modelComboBox_NutrientLookupListNutrient, all nutrients must be on list
        //modelComboBox_NutrientLookupListNutrient.reload();
    }

    private void set_cbmdl_editor_lifestage_to_daily_value() {
        cbmdl_results_lifestage.reload();
        cbmdl_results_lifestage.setSelectedItem( new RdaLifeStageDataObject( 22, "Daily Value" ) );
    }

    private void set_cbmdl_journal_lifestage_to_daily_value() {
        cbmdl_journal_lifestage.reload();
        cbmdl_journal_lifestage.setSelectedItem( new RdaLifeStageDataObject( 22, "Daily Value" ) );
    }

    private void reload_cbmdl_food( String mixid ) {
        cb_food_loader.reload( mixid );
        if ( !cb_food_loader.get_food_list().isEmpty() ) {
            FoodDataObject food01 = ( FoodDataObject ) comboBoxFoodNutrientRatioFoodA.getSelectedItem();
            FoodDataObject food02 = ( FoodDataObject ) comboBoxFoodNutrientRatioFoodB.getSelectedItem();
            FoodDataObject food03 = ( FoodDataObject ) comboBoxFoodNutrient_Food.getSelectedItem();
            FoodDataObject food04 = ( FoodDataObject ) comboBoxPercentNutrient_Food.getSelectedItem();
            modelComboBox_0_FoodAtFoodNutrientRatio.removeAllElements();
            modelComboBox_1_FoodAtFoodNutrientRatio.removeAllElements();
            modelComboBox_FoodAtFoodNutrient.removeAllElements();
            modelComboBox_FoodAtNutrientPct.removeAllElements();
            modelComboBox_0_FoodAtFoodNutrientRatio.addAll( cb_food_loader.get_food_list() );
            modelComboBox_1_FoodAtFoodNutrientRatio.addAll( cb_food_loader.get_food_list() );
            modelComboBox_FoodAtFoodNutrient.addAll( cb_food_loader.get_food_list() );
            modelComboBox_FoodAtNutrientPct.addAll( cb_food_loader.get_food_list() );
            comboBoxFoodNutrientRatioFoodA.setSelectedIndex( 0 );
            comboBoxFoodNutrientRatioFoodB.setSelectedIndex( 0 );
            comboBoxFoodNutrient_Food.setSelectedIndex( 0 );
            comboBoxPercentNutrient_Food.setSelectedIndex( 0 );
            if ( food01 != null ) {
                int index01 = find_fooddataobject( food01, modelComboBox_0_FoodAtFoodNutrientRatio );
                int index02 = find_fooddataobject( food02, modelComboBox_1_FoodAtFoodNutrientRatio );
                int index03 = find_fooddataobject( food03, modelComboBox_FoodAtFoodNutrient );
                int index04 = find_fooddataobject( food04, modelComboBox_FoodAtNutrientPct );
                food01 = ( FoodDataObject ) modelComboBox_0_FoodAtFoodNutrientRatio.getElementAt( index01 );
                food02 = ( FoodDataObject ) modelComboBox_1_FoodAtFoodNutrientRatio.getElementAt( index02 );
                food03 = ( FoodDataObject ) modelComboBox_FoodAtFoodNutrient.getElementAt( index03 );
                food04 = ( FoodDataObject ) modelComboBox_FoodAtNutrientPct.getElementAt( index04 );
                comboBoxFoodNutrientRatioFoodA.setSelectedItem( food01 );
                comboBoxFoodNutrientRatioFoodB.setSelectedItem( food02 );
                comboBoxFoodNutrient_Food.setSelectedItem( food03 );
                comboBoxPercentNutrient_Food.setSelectedItem( food04 );
            }
        }
    }

    private int find_fooddataobject( FoodDataObject food01, DefaultComboBoxModel model ) {
        int index = 0;
        int size = model.getSize();
        for ( int i = 0; i < size; i++ ) {
            FoodDataObject elementAt = ( FoodDataObject ) model.getElementAt( i );
            if ( elementAt.getFoodId().equals( food01.getFoodId() ) ) {
                index = i;
                break;
            }
        }
        return index;
    }

    private int find_fooddataobject( String foodid, DefaultComboBoxModel model ) {
        int index = 0;
        int size = model.getSize();
        for ( int i = 0; i < size; i++ ) {
            FoodDataObject elementAt = ( FoodDataObject ) model.getElementAt( i );
            if ( elementAt.getFoodId().equals( foodid ) ) {
                index = i;
                break;
            }
        }
        return index;
    }

    private int find_nutrientdataobject( String nutrient01, DefaultComboBoxModel model ) {
        int index = 0;
        int size = model.getSize();
        for ( int i = 0; i < size; i++ ) {
            NutrientDataObject elementAt = ( NutrientDataObject ) model.getElementAt( i );
            if ( elementAt.getNutr_no().equals( nutrient01 ) ) {
                index = i;
                break;
            }
        }
        return index;
    }

    private int find_relationshipdataobject( int relationship_id, DefaultComboBoxModel model ) {
        int index = 0;
        int size = model.getSize();
        for ( int i = 0; i < size; i++ ) {
            RelationshipDataObject elementAt = ( RelationshipDataObject ) model.getElementAt( i );
            if ( elementAt.getRelationshipid() == relationship_id ) {
                index = i;
                break;
            }
        }
        return index;
    }

    private void resize_tbl_editor_results() {
        tableEnergy.getColumnModel().getColumn( 0 ).setMinWidth( 300 );
        for ( int i = 1; i < 9; i++ ) {
            tableEnergy.getColumnModel().getColumn( i ).setMinWidth( 70 );
        }
        tableEnergy.getColumnModel().getColumn( 6 ).setMinWidth( 90 );
        tableMacronutrient.getColumnModel().getColumn( 0 ).setMinWidth( 300 );
        for ( int i = 1; i < 6; i++ ) {
            tableMacronutrient.getColumnModel().getColumn( i ).setMinWidth( 70 );
        }
        tableProtein.getColumnModel().getColumn( 0 ).setMinWidth( 300 );
        for ( int i = 1; i < 5; i++ ) {
            tableProtein.getColumnModel().getColumn( i ).setMinWidth( 70 );
        }
        tableFats.getColumnModel().getColumn( 0 ).setMinWidth( 300 );
        for ( int i = 1; i < 12; i++ ) {
            tableFats.getColumnModel().getColumn( i ).setMinWidth( 70 );
        }
        tableCarbs.getColumnModel().getColumn( 0 ).setMinWidth( 300 );
        for ( int i = 1; i < 6; i++ ) {
            tableCarbs.getColumnModel().getColumn( i ).setMinWidth( 70 );
        }
        tableCarbs.getColumnModel().getColumn( 3 ).setMinWidth( 90 );
        tableVitamins.getColumnModel().getColumn( 0 ).setMinWidth( 300 );
        for ( int i = 1; i < 15; i++ ) {
            tableVitamins.getColumnModel().getColumn( i ).setMinWidth( 70 );
        }
        tableMinerals.getColumnModel().getColumn( 0 ).setMinWidth( 300 );
        for ( int i = 1; i < 10; i++ ) {
            tableMinerals.getColumnModel().getColumn( i ).setMinWidth( 70 );
        }
        tableWater.getColumnModel().getColumn( 0 ).setMinWidth( 300 );
        for ( int i = 1; i < 3; i++ ) {
            tableWater.getColumnModel().getColumn( i ).setMinWidth( 70 );
        }
        tableCost.getColumnModel().getColumn( 0 ).setMinWidth( 300 );
        for ( int i = 1; i < 3; i++ ) {
            tableCost.getColumnModel().getColumn( i ).setMinWidth( 70 );
        }
        tableElectrolytes.getColumnModel().getColumn( 0 ).setMinWidth( 300 );
        for ( int i = 1; i < 4; i++ ) {
            tableElectrolytes.getColumnModel().getColumn( i ).setMinWidth( 70 );
        }
        tableGlycemic.getColumnModel().getColumn( 0 ).setMinWidth( 300 );
        for ( int i = 1; i < 8; i++ ) {
            tableGlycemic.getColumnModel().getColumn( i ).setMinWidth( 70 );
        }
    }

    private void reload_tblmdl_editor_results() {
        MixDataObject mixDataObject = ( MixDataObject ) cmb_mix.getSelectedItem();
        String mixid = mixDataObject.getMixId();
        result_loader.reload( mixid );
        modelTableEnergy.reload();
        modelTableMacroNutrient.reload();
        modelTableProtein.reload();
        modelTableFats.reload();
        modelTableCarbs.reload();
        modelTableVitamins.reload();
        modelTableMinerals.reload();
        modelTableWater.reload();
        modelTableCost.reload();
        modelTableElectrolytes.reload();
        modelTableGlycemic.reload( mixid );
    }

    private void process_evt_mnui_mix_delete() {
        JComponent[] inputs = new JComponent[] {
            new JLabel( "Would you like to delete mix?" )
        };
        int optionValue = Message.showOptionDialogOkCancel( inputs, "Delete Mix" );
        if ( optionValue == 0 ) {
            try {
                MixDataObject mix = ( MixDataObject ) cmb_mix.getSelectedItem();
                String mixid = mix.getMixId();
                dbLink.Mix_Delete( mixid );
                dbLink.stopTransaction();
                reload_lstmdl_mixes();
                clear_model_all();
                set_constraint_counts();
                if ( cmb_mix.getModel().getSize() > 0 ) {
                    cmb_mix.setSelectedIndex( 0 );
                }
            } catch ( SQLException e ) {

            }
        } else {
        }
    }

    private void clear_model_all() {
        clear_model_solve();
        clear_model_meal_plan();
        clear_model_mix_comparison();
        clear_model_food_combo_boxes();
    }

    private void clear_model_mix_comparison() {
        modelTableMixDifference.setRowCount( 0 );
    }

    private void clear_model_food_combo_boxes() {
        cb_food_loader.reload( "" );
    }

    private void clear_model_solve() {
        modelList_selected_food.clear();
        modelTableNutrientConstraints.setRowCount( 0 );
        modelTableFoodNutrientConstraints.setRowCount( 0 );
        modelTableNutrientRatioConstraints.setRowCount( 0 );
        modelTableFoodNutrientRatioConstraints.setRowCount( 0 );
        tableModelPercentNutrientConstraints.setRowCount( 0 );
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
        modelTableRda.setRowCount( 0 );
        txta_editor_model.setText( "" );
    }

    private void process_evt_mnui_mix_rename() {
        JTextField input = new JTextField();
        JComponent[] inputs = new JComponent[] {
            new JLabel( "What is your new mix name?" ),
            input
        };
        MixDataObject mix = ( MixDataObject ) cmb_mix.getSelectedItem();
        input.setText( mix.getName() );
        int optionValue = Message.showOptionDialogOkCancel( inputs, "Update Mix" );
        if ( optionValue == 0 ) {
            try {
                String mixnom = input.getText();
                StringCheck sc = new StringCheck();
                sc.addUncheckedList( mixnom );
                if ( sc.pass() ) {
                    String mixid = mix.getMixId();
                    dbLink.Mix_Update_Name( mixid, mixnom );
                    dbLink.stopTransaction();
                    reload_lstmdl_mixes();
                    int index = mdl_cmb_mix.find_by_mixid( mix.getMixId() );
                    cmb_mix.setSelectedIndex( index );
                } else {
                    Message.showMessage( "These characters are not allowed: < & > ' \"" );
                }
            } catch ( SQLException e ) {

            }
        }
    }

    private void process_evt_mnui_mix_duplicate() {
        JComponent[] inputs = new JComponent[] {
            new JLabel( "Would you like to duplicate mix?" )
        };
        int optionValue = Message.showOptionDialogOkCancel( inputs, "Duplicate Mix" );
        if ( optionValue == 0 ) {
            try {
                MixDataObject mix = ( MixDataObject ) cmb_mix.getSelectedItem();
                String mixid = mix.getMixId();
                dbLink.Mix_Duplicate( mixid );
                dbLink.stopTransaction();
                HashSet set_without = new HashSet();
                HashSet set_with = new HashSet();
                final int old_size = mdl_cmb_mix.getSize();
                for ( int i = 0; i < old_size; i++ ) {
                    MixDataObject o = ( MixDataObject ) mdl_cmb_mix.getElementAt( i );
                    set_without.add( o.getMixId() );
                }
                reload_lstmdl_mixes();
                for ( int i = 0; i < mdl_cmb_mix.getSize(); i++ ) {
                    MixDataObject o = ( MixDataObject ) mdl_cmb_mix.getElementAt( i );
                    set_with.add( o.getMixId() );
                }
                if ( set_with.removeAll( set_without ) ) {
                    if ( !set_with.isEmpty() ) {
                        int index = mdl_cmb_mix.find_by_mixid( ( String ) set_with.toArray()[ 0 ] );
                        cmb_mix.setSelectedIndex( index );
                    }
                } else {
                    cmb_mix.setSelectedIndex( 0 );
                }
            } catch ( SQLException e ) {

            }
        }
    }

    private void process_evt_btn_add_mix_to_foodlist() {
        JComponent[] inputs = new JComponent[] {
            new JLabel( "Would you like to add mix to food list?" ),};
        int optionValue = Message.showOptionDialogOkCancel( inputs, "Add to Food List" );
        if ( optionValue == 0 ) {
            try {
                MixDataObject mixDataObject = ( MixDataObject ) cmb_mix.getSelectedItem();
                dbLink.Food_Put( mixDataObject.getMixId() );
                dbLink.stopTransaction();
                reload_food_items();
                resize_col_tbl_food_list();
            } catch ( SQLException e ) {

            }
        }
    }

    private JTable get_table_mix_comparison() {
        JTable table;
        table = new JTable() {
            @Override
            public Component prepareRenderer( TableCellRenderer renderer, int rowIndex, int columnIndex ) {
                JComponent component = ( JComponent ) super.prepareRenderer( renderer, rowIndex, columnIndex );
                Double valueAt;
                switch ( columnIndex ) {
                    case 0:
                        component.setForeground( tableEnergy.getForeground() );
                        break;
                    case 1:
                        component.setForeground( tableEnergy.getForeground() );
                        break;
                    case 2:
                        valueAt = ( Double ) getValueAt( rowIndex, columnIndex );
                        if ( valueAt <= 0 ) {
                            component.setForeground( Color.red );
                        } else {
                            component.setForeground( tableEnergy.getForeground() );
                        }
                        break;
                    case 3:
                        valueAt = ( Double ) getValueAt( rowIndex, columnIndex );
                        if ( valueAt <= 0 ) {
                            component.setForeground( Color.red );
                        } else {
                            component.setForeground( tableEnergy.getForeground() );
                        }
                        break;
                    case 4:
                        valueAt = ( Double ) getValueAt( rowIndex, columnIndex );
                        if ( valueAt < 0 ) {
                            component.setForeground( Color.red );
                        } else {
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
        tbl_mix_comparison = get_table_mix_comparison();
        JScrollPane scrollPaneA = new JScrollPane( lst_mix_compare_a );
        JScrollPane scrollPaneB = new JScrollPane( lst_mix_compare_b );
        JScrollPane scrollPaneC = new JScrollPane( tbl_mix_comparison );
        JPanel search_panel = new JPanel();
        JLabel search_label = new JLabel( "Search: " );
        JTextField search_field = new JTextField();
        //create layouts
        FormLayout layout = new FormLayout(
                "4dlu,150dlu,4dlu,150dlu,4dlu,min:grow,4dlu", //columns
                "4dlu,min,fill:min:grow,4dlu" //rows
        );
        FormLayout layout02 = new FormLayout(
                "min,min:grow", //columns
                "fill:16dlu,4dlu" //rows
        );
        panel.setLayout( layout );
        panel.add( scrollPaneA, cc.xywh( 2, 2, 1, 2 ) );
        panel.add( scrollPaneB, cc.xywh( 4, 2, 1, 2 ) );
        search_panel.setLayout( layout02 );
        search_label.setHorizontalAlignment( JLabel.RIGHT );
        search_panel.add( search_label, cc.xy( 1, 1 ) );
        search_panel.add( search_field, cc.xy( 2, 1 ) );
        panel.add( search_panel, cc.xy( 6, 2 ) );
        panel.add( scrollPaneC, cc.xy( 6, 3 ) );
        scrollPaneA.setBorder( new TitledBorder( "Mix A" ) );
        scrollPaneB.setBorder( new TitledBorder( "Mix B" ) );
        scrollPaneC.setBorder( new TitledBorder( "Mix Difference" ) );
        lst_mix_compare_a.addListSelectionListener( ( ListSelectionEvent e ) ->
        {
            process_evt_lst_mix_compare_a( e );
        } );
        lst_mix_compare_b.addListSelectionListener( ( ListSelectionEvent e ) ->
        {
            process_evt_lst_mix_compare_b( e );
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
                } catch ( java.util.regex.PatternSyntaxException e ) {
                    return;
                }
                srttbl_mix_comparison.setRowFilter( rf );
            }

        } );
        lst_mix_compare_a.setModel( modelList_A_MixDiff );
        lst_mix_compare_b.setModel( modelList_B_MixDiff );
        tbl_mix_comparison.setModel( modelTableMixDifference );
        tbl_mix_comparison.setSelectionMode( ListSelectionModel.SINGLE_SELECTION );
        tbl_mix_comparison.setFillsViewportHeight( true );
        tbl_mix_comparison.setRowSorter( srttbl_mix_comparison );
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
                switch ( columnIndex ) {
                    case 0:
                        component.setForeground( tableEnergy.getForeground() );
                        break;
                    case 1:
                        component.setForeground( tableEnergy.getForeground() );
                        break;
                    case 2:
                        valueAt = ( Double ) getValueAt( rowIndex, columnIndex );
                        if ( valueAt <= 0 ) {
                            component.setForeground( Color.red );
                        } else {
                            component.setForeground( tableEnergy.getForeground() );
                        }
                        break;
                    case 3:
                        valueAt = ( Double ) getValueAt( rowIndex, columnIndex );
                        if ( valueAt <= 0 ) {
                            component.setForeground( Color.red );
                        } else {
                            component.setForeground( tableEnergy.getForeground() );
                        }
                        break;
                    case 4:
                        valueAt = ( Double ) getValueAt( rowIndex, columnIndex );
                        if ( valueAt < 0 ) {
                            component.setForeground( Color.red );
                        } else {
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
        tbl_food_comparison = get_table_food_comparison();
        JScrollPane scrollPaneC = new JScrollPane( tbl_food_comparison );
        JPanel search_panel = new JPanel();
        JLabel search_label = new JLabel( "Search: " );
        JTextField search_field = new JTextField();
        //create layouts
        FormLayout layout = new FormLayout(
                "4dlu,150dlu,4dlu,150dlu,4dlu,min:grow,4dlu", //columns
                "min,fill:min:grow,4dlu" //rows
        );
        FormLayout layout02 = new FormLayout(
                "min,min:grow", //columns
                "4dlu,fill:16dlu,4dlu" //rows
        );
        JPanel food_list_a_panel = new JPanel();
        JPanel food_list_b_panel = new JPanel();
        FormLayout layout03 = new FormLayout(
                "min,min:grow", //columns
                "4dlu,fill:16dlu,4dlu,fill:min:grow" //rows
        );
        food_list_a_panel.setLayout( layout03 );
        JScrollPane scrollPaneA = new JScrollPane( lst_food_compare_a );
        scrollPaneA.setBorder( new TitledBorder( "Food A" ) );
        JLabel label_a = new JLabel( "Search: " );
        food_list_a_panel.add( label_a, cc.xy( 1, 2 ) );
        JTextField search_field_a = new JTextField();
        food_list_a_panel.add( search_field_a, cc.xy( 2, 2 ) );
        food_list_a_panel.add( scrollPaneA, cc.xyw( 1, 4, 2 ) );
        food_list_b_panel.setLayout( layout03 );
        JScrollPane scrollPaneB = new JScrollPane( lst_food_compare_b );
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
        lst_food_compare_a.addListSelectionListener( ( ListSelectionEvent e ) ->
        {
            process_evt_lst_food_compare_a( e );
        } );
        lst_food_compare_b.addListSelectionListener( ( ListSelectionEvent e ) ->
        {
            process_evt_lst_food_compare_b( e );
        } );
        search_field_a.addActionListener( ( ActionEvent e ) ->
        {
            process_evt_fld_search_a( e );
        } );
        search_field_b.addActionListener( ( ActionEvent e ) ->
        {
            process_evt_fld_search_b( e );
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
                } catch ( java.util.regex.PatternSyntaxException e ) {
                    return;
                }
                srttbl_food_comparison.setRowFilter( rf );
            }

        } );
        lst_food_compare_a.setModel( modelList_A_FoodDiff );
        lst_food_compare_b.setModel( modelList_B_FoodDiff );
        tbl_food_comparison.setModel( modelTableFoodDifference );
        tbl_food_comparison.setSelectionMode( ListSelectionModel.SINGLE_SELECTION );
        tbl_food_comparison.setFillsViewportHeight( true );
        tbl_food_comparison.setRowSorter( srttbl_food_comparison );
        modelList_A_FoodDiff.reload();
        modelList_B_FoodDiff.reload();
        resize_col_tbl_food_comparison();
        return panel;
    }

    private void process_evt_fld_search_a( ActionEvent e ) {
        modelList_A_FoodDiff.reload( (( JTextComponent ) e.getSource()).getText() );
    }

    private void process_evt_fld_search_b( ActionEvent e ) {
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
                switch ( columnIndex ) {
                    case 0:
                        component.setForeground( offwhite );
                        break;
                    case 1:
                        component.setForeground( offwhite );
                        break;
                    case 2:
                        valueAt = ( Double ) getValueAt( rowIndex, columnIndex );
                        if ( valueAt <= 0 ) {
                            component.setForeground( Color.red );
                        } else {
                            component.setForeground( offwhite );
                        }
                        break;
                    case 3:
                        component.setForeground( offwhite );
                        break;
                    case 4:
                        valueAt = ( Double ) getValueAt( rowIndex, columnIndex );
                        if ( valueAt < 100 && ( Double ) getValueAt( rowIndex, columnIndex - 1 ) > 0 ) {
                            component.setForeground( Color.red );
                        }
                        break;
                    case 5:
                        component.setForeground( offwhite );
                        break;
                    case 6:
                        valueAt = ( Double ) getValueAt( rowIndex, columnIndex );
                        if ( valueAt > 100 ) {
                            component.setForeground( Color.red );
                        } else {
                            component.setForeground( offwhite );
                        }
                        break;
                }
                return component;
            }
        };
        return table;
    }

    private JPanel get_editor_rda() {
        tbl_results_rda = get_table_rda_check();
        JScrollPane scrollPaneRdaDiff = new JScrollPane( tbl_results_rda );
        FormLayout layoutPanelRdaDiff = new FormLayout(
                "400dlu", //columns
                "5dlu,min,5dlu,fill:min:grow" //rows
        );
        FormLayout layout = new FormLayout(
                "5dlu,min:grow,5dlu,min", //columns
                "min" //rows
        );
        JPanel panel = new JPanel();
        panel.setLayout( layout );
        JLabel label = new JLabel( " Lifestage:" );
        label.setHorizontalAlignment( JLabel.RIGHT );
        panel.add( label, cc.xy( 2, 1 ) );
        panel.add( cb_results_lifestage, cc.xy( 4, 1 ) );
        JPanel panelRdaDiff = new JPanel();
        panelRdaDiff.setLayout( layoutPanelRdaDiff );
        panelRdaDiff.add( panel, cc.xy( 1, 2 ) );
        panelRdaDiff.add( scrollPaneRdaDiff, cc.xy( 1, 4 ) );
        scrollPaneRdaDiff.setBorder( new TitledBorder( "RDA Check" ) );
        cb_results_lifestage.setModel( cbmdl_results_lifestage );
        tbl_results_rda.setModel( modelTableRda );
        tbl_results_rda.setSelectionMode( ListSelectionModel.SINGLE_SELECTION );
        tbl_results_rda.setAutoResizeMode( JTable.AUTO_RESIZE_OFF );
        tbl_results_rda.setFillsViewportHeight( true );
        tbl_results_rda.setTableHeader( new TableHeaderRdaDiff( tbl_results_rda.getColumnModel() ) );
        tbl_results_rda.setAutoCreateRowSorter( true );
        resize_col_tbl_editor_rda_check();
        cb_results_lifestage.addActionListener( ( ActionEvent e ) ->
        {
            process_evt_cb_results_lifestage();
        } );
        JPopupMenu popMenu = new JPopupMenu();
        JMenuItem item_01 = new JMenuItem( "Find nutrient containing foods" );
        popMenu.add( item_01 );
        item_01.addActionListener( ( ActionEvent e ) ->
        {
            process_evt_mnui_results_nutrient_lookup();
        } );
        tbl_results_rda.addMouseListener( new MouseAdapter() {
            @Override
            public void mouseClicked( MouseEvent e ) {
                super.mouseClicked( e );
                process_evt_lst_mixes( e, popMenu );
            }
        } );
        return panelRdaDiff;
    }

    private void process_evt_mnui_results_nutrient_lookup() {
        int selectedRowNo = tbl_results_rda.getSelectedRow();
        if ( selectedRowNo != -1 ) {
            String nutrientid = ( String ) tbl_results_rda.getValueAt( selectedRowNo, 0 );
            String nutrient = ( String ) tbl_results_rda.getValueAt( selectedRowNo, 1 );
            Double rda = ( Double ) tbl_results_rda.getValueAt( selectedRowNo, 3 );
            textFieldNutrientLookup.setText( String.valueOf( rda ) );
            NutrientDataObject nutrientDataObject = new NutrientDataObject( nutrientid, nutrient, null );
            modelComboBox_NutrientLookupListNutrient.setSelectedItem( nutrientDataObject );
            modelTableNutrientLookup.reload( nutrientid, rda );
            resize_col_tbl_nutrient_lookup();
            main_tabbed_pane.setSelectedIndex( 4 );
        } else {
            Message.showMessage( "Please select nutrient" );
        }
    }

    private void process_evt_cb_results_lifestage() {
        reload_tblmdl_editor_rda_check();
        resize_col_tbl_editor_rda_check();
    }

    private void reload_tblmdl_editor_rda_check() {
        if ( cmb_mix.getSelectedItem() != null ) {
            MixDataObject mixDataObject = ( MixDataObject ) cmb_mix.getSelectedItem();
            RdaLifeStageDataObject rdaLifeStageDataObject = ( RdaLifeStageDataObject ) cb_results_lifestage.getSelectedItem();
            modelTableRda.reload( mixDataObject.getMixId(), rdaLifeStageDataObject.getLifeStageId() );
        }
    }

    private JPanel get_meal_portion() {
        JPanel panel = new JPanel();
        FormLayout panelLayout = new FormLayout(
                "60px,50px,155px,50px,53px,min:grow,60px,171px", //columns
                "10px,fill:25px,10px,p,100px,10px,fill:p:grow,p" //rows
        );
        JScrollPane scroll_pane = new JScrollPane( listPortionMeal );
        scroll_pane.setBorder( new TitledBorder( "Meals" ) );
        textfield_portion_remaining.setPreferredSize( new Dimension( 100, 25 ) );
        textfield_portion_pct.setPreferredSize( new Dimension( 100, 25 ) );
        cmb_food_portion.setPreferredSize( new Dimension( 100, 25 ) );
        scroll_pane.setPreferredSize( new Dimension( 100, 100 ) );
        panel.setLayout( panelLayout );
        JScrollPane spTable = new JScrollPane( tbl_meal_portions );
        JPanel buttons = new JPanel();
        textfield_portion_remaining.setEditable( false );
        JLabel label_search = new JLabel( "Search: " );
        label_search.setHorizontalAlignment( JLabel.RIGHT );
        //first row
        panel.add( label_search, cc.xy( 1, 2 ) );
        panel.add( textfield_portion_search, cc.xyw( 2, 2, 7 ) );
        //second row
        JLabel label01 = new JLabel( "Out of" );
        label01.setHorizontalAlignment( JLabel.CENTER );
        panel.add( label01, cc.xy( 1, 4 ) );
        panel.add( textfield_portion_remaining, cc.xy( 2, 4 ) );
        JLabel label02 = new JLabel( "% remaining, apportion" );
        label02.setHorizontalAlignment( JLabel.CENTER );
        panel.add( label02, cc.xy( 3, 4 ) );
        panel.add( textfield_portion_pct, cc.xy( 4, 4 ) );
        JLabel label03 = new JLabel( "% of" );
        label03.setHorizontalAlignment( JLabel.CENTER );
        panel.add( label03, cc.xy( 5, 4 ) );
        panel.add( cmb_food_portion, cc.xy( 6, 4 ) );
        JLabel label04 = new JLabel( "to " );
        label04.setHorizontalAlignment( JLabel.CENTER );
        panel.add( label04, cc.xy( 7, 4 ) );
        panel.add( scroll_pane, cc.xywh( 8, 4, 1, 2 ) );
        //third row
        panel.add( spTable, cc.xyw( 1, 7, 8 ) );
        buttons.add( buttonPortionAdd );
        buttons.add( buttonPortionDelete );
        buttons.add( buttonPortionUpdateWeight );
        //fourth row
        panel.add( buttons, cc.xyw( 1, 8, 8 ) );
        spTable.setBorder( new TitledBorder( "Food Portions" ) );
        listPortionMeal.setModel( modelList_PortionMeal );
        cmb_food_portion.setMaximumRowCount( 6 );
        cmb_food_portion.setModel( modelComboBox_PortionFood );
        tbl_meal_portions.getTableHeader().setReorderingAllowed( false );
        tbl_meal_portions.setAutoCreateRowSorter( true );
        tbl_meal_portions.setModel( modelTablePortion );
        tbl_meal_portions.setRowSorter( srttbl_portionlookup );
        buttonPortionAdd.setToolTipText( "Add food portion" );
        buttonPortionDelete.setToolTipText( "Delete food portion" );
        buttonPortionUpdateWeight.setToolTipText( "Update weight of food consumed" );
        buttonPortionAdd.addActionListener( ( ActionEvent e ) ->
        {
            process_evt_btn_food_portion_add();
        } );
        buttonPortionDelete.addActionListener( ( ActionEvent e ) ->
        {
            process_evt_btn_food_portion_delete();
        } );
        buttonPortionUpdateWeight.addActionListener( ( ActionEvent e ) ->
        {
            process_evt_btn_food_portion_update_weight();
        } );
        cmb_food_portion.addActionListener( ( ActionEvent e ) ->
        {
            process_evt_cb_meal_food_portion();
        } );
        tbl_meal_portions.setFillsViewportHeight( true );
        textfield_portion_search.getDocument().addDocumentListener( new DocumentListener() {
            @Override
            public void changedUpdate( DocumentEvent e ) {
                filter_portion();
            }

            @Override
            public void insertUpdate( DocumentEvent e ) {
                filter_portion();
            }

            @Override
            public void removeUpdate( DocumentEvent e ) {
                filter_portion();
            }
        } );
        JPopupMenu popMenu = new JPopupMenu();
        JMenuItem item_01 = new JMenuItem( "Assign portion to meal" );
        popMenu.add( item_01 );
        item_01.addActionListener( ( ActionEvent e ) ->
        {
            process_evt_mnui_assign_portion_to_meal();
        } );
        tbl_meal_portions.addMouseListener( new MouseAdapter() {
            @Override
            public void mouseClicked( MouseEvent e ) {
                super.mouseClicked( e );
                process_evt_lst_mixes( e, popMenu );
            }
        } );
        return panel;
    }

    private JPanel get_meal() {
        JPanel panel = new JPanel();
        FormLayout panelLayout = new FormLayout(
                "400dlu:grow", //columns
                "fill:p:grow,p" //rows
        );
        panel.setLayout( panelLayout );
        JScrollPane spTable = new JScrollPane( tbl_meals );
        JPanel buttons = new JPanel();
        panel.add( spTable, cc.xy( 1, 1 ) );
        buttons.add( buttonMealAdd );
        buttons.add( buttonMealDelete );
        buttons.add( buttonMealUpdate );
        panel.add( buttons, cc.xy( 1, 2 ) );
        spTable.setBorder( new TitledBorder( "Meals" ) );
        tbl_meals.getTableHeader().setReorderingAllowed( false );
        tbl_meals.setAutoCreateRowSorter( true );
        tbl_meals.setModel( modelTableMeals );
        tbl_meals.setSelectionMode( ListSelectionModel.SINGLE_SELECTION );
        buttonMealAdd.setToolTipText( "Add Meal" );
        buttonMealDelete.setToolTipText( "Delete Meal" );
        buttonMealUpdate.setToolTipText( "Update Meal" );
        buttonMealAdd.addActionListener( ( ActionEvent e ) ->
        {
            process_evt_btn_meal_add();
        } );
        buttonMealDelete.addActionListener( ( ActionEvent e ) ->
        {
            process_evt_btn_meal_delete();
        } );
        buttonMealUpdate.addActionListener( ( ActionEvent e ) ->
        {
            process_evt_btn_meal_update();
        } );
        tbl_meals.setFillsViewportHeight( true );
        return panel;
    }

    private void reload_tblmdl_meals() {
        MixDataObject mixDataObject = ( MixDataObject ) cmb_mix.getSelectedItem();
        modelTableMeals.reload( mixDataObject.getMixId() );
    }

    private void reload_tblmdl_meals( String mixid ) {
        modelTableMeals.reload( mixid );
    }

    private void reload_cbmdl_portion_food() {
        MixDataObject mixDataObject = ( MixDataObject ) cmb_mix.getSelectedItem();
        modelComboBox_PortionFood.reload( mixDataObject.getMixId() );
    }

    private void reload_lstmdl_portion_meal() {
        MixDataObject mixDataObject = ( MixDataObject ) cmb_mix.getSelectedItem();
        reload_lstmdl_portion( mixDataObject.getMixId() );
    }

    private void resize_col_tbl_meal() {
        tbl_meals.getColumnModel().getColumn( 0 ).setMinWidth( 0 );
        tbl_meals.getColumnModel().getColumn( 0 ).setMaxWidth( 0 );
        tbl_meals.getColumnModel().getColumn( 1 ).setMinWidth( 0 );
        tbl_meals.getColumnModel().getColumn( 1 ).setMaxWidth( 0 );
    }

    private void resize_col_tbl_meal_portions() {
        tbl_meal_portions.getColumnModel().getColumn( 0 ).setMinWidth( 0 );
        tbl_meal_portions.getColumnModel().getColumn( 0 ).setMaxWidth( 0 );
        tbl_meal_portions.getColumnModel().getColumn( 1 ).setMinWidth( 0 );
        tbl_meal_portions.getColumnModel().getColumn( 1 ).setMaxWidth( 0 );
        tbl_meal_portions.getColumnModel().getColumn( 2 ).setMinWidth( 0 );
        tbl_meal_portions.getColumnModel().getColumn( 2 ).setMaxWidth( 0 );
        tbl_meal_portions.getColumnModel().getColumn( 3 ).setMinWidth( 200 );
        tbl_meal_portions.getColumnModel().getColumn( 4 ).setMinWidth( 600 );
    }

    private void resize_col_tbl_results_by_meal_calories() {
        tbl_results_by_meal_calories.getColumnModel().getColumn( 0 ).setMinWidth( 200 );
        tbl_results_by_meal_calories.getColumnModel().getColumn( 6 ).setMinWidth( 90 );
    }

    private void resize_col_tbl_results_by_meal_grams() {
        tbl_results_by_meal_grams.getColumnModel().getColumn( 0 ).setMinWidth( 200 );
    }

    private void clear_model_meal_plan() {
        modelTableMeals.setRowCount( 0 );
        modelTablePortion.setRowCount( 0 );
        cmb_food_portion.removeAllItems();
        modelTableResultByMealsCalories.setRowCount( 0 );
        modelTableResultByMealsGrams.setRowCount( 0 );
        modelList_PortionMeal.clear();
    }

    private void filter_portion() {
        RowFilter<TableModelPortions, Object> rf = null;
        try {
            ArrayList filters = new ArrayList();
            filters.add( RowFilter.regexFilter( "(?i)" + textfield_portion_search.getText(), 3 ) );
            filters.add( RowFilter.regexFilter( "(?i)" + textfield_portion_search.getText(), 4 ) );
            rf = RowFilter.orFilter( ( Iterable<? extends RowFilter<? super TableModelPortions, ? super Object>> ) filters );
        } catch ( java.util.regex.PatternSyntaxException e ) {
            return;
        }
        srttbl_portionlookup.setRowFilter( rf );
    }

    private void filter_food_list() {
        RowFilter<TableModelFoodList, Object> rf = null;
        try {
            ArrayList filters = new ArrayList();
            filters.add( RowFilter.regexFilter( "(?i)" + textFieldFoodListSearch.getText(), 1 ) );
            filters.add( RowFilter.regexFilter( "(?i)" + textFieldFoodListSearch.getText(), 2 ) );
            rf = RowFilter.orFilter( ( Iterable<? extends RowFilter<? super TableModelFoodList, ? super Object>> ) filters );
        } catch ( java.util.regex.PatternSyntaxException e ) {

            return;
        }
        srttbl_foodlist.setRowFilter( rf );
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
                "min:grow,min,min,min,min,min,min:grow", //columns
                "min" //rows
        );
        buttonPanel.setLayout( buttonPanelLayout );
        JScrollPane scrollPaneTable01 = new JScrollPane( tableFoodList01 );
        JLabel label = new JLabel( "Search: " );
        label.setHorizontalAlignment( JLabel.RIGHT );
        searchPanel.add( label, cc.xy( 1, 2 ) );
        searchPanel.add( textFieldFoodListSearch, cc.xy( 2, 2 ) );
        buttonPanel.add( buttonFoodListAdd, cc.xy( 2, 1 ) );
        buttonPanel.add( buttonFoodListDelete, cc.xy( 3, 1 ) );
        buttonPanel.add( buttonFoodListUpdate, cc.xy( 4, 1 ) );
        buttonPanel.add( buttonFoodListDuplicate, cc.xy( 5, 1 ) );
        buttonPanel.add( buttonFoodListGi, cc.xy( 6, 1 ) );
        panel.add( searchPanel, cc.xy( 2, 1 ) );
        panel.add( scrollPaneTable01, cc.xy( 2, 2 ) );
        panel.add( buttonPanel, cc.xy( 2, 4 ) );
        scrollPaneTable01.setBorder( new TitledBorder( "Food List" ) );
        buttonFoodListAdd.setToolTipText( "Add food item" );
        buttonFoodListUpdate.setToolTipText( "Update food item" );
        buttonFoodListDelete.setToolTipText( "Delete food item" );
        buttonFoodListDuplicate.setToolTipText( "Duplicate food item" );
        buttonFoodListGi.setToolTipText( "Update glycemic index" );
        buttonFoodListAdd.addActionListener( ( ActionEvent e ) ->
        {
            process_evt_btn_food_list_add();
        } );
        buttonFoodListDelete.addActionListener( ( ActionEvent e ) ->
        {
            process_evt_btn_food_list_delete();
        } );
        buttonFoodListUpdate.addActionListener( ( ActionEvent e ) ->
        {
            process_evt_btn_food_list_update();
        } );
        buttonFoodListDuplicate.addActionListener( ( ActionEvent e ) ->
        {
            process_evt_btn_food_list_duplicate();
        } );
        buttonFoodListGi.addActionListener( ( ActionEvent e ) ->
        {
            process_evt_btn_food_list_update_gi();
        } );
        textFieldFoodListSearch.getDocument().addDocumentListener( new DocumentListener() {
            @Override
            public void changedUpdate( DocumentEvent e ) {
                filter_food_list();
            }

            @Override
            public void insertUpdate( DocumentEvent e ) {
                filter_food_list();
            }

            @Override
            public void removeUpdate( DocumentEvent e ) {
                filter_food_list();
            }
        } );
        tableFoodList01.setTableHeader( new TableHeaderFoodList( tableFoodList01.getColumnModel() ) );
        tableFoodList01.setRowSorter( srttbl_foodlist );
        tableFoodList01.setModel( modelTableFoodList );
        tableFoodList01.setSelectionMode( ListSelectionModel.SINGLE_SELECTION );
        tableFoodList01.setFillsViewportHeight( true );
        tableFoodList01.setAutoResizeMode( JTable.AUTO_RESIZE_OFF );
        reload_food_items();
        resize_col_tbl_food_list();
        JPopupMenu popMenu = new JPopupMenu();
        JMenuItem item = new JMenuItem( "Check coefficients" );
        popMenu.add( item );
        item.addActionListener( ( ActionEvent e ) ->
        {
            int selectedRowNo = tableFoodList01.getSelectedRow();
            if ( selectedRowNo != -1 ) {
                check_coefficients( ( String ) tableFoodList01.getValueAt( selectedRowNo, 0 ) );
            } else {
                Message.showMessage( "Please select food item" );
            }
        } );
        tableFoodList01.addMouseListener( new MouseAdapter() {
            @Override
            public void mouseClicked( MouseEvent e ) {
                super.mouseClicked( e );
                if ( (e.getModifiers() & InputEvent.BUTTON3_MASK) != 0 ) {
                    Component component = e.getComponent();
                    popMenu.show( component, e.getX(), e.getY() );
                }
            }
        } );
        return panel;
    }

    private void process_evt_btn_food_list_duplicate() {
        int selectedRowNo = tableFoodList01.getSelectedRow();
        if ( selectedRowNo != -1 ) {
            String foodId = ( String ) tableFoodList01.getValueAt( selectedRowNo, 0 );
            duplicate_food_item( foodId );
        }
    }

    private void filter_nutrient_coefficient() {
        RowFilter<TableModelCheckCoefficients, Object> rf = null;
        try {
            ArrayList filters = new ArrayList();
            filters.add( RowFilter.regexFilter( "(?i)" + textFieldNutrientSearchCheckCoefficients.getText(), 1 ) );
            filters.add( RowFilter.regexFilter( "(?i)" + textFieldNutrientSearchCheckCoefficients.getText(), 2 ) );
            rf = RowFilter.orFilter( ( Iterable<? extends RowFilter<? super TableModelCheckCoefficients, ? super Object>> ) filters );
        } catch ( java.util.regex.PatternSyntaxException e ) {

            return;
        }
        srttbl_CheckCoefficients.setRowFilter( rf );
    }

    private void check_coefficients( String foodId ) {
        tableCheckCoefficients.setRowSorter( srttbl_CheckCoefficients );
        tableCheckCoefficients.setModel( modelTableCheckCoefficients );
        tableCheckCoefficients.setFillsViewportHeight( true );
        modelTableCheckCoefficients.set_precision( 5 );
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
        panel.setPreferredSize( new Dimension( 637, 400 ) );
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
        buttonNext.addActionListener( ( ActionEvent e ) ->
        {
            int selectedRowNo = tableCheckCoefficients.getSelectedRow();
            if ( selectedRowNo != tableCheckCoefficients.getRowCount() - 1 ) {
                selectedRowNo++;
                scroll_to_row_using_table( tableCheckCoefficients, selectedRowNo );
            } else {
                select_table_row_using_table( tableCheckCoefficients, selectedRowNo );
            }
        } );
        buttonPrevious.addActionListener( ( ActionEvent e ) ->
        {
            int selectedRowNo = tableCheckCoefficients.getSelectedRow();
            if ( selectedRowNo > 0 && selectedRowNo < tableCheckCoefficients.getRowCount() ) {
                selectedRowNo--;
                scroll_to_row_using_table( tableCheckCoefficients, selectedRowNo );
            } else {
                select_table_row_using_table( tableCheckCoefficients, 0 );
            }
        } );
        textFieldNutrientSearchCheckCoefficients.getDocument().addDocumentListener( new DocumentListener() {
            @Override
            public void changedUpdate( DocumentEvent e ) {
                filter_nutrient_coefficient();
            }

            @Override
            public void insertUpdate( DocumentEvent e ) {
                filter_nutrient_coefficient();
            }

            @Override
            public void removeUpdate( DocumentEvent e ) {
                filter_nutrient_coefficient();
            }
        } );
        Message.showOptionDialog( inputs, "Check Coefficients" );
    }

    private void filter_nutrient() {
        RowFilter<TableModelDataInput, Object> rf = null;
        try {
            ArrayList filters = new ArrayList();
            filters.add( RowFilter.regexFilter( "(?i)" + textFieldNutrientSearch.getText(), 1 ) );
            filters.add( RowFilter.regexFilter( "(?i)" + textFieldNutrientSearch.getText(), 2 ) );
            rf = RowFilter.orFilter( ( Iterable<? extends RowFilter<? super TableModelDataInput, ? super Object>> ) filters );
        } catch ( java.util.regex.PatternSyntaxException e ) {

            return;
        }
        srttbl_nutrientinput.setRowFilter( rf );
    }

    private void process_evt_btn_fill_complete_protein_data() {
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
        if ( optionValue == 0 ) {
            String s0 = fld_protein.getText();
            if ( (s0 != null && s0.length() > 0) ) {
                checkNumber.addToUncheckedList( s0 );
                if ( checkNumber.pass() ) {
                    Double val_protein = Double.valueOf( fld_protein.getText() );
                    Double val_complete_protein = Double.valueOf( fld_complete_protein.getText() );
                    //model row index is specified by sql query.
                    modelTableNutrientInput.setValueAt( val_protein, model_row_index_protein, model_column_index );
                    modelTableNutrientInput.setValueAt( val_complete_protein, model_row_index_complete_protein, model_column_index );
                    select_table_row_using_model( tbl_nutrient_input, model_row_index_protein );
                    scroll_to_row_using_model( tbl_nutrient_input, model_row_index_protein );
                } else {
                    Message.showMessage( "Numbers only" );
                }
            }
        }
    }

    private void process_evt_btn_fill_fat() {
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
        SwingUtilities.invokeLater( () ->
        {
            scrollPane.getViewport().setViewPosition( new Point( 0, 0 ) );
        } );
        int optionValue = Message.showOptionDialogOkCancel( inputs, "Fat" );
        if ( optionValue == 0 ) {
            String s0 = totalFatText.getText();
            String s1 = saturatedFatText.getText();
            String s2 = monounsaturatedFatText.getText();
            String s3 = polyunsaturatedFatText.getText();
            if ( (s0 != null && s0.length() > 0) && (s1 != null && s1.length() > 0) && (s2 != null && s2.length() > 0) && (s3 != null && s3.length() > 0) ) {
                checkNumber.addToUncheckedList( s0 );
                if ( checkNumber.pass() ) {
                    Double totalFat = Double.valueOf( totalFatText.getText() );
                    Double saturatedFat = Double.valueOf( saturatedFatText.getText() );
                    Double monounsaturatedFat = Double.valueOf( monounsaturatedFatText.getText() );
                    Double polyunsaturatedFat = Double.valueOf( polyunsaturatedFatText.getText() );
                    //model row index is specified by sql query.
                    modelTableNutrientInput.setValueAt( monounsaturatedFat, model_row_index_mufa, model_column_index );
                    modelTableNutrientInput.setValueAt( polyunsaturatedFat, model_row_index_pufa, model_column_index );
                    modelTableNutrientInput.setValueAt( saturatedFat, model_row_index_sfa, model_column_index );
                    modelTableNutrientInput.setValueAt( totalFat, model_row_index_fat, model_column_index );
                    select_table_row_using_model( tbl_nutrient_input, model_row_index_fat );
                    scroll_to_row_using_model( tbl_nutrient_input, model_row_index_fat );
                } else {
                    Message.showMessage( "Numbers only" );
                }
            }
        }
    }

    private void process_evt_btn_fill_vitamin_values() {
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
        if ( optionValue == 0 ) {
            s0 = dailyValuePct.getText();
            if ( s0 != null && s0.length() > 0 ) {
                checkNumber.addToUncheckedList( s0 );
                if ( checkNumber.pass() ) {
                    nutrientDataObject = ( NutrientDataObject ) cboxNutrients.getSelectedItem();
                    dvpct = Double.valueOf( s0 );
                    xgrams = dvpct * (nutrientDataObject.getQ() / 100);
                    //model row index is specified by sql query.
                    int model_column_index = 3;
                    Integer model_row_index_vitamin = modelTableNutrientInput.find( nutrientDataObject.getNutr_no() );
                    modelTableNutrientInput.setValueAt( xgrams, model_row_index_vitamin, model_column_index );
                    select_table_row_using_model( tbl_nutrient_input, model_row_index_vitamin );
                    scroll_to_row_using_model( tbl_nutrient_input, model_row_index_vitamin );
                } else {
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
                "min:grow,min,min,min,min,min:grow", //columns
                "min" //rows
        );
        wizardPanel.setLayout( layout );
        JButton fillCompleteProteinButton = new JButton( "Protein" );
        JButton fillFatButton = new JButton( "Fat" );
        JButton fillVitaminsButton = new JButton( "Vitamins" );
        JButton btn_cost = new JButton( "Cost" );
        wizardPanel.add( fillCompleteProteinButton, cc.xy( 2, 1 ) );
        wizardPanel.add( fillFatButton, cc.xy( 3, 1 ) );
        wizardPanel.add( fillVitaminsButton, cc.xy( 4, 1 ) );
        wizardPanel.add( btn_cost, cc.xy( 5, 1 ) );
        layout.setColumnGroup( 2, 3, 4, 5 );
        fillCompleteProteinButton.setToolTipText( "Complete Protein calculator assistant" );
        fillFatButton.setToolTipText( "Fat calculator assistant" );
        fillVitaminsButton.setToolTipText( "Vitamin and mineral values calculator assistant" );
        btn_cost.setToolTipText( "Cost calculator assistant" );
        fillCompleteProteinButton.addActionListener( ( ActionEvent e ) ->
        {
            process_evt_btn_fill_complete_protein_data();
        } );
        fillFatButton.addActionListener( ( ActionEvent e ) ->
        {
            process_evt_btn_fill_fat();
        } );
        fillVitaminsButton.addActionListener( ( ActionEvent e ) ->
        {
            process_evt_btn_fill_vitamin_values();
        } );
        btn_cost.addActionListener( ( ActionEvent e ) ->
        {
            process_evt_btn_cost();
        } );
        return wizardPanel;
    }

    private void update_food_item( String foodid, Integer optionValue ) {
        tbl_nutrient_input.setRowSorter( srttbl_nutrientinput );
        tbl_nutrient_input.setModel( modelTableNutrientInput );
        tbl_nutrient_input.setSelectionMode( ListSelectionModel.SINGLE_SELECTION );
        tbl_nutrient_input.setFillsViewportHeight( true );
        tbl_nutrient_input.setDefaultEditor( Double.class, new DoubleTableCellEditor() );
        modelTableNutrientInput.set_precision( 5 );
        textFieldNutrientSearch.setText( "" );
        if ( optionValue == -1 ) {
            modelTableNutrientInput.reload( foodid );
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
        tableNutrientInputScrollPane = new JScrollPane( tbl_nutrient_input );
        panel.add( tableNutrientInputScrollPane, cc.xyw( 2, 8, 7 ) );
        JComponent[] inputs = new JComponent[] {
            panel
        };
        if ( optionValue == 0 ) {
            textFieldFoodName.setText( foodNameText );
        } else {
            try {
                FoodDataObject foodDataObject = new FoodDataObject();
                foodDataObject.setFoodId( foodid );
                LinkedList<FoodDataObject> list = ( LinkedList ) dbLink.Food_Select( foodDataObject );
                list.forEach( food_data_object ->
                {
                    textFieldFoodName.setText( food_data_object.getFoodName() );
                } );
            } catch ( SQLException e ) {

            }
        }
        buttonNext.addActionListener( ( ActionEvent e ) ->
        {
            int selectedRowNo = tbl_nutrient_input.getSelectedRow();
            if ( selectedRowNo != tbl_nutrient_input.getRowCount() - 1 ) {
                tbl_nutrient_input.getDefaultEditor( Double.class ).cancelCellEditing();
                selectedRowNo++;
                scroll_to_row_using_table( tbl_nutrient_input, selectedRowNo );
            } else {
                select_table_row_using_table( tbl_nutrient_input, selectedRowNo );
            }
        } );
        buttonPrevious.addActionListener( ( ActionEvent e ) ->
        {
            int selectedRowNo = tbl_nutrient_input.getSelectedRow();
            if ( selectedRowNo > 0 && selectedRowNo < tbl_nutrient_input.getRowCount() ) {
                tbl_nutrient_input.getDefaultEditor( Double.class ).cancelCellEditing();
                selectedRowNo--;
                scroll_to_row_using_table( tbl_nutrient_input, selectedRowNo );
            } else {
                select_table_row_using_table( tbl_nutrient_input, 0 );
            }
        } );
        buttonNutrientWeightSave.addActionListener( ( ActionEvent e ) ->
        {
            int selectedRowNo = tbl_nutrient_input.getSelectedRow();
            if ( selectedRowNo != -1 ) {
                NumberCheck numberCheck = new NumberCheck();
                numberCheck.addToUncheckedList( textFieldNutrientValue.getText() );
                if ( numberCheck.pass() ) {
                    tbl_nutrient_input.getDefaultEditor( Double.class ).cancelCellEditing();
                    modelTableNutrientInput.setValueAt( Double.valueOf( textFieldNutrientValue.getText() ), tbl_nutrient_input.convertRowIndexToModel( selectedRowNo ), 3 );
                } else {
                    Message.showMessage( "Value must be a number greater than or equal to zero" );
                }
            }
        } );
        ListSelectionModel selectionModel = tbl_nutrient_input.getSelectionModel();
        selectionModel.addListSelectionListener( ( ListSelectionEvent e ) ->
        {
            if ( e.getValueIsAdjusting() ) {
                tbl_nutrient_input.getDefaultEditor( Double.class ).cancelCellEditing();
                return;
            } else {

            }
            int selectedRowNo = tbl_nutrient_input.getSelectedRow();
            if ( selectedRowNo != -1 ) {
                String nutrient = ( String ) modelTableNutrientInput.getValueAt( tbl_nutrient_input.convertRowIndexToModel( selectedRowNo ), 2 );
                Double weight = ( Double ) modelTableNutrientInput.getValueAt( tbl_nutrient_input.convertRowIndexToModel( selectedRowNo ), 3 );
                textFieldNutrientValue.setText( String.valueOf( weight ) );
                labelNutrientWeight.setText( nutrient );
            }
        } );
        textFieldNutrientSearch.getDocument().addDocumentListener( new DocumentListener() {
            @Override
            public void changedUpdate( DocumentEvent e ) {
                filter_nutrient();
            }

            @Override
            public void insertUpdate( DocumentEvent e ) {
                filter_nutrient();
            }

            @Override
            public void removeUpdate( DocumentEvent e ) {
                filter_nutrient();
            }
        } );
        //scroll to weight field
        scroll_to_row_using_table( tbl_nutrient_input, 33 );
        optionValue = Message.showOptionDialogOkCancel( inputs, "Add New Food Item - Would you like to save specified values?" );
        if ( optionValue == 0 ) {
            Integer rowIndex = modelTableNutrientInput.find( "10000" );
            Double q = ( Double ) modelTableNutrientInput.getValueAt( rowIndex, 3 );
            if ( q > 0 ) {
                try {
                    FoodDataObject foodDataObject = new FoodDataObject();
                    foodDataObject.setFoodId( foodid );
                    foodDataObject.setFoodName( textFieldFoodName.getText() );
                    dbLink.Food_Update( foodDataObject );
                    rowIndex = modelTableNutrientInput.find( "10000" );
                    q = ( Double ) modelTableNutrientInput.getValueAt( rowIndex, 3 );
                    //Weight must be first "NutrientId" updated for trigger to calculate correct nutrient coefficients. Weight is serving size.
                    dbLink.FoodFact_Merge( foodid, "10000", q );
                    int rowNo = modelTableNutrientInput.getRowCount();
                    for ( int j = 0; j < rowNo; j++ ) {
                        String nutrientid = ( String ) modelTableNutrientInput.getValueAt( j, 0 );
                        //Weight was updated earlier, I do not want to update it again
                        if ( !nutrientid.equals( "10000" ) ) {
                            q = ( Double ) modelTableNutrientInput.getValueAt( j, 3 );
                            dbLink.FoodFact_Merge( foodid, nutrientid, q );
                        }
                    }
                    dbLink.foodfact_calculated_quantities_update( foodid );
                    dbLink.stopTransaction();
                } catch ( SQLException e ) {

                }
                reload_food_items();
                resize_col_tbl_food_list();
                rowIndex = modelTableFoodList.find( foodid );
                scroll_to_row_using_table( tableFoodList01, tableFoodList01.convertRowIndexToView( rowIndex ) );
                foodNameText = "";
            } else {
                foodNameText = textFieldFoodName.getText();
                Message.showMessage( "What is serving size? Weight must be greater than zero." );
                update_food_item( foodid, optionValue );
            }
        } else {
            dbLink.revertTransaction();
        }
    }

    private void reload_food_items() {
        modelTableFoodList.reload();
        modelTreeFoodList.reload();
        modelListFood.reload();
    }

    private void process_evt_btn_food_list_add() {
        try {
            String foodId = dbLink.Food_Insert_Temp( "New Food Item Name" );
            update_food_item( foodId, -1 );
        } catch ( SQLException e ) {

        }
    }

    private void process_evt_btn_food_list_update() {
        int selectedRowNo = tableFoodList01.getSelectedRow();
        if ( selectedRowNo != -1 ) {
            String foodId = ( String ) tableFoodList01.getValueAt( selectedRowNo, 0 );
            update_food_item( foodId, -1 );
        }
    }

    private void process_evt_btn_food_list_delete() {
        int selectedRowNo = tableFoodList01.getSelectedRow();
        if ( selectedRowNo != -1 ) {
            String foodId = ( String ) tableFoodList01.getValueAt( selectedRowNo, 0 );
            delete_food_item( foodId );
        }
    }

    private void delete_food_item( String foodId ) {
        try {
            dbLink.Food_Delete( foodId );
            dbLink.stopTransaction();
            reload_food_items();
            resize_col_tbl_food_list();
            if ( !listCategories.isSelectionEmpty() ) {
                FoodCategoryDataObject foodCategoryDataObject = ( FoodCategoryDataObject ) listCategories.getSelectedValue();
                modelListFoodInCategory.reload( foodCategoryDataObject.getFoodCategoryId() );
            }
        } catch ( SQLException e ) {

        }
    }

    private void duplicate_food_item( String foodId ) {
        try {
            dbLink.DuplicateFoodItem( foodId );
            dbLink.stopTransaction();
            reload_food_items();
            resize_col_tbl_food_list();
            Integer rowIndex = modelTableFoodList.find( foodId );
            scroll_to_row_using_table( tableFoodList01, tableFoodList01.convertRowIndexToView( rowIndex ) );
            if ( !listCategories.isSelectionEmpty() ) {
                FoodCategoryDataObject foodCategoryDataObject = ( FoodCategoryDataObject ) listCategories.getSelectedValue();
                modelListFoodInCategory.reload( foodCategoryDataObject.getFoodCategoryId() );
            }
        } catch ( SQLException e ) {

        }
    }

    private JPanel get_nutrient_lookup() {
        JPanel panel_00 = new JPanel();
        JPanel panel_01 = new JPanel();
        FormLayout layout_00 = new FormLayout(
                "4dlu,404dlu,4dlu", //columns
                "4dlu,min,4dlu,fill:min:grow,4dlu" //rows
        );

        FormLayout layout_01 = new FormLayout(
                "4dlu,min,min,4dlu,min,min:grow,4dlu", //columns
                "4dlu,fill:25px,4dlu,fill:25px,4dlu" //rows
        );
        panel_00.setLayout( layout_00 );
        panel_01.setLayout( layout_01 );
        JLabel search_label = new JLabel( "Search: " );
        JLabel nutrient_label = new JLabel( "Nutrient: " );
        nutrient_label.setHorizontalAlignment( JLabel.RIGHT );
        JLabel value_label = new JLabel( "Value: " );
        value_label.setHorizontalAlignment( JLabel.RIGHT );
        JTextField search_field = new JTextField();
        search_label.setHorizontalAlignment( JLabel.RIGHT );
        tableNutrientLookup.setToolTipText( "These food items contain the specific nutrient" );
        tableNutrientLookup.setTableHeader( new TableHeaderNutrientLookup( tableNutrientLookup.getColumnModel() ) );
        tableNutrientLookup.setModel( modelTableNutrientLookup );
        tableNutrientLookup.setSelectionMode( ListSelectionModel.SINGLE_SELECTION );
        tableNutrientLookup.setAutoResizeMode( JTable.AUTO_RESIZE_OFF );
        tableNutrientLookup.setFillsViewportHeight( true );
        tableNutrientLookup.setRowSorter( srttbl_nutrientlookup );
        comboBoxNutrientLookupListNutrient.setModel( modelComboBox_NutrientLookupListNutrient );
        JScrollPane scrollPaneNutrientLookup = new JScrollPane( tableNutrientLookup );
        scrollPaneNutrientLookup.setBorder( new TitledBorder( "Nutrient Lookup" ) );
        panel_01.add( search_label, cc.xy( 5, 2 ) );
        panel_01.add( search_field, cc.xy( 6, 2 ) );
        panel_01.add( nutrient_label, cc.xy( 2, 4 ) );
        panel_01.add( comboBoxNutrientLookupListNutrient, cc.xy( 3, 4 ) );
        panel_01.add( value_label, cc.xy( 5, 4 ) );
        panel_01.add( textFieldNutrientLookup, cc.xy( 6, 4 ) );
        panel_00.add( panel_01, cc.xy( 2, 2 ) );
        panel_00.add( scrollPaneNutrientLookup, cc.xy( 2, 4 ) );
        modelComboBox_NutrientLookupListNutrient.reload();
        resize_col_tbl_nutrient_lookup();
        textFieldNutrientLookup.addActionListener( ( ActionEvent e ) ->
        {
            reload_tblmdl_nutrient_lookup();
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
                } catch ( java.util.regex.PatternSyntaxException e ) {
                    return;
                }
                srttbl_nutrientlookup.setRowFilter( rf );
            }
        } );
        return panel_00;
    }

    private void set_precision() {
        boolean selected = checkBoxResultRoundUp.isSelected();
        if ( selected ) {
            precision = 0;
            modelTableFoodList.set_precision( precision );
            result_loader.set_precision( precision );
            result_loader_journal.set_precision( precision );
            modelTableGlycemic.set_precision( precision );
            modelTableFoodDifference.set_precision( precision );
            modelTableMixDifference.set_precision( precision );
            modelTableRda.set_precision( precision );
            stringModelMixPct.set_precision( precision );
            modelTableNutrientLookup.set_precision( precision );
            modelTableNutrientInput.set_precision( 5 );
            modelTablePortion.set_precision( precision );
            modelTableResultByMealsCalories.set_precision( precision );
            modelTableResultByMealsGrams.set_precision( precision );
        } else {
            precision = 5;
            modelTableFoodList.set_precision( precision );
            result_loader.set_precision( precision );
            result_loader_journal.set_precision( precision );
            modelTableGlycemic.set_precision( precision );
            modelTableFoodDifference.set_precision( precision );
            modelTableMixDifference.set_precision( precision );
            modelTableRda.set_precision( precision );
            stringModelMixPct.set_precision( precision );
            modelTableNutrientLookup.set_precision( precision );
            modelTableNutrientInput.set_precision( precision );
            modelTablePortion.set_precision( precision );
            modelTableResultByMealsCalories.set_precision( precision );
            modelTableResultByMealsGrams.set_precision( precision );
        }
    }

    private void process_evt_mnui_nutrients_shown_as_constraints() {
        JComponent[] inputs = new JComponent[] {
            get_mnui_constraints_panel()
        };
        int optionValue = Message.showOptionDialogOkCancel( inputs, "Nutrients, Energies and Cost Shown As Constraints" );
        if ( optionValue == 0 ) {
            mapConstraintCheckboxes.forEach( ( k,
                                               v ) ->
            {
                try {
                    if ( v.isSelected() ) {
                        dbLink.Nutrient_Update( k, 1 );
                    } else {
                        dbLink.Nutrient_Update( k, 0 );
                    }
                    dbLink.stopTransaction();
                } catch ( SQLException e ) {

                }
            }
            );
            reload_cbmdl_nutrient();
        }
    }

    private void process_evt_mnui_choose_minimization_option() {
        JComponent[] inputs = new JComponent[] {
            get_minimization_options_panel()
        };
        MixDataObject o = ( MixDataObject ) cmb_mix.getSelectedItem();
        String nutrientid = o.getNutrientid();
        if ( nutrientid.equals( "10009" ) ) {
            mnui_calories.setSelected( true );
        } else {
            mnui_cost.setSelected( true );
        }
        int optionValue = Message.showOptionDialogOkCancel( inputs, "Minimization Options" );
        if ( optionValue == 0 ) {
            try {
                if ( mnui_calories.isSelected() ) {
                    dbLink.Mix_Update_NutrientId( o.getMixId(), "10009" );
                } else {
                    dbLink.Mix_Update_NutrientId( o.getMixId(), "10005" );
                }
                dbLink.stopTransaction();
                reload_lstmdl_mixes();
                clear_model_all();
                int index = mdl_cmb_mix.find_by_mixid( o.getMixId() );
                cmb_mix.setSelectedIndex( index );
            } catch ( SQLException ex ) {
            }
        }
    }

    private JPanel get_mnui_constraints_panel() {
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
        for ( int x = 1; x < it.length + 1; x++ ) {
            Map.Entry entry = ( Map.Entry ) it[ x - 1 ];
            JCheckBox cb = ( JCheckBox ) entry.getValue();
            JLabel label = new JLabel( cb.getName() );
            label.setHorizontalAlignment( SwingConstants.RIGHT );
            if ( x < 11 ) {
                panel01.add( label, cc.xy( 1, x ) );
                panel01.add( cb, cc.xy( 2, x ) );
            } else {
                if ( x < 21 ) {
                    panel01.add( label, cc.xy( 3, x - 10 ) );
                    panel01.add( cb, cc.xy( 4, x - 10 ) );
                } else {
                    if ( x < 31 ) {
                        panel01.add( label, cc.xy( 5, x - 20 ) );
                        panel01.add( cb, cc.xy( 6, x - 20 ) );
                    } else {
                        if ( x < 41 ) {
                            panel01.add( label, cc.xy( 7, x - 30 ) );
                            panel01.add( cb, cc.xy( 8, x - 30 ) );
                        } else {
                            if ( x < 51 ) {
                                panel01.add( label, cc.xy( 9, x - 40 ) );
                                panel01.add( cb, cc.xy( 10, x - 40 ) );
                            } else {
                                if ( x < 61 ) {
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
        minimizationOptionGroup.add( mnui_calories );
        minimizationOptionGroup.add( mnui_cost );
        mnui_calories.setText( "Calories" );
        mnui_cost.setText( "Cost" );
        panel01.add( mnui_calories, cc.xy( 2, 2 ) );
        panel01.add( mnui_cost, cc.xy( 3, 2 ) );
        return panel00;
    }

    private void process_evt_mnui_exit() {
        dbLink.Shutdown();
        //frame.dispose();
        System.exit( 0 );
    }

    private void process_evt_mnui_export_food_list() {
        ExportFoodList exportFoodList = new ExportFoodList( dbLink );
        exportFoodList.print();
    }

    private void process_evt_mnui_export_mix_comparison() {
        if ( is_list_mix_compare_a_selected() && is_list_mix_compare_b_selected() ) {
            ExportMixComparison exportMixComparison = new ExportMixComparison();
            exportMixComparison.print( modelTableMixDifference, lst_mix_compare_a, lst_mix_compare_b );
        } else {
            Message.showMessage( "Go to mix comparison and select two food mixes to compare" );
        }
    }

    private void process_evt_mnui_export_food_comparison() {
        if ( is_list_food_compare_a_selected() && is_list_food_compare_b_selected() ) {
            ExportFoodComparison exportFoodComparison = new ExportFoodComparison();
            exportFoodComparison.print( modelTableFoodDifference, lst_food_compare_a, lst_food_compare_b );
        } else {
            Message.showMessage( "Go to food comparison and select two food items to compare" );
        }
    }

    private void process_evt_mnui_export_rda_check() {
        MixDataObject mixDataObject = ( MixDataObject ) cmb_mix.getSelectedItem();
        RdaLifeStageDataObject rdaLifeStageDataObject = ( RdaLifeStageDataObject ) cb_results_lifestage.getSelectedItem();
        ExportRdaCheck exportRdaCheck = new ExportRdaCheck( dbLink );
        exportRdaCheck.print( mixDataObject, rdaLifeStageDataObject );
    }

    private void process_evt_mnui_export_nutrient_lookup() {
        if ( !textFieldNutrientLookup.getText().isBlank() ) {
            ExportNutrientLookup exportNutrientLookup = new ExportNutrientLookup( dbLink );
            exportNutrientLookup.print( textFieldNutrientLookup, comboBoxNutrientLookupListNutrient );
        } else {
            Message.showMessage( "Go to nutrient lookup and enter nutrient amount" );
        }
    }

    private void process_evt_mnui_guide() {
        open_url( "http://xjrga.github.io/snack" );
    }

    private void process_evt_mnui_credits() {
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
        sb.append( "\n\n" );
        sb.append( "Snack uses a data subset from:" );
        sb.append( "\n\n" );
        sb.append( "1) USDA National Nutrient Database for Standard Reference, Release 28" );
        sb.append( "\n\n" );
        sb.append( "2) Dietary Reference Intakes Nutrient Recommendations Report from" );
        sb.append( "\n" );
        sb.append( "   Food and Nutrition Board of the Institute of Medicine, National Academy of Sciences" );
        String_display_component component = new String_display_component();
        component.setText( sb.toString() );
        component.setPreferredSize( new Dimension( 550, 250 ) );
        JComponent[] inputs = new JComponent[ 1 ];
        inputs[ 0 ] = component;
        Message.showOptionDialog( inputs, "Credits" );
    }

    private void process_evt_mnui_about() {
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
        sb.append( "This is build 1200" );
        sb.append( "\n\n" );
        sb.append( "Please send your comments and suggestions to jorge.r.garciadealba+snack@gmail.com" );
        String_display_component component = new String_display_component();
        component.setText( sb.toString() );
        component.setPreferredSize( new Dimension( 754, 575 ) );
        JComponent[] inputs = new JComponent[ 1 ];
        inputs[ 0 ] = component;
        Message.showOptionDialog( inputs, "About" );
    }

    private JSplitPane get_editor_results() {
        JPanel pnl_main = new JPanel();
        JPanel pnl_right = new JPanel();
        JPanel pnl_objective = new JPanel();
        JPanel pnl_constraint_count = new JPanel();
        FormLayout layout00 = new FormLayout(
                "600dlu,100dlu", //columns
                "fill:min:grow" //rows
        );
        FormLayout layout01 = new FormLayout(
                "min:grow", //columns
                "min,min,fill:130dlu" //rows
        );
        FormLayout layout02 = new FormLayout(
                "min,min", //columns
                "4dlu,min,min,min,min,min,4dlu" //rows
        );
        pnl_main.setLayout( layout00 );
        pnl_right.setLayout( layout01 );
        pnl_constraint_count.setLayout( layout02 );
        JScrollPane scrp_high_score = new JScrollPane( lst_high_score );
        scrp_high_score.setBorder( new TitledBorder( "" ) );
        pnl_objective.setBorder( new TitledBorder( "Minimize" ) );
        scrp_high_score.setToolTipText( "Press delete button to clear list" );
        pnl_constraint_count.setBorder( new TitledBorder( "Mix Constraints" ) );
        lst_high_score.setModel( mdl_lst_high_score );
        DefaultListCellRenderer renderer = ( DefaultListCellRenderer ) lst_high_score.getCellRenderer();
        renderer.setHorizontalAlignment( SwingConstants.RIGHT );
        results_tabbed_pane.setBorder( new TitledBorder( "Mix Nutritional Value" ) );
        results_tabbed_pane.setTabPlacement( JTabbedPane.RIGHT );
        JLabel lbl_nutrient_constraint = new JLabel( "Nutrient: " );
        JLabel lbl_food_nutrient_constraint = new JLabel( "Food Nutrient: " );
        JLabel lbl_nutrient_ratio_constraint = new JLabel( "Nutrient Ratio: " );
        JLabel lbl_food_nutrient_ratio_constraint = new JLabel( "Food Nutrient Ratio: " );
        JLabel lbl_nutrient_pct_constraint = new JLabel( "Food Nutrient Percent: " );
        lbl_nutrient_constraint.setHorizontalAlignment( JLabel.RIGHT );
        lbl_food_nutrient_constraint.setHorizontalAlignment( JLabel.RIGHT );
        lbl_nutrient_ratio_constraint.setHorizontalAlignment( JLabel.RIGHT );
        lbl_food_nutrient_ratio_constraint.setHorizontalAlignment( JLabel.RIGHT );
        lbl_nutrient_pct_constraint.setHorizontalAlignment( JLabel.RIGHT );
        nutrient_constraint_count.setHorizontalAlignment( JLabel.CENTER );
        food_nutrient_constraint_count.setHorizontalAlignment( JLabel.CENTER );
        nutrient_ratio_constraint_count.setHorizontalAlignment( JLabel.CENTER );
        food_nutrient_ratio_constraint_count.setHorizontalAlignment( JLabel.CENTER );
        nutrient_pct_constraint_count.setHorizontalAlignment( JLabel.CENTER );
        pnl_constraint_count.add( lbl_nutrient_constraint, cc.xy( 1, 2 ) );
        pnl_constraint_count.add( lbl_food_nutrient_constraint, cc.xy( 1, 3 ) );
        pnl_constraint_count.add( lbl_nutrient_ratio_constraint, cc.xy( 1, 4 ) );
        pnl_constraint_count.add( lbl_food_nutrient_ratio_constraint, cc.xy( 1, 5 ) );
        pnl_constraint_count.add( lbl_nutrient_pct_constraint, cc.xy( 1, 6 ) );
        pnl_constraint_count.add( nutrient_constraint_count, cc.xy( 2, 2 ) );
        pnl_constraint_count.add( food_nutrient_constraint_count, cc.xy( 2, 3 ) );
        pnl_constraint_count.add( nutrient_ratio_constraint_count, cc.xy( 2, 4 ) );
        pnl_constraint_count.add( food_nutrient_ratio_constraint_count, cc.xy( 2, 5 ) );
        pnl_constraint_count.add( nutrient_pct_constraint_count, cc.xy( 2, 6 ) );
        results_tabbed_pane.add( get_editor_energy() );
        results_tabbed_pane.add( get_editor_macronutrient() );
        results_tabbed_pane.add( get_editor_protein() );
        results_tabbed_pane.add( get_editor_fats() );
        results_tabbed_pane.add( get_editor_carbs() );
        results_tabbed_pane.add( get_editor_vitamins() );
        results_tabbed_pane.add( get_editor_minerals() );
        results_tabbed_pane.add( get_editor_electrolytes() );
        results_tabbed_pane.add( get_editor_water() );
        results_tabbed_pane.add( get_editor_cost() );
        results_tabbed_pane.add( get_editor_glycemic() );
        results_tabbed_pane.add( get_editor_rda() );
        results_tabbed_pane.add( get_editor_model() );
        results_tabbed_pane.setTitleAt( 0, "Energy" );
        results_tabbed_pane.setTitleAt( 1, "Macronutrient" );
        results_tabbed_pane.setTitleAt( 2, "Protein" );
        results_tabbed_pane.setTitleAt( 3, "Fats" );
        results_tabbed_pane.setTitleAt( 4, "Carbohydrates" );
        results_tabbed_pane.setTitleAt( 5, "Vitamins" );
        results_tabbed_pane.setTitleAt( 6, "Minerals" );
        results_tabbed_pane.setTitleAt( 7, "Electrolytes" );
        results_tabbed_pane.setTitleAt( 8, "Water" );
        results_tabbed_pane.setTitleAt( 9, "Cost" );
        results_tabbed_pane.setTitleAt( 10, "Glycemic" );
        results_tabbed_pane.setTitleAt( 11, "Rda" );
        results_tabbed_pane.setTitleAt( 12, "Model" );
        pnl_objective.add( lbl_min );
        pnl_right.add( pnl_constraint_count, cc.xy( 1, 1 ) );
        pnl_right.add( pnl_objective, cc.xy( 1, 2 ) );
        pnl_right.add( scrp_high_score, cc.xy( 1, 3 ) );
        pnl_main.add( results_tabbed_pane, cc.xy( 1, 1 ) );
        pnl_main.add( pnl_right, cc.xy( 2, 1 ) );
        split.setOrientation( JSplitPane.VERTICAL_SPLIT );
        split.setOneTouchExpandable( true );
        split.setTopComponent( pnl_main );
        split.setBottomComponent( get_constraints_tab_pane() );
        split.addPropertyChangeListener( JSplitPane.DIVIDER_LOCATION_PROPERTY, (
                                         PropertyChangeEvent pce ) ->
                                 {
                                     //System.out.println( split.getDividerLocation() );
                                 } );
        lst_high_score.addKeyListener( new KeyListener() {
            @Override
            public void keyTyped( KeyEvent keyEvent ) {
            }

            @Override
            public void keyPressed( KeyEvent keyEvent ) {
                if ( keyEvent.getKeyCode() == KeyEvent.VK_DELETE ) {
                    process_evt_lst_high_score();
                }
            }

            @Override
            public void keyReleased( KeyEvent keyEvent ) {
            }
        } );
        Action high = new AbstractAction() {
            @Override
            public void actionPerformed( ActionEvent e ) {
                split.setDividerLocation( 0.0 );
            }
        };
        Action middle = new AbstractAction() {
            @Override
            public void actionPerformed( ActionEvent e ) {
                split.setDividerLocation( 370 );
            }
        };
        Action low = new AbstractAction() {
            @Override
            public void actionPerformed( ActionEvent e ) {
                split.setDividerLocation( 1.0 );
            }
        };
        InputMap input_map = main_tabbed_pane.getInputMap( JSplitPane.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT );
        ActionMap action_map = main_tabbed_pane.getActionMap();
        input_map.put( KeyStroke.getKeyStroke( "control L" ), "min" );
        input_map.put( KeyStroke.getKeyStroke( "control M" ), "mid" );
        input_map.put( KeyStroke.getKeyStroke( "control H" ), "max" );
        action_map.put( "min", low );
        action_map.put( "mid", middle );
        action_map.put( "max", high );
        return split;
    }

    private void set_constraint_counts() {
        nutrient_ratio_constraint_count.setText( get_text_nutrient_ratio_count() );
        food_nutrient_ratio_constraint_count.setText( get_text_food_ratio_count() );
        food_nutrient_constraint_count.setText( get_text_food_constraint_count() );
        nutrient_pct_constraint_count.setText( get_text_nutrient_percent_constraint_count() );
        nutrient_constraint_count.setText( get_text_nutrient_constraint_count() );
    }

    private JScrollPane get_editor_glycemic() {
        JScrollPane scrollPane = new JScrollPane( tableGlycemic );
        tableGlycemic.setModel( modelTableGlycemic );
        tableGlycemic.setSelectionMode( ListSelectionModel.SINGLE_SELECTION );
        tableGlycemic.setFillsViewportHeight( true );
        tableGlycemic.setAutoResizeMode( JTable.AUTO_RESIZE_OFF );
        tableGlycemic.setTableHeader( new TableHeaderGlycemic( tableGlycemic.getColumnModel() ) );
        tableGlycemic.setAutoCreateRowSorter( true );
        return scrollPane;
    }

    private JScrollPane get_editor_energy() {
        JScrollPane scrollPane = new JScrollPane( tableEnergy );
        tableEnergy.setModel( modelTableEnergy );
        tableEnergy.setSelectionMode( ListSelectionModel.SINGLE_SELECTION );
        tableEnergy.setFillsViewportHeight( true );
        tableEnergy.setAutoResizeMode( JTable.AUTO_RESIZE_OFF );
        tableEnergy.setTableHeader( new TableHeaderEnergy( tableEnergy.getColumnModel() ) );
        tableEnergy.setAutoCreateRowSorter( true );
        return scrollPane;
    }

    private JScrollPane get_editor_macronutrient() {
        JScrollPane scrollPane = new JScrollPane( tableMacronutrient );
        tableMacronutrient.setModel( modelTableMacroNutrient );
        tableMacronutrient.setSelectionMode( ListSelectionModel.SINGLE_SELECTION );
        tableMacronutrient.setFillsViewportHeight( true );
        tableMacronutrient.setAutoResizeMode( JTable.AUTO_RESIZE_OFF );
        tableMacronutrient.setTableHeader( new TableHeaderMacroNutrient( tableMacronutrient.getColumnModel() ) );
        tableMacronutrient.setAutoCreateRowSorter( true );
        return scrollPane;
    }

    private JScrollPane get_editor_protein() {
        JScrollPane scrollPane = new JScrollPane( tableProtein );
        tableProtein.setModel( modelTableProtein );
        tableProtein.setSelectionMode( ListSelectionModel.SINGLE_SELECTION );
        tableProtein.setFillsViewportHeight( true );
        tableProtein.setAutoResizeMode( JTable.AUTO_RESIZE_OFF );
        tableProtein.setTableHeader( new TableHeaderProtein( tableProtein.getColumnModel() ) );
        tableProtein.setAutoCreateRowSorter( true );
        return scrollPane;
    }

    private JScrollPane get_editor_fats() {
        JScrollPane scrollPane = new JScrollPane( tableFats );
        tableFats.setModel( modelTableFats );
        tableFats.setSelectionMode( ListSelectionModel.SINGLE_SELECTION );
        tableFats.setFillsViewportHeight( true );
        tableFats.setAutoResizeMode( JTable.AUTO_RESIZE_OFF );
        tableFats.setTableHeader( new TableHeaderFats( tableFats.getColumnModel() ) );
        tableFats.setAutoCreateRowSorter( true );
        return scrollPane;
    }

    private JScrollPane get_editor_carbs() {
        JScrollPane scrollPane = new JScrollPane( tableCarbs );
        tableCarbs.setModel( modelTableCarbs );
        tableCarbs.setSelectionMode( ListSelectionModel.SINGLE_SELECTION );
        tableCarbs.setFillsViewportHeight( true );
        tableCarbs.setAutoResizeMode( JTable.AUTO_RESIZE_OFF );
        tableCarbs.setTableHeader( new TableHeaderCarbs( tableCarbs.getColumnModel() ) );
        tableCarbs.setAutoCreateRowSorter( true );
        return scrollPane;
    }

    private JScrollPane get_editor_vitamins() {
        JScrollPane scrollPane = new JScrollPane( tableVitamins );
        tableVitamins.setModel( modelTableVitamins );
        tableVitamins.setSelectionMode( ListSelectionModel.SINGLE_SELECTION );
        tableVitamins.setFillsViewportHeight( true );
        tableVitamins.setAutoResizeMode( JTable.AUTO_RESIZE_OFF );
        tableVitamins.setTableHeader( new TableHeaderVitamins( tableVitamins.getColumnModel() ) );
        tableVitamins.setAutoCreateRowSorter( true );
        return scrollPane;
    }

    private JScrollPane get_editor_minerals() {
        JScrollPane scrollPane = new JScrollPane( tableMinerals );
        tableMinerals.setModel( modelTableMinerals );
        tableMinerals.setSelectionMode( ListSelectionModel.SINGLE_SELECTION );
        tableMinerals.setFillsViewportHeight( true );
        tableMinerals.setAutoResizeMode( JTable.AUTO_RESIZE_OFF );
        tableMinerals.setTableHeader( new TableHeaderMinerals( tableMinerals.getColumnModel() ) );
        tableMinerals.setAutoCreateRowSorter( true );
        return scrollPane;
    }

    private JScrollPane get_editor_electrolytes() {
        JScrollPane scrollPane = new JScrollPane( tableElectrolytes );
        tableElectrolytes.setModel( modelTableElectrolytes );
        tableElectrolytes.setSelectionMode( ListSelectionModel.SINGLE_SELECTION );
        tableElectrolytes.setFillsViewportHeight( true );
        tableElectrolytes.setAutoResizeMode( JTable.AUTO_RESIZE_OFF );
        tableElectrolytes.setTableHeader( new TableHeaderElectrolytes( tableElectrolytes.getColumnModel() ) );
        tableElectrolytes.setAutoCreateRowSorter( true );
        return scrollPane;
    }

    private JScrollPane get_editor_water() {
        JScrollPane scrollPane = new JScrollPane( tableWater );
        tableWater.setModel( modelTableWater );
        tableWater.setSelectionMode( ListSelectionModel.SINGLE_SELECTION );
        tableWater.setFillsViewportHeight( true );
        tableWater.setAutoResizeMode( JTable.AUTO_RESIZE_OFF );
        tableWater.setTableHeader( new TableHeaderWater( tableWater.getColumnModel() ) );
        tableWater.setAutoCreateRowSorter( true );
        return scrollPane;
    }

    private JScrollPane get_editor_cost() {
        JScrollPane scrollPane = new JScrollPane( tableCost );
        tableCost.setModel( modelTableCost );
        tableCost.setSelectionMode( ListSelectionModel.SINGLE_SELECTION );
        tableCost.setFillsViewportHeight( true );
        tableCost.setAutoResizeMode( JTable.AUTO_RESIZE_OFF );
        tableCost.setTableHeader( new TableHeaderCost( tableCost.getColumnModel() ) );
        tableCost.setAutoCreateRowSorter( true );
        return scrollPane;
    }

    private void process_evt_lst_high_score() {
        mdl_lst_high_score.clear();
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
        JScrollPane scrSelectedFood = new JScrollPane( lst_selected_food );
        scrSelectedFood.setBorder( new TitledBorder( "Mix Food" ) );
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
        buttonAddMixFood.addActionListener( e ->
                process_evt_btn_mix_food_add() );
        buttonDeleteMixFood.addActionListener( e ->
                process_evt_btn_mix_food_delete() );
        buttonExpandMixFood.addActionListener( e ->
                process_evt_btn_mix_food_expand() );
        buttonCollapseMixFood.addActionListener( e ->
                process_evt_btn_mix_food_collapse() );
        lst_selected_food.setModel( modelList_selected_food );
        return panel;
    }

    private JPanel get_constraint_nutrient() {
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
        buttonNutrientConstraintAdd.addActionListener( ( ActionEvent e ) ->
        {
            process_evt_btn_nutrient_constraint_add();
        } );
        buttonNutrientConstraintDelete.addActionListener( ( ActionEvent e ) ->
        {
            process_evt_btn_nutrient_constraint_delete();
        } );
        tableNutrientConstraint.getSelectionModel().addListSelectionListener( (
                ListSelectionEvent e ) ->
        {
            process_evt_tbl_nutrient_constraint();
        } );
        tableNutrientConstraint.setFillsViewportHeight( true );
        return panel;
    }

    private JPanel get_constraint_food_nutrient() {
        JPanel panel = new JPanel();
        FormLayout panelLayout = new FormLayout(
                //374dlu is limit
                "min,min,min,374dlu", //columns
                "min,min,fill:min:grow,min" //rows
        );
        panel.setLayout( panelLayout );
        JScrollPane spTable = new JScrollPane( tableFoodNutrient );
        JPanel buttons = new JPanel();
        textFieldFoodNutrient_Quantity.setMinimumSize( new Dimension( 100, 25 ) );
        panel.add( comboBoxFoodNutrient_Food, cc.xyw( 1, 1, 4 ) );
        panel.add( comboBoxFoodNutrient_Nutrient, cc.xy( 1, 2 ) );
        panel.add( comboBoxFoodNutrient_Relationship, cc.xy( 2, 2 ) );
        panel.add( textFieldFoodNutrient_Quantity, cc.xy( 3, 2 ) );
        panel.add( spTable, cc.xyw( 1, 3, 4 ) );
        buttons.add( buttonFoodNutrientConstraintAdd );
        buttons.add( buttonFoodNutrientConstraintDelete );
        panel.add( buttons, cc.xyw( 1, 4, 4 ) );
        spTable.setBorder( new TitledBorder( "Food Nutrient Constraints" ) );
        comboBoxFoodNutrient_Nutrient.setMaximumRowCount( 10 );
        comboBoxFoodNutrient_Nutrient.setModel( modelComboBox_NutrientAtFoodNutrient );
        comboBoxFoodNutrient_Relationship.setMaximumRowCount( 3 );
        comboBoxFoodNutrient_Relationship.setModel( modelComboBox_RelationshipAtFoodNutrient );
        comboBoxFoodNutrient_Food.setMaximumRowCount( 10 );
        comboBoxFoodNutrient_Food.setModel( modelComboBox_FoodAtFoodNutrient );
        tableFoodNutrient.getTableHeader().setReorderingAllowed( false );
        tableFoodNutrient.setModel( modelTableFoodNutrientConstraints );
        tableFoodNutrient.setSelectionMode( ListSelectionModel.SINGLE_SELECTION );
        buttonFoodNutrientConstraintAdd.setToolTipText( "Add Constraint" );
        buttonFoodNutrientConstraintDelete.setToolTipText( "Delete Constraint" );
        buttonFoodNutrientConstraintAdd.addActionListener( ( ActionEvent e ) ->
        {
            process_evt_btn_food_nutrient_constraint_add();
        } );
        buttonFoodNutrientConstraintDelete.addActionListener( ( ActionEvent e ) ->
        {
            process_evt_btn_food_nutrient_constraint_delete();
        } );
        tableFoodNutrient.getSelectionModel().addListSelectionListener( (
                ListSelectionEvent e ) ->
        {
            process_evt_tbl_food_nutrient_constraint();
        } );
        tableFoodNutrient.setFillsViewportHeight( true );
        return panel;
    }

    private JPanel get_constraint_nutrient_ratio() {
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
        buttonNutrientRatioAdd.addActionListener( ( ActionEvent e ) ->
        {
            process_evt_btn_nutrient_ratio_add();
        } );
        buttonNutrientRatioDelete.addActionListener( ( ActionEvent e ) ->
        {
            process_evt_btn_nutrient_ratio_delete();
        } );
        tableNutrientRatio.getSelectionModel().addListSelectionListener( (
                ListSelectionEvent e ) ->
        {
            process_evt_tbl_nutrient_ratio_constraint();
        } );
        tableNutrientRatio.setFillsViewportHeight( true );
        return panel;
    }

    private JPanel get_constraint_food_nutrient_ratio() {
        JPanel panel = new JPanel();
        FormLayout panelLayout = new FormLayout(
                "min,min,min,374dlu:grow", //columns
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
        spTable.setBorder( new TitledBorder( "Food Nutrient Ratio Constraints" ) );
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
        buttonFoodNutrientRatioAdd.addActionListener( ( ActionEvent e ) ->
        {
            process_evt_btn_food_nutrient_ratio_add();
            resize_col_tbl_food_nutrient_ratio_constraint();
        } );
        buttonFoodNutrientRatioDelete.addActionListener( ( ActionEvent e ) ->
        {
            process_evt_btn_food_nutrient_ratio_delete();
            resize_col_tbl_food_nutrient_ratio_constraint();
        } );
        tableFoodNutrientRatio.getSelectionModel().addListSelectionListener( (
                ListSelectionEvent e ) ->
        {
            process_evt_tbl_food_nutrient_ratio_constraint();
        } );
        tableFoodNutrientRatio.setFillsViewportHeight( true );
        return panel;
    }

    private JPanel get_constraint_food_nutrient_percent() {
        JPanel panel = new JPanel();
        FormLayout panelLayout = new FormLayout(
                "min,min,min,min,550px", //columns
                "min,min,fill:min:grow,min" //rows
        );
        panel.setLayout( panelLayout );
        JScrollPane spTable = new JScrollPane( tableNutrientPercent );
        JPanel buttons = new JPanel();
        textFieldPercentNutrient_Quantity.setMinimumSize( new Dimension( 100, 25 ) );
        panel.add( comboBoxPercentNutrient_Food, cc.xyw( 1, 1, 5 ) );
        panel.add( comboBoxPercentNutrient_Nutrient, cc.xy( 1, 2 ) );
        panel.add( comboBoxPercentNutrient_Relationship, cc.xy( 2, 2 ) );
        panel.add( textFieldPercentNutrient_Quantity, cc.xy( 3, 2 ) );
        panel.add( new JLabel( "%" ), cc.xy( 3, 2 ) );
        panel.add( spTable, cc.xyw( 1, 3, 5 ) );
        buttons.add( buttonPercentNutrientConstraintAdd );
        buttons.add( buttonPercentNutrientConstraintDelete );
        panel.add( buttons, cc.xyw( 1, 4, 5 ) );
        spTable.setBorder( new TitledBorder( "Food Nutrient Percent Constraints" ) );
        comboBoxPercentNutrient_Nutrient.setMaximumRowCount( 10 );
        comboBoxPercentNutrient_Nutrient.setModel( modelComboBox_NutrientAtNutrientPct );
        comboBoxPercentNutrient_Food.setMaximumRowCount( 10 );
        comboBoxPercentNutrient_Food.setModel( modelComboBox_FoodAtNutrientPct );
        comboBoxPercentNutrient_Relationship.setModel( modelComboBox_RelationshipAtNutrientPct );
        tableNutrientPercent.getTableHeader().setReorderingAllowed( false );
        tableNutrientPercent.setModel( tableModelPercentNutrientConstraints );
        tableNutrientPercent.setSelectionMode( ListSelectionModel.SINGLE_SELECTION );
        buttonPercentNutrientConstraintAdd.setToolTipText( "Add Constraint" );
        buttonPercentNutrientConstraintDelete.setToolTipText( "Delete Constraint" );
        buttonPercentNutrientConstraintAdd.addActionListener( ( ActionEvent e ) ->
        {
            process_evt_btn_percent_nutrient_constraint_add();
        } );
        buttonPercentNutrientConstraintDelete.addActionListener( ( ActionEvent e ) ->
        {
            process_evt_btn_percent_nutrient_constraint_delete();
        } );
        tableNutrientPercent.getSelectionModel().addListSelectionListener( (
                ListSelectionEvent e ) ->
        {
            process_evt_tbl_food_nutrient_percent_constraint();
        } );
        tableNutrientPercent.setFillsViewportHeight( true );
        return panel;
    }

    private void process_evt_btn_percent_nutrient_constraint_delete() {
        try {
            int selectedRow = tableNutrientPercent.getSelectedRow();
            if ( selectedRow != -1 ) {
                String mixid = ( String ) tableNutrientPercent.getValueAt( selectedRow, 0 );
                String foodid = ( String ) tableNutrientPercent.getValueAt( selectedRow, 1 );
                String nutrientid = ( String ) tableNutrientPercent.getValueAt( selectedRow, 2 );
                Integer relationshipid = ( Integer ) tableNutrientPercent.getValueAt( selectedRow, 3 );
                dbLink.PercentNutrientConstraint_Delete( mixid, foodid, nutrientid, relationshipid );
                tableModelPercentNutrientConstraints.reload( mixid );
                set_constraint_counts();
                resize_col_tbl_percent_nutrient_constraint();
            }
        } catch ( SQLException e ) {

        }
    }

    private void process_evt_btn_percent_nutrient_constraint_add() {
        if ( is_it_ready_to_add_percent_nutrient_constraint() ) {
            NumberCheck numberCheck = new NumberCheck();
            numberCheck.addToUncheckedList( textFieldPercentNutrient_Quantity.getText() );
            if ( numberCheck.pass() ) {
                try {
                    MixDataObject mix = ( MixDataObject ) cmb_mix.getSelectedItem();
                    FoodDataObject foodDataObject = ( FoodDataObject ) comboBoxPercentNutrient_Food.getSelectedItem();
                    NutrientDataObject nutrientDataObject = ( NutrientDataObject ) comboBoxPercentNutrient_Nutrient.getSelectedItem();
                    RelationshipDataObject relationshipDataObject = ( RelationshipDataObject ) comboBoxPercentNutrient_Relationship.getSelectedItem();
                    Double b = Double.parseDouble( textFieldPercentNutrient_Quantity.getText() );
                    dbLink.NutrientPercentConstraint_Merge( mix.getMixId(), foodDataObject.getFoodId(), nutrientDataObject.getNutr_no(), relationshipDataObject.getRelationshipid(), b );
                    tableModelPercentNutrientConstraints.reload( mix.getMixId() );
                    set_constraint_counts();
                    resize_col_tbl_percent_nutrient_constraint();
                } catch ( SQLException e ) {

                }
            } else {
                Message.showMessage( "Value must be a number greater than or equal to zero" );
            }
        }
    }

    private void resize_col_tbl_percent_nutrient_constraint() {
        for ( int i = 0; i < 4; i++ ) {
            tableNutrientPercent.getColumnModel().getColumn( i ).setMinWidth( 0 );
            tableNutrientPercent.getColumnModel().getColumn( i ).setMaxWidth( 0 );
        }
        tableNutrientPercent.getColumnModel().getColumn( 4 ).setMinWidth( 480 );
        tableNutrientPercent.getColumnModel().getColumn( 5 ).setMinWidth( 250 );
        tableNutrientPercent.getColumnModel().getColumn( 6 ).setMinWidth( 21 );
        tableNutrientPercent.getColumnModel().getColumn( 6 ).setMaxWidth( 21 );
    }

    private boolean is_it_ready_to_add_percent_nutrient_constraint() {
        Boolean flag_isReady = false;
        Boolean flag_listFood = false;
        Boolean flag_listNutrient = false;
        Boolean flag_quantity = false;
        if ( comboBoxPercentNutrient_Food.getSelectedIndex() != -1 ) {
            flag_listFood = true;
        } else {
            Message.showMessage( "Select food" );
        }
        if ( comboBoxPercentNutrient_Nutrient.getSelectedIndex() != -1 ) {
            flag_listNutrient = true;
        } else {
            Message.showMessage( "Select nutrient" );
        }
        if ( !textFieldPercentNutrient_Quantity.getText().isEmpty() ) {
            flag_quantity = true;
        } else {
            Message.showMessage( "Specify amount" );
        }
        if ( flag_listFood && flag_listNutrient && flag_quantity ) {
            flag_isReady = true;
        }
        return flag_isReady;
    }

    private JPanel get_editor_model() {
        JPanel panel = new JPanel();
        FormLayout layout = new FormLayout(
                "min:grow", //columns
                "fill:pref:grow" //rows
        );
        panel.setLayout( layout );
        txta_editor_model.setLineWrap( false );
        txta_editor_model.setEditable( false );
        JScrollPane scrollPane = new JScrollPane( txta_editor_model );
        scrollPane.setPreferredSize( new Dimension( 0, 0 ) );
        panel.add( scrollPane, cc.xy( 1, 1 ) );
        return panel;
    }

    private void process_evt_cmb_mix() {
        MixDataObject mixDataObject = ( MixDataObject ) cmb_mix.getSelectedItem();
        String mixid = mixDataObject.getMixId();
        modelList_selected_food.reload( mixid );
        legend_generator.reload( mixid );
        reload_tblmdl_editor_results();
        reload_tblmdl_editor_rda_check();
        reload_cbmdl_food( mixid );
        reload_tblmdl_constraints( mixid );
        reload_lstmdl_portion_meal();
        reload_cbmdl_portion_food();
        reload_tblmdl_meals( mixid );
        reload_tblmdl_portion( mixid );
        reload_tblmdl_results_by_meal( mixid );
        resize_col_tbl_editor_rda_check();
        resize_tbls_constraint();
        resize_col_tbl_meal();
        resize_col_tbl_meal_portions();
        resize_col_tbl_results_by_meal_calories();
        resize_col_tbl_results_by_meal_grams();
        resize_tbl_editor_results();
        txta_editor_model.setText( mixDataObject.getModel() );
        set_constraint_counts();
        if ( mixDataObject.getNutrientid().equals( "10009" ) ) {
            lbl_min.setText( "Calories" );
        } else {
            lbl_min.setText( "Cost" );
        }
    }

    private void resize_tbls_constraint() {
        resize_col_tbl_nutrient_constraint();
        resize_col_tbl_food_nutrient_constraint();
        resize_col_tbl_nutrient_ratio_constraint();
        resize_col_tbl_food_nutrient_ratio_constraint();
        resize_col_tbl_percent_nutrient_constraint();
    }

    private void resize_col_tbl_nutrient_constraint() {
        for ( int i = 0; i < 3; i++ ) {
            tableNutrientConstraint.getColumnModel().getColumn( i ).setMinWidth( 0 );
            tableNutrientConstraint.getColumnModel().getColumn( i ).setMaxWidth( 0 );
        }
        tableNutrientConstraint.getColumnModel().getColumn( 3 ).setMinWidth( 250 );
        tableNutrientConstraint.getColumnModel().getColumn( 3 ).setMaxWidth( 250 );
        tableNutrientConstraint.getColumnModel().getColumn( 4 ).setMinWidth( 21 );
        tableNutrientConstraint.getColumnModel().getColumn( 4 ).setMaxWidth( 21 );
    }

    private void process_evt_lst_mix_compare_a( ListSelectionEvent e ) {
        if ( !e.getValueIsAdjusting() ) {
            reload_tblmdl_mix_comparison();
        }
    }

    private void process_evt_lst_mix_compare_b( ListSelectionEvent e ) {
        if ( !e.getValueIsAdjusting() ) {
            reload_tblmdl_mix_comparison();
        }
    }

    private void reload_tblmdl_mix_comparison() {
        if ( is_list_mix_compare_a_selected() && is_list_mix_compare_b_selected() ) {
            MixDataObject mix1 = ( MixDataObject ) lst_mix_compare_a.getSelectedValue();
            String mixid1 = mix1.getMixId();
            MixDataObject mix2 = ( MixDataObject ) lst_mix_compare_b.getSelectedValue();
            String mixid2 = mix2.getMixId();
            modelTableMixDifference.reload( mixid1, mixid2 );
            srttbl_mix_comparison.toggleSortOrder( 1 );
            srttbl_mix_comparison.sort();
            srttbl_mix_comparison.toggleSortOrder( 0 );
            srttbl_mix_comparison.sort();
            resize_col_tbl_mix_comparison();
        }
    }

    private void process_evt_lst_food_compare_a( ListSelectionEvent e ) {
        if ( !e.getValueIsAdjusting() ) {
            reload_tblmdl_food_comparison();
        }
    }

    private void process_evt_lst_food_compare_b( ListSelectionEvent e ) {
        if ( !e.getValueIsAdjusting() ) {
            reload_tblmdl_food_comparison();
        }
    }

    private void reload_tblmdl_food_comparison() {
        if ( is_list_food_compare_a_selected() && is_list_food_compare_b_selected() ) {
            FoodDataObject food_a = ( FoodDataObject ) lst_food_compare_a.getSelectedValue();
            String food_id_a = food_a.getFoodId();
            FoodDataObject food_b = ( FoodDataObject ) lst_food_compare_b.getSelectedValue();
            String food_id_b = food_b.getFoodId();
            modelTableFoodDifference.reload( food_id_a, food_id_b );
            resize_col_tbl_food_comparison();
        }
    }

    private JPanel get_food_categories() {
        JPanel panel = new JPanel();
        FormLayout layout = new FormLayout(
                "4dlu,min:grow(.2),4dlu,min:grow(.5),4dlu,min:grow(.6),4dlu", //columns
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
        buttonAddFoodToCategory.setToolTipText( "Add food item to category" );
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
        panel02.setBorder( new TitledBorder( "All Food Items" ) );
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
        resize_col_tbl_food_list();
        //
        buttonCategoriesAdd.addActionListener( ( ActionEvent e ) ->
        {
            process_evt_btn_categories_add();
        } );
        buttonCategoriesRename.addActionListener( ( ActionEvent e ) ->
        {
            process_evt_btn_categories_rename();
        } );
        buttonCategoriesDelete.addActionListener( ( ActionEvent e ) ->
        {
            process_evt_btn_categories_delete();
        } );
        listCategories.addListSelectionListener( ( ListSelectionEvent e ) ->
        {
            process_evt_lst_categories( e );
        } );
        buttonAddFoodToCategory.addActionListener( ( ActionEvent e ) ->
        {
            process_evt_btn_category_add_food();
        } );
        buttonDeleteFoodFromCategory.addActionListener( ( ActionEvent e ) ->
        {
            process_evt_btn_category_delete_food();
        } );
        textFieldSearch.addActionListener( ( ActionEvent e ) ->
        {
            process_evt_fld_search( e );
        } );
        return panel;
    }

    private void process_evt_fld_search( ActionEvent e ) {
        modelListFood.reload( (( JTextComponent ) e.getSource()).getText() );
    }

    private void process_evt_btn_category_delete_food() {
        if ( !listCategories.isSelectionEmpty() ) {
            try {
                FoodCategoryDataObject foodCategoryDataObject = ( FoodCategoryDataObject ) listCategories.getSelectedValue();
                int[] selectedRows = listFoodInCategory.getSelectedIndices();
                for ( int i = 0; i < selectedRows.length; i++ ) {
                    FoodDataObject foodDataObject = ( FoodDataObject ) modelListFoodInCategory.get( selectedRows[ i ] );
                    dbLink.CategoryLink_Delete( foodCategoryDataObject.getFoodCategoryId(), foodDataObject.getFoodId() );
                    dbLink.stopTransaction();
                }
                reload_food_items();
                resize_col_tbl_food_list();
                modelListFoodInCategory.reload( foodCategoryDataObject.getFoodCategoryId() );
            } catch ( SQLException e ) {

            }
        }
    }

    private void process_evt_btn_category_add_food() {
        if ( !listCategories.isSelectionEmpty() ) {
            if ( !listAllFoodItems.isSelectionEmpty() ) {
                try {
                    FoodCategoryDataObject foodCategoryDataObject = ( FoodCategoryDataObject ) listCategories.getSelectedValue();
                    int[] selectedRows = listAllFoodItems.getSelectedIndices();
                    for ( int i = 0; i < selectedRows.length; i++ ) {
                        FoodDataObject foodDataObject = ( FoodDataObject ) modelListFood.get( selectedRows[ i ] );
                        Integer count = dbLink.CategoryLink_Count( foodCategoryDataObject.getFoodCategoryId(), foodDataObject.getFoodId() );
                        if ( count == 0 ) {
                            dbLink.CategoryLink_Insert( foodCategoryDataObject.getFoodCategoryId(), foodDataObject.getFoodId() );
                            dbLink.stopTransaction();
                            reload_food_items();
                            resize_col_tbl_food_list();
                            modelListFoodInCategory.reload( foodCategoryDataObject.getFoodCategoryId() );
                        }
                    }
                } catch ( SQLException e ) {

                }
            }
        }
    }

    private void process_evt_lst_categories( ListSelectionEvent e ) {
        if ( !e.getValueIsAdjusting() ) {
            if ( !listCategories.isSelectionEmpty() ) {
                FoodCategoryDataObject foodCategoryDataObject = ( FoodCategoryDataObject ) listCategories.getSelectedValue();
                String foodCategoryId = foodCategoryDataObject.getFoodCategoryId();
                modelListFoodInCategory.reload( foodCategoryId );
            }
        }
    }

    private void reload_tblmdl_nutrient_lookup() {
        NutrientDataObject nutrientDataObject = ( NutrientDataObject ) comboBoxNutrientLookupListNutrient.getSelectedItem();
        String text = textFieldNutrientLookup.getText();
        NumberCheck checkNumber = new NumberCheck();
        checkNumber.addToUncheckedList( text );
        if ( checkNumber.pass() ) {
            Double q = Double.parseDouble( text );
            modelTableNutrientLookup.reload( nutrientDataObject.getNutr_no(), q );
            resize_col_tbl_nutrient_lookup();
        } else {
            if ( !text.isEmpty() ) {
                Message.showMessage( "Character must be number." );
            }

        }
    }

    private void process_evt_btn_mix_food_add() {
        MixDataObject mix = ( MixDataObject ) cmb_mix.getSelectedItem();
        DefaultMutableTreeNode node = ( DefaultMutableTreeNode ) treeFoodList.getLastSelectedPathComponent();
        if ( node == null ) {
            return;
        }
        FoodDataObject food = ( FoodDataObject ) node.getUserObject();
        if ( node.isLeaf() ) {
            try {
                String mixid = mix.getMixId();
                dbLink.MixFood_Insert( mixid, food.getFoodId() );
                modelList_selected_food.reload( mixid );
                legend_generator.reload( mixid );
                reload_cbmdl_food( mixid );
            } catch ( SQLException e ) {

            }
        }
    }

    private void process_evt_btn_mix_food_delete() {
        if ( is_food_selected() ) {
            try {
                MixDataObject mix = ( MixDataObject ) cmb_mix.getSelectedItem();
                FoodDataObject foodDataObject = ( FoodDataObject ) lst_selected_food.getSelectedValue();
                String mixid = mix.getMixId();
                dbLink.MixFood_Delete( mixid, foodDataObject.getFoodId() );
                modelList_selected_food.reload( mixid );
                legend_generator.reload( mixid );
                reload_cbmdl_food( mixid );
                reload_tblmdl_constraints( mixid );
                reload_tblmdl_editor_results();
                reload_tblmdl_editor_rda_check();
                resize_col_tbl_editor_rda_check();
                resize_tbls_constraint();
                resize_tbl_editor_results();
            } catch ( SQLException e ) {

            }
        }
    }

    private void process_evt_btn_mix_food_expand() {
        int rowCount = treeFoodList.getRowCount();
        expand_all_nodes( treeFoodList, 0, rowCount );
    }

    private void expand_all_nodes( JTree tree, int startingIndex, int rowCount ) {
        for ( int i = startingIndex; i < rowCount; ++i ) {
            tree.expandRow( i );
        }
        if ( tree.getRowCount() != rowCount ) {
            expand_all_nodes( tree, rowCount, tree.getRowCount() );
        }
    }

    private void process_evt_btn_mix_food_collapse() {
        int rowCount = treeFoodList.getRowCount();
        for ( int i = 1; i < rowCount; i++ ) {
            treeFoodList.collapseRow( i );
        }
    }

    private void process_evt_btn_undo() {
        MixDataObject mix = ( MixDataObject ) cmb_mix.getSelectedItem();
        dbLink.revertTransaction();
        reload_lstmdl_mixes();
        int index = mdl_cmb_mix.find_by_mixid( mix.getMixId() );
        cmb_mix.setSelectedIndex( index );
        set_constraint_counts();
    }

    private void process_evt_btn_solve() {
        try {
            MixDataObject mix = ( MixDataObject ) cmb_mix.getSelectedItem();
            String mixid = mix.getMixId();
            txta_editor_model.setText( "" );
            LpModel lpModel = new LpModel();
            lpModel.setComponent( get_no_feasible_solution_panel() );
            //Add objective
            lpModel.addObjective( dbLink.objective_lhs( mixid ) );
            //Add nutrient constraint
            LinkedList<HashMap> nutrient_constraints = ( LinkedList ) dbLink.nutrient_rhs( mixid );
            nutrient_constraints.forEach( row ->
            {
                String nutrientid = ( String ) row.get( "NUTRIENTID" );
                Integer relationshipid = ( Integer ) row.get( "RELATIONSHIPID" );
                Double b = ( Double ) row.get( "B" );
                try {
                    lpModel.addConstraint( dbLink.nutrient_lhs( mixid, nutrientid, relationshipid ), relationshipid, b );
                } catch ( SQLException ex ) {
                }
            } );
            //Add food nutrient constraint
            LinkedList<HashMap> foodnutrientRhsList = ( LinkedList ) dbLink.foodnutrient_rhs( mixid );
            foodnutrientRhsList.forEach( row ->
            {
                String foodid = ( String ) row.get( "FOODID" );
                String nutrientid = ( String ) row.get( "NUTRIENTID" );
                Integer relationshipid = ( Integer ) row.get( "RELATIONSHIPID" );
                Double b = ( double ) row.get( "B" );
                try {
                    lpModel.addConstraint( dbLink.foodnutrient_lhs( mixid, foodid, nutrientid, relationshipid ), relationshipid, b );
                } catch ( SQLException ex ) {
                }
            } );
            //Add food nutrient ratio constraint
            LinkedList<HashMap> foodnutrientratioRhsList = ( LinkedList ) dbLink.foodnutrientratio_rhs( mixid );
            foodnutrientratioRhsList.forEach( row ->
            {
                String foodid1 = ( String ) row.get( "FOOD_ID_1" );
                String nutrientid1 = ( String ) row.get( "NUTRIENT_ID_1" );
                String foodid2 = ( String ) row.get( "FOOD_ID_2" );
                String nutrientid2 = ( String ) row.get( "NUTRIENT_ID_2" );
                int relationshipid = ( int ) row.get( "RELATIONSHIPID" );
                Double b = ( Double ) row.get( "B" );
                try {
                    lpModel.addConstraint( dbLink.foodnutrientratio_lhs( mixid, foodid1, nutrientid1, foodid2, nutrientid2, relationshipid ), relationshipid, b );
                } catch ( SQLException ex ) {
                }
            } );
            //Add nutrient ratio constraint
            LinkedList<HashMap> nutrientratioRhsList = ( LinkedList ) dbLink.nutrientratio_rhs( mixid );
            nutrientratioRhsList.forEach( row ->
            {
                String nutrientid1 = ( String ) row.get( "NUTRIENT_ID_1" );
                String nutrientid2 = ( String ) row.get( "NUTRIENT_ID_2" );
                int relationshipid = ( int ) row.get( "RELATIONSHIPID" );
                Double b = ( Double ) row.get( "B" );
                try {
                    lpModel.addConstraint( dbLink.nutrientratio_lhs( mixid, nutrientid1, nutrientid2, relationshipid ), relationshipid, b );
                } catch ( SQLException ex ) {
                }
            } );
            //Add percent of total nutrient constraint
            LinkedList<HashMap> percentnutrientRhsList = ( LinkedList ) dbLink.percentnutrient_rhs( mixid );
            percentnutrientRhsList.forEach( row ->
            {
                String foodid = ( String ) row.get( "FOODID" );
                String nutrientid = ( String ) row.get( "NUTRIENTID" );
                Integer relationshipid = ( Integer ) row.get( "RELATIONSHIPID" );;
                Double b = ( double ) row.get( "B" );
                try {
                    lpModel.addConstraint( dbLink.percentnutrient_lhs( mixid, foodid, nutrientid, b ), relationshipid, 0 );
                } catch ( SQLException ex ) {
                }
            } );
            String pattern = "yyyy-MMMMM-dd'_at_'HH-mm-ss";
            SimpleDateFormat dateFormat = new SimpleDateFormat( pattern );
            Date date = new Date();
            String stringDate = dateFormat.format( date );
            lpModel.setTitle( mix.getName() );
            lpModel.setDate( stringDate );
            lpModel.setVariables( get_food_legend( mixid ) );
            StringBuilder sbResults = new StringBuilder();
            StringBuilder sbAll = new StringBuilder();
            if ( lpModel.solve() ) {
                double objective_function_value = lpModel.getCost();
                double[] point = lpModel.getPoint();
                DecimalFormat formatter = new DecimalFormat( "####.###" );
                mdl_lst_high_score.addElement( formatter.format( objective_function_value ) );
                lst_high_score.ensureIndexIsVisible( mdl_lst_high_score.getSize() - 1 );
                lst_high_score.setSelectedIndex( lst_high_score.getLastVisibleIndex() );
                sbResults.append( lbl_min.getText() ).append( ": " ).append( formatter.format( objective_function_value ) );
                sbResults.append( "\n" );
                DecimalFormat formatter2 = new DecimalFormat( "####.###" );
                for ( int i = 0; i < point.length; i++ ) {
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
                LinkedList<HashMap> mixfoodlist = ( LinkedList ) dbLink.MixFood_Select( mixid );
                for ( int i = 0; i < mixfoodlist.size(); i++ ) {
                    HashMap row = mixfoodlist.get( i );
                    String foodid = ( String ) row.get( "FOODID" );
                    double v = point[ i ];
                    dbLink.MixFood_Update( mixid, foodid, v );
                }
                dbLink.fill_mixresult( mixid );
                dbLink.delete_mixresultdn( mixid );
                dbLink.fill_mixresultdn( mixid );
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
                dbLink.Mix_Update_Time( mixid );
                dbLink.Mix_Update_Other( mixid, sbAll.toString() );
                reload_tblmdl_editor_results();
                reload_tblmdl_editor_rda_check();
                reload_tblmdl_food_comparison();
                reload_tblmdl_mix_comparison();
                resize_col_tbl_editor_rda_check();
                resize_tbl_editor_results();
                dbLink.apportion( mixid );
                reload_lstmdl_mixes();
                int mix_index = mdl_cmb_mix.find_by_mixid( mixid );
                cmb_mix.setSelectedIndex( mix_index );
                dbLink.stopTransaction();
            } else {
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
                dbLink.Mix_Update_Time( mixid );
                dbLink.Mix_Update_Other( mixid, sbAll.toString() );
            }
            txta_editor_model.setText( sbAll.toString() );
            set_constraint_counts();

        } catch ( SQLException e ) {

        }
    }

    private String get_food_legend( String mixid )
            throws SQLException {
        StringBuilder sb = new StringBuilder();
        Object[] objects = legend_generator.toArray();
        int size = objects.length;
        for ( int i = 0; i < size; i++ ) {
            FoodDataObject food = ( FoodDataObject ) objects[ i ];
            sb.append( "x" );
            sb.append( i );
            sb.append( ": " );
            sb.append( food.getFoodName() );
            sb.append( "\n" );
        }
        if ( sb.length() > 0 ) {
            sb.setLength( sb.length() - 1 );
        }
        return sb.toString();
    }

    private void process_evt_btn_nutrient_constraint_add() {
        if ( is_it_ready_to_add_nutrient_constraint() ) {
            NumberCheck numberCheck = new NumberCheck();
            numberCheck.addToUncheckedList( textFieldNutrientConstraintQuantity.getText() );
            if ( numberCheck.pass() ) {
                try {
                    MixDataObject mix = ( MixDataObject ) cmb_mix.getSelectedItem();
                    NutrientDataObject nutrientDataObject = ( NutrientDataObject ) comboBoxNutrientConstraintNutrient.getSelectedItem();
                    RelationshipDataObject relationshipDataObject = ( RelationshipDataObject ) comboBoxNutrientConstraintRelationship.getSelectedItem();
                    double b = Double.parseDouble( textFieldNutrientConstraintQuantity.getText() );
                    dbLink.NutrientConstraint_Merge( mix.getMixId(), nutrientDataObject.getNutr_no(), relationshipDataObject.getRelationshipid(), b );
                    modelTableNutrientConstraints.reload( mix.getMixId() );
                    set_constraint_counts();
                    resize_col_tbl_nutrient_constraint();
                } catch ( SQLException e ) {

                }
            } else {
                Message.showMessage( "Value must be a number greater than or equal to zero" );
            }
        }
    }

    private Boolean is_it_ready_to_add_nutrient_constraint() {
        Boolean flag_isReady = false;
        Boolean flag_listNutrient = false;
        Boolean flag_listNutrientRelationship = false;
        Boolean flag_textFieldNutrientConstraint = false;
        if ( comboBoxNutrientConstraintNutrient.getSelectedIndex() != -1 ) {
            flag_listNutrient = true;
        } else {
            Message.showMessage( "Select nutrient" );
        }
        if ( comboBoxNutrientConstraintRelationship.getSelectedIndex() != -1 ) {
            flag_listNutrientRelationship = true;
        } else {
            Message.showMessage( "Select relationship" );
        }
        if ( !textFieldNutrientConstraintQuantity.getText().isEmpty() ) {
            flag_textFieldNutrientConstraint = true;
        } else {
            Message.showMessage( "Specify amount" );
        }
        if ( flag_listNutrient && flag_listNutrientRelationship && flag_textFieldNutrientConstraint ) {
            flag_isReady = true;
        }
        return flag_isReady;
    }

    private void process_evt_btn_nutrient_constraint_delete() {
        try {
            int selectedRow = tableNutrientConstraint.getSelectedRow();
            String mixid = ( String ) tableNutrientConstraint.getValueAt( selectedRow, 0 );
            String nutrientid = ( String ) tableNutrientConstraint.getValueAt( selectedRow, 1 );
            Integer relationshipid = ( Integer ) tableNutrientConstraint.getValueAt( selectedRow, 2 );
            dbLink.NutrientConstraint_Delete( mixid, nutrientid, relationshipid );
            modelTableNutrientConstraints.reload( mixid );
            set_constraint_counts();
            resize_col_tbl_nutrient_constraint();
        } catch ( SQLException e ) {

        }
    }

    private void process_evt_btn_food_nutrient_constraint_add() {
        if ( is_it_ready_to_add_food_nutrient_constraint() ) {
            NumberCheck numberCheck = new NumberCheck();
            numberCheck.addToUncheckedList( textFieldFoodNutrient_Quantity.getText() );
            if ( numberCheck.pass() ) {
                try {
                    MixDataObject mix = ( MixDataObject ) cmb_mix.getSelectedItem();
                    FoodDataObject foodDataObject = ( FoodDataObject ) comboBoxFoodNutrient_Food.getSelectedItem();
                    NutrientDataObject nutrientDataObject = ( NutrientDataObject ) comboBoxFoodNutrient_Nutrient.getSelectedItem();
                    RelationshipDataObject relationshipDataObject = ( RelationshipDataObject ) comboBoxFoodNutrient_Relationship.getSelectedItem();
                    double b = Double.parseDouble( textFieldFoodNutrient_Quantity.getText() );
                    dbLink.FoodNutrientConstraint_Merge( mix.getMixId(), foodDataObject.getFoodId(), nutrientDataObject.getNutr_no(), relationshipDataObject.getRelationshipid(), b );
                    modelTableFoodNutrientConstraints.reload( mix.getMixId() );
                    set_constraint_counts();
                    resize_col_tbl_food_nutrient_constraint();
                } catch ( SQLException e ) {

                }
            } else {
                Message.showMessage( "Value must be a number greater than or equal to zero" );
            }
        }
    }

    private void process_evt_btn_food_portion_add() {
        NumberCheck checkNumber = new NumberCheck();
        Double pcti = Double.NaN;
        checkNumber.addToUncheckedList( textfield_portion_pct.getText() );
        if ( checkNumber.pass() ) {
            MixDataObject mix = ( MixDataObject ) cmb_mix.getSelectedItem();
            String mixid = mix.getMixId();
            String foodid = (( FoodDataObject ) cmb_food_portion.getSelectedItem()).getFoodId();
            ArrayList selectedValuesList = ( ArrayList ) listPortionMeal.getSelectedValuesList();
            Double pct = Double.valueOf( textfield_portion_pct.getText() );
            int n = selectedValuesList.size();
            pcti = pct / n;
            Double remaining = Double.NaN;
            try {
                for ( Object o : selectedValuesList ) {
                    O_Meal meal = ( O_Meal ) o;
                    Integer mealid = meal.getMealid();
                    dbLink.MealFoodPortion_insert_and_calculate( mixid, mealid, foodid, pcti );
                }
                dbLink.stopTransaction();
                remaining = dbLink.calculate_remaining_percentage( mixid, foodid, precision );
            } catch ( SQLException e ) {
                e.printStackTrace();
            }
            reload_tblmdl_portion( mixid );
            reload_tblmdl_results_by_meal( mixid );
            resize_col_tbl_meal_portions();
            resize_col_tbl_results_by_meal_calories();
            resize_col_tbl_results_by_meal_grams();
            textfield_portion_remaining.setText( String.valueOf( remaining ) );
        } else {
            Message.showMessage( "Character must be number." );
        }
    }

    private Boolean is_it_ready_to_add_food_nutrient_constraint() {
        Boolean flag_isReady = false;
        Boolean flag_listFood = false;
        Boolean flag_listNutrient = false;
        Boolean flag_listRelationship = false;
        Boolean flag_quantity = false;
        if ( comboBoxFoodNutrient_Food.getSelectedIndex() != -1 ) {
            flag_listFood = true;
        } else {
            Message.showMessage( "Select food" );
        }
        if ( comboBoxFoodNutrient_Nutrient.getSelectedIndex() != -1 ) {
            flag_listNutrient = true;
        } else {
            Message.showMessage( "Select nutrient" );
        }
        if ( comboBoxFoodNutrient_Relationship.getSelectedIndex() != -1 ) {
            flag_listRelationship = true;
        } else {
            Message.showMessage( "Select relationship" );
        }
        if ( !textFieldFoodNutrient_Quantity.getText().isEmpty() ) {
            flag_quantity = true;
        } else {
            Message.showMessage( "Specify amount" );
        }
        if ( flag_listFood && flag_listNutrient && flag_listRelationship && flag_quantity ) {
            flag_isReady = true;
        }
        return flag_isReady;
    }

    private void resize_col_tbl_food_nutrient_constraint() {
        for ( int i = 0; i < 4; i++ ) {
            tableFoodNutrient.getColumnModel().getColumn( i ).setMinWidth( 0 );
            tableFoodNutrient.getColumnModel().getColumn( i ).setMaxWidth( 0 );
        }
        tableFoodNutrient.getColumnModel().getColumn( 4 ).setMinWidth( 480 );
        tableFoodNutrient.getColumnModel().getColumn( 5 ).setMinWidth( 250 );
        tableFoodNutrient.getColumnModel().getColumn( 6 ).setMinWidth( 21 );
        tableFoodNutrient.getColumnModel().getColumn( 6 ).setMaxWidth( 21 );
    }

    private void process_evt_btn_food_portion_update_weight() {
        JTextField input = new JTextField();
        input.setPreferredSize( new Dimension( 50, 25 ) );
        int selectedRow = tbl_meal_portions.getSelectedRow();
        if ( selectedRow != -1 ) {
            Double actualwt = ( Double ) tbl_meal_portions.getValueAt( selectedRow, 7 );
            input.setText( String.valueOf( actualwt ) );
            JPanel input_panel = new JPanel();
            input_panel.add( new JLabel( "Actual Weight: " ) );
            input_panel.add( input );
            JComponent[] inputs = new JComponent[] {
                input_panel
            };
            int optionValue = Message.showOptionDialogOkCancel( inputs, "Update Actual Weight" );
            if ( optionValue == 0 ) {
                try {
                    String mixid = ( String ) tbl_meal_portions.getValueAt( selectedRow, 0 );
                    Integer mealid = ( Integer ) tbl_meal_portions.getValueAt( selectedRow, 1 );
                    String foodid = ( String ) tbl_meal_portions.getValueAt( selectedRow, 2 );
                    dbLink.MealFoodPortion_update_actualwt( mixid, mealid, foodid, Double.valueOf( input.getText() ) );
                    dbLink.stopTransaction();
                    reload_tblmdl_portion( mixid );
                    reload_tblmdl_results_by_meal( mixid );
                    resize_col_tbl_meal_portions();
                    resize_col_tbl_results_by_meal_calories();
                    resize_col_tbl_results_by_meal_grams();
                } catch ( SQLException e ) {

                }
            }
        }
    }

    private void process_evt_btn_food_portion_delete() {
        int[] selectedRows = tbl_meal_portions.getSelectedRows();
        if ( selectedRows.length > 0 ) {
            String mixid = "";
            Integer mealid = -1;
            String foodid = "";
            Double remaining = Double.NaN;
            for ( int i = 0; i < selectedRows.length; i++ ) {
                int selectedRow = selectedRows[ i ];
                mixid = ( String ) tbl_meal_portions.getValueAt( selectedRow, 0 );
                mealid = ( Integer ) tbl_meal_portions.getValueAt( selectedRow, 1 );
                foodid = ( String ) tbl_meal_portions.getValueAt( selectedRow, 2 );
                try {
                    dbLink.MealFoodPortion_delete( mixid, mealid, foodid );
                } catch ( SQLException e ) {
                }
            }
            dbLink.stopTransaction();
            try {
                remaining = dbLink.calculate_remaining_percentage( mixid, foodid, precision );
            } catch ( SQLException e ) {
            }
            textfield_portion_remaining.setText( String.valueOf( remaining ) );
            int index_food = modelComboBox_PortionFood.find_by_foodid( foodid );
            int index_meal = modelList_PortionMeal.find_by_mealid( mealid );
            cmb_food_portion.setSelectedIndex( index_food );
            listPortionMeal.setSelectedIndex( index_meal );
            reload_tblmdl_portion( mixid );
            reload_tblmdl_results_by_meal( mixid );
            resize_col_tbl_meal_portions();
            resize_col_tbl_results_by_meal_calories();
            resize_col_tbl_results_by_meal_grams();
        } else {
            Message.showMessage( "Please select row or rows." );
        }
    }

    private void reload_tblmdl_portion( String mixid ) {
        modelTablePortion.reload( mixid );
    }

    private void reload_tblmdl_results_by_meal( String mixid ) {
        modelTableResultByMealsCalories.reload( mixid );
        modelTableResultByMealsGrams.reload( mixid );
    }

    private void process_evt_btn_food_nutrient_constraint_delete() {
        try {
            int selectedRow = tableFoodNutrient.getSelectedRow();
            if ( selectedRow != -1 ) {
                String mixid = ( String ) tableFoodNutrient.getValueAt( selectedRow, 0 );
                String foodid = ( String ) tableFoodNutrient.getValueAt( selectedRow, 1 );
                String nutrientid = ( String ) tableFoodNutrient.getValueAt( selectedRow, 2 );
                Integer relationshipid = ( Integer ) tableFoodNutrient.getValueAt( selectedRow, 3 );
                dbLink.FoodNutrientConstraint_Delete( mixid, foodid, nutrientid, relationshipid );
                modelTableFoodNutrientConstraints.reload( mixid );
                set_constraint_counts();
                resize_col_tbl_food_nutrient_constraint();
            }
        } catch ( SQLException e ) {

        }
    }

    private void process_evt_btn_nutrient_ratio_add() {
        if ( is_it_ready_to_add_nutrient_ratio_constraint() ) {
            NumberCheck numberCheck = new NumberCheck();
            numberCheck.addToUncheckedList( textFieldNutrientRatioNutrientA.getText() );
            numberCheck.addToUncheckedList( textFieldNutrientRatioNutrientB.getText() );
            if ( numberCheck.pass() ) {
                try {
                    MixDataObject mix = ( MixDataObject ) cmb_mix.getSelectedItem();
                    NutrientDataObject nutrientDataObjectA = ( NutrientDataObject ) comboBoxNutrientRatioNutrientA.getSelectedItem();
                    NutrientDataObject nutrientDataObjectB = ( NutrientDataObject ) comboBoxNutrientRatioNutrientB.getSelectedItem();
                    RelationshipDataObject relationshipDataObject = ( RelationshipDataObject ) comboBoxNutrientRatioRelationship.getSelectedItem();
                    Double a = Double.parseDouble( textFieldNutrientRatioNutrientA.getText() );
                    Double b = Double.parseDouble( textFieldNutrientRatioNutrientB.getText() );
                    dbLink.NutrientRatio_Merge( mix.getMixId(), nutrientDataObjectA.getNutr_no(), nutrientDataObjectB.getNutr_no(), relationshipDataObject.getRelationshipid(), a, b );
                    modelTableNutrientRatioConstraints.reload( mix.getMixId() );
                    resize_col_tbl_nutrient_ratio_constraint();
                    set_constraint_counts();
                } catch ( SQLException e ) {

                }
            } else {
                Message.showMessage( "Value must be a number greater than zero" );
            }
        }
    }

    private Boolean is_it_ready_to_add_nutrient_ratio_constraint() {
        Boolean flag_isReady = false;
        Boolean flag_listNutrientA = false;
        Boolean flag_listNutrientB = false;
        Boolean flag_quantityA = false;
        Boolean flag_quantityB = false;
        if ( comboBoxNutrientRatioNutrientA.getSelectedIndex() != -1 ) {
            flag_listNutrientA = true;
        } else {
            Message.showMessage( "Select nutrient A" );
        }
        if ( comboBoxNutrientRatioNutrientA.getSelectedIndex() != -1 ) {
            flag_listNutrientB = true;
        } else {
            Message.showMessage( "Select nutrient B" );
        }
        if ( !textFieldNutrientRatioNutrientA.getText().isEmpty() ) {
            flag_quantityA = true;
        } else {
            Message.showMessage( "Specify amount A" );
        }
        if ( !textFieldNutrientRatioNutrientB.getText().isEmpty() ) {
            flag_quantityB = true;
        } else {
            Message.showMessage( "Specify amount B" );
        }
        if ( flag_listNutrientA && flag_listNutrientB && flag_quantityA && flag_quantityB ) {
            flag_isReady = true;
        }
        return flag_isReady;
    }

    private void resize_col_tbl_nutrient_ratio_constraint() {
        for ( int i = 0; i < 4; i++ ) {
            tableNutrientRatio.getColumnModel().getColumn( i ).setMinWidth( 0 );
            tableNutrientRatio.getColumnModel().getColumn( i ).setMaxWidth( 0 );
        }
        //Columns missing on purpose
        tableNutrientRatio.getColumnModel().getColumn( 7 ).setMinWidth( 21 );
        tableNutrientRatio.getColumnModel().getColumn( 7 ).setMaxWidth( 21 );
    }

    private void resize_col_tbl_food_comparison() {
        tbl_food_comparison.getColumnModel().getColumn( 0 ).setMinWidth( 120 );
        tbl_food_comparison.getColumnModel().getColumn( 1 ).setMinWidth( 250 );
        for ( int i = 2; i < 5; i++ ) {
            tbl_food_comparison.getColumnModel().getColumn( i ).setMinWidth( 75 );
        }
    }

    private void resize_col_tbl_mix_comparison() {
        tbl_mix_comparison.getColumnModel().getColumn( 0 ).setMinWidth( 120 );
        tbl_mix_comparison.getColumnModel().getColumn( 1 ).setMinWidth( 250 );
        for ( int i = 2; i < 5; i++ ) {
            tbl_mix_comparison.getColumnModel().getColumn( i ).setMinWidth( 70 );
        }
    }

    private void resize_col_tbl_editor_rda_check() {
        tbl_results_rda.getColumnModel().getColumn( 0 ).setMinWidth( 0 );
        tbl_results_rda.getColumnModel().getColumn( 0 ).setMaxWidth( 0 );
        tbl_results_rda.getColumnModel().getColumn( 1 ).setMinWidth( 310 );
        for ( int i = 2; i < 7; i++ ) {
            tbl_results_rda.getColumnModel().getColumn( i ).setMinWidth( 70 );
        }
    }

    private void resize_col_tbl_nutrient_lookup() {
        tableNutrientLookup.getColumnModel().getColumn( 0 ).setMinWidth( 550 );
        tableNutrientLookup.getColumnModel().getColumn( 1 ).setMinWidth( 70 );
        tableNutrientLookup.getColumnModel().getColumn( 2 ).setMinWidth( 70 );
    }

    private void resize_col_tbl_nutrient_input() {
        tbl_nutrient_input.getColumnModel().getColumn( 0 ).setMinWidth( 0 );
        tbl_nutrient_input.getColumnModel().getColumn( 0 ).setMaxWidth( 0 );
    }

    private void resize_col_tbl_check_coefficients() {
        tableCheckCoefficients.getColumnModel().getColumn( 0 ).setMinWidth( 0 );
        tableCheckCoefficients.getColumnModel().getColumn( 0 ).setMaxWidth( 0 );
    }

    private void resize_col_tbl_food_list() {
        tableFoodList01.getColumnModel().getColumn( 0 ).setMinWidth( 0 );
        tableFoodList01.getColumnModel().getColumn( 0 ).setMaxWidth( 0 );
        tableFoodList01.getColumnModel().getColumn( 1 ).setMinWidth( 350 );
        tableFoodList01.getColumnModel().getColumn( 16 ).setMinWidth( 90 );
    }

    private void process_evt_btn_nutrient_ratio_delete() {
        try {
            int selectedRow = tableNutrientRatio.getSelectedRow();
            String mixid = ( String ) tableNutrientRatio.getValueAt( selectedRow, 0 );
            String nutrientidA = ( String ) tableNutrientRatio.getValueAt( selectedRow, 1 );
            String nutrientidB = ( String ) tableNutrientRatio.getValueAt( selectedRow, 2 );
            Integer relationshipid = ( Integer ) tableNutrientRatio.getValueAt( selectedRow, 3 );
            dbLink.NutrientRatio_Delete( mixid, nutrientidA, nutrientidB, relationshipid );
            modelTableNutrientRatioConstraints.reload( mixid );
            set_constraint_counts();
            resize_col_tbl_nutrient_ratio_constraint();
        } catch ( SQLException e ) {

        }
    }

    private void process_evt_btn_food_nutrient_ratio_add() {
        if ( is_it_ready_to_add_food_nutrient_ratio_constraint() ) {
            NumberCheck numberCheck = new NumberCheck();
            numberCheck.addToUncheckedList( textFieldFoodNutrientRatioQuantityA.getText() );
            numberCheck.addToUncheckedList( textFieldFoodNutrientRatioQuantityB.getText() );
            if ( numberCheck.pass() ) {
                try {
                    MixDataObject mix = ( MixDataObject ) cmb_mix.getSelectedItem();
                    FoodDataObject foodDataObjectA = ( FoodDataObject ) comboBoxFoodNutrientRatioFoodA.getSelectedItem();
                    NutrientDataObject nutrientDataObjectA = ( NutrientDataObject ) comboBoxFoodNutrientRatioNutrientA.getSelectedItem();
                    FoodDataObject foodDataObjectB = ( FoodDataObject ) comboBoxFoodNutrientRatioFoodB.getSelectedItem();
                    NutrientDataObject nutrientDataObjectB = ( NutrientDataObject ) comboBoxFoodNutrientRatioNutrientB.getSelectedItem();
                    Double a = Double.parseDouble( textFieldFoodNutrientRatioQuantityA.getText() );
                    Double b = Double.parseDouble( textFieldFoodNutrientRatioQuantityB.getText() );
                    RelationshipDataObject relationshipDataObject = ( RelationshipDataObject ) comboBoxFoodNutrientRatioRelationship.getSelectedItem();
                    dbLink.FoodNutrientRatio_Merge( mix.getMixId(), foodDataObjectA.getFoodId(), nutrientDataObjectA.getNutr_no(), foodDataObjectB.getFoodId(), nutrientDataObjectB.getNutr_no(), relationshipDataObject.getRelationshipid(), a, b );
                    modelTableFoodNutrientRatioConstraints.reload( mix.getMixId() );
                    set_constraint_counts();
                } catch ( SQLException e ) {

                }
            } else {
                Message.showMessage( "Value must be number greater than zero" );
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
        if ( comboBoxFoodNutrientRatioFoodA.getSelectedIndex() != -1 ) {
            flag_listFoodA = true;
        } else {
            Message.showMessage( "Select food A" );
        }
        if ( comboBoxFoodNutrientRatioNutrientA.getSelectedIndex() != -1 ) {
            flag_listNutrientA = true;
        } else {
            Message.showMessage( "Select nutrient A" );
        }
        if ( !textFieldFoodNutrientRatioQuantityA.getText().isEmpty() ) {
            flag_quantityA = true;
        } else {
            Message.showMessage( "Specify amount A" );
        }
        if ( comboBoxFoodNutrientRatioFoodB.getSelectedIndex() != -1 ) {
            flag_listFoodB = true;
        } else {
            Message.showMessage( "Select food B" );
        }
        if ( comboBoxFoodNutrientRatioNutrientB.getSelectedIndex() != -1 ) {
            flag_listNutrientB = true;
        } else {
            Message.showMessage( "Select nutrient B" );
        }
        if ( !textFieldFoodNutrientRatioQuantityB.getText().isEmpty() ) {
            flag_quantityB = true;
        } else {
            Message.showMessage( "Specify amount B" );
        }
        if ( flag_listFoodA && flag_listNutrientA && flag_quantityA && flag_listFoodB && flag_listNutrientB && flag_quantityB ) {
            flag_isReady = true;
        }
        return flag_isReady;
    }

    private void resize_col_tbl_food_nutrient_ratio_constraint() {
        for ( int i = 0; i < 6; i++ ) {
            tableFoodNutrientRatio.getColumnModel().getColumn( i ).setMinWidth( 0 );
            tableFoodNutrientRatio.getColumnModel().getColumn( i ).setMaxWidth( 0 );
        }
        //Columns missing on purpose
        tableFoodNutrientRatio.getColumnModel().getColumn( 11 ).setMinWidth( 21 );
        tableFoodNutrientRatio.getColumnModel().getColumn( 11 ).setMaxWidth( 21 );
    }

    private void process_evt_btn_food_nutrient_ratio_delete() {
        try {
            int selectedRow = tableFoodNutrientRatio.getSelectedRow();
            if ( selectedRow != -1 ) {
                String mixid = ( String ) tableFoodNutrientRatio.getValueAt( selectedRow, 0 );
                String foodidA = ( String ) tableFoodNutrientRatio.getValueAt( selectedRow, 1 );
                String nutrientidA = ( String ) tableFoodNutrientRatio.getValueAt( selectedRow, 2 );
                String foodidB = ( String ) tableFoodNutrientRatio.getValueAt( selectedRow, 3 );
                String nutrientidB = ( String ) tableFoodNutrientRatio.getValueAt( selectedRow, 4 );
                Integer relationshipid = ( Integer ) tableFoodNutrientRatio.getValueAt( selectedRow, 5 );
                dbLink.FoodNutrientRatio_Delete( mixid, foodidA, nutrientidA, foodidB, nutrientidB, relationshipid );
                modelTableFoodNutrientRatioConstraints.reload( mixid );
                set_constraint_counts();
            }
        } catch ( SQLException e ) {

        }
    }

    private boolean is_food_selected() {
        return !lst_selected_food.isSelectionEmpty();
    }

    private boolean is_list_food_compare_a_selected() {
        return !lst_food_compare_a.isSelectionEmpty();
    }

    private boolean is_list_food_compare_b_selected() {
        return !lst_food_compare_b.isSelectionEmpty();
    }

    private boolean is_list_mix_compare_a_selected() {
        return !lst_mix_compare_a.isSelectionEmpty();
    }

    private boolean is_list_mix_compare_b_selected() {
        return !lst_mix_compare_b.isSelectionEmpty();
    }

    private void process_evt_btn_categories_add() {
        JTextField input = new JTextField();
        JComponent[] inputs = new JComponent[] {
            new JLabel( "What is your new category name?" ),
            input
        };
        int optionValue = Message.showOptionDialog( inputs, "New Category" );
        if ( optionValue == 0 ) {
            String category_name = input.getText();
            if ( category_name != null && category_name.length() > 0 ) {
                try {
                    dbLink.FoodCategory_Insert_2( category_name );
                    dbLink.stopTransaction();
                    modelListCategory.reload();
                    reload_food_items();
                    resize_col_tbl_food_list();
                } catch ( SQLException e ) {

                }
            }
        }
    }

    private void process_evt_btn_categories_rename() {
        if ( !listCategories.isSelectionEmpty() ) {
            JTextField input = new JTextField();
            JComponent[] inputs = new JComponent[] {
                new JLabel( "What is your new category name?" ),
                input
            };
            int optionValue = Message.showOptionDialog( inputs, "Update Category" );
            if ( optionValue == 0 ) {
                String category_name = input.getText();
                if ( category_name != null && category_name.length() > 0 ) {
                    try {
                        FoodCategoryDataObject foodCategoryDataObject = ( FoodCategoryDataObject ) listCategories.getSelectedValue();
                        String foodCategoryId = foodCategoryDataObject.getFoodCategoryId();
                        dbLink.FoodCategory_Update( foodCategoryId, category_name );
                        dbLink.stopTransaction();
                        modelListCategory.reload();
                        reload_food_items();
                        resize_col_tbl_food_list();
                    } catch ( SQLException e ) {

                    }
                }
            }
        }
    }

    private void process_evt_btn_categories_delete() {
        if ( !listCategories.isSelectionEmpty() ) {
            try {
                FoodCategoryDataObject foodCategoryDataObject = ( FoodCategoryDataObject ) listCategories.getSelectedValue();
                String foodCategoryId = foodCategoryDataObject.getFoodCategoryId();
                dbLink.FoodCategory_Delete( foodCategoryId );
                dbLink.stopTransaction();
                modelListCategory.reload();
                reload_food_items();
                resize_col_tbl_food_list();
                modelListFoodInCategory.reload( "-1" );
            } catch ( SQLException e ) {

            }
        }
    }

    private void open_url( String url ) {
        try {
            Desktop.getDesktop().browse( new URL( url ).toURI() );
        } catch ( IOException | URISyntaxException e ) {

        }
    }

    private void process_evt_mnui_glycemic_load() {
        FormLayout layout = new FormLayout( "min,30dlu", //columns
                                            "min,16dlu" //rows
        );
        JPanel input_panel = new JPanel();
        input_panel.setLayout( layout );
        JTextField txt_gi = new JTextField();
        JTextField txt_digestible_carbs = new JTextField();
        JLabel digestiblel_carbs_label = new JLabel( "How many digestible carbs (g) in food item? " );
        JLabel gi_label = new JLabel( "What is glycemic index of food item? " );
        digestiblel_carbs_label.setHorizontalAlignment( JLabel.RIGHT );
        gi_label.setHorizontalAlignment( JLabel.RIGHT );
        input_panel.add( digestiblel_carbs_label, cc.xy( 1, 1 ) );
        input_panel.add( txt_digestible_carbs, cc.xy( 2, 1 ) );
        input_panel.add( gi_label, cc.xy( 1, 2 ) );
        input_panel.add( txt_gi, cc.xy( 2, 2 ) );
        JComponent[] inputs = new JComponent[] {
            input_panel
        };
        int optionValue = Message.showOptionDialogOkCancel( inputs, "Glycemic Load" );
        if ( optionValue == 0 ) {
            String strGI = txt_gi.getText();
            String strCarbs = txt_digestible_carbs.getText();
            if ( strGI != null && strGI.length() > 0 ) {
                if ( strCarbs != null && strCarbs.length() > 0 ) {
                    StringBuilder sb = new StringBuilder();
                    NumberCheck checkNumber = new NumberCheck();
                    checkNumber.addToUncheckedList( strGI );
                    checkNumber.addToUncheckedList( strCarbs );
                    if ( checkNumber.pass() ) {
                        Double gi = Double.valueOf( strGI );
                        Double carbs = Double.valueOf( strCarbs );
                        double gl = new GlycemicLoad( gi, carbs ).getGlycemicLoad();
                        sb.append( "The glycemic load is " );
                        sb.append( gl );
                        sb.append( " grams." );
                        String_display_component component = new String_display_component();
                        component.setText( sb.toString() );
                        component.setPreferredSize( new Dimension( 0, 40 ) );
                        inputs = new JComponent[ 1 ];
                        inputs[ 0 ] = component;
                        Message.showOptionDialog( inputs, "Glycemic Load" );
                    }
                }
            }
        }
    }

    private void process_evt_mnui_n3_fatty_acid_recommendations() {
        JTextField input = new JTextField();
        JPanel input_panel = new JPanel();
        input.setPreferredSize( new Dimension( 50, 25 ) );
        input_panel.add( new JLabel( "What is your optimal calorie intake?" ) );
        input_panel.add( input );
        JComponent[] inputs = new JComponent[] {
            input_panel
        };
        int optionValue = Message.showOptionDialogOkCancel( inputs, "Alpha-Linolenic Acid (ALA)" );
        if ( optionValue == 0 ) {
            String s = input.getText();
            if ( s != null && s.length() > 0 ) {
                StringBuilder sb = new StringBuilder();
                NumberCheck checkNumber = new NumberCheck();
                checkNumber.addToUncheckedList( s );
                if ( checkNumber.pass() ) {
                    Double energy_in_kcal = Double.valueOf( s );
                    final Alpha_linolenic_acid_required n3_fatty_acid_recommendation = new Alpha_linolenic_acid_required( energy_in_kcal );
                    BigDecimal ala_low = n3_fatty_acid_recommendation.get_low_in_grams();
                    BigDecimal ala_high = n3_fatty_acid_recommendation.get_high_in_grams();
                    sb.append( "Alpha-linolenic acid (ALA) required is between " );
                    sb.append( ala_low.setScale( 1, RoundingMode.HALF_UP ) );
                    sb.append( " and " );
                    sb.append( ala_high.setScale( 1, RoundingMode.HALF_UP ) );
                    sb.append( " grams." );
                    String_display_component component = new String_display_component();
                    component.setText( sb.toString() );
                    component.setPreferredSize( new Dimension( 415, 40 ) );
                    inputs = new JComponent[ 1 ];
                    inputs[ 0 ] = component;
                    Message.showOptionDialog( inputs, "Alpha-Linolenic Acid (ALA)" );
                } else {
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
        sbPanel1.append( get_text_no_feasible_solution() );
        StringBuilder sbPanel2 = new StringBuilder();
        sbPanel2.append( "One or more of these constraints makes the solution unfeasible." );
        sbPanel2.append( "\n\n" );
        sbPanel2.append( show_constraints() );
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

    private String show_constraints() {
        StringBuilder sb = new StringBuilder();
        sb.append( get_text_nutrient_constraint() );
        sb.append( get_text_food_nutrient_constraint() );
        sb.append( get_text_nutrient_ratio() );
        sb.append( get_text_food_nutrient_ratio() );
        sb.append( get_text_nutrient_percent_constraint() );
        return sb.toString();
    }

    private String get_text_nutrient_ratio() {
        StringBuilder sb = new StringBuilder();
        if ( tableNutrientRatio.getRowCount() > 0 ) {
            sb.append( "Nutrient Ratio Constraint" );
            sb.append( "\n" );
            sb.append( "---------------------------------------" );
            sb.append( "\n" );
            for ( int i = 0; i < tableNutrientRatio.getRowCount(); i++ ) {
                String nutrientA = ( String ) tableNutrientRatio.getValueAt( i, 4 );
                String nutrientB = ( String ) tableNutrientRatio.getValueAt( i, 5 );
                Double a = ( Double ) tableNutrientRatio.getValueAt( i, 6 );
                String rel = ( String ) tableNutrientRatio.getValueAt( i, 7 );
                Double b = ( Double ) tableNutrientRatio.getValueAt( i, 8 );
                sb.append( nutrientA );
                sb.append( "\n" );
                sb.append( a );
                sb.append( "\n" );
                sb.append( rel );
                sb.append( "\n" );
                sb.append( nutrientB );
                sb.append( "\n" );
                sb.append( b );
                sb.append( "\n\n" );
            }
            sb.append( "\n" );
        }
        return sb.toString();
    }

    private String get_text_food_nutrient_ratio() {
        StringBuilder sb = new StringBuilder();
        if ( tableFoodNutrientRatio.getRowCount() > 0 ) {
            sb.append( "Food Ratio Constraint" );
            sb.append( "\n" );
            sb.append( "----------------------------------" );
            sb.append( "\n" );
            for ( int i = 0; i < tableFoodNutrientRatio.getRowCount(); i++ ) {
                String foodA = ( String ) tableFoodNutrientRatio.getValueAt( i, 6 );
                String nutrientA = ( String ) tableFoodNutrientRatio.getValueAt( i, 7 );
                String foodB = ( String ) tableFoodNutrientRatio.getValueAt( i, 8 );
                String nutrientB = ( String ) tableFoodNutrientRatio.getValueAt( i, 9 );
                Double a = ( Double ) tableFoodNutrientRatio.getValueAt( i, 10 );
                String rel = ( String ) tableFoodNutrientRatio.getValueAt( i, 11 );
                Double b = ( Double ) tableFoodNutrientRatio.getValueAt( i, 12 );
                sb.append( foodA );
                sb.append( "\n" );
                sb.append( nutrientA );
                sb.append( "\n" );
                sb.append( a );
                sb.append( "\n" );
                sb.append( rel );
                sb.append( "\n" );
                sb.append( foodB );
                sb.append( "\n" );
                sb.append( nutrientB );
                sb.append( "\n" );
                sb.append( b );
                sb.append( "\n\n" );
            }
            sb.append( "\n" );
        }
        return sb.toString();
    }

    private String get_text_nutrient_percent_constraint() {
        StringBuilder sb = new StringBuilder();
        if ( tableNutrientPercent.getRowCount() > 0 ) {
            sb.append( "Nutrient Percent Constraint" );
            sb.append( "\n" );
            sb.append( "--------------------------" );
            sb.append( "\n" );
            for ( int i = 0; i < tableNutrientPercent.getRowCount(); i++ ) {
                String food = ( String ) tableNutrientPercent.getValueAt( i, 4 );
                String nutrient = ( String ) tableNutrientPercent.getValueAt( i, 5 );
                String relationship = ( String ) tableNutrientPercent.getValueAt( i, 6 );
                Double value = ( Double ) tableNutrientPercent.getValueAt( i, 7 );
                sb.append( food );
                sb.append( "\n" );
                sb.append( nutrient );
                sb.append( "\n" );
                sb.append( relationship );
                sb.append( " " );
                sb.append( value );
                sb.append( "\n\n" );
            }
            sb.append( "\n" );
        }
        return sb.toString();
    }

    private String get_text_food_nutrient_constraint() {
        StringBuilder sb = new StringBuilder();
        if ( tableFoodNutrient.getRowCount() > 0 ) {
            sb.append( "Food Constraint" );
            sb.append( "\n" );
            sb.append( "-------------------------" );
            sb.append( "\n" );
            for ( int i = 0; i < tableFoodNutrient.getRowCount(); i++ ) {
                String food = ( String ) tableFoodNutrient.getValueAt( i, 4 );
                String nutrient = ( String ) tableFoodNutrient.getValueAt( i, 5 );
                String equality = ( String ) tableFoodNutrient.getValueAt( i, 6 );
                Double value = ( Double ) tableFoodNutrient.getValueAt( i, 7 );
                sb.append( food );
                sb.append( "\n" );
                sb.append( nutrient );
                sb.append( "\n" );
                sb.append( equality );
                sb.append( " " );
                sb.append( value );
                sb.append( "\n\n" );
            }
            sb.append( "\n" );
        }
        return sb.toString();
    }

    private String get_text_nutrient_constraint() {
        StringBuilder sb = new StringBuilder();
        if ( tableNutrientConstraint.getRowCount() > 0 ) {
            sb.append( "Nutrient Constraint" );
            sb.append( "\n" );
            sb.append( "------------------------------" );
            sb.append( "\n" );
            for ( int i = 0; i < tableNutrientConstraint.getRowCount(); i++ ) {
                String nutrient = ( String ) tableNutrientConstraint.getValueAt( i, 3 );
                String equality = ( String ) tableNutrientConstraint.getValueAt( i, 4 );
                Double value = ( Double ) tableNutrientConstraint.getValueAt( i, 5 );
                sb.append( nutrient );
                sb.append( "\n" );
                sb.append( equality );
                sb.append( " " );
                sb.append( value );
                sb.append( "\n\n" );
            }
            sb.append( "\n" );
        }
        return sb.toString();
    }

    private String get_text_no_feasible_solution() {
        StringBuilder sb = new StringBuilder();
        for ( int i = 0; i < 8; i++ ) {
            sb.append( "\n" );
        }
        for ( int i = 0; i < 83; i++ ) {
            sb.append( " " );
        }
        sb.append( "No Feasible Solution" );
        sb.append( "\n\n" );
        for ( int i = 0; i < 83; i++ ) {
            sb.append( " " );
        }
        sb.append( "Things you can try:" );
        sb.append( "\n\n" );
        for ( int i = 0; i < 83; i++ ) {
            sb.append( " " );
        }
        sb.append( "1. Delete a constraint" );
        sb.append( "\n\n" );
        for ( int i = 0; i < 83; i++ ) {
            sb.append( " " );
        }
        sb.append( "2. Add a food item" );
        return sb.toString();
    }

    //todo - delete
    private String show_constraints_count() {
        StringBuilder sb = new StringBuilder();
        sb.append( get_text_nutrient_constraint_count() );
        sb.append( get_text_nutrient_percent_constraint_count() );
        sb.append( get_text_food_constraint_count() );
        sb.append( get_text_food_ratio_count() );
        sb.append( get_text_nutrient_ratio_count() );
        return sb.toString();
    }

    private String get_text_nutrient_ratio_count() {
        StringBuilder sb = new StringBuilder();
        sb.append( tableNutrientRatio.getRowCount() );
        return sb.toString();
    }

    private String get_text_food_ratio_count() {
        StringBuilder sb = new StringBuilder();
        sb.append( tableFoodNutrientRatio.getRowCount() );
        return sb.toString();
    }

    private String get_text_nutrient_percent_constraint_count() {
        StringBuilder sb = new StringBuilder();
        sb.append( tableNutrientPercent.getRowCount() );
        return sb.toString();
    }

    private String get_text_food_constraint_count() {
        StringBuilder sb = new StringBuilder();
        sb.append( tableFoodNutrient.getRowCount() );
        return sb.toString();
    }

    private String get_text_nutrient_constraint_count() {
        StringBuilder sb = new StringBuilder();
        sb.append( tableNutrientConstraint.getRowCount() );
        return sb.toString();
    }

    private void process_evt_mnui_export_model() {
        fileChooser.setAcceptAllFileFilterUsed( false );
        fileChooser.addChoosableFileFilter( new FileNameExtensionFilter( "Xml Document", "xml" ) );
        StringBuilder sb = new StringBuilder();
        sb.append( System.getProperty( "user.dir" ) );
        sb.append( File.separator );
        sb.append( "model" );
        sb.append( File.separator );
        sb.append( "export.xml" );
        fileChooser.setSelectedFile( new File( sb.toString() ) );
        int returnVal = fileChooser.showSaveDialog( frame );
        if ( returnVal == JFileChooser.APPROVE_OPTION ) {
            File file = fileChooser.getSelectedFile();
            String path = file.getAbsolutePath();
            switch ( main_tabbed_pane.getSelectedIndex() ) {
                case 0:
                    frame.setCursor( Cursor.getPredefinedCursor( Cursor.WAIT_CURSOR ) );
                    MixDataObject mix = ( MixDataObject ) cmb_mix.getSelectedItem();
                    Xml_send send = new Xml_send( dbLink, mix.getMixId(), path );
                    frame.setCursor( Cursor.getPredefinedCursor( Cursor.DEFAULT_CURSOR ) );
                    show_message_sent( path );
                    break;
            }
        }
    }

    private void show_message_sent( String path ) {
        String_display_component label = new String_display_component();
        label.setPreferredSize( new Dimension( 320, 40 ) );
        StringBuilder sb = new StringBuilder();
        sb.append( "Document saved to\n" );
        sb.append( path );
        label.setText( sb.toString() );
        JComponent[] inputs = new JComponent[] {
            label
        };
        Message.showOptionDialog( inputs, "Data Exchange" );
    }

    private int process_evt_mnui_import_model() {
        fileChooser.setAcceptAllFileFilterUsed( false );
        fileChooser.addChoosableFileFilter( new FileNameExtensionFilter( "Xml Document", "xml" ) );
        fileChooser.setSelectedFile( new File( "" ) );
        int returnVal = fileChooser.showOpenDialog( frame );
        if ( returnVal == JFileChooser.APPROVE_OPTION ) {
            File file = fileChooser.getSelectedFile();
            String path = file.getAbsolutePath();
            fileChooser.setCurrentDirectory( new File( path ) );
            HashSet set_without = new HashSet();
            HashSet set_with = new HashSet();
            final int old_size = mdl_cmb_mix.getSize();
            for ( int i = 0; i < old_size; i++ ) {
                MixDataObject o = ( MixDataObject ) mdl_cmb_mix.getElementAt( i );
                set_without.add( o.getMixId() );
            }
            Xml_receive receive = new Xml_receive( dbLink );
            receive.import_snack_data( path );
            reload_lstmdl_mixes();
            reload_food_items();
            resize_col_tbl_food_list();
            modelListCategory.reload();
            for ( int i = 0; i < mdl_cmb_mix.getSize(); i++ ) {
                MixDataObject o = ( MixDataObject ) mdl_cmb_mix.getElementAt( i );
                set_with.add( o.getMixId() );
            }
            if ( set_with.removeAll( set_without ) ) {
                if ( !set_with.isEmpty() ) {
                    int index = mdl_cmb_mix.find_by_mixid( ( String ) set_with.toArray()[ 0 ] );
                    cmb_mix.setSelectedIndex( index );
                }
            } else {
                cmb_mix.setSelectedIndex( 0 );
            }
        }
        return returnVal;
    }

    private void process_evt_mnui_show_mix_stats() {
        String_display_component component = new String_display_component();
        component.setPreferredSize( new Dimension( 310, 130 ) );
        JComponent[] inputs = new JComponent[ 1 ];
        inputs[ 0 ] = component;
        switch ( main_tabbed_pane.getSelectedIndex() ) {
            case 0:
                MixDataObject mix = ( MixDataObject ) cmb_mix.getSelectedItem();
                stringModelMixPct.reload( mix.getMixId() );
                component.setText( stringModelMixPct.get_mix_stats() );
                Message.showOptionDialog( inputs, "Macronutrient Percentages" );
                break;
        }
    }

    private void process_evt_btn_cost() {
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
        if ( optionValue == 0 ) {
            String s0 = fld_price.getText();
            String s1 = fld_total_weight.getText();
            if ( (s0 != null && s0.length() > 0) && (s1 != null && s1.length() > 0) ) {
                checkNumber.addToUncheckedList( s0 );
                if ( checkNumber.pass() ) {
                    Double price = Double.valueOf( fld_price.getText() );
                    Double total_weight = Double.valueOf( fld_total_weight.getText() );
                    //model row index is specified by sql query.
                    int model_column_index = 3;
                    int model_row_index_weight = modelTableNutrientInput.find( "10000" );
                    int model_row_index_cost = modelTableNutrientInput.find( "10005" );
                    Double weight = ( Double ) modelTableNutrientInput.getValueAt( model_row_index_weight, model_column_index );
                    Double cost = (price / total_weight) * weight;
                    modelTableNutrientInput.setValueAt( cost, model_row_index_cost, model_column_index );
                    select_table_row_using_model( tbl_nutrient_input, model_row_index_cost );
                    scroll_to_row_using_model( tbl_nutrient_input, model_row_index_cost );
                } else {
                    Message.showMessage( "Numbers only" );
                }
            }
        }
    }
}
