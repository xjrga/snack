package io.github.xjrga.snack.gui;

import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;
import io.github.xjrga.snack.csv.DriReport;
import io.github.xjrga.snack.csv.FoodComparisonReport;
import io.github.xjrga.snack.csv.MealPlanCaloriesReport;
import io.github.xjrga.snack.csv.MealPlanMacronutrientsReport;
import io.github.xjrga.snack.csv.MealPlanPortionsReport;
import io.github.xjrga.snack.csv.MealPlanUsageReport;
import io.github.xjrga.snack.csv.MixComparisonReport;
import io.github.xjrga.snack.csv.MixResultsReport;
import io.github.xjrga.snack.csv.MixResultsReport2;
import io.github.xjrga.snack.csv.NutrientContentReport;
import io.github.xjrga.snack.database.Connect;
import io.github.xjrga.snack.database.callable.BackgroundExec;
import io.github.xjrga.snack.database.callable.FoodCreator;
import io.github.xjrga.snack.database.callable.delete.DeleteAllFoodCategoriesTask;
import io.github.xjrga.snack.database.callable.delete.DeleteAllFoodsTask;
import io.github.xjrga.snack.database.callable.delete.DeleteAllMixesTask;
import io.github.xjrga.snack.database.callable.delete.DeleteCategoryLinkTask;
import io.github.xjrga.snack.database.callable.delete.DeleteCategoryTask;
import io.github.xjrga.snack.database.callable.delete.DeleteFoodPortionTask;
import io.github.xjrga.snack.database.callable.delete.DeleteFoodQuantityConstraintTask;
import io.github.xjrga.snack.database.callable.delete.DeleteFoodRatioConstraintTask;
import io.github.xjrga.snack.database.callable.delete.DeleteFoodTask;
import io.github.xjrga.snack.database.callable.delete.DeleteMealPlanUsageTask;
import io.github.xjrga.snack.database.callable.delete.DeleteMealTask;
import io.github.xjrga.snack.database.callable.delete.DeleteMixFoodTask;
import io.github.xjrga.snack.database.callable.delete.DeleteMixTask;
import io.github.xjrga.snack.database.callable.delete.DeleteNutrientQuantityConstraintTask;
import io.github.xjrga.snack.database.callable.delete.DeleteNutrientRatioConstraintTask;
import io.github.xjrga.snack.database.callable.insert.CreateMealTask;
import io.github.xjrga.snack.database.callable.insert.CreateMixTask;
import io.github.xjrga.snack.database.callable.insert.InsertAndCalculateFoodPortionTask;
import io.github.xjrga.snack.database.callable.insert.InsertCategoryTask;
import io.github.xjrga.snack.database.callable.insert.InsertFoodCategoryLinkTask;
import io.github.xjrga.snack.database.callable.insert.InsertMixFoodTask;
import io.github.xjrga.snack.database.callable.insert.MergeFoodQuantityConstraintTask;
import io.github.xjrga.snack.database.callable.insert.MergeFoodRatioConstraintTask;
import io.github.xjrga.snack.database.callable.insert.MergeMealPlanUsageTask;
import io.github.xjrga.snack.database.callable.insert.MergeNutrientQuantityConstraintTask;
import io.github.xjrga.snack.database.callable.insert.MergeNutrientRatioConstraintTask;
import io.github.xjrga.snack.database.callable.other.AllocateTask;
import io.github.xjrga.snack.database.callable.other.DenormalizeFoodFactsTask;
import io.github.xjrga.snack.database.callable.other.DuplicateMixTask;
import io.github.xjrga.snack.database.callable.other.ExportMixTask;
import io.github.xjrga.snack.database.callable.other.PinMixTask;
import io.github.xjrga.snack.database.callable.other.SendCategoryToXmlTask;
import io.github.xjrga.snack.database.callable.select.DerivedFoodFactsTask;
import io.github.xjrga.snack.database.callable.select.DriDifferenceTask;
import io.github.xjrga.snack.database.callable.select.DriNutrientsTask;
import io.github.xjrga.snack.database.callable.select.FoodCategoriesTask;
import io.github.xjrga.snack.database.callable.select.FoodCategoryCountTask;
import io.github.xjrga.snack.database.callable.select.FoodDifferenceTask;
import io.github.xjrga.snack.database.callable.select.FoodFactsTask;
import io.github.xjrga.snack.database.callable.select.FoodQuantityConstraintsTask;
import io.github.xjrga.snack.database.callable.select.FoodQuantityLhsTask;
import io.github.xjrga.snack.database.callable.select.FoodQuantityRhsTask;
import io.github.xjrga.snack.database.callable.select.FoodRatioConstraintsTask;
import io.github.xjrga.snack.database.callable.select.FoodRatioLhsTask;
import io.github.xjrga.snack.database.callable.select.FoodRatioRhsTask;
import io.github.xjrga.snack.database.callable.select.FoodsInCategoryTask;
import io.github.xjrga.snack.database.callable.select.FoodsTask;
import io.github.xjrga.snack.database.callable.select.LifestageDriTask;
import io.github.xjrga.snack.database.callable.select.LifestagesTask;
import io.github.xjrga.snack.database.callable.select.MealPlanMealsTask;
import io.github.xjrga.snack.database.callable.select.MealPlanPortionsTask;
import io.github.xjrga.snack.database.callable.select.MealPlanResultsTask;
import io.github.xjrga.snack.database.callable.select.MealPlanUsageResultsTask;
import io.github.xjrga.snack.database.callable.select.MealPlanUsageTask;
import io.github.xjrga.snack.database.callable.select.MixDifferenceTask;
import io.github.xjrga.snack.database.callable.select.MixFoodFactsTask;
import io.github.xjrga.snack.database.callable.select.MixFoodsTask;
import io.github.xjrga.snack.database.callable.select.MixResultsTask;
import io.github.xjrga.snack.database.callable.select.MixStatsTask;
import io.github.xjrga.snack.database.callable.select.MixesTask;
import io.github.xjrga.snack.database.callable.select.NamedMixFoodSortedByIdTask;
import io.github.xjrga.snack.database.callable.select.NamedMixFoodSortedByNameTask;
import io.github.xjrga.snack.database.callable.select.NewItemFoodFactsTask;
import io.github.xjrga.snack.database.callable.select.NutrientContainingFoodsTask;
import io.github.xjrga.snack.database.callable.select.NutrientQuantityConstraintsTask;
import io.github.xjrga.snack.database.callable.select.NutrientQuantityLhsTask;
import io.github.xjrga.snack.database.callable.select.NutrientQuantityRhsTask;
import io.github.xjrga.snack.database.callable.select.NutrientRatioConstraintsTask;
import io.github.xjrga.snack.database.callable.select.NutrientRatioLhsTask;
import io.github.xjrga.snack.database.callable.select.NutrientRatioRhsTask;
import io.github.xjrga.snack.database.callable.select.ObjectiveLhsTask;
import io.github.xjrga.snack.database.callable.select.UnallocatedFoodPercentageTask;
import io.github.xjrga.snack.database.callable.update.UpdateCategoryTask;
import io.github.xjrga.snack.database.callable.update.UpdateCostOnMixTask;
import io.github.xjrga.snack.database.callable.update.UpdateFoodPortionActualWeightTask;
import io.github.xjrga.snack.database.callable.update.UpdateFoodTask;
import io.github.xjrga.snack.database.callable.update.UpdateMealTask;
import io.github.xjrga.snack.database.callable.update.UpdateModelOnMixTask;
import io.github.xjrga.snack.database.callable.update.UpdateNameOnMixTask;
import io.github.xjrga.snack.database.callable.update.UpdateObjectiveOnMixTask;
import io.github.xjrga.snack.database.callable.update.UpdateQuantityOnMixFoodTask;
import io.github.xjrga.snack.database.runnable.CreateAllFoodsReport1Task;
import io.github.xjrga.snack.database.runnable.CreateAllFoodsReport2Task;
import io.github.xjrga.snack.datamodel.FoodStats;
import io.github.xjrga.snack.datamodel.MixFoodLoader;
import io.github.xjrga.snack.datamodel.NutrientLoader;
import io.github.xjrga.snack.datamodel.RelationshipLoader;
import io.github.xjrga.snack.datamodel.TreeModelFood;
import io.github.xjrga.snack.dataobject.DriDO;
import io.github.xjrga.snack.dataobject.Food;
import io.github.xjrga.snack.dataobject.LifeStageDO;
import io.github.xjrga.snack.dataobject.MixDO;
import io.github.xjrga.snack.dataobject.MixFoodDO;
import io.github.xjrga.snack.dataobject.NutrientDO;
import io.github.xjrga.snack.dataobject.RelationshipDO;
import io.github.xjrga.snack.jcomponents.ComboBox;
import io.github.xjrga.snack.jcomponents.FoodFactInputPanel;
import io.github.xjrga.snack.jcomponents.TableCarbs;
import io.github.xjrga.snack.jcomponents.TableCategory;
import io.github.xjrga.snack.jcomponents.TableCost;
import io.github.xjrga.snack.jcomponents.TableDri;
import io.github.xjrga.snack.jcomponents.TableElectrolytes;
import io.github.xjrga.snack.jcomponents.TableEnergy;
import io.github.xjrga.snack.jcomponents.TableFats;
import io.github.xjrga.snack.jcomponents.TableFood;
import io.github.xjrga.snack.jcomponents.TableFoodDetails;
import io.github.xjrga.snack.jcomponents.TableFoodDiff;
import io.github.xjrga.snack.jcomponents.TableFoodFactInput;
import io.github.xjrga.snack.jcomponents.TableFoodQuantityConstraint;
import io.github.xjrga.snack.jcomponents.TableFoodRatioConstraint;
import io.github.xjrga.snack.jcomponents.TableInventoryDays;
import io.github.xjrga.snack.jcomponents.TableMass;
import io.github.xjrga.snack.jcomponents.TableMealCalories;
import io.github.xjrga.snack.jcomponents.TableMealGrams;
import io.github.xjrga.snack.jcomponents.TableMealPlanUsageResults;
import io.github.xjrga.snack.jcomponents.TableMinerals;
import io.github.xjrga.snack.jcomponents.TableMix;
import io.github.xjrga.snack.jcomponents.TableMixDiff;
import io.github.xjrga.snack.jcomponents.TableNutrientLookup;
import io.github.xjrga.snack.jcomponents.TableNutrientQuantity;
import io.github.xjrga.snack.jcomponents.TableNutrientRatioConstraint;
import io.github.xjrga.snack.jcomponents.TablePhytonutrients;
import io.github.xjrga.snack.jcomponents.TablePortion;
import io.github.xjrga.snack.jcomponents.TablePortionMeals;
import io.github.xjrga.snack.jcomponents.TablePortionMeals.Row;
import io.github.xjrga.snack.jcomponents.TableProtein;
import io.github.xjrga.snack.jcomponents.TablePufa;
import io.github.xjrga.snack.jcomponents.TableSfa;
import io.github.xjrga.snack.jcomponents.TableVitamins;
import io.github.xjrga.snack.logger.LoggerImpl;
import io.github.xjrga.snack.lp.LinearProgram;
import io.github.xjrga.snack.lp.LpsolvePrintOut;
import io.github.xjrga.snack.other.AlphaLinolenicRequired;
import io.github.xjrga.snack.other.CunninghamFormula;
import io.github.xjrga.snack.other.DigestibleCarbohydrate;
import io.github.xjrga.snack.other.Dimensions;
import io.github.xjrga.snack.other.ElapsedTime;
import io.github.xjrga.snack.other.FileName;
import io.github.xjrga.snack.other.GlycemicIndexRange;
import io.github.xjrga.snack.other.GlycemicLoad;
import io.github.xjrga.snack.other.ImageUtilities;
import io.github.xjrga.snack.other.KatchMcArdleFormula;
import io.github.xjrga.snack.other.MinimumNutrientRequirements;
import io.github.xjrga.snack.other.NumberCheck;
import io.github.xjrga.snack.other.PanelSpacer;
import io.github.xjrga.snack.other.Reloader;
import io.github.xjrga.snack.other.Shutdown;
import io.github.xjrga.snack.other.StringCheck;
import io.github.xjrga.snack.other.TableColumnWidth;
import io.github.xjrga.snack.other.Utilities;
import io.github.xjrga.snack.xml.FoodsImporter;
import io.github.xjrga.snack.xml.MixImporter;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.net.URL;
import java.sql.Connection;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JTree;
import javax.swing.JViewport;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.TitledBorder;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.ListSelectionEvent;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.tree.DefaultMutableTreeNode;

public class Main {
  private final BufferedImage logo;
  private final CellConstraints cc;
  private final ComboBox<MixFoodDO> cmbFoodQuantityFood;
  private final ComboBox<MixFoodDO> cmbFoodRatioFoodA;
  private final ComboBox<MixFoodDO> cmbFoodRatioFoodB;
  private final ComboBox<MixFoodDO> cmbPortionFood;
  private final ComboBox<NutrientDO> cmbFoodQuantityNutrient;
  private final ComboBox<NutrientDO> cmbFoodRatioNutrientA;
  private final ComboBox<NutrientDO> cmbFoodRatioNutrientB;
  private final ComboBox<NutrientDO> cmbNutrientContentNutrient;
  private final ComboBox<NutrientDO> cmbNutrientQuantityNutrient;
  private final ComboBox<NutrientDO> cmbNutrientRatioNutrientA;
  private final ComboBox<NutrientDO> cmbNutrientRatioNutrientB;
  private final ComboBox<RelationshipDO> cmbFoodQuantityRelationship;
  private final ComboBox<RelationshipDO> cmbFoodRatioRelationship;
  private final ComboBox<RelationshipDO> cmbNutrientQuantityRelationship;
  private final ComboBox<RelationshipDO> cmbNutrientRatioRelationship;
  private final DefaultListModel listModelHighScore;
  private final FoodStats foodStats;
  private final JButton btnAddFood;
  private final JButton btnAddFoodQuantityConstraint;
  private final JButton btnAddFoodRatioConstraint;
  private final JButton btnAddMeal;
  private final JButton btnAddNutrientConstraint;
  private final JButton btnAddNutrientRatio;
  private final JButton btnAddPortion;
  private final JButton btnDeleteFood;
  private final JButton btnDeleteFoodQuantityConstraint;
  private final JButton btnDeleteFoodRatioConstraint;
  private final JButton btnDeleteMeal;
  private final JButton btnDeleteNutrientConstraint;
  private final JButton btnDeleteNutrientRatio;
  private final JButton btnDeletePortion;
  private final JButton btnRenameFood;
  private final JButton btnSolve;
  private final JButton btnUpdateFood;
  private final JButton btnUpdateMeal;
  private final JButton btnUpdatePortionWeight;
  private final JCheckBox chkLpsolve;
  private final JCheckBox chkResultRoundUp;
  private final JFileChooser fch;
  private final JFrame frm;
  private final JLabel lblFoodQuantityCount;
  private final JLabel lblFoodRatioCount;
  private final JLabel lblMinimization;
  private final JLabel lblNutrientQuantityCount;
  private final JLabel lblNutrientRatioCount;
  private final JList lstHighScore;
  private final JMenu mnuDELETE;
  private final JMenu mnuData;
  private final JMenu mnuFoodsData;
  private final JMenu mnuHelp;
  private final JMenu mnuMix;
  private final JMenu mnuMixModel;
  private final JMenu mnuMixResult;
  private final JMenu mnuReport;
  private final JMenu mnuProgram;
  private final JMenu mnuSettings;
  private final JMenu mnuTools;
  private final JMenuItem mniAbout;
  private final JMenuItem mniAuthor;
  private final JMenuItem mniCalculateALARequired;
  private final JMenuItem mniCalculateBMR;
  private final JMenuItem mniCalculateDigestibleCarbs;
  private final JMenuItem mniCalculateGIRange;
  private final JMenuItem mniCalculateGL;
  private final JMenuItem mniCalculateProteinRequired;
  private final JMenuItem mniConvertDRI;
  private final JMenuItem mniConvertMix;
  private final JMenuItem mniCreateAllFoodsReport1;
  private final JMenuItem mniCreateAllFoodsReport2;
  private final JMenuItem mniCreateMixDriReport;
  private final JMenuItem mniCreateFoodComparisonReport;
  private final JMenuItem mniCreateMealPlanUsageReport;
  private final JMenuItem mniCreateMealPlanCaloriesReport;
  private final JMenuItem mniCreateMealPlanMacronutrientsReport;
  private final JMenuItem mniCreateMealPlanPortionsReport;
  private final JMenuItem mniCreateMix;
  private final JMenuItem mniCreateMixComparisonReport;
  private final JMenuItem mniCreateMixResultsReport1;
  private final JMenuItem mniCreateMixResultsReport2;
  private final JMenuItem mniCreateNutrientSearchReport;
  private final JMenuItem mniCredits;
  private final JMenuItem mniDELETEALL;
  private final JMenuItem mniDELETEMIXES;
  private final JMenuItem mniDeleteMix;
  private final JMenuItem mniDuplicateMix;
  private final JMenuItem mniExit;
  private final JMenuItem mniExportMixModel;
  private final JMenuItem mniImportFoods;
  private final JMenuItem mniImportMixModel;
  private final JMenuItem mniPinMix;
  private final JMenuItem mniProject;
  private final JMenuItem mniRenameMix;
  private final JMenuItem mniSetConstraints;
  private final JMenuItem mniSetMinimizationOption;
  private final JMenuItem mniShowCarbohydrateRequired;
  private final JMenuItem mniShowMixStats;
  private final JRadioButtonMenuItem raiCalories;
  private final JRadioButtonMenuItem raiCost;
  private final JSplitPane splMain;
  private final JTabbedPane tabMain;
  private final JTabbedPane tabResults;
  private final JTextArea txaLpProgram;
  private final JTextField txtFoodNutrientRatioQuantityA;
  private final JTextField txtFoodNutrientRatioQuantityB;
  private final JTextField txtFoodQuantityValue;
  private final JTextField txtNutrientSearchQuantity;
  private final JTextField txtNutrientQuantityValue;
  private final JTextField txtNutrientRatioNutrientA;
  private final JTextField txtNutrientRatioNutrientB;
  private final JTextField txtPortionPct;
  private final JTextField txtTotalPct;
  private final JTree treFoods;
  private final MixFoodLoader mixFoodLoader;
  private final NutrientLoader nutrientLoader;
  private final RelationshipLoader relationshipLoader;
  private final TableMix tblMealPlanUsageMixes;
  private final TreeModelFood tremodelFoods;
  private ComboBox<LifeStageDO> cmbLifestage;
  private ComboBox<MixDO> cmbMixes;
  private TableCarbs tblCarbs;
  private TableCategory tblCategory;
  private TableCost tblCost;
  private TableDri tblDri;
  private TableElectrolytes tblElectrolytes;
  private TableEnergy tblCalories;
  private TableFats tblFats;
  private TableFood tblCategoryAllFoods;
  private TableFood tblCategoryFood;
  private TableFood tblFoodDiffA;
  private TableFood tblFoodDiffB;
  private TableFood tblMixFood;
  private TableFoodDetails tblFoods;
  private TableFoodDiff tblFoodDiff;
  private TableFoodQuantityConstraint tblFoodQuantityConstraint;
  private TableFoodRatioConstraint tblFoodRatioConstraint;
  private TableInventoryDays tblMealPlanUsage;
  private TableMealPlanUsageResults tblMealPlanUsageResults;
  private TableMass tblMacronutrients;
  private TableMealCalories tblMealCalories;
  private TableMealGrams tblMealMacronutrients;
  private TableMinerals tblMinerals;
  private TableMix tblMixDiffA;
  private TableMix tblMixDiffB;
  private TableMixDiff tblMixDiff;
  private TableNutrientLookup tblNutrientLookup;
  private TableNutrientQuantity tblNutrientQuantityConstraint;
  private TableNutrientRatioConstraint tblNutrientRatio;
  private TablePhytonutrients tblPhytonutrients;
  private TablePortion tblMealPortions;
  private TablePortionMeals tblMeals;
  private TableProtein tblProtein;
  private TablePufa tblPufa;
  private TableSfa tblSfa;
  private TableVitamins tblVitamins;
  private List<List> foods;
  private List<List> categories;
  private LinkedList<HashMap> treeFoods;
  private List<List> mixDri;
  private List<List> foodDiffList;
  private final Connection connection;

  public Main(Splash splash) {
    LoggerImpl.INSTANCE.filter("io.github.xjrga.*");
    LoggerImpl.INSTANCE.print();
    // LoggerImpl.INSTANCE.write();
    logo =
        ImageUtilities.readImageFromUrl(Utilities.getResourceAsUrl("/resources/images/logo.png"));
    cc = new CellConstraints();
    cmbFoodQuantityFood = new ComboBox();
    cmbFoodRatioFoodA = new ComboBox();
    cmbFoodRatioFoodB = new ComboBox();
    cmbPortionFood = new ComboBox<>();
    cmbFoodQuantityNutrient = new ComboBox();
    cmbFoodRatioNutrientA = new ComboBox();
    cmbFoodRatioNutrientB = new ComboBox();
    cmbNutrientContentNutrient = new ComboBox();
    cmbNutrientQuantityNutrient = new ComboBox();
    cmbNutrientRatioNutrientA = new ComboBox();
    cmbNutrientRatioNutrientB = new ComboBox();
    cmbFoodQuantityRelationship = new ComboBox();
    cmbFoodRatioRelationship = new ComboBox();
    cmbNutrientQuantityRelationship = new ComboBox();
    cmbNutrientRatioRelationship = new ComboBox();
    listModelHighScore = new DefaultListModel();
    foodStats = new FoodStats();
    btnAddFood = new JButton("+");
    btnAddFoodQuantityConstraint = new JButton("+");
    btnAddFoodRatioConstraint = new JButton("+");
    btnAddMeal = new JButton("+");
    btnAddNutrientConstraint = new JButton("+");
    btnAddNutrientRatio = new JButton("+");
    btnAddPortion = new JButton("+");
    btnDeleteFood = new JButton("-");
    btnDeleteFoodQuantityConstraint = new JButton("-");
    btnDeleteFoodRatioConstraint = new JButton("-");
    btnDeleteMeal = new JButton("-");
    btnDeleteNutrientConstraint = new JButton("-");
    btnDeleteNutrientRatio = new JButton("-");
    btnDeletePortion = new JButton("-");
    btnRenameFood = new JButton("r");
    btnSolve = new JButton("Solve");
    btnUpdateFood = new JButton("u");
    btnUpdateMeal = new JButton("u");
    btnUpdatePortionWeight = new JButton("w");
    chkLpsolve = new JCheckBox();
    chkResultRoundUp = new JCheckBox();
    fch = new JFileChooser();
    frm = new JFrame();
    lblFoodQuantityCount = new JLabel();
    lblFoodRatioCount = new JLabel();
    lblMinimization = new JLabel();
    lblNutrientQuantityCount = new JLabel();
    lblNutrientRatioCount = new JLabel();
    lstHighScore = new JList();
    mnuDELETE = new JMenu();
    mnuData = new JMenu();
    mnuFoodsData = new JMenu();
    mnuHelp = new JMenu();
    mnuMix = new JMenu();
    mnuMixModel = new JMenu();
    mnuMixResult = new JMenu();
    mnuReport = new JMenu();
    mnuProgram = new JMenu();
    mnuSettings = new JMenu();
    mnuTools = new JMenu();
    mniAbout = new JMenuItem();
    mniAuthor = new JMenuItem();
    mniCalculateALARequired = new JMenuItem();
    mniCalculateBMR = new JMenuItem();
    mniCalculateDigestibleCarbs = new JMenuItem();
    mniCalculateGIRange = new JMenuItem();
    mniCalculateGL = new JMenuItem();
    mniCalculateProteinRequired = new JMenuItem();
    mniConvertDRI = new JMenuItem();
    mniConvertMix = new JMenuItem();
    mniCreateAllFoodsReport1 = new JMenuItem();
    mniCreateAllFoodsReport2 = new JMenuItem();
    mniCreateMixDriReport = new JMenuItem();
    mniCreateFoodComparisonReport = new JMenuItem();
    mniCreateMealPlanUsageReport = new JMenuItem();
    mniCreateMealPlanCaloriesReport = new JMenuItem();
    mniCreateMealPlanMacronutrientsReport = new JMenuItem();
    mniCreateMealPlanPortionsReport = new JMenuItem();
    mniCreateMix = new JMenuItem();
    mniCreateMixComparisonReport = new JMenuItem();
    mniCreateMixResultsReport1 = new JMenuItem();
    mniCreateMixResultsReport2 = new JMenuItem();
    mniCreateNutrientSearchReport = new JMenuItem();
    mniCredits = new JMenuItem();
    mniDELETEALL = new JMenuItem();
    mniDELETEMIXES = new JMenuItem();
    mniDeleteMix = new JMenuItem();
    mniDuplicateMix = new JMenuItem();
    mniExit = new JMenuItem();
    mniExportMixModel = new JMenuItem();
    mniImportFoods = new JMenuItem();
    mniImportMixModel = new JMenuItem();
    mniPinMix = new JMenuItem("Pin");
    mniProject = new JMenuItem();
    mniRenameMix = new JMenuItem();
    mniSetConstraints = new JMenuItem();
    mniSetMinimizationOption = new JMenuItem();
    mniShowCarbohydrateRequired = new JMenuItem();
    mniShowMixStats = new JMenuItem();
    raiCalories = new JRadioButtonMenuItem();
    raiCost = new JRadioButtonMenuItem();
    splMain = new JSplitPane();
    tabMain = new JTabbedPane();
    tabResults = new JTabbedPane();
    txaLpProgram = new JTextArea();
    txtFoodNutrientRatioQuantityA = new JTextField();
    txtFoodNutrientRatioQuantityB = new JTextField();
    txtFoodQuantityValue = new JTextField();
    txtNutrientSearchQuantity = new JTextField();
    txtNutrientQuantityValue = new JTextField();
    txtNutrientRatioNutrientA = new JTextField();
    txtNutrientRatioNutrientB = new JTextField();
    txtPortionPct = new JTextField();
    txtTotalPct = new JTextField();
    treFoods = new JTree();
    mixFoodLoader = new MixFoodLoader();
    nutrientLoader = new NutrientLoader();
    relationshipLoader = new RelationshipLoader();
    tblMealPlanUsageMixes = new TableMix();
    tremodelFoods = new TreeModelFood();
    frm.setIconImage(logo);
    frm.setJMenuBar(getMenuBar());
    tabMain.setTabPlacement(SwingConstants.BOTTOM);
    tabMain.add(getEditorPanel());
    tabMain.add(getFoodList());
    tabMain.add(getFoodComparisonPanel());
    tabMain.add(getMixComparisonPanel());
    tabMain.add(getNutrientSearchPanel());
    tabMain.add(getFoodCategoriesPanel());
    tabMain.add(getMealPlanUsagePanel());
    tabMain.setTitleAt(0, "Editor");
    tabMain.setToolTipTextAt(0, "Create, edit and solve your diet here");
    tabMain.setTitleAt(1, "Food List");
    tabMain.setToolTipTextAt(1, "This is your list of favorite food items");
    tabMain.setTitleAt(2, "Food Comparison");
    tabMain.setToolTipTextAt(2, "This is where you compare two 100g food servings");
    tabMain.setTitleAt(3, "Mix Comparison");
    tabMain.setToolTipTextAt(3, "This is where you compare two mixes");
    tabMain.setTitleAt(4, "Nutrient Search");
    tabMain.setToolTipTextAt(4, "This is where you search food items for nutrient content");
    tabMain.setTitleAt(5, "Food Category");
    tabMain.setToolTipTextAt(5, "This is where you put food items into categories");
    tabMain.setTitleAt(6, "Meal Plan Usage");
    tabMain.setToolTipTextAt(6, "This is where you find out how much food you need to buy");
    JScrollPane scrollPane = new JScrollPane();
    scrollPane.setViewportView(tabMain);
    frm.add(scrollPane);
    frm.setDefaultCloseOperation(3);
    Dimension size = new Dimension(1500, 870);
    frm.setSize(size);
    frm.setVisible(true);
    frm.setTitle(" Snack");
    frm.addWindowListener(
        new WindowAdapter() {
          @Override
          public void windowClosing(WindowEvent e) {
            exit();
          }
        });
    cmbMixes.setMaximumRowCount(24);
    raiCalories.setSelected(true);
    connection = Connect.getInstance().getConnection();
    reloadCbNutrientData();
    reloadCbRelationshipData();
    try {
      Future<List<List>> task = BackgroundExec.submit(new MixesTask());
      List<List> lst = task.get();
      List<MixDO> mixesList = Utilities.createMixDOList(lst);
      cmbMixes.reload(mixesList);
      tblMixDiffA.reload(lst);
      tblMixDiffB.reload(lst);
      tblMealPlanUsageMixes.reload(lst);
    } catch (Exception e) {
      LoggerImpl.INSTANCE.logProblem(e);
    }
    try {
      Future<List<List>> task = BackgroundExec.submit(new FoodFactsTask());
      List<List> foods = task.get();
      tblFoods.reload(foods);
      tblFoodDiffA.reload(foods);
      tblFoodDiffB.reload(foods);
      tblCategoryAllFoods.reload(foods);
    } catch (Exception e) {
      LoggerImpl.INSTANCE.logProblem(e);
    }
    try {
      Future<List<Map<String, Object>>> task = BackgroundExec.submit(new FoodsTask());
      List<Map<String, Object>> treeFoods = task.get();
      tremodelFoods.reload(treeFoods);
    } catch (Exception e) {
      LoggerImpl.INSTANCE.logProblem(e);
    }
    try {
      Future<List<List>> task = BackgroundExec.submit(new FoodCategoriesTask());
      List<List> categories = task.get();
      tblCategory.reload(categories);
    } catch (Exception e) {
      LoggerImpl.INSTANCE.logProblem(e);
    }
    try {
      Future<List<LifeStageDO>> task = BackgroundExec.submit(new LifestagesTask());
      List<LifeStageDO> lifestages = task.get();
      cmbLifestage.reload(lifestages);
    } catch (Exception e) {
      LoggerImpl.INSTANCE.logProblem(e);
    }
    fch.setAcceptAllFileFilterUsed(false);
    fch.addChoosableFileFilter(new FileNameExtensionFilter("Xml Document", "xml"));
    cmbLifestage.setSelectedItem(new LifeStageDO(22, "Daily Value"));
    if (!cmbMixes.isEmpty()) {
      cmbMixes.setSelectedIndex(0);
    }
    setSplitPanelDivider();
    setQuantityScale();
    fch.setCurrentDirectory(new File("."));
    updateObjectiveDisplay("10009");
    splash.halt();
  }

  private void clearMixesView() {
    // Mixes List
    cmbMixes.clear();
    tblMixDiffA.clear();
    tblMixDiffB.clear();
    tblMealPlanUsageMixes.clear();
    // Model Data
    tblMixFood.clear();
    tblNutrientQuantityConstraint.clear();
    tblNutrientRatio.clear();
    cmbFoodQuantityFood.clear();
    tblFoodQuantityConstraint.clear();
    cmbFoodRatioFoodA.clear();
    cmbFoodRatioFoodB.clear();
    tblFoodRatioConstraint.clear();
    // Model Results Data
    tblCalories.clear();
    tblMacronutrients.clear();
    tblProtein.clear();
    tblFats.clear();
    tblSfa.clear();
    tblPufa.clear();
    tblCarbs.clear();
    tblVitamins.clear();
    tblMinerals.clear();
    tblElectrolytes.clear();
    tblPhytonutrients.clear();
    tblCost.clear();
    tblDri.clear();
    txaLpProgram.setText("");
    // Model Meal Plan
    tblMeals.clear();
    cmbPortionFood.clear();
    tblMealPortions.clear();
    tblMealCalories.clear();
    tblMealMacronutrients.clear();
    // Mixes Comparison
    tblMixDiff.clear();
    // Meal Plan Usage
    tblMealPlanUsage.clear();
    tblMealPlanUsageResults.clear();
  }

  private void clearFoodsView() {
    tremodelFoods.clear();
    tblMixFood.clear();
    tblFoods.clear();
    tblFoodDiffA.clear();
    tblFoodDiffB.clear();
    tblCategoryAllFoods.clear();
    tblCategoryFood.clear();
    tblCategory.clear();
    cmbFoodQuantityFood.clear();
    cmbFoodRatioFoodA.clear();
    cmbFoodRatioFoodB.clear();
    tblFoodDiff.clear();
  }

  private void deleteFoodItem(String foodId) {
    try {
      Future<Boolean> task = BackgroundExec.submit(new DeleteFoodTask(foodId));
      Boolean completed = task.get();
      if (!completed) {
        return;
      }
    } catch (Exception e) {
      LoggerImpl.INSTANCE.logProblem(e);
    }
    try {
      Future<List<List>> task = BackgroundExec.submit(new FoodFactsTask());
      List<List> foods = task.get();
      tblFoods.reload(foods);
      tblFoodDiffA.reload(foods);
      tblFoodDiffB.reload(foods);
      tblCategoryAllFoods.reload(foods);
    } catch (Exception e) {
      LoggerImpl.INSTANCE.logProblem(e);
    }
    try {
      Future<List<Map<String, Object>>> task = BackgroundExec.submit(new FoodsTask());
      List<Map<String, Object>> treeFoods = task.get();
      tremodelFoods.reload(treeFoods);
    } catch (Exception e) {
      LoggerImpl.INSTANCE.logProblem(e);
    }
    try {
      Future<List<List>> task = BackgroundExec.submit(new FoodCategoriesTask());
      List<List> categories = task.get();
      tblCategory.reload(categories);
    } catch (Exception e) {
      LoggerImpl.INSTANCE.logProblem(e);
    }
    MixDO mix = getSelectedMix();
    try {
      Future<List<List>> task =
          BackgroundExec.submit(new NamedMixFoodSortedByNameTask(mix.getMixId()));
      List<List> foods = task.get();
      tblMixFood.reload(foods);
    } catch (Exception e) {
      LoggerImpl.INSTANCE.logProblem(e);
    }
    setQuantityScale();
  }

  private void addMealPlanUsage() {
    if (tblMealPlanUsageMixes.isSelectionEmpty()) {
      return;
    }
    TableMix.Row row = tblMealPlanUsageMixes.getSelectedValue();
    Double days = getMixUsageInputForInventory();
    if (days == Double.NaN) {
      return;
    }
    try {
      Future<Boolean> task =
          BackgroundExec.submit(new MergeMealPlanUsageTask(row.getMixid(), days));
      task.get();
    } catch (Exception e) {
      LoggerImpl.INSTANCE.logProblem(e);
    }
  }

  private void deleteMealPlanUsage() {
    if (tblMealPlanUsage.isSelectionEmpty()) {
      return;
    }
    try {
      TableInventoryDays.Row row = tblMealPlanUsage.getSelectedValue();
      Future<Boolean> task = BackgroundExec.submit(new DeleteMealPlanUsageTask(row.getMixid()));
      task.get();
    } catch (Exception e) {
      LoggerImpl.INSTANCE.logProblem(e);
    }
  }

  private void expandTree(JTree tree, int startingIndex, int rowCount) {
    for (int i = startingIndex; i < rowCount; ++i) {
      tree.expandRow(i);
    }
    if (tree.getRowCount() != rowCount) {
      expandTree(tree, rowCount, tree.getRowCount());
    }
  }

  private JTabbedPane getConstraintsPanel() {
    JTabbedPane tab = new JTabbedPane();
    tblFoodQuantityConstraint = new TableFoodQuantityConstraint();
    tab.setBorder(new TitledBorder("Mix Definition"));
    tab.setTabPlacement(SwingConstants.RIGHT);
    tab.add("Food List        ", getMixFoodPanel());
    tab.add("Nutrient Quantity", new PanelSpacer(getNutrientQuantityConstraintPanel()));
    tab.add("Nutrient Ratio   ", new PanelSpacer(getNutrientRatioPanel()));
    tab.add("Food Quantity    ", new PanelSpacer(getFoodQuantityConstraint()));
    tab.add("Food Ratio       ", new PanelSpacer(getFoodRatioPanel()));
    tab.setToolTipTextAt(0, "Add food items to this list");
    tab.setToolTipTextAt(1, "Limit a nutrient");
    tab.setToolTipTextAt(2, "Specify a relationship between two nutrients");
    tab.setToolTipTextAt(3, "Limit a food item");
    tab.setToolTipTextAt(4, "Specify a relationship between two food items");
    return tab;
  }

  private JPanel getEditorPanel() {
    JPanel pnl = new JPanel();
    FormLayout lyo =
        new FormLayout(
            "min:grow", // columns
            "min,fill:min:grow" // rows
            );
    pnl.setLayout(lyo);
    pnl.add(getMixesPanel(), cc.xy(1, 1));
    pnl.add(getSolutionPanel(), cc.xy(1, 2));
    cmbMixes.addActionListener(
        (ActionEvent e) -> {
          if (!cmbMixes.isSelectionEmpty()) {
            loadSelectedMix();
          }
        });
    return pnl;
  }

  private JPanel getMealPlanPanel() {
    JPanel pnl = new JPanel();
    JTabbedPane tab = new JTabbedPane();
    FormLayout lyo =
        new FormLayout(
            "min:grow", // columns
            "fill:min:grow" // rows
            );
    pnl.setLayout(lyo);
    tab.setTabPlacement(SwingConstants.RIGHT);
    tab.add("Portions      ", new PanelSpacer(getMealPortionsPanel()));
    tab.add("Calories      ", new PanelSpacer(getMealCaloriesPanel()));
    tab.add("Macronutrients", new PanelSpacer(getMealMacronutrientsPanel()));
    tab.setSelectedIndex(0);
    tab.setToolTipTextAt(
        0,
        "Allocate food amount by specifying a percentage, selecting a food item, one or more meals"
            + " and pressing '+'");
    tab.setToolTipTextAt(1, "Calories per meal");
    tab.setToolTipTextAt(2, "Grams per meal");
    pnl.add(tab, cc.xy(1, 1));
    return pnl;
  }

  private JPanel getMixesPanel() {
    cmbMixes = new ComboBox<>();
    cmbMixes.setDoubleBuffered(false);
    JPanel pnl = new JPanel();
    FormLayout lyo =
        new FormLayout(
            "p:grow,min", // columns
            "fill:min:grow" // rows
            );
    pnl.setLayout(lyo);
    pnl.setBorder(new TitledBorder("Mix"));
    JPanel pnlButtons = new JPanel();
    FormLayout buttonsLayout =
        new FormLayout(
            "min", // columns
            "min" // rows
            );
    pnlButtons.setLayout(buttonsLayout);
    btnSolve.setToolTipText("Find lowest calorie diet");
    pnlButtons.add(btnSolve, cc.xy(1, 1));
    pnl.add(cmbMixes, cc.xy(1, 1));
    pnl.add(pnlButtons, cc.xy(2, 1));
    btnSolve.addActionListener(
        (ActionEvent evt) -> {
          if (cmbMixes.isSelectionEmpty()) {
            return;
          }
          MixDO mix = new MixDO();
          mix = cmbMixes.getSelectedItem();
          solveModel(mix);
          try {
            Future<List<List>> task = BackgroundExec.submit(new MixesTask());
            List<List> lst = task.get();
            List<MixDO> mixesList = Utilities.createMixDOList(lst);
            cmbMixes.reload(mixesList);
            tblMixDiffA.reload(lst);
            tblMixDiffB.reload(lst);
            tblMealPlanUsageMixes.reload(lst);
          } catch (Exception e) {
            LoggerImpl.INSTANCE.logProblem(e);
          }
          cmbMixes.setSelectedItem(mix);
        });
    return pnl;
  }

  private JPanel getEditorModel() {
    JPanel pnl = new JPanel();
    FormLayout lyo =
        new FormLayout(
            "min:grow", // columns
            "fill:pref:grow" // rows
            );
    pnl.setLayout(lyo);
    try {
      URL url = Utilities.getResourceAsUrl("/resources/fonts/inconsolata.ttf");
      InputStream is = url.openStream();
      Font font = Font.createFont(Font.TRUETYPE_FONT, is).deriveFont(13f);
      txaLpProgram.setFont(font);
      txaLpProgram.setLineWrap(false);
      JScrollPane scrollPane = new JScrollPane(txaLpProgram);
      scrollPane.setPreferredSize(new Dimension(0, 0));
      pnl.add(scrollPane, cc.xy(1, 1));
    } catch (IOException | FontFormatException e) {
      LoggerImpl.INSTANCE.logProblem(e);
    }
    return pnl;
  }

  private JPanel getEditorRda(TableDri tblDri) {
    JScrollPane scr = new JScrollPane(tblDri);
    FormLayout lyo =
        new FormLayout(
            "p:grow", // columns
            "5dlu,min,5dlu,fill:min:grow" // rows
            );
    FormLayout lyoLifestage =
        new FormLayout(
            "5dlu,min:grow,5dlu,min", // columns
            "min" // rows
            );
    JPanel pnlLifestage = new JPanel();
    pnlLifestage.setLayout(lyoLifestage);
    JLabel lbl = new JLabel(" Lifestage:");
    cmbLifestage = new ComboBox<>();
    lbl.setHorizontalAlignment(SwingConstants.RIGHT);
    pnlLifestage.add(lbl, cc.xy(2, 1));
    pnlLifestage.add(cmbLifestage, cc.xy(4, 1));
    JPanel pnl = new JPanel();
    pnl.setLayout(lyo);
    pnl.add(pnlLifestage, cc.xy(1, 2));
    pnl.add(scr, cc.xy(1, 4));
    scr.setBorder(new TitledBorder("DRI Check"));
    cmbLifestage.addActionListener(
        (ActionEvent a) -> {
          if (!cmbLifestage.isSelectionEmpty()) {
            MixDO mix = getSelectedMix();
            LifeStageDO lifestage = (LifeStageDO) cmbLifestage.getSelectedItem();
            try {
              Future<List<List>> task =
                  BackgroundExec.submit(
                      new DriDifferenceTask(mix.getMixId(), lifestage.getLifeStageId()));
              List<List> diff = task.get();
              tblDri.reload(diff);
              setQuantityScale();
            } catch (Exception e) {
              LoggerImpl.INSTANCE.logProblem(e);
            }
          }
        });
    JPopupMenu pmn = new JPopupMenu();
    JMenuItem item01 = new JMenuItem("Find nutrient containing foods");
    pmn.add(item01);
    item01.addActionListener(
        (ActionEvent e) -> {
          if (!tblDri.isSelectionEmpty()) {
            calculateNutrientContent();
          } else {
            Message.showMessage("Please select nutrient");
          }
        });
    tblDri.addMouseListener(
        new MouseAdapter() {
          @Override
          public void mouseClicked(MouseEvent e) {
            super.mouseClicked(e);
            showPopup(e, pmn);
          }
        });
    return pnl;
  }

  private JSplitPane getResultsPanel() {
    JPanel pnlMain = new JPanel();
    JPanel pnlRight = new JPanel();
    JPanel pnlObjective = new JPanel();
    JPanel pnlConstraintCount = new JPanel();
    FormLayout lyoMainPanel =
        new FormLayout(
            "p:grow,right:p", // columns
            "fill:min:grow" // rows
            );
    FormLayout lyoRightPanel =
        new FormLayout(
            "min", // columns
            "min,fill:min,fill:min:grow" // rows
            );
    FormLayout lyoConstraintCountPanel =
        new FormLayout(
            "p,p", // columns
            "4dlu,min,min,min,min,4dlu" // rows
            );
    pnlMain.setLayout(lyoMainPanel);
    pnlRight.setLayout(lyoRightPanel);
    pnlConstraintCount.setLayout(lyoConstraintCountPanel);
    JScrollPane scrHighScore = new JScrollPane(lstHighScore);
    scrHighScore.setBorder(new TitledBorder(""));
    pnlObjective.setBorder(new TitledBorder("Minimize"));
    scrHighScore.setToolTipText("Press delete button to clear list");
    pnlConstraintCount.setBorder(new TitledBorder("Mix Constraints"));
    lstHighScore.setModel(listModelHighScore);
    DefaultListCellRenderer renderer = (DefaultListCellRenderer) lstHighScore.getCellRenderer();
    renderer.setHorizontalAlignment(SwingConstants.RIGHT);
    tabResults.setBorder(new TitledBorder("Mix Nutritional Value"));
    tabResults.setTabPlacement(SwingConstants.RIGHT);
    JLabel lblNutrientQuantity = new JLabel("Nutrient Quantity: ");
    JLabel lblNutrientRatio = new JLabel("Nutrient Ratio: ");
    JLabel lblFoodQuantity = new JLabel("Food Quantity: ");
    JLabel lblFoodRatio = new JLabel("Food Ratio: ");
    tblCalories = new TableEnergy();
    tblMacronutrients = new TableMass();
    tblProtein = new TableProtein();
    tblFats = new TableFats();
    tblSfa = new TableSfa();
    tblPufa = new TablePufa();
    tblCarbs = new TableCarbs();
    tblVitamins = new TableVitamins();
    tblMinerals = new TableMinerals();
    tblElectrolytes = new TableElectrolytes();
    tblPhytonutrients = new TablePhytonutrients();
    tblCost = new TableCost();
    tblDri = new TableDri();
    lblNutrientQuantity.setHorizontalAlignment(SwingConstants.RIGHT);
    lblFoodQuantity.setHorizontalAlignment(SwingConstants.RIGHT);
    lblNutrientRatio.setHorizontalAlignment(SwingConstants.RIGHT);
    lblFoodRatio.setHorizontalAlignment(SwingConstants.RIGHT);
    pnlConstraintCount.add(lblNutrientQuantity, cc.xy(1, 2));
    pnlConstraintCount.add(lblNutrientRatio, cc.xy(1, 3));
    pnlConstraintCount.add(lblFoodQuantity, cc.xy(1, 4));
    pnlConstraintCount.add(lblFoodRatio, cc.xy(1, 5));
    pnlConstraintCount.add(lblNutrientQuantityCount, cc.xy(2, 2));
    pnlConstraintCount.add(lblNutrientRatioCount, cc.xy(2, 3));
    pnlConstraintCount.add(lblFoodQuantityCount, cc.xy(2, 4));
    pnlConstraintCount.add(lblFoodRatioCount, cc.xy(2, 5));
    tabResults.add(new JScrollPane(tblCalories));
    tabResults.add(new JScrollPane(tblMacronutrients));
    tabResults.add(new JScrollPane(tblProtein));
    tabResults.add(new JScrollPane(tblFats));
    tabResults.add(new JScrollPane(tblSfa));
    tabResults.add(new JScrollPane(tblPufa));
    tabResults.add(new JScrollPane(tblCarbs));
    tabResults.add(new JScrollPane(tblVitamins));
    tabResults.add(new JScrollPane(tblMinerals));
    tabResults.add(new JScrollPane(tblElectrolytes));
    tabResults.add(new JScrollPane(tblPhytonutrients));
    tabResults.add(new JScrollPane(tblCost));
    tabResults.add(getEditorRda(tblDri));
    tabResults.add(getEditorModel());
    tabResults.setTitleAt(0, "Calories       ");
    tabResults.setTitleAt(1, "Macronutrients ");
    tabResults.setTitleAt(2, "Protein        ");
    tabResults.setTitleAt(3, "Fats           ");
    tabResults.setTitleAt(4, "Saturated      ");
    tabResults.setTitleAt(5, "Polyunsaturated");
    tabResults.setTitleAt(6, "Carbohydrates  ");
    tabResults.setTitleAt(7, "Vitamins       ");
    tabResults.setTitleAt(8, "Minerals       ");
    tabResults.setTitleAt(9, "Electrolytes   ");
    tabResults.setTitleAt(10, "Phytonutrients ");
    tabResults.setTitleAt(11, "Cost           ");
    tabResults.setTitleAt(12, "Dri            ");
    tabResults.setTitleAt(13, "Model          ");
    pnlObjective.add(lblMinimization);
    pnlRight.add(pnlConstraintCount, cc.xy(1, 1));
    pnlRight.add(pnlObjective, cc.xy(1, 2));
    pnlRight.add(scrHighScore, cc.xy(1, 3));
    pnlMain.add(tabResults, cc.xy(1, 1));
    pnlMain.add(pnlRight, cc.xy(2, 1));
    splMain.setOrientation(JSplitPane.VERTICAL_SPLIT);
    splMain.setOneTouchExpandable(true);
    splMain.setTopComponent(pnlMain);
    splMain.setBottomComponent(getConstraintsPanel());
    lstHighScore.addKeyListener(
        new KeyListener() {
          @Override
          public void keyPressed(KeyEvent keyEvent) {
            if (keyEvent.getKeyCode() == KeyEvent.VK_DELETE) {
              clearHighscore();
            }
          }

          @Override
          public void keyReleased(KeyEvent keyEvent) {}

          @Override
          public void keyTyped(KeyEvent keyEvent) {}
        });
    Action high =
        new AbstractAction() {
          @Override
          public void actionPerformed(ActionEvent e) {
            splMain.setDividerLocation(0.0);
          }
        };
    Action middle =
        new AbstractAction() {
          @Override
          public void actionPerformed(ActionEvent e) {
            setSplitPanelDivider();
          }
        };
    Action low =
        new AbstractAction() {
          @Override
          public void actionPerformed(ActionEvent e) {
            splMain.setDividerLocation(1.0);
          }
        };
    InputMap inputMap = tabMain.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    ActionMap actionMap = tabMain.getActionMap();
    inputMap.put(KeyStroke.getKeyStroke("control L"), "min");
    inputMap.put(KeyStroke.getKeyStroke("control M"), "mid");
    inputMap.put(KeyStroke.getKeyStroke("control H"), "max");
    actionMap.put("min", low);
    actionMap.put("mid", middle);
    actionMap.put("max", high);
    return splMain;
  }

  private JTabbedPane getSolutionPanel() {
    JTabbedPane tab = new JTabbedPane();
    tab.setTabPlacement(SwingConstants.BOTTOM);
    tab.add("Model", getResultsPanel());
    tab.add("Meals", getMealPlanPanel());
    tab.setToolTipTextAt(0, "This is where you create your diet");
    tab.setToolTipTextAt(1, "This is where you create your meals");
    return tab;
  }

  private JPanel getFoodCategoriesPanel() {
    tblCategoryAllFoods = new TableFood();
    tblCategory = new TableCategory();
    tblCategoryFood = new TableFood();
    JScrollPane scrAllFoodsTable = new JScrollPane(tblCategoryAllFoods);
    JScrollPane scrCategoryTable = new JScrollPane(tblCategory);
    JScrollPane scrCategoryFoodTable = new JScrollPane(tblCategoryFood);
    JTextField txtSearch = tblCategoryAllFoods.getTxtSearch();
    JPanel pnlMain = new JPanel();
    JPanel pnlAllFoodsComp = new JPanel();
    JPanel pnlCategories = new JPanel();
    JPanel pnlCategoryFoods = new JPanel();
    JPanel pnlAllFoods = new JPanel();
    JPanel pnlCategoryButtons = new JPanel();
    JPanel pnlFoodButtonsMinus = new JPanel();
    JSplitPane spl = new JSplitPane();
    FormLayout lyo =
        new FormLayout(
            "m:grow,m:grow", // columns
            "fill:min:grow" // rows
            );
    FormLayout lyo00 =
        new FormLayout(
            "min:grow", // columns
            "fill:min:grow" // rows
            );
    FormLayout lyo01 =
        new FormLayout(
            "min:grow", // columns
            "fill:min:grow,min" // rows
            );
    FormLayout lyo02 =
        new FormLayout(
            "min,min:grow", // columns
            "fill:16dlu,6dlu,fill:min:grow" // rows
            );
    FormLayout lyoButtons =
        new FormLayout(
            "min:grow,min,min,min,min,min:grow", // columns
            "min" // rows
            );
    FormLayout lyoButtons01 =
        new FormLayout(
            "min:grow,min,min,min:grow", // columns
            "fill:min:grow" // rows
            );
    FormLayout lyo03 =
        new FormLayout(
            "min:grow", // columns
            "fill:min:grow,min" // rows
            );
    pnlCategoryFoods.setLayout(lyo03);
    JButton btnAddCategory = new JButton("+");
    JButton btnDeleteCategory = new JButton("-");
    JButton btnRenameCategory = new JButton("r");
    JButton btnExportCategory = new JButton("e");
    JLabel lblSearch = new JLabel("Search: ");
    lblSearch.setToolTipText(
        "Search field input should be a valid regex expression (case insensitive match)");
    JButton btnAddFood = new JButton("+");
    JButton btnDeleteFood = new JButton("-");
    btnAddCategory.setToolTipText("Create category");
    btnDeleteCategory.setToolTipText("Delete category");
    btnRenameCategory.setToolTipText("Rename category");
    btnExportCategory.setToolTipText("Export category");
    btnAddFood.setToolTipText("Add food item to category");
    btnDeleteFood.setToolTipText("Remove food item from category");
    pnlAllFoods.setBorder(new TitledBorder("All Food Items"));
    pnlCategories.setBorder(new TitledBorder("Categories"));
    scrCategoryFoodTable.setBorder(new TitledBorder("Foods"));
    lyo.setColumnGroups(new int[][] {{1, 2}});
    pnlMain.setLayout(lyo);
    pnlAllFoodsComp.setLayout(lyo00);
    pnlCategoryButtons.setLayout(lyoButtons);
    pnlFoodButtonsMinus.setLayout(lyoButtons01);
    pnlAllFoods.setLayout(lyo02);
    pnlCategories.setLayout(lyo01);
    pnlCategoryFoods.add(scrCategoryFoodTable, cc.xy(1, 1));
    pnlCategoryFoods.add(pnlFoodButtonsMinus, cc.xy(1, 2));
    pnlCategoryButtons.add(btnAddCategory, cc.xy(2, 1));
    pnlCategoryButtons.add(btnDeleteCategory, cc.xy(3, 1));
    pnlCategoryButtons.add(btnRenameCategory, cc.xy(4, 1));
    pnlCategoryButtons.add(btnExportCategory, cc.xy(5, 1));
    pnlAllFoodsComp.add(pnlAllFoods, cc.xy(1, 1));
    pnlAllFoods.add(lblSearch, cc.xy(1, 1));
    pnlAllFoods.add(txtSearch, cc.xy(2, 1));
    pnlAllFoods.add(scrAllFoodsTable, cc.xyw(1, 3, 2));
    pnlFoodButtonsMinus.add(btnAddFood, cc.xy(2, 1));
    pnlFoodButtonsMinus.add(btnDeleteFood, cc.xy(3, 1));
    pnlCategories.add(scrCategoryTable, cc.xy(1, 1));
    pnlCategories.add(pnlCategoryButtons, cc.xy(1, 2));
    spl.setOrientation(JSplitPane.VERTICAL_SPLIT);
    spl.setDividerLocation(200);
    spl.setTopComponent(pnlCategories);
    spl.setBottomComponent(pnlCategoryFoods);
    pnlMain.add(pnlAllFoodsComp, cc.xy(1, 1));
    pnlMain.add(spl, cc.xy(2, 1));
    try {
      Future<List<List>> task = BackgroundExec.submit(new FoodCategoriesTask());
      List<List> categories = task.get();
      tblCategory.reload(categories);
    } catch (Exception e) {
      LoggerImpl.INSTANCE.logProblem(e);
    }
    btnAddCategory.addActionListener(
        (ActionEvent e) -> {
          addCategory();
        });
    btnRenameCategory.addActionListener(
        (ActionEvent e) -> {
          renameCategory();
        });
    btnDeleteCategory.addActionListener(
        (ActionEvent e) -> {
          deleteCategory();
        });
    btnExportCategory.addActionListener(
        (ActionEvent e) -> {
          exportCategory();
        });
    tblCategory
        .getSelectionModel()
        .addListSelectionListener(
            (ListSelectionEvent a) -> {
              if (a.getValueIsAdjusting()) {
                return;
              }
              if (tblCategory.isSelectionEmpty()) {
                return;
              }
              TableCategory.Row category = tblCategory.getSelectedValue();
              try {
                Future<List<List>> task =
                    BackgroundExec.submit(new FoodsInCategoryTask((category.getCategoryid())));
                List<List> categoryFoods = task.get();
                tblCategoryFood.reload(categoryFoods);
              } catch (Exception e) {
                LoggerImpl.INSTANCE.logProblem(e);
              }
            });
    btnAddFood.addActionListener(
        (ActionEvent e) -> {
          addFoodToCategory();
        });
    btnDeleteFood.addActionListener(
        (ActionEvent e) -> {
          removeFoodFromCategory();
        });
    return pnlMain;
  }

  private JPanel getFoodComparisonPanel() {
    JPanel pnl = new JPanel();
    tblFoodDiffA = new TableFood();
    tblFoodDiffB = new TableFood();
    tblFoodDiff = new TableFoodDiff();
    JScrollPane scrC = new JScrollPane(tblFoodDiff);
    JPanel pnlSearch = new JPanel();
    JLabel lblSearch = new JLabel("Search: ");
    lblSearch.setToolTipText(
        "Search field input should be a valid regex expression (case insensitive match)");
    FormLayout lyo =
        new FormLayout(
            "4px,391px:grow,4px,391px:grow,4px,678px:grow,4px", // columns
            "min,fill:min:grow,4px" // rows
            );
    FormLayout lyo02 =
        new FormLayout(
            "min,min:grow", // columns
            "4dlu,fill:16dlu,4dlu" // rows
            );
    JPanel pnlFoodAList = new JPanel();
    JPanel pnlFoodBList = new JPanel();
    FormLayout lyo03 =
        new FormLayout(
            "min,min:grow", // columns
            "4dlu,fill:16dlu,4dlu,fill:min:grow" // rows
            );
    pnlFoodAList.setLayout(lyo03);
    JScrollPane scrA = new JScrollPane(tblFoodDiffA);
    scrA.setBorder(new TitledBorder("Food A"));
    JLabel lblA = new JLabel("Search: ");
    lblA.setToolTipText(
        "Search field input should be a valid regex expression (case insensitive match)");
    pnlFoodAList.add(lblA, cc.xy(1, 2));
    JTextField txtComparisonFoodASearch = tblFoodDiffA.getTxtSearch();
    pnlFoodAList.add(txtComparisonFoodASearch, cc.xy(2, 2));
    pnlFoodAList.add(scrA, cc.xyw(1, 4, 2));
    pnlFoodBList.setLayout(lyo03);
    JScrollPane scrB = new JScrollPane(tblFoodDiffB);
    scrB.setBorder(new TitledBorder("Food B"));
    JLabel lblB = new JLabel("Search: ");
    lblB.setToolTipText(
        "Search field input should be a valid regex expression (case insensitive match)");
    pnlFoodBList.add(lblB, cc.xy(1, 2));
    JTextField txtComparisonFoodBSearch = tblFoodDiffB.getTxtSearch();
    pnlFoodBList.add(txtComparisonFoodBSearch, cc.xy(2, 2));
    pnlFoodBList.add(scrB, cc.xyw(1, 4, 2));
    pnl.setLayout(lyo);
    pnl.add(pnlFoodAList, cc.xywh(2, 1, 1, 2));
    pnl.add(pnlFoodBList, cc.xywh(4, 1, 1, 2));
    pnlSearch.setLayout(lyo02);
    lblSearch.setHorizontalAlignment(SwingConstants.RIGHT);
    pnlSearch.add(lblSearch, cc.xy(1, 2));
    pnlSearch.add(tblFoodDiff.getSearchField(), cc.xy(2, 2));
    pnl.add(pnlSearch, cc.xy(6, 1));
    pnl.add(scrC, cc.xy(6, 2));
    scrC.setBorder(new TitledBorder("Food Difference"));
    tblFoodDiffA
        .getSelectionModel()
        .addListSelectionListener(
            (ListSelectionEvent a) -> {
              if (a.getValueIsAdjusting()) {
                return;
              }
              if (tblFoodDiffA.isSelectionEmpty()) {
                return;
              }
              if (tblFoodDiffB.isSelectionEmpty()) {
                return;
              }
              int selectedRowA = tblFoodDiffA.getSelectedRow();
              int selectedRowB = tblFoodDiffB.getSelectedRow();
              String fooddiffida = (String) tblFoodDiffA.getValueAt(selectedRowA, 0);
              String fooddiffidb = (String) tblFoodDiffB.getValueAt(selectedRowB, 0);
              try {
                Future<List<List>> task =
                    BackgroundExec.submit(new FoodDifferenceTask(fooddiffida, fooddiffidb));
                List<List> diff = task.get();
                tblFoodDiff.reload(diff);
              } catch (Exception e) {
                LoggerImpl.INSTANCE.logProblem(e);
              }
            });
    tblFoodDiffB
        .getSelectionModel()
        .addListSelectionListener(
            (ListSelectionEvent a) -> {
              if (a.getValueIsAdjusting()) {
                return;
              }
              if (tblFoodDiffA.isSelectionEmpty()) {
                return;
              }
              if (tblFoodDiffB.isSelectionEmpty()) {
                return;
              }
              int selectedRowA = tblFoodDiffA.getSelectedRow();
              int selectedRowB = tblFoodDiffB.getSelectedRow();
              String fooddiffida = (String) tblFoodDiffA.getValueAt(selectedRowA, 0);
              String fooddiffidb = (String) tblFoodDiffB.getValueAt(selectedRowB, 0);
              try {
                Future<List<List>> task =
                    BackgroundExec.submit(new FoodDifferenceTask(fooddiffida, fooddiffidb));
                List<List> diff = task.get();
                tblFoodDiff.reload(diff);
              } catch (Exception e) {
                LoggerImpl.INSTANCE.logProblem(e);
              }
            });
    return pnl;
  }

  private JPanel getFoodQuantityConstraint() {
    JPanel pnl = new JPanel();
    FormLayout panelLayout =
        new FormLayout(
            "p,p,p,p:grow", // columns
            "p,p,fill:p:grow,min" // rows
            );
    pnl.setLayout(panelLayout);
    tblFoodQuantityConstraint = new TableFoodQuantityConstraint();
    JScrollPane spTable = new JScrollPane(tblFoodQuantityConstraint);
    Integer width =
        TableColumnWidth.Food.getWidth()
            + TableColumnWidth.Nutrient.getWidth()
            + 21
            + 90
            + TableColumnWidth.Scrollbar.getWidth();
    spTable.setPreferredSize(new Dimension(width, 0));
    JPanel buttons = new JPanel();
    txtFoodQuantityValue.setPreferredSize(Dimensions.Quantity.get());
    pnl.add(cmbFoodQuantityFood, cc.xyw(1, 1, 4));
    pnl.add(cmbFoodQuantityNutrient, cc.xy(1, 2));
    pnl.add(cmbFoodQuantityRelationship, cc.xy(2, 2));
    pnl.add(txtFoodQuantityValue, cc.xy(3, 2));
    pnl.add(spTable, cc.xyw(1, 3, 4));
    buttons.add(btnAddFoodQuantityConstraint);
    buttons.add(btnDeleteFoodQuantityConstraint);
    pnl.add(buttons, cc.xyw(1, 4, 4));
    spTable.setBorder(new TitledBorder("Food Nutrient Constraints"));
    cmbFoodQuantityNutrient.setMaximumRowCount(10);
    cmbFoodQuantityRelationship.setMaximumRowCount(3);
    cmbFoodQuantityFood.setMaximumRowCount(10);
    btnAddFoodQuantityConstraint.setToolTipText("Add Constraint");
    btnDeleteFoodQuantityConstraint.setToolTipText("Delete Constraint");
    btnAddFoodQuantityConstraint.addActionListener(
        (ActionEvent e) -> {
          addFoodQuantityConstraint();
        });
    btnDeleteFoodQuantityConstraint.addActionListener(
        (ActionEvent e) -> {
          removeFoodQuantityConstraint();
        });
    tblFoodQuantityConstraint
        .getSelectionModel()
        .addListSelectionListener(
            (ListSelectionEvent e) -> {
              if (e.getValueIsAdjusting()) {
                return;
              }
              if (tblFoodQuantityConstraint.isSelectionEmpty()) {
                return;
              }
              setFoodQuantityConstraintGuiValues();
            });
    return pnl;
  }

  private JPanel getFoodList() {
    JPanel pnl = new JPanel();
    FormLayout paneLayout =
        new FormLayout(
            "4dlu,min:grow,4dlu", // columns
            "min,fill:min:grow,4dlu,min,4dlu" // rows
            );
    pnl.setLayout(paneLayout);
    JPanel searchPanel = new JPanel();
    FormLayout searchPanelLayout =
        new FormLayout(
            "min,min:grow", // columns
            "4dlu,fill:16dlu,4dlu" // rows
            );
    searchPanel.setLayout(searchPanelLayout);
    JPanel buttonPanel = new JPanel();
    FormLayout buttonPanelLayout =
        new FormLayout(
            "min:grow,min,min,min,min,min:grow", // columns
            "min" // rows
            );
    buttonPanel.setLayout(buttonPanelLayout);
    tblFoods = new TableFoodDetails();
    JScrollPane scrollPaneTable01 = new JScrollPane(tblFoods);
    scrollPaneTable01.getViewport().setScrollMode(JViewport.BLIT_SCROLL_MODE);
    JLabel label = new JLabel("Search: ");
    label.setToolTipText(
        "Search field input should be a valid regex expression (case insensitive match)");
    label.setHorizontalAlignment(SwingConstants.RIGHT);
    searchPanel.add(label, cc.xy(1, 2));
    searchPanel.add(tblFoods.getTxtSearch(), cc.xy(2, 2));
    buttonPanel.add(btnAddFood, cc.xy(2, 1));
    buttonPanel.add(btnUpdateFood, cc.xy(3, 1));
    buttonPanel.add(btnRenameFood, cc.xy(4, 1));
    buttonPanel.add(btnDeleteFood, cc.xy(5, 1));
    pnl.add(searchPanel, cc.xy(2, 1));
    pnl.add(scrollPaneTable01, cc.xy(2, 2));
    pnl.add(buttonPanel, cc.xy(2, 4));
    scrollPaneTable01.setBorder(new TitledBorder("Food List"));
    btnAddFood.setToolTipText("Add food item");
    btnUpdateFood.setToolTipText("Update food item");
    btnRenameFood.setToolTipText("Rename food item");
    btnDeleteFood.setToolTipText("Delete food item");
    btnAddFood.addActionListener(
        (ActionEvent e) -> {
          addFoodToDatabase();
        });
    btnUpdateFood.addActionListener(
        (ActionEvent e) -> {
          addDerivativeFoodToDatabase();
        });
    btnRenameFood.addActionListener(
        (ActionEvent e) -> {
          renameFoodItemInDatabase();
        });
    btnDeleteFood.addActionListener(
        (ActionEvent e) -> {
          removeFoodFromDatabase();
        });
    tblFoods
        .getSelectionModel()
        .addListSelectionListener(
            (ListSelectionEvent e) -> {
              if (e.getValueIsAdjusting()) {
                return;
              }
              if (tblFoods.isSelectionEmpty()) {
                return;
              }
            });
    JPopupMenu pmn = new JPopupMenu();
    JMenuItem mniFoodStats = new JMenuItem("Show food statistics");
    pmn.add(mniFoodStats);
    mniFoodStats.addActionListener(
        (ActionEvent e) -> {
          if (!tblFoods.isSelectionEmpty()) {
            TableFoodDetails.Row food = tblFoods.getSelectedValue();
            showFoodStats(food.getId());
          } else {
            Message.showMessage("Please select food item");
          }
        });
    tblFoods.addMouseListener(
        new MouseAdapter() {
          @Override
          public void mouseClicked(MouseEvent e) {
            super.mouseClicked(e);
            if (SwingUtilities.isRightMouseButton(e)) {
              Component component = e.getComponent();
              pmn.show(component, e.getX(), e.getY());
            }
          }
        });
    return pnl;
  }

  private JPanel getFoodRatioPanel() {
    JPanel pnl = new JPanel();
    tblFoodRatioConstraint = new TableFoodRatioConstraint();
    JScrollPane scrTable = new JScrollPane(tblFoodRatioConstraint);
    JPanel buttons = new JPanel();
    FormLayout panelLayout =
        new FormLayout(
            "p,p,p,p:grow", // columns
            "p,p,p,p,fill:min:grow,min" // rows
            );
    pnl.setLayout(panelLayout);
    Integer width =
        TableColumnWidth.Food.getWidth()
            + TableColumnWidth.Nutrient.getWidth()
            + 21
            + 90
            + TableColumnWidth.Scrollbar.getWidth();
    scrTable.setBorder(new TitledBorder("Food Nutrient Ratio Constraints"));
    scrTable.setPreferredSize(new Dimension(width, 0));
    txtFoodNutrientRatioQuantityA.setPreferredSize(Dimensions.Quantity.get());
    txtFoodNutrientRatioQuantityB.setPreferredSize(Dimensions.Quantity.get());
    pnl.add(cmbFoodRatioFoodA, cc.xyw(1, 1, 4));
    pnl.add(cmbFoodRatioNutrientA, cc.xy(1, 2));
    pnl.add(txtFoodNutrientRatioQuantityA, cc.xy(2, 2));
    pnl.add(cmbFoodRatioRelationship, cc.xy(3, 2));
    pnl.add(cmbFoodRatioFoodB, cc.xyw(1, 3, 4));
    pnl.add(cmbFoodRatioNutrientB, cc.xy(1, 4));
    pnl.add(txtFoodNutrientRatioQuantityB, cc.xy(2, 4));
    pnl.add(scrTable, cc.xyw(1, 5, 4));
    buttons.add(btnAddFoodRatioConstraint);
    buttons.add(btnDeleteFoodRatioConstraint);
    pnl.add(buttons, cc.xyw(1, 6, 4));
    cmbFoodRatioNutrientA.setMaximumRowCount(10);
    cmbFoodRatioNutrientB.setMaximumRowCount(10);
    cmbFoodRatioFoodA.setMaximumRowCount(10);
    cmbFoodRatioFoodB.setMaximumRowCount(10);
    btnAddFoodRatioConstraint.setToolTipText("Add Constraint");
    btnDeleteFoodRatioConstraint.setToolTipText("Delete Constraint");
    btnAddFoodRatioConstraint.addActionListener(
        (ActionEvent e) -> {
          addFoodRatioConstraint();
        });
    btnDeleteFoodRatioConstraint.addActionListener(
        (ActionEvent e) -> {
          deleteFoodRatioConstraint();
        });
    tblFoodRatioConstraint
        .getSelectionModel()
        .addListSelectionListener(
            (ListSelectionEvent e) -> {
              if (e.getValueIsAdjusting()) {
                return;
              }
              if (tblFoodRatioConstraint.isSelectionEmpty()) {
                return;
              }
              setFoodRatioConstraintGuiValues();
            });
    return pnl;
  }

  private JPanel getMealPlanUsagePanel() {
    JPanel pnl = new JPanel();
    FormLayout lyo =
        new FormLayout(
            "p:grow", // columns
            "fill:min:grow" // rows
            );
    pnl.setLayout(lyo);
    JSplitPane spl00 = new JSplitPane();
    JSplitPane spl01 = new JSplitPane();
    spl00.setLeftComponent(getMealPlanUsageMixesPanel());
    spl00.setRightComponent(getMealPlanUsageDaysPanel());
    spl01.setLeftComponent(spl00);
    spl01.setRightComponent(getMealPlanUsageResultPanel());
    pnl.add(spl01, cc.xy(1, 1));
    try {
      Future<List<List>> task = BackgroundExec.submit(new MealPlanUsageTask());
      List<List> usage = task.get();
      tblMealPlanUsage.reload(usage);
    } catch (Exception e) {
      LoggerImpl.INSTANCE.logProblem(e);
    }
    try {
      Future<List<List>> task = BackgroundExec.submit(new MealPlanUsageResultsTask());
      List<List> results = task.get();
      tblMealPlanUsageResults.reload(results);
    } catch (Exception e) {
      LoggerImpl.INSTANCE.logProblem(e);
    }
    return pnl;
  }

  private JPanel getMealsPanel() {
    JPanel pnl = new JPanel();
    FormLayout lyo =
        new FormLayout(
            "p:grow", // columns
            "fill:min:grow,min" // rows
            );
    pnl.setLayout(lyo);
    tblMeals = new TablePortionMeals();
    JScrollPane spTable = new JScrollPane(tblMeals);
    spTable.setPreferredSize(Dimensions.D1.get());
    JPanel buttons = new JPanel();
    pnl.add(spTable, cc.xy(1, 1));
    buttons.add(btnAddMeal);
    buttons.add(btnDeleteMeal);
    buttons.add(btnUpdateMeal);
    pnl.add(buttons, cc.xy(1, 2));
    spTable.setBorder(new TitledBorder("Meals"));
    btnAddMeal.setToolTipText("Add Meal");
    btnDeleteMeal.setToolTipText("Delete Meal");
    btnUpdateMeal.setToolTipText("Update Meal");
    btnAddMeal.addActionListener(
        (ActionEvent e) -> {
          addMeal();
        });
    btnDeleteMeal.addActionListener(
        (ActionEvent e) -> {
          deleteMeal();
        });
    btnUpdateMeal.addActionListener(
        (ActionEvent e) -> {
          updateMeal();
        });
    return pnl;
  }

  private JPanel getMealCaloriesPanel() {
    JPanel pnl = new JPanel();
    ColumnBuild columns = new ColumnBuild();
    columns.add(803);
    RowBuild rows = new RowBuild();
    rows.add(RowBuild.rowAlignment.FILL, RowBuild.componentSize.MIN, RowBuild.resizeBehavior.GROW);
    FormLayout lyo = new FormLayout(columns.get(), rows.get());
    pnl.setLayout(lyo);
    tblMealCalories = new TableMealCalories();
    JScrollPane spTable = new JScrollPane(tblMealCalories);
    pnl.add(spTable, cc.xy(1, 1));
    return pnl;
  }

  private JPanel getMealMacronutrientsPanel() {
    JPanel pnl = new JPanel();
    ColumnBuild columns = new ColumnBuild();
    columns.add(878);
    RowBuild rows = new RowBuild();
    rows.add(RowBuild.rowAlignment.FILL, RowBuild.componentSize.MIN, RowBuild.resizeBehavior.GROW);
    FormLayout lyo = new FormLayout(columns.get(), rows.get());
    pnl.setLayout(lyo);
    tblMealMacronutrients = new TableMealGrams();
    JScrollPane spTable = new JScrollPane(tblMealMacronutrients);
    pnl.add(spTable, cc.xy(1, 1));
    return pnl;
  }

  private JPanel getMealPortionsPanel() {
    JPanel pnl = new JPanel();
    tblMealPortions = new TablePortion();
    ColumnBuild columns = new ColumnBuild();
    columns.add(ColumnBuild.componentSize.PREF);
    columns.add(ColumnBuild.componentSize.PREF);
    columns.add(ColumnBuild.componentSize.PREF);
    columns.add(800);
    columns.add(ColumnBuild.componentSize.PREF);
    columns.add(ColumnBuild.componentSize.PREF);
    columns.add(ColumnBuild.componentSize.PREF);
    RowBuild rows = new RowBuild();
    rows.add(RowBuild.rowAlignment.FILL, 25);
    rows.add(RowBuild.rowAlignment.FILL, 200);
    rows.add(RowBuild.rowAlignment.FILL, 25);
    rows.add(RowBuild.rowAlignment.FILL, RowBuild.componentSize.MIN, RowBuild.resizeBehavior.GROW);
    rows.add(RowBuild.componentSize.PREF);
    FormLayout lyo = new FormLayout(columns.get(), rows.get());
    pnl.setLayout(lyo);
    JScrollPane spPortions = new JScrollPane(tblMealPortions);
    JPanel buttons = new JPanel();
    txtTotalPct.setEditable(false);
    txtTotalPct.setPreferredSize(Dimensions.Pct.get());
    txtPortionPct.setPreferredSize(Dimensions.Pct.get());
    JLabel lblSearch = new JLabel("Search: ");
    lblSearch.setToolTipText(
        "Search field input should be a valid regex expression (case insensitive match)");
    lblSearch.setHorizontalAlignment(SwingConstants.RIGHT);
    JLabel lblPortionPct = new JLabel("Portion: ");
    JLabel lblPortionPct2 = new JLabel("% ");
    lblPortionPct.setHorizontalAlignment(SwingConstants.RIGHT);
    JLabel lblAllocatedPct = new JLabel(" Allocated: ");
    lblAllocatedPct.setHorizontalAlignment(SwingConstants.RIGHT);
    JLabel lblTotalPct2 = new JLabel("%");
    buttons.add(btnAddPortion);
    buttons.add(btnDeletePortion);
    buttons.add(btnUpdatePortionWeight);
    pnl.add(lblPortionPct, cc.xy(1, 1));
    pnl.add(txtPortionPct, cc.xy(2, 1));
    pnl.add(lblPortionPct2, cc.xy(3, 1));
    pnl.add(cmbPortionFood, cc.xy(4, 1));
    pnl.add(lblAllocatedPct, cc.xy(5, 1));
    pnl.add(txtTotalPct, cc.xy(6, 1));
    pnl.add(lblTotalPct2, cc.xy(7, 1));
    pnl.add(getMealsPanel(), cc.xyw(1, 2, 7));
    pnl.add(lblSearch, cc.xy(1, 3));
    pnl.add(tblMealPortions.getSearchField(), cc.xyw(2, 3, 6));
    pnl.add(spPortions, cc.xyw(1, 4, 7));
    pnl.add(buttons, cc.xyw(1, 5, 7));
    spPortions.setBorder(new TitledBorder("Food Portions"));
    cmbPortionFood.setMaximumRowCount(6);
    btnAddPortion.setToolTipText("Add one or more food portions");
    btnDeletePortion.setToolTipText("Delete one or more food portions");
    btnUpdatePortionWeight.setToolTipText("Update weight of food portion consumed");
    btnAddPortion.addActionListener(
        (ActionEvent e) -> {
          addFoodPortion();
        });
    btnDeletePortion.addActionListener(
        (ActionEvent e) -> {
          deleteFoodPortion();
        });
    btnUpdatePortionWeight.addActionListener(
        (ActionEvent e) -> {
          updateFoodPortionWeight();
        });
    cmbPortionFood.addActionListener(
        (ActionEvent e) -> {
          calculateRemainingFoodAllocationPercentage();
        });
    JPopupMenu pmn = new JPopupMenu();
    JMenuItem item01 = new JMenuItem("Assign portion to meal");
    pmn.add(item01);
    item01.addActionListener(
        (ActionEvent e) -> {
          moveFoodPortion();
        });
    tblMealPortions.addMouseListener(
        new MouseAdapter() {
          @Override
          public void mouseClicked(MouseEvent e) {
            super.mouseClicked(e);
            showPopup(e, pmn);
          }
        });
    return pnl;
  }

  private JMenuBar getMenuBar() {
    JMenuBar mnuBar = new JMenuBar();
    mnuBar.add(mnuProgram);
    mnuBar.add(mnuMix);
    mnuBar.add(mnuTools);
    mnuBar.add(mnuData);
    mnuBar.add(mnuReport);
    mnuBar.add(mnuHelp);
    mnuProgram.add(mnuSettings);
    mnuProgram.add(mniExit);
    mnuTools.add(mniConvertDRI);
    mnuTools.add(mniCalculateBMR);
    mnuTools.add(mniCalculateProteinRequired);
    mnuTools.add(mniShowCarbohydrateRequired);
    mnuTools.add(mniCalculateDigestibleCarbs);
    mnuTools.add(mniCalculateGL);
    mnuTools.add(mniCalculateGIRange);
    mnuTools.add(mniCalculateALARequired);
    mnuData.add(mnuFoodsData);
    mnuData.add(mnuMixModel);
    mnuData.add(mnuDELETE);
    mnuReport.add(mniCreateMixResultsReport1);
    mnuReport.add(mniCreateMixResultsReport2);
    mnuReport.add(mniCreateMixDriReport);
    mnuReport.add(mniCreateMixComparisonReport);
    mnuReport.add(mniCreateMealPlanPortionsReport);
    mnuReport.add(mniCreateMealPlanCaloriesReport);
    mnuReport.add(mniCreateMealPlanMacronutrientsReport);
    mnuReport.add(mniCreateMealPlanUsageReport);
    mnuReport.add(mniCreateNutrientSearchReport);
    mnuReport.add(mniCreateFoodComparisonReport);
    mnuReport.add(mniCreateAllFoodsReport1);
    mnuReport.add(mniCreateAllFoodsReport2);
    mnuDELETE.add(mniDELETEMIXES);
    mnuDELETE.add(mniDELETEALL);
    mnuMixModel.add(mniImportMixModel);
    mnuMixModel.add(mniExportMixModel);
    mnuFoodsData.add(mniImportFoods);
    mnuHelp.add(mniProject);
    mnuHelp.add(mniCredits);
    mnuHelp.add(mniAbout);
    mnuHelp.add(mniAuthor);
    mnuSettings.add(chkResultRoundUp);
    mnuSettings.add(chkLpsolve);
    mnuSettings.add(mniSetConstraints);
    mnuMix.add(mniCreateMix);
    mnuMix.add(mniDeleteMix);
    mnuMix.add(mniRenameMix);
    mnuMix.add(mniDuplicateMix);
    mnuMix.add(mniPinMix);
    mnuMix.add(mniConvertMix);
    mnuMix.add(mniSetMinimizationOption);
    mnuMix.add(mniShowMixStats);
    mnuProgram.setText("Program");
    mnuMix.setText("Mix");
    mnuTools.setText("Tools");
    mnuData.setText("Data");
    mnuData.setToolTipText("Find your documents in snack's model directory");
    mnuHelp.setText("Help");
    mnuSettings.setText("Settings");
    mniExit.setText("Exit");
    mniConvertDRI.setText("Convert daily value (%DV) required to grams");
    mniCalculateBMR.setText("Calculate basal metabolic rate of an individual");
    mniCalculateProteinRequired.setText(
        "Calculate complete protein required in a no fat, no carbohydrate regimen");
    mniShowCarbohydrateRequired.setText("Show carbohydrate required to inhibit ketosis");
    mniCalculateDigestibleCarbs.setText("Calculate digestible carbohydrate of a food item");
    mniCalculateGL.setText("Calculate glycemic load of a food item");
    mniCalculateALARequired.setText("Calculate alpha-linolenic acid required");
    mniCalculateGIRange.setText("Show glycemic index range of a food item");
    mnuReport.setText("Reports");
    mnuMixModel.setText("Model");
    mnuMixResult.setText("Result");
    mnuFoodsData.setText("Food");
    mniCreateAllFoodsReport1.setText("All Foods #1");
    mniCreateAllFoodsReport2.setText("All Foods #2");
    mniCreateFoodComparisonReport.setText("Food Comparison");
    mniCreateMixDriReport.setText("Mix Daily Reference Intake");
    mniCreateMixComparisonReport.setText("Mix Comparison");
    mniCreateMixResultsReport1.setText("Mix Results #1");
    mniCreateMixResultsReport2.setText("Mix Results #2");
    mniCreateNutrientSearchReport.setText("Nutrient Search");
    mniCreateMealPlanCaloriesReport.setText("Meal Plan Calories");
    mniCreateMealPlanMacronutrientsReport.setText("Meal Plan Macronutrients");
    mniCreateMealPlanPortionsReport.setText("Meal Plan Portions");
    mniCreateMealPlanUsageReport.setText("Meal Plan Usage");
    mniImportMixModel.setText("Import");
    mniExportMixModel.setText("Export");
    mniImportFoods.setText("Import");
    chkResultRoundUp.setText("Round up result values");
    chkLpsolve.setText("Write model in LPSOLVE format");
    mniSetConstraints.setText("Show visible constraints");
    mniProject.setText("Project");
    mniCredits.setText("Credits");
    mniAbout.setText("About");
    mniAuthor.setText("Author");
    mniCreateMix.setText("Create mix");
    mniDeleteMix.setText("Delete mix");
    mniRenameMix.setText("Rename mix");
    mniDuplicateMix.setText("Duplicate mix");
    mniPinMix.setText("Pin mix");
    mniConvertMix.setText("Convert mix to food item");
    mniSetMinimizationOption.setText("Choose minimization option");
    mniShowMixStats.setText("Show mix statistics");
    mnuDELETE.setText("DELETE");
    mniDELETEMIXES.setText("DELETE ALL MIXES");
    mniDELETEALL.setText("DELETE ALL MIXES AND ALL FOOD ITEMS");
    chkResultRoundUp.setSelected(true);
    mniConvertDRI.addActionListener(
        (ActionEvent e) -> {
          convertMicronutrient();
        });
    mniCalculateBMR.addActionListener(
        (ActionEvent e) -> {
          calculateBmr();
        });
    mniCalculateProteinRequired.addActionListener(
        (ActionEvent e) -> {
          calculateProteinNeededForNitrogenBalance();
        });
    mniShowCarbohydrateRequired.addActionListener(
        (ActionEvent e) -> {
          showKetosis();
        });
    mniCalculateDigestibleCarbs.addActionListener(
        (ActionEvent e) -> {
          calculateDigestibleCarbs();
        });
    mniCalculateGL.addActionListener(
        (ActionEvent e) -> {
          calculateGlycemicLoad();
        });
    mniCalculateALARequired.addActionListener(
        (ActionEvent e) -> {
          calculateN3FattyAcidRequired();
        });
    mniShowMixStats.addActionListener(
        (ActionEvent e) -> {
          showMixStats();
        });
    mniCalculateGIRange.addActionListener(
        (ActionEvent e) -> {
          calculateGlycemicIndexRange();
        });
    mniCreateAllFoodsReport1.addActionListener(
        (ActionEvent e) -> {
          createAllFoodsReport1();
        });
    mniCreateAllFoodsReport2.addActionListener(
        (ActionEvent e) -> {
          createAllFoodsReport2();
        });
    mniCreateFoodComparisonReport.addActionListener(
        (ActionEvent e) -> {
          if (tblFoodDiffA.isSelectionEmpty() || tblFoodDiffB.isSelectionEmpty()) {
            Message.showMessage("You need to select two food items to compare first.");
            return;
          }
          createFoodComparisonReport();
          Message.showMessage("Food Comparison Report created.");
        });
    mniCreateMixComparisonReport.addActionListener(
        (ActionEvent e) -> {
          if (tblMixDiffA.isSelectionEmpty() || tblMixDiffB.isSelectionEmpty()) {
            Message.showMessage("You need to select two mixes to compare first.");
            return;
          }
          createMixComparisonReport();
          Message.showMessage("Mix Comparison Report created.");
        });
    mniCreateMixResultsReport1.addActionListener(
        (ActionEvent e) -> {
          createMixResultsReport1();
          Message.showMessage("Mix Results Report #1 created.");
        });
    mniCreateMixResultsReport2.addActionListener(
        (ActionEvent e) -> {
          createMixResultsReport2();
          Message.showMessage("Mix Results Report #2 created.");
        });
    mniCreateMixDriReport.addActionListener(
        (ActionEvent e) -> {
          createDriReport();
          Message.showMessage("Daily Reference Intake Report created.");
        });
    mniCreateNutrientSearchReport.addActionListener(
        (ActionEvent e) -> {
          if (txtNutrientSearchQuantity.getText().isBlank()) {
            Message.showMessage(
                "You need to search for food items that contain the nutrient first.");
            return;
          }
          createNutrientContentReport();
          Message.showMessage("Nutrient Search Report created.");
        });
    mniCreateMealPlanCaloriesReport.addActionListener(
        (ActionEvent e) -> {
          if (tblMealPortions.isEmpty()) {
            Message.showMessage("You need to create meal plan first.");
            return;
          }
          createMealPlanCaloriesReport();
          Message.showMessage("Meal Plan Calories Report created.");
        });
    mniCreateMealPlanMacronutrientsReport.addActionListener(
        (ActionEvent e) -> {
          if (tblMealPortions.isEmpty()) {
            Message.showMessage("You need to create meal plan first.");
            return;
          }
          createMealPlanMacronutrientsReport();
          Message.showMessage("Meal Plan Macronutrients Report created.");
        });
    mniCreateMealPlanPortionsReport.addActionListener(
        (ActionEvent e) -> {
          if (tblMealPortions.isEmpty()) {
            Message.showMessage("You need to create meal plan first.");
            return;
          }
          createMealPlanPortionsReport();
          Message.showMessage("Meal Plan Portions Report created.");
        });
    mniCreateMealPlanUsageReport.addActionListener(
        (ActionEvent e) -> {
          if (tblMealPlanUsage.isEmpty()) {
            Message.showMessage("You need to create meal plan usage first.");
            return;
          }
          createMealPlanUsageReport();
          Message.showMessage("Meal Plan Usage Report created.");
        });
    mniDELETEMIXES.addActionListener(
        (ActionEvent e) -> {
          deleteAllMixes();
        });
    mniDELETEALL.addActionListener(
        (ActionEvent e) -> {
          deleteAll();
        });
    mniExportMixModel.addActionListener(
        (ActionEvent e) -> {
          exportMix();
        });
    mniImportMixModel.addActionListener(
        (ActionEvent evt) -> {
          MixDO mix = new MixDO();
          frm.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
          mix = importMix();
          if (mix.getMixId().isEmpty()) {
            frm.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
            return;
          }
          solveModel(mix);
          try {
            Future<List<List>> task = BackgroundExec.submit(new MixesTask());
            List<List> lst = task.get();
            List<MixDO> mixesList = Utilities.createMixDOList(lst);
            cmbMixes.reload(mixesList);
            tblMixDiffA.reload(lst);
            tblMixDiffB.reload(lst);
            tblMealPlanUsageMixes.reload(lst);
          } catch (Exception e) {
            LoggerImpl.INSTANCE.logProblem(e);
          }
          cmbMixes.setSelectedItem(mix);
          try {
            Future<List<List>> task = BackgroundExec.submit(new FoodFactsTask());
            List<List> foods = task.get();
            tblFoods.reload(foods);
            tblFoodDiffA.reload(foods);
            tblFoodDiffB.reload(foods);
            tblCategoryAllFoods.reload(foods);
          } catch (Exception e) {
            LoggerImpl.INSTANCE.logProblem(e);
          }
          try {
            Future<List<Map<String, Object>>> task = BackgroundExec.submit(new FoodsTask());
            List<Map<String, Object>> treeFoods = task.get();
            tremodelFoods.reload(treeFoods);
          } catch (Exception e) {
            LoggerImpl.INSTANCE.logProblem(e);
          }
          try {
            Future<List<List>> task = BackgroundExec.submit(new FoodCategoriesTask());
            List<List> categories = task.get();
            tblCategory.reload(categories);
          } catch (Exception e) {
            LoggerImpl.INSTANCE.logProblem(e);
          }
          frm.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        });
    mniImportFoods.addActionListener(
        (ActionEvent e) -> {
          importFoods();
        });
    mniProject.addActionListener(
        (ActionEvent e) -> {
          showProjectInformation();
        });
    mniCredits.addActionListener(
        (ActionEvent e) -> {
          showCredits();
        });
    mniAbout.addActionListener(
        (ActionEvent e) -> {
          showAbout();
        });
    mniAuthor.addActionListener(
        (ActionEvent e) -> {
          showAuthor();
        });
    mniSetConstraints.addActionListener(
        (ActionEvent e) -> {
          (new ConstraintChooser()).show();
          reloadCbNutrientData();
        });
    chkResultRoundUp.addActionListener(
        (ActionEvent e) -> {
          setQuantityScale();
        });
    mniExit.addActionListener(
        (ActionEvent e) -> {
          exit();
        });
    mniCreateMix.addActionListener(
        (ActionEvent e) -> {
          createMix();
        });
    mniDeleteMix.addActionListener(
        (ActionEvent e) -> {
          deleteMix();
        });
    mniRenameMix.addActionListener(
        (ActionEvent e) -> {
          renameMix();
        });
    mniSetMinimizationOption.addActionListener(
        (ActionEvent e) -> {
          String nutrientid = selectObjective();
          updateObjectiveDisplay(nutrientid);
        });
    mniDuplicateMix.addActionListener(
        (ActionEvent e) -> {
          duplicateMix();
        });
    mniConvertMix.addActionListener(
        (ActionEvent e) -> {
          convertMixToFood();
        });
    mniPinMix.addActionListener(
        (ActionEvent e) -> {
          pinMix();
        });
    return mnuBar;
  }

  private void exit() {
    mniExit.setEnabled(false);
    frm.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
    BackgroundExec.execute(
        () -> {
          try {
            Connect.getInstance().getConnection().close();
            (new Shutdown()).execute();
          } catch (Exception e) {
            e.printStackTrace();
          } finally {
            System.exit(0);
          }
        });
  }

  private MixDO importMix() {
    int returnVal = fch.showOpenDialog(frm);
    MixDO mix = new MixDO();
    if (returnVal == JFileChooser.APPROVE_OPTION) {
      File file = fch.getSelectedFile();
      String path = file.getAbsolutePath();
      fch.setCurrentDirectory(new File(path));
      mix = new MixImporter(path).receive();
    }
    return mix;
  }

  private void importFoods() {
    fch.setSelectedFile(new File(""));
    int returnVal = fch.showOpenDialog(frm);
    if (returnVal == JFileChooser.APPROVE_OPTION) {
      File file = fch.getSelectedFile();
      String path = file.getAbsolutePath();
      fch.setCurrentDirectory(new File(path));
      frm.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
      String schema = "/resources/schemas/foods.xsd";
      Boolean imported = false;
      ElapsedTime time = new ElapsedTime();
      try {
        time.start();
        imported = new FoodsImporter().importFoodListUsingResource(schema, path);
        time.end();
      } catch (Exception e) {
        LoggerImpl.INSTANCE.logProblem(e);
      } finally {
        if (imported) {
          try {
            Future<List<List>> task = BackgroundExec.submit(new FoodFactsTask());
            List<List> foods = task.get();
            tblFoods.reload(foods);
            tblFoodDiffA.reload(foods);
            tblFoodDiffB.reload(foods);
            tblCategoryAllFoods.reload(foods);
          } catch (Exception e) {
            LoggerImpl.INSTANCE.logProblem(e);
          }
          try {
            Future<List<Map<String, Object>>> task = BackgroundExec.submit(new FoodsTask());
            List<Map<String, Object>> treeFoods = task.get();
            tremodelFoods.reload(treeFoods);
          } catch (Exception e) {
            LoggerImpl.INSTANCE.logProblem(e);
          }
          try {
            Future<List<List>> task = BackgroundExec.submit(new FoodCategoriesTask());
            List<List> categories = task.get();
            tblCategory.reload(categories);
          } catch (Exception e) {
            LoggerImpl.INSTANCE.logProblem(e);
          }
          StringBuilder sb = new StringBuilder();
          sb.append("Food items were loaded in ");
          sb.append(time.getElapsedTimeInSeconds());
          sb.append(" seconds. ");
          Message.showMessage(sb.toString());
        } else {
          Message.showMessage("Food import failed. Please try again.");
        }
        setQuantityScale();
        frm.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
      }
    }
  }

  private JPanel getMinimizationOptionsPanel() {
    JPanel pnl = new JPanel();
    FormLayout lyo00 =
        new FormLayout(
            "4px,min:grow,4px", // columns
            "4px,fill:min:grow,4px" // rows
            );
    JPanel pnl01 = new JPanel();
    FormLayout lyo01 =
        new FormLayout(
            "min:grow,p,p,min:grow", // columns
            "fill:min:grow,p,fill:min:grow" // rows
            );
    //
    pnl.setLayout(lyo00);
    pnl.setPreferredSize(new Dimension(170, 55));
    pnl.add(pnl01, cc.xy(2, 2));
    pnl01.setLayout(lyo01);
    ButtonGroup minimizationOptionGroup = new ButtonGroup();
    minimizationOptionGroup.add(raiCalories);
    minimizationOptionGroup.add(raiCost);
    raiCalories.setText("Calories");
    raiCost.setText("Cost");
    pnl01.add(raiCalories, cc.xy(2, 2));
    pnl01.add(raiCost, cc.xy(3, 2));
    return pnl;
  }

  private JPanel getMixComparisonPanel() {
    JPanel pnl = new JPanel();
    tblMixDiffA = new TableMix();
    tblMixDiffB = new TableMix();
    tblMixDiff = new TableMixDiff();
    JScrollPane scrA = new JScrollPane(tblMixDiffA);
    JScrollPane scrB = new JScrollPane(tblMixDiffB);
    JScrollPane scrC = new JScrollPane(tblMixDiff);
    JPanel pnlSearch = new JPanel();
    JLabel lblSearch = new JLabel("Search: ");
    lblSearch.setToolTipText(
        "Search field input should be a valid regex expression (case insensitive match)");
    // create layouts
    FormLayout lyo00 =
        new FormLayout(
            "4px,391px:grow,4px,391px:grow,4px,678px:grow,4px", // columns
            "4px,min,fill:min:grow,4px" // rows
            );
    FormLayout lyo01 =
        new FormLayout(
            "min,min:grow", // columns
            "fill:16dlu,4dlu" // rows
            );
    pnl.setLayout(lyo00);
    pnl.add(scrA, cc.xywh(2, 2, 1, 2));
    pnl.add(scrB, cc.xywh(4, 2, 1, 2));
    pnlSearch.setLayout(lyo01);
    lblSearch.setHorizontalAlignment(SwingConstants.RIGHT);
    pnlSearch.add(lblSearch, cc.xy(1, 1));
    pnlSearch.add(tblMixDiff.getSearchField(), cc.xy(2, 1));
    pnl.add(pnlSearch, cc.xy(6, 2));
    pnl.add(scrC, cc.xy(6, 3));
    scrA.setBorder(new TitledBorder("Mix A"));
    scrB.setBorder(new TitledBorder("Mix B"));
    scrC.setBorder(new TitledBorder("Mix Difference"));
    tblMixDiffA
        .getSelectionModel()
        .addListSelectionListener(
            (ListSelectionEvent a) -> {
              if (a.getValueIsAdjusting()) {
                return;
              }
              if (tblMixDiffB.isSelectionEmpty()) {
                return;
              }
              TableMix.Row mixa = tblMixDiffA.getSelectedValue();
              TableMix.Row mixb = tblMixDiffB.getSelectedValue();
              try {
                Future<List<List>> task =
                    BackgroundExec.submit(new MixDifferenceTask(mixa.getMixid(), mixb.getMixid()));
                List<List> diff = task.get();
                tblMixDiff.reload(diff);
              } catch (Exception e) {
                LoggerImpl.INSTANCE.logProblem(e);
              }
            });
    tblMixDiffB
        .getSelectionModel()
        .addListSelectionListener(
            (ListSelectionEvent a) -> {
              if (a.getValueIsAdjusting()) {
                return;
              }
              if (tblMixDiffA.isSelectionEmpty()) {
                return;
              }
              TableMix.Row mixa = tblMixDiffA.getSelectedValue();
              TableMix.Row mixb = tblMixDiffB.getSelectedValue();
              try {
                Future<List<List>> task =
                    BackgroundExec.submit(new MixDifferenceTask(mixa.getMixid(), mixb.getMixid()));
                List<List> diff = task.get();
                tblMixDiff.reload(diff);
              } catch (Exception e) {
                LoggerImpl.INSTANCE.logProblem(e);
              }
            });
    return pnl;
  }

  private JPanel getMixFoodPanel() {
    JPanel pnl = new JPanel();
    FormLayout lyo =
        new FormLayout(
            "min:grow,min,min:grow", // columns
            "fill:min:grow" // rows
            );
    pnl.setLayout(lyo);
    JPanel pnlButtons = new JPanel();
    FormLayout lyoButtons =
        new FormLayout(
            "min", // columns
            "min:grow,min,min,min,min,min:grow" // rows
            );
    pnlButtons.setLayout(lyoButtons);
    tblMixFood = new TableFood();
    JScrollPane mixFoodScrollPane = new JScrollPane(tblMixFood);
    mixFoodScrollPane.setBorder(new TitledBorder("Mix Food"));
    JScrollPane scr_food = new JScrollPane(treFoods);
    scr_food.setBorder(new TitledBorder("Food"));
    treFoods.setModel(tremodelFoods);
    JButton buttonAddMixFood = new JButton("+");
    JButton buttonDeleteMixFood = new JButton("-");
    JButton buttonExpandMixFood = new JButton("e");
    JButton buttonCollapseMixFood = new JButton("c");
    pnlButtons.add(buttonAddMixFood, cc.xy(1, 2));
    pnlButtons.add(buttonDeleteMixFood, cc.xy(1, 3));
    pnlButtons.add(buttonExpandMixFood, cc.xy(1, 4));
    pnlButtons.add(buttonCollapseMixFood, cc.xy(1, 5));
    pnl.add(scr_food, cc.xy(1, 1));
    pnl.add(pnlButtons, cc.xy(2, 1));
    pnl.add(mixFoodScrollPane, cc.xy(3, 1));
    buttonAddMixFood.setToolTipText("Add Food Item to Mix");
    buttonDeleteMixFood.setToolTipText("Delete Food Item from Mix");
    buttonExpandMixFood.setToolTipText("Expand Food List");
    buttonCollapseMixFood.setToolTipText("Collapse Food List");
    buttonAddMixFood.addActionListener(e -> addMixFood());
    buttonDeleteMixFood.addActionListener(e -> deleteMixFood());
    buttonExpandMixFood.addActionListener(e -> expandFoods());
    buttonCollapseMixFood.addActionListener(e -> collapseFoods());
    return pnl;
  }

  private Double getMixUsageInputForInventory() {
    Double days = 1.0;
    JTextField input = new JTextField();
    JPanel input_panel = new JPanel();
    input.setPreferredSize(new Dimension(50, 25));
    input_panel.add(new JLabel("How many days will you be using this meal plan?"));
    input_panel.add(input);
    JComponent[] inputs = {input_panel};
    int optionValue = Message.showOptionDialogOkCancel(inputs, "Meal Plan Usage");
    if (optionValue == 0) {
      String s = input.getText();
      if (s != null && s.length() > 0) {
        NumberCheck checkNumber = new NumberCheck();
        checkNumber.addToUncheckedList(s);
        if (checkNumber.pass()) {
          days = Double.valueOf(s);
        }
      }
    }
    return days;
  }

  private JPanel getMealPlanUsageDaysPanel() {
    JPanel pnl = new JPanel();
    pnl.setBorder(new TitledBorder("Meal Plan Usage"));
    FormLayout panelLayout =
        new FormLayout(
            "p:grow", // columns
            "fill:min:grow,min" // rows
            );
    pnl.setLayout(panelLayout);
    tblMealPlanUsage = new TableInventoryDays();
    pnl.add(new JScrollPane(tblMealPlanUsage), cc.xy(1, 1));
    pnl.add(getMealPlanUsageButtonsPanel(), cc.xy(1, 2));
    return pnl;
  }

  private JPanel getMealPlanUsageButtonsPanel() {
    JPanel pnl = new JPanel();
    JButton btn_add = new JButton("+");
    JButton btn_delete = new JButton("-");
    btn_add.setToolTipText("Add meal plan to food forecast");
    btn_delete.setToolTipText("Delete meal plan from food forecast");
    pnl.add(btn_add);
    pnl.add(btn_delete);
    btn_add.addActionListener(
        (ActionEvent a) -> {
          addMealPlanUsage();
          try {
            Future<List<List>> task = BackgroundExec.submit(new MealPlanUsageTask());
            List<List> usage = task.get();
            tblMealPlanUsage.reload(usage);
          } catch (Exception e) {
            LoggerImpl.INSTANCE.logProblem(e);
          }
          try {
            Future<List<List>> task = BackgroundExec.submit(new MealPlanUsageResultsTask());
            List<List> results = task.get();
            tblMealPlanUsageResults.reload(results);
          } catch (Exception e) {
            LoggerImpl.INSTANCE.logProblem(e);
          }
        });
    btn_delete.addActionListener(
        (ActionEvent a) -> {
          deleteMealPlanUsage();
          try {
            Future<List<List>> task = BackgroundExec.submit(new MealPlanUsageTask());
            List<List> usage = task.get();
            tblMealPlanUsage.reload(usage);
          } catch (Exception e) {
            LoggerImpl.INSTANCE.logProblem(e);
          }
          try {
            Future<List<List>> task = BackgroundExec.submit(new MealPlanUsageResultsTask());
            List<List> results = task.get();
            tblMealPlanUsageResults.reload(results);
          } catch (Exception e) {
            LoggerImpl.INSTANCE.logProblem(e);
          }
        });
    return pnl;
  }

  private JPanel getMealPlanUsageMixesPanel() {
    JPanel pnl = new JPanel();
    pnl.setBorder(new TitledBorder("Mix"));
    FormLayout panelLayout =
        new FormLayout(
            "p:grow", // columns
            "fill:min:grow" // rows
            );
    pnl.setLayout(panelLayout);
    pnl.add(new JScrollPane(tblMealPlanUsageMixes), cc.xy(1, 1));
    return pnl;
  }

  private JPanel getMealPlanUsageResultPanel() {
    JPanel pnl = new JPanel();
    pnl.setBorder(new TitledBorder("Food Usage"));
    FormLayout panelLayout =
        new FormLayout(
            "p:grow", // columns
            "fill:min:grow,min" // rows
            );
    pnl.setLayout(panelLayout);
    tblMealPlanUsageResults = new TableMealPlanUsageResults();
    pnl.add(new JScrollPane(tblMealPlanUsageResults), cc.xy(1, 1));
    return pnl;
  }

  private JPanel getNoSolutionPanel() {
    FormLayout lyo =
        new FormLayout(
            "pref:grow", // columns
            "fill:pref:grow" // rows
            );
    StringBuilder sb = new StringBuilder();
    sb.append(getNoFeasibleSolutionText());
    JPanel pnl = new JPanel();
    JTextArea txa = new JTextArea(sb.toString());
    txa.setPreferredSize(new Dimension(700, 433));
    txa.setEditable(false);
    pnl.setLayout(lyo);
    txa.setLineWrap(false);
    pnl.add(new JScrollPane(txa), cc.xy(1, 1));
    return pnl;
  }

  private JPanel getNutrientQuantityConstraintPanel() {
    JPanel pnl = new JPanel();
    FormLayout panelLayout =
        new FormLayout(
            "p,p,p", // columns
            "p,fill:p:grow,min" // rows
            );
    pnl.setLayout(panelLayout);
    tblNutrientQuantityConstraint = new TableNutrientQuantity();
    JScrollPane scrollPane = new JScrollPane(tblNutrientQuantityConstraint);
    Integer width =
        TableColumnWidth.Nutrient.getWidth() + 21 + 90 + TableColumnWidth.Scrollbar.getWidth();
    scrollPane.setPreferredSize(new Dimension(width, 0));
    JPanel buttons = new JPanel();
    txtNutrientQuantityValue.setPreferredSize(Dimensions.Quantity.get());
    pnl.add(cmbNutrientQuantityNutrient, cc.xy(1, 1));
    pnl.add(cmbNutrientQuantityRelationship, cc.xy(2, 1));
    pnl.add(txtNutrientQuantityValue, cc.xy(3, 1));
    pnl.add(scrollPane, cc.xyw(1, 2, 3));
    buttons.add(btnAddNutrientConstraint);
    buttons.add(btnDeleteNutrientConstraint);
    pnl.add(buttons, cc.xyw(1, 3, 3));
    scrollPane.setBorder(new TitledBorder("Nutrient Constraints"));
    cmbNutrientQuantityNutrient.setMaximumRowCount(10);
    cmbNutrientQuantityRelationship.setMaximumRowCount(3);
    btnAddNutrientConstraint.setToolTipText("Add Constraint");
    btnDeleteNutrientConstraint.setToolTipText("Delete Constraint");
    btnAddNutrientConstraint.addActionListener(
        (ActionEvent e) -> {
          addNutrientQuantityConstraint();
        });
    btnDeleteNutrientConstraint.addActionListener(
        (ActionEvent e) -> {
          deleteNutrientQuantityConstraint();
        });
    tblNutrientQuantityConstraint
        .getSelectionModel()
        .addListSelectionListener(
            (ListSelectionEvent e) -> {
              if (e.getValueIsAdjusting()) {
                return;
              }
              if (tblNutrientQuantityConstraint.isSelectionEmpty()) {
                return;
              }
              setNutrientQuantityConstraintGuiValues();
            });
    return pnl;
  }

  private JPanel getNutrientSearchPanel() {
    JPanel pnl = new JPanel();
    JPanel pnl01 = new JPanel();
    FormLayout lyo =
        new FormLayout(
            "4dlu:grow,500dlu,4dlu:grow", // columns
            "4dlu,min,4dlu,fill:min:grow,4dlu" // rows
            );
    FormLayout lyo01 =
        new FormLayout(
            "4dlu,p,p,4dlu,p,p:grow,4dlu", // columns
            "4dlu,fill:25px,4dlu,fill:25px,4dlu" // rows
            );
    pnl.setLayout(lyo);
    pnl01.setLayout(lyo01);
    JLabel lblSearch = new JLabel("Search: ");
    lblSearch.setToolTipText(
        "Search field input should be a valid regex expression (case insensitive match)");
    JLabel lblNutrient = new JLabel("Nutrient: ");
    lblNutrient.setHorizontalAlignment(SwingConstants.RIGHT);
    JLabel lblValue = new JLabel("Value: ");
    lblValue.setHorizontalAlignment(SwingConstants.RIGHT);
    lblSearch.setHorizontalAlignment(SwingConstants.RIGHT);
    tblNutrientLookup = new TableNutrientLookup();
    tblNutrientLookup.setToolTipText("These food items contain the nutrient");
    JScrollPane scr = new JScrollPane(tblNutrientLookup);
    scr.setBorder(new TitledBorder("Nutrient Search"));
    pnl01.add(lblSearch, cc.xy(5, 2));
    pnl01.add(tblNutrientLookup.getSearchField(), cc.xy(6, 2));
    pnl01.add(lblNutrient, cc.xy(2, 4));
    pnl01.add(cmbNutrientContentNutrient, cc.xy(3, 4));
    pnl01.add(lblValue, cc.xy(5, 4));
    pnl01.add(txtNutrientSearchQuantity, cc.xy(6, 4));
    pnl.add(pnl01, cc.xy(2, 2));
    pnl.add(scr, cc.xy(2, 4));
    txtNutrientSearchQuantity.addActionListener(
        (ActionEvent e) -> {
          process_evt_txt_nutrient_content();
        });
    return pnl;
  }

  private JPanel getNutrientRatioPanel() {
    JPanel pnl = new JPanel();
    FormLayout lyo =
        new FormLayout(
            "p:grow,90px,p,p,370px:grow", // columns
            "p,p,fill:p:grow,min" // rows
            );
    pnl.setLayout(lyo);
    tblNutrientRatio = new TableNutrientRatioConstraint();
    JScrollPane scr = new JScrollPane(tblNutrientRatio);
    Integer width =
        TableColumnWidth.Nutrient.getWidth()
            + TableColumnWidth.Nutrient.getWidth()
            + 90
            + 21
            + 90
            + TableColumnWidth.Scrollbar.getWidth();
    scr.setPreferredSize(new Dimension(width, 0));
    JPanel buttons = new JPanel();
    txtNutrientRatioNutrientA.setPreferredSize(Dimensions.Quantity.get());
    txtNutrientRatioNutrientB.setPreferredSize(Dimensions.Quantity.get());
    pnl.add(cmbNutrientRatioNutrientA, cc.xy(1, 1));
    pnl.add(txtNutrientRatioNutrientA, cc.xy(2, 1));
    pnl.add(cmbNutrientRatioRelationship, cc.xy(3, 1));
    pnl.add(cmbNutrientRatioNutrientB, cc.xy(1, 2));
    pnl.add(txtNutrientRatioNutrientB, cc.xy(2, 2));
    pnl.add(scr, cc.xyw(1, 3, 5));
    buttons.add(btnAddNutrientRatio);
    buttons.add(btnDeleteNutrientRatio);
    pnl.add(buttons, cc.xyw(1, 4, 5));
    scr.setBorder(new TitledBorder("Nutrient Ratio Constraints"));
    cmbNutrientRatioNutrientA.setMaximumRowCount(10);
    cmbNutrientRatioNutrientB.setMaximumRowCount(10);
    btnAddNutrientRatio.setToolTipText("Add Constraint");
    btnDeleteNutrientRatio.setToolTipText("Delete Constraint");
    btnAddNutrientRatio.addActionListener(
        (ActionEvent e) -> {
          addNutrientRatioConstraint();
        });
    btnDeleteNutrientRatio.addActionListener(
        (ActionEvent e) -> {
          deleteNutrientRatioConstraint();
        });
    tblNutrientRatio
        .getSelectionModel()
        .addListSelectionListener(
            (ListSelectionEvent e) -> {
              if (e.getValueIsAdjusting()) {
                return;
              }
              if (tblNutrientRatio.isSelectionEmpty()) {
                return;
              }
              setNutrientRatioConstraintGuiValues();
            });
    return pnl;
  }

  private String getFoodConstraintCount() {
    return String.format("%1$ 2d", tblFoodQuantityConstraint.getRowCount());
  }

  private String getFoodRatioConstraintCount() {
    return String.format("%1$ 2d", tblFoodRatioConstraint.getRowCount());
  }

  private String getNoFeasibleSolutionText() {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < 8; i++) {
      sb.append("\n");
    }
    for (int i = 0; i < 40; i++) {
      sb.append(" ");
    }
    sb.append("No Feasible Solution");
    sb.append("\n\n");
    for (int i = 0; i < 40; i++) {
      sb.append(" ");
    }
    sb.append("Things you can try:");
    sb.append("\n\n");
    for (int i = 0; i < 40; i++) {
      sb.append(" ");
    }
    sb.append("1. Delete a constraint");
    sb.append("\n\n");
    for (int i = 0; i < 40; i++) {
      sb.append(" ");
    }
    sb.append("2. Add a food item");
    sb.append("\n\n");
    for (int i = 0; i < 40; i++) {
      sb.append(" ");
    }
    sb.append("3. Pin the mix");
    return sb.toString();
  }

  private String getNutrientQuantityConstraintCount() {
    return String.format("%1$ 2d", tblNutrientQuantityConstraint.getRowCount());
  }

  private String getNutrientRatioConstraintCount() {
    return String.format("%1$ 2d", tblNutrientRatio.getRowCount());
  }

  private Boolean checkFoodConstraint() {
    boolean flag_isReady = false;
    boolean flag_listFood = false;
    boolean flag_listNutrient = false;
    boolean flag_listRelationship = false;
    boolean flag_quantity = false;
    if (!cmbFoodQuantityFood.isSelectionEmpty()) {
      flag_listFood = true;
    } else {
      Message.showMessage("Select food");
    }
    if (!cmbFoodQuantityNutrient.isSelectionEmpty()) {
      flag_listNutrient = true;
    } else {
      Message.showMessage("Select nutrient");
    }
    if (!cmbFoodQuantityRelationship.isSelectionEmpty()) {
      flag_listRelationship = true;
    } else {
      Message.showMessage("Select relationship");
    }
    if (!txtFoodQuantityValue.getText().isEmpty()) {
      flag_quantity = true;
    } else {
      Message.showMessage("Specify amount");
    }
    if (flag_listFood && flag_listNutrient && flag_listRelationship && flag_quantity) {
      flag_isReady = true;
    }
    return flag_isReady;
  }

  private Boolean checkFoodRatioConstraint() {
    boolean flag_isReady = false;
    boolean flag_listFoodA = false;
    boolean flag_listNutrientA = false;
    boolean flag_quantityA = false;
    boolean flag_listFoodB = false;
    boolean flag_listNutrientB = false;
    boolean flag_quantityB = false;
    if (!cmbFoodRatioFoodA.isSelectionEmpty()) {
      flag_listFoodA = true;
    } else {
      Message.showMessage("Select food A");
    }
    if (!cmbFoodRatioNutrientA.isSelectionEmpty()) {
      flag_listNutrientA = true;
    } else {
      Message.showMessage("Select nutrient A");
    }
    if (!txtFoodNutrientRatioQuantityA.getText().isEmpty()) {
      flag_quantityA = true;
    } else {
      Message.showMessage("Specify amount A");
    }
    if (!cmbFoodRatioFoodB.isSelectionEmpty()) {
      flag_listFoodB = true;
    } else {
      Message.showMessage("Select food B");
    }
    if (!cmbFoodRatioNutrientB.isSelectionEmpty()) {
      flag_listNutrientB = true;
    } else {
      Message.showMessage("Select nutrient B");
    }
    if (!txtFoodNutrientRatioQuantityB.getText().isEmpty()) {
      flag_quantityB = true;
    } else {
      Message.showMessage("Specify amount B");
    }
    if (flag_listFoodA
        && flag_listNutrientA
        && flag_quantityA
        && flag_listFoodB
        && flag_listNutrientB
        && flag_quantityB) {
      flag_isReady = true;
    }
    return flag_isReady;
  }

  private Boolean checkNutrientQuantityConstraint() {
    boolean flag_isReady = false;
    boolean flag_listNutrient = false;
    boolean flag_listNutrientRelationship = false;
    boolean flag_textFieldNutrientConstraint = false;
    if (!cmbNutrientQuantityNutrient.isSelectionEmpty()) {
      flag_listNutrient = true;
    } else {
      Message.showMessage("Select nutrient");
    }
    if (cmbNutrientQuantityRelationship.getSelectedIndex() != -1) {
      flag_listNutrientRelationship = true;
    } else {
      Message.showMessage("Select relationship");
    }
    if (!txtNutrientQuantityValue.getText().isEmpty()) {
      flag_textFieldNutrientConstraint = true;
    } else {
      Message.showMessage("Specify amount");
    }
    if (flag_listNutrient && flag_listNutrientRelationship && flag_textFieldNutrientConstraint) {
      flag_isReady = true;
    }
    return flag_isReady;
  }

  private Boolean checkNutrientRatioConstraint() {
    boolean flag_isReady = false;
    boolean flag_listNutrientA = false;
    boolean flag_listNutrientB = false;
    boolean flag_quantityA = false;
    boolean flag_quantityB = false;
    if (!cmbNutrientRatioNutrientA.isSelectionEmpty()) {
      flag_listNutrientA = true;
    } else {
      Message.showMessage("Select nutrient A");
    }
    if (!cmbNutrientRatioNutrientB.isSelectionEmpty()) {
      flag_listNutrientB = true;
    } else {
      Message.showMessage("Select nutrient B");
    }
    if (!txtNutrientRatioNutrientA.getText().isEmpty()) {
      flag_quantityA = true;
    } else {
      Message.showMessage("Specify amount A");
    }
    if (!txtNutrientRatioNutrientB.getText().isEmpty()) {
      flag_quantityB = true;
    } else {
      Message.showMessage("Specify amount B");
    }
    if (flag_listNutrientA && flag_listNutrientB && flag_quantityA && flag_quantityB) {
      flag_isReady = true;
    }
    return flag_isReady;
  }

  private void convertMixToFood() {
    MixDO mix = getSelectedMix();
    TableFoodFactInput tbl = new TableFoodFactInput();
    try {
      Future<List<List>> task = BackgroundExec.submit(new MixFoodFactsTask(mix.getMixId()));
      List<List> foodfacts = task.get();
      tbl.reload(foodfacts);
    } catch (Exception e) {
      LoggerImpl.INSTANCE.logProblem(e);
    }
    FoodFactInputPanel pnlFoodFactsInput = new FoodFactInputPanel(tbl);
    pnlFoodFactsInput.setFoodName(mix.getName());
    JPanel pnl = pnlFoodFactsInput.getPanel();
    JComponent[] inputs = {pnl};
    int optionValue =
        Message.showOptionDialogOkCancel(
            inputs, "Add Mix As Food Item - Would you like to save specified values?");
    if (optionValue == 0) {
      Food food = pnlFoodFactsInput.getFood();
      Boolean completed = new FoodCreator(food).create();
      if (completed) {
        try {
          Future<List<List>> task = BackgroundExec.submit(new FoodFactsTask());
          List<List> foods = task.get();
          tblFoods.reload(foods);
          tblFoodDiffA.reload(foods);
          tblFoodDiffB.reload(foods);
          tblCategoryAllFoods.reload(foods);
        } catch (Exception e) {
          LoggerImpl.INSTANCE.logProblem(e);
        }
        try {
          Future<List<Map<String, Object>>> task = BackgroundExec.submit(new FoodsTask());
          List<Map<String, Object>> treeFoods = task.get();
          tremodelFoods.reload(treeFoods);
        } catch (Exception e) {
          LoggerImpl.INSTANCE.logProblem(e);
        }
        try {
          Future<List<List>> task = BackgroundExec.submit(new FoodCategoriesTask());
          List<List> categories = task.get();
          tblCategory.reload(categories);
        } catch (Exception e) {
          LoggerImpl.INSTANCE.logProblem(e);
        }
        try {
          Future<List<List>> task =
              BackgroundExec.submit(new NamedMixFoodSortedByNameTask(mix.getMixId()));
          List<List> foods = task.get();
          tblMixFood.reload(foods);
        } catch (Exception e) {
          LoggerImpl.INSTANCE.logProblem(e);
        }
        setQuantityScale();
        int rowIndex = tblFoods.find(food.getFoodId());
        tblFoods.showRow(rowIndex);
      }
    }
  }

  private void addCategory() {
    JTextField txtInput = new JTextField();
    JComponent[] inputs = {new JLabel("What is your new category name?"), txtInput};
    int optionValue = Message.showOptionDialog(inputs, "New Category");
    if (optionValue == 0) {
      String categoryname = txtInput.getText();
      if (categoryname != null && categoryname.length() > 0) {
        try {
          Future<Boolean> task = BackgroundExec.submit(new InsertCategoryTask(categoryname));
          Boolean completed = task.get();
          if (!completed) {
            return;
          }
        } catch (Exception e) {
          LoggerImpl.INSTANCE.logProblem(e);
        }
        try {
          Future<List<List>> task = BackgroundExec.submit(new FoodCategoriesTask());
          List<List> categories = task.get();
          tblCategory.reload(categories);
        } catch (Exception e) {
          LoggerImpl.INSTANCE.logProblem(e);
        }
      }
    }
  }

  private void deleteCategory() {
    if (!tblCategory.isSelectionEmpty()) {
      TableCategory.Row category = tblCategory.getSelectedValue();
      try {
        Future<Boolean> task =
            BackgroundExec.submit(new DeleteCategoryTask(category.getCategoryid()));
        Boolean completed = task.get();
        if (!completed) {
          return;
        }
      } catch (Exception e) {
        LoggerImpl.INSTANCE.logProblem(e);
      }
      try {
        Future<List<List>> task = BackgroundExec.submit(new FoodCategoriesTask());
        List<List> categories = task.get();
        tblCategory.reload(categories);
      } catch (Exception e) {
        LoggerImpl.INSTANCE.logProblem(e);
      }
      tblCategoryFood.clear();
      try {
        Future<List<Map<String, Object>>> task = BackgroundExec.submit(new FoodsTask());
        List<Map<String, Object>> treeFoods = task.get();
        tremodelFoods.reload(treeFoods);
      } catch (Exception e) {
        LoggerImpl.INSTANCE.logProblem(e);
      }
    }
  }

  private void renameCategory() {
    if (!tblCategory.isSelectionEmpty()) {
      JTextField input = new JTextField();
      JComponent[] inputs = {new JLabel("What is your new category name?"), input};
      int optionValue = Message.showOptionDialogOkCancel(inputs, "Update Category");
      if (optionValue == 0) {
        String categoryname = input.getText();
        if (categoryname != null && categoryname.length() > 0) {
          TableCategory.Row category = tblCategory.getSelectedValue();
          try {
            Future<Boolean> task =
                BackgroundExec.submit(
                    new UpdateCategoryTask(category.getCategoryid(), categoryname));
            Boolean completed = task.get();
            if (!completed) {
              return;
            }
          } catch (Exception e) {
            LoggerImpl.INSTANCE.logProblem(e);
          }
          try {
            Future<List<List>> task = BackgroundExec.submit(new FoodCategoriesTask());
            List<List> categories = task.get();
            tblCategory.reload(categories);
          } catch (Exception e) {
            LoggerImpl.INSTANCE.logProblem(e);
          }
        }
      }
    }
  }

  public void exportCategory() {
    if (tblCategory.isSelectionEmpty()) {
      return;
    }
    StringBuilder sb = new StringBuilder();
    sb.append(System.getProperty("user.dir"));
    sb.append(File.separator);
    sb.append("models");
    sb.append(File.separator);
    sb.append("favoritefoods.xml");
    fch.setSelectedFile(new File(sb.toString()));
    int returnVal = fch.showSaveDialog(frm);
    if (returnVal == JFileChooser.APPROVE_OPTION) {
      File file = fch.getSelectedFile();
      String path = file.getAbsolutePath();
      frm.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
      try {
        TableCategory.Row selectedValue = tblCategory.getSelectedValue();
        Future<String> task =
            BackgroundExec.submit(new SendCategoryToXmlTask(selectedValue.getCategoryid()));
        String xml = task.get();
        if (xml.isEmpty()) {
          frm.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
          return;
        }
        BufferedWriter writer = new BufferedWriter(new FileWriter(path));
        String fdoc = Utilities.formatXmlDoc(xml);
        writer.write(fdoc);
        writer.close();
        frm.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        showMessageSent(path);
      } catch (Exception e) {
        LoggerImpl.INSTANCE.logProblem(e);
      }
    }
  }

  private void addFoodToCategory() {
    if (!tblCategory.isSelectionEmpty()) {
      if (!tblCategoryAllFoods.isSelectionEmpty()) {
        TableCategory.Row category = tblCategory.getSelectedValue();
        TableFood.Row food = tblCategoryAllFoods.getSelectedValue();
        try {
          Future<Integer> task0 =
              BackgroundExec.submit(
                  new FoodCategoryCountTask(category.getCategoryid(), food.getFoodid()));
          Integer count = task0.get();
          if (count == 0) {
            Future<Boolean> task1 =
                BackgroundExec.submit(
                    new InsertFoodCategoryLinkTask(category.getCategoryid(), food.getFoodid()));
            Boolean task1Completed = task1.get();
            if (!task1Completed) {
              return;
            }
            try {
              Future<List<List>> task3 =
                  BackgroundExec.submit(new FoodsInCategoryTask((category.getCategoryid())));
              List<List> categoryFoods = task3.get();
              tblCategoryFood.reload(categoryFoods);
            } catch (Exception e) {
              LoggerImpl.INSTANCE.logProblem(e);
            }
            try {
              Future<List<Map<String, Object>>> task = BackgroundExec.submit(new FoodsTask());
              List<Map<String, Object>> treeFoods = task.get();
              tremodelFoods.reload(treeFoods);
            } catch (Exception e) {
              LoggerImpl.INSTANCE.logProblem(e);
            }
          }
        } catch (Exception e) {
          LoggerImpl.INSTANCE.logProblem(e);
        }
      }
    }
  }

  private void removeFoodFromCategory() {
    if (!tblCategory.isSelectionEmpty()) {
      TableCategory.Row category = tblCategory.getSelectedValue();
      TableFood.Row food = tblCategoryFood.getSelectedValue();
      try {
        Future<Boolean> task0 =
            BackgroundExec.submit(
                new DeleteCategoryLinkTask(category.getCategoryid(), food.getFoodid()));
        Boolean complete = task0.get();
        if (!complete) {
          return;
        }
        try {
          Future<List<List>> task1 =
              BackgroundExec.submit(new FoodsInCategoryTask((category.getCategoryid())));
          List<List> categoryFoods = task1.get();
          tblCategoryFood.reload(categoryFoods);
        } catch (Exception e) {
          LoggerImpl.INSTANCE.logProblem(e);
        }
        try {
          Future<List<Map<String, Object>>> task2 = BackgroundExec.submit(new FoodsTask());
          List<Map<String, Object>> treeFoods = task2.get();
          tremodelFoods.reload(treeFoods);
        } catch (Exception e) {
          LoggerImpl.INSTANCE.logProblem(e);
        }
      } catch (Exception e) {
        LoggerImpl.INSTANCE.logProblem(e);
      }
    }
  }

  private void addFoodToDatabase() {
    MixDO mix = getSelectedMix();
    TableFoodFactInput tbl = new TableFoodFactInput();
    try {
      Future<List<List>> task = BackgroundExec.submit(new NewItemFoodFactsTask());
      List<List> foodfacts = task.get();
      tbl.reload(foodfacts);
    } catch (Exception e) {
      LoggerImpl.INSTANCE.logProblem(e);
    }
    FoodFactInputPanel pnlFoodFactsInput = new FoodFactInputPanel(tbl);
    JPanel pnl = pnlFoodFactsInput.getPanel();
    JComponent[] inputs = {pnl};
    int optionValue =
        Message.showOptionDialogOkCancel(
            inputs, "Add New Food Item - Would you like to save specified values?");
    if (optionValue == 0) {
      Food food = pnlFoodFactsInput.getFood();
      Boolean completed = new FoodCreator(food).create();
      if (completed) {
        try {
          Future<List<List>> task = BackgroundExec.submit(new FoodFactsTask());
          List<List> foods = task.get();
          tblFoods.reload(foods);
          tblFoodDiffA.reload(foods);
          tblFoodDiffB.reload(foods);
          tblCategoryAllFoods.reload(foods);
        } catch (Exception e) {
          LoggerImpl.INSTANCE.logProblem(e);
        }
        try {
          Future<List<Map<String, Object>>> task = BackgroundExec.submit(new FoodsTask());
          List<Map<String, Object>> treeFoods = task.get();
          tremodelFoods.reload(treeFoods);
        } catch (Exception e) {
          LoggerImpl.INSTANCE.logProblem(e);
        }
        try {
          Future<List<List>> task = BackgroundExec.submit(new FoodCategoriesTask());
          List<List> categories = task.get();
          tblCategory.reload(categories);
        } catch (Exception e) {
          LoggerImpl.INSTANCE.logProblem(e);
        }
        try {
          Future<List<List>> task =
              BackgroundExec.submit(new NamedMixFoodSortedByNameTask(mix.getMixId()));
          List<List> foods = task.get();
          tblMixFood.reload(foods);
        } catch (Exception e) {
          LoggerImpl.INSTANCE.logProblem(e);
        }
        setQuantityScale();
        int rowIndex = tblFoods.find(food.getFoodId());
        tblFoods.showRow(rowIndex);
      }
    }
  }

  private void addDerivativeFoodToDatabase() {
    if (!tblFoods.isSelectionEmpty()) {
      TableFoodDetails.Row foodfact = tblFoods.getSelectedValue();
      TableFoodFactInput tbl = new TableFoodFactInput();
      try {
        Future<List<List>> task = BackgroundExec.submit(new DerivedFoodFactsTask(foodfact.getId()));
        List<List> foodfacts = task.get();
        tbl.reload(foodfacts);
      } catch (Exception e) {
        LoggerImpl.INSTANCE.logProblem(e);
      }
      FoodFactInputPanel foodFactsInputPanel = new FoodFactInputPanel(tbl);
      foodFactsInputPanel.setFoodName(foodfact.getName());
      JPanel panel = foodFactsInputPanel.getPanel();
      JComponent[] inputs = {panel};
      int optionValue =
          Message.showOptionDialogOkCancel(
              inputs, "Update New Food Item - Would you like to save specified values?");
      if (optionValue == 0) {
        Food food = foodFactsInputPanel.getFood();
        Boolean completed = new FoodCreator(food).create();
        if (completed) {
          try {
            Future<List<List>> task = BackgroundExec.submit(new FoodFactsTask());
            List<List> foods = task.get();
            tblFoods.reload(foods);
            tblFoodDiffA.reload(foods);
            tblFoodDiffB.reload(foods);
            tblCategoryAllFoods.reload(foods);
          } catch (Exception e) {
            LoggerImpl.INSTANCE.logProblem(e);
          }
          try {
            Future<List<Map<String, Object>>> task = BackgroundExec.submit(new FoodsTask());
            List<Map<String, Object>> treeFoods = task.get();
            tremodelFoods.reload(treeFoods);
          } catch (Exception e) {
            LoggerImpl.INSTANCE.logProblem(e);
          }
          try {
            Future<List<List>> task = BackgroundExec.submit(new FoodCategoriesTask());
            List<List> categories = task.get();
            tblCategory.reload(categories);
          } catch (Exception e) {
            LoggerImpl.INSTANCE.logProblem(e);
          }
          setQuantityScale();
          int rowIndex = tblFoods.find(food.getFoodId());
          tblFoods.showRow(rowIndex);
        }
      }
    }
  }

  private void removeFoodFromDatabase() {
    if (!tblFoods.isSelectionEmpty()) {
      TableFoodDetails.Row food = tblFoods.getSelectedValue();
      deleteFoodItem(food.getId());
    }
  }

  private void renameFoodItemInDatabase() {
    if (!tblFoods.isSelectionEmpty()) {
      TableFoodDetails.Row food = tblFoods.getSelectedValue();
      String foodid = food.getId();
      JTextField input = new JTextField();
      JPanel input_panel = new JPanel();
      input.setPreferredSize(new Dimension(150, 25));
      input_panel.add(new JLabel("What is the food item name?"));
      input_panel.add(input);
      JComponent[] inputs = {input_panel};
      int optionValue = Message.showOptionDialogOkCancel(inputs, "Rename Food Item");
      if (optionValue == 0) {
        food.setName(input.getText());
        try {
          Future<Boolean> task =
              BackgroundExec.submit(new UpdateFoodTask(food.getId(), food.getName()));
          Boolean completed = task.get();
          if (!completed) {
            return;
          }
        } catch (Exception e) {
          LoggerImpl.INSTANCE.logProblem(e);
        }
        try {
          Future<Boolean> task = BackgroundExec.submit(new DenormalizeFoodFactsTask(food.getId()));
          Boolean completed = task.get();
          if (!completed) {
            return;
          }
        } catch (Exception e) {
          LoggerImpl.INSTANCE.logProblem(e);
        }
        try {
          Future<List<List>> task = BackgroundExec.submit(new FoodFactsTask());
          List<List> foods = task.get();
          tblFoods.reload(foods);
          tblFoodDiffA.reload(foods);
          tblFoodDiffB.reload(foods);
          tblCategoryAllFoods.reload(foods);
        } catch (Exception e) {
          LoggerImpl.INSTANCE.logProblem(e);
        }
        try {
          Future<List<Map<String, Object>>> task = BackgroundExec.submit(new FoodsTask());
          List<Map<String, Object>> treeFoods = task.get();
          tremodelFoods.reload(treeFoods);
        } catch (Exception e) {
          LoggerImpl.INSTANCE.logProblem(e);
        }
        try {
          Future<List<List>> task = BackgroundExec.submit(new FoodCategoriesTask());
          List<List> categories = task.get();
          tblCategory.reload(categories);
        } catch (Exception e) {
          LoggerImpl.INSTANCE.logProblem(e);
        }
        MixDO mix = getSelectedMix();
        try {
          Future<List<List>> task =
              BackgroundExec.submit(new NamedMixFoodSortedByNameTask(mix.getMixId()));
          List<List> foods = task.get();
          tblMixFood.reload(foods);
        } catch (Exception e) {
          LoggerImpl.INSTANCE.logProblem(e);
        }
        setQuantityScale();
        int rowIndex = tblFoods.find(foodid);
        tblFoods.showRow(rowIndex);
      }
    }
  }

  private void addFoodQuantityConstraint() {
    if (checkFoodConstraint()) {
      NumberCheck numberCheck = new NumberCheck();
      numberCheck.addToUncheckedList(txtFoodQuantityValue.getText());
      if (numberCheck.pass()) {
        MixFoodDO foodDO = cmbFoodQuantityFood.getSelectedItem();
        NutrientDO nutrientDO = cmbFoodQuantityNutrient.getSelectedItem();
        RelationshipDO relationshipDO = cmbFoodQuantityRelationship.getSelectedItem();
        BigDecimal b = new BigDecimal(txtFoodQuantityValue.getText());
        MixDO mix = getSelectedMix();
        try {
          Future<Boolean> task0 =
              BackgroundExec.submit(
                  new MergeFoodQuantityConstraintTask(
                      mix.getMixId(),
                      foodDO.getFoodId(),
                      nutrientDO.getNutr_no(),
                      relationshipDO.getRelationshipid(),
                      b));
          Boolean completed = task0.get();
          if (!completed) {
            return;
          }
          Future<List<List>> task1 =
              BackgroundExec.submit(new FoodQuantityConstraintsTask(mix.getMixId()));
          List<List> constraints = task1.get();
          tblFoodQuantityConstraint.reload(constraints);
          setConstraintCounts();
        } catch (Exception e) {
          LoggerImpl.INSTANCE.logProblem(e);
        }
      } else {
        Message.showMessage("Value must be a number greater than or equal to zero");
      }
    }
  }

  private void removeFoodQuantityConstraint() {
    if (!tblFoodQuantityConstraint.isSelectionEmpty()) {
      TableFoodQuantityConstraint.Row row = tblFoodQuantityConstraint.getSelectedValue();
      String mixid = row.getMixid();
      String foodid = row.getFoodid();
      String nutrientid = row.getNutrientid();
      Integer relationshipid = row.getRelationshipid();
      try {
        Future<Boolean> task0 =
            BackgroundExec.submit(
                new DeleteFoodQuantityConstraintTask(mixid, foodid, nutrientid, relationshipid));
        Boolean completed = task0.get();
        if (!completed) {
          return;
        }
        Future<List<List>> task1 = BackgroundExec.submit(new FoodQuantityConstraintsTask(mixid));
        List<List> constraints = task1.get();
        tblFoodQuantityConstraint.reload(constraints);
        setConstraintCounts();
      } catch (Exception e) {
        LoggerImpl.INSTANCE.logProblem(e);
      }
    }
  }

  private void addFoodRatioConstraint() {
    if (checkFoodRatioConstraint()) {
      NumberCheck numberCheck = new NumberCheck();
      numberCheck.addToUncheckedList(txtFoodNutrientRatioQuantityA.getText());
      numberCheck.addToUncheckedList(txtFoodNutrientRatioQuantityB.getText());
      if (numberCheck.pass()) {
        MixFoodDO foodDOA = cmbFoodRatioFoodA.getSelectedItem();
        NutrientDO nutrientDOA = cmbFoodRatioNutrientA.getSelectedItem();
        MixFoodDO foodDOB = cmbFoodRatioFoodB.getSelectedItem();
        NutrientDO nutrientDOB = cmbFoodRatioNutrientB.getSelectedItem();
        BigDecimal a = new BigDecimal(txtFoodNutrientRatioQuantityA.getText());
        BigDecimal b = new BigDecimal(txtFoodNutrientRatioQuantityB.getText());
        RelationshipDO relationshipDataObject =
            (RelationshipDO) cmbFoodRatioRelationship.getSelectedItem();
        MixDO mix = getSelectedMix();
        try {
          Future<Boolean> task0 =
              BackgroundExec.submit(
                  new MergeFoodRatioConstraintTask(
                      mix.getMixId(),
                      foodDOA.getFoodId(),
                      nutrientDOA.getNutr_no(),
                      foodDOB.getFoodId(),
                      nutrientDOB.getNutr_no(),
                      relationshipDataObject.getRelationshipid(),
                      a,
                      b));
          Boolean completed = task0.get();
          if (!completed) {
            return;
          }
          Future<List<List>> task1 =
              BackgroundExec.submit(new FoodRatioConstraintsTask(mix.getMixId()));
          List<List> constraints = task1.get();
          tblFoodRatioConstraint.reload(constraints);
          setConstraintCounts();
        } catch (Exception e) {
          LoggerImpl.INSTANCE.logProblem(e);
        }
      } else {
        Message.showMessage("Value must be number greater than zero");
      }
    }
  }

  private void deleteFoodRatioConstraint() {
    if (!tblFoodRatioConstraint.isSelectionEmpty()) {
      TableFoodRatioConstraint.Row row = tblFoodRatioConstraint.getSelectedValue();
      String mixid = row.getMixid();
      String foodidA = row.getFoodida();
      String nutrientidA = row.getNutrientida();
      String foodidB = row.getFoodidb();
      String nutrientidB = row.getNutrientidb();
      Integer relationshipid = row.getRelationshipid();
      try {
        Future<Boolean> task0 =
            BackgroundExec.submit(
                new DeleteFoodRatioConstraintTask(
                    mixid, foodidA, nutrientidA, foodidB, nutrientidB, relationshipid));
        Boolean completed = task0.get();
        if (!completed) {
          return;
        }
        Future<List<List>> task1 = BackgroundExec.submit(new FoodRatioConstraintsTask(mixid));
        List<List> constraints = task1.get();
        tblFoodRatioConstraint.reload(constraints);
        setConstraintCounts();
      } catch (Exception e) {
        LoggerImpl.INSTANCE.logProblem(e);
      }
    }
  }

  private void addFoodPortion() {
    NumberCheck checkNumber = new NumberCheck();
    Double pcti = Double.NaN;
    checkNumber.addToUncheckedList(txtPortionPct.getText());
    if (checkNumber.pass()) {
      MixDO mix = getSelectedMix();
      String mixid = mix.getMixId();
      String foodid = cmbPortionFood.getSelectedItem().getFoodId();
      List<TablePortionMeals.Row> rows = tblMeals.getSelectedValues();
      double pct = Double.parseDouble(txtPortionPct.getText());
      int n = rows.size();
      pcti = pct / n;
      for (Row row : rows) {
        try {
          Future<Boolean> task0 =
              BackgroundExec.submit(
                  new InsertAndCalculateFoodPortionTask(mixid, row.getMealid(), foodid, pcti));
          Boolean complete = task0.get();
          if (complete) {
            try {
              Future<List<List>> task1 =
                  BackgroundExec.submit(new MealPlanPortionsTask(mix.getMixId()));
              List<List> portions = task1.get();
              tblMealPortions.reload(portions);
            } catch (Exception e) {
              LoggerImpl.INSTANCE.logProblem(e);
            }
            try {
              Future<List<List>> task =
                  BackgroundExec.submit(new MealPlanResultsTask(mix.getMixId()));
              List<List> results = task.get();
              tblMealCalories.reload(results);
              tblMealMacronutrients.reload(results);
            } catch (Exception e) {
              LoggerImpl.INSTANCE.logProblem(e);
            }
          }
        } catch (Exception e) {
          LoggerImpl.INSTANCE.logProblem(e);
        }
      }
    } else {
      Message.showMessage("Character must be number.");
    }
  }

  private void deleteFoodPortion() {
    if (!tblMealPortions.isSelectionEmpty()) {
      try {
        List<TablePortion.Row> rows = tblMealPortions.getSelectedValues();
        for (TablePortion.Row row : rows) {
          try {
            Future<Boolean> task0 =
                BackgroundExec.submit(
                    new DeleteFoodPortionTask(row.getMixid(), row.getMealid(), row.getFoodid()));
            Boolean complete = task0.get();
            if (complete) {
              try {
                Future<List<List>> task1 =
                    BackgroundExec.submit(new MealPlanPortionsTask(row.getMixid()));
                List<List> portions = task1.get();
                tblMealPortions.reload(portions);
              } catch (Exception e) {
                LoggerImpl.INSTANCE.logProblem(e);
              }
              try {
                Future<List<List>> task2 =
                    BackgroundExec.submit(new MealPlanResultsTask(row.getMixid()));
                List<List> results = task2.get();
                tblMealCalories.reload(results);
                tblMealMacronutrients.reload(results);
              } catch (Exception e) {
                LoggerImpl.INSTANCE.logProblem(e);
              }
            }
          } catch (Exception e) {
            LoggerImpl.INSTANCE.logProblem(e);
          }
        }
      } catch (Exception e) {
        LoggerImpl.INSTANCE.logProblem(e);
      }
    } else {
      Message.showMessage("Please select row or rows.");
    }
  }

  private void updateFoodPortionWeight() {
    JTextField txtInput = new JTextField();
    txtInput.setPreferredSize(new Dimension(50, 25));
    if (!tblMealPortions.isSelectionEmpty()) {
      TablePortion.Row row = tblMealPortions.getSelectedValue();
      BigDecimal actualwt = row.getActual();
      txtInput.setText(actualwt.toPlainString());
      JPanel pnlInput = new JPanel();
      pnlInput.add(new JLabel("Actual Weight: "));
      pnlInput.add(txtInput);
      JComponent[] inputs = {pnlInput};
      int optionValue = Message.showOptionDialogOkCancel(inputs, "Update Actual Weight");
      if (optionValue == 0) {
        try {
          String mixid = row.getMixid();
          Integer mealid = row.getMealid();
          String foodid = row.getFoodid();
          Future<Boolean> task0 =
              BackgroundExec.submit(
                  new UpdateFoodPortionActualWeightTask(
                      mixid, mealid, foodid, new BigDecimal(txtInput.getText())));
          Boolean complete = task0.get();
          if (complete) {
            try {
              Future<List<List>> task1 = BackgroundExec.submit(new MealPlanPortionsTask(mixid));
              List<List> portions = task1.get();
              tblMealPortions.reload(portions);
            } catch (Exception e) {
              LoggerImpl.INSTANCE.logProblem(e);
            }
            try {
              Future<List<List>> task = BackgroundExec.submit(new MealPlanResultsTask(mixid));
              List<List> results = task.get();
              tblMealCalories.reload(results);
              tblMealMacronutrients.reload(results);
            } catch (Exception e) {
              LoggerImpl.INSTANCE.logProblem(e);
            }
          }
        } catch (Exception e) {
          LoggerImpl.INSTANCE.logProblem(e);
        }
      }
    }
  }

  private void addMeal() {
    JTextField txtMealName = new JTextField();
    JTextField txtMealOrder = new JTextField();
    JPanel pnl = new JPanel();
    FormLayout lyo =
        new FormLayout(
            "28dlu,34dlu,100dlu", // columns
            "fill:16dlu,4dlu,fill:16dlu" // rows
            );
    pnl.setLayout(lyo);
    JLabel lblMealName = new JLabel("Name: ");
    lblMealName.setHorizontalAlignment(SwingConstants.RIGHT);
    pnl.add(lblMealName, cc.xy(1, 1));
    pnl.add(txtMealName, cc.xyw(2, 1, 2));
    JLabel lblMealOrder = new JLabel("Order: ");
    lblMealOrder.setHorizontalAlignment(SwingConstants.RIGHT);
    pnl.add(lblMealOrder, cc.xy(1, 3));
    pnl.add(txtMealOrder, cc.xy(2, 3));
    JComponent[] inputs = {pnl};
    int optionValue = Message.showOptionDialogOkCancel(inputs, "Add Meal");
    if (optionValue == 0) {
      NumberCheck checkNumber = new NumberCheck();
      checkNumber.addToUncheckedList(txtMealOrder.getText());
      if (checkNumber.pass()) {
        MixDO mix = getSelectedMix();
        String mealname = txtMealName.getText();
        Integer mealorder = Integer.valueOf(txtMealOrder.getText());
        try {
          Future<Integer> task =
              BackgroundExec.submit(new CreateMealTask(mix.getMixId(), mealname, mealorder));
          Integer mealid = task.get();
        } catch (Exception e) {
          LoggerImpl.INSTANCE.logProblem(e);
        }
        try {
          Future<List<List>> task = BackgroundExec.submit(new MealPlanMealsTask(mix.getMixId()));
          List<List> meals = task.get();
          tblMeals.reload(meals);
        } catch (Exception e) {
          LoggerImpl.INSTANCE.logProblem(e);
        }
      }
    }
  }

  private void deleteMeal() {
    if (!tblMeals.isSelectionEmpty()) {
      MixDO mix = getSelectedMix();
      Row meal = tblMeals.getSelectedValue();
      try {
        Future<Boolean> task =
            BackgroundExec.submit(new DeleteMealTask(meal.getMixid(), meal.getMealid()));
        Boolean completed = task.get();
        if (!completed) {
          return;
        }
      } catch (Exception e) {
        LoggerImpl.INSTANCE.logProblem(e);
      }
      try {
        Future<List<List>> task = BackgroundExec.submit(new MealPlanMealsTask(mix.getMixId()));
        List<List> meals = task.get();
        tblMeals.reload(meals);
      } catch (Exception e) {
        LoggerImpl.INSTANCE.logProblem(e);
      }
      try {
        Future<List<List>> task = BackgroundExec.submit(new MealPlanPortionsTask(mix.getMixId()));
        List<List> portions = task.get();
        tblMealPortions.reload(portions);
      } catch (Exception e) {
        LoggerImpl.INSTANCE.logProblem(e);
      }
      try {
        Future<List<List>> task = BackgroundExec.submit(new MealPlanResultsTask(mix.getMixId()));
        List<List> results = task.get();
        tblMealCalories.reload(results);
        tblMealMacronutrients.reload(results);
      } catch (Exception e) {
        LoggerImpl.INSTANCE.logProblem(e);
      }
    }
  }

  private void updateMeal() {
    JTextField txtMealName = new JTextField();
    JTextField txtMealOrder = new JTextField();
    if (!tblMeals.isSelectionEmpty()) {
      Row row = tblMeals.getSelectedValue();
      // String mixid = row.getMixid();
      Integer mealid = row.getMealid();
      String mealname = row.getMealname();
      Integer mealorder = row.getMealorder();
      txtMealName.setText(mealname);
      txtMealOrder.setText(String.valueOf(mealorder));
      JPanel pnl = new JPanel();
      FormLayout lyo =
          new FormLayout(
              "28dlu,34dlu,100dlu", // columns
              "fill:16dlu,4dlu,fill:16dlu" // rows
              );
      pnl.setLayout(lyo);
      JLabel lblMealName = new JLabel("Name: ");
      lblMealName.setHorizontalAlignment(SwingConstants.RIGHT);
      pnl.add(lblMealName, cc.xy(1, 1));
      pnl.add(txtMealName, cc.xyw(2, 1, 2));
      JLabel lblMealOrder = new JLabel("Order: ");
      lblMealOrder.setHorizontalAlignment(SwingConstants.RIGHT);
      pnl.add(lblMealOrder, cc.xy(1, 3));
      pnl.add(txtMealOrder, cc.xy(2, 3));
      JComponent[] inputs = {pnl};
      int optionValue = Message.showOptionDialogOkCancel(inputs, "Update Meal");
      if (optionValue == 0) {
        NumberCheck checkNumber = new NumberCheck();
        checkNumber.addToUncheckedList(txtMealOrder.getText());
        if (checkNumber.pass()) {
          mealname = txtMealName.getText();
          mealorder = Integer.valueOf(txtMealOrder.getText());
          MixDO mix = getSelectedMix();
          try {
            Future<Boolean> task =
                BackgroundExec.submit(
                    new UpdateMealTask(mix.getMixId(), mealid, mealname, mealorder));
            Boolean completed = task.get();
            if (!completed) {
              return;
            }
          } catch (Exception e) {
            LoggerImpl.INSTANCE.logProblem(e);
          }
          try {
            Future<List<List>> task = BackgroundExec.submit(new MealPlanMealsTask(mix.getMixId()));
            List<List> meals = task.get();
            tblMeals.reload(meals);
          } catch (Exception e) {
            LoggerImpl.INSTANCE.logProblem(e);
          }
          try {
            Future<List<List>> task =
                BackgroundExec.submit(new MealPlanPortionsTask(mix.getMixId()));
            List<List> portions = task.get();
            tblMealPortions.reload(portions);
          } catch (Exception e) {
            LoggerImpl.INSTANCE.logProblem(e);
          }
          try {
            Future<List<List>> task =
                BackgroundExec.submit(new MealPlanResultsTask(mix.getMixId()));
            List<List> results = task.get();
            tblMealCalories.reload(results);
            tblMealMacronutrients.reload(results);
          } catch (Exception e) {
            LoggerImpl.INSTANCE.logProblem(e);
          }
        }
      }
    }
  }

  private void addMixFood() {
    DefaultMutableTreeNode node = (DefaultMutableTreeNode) treFoods.getLastSelectedPathComponent();
    if (node == null) {
      return;
    }
    MixFoodDO food = (MixFoodDO) node.getUserObject();
    if (node.isLeaf()) {
      try {
        MixDO mix = getSelectedMix();
        Future<Boolean> task0 =
            BackgroundExec.submit(new InsertMixFoodTask(mix.getMixId(), food.getFoodId()));
        Boolean completed = task0.get();
        if (!completed) {
          return;
        }
        try {
          Future<List<List>> task1 =
              BackgroundExec.submit(new NamedMixFoodSortedByNameTask(mix.getMixId()));
          List<List> foods = task1.get();
          tblMixFood.reload(foods);
        } catch (Exception e) {
          LoggerImpl.INSTANCE.logProblem(e);
        }
        reloadFoodComboBoxes(mix.getMixId());
        selectFoodComboBoxItem();
      } catch (Exception e) {
        LoggerImpl.INSTANCE.logProblem(e);
      }
    }
  }

  private void collapseFoods() {
    int rowCount = treFoods.getRowCount();
    for (int i = 1; i < rowCount; i++) {
      treFoods.collapseRow(i);
    }
  }

  private void deleteMixFood() {
    TableFood.Row food = tblMixFood.getSelectedValue();
    if (food.isNull()) {
      return;
    }
    MixDO mix = getSelectedMix();
    try {
      Future<Boolean> task =
          BackgroundExec.submit(new DeleteMixFoodTask(mix.getMixId(), food.getFoodid()));
      Boolean completed = task.get();
      if (!completed) {
        return;
      }
    } catch (Exception e) {
      LoggerImpl.INSTANCE.logProblem(e);
    }
    try {
      Future<List<List>> task =
          BackgroundExec.submit(new NamedMixFoodSortedByNameTask(mix.getMixId()));
      List<List> foods = task.get();
      tblMixFood.reload(foods);
    } catch (Exception e) {
      LoggerImpl.INSTANCE.logProblem(e);
    }
    reloadFoodComboBoxes(mix.getMixId());
    selectFoodComboBoxItem();
    reloadMixConstraints(mix.getMixId());
    try {
      Future<List<List>> task = BackgroundExec.submit(new MixResultsTask(mix.getMixId()));
      List<List> results = task.get();
      if (results.isEmpty()) {
        return;
      }
      tblCalories.reload(Reloader.getEnergy(results));
      tblMacronutrients.reload(Reloader.getMass(results));
      tblProtein.reload(Reloader.getProtein(results));
      tblFats.reload(Reloader.getFat(results));
      tblSfa.reload(Reloader.getSaturatedFat(results));
      tblPufa.reload(Reloader.getPolyunsaturatedFat(results));
      tblCarbs.reload(Reloader.getCarbohydrates(results));
      tblVitamins.reload(Reloader.getVitamins(results));
      tblMinerals.reload(Reloader.getMinerals(results));
      tblElectrolytes.reload(Reloader.getElectrolytes(results));
      tblPhytonutrients.reload(Reloader.getPhytonutrients(results));
      tblCost.reload(Reloader.getCost(results));
    } catch (Exception e) {
      LoggerImpl.INSTANCE.logProblem(e);
    }
    try {
      Future<List<List>> task = BackgroundExec.submit(new MealPlanPortionsTask(mix.getMixId()));
      List<List> portions = task.get();
      tblMealPortions.reload(portions);
    } catch (Exception e) {
      LoggerImpl.INSTANCE.logProblem(e);
    }
    LifeStageDO lifestage = (LifeStageDO) cmbLifestage.getSelectedItem();
    try {
      Future<List<List>> task =
          BackgroundExec.submit(new DriDifferenceTask(mix.getMixId(), lifestage.getLifeStageId()));
      List<List> diff = task.get();
      tblDri.reload(diff);
      setQuantityScale();
    } catch (Exception e) {
      LoggerImpl.INSTANCE.logProblem(e);
    }
  }

  private void expandFoods() {
    int rowCount = treFoods.getRowCount();
    expandTree(treFoods, 0, rowCount);
  }

  private void addNutrientQuantityConstraint() {
    if (checkNutrientQuantityConstraint()) {
      NumberCheck numberCheck = new NumberCheck();
      numberCheck.addToUncheckedList(txtNutrientQuantityValue.getText());
      if (numberCheck.pass()) {
        NutrientDO nutrientDO = cmbNutrientQuantityNutrient.getSelectedItem();
        RelationshipDO relationshipDataObject =
            (RelationshipDO) cmbNutrientQuantityRelationship.getSelectedItem();
        BigDecimal b = new BigDecimal(txtNutrientQuantityValue.getText());
        MixDO mix = getSelectedMix();
        try {
          Future<Boolean> task0 =
              BackgroundExec.submit(
                  new MergeNutrientQuantityConstraintTask(
                      mix.getMixId(),
                      nutrientDO.getNutr_no(),
                      relationshipDataObject.getRelationshipid(),
                      b));
          Boolean completed = task0.get();
          if (!completed) {
            return;
          }
          Future<List<List>> task1 =
              BackgroundExec.submit(new NutrientQuantityConstraintsTask(mix.getMixId()));
          List<List> constraints = task1.get();
          tblNutrientQuantityConstraint.reload(constraints);
          setConstraintCounts();
        } catch (Exception e) {
          LoggerImpl.INSTANCE.logProblem(e);
        }
      } else {
        Message.showMessage("Value must be a number greater than or equal to zero");
      }
    }
  }

  private void deleteNutrientQuantityConstraint() {
    TableNutrientQuantity.Row row = tblNutrientQuantityConstraint.getSelectedValue();
    String mixid = String.valueOf(row.getMixid());
    String nutrientid = row.getNutrientid();
    Integer relationshipid = row.getRelationshipid();
    try {
      Future<Boolean> task0 =
          BackgroundExec.submit(
              new DeleteNutrientQuantityConstraintTask(mixid, nutrientid, relationshipid));
      Boolean completed = task0.get();
      if (!completed) {
        return;
      }
      Future<List<List>> task1 = BackgroundExec.submit(new NutrientQuantityConstraintsTask(mixid));
      List<List> constraints = task1.get();
      tblNutrientQuantityConstraint.reload(constraints);
      setConstraintCounts();
    } catch (Exception e) {
      LoggerImpl.INSTANCE.logProblem(e);
    }
  }

  private void addNutrientRatioConstraint() {
    if (checkNutrientRatioConstraint()) {
      NumberCheck numberCheck = new NumberCheck();
      numberCheck.addToUncheckedList(txtNutrientRatioNutrientA.getText());
      numberCheck.addToUncheckedList(txtNutrientRatioNutrientB.getText());
      if (numberCheck.pass()) {
        NutrientDO nutrientDOA = cmbNutrientRatioNutrientA.getSelectedItem();
        NutrientDO nutrientDOB = cmbNutrientRatioNutrientB.getSelectedItem();
        RelationshipDO relationshipDataObject =
            (RelationshipDO) cmbNutrientRatioRelationship.getSelectedItem();
        BigDecimal A = new BigDecimal(txtNutrientRatioNutrientA.getText());
        BigDecimal B = new BigDecimal(txtNutrientRatioNutrientB.getText());
        MixDO mix = getSelectedMix();
        try {
          Future<Boolean> task0 =
              BackgroundExec.submit(
                  new MergeNutrientRatioConstraintTask(
                      mix.getMixId(),
                      nutrientDOA.getNutr_no(),
                      nutrientDOB.getNutr_no(),
                      relationshipDataObject.getRelationshipid(),
                      A,
                      B));
          Boolean completed = task0.get();
          if (!completed) {
            return;
          }
          Future<List<List>> task1 =
              BackgroundExec.submit(new NutrientRatioConstraintsTask(mix.getMixId()));
          List<List> constraints = task1.get();
          tblNutrientRatio.reload(constraints);
          setConstraintCounts();
        } catch (Exception e) {
          LoggerImpl.INSTANCE.logProblem(e);
        }
      } else {
        Message.showMessage("Value must be a number greater than zero");
      }
    }
  }

  private void deleteNutrientRatioConstraint() {
    TableNutrientRatioConstraint.Row row = tblNutrientRatio.getSelectedValue();
    String mixid = row.getMixid();
    String nutrientaid = row.getNutrientaid();
    String nutrientbid = row.getNutrientbid();
    Integer relationshipid = row.getRelationshipid();
    try {
      Future<Boolean> task0 =
          BackgroundExec.submit(
              new DeleteNutrientRatioConstraintTask(
                  mixid, nutrientaid, nutrientbid, relationshipid));
      Boolean completed = task0.get();
      if (!completed) {
        return;
      }
      Future<List<List>> task1 = BackgroundExec.submit(new NutrientRatioConstraintsTask(mixid));
      List<List> constraints = task1.get();
      tblNutrientRatio.reload(constraints);
      setConstraintCounts();
    } catch (Exception e) {
      LoggerImpl.INSTANCE.logProblem(e);
    }
  }

  private void solveModel(MixDO mix) {
    LpsolvePrintOut print = new LpsolvePrintOut();
    LinearProgram program = new LinearProgram();
    String mixid = mix.getMixId();
    String mixname = mix.getName();
    try {
      program.setComponent(getNoSolutionPanel());

      // ----- OBJECTIVE FUNCTION -----
      createObjectiveFunction(mixid, program, print);

      // ----- NUTRIENT QUANTITY CONSTRAINTS -----
      createNutrientQuantityConstraints(mixid, program, print);

      // ----- NUTRIENT RATIO CONSTRAINTS -----
      createNutrientRatioConstraint(mixid, program, print);

      // ----- FOOD QUANTITY CONSTRAINTS -----
      createFoodQuantityConstraint(mixid, program, print);

      // ----- FOOD RATIO CONSTRAINTS -----
      createFoodRatioConstraint(mixid, program, print);

      // ----- LEGENDS -----
      print.addMixLegend(mixname);
      print.addFoodLegend(createFoodLegend(mixid));

      // ----- SOLVE MODEL -----
      if (program.solve()) {
        String nutrientid = getSelectedMixObjective();
        double[] point = program.getPoint();
        BigDecimal cost = new BigDecimal(program.getCost(), MathContext.DECIMAL64);
        // ---- UPDATE DATABASE -----
        Future<List<Map>> task0 = BackgroundExec.submit(new MixFoodsTask(mixid));
        List<Map> mixfoodlist = task0.get();
        for (int i = 0; i < mixfoodlist.size(); i++) {
          Map row = mixfoodlist.get(i);
          String foodid = (String) row.get("FOODID");
          BigDecimal x = new BigDecimal(point[i], MathContext.DECIMAL64);
          Future<Boolean> task1 =
              BackgroundExec.submit(new UpdateQuantityOnMixFoodTask(mixid, foodid, x));
          task1.get();
        }
        Future<Boolean> task2 = BackgroundExec.submit(new UpdateCostOnMixTask(mixid, cost));
        task2.get();
        Future<Boolean> task3 = BackgroundExec.submit(new AllocateTask(mixid));
        task3.get();
        // ----- CREATE LPSOLVE MODEL AND SET -----
        print.feasible();
        String model = print.toString();
        // ----- UPDATE DATABASE  -----
        Future<Boolean> task4 = BackgroundExec.submit(new UpdateModelOnMixTask(mixid, model));
        task4.get();
        //
        mix.setModel(model);
        mix.setCost(cost);
        mix.setNutrientid(nutrientid);
        FileName fileName = new FileName();
        if (chkLpsolve.isSelected()) {
          Utilities.write(fileName.getLpsolveFileName(), model);
        }
        // ---- SET THE HIGH SCORE ----
        setTheHighScore(cost);
      } else {
        // ----- CREATE LPSOLVE MODEL AND SET -----
        print.unfeasible();
        String model = print.toString();
        // ----- UPDATE DATABASE  -----
        Future<Boolean> task5 = BackgroundExec.submit(new UpdateModelOnMixTask(mixid, model));
        task5.get();
      }
      setConstraintCounts();
    } catch (Exception e) {
      LoggerImpl.INSTANCE.logProblem(e);
    }
  }

  private String getSelectedMixObjective() {
    String nutrientid = "10009";
    if (raiCost.isSelected()) {
      nutrientid = "10005";
    }
    return nutrientid;
  }

  private void setTheHighScore(BigDecimal cost) {
    listModelHighScore.addElement(cost);
    lstHighScore.ensureIndexIsVisible(listModelHighScore.getSize() - 1);
    lstHighScore.setSelectedIndex(lstHighScore.getLastVisibleIndex());
  }

  private String createFoodLegend(String mixid) {
    StringBuilder sb = new StringBuilder();
    try {
      Future<List<Map<String, String>>> task =
          BackgroundExec.submit(new NamedMixFoodSortedByIdTask(mixid));
      List<Map<String, String>> source = task.get();
      if (source.isEmpty()) {
        return "";
      }
      List<MixFoodDO> foodsInMix = new ArrayList();
      source.forEach(
          row -> {
            String foodid = row.get("FOODID");
            String name = row.get("NAME");
            foodsInMix.add(new MixFoodDO(foodid, name));
          });
      for (int i = 0; i < foodsInMix.size(); i++) {
        sb.append(String.format("%1$2d) %2$s", i + 1, foodsInMix.get(i).getFoodName()));
        sb.append("\n");
      }
      if (sb.length() > 0) {
        sb.setLength(sb.length() - 1);
      }
    } catch (Exception e) {
      LoggerImpl.INSTANCE.logProblem(e);
    }
    return sb.toString();
  }

  private void createObjectiveFunction(
      String mixid, LinearProgram lpmodel, LpsolvePrintOut lpsolve) {
    try {
      Future<double[]> task = BackgroundExec.submit(new ObjectiveLhsTask(mixid));
      double[] objectiveFunctionCoefficients = task.get();
      lpmodel.addObjectiveFunction(objectiveFunctionCoefficients);
      String objectiveFunctionName;
      if (raiCalories.isSelected()) {
        objectiveFunctionName = "Calories";
      } else {
        objectiveFunctionName = "Cost";
      }
      lpsolve.addObjectiveFunction(objectiveFunctionCoefficients, objectiveFunctionName);
    } catch (Exception e) {
      LoggerImpl.INSTANCE.logProblem(e);
    }
  }

  private void createNutrientQuantityConstraints(
      String mixid, LinearProgram lpmodel, LpsolvePrintOut lpsolve) {
    try {
      Future<List<Map<String, Object>>> taskRhs =
          BackgroundExec.submit(new NutrientQuantityRhsTask(mixid));
      List<Map<String, Object>> lst = taskRhs.get();
      lst.forEach(
          (row) -> {
            try {
              String nutrientid = (String) row.get("NUTRIENTID");
              Integer relationshipid = (Integer) row.get("RELATIONSHIPID");
              Double b = (Double) row.get("B");
              String nutrient = (String) row.get("NUTRIENT");
              String eq = (String) row.get("EQ");
              Future<double[]> taskLhs =
                  BackgroundExec.submit(
                      new NutrientQuantityLhsTask(mixid, nutrientid, relationshipid));
              double[] coefficients = taskLhs.get();
              lpmodel.addConstraint(coefficients, relationshipid, b);
              StringBuilder constraintName = new StringBuilder();
              constraintName.append(nutrient).append(" ").append(eq).append(" ").append(b);
              lpsolve.addNutrientQuantityConstraint(
                  coefficients, relationshipid, b, constraintName.toString());
            } catch (Exception e) {
              LoggerImpl.INSTANCE.logProblem(e);
            }
          });
    } catch (Exception e) {
      LoggerImpl.INSTANCE.logProblem(e);
    }
  }

  private void createNutrientRatioConstraint(
      String mixid, LinearProgram lpmodel, LpsolvePrintOut lpsolve) {
    try {
      Future<List<Map<String, Object>>> task =
          BackgroundExec.submit(new NutrientRatioRhsTask(mixid));
      List<Map<String, Object>> lst = task.get();
      lst.forEach(
          (row) -> {
            try {
              String nutrientid1 = (String) row.get("NUTRIENT_ID_1");
              String nutrientid2 = (String) row.get("NUTRIENT_ID_2");
              int relationshipid = (int) row.get("RELATIONSHIPID");
              BigDecimal a = (BigDecimal) row.get("A");
              BigDecimal b = (BigDecimal) row.get("B");
              String nutrient1 = (String) row.get("NUTRIENT1");
              String nutrient2 = (String) row.get("NUTRIENT2");
              String eq = (String) row.get("EQ");
              Future<double[]> taskLhs =
                  BackgroundExec.submit(
                      new NutrientRatioLhsTask(mixid, nutrientid1, nutrientid2, relationshipid));
              double[] coefficients = taskLhs.get();
              lpmodel.addConstraint(coefficients, relationshipid, 0.0);
              StringBuilder constraintName = new StringBuilder();
              constraintName
                  .append(nutrient1)
                  .append(" / ")
                  .append(nutrient2)
                  .append(" ")
                  .append(eq)
                  .append(" ")
                  .append(a)
                  .append(" / ")
                  .append(b);
              lpsolve.addNutrientRatioConstraint(
                  coefficients, relationshipid, 0.0, constraintName.toString());
            } catch (Exception e) {
              LoggerImpl.INSTANCE.logProblem(e);
            }
          });
    } catch (Exception e) {
      LoggerImpl.INSTANCE.logProblem(e);
    }
  }

  private void createFoodQuantityConstraint(
      String mixid, LinearProgram lpmodel, LpsolvePrintOut lpsolve) {
    try {
      Future<List<Map<String, Object>>> task =
          BackgroundExec.submit(new FoodQuantityRhsTask(mixid));
      List<Map<String, Object>> lst = task.get();
      lst.forEach(
          (row) -> {
            try {
              String foodid = (String) row.get("FOODID");
              String nutrientid = (String) row.get("NUTRIENTID");
              Integer relationshipid = (Integer) row.get("RELATIONSHIPID");
              Double b = (double) row.get("B");
              String food = (String) row.get("FOOD");
              String nutrient = (String) row.get("NUTRIENT");
              String eq = (String) row.get("EQ");
              Future<double[]> taskLhs =
                  BackgroundExec.submit(
                      new FoodQuantityLhsTask(mixid, foodid, nutrientid, relationshipid));
              double[] coefficients = taskLhs.get();
              lpmodel.addConstraint(coefficients, relationshipid, b);
              StringBuilder constraintName = new StringBuilder();
              constraintName
                  .append(food)
                  .append(" AS ")
                  .append(nutrient)
                  .append(" ")
                  .append(eq)
                  .append(" ")
                  .append(b);
              lpsolve.addFoodQuantityConstraint(
                  coefficients, relationshipid, b, constraintName.toString());
            } catch (Exception e) {
              LoggerImpl.INSTANCE.logProblem(e);
            }
          });
    } catch (Exception e) {
      LoggerImpl.INSTANCE.logProblem(e);
    }
  }

  private void createFoodRatioConstraint(
      String mixid, LinearProgram lpmodel, LpsolvePrintOut lpsolve) {
    try {
      Future<List<Map<String, Object>>> task = BackgroundExec.submit(new FoodRatioRhsTask(mixid));
      List<Map<String, Object>> lst = task.get();
      lst.forEach(
          (row) -> {
            try {
              String foodid1 = (String) row.get("FOOD_ID_1");
              String nutrientid1 = (String) row.get("NUTRIENT_ID_1");
              String foodid2 = (String) row.get("FOOD_ID_2");
              String nutrientid2 = (String) row.get("NUTRIENT_ID_2");
              int relationshipid = (int) row.get("RELATIONSHIPID");
              BigDecimal a = (BigDecimal) row.get("A");
              BigDecimal b = (BigDecimal) row.get("B");
              String food1 = (String) row.get("FOOD1");
              String nutrient1 = (String) row.get("NUTRIENT1");
              String food2 = (String) row.get("FOOD2");
              String nutrient2 = (String) row.get("NUTRIENT2");
              String eq = (String) row.get("EQ");
              Future<double[]> taskLhs =
                  BackgroundExec.submit(
                      new FoodRatioLhsTask(
                          mixid, foodid1, nutrientid1, foodid2, nutrientid2, relationshipid));
              double[] coefficients = taskLhs.get();
              lpmodel.addConstraint(coefficients, relationshipid, 0.0);
              StringBuilder constraintName = new StringBuilder();
              constraintName
                  .append(food1)
                  .append(" AS ")
                  .append(nutrient1)
                  .append(" / ")
                  .append(food2)
                  .append(" AS ")
                  .append(nutrient2)
                  .append(" ")
                  .append(eq)
                  .append(" ")
                  .append(a)
                  .append(" / ")
                  .append(b);
              lpsolve.addFoodRatioConstraint(
                  coefficients, relationshipid, 0.0, constraintName.toString());
            } catch (Exception e) {
              LoggerImpl.INSTANCE.logProblem(e);
            }
          });
    } catch (Exception e) {
      LoggerImpl.INSTANCE.logProblem(e);
    }
  }

  private void calculateRemainingFoodAllocationPercentage() {
    if (!cmbPortionFood.isSelectionEmpty()) {
      try {
        MixDO mix = getSelectedMix();
        MixFoodDO food = cmbPortionFood.getSelectedItem();
        String mixid = mix.getMixId();
        String foodid = food.getFoodId();
        Future<BigDecimal> task =
            BackgroundExec.submit(new UnallocatedFoodPercentageTask(mixid, foodid));
        BigDecimal remaining = task.get();
        txtTotalPct.setText(remaining.toPlainString().strip());
      } catch (Exception e) {
        LoggerImpl.INSTANCE.logProblem(e);
      }
    }
  }

  private void clearHighscore() {
    listModelHighScore.clear();
  }

  private void showPopup(MouseEvent e, JPopupMenu pmn) {
    if (SwingUtilities.isRightMouseButton(e)) {
      Component component = e.getComponent();
      pmn.show(component, e.getX(), e.getY());
    }
  }

  private void showAbout() {
    JTextPane txp = new JTextPane();
    txp.setEditorKit(JEditorPane.createEditorKitForContentType("text/html"));
    txp.setText(Utilities.getResourceAsString("/resources/html/about.html"));
    txp.setEditable(false);
    txp.putClientProperty(JEditorPane.HONOR_DISPLAY_PROPERTIES, true);
    txp.addHyperlinkListener(
        (HyperlinkEvent e) -> {
          if (e.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
            if (Desktop.isDesktopSupported()) {
              Utilities.openUrl(e.getURL().toString());
            }
          }
        });
    JScrollPane scr = new JScrollPane(txp);
    scr.setPreferredSize(new Dimension(800, 400));
    JComponent[] inputs = {scr};
    Message.showOptionDialog(inputs, "About");
  }

  private void moveFoodPortion() {
    if (!tblMealPortions.isSelectionEmpty()) {
      List<TablePortion.Row> rows = tblMealPortions.getSelectedValues();
      if (!tblMeals.getSelectedValues().isEmpty()) {
        List<Row> selectedMeals = tblMeals.getSelectedValues();
        for (TablePortion.Row row : rows) {
          String mixid = row.getMixid();
          Integer mealid = row.getMealid();
          String foodid = row.getFoodid();
          Double pct = row.getPct().doubleValue();
          Double pcti = pct / selectedMeals.size();
          MixDO mix = getSelectedMix();
          try {
            Future<Boolean> task0 =
                BackgroundExec.submit(new DeleteFoodPortionTask(mixid, mealid, foodid));
            Boolean task0Complete = task0.get();
            for (Row meal : selectedMeals) {
              Future<Boolean> task1 =
                  BackgroundExec.submit(
                      new InsertAndCalculateFoodPortionTask(
                          mix.getMixId(), meal.getMealid(), foodid, pcti));
              Boolean task1Complete = task1.get();
            }
            try {
              Future<List<List>> task =
                  BackgroundExec.submit(new MealPlanPortionsTask(mix.getMixId()));
              List<List> portions = task.get();
              tblMealPortions.reload(portions);
            } catch (Exception e) {
              LoggerImpl.INSTANCE.logProblem(e);
            }
            try {
              Future<List<List>> task =
                  BackgroundExec.submit(new MealPlanResultsTask(mix.getMixId()));
              List<List> results = task.get();
              tblMealCalories.reload(results);
              tblMealMacronutrients.reload(results);
            } catch (Exception e) {
              LoggerImpl.INSTANCE.logProblem(e);
            }
          } catch (Exception e) {
            LoggerImpl.INSTANCE.logProblem(e);
          }
        }
      } else {
        Message.showMessage("Please select one or more meals.");
      }
    }
  }

  private void showAuthor() {
    JTextPane txp = new JTextPane();
    txp.setEditorKit(JEditorPane.createEditorKitForContentType("text/html"));
    txp.setText(Utilities.getResourceAsString("/resources/html/author.html"));
    txp.setEditable(false);
    txp.putClientProperty(JEditorPane.HONOR_DISPLAY_PROPERTIES, true);
    txp.addHyperlinkListener(
        (HyperlinkEvent e) -> {
          if (e.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
            if (Desktop.isDesktopSupported()) {
              Utilities.openUrl(e.getURL().toString());
            }
          }
        });
    JScrollPane scr = new JScrollPane(txp);
    scr.setPreferredSize(new Dimension(800, 400));
    JComponent[] inputs = {scr};
    Message.showOptionDialog(inputs, "Author");
  }

  private void calculateBmr() {
    JTextField txtInput = new JTextField();
    JPanel pnl = new JPanel();
    txtInput.setPreferredSize(new Dimension(50, 25));
    pnl.add(new JLabel("What is your lean body mass in pounds?"));
    pnl.add(txtInput);
    JComponent[] inputs = {pnl};
    int optionValue = Message.showOptionDialogOkCancel(inputs, "Basal Metabolic Rate");
    if (optionValue == 0) {
      String s = txtInput.getText();
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
          Message.showMessagePadW510H150("Basal Metabolic Rate", sb.toString());
        } else {
          Message.showMessage("Numbers only");
        }
      }
    }
  }

  private void convertMicronutrient() {
    FormLayout lyo =
        new FormLayout(
            "min:grow,min,30dlu", // columns
            "28px,fill:28px" // rows
            );
    JPanel pnl = new JPanel();
    pnl.setLayout(lyo);
    ComboBox<LifeStageDO> cmbLifeStage = new ComboBox();
    ComboBox<NutrientDO> cmbNutrients = new ComboBox();
    JLabel lblDV = new JLabel(" %DRI ");
    try {
      Future<List<LifeStageDO>> task = BackgroundExec.submit(new LifestagesTask());
      List<LifeStageDO> lifestages = task.get();
      cmbLifeStage.reload(lifestages);
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
    } catch (Exception e) {
      LoggerImpl.INSTANCE.logProblem(e);
    }
    JTextField txtDailyValuePct = new JTextField();
    txtDailyValuePct.setMinimumSize(new Dimension(50, 20));
    pnl.add(cmbLifeStage, cc.xyw(1, 1, 3));
    pnl.add(cmbNutrients, cc.xy(1, 2));
    pnl.add(lblDV, cc.xy(2, 2));
    pnl.add(txtDailyValuePct, cc.xy(3, 2));
    JComponent[] inputs = {pnl};
    int optionValue =
        Message.showOptionDialogOkCancel(
            inputs, "Percent of Daily Reference Intake (DRI) to Grams");
    if (optionValue == 0) {
      String s = txtDailyValuePct.getText();
      if (s != null && s.length() > 0) {
        try {
          Future<List<DriDO>> task =
              BackgroundExec.submit(
                  new LifestageDriTask(
                      cmbNutrients.getSelectedItem().getNutr_no(),
                      cmbLifeStage.getSelectedItem().getLifeStageId()));

          List<DriDO> driDOlist = task.get();
          DriDO driDO = driDOlist.get(0);
          NutrientDO nutrientDO = cmbNutrients.getSelectedItem();
          StringBuilder sb = new StringBuilder();
          NumberCheck checkNumber = new NumberCheck();
          checkNumber.addToUncheckedList(s);
          if (checkNumber.pass()) {
            double dvpct = Double.parseDouble(s);
            sb.append("The ");
            sb.append(driDO.getNutrientName().substring(0, driDO.getNutrientName().length() - 5));
            sb.append(" ");
            sb.append(String.format("%.0f", dvpct));
            sb.append("% ");
            sb.append("DRI recommendation for ");
            sb.append(driDO.getLifestageLabel());
            sb.append(" is ");
            sb.append(String.format("%.1f", dvpct * (driDO.getNutrientQ().doubleValue() / 100)));
            sb.append(" ");
            sb.append(driDO.getNutrientUnits());
            sb.append("\n");
            Message.showMessage("Percent of Daily Reference Intake (DRI) to Grams", sb.toString());
          } else {
            Message.showMessage("Numbers only");
          }
        } catch (Exception e) {
          LoggerImpl.INSTANCE.logProblem(e);
        }
      }
    }
  }

  private void showCredits() {
    JTextPane txp = new JTextPane();
    txp.setEditorKit(JEditorPane.createEditorKitForContentType("text/html"));
    txp.setText(Utilities.getResourceAsString("/resources/html/credits.html"));
    txp.setEditable(false);
    txp.putClientProperty(JEditorPane.HONOR_DISPLAY_PROPERTIES, true);
    txp.addHyperlinkListener(
        (HyperlinkEvent e) -> {
          if (e.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
            if (Desktop.isDesktopSupported()) {
              Utilities.openUrl(e.getURL().toString());
            }
          }
        });
    JScrollPane scr = new JScrollPane(txp);
    scr.setPreferredSize(new Dimension(800, 400));
    JComponent[] inputs = {scr};
    Message.showOptionDialog(inputs, "Credits");
  }

  private void calculateDigestibleCarbs() {
    FormLayout lyo =
        new FormLayout(
            "min,30dlu", // columns
            "min,16dlu" // rows
            );
    JPanel pnl = new JPanel();
    pnl.setLayout(lyo);
    JTextField txtTotalCarbs = new JTextField();
    JTextField txtTotalFiber = new JTextField();
    JLabel lblTotalCarbs = new JLabel("What is total carbohydrate (g) of food item? ");
    JLabel lblTotalFiber = new JLabel("What is total fiber (g) in food item? ");
    lblTotalCarbs.setHorizontalAlignment(SwingConstants.RIGHT);
    lblTotalFiber.setHorizontalAlignment(SwingConstants.RIGHT);
    pnl.add(lblTotalCarbs, cc.xy(1, 1));
    pnl.add(txtTotalCarbs, cc.xy(2, 1));
    pnl.add(lblTotalFiber, cc.xy(1, 2));
    pnl.add(txtTotalFiber, cc.xy(2, 2));
    JComponent[] inputs = {pnl};
    int optionValue = Message.showOptionDialogOkCancel(inputs, "Digestible Carbohydrate");
    if (optionValue == 0) {
      String totalCarbs = txtTotalCarbs.getText();
      String totalFiber = txtTotalFiber.getText();
      if (totalCarbs != null && totalCarbs.length() > 0) {
        if (totalFiber != null && totalFiber.length() > 0) {
          StringBuilder sb = new StringBuilder();
          NumberCheck checkNumber = new NumberCheck();
          checkNumber.addToUncheckedList(totalCarbs);
          checkNumber.addToUncheckedList(totalFiber);
          if (checkNumber.pass()) {
            Double totalCarbsNumber = Double.valueOf(totalCarbs);
            Double totalFiberNumber = Double.valueOf(totalFiber);
            double digestibleCarbsNumber =
                new DigestibleCarbohydrate(totalCarbsNumber, totalFiberNumber)
                    .getDigestibleCarbohydrate();
            sb.append("There are ");
            sb.append(digestibleCarbsNumber);
            sb.append(" grams of digestible carbohydrates.");
            Message.showMessagePadW510H150("Digestible Carbohydrate", sb.toString());
          }
        }
      }
    }
  }

  private void createFoodComparisonReport() {
    FoodComparisonReport csv = new FoodComparisonReport();
    csv.create(tblFoodDiff, tblFoodDiffA, tblFoodDiffB);
  }

  private void createAllFoodsReport1() {
    frm.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
    BackgroundExec.execute(new CreateAllFoodsReport1Task(frm));
  }

  private void createAllFoodsReport2() {
    frm.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
    BackgroundExec.execute(new CreateAllFoodsReport2Task(frm));
  }

  private void createMealPlanCaloriesReport() {
    MixDO mix = getSelectedMix();
    (new MealPlanCaloriesReport()).create(mix);
  }

  private void createMealPlanMacronutrientsReport() {
    MixDO mix = getSelectedMix();
    (new MealPlanMacronutrientsReport()).create(mix);
  }

  private void createMealPlanPortionsReport() {
    MixDO mix = getSelectedMix();
    (new MealPlanPortionsReport()).create(mix);
  }

  private void createMealPlanUsageReport() {
    (new MealPlanUsageReport()).create();
  }

  private void createMixComparisonReport() {
    (new MixComparisonReport()).create(tblMixDiff, tblMixDiffA, tblMixDiffB);
  }

  private void createMixResultsReport1() {
    MixDO mix = getSelectedMix();
    (new MixResultsReport()).create(mix);
  }

  private void createMixResultsReport2() {
    MixDO mix = getSelectedMix();
    (new MixResultsReport2()).create(mix);
  }

  private void exportMix() {
    int returnVal = fch.showSaveDialog(frm);
    if (returnVal == JFileChooser.APPROVE_OPTION) {
      File file = fch.getSelectedFile();
      String path = file.getAbsolutePath();
      fch.setCurrentDirectory(new File(path));
      frm.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
      try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
        try {
          MixDO mix = getSelectedMix();
          Future<String> task = BackgroundExec.submit(new ExportMixTask(mix.getMixId()));
          String doc = task.get();
          if (doc.isEmpty()) {
            frm.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
            return;
          }
          writer.write(Utilities.formatXmlDoc(doc));
          frm.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
          showMessageSent(path);
        } catch (Exception e) {
          LoggerImpl.INSTANCE.logProblem(e);
        }
      } catch (IOException e) {
        LoggerImpl.INSTANCE.logProblem(e);
      }
    }
  }

  private void createNutrientContentReport() {
    (new NutrientContentReport()).create(txtNutrientSearchQuantity, cmbNutrientContentNutrient);
  }

  private void createDriReport() {
    LifeStageDO lifestage = (LifeStageDO) cmbLifestage.getSelectedItem();
    MixDO mix = getSelectedMix();
    (new DriReport()).create(mix, lifestage);
  }

  private void calculateGlycemicIndexRange() {
    JTextField txtInput = new JTextField();
    JPanel pnl = new JPanel();
    txtInput.setPreferredSize(new Dimension(50, 25));
    pnl.add(new JLabel("What is glycemic index of food item?"));
    pnl.add(txtInput);
    JComponent[] inputs = {pnl};
    int optionValue = Message.showOptionDialogOkCancel(inputs, "Glycemic Index Range");
    if (optionValue == 0) {
      String strGI = txtInput.getText();
      if (strGI != null && strGI.length() > 0) {
        StringBuilder sb = new StringBuilder();
        NumberCheck checkNumber = new NumberCheck();
        checkNumber.addToUncheckedList(strGI);
        if (checkNumber.pass()) {
          Integer gi = Integer.valueOf(strGI);
          String range = new GlycemicIndexRange(gi).getGlycemicIndexRange();
          sb.append("The glycemic index is in ");
          sb.append(range.toLowerCase());
          sb.append(" range.");
          Message.showMessagePadW510H150("Glycemic Index Range", sb.toString());
        }
      }
    }
  }

  private void calculateGlycemicLoad() {
    FormLayout lyo =
        new FormLayout(
            "min,30dlu", // columns
            "min,16dlu" // rows
            );
    JPanel pnl = new JPanel();
    pnl.setLayout(lyo);
    JTextField txtGi = new JTextField();
    JTextField txtDigestibleCarbs = new JTextField();
    JLabel lblDigestibleCarbs = new JLabel("How many digestible carbs (g) in food item? ");
    JLabel lblGi = new JLabel("What is glycemic index of food item? ");
    lblDigestibleCarbs.setHorizontalAlignment(SwingConstants.RIGHT);
    lblGi.setHorizontalAlignment(SwingConstants.RIGHT);
    pnl.add(lblDigestibleCarbs, cc.xy(1, 1));
    pnl.add(txtDigestibleCarbs, cc.xy(2, 1));
    pnl.add(lblGi, cc.xy(1, 2));
    pnl.add(txtGi, cc.xy(2, 2));
    JComponent[] inputs = {pnl};
    int optionValue = Message.showOptionDialogOkCancel(inputs, "Glycemic Load");
    if (optionValue == 0) {
      String gi = txtGi.getText();
      String carbs = txtDigestibleCarbs.getText();
      if (gi != null && gi.length() > 0) {
        if (carbs != null && carbs.length() > 0) {
          StringBuilder sb = new StringBuilder();
          NumberCheck checkNumber = new NumberCheck();
          checkNumber.addToUncheckedList(gi);
          checkNumber.addToUncheckedList(carbs);
          if (checkNumber.pass()) {
            Double giq = Double.valueOf(gi);
            Double carbsq = Double.valueOf(carbs);
            double gl = new GlycemicLoad(giq, carbsq).getGlycemicLoad();
            sb.append("The glycemic load is ");
            sb.append(gl);
            sb.append(" grams.");
            Message.showMessagePadW510H150("Glycemic Load", sb.toString());
          }
        }
      }
    }
  }

  private void showKetosis() {
    // If you want the bibliography for these facts, ask.
    StringBuilder sb = new StringBuilder();
    double carbohydrateLow = new MinimumNutrientRequirements(0.0).getCarbohydrateLow();
    double carbohydrateMedium = new MinimumNutrientRequirements(0.0).getCarbohydrateMedium();
    double carbohydrateHigh = new MinimumNutrientRequirements(0.0).getCarbohydrateHigh();
    sb.append(carbohydrateMedium);
    sb.append(" to ");
    sb.append(carbohydrateHigh);
    sb.append(" grams of carbohydrates will inhibit ketosis.");
    sb.append("\n");
    sb.append(carbohydrateLow);
    sb.append(" to ");
    sb.append(carbohydrateMedium);
    sb.append(" grams of carbohydrates will appreciably reduce ketosis.");
    sb.append("\n");
    Message.showMessagePadW510H150("Carbohydrate Required to Inhibit Ketosis", sb.toString());
  }

  private void deleteMix() {
    JComponent[] inputs = {new JLabel("Would you like to delete mix?")};
    int optionValue = Message.showOptionDialogOkCancel(inputs, "Delete Mix");
    if (optionValue == 0) {
      MixDO mix = getSelectedMix();
      Boolean completed = false;
      try {
        Future<Boolean> task = BackgroundExec.submit(new DeleteMixTask(mix.getMixId()));
        completed = task.get();
      } catch (Exception e) {
        LoggerImpl.INSTANCE.logProblem(e);
      }
      if (!completed) {
        return;
      }
      clearMixesView();
      setConstraintCounts();
      try {
        Future<List<List>> task = BackgroundExec.submit(new MixesTask());
        List<List> lst = task.get();
        List<MixDO> mixesList = Utilities.createMixDOList(lst);
        cmbMixes.reload(mixesList);
        tblMixDiffA.reload(lst);
        tblMixDiffB.reload(lst);
        tblMealPlanUsageMixes.reload(lst);
      } catch (Exception e) {
        LoggerImpl.INSTANCE.logProblem(e);
      }
      cmbMixes.setSelectedIndex(0);
    }
  }

  private void createMix() {
    JTextField txtInput = new JTextField();
    JComponent[] inputs = {new JLabel("What would you like to call it?"), txtInput};
    int optionValue = Message.showOptionDialogOkCancel(inputs, "Create Mix");
    if (optionValue == 0) {
      String mixName = txtInput.getText();
      StringCheck sc = new StringCheck();
      sc.addUncheckedList(mixName);
      if (sc.pass()) {
        String mixId = "";
        try {
          Future<String> task = BackgroundExec.submit(new CreateMixTask(mixName));
          mixId = task.get();
        } catch (Exception e) {
          LoggerImpl.INSTANCE.logProblem(e);
        }
        if (mixId.isEmpty()) {
          return;
        }
        MixDO mix = createMixDO(mixId);
        String nutrientId = "10009";
        try {
          Future<Boolean> task =
              BackgroundExec.submit(new UpdateObjectiveOnMixTask(mixId, nutrientId));
          task.get();
        } catch (Exception e) {
          LoggerImpl.INSTANCE.logProblem(e);
        }
        try {
          Future<List<List>> task = BackgroundExec.submit(new MixesTask());
          List<List> lst = task.get();
          List<MixDO> mixesList = Utilities.createMixDOList(lst);
          cmbMixes.reload(mixesList);
          tblMixDiffA.reload(lst);
          tblMixDiffB.reload(lst);
          tblMealPlanUsageMixes.reload(lst);
        } catch (Exception e) {
          LoggerImpl.INSTANCE.logProblem(e);
        }
        cmbMixes.setSelectedItem(mix);
      } else {
        Message.showMessage("These characters are not allowed: < & > ' \"");
      }
    }
  }

  private void duplicateMix() {
    JComponent[] inputs = {new JLabel("Would you like to duplicate mix?")};
    int optionValue = Message.showOptionDialogOkCancel(inputs, "Duplicate Mix");
    if (optionValue == 0) {
      String newMixId = "";
      try {
        String mixId = getSelectedMix().getMixId();
        Future<String> task = BackgroundExec.submit(new DuplicateMixTask(mixId));
        newMixId = task.get();
      } catch (Exception e) {
        LoggerImpl.INSTANCE.logProblem(e);
      }
      if (newMixId.isEmpty()) {
        return;
      }
      MixDO mix = createMixDO(newMixId);
      try {
        Future<List<List>> task = BackgroundExec.submit(new MixesTask());
        List<List> lst = task.get();
        List<MixDO> mixesList = Utilities.createMixDOList(lst);
        cmbMixes.reload(mixesList);
        tblMixDiffA.reload(lst);
        tblMixDiffB.reload(lst);
        tblMealPlanUsageMixes.reload(lst);
      } catch (Exception e) {
        LoggerImpl.INSTANCE.logProblem(e);
      }
      cmbMixes.setSelectedItem(mix);
      setQuantityScale();
    }
  }

  private MixDO getSelectedMix() {
    Object o = cmbMixes.getSelectedItem();
    if (o instanceof MixDO mix) {
      return cmbMixes.getSelectedItem();
    } else {
      return createMixDO("");
    }
  }

  private MixDO createMixDO(String mixid) {
    return new MixDO(mixid);
  }

  private String selectObjective() {
    String nutrientid = "10009";
    JComponent[] inputs = {getMinimizationOptionsPanel()};
    int optionValue = Message.showOptionDialogOkCancel(inputs, "Minimization Options");
    if (optionValue == 0) {
      if (raiCost.isSelected()) {
        nutrientid = "10005";
      }
      String mixId = getSelectedMix().getMixId();
      try {
        Future<Boolean> task =
            BackgroundExec.submit(new UpdateObjectiveOnMixTask(mixId, nutrientid));
        task.get();
      } catch (Exception e) {
        LoggerImpl.INSTANCE.logProblem(e);
      }
    }
    return nutrientid;
  }

  private void pinMix() {
    try {
      String mixId = getSelectedMix().getMixId();
      Future<Boolean> task = BackgroundExec.submit(new PinMixTask(mixId));
      Boolean completed = task.get();
      if (completed) {
        reloadMixConstraints(mixId);
      }
    } catch (Exception e) {
      LoggerImpl.INSTANCE.logProblem(e);
    }
  }

  private void renameMix() {
    JTextField txtInput = new JTextField();
    JComponent[] inputs = {new JLabel("What is your new mix name?"), txtInput};
    MixDO mix = getSelectedMix();
    txtInput.setText(mix.getName());
    int optionValue = Message.showOptionDialogOkCancel(inputs, "Update Mix");
    if (optionValue == 0) {
      String mixnom = txtInput.getText();
      StringCheck sc = new StringCheck();
      sc.addUncheckedList(mixnom);
      if (sc.pass()) {
        Boolean completed = false;
        try {
          Future<Boolean> task =
              BackgroundExec.submit(new UpdateNameOnMixTask(mix.getMixId(), mixnom));
          completed = task.get();
        } catch (Exception e) {
          LoggerImpl.INSTANCE.logProblem(e);
        }
        if (!completed) {
          return;
        }
        try {
          Future<List<List>> task = BackgroundExec.submit(new MixesTask());
          List<List> lst = task.get();
          List<MixDO> mixesList = Utilities.createMixDOList(lst);
          cmbMixes.reload(mixesList);
          tblMixDiffA.reload(lst);
          tblMixDiffB.reload(lst);
          tblMealPlanUsageMixes.reload(lst);
        } catch (Exception e) {
          LoggerImpl.INSTANCE.logProblem(e);
        }
        cmbMixes.setSelectedItem(mix);
      } else {
        Message.showMessage("These characters are not allowed: < & > ' \"");
      }
    }
  }

  private void calculateN3FattyAcidRequired() {
    JTextField txtInput = new JTextField();
    JPanel pnl = new JPanel();
    txtInput.setPreferredSize(new Dimension(50, 25));
    pnl.add(new JLabel("What is your optimal calorie intake?"));
    pnl.add(txtInput);
    JComponent[] inputs = {pnl};
    int optionValue =
        Message.showOptionDialogOkCancel(inputs, "Alpha-linolenic Acid, ALA, 18:3 n-3");
    if (optionValue == 0) {
      String s = txtInput.getText();
      if (s != null && s.length() > 0) {
        StringBuilder sb = new StringBuilder();
        NumberCheck checkNumber = new NumberCheck();
        checkNumber.addToUncheckedList(s);
        if (checkNumber.pass()) {
          Double energyKcal = Double.valueOf(s);
          final AlphaLinolenicRequired n3_fatty_acid_recommendation =
              new AlphaLinolenicRequired(energyKcal);
          BigDecimal alaLow = n3_fatty_acid_recommendation.get_low_in_grams();
          BigDecimal alaHigh = n3_fatty_acid_recommendation.get_high_in_grams();
          sb.append("Alpha-linolenic Acid required is between ");
          sb.append(alaLow.setScale(1, RoundingMode.HALF_UP));
          sb.append(" and ");
          sb.append(alaHigh.setScale(1, RoundingMode.HALF_UP));
          sb.append(" grams.");
          Message.showMessagePadW510H150("Alpha-linolenic Acid, ALA, 18:3 n-3", sb.toString());
        } else {
          Message.showMessage("Numbers only");
        }
      }
    }
  }

  private void calculateProteinNeededForNitrogenBalance() {
    JTextField textFieldLbs = new JTextField();
    textFieldLbs.setPreferredSize(new Dimension(50, 25));
    JPanel pnl = new JPanel();
    pnl.add(new JLabel("What is your lean body mass in pounds?"));
    pnl.add(textFieldLbs);
    JComponent[] inputs = {pnl};
    int optionValue = Message.showOptionDialogOkCancel(inputs, "Complete Protein Required");
    if (optionValue == 0) {
      String s = textFieldLbs.getText();
      if (s != null && s.length() > 0) {
        StringBuilder sb = new StringBuilder();
        NumberCheck checkNumber = new NumberCheck();
        checkNumber.addToUncheckedList(s);
        if (checkNumber.pass()) {
          Double weightinlbs = Double.valueOf(s);
          double protein = new MinimumNutrientRequirements(weightinlbs).getProtein();
          sb.append(
              "The amount of complete protein required in a no fat, no carbs regimen to maintain"
                  + " nitrogen balance is ");
          sb.append(Math.round(protein));
          sb.append(" grams.");
          sb.append("\n");
          Message.showMessagePadW510H150(
              "Complete Protein Required (no carbs, no fats)", sb.toString());
        } else {
          Message.showMessage("Numbers only");
        }
      }
    }
  }

  private void showProjectInformation() {
    JTextPane txp = new JTextPane();
    txp.setEditorKit(JEditorPane.createEditorKitForContentType("text/html"));
    txp.setText(Utilities.getResourceAsString("/resources/html/project.html"));
    txp.setEditable(false);
    txp.putClientProperty(JEditorPane.HONOR_DISPLAY_PROPERTIES, true);
    txp.addHyperlinkListener(
        (HyperlinkEvent e) -> {
          if (e.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
            if (Desktop.isDesktopSupported()) {
              Utilities.openUrl(e.getURL().toString());
            }
          }
        });
    JScrollPane scr = new JScrollPane(txp);
    scr.setPreferredSize(new Dimension(800, 400));
    JComponent[] inputs = {scr};
    Message.showOptionDialog(inputs, "Project");
  }

  private void calculateNutrientContent() {
    TableDri.Row row = tblDri.getSelectedValue();
    String nutrientid = row.getNutrientid();
    String nutrient = row.getNutrient();
    BigDecimal dri = row.getDri();
    txtNutrientSearchQuantity.setText(String.valueOf(dri));
    NutrientDO nutrientDO = new NutrientDO(nutrientid, nutrient, null);
    cmbNutrientContentNutrient.setSelectedItem(nutrientDO);
    try {
      Future<List<List>> task =
          BackgroundExec.submit(new NutrientContainingFoodsTask(nutrientid, dri));
      List<List> results = task.get();
      tblNutrientLookup.reload(results);
    } catch (Exception e) {
      LoggerImpl.INSTANCE.logProblem(e);
    }
    tabMain.setSelectedIndex(4);
  }

  private void setFoodQuantityConstraintGuiValues() {
    TableFoodQuantityConstraint.Row row = tblFoodQuantityConstraint.getSelectedValue();
    String foodid = row.getFoodid();
    String nutrientid = row.getNutrientid();
    Integer relationshipid = row.getRelationshipid();
    BigDecimal q = row.getB();
    int foodIndex = cmbFoodQuantityFood.index(new MixFoodDO(foodid, ""));
    int nutrientIndex =
        cmbFoodQuantityNutrient.index(new NutrientDO(nutrientid, "", new BigDecimal("-1")));
    int relationshipIndex =
        cmbFoodQuantityRelationship.index(new RelationshipDO(relationshipid, ""));
    cmbFoodQuantityFood.setSelectedIndex(foodIndex);
    cmbFoodQuantityNutrient.setSelectedIndex(nutrientIndex);
    cmbFoodQuantityRelationship.setSelectedIndex(relationshipIndex);
    txtFoodQuantityValue.setText(q.toPlainString());
  }

  private void setFoodRatioConstraintGuiValues() {
    TableFoodRatioConstraint.Row row = tblFoodRatioConstraint.getSelectedValue();
    String foodAid = row.getFoodida();
    String foodBid = row.getFoodidb();
    String nutrientAid = row.getNutrientida();
    String nutrientBid = row.getNutrientidb();
    Integer relationshipid = row.getRelationshipid();
    BigDecimal qA = row.getA();
    BigDecimal qB = row.getB();
    int foodAIndex = cmbFoodRatioFoodA.index(new MixFoodDO(foodAid, ""));
    int foodBIndex = cmbFoodRatioFoodB.index(new MixFoodDO(foodBid, ""));
    int nutrientAindex =
        cmbFoodRatioNutrientA.index(new NutrientDO(nutrientAid, "", new BigDecimal("-1")));
    int nutrientBindex =
        cmbFoodRatioNutrientB.index(new NutrientDO(nutrientBid, "", new BigDecimal("-1")));
    int relationshipindex = cmbFoodRatioRelationship.index(new RelationshipDO(relationshipid, ""));
    cmbFoodRatioFoodA.setSelectedIndex(foodAIndex);
    cmbFoodRatioFoodB.setSelectedIndex(foodBIndex);
    cmbFoodRatioNutrientA.setSelectedIndex(nutrientAindex);
    txtFoodNutrientRatioQuantityA.setText(qA.toPlainString());
    cmbFoodRatioNutrientB.setSelectedIndex(nutrientBindex);
    txtFoodNutrientRatioQuantityB.setText(qB.toPlainString());
    cmbFoodRatioRelationship.setSelectedIndex(relationshipindex);
  }

  private void setNutrientQuantityConstraintGuiValues() {
    TableNutrientQuantity.Row row = tblNutrientQuantityConstraint.getSelectedValue();
    String nutrientid = row.getNutrientid();
    Integer relationshipid = row.getRelationshipid();
    BigDecimal q = row.getB();
    int nutrientindex =
        cmbNutrientQuantityNutrient.index(new NutrientDO(nutrientid, "", new BigDecimal("-1")));
    int relationshipindex =
        cmbNutrientQuantityRelationship.index(new RelationshipDO(relationshipid, ""));
    cmbNutrientQuantityNutrient.setSelectedIndex(nutrientindex);
    cmbNutrientQuantityRelationship.setSelectedIndex(relationshipindex);
    txtNutrientQuantityValue.setText(String.valueOf(q));
  }

  private void setNutrientRatioConstraintGuiValues() {
    TableNutrientRatioConstraint.Row row = tblNutrientRatio.getSelectedValue();
    String nutrientida = row.getNutrientaid();
    String nutrientidb = row.getNutrientbid();
    BigDecimal qA = row.getA();
    BigDecimal qB = row.getB();
    Integer relationshipid = row.getRelationshipid();
    int nutrientAindex =
        cmbNutrientRatioNutrientA.index(new NutrientDO(nutrientida, "", new BigDecimal("-1")));
    int nutrientBindex =
        cmbNutrientRatioNutrientB.index(new NutrientDO(nutrientidb, "", new BigDecimal("-1")));
    int relationshipindex =
        cmbNutrientRatioRelationship.index(new RelationshipDO(relationshipid, ""));
    cmbNutrientRatioNutrientA.setSelectedIndex(nutrientAindex);
    txtNutrientRatioNutrientA.setText(String.valueOf(qA));
    cmbNutrientRatioNutrientB.setSelectedIndex(nutrientBindex);
    txtNutrientRatioNutrientB.setText(String.valueOf(qB));
    cmbNutrientRatioRelationship.setSelectedIndex(relationshipindex);
  }

  private void process_evt_txt_nutrient_content() {
    reload_tblmdl_nutrient_lookup();
    setQuantityScale();
  }

  private void reloadFoodComboBoxes(String mixid) {
    cmbFoodRatioFoodA.clear();
    cmbFoodRatioFoodB.clear();
    cmbFoodQuantityFood.clear();
    cmbPortionFood.clear();
    mixFoodLoader.reload(mixid);
    if (!mixFoodLoader.get().isEmpty()) {
      cmbFoodRatioFoodA.reload(mixFoodLoader.get());
      cmbFoodRatioFoodB.reload(mixFoodLoader.get());
      cmbFoodQuantityFood.reload(mixFoodLoader.get());
      cmbPortionFood.reload(mixFoodLoader.get());
    }
  }

  private void reloadCbNutrientData() {
    cmbNutrientQuantityNutrient.clear();
    cmbNutrientRatioNutrientA.clear();
    cmbNutrientRatioNutrientB.clear();
    cmbFoodQuantityNutrient.clear();
    cmbFoodRatioNutrientA.clear();
    cmbFoodRatioNutrientB.clear();
    cmbNutrientContentNutrient.clear();
    nutrientLoader.reload();
    cmbNutrientQuantityNutrient.reload(nutrientLoader.getList());
    cmbNutrientRatioNutrientA.reload(nutrientLoader.getList());
    cmbNutrientRatioNutrientB.reload(nutrientLoader.getList());
    cmbFoodQuantityNutrient.reload(nutrientLoader.getList());
    cmbFoodRatioNutrientA.reload(nutrientLoader.getList());
    cmbFoodRatioNutrientB.reload(nutrientLoader.getList());
    cmbNutrientContentNutrient.reload(nutrientLoader.getList());
    cmbNutrientQuantityNutrient.setSelectedIndex(0);
    cmbNutrientRatioNutrientA.setSelectedIndex(0);
    cmbNutrientRatioNutrientB.setSelectedIndex(0);
    cmbFoodQuantityNutrient.setSelectedIndex(0);
    cmbFoodRatioNutrientA.setSelectedIndex(0);
    cmbFoodRatioNutrientB.setSelectedIndex(0);
  }

  private void reloadCbRelationshipData() {
    relationshipLoader.reload();
    cmbNutrientQuantityRelationship.clear();
    cmbNutrientRatioRelationship.clear();
    cmbFoodQuantityRelationship.clear();
    cmbFoodRatioRelationship.clear();
    cmbNutrientQuantityRelationship.reload(relationshipLoader.get());
    cmbNutrientRatioRelationship.reload(relationshipLoader.get());
    cmbFoodQuantityRelationship.reload(relationshipLoader.get());
    cmbFoodRatioRelationship.reload(relationshipLoader.get());
    cmbNutrientQuantityRelationship.setSelectedIndex(0);
    cmbNutrientRatioRelationship.setSelectedIndex(0);
    cmbFoodQuantityRelationship.setSelectedIndex(0);
    cmbFoodRatioRelationship.setSelectedIndex(0);
  }

  private void reloadFoods() {
    Future<List<List>> task0 = null;
    try {
      task0 = BackgroundExec.submit(new FoodFactsTask());
      foods = task0.get();
    } catch (Exception e) {
      LoggerImpl.INSTANCE.logProblem(e);
    } finally {
      if (foods.isEmpty()) {
        return;
      }
      tblFoods.reload(foods);
      tblFoodDiffA.reload(foods);
      tblFoodDiffB.reload(foods);
      tblCategoryAllFoods.reload(foods);
      try {
        Future<List<Map<String, Object>>> task1 = BackgroundExec.submit(new FoodsTask());
        List<Map<String, Object>> treeFoods = task1.get();
        tremodelFoods.reload(treeFoods);
      } catch (Exception e) {
        LoggerImpl.INSTANCE.logProblem(e);
      }
    }
  }

  private void reloadMixConstraints(String mixid) {
    try {
      Future<List<List>> task0 = BackgroundExec.submit(new NutrientQuantityConstraintsTask(mixid));
      Future<List<List>> task1 = BackgroundExec.submit(new NutrientRatioConstraintsTask(mixid));
      Future<List<List>> task2 = BackgroundExec.submit(new FoodQuantityConstraintsTask(mixid));
      Future<List<List>> task3 = BackgroundExec.submit(new FoodRatioConstraintsTask(mixid));
      List<List> constraints0 = task0.get();
      List<List> constraints1 = task1.get();
      List<List> constraints2 = task2.get();
      List<List> constraints3 = task3.get();
      try {
        Future<List<List>> task4 = BackgroundExec.submit(new NamedMixFoodSortedByNameTask(mixid));
        List<List> foods = task4.get();
        tblMixFood.reload(foods);
      } catch (Exception e) {
        LoggerImpl.INSTANCE.logProblem(e);
      }
      tblNutrientQuantityConstraint.reload(constraints0);
      tblNutrientRatio.reload(constraints1);
      tblFoodQuantityConstraint.reload(constraints2);
      tblFoodRatioConstraint.reload(constraints3);
      setConstraintCounts();
    } catch (Exception e) {
      LoggerImpl.INSTANCE.logProblem(e);
    }
  }

  private void reload_tblmdl_nutrient_lookup() {
    NutrientDO nutrientDO = (NutrientDO) cmbNutrientContentNutrient.getSelectedItem();
    String text = txtNutrientSearchQuantity.getText();
    NumberCheck checkNumber = new NumberCheck();
    checkNumber.addToUncheckedList(text);
    if (checkNumber.pass()) {
      BigDecimal q = new BigDecimal(text);
      try {
        Future<List<List>> task =
            BackgroundExec.submit(new NutrientContainingFoodsTask(nutrientDO.getNutr_no(), q));
        List<List> results = task.get();
        tblNutrientLookup.reload(results);
      } catch (Exception e) {
        LoggerImpl.INSTANCE.logProblem(e);
      }
    } else if (!text.isEmpty()) {
      Message.showMessage("Character must be number.");
    }
  }

  private void roundDown() {
    // Energy
    tblCalories.roundDown();
    // Mass
    tblMacronutrients.roundDown();
    // Protein
    tblProtein.roundDown();
    // Fats
    tblProtein.roundDown();
    // Saturated
    tblSfa.roundDown();
    // Polyunsaturated
    tblPufa.roundDown();
    // Carbs
    tblCarbs.roundDown();
    // Vitamins
    tblVitamins.roundDown();
    // Minerals
    tblMinerals.roundDown();
    // Electrolytes
    tblElectrolytes.roundDown();
    // Phytonutrients
    tblPhytonutrients.roundDown();
    // Cost
    tblCost.roundDown();
    // Dri
    tblDri.roundDown();
    // By Meal (Kcal)
    tblMealCalories.roundDown();
    // By Meal (grams)
    tblMealMacronutrients.roundDown();
    // Food list
    tblFoods.roundDown();
    // Food comparison
    tblFoodDiff.roundDown();
    // Mix comparison
    tblMixDiff.roundDown();
    // Nutrient lookup
    tblNutrientLookup.roundDown();
    // Inventory Days
    tblMealPlanUsage.roundDown();
    // Inventory Sum
    tblMealPlanUsageResults.roundDown();
  }

  private void roundUp() {
    // Energy
    tblCalories.roundUp();
    // Mass
    tblMacronutrients.roundUp();
    // Protein
    tblProtein.roundUp();
    // Fats
    tblFats.roundUp();
    // Saturated
    tblSfa.roundUp();
    // Polyunsaturated
    tblPufa.roundUp();
    // Carbs
    tblCarbs.roundUp();
    // Vitamins
    tblVitamins.roundUp();
    // Minerals
    tblMinerals.roundUp();
    // Electrolytes
    tblElectrolytes.roundUp();
    // Phytonutrients
    tblPhytonutrients.roundUp();
    // Cost
    tblCost.roundUp();
    // Dri
    tblDri.roundUp();
    // By Meal (Kcal)
    tblMealCalories.roundUp();
    // By Meal (grams)
    tblMealMacronutrients.roundUp();
    // Food list
    tblFoods.roundUp();
    // Food comparison
    tblFoodDiff.roundUp();
    // Mix comparison
    tblMixDiff.roundUp();
    // Nutrient lookup
    tblNutrientLookup.roundUp();
    // Inventory Days
    tblMealPlanUsage.roundUp();
    // Inventory Sum
    tblMealPlanUsageResults.roundUp();
  }

  private void loadSelectedMix() {
    MixDO mix = getSelectedMix();
    String mixid = mix.getMixId();
    String name = mix.getName();
    String model = mix.getModel();
    BigDecimal cost = mix.getCost();
    String nutrientid = mix.getNutrientid();
    try {
      Future<List<List>> task = BackgroundExec.submit(new NamedMixFoodSortedByNameTask(mixid));
      List<List> foods = task.get();
      tblMixFood.reload(foods);
    } catch (Exception e) {
      LoggerImpl.INSTANCE.logProblem(e);
    }
    try {
      Future<List<List>> task = BackgroundExec.submit(new MixResultsTask(mix.getMixId()));
      List<List> results = task.get();
      if (results.isEmpty()) {
        return;
      }
      tblCalories.reload(Reloader.getEnergy(results));
      tblMacronutrients.reload(Reloader.getMass(results));
      tblProtein.reload(Reloader.getProtein(results));
      tblFats.reload(Reloader.getFat(results));
      tblSfa.reload(Reloader.getSaturatedFat(results));
      tblPufa.reload(Reloader.getPolyunsaturatedFat(results));
      tblCarbs.reload(Reloader.getCarbohydrates(results));
      tblVitamins.reload(Reloader.getVitamins(results));
      tblMinerals.reload(Reloader.getMinerals(results));
      tblElectrolytes.reload(Reloader.getElectrolytes(results));
      tblPhytonutrients.reload(Reloader.getPhytonutrients(results));
      tblCost.reload(Reloader.getCost(results));
    } catch (Exception e) {
      LoggerImpl.INSTANCE.logProblem(e);
    }
    reloadFoodComboBoxes(mixid);
    selectFoodComboBoxItem();
    reloadMixConstraints(mixid);
    mixFoodLoader.reload(mixid);
    cmbPortionFood.reload(mixFoodLoader.get());
    try {
      Future<List<List>> task = BackgroundExec.submit(new MealPlanMealsTask(mixid));
      List<List> meals = task.get();
      tblMeals.reload(meals);
    } catch (Exception e) {
      LoggerImpl.INSTANCE.logProblem(e);
    }
    txaLpProgram.setText(model);
    txaLpProgram.setCaretPosition(0);
    setConstraintCounts();
    LifeStageDO lifestage = (LifeStageDO) cmbLifestage.getSelectedItem();
    try {
      Future<List<List>> task =
          BackgroundExec.submit(new DriDifferenceTask(mix.getMixId(), lifestage.getLifeStageId()));
      List<List> diff = task.get();
      tblDri.reload(diff);
    } catch (Exception e) {
      LoggerImpl.INSTANCE.logProblem(e);
    }
    try {
      Future<List<List>> task = BackgroundExec.submit(new MealPlanPortionsTask(mix.getMixId()));
      List<List> portions = task.get();
      tblMealPortions.reload(portions);
    } catch (Exception e) {
      LoggerImpl.INSTANCE.logProblem(e);
    }
    try {
      Future<List<List>> task = BackgroundExec.submit(new MealPlanResultsTask(mix.getMixId()));
      List<List> results = task.get();
      tblMealCalories.reload(results);
      tblMealMacronutrients.reload(results);
    } catch (Exception e) {
      LoggerImpl.INSTANCE.logProblem(e);
    }
    setQuantityScale();
    updateObjectiveDisplay(nutrientid);
  }

  private void clearMixResults() {
    tblCalories.clear();
    tblMacronutrients.clear();
    tblProtein.clear();
    tblFats.clear();
    tblSfa.clear();
    tblPufa.clear();
    tblCarbs.clear();
    tblVitamins.clear();
    tblMinerals.clear();
    tblElectrolytes.clear();
    tblPhytonutrients.clear();
    tblCost.clear();
    tblDri.clear();
    tblMeals.clear();
    tblMealPortions.clear();
    tblMealCalories.clear();
    tblMealMacronutrients.clear();
    txaLpProgram.setText("");
  }

  private void updateObjectiveDisplay(String nutrientid) {
    if (nutrientid.equals("10009")) {
      lblMinimization.setText("Calories");
      raiCalories.setSelected(true);
    } else {
      lblMinimization.setText("Cost");
      raiCost.setSelected(true);
    }
  }

  private void setConstraintCounts() {
    lblNutrientRatioCount.setText(getNutrientRatioConstraintCount());
    lblFoodRatioCount.setText(getFoodRatioConstraintCount());
    lblFoodQuantityCount.setText(getFoodConstraintCount());
    lblNutrientQuantityCount.setText(getNutrientQuantityConstraintCount());
  }

  private void setSplitPanelDivider() {
    splMain.setDividerLocation(390);
  }

  private void setQuantityScale() {
    if (chkResultRoundUp.isSelected()) {
      roundUp();
    } else {
      roundDown();
    }
  }

  private void selectFoodComboBoxItem() {
    if (cmbFoodRatioFoodA.isEmpty()) {
      return;
    }
    cmbFoodRatioFoodA.setSelectedIndex(0);
    cmbFoodRatioFoodB.setSelectedIndex(0);
    cmbFoodQuantityFood.setSelectedIndex(0);
    cmbPortionFood.setSelectedIndex(0);
  }

  private void showFoodStats(String foodid) {
    foodStats.reload(foodid);
    Message.showMessagePadW510(230, "Food Statistics", foodStats.get_stats());
  }

  private void showMessageSent(String path) {
    JTextArea txa = new JTextArea();
    txa.setEditable(false);
    StringBuilder sb = new StringBuilder();
    sb.append("Document saved to:\n");
    sb.append(path);
    txa.setText(sb.toString());
    JComponent[] inputs = {txa};
    Message.showOptionDialog(inputs, "Document Export");
  }

  private void showMixStats() {
    try {
      MixDO mix = getSelectedMix();
      Future<List<Map<String, Object>>> task =
          BackgroundExec.submit(new MixStatsTask(mix.getMixId()));
      List<Map<String, Object>> list = task.get();
      if (list.isEmpty()) {
        return;
      }
      StringBuilder sb = new StringBuilder();
      list.forEach(
          row -> {
            BigDecimal calories = (BigDecimal) row.get("CALORIES");
            BigDecimal fatpct = (BigDecimal) row.get("FATPCT");
            BigDecimal carbpct = (BigDecimal) row.get("CARBPCT");
            BigDecimal proteinpct = (BigDecimal) row.get("PROTEINPCT");
            BigDecimal alcoholpct = (BigDecimal) row.get("ALCOHOLPCT");
            BigDecimal fq = (BigDecimal) row.get("FQ");
            BigDecimal satfatpct = (BigDecimal) row.get("SATFATPCT");
            BigDecimal monoufatpct = (BigDecimal) row.get("MONOUFATPCT");
            BigDecimal polyufatpct = (BigDecimal) row.get("POLYUFATPCT");
            BigDecimal essentialfatratio = (BigDecimal) row.get("ESSENTIALFATRATIO");
            BigDecimal electrolyteratio = (BigDecimal) row.get("ELECTROLYTERATIO");
            BigDecimal lapct = (BigDecimal) row.get("LAPCT");
            BigDecimal alapct = (BigDecimal) row.get("ALAPCT");
            BigDecimal psratio = (BigDecimal) row.get("PSRATIO");
            BigDecimal msratio = (BigDecimal) row.get("MSRATIO");
            sb.append("Fat: ");
            sb.append((new DecimalFormat("###0.00")).format(fatpct));
            sb.append("%\n");
            sb.append("Carbohydrate: ");
            sb.append((new DecimalFormat("###0.00")).format(carbpct));
            sb.append("%\n");
            sb.append("Protein: ");
            sb.append((new DecimalFormat("###0.00")).format(proteinpct));
            sb.append("%\n");
            sb.append("Alcohol: ");
            sb.append((new DecimalFormat("###0.00")).format(alcoholpct));
            sb.append("%\n");
            sb.append("Saturated Fat: ");
            sb.append((new DecimalFormat("###0.00")).format(satfatpct));
            sb.append("%\n");
            sb.append("Polyunsaturated Fat: ");
            sb.append((new DecimalFormat("###0.00")).format(polyufatpct));
            sb.append("%\n");
            sb.append("Monounsaturated Fat: ");
            sb.append((new DecimalFormat("###0.00")).format(monoufatpct));
            sb.append("%\n");
            sb.append("Linoleic Acid: ");
            sb.append((new DecimalFormat("###0.00")).format(lapct));
            sb.append("%\n");
            sb.append("Alpha-linolenic Acid: ");
            sb.append((new DecimalFormat("###0.00")).format(alapct));
            sb.append("%\n");
            sb.append("Ratio PUFA/SFA: ");
            sb.append((new DecimalFormat("###0.00")).format(psratio));
            sb.append("\n");
            sb.append("Ratio MUFA/SFA: ");
            sb.append((new DecimalFormat("###0.00")).format(msratio));
            sb.append("\n");
            sb.append("Ratio LA/ALA: ");
            sb.append((new DecimalFormat("###0.00")).format(essentialfatratio));
            sb.append("\n");
            sb.append("Ratio K/Na: ");
            sb.append((new DecimalFormat("###0.00")).format(electrolyteratio));
            sb.append("\n");
            sb.append("Food Quotient (FQ): ");
            sb.append((new DecimalFormat("###0.00")).format(fq));
            sb.append("\n");
          });
      Message.showMessagePadW510(230, "Mix Statistics", sb.toString());
    } catch (Exception e) {
      LoggerImpl.INSTANCE.logProblem(e);
    }
  }

  private void deleteAllMixes() {
    JLabel lbl = new JLabel("DO YOU WANT TO DELETE ALL MIXES?");
    JPanel pnl = new JPanel();
    pnl.add(lbl);
    JComponent[] inputs = {pnl};
    int optionValue =
        Message.showOptionDialogYesNo(inputs, "** WARNING: DELETING VALUABLE DATA **");
    if (optionValue == 0) {
      try {
        Future<Boolean> task = BackgroundExec.submit(new DeleteAllMixesTask());
        Boolean completed = task.get();
        if (completed) {
          clearMixesView();
          Message.showMessage("", "ALL MIXES HAVE BEEN DELETED.");
        }
      } catch (Exception e) {
        LoggerImpl.INSTANCE.logProblem(e);
      }
    }
  }

  private void deleteAll() {
    JLabel lbl = new JLabel("DO YOU WANT TO DELETE ALL MIXES AND ALL FOOD ITEMS?");
    JPanel pnl = new JPanel();
    pnl.add(lbl);
    JComponent[] inputs = {pnl};
    int optionValue =
        Message.showOptionDialogYesNo(inputs, "** WARNING: DELETING VALUABLE DATA **");
    if (optionValue == 0) {
      try {
        Future<Boolean> task0 = BackgroundExec.submit(new DeleteAllMixesTask());
        Boolean task0Completed = task0.get();
        frm.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        Future<Boolean> task1 = BackgroundExec.submit(new DeleteAllFoodsTask());
        Boolean task1Completed = task1.get();
        Future<Boolean> task2 = BackgroundExec.submit(new DeleteAllFoodCategoriesTask());
        Boolean task2Completed = task2.get();
        if (task0Completed && task1Completed && task2Completed) {
          clearMixesView();
          clearFoodsView();
          frm.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
          Message.showMessage("", "ALL MIXES AND ALL FOOD ITEMS HAVE BEEN DELETED.");
        }

      } catch (Exception e) {
        LoggerImpl.INSTANCE.logProblem(e);
      }
    }
  }

  public static void main(String[] args) {
    try {
      URL url = Utilities.getResourceAsUrl("/resources/fonts/inconsolata.ttf");
      InputStream is = url.openStream();
      Font font = Font.createFont(Font.TRUETYPE_FONT, is).deriveFont(13f);
      MetalLookAndFeel.setCurrentTheme(new io.github.xjrga.looks.themes.Dawn_150(font));
      UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
    } catch (ClassNotFoundException
        | IllegalAccessException
        | InstantiationException
        | UnsupportedLookAndFeelException
        | FontFormatException
        | IOException e) {
    }
    try {
      BackgroundExec.start();
      Splash f = new Splash();
      f.initiate();
      new Main(f);
    } catch (Exception e) {
      LoggerImpl.INSTANCE.logProblem(e);
    }
  }
}
