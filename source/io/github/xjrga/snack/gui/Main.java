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
import io.github.xjrga.snack.csv.MixTotalsReport;
import io.github.xjrga.snack.csv.NutrientContentReport;
import io.github.xjrga.snack.database.Connect;
import io.github.xjrga.snack.database.callable.BackgroundExec;
import io.github.xjrga.snack.database.callable.FoodCreator;
import io.github.xjrga.snack.database.callable.delete.DeleteAllFoodCategoriesTask;
import io.github.xjrga.snack.database.callable.delete.DeleteAllFoodsTask;
import io.github.xjrga.snack.database.callable.delete.DeleteAllMixesTask;
import io.github.xjrga.snack.database.callable.delete.DeleteCategoryLinkTask;
import io.github.xjrga.snack.database.callable.delete.DeleteCategoryTask;
import io.github.xjrga.snack.database.callable.delete.DeleteFoodConstraintTask;
import io.github.xjrga.snack.database.callable.delete.DeleteFoodGroupConstraintTask;
import io.github.xjrga.snack.database.callable.delete.DeleteFoodGroupTask;
import io.github.xjrga.snack.database.callable.delete.DeleteFoodInFoodGroupTask;
import io.github.xjrga.snack.database.callable.delete.DeleteFoodPortionTask;
import io.github.xjrga.snack.database.callable.delete.DeleteFoodRatioConstraintTask;
import io.github.xjrga.snack.database.callable.delete.DeleteFoodTask;
import io.github.xjrga.snack.database.callable.delete.DeleteMealPlanUsageTask;
import io.github.xjrga.snack.database.callable.delete.DeleteMealTask;
import io.github.xjrga.snack.database.callable.delete.DeleteMixFoodTask;
import io.github.xjrga.snack.database.callable.delete.DeleteMixTask;
import io.github.xjrga.snack.database.callable.delete.DeleteNutrientConstraintTask;
import io.github.xjrga.snack.database.callable.delete.DeleteNutrientRatioConstraintTask;
import io.github.xjrga.snack.database.callable.insert.CreateMealTask;
import io.github.xjrga.snack.database.callable.insert.CreateMixTask;
import io.github.xjrga.snack.database.callable.insert.DuplicateCategoryTask;
import io.github.xjrga.snack.database.callable.insert.DuplicateFoodGroupTask;
import io.github.xjrga.snack.database.callable.insert.InsertAndCalculateFoodPortionTask;
import io.github.xjrga.snack.database.callable.insert.InsertCategoryTask;
import io.github.xjrga.snack.database.callable.insert.InsertFoodCategoryLinkTask;
import io.github.xjrga.snack.database.callable.insert.InsertFoodGroupTask;
import io.github.xjrga.snack.database.callable.insert.InsertGroupFoodTask;
import io.github.xjrga.snack.database.callable.insert.InsertMixFoodTask;
import io.github.xjrga.snack.database.callable.insert.MergeFoodConstraintTask;
import io.github.xjrga.snack.database.callable.insert.MergeFoodRatioConstraintTask;
import io.github.xjrga.snack.database.callable.insert.MergeGroupConstraintTask;
import io.github.xjrga.snack.database.callable.insert.MergeMealPlanUsageTask;
import io.github.xjrga.snack.database.callable.insert.MergeNutrientConstraintTask;
import io.github.xjrga.snack.database.callable.insert.MergeNutrientRatioConstraintTask;
import io.github.xjrga.snack.database.callable.other.DenormalizeFoodFactsTask;
import io.github.xjrga.snack.database.callable.other.DuplicateMixTask;
import io.github.xjrga.snack.database.callable.other.ExportMixTask;
import io.github.xjrga.snack.database.callable.other.PinAndDeleteTask;
import io.github.xjrga.snack.database.callable.other.PinAndKeepTask;
import io.github.xjrga.snack.database.callable.other.SendCategoryToXmlTask;
import io.github.xjrga.snack.database.callable.select.DerivedFoodFactsTask;
import io.github.xjrga.snack.database.callable.select.DriDevNutrientLhsTask;
import io.github.xjrga.snack.database.callable.select.DriDevObjectiveDeficiencyLhsTask;
import io.github.xjrga.snack.database.callable.select.DriDevObjectiveLhsTask;
import io.github.xjrga.snack.database.callable.select.DriDevSumDeficiencyLhsTask;
import io.github.xjrga.snack.database.callable.select.DriDevSumExcessLhsTask;
import io.github.xjrga.snack.database.callable.select.DriDevTniLhsTask;
import io.github.xjrga.snack.database.callable.select.DriDevTniRhsTask;
import io.github.xjrga.snack.database.callable.select.DriDiffTask;
import io.github.xjrga.snack.database.callable.select.DriNutrientsTask;
import io.github.xjrga.snack.database.callable.select.FoodCategoriesTask;
import io.github.xjrga.snack.database.callable.select.FoodCategoryCountTask;
import io.github.xjrga.snack.database.callable.select.FoodConstraintsTask;
import io.github.xjrga.snack.database.callable.select.FoodDiffTask;
import io.github.xjrga.snack.database.callable.select.FoodFactsTask;
import io.github.xjrga.snack.database.callable.select.FoodGroupsTask;
import io.github.xjrga.snack.database.callable.select.FoodGroupsTaskGroupDO;
import io.github.xjrga.snack.database.callable.select.FoodLhsTask;
import io.github.xjrga.snack.database.callable.select.FoodRatioConstraintsTask;
import io.github.xjrga.snack.database.callable.select.FoodRatioLhsTask;
import io.github.xjrga.snack.database.callable.select.FoodRatioRhsTask;
import io.github.xjrga.snack.database.callable.select.FoodRhsTask;
import io.github.xjrga.snack.database.callable.select.FoodsInCategoryTask;
import io.github.xjrga.snack.database.callable.select.FoodsInCategoryTask02;
import io.github.xjrga.snack.database.callable.select.FoodsInFoodGroupTask;
import io.github.xjrga.snack.database.callable.select.FoodsTask;
import io.github.xjrga.snack.database.callable.select.GroupConstraintsTask;
import io.github.xjrga.snack.database.callable.select.GroupLhsTask;
import io.github.xjrga.snack.database.callable.select.GroupRhsTask;
import io.github.xjrga.snack.database.callable.select.LifestageDriTask;
import io.github.xjrga.snack.database.callable.select.LifestagesTask;
import io.github.xjrga.snack.database.callable.select.MealPlanMealsTask;
import io.github.xjrga.snack.database.callable.select.MealPlanPortionsTask;
import io.github.xjrga.snack.database.callable.select.MealPlanResultsMacronutrientsTask;
import io.github.xjrga.snack.database.callable.select.MealPlanResultsTask;
import io.github.xjrga.snack.database.callable.select.MealPlanUsageResultsTask;
import io.github.xjrga.snack.database.callable.select.MealPlanUsageTask;
import io.github.xjrga.snack.database.callable.select.MixDiffTask;
import io.github.xjrga.snack.database.callable.select.MixFoodFactsTask;
import io.github.xjrga.snack.database.callable.select.MixResultsTask;
import io.github.xjrga.snack.database.callable.select.MixStatsTask;
import io.github.xjrga.snack.database.callable.select.MixesTask;
import io.github.xjrga.snack.database.callable.select.NamedMixFoodSortedByIdTask;
import io.github.xjrga.snack.database.callable.select.NamedMixFoodSortedByNameTask;
import io.github.xjrga.snack.database.callable.select.NewItemFoodFactsTask;
import io.github.xjrga.snack.database.callable.select.NutrientConstraintsTask;
import io.github.xjrga.snack.database.callable.select.NutrientContainingFoodsTask;
import io.github.xjrga.snack.database.callable.select.NutrientRatioConstraintsTask;
import io.github.xjrga.snack.database.callable.select.NutrientRatioLhsTask;
import io.github.xjrga.snack.database.callable.select.NutrientRatioRhsTask;
import io.github.xjrga.snack.database.callable.select.NutrientRhsTask;
import io.github.xjrga.snack.database.callable.select.ULDevSumExcessLhsTask;
import io.github.xjrga.snack.database.callable.select.UnallocatedFoodPercentageTask;
import io.github.xjrga.snack.database.callable.update.UpdateCategoryTask;
import io.github.xjrga.snack.database.callable.update.UpdateFoodGroupTask;
import io.github.xjrga.snack.database.callable.update.UpdateFoodPortionActualWeightTask;
import io.github.xjrga.snack.database.callable.update.UpdateFoodTask;
import io.github.xjrga.snack.database.callable.update.UpdateMealTask;
import io.github.xjrga.snack.database.callable.update.UpdateNameOnMixTask;
import io.github.xjrga.snack.database.query.AllocateAction;
import io.github.xjrga.snack.database.query.MixFoodsQuery;
import io.github.xjrga.snack.database.query.UpdateMixAction;
import io.github.xjrga.snack.database.query.UpdateMixFoodAction;
import io.github.xjrga.snack.database.runnable.CreateAllFoodsReport1Task;
import io.github.xjrga.snack.database.runnable.CreateAllFoodsReport2Task;
import io.github.xjrga.snack.datamodel.FoodStats;
import io.github.xjrga.snack.datamodel.MixFoodLoader;
import io.github.xjrga.snack.datamodel.NutrientLoader;
import io.github.xjrga.snack.datamodel.RelationshipLoader;
import io.github.xjrga.snack.datamodel.TreeModelFood;
import io.github.xjrga.snack.dataobject.DriDO;
import io.github.xjrga.snack.dataobject.Food;
import io.github.xjrga.snack.dataobject.GroupDO;
import io.github.xjrga.snack.dataobject.LhsContainer;
import io.github.xjrga.snack.dataobject.LifeStageDO;
import io.github.xjrga.snack.dataobject.MixDO;
import io.github.xjrga.snack.dataobject.MixFoodDO;
import io.github.xjrga.snack.dataobject.NutrientDO;
import io.github.xjrga.snack.dataobject.RelationshipDO;
import io.github.xjrga.snack.jcomponents.ComboBox;
import io.github.xjrga.snack.jcomponents.FoodFactInputPanel;
import io.github.xjrga.snack.jcomponents.LifestageFinder;
import io.github.xjrga.snack.jcomponents.Spinner;
import io.github.xjrga.snack.jcomponents.TableCategory;
import io.github.xjrga.snack.jcomponents.TableDri;
import io.github.xjrga.snack.jcomponents.TableFood;
import io.github.xjrga.snack.jcomponents.TableFoodDiff;
import io.github.xjrga.snack.jcomponents.TableFoodFactInput;
import io.github.xjrga.snack.jcomponents.TableFoodFacts;
import io.github.xjrga.snack.jcomponents.TableFoodQuantityConstraint;
import io.github.xjrga.snack.jcomponents.TableFoodRatioConstraint;
import io.github.xjrga.snack.jcomponents.TableGroupQuantityConstraint;
import io.github.xjrga.snack.jcomponents.TableGroups;
import io.github.xjrga.snack.jcomponents.TableInventoryDays;
import io.github.xjrga.snack.jcomponents.TableLog;
import io.github.xjrga.snack.jcomponents.TableMealCalories;
import io.github.xjrga.snack.jcomponents.TableMealGrams;
import io.github.xjrga.snack.jcomponents.TableMealPlanUsageResults;
import io.github.xjrga.snack.jcomponents.TableMix;
import io.github.xjrga.snack.jcomponents.TableMixDiff;
import io.github.xjrga.snack.jcomponents.TableMixResults;
import io.github.xjrga.snack.jcomponents.TableNutrientLookup;
import io.github.xjrga.snack.jcomponents.TableNutrientQuantity;
import io.github.xjrga.snack.jcomponents.TableNutrientRatioConstraint;
import io.github.xjrga.snack.jcomponents.TablePortion;
import io.github.xjrga.snack.jcomponents.TablePortionMeals;
import io.github.xjrga.snack.jcomponents.TablePortionMeals.Row;
import io.github.xjrga.snack.jpanels.NutrientCategorySelector;
import io.github.xjrga.snack.jpanels.NutrientCategorySelector.Nutrients;
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
import io.github.xjrga.snack.other.RegexCheck;
import io.github.xjrga.snack.other.Shutdown;
import io.github.xjrga.snack.other.StringCheck;
import io.github.xjrga.snack.other.TableColumnWidth;
import io.github.xjrga.snack.other.Utilities;
import io.github.xjrga.snack.renderers.ComboMixRenderer;
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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ActionMap;
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
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JTree;
import javax.swing.JViewport;
import javax.swing.KeyStroke;
import javax.swing.SpinnerListModel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.ListSelectionEvent;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.tree.DefaultMutableTreeNode;
import org.apache.commons.lang3.StringUtils;

public class Main {

    private final BufferedImage logo;
    private final CellConstraints cc;
    private final ComboBox<MixFoodDO> cmbFoodQuantityFood;
    private final ComboBox<GroupDO> cmbFoodGroup;
    private final ComboBox<MixFoodDO> cmbFoodRatioFoodA;
    private final ComboBox<MixFoodDO> cmbFoodRatioFoodB;
    private final ComboBox<MixFoodDO> cmbPortionFood;
    private final ComboBox<NutrientDO> cmbFoodQuantityNutrient;
    private final ComboBox<NutrientDO> cmbGroupNutrient;
    private final ComboBox<NutrientDO> cmbFoodRatioNutrientA;
    private final ComboBox<NutrientDO> cmbFoodRatioNutrientB;
    private final ComboBox<NutrientDO> cmbNutrientContentNutrient;
    private final ComboBox<NutrientDO> cmbNutrientQuantityNutrient;
    private final ComboBox<NutrientDO> cmbNutrientRatioNutrientA;
    private final ComboBox<NutrientDO> cmbNutrientRatioNutrientB;
    private final ComboBox<RelationshipDO> cmbFoodQuantityRelationship;
    private final ComboBox<RelationshipDO> cmbGroupRelationship;
    private final ComboBox<RelationshipDO> cmbFoodRatioRelationship;
    private final ComboBox<RelationshipDO> cmbNutrientQuantityRelationship;
    private final ComboBox<RelationshipDO> cmbNutrientRatioRelationship;
    private final DefaultListModel listModelHighScore;
    private final FoodStats foodStats;
    private final JButton btnAddFood;
    private final JButton btnAddFoodQuantityConstraint;
    private final JButton btnAddGroupQuantityConstraint;
    private final JButton btnAddFoodRatioConstraint;
    private final JButton btnAddMeal;
    private final JButton btnAddNutrientConstraint;
    private final JButton btnAddNutrientRatio;
    private final JButton btnAddPortion;
    private final JButton btnDeleteFood;
    private final JButton btnDeleteFoodQuantityConstraint;
    private final JButton btnDeleteGroupQuantityConstraint;
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
    private final JButton btnBlock;
    private final JButton btnGroupBlock;
    private final JCheckBox chkLpsolve;
    private final JCheckBox chkResultRoundUp;
    private final JFileChooser fch;
    private final JFrame frm;
    private final JLabel lblFoodCount;
    private final JLabel lblGroupCount;
    private final JLabel lblFoodRatioCount;
    // private final JLabel lblGroupRatioCount;
    private final JLabel lblNutrientCount;
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
    private final JMenuItem mniCreateMixTotalsReport;
    private final JMenuItem mniCreateMixResultsReport1;
    private final JMenuItem mniCreateMixResultsReport2;
    private final JMenuItem mniCreateNutrientSearchReport;
    private final JMenuItem mniDELETEALL;
    private final JMenuItem mniDELETEMIXES;
    private final JMenuItem mniDeleteMix;
    private final JMenuItem mniDuplicateMix;
    private final JMenuItem mniExit;
    private final JMenuItem mniExportMixModel;
    private final JMenuItem mniImportFoods;
    private final JMenuItem mniImportMixModel;
    private final JMenuItem mniPinMixAndDeleteConstraints;
    private final JMenuItem mniPinMixAndKeepConstraints;
    private final JMenuItem mniRenameMix;
    private final JMenuItem mniSetConstraints;
    private final JMenuItem mniShowCarbohydrateRequired;
    private final JMenuItem mniShowMixStats;
    private final JSplitPane splMain;
    private final JTabbedPane tabMain;
    private final JTabbedPane tabResults;
    private final JTextArea txaLpProgram;
    private final JTextField txtFoodNutrientRatioQuantityA;
    private final JTextField txtFoodNutrientRatioQuantityB;
    private final JTextField txtFoodQuantityValue;
    private final JTextField txtGroupQuantityValue;
    private final JTextField txtNutrientSearchQuantity;
    private final JTextField txtNutrientQuantityValue;
    private final JTextField txtNutrientRatioNutrientA;
    private final JTextField txtNutrientRatioNutrientB;
    private final JTextField txtPortionPct;
    private final JTextField txtTotalPct;
    private JTextArea txtMinimization;
    private final JTree tree;
    private final MixFoodLoader mixFoodLoader;
    private final NutrientLoader nutrientLoader;
    private final RelationshipLoader relationshipLoader;
    private final TableMix tblMealPlanUsageMixes;
    private final TreeModelFood treeModel;
    private ComboBox<LifeStageDO> cmbLifestage;
    private Spinner<LifeStageDO> spnLifestage;
    private Spinner<String> spnMinimizationOption;
    private ComboBox<MixDO> cmbMixes;
    private TableCategory tblAllFoodCategories;
    private TableGroups tblFoodGroups;
    private TableDri tblDri;
    private TableMixResults tblMixResults;
    private TableFood tblAllFoods;
    private TableFood tblFoodsInCategory;
    private TableFood tblSelectedFoods;
    private TableFood tblFoodsInFoodGroup;
    private TableFood tblFoodDiffA;
    private TableFood tblFoodDiffB;
    private TableFood tblMixFood;
    private TableFoodFacts tblFoodFacts;
    private TableFoodDiff tblFoodDiff;
    private TableFoodQuantityConstraint tblFoodQuantityConstraint;
    private TableGroupQuantityConstraint tblGroupQuantityConstraint;
    private TableFoodRatioConstraint tblFoodRatioConstraint;
    private TableInventoryDays tblMealPlanUsage;
    private TableMealPlanUsageResults tblMealPlanUsageResults;
    private TableMealCalories tblMealCalories;
    private TableMealGrams tblMealMacronutrients;
    private TableMix tblMixDiffA;
    private TableMix tblMixDiffB;
    private TableMixDiff tblMixDiff;
    private TableNutrientLookup tblNutrientLookup;
    private TableNutrientQuantity tblNutrientQuantityConstraint;
    private TableNutrientRatioConstraint tblNutrientRatio;
    private TablePortion tblMealPortions;
    private TablePortionMeals tblMeals;
    private TableLog tblLog;
    private final Connection connection;
    private int minimizationOption;
    private NutrientCategorySelector selectorMixResultsTable;
    private MixDO selectedMix;
    private String selectedMixId;
    private String selectedMixName;
    private String selectedMixModel;
    private BigDecimal selectedMixCost;
    private BigDecimal selectedMixDeficiency;
    private BigDecimal selectedMixExcess;
    private Integer selectedMixLifeStageId;


    public Main( Splash splash ) {
        LoggerImpl.INSTANCE.filter( "io.github.xjrga.*" );
        logo = ImageUtilities.readImageFromUrl( Utilities.getResourceAsUrl( "/resources/images/logo.png" ) );
        cc = new CellConstraints();
        cmbFoodQuantityFood = new ComboBox();
        cmbFoodGroup = new ComboBox();
        cmbFoodRatioFoodA = new ComboBox();
        cmbFoodRatioFoodB = new ComboBox();
        cmbPortionFood = new ComboBox<>();
        cmbFoodQuantityNutrient = new ComboBox();
        cmbGroupNutrient = new ComboBox();
        cmbFoodRatioNutrientA = new ComboBox();
        cmbFoodRatioNutrientB = new ComboBox();
        cmbNutrientContentNutrient = new ComboBox();
        cmbNutrientQuantityNutrient = new ComboBox();
        cmbNutrientRatioNutrientA = new ComboBox();
        cmbNutrientRatioNutrientB = new ComboBox();
        cmbFoodQuantityRelationship = new ComboBox();
        cmbGroupRelationship = new ComboBox();
        cmbFoodRatioRelationship = new ComboBox();
        cmbNutrientQuantityRelationship = new ComboBox();
        cmbNutrientRatioRelationship = new ComboBox();
        listModelHighScore = new DefaultListModel();
        foodStats = new FoodStats();
        btnAddFood = new JButton( "+" );
        btnAddFoodQuantityConstraint = new JButton( "+" );
        btnAddGroupQuantityConstraint = new JButton( "+" );
        btnAddFoodRatioConstraint = new JButton( "+" );
        btnAddMeal = new JButton( "+" );
        btnAddNutrientConstraint = new JButton( "+" );
        btnAddNutrientRatio = new JButton( "+" );
        btnAddPortion = new JButton( "+" );
        btnDeleteFood = new JButton( "-" );
        btnDeleteFoodQuantityConstraint = new JButton( "-" );
        btnDeleteGroupQuantityConstraint = new JButton( "-" );
        btnDeleteFoodRatioConstraint = new JButton( "-" );
        btnDeleteMeal = new JButton( "-" );
        btnDeleteNutrientConstraint = new JButton( "-" );
        btnDeleteNutrientRatio = new JButton( "-" );
        btnDeletePortion = new JButton( "-" );
        btnRenameFood = new JButton( "r" );
        btnSolve = new JButton( "Solve" );
        btnUpdateFood = new JButton( "u" );
        btnUpdateMeal = new JButton( "u" );
        btnUpdatePortionWeight = new JButton( "w" );
        btnBlock = new JButton( "Block" );
        btnGroupBlock = new JButton( "Block" );
        chkLpsolve = new JCheckBox();
        chkResultRoundUp = new JCheckBox();
        fch = new JFileChooser();
        frm = new JFrame();
        lblFoodCount = new JLabel();
        lblGroupCount = new JLabel();
        lblFoodRatioCount = new JLabel();
        // lblGroupRatioCount = new JLabel();
        lblNutrientCount = new JLabel();
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
        mniCreateMixTotalsReport = new JMenuItem();
        mniCreateMixResultsReport1 = new JMenuItem();
        mniCreateMixResultsReport2 = new JMenuItem();
        mniCreateNutrientSearchReport = new JMenuItem();
        mniDELETEALL = new JMenuItem();
        mniDELETEMIXES = new JMenuItem();
        mniDeleteMix = new JMenuItem();
        mniDuplicateMix = new JMenuItem();
        mniExit = new JMenuItem();
        mniExportMixModel = new JMenuItem();
        mniImportFoods = new JMenuItem();
        mniImportMixModel = new JMenuItem();
        mniPinMixAndDeleteConstraints = new JMenuItem();
        mniPinMixAndKeepConstraints = new JMenuItem();
        mniRenameMix = new JMenuItem();
        mniSetConstraints = new JMenuItem();
        mniShowCarbohydrateRequired = new JMenuItem();
        mniShowMixStats = new JMenuItem();
        splMain = new JSplitPane();
        tabMain = new JTabbedPane();
        tabResults = new JTabbedPane();
        txaLpProgram = new JTextArea();
        txtFoodNutrientRatioQuantityA = new JTextField();
        txtFoodNutrientRatioQuantityB = new JTextField();
        txtFoodQuantityValue = new JTextField();
        txtGroupQuantityValue = new JTextField();
        txtNutrientSearchQuantity = new JTextField();
        txtNutrientQuantityValue = new JTextField();
        txtNutrientRatioNutrientA = new JTextField();
        txtNutrientRatioNutrientB = new JTextField();
        txtPortionPct = new JTextField();
        txtTotalPct = new JTextField();
        txtMinimization = new JTextArea();
        tree = new JTree();
        mixFoodLoader = new MixFoodLoader();
        nutrientLoader = new NutrientLoader();
        relationshipLoader = new RelationshipLoader();
        tblMealPlanUsageMixes = new TableMix();
        treeModel = new TreeModelFood();
        minimizationOption = 0;
        txtMinimization.setText( "DRI Deficiency" );
        txtMinimization.setLineWrap( true );
        txtMinimization.setEditable( false );
        frm.setIconImage( logo );
        frm.setJMenuBar( getMenuBar() );
        tabMain.setTabPlacement( SwingConstants.BOTTOM );
        tabMain.add( getEditorPanel() );
        tabMain.add( getFoodList() );
        tabMain.add( getFoodComparisonPanel() );
        tabMain.add( getMixComparisonPanel() );
        tabMain.add( getNutrientSearchPanel() );
        tabMain.add( getFoodCategoriesPanel() );
        tabMain.add( getMealPlanUsagePanel() );
        int length = 17;
        String txt0 = StringUtils.center( "Editor", length );
        String txt1 = StringUtils.center( "Food List", length );
        String txt2 = StringUtils.center( "Food Comparison", length );
        String txt3 = StringUtils.center( "Mix Comparison", length );
        String txt4 = StringUtils.center( "Nutrient Search", length );
        String txt5 = StringUtils.center( "Food Category", length );
        String txt6 = StringUtils.center( "Food Shopping", length );
        String txt7 = StringUtils.center( "Mixes Log", length );
        tabMain.setTitleAt( 0, txt0 );
        tabMain.setToolTipTextAt( 0, "Create, edit and solve your diet here" );
        tabMain.setTitleAt( 1, txt1 );
        tabMain.setToolTipTextAt( 1, "This is your list of favorite food items" );
        tabMain.setTitleAt( 2, txt2 );
        tabMain.setToolTipTextAt( 2, "This is where you compare two 100 Kcal food servings" );
        tabMain.setTitleAt( 3, txt3 );
        tabMain.setToolTipTextAt( 3, "This is where you compare two mixes" );
        tabMain.setTitleAt( 4, txt4 );
        tabMain.setToolTipTextAt( 4, "This is where you search food items for nutrient content" );
        tabMain.setTitleAt( 5, txt5 );
        tabMain.setToolTipTextAt( 5, "This is where you put food items into categories" );
        tabMain.setTitleAt( 6, txt6 );
        tabMain.setToolTipTextAt( 6, "This is where you find out how much food you need to buy" );
        tabMain.add( txt7, getModelLogPanel() );
        tabMain.setToolTipTextAt( 7, "This is keeps track of changes made to mixes in this session" );
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView( tabMain );
        frm.add( scrollPane );
        frm.setDefaultCloseOperation( 3 );
        Dimension size = new Dimension( 1500, 870 );
        frm.setSize( size );
        frm.setVisible( true );
        frm.setTitle( StringUtils.center( "Snack", 7 ) );
        frm.addWindowListener( new WindowAdapter() {
            @Override
            public void windowClosing( WindowEvent e ) {
                exit();
            }
        } );
        cmbMixes.setMaximumRowCount( 24 );
        connection = Connect.getInstance().getConnection();
        reloadCbNutrientData();
        reloadCbRelationshipData();
        try {
            Future<List<List>> task = BackgroundExec.submit( new MixesTask() );
            List<List> lst = task.get();
            List<MixDO> mixesList = Utilities.createMixDOList( lst );
            cmbMixes.reload( mixesList );
            tblMixDiffA.reload( lst );
            tblMixDiffB.reload( lst );
            tblMealPlanUsageMixes.reload( lst );
        } catch ( Exception e ) {
            LoggerImpl.INSTANCE.logProblem( e );
        }
        reloadFoods();
        try {
            Future<List<LifeStageDO>> task = BackgroundExec.submit( new LifestagesTask() );
            List<LifeStageDO> lifestages = task.get();
            cmbLifestage.reload( lifestages );
            spnLifestage.reload( lifestages );
        } catch ( Exception e ) {
            LoggerImpl.INSTANCE.logProblem( e );
        }
        fch.setPreferredSize( new Dimension( 600, 600 ) );
        fch.setAcceptAllFileFilterUsed( false );
        fch.addChoosableFileFilter( new FileNameExtensionFilter( "Xml Document", "xml" ) );
        Action details = fch.getActionMap().get( "viewTypeDetails" );
        details.actionPerformed( null );
        LifeStageDO lifestage8 = new LifeStageDO( 8, "Males (51-70 y)" );
        cmbLifestage.setSelectedItem( lifestage8 );
        spnLifestage.setSelectedItem( lifestage8 );
        if ( !cmbMixes.isEmpty() ) {
            cmbMixes.setSelectedIndex( 0 );
        }
        setSplitPanelDivider();
        setQuantityScale();
        splash.halt();
    }


    private void reloadFoods() {
        try {
            Future<List<List>> task = BackgroundExec.submit( new FoodFactsTask() );
            List<List> foods = task.get();
            List<List> filteredFoods = new ArrayList();
            int size = foods.size();
            for ( int i = 0; i < size; i++ ) {
                List food = foods.get( i );
                ArrayList<Object> newFood = new ArrayList();
                newFood.add( food.get( 0 ) );
                newFood.add( food.get( 1 ) );
                filteredFoods.add( newFood );
            }
            tblFoodFacts.reload( foods );
            tblFoodDiffA.reload( filteredFoods );
            tblFoodDiffB.reload( filteredFoods );
            tblAllFoods.reload( filteredFoods );
        } catch ( Exception e ) {
            LoggerImpl.INSTANCE.logProblem( e );
        }
        try {
            Future<List<Map<String, Object>>> task = BackgroundExec.submit( new FoodsTask() );
            List<Map<String, Object>> treeFoods = task.get();
            treeModel.reload( treeFoods );
        } catch ( Exception e ) {
            LoggerImpl.INSTANCE.logProblem( e );
        }
        try {
            Future<List<List>> task = BackgroundExec.submit( new FoodCategoriesTask() );
            List<List> categories = task.get();
            tblAllFoodCategories.reload( categories );
        } catch ( Exception e ) {
            LoggerImpl.INSTANCE.logProblem( e );
        }
    }


    private void clearMixesView() {
        // Mixes List
        cmbMixes.clear();
        tblMixDiffA.clear();
        tblMixDiffB.clear();
        tblMealPlanUsageMixes.clear();
        // Model Data
        tblMixFood.clear();
        tblSelectedFoods.clear();
        tblNutrientQuantityConstraint.clear();
        tblNutrientRatio.clear();
        cmbFoodQuantityFood.clear();
        tblFoodQuantityConstraint.clear();
        cmbFoodRatioFoodA.clear();
        cmbFoodRatioFoodB.clear();
        tblFoodRatioConstraint.clear();
        cmbFoodGroup.clear();
        tblGroupQuantityConstraint.clear();
        // Model Results Data
        tblMixResults.clear();
        tblDri.clear();
        txaLpProgram.setText( "" );
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
        treeModel.clear();
        tblMixFood.clear();
        tblSelectedFoods.clear();
        tblFoodFacts.clear();
        tblFoodDiffA.clear();
        tblFoodDiffB.clear();
        tblAllFoods.clear();
        tblFoodsInCategory.clear();
        tblAllFoodCategories.clear();
        cmbFoodQuantityFood.clear();
        cmbFoodRatioFoodA.clear();
        cmbFoodRatioFoodB.clear();
        tblFoodDiff.clear();
    }


    private void deleteFoodItem( String foodId ) {
        try {
            Future<Boolean> task = BackgroundExec.submit( new DeleteFoodTask( foodId ) );
            Boolean completed = task.get();
        } catch ( Exception e ) {
            LoggerImpl.INSTANCE.logProblem( e );
        }
        reloadFoods();
        try {
            Future<List<List>> task = BackgroundExec.submit( new NamedMixFoodSortedByNameTask( selectedMixId ) );
            List<List> foods = task.get();
            tblMixFood.reload( foods );
            tblSelectedFoods.reload( foods );
        } catch ( Exception e ) {
            LoggerImpl.INSTANCE.logProblem( e );
        }
        setQuantityScale();
    }


    private void addMealPlanUsage() {
        if ( tblMealPlanUsageMixes.isSelectionEmpty() ) {
            return;
        }
        TableMix.Row row = tblMealPlanUsageMixes.getSelectedValue();
        Double days = getMixUsageInputForInventory();
        if ( days == Double.NaN ) {
            return;
        }
        try {
            Future<Boolean> task = BackgroundExec.submit( new MergeMealPlanUsageTask( row.getMixid(), days ) );
            task.get();
        } catch ( Exception e ) {
            LoggerImpl.INSTANCE.logProblem( e );
        }
    }


    private void deleteMealPlanUsage() {
        if ( tblMealPlanUsage.isSelectionEmpty() ) {
            return;
        }
        try {
            TableInventoryDays.Row row = tblMealPlanUsage.getSelectedValue();
            Future<Boolean> task = BackgroundExec.submit( new DeleteMealPlanUsageTask( row.getMixid() ) );
            task.get();
        } catch ( Exception e ) {
            LoggerImpl.INSTANCE.logProblem( e );
        }
    }


    private void expandTree( JTree tree, int startingIndex, int rowCount ) {
        for ( int i = startingIndex; i < rowCount; ++i ) {
            tree.expandRow( i );
        }
        if ( tree.getRowCount() != rowCount ) {
            expandTree( tree, rowCount, tree.getRowCount() );
        }
    }


    private JTabbedPane getConstraintsPanel() {
        JTabbedPane tab = new JTabbedPane();
        tblFoodQuantityConstraint = new TableFoodQuantityConstraint();
        int size = 19;
        String txt0 = StringUtils.rightPad( "Food List", size );
        String txt1 = StringUtils.rightPad( "Nutrient", size );
        String txt2 = StringUtils.rightPad( "Nutrient Ratio", size );
        String txt3 = StringUtils.rightPad( "Food", size );
        String txt4 = StringUtils.rightPad( "Food Ratio", size );
        String txt5 = StringUtils.rightPad( "Group", size );
        // String txt6 = StringUtils.rightPad("Group Ratio", size);
        tab.setBorder( new TitledBorder( "Constraints" ) );
        tab.setTabPlacement( SwingConstants.RIGHT );
        tab.add( txt0, getMixFoodPanel() );
        tab.add( txt1, new PanelSpacer( getNutrientQuantityConstraintPanel() ) );
        tab.add( txt2, new PanelSpacer( getNutrientRatioPanel() ) );
        tab.add( txt3, new PanelSpacer( getFoodQuantityConstraint() ) );
        tab.add( txt4, new PanelSpacer( getFoodRatioPanel() ) );
        tab.add( txt5, new PanelSpacer( getGroupQuantityConstraint() ) );
        // tab.add(txt6, new PanelSpacer(new JPanel()));
        tab.setToolTipTextAt( 0, "Add food items to this list" );
        tab.setToolTipTextAt( 1, "Limit a nutrient" );
        tab.setToolTipTextAt( 2, "Create relationship between two nutrients" );
        tab.setToolTipTextAt( 3, "Limit a food item" );
        tab.setToolTipTextAt( 4, "Create relationship between two food items" );
        tab.setToolTipTextAt( 5, "Limit a group" );
        // tab.setToolTipTextAt(6, "Create relationship between two groups");
        return tab;
    }


    private JPanel getEditorPanel() {
        JPanel pnl = new JPanel();
        FormLayout lyo = new FormLayout(
                "min:grow", // columns
                "min,fill:min:grow" // rows
        );
        pnl.setLayout( lyo );
        pnl.add( getEditorTopPanel(), cc.xy( 1, 1 ) );
        pnl.add( getEditorBottomPanel(), cc.xy( 1, 2 ) );
        cmbMixes.addActionListener( ( ActionEvent evt ) -> {
            if ( !cmbMixes.isSelectionEmpty() ) {
                clearMixResults();
                loadSelectedMix();
            }
        } );
        return pnl;
    }


    private JPanel getMealPlanPanel() {
        JPanel pnl = new JPanel();
        JTabbedPane tab = new JTabbedPane();
        FormLayout lyo = new FormLayout(
                "min:grow", // columns
                "fill:min:grow" // rows
        );
        pnl.setLayout( lyo );
        tab.setTabPlacement( SwingConstants.RIGHT );
        tab.add( "Portions      ", new PanelSpacer( getMealPortionsPanel() ) );
        tab.add( "Calories      ", new PanelSpacer( getMealCaloriesPanel() ) );
        tab.add( "Macronutrients", new PanelSpacer( getMealMacronutrientsPanel() ) );
        tab.setSelectedIndex( 0 );
        tab.setToolTipTextAt(
                0,
                "Allocate food amount by specifying a percentage, selecting a food item, one or more meals"
                + " and pressing '+'" );
        tab.setToolTipTextAt( 1, "Calories per meal" );
        tab.setToolTipTextAt( 2, "Grams per meal" );
        pnl.add( tab, cc.xy( 1, 1 ) );
        return pnl;
    }


    private JPanel getEditorTopPanel() {
        cmbMixes = new ComboBox<>();
        cmbMixes.setRenderer( new ComboMixRenderer() );
        JPanel pnl = new JPanel();
        FormLayout lyo = new FormLayout(
                "p:grow,4px,156px", // columns
                "fill:30px:grow" // rows
        );
        pnl.setLayout( lyo );
        pnl.setBorder( new TitledBorder( "Mix" ) );
        btnSolve.setToolTipText( "Find lowest calorie diet" );
        pnl.add( cmbMixes, cc.xy( 1, 1 ) );
        pnl.add( btnSolve, cc.xy( 3, 1 ) );
        btnSolve.addActionListener( ( ActionEvent evt ) -> {
            if ( cmbMixes.isSelectionEmpty() ) {
                return;
            }
            if ( tblMixFood.isEmpty() ) {
                return;
            }
            LifeStageDO selectedLifestage = spnLifestage.getSelectedItem();
            Integer selectedLifestageId = selectedLifestage.getLifeStageId();
            selectedMix.setLifestageid( selectedLifestageId );
            Boolean solutionFound = solveModel( selectedMix );
            if ( !solutionFound ) {
                return;
            }
            reloadResults( selectedMix );
            tblMixDiffA.clearSelection();
            tblMixDiffB.clearSelection();
            tblMealPlanUsageMixes.clearSelection();
        } );
        return pnl;
    }


    private JPanel getEditorModel() {
        JPanel pnl = new JPanel();
        FormLayout lyo = new FormLayout(
                "min:grow", // columns
                "fill:pref:grow" // rows
        );
        pnl.setLayout( lyo );
        try {
            URL url = Utilities.getResourceAsUrl( "/resources/fonts/inconsolata.ttf" );
            InputStream is = url.openStream();
            Font font = Font.createFont( Font.TRUETYPE_FONT, is ).deriveFont( 13f );
            txaLpProgram.setFont( font );
            txaLpProgram.setLineWrap( false );
            JScrollPane scrollPane = new JScrollPane( txaLpProgram );
            scrollPane.setPreferredSize( new Dimension( 0, 0 ) );
            pnl.add( scrollPane, cc.xy( 1, 1 ) );
        } catch ( IOException | FontFormatException e ) {
            LoggerImpl.INSTANCE.logProblem( e );
        }
        return pnl;
    }


    private JPanel getEditorDri( TableDri tblDri ) {
        JScrollPane scr = new JScrollPane( tblDri );
        FormLayout lyo = new FormLayout(
                "p:grow", // columns
                "5dlu,min,5dlu,fill:min:grow" // rows
        );
        FormLayout lyoLifestage = new FormLayout(
                "5dlu,min:grow,5dlu,min", // columns
                "min" // rows
        );
        JPanel pnlLifestage = new JPanel();
        pnlLifestage.setLayout( lyoLifestage );
        JLabel lbl = new JLabel( " Lifestage:" );
        cmbLifestage = new ComboBox<>();
        lbl.setHorizontalAlignment( SwingConstants.RIGHT );
        pnlLifestage.add( lbl, cc.xy( 2, 1 ) );
        pnlLifestage.add( cmbLifestage, cc.xy( 4, 1 ) );
        JPanel pnl = new JPanel();
        pnl.setLayout( lyo );
        pnl.add( pnlLifestage, cc.xy( 1, 2 ) );
        pnl.add( scr, cc.xy( 1, 4 ) );
        scr.setBorder( new TitledBorder( "DRI Check" ) );
        cmbLifestage.addActionListener( ( ActionEvent evt ) -> {
            if ( !cmbLifestage.isSelectionEmpty() ) {
                if ( selectedMix != null ) {
                    LifeStageDO lifestage = ( LifeStageDO ) cmbLifestage.getSelectedItem();
                    try {
                        Future<List<List>> task
                                = BackgroundExec.submit( new DriDiffTask( selectedMixId, lifestage.getLifeStageId() ) );
                        List<List> diff = task.get();
                        tblDri.reload( diff );
                        setQuantityScale();
                    } catch ( Exception e ) {
                        LoggerImpl.INSTANCE.logProblem( e );
                    }
                }
            }
        } );
        JPopupMenu pmn = new JPopupMenu();
        JMenuItem item01 = new JMenuItem( "Do nutrient search" );
        JMenuItem item02 = new JMenuItem( "Show nutrient contribution by food" );
        pmn.add( item01 );
        pmn.add( item02 );
        item01.addActionListener( ( ActionEvent evt ) -> {
            if ( !tblDri.isSelectionEmpty() ) {
                calculateNutrientContent();
            } else {
                Message.showMessage( "Please select nutrient" );
            }
        } );
        item02.addActionListener( ( ActionEvent evt ) -> {
            String nutrient = tblDri.getSelectedValue().getNutrient();
            boolean carbohydrates = nutrient.startsWith( "Carbohydrates" );
            boolean pufa = nutrient.startsWith( "Fats, Linole" );
            boolean fats = nutrient.startsWith( "Fats, Total" );
            boolean minerals = nutrient.startsWith( "Minerals" );
            boolean potassium = nutrient.startsWith( "Minerals, Potassium" );
            boolean sodium = nutrient.startsWith( "Minerals, Sodium" );
            boolean other = nutrient.startsWith( "Other" );
            boolean protein = nutrient.startsWith( "Protein" );
            boolean vitamins = nutrient.startsWith( "Vitamins" );
            tabResults.setSelectedIndex( 0 );
            if ( carbohydrates ) {
                selectorMixResultsTable.setSelected( Nutrients.Carbohydrates );
            }
            if ( pufa ) {
                selectorMixResultsTable.setSelected( Nutrients.Polyunsaturated );
            }
            if ( fats ) {
                selectorMixResultsTable.setSelected( Nutrients.Fats );
            }
            if ( minerals ) {
                if ( potassium || sodium ) {
                    selectorMixResultsTable.setSelected( Nutrients.Electrolytes );
                } else {
                    selectorMixResultsTable.setSelected( Nutrients.Minerals );
                }
            }
            if ( other ) {
                selectorMixResultsTable.setSelected( Nutrients.Other );
            }
            if ( protein ) {
                selectorMixResultsTable.setSelected( Nutrients.Protein );
            }
            if ( vitamins ) {
                selectorMixResultsTable.setSelected( Nutrients.Vitamins );
            }
        } );
        tblDri.addMouseListener( new MouseAdapter() {
            @Override
            public void mouseClicked( MouseEvent e ) {
                super.mouseClicked( e );
                showPopup( e, pmn );
            }
        } );
        return pnl;
    }


    private JSplitPane getModelPanel() {
        JPanel pnlMain = new JPanel();
        JPanel pnlRight = new JPanel();
        JPanel pnlObjective = new JPanel();
        JPanel pnlConstraintCount = new JPanel();
        FormLayout lyoMainPanel = new FormLayout(
                "p:grow,right:p", // columns
                "fill:min:grow" // rows
        );
        FormLayout lyoRightPanel = new FormLayout(
                "160px", // columns
                "min,fill:min:grow" // rows
        );
        FormLayout lyoConstraintCountPanel = new FormLayout(
                "p,p", // columns
                "4dlu,min,min,min,min,min,min,4dlu" // rows
        );
        FormLayout lyoObjective = new FormLayout(
                "150px", // columns
                "min,fill:32px,min,fill:32px,min,fill:min:grow" // rows
        );
        pnlMain.setLayout( lyoMainPanel );
        pnlRight.setLayout( lyoRightPanel );
        pnlConstraintCount.setLayout( lyoConstraintCountPanel );
        pnlObjective.setLayout( lyoObjective );
        JScrollPane scrHighScore = new JScrollPane( lstHighScore );
        scrHighScore.setBorder( new TitledBorder( "" ) );
        pnlObjective.setBorder( new TitledBorder( "" ) );
        scrHighScore.setToolTipText( "Press delete button to clear list" );
        pnlConstraintCount.setBorder( new TitledBorder( "Constraints" ) );
        lstHighScore.setModel( listModelHighScore );
        DefaultListCellRenderer renderer = ( DefaultListCellRenderer ) lstHighScore.getCellRenderer();
        renderer.setHorizontalAlignment( SwingConstants.RIGHT );
        tabResults.setBorder( new TitledBorder( "Results" ) );
        tabResults.setTabPlacement( SwingConstants.BOTTOM );
        JLabel lblNutrient = new JLabel( "Nutrient: " );
        JLabel lblNutrientRatio = new JLabel( "Nutrient Ratio: " );
        JLabel lblFood = new JLabel( "Food: " );
        JLabel lblFoodRatio = new JLabel( "Food Ratio: " );
        JLabel lblGroup = new JLabel( "Group: " );
        // JLabel lblGroupRatio = new JLabel("Group Ratio: ");
        tblMixResults = new TableMixResults();
        tblDri = new TableDri();
        spnLifestage = new Spinner<>();
        spnMinimizationOption = new Spinner<>();
        ArrayList list = new ArrayList();
        list.add( "DRI Deficiency" );
        list.add( "DRI Deficiency And UL Excess" );
        list.add( "DRI Deficiency And DRI Excess" );
        spnMinimizationOption.reload( list );
        lblNutrient.setHorizontalAlignment( SwingConstants.RIGHT );
        lblFood.setHorizontalAlignment( SwingConstants.RIGHT );
        lblNutrientRatio.setHorizontalAlignment( SwingConstants.RIGHT );
        lblFoodRatio.setHorizontalAlignment( SwingConstants.RIGHT );
        lblGroup.setHorizontalAlignment( SwingConstants.RIGHT );
        // lblGroupRatio.setHorizontalAlignment(SwingConstants.RIGHT);
        pnlConstraintCount.add( lblNutrient, cc.xy( 1, 2 ) );
        pnlConstraintCount.add( lblNutrientRatio, cc.xy( 1, 3 ) );
        pnlConstraintCount.add( lblFood, cc.xy( 1, 4 ) );
        pnlConstraintCount.add( lblFoodRatio, cc.xy( 1, 5 ) );
        pnlConstraintCount.add( lblGroup, cc.xy( 1, 6 ) );
        // pnlConstraintCount.add(lblGroupRatio, cc.xy(1, 7));
        pnlConstraintCount.add( lblNutrientCount, cc.xy( 2, 2 ) );
        pnlConstraintCount.add( lblNutrientRatioCount, cc.xy( 2, 3 ) );
        pnlConstraintCount.add( lblFoodCount, cc.xy( 2, 4 ) );
        pnlConstraintCount.add( lblFoodRatioCount, cc.xy( 2, 5 ) );
        pnlConstraintCount.add( lblGroupCount, cc.xy( 2, 6 ) );
        // pnlConstraintCount.add(lblGroupRatioCount, cc.xy(2, 7));
        JPanel pnl = new JPanel();
        FormLayout lyoPnl = new FormLayout(
                "4px,min:grow,4px,p,4px", // columns
                "4px,fill:min:grow,4px" // rows
        );
        pnl.setLayout( lyoPnl );
        pnl.add( new JScrollPane( tblMixResults ), cc.xy( 2, 2 ) );
        selectorMixResultsTable = new NutrientCategorySelector( tblMixResults );
        selectorMixResultsTable.setSelected( Nutrients.Calories );
        pnl.add( selectorMixResultsTable, cc.xy( 4, 2 ) );
        tabResults.add( pnl );
        tabResults.add( getEditorDri( tblDri ) );
        tabResults.add( getEditorModel() );
        int size = 32;
        String txt0 = StringUtils.center( "Nutrient Contribution By Food", size );
        String txt1 = StringUtils.center( "Dietary Reference Intake", 32 );
        String txt2 = StringUtils.center( "Linear Programming Model", 32 );
        tabResults.setTitleAt( 0, txt0 );
        tabResults.setTitleAt( 1, txt1 );
        tabResults.setTitleAt( 2, txt2 );
        pnlObjective.add( new JLabel( "Lifestage" ), cc.xy( 1, 1 ) );
        pnlObjective.add( spnLifestage, cc.xy( 1, 2 ) );
        pnlObjective.add( new JLabel( "Minimization Option" ), cc.xy( 1, 3 ) );
        pnlObjective.add( spnMinimizationOption, cc.xy( 1, 4 ) );
        pnlObjective.add( new JLabel( "Total Nutrient Index" ), cc.xy( 1, 5 ) );
        pnlObjective.add( scrHighScore, cc.xy( 1, 6 ) );
        pnlRight.add( pnlConstraintCount, cc.xy( 1, 1 ) );
        pnlRight.add( pnlObjective, cc.xy( 1, 2 ) );
        pnlMain.add( tabResults, cc.xy( 1, 1 ) );
        pnlMain.add( pnlRight, cc.xy( 2, 1 ) );
        splMain.setOrientation( JSplitPane.VERTICAL_SPLIT );
        splMain.setOneTouchExpandable( true );
        splMain.setTopComponent( pnlMain );
        splMain.setBottomComponent( getConstraintsPanel() );
        lstHighScore.addKeyListener( new KeyListener() {
            @Override
            public void keyPressed( KeyEvent e ) {
                if ( e.getKeyCode() == KeyEvent.VK_DELETE ) {
                    clearHighscore();
                }
            }


            @Override
            public void keyReleased( KeyEvent e ) {
            }


            @Override
            public void keyTyped( KeyEvent e ) {
            }
        } );
        Action high = new AbstractAction() {
            @Override
            public void actionPerformed( ActionEvent evt ) {
                splMain.setDividerLocation( 0.0 );
            }
        };
        Action middle = new AbstractAction() {
            @Override
            public void actionPerformed( ActionEvent evt ) {
                setSplitPanelDivider();
            }
        };
        Action low = new AbstractAction() {
            @Override
            public void actionPerformed( ActionEvent evt ) {
                splMain.setDividerLocation( 1.0 );
            }
        };
        InputMap inputMap = tabMain.getInputMap( JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT );
        ActionMap actionMap = tabMain.getActionMap();
        inputMap.put( KeyStroke.getKeyStroke( "control L" ), "min" );
        inputMap.put( KeyStroke.getKeyStroke( "control M" ), "mid" );
        inputMap.put( KeyStroke.getKeyStroke( "control H" ), "max" );
        actionMap.put( "min", low );
        actionMap.put( "mid", middle );
        actionMap.put( "max", high );
        spnLifestage.addChangeListener( ( ChangeEvent e ) -> {
            LifeStageDO lifestage = spnLifestage.getSelectedItem();
            cmbLifestage.setSelectedItem( lifestage );
        } );
        spnMinimizationOption.addChangeListener( ( ChangeEvent e ) -> {
            minimizationOption = spnMinimizationOption.getSelectedIndex();
        } );
        return splMain;
    }


    private JTabbedPane getEditorBottomPanel() {
        JTabbedPane tab = new JTabbedPane();
        tab.setTabPlacement( SwingConstants.BOTTOM );
        int size = 7;
        String txt0 = StringUtils.center( "Mix", size );
        String txt1 = StringUtils.center( "Meals", size );
        String txt2 = StringUtils.center( "Groups", size );
        tab.add( txt0, getModelPanel() );
        tab.add( txt1, getMealPlanPanel() );
        tab.add( txt2, getFoodGroupsPanel() );
        tab.setToolTipTextAt( 0, "This is where you create your food mix." );
        tab.setToolTipTextAt( 1, "This is where you create your meal plan for mix." );
        tab.setToolTipTextAt( 2, "This is where you create food groups that participate in the mix." );
        return tab;
    }


    private JPanel getFoodCategoriesPanel() {
        tblAllFoods = new TableFood();
        tblAllFoodCategories = new TableCategory();
        tblFoodsInCategory = new TableFood();
        TableCategory tblParentCategories = new TableCategory();
        JScrollPane scrAllFoods = new JScrollPane( tblAllFoods );
        scrAllFoods.setBorder( new TitledBorder( "All Foods" ) );
        JScrollPane scrAllFoodCategories = new JScrollPane( tblAllFoodCategories );
        scrAllFoodCategories.setBorder( new TitledBorder( "Categories" ) );
        JScrollPane scrFoodsInCategory = new JScrollPane( tblFoodsInCategory );
        JScrollPane scrParentCategories = new JScrollPane( tblParentCategories );
        JTextField txtSearchCategories = tblAllFoodCategories.getTxtSearch();
        JTextField txtSearchAllFoods = tblAllFoods.getTxtSearch();
        JTextField txtSearchFoodsInCategory = tblFoodsInCategory.getTxtSearch();
        JPanel pnlMain = new JPanel();
        JPanel pnlCategories = new JPanel();
        JPanel pnlAllFoods = new JPanel();
        JPanel pnlCategoryFoods = new JPanel();
        JPanel pnlCategoryButtons = new JPanel();
        JPanel pnlFoodButtons = new JPanel();
        JPanel pnlButtons = new JPanel();
        FormLayout lyoMain = new FormLayout(
                "m:grow,8px,m:grow", // columns
                "fill:200px,8px,fill:min:grow,min" // rows
        );
        FormLayout lyoCategories = new FormLayout(
                "min,min:grow", // columns
                "8px,fill:28px,fill:min:grow" // rows
        );
        FormLayout lyoAllFoods = new FormLayout(
                "min,min:grow", // columns
                "fill:28px,fill:min:grow" // rows
        );
        FormLayout lyoCategoryFoods = new FormLayout(
                "min,min:grow", // columns
                "fill:28px,fill:min:grow" // rows
        );
        FormLayout lyoButtons = new FormLayout(
                "m:grow,300px,150px,m:grow", // columns
                "min,8px" // rows
        );
        JLabel lblSearchCategories = new JLabel( "Search: " );
        JLabel lblSearchAllFoods = new JLabel( "Search: " );
        JLabel lblSearchFoodsInCategory = new JLabel( "Search: " );
        JButton btnAddCategory = new JButton( "+" );
        JButton btnDeleteCategory = new JButton( "-" );
        JButton btnRenameCategory = new JButton( "r" );
        JButton btnDuplicateCategory = new JButton( "d" );
        JButton btnExportCategory = new JButton( "e" );
        JButton btnAddFoodToCategory = new JButton( "+" );
        JButton btnDeleteFoodFromCategory = new JButton( "-" );
        JPopupMenu pmn = new JPopupMenu();
        JMenuItem mniFoodCategories = new JMenuItem( "Show food categories" );
        pnlCategories.setLayout( lyoCategories );
        pnlCategoryFoods.setLayout( lyoCategoryFoods );
        lblSearchCategories.setToolTipText(
                "Search field input should be a valid regex expression (case insensitive match)" );
        lblSearchAllFoods.setToolTipText(
                "Search field input should be a valid regex expression (case insensitive match)" );
        lblSearchFoodsInCategory.setToolTipText(
                "Search field input should be a valid regex expression (case insensitive match)" );
        pnlCategoryButtons.add( btnAddCategory );
        pnlCategoryButtons.add( btnDeleteCategory );
        pnlCategoryButtons.add( btnRenameCategory );
        pnlCategoryButtons.add( btnDuplicateCategory );
        pnlCategoryButtons.add( btnExportCategory );
        pnlCategoryButtons.setBorder( new TitledBorder( "Category" ) );
        pnlButtons.setLayout( lyoButtons );
        pnlButtons.add( pnlCategoryButtons, cc.xy( 2, 1 ) );
        pnlButtons.add( pnlFoodButtons, cc.xy( 3, 1 ) );
        pnlFoodButtons.add( btnAddFoodToCategory );
        pnlFoodButtons.add( btnDeleteFoodFromCategory );
        pnlFoodButtons.setBorder( new TitledBorder( "Food" ) );
        btnAddCategory.setToolTipText( "Create category" );
        btnDeleteCategory.setToolTipText( "Delete category" );
        btnRenameCategory.setToolTipText( "Rename category" );
        btnDuplicateCategory.setToolTipText( "Duplicate category" );
        btnExportCategory.setToolTipText( "Export category" );
        btnAddFoodToCategory.setToolTipText( "Add food item to category" );
        btnDeleteFoodFromCategory.setToolTipText( "Remove food item from category" );
        scrFoodsInCategory.setBorder( new TitledBorder( "Category Foods" ) );
        pnlMain.setLayout( lyoMain );
        pnlAllFoods.setLayout( lyoAllFoods );
        pnlCategories.add( lblSearchCategories, cc.xy( 1, 2 ) );
        pnlCategories.add( txtSearchCategories, cc.xy( 2, 2 ) );
        pnlCategories.add( scrAllFoodCategories, cc.xyw( 1, 3, 2 ) );
        pnlCategoryFoods.add( lblSearchFoodsInCategory, cc.xy( 1, 1 ) );
        pnlCategoryFoods.add( txtSearchFoodsInCategory, cc.xy( 2, 1 ) );
        pnlCategoryFoods.add( scrFoodsInCategory, cc.xyw( 1, 2, 2 ) );
        pnlAllFoods.add( lblSearchAllFoods, cc.xy( 1, 1 ) );
        pnlAllFoods.add( txtSearchAllFoods, cc.xy( 2, 1 ) );
        pnlAllFoods.add( scrAllFoods, cc.xyw( 1, 2, 2 ) );
        pnlMain.add( pnlCategories, cc.xyw( 1, 1, 3 ) );
        pnlMain.add( pnlAllFoods, cc.xy( 1, 3 ) );
        pnlMain.add( pnlCategoryFoods, cc.xy( 3, 3 ) );
        pnlMain.add( pnlButtons, cc.xyw( 1, 4, 3 ) );
        try {
            Future<List<List>> task = BackgroundExec.submit( new FoodCategoriesTask() );
            List<List> foodcategories = task.get();
            tblAllFoodCategories.reload( foodcategories );
        } catch ( Exception e ) {
            LoggerImpl.INSTANCE.logProblem( e );
        }
        btnAddCategory.addActionListener( ( ActionEvent evt ) -> {
            addCategory();
        } );
        btnRenameCategory.addActionListener( ( ActionEvent evt ) -> {
            renameCategory();
        } );
        btnDeleteCategory.addActionListener( ( ActionEvent evt ) -> {
            deleteCategory();
        } );
        btnDuplicateCategory.addActionListener( ( ActionEvent evt ) -> {
            duplicateCategory();
        } );
        btnExportCategory.addActionListener( ( ActionEvent evt ) -> {
            exportCategory();
        } );
        tblAllFoodCategories.getSelectionModel().addListSelectionListener( ( ListSelectionEvent a ) -> {
            if ( a.getValueIsAdjusting() ) {
                return;
            }
            if ( tblAllFoodCategories.isSelectionEmpty() ) {
                return;
            }
            TableCategory.Row category = tblAllFoodCategories.getSelectedValue();
            try {
                Future<List<List>> task = BackgroundExec.submit( new FoodsInCategoryTask( ( category.getCategoryid() ) ) );
                List<List> categoryFoods = task.get();
                tblFoodsInCategory.reload( categoryFoods );
            } catch ( Exception e ) {
                LoggerImpl.INSTANCE.logProblem( e );
            }
        } );
        btnAddFoodToCategory.addActionListener( ( ActionEvent evt ) -> {
            addFoodToCategory();
        } );
        btnDeleteFoodFromCategory.addActionListener( ( ActionEvent evt ) -> {
            removeFoodFromCategory();
        } );
        pmn.add( mniFoodCategories );
        mniFoodCategories.addActionListener( ( ActionEvent evt ) -> {
            if ( !tblAllFoods.isSelectionEmpty() ) {
                TableFood.Row food = tblAllFoods.getSelectedValue();
                try {
                    Future<List<List>> task = BackgroundExec.submit( new FoodsInCategoryTask02( ( food.getFoodid() ) ) );
                    List<List> categoryFoods = task.get();
                    tblParentCategories.reload( categoryFoods );
                } catch ( Exception e ) {
                    LoggerImpl.INSTANCE.logProblem( e );
                }
                JPanel input_panel = new JPanel();
                input_panel.add( scrParentCategories );
                scrParentCategories.setPreferredSize( new Dimension( 200, 100 ) );
                JComponent[] inputs = { input_panel };
                Message.showMessage( inputs, "Food Categories" );
            } else {
                Message.showMessage( "Please select food item" );
            }
        } );
        tblAllFoods.addMouseListener( new MouseAdapter() {
            @Override
            public void mouseClicked( MouseEvent e ) {
                super.mouseClicked( e );
                if ( SwingUtilities.isRightMouseButton( e ) ) {
                    Component component = e.getComponent();
                    pmn.show( component, e.getX(), e.getY() );
                }
            }
        } );
        return pnlMain;
    }


    private JPanel getFoodComparisonPanel() {
        JPanel pnl = new JPanel();
        tblFoodDiffA = new TableFood();
        tblFoodDiffB = new TableFood();
        tblFoodDiff = new TableFoodDiff();
        JScrollPane scrC = new JScrollPane( tblFoodDiff );
        JPanel pnlSearch = new JPanel();
        JLabel lblSearch = new JLabel( "Search: " );
        lblSearch.setToolTipText( "Search field input should be a valid regex expression (case insensitive match)" );
        FormLayout lyo = new FormLayout(
                "4px,391px:grow,4px,391px:grow,4px,678px:grow,4px", // columns
                "min,fill:min:grow,4px" // rows
        );
        FormLayout lyo02 = new FormLayout(
                "min,min:grow", // columns
                "4dlu,fill:28px,4dlu" // rows
        );
        JPanel pnlFoodAList = new JPanel();
        JPanel pnlFoodBList = new JPanel();
        FormLayout lyo03 = new FormLayout(
                "min,min:grow", // columns
                "4dlu,fill:28px,4dlu,fill:min:grow" // rows
        );
        pnlFoodAList.setLayout( lyo03 );
        JScrollPane scrA = new JScrollPane( tblFoodDiffA );
        scrA.setBorder( new TitledBorder( "Food A" ) );
        JLabel lblA = new JLabel( "Search: " );
        lblA.setToolTipText( "Search field input should be a valid regex expression (case insensitive match)" );
        pnlFoodAList.add( lblA, cc.xy( 1, 2 ) );
        JTextField txtComparisonFoodASearch = tblFoodDiffA.getTxtSearch();
        pnlFoodAList.add( txtComparisonFoodASearch, cc.xy( 2, 2 ) );
        pnlFoodAList.add( scrA, cc.xyw( 1, 4, 2 ) );
        pnlFoodBList.setLayout( lyo03 );
        JScrollPane scrB = new JScrollPane( tblFoodDiffB );
        scrB.setBorder( new TitledBorder( "Food B" ) );
        JLabel lblB = new JLabel( "Search: " );
        lblB.setToolTipText( "Search field input should be a valid regex expression (case insensitive match)" );
        pnlFoodBList.add( lblB, cc.xy( 1, 2 ) );
        JTextField txtComparisonFoodBSearch = tblFoodDiffB.getTxtSearch();
        pnlFoodBList.add( txtComparisonFoodBSearch, cc.xy( 2, 2 ) );
        pnlFoodBList.add( scrB, cc.xyw( 1, 4, 2 ) );
        pnl.setLayout( lyo );
        pnl.add( pnlFoodAList, cc.xywh( 2, 1, 1, 2 ) );
        pnl.add( pnlFoodBList, cc.xywh( 4, 1, 1, 2 ) );
        pnlSearch.setLayout( lyo02 );
        lblSearch.setHorizontalAlignment( SwingConstants.RIGHT );
        pnlSearch.add( lblSearch, cc.xy( 1, 2 ) );
        pnlSearch.add( tblFoodDiff.getSearchField(), cc.xy( 2, 2 ) );
        pnl.add( pnlSearch, cc.xy( 6, 1 ) );
        pnl.add( scrC, cc.xy( 6, 2 ) );
        scrC.setBorder( new TitledBorder( "Food Difference" ) );
        tblFoodDiffA.getSelectionModel().addListSelectionListener( ( ListSelectionEvent e ) -> {
            calculateFoodDifference( e );
        } );
        tblFoodDiffB.getSelectionModel().addListSelectionListener( ( ListSelectionEvent e ) -> {
            calculateFoodDifference( e );
        } );
        return pnl;
    }


    private void calculateFoodDifference( ListSelectionEvent e ) {
        if ( e.getValueIsAdjusting() ) {
            return;
        }
        if ( tblFoodDiffA.isSelectionEmpty() ) {
            return;
        }
        if ( tblFoodDiffB.isSelectionEmpty() ) {
            return;
        }
        int selectedRowA = tblFoodDiffA.getSelectedRow();
        int selectedRowB = tblFoodDiffB.getSelectedRow();
        String fooddiffida = ( String ) tblFoodDiffA.getValueAt( selectedRowA, 0 );
        String fooddiffidb = ( String ) tblFoodDiffB.getValueAt( selectedRowB, 0 );
        try {
            Future<List<List>> task = BackgroundExec.submit( new FoodDiffTask( fooddiffida, fooddiffidb ) );
            List<List> diff = task.get();
            tblFoodDiff.reload( diff );
        } catch ( Exception ex ) {
            LoggerImpl.INSTANCE.logProblem( ex );
        }
    }


    private JPanel getFoodQuantityConstraint() {
        JPanel pnl = new JPanel();
        FormLayout panelLayout = new FormLayout(
                "p,p,p:grow,p", // columns
                "p,p,fill:p:grow,min" // rows
        );
        pnl.setLayout( panelLayout );
        tblFoodQuantityConstraint = new TableFoodQuantityConstraint();
        JScrollPane spTable = new JScrollPane( tblFoodQuantityConstraint );
        Integer width = TableColumnWidth.Food.getWidth()
                + TableColumnWidth.Nutrient.getWidth()
                + 21
                + 90
                + TableColumnWidth.Scrollbar.getWidth();
        spTable.setPreferredSize( new Dimension( width, 0 ) );
        JPanel buttons = new JPanel();
        txtFoodQuantityValue.setPreferredSize( Dimensions.Quantity.get() );
        pnl.add( cmbFoodQuantityFood, cc.xyw( 1, 1, 3 ) );
        pnl.add( btnBlock, cc.xy( 4, 1 ) );
        pnl.add( cmbFoodQuantityNutrient, cc.xy( 1, 2 ) );
        pnl.add( cmbFoodQuantityRelationship, cc.xy( 2, 2 ) );
        pnl.add( txtFoodQuantityValue, cc.xyw( 3, 2, 2 ) );
        pnl.add( spTable, cc.xyw( 1, 3, 4 ) );
        buttons.add( btnAddFoodQuantityConstraint );
        buttons.add( btnDeleteFoodQuantityConstraint );
        pnl.add( buttons, cc.xyw( 1, 4, 4 ) );
        spTable.setBorder( new TitledBorder( "Food Nutrient Constraints" ) );
        cmbFoodQuantityNutrient.setMaximumRowCount( 10 );
        cmbFoodQuantityRelationship.setMaximumRowCount( 3 );
        cmbFoodQuantityFood.setMaximumRowCount( 10 );
        btnAddFoodQuantityConstraint.setToolTipText( "Add Constraint" );
        btnDeleteFoodQuantityConstraint.setToolTipText( "Delete Constraint" );
        btnAddFoodQuantityConstraint.addActionListener( ( ActionEvent evt ) -> {
            addFoodQuantityConstraint();
        } );
        btnDeleteFoodQuantityConstraint.addActionListener( ( ActionEvent evt ) -> {
            if ( tblFoodQuantityConstraint.isSelectionEmpty() ) {
                return;
            }
            deleteFoodQuantityConstraint();
        } );
        btnBlock.addActionListener( ( ActionEvent evt ) -> {
            blockFood();
        } );
        tblFoodQuantityConstraint.getSelectionModel().addListSelectionListener( ( ListSelectionEvent e ) -> {
            if ( e.getValueIsAdjusting() ) {
                return;
            }
            if ( tblFoodQuantityConstraint.isSelectionEmpty() ) {
                return;
            }
            setFoodQuantityConstraintGuiValues();
        } );
        JPopupMenu pmn = new JPopupMenu();
        JMenuItem item01 = new JMenuItem( "Plus" );
        pmn.add( item01 );
        item01.addActionListener( ( ActionEvent evt ) -> {
            if ( txtFoodQuantityValue.getText().isBlank() ) {
                return;
            }
            Double total = plusQuantity( Double.valueOf( txtFoodQuantityValue.getText() ) );
            txtFoodQuantityValue.setText( String.valueOf( total ) );
        } );
        txtFoodQuantityValue.addMouseListener( new MouseAdapter() {
            @Override
            public void mouseClicked( MouseEvent e ) {
                super.mouseClicked( e );
                showPopup( e, pmn );
            }
        } );
        return pnl;
    }


    private JPanel getFoodList() {
        JPanel pnl = new JPanel();
        FormLayout paneLayout = new FormLayout(
                "4px,min:grow,4px,min,4px", // columns
                "min,fill:min:grow,4px,min,4px" // rows
        );
        pnl.setLayout( paneLayout );
        JPanel searchPanel = new JPanel();
        FormLayout searchPanelLayout = new FormLayout(
                "min,min:grow", // columns
                "4px,fill:28px,4px" // rows
        );
        searchPanel.setLayout( searchPanelLayout );
        JPanel buttonPanel = new JPanel();
        FormLayout buttonPanelLayout = new FormLayout(
                "min:grow,min,min,min,min,min:grow", // columns
                "min" // rows
        );
        buttonPanel.setLayout( buttonPanelLayout );
        tblFoodFacts = new TableFoodFacts();
        NutrientCategorySelector selectorFoodFactsTable = new NutrientCategorySelector( tblFoodFacts );
        selectorFoodFactsTable.setSelected( Nutrients.Calories );
        JScrollPane scrollPaneTable01 = new JScrollPane( tblFoodFacts );
        scrollPaneTable01.setToolTipText( "A new food item is generated everytime a food nutrient quantity is updated." );
        scrollPaneTable01.getViewport().setScrollMode( JViewport.BLIT_SCROLL_MODE );
        JLabel label = new JLabel( "Search: " );
        label.setToolTipText( "Search field input should be a valid regex expression (case insensitive match)" );
        label.setHorizontalAlignment( SwingConstants.RIGHT );
        searchPanel.add( label, cc.xy( 1, 2 ) );
        searchPanel.add( tblFoodFacts.getTxtSearch(), cc.xy( 2, 2 ) );
        buttonPanel.add( btnAddFood, cc.xy( 2, 1 ) );
        buttonPanel.add( btnUpdateFood, cc.xy( 3, 1 ) );
        buttonPanel.add( btnRenameFood, cc.xy( 4, 1 ) );
        buttonPanel.add( btnDeleteFood, cc.xy( 5, 1 ) );
        pnl.add( searchPanel, cc.xyw( 2, 1, 2 ) );
        pnl.add( scrollPaneTable01, cc.xy( 2, 2 ) );
        pnl.add( selectorFoodFactsTable, cc.xy( 4, 2 ) );
        pnl.add( buttonPanel, cc.xyw( 2, 4, 3 ) );
        scrollPaneTable01.setBorder( new TitledBorder( "Food List" ) );
        btnAddFood.setToolTipText( "Add food item" );
        btnUpdateFood.setToolTipText( "Update food item" );
        btnRenameFood.setToolTipText( "Rename food item" );
        btnDeleteFood.setToolTipText( "Delete food item" );
        btnAddFood.addActionListener( ( ActionEvent evt ) -> {
            addFoodToDatabase();
        } );
        btnUpdateFood.addActionListener( ( ActionEvent evt ) -> {
            addDerivativeFoodToDatabase();
        } );
        btnRenameFood.addActionListener( ( ActionEvent evt ) -> {
            renameFood();
        } );
        btnDeleteFood.addActionListener( ( ActionEvent evt ) -> {
            removeFoodFromDatabase();
        } );
        tblFoodFacts.getSelectionModel().addListSelectionListener( ( ListSelectionEvent e ) -> {
            if ( e.getValueIsAdjusting() ) {
                return;
            }
            if ( tblFoodFacts.isSelectionEmpty() ) {
            }
        } );
        JPopupMenu pmn = new JPopupMenu();
        JMenuItem mniFoodStats = new JMenuItem( "Show food statistics" );
        pmn.add( mniFoodStats );
        mniFoodStats.addActionListener( ( ActionEvent evt ) -> {
            if ( !tblFoodFacts.isSelectionEmpty() ) {
                TableFoodFacts.Row food = tblFoodFacts.getSelectedValue();
                showFoodStats( food.getId_food_id() );
            } else {
                Message.showMessage( "Please select food item" );
            }
        } );
        tblFoodFacts.addMouseListener( new MouseAdapter() {
            @Override
            public void mouseClicked( MouseEvent e ) {
                super.mouseClicked( e );
                if ( SwingUtilities.isRightMouseButton( e ) ) {
                    Component component = e.getComponent();
                    pmn.show( component, e.getX(), e.getY() );
                }
            }
        } );
        return pnl;
    }


    private JPanel getFoodRatioPanel() {
        JPanel pnl = new JPanel();
        tblFoodRatioConstraint = new TableFoodRatioConstraint();
        JScrollPane scrTable = new JScrollPane( tblFoodRatioConstraint );
        JPanel buttons = new JPanel();
        FormLayout panelLayout = new FormLayout(
                "p,p,p,p:grow", // columns
                "p,p,p,p,fill:min:grow,min" // rows
        );
        pnl.setLayout( panelLayout );
        Integer width = TableColumnWidth.Food.getWidth()
                + TableColumnWidth.Nutrient.getWidth()
                + 21
                + 90
                + TableColumnWidth.Scrollbar.getWidth();
        scrTable.setBorder( new TitledBorder( "Food Nutrient Ratio Constraints" ) );
        scrTable.setPreferredSize( new Dimension( width, 0 ) );
        txtFoodNutrientRatioQuantityA.setPreferredSize( Dimensions.Quantity.get() );
        txtFoodNutrientRatioQuantityB.setPreferredSize( Dimensions.Quantity.get() );
        pnl.add( cmbFoodRatioFoodA, cc.xyw( 1, 1, 4 ) );
        pnl.add( cmbFoodRatioNutrientA, cc.xy( 1, 2 ) );
        pnl.add( txtFoodNutrientRatioQuantityA, cc.xy( 2, 2 ) );
        pnl.add( cmbFoodRatioRelationship, cc.xy( 3, 2 ) );
        pnl.add( cmbFoodRatioFoodB, cc.xyw( 1, 3, 4 ) );
        pnl.add( cmbFoodRatioNutrientB, cc.xy( 1, 4 ) );
        pnl.add( txtFoodNutrientRatioQuantityB, cc.xy( 2, 4 ) );
        pnl.add( scrTable, cc.xyw( 1, 5, 4 ) );
        buttons.add( btnAddFoodRatioConstraint );
        buttons.add( btnDeleteFoodRatioConstraint );
        pnl.add( buttons, cc.xyw( 1, 6, 4 ) );
        cmbFoodRatioNutrientA.setMaximumRowCount( 10 );
        cmbFoodRatioNutrientB.setMaximumRowCount( 10 );
        cmbFoodRatioFoodA.setMaximumRowCount( 10 );
        cmbFoodRatioFoodB.setMaximumRowCount( 10 );
        btnAddFoodRatioConstraint.setToolTipText( "Add Constraint" );
        btnDeleteFoodRatioConstraint.setToolTipText( "Delete Constraint" );
        btnAddFoodRatioConstraint.addActionListener( ( ActionEvent evt ) -> {
            addFoodRatioConstraint();
        } );
        btnDeleteFoodRatioConstraint.addActionListener( ( ActionEvent evt ) -> {
            if ( tblFoodRatioConstraint.isSelectionEmpty() ) {
                return;
            }
            deleteFoodRatioConstraint();
        } );
        tblFoodRatioConstraint.getSelectionModel().addListSelectionListener( ( ListSelectionEvent e ) -> {
            if ( e.getValueIsAdjusting() ) {
                return;
            }
            if ( tblFoodRatioConstraint.isSelectionEmpty() ) {
                return;
            }
            setFoodRatioConstraintGuiValues();
        } );
        return pnl;
    }


    private JPanel getMealPlanUsagePanel() {
        JPanel pnl = new JPanel();
        FormLayout lyo = new FormLayout(
                "p:grow", // columns
                "fill:min:grow" // rows
        );
        pnl.setLayout( lyo );
        JSplitPane spl00 = new JSplitPane();
        JSplitPane spl01 = new JSplitPane();
        spl00.setLeftComponent( getMealPlanUsageMixesPanel() );
        spl00.setRightComponent( getMealPlanUsageDaysPanel() );
        spl01.setLeftComponent( spl00 );
        spl01.setRightComponent( getMealPlanUsageResultPanel() );
        pnl.add( spl01, cc.xy( 1, 1 ) );
        exectureMealPlanUsageTasks();
        return pnl;
    }


    private void exectureMealPlanUsageTasks() {
        try {
            Future<List<List>> task = BackgroundExec.submit( new MealPlanUsageTask() );
            List<List> usage = task.get();
            tblMealPlanUsage.reload( usage );
        } catch ( Exception e ) {
            LoggerImpl.INSTANCE.logProblem( e );
        }
        try {
            Future<List<List>> task = BackgroundExec.submit( new MealPlanUsageResultsTask() );
            List<List> results = task.get();
            tblMealPlanUsageResults.reload( results );
        } catch ( Exception e ) {
            LoggerImpl.INSTANCE.logProblem( e );
        }
    }


    private JPanel getMealsPanel() {
        JPanel pnl = new JPanel();
        FormLayout lyo = new FormLayout(
                "p:grow", // columns
                "fill:min:grow,min" // rows
        );
        pnl.setLayout( lyo );
        tblMeals = new TablePortionMeals();
        JScrollPane spTable = new JScrollPane( tblMeals );
        spTable.setPreferredSize( Dimensions.D1.get() );
        JPanel buttons = new JPanel();
        pnl.add( spTable, cc.xy( 1, 1 ) );
        buttons.add( btnAddMeal );
        buttons.add( btnDeleteMeal );
        buttons.add( btnUpdateMeal );
        pnl.add( buttons, cc.xy( 1, 2 ) );
        spTable.setBorder( new TitledBorder( "Meals" ) );
        btnAddMeal.setToolTipText( "Add Meal" );
        btnDeleteMeal.setToolTipText( "Delete Meal" );
        btnUpdateMeal.setToolTipText( "Update Meal" );
        btnAddMeal.addActionListener( ( ActionEvent evt ) -> {
            addMeal();
        } );
        btnDeleteMeal.addActionListener( ( ActionEvent evt ) -> {
            deleteMeal();
        } );
        btnUpdateMeal.addActionListener( ( ActionEvent evt ) -> {
            updateMeal();
        } );
        return pnl;
    }


    private JPanel getMealCaloriesPanel() {
        JPanel pnl = new JPanel();
        ColumnBuild columns = new ColumnBuild();
        columns.add( 803 );
        RowBuild rows = new RowBuild();
        rows.add( RowBuild.rowAlignment.FILL, RowBuild.componentSize.MIN, RowBuild.resizeBehavior.GROW );
        FormLayout lyo = new FormLayout( columns.get(), rows.get() );
        pnl.setLayout( lyo );
        tblMealCalories = new TableMealCalories();
        JScrollPane spTable = new JScrollPane( tblMealCalories );
        pnl.add( spTable, cc.xy( 1, 1 ) );
        return pnl;
    }


    private JPanel getMealMacronutrientsPanel() {
        JPanel pnl = new JPanel();
        ColumnBuild columns = new ColumnBuild();
        columns.add( 878 );
        RowBuild rows = new RowBuild();
        rows.add( RowBuild.rowAlignment.FILL, RowBuild.componentSize.MIN, RowBuild.resizeBehavior.GROW );
        FormLayout lyo = new FormLayout( columns.get(), rows.get() );
        pnl.setLayout( lyo );
        tblMealMacronutrients = new TableMealGrams();
        JScrollPane spTable = new JScrollPane( tblMealMacronutrients );
        pnl.add( spTable, cc.xy( 1, 1 ) );
        return pnl;
    }


    private JPanel getMealPortionsPanel() {
        JPanel pnl = new JPanel();
        tblMealPortions = new TablePortion();
        ColumnBuild columns = new ColumnBuild();
        columns.add( ColumnBuild.componentSize.PREF );
        columns.add( ColumnBuild.componentSize.PREF );
        columns.add( ColumnBuild.componentSize.PREF );
        columns.add( 800 );
        columns.add( ColumnBuild.componentSize.PREF );
        columns.add( ColumnBuild.componentSize.PREF );
        columns.add( ColumnBuild.componentSize.PREF );
        RowBuild rows = new RowBuild();
        rows.add( RowBuild.rowAlignment.FILL, 28 );
        rows.add( RowBuild.rowAlignment.FILL, 200 );
        rows.add( RowBuild.rowAlignment.FILL, 28 );
        rows.add( RowBuild.rowAlignment.FILL, RowBuild.componentSize.MIN, RowBuild.resizeBehavior.GROW );
        rows.add( RowBuild.componentSize.PREF );
        FormLayout lyo = new FormLayout( columns.get(), rows.get() );
        pnl.setLayout( lyo );
        JScrollPane spPortions = new JScrollPane( tblMealPortions );
        JPanel buttons = new JPanel();
        txtTotalPct.setEditable( false );
        txtTotalPct.setPreferredSize( Dimensions.Pct.get() );
        txtPortionPct.setPreferredSize( Dimensions.Pct.get() );
        JLabel lblSearch = new JLabel( "Search: " );
        lblSearch.setToolTipText( "Search field input should be a valid regex expression (case insensitive match)" );
        lblSearch.setHorizontalAlignment( SwingConstants.RIGHT );
        JLabel lblPortionPct = new JLabel( "Portion: " );
        JLabel lblPortionPct2 = new JLabel( "% " );
        lblPortionPct.setHorizontalAlignment( SwingConstants.RIGHT );
        JLabel lblAllocatedPct = new JLabel( " Allocated: " );
        lblAllocatedPct.setHorizontalAlignment( SwingConstants.RIGHT );
        JLabel lblTotalPct2 = new JLabel( "%" );
        buttons.add( btnAddPortion );
        buttons.add( btnDeletePortion );
        buttons.add( btnUpdatePortionWeight );
        pnl.add( lblPortionPct, cc.xy( 1, 1 ) );
        pnl.add( txtPortionPct, cc.xy( 2, 1 ) );
        pnl.add( lblPortionPct2, cc.xy( 3, 1 ) );
        pnl.add( cmbPortionFood, cc.xy( 4, 1 ) );
        pnl.add( lblAllocatedPct, cc.xy( 5, 1 ) );
        pnl.add( txtTotalPct, cc.xy( 6, 1 ) );
        pnl.add( lblTotalPct2, cc.xy( 7, 1 ) );
        pnl.add( getMealsPanel(), cc.xyw( 1, 2, 7 ) );
        pnl.add( lblSearch, cc.xy( 1, 3 ) );
        pnl.add( tblMealPortions.getSearchField(), cc.xyw( 2, 3, 6 ) );
        pnl.add( spPortions, cc.xyw( 1, 4, 7 ) );
        pnl.add( buttons, cc.xyw( 1, 5, 7 ) );
        spPortions.setBorder( new TitledBorder( "Food Portions" ) );
        cmbPortionFood.setMaximumRowCount( 6 );
        btnAddPortion.setToolTipText( "Add one or more food portions" );
        btnDeletePortion.setToolTipText( "Delete one or more food portions" );
        btnUpdatePortionWeight.setToolTipText( "Update weight of food portion consumed" );
        btnAddPortion.addActionListener( ( ActionEvent evt ) -> {
            addFoodPortion();
        } );
        btnDeletePortion.addActionListener( ( ActionEvent evt ) -> {
            deleteFoodPortion();
        } );
        btnUpdatePortionWeight.addActionListener( ( ActionEvent evt ) -> {
            updateFoodPortionWeight();
        } );
        cmbPortionFood.addActionListener( ( ActionEvent evt ) -> {
            calculateRemainingFoodAllocationPercentage();
        } );
        JPopupMenu pmn = new JPopupMenu();
        JMenuItem item01 = new JMenuItem( "Assign portion to meal" );
        pmn.add( item01 );
        item01.addActionListener( ( ActionEvent evt ) -> {
            moveFoodPortion();
        } );
        tblMealPortions.addMouseListener( new MouseAdapter() {
            @Override
            public void mouseClicked( MouseEvent e ) {
                super.mouseClicked( e );
                showPopup( e, pmn );
            }
        } );
        return pnl;
    }


    private JMenuBar getMenuBar() {
        JMenuBar mnuBar = new JMenuBar();
        mnuBar.add( mnuProgram );
        mnuBar.add( mnuMix );
        mnuBar.add( mnuTools );
        mnuBar.add( mnuData );
        mnuBar.add( mnuReport );
        mnuBar.add( mnuHelp );
        mnuProgram.add( mnuSettings );
        mnuProgram.add( mniExit );
        mnuTools.add( mniConvertDRI );
        mnuTools.add( mniCalculateBMR );
        mnuTools.add( mniCalculateProteinRequired );
        mnuTools.add( mniShowCarbohydrateRequired );
        mnuTools.add( mniCalculateDigestibleCarbs );
        mnuTools.add( mniCalculateGL );
        mnuTools.add( mniCalculateGIRange );
        mnuTools.add( mniCalculateALARequired );
        mnuData.add( mnuFoodsData );
        mnuData.add( mnuMixModel );
        mnuData.add( mnuDELETE );
        mnuReport.add( mniCreateMixTotalsReport );
        mnuReport.add( mniCreateMixResultsReport1 );
        mnuReport.add( mniCreateMixResultsReport2 );
        mnuReport.add( mniCreateMixDriReport );
        mnuReport.add( mniCreateMixComparisonReport );
        mnuReport.add( mniCreateMealPlanPortionsReport );
        mnuReport.add( mniCreateMealPlanCaloriesReport );
        mnuReport.add( mniCreateMealPlanMacronutrientsReport );
        mnuReport.add( mniCreateMealPlanUsageReport );
        mnuReport.add( mniCreateNutrientSearchReport );
        mnuReport.add( mniCreateFoodComparisonReport );
        mnuReport.add( mniCreateAllFoodsReport1 );
        mnuReport.add( mniCreateAllFoodsReport2 );
        mnuDELETE.add( mniDELETEMIXES );
        mnuDELETE.add( mniDELETEALL );
        mnuMixModel.add( mniImportMixModel );
        mnuMixModel.add( mniExportMixModel );
        mnuFoodsData.add( mniImportFoods );
        mnuHelp.add( mniAbout );
        mnuSettings.add( chkResultRoundUp );
        mnuSettings.add( chkLpsolve );
        mnuSettings.add( mniSetConstraints );
        mnuMix.add( mniCreateMix );
        mnuMix.add( mniDeleteMix );
        mnuMix.add( mniRenameMix );
        mnuMix.add( mniDuplicateMix );
        mnuMix.add( mniPinMixAndDeleteConstraints );
        mnuMix.add( mniPinMixAndKeepConstraints );
        mnuMix.add( mniConvertMix );
        mnuMix.add( mniShowMixStats );
        mnuProgram.setText( "Program" );
        mnuMix.setText( "Mix" );
        mnuTools.setText( "Tools" );
        mnuData.setText( "Data" );
        mnuData.setToolTipText( "Find your documents in snack's model directory" );
        mnuHelp.setText( "Help" );
        mnuSettings.setText( "Settings" );
        mniExit.setText( "Exit" );
        mniConvertDRI.setText( "Convert daily value (%DV) required to grams" );
        mniCalculateBMR.setText( "Calculate basal metabolic rate of an individual" );
        mniCalculateProteinRequired.setText( "Calculate complete protein required in a no fat, no carbohydrate regimen" );
        mniShowCarbohydrateRequired.setText( "Show carbohydrate required to inhibit ketosis" );
        mniCalculateDigestibleCarbs.setText( "Calculate digestible carbohydrate of a food item" );
        mniCalculateGL.setText( "Calculate glycemic load of a food item" );
        mniCalculateALARequired.setText( "Calculate alpha-linolenic acid required" );
        mniCalculateGIRange.setText( "Show glycemic index range of a food item" );
        mnuReport.setText( "Reports" );
        mnuMixModel.setText( "Model" );
        mnuMixResult.setText( "Result" );
        mnuFoodsData.setText( "Food" );
        mniCreateAllFoodsReport1.setText( "All Foods #1" );
        mniCreateAllFoodsReport2.setText( "All Foods #2" );
        mniCreateFoodComparisonReport.setText( "Food Comparison" );
        mniCreateMixDriReport.setText( "Mix Daily Reference Intake" );
        mniCreateMixComparisonReport.setText( "Mix Comparison" );
        mniCreateMixTotalsReport.setText( "Mix Totals" );
        mniCreateMixResultsReport1.setText( "Mix Results #1" );
        mniCreateMixResultsReport2.setText( "Mix Results #2" );
        mniCreateNutrientSearchReport.setText( "Nutrient Search" );
        mniCreateMealPlanCaloriesReport.setText( "Meal Plan Calories" );
        mniCreateMealPlanMacronutrientsReport.setText( "Meal Plan Macronutrients" );
        mniCreateMealPlanPortionsReport.setText( "Meal Plan Portions" );
        mniCreateMealPlanUsageReport.setText( "Meal Plan Usage" );
        mniImportMixModel.setText( "Import" );
        mniExportMixModel.setText( "Export" );
        mniImportFoods.setText( "Import" );
        chkResultRoundUp.setText( "Round up result values" );
        chkLpsolve.setText( "Write model in LPSOLVE format" );
        mniSetConstraints.setText( "Choose constraints" );
        mniAbout.setText( "About" );
        mniCreateMix.setText( "Create mix" );
        mniDeleteMix.setText( "Delete mix" );
        mniRenameMix.setText( "Rename mix" );
        mniDuplicateMix.setText( "Duplicate mix" );
        mniPinMixAndDeleteConstraints.setText( "Pin mix and delete constraints" );
        mniPinMixAndKeepConstraints.setText( "Pin mix and keep constraints" );
        mniConvertMix.setText( "Convert mix to food item" );
        mniShowMixStats.setText( "Show mix statistics" );
        mnuDELETE.setText( "DELETE" );
        mniDELETEMIXES.setText( "DELETE ALL MIXES" );
        mniDELETEALL.setText( "DELETE ALL MIXES AND ALL FOOD ITEMS" );
        chkResultRoundUp.setSelected( true );
        mniConvertDRI.addActionListener( ( ActionEvent evt ) -> {
            convertMicronutrient();
        } );
        mniCalculateBMR.addActionListener( ( ActionEvent evt ) -> {
            calculateBmr();
        } );
        mniCalculateProteinRequired.addActionListener( ( ActionEvent evt ) -> {
            calculateProteinNeededForNitrogenBalance();
        } );
        mniShowCarbohydrateRequired.addActionListener( ( ActionEvent evt ) -> {
            showKetosis();
        } );
        mniCalculateDigestibleCarbs.addActionListener( ( ActionEvent evt ) -> {
            calculateDigestibleCarbs();
        } );
        mniCalculateGL.addActionListener( ( ActionEvent evt ) -> {
            calculateGlycemicLoad();
        } );
        mniCalculateALARequired.addActionListener( ( ActionEvent evt ) -> {
            calculateN3FattyAcidRequired();
        } );
        mniShowMixStats.addActionListener( ( ActionEvent evt ) -> {
            showMixStats();
        } );
        mniCalculateGIRange.addActionListener( ( ActionEvent evt ) -> {
            calculateGlycemicIndexRange();
        } );
        mniCreateAllFoodsReport1.addActionListener( ( ActionEvent evt ) -> {
            createAllFoodsReport1();
        } );
        mniCreateAllFoodsReport2.addActionListener( ( ActionEvent evt ) -> {
            createAllFoodsReport2();
        } );
        mniCreateFoodComparisonReport.addActionListener( ( ActionEvent evt ) -> {
            if ( tblFoodDiffA.isSelectionEmpty() || tblFoodDiffB.isSelectionEmpty() ) {
                Message.showMessage( "You need to select two food items to compare first." );
                return;
            }
            createFoodComparisonReport();
            Message.showMessage( "Food Comparison Report created." );
        } );
        mniCreateMixComparisonReport.addActionListener( ( ActionEvent evt ) -> {
            if ( tblMixDiffA.isSelectionEmpty() || tblMixDiffB.isSelectionEmpty() ) {
                Message.showMessage( "You need to select two mixes to compare first." );
                return;
            }
            createMixComparisonReport();
            Message.showMessage( "Mix Comparison Report created." );
        } );
        mniCreateMixTotalsReport.addActionListener( ( ActionEvent evt ) -> {
            createMixTotalsReport();
            Message.showMessage( "Mix Totals Report appended." );
        } );
        mniCreateMixResultsReport1.addActionListener( ( ActionEvent evt ) -> {
            createMixResultsReport1();
            Message.showMessage( "Mix Results Report #1 created." );
        } );
        mniCreateMixResultsReport2.addActionListener( ( ActionEvent evt ) -> {
            createMixResultsReport2();
            Message.showMessage( "Mix Results Report #2 created." );
        } );
        mniCreateMixDriReport.addActionListener( ( ActionEvent evt ) -> {
            createDriReport();
            Message.showMessage( "Daily Reference Intake Report created." );
        } );
        mniCreateNutrientSearchReport.addActionListener( ( ActionEvent evt ) -> {
            if ( txtNutrientSearchQuantity.getText().isBlank() ) {
                Message.showMessage( "You need to search for food items that contain the nutrient first." );
                return;
            }
            createNutrientContentReport();
            Message.showMessage( "Nutrient Search Report created." );
        } );
        mniCreateMealPlanCaloriesReport.addActionListener( ( ActionEvent evt ) -> {
            if ( tblMealPortions.isEmpty() ) {
                Message.showMessage( "You need to create meal plan first." );
                return;
            }
            createMealPlanCaloriesReport();
            Message.showMessage( "Meal Plan Calories Report created." );
        } );
        mniCreateMealPlanMacronutrientsReport.addActionListener( ( ActionEvent evt ) -> {
            if ( tblMealPortions.isEmpty() ) {
                Message.showMessage( "You need to create meal plan first." );
                return;
            }
            createMealPlanMacronutrientsReport();
            Message.showMessage( "Meal Plan Macronutrients Report created." );
        } );
        mniCreateMealPlanPortionsReport.addActionListener( ( ActionEvent evt ) -> {
            if ( tblMealPortions.isEmpty() ) {
                Message.showMessage( "You need to create meal plan first." );
                return;
            }
            createMealPlanPortionsReport();
            Message.showMessage( "Meal Plan Portions Report created." );
        } );
        mniCreateMealPlanUsageReport.addActionListener( ( ActionEvent evt ) -> {
            if ( tblMealPlanUsage.isEmpty() ) {
                Message.showMessage( "You need to create meal plan usage first." );
                return;
            }
            createMealPlanUsageReport();
            Message.showMessage( "Meal Plan Usage Report created." );
        } );
        mniDELETEMIXES.addActionListener( ( ActionEvent evt ) -> {
            deleteAllMixes();
        } );
        mniDELETEALL.addActionListener( ( ActionEvent evt ) -> {
            deleteAll();
        } );
        mniExportMixModel.addActionListener( ( ActionEvent evt ) -> {
            exportMix();
        } );
        mniImportMixModel.addActionListener( ( ActionEvent evt ) -> {
            int returnVal = fch.showOpenDialog( frm );
            if ( returnVal == JFileChooser.APPROVE_OPTION ) {
                frm.setCursor( Cursor.getPredefinedCursor( Cursor.WAIT_CURSOR ) );
                File file = fch.getSelectedFile();
                fch.setCurrentDirectory( file );
                String path = file.getAbsolutePath();
                MixDO mix = new MixImporter().receive( path );
                String mixid = mix.getMixid();
                if ( mixid.isEmpty() ) {
                    frm.setCursor( Cursor.getPredefinedCursor( Cursor.DEFAULT_CURSOR ) );
                    return;
                }
                boolean solutionFound = solveModel( mix );
                Integer lifeStageId = mix.getLifestageid();
                try {
                    Future<List<List>> task = BackgroundExec.submit( new MixesTask() );
                    List<List> lst = task.get();
                    List<MixDO> mixesList = Utilities.createMixDOList( lst );
                    cmbMixes.reload( mixesList );
                    cmbMixes.setSelectedItem( mix );
                    LifeStageDO find
                            = LifestageFinder.find( ( ( SpinnerListModel ) spnLifestage.getModel() ).getList(), lifeStageId );
                    spnLifestage.setSelectedItem( find );
                } catch ( Exception e ) {
                    LoggerImpl.INSTANCE.logProblem( e );
                }
                reloadFoods();
                if ( !solutionFound ) {
                    frm.setCursor( Cursor.getPredefinedCursor( Cursor.DEFAULT_CURSOR ) );
                    return;
                }
                try {
                    Future<List<List>> task = BackgroundExec.submit( new MixesTask() );
                    List<List> lst = task.get();
                    tblMixDiff.clear();
                    tblMixDiffA.reload( lst );
                    tblMixDiffB.reload( lst );
                    tblMealPlanUsageMixes.reload( lst );
                } catch ( Exception e ) {
                    LoggerImpl.INSTANCE.logProblem( e );
                }
                frm.setCursor( Cursor.getPredefinedCursor( Cursor.DEFAULT_CURSOR ) );
            }
        } );
        mniImportFoods.addActionListener( ( ActionEvent evt ) -> {
            int returnVal = fch.showOpenDialog( frm );
            if ( returnVal == JFileChooser.APPROVE_OPTION ) {
                File file = fch.getSelectedFile();
                String path = file.getAbsolutePath();
                fch.setCurrentDirectory( new File( path ) );
                String schema = "/resources/schemas/foods.xsd";
                ElapsedTime time = new ElapsedTime();
                frm.setCursor( Cursor.getPredefinedCursor( Cursor.WAIT_CURSOR ) );
                time.start();
                new FoodsImporter().importFoodListUsingResource( schema, path );
                time.end();
                frm.setCursor( Cursor.getPredefinedCursor( Cursor.DEFAULT_CURSOR ) );
                StringBuilder sb = new StringBuilder();
                sb.append( "Food items were loaded in " );
                sb.append( time.getElapsedTimeInSeconds() );
                sb.append( " seconds. " );
                reloadFoods();
                setQuantityScale();
                Message.showMessage( sb.toString() );
            }
        } );
        mniAbout.addActionListener( ( ActionEvent evt ) -> {
            showAbout();
        } );
        mniSetConstraints.addActionListener( ( ActionEvent evt ) -> {
            ( new ConstraintChooser() ).show();
            reloadCbNutrientData();
        } );
        chkResultRoundUp.addActionListener( ( ActionEvent evt ) -> {
            setQuantityScale();
        } );
        mniExit.addActionListener( ( ActionEvent evt ) -> {
            exit();
        } );
        mniCreateMix.addActionListener( ( ActionEvent evt ) -> {
            createMix();
        } );
        mniDeleteMix.addActionListener( ( ActionEvent evt ) -> {
            deleteMix();
        } );
        mniRenameMix.addActionListener( ( ActionEvent evt ) -> {
            renameMix();
        } );
        mniDuplicateMix.addActionListener( ( ActionEvent evt ) -> {
            duplicateMix();
        } );
        mniConvertMix.addActionListener( ( ActionEvent evt ) -> {
            convertMixToFood();
        } );
        mniPinMixAndDeleteConstraints.addActionListener( ( ActionEvent evt ) -> {
            pinAndDelete();
        } );
        mniPinMixAndKeepConstraints.addActionListener( ( ActionEvent evt ) -> {
            pinAndKeep();
        } );
        return mnuBar;
    }


    private void exit() {
        mniExit.setEnabled( false );
        frm.setCursor( Cursor.getPredefinedCursor( Cursor.WAIT_CURSOR ) );
        BackgroundExec.execute( () -> {
            try {
                Connect.getInstance().getConnection().close();
                ( new Shutdown() ).execute();
            } catch ( Exception e ) {
            } finally {
                System.exit( 0 );
            }
        } );
    }


    private JPanel getMixComparisonPanel() {
        JPanel pnl = new JPanel();
        tblMixDiffA = new TableMix();
        tblMixDiffB = new TableMix();
        tblMixDiff = new TableMixDiff();
        JScrollPane scrA = new JScrollPane( tblMixDiffA );
        JScrollPane scrB = new JScrollPane( tblMixDiffB );
        JScrollPane scrC = new JScrollPane( tblMixDiff );
        JPanel pnlSearch = new JPanel();
        JLabel lblSearch = new JLabel( "Search: " );
        lblSearch.setToolTipText( "Search field input should be a valid regex expression (case insensitive match)" );
        // create layouts
        FormLayout lyo00 = new FormLayout(
                "4px,391px:grow,4px,391px:grow,4px,678px:grow,4px", // columns
                "4px,min,fill:min:grow,4px" // rows
        );
        FormLayout lyo01 = new FormLayout(
                "min,min:grow", // columns
                "fill:28px,4dlu" // rows
        );
        pnl.setLayout( lyo00 );
        pnl.add( scrA, cc.xywh( 2, 2, 1, 2 ) );
        pnl.add( scrB, cc.xywh( 4, 2, 1, 2 ) );
        pnlSearch.setLayout( lyo01 );
        lblSearch.setHorizontalAlignment( SwingConstants.RIGHT );
        pnlSearch.add( lblSearch, cc.xy( 1, 1 ) );
        pnlSearch.add( tblMixDiff.getSearchField(), cc.xy( 2, 1 ) );
        pnl.add( pnlSearch, cc.xy( 6, 2 ) );
        pnl.add( scrC, cc.xy( 6, 3 ) );
        scrA.setBorder( new TitledBorder( "Mix A" ) );
        scrB.setBorder( new TitledBorder( "Mix B" ) );
        scrC.setBorder( new TitledBorder( "Mix Difference" ) );
        tblMixDiffA.getSelectionModel().addListSelectionListener( ( ListSelectionEvent e ) -> {
            calculateMixDifference( e );
        } );
        tblMixDiffB.getSelectionModel().addListSelectionListener( ( ListSelectionEvent e ) -> {
            calculateMixDifference( e );
        } );
        return pnl;
    }


    private void calculateMixDifference( ListSelectionEvent e ) {
        if ( e.getValueIsAdjusting() ) {
            return;
        }
        if ( tblMixDiffA.isSelectionEmpty() ) {
            return;
        }
        if ( tblMixDiffB.isSelectionEmpty() ) {
            return;
        }
        TableMix.Row mixa = tblMixDiffA.getSelectedValue();
        TableMix.Row mixb = tblMixDiffB.getSelectedValue();
        try {
            Future<List<List>> task = BackgroundExec.submit( new MixDiffTask( mixa.getMixid(), mixb.getMixid() ) );
            List<List> diff = task.get();
            tblMixDiff.reload( diff );
        } catch ( Exception ex ) {
            LoggerImpl.INSTANCE.logProblem( ex );
        }
    }


    private JPanel getMixFoodPanel() {
        JPanel pnl = new JPanel();
        FormLayout lyo = new FormLayout(
                "min:grow,min,min:grow", // columns
                "fill:min:grow" // rows
        );
        pnl.setLayout( lyo );
        JPanel pnlFood = new JPanel();
        FormLayout lyoFood = new FormLayout(
                "min:grow", // columns
                "4px,min,4px,fill:min:grow" // rows
        );
        pnlFood.setLayout( lyoFood );
        JPanel pnlSearch = new JPanel();
        FormLayout lyoSearch = new FormLayout(
                "min,min:grow", // columns
                "fill:28px:grow" // rows
        );
        pnlSearch.setLayout( lyoSearch );
        JPanel pnlButtons = new JPanel();
        FormLayout lyoButtons = new FormLayout(
                "min,min:grow", // columns
                "min:grow,min,min,min,min,min:grow" // rows
        );
        pnlButtons.setLayout( lyoButtons );
        tblMixFood = new TableFood();
        JScrollPane mixFoodScrollPane = new JScrollPane( tblMixFood );
        mixFoodScrollPane.setBorder( new TitledBorder( "Selected Food" ) );
        JScrollPane scrFood = new JScrollPane( tree );
        scrFood.setBorder( new TitledBorder( "Available Food" ) );
        tree.setModel( treeModel );
        JButton buttonAddMixFood = new JButton( "+" );
        JButton buttonDeleteMixFood = new JButton( "-" );
        JButton buttonExpandMixFood = new JButton( "e" );
        JButton buttonCollapseMixFood = new JButton( "c" );
        JTextField txtSearch = new JTextField();
        pnlSearch.add( new JLabel( "Search:" ), cc.xy( 1, 1 ) );
        pnlSearch.add( txtSearch, cc.xy( 2, 1 ) );
        pnlFood.add( pnlSearch, cc.xy( 1, 2 ) );
        pnlFood.add( scrFood, cc.xy( 1, 4 ) );
        pnlButtons.add( buttonAddMixFood, cc.xy( 1, 2 ) );
        pnlButtons.add( buttonDeleteMixFood, cc.xy( 1, 3 ) );
        pnlButtons.add( buttonExpandMixFood, cc.xy( 1, 4 ) );
        pnlButtons.add( buttonCollapseMixFood, cc.xy( 1, 5 ) );
        pnl.add( pnlFood, cc.xy( 1, 1 ) );
        pnl.add( pnlButtons, cc.xy( 2, 1 ) );
        pnl.add( mixFoodScrollPane, cc.xy( 3, 1 ) );
        buttonAddMixFood.setToolTipText( "Add Food Item to Mix" );
        buttonDeleteMixFood.setToolTipText( "Delete Food Item from Mix" );
        buttonExpandMixFood.setToolTipText( "Expand Food List" );
        buttonCollapseMixFood.setToolTipText( "Collapse Food List" );
        buttonAddMixFood.addActionListener( e -> {
            if ( cmbMixes.isEmpty() ) {
                Message.showMessage( "Please create new mix." );
            }
            addMixFood();
        } );
        buttonDeleteMixFood.addActionListener( e -> deleteMixFood() );
        buttonExpandMixFood.addActionListener( e -> expandFoods() );
        buttonCollapseMixFood.addActionListener( e -> collapseFoods() );
        txtSearch
                .getDocument()
                .addDocumentListener(
                        new DocumentListener() {
                    @Override
                    public void insertUpdate( final DocumentEvent e ) {
                        createTreeModel();
                    }


                    @Override
                    public void removeUpdate( final DocumentEvent e ) {
                        createTreeModel();
                    }


                    @Override
                    public void changedUpdate( final DocumentEvent e ) {
                        createTreeModel();
                    }


                    public void createTreeModel() {
                        if ( txtSearch.getText().isEmpty() ) {
                            tree.setModel( treeModel );
                            return;
                        }
                        if ( txtSearch.getText().length() < 2 ) {
                            return;
                        }
                        String regex = getRegex( txtSearch.getText() );
                        RegexCheck check = new RegexCheck( regex );
                        if ( !check.pass() ) {
                            return;
                        }
                        //
                        TreeModelFilter treeModelRegexFilter = new TreeModelFilter( treeModel, regex );
                        //tree.setCellRenderer( new TreeModelRegexHighlighter( tree.getCellRenderer(), txtSearch.getText() ) );
                        tree.setModel( treeModelRegexFilter.model() );
                        expandTree( tree );
                    }
                } );
        return pnl;
    }


    private String getRegex( String regex ) {
        StringBuilder sb = new StringBuilder();
        // sb.append("(?i)");
        sb.append( ".*" );
        sb.append( regex );
        sb.append( ".*" );
        return sb.toString();
    }


    private void expandTree( JTree tree ) {
        for ( int i = 0; i < tree.getRowCount(); i++ ) {
            tree.expandRow( i );
        }
    }


    private Double getMixUsageInputForInventory() {
        Double days = 1.0;
        JTextField input = new JTextField();
        JPanel input_panel = new JPanel();
        input.setPreferredSize( new Dimension( 50, 25 ) );
        input_panel.add( new JLabel( "How many days will you be using this meal plan?" ) );
        input_panel.add( input );
        JComponent[] inputs = { input_panel };
        int optionValue = Message.showOptionDialogOkCancel( inputs, "Meal Plan Usage" );
        if ( optionValue == 0 ) {
            String s = input.getText();
            if ( s != null && s.length() > 0 ) {
                NumberCheck checkNumber = new NumberCheck();
                checkNumber.addToUncheckedList( s );
                if ( checkNumber.pass() ) {
                    days = Double.valueOf( s );
                }
            }
        }
        return days;
    }


    private JPanel getMealPlanUsageDaysPanel() {
        JPanel pnl = new JPanel();
        pnl.setBorder( new TitledBorder( "Meal Plan Usage" ) );
        FormLayout panelLayout = new FormLayout(
                "p:grow", // columns
                "fill:min:grow,min" // rows
        );
        pnl.setLayout( panelLayout );
        tblMealPlanUsage = new TableInventoryDays();
        pnl.add( new JScrollPane( tblMealPlanUsage ), cc.xy( 1, 1 ) );
        pnl.add( getMealPlanUsageButtonsPanel(), cc.xy( 1, 2 ) );
        return pnl;
    }


    private JPanel getMealPlanUsageButtonsPanel() {
        JPanel pnl = new JPanel();
        JButton btn_add = new JButton( "+" );
        JButton btn_delete = new JButton( "-" );
        btn_add.setToolTipText( "Add meal plan to food forecast" );
        btn_delete.setToolTipText( "Delete meal plan from food forecast" );
        pnl.add( btn_add );
        pnl.add( btn_delete );
        btn_add.addActionListener( ( ActionEvent a ) -> {
            addMealPlanUsage();
            exectureMealPlanUsageTasks();
        } );
        btn_delete.addActionListener( ( ActionEvent evt ) -> {
            deleteMealPlanUsage();
            exectureMealPlanUsageTasks();
        } );
        return pnl;
    }


    private JPanel getMealPlanUsageMixesPanel() {
        JPanel pnl = new JPanel();
        pnl.setBorder( new TitledBorder( "Mix" ) );
        FormLayout panelLayout = new FormLayout(
                "p:grow", // columns
                "fill:min:grow" // rows
        );
        pnl.setLayout( panelLayout );
        pnl.add( new JScrollPane( tblMealPlanUsageMixes ), cc.xy( 1, 1 ) );
        return pnl;
    }


    private JPanel getMealPlanUsageResultPanel() {
        JPanel pnl = new JPanel();
        pnl.setBorder( new TitledBorder( "Food Usage" ) );
        FormLayout panelLayout = new FormLayout(
                "p:grow", // columns
                "fill:min:grow,min" // rows
        );
        pnl.setLayout( panelLayout );
        tblMealPlanUsageResults = new TableMealPlanUsageResults();
        pnl.add( new JScrollPane( tblMealPlanUsageResults ), cc.xy( 1, 1 ) );
        return pnl;
    }


    private JPanel getNoSolutionPanel() {
        FormLayout lyo = new FormLayout(
                "pref:grow", // columns
                "fill:pref:grow" // rows
        );
        StringBuilder sb = new StringBuilder();
        sb.append( getNoFeasibleSolutionText() );
        JPanel pnl = new JPanel();
        JTextArea txa = new JTextArea( sb.toString() );
        txa.setPreferredSize( new Dimension( 700, 433 ) );
        txa.setEditable( false );
        pnl.setLayout( lyo );
        txa.setLineWrap( false );
        pnl.add( new JScrollPane( txa ), cc.xy( 1, 1 ) );
        return pnl;
    }


    private JPanel getNutrientQuantityConstraintPanel() {
        JPanel pnl = new JPanel();
        FormLayout panelLayout = new FormLayout(
                "p,p,p", // columns
                "p,fill:p:grow,min" // rows
        );
        pnl.setLayout( panelLayout );
        tblNutrientQuantityConstraint = new TableNutrientQuantity();
        JScrollPane scrollPane = new JScrollPane( tblNutrientQuantityConstraint );
        Integer width = TableColumnWidth.Nutrient.getWidth() + 21 + 90 + TableColumnWidth.Scrollbar.getWidth();
        scrollPane.setPreferredSize( new Dimension( width, 0 ) );
        JPanel buttons = new JPanel();
        txtNutrientQuantityValue.setPreferredSize( Dimensions.Quantity.get() );
        pnl.add( cmbNutrientQuantityNutrient, cc.xy( 1, 1 ) );
        pnl.add( cmbNutrientQuantityRelationship, cc.xy( 2, 1 ) );
        pnl.add( txtNutrientQuantityValue, cc.xy( 3, 1 ) );
        pnl.add( scrollPane, cc.xyw( 1, 2, 3 ) );
        buttons.add( btnAddNutrientConstraint );
        buttons.add( btnDeleteNutrientConstraint );
        pnl.add( buttons, cc.xyw( 1, 3, 3 ) );
        scrollPane.setBorder( new TitledBorder( "Nutrient Constraints" ) );
        cmbNutrientQuantityNutrient.setMaximumRowCount( 10 );
        cmbNutrientQuantityRelationship.setMaximumRowCount( 3 );
        btnAddNutrientConstraint.setToolTipText( "Add Constraint" );
        btnDeleteNutrientConstraint.setToolTipText( "Delete Constraint" );
        btnAddNutrientConstraint.addActionListener( ( ActionEvent evt ) -> {
            addNutrientQuantityConstraint();
        } );
        btnDeleteNutrientConstraint.addActionListener( ( ActionEvent evt ) -> {
            if ( tblNutrientQuantityConstraint.isSelectionEmpty() ) {
                return;
            }
            deleteNutrientQuantityConstraint();
        } );
        tblNutrientQuantityConstraint.getSelectionModel().addListSelectionListener( ( ListSelectionEvent e ) -> {
            if ( e.getValueIsAdjusting() ) {
                return;
            }
            if ( tblNutrientQuantityConstraint.isSelectionEmpty() ) {
                return;
            }
            setNutrientQuantityConstraintGuiValues();
        } );
        return pnl;
    }


    private JPanel getNutrientSearchPanel() {
        JPanel pnl = new JPanel();
        JPanel pnl01 = new JPanel();
        FormLayout lyo = new FormLayout(
                "4dlu:grow,500dlu,4dlu:grow", // columns
                "4dlu,min,4dlu,fill:min:grow,4dlu" // rows
        );
        FormLayout lyo01 = new FormLayout(
                "4dlu,p,p,4dlu,p,p:grow,4dlu", // columns
                "4dlu,fill:28px,4dlu,fill:28px,4dlu" // rows
        );
        pnl.setLayout( lyo );
        pnl01.setLayout( lyo01 );
        JLabel lblSearch = new JLabel( "Search: " );
        lblSearch.setToolTipText( "Search field input should be a valid regex expression (case insensitive match)" );
        JLabel lblNutrient = new JLabel( "Nutrient: " );
        lblNutrient.setHorizontalAlignment( SwingConstants.RIGHT );
        JLabel lblValue = new JLabel( "Nutrient Quantity: " );
        lblValue.setHorizontalAlignment( SwingConstants.RIGHT );
        lblSearch.setHorizontalAlignment( SwingConstants.RIGHT );
        tblNutrientLookup = new TableNutrientLookup();
        tblNutrientLookup.setToolTipText( "These food items contain the nutrient" );
        JScrollPane scr = new JScrollPane( tblNutrientLookup );
        scr.setBorder( new TitledBorder( "Nutrient Search" ) );
        pnl01.add( lblSearch, cc.xy( 5, 2 ) );
        pnl01.add( tblNutrientLookup.getSearchField(), cc.xy( 6, 2 ) );
        pnl01.add( lblNutrient, cc.xy( 2, 4 ) );
        pnl01.add( cmbNutrientContentNutrient, cc.xy( 3, 4 ) );
        pnl01.add( lblValue, cc.xy( 5, 4 ) );
        pnl01.add( txtNutrientSearchQuantity, cc.xy( 6, 4 ) );
        pnl.add( pnl01, cc.xy( 2, 2 ) );
        pnl.add( scr, cc.xy( 2, 4 ) );
        txtNutrientSearchQuantity.setToolTipText( "Press enter to search for food items" );
        txtNutrientSearchQuantity.addActionListener( ( ActionEvent evt ) -> {
            reload_tblmdl_nutrient_lookup();
            setQuantityScale();
        } );
        return pnl;
    }


    private JPanel getNutrientRatioPanel() {
        JPanel pnl = new JPanel();
        FormLayout lyo = new FormLayout(
                "p:grow,90px,p,p,370px:grow", // columns
                "p,p,fill:p:grow,min" // rows
        );
        pnl.setLayout( lyo );
        tblNutrientRatio = new TableNutrientRatioConstraint();
        JScrollPane scr = new JScrollPane( tblNutrientRatio );
        Integer width = TableColumnWidth.Nutrient.getWidth()
                + TableColumnWidth.Nutrient.getWidth()
                + 90
                + 21
                + 90
                + TableColumnWidth.Scrollbar.getWidth();
        scr.setPreferredSize( new Dimension( width, 0 ) );
        JPanel buttons = new JPanel();
        txtNutrientRatioNutrientA.setPreferredSize( Dimensions.Quantity.get() );
        txtNutrientRatioNutrientB.setPreferredSize( Dimensions.Quantity.get() );
        pnl.add( cmbNutrientRatioNutrientA, cc.xy( 1, 1 ) );
        pnl.add( txtNutrientRatioNutrientA, cc.xy( 2, 1 ) );
        pnl.add( cmbNutrientRatioRelationship, cc.xy( 3, 1 ) );
        pnl.add( cmbNutrientRatioNutrientB, cc.xy( 1, 2 ) );
        pnl.add( txtNutrientRatioNutrientB, cc.xy( 2, 2 ) );
        pnl.add( scr, cc.xyw( 1, 3, 5 ) );
        buttons.add( btnAddNutrientRatio );
        buttons.add( btnDeleteNutrientRatio );
        pnl.add( buttons, cc.xyw( 1, 4, 5 ) );
        scr.setBorder( new TitledBorder( "Nutrient Ratio Constraints" ) );
        cmbNutrientRatioNutrientA.setMaximumRowCount( 10 );
        cmbNutrientRatioNutrientB.setMaximumRowCount( 10 );
        btnAddNutrientRatio.setToolTipText( "Add Constraint" );
        btnDeleteNutrientRatio.setToolTipText( "Delete Constraint" );
        btnAddNutrientRatio.addActionListener( ( ActionEvent evt ) -> {
            addNutrientRatioConstraint();
        } );
        btnDeleteNutrientRatio.addActionListener( ( ActionEvent evt ) -> {
            if ( tblNutrientRatio.isSelectionEmpty() ) {
                return;
            }
            deleteNutrientRatioConstraint();
        } );
        tblNutrientRatio.getSelectionModel().addListSelectionListener( ( ListSelectionEvent e ) -> {
            if ( e.getValueIsAdjusting() ) {
                return;
            }
            if ( tblNutrientRatio.isSelectionEmpty() ) {
                return;
            }
            setNutrientRatioConstraintGuiValues();
        } );
        return pnl;
    }


    private String getFoodConstraintCount() {
        return String.format( "%1$ 2d", tblFoodQuantityConstraint.getRowCount() );
    }


    private String getFoodRatioConstraintCount() {
        return String.format( "%1$ 2d", tblFoodRatioConstraint.getRowCount() );
    }


    private String getGroupConstraintCount() {
        return String.format( "%1$ 2d", tblGroupQuantityConstraint.getRowCount() );
    }


    private String getNoFeasibleSolutionText() {
        StringBuilder sb = new StringBuilder();
        for ( int i = 0; i < 8; i++ ) {
            sb.append( "\n" );
        }
        for ( int i = 0; i < 40; i++ ) {
            sb.append( " " );
        }
        sb.append( "No Feasible Solution" );
        sb.append( "\n\n" );
        for ( int i = 0; i < 40; i++ ) {
            sb.append( " " );
        }
        sb.append( "Things you can try:" );
        sb.append( "\n\n" );
        for ( int i = 0; i < 40; i++ ) {
            sb.append( " " );
        }
        sb.append( "1. Delete a constraint" );
        sb.append( "\n\n" );
        for ( int i = 0; i < 40; i++ ) {
            sb.append( " " );
        }
        sb.append( "2. Add a food item" );
        sb.append( "\n\n" );
        for ( int i = 0; i < 40; i++ ) {
            sb.append( " " );
        }
        sb.append( "3. Pin the mix" );
        return sb.toString();
    }


    private String getNutrientQuantityConstraintCount() {
        return String.format( "%1$ 2d", tblNutrientQuantityConstraint.getRowCount() );
    }


    private String getNutrientRatioConstraintCount() {
        return String.format( "%1$ 2d", tblNutrientRatio.getRowCount() );
    }


    private Boolean checkFoodConstraint() {
        boolean flag_isReady = false;
        boolean flag_listFood = false;
        boolean flag_listNutrient = false;
        boolean flag_listRelationship = false;
        boolean flag_quantity = false;
        if ( !cmbFoodQuantityFood.isSelectionEmpty() ) {
            flag_listFood = true;
        } else {
            Message.showMessage( "Select food" );
        }
        if ( !cmbFoodQuantityNutrient.isSelectionEmpty() ) {
            flag_listNutrient = true;
        } else {
            Message.showMessage( "Select nutrient" );
        }
        if ( !cmbFoodQuantityRelationship.isSelectionEmpty() ) {
            flag_listRelationship = true;
        } else {
            Message.showMessage( "Select relationship" );
        }
        if ( !txtFoodQuantityValue.getText().isEmpty() ) {
            flag_quantity = true;
        } else {
            Message.showMessage( "Specify amount" );
        }
        if ( flag_listFood && flag_listNutrient && flag_listRelationship && flag_quantity ) {
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
        if ( !cmbFoodRatioFoodA.isSelectionEmpty() ) {
            flag_listFoodA = true;
        } else {
            Message.showMessage( "Select food A" );
        }
        if ( !cmbFoodRatioNutrientA.isSelectionEmpty() ) {
            flag_listNutrientA = true;
        } else {
            Message.showMessage( "Select nutrient A" );
        }
        if ( !txtFoodNutrientRatioQuantityA.getText().isEmpty() ) {
            flag_quantityA = true;
        } else {
            Message.showMessage( "Specify amount A" );
        }
        if ( !cmbFoodRatioFoodB.isSelectionEmpty() ) {
            flag_listFoodB = true;
        } else {
            Message.showMessage( "Select food B" );
        }
        if ( !cmbFoodRatioNutrientB.isSelectionEmpty() ) {
            flag_listNutrientB = true;
        } else {
            Message.showMessage( "Select nutrient B" );
        }
        if ( !txtFoodNutrientRatioQuantityB.getText().isEmpty() ) {
            flag_quantityB = true;
        } else {
            Message.showMessage( "Specify amount B" );
        }
        if ( flag_listFoodA
                && flag_listNutrientA
                && flag_quantityA
                && flag_listFoodB
                && flag_listNutrientB
                && flag_quantityB ) {
            flag_isReady = true;
        }
        return flag_isReady;
    }


    private Boolean checkNutrientQuantityConstraint() {
        boolean flag_isReady = false;
        boolean flag_listNutrient = false;
        boolean flag_listNutrientRelationship = false;
        boolean flag_textFieldNutrientConstraint = false;
        if ( !cmbNutrientQuantityNutrient.isSelectionEmpty() ) {
            flag_listNutrient = true;
        } else {
            Message.showMessage( "Select nutrient" );
        }
        if ( cmbNutrientQuantityRelationship.getSelectedIndex() != -1 ) {
            flag_listNutrientRelationship = true;
        } else {
            Message.showMessage( "Select relationship" );
        }
        if ( !txtNutrientQuantityValue.getText().isEmpty() ) {
            flag_textFieldNutrientConstraint = true;
        } else {
            Message.showMessage( "Specify amount" );
        }
        if ( flag_listNutrient && flag_listNutrientRelationship && flag_textFieldNutrientConstraint ) {
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
        if ( !cmbNutrientRatioNutrientA.isSelectionEmpty() ) {
            flag_listNutrientA = true;
        } else {
            Message.showMessage( "Select nutrient A" );
        }
        if ( !cmbNutrientRatioNutrientB.isSelectionEmpty() ) {
            flag_listNutrientB = true;
        } else {
            Message.showMessage( "Select nutrient B" );
        }
        if ( !txtNutrientRatioNutrientA.getText().isEmpty() ) {
            flag_quantityA = true;
        } else {
            Message.showMessage( "Specify amount A" );
        }
        if ( !txtNutrientRatioNutrientB.getText().isEmpty() ) {
            flag_quantityB = true;
        } else {
            Message.showMessage( "Specify amount B" );
        }
        if ( flag_listNutrientA && flag_listNutrientB && flag_quantityA && flag_quantityB ) {
            flag_isReady = true;
        }
        return flag_isReady;
    }


    private void convertMixToFood() {
        TableFoodFactInput tbl = new TableFoodFactInput();
        try {
            Future<List<List>> task = BackgroundExec.submit( new MixFoodFactsTask( selectedMixId ) );
            List<List> foodfacts = task.get();
            tbl.reload( foodfacts );
        } catch ( Exception e ) {
            LoggerImpl.INSTANCE.logProblem( e );
        }
        FoodFactInputPanel pnlFoodFactsInput = new FoodFactInputPanel( tbl );
        pnlFoodFactsInput.setFoodName( selectedMixName );
        JPanel pnl = pnlFoodFactsInput.getPanel();
        JComponent[] inputs = { pnl };
        int optionValue = Message.showOptionDialogOkCancel(
                inputs, "Add Mix As Food Item - Would you like to save specified values?" );
        if ( optionValue == 0 ) {
            Food food = pnlFoodFactsInput.getFood();
            Boolean completed = new FoodCreator( food ).create();
            if ( completed ) {
                try {
                    Future<List<List>> task = BackgroundExec.submit( new FoodFactsTask() );
                    List<List> foods = task.get();
                    tblFoodFacts.reload( foods );
                    tblFoodDiffA.reload( foods );
                    tblFoodDiffB.reload( foods );
                    tblAllFoods.reload( foods );
                } catch ( Exception e ) {
                    LoggerImpl.INSTANCE.logProblem( e );
                }
                reloadFoods();
                try {
                    Future<List<List>> task = BackgroundExec.submit( new NamedMixFoodSortedByNameTask( selectedMixId ) );
                    List<List> foods = task.get();
                    tblMixFood.reload( foods );
                    tblSelectedFoods.reload( foods );
                } catch ( Exception e ) {
                    LoggerImpl.INSTANCE.logProblem( e );
                }
                setQuantityScale();
                int rowIndex = tblFoodFacts.find( food.getFoodId() );
                tblFoodFacts.showRow( rowIndex );
            }
        }
    }


    private void addCategory() {
        JTextField txtInput = new JTextField();
        JComponent[] inputs = { new JLabel( "What is your new category name?" ), txtInput };
        int optionValue = Message.showOptionDialogOkCancel( inputs, "New Category" );
        if ( optionValue == 0 ) {
            String categoryname = txtInput.getText();
            if ( categoryname != null && categoryname.length() > 0 ) {
                try {
                    Future<String> task00 = BackgroundExec.submit( new InsertCategoryTask( categoryname ) );
                    String id = task00.get();
                    if ( task00.isDone() ) {
                        Future<List<List>> task02 = BackgroundExec.submit( new FoodCategoriesTask() );
                        List<List> categories = task02.get();
                        tblAllFoodCategories.reload( categories );
                        int rowIndex = tblAllFoodCategories.find( id );
                        tblAllFoodCategories.selectRow( rowIndex );
                        tblAllFoodCategories.showRow( rowIndex );
                    }
                } catch ( Exception e ) {
                    LoggerImpl.INSTANCE.logProblem( e );
                }
            }
        }
    }


    private void duplicateCategory() {
        if ( !tblAllFoodCategories.isSelectionEmpty() ) {
            TableCategory.Row category = tblAllFoodCategories.getSelectedValue();
            try {
                Future<String> task00 = BackgroundExec.submit( new DuplicateCategoryTask( category.getCategoryid() ) );
                String id = task00.get();
                if ( task00.isDone() ) {
                    Future<List<List>> task02 = BackgroundExec.submit( new FoodCategoriesTask() );
                    List<List> categories = task02.get();
                    tblAllFoodCategories.reload( categories );
                    int rowIndex = tblAllFoodCategories.find( id );
                    tblAllFoodCategories.selectRow( rowIndex );
                    tblAllFoodCategories.showRow( rowIndex );
                }
            } catch ( Exception e ) {
                LoggerImpl.INSTANCE.logProblem( e );
            }
        }
    }


    private void deleteCategory() {
        if ( !tblAllFoodCategories.isSelectionEmpty() ) {
            TableCategory.Row category = tblAllFoodCategories.getSelectedValue();
            try {
                Future<Boolean> task = BackgroundExec.submit( new DeleteCategoryTask( category.getCategoryid() ) );
                Boolean completed = task.get();
                if ( !completed ) {
                    return;
                }
            } catch ( Exception e ) {
                LoggerImpl.INSTANCE.logProblem( e );
            }
            try {
                Future<List<Map<String, Object>>> task = BackgroundExec.submit( new FoodsTask() );
                List<Map<String, Object>> treeFoods = task.get();
                treeModel.reload( treeFoods );
            } catch ( Exception e ) {
                LoggerImpl.INSTANCE.logProblem( e );
            }
            try {
                Future<List<List>> task = BackgroundExec.submit( new FoodCategoriesTask() );
                List<List> categories = task.get();
                tblAllFoodCategories.reload( categories );
            } catch ( Exception e ) {
                LoggerImpl.INSTANCE.logProblem( e );
            }
            tblFoodsInCategory.clear();
        }
    }


    private void renameCategory() {
        if ( !tblAllFoodCategories.isSelectionEmpty() ) {
            JTextField input = new JTextField();
            JComponent[] inputs = { new JLabel( "What is your new category name?" ), input };
            int optionValue = Message.showOptionDialogOkCancel( inputs, "Update Category" );
            if ( optionValue == 0 ) {
                String categoryname = input.getText();
                if ( categoryname != null && categoryname.length() > 0 ) {
                    TableCategory.Row category = tblAllFoodCategories.getSelectedValue();
                    try {
                        Future<Boolean> task
                                = BackgroundExec.submit( new UpdateCategoryTask( category.getCategoryid(), categoryname ) );
                        Boolean completed = task.get();
                    } catch ( Exception e ) {
                        LoggerImpl.INSTANCE.logProblem( e );
                    }
                    try {
                        Future<List<List>> task = BackgroundExec.submit( new FoodCategoriesTask() );
                        List<List> categories = task.get();
                        tblAllFoodCategories.reload( categories );
                        int rowIndex = tblAllFoodCategories.find( category.getCategoryid() );
                        tblAllFoodCategories.selectRow( rowIndex );
                        tblAllFoodCategories.showRow( rowIndex );
                    } catch ( Exception e ) {
                        LoggerImpl.INSTANCE.logProblem( e );
                    }
                    try {
                        Future<List<Map<String, Object>>> task = BackgroundExec.submit( new FoodsTask() );
                        List<Map<String, Object>> treeFoods = task.get();
                        treeModel.reload( treeFoods );
                    } catch ( Exception e ) {
                        LoggerImpl.INSTANCE.logProblem( e );
                    }
                }
            }
        }
    }


    public void exportCategory() {
        if ( tblAllFoodCategories.isSelectionEmpty() ) {
            return;
        }
        int returnVal = fch.showSaveDialog( frm );
        if ( returnVal == JFileChooser.APPROVE_OPTION ) {
            File file = fch.getSelectedFile();
            fch.setCurrentDirectory( file );
            String path = file.getAbsolutePath();
            try {
                TableCategory.Row selectedValue = tblAllFoodCategories.getSelectedValue();
                frm.setCursor( Cursor.getPredefinedCursor( Cursor.WAIT_CURSOR ) );
                Future<String> task = BackgroundExec.submit( new SendCategoryToXmlTask( selectedValue.getCategoryid() ) );
                String xml = task.get();
                if ( xml.isEmpty() ) {
                    frm.setCursor( Cursor.getPredefinedCursor( Cursor.DEFAULT_CURSOR ) );
                    return;
                }
                BufferedWriter writer = new BufferedWriter( new FileWriter( path ) );
                String fdoc = Utilities.formatXmlDoc( xml );
                writer.write( fdoc );
                writer.close();
                frm.setCursor( Cursor.getPredefinedCursor( Cursor.DEFAULT_CURSOR ) );
                showMessageSent( path );
            } catch ( Exception e ) {
                LoggerImpl.INSTANCE.logProblem( e );
            }
        }
    }


    private void addFoodToCategory() {
        if ( !tblAllFoodCategories.isSelectionEmpty() ) {
            if ( !tblAllFoods.isSelectionEmpty() ) {
                TableCategory.Row category = tblAllFoodCategories.getSelectedValue();
                TableFood.Row food = tblAllFoods.getSelectedValue();
                try {
                    Future<Integer> task0 = BackgroundExec.submit(
                            new FoodCategoryCountTask( category.getCategoryid(), food.getFoodid() ) );
                    Integer count = task0.get();
                    if ( count == 0 ) {
                        Future<Boolean> task1 = BackgroundExec.submit(
                                new InsertFoodCategoryLinkTask( category.getCategoryid(), food.getFoodid() ) );
                        Boolean task1Completed = task1.get();
                        if ( !task1Completed ) {
                            return;
                        }
                        executeFoodsInCategoryTasks( category );
                        int rowIndex = tblFoodsInCategory.find( food.getFoodid() );
                        tblFoodsInCategory.selectRow( rowIndex );
                        tblFoodsInCategory.showRow( rowIndex );
                    }
                } catch ( Exception e ) {
                    LoggerImpl.INSTANCE.logProblem( e );
                }
            }
        }
    }


    private void executeFoodsInCategoryTasks( TableCategory.Row category ) {
        try {
            Future<List<List>> task3 = BackgroundExec.submit( new FoodsInCategoryTask( ( category.getCategoryid() ) ) );
            List<List> categoryFoods = task3.get();
            tblFoodsInCategory.reload( categoryFoods );
        } catch ( Exception e ) {
            LoggerImpl.INSTANCE.logProblem( e );
        }
        try {
            Future<List<Map<String, Object>>> task = BackgroundExec.submit( new FoodsTask() );
            List<Map<String, Object>> treeFoods = task.get();
            treeModel.reload( treeFoods );
        } catch ( Exception e ) {
            LoggerImpl.INSTANCE.logProblem( e );
        }
    }


    private void removeFoodFromCategory() {
        if ( !tblAllFoodCategories.isSelectionEmpty() ) {
            TableCategory.Row category = tblAllFoodCategories.getSelectedValue();
            TableFood.Row food = tblFoodsInCategory.getSelectedValue();
            try {
                Future<Boolean> task0
                        = BackgroundExec.submit( new DeleteCategoryLinkTask( category.getCategoryid(), food.getFoodid() ) );
                Boolean complete = task0.get();
                if ( !complete ) {
                    return;
                }
                executeFoodsInCategoryTasks( category );
            } catch ( Exception e ) {
                LoggerImpl.INSTANCE.logProblem( e );
            }
        }
    }


    private void addFoodToDatabase() {
        TableFoodFactInput tbl = new TableFoodFactInput();
        try {
            Future<List<List>> task = BackgroundExec.submit( new NewItemFoodFactsTask() );
            List<List> foodfacts = task.get();
            tbl.reload( foodfacts );
        } catch ( Exception e ) {
            LoggerImpl.INSTANCE.logProblem( e );
        }
        FoodFactInputPanel pnlFoodFactsInput = new FoodFactInputPanel( tbl );
        JPanel pnl = pnlFoodFactsInput.getPanel();
        JComponent[] inputs = { pnl };
        int optionValue = Message.showOptionDialogOkCancel(
                inputs, "Add New Food Item - Would you like to save specified values?" );
        if ( optionValue == 0 ) {
            Food food = pnlFoodFactsInput.getFood();
            Boolean completed = new FoodCreator( food ).create();
            if ( completed ) {
                reloadFoods();
                try {
                    Future<List<List>> task = BackgroundExec.submit( new NamedMixFoodSortedByNameTask( selectedMixId ) );
                    List<List> foods = task.get();
                    tblMixFood.reload( foods );
                    tblSelectedFoods.reload( foods );
                } catch ( Exception e ) {
                    LoggerImpl.INSTANCE.logProblem( e );
                }
                setQuantityScale();
                int rowIndex = tblFoodFacts.find( food.getFoodId() );
                tblFoodFacts.showRow( rowIndex );
                tblFoodFacts.selectRow( rowIndex );
            }
        }
    }


    private void addDerivativeFoodToDatabase() {
        if ( !tblFoodFacts.isSelectionEmpty() ) {
            TableFoodFacts.Row foodfact = tblFoodFacts.getSelectedValue();
            TableFoodFactInput tbl = new TableFoodFactInput();
            try {
                Future<List<List>> task = BackgroundExec.submit( new DerivedFoodFactsTask( foodfact.getId_food_id() ) );
                List<List> foodfacts = task.get();
                tbl.reload( foodfacts );
            } catch ( Exception e ) {
                LoggerImpl.INSTANCE.logProblem( e );
            }
            FoodFactInputPanel foodFactsInputPanel = new FoodFactInputPanel( tbl );
            foodFactsInputPanel.setFoodName( foodfact.getId_food_name() );
            JPanel panel = foodFactsInputPanel.getPanel();
            JComponent[] inputs = { panel };
            int optionValue = Message.showOptionDialogOkCancel(
                    inputs, "Update New Food Item - Would you like to save specified values?" );
            if ( optionValue == 0 ) {
                Food food = foodFactsInputPanel.getFood();
                Boolean completed = new FoodCreator( food ).create();
                if ( completed ) {
                    reloadFoods();
                    setQuantityScale();
                    int rowIndex = tblFoodFacts.find( food.getCheckSum() );
                    tblFoodFacts.showRow( rowIndex );
                    tblFoodFacts.selectRow( rowIndex );
                }
            }
        }
    }


    private void removeFoodFromDatabase() {
        if ( !tblFoodFacts.isSelectionEmpty() ) {
            TableFoodFacts.Row food = tblFoodFacts.getSelectedValue();
            deleteFoodItem( food.getId_food_id() );
            reloadFoodComboBoxes( selectedMixId );
            reloadMixConstraints( selectedMixId );
            mixFoodLoader.reload( selectedMixId );
            cmbPortionFood.reload( mixFoodLoader.get() );
            setConstraintCounts();
        }
    }


    private void renameFood() {
        if ( !tblFoodFacts.isSelectionEmpty() ) {
            TableFoodFacts.Row food = tblFoodFacts.getSelectedValue();
            String foodid = food.getId_food_id();
            JTextField input = new JTextField();
            JPanel input_panel = new JPanel();
            input.setPreferredSize( new Dimension( 600, 25 ) );
            input_panel.add( new JLabel( "What is the food item name?" ) );
            input_panel.add( input );
            JComponent[] inputs = { input_panel };
            input.setText( food.getId_food_name() );
            int optionValue = Message.showOptionDialogOkCancel( inputs, "Rename Food Item" );
            if ( optionValue == 0 ) {
                food.setId_food_name( input.getText() );
                try {
                    Future<Boolean> task
                            = BackgroundExec.submit( new UpdateFoodTask( food.getId_food_id(), food.getId_food_name() ) );
                    Boolean completed = task.get();
                    if ( !completed ) {
                        return;
                    }
                } catch ( Exception e ) {
                    LoggerImpl.INSTANCE.logProblem( e );
                }
                try {
                    Future<Boolean> task = BackgroundExec.submit( new DenormalizeFoodFactsTask( food.getId_food_id() ) );
                    Boolean completed = task.get();
                    if ( !completed ) {
                        return;
                    }
                } catch ( Exception e ) {
                    LoggerImpl.INSTANCE.logProblem( e );
                }
                reloadFoods();
                String mixid = selectedMixId;
                reloadFoodComboBoxes( mixid );
                reloadResults( selectedMix );
                try {
                    Future<List<List>> task1 = BackgroundExec.submit( new FoodConstraintsTask( mixid ) );
                    List<List> constraints = task1.get();
                    tblFoodQuantityConstraint.reload( constraints );
                    Future<List<List>> task2 = BackgroundExec.submit( new FoodRatioConstraintsTask( mixid ) );
                    List<List> constraints2 = task2.get();
                    tblFoodRatioConstraint.reload( constraints2 );
                } catch ( Exception e ) {
                    LoggerImpl.INSTANCE.logProblem( e );
                }
                try {
                    Future<List<List>> task = BackgroundExec.submit( new NamedMixFoodSortedByNameTask( selectedMixId ) );
                    List<List> foods = task.get();
                    tblMixFood.reload( foods );
                    tblSelectedFoods.reload( foods );
                } catch ( Exception e ) {
                    LoggerImpl.INSTANCE.logProblem( e );
                }
                setQuantityScale();
                int rowIndex = tblFoodFacts.find( foodid );
                tblFoodFacts.showRow( rowIndex );
            }
        }
    }


    private void addFoodQuantityConstraint() {
        if ( checkFoodConstraint() ) {
            NumberCheck numberCheck = new NumberCheck();
            numberCheck.addToUncheckedList( txtFoodQuantityValue.getText() );
            if ( numberCheck.pass() ) {
                MixFoodDO foodDO = cmbFoodQuantityFood.getSelectedItem();
                NutrientDO nutrientDO = cmbFoodQuantityNutrient.getSelectedItem();
                RelationshipDO relationshipDO = cmbFoodQuantityRelationship.getSelectedItem();
                BigDecimal b = new BigDecimal( txtFoodQuantityValue.getText() );
                executeMergeFoodQuantityConstraintTasks( selectedMix, foodDO, nutrientDO, relationshipDO, b );
            } else {
                Message.showMessage( "Value must be a number greater than or equal to zero" );
            }
        }
    }


    private void executeMergeFoodQuantityConstraintTasks(
            MixDO mix, MixFoodDO foodDO, NutrientDO nutrientDO, RelationshipDO relationshipDO, BigDecimal b ) {
        try {
            Future<Boolean> task0 = BackgroundExec.submit( new MergeFoodConstraintTask(
                    mix.getMixid(),
                    foodDO.getFoodId(),
                    nutrientDO.getNutr_no(),
                    relationshipDO.getRelationshipid(),
                    b ) );
            Boolean completed = task0.get();
            if ( !completed ) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append( foodDO.getFoodName() );
            sb.append( " using " );
            sb.append( nutrientDO.getNutrdesc() );
            sb.append( " " );
            sb.append( relationshipDO.getName() );
            sb.append( " " );
            sb.append( ( new DecimalFormat( "###0.0" ) ).format( b ) );
            addLogEntry(
                    selectedMixName,
                    "Add",
                    "Food Quantity Constraint",
                    sb.toString(),
                    selectedMixId,
                    foodDO.getFoodId(),
                    nutrientDO.getNutr_no(),
                    "",
                    "",
                    relationshipDO.getRelationshipid(),
                    b,
                    null );
            Future<List<List>> task1 = BackgroundExec.submit( new FoodConstraintsTask( mix.getMixid() ) );
            List<List> constraints = task1.get();
            tblFoodQuantityConstraint.reload( constraints );
            setConstraintCounts();
        } catch ( Exception e ) {
            LoggerImpl.INSTANCE.logProblem( e );
        }
    }


    private void deleteFoodQuantityConstraint() {
        if ( !tblFoodQuantityConstraint.isSelectionEmpty() ) {
            TableFoodQuantityConstraint.Row row = tblFoodQuantityConstraint.getSelectedValue();
            String mixid = row.getMixid();
            String foodid = row.getFoodid();
            String nutrientid = row.getNutrientid();
            Integer relationshipid = row.getRelationshipid();
            try {
                Future<Boolean> task0 = BackgroundExec.submit( new DeleteFoodConstraintTask( mixid, foodid, nutrientid, relationshipid ) );
                Boolean completed = task0.get();
                if ( !completed ) {
                    return;
                }
                StringBuilder sb = new StringBuilder();
                sb.append( row.getFood() );
                sb.append( " using " );
                sb.append( row.getNutrient() );
                sb.append( " " );
                sb.append( row.getRelationship() );
                sb.append( " " );
                sb.append( ( new DecimalFormat( "###0.0" ) ).format( row.getB() ) );
                addLogEntry(
                        selectedMixName,
                        "Delete",
                        "Food Quantity Constraint",
                        sb.toString(),
                        selectedMixId,
                        row.getFoodid(),
                        row.getNutrientid(),
                        "",
                        "",
                        row.getRelationshipid(),
                        row.getB(),
                        null );
                Future<List<List>> task1 = BackgroundExec.submit( new FoodConstraintsTask( mixid ) );
                List<List> constraints = task1.get();
                tblFoodQuantityConstraint.reload( constraints );
                setConstraintCounts();
            } catch ( Exception e ) {
                LoggerImpl.INSTANCE.logProblem( e );
            }
        }
    }


    private void blockFood() {
        MixFoodDO foodDO = cmbFoodQuantityFood.getSelectedItem();
        NutrientDO nutrientDO = new NutrientDO( "10000", "Other, Weight (g)", new BigDecimal( "-1" ) );
        RelationshipDO relationshipDO = new RelationshipDO( 3, "=" );
        BigDecimal b = new BigDecimal( "0.0" );
        executeMergeFoodQuantityConstraintTasks( selectedMix, foodDO, nutrientDO, relationshipDO, b );
    }


    private void blockGroup() {
        GroupDO groupDO = cmbFoodGroup.getSelectedItem();
        NutrientDO nutrientDO = new NutrientDO( "10000", "Other, Weight (g)", new BigDecimal( "-1" ) );
        RelationshipDO relationshipDO = new RelationshipDO( 3, "=" );
        BigDecimal b = new BigDecimal( "0.0" );
        executeMergeGroupQuantityConstraintTasks( selectedMix, groupDO, nutrientDO, relationshipDO, b );
    }


    private void addFoodRatioConstraint() {
        if ( checkFoodRatioConstraint() ) {
            NumberCheck numberCheck = new NumberCheck();
            numberCheck.addToUncheckedList( txtFoodNutrientRatioQuantityA.getText() );
            numberCheck.addToUncheckedList( txtFoodNutrientRatioQuantityB.getText() );
            if ( numberCheck.pass() ) {
                MixFoodDO foodDOA = cmbFoodRatioFoodA.getSelectedItem();
                NutrientDO nutrientDOA = cmbFoodRatioNutrientA.getSelectedItem();
                MixFoodDO foodDOB = cmbFoodRatioFoodB.getSelectedItem();
                NutrientDO nutrientDOB = cmbFoodRatioNutrientB.getSelectedItem();
                BigDecimal a = new BigDecimal( txtFoodNutrientRatioQuantityA.getText() );
                BigDecimal b = new BigDecimal( txtFoodNutrientRatioQuantityB.getText() );
                RelationshipDO relationshipDO = ( RelationshipDO ) cmbFoodRatioRelationship.getSelectedItem();
                try {
                    Future<Boolean> task0 = BackgroundExec.submit( new MergeFoodRatioConstraintTask(
                            selectedMixId,
                            foodDOA.getFoodId(),
                            nutrientDOA.getNutr_no(),
                            foodDOB.getFoodId(),
                            nutrientDOB.getNutr_no(),
                            relationshipDO.getRelationshipid(),
                            a,
                            b ) );
                    Boolean completed = task0.get();
                    if ( !completed ) {
                        return;
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append( foodDOA.getFoodName() );
                    sb.append( " using " );
                    sb.append( nutrientDOA.getNutrdesc() );
                    sb.append( " / " );
                    sb.append( foodDOB.getFoodName() );
                    sb.append( " using " );
                    sb.append( nutrientDOB.getNutrdesc() );
                    sb.append( " " );
                    sb.append( relationshipDO.getName() );
                    sb.append( " " );
                    sb.append( ( new DecimalFormat( "###0.0" ) ).format( a ) );
                    sb.append( " / " );
                    sb.append( ( new DecimalFormat( "###0.0" ) ).format( b ) );
                    addLogEntry(
                            selectedMixName,
                            "Add",
                            "Nutrient Ratio Constraint",
                            sb.toString(),
                            selectedMixId,
                            foodDOA.getFoodId(),
                            nutrientDOA.getNutr_no(),
                            foodDOB.getFoodId(),
                            nutrientDOB.getNutr_no(),
                            relationshipDO.getRelationshipid(),
                            a,
                            b );
                    Future<List<List>> task1 = BackgroundExec.submit( new FoodRatioConstraintsTask( selectedMixId ) );
                    List<List> constraints = task1.get();
                    tblFoodRatioConstraint.reload( constraints );
                    setConstraintCounts();
                } catch ( Exception e ) {
                    LoggerImpl.INSTANCE.logProblem( e );
                }
            } else {
                Message.showMessage( "Value must be number greater than zero" );
            }
        }
    }


    private void deleteFoodRatioConstraint() {
        if ( !tblFoodRatioConstraint.isSelectionEmpty() ) {
            TableFoodRatioConstraint.Row row = tblFoodRatioConstraint.getSelectedValue();
            String mixid = row.getMixid();
            String foodidA = row.getFoodida();
            String nutrientidA = row.getNutrientida();
            String foodidB = row.getFoodidb();
            String nutrientidB = row.getNutrientidb();
            Integer relationshipid = row.getRelationshipid();
            try {
                Future<Boolean> task0 = BackgroundExec.submit( new DeleteFoodRatioConstraintTask(
                        mixid, foodidA, nutrientidA, foodidB, nutrientidB, relationshipid ) );
                Boolean completed = task0.get();
                if ( !completed ) {
                    return;
                }
                StringBuilder sb = new StringBuilder();
                sb.append( row.getFooda() );
                sb.append( " using " );
                sb.append( row.getNutrienta() );
                sb.append( " / " );
                sb.append( row.getFoodb() );
                sb.append( " using " );
                sb.append( row.getNutrientb() );
                sb.append( " " );
                sb.append( row.getRelationship() );
                sb.append( " " );
                sb.append( ( new DecimalFormat( "###0.0" ) ).format( row.getA() ) );
                sb.append( " / " );
                sb.append( ( new DecimalFormat( "###0.0" ) ).format( row.getB() ) );
                addLogEntry(
                        selectedMixName,
                        "Delete",
                        "Food Ratio Constraint",
                        sb.toString(),
                        selectedMixId,
                        row.getFoodida(),
                        row.getNutrientida(),
                        row.getFoodidb(),
                        row.getNutrientidb(),
                        row.getRelationshipid(),
                        row.getA(),
                        row.getB() );
                Future<List<List>> task1 = BackgroundExec.submit( new FoodRatioConstraintsTask( mixid ) );
                List<List> constraints = task1.get();
                tblFoodRatioConstraint.reload( constraints );
                setConstraintCounts();
            } catch ( Exception e ) {
                LoggerImpl.INSTANCE.logProblem( e );
            }
        }
    }


    private void addFoodPortion() {
        NumberCheck checkNumber = new NumberCheck();
        Double pcti = Double.NaN;
        checkNumber.addToUncheckedList( txtPortionPct.getText() );
        if ( checkNumber.pass() ) {
            String mixid = selectedMixId;
            String foodid = cmbPortionFood.getSelectedItem().getFoodId();
            List<TablePortionMeals.Row> rows = tblMeals.getSelectedValues();
            double pct = Double.parseDouble( txtPortionPct.getText() );
            int n = rows.size();
            pcti = pct / n;
            for ( Row row : rows ) {
                try {
                    Future<Boolean> task0 = BackgroundExec.submit(
                            new InsertAndCalculateFoodPortionTask( mixid, row.getMealid(), foodid, pcti ) );
                    Boolean complete = task0.get();
                    if ( complete ) {
                        executeMealPlanPortionsTasks( selectedMix );
                    }
                } catch ( Exception e ) {
                    LoggerImpl.INSTANCE.logProblem( e );
                }
            }
        } else {
            Message.showMessage( "Character must be number." );
        }
    }


    private void executeMealPlanPortionsTasks( MixDO mix ) {
        try {
            Future<List<List>> task1 = BackgroundExec.submit( new MealPlanPortionsTask( mix.getMixid() ) );
            List<List> portions = task1.get();
            tblMealPortions.reload( portions );
        } catch ( Exception e ) {
            LoggerImpl.INSTANCE.logProblem( e );
        }
        try {
            Future<List<List>> task = BackgroundExec.submit( new MealPlanResultsTask( mix.getMixid() ) );
            List<List> results = task.get();
            if ( results.size() > 1 ) {
                tblMealCalories.reload( results );
            } else {
                tblMealCalories.clear();
            }
        } catch ( Exception e ) {
            LoggerImpl.INSTANCE.logProblem( e );
        }
        try {
            Future<List<List>> task = BackgroundExec.submit( new MealPlanResultsMacronutrientsTask( mix.getMixid() ) );
            List<List> results = task.get();
            if ( results.size() > 1 ) {
                tblMealMacronutrients.reload( results );
            } else {
                tblMealMacronutrients.clear();
            }
        } catch ( Exception e ) {
            LoggerImpl.INSTANCE.logProblem( e );
        }
    }


    private void deleteFoodPortion() {
        if ( !tblMealPortions.isSelectionEmpty() ) {
            try {
                List<TablePortion.Row> rows = tblMealPortions.getSelectedValues();
                for ( TablePortion.Row row : rows ) {
                    try {
                        Future<Boolean> task0 = BackgroundExec.submit(
                                new DeleteFoodPortionTask( row.getMixid(), row.getMealid(), row.getFoodid() ) );
                        Boolean complete = task0.get();
                        if ( complete ) {
                            executeMealPlanPortionsTasks( new MixDO( row.getMixid() ) );
                        }
                    } catch ( Exception e ) {
                        LoggerImpl.INSTANCE.logProblem( e );
                    }
                }
            } catch ( Exception e ) {
                LoggerImpl.INSTANCE.logProblem( e );
            }
        } else {
            Message.showMessage( "Please select row or rows." );
        }
    }


    private void updateFoodPortionWeight() {
        JTextField txtInput = new JTextField();
        txtInput.setPreferredSize( new Dimension( 50, 25 ) );
        if ( !tblMealPortions.isSelectionEmpty() ) {
            TablePortion.Row row = tblMealPortions.getSelectedValue();
            BigDecimal actualwt = row.getActual();
            txtInput.setText( actualwt.toPlainString() );
            JPanel pnlInput = new JPanel();
            pnlInput.add( new JLabel( "Actual Weight: " ) );
            pnlInput.add( txtInput );
            JComponent[] inputs = { pnlInput };
            int optionValue = Message.showOptionDialogOkCancel( inputs, "Update Actual Weight" );
            if ( optionValue == 0 ) {
                try {
                    String mixid = row.getMixid();
                    Integer mealid = row.getMealid();
                    String foodid = row.getFoodid();
                    Future<Boolean> task0 = BackgroundExec.submit( new UpdateFoodPortionActualWeightTask(
                            mixid, mealid, foodid, new BigDecimal( txtInput.getText() ) ) );
                    Boolean complete = task0.get();
                    if ( complete ) {
                        executeMealPlanPortionsTasks( new MixDO( mixid ) );
                    }
                } catch ( Exception e ) {
                    LoggerImpl.INSTANCE.logProblem( e );
                }
            }
        }
    }


    private void addMeal() {
        JTextField txtMealName = new JTextField();
        JTextField txtMealOrder = new JTextField();
        JPanel pnl = new JPanel();
        FormLayout lyo = new FormLayout(
                "28dlu,34dlu,100dlu", // columns
                "fill:28px,4dlu,fill:28px" // rows
        );
        pnl.setLayout( lyo );
        JLabel lblMealName = new JLabel( "Name: " );
        lblMealName.setHorizontalAlignment( SwingConstants.RIGHT );
        pnl.add( lblMealName, cc.xy( 1, 1 ) );
        pnl.add( txtMealName, cc.xyw( 2, 1, 2 ) );
        JLabel lblMealOrder = new JLabel( "Order: " );
        lblMealOrder.setHorizontalAlignment( SwingConstants.RIGHT );
        pnl.add( lblMealOrder, cc.xy( 1, 3 ) );
        pnl.add( txtMealOrder, cc.xy( 2, 3 ) );
        JComponent[] inputs = { pnl };
        int optionValue = Message.showOptionDialogOkCancel( inputs, "Add Meal" );
        if ( optionValue == 0 ) {
            NumberCheck checkNumber = new NumberCheck();
            checkNumber.addToUncheckedList( txtMealOrder.getText() );
            if ( checkNumber.pass() ) {
                String mealname = txtMealName.getText();
                Integer mealorder = Integer.valueOf( txtMealOrder.getText() );
                try {
                    Future<Integer> task
                            = BackgroundExec.submit( new CreateMealTask( selectedMixId, mealname, mealorder ) );
                    Integer mealid = task.get();
                } catch ( Exception e ) {
                    LoggerImpl.INSTANCE.logProblem( e );
                }
                try {
                    Future<List<List>> task = BackgroundExec.submit( new MealPlanMealsTask( selectedMixId ) );
                    List<List> meals = task.get();
                    tblMeals.reload( meals );
                } catch ( Exception e ) {
                    LoggerImpl.INSTANCE.logProblem( e );
                }
            }
        }
    }


    private void deleteMeal() {
        if ( !tblMeals.isSelectionEmpty() ) {
            Row meal = tblMeals.getSelectedValue();
            try {
                Future<Boolean> task = BackgroundExec.submit( new DeleteMealTask( meal.getMixid(), meal.getMealid() ) );
                Boolean completed = task.get();
                if ( !completed ) {
                    return;
                }
            } catch ( Exception e ) {
                LoggerImpl.INSTANCE.logProblem( e );
            }
            try {
                Future<List<List>> task = BackgroundExec.submit( new MealPlanMealsTask( selectedMixId ) );
                List<List> meals = task.get();
                tblMeals.reload( meals );
            } catch ( Exception e ) {
                LoggerImpl.INSTANCE.logProblem( e );
            }
            executeMealPlanPortionsTasks( selectedMix );
        }
    }


    private void updateMeal() {
        JTextField txtMealName = new JTextField();
        JTextField txtMealOrder = new JTextField();
        if ( !tblMeals.isSelectionEmpty() ) {
            Row row = tblMeals.getSelectedValue();
            // String mixid = row.getMixid();
            Integer mealid = row.getMealid();
            String mealname = row.getMealname();
            Integer mealorder = row.getMealorder();
            txtMealName.setText( mealname );
            txtMealOrder.setText( String.valueOf( mealorder ) );
            JPanel pnl = new JPanel();
            FormLayout lyo = new FormLayout(
                    "28dlu,34dlu,100dlu", // columns
                    "fill:28px,4dlu,fill:28px" // rows
            );
            pnl.setLayout( lyo );
            JLabel lblMealName = new JLabel( "Name: " );
            lblMealName.setHorizontalAlignment( SwingConstants.RIGHT );
            pnl.add( lblMealName, cc.xy( 1, 1 ) );
            pnl.add( txtMealName, cc.xyw( 2, 1, 2 ) );
            JLabel lblMealOrder = new JLabel( "Order: " );
            lblMealOrder.setHorizontalAlignment( SwingConstants.RIGHT );
            pnl.add( lblMealOrder, cc.xy( 1, 3 ) );
            pnl.add( txtMealOrder, cc.xy( 2, 3 ) );
            JComponent[] inputs = { pnl };
            int optionValue = Message.showOptionDialogOkCancel( inputs, "Update Meal" );
            if ( optionValue == 0 ) {
                NumberCheck checkNumber = new NumberCheck();
                checkNumber.addToUncheckedList( txtMealOrder.getText() );
                if ( checkNumber.pass() ) {
                    mealname = txtMealName.getText();
                    mealorder = Integer.valueOf( txtMealOrder.getText() );
                    try {
                        Future<Boolean> task
                                = BackgroundExec.submit( new UpdateMealTask( selectedMixId, mealid, mealname, mealorder ) );
                        Boolean completed = task.get();
                        if ( !completed ) {
                            return;
                        }
                    } catch ( Exception e ) {
                        LoggerImpl.INSTANCE.logProblem( e );
                    }
                    try {
                        Future<List<List>> task = BackgroundExec.submit( new MealPlanMealsTask( selectedMixId ) );
                        List<List> meals = task.get();
                        tblMeals.reload( meals );
                    } catch ( Exception e ) {
                        LoggerImpl.INSTANCE.logProblem( e );
                    }
                    executeMealPlanPortionsTasks( selectedMix );
                }
            }
        }
    }


    private void addMixFood() {
        DefaultMutableTreeNode node = ( DefaultMutableTreeNode ) tree.getLastSelectedPathComponent();
        if ( node == null ) {
            return;
        }
        if ( node.isLeaf() ) {
            try {
                MixFoodDO food = ( MixFoodDO ) node.getUserObject();
                String foodId = food.getFoodId();
                String foodName = food.getFoodName();
                Future<Boolean> task0 = BackgroundExec.submit( new InsertMixFoodTask( selectedMixId, foodId ) );
                Boolean completed = task0.get();
                if ( !completed ) {
                    return;
                }
                addLogEntry(
                        selectedMixName, "Add", "Food", foodName, selectedMixId, foodId, "", "", "", null, null, null );
                try {
                    Future<List<List>> task1 = BackgroundExec.submit( new NamedMixFoodSortedByNameTask( selectedMixId ) );
                    List<List> foods = task1.get();
                    tblMixFood.reload( foods );
                    tblSelectedFoods.reload( foods );
                } catch ( Exception e ) {
                    LoggerImpl.INSTANCE.logProblem( e );
                }
                reloadFoodComboBoxes( selectedMixId );
            } catch ( Exception e ) {
                LoggerImpl.INSTANCE.logProblem( e );
            }
        }
    }


    private void collapseFoods() {
        int rowCount = tree.getRowCount();
        for ( int i = 1; i < rowCount; i++ ) {
            tree.collapseRow( i );
        }
    }


    private void deleteMixFood() {
        TableFood.Row food = tblMixFood.getSelectedValue();
        if ( food.isNull() ) {
            return;
        }
        String selectedFoodId = food.getFoodid();
        String selectedFoodName = food.getFoodname();
        try {
            Future<Boolean> task = BackgroundExec.submit( new DeleteMixFoodTask( selectedMixId, selectedFoodId ) );
            Boolean completed = task.get();
            if ( !completed ) {
                return;
            }
        } catch ( Exception e ) {
            LoggerImpl.INSTANCE.logProblem( e );
        }
        addLogEntry(
                selectedMixName,
                "Delete",
                "Food",
                selectedFoodName,
                selectedMixId,
                selectedFoodId,
                "",
                "",
                "",
                null,
                null,
                null );
        try {
            Future<List<List>> task = BackgroundExec.submit( new NamedMixFoodSortedByNameTask( selectedMixId ) );
            List<List> foods = task.get();
            tblMixFood.reload( foods );
            tblSelectedFoods.reload( foods );
        } catch ( Exception e ) {
            LoggerImpl.INSTANCE.logProblem( e );
        }
        reloadFoodComboBoxes( selectedMixId );
        reloadMixConstraints( selectedMixId );
        try {
            Future<List<List>> task = BackgroundExec.submit( new MixResultsTask( selectedMixId ) );
            List<List> results = task.get();
            if ( results.isEmpty() ) {
                return;
            }
            tblMixResults.reload( results );
        } catch ( Exception e ) {
            LoggerImpl.INSTANCE.logProblem( e );
        }
        executeMealPlanPortionsTasks( selectedMix );
        LifeStageDO lifestage = ( LifeStageDO ) cmbLifestage.getSelectedItem();
        try {
            Future<List<List>> task = BackgroundExec.submit( new DriDiffTask( selectedMixId, lifestage.getLifeStageId() ) );
            List<List> diff = task.get();
            tblDri.reload( diff );
            setQuantityScale();
        } catch ( Exception e ) {
            LoggerImpl.INSTANCE.logProblem( e );
        }
    }


    private void expandFoods() {
        int rowCount = tree.getRowCount();
        expandTree( tree, 0, rowCount );
    }


    private void addNutrientQuantityConstraint() {
        if ( checkNutrientQuantityConstraint() ) {
            NumberCheck numberCheck = new NumberCheck();
            numberCheck.addToUncheckedList( txtNutrientQuantityValue.getText() );
            if ( numberCheck.pass() ) {
                NutrientDO nutrientDO = cmbNutrientQuantityNutrient.getSelectedItem();
                RelationshipDO relationshipDO = ( RelationshipDO ) cmbNutrientQuantityRelationship.getSelectedItem();
                BigDecimal b = new BigDecimal( txtNutrientQuantityValue.getText() );
                try {
                    Future<Boolean> task0 = BackgroundExec.submit( new MergeNutrientConstraintTask(
                            selectedMixId, nutrientDO.getNutr_no(), relationshipDO.getRelationshipid(), b ) );
                    Boolean completed = task0.get();
                    if ( !completed ) {
                        return;
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append( nutrientDO.getNutrdesc() );
                    sb.append( " " );
                    sb.append( relationshipDO.getName() );
                    sb.append( " " );
                    sb.append( ( new DecimalFormat( "###0.0" ) ).format( b ) );
                    addLogEntry(
                            selectedMixName,
                            "Add",
                            "Nutrient Quantity Constraint",
                            sb.toString(),
                            selectedMixId,
                            "",
                            nutrientDO.getNutr_no(),
                            "",
                            "",
                            relationshipDO.getRelationshipid(),
                            b,
                            null );
                    Future<List<List>> task1
                            = BackgroundExec.submit( new NutrientConstraintsTask( selectedMixId ) );
                    List<List> constraints = task1.get();
                    tblNutrientQuantityConstraint.reload( constraints );
                    setConstraintCounts();
                } catch ( Exception e ) {
                    LoggerImpl.INSTANCE.logProblem( e );
                }
            } else {
                Message.showMessage( "Value must be a number greater than or equal to zero" );
            }
        }
    }


    private void deleteNutrientQuantityConstraint() {
        TableNutrientQuantity.Row row = tblNutrientQuantityConstraint.getSelectedValue();
        String mixid = String.valueOf( row.getMixid() );
        String nutrientid = row.getNutrientid();
        Integer relationshipid = row.getRelationshipid();
        try {
            Future<Boolean> task0
                    = BackgroundExec.submit( new DeleteNutrientConstraintTask( mixid, nutrientid, relationshipid ) );
            Boolean completed = task0.get();
            if ( !completed ) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append( row.getNutrient() );
            sb.append( " " );
            sb.append( row.getRelationship() );
            sb.append( " " );
            sb.append( ( new DecimalFormat( "###0.0" ) ).format( row.getB() ) );
            addLogEntry(
                    selectedMixName,
                    "Delete",
                    "Nutrient Quantity Constraint",
                    sb.toString(),
                    selectedMixId,
                    "",
                    row.getNutrientid(),
                    "",
                    "",
                    row.getRelationshipid(),
                    row.getB(),
                    null );
            Future<List<List>> task1 = BackgroundExec.submit( new NutrientConstraintsTask( mixid ) );
            List<List> constraints = task1.get();
            tblNutrientQuantityConstraint.reload( constraints );
            setConstraintCounts();
        } catch ( Exception e ) {
            LoggerImpl.INSTANCE.logProblem( e );
        }
    }


    private void addNutrientRatioConstraint() {
        if ( checkNutrientRatioConstraint() ) {
            NumberCheck numberCheck = new NumberCheck();
            numberCheck.addToUncheckedList( txtNutrientRatioNutrientA.getText() );
            numberCheck.addToUncheckedList( txtNutrientRatioNutrientB.getText() );
            if ( numberCheck.pass() ) {
                NutrientDO nutrientDOA = cmbNutrientRatioNutrientA.getSelectedItem();
                NutrientDO nutrientDOB = cmbNutrientRatioNutrientB.getSelectedItem();
                RelationshipDO relationshipDO = ( RelationshipDO ) cmbNutrientRatioRelationship.getSelectedItem();
                BigDecimal A = new BigDecimal( txtNutrientRatioNutrientA.getText() );
                BigDecimal B = new BigDecimal( txtNutrientRatioNutrientB.getText() );
                try {
                    Future<Boolean> task0 = BackgroundExec.submit( new MergeNutrientRatioConstraintTask(
                            selectedMixId,
                            nutrientDOA.getNutr_no(),
                            nutrientDOB.getNutr_no(),
                            relationshipDO.getRelationshipid(),
                            A,
                            B ) );
                    Boolean completed = task0.get();
                    if ( !completed ) {
                        return;
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append( nutrientDOA.getNutrdesc() );
                    sb.append( " / " );
                    sb.append( nutrientDOB.getNutrdesc() );
                    sb.append( " " );
                    sb.append( relationshipDO.getName() );
                    sb.append( " " );
                    sb.append( ( new DecimalFormat( "###0.0" ) ).format( A ) );
                    sb.append( " / " );
                    sb.append( ( new DecimalFormat( "###0.0" ) ).format( B ) );
                    addLogEntry(
                            selectedMixName,
                            "Add",
                            "Nutrient Ratio Constraint",
                            sb.toString(),
                            selectedMixId,
                            "",
                            nutrientDOA.getNutr_no(),
                            "",
                            nutrientDOB.getNutr_no(),
                            relationshipDO.getRelationshipid(),
                            A,
                            B );
                    Future<List<List>> task1 = BackgroundExec.submit( new NutrientRatioConstraintsTask( selectedMixId ) );
                    List<List> constraints = task1.get();
                    tblNutrientRatio.reload( constraints );
                    setConstraintCounts();
                } catch ( Exception e ) {
                    LoggerImpl.INSTANCE.logProblem( e );
                }
            } else {
                Message.showMessage( "Value must be a number greater than zero" );
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
            Future<Boolean> task0 = BackgroundExec.submit(
                    new DeleteNutrientRatioConstraintTask( mixid, nutrientaid, nutrientbid, relationshipid ) );
            Boolean completed = task0.get();
            if ( !completed ) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append( row.getNutrienta() );
            sb.append( " / " );
            sb.append( row.getNutrientb() );
            sb.append( " " );
            sb.append( row.getRelationship() );
            sb.append( " " );
            sb.append( ( new DecimalFormat( "###0.0" ) ).format( row.getA() ) );
            sb.append( " / " );
            sb.append( ( new DecimalFormat( "###0.0" ) ).format( row.getB() ) );
            addLogEntry(
                    selectedMixName,
                    "Delete",
                    "Nutrient Ratio Constraint",
                    sb.toString(),
                    selectedMixId,
                    "",
                    row.getNutrientaid(),
                    "",
                    row.getNutrientbid(),
                    row.getRelationshipid(),
                    row.getA(),
                    row.getB() );
            Future<List<List>> task1 = BackgroundExec.submit( new NutrientRatioConstraintsTask( mixid ) );
            List<List> constraints = task1.get();
            tblNutrientRatio.reload( constraints );
            setConstraintCounts();
        } catch ( Exception e ) {
            LoggerImpl.INSTANCE.logProblem( e );
        }
    }


    private Boolean solveModel( MixDO mix ) {
        Boolean solutionFound = false;
        LpsolvePrintOut print = new LpsolvePrintOut();
        LinearProgram program = new LinearProgram();
        String mixid = mix.getMixid();
        String mixname = mix.getName();
        Integer lifestageid = mix.getLifestageid();
        String lifestage = spnLifestage.getSelectedItem().getLabel();
        try {
            program.setComponent( getNoSolutionPanel() );
            // ----- MINIMIZATION OPTION -----
            switch ( minimizationOption ) {
                case 0 ->
                    minimizeDRIDeficiency( mixid, program, print, lifestageid );
                case 1 ->
                    minimizeDRIDeficiencyAndULExcess( mixid, program, print, lifestageid );
                case 2 ->
                    minimizeDRIDeficiencyAndDRIExcess( mixid, program, print, lifestageid );
                default ->
                    minimizeDRIDeficiency( mixid, program, print, lifestageid );
            }
            // ----- LEGENDS -----
            print.addMixLegend( mixname );
            print.addFoodLegend( createFoodLegend( mixid ) );
            solutionFound = program.solve();
            // ----- SOLVE MODEL -----
            if ( solutionFound ) {
                double[] solutionPoint = program.getPoint();
                Double theAvgDeficiency = solutionPoint[ solutionPoint.length - 2 ];
                Double theAvgExcess = solutionPoint[ solutionPoint.length - 1 ];
                // Cost may be deficiency, deficiency + ul excess or deficiency + dri excess
                Double theCost = program.getCost();
                double tni = calculateTni( theAvgDeficiency );
                BigDecimal deficiency = new BigDecimal( theAvgDeficiency, MathContext.DECIMAL128 );
                BigDecimal excess = new BigDecimal( theAvgExcess, MathContext.DECIMAL128 );
                BigDecimal cost = new BigDecimal( theCost, MathContext.DECIMAL128 );
                // System.out.println( mix.getName() + ": " + cost.toPlainString() );
                // ---- SET THE HIGH SCORE ----
                setTheHighScore( tni );
                // ---- ADD LOG ENTRIES ----
                addLogEntries( mix, lifestage, tni );
                // ----- CREATE LPSOLVE MODEL AND SET -----
                print.feasible();
                String model = print.toString();
                // ---- UPDATE DATABASE -----
                Runnable tasks = () -> {
                    MixFoodsQuery q = new MixFoodsQuery( mixid );
                    List<Map> mixfoodlist = q.get();
                    for ( int i = 0; i < mixfoodlist.size(); i++ ) {
                        Map row = mixfoodlist.get( i );
                        String foodid = ( String ) row.get( "FOODID" );
                        BigDecimal x = new BigDecimal( solutionPoint[ i ], MathContext.DECIMAL128 );
                        ( new UpdateMixFoodAction( mixid, foodid, x ) ).execute();
                    }
                    ( new AllocateAction( mixid ) ).execute();
                    ( new UpdateMixAction( mixid, lifestageid, model, cost, deficiency, excess ) ).execute();
                };
                BackgroundExec.execute( tasks );
                //
                mix.setModel( model );
                mix.setCost( cost );
                mix.setDeficiency( deficiency );
                mix.setExcess( excess );
                FileName fileName = new FileName();
                if ( chkLpsolve.isSelected() ) {
                    Utilities.write( fileName.getLpsolveFileName(), model );
                }
            } else {
                // ----- CREATE LPSOLVE MODEL AND SET -----
                print.unfeasible();
                String model = print.toString();
                // ----- UPDATE DATABASE -----
                Runnable tasks = () -> {
                    ( new UpdateMixAction(
                            mixid,
                            lifestageid,
                            model,
                            new BigDecimal( "1.0" ),
                            new BigDecimal( "1.0" ),
                            new BigDecimal( "1.0" ) ) )
                            .execute();
                };
                BackgroundExec.execute( tasks );
                //
                mix.setModel( model );
                mix.setCost( new BigDecimal( "1.0" ) );
            }
            setConstraintCounts();
        } catch ( Exception e ) {
            LoggerImpl.INSTANCE.logProblem( e );
        }
        return solutionFound;
    }


    public double calculateTni( Double avgDeficiency ) {
        return ( 1 - avgDeficiency ) * 100.0;
    }


    private void addLogEntries( MixDO mix, String lifestage, Double score ) {
        addLogEntry( mix.getName(), "Add", "Lifestage", lifestage, mix.getMixid(), "", "", "", "", null, null, null );
        addLogEntry(
                mix.getName(),
                "Add",
                "Minimization Option",
                txtMinimization.getText(),
                mix.getMixid(),
                "",
                "",
                "",
                "",
                null,
                null,
                null );
        addLogEntry(
                mix.getName(),
                "Solve",
                "Total Nutrient Index Score",
                String.valueOf( score ),
                mix.getMixid(),
                "",
                "",
                "",
                "",
                null,
                null,
                null );
    }


    private void minimizeDRIDeficiency(
            String mixid, LinearProgram program, LpsolvePrintOut print, Integer lifestageid ) {
        // ----- OBJECTIVE FUNCTION - Minimizes DRI Deficiency -----
        createDeficiencyObjectiveFunction( mixid, program, print );
        // ----- DRI DEVIATION TNI CONSTRAINTS -----
        createDriDeviationTniConstraint( mixid, lifestageid, program, print );
        // ----- DRI DEVIATION SUM DEFICIENCY CONSTRAINT -----
        createDriDeviationSumDeficiencyConstraint( mixid, lifestageid, program, print );
        // ----- NUTRIENT CONSTRAINTS -----
        createNutrientConstraints( mixid, program, print );
        // ----- NUTRIENT RATIO CONSTRAINTS -----
        createNutrientRatioConstraint( mixid, program, print );
        // ----- FOOD CONSTRAINTS -----
        createFoodConstraint( mixid, program, print );
        // ----- FOOD RATIO CONSTRAINTS -----
        createFoodRatioConstraint( mixid, program, print );
        // ----- GROUP CONSTRAINTS -----
        createGroupConstraint( mixid, program, print );
    }


    private void minimizeDRIDeficiencyAndULExcess(
            String mixid, LinearProgram program, LpsolvePrintOut print, Integer lifestageid ) {
        // ----- OBJECTIVE FUNCTION - Minimizes DRI Deficiency and UL Excess -----
        createDeficiencyAndExcessObjectiveFunction( mixid, program, print );
        // ----- DRI DEVIATION TNI CONSTRAINTS -----
        createDriDeviationTniConstraint( mixid, lifestageid, program, print );
        // ----- DRI DEVIATION SUM DEFICIENCY CONSTRAINT -----
        createDriDeviationSumDeficiencyConstraint( mixid, lifestageid, program, print );
        // ----- UL DEVIATION SUM EXCESS CONSTRAINT -----
        createULDeviationSumExcessConstraint( mixid, lifestageid, program, print );
        // ----- NUTRIENT CONSTRAINTS -----
        createNutrientConstraints( mixid, program, print );
        // ----- NUTRIENT RATIO CONSTRAINTS -----
        createNutrientRatioConstraint( mixid, program, print );
        // ----- FOOD CONSTRAINTS -----
        createFoodConstraint( mixid, program, print );
        // ----- FOOD RATIO CONSTRAINTS -----
        createFoodRatioConstraint( mixid, program, print );
        // ----- GROUP CONSTRAINTS -----
        createGroupConstraint( mixid, program, print );
    }


    private void minimizeDRIDeficiencyAndDRIExcess(
            String mixid, LinearProgram program, LpsolvePrintOut print, Integer lifestageid ) {
        // ----- OBJECTIVE FUNCTION - Minimizes DRI Deficiency and DRI Excess -----
        createDeficiencyAndExcessObjectiveFunction( mixid, program, print );
        // ----- DRI DEVIATION TNI CONSTRAINTS -----
        createDriDeviationTniConstraint( mixid, lifestageid, program, print );
        // ----- DRI DEVIATION SUM DEFICIENCY CONSTRAINT -----
        createDriDeviationSumDeficiencyConstraint( mixid, lifestageid, program, print );
        // ----- DRI DEVIATION SUM EXCESS CONSTRAINT -----
        createDriDeviationSumExcessConstraint( mixid, lifestageid, program, print );
        // ----- NUTRIENT CONSTRAINTS -----
        createNutrientConstraints( mixid, program, print );
        // ----- NUTRIENT RATIO CONSTRAINTS -----
        createNutrientRatioConstraint( mixid, program, print );
        // ----- FOOD CONSTRAINTS -----
        createFoodConstraint( mixid, program, print );
        // ----- FOOD RATIO CONSTRAINTS -----
        createFoodRatioConstraint( mixid, program, print );
        // ----- GROUP CONSTRAINTS -----
        createGroupConstraint( mixid, program, print );
    }


    private void setTheHighScore( Double tni ) {
        listModelHighScore.addElement( ( new DecimalFormat( "###0.00000" ) ).format( tni ) );
        lstHighScore.ensureIndexIsVisible( listModelHighScore.getSize() - 1 );
        lstHighScore.setSelectedIndex( lstHighScore.getLastVisibleIndex() );
    }


    private String createFoodLegend( String mixid ) {
        StringBuilder sb = new StringBuilder();
        try {
            Future<List<Map<String, String>>> task = BackgroundExec.submit( new NamedMixFoodSortedByIdTask( mixid ) );
            List<Map<String, String>> source = task.get();
            if ( source.isEmpty() ) {
                return "";
            }
            List<MixFoodDO> foodsInMix = new ArrayList();
            source.forEach( row -> {
                String foodid = row.get( "FOODID" );
                String name = row.get( "NAME" );
                foodsInMix.add( new MixFoodDO( foodid, name ) );
            } );
            for ( int i = 0; i < foodsInMix.size(); i++ ) {
                sb.append( String.format( "%1$2d) %2$s", i + 1, foodsInMix.get( i ).getFoodName() ) );
                sb.append( "\n" );
            }
            if ( sb.length() > 0 ) {
                sb.setLength( sb.length() - 1 );
            }
        } catch ( Exception e ) {
            LoggerImpl.INSTANCE.logProblem( e );
        }
        return sb.toString();
    }


    private void createDeficiencyObjectiveFunction( String mixid, LinearProgram lpmodel, LpsolvePrintOut lpsolve ) {
        try {
            Future<LhsContainer> taskLhs = BackgroundExec.submit( new DriDevObjectiveDeficiencyLhsTask( mixid ) );
            LhsContainer container = taskLhs.get();
            double[] coefficients = container.getCoefficients();
            lpmodel.addObjectiveFunction( coefficients );
            lpsolve.addObjectiveFunction( coefficients, "Minimize" );
        } catch ( Exception e ) {
            LoggerImpl.INSTANCE.logProblem( e );
        }
    }


    private void createDeficiencyAndExcessObjectiveFunction(
            String mixid, LinearProgram lpmodel, LpsolvePrintOut lpsolve ) {
        try {
            Future<LhsContainer> taskLhs = BackgroundExec.submit( new DriDevObjectiveLhsTask( mixid ) );
            LhsContainer container = taskLhs.get();
            double[] coefficients = container.getCoefficients();
            lpmodel.addObjectiveFunction( coefficients );
            lpsolve.addObjectiveFunction( coefficients, "Minimize" );
        } catch ( Exception e ) {
            LoggerImpl.INSTANCE.logProblem( e );
        }
    }


    private void createNutrientConstraints( String mixid, LinearProgram lpmodel, LpsolvePrintOut lpsolve ) {
        try {
            Future<List<Map<String, Object>>> taskRhs = BackgroundExec.submit( new NutrientRhsTask( mixid ) );
            List<Map<String, Object>> lst = taskRhs.get();
            lst.forEach( ( row ) -> {
                try {
                    String nutrientid = ( String ) row.get( "NUTRIENTID" );
                    Integer relationshipid = ( Integer ) row.get( "RELATIONSHIPID" );
                    Double b = ( Double ) row.get( "B" );
                    String nutrient = ( String ) row.get( "NUTRIENT" );
                    String eq = ( String ) row.get( "EQ" );
                    Future<LhsContainer> taskLhs = BackgroundExec.submit( new DriDevNutrientLhsTask( mixid, nutrientid ) );
                    LhsContainer container = taskLhs.get();
                    double[] coefficients = container.getCoefficients();
                    lpmodel.addConstraint( coefficients, relationshipid, b );
                    StringBuilder constraintName = new StringBuilder();
                    constraintName
                            .append( nutrient )
                            .append( " " )
                            .append( eq )
                            .append( " " )
                            .append( b );
                    lpsolve.addNutrientConstraint( coefficients, relationshipid, b, constraintName.toString() );
                } catch ( Exception e ) {
                    LoggerImpl.INSTANCE.logProblem( e );
                }
            } );
        } catch ( Exception e ) {
            LoggerImpl.INSTANCE.logProblem( e );
        }
    }


    private void createNutrientRatioConstraint( String mixid, LinearProgram lpmodel, LpsolvePrintOut lpsolve ) {
        try {
            Future<List<Map<String, Object>>> task = BackgroundExec.submit( new NutrientRatioRhsTask( mixid ) );
            List<Map<String, Object>> lst = task.get();
            lst.forEach( ( row ) -> {
                try {
                    String nutrientid1 = ( String ) row.get( "NUTRIENT_ID_1" );
                    String nutrientid2 = ( String ) row.get( "NUTRIENT_ID_2" );
                    int relationshipid = ( int ) row.get( "RELATIONSHIPID" );
                    BigDecimal a = ( BigDecimal ) row.get( "A" );
                    BigDecimal b = ( BigDecimal ) row.get( "B" );
                    String nutrient1 = ( String ) row.get( "NUTRIENT1" );
                    String nutrient2 = ( String ) row.get( "NUTRIENT2" );
                    String eq = ( String ) row.get( "EQ" );
                    Future<double[]> taskLhs = BackgroundExec.submit(
                            new NutrientRatioLhsTask( mixid, nutrientid1, nutrientid2, relationshipid ) );
                    double[] coefficients = taskLhs.get();
                    lpmodel.addConstraint( coefficients, relationshipid, 0.0 );
                    StringBuilder constraintName = new StringBuilder();
                    constraintName
                            .append( nutrient1 )
                            .append( " / " )
                            .append( nutrient2 )
                            .append( " " )
                            .append( eq )
                            .append( " " )
                            .append( a )
                            .append( " / " )
                            .append( b );
                    lpsolve.addNutrientRatioConstraint( coefficients, relationshipid, 0.0, constraintName.toString() );
                } catch ( Exception e ) {
                    LoggerImpl.INSTANCE.logProblem( e );
                }
            } );
        } catch ( Exception e ) {
            LoggerImpl.INSTANCE.logProblem( e );
        }
    }


    private void createFoodConstraint( String mixid, LinearProgram lpmodel, LpsolvePrintOut lpsolve ) {
        try {
            Future<List<Map<String, Object>>> task = BackgroundExec.submit( new FoodRhsTask( mixid ) );
            List<Map<String, Object>> lst = task.get();
            lst.forEach( ( row ) -> {
                try {
                    String foodid = ( String ) row.get( "FOODID" );
                    String nutrientid = ( String ) row.get( "NUTRIENTID" );
                    Integer relationshipid = ( Integer ) row.get( "RELATIONSHIPID" );
                    Double b = ( double ) row.get( "B" );
                    String food = ( String ) row.get( "FOOD" );
                    String nutrient = ( String ) row.get( "NUTRIENT" );
                    String eq = ( String ) row.get( "EQ" );
                    Future<double[]> taskLhs
                            = BackgroundExec.submit( new FoodLhsTask( mixid, foodid, nutrientid, relationshipid ) );
                    double[] coefficients = taskLhs.get();
                    lpmodel.addConstraint( coefficients, relationshipid, b );
                    StringBuilder constraintName = new StringBuilder();
                    constraintName
                            .append( food )
                            .append( " AS " )
                            .append( nutrient )
                            .append( " " )
                            .append( eq )
                            .append( " " )
                            .append( b );
                    lpsolve.addFoodConstraint( coefficients, relationshipid, b, constraintName.toString() );
                } catch ( Exception e ) {
                    LoggerImpl.INSTANCE.logProblem( e );
                }
            } );
        } catch ( Exception e ) {
            LoggerImpl.INSTANCE.logProblem( e );
        }
    }


    private void createFoodRatioConstraint( String mixid, LinearProgram lpmodel, LpsolvePrintOut lpsolve ) {
        try {
            Future<List<Map<String, Object>>> task = BackgroundExec.submit( new FoodRatioRhsTask( mixid ) );
            List<Map<String, Object>> lst = task.get();
            lst.forEach( ( row ) -> {
                try {
                    String foodid1 = ( String ) row.get( "FOOD_ID_1" );
                    String nutrientid1 = ( String ) row.get( "NUTRIENT_ID_1" );
                    String foodid2 = ( String ) row.get( "FOOD_ID_2" );
                    String nutrientid2 = ( String ) row.get( "NUTRIENT_ID_2" );
                    int relationshipid = ( int ) row.get( "RELATIONSHIPID" );
                    BigDecimal a = ( BigDecimal ) row.get( "A" );
                    BigDecimal b = ( BigDecimal ) row.get( "B" );
                    String food1 = ( String ) row.get( "FOOD1" );
                    String nutrient1 = ( String ) row.get( "NUTRIENT1" );
                    String food2 = ( String ) row.get( "FOOD2" );
                    String nutrient2 = ( String ) row.get( "NUTRIENT2" );
                    String eq = ( String ) row.get( "EQ" );
                    Future<double[]> taskLhs = BackgroundExec.submit(
                            new FoodRatioLhsTask( mixid, foodid1, nutrientid1, foodid2, nutrientid2, relationshipid ) );
                    double[] coefficients = taskLhs.get();
                    lpmodel.addConstraint( coefficients, relationshipid, 0.0 );
                    StringBuilder constraintName = new StringBuilder();
                    constraintName
                            .append( food1 )
                            .append( " AS " )
                            .append( nutrient1 )
                            .append( " / " )
                            .append( food2 )
                            .append( " AS " )
                            .append( nutrient2 )
                            .append( " " )
                            .append( eq )
                            .append( " " )
                            .append( a )
                            .append( " / " )
                            .append( b );
                    lpsolve.addFoodRatioConstraint( coefficients, relationshipid, 0.0, constraintName.toString() );
                } catch ( Exception e ) {
                    LoggerImpl.INSTANCE.logProblem( e );
                }
            } );
        } catch ( Exception e ) {
            LoggerImpl.INSTANCE.logProblem( e );
        }
    }


    private void createGroupConstraint( String mixid, LinearProgram lpmodel, LpsolvePrintOut lpsolve ) {
        try {
            Future<List<Map<String, Object>>> task = BackgroundExec.submit( new GroupRhsTask( mixid ) );
            List<Map<String, Object>> lst = task.get();
            lst.forEach( ( row ) -> {
                try {
                    String groupid = ( String ) row.get( "GROUPID" );
                    String nutrientid = ( String ) row.get( "NUTRIENTID" );
                    Integer relationshipid = ( Integer ) row.get( "RELATIONSHIPID" );
                    Double b = ( double ) row.get( "B" );
                    String group = ( String ) row.get( "GROUP" );
                    String nutrient = ( String ) row.get( "NUTRIENT" );
                    String eq = ( String ) row.get( "EQ" );
                    Future<double[]> taskLhs
                            = BackgroundExec.submit( new GroupLhsTask( mixid, groupid, nutrientid, relationshipid ) );
                    double[] coefficients = taskLhs.get();
                    lpmodel.addConstraint( coefficients, relationshipid, b );
                    StringBuilder constraintName = new StringBuilder();
                    constraintName
                            .append( group )
                            .append( " AS " )
                            .append( nutrient )
                            .append( " " )
                            .append( eq )
                            .append( " " )
                            .append( b );
                    lpsolve.addGroupQuantityConstraint( coefficients, relationshipid, b, constraintName.toString() );
                } catch ( Exception e ) {
                    LoggerImpl.INSTANCE.logProblem( e );
                }
            } );
        } catch ( Exception e ) {
            LoggerImpl.INSTANCE.logProblem( e );
        }
    }


    private void calculateRemainingFoodAllocationPercentage() {
        if ( !cmbPortionFood.isSelectionEmpty() ) {
            try {
                MixFoodDO food = cmbPortionFood.getSelectedItem();
                String mixid = selectedMixId;
                String foodid = food.getFoodId();
                Future<BigDecimal> task = BackgroundExec.submit( new UnallocatedFoodPercentageTask( mixid, foodid ) );
                BigDecimal remaining = task.get();
                String fRemaining = ( new DecimalFormat( "###0.0" ) ).format( remaining );
                txtTotalPct.setText( fRemaining );
            } catch ( Exception e ) {
                LoggerImpl.INSTANCE.logProblem( e );
            }
        }
    }


    private void clearHighscore() {
        listModelHighScore.clear();
    }


    private void showPopup( MouseEvent e, JPopupMenu pmn ) {
        if ( SwingUtilities.isRightMouseButton( e ) ) {
            Component component = e.getComponent();
            pmn.show( component, e.getX(), e.getY() );
        }
    }


    private void showAbout() {
        JTextPane txp = new JTextPane();
        txp.setEditorKit( JEditorPane.createEditorKitForContentType( "text/html" ) );
        txp.setText( Utilities.getResourceAsString( "/resources/html/about.html" ) );
        txp.setEditable( false );
        txp.putClientProperty( JEditorPane.HONOR_DISPLAY_PROPERTIES, true );
        txp.setCaretPosition( 0 );
        txp.addHyperlinkListener( ( HyperlinkEvent e ) -> {
            if ( e.getEventType() == HyperlinkEvent.EventType.ACTIVATED ) {
                if ( Desktop.isDesktopSupported() ) {
                    Utilities.openUrl( e.getURL().toString() );
                }
            }
        } );
        JScrollPane scr = new JScrollPane( txp );
        scr.setPreferredSize( new Dimension( 800, 400 ) );
        scr.getVerticalScrollBar().setValue( 0 );
        JComponent[] inputs = { scr };
        Message.showOptionDialog( inputs, "About" );
    }


    private void moveFoodPortion() {
        if ( !tblMealPortions.isSelectionEmpty() ) {
            List<TablePortion.Row> rows = tblMealPortions.getSelectedValues();
            if ( !tblMeals.getSelectedValues().isEmpty() ) {
                List<Row> selectedMeals = tblMeals.getSelectedValues();
                for ( TablePortion.Row row : rows ) {
                    String mixid = row.getMixid();
                    Integer mealid = row.getMealid();
                    String foodid = row.getFoodid();
                    Double pct = row.getPct().doubleValue();
                    Double pcti = pct / selectedMeals.size();
                    try {
                        Future<Boolean> task0 = BackgroundExec.submit( new DeleteFoodPortionTask( mixid, mealid, foodid ) );
                        Boolean task0Complete = task0.get();
                        for ( Row meal : selectedMeals ) {
                            Future<Boolean> task1 = BackgroundExec.submit( new InsertAndCalculateFoodPortionTask(
                                    selectedMixId, meal.getMealid(), foodid, pcti ) );
                            Boolean task1Complete = task1.get();
                        }
                        executeMealPlanPortionsTasks( selectedMix );
                    } catch ( Exception e ) {
                        LoggerImpl.INSTANCE.logProblem( e );
                    }
                }
            } else {
                Message.showMessage( "Please select one or more meals." );
            }
        }
    }


    private void calculateBmr() {
        JTextField txtInput = new JTextField();
        JPanel pnl = new JPanel();
        txtInput.setPreferredSize( new Dimension( 50, 25 ) );
        pnl.add( new JLabel( "What is your lean body mass in pounds?" ) );
        pnl.add( txtInput );
        JComponent[] inputs = { pnl };
        int optionValue = Message.showOptionDialogOkCancel( inputs, "Basal Metabolic Rate" );
        if ( optionValue == 0 ) {
            String s = txtInput.getText();
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
                    Message.showMessagePadW510H150( "Basal Metabolic Rate", sb.toString() );
                } else {
                    Message.showMessage( "Numbers only" );
                }
            }
        }
    }


    private void convertMicronutrient() {
        FormLayout lyo = new FormLayout(
                "min:grow,min,30dlu", // columns
                "28px,fill:28px" // rows
        );
        JPanel pnl = new JPanel();
        pnl.setLayout( lyo );
        ComboBox<LifeStageDO> cmbLifeStage = new ComboBox();
        ComboBox<NutrientDO> cmbNutrients = new ComboBox();
        JLabel lblDV = new JLabel( StringUtils.center( "%DRI", 6 ) );
        try {
            Future<List<LifeStageDO>> task = BackgroundExec.submit( new LifestagesTask() );
            List<LifeStageDO> lifestages = task.get();
            cmbLifeStage.reload( lifestages );
            cmbLifeStage.setSelectedIndex( 8 );
        } catch ( Exception e ) {
            LoggerImpl.INSTANCE.logProblem( e );
        }
        try {
            Future<List<NutrientDO>> task = BackgroundExec.submit( new DriNutrientsTask() );
            List<NutrientDO> list = task.get();
            if ( list.isEmpty() ) {
                return;
            }
            cmbNutrients.reload( list );
            cmbNutrients.setSelectedIndex( 13 );
        } catch ( Exception e ) {
            LoggerImpl.INSTANCE.logProblem( e );
        }
        JTextField txtDailyValuePct = new JTextField();
        txtDailyValuePct.setMinimumSize( new Dimension( 50, 20 ) );
        pnl.add( cmbLifeStage, cc.xyw( 1, 1, 3 ) );
        pnl.add( cmbNutrients, cc.xy( 1, 2 ) );
        pnl.add( lblDV, cc.xy( 2, 2 ) );
        pnl.add( txtDailyValuePct, cc.xy( 3, 2 ) );
        JComponent[] inputs = { pnl };
        int optionValue = Message.showOptionDialogOkCancel( inputs, "Percent of Daily Reference Intake (DRI) to Grams" );
        if ( optionValue == 0 ) {
            String s = txtDailyValuePct.getText();
            if ( s != null && s.length() > 0 ) {
                try {
                    Future<List<DriDO>> task = BackgroundExec.submit( new LifestageDriTask(
                            cmbNutrients.getSelectedItem().getNutr_no(),
                            cmbLifeStage.getSelectedItem().getLifeStageId() ) );
                    List<DriDO> driDOlist = task.get();
                    DriDO driDO = driDOlist.get( 0 );
                    NutrientDO nutrientDO = cmbNutrients.getSelectedItem();
                    StringBuilder sb = new StringBuilder();
                    NumberCheck checkNumber = new NumberCheck();
                    checkNumber.addToUncheckedList( s );
                    if ( checkNumber.pass() ) {
                        double dvpct = Double.parseDouble( s );
                        sb.append( String.format( "%.0f", dvpct ) );
                        sb.append( "% of " );
                        sb.append( "DRI recommendation of " );
                        sb.append( driDO.getNutrientName()
                                .substring( 0, driDO.getNutrientName().length() - 5 ) );
                        sb.append( " for " );
                        sb.append( driDO.getLifestageLabel() );
                        sb.append( " is " );
                        sb.append( String.format(
                                "%.1f", dvpct * ( driDO.getNutrientQ().doubleValue() / 100 ) ) );
                        sb.append( " " );
                        sb.append( driDO.getNutrientUnits() );
                        sb.append( "\n" );
                        Message.showMessage( "Percent of Daily Reference Intake (DRI) to Grams", sb.toString() );
                    } else {
                        Message.showMessage( "Numbers only" );
                    }
                } catch ( Exception e ) {
                    LoggerImpl.INSTANCE.logProblem( e );
                }
            }
        }
    }


    private void calculateDigestibleCarbs() {
        FormLayout lyo = new FormLayout(
                "min,30dlu", // columns
                "min,28px" // rows
        );
        JPanel pnl = new JPanel();
        pnl.setLayout( lyo );
        JTextField txtTotalCarbs = new JTextField();
        JTextField txtTotalFiber = new JTextField();
        JLabel lblTotalCarbs = new JLabel( "What is total carbohydrate (g) of food item? " );
        JLabel lblTotalFiber = new JLabel( "What is total fiber (g) in food item? " );
        lblTotalCarbs.setHorizontalAlignment( SwingConstants.RIGHT );
        lblTotalFiber.setHorizontalAlignment( SwingConstants.RIGHT );
        pnl.add( lblTotalCarbs, cc.xy( 1, 1 ) );
        pnl.add( txtTotalCarbs, cc.xy( 2, 1 ) );
        pnl.add( lblTotalFiber, cc.xy( 1, 2 ) );
        pnl.add( txtTotalFiber, cc.xy( 2, 2 ) );
        JComponent[] inputs = { pnl };
        int optionValue = Message.showOptionDialogOkCancel( inputs, "Digestible Carbohydrate" );
        if ( optionValue == 0 ) {
            String totalCarbs = txtTotalCarbs.getText();
            String totalFiber = txtTotalFiber.getText();
            if ( totalCarbs != null && totalCarbs.length() > 0 ) {
                if ( totalFiber != null && totalFiber.length() > 0 ) {
                    StringBuilder sb = new StringBuilder();
                    NumberCheck checkNumber = new NumberCheck();
                    checkNumber.addToUncheckedList( totalCarbs );
                    checkNumber.addToUncheckedList( totalFiber );
                    if ( checkNumber.pass() ) {
                        Double totalCarbsNumber = Double.valueOf( totalCarbs );
                        Double totalFiberNumber = Double.valueOf( totalFiber );
                        double digestibleCarbsNumber = new DigestibleCarbohydrate( totalCarbsNumber, totalFiberNumber )
                                .getDigestibleCarbohydrate();
                        sb.append( "There are " );
                        sb.append( digestibleCarbsNumber );
                        sb.append( " grams of digestible carbohydrates." );
                        Message.showMessagePadW510H150( "Digestible Carbohydrate", sb.toString() );
                    }
                }
            }
        }
    }


    private void createFoodComparisonReport() {
        FoodComparisonReport csv = new FoodComparisonReport();
        csv.create( tblFoodDiff, tblFoodDiffA, tblFoodDiffB );
    }


    private void createAllFoodsReport1() {
        frm.setCursor( Cursor.getPredefinedCursor( Cursor.WAIT_CURSOR ) );
        BackgroundExec.execute( new CreateAllFoodsReport1Task( frm ) );
    }


    private void createAllFoodsReport2() {
        frm.setCursor( Cursor.getPredefinedCursor( Cursor.WAIT_CURSOR ) );
        BackgroundExec.execute( new CreateAllFoodsReport2Task( frm ) );
    }


    private void createMealPlanCaloriesReport() {
        ( new MealPlanCaloriesReport() ).create( selectedMix );
    }


    private void createMealPlanMacronutrientsReport() {
        ( new MealPlanMacronutrientsReport() ).create( selectedMix );
    }


    private void createMealPlanPortionsReport() {
        ( new MealPlanPortionsReport() ).create( selectedMix );
    }


    private void createMealPlanUsageReport() {
        ( new MealPlanUsageReport() ).create();
    }


    private void createMixComparisonReport() {
        ( new MixComparisonReport() ).create( tblMixDiff, tblMixDiffA, tblMixDiffB );
    }


    private void createMixTotalsReport() {
        ( new MixTotalsReport() ).create( selectedMix );
    }


    private void createMixResultsReport1() {
        ( new MixResultsReport() ).create( selectedMix );
    }


    private void createMixResultsReport2() {
        ( new MixResultsReport2() ).create( selectedMix );
    }


    private void exportMix() {
        int returnVal = fch.showSaveDialog( frm );
        if ( returnVal == JFileChooser.APPROVE_OPTION ) {
            File file = fch.getSelectedFile();
            String path = file.getAbsolutePath();
            fch.setCurrentDirectory( new File( path ) );
            frm.setCursor( Cursor.getPredefinedCursor( Cursor.WAIT_CURSOR ) );
            try ( BufferedWriter writer = new BufferedWriter( new FileWriter( path ) ) ) {
                try {
                    Future<String> task = BackgroundExec.submit( new ExportMixTask( selectedMixId ) );
                    String doc = task.get();
                    if ( doc == null ) {
                        frm.setCursor( Cursor.getPredefinedCursor( Cursor.DEFAULT_CURSOR ) );
                        return;
                    }
                    writer.write( Utilities.formatXmlDoc( doc ) );
                    frm.setCursor( Cursor.getPredefinedCursor( Cursor.DEFAULT_CURSOR ) );
                    showMessageSent( path );
                } catch ( Exception e ) {
                    LoggerImpl.INSTANCE.logProblem( e );
                }
            } catch ( IOException e ) {
                LoggerImpl.INSTANCE.logProblem( e );
            }
        }
    }


    private void createNutrientContentReport() {
        ( new NutrientContentReport() ).create( txtNutrientSearchQuantity, cmbNutrientContentNutrient );
    }


    private void createDriReport() {
        LifeStageDO lifestage = ( LifeStageDO ) cmbLifestage.getSelectedItem();
        ( new DriReport() ).create( selectedMix, lifestage );
    }


    private void calculateGlycemicIndexRange() {
        JTextField txtInput = new JTextField();
        JPanel pnl = new JPanel();
        txtInput.setPreferredSize( new Dimension( 50, 25 ) );
        pnl.add( new JLabel( "What is glycemic index of food item?" ) );
        pnl.add( txtInput );
        JComponent[] inputs = { pnl };
        int optionValue = Message.showOptionDialogOkCancel( inputs, "Glycemic Index Range" );
        if ( optionValue == 0 ) {
            String strGI = txtInput.getText();
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
                    Message.showMessagePadW510H150( "Glycemic Index Range", sb.toString() );
                }
            }
        }
    }


    private void calculateGlycemicLoad() {
        FormLayout lyo = new FormLayout(
                "min,30dlu", // columns
                "min,28px" // rows
        );
        JPanel pnl = new JPanel();
        pnl.setLayout( lyo );
        JTextField txtGi = new JTextField();
        JTextField txtDigestibleCarbs = new JTextField();
        JLabel lblDigestibleCarbs = new JLabel( "How many digestible carbs (g) in food item? " );
        JLabel lblGi = new JLabel( "What is glycemic index of food item? " );
        lblDigestibleCarbs.setHorizontalAlignment( SwingConstants.RIGHT );
        lblGi.setHorizontalAlignment( SwingConstants.RIGHT );
        pnl.add( lblDigestibleCarbs, cc.xy( 1, 1 ) );
        pnl.add( txtDigestibleCarbs, cc.xy( 2, 1 ) );
        pnl.add( lblGi, cc.xy( 1, 2 ) );
        pnl.add( txtGi, cc.xy( 2, 2 ) );
        JComponent[] inputs = { pnl };
        int optionValue = Message.showOptionDialogOkCancel( inputs, "Glycemic Load" );
        if ( optionValue == 0 ) {
            String gi = txtGi.getText();
            String carbs = txtDigestibleCarbs.getText();
            if ( gi != null && gi.length() > 0 ) {
                if ( carbs != null && carbs.length() > 0 ) {
                    StringBuilder sb = new StringBuilder();
                    NumberCheck checkNumber = new NumberCheck();
                    checkNumber.addToUncheckedList( gi );
                    checkNumber.addToUncheckedList( carbs );
                    if ( checkNumber.pass() ) {
                        Double giq = Double.valueOf( gi );
                        Double carbsq = Double.valueOf( carbs );
                        double gl = new GlycemicLoad( giq, carbsq ).getGlycemicLoad();
                        sb.append( "The glycemic load is " );
                        sb.append( gl );
                        sb.append( " grams." );
                        Message.showMessagePadW510H150( "Glycemic Load", sb.toString() );
                    }
                }
            }
        }
    }


    private void showKetosis() {
        // If you want the bibliography for these facts, ask.
        StringBuilder sb = new StringBuilder();
        double carbohydrateLow = new MinimumNutrientRequirements( 0.0 ).getCarbohydrateLow();
        double carbohydrateMedium = new MinimumNutrientRequirements( 0.0 ).getCarbohydrateMedium();
        double carbohydrateHigh = new MinimumNutrientRequirements( 0.0 ).getCarbohydrateHigh();
        sb.append( carbohydrateMedium );
        sb.append( " to " );
        sb.append( carbohydrateHigh );
        sb.append( " grams of carbohydrates will inhibit ketosis." );
        sb.append( "\n" );
        sb.append( carbohydrateLow );
        sb.append( " to " );
        sb.append( carbohydrateMedium );
        sb.append( " grams of carbohydrates will appreciably reduce ketosis." );
        sb.append( "\n" );
        Message.showMessagePadW510H150( "Carbohydrate Required to Inhibit Ketosis", sb.toString() );
    }


    private void deleteMix() {
        JComponent[] inputs = { new JLabel( "Would you like to delete mix?" ) };
        int optionValue = Message.showOptionDialogOkCancel( inputs, "Delete Mix" );
        if ( optionValue == 0 ) {
            Boolean completed = false;
            try {
                Future<Boolean> task = BackgroundExec.submit( new DeleteMixTask( selectedMixId ) );
                completed = task.get();
            } catch ( Exception e ) {
                LoggerImpl.INSTANCE.logProblem( e );
            }
            if ( !completed ) {
                return;
            }
            clearMixesView();
            setConstraintCounts();
            try {
                Future<List<List>> task = BackgroundExec.submit( new MixesTask() );
                List<List> lst = task.get();
                List<MixDO> mixesList = Utilities.createMixDOList( lst );
                cmbMixes.reload( mixesList );
                tblMixDiffA.reload( lst );
                tblMixDiffB.reload( lst );
                tblMealPlanUsageMixes.reload( lst );
            } catch ( Exception e ) {
                LoggerImpl.INSTANCE.logProblem( e );
            }
            cmbMixes.setSelectedIndex( 0 );
        }
    }


    private void createMix() {
        JTextField txtInput = new JTextField();
        JComponent[] inputs = { new JLabel( "What would you like to call it?" ), txtInput };
        int optionValue = Message.showOptionDialogOkCancel( inputs, "Create Mix" );
        if ( optionValue == 0 ) {
            String mixName = txtInput.getText();
            StringCheck sc = new StringCheck();
            sc.addUncheckedList( mixName );
            if ( sc.pass() ) {
                try {
                    Future<MixDO> task = BackgroundExec.submit( new CreateMixTask( mixName ) );
                    MixDO mix = task.get();
                    try {
                        Future<List<List>> task2 = BackgroundExec.submit( new MixesTask() );
                        List<List> lst = task2.get();
                        List<MixDO> mixesList = Utilities.createMixDOList( lst );
                        cmbMixes.reload( mixesList );
                        tblMixDiffA.reload( lst );
                        tblMixDiffB.reload( lst );
                        tblMealPlanUsageMixes.reload( lst );
                    } catch ( Exception e ) {
                        LoggerImpl.INSTANCE.logProblem( e );
                    }
                    cmbMixes.setSelectedItem( mix );
                    clearMixResults();
                } catch ( Exception e ) {
                    LoggerImpl.INSTANCE.logProblem( e );
                }
            } else {
                Message.showMessage( "These characters are not allowed: < & > ' \"" );
            }
        }
    }


    private void duplicateMix() {
        JComponent[] inputs = { new JLabel( "Would you like to duplicate mix?" ) };
        int optionValue = Message.showOptionDialogOkCancel( inputs, "Duplicate Mix" );
        if ( optionValue == 0 ) {
            try {
                String mixId = selectedMixId;
                Future<MixDO> task = BackgroundExec.submit( new DuplicateMixTask( mixId ) );
                MixDO mix = task.get();
                try {
                    Future<List<List>> task2 = BackgroundExec.submit( new MixesTask() );
                    List<List> lst = task2.get();
                    List<MixDO> mixesList = Utilities.createMixDOList( lst );
                    cmbMixes.reload( mixesList );
                    tblMixDiffA.reload( lst );
                    tblMixDiffB.reload( lst );
                    tblMealPlanUsageMixes.reload( lst );
                } catch ( Exception e ) {
                    LoggerImpl.INSTANCE.logProblem( e );
                }
                cmbMixes.setSelectedItem( mix );
                setQuantityScale();
            } catch ( Exception e ) {
                LoggerImpl.INSTANCE.logProblem( e );
            }
        }
    }


    private void pinAndDelete() {
        try {
            Future<Boolean> task = BackgroundExec.submit( new PinAndDeleteTask( selectedMixId ) );
            Boolean completed = task.get();
            if ( completed ) {
                tblNutrientQuantityConstraint.getStream().forEach( o -> {
                    List row = ( List ) o;
                    StringBuilder sb = new StringBuilder();
                    sb.append( row.get( 3 ) );
                    sb.append( " " );
                    sb.append( row.get( 4 ) );
                    sb.append( " " );
                    sb.append( ( new DecimalFormat( "###0.0" ) ).format( row.get( 5 ) ) );
                    addLogEntry(
                            selectedMixName,
                            "Delete",
                            "Nutrient Quantity Constraint",
                            sb.toString(),
                            selectedMixId,
                            "",
                            ( String ) row.get( 1 ),
                            "",
                            "",
                            ( Integer ) row.get( 2 ),
                            ( BigDecimal ) row.get( 5 ),
                            null );
                } );
                tblNutrientRatio.getStream().forEach( o -> {
                    List row = ( List ) o;
                    StringBuilder sb = new StringBuilder();
                    sb.append( row.get( 4 ) );
                    sb.append( " / " );
                    sb.append( row.get( 7 ) );
                    sb.append( " " );
                    sb.append( row.get( 6 ) );
                    sb.append( " " );
                    sb.append( ( new DecimalFormat( "###0.0" ) ).format( row.get( 5 ) ) );
                    sb.append( " / " );
                    sb.append( ( new DecimalFormat( "###0.0" ) ).format( row.get( 8 ) ) );
                    addLogEntry(
                            selectedMixName,
                            "Delete",
                            "Nutrient Ratio Constraint",
                            sb.toString(),
                            selectedMixId,
                            "",
                            ( String ) row.get( 1 ),
                            "",
                            ( String ) row.get( 2 ),
                            ( Integer ) row.get( 3 ),
                            ( BigDecimal ) row.get( 5 ),
                            ( BigDecimal ) row.get( 8 ) );
                } );
                tblFoodQuantityConstraint.getStream().forEach( o -> {
                    List row = ( List ) o;
                    StringBuilder sb = new StringBuilder();
                    sb.append( row.get( 4 ) );
                    sb.append( " using " );
                    sb.append( row.get( 5 ) );
                    sb.append( " " );
                    sb.append( row.get( 6 ) );
                    sb.append( " " );
                    sb.append( ( new DecimalFormat( "###0.0" ) ).format( row.get( 7 ) ) );
                    addLogEntry(
                            selectedMixName,
                            "Delete",
                            "Food Quantity Constraint",
                            sb.toString(),
                            selectedMixId,
                            ( String ) row.get( 1 ),
                            ( String ) row.get( 2 ),
                            "",
                            "",
                            ( Integer ) row.get( 3 ),
                            ( BigDecimal ) row.get( 7 ),
                            null );
                } );
                tblFoodRatioConstraint.getStream().forEach( o -> {
                    List row = ( List ) o;
                    StringBuilder sb = new StringBuilder();
                    sb.append( row.get( 6 ) );
                    sb.append( " using " );
                    sb.append( row.get( 7 ) );
                    sb.append( " / " );
                    sb.append( row.get( 10 ) );
                    sb.append( " using " );
                    sb.append( row.get( 11 ) );
                    sb.append( " " );
                    sb.append( row.get( 9 ) );
                    sb.append( " " );
                    sb.append( ( new DecimalFormat( "###0.0" ) ).format( row.get( 8 ) ) );
                    sb.append( " / " );
                    sb.append( ( new DecimalFormat( "###0.0" ) ).format( row.get( 12 ) ) );
                    addLogEntry(
                            selectedMixName,
                            "Delete",
                            "Food Ratio Constraint",
                            sb.toString(),
                            selectedMixId,
                            ( String ) row.get( 1 ),
                            ( String ) row.get( 2 ),
                            ( String ) row.get( 3 ),
                            ( String ) row.get( 4 ),
                            ( Integer ) row.get( 5 ),
                            ( BigDecimal ) row.get( 8 ),
                            ( BigDecimal ) row.get( 12 ) );
                } );
                reloadMixConstraints( selectedMixId );
                tblFoodQuantityConstraint.getStream().forEach( o -> {
                    List row = ( List ) o;
                    StringBuilder sb = new StringBuilder();
                    sb.append( row.get( 4 ) );
                    sb.append( " using " );
                    sb.append( row.get( 5 ) );
                    sb.append( " " );
                    sb.append( row.get( 6 ) );
                    sb.append( " " );
                    sb.append( ( new DecimalFormat( "###0.0" ) ).format( row.get( 7 ) ) );
                    addLogEntry(
                            selectedMixName,
                            "Add",
                            "Food Quantity Constraint",
                            sb.toString(),
                            selectedMixId,
                            ( String ) row.get( 1 ),
                            ( String ) row.get( 2 ),
                            "",
                            "",
                            ( Integer ) row.get( 3 ),
                            ( BigDecimal ) row.get( 7 ),
                            null );
                } );
            }
        } catch ( Exception e ) {
            LoggerImpl.INSTANCE.logProblem( e );
        }
    }


    private void pinAndKeep() {
        try {
            Future<Boolean> task = BackgroundExec.submit( new PinAndKeepTask( selectedMixId ) );
            Boolean completed = task.get();
            if ( completed ) {
                tblFoodQuantityConstraint.getStream().forEach( o -> {
                    List row = ( List ) o;
                    StringBuilder sb = new StringBuilder();
                    sb.append( row.get( 4 ) );
                    sb.append( " using " );
                    sb.append( row.get( 5 ) );
                    sb.append( " " );
                    sb.append( row.get( 6 ) );
                    sb.append( " " );
                    sb.append( ( new DecimalFormat( "###0.0" ) ).format( row.get( 7 ) ) );
                    addLogEntry(
                            selectedMixName,
                            "Delete",
                            "Food Quantity Constraint",
                            sb.toString(),
                            selectedMixId,
                            ( String ) row.get( 1 ),
                            ( String ) row.get( 2 ),
                            "",
                            "",
                            ( Integer ) row.get( 3 ),
                            ( BigDecimal ) row.get( 7 ),
                            null );
                } );
                reloadMixConstraints( selectedMixId );
                tblFoodQuantityConstraint.getStream().forEach( o -> {
                    List row = ( List ) o;
                    StringBuilder sb = new StringBuilder();
                    sb.append( row.get( 4 ) );
                    sb.append( " using " );
                    sb.append( row.get( 5 ) );
                    sb.append( " " );
                    sb.append( row.get( 6 ) );
                    sb.append( " " );
                    sb.append( ( new DecimalFormat( "###0.0" ) ).format( row.get( 7 ) ) );
                    addLogEntry(
                            selectedMixName,
                            "Add",
                            "Food Quantity Constraint",
                            sb.toString(),
                            selectedMixId,
                            ( String ) row.get( 1 ),
                            ( String ) row.get( 2 ),
                            "",
                            "",
                            ( Integer ) row.get( 3 ),
                            ( BigDecimal ) row.get( 7 ),
                            null );
                } );
            }
        } catch ( Exception e ) {
            LoggerImpl.INSTANCE.logProblem( e );
        }
    }


    private void renameMix() {
        JTextField txtInput = new JTextField();
        JComponent[] inputs = { new JLabel( "What is your new mix name?" ), txtInput };
        txtInput.setText( selectedMixName );
        int optionValue = Message.showOptionDialogOkCancel( inputs, "Update Mix" );
        if ( optionValue == 0 ) {
            String mixnom = txtInput.getText();
            StringCheck sc = new StringCheck();
            sc.addUncheckedList( mixnom );
            if ( sc.pass() ) {
                Boolean completed = false;
                try {
                    Future<Boolean> task = BackgroundExec.submit( new UpdateNameOnMixTask( selectedMixId, mixnom ) );
                    completed = task.get();
                } catch ( Exception e ) {
                    LoggerImpl.INSTANCE.logProblem( e );
                }
                if ( !completed ) {
                    return;
                }
                try {
                    Future<List<List>> task = BackgroundExec.submit( new MixesTask() );
                    List<List> lst = task.get();
                    List<MixDO> mixesList = Utilities.createMixDOList( lst );
                    cmbMixes.reload( mixesList );
                    tblMixDiffA.reload( lst );
                    tblMixDiffB.reload( lst );
                    tblMealPlanUsageMixes.reload( lst );
                } catch ( Exception e ) {
                    LoggerImpl.INSTANCE.logProblem( e );
                }
                cmbMixes.setSelectedItem( selectedMix );
            } else {
                Message.showMessage( "These characters are not allowed: < & > ' \"" );
            }
        }
    }


    private void calculateN3FattyAcidRequired() {
        JTextField txtInput = new JTextField();
        JPanel pnl = new JPanel();
        txtInput.setPreferredSize( new Dimension( 50, 25 ) );
        pnl.add( new JLabel( "What is your optimal calorie intake?" ) );
        pnl.add( txtInput );
        JComponent[] inputs = { pnl };
        int optionValue = Message.showOptionDialogOkCancel( inputs, "Alpha-linolenic Acid, ALA, 18:3 n-3" );
        if ( optionValue == 0 ) {
            String s = txtInput.getText();
            if ( s != null && s.length() > 0 ) {
                StringBuilder sb = new StringBuilder();
                NumberCheck checkNumber = new NumberCheck();
                checkNumber.addToUncheckedList( s );
                if ( checkNumber.pass() ) {
                    Double energyKcal = Double.valueOf( s );
                    final AlphaLinolenicRequired n3_fatty_acid_recommendation = new AlphaLinolenicRequired( energyKcal );
                    BigDecimal alaLow = n3_fatty_acid_recommendation.get_low_in_grams();
                    BigDecimal alaHigh = n3_fatty_acid_recommendation.get_high_in_grams();
                    sb.append( "Alpha-linolenic Acid required is between " );
                    sb.append( alaLow.setScale( 1, RoundingMode.HALF_UP ) );
                    sb.append( " and " );
                    sb.append( alaHigh.setScale( 1, RoundingMode.HALF_UP ) );
                    sb.append( " grams." );
                    Message.showMessagePadW510H150( "Alpha-linolenic Acid, ALA, 18:3 n-3", sb.toString() );
                } else {
                    Message.showMessage( "Numbers only" );
                }
            }
        }
    }


    private void calculateProteinNeededForNitrogenBalance() {
        JTextField textFieldLbs = new JTextField();
        textFieldLbs.setPreferredSize( new Dimension( 50, 25 ) );
        JPanel pnl = new JPanel();
        pnl.add( new JLabel( "What is your lean body mass in pounds?" ) );
        pnl.add( textFieldLbs );
        JComponent[] inputs = { pnl };
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
                    sb.append( "The amount of complete protein required in a no fat, no carbs regimen to maintain"
                            + " nitrogen balance is " );
                    sb.append( Math.round( protein ) );
                    sb.append( " grams." );
                    sb.append( "\n" );
                    Message.showMessagePadW510H150( "Complete Protein Required (no carbs, no fats)", sb.toString() );
                } else {
                    Message.showMessage( "Numbers only" );
                }
            }
        }
    }


    private void calculateNutrientContent() {
        TableDri.Row row = tblDri.getSelectedValue();
        String nutrientid = row.getNutrientid();
        String nutrient = row.getNutrient();
        BigDecimal dri = row.getDri();
        txtNutrientSearchQuantity.setText( ( new DecimalFormat( "######0.0#################" ) ).format( dri ) );
        NutrientDO nutrientDO = new NutrientDO( nutrientid, nutrient, null );
        cmbNutrientContentNutrient.setSelectedItem( nutrientDO );
        try {
            Future<List<List>> task = BackgroundExec.submit( new NutrientContainingFoodsTask( nutrientid, dri ) );
            List<List> results = task.get();
            tblNutrientLookup.reload( results );
        } catch ( Exception e ) {
            LoggerImpl.INSTANCE.logProblem( e );
        }
        tabMain.setSelectedIndex( 4 );
    }


    private void setFoodQuantityConstraintGuiValues() {
        TableFoodQuantityConstraint.Row row = tblFoodQuantityConstraint.getSelectedValue();
        String foodid = row.getFoodid();
        String nutrientid = row.getNutrientid();
        Integer relationshipid = row.getRelationshipid();
        BigDecimal q = row.getB();
        int foodIndex = cmbFoodQuantityFood.index( new MixFoodDO( foodid, "" ) );
        int nutrientIndex = cmbFoodQuantityNutrient.index( new NutrientDO( nutrientid, "", new BigDecimal( "-1" ) ) );
        int relationshipIndex = cmbFoodQuantityRelationship.index( new RelationshipDO( relationshipid, "" ) );
        cmbFoodQuantityFood.setSelectedIndex( foodIndex );
        cmbFoodQuantityNutrient.setSelectedIndex( nutrientIndex );
        cmbFoodQuantityRelationship.setSelectedIndex( relationshipIndex );
        txtFoodQuantityValue.setText( ( new DecimalFormat( "###0.000" ) ).format( q ) );
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
        int foodAIndex = cmbFoodRatioFoodA.index( new MixFoodDO( foodAid, "" ) );
        int foodBIndex = cmbFoodRatioFoodB.index( new MixFoodDO( foodBid, "" ) );
        int nutrientAindex = cmbFoodRatioNutrientA.index( new NutrientDO( nutrientAid, "", new BigDecimal( "-1" ) ) );
        int nutrientBindex = cmbFoodRatioNutrientB.index( new NutrientDO( nutrientBid, "", new BigDecimal( "-1" ) ) );
        int relationshipindex = cmbFoodRatioRelationship.index( new RelationshipDO( relationshipid, "" ) );
        cmbFoodRatioFoodA.setSelectedIndex( foodAIndex );
        cmbFoodRatioFoodB.setSelectedIndex( foodBIndex );
        cmbFoodRatioNutrientA.setSelectedIndex( nutrientAindex );
        txtFoodNutrientRatioQuantityA.setText( ( new DecimalFormat( "###0.000" ) ).format( qA ) );
        cmbFoodRatioNutrientB.setSelectedIndex( nutrientBindex );
        txtFoodNutrientRatioQuantityB.setText( ( new DecimalFormat( "###0.000" ) ).format( qB ) );
        cmbFoodRatioRelationship.setSelectedIndex( relationshipindex );
    }


    private void setNutrientQuantityConstraintGuiValues() {
        TableNutrientQuantity.Row row = tblNutrientQuantityConstraint.getSelectedValue();
        String nutrientid = row.getNutrientid();
        Integer relationshipid = row.getRelationshipid();
        BigDecimal q = row.getB();
        int nutrientindex = cmbNutrientQuantityNutrient.index( new NutrientDO( nutrientid, "", new BigDecimal( "-1" ) ) );
        int relationshipindex = cmbNutrientQuantityRelationship.index( new RelationshipDO( relationshipid, "" ) );
        cmbNutrientQuantityNutrient.setSelectedIndex( nutrientindex );
        cmbNutrientQuantityRelationship.setSelectedIndex( relationshipindex );
        txtNutrientQuantityValue.setText( ( new DecimalFormat( "###0.000" ) ).format( q ) );
    }


    private void setNutrientRatioConstraintGuiValues() {
        TableNutrientRatioConstraint.Row row = tblNutrientRatio.getSelectedValue();
        String nutrientida = row.getNutrientaid();
        String nutrientidb = row.getNutrientbid();
        BigDecimal qA = row.getA();
        BigDecimal qB = row.getB();
        Integer relationshipid = row.getRelationshipid();
        int nutrientAindex = cmbNutrientRatioNutrientA.index( new NutrientDO( nutrientida, "", new BigDecimal( "-1" ) ) );
        int nutrientBindex = cmbNutrientRatioNutrientB.index( new NutrientDO( nutrientidb, "", new BigDecimal( "-1" ) ) );
        int relationshipindex = cmbNutrientRatioRelationship.index( new RelationshipDO( relationshipid, "" ) );
        cmbNutrientRatioNutrientA.setSelectedIndex( nutrientAindex );
        txtNutrientRatioNutrientA.setText( ( new DecimalFormat( "###0.000" ) ).format( qA ) );
        cmbNutrientRatioNutrientB.setSelectedIndex( nutrientBindex );
        txtNutrientRatioNutrientB.setText( ( new DecimalFormat( "###0.000" ) ).format( qB ) );
        cmbNutrientRatioRelationship.setSelectedIndex( relationshipindex );
    }


    private void reloadFoodComboBoxes( String mixid ) {
        cmbFoodRatioFoodA.clear();
        cmbFoodRatioFoodB.clear();
        cmbFoodQuantityFood.clear();
        cmbPortionFood.clear();
        mixFoodLoader.reload( mixid );
        if ( !mixFoodLoader.get().isEmpty() ) {
            cmbFoodRatioFoodA.reload( mixFoodLoader.get() );
            cmbFoodRatioFoodB.reload( mixFoodLoader.get() );
            cmbFoodQuantityFood.reload( mixFoodLoader.get() );
            cmbPortionFood.reload( mixFoodLoader.get() );
        }
    }


    private void reloadCbNutrientData() {
        cmbNutrientQuantityNutrient.clear();
        cmbNutrientRatioNutrientA.clear();
        cmbNutrientRatioNutrientB.clear();
        cmbFoodQuantityNutrient.clear();
        cmbGroupNutrient.clear();
        cmbFoodRatioNutrientA.clear();
        cmbFoodRatioNutrientB.clear();
        cmbNutrientContentNutrient.clear();
        nutrientLoader.reload();
        cmbNutrientQuantityNutrient.reload( nutrientLoader.getList() );
        cmbNutrientRatioNutrientA.reload( nutrientLoader.getList() );
        cmbNutrientRatioNutrientB.reload( nutrientLoader.getList() );
        cmbFoodQuantityNutrient.reload( nutrientLoader.getList() );
        cmbGroupNutrient.reload( nutrientLoader.getList() );
        cmbFoodRatioNutrientA.reload( nutrientLoader.getList() );
        cmbFoodRatioNutrientB.reload( nutrientLoader.getList() );
        cmbNutrientContentNutrient.reload( nutrientLoader.getList() );
        cmbNutrientQuantityNutrient.setSelectedIndex( 13 );
        cmbNutrientRatioNutrientA.setSelectedIndex( 0 );
        cmbNutrientRatioNutrientB.setSelectedIndex( 0 );
        cmbFoodQuantityNutrient.setSelectedIndex( 46 );
        cmbGroupNutrient.setSelectedIndex( 46 );
        cmbFoodRatioNutrientA.setSelectedIndex( 46 );
        cmbFoodRatioNutrientB.setSelectedIndex( 46 );
    }


    private void reloadCbRelationshipData() {
        relationshipLoader.reload();
        cmbNutrientQuantityRelationship.clear();
        cmbNutrientRatioRelationship.clear();
        cmbFoodQuantityRelationship.clear();
        cmbGroupRelationship.clear();
        cmbFoodRatioRelationship.clear();
        cmbNutrientQuantityRelationship.reload( relationshipLoader.get() );
        cmbNutrientRatioRelationship.reload( relationshipLoader.get() );
        cmbFoodQuantityRelationship.reload( relationshipLoader.get() );
        cmbGroupRelationship.reload( relationshipLoader.get() );
        cmbFoodRatioRelationship.reload( relationshipLoader.get() );
        cmbNutrientQuantityRelationship.setSelectedIndex( 2 );
        cmbNutrientRatioRelationship.setSelectedIndex( 2 );
        cmbFoodQuantityRelationship.setSelectedIndex( 2 );
        cmbGroupRelationship.setSelectedIndex( 2 );
        cmbFoodRatioRelationship.setSelectedIndex( 2 );
    }


    private void reloadMixConstraints( String mixid ) {
        try {
            Future<List<List>> task0 = BackgroundExec.submit( new NutrientConstraintsTask( mixid ) );
            Future<List<List>> task1 = BackgroundExec.submit( new NutrientRatioConstraintsTask( mixid ) );
            Future<List<List>> task2 = BackgroundExec.submit( new FoodConstraintsTask( mixid ) );
            Future<List<List>> task3 = BackgroundExec.submit( new FoodRatioConstraintsTask( mixid ) );
            Future<List<List>> task4 = BackgroundExec.submit( new GroupConstraintsTask( mixid ) );
            List<List> constraints0 = task0.get();
            List<List> constraints1 = task1.get();
            List<List> constraints2 = task2.get();
            List<List> constraints3 = task3.get();
            List<List> constraints4 = task4.get();
            try {
                Future<List<List>> task6 = BackgroundExec.submit( new NamedMixFoodSortedByNameTask( mixid ) );
                List<List> foods = task6.get();
                tblMixFood.reload( foods );
                tblSelectedFoods.reload( foods );
            } catch ( Exception e ) {
                LoggerImpl.INSTANCE.logProblem( e );
            }
            tblNutrientQuantityConstraint.reload( constraints0 );
            tblNutrientRatio.reload( constraints1 );
            tblFoodQuantityConstraint.reload( constraints2 );
            tblFoodRatioConstraint.reload( constraints3 );
            tblGroupQuantityConstraint.reload( constraints4 );
            setConstraintCounts();
        } catch ( Exception e ) {
            LoggerImpl.INSTANCE.logProblem( e );
        }
    }


    private void reload_tblmdl_nutrient_lookup() {
        NutrientDO nutrientDO = ( NutrientDO ) cmbNutrientContentNutrient.getSelectedItem();
        if ( nutrientDO == null ) {
            return;
        }
        String text = txtNutrientSearchQuantity.getText();
        NumberCheck checkNumber = new NumberCheck();
        checkNumber.addToUncheckedList( text );
        if ( checkNumber.pass() ) {
            BigDecimal q = new BigDecimal( text );
            try {
                Future<List<List>> task
                        = BackgroundExec.submit( new NutrientContainingFoodsTask( nutrientDO.getNutr_no(), q ) );
                List<List> results = task.get();
                tblNutrientLookup.reload( results );
            } catch ( Exception e ) {
                LoggerImpl.INSTANCE.logProblem( e );
            }
        } else if ( !text.isEmpty() ) {
            Message.showMessage( "Character must be number." );
        }
    }


    private void roundDown() {
        // Mix Results
        tblMixResults.roundDown();
        // Dri
        tblDri.roundDown();
        // By Meal (Kcal)
        tblMealCalories.roundDown();
        // By Meal (grams)
        tblMealMacronutrients.roundDown();
        // Food list
        tblFoodFacts.roundDown();
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
        // Nutrient Quantity Constraints
        tblNutrientQuantityConstraint.roundDown();
        // Nutrient Ratio Constraints
        tblNutrientRatio.roundDown();
        // Food Quantity Constraints
        tblFoodQuantityConstraint.roundDown();
        // Food Ratio Constraints
        tblFoodRatioConstraint.roundDown();
        // Group Quantity Constraints
        tblGroupQuantityConstraint.roundDown();
        // Meal Portions
        tblMealPortions.roundDown();
    }


    private void roundUp() {
        // Mix Results
        tblMixResults.roundUp();
        // Dri
        tblDri.roundUp();
        // By Meal (Kcal)
        tblMealCalories.roundUp();
        // By Meal (grams)
        tblMealMacronutrients.roundUp();
        // Food list
        tblFoodFacts.roundUp();
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
        // Nutrient Quantity Constraints
        tblNutrientQuantityConstraint.roundUp();
        // Nutrient Ratio Constraints
        tblNutrientRatio.roundUp();
        // Food Quantity Constraints
        tblFoodQuantityConstraint.roundUp();
        // Food Ratio Constraints
        tblFoodRatioConstraint.roundUp();
        // Group Quantity Constraints
        tblGroupQuantityConstraint.roundUp();
        // Meal Portions
        tblMealPortions.roundUp();
    }


    private void loadSelectedMix() {
        selectedMix = cmbMixes.getSelectedItem();
        selectedMixId = selectedMix.getMixid();
        selectedMixName = selectedMix.getName();
        selectedMixModel = selectedMix.getModel();
        selectedMixCost = selectedMix.getCost();
        selectedMixDeficiency = selectedMix.getDeficiency();
        selectedMixExcess = selectedMix.getExcess();
        selectedMixLifeStageId = selectedMix.getLifestageid();
        Double tni = calculateTni( selectedMixCost.doubleValue() );
        setTheHighScore( tni );
        tblMixFood.clear();
        tblSelectedFoods.clear();
        tblFoodsInFoodGroup.clear();
        reloadFoodComboBoxes( selectedMixId );
        reloadMixConstraints( selectedMixId );
        mixFoodLoader.reload( selectedMixId );
        cmbPortionFood.reload( mixFoodLoader.get() );
        setConstraintCounts();
        LifeStageDO find
                = LifestageFinder.find( ( ( SpinnerListModel ) spnLifestage.getModel() ).getList(), selectedMixLifeStageId );
        spnLifestage.setSelectedItem( find );
        reloadResults( selectedMix );
        reloadGroups( selectedMixId );
    }


    private void reloadResults( MixDO mix ) {
        String mixid = mix.getMixid();
        String model = mix.getModel();
        try {
            Future<List<List>> task = BackgroundExec.submit( new MixResultsTask( mix.getMixid() ) );
            List<List> results = task.get();
            if ( results.isEmpty() ) {
                return;
            }
            tblMixResults.reload( results );
        } catch ( Exception e ) {
            LoggerImpl.INSTANCE.logProblem( e );
        }
        try {
            Future<List<List>> task = BackgroundExec.submit( new MealPlanMealsTask( mixid ) );
            List<List> meals = task.get();
            tblMeals.reload( meals );
        } catch ( Exception e ) {
            LoggerImpl.INSTANCE.logProblem( e );
        }
        txaLpProgram.setText( model );
        txaLpProgram.setCaretPosition( 0 );
        LifeStageDO lifestage = ( LifeStageDO ) cmbLifestage.getSelectedItem();
        try {
            Future<List<List>> task
                    = BackgroundExec.submit( new DriDiffTask( mix.getMixid(), lifestage.getLifeStageId() ) );
            List<List> diff = task.get();
            tblDri.reload( diff );
        } catch ( Exception e ) {
            LoggerImpl.INSTANCE.logProblem( e );
        }
        executeMealPlanPortionsTasks( mix );
        setQuantityScale();
    }


    private void clearMixResults() {
        tblMixResults.clear();
        tblDri.clear();
        tblMeals.clear();
        tblMealPortions.clear();
        tblMealCalories.clear();
        tblMealMacronutrients.clear();
        txaLpProgram.setText( "" );
        tblNutrientQuantityConstraint.clear();
        tblNutrientRatio.clear();
        tblFoodQuantityConstraint.clear();
        tblFoodRatioConstraint.clear();
        tblGroupQuantityConstraint.clear();
    }


    private void setConstraintCounts() {
        lblNutrientRatioCount.setText( getNutrientRatioConstraintCount() );
        lblFoodRatioCount.setText( getFoodRatioConstraintCount() );
        lblFoodCount.setText( getFoodConstraintCount() );
        lblNutrientCount.setText( getNutrientQuantityConstraintCount() );
        lblGroupCount.setText( getGroupConstraintCount() );
        // lblGroupRatioCount.setText("Fix");
    }


    private void setSplitPanelDivider() {
        splMain.setDividerLocation( 410 );
    }


    private void setQuantityScale() {
        if ( chkResultRoundUp.isSelected() ) {
            roundUp();
        } else {
            roundDown();
        }
    }


    private void showFoodStats( String foodid ) {
        foodStats.reload( foodid );
        Message.showMessagePadW510( 230, "Food Statistics", foodStats.get_stats() );
    }


    private void showMessageSent( String path ) {
        JTextArea txa = new JTextArea();
        txa.setEditable( false );
        StringBuilder sb = new StringBuilder();
        sb.append( "Document saved to:\n" );
        sb.append( path );
        txa.setText( sb.toString() );
        JComponent[] inputs = { txa };
        Message.showOptionDialog( inputs, "Document Export" );
    }


    private void showMixStats() {
        try {
            Future<List<Map<String, Object>>> task = BackgroundExec.submit( new MixStatsTask( selectedMixId ) );
            List<Map<String, Object>> list = task.get();
            if ( list.isEmpty() ) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            list.forEach( row -> {
                BigDecimal calories = ( BigDecimal ) row.get( "CALORIES" );
                BigDecimal fatpct = ( BigDecimal ) row.get( "FATPCT" );
                BigDecimal carbpct = ( BigDecimal ) row.get( "CARBPCT" );
                BigDecimal proteinpct = ( BigDecimal ) row.get( "PROTEINPCT" );
                BigDecimal alcoholpct = ( BigDecimal ) row.get( "ALCOHOLPCT" );
                BigDecimal fq = ( BigDecimal ) row.get( "FQ" );
                BigDecimal satfatpct = ( BigDecimal ) row.get( "SATFATPCT" );
                BigDecimal monoufatpct = ( BigDecimal ) row.get( "MONOUFATPCT" );
                BigDecimal polyufatpct = ( BigDecimal ) row.get( "POLYUFATPCT" );
                BigDecimal essentialfatratio = ( BigDecimal ) row.get( "ESSENTIALFATRATIO" );
                BigDecimal electrolyteratio = ( BigDecimal ) row.get( "ELECTROLYTERATIO" );
                BigDecimal lapct = ( BigDecimal ) row.get( "LAPCT" );
                BigDecimal alapct = ( BigDecimal ) row.get( "ALAPCT" );
                BigDecimal pratio = ( BigDecimal ) row.get( "PRATIO" );
                BigDecimal mratio = ( BigDecimal ) row.get( "MRATIO" );
                BigDecimal sratio = ( BigDecimal ) row.get( "SRATIO" );
                sb.append( "Fat: " );
                sb.append( ( new DecimalFormat( "###0.00" ) ).format( fatpct ) );
                sb.append( "%\n" );
                sb.append( "Carbohydrate: " );
                sb.append( ( new DecimalFormat( "###0.00" ) ).format( carbpct ) );
                sb.append( "%\n" );
                sb.append( "Protein: " );
                sb.append( ( new DecimalFormat( "###0.00" ) ).format( proteinpct ) );
                sb.append( "%\n" );
                sb.append( "Alcohol: " );
                sb.append( ( new DecimalFormat( "###0.00" ) ).format( alcoholpct ) );
                sb.append( "%\n" );
                sb.append( "Saturated Fat: " );
                sb.append( ( new DecimalFormat( "###0.00" ) ).format( satfatpct ) );
                sb.append( "%\n" );
                sb.append( "Polyunsaturated Fat: " );
                sb.append( ( new DecimalFormat( "###0.00" ) ).format( polyufatpct ) );
                sb.append( "%\n" );
                sb.append( "Monounsaturated Fat: " );
                sb.append( ( new DecimalFormat( "###0.00" ) ).format( monoufatpct ) );
                sb.append( "%\n" );
                sb.append( "Linoleic Acid: " );
                sb.append( ( new DecimalFormat( "###0.00" ) ).format( lapct ) );
                sb.append( "%\n" );
                sb.append( "Alpha-linolenic Acid: " );
                sb.append( ( new DecimalFormat( "###0.00" ) ).format( alapct ) );
                sb.append( "%\n" );
                sb.append( "Ratio SFA/TF: " );
                sb.append( ( new DecimalFormat( "###0.00" ) ).format( sratio ) );
                sb.append( "\n" );
                sb.append( "Ratio PUFA/TF: " );
                sb.append( ( new DecimalFormat( "###0.00" ) ).format( pratio ) );
                sb.append( "\n" );
                sb.append( "Ratio MUFA/TF: " );
                sb.append( ( new DecimalFormat( "###0.00" ) ).format( mratio ) );
                sb.append( "\n" );
                sb.append( "Ratio LA/ALA: " );
                sb.append( ( new DecimalFormat( "###0.00" ) ).format( essentialfatratio ) );
                sb.append( "\n" );
                sb.append( "Ratio K/Na: " );
                sb.append( ( new DecimalFormat( "###0.00" ) ).format( electrolyteratio ) );
                sb.append( "\n" );
                sb.append( "Food Quotient (FQ): " );
                sb.append( ( new DecimalFormat( "###0.00" ) ).format( fq ) );
                sb.append( "\n" );
            } );
            Message.showMessagePadW510( 230, "Mix Statistics", sb.toString() );
        } catch ( Exception e ) {
            LoggerImpl.INSTANCE.logProblem( e );
        }
    }


    private void deleteAllMixes() {
        JLabel lbl = new JLabel( "DO YOU WANT TO DELETE ALL MIXES?" );
        JPanel pnl = new JPanel();
        pnl.add( lbl );
        JComponent[] inputs = { pnl };
        int optionValue = Message.showOptionDialogYesNo( inputs, "** WARNING: DELETING VALUABLE DATA **" );
        if ( optionValue == 0 ) {
            try {
                Future<Boolean> task = BackgroundExec.submit( new DeleteAllMixesTask() );
                Boolean completed = task.get();
                if ( completed ) {
                    clearMixesView();
                    Message.showMessage( "", "ALL MIXES HAVE BEEN DELETED." );
                }
            } catch ( Exception e ) {
                LoggerImpl.INSTANCE.logProblem( e );
            }
        }
    }


    private void deleteAll() {
        JLabel lbl = new JLabel( "DO YOU WANT TO DELETE ALL MIXES AND ALL FOOD ITEMS?" );
        JPanel pnl = new JPanel();
        pnl.add( lbl );
        JComponent[] inputs = { pnl };
        int optionValue = Message.showOptionDialogYesNo( inputs, "** WARNING: DELETING VALUABLE DATA **" );
        if ( optionValue == 0 ) {
            try {
                Future<Boolean> task0 = BackgroundExec.submit( new DeleteAllMixesTask() );
                Boolean task0Completed = task0.get();
                frm.setCursor( Cursor.getPredefinedCursor( Cursor.WAIT_CURSOR ) );
                Future<Boolean> task1 = BackgroundExec.submit( new DeleteAllFoodsTask() );
                Boolean task1Completed = task1.get();
                Future<Boolean> task2 = BackgroundExec.submit( new DeleteAllFoodCategoriesTask() );
                Boolean task2Completed = task2.get();
                if ( task0Completed && task1Completed && task2Completed ) {
                    clearMixesView();
                    clearFoodsView();
                    frm.setCursor( Cursor.getPredefinedCursor( Cursor.DEFAULT_CURSOR ) );
                    Message.showMessage( "", "ALL MIXES AND ALL FOOD ITEMS HAVE BEEN DELETED." );
                }
            } catch ( Exception e ) {
                LoggerImpl.INSTANCE.logProblem( e );
            }
        }
    }


    public static void main( String[] args ) {
        try {
            URL url = Utilities.getResourceAsUrl( "/resources/fonts/inconsolata.ttf" );
            InputStream is = url.openStream();
            Font font = Font.createFont( Font.TRUETYPE_FONT, is ).deriveFont( 13f );
            MetalLookAndFeel.setCurrentTheme( new io.github.xjrga.looks.themes.Dawn_150( font ) );
            UIManager.setLookAndFeel( "javax.swing.plaf.metal.MetalLookAndFeel" );
        } catch ( ClassNotFoundException
                | IllegalAccessException
                | InstantiationException
                | UnsupportedLookAndFeelException
                | FontFormatException
                | IOException e ) {
        }
        BackgroundExec.start();
        Splash f = new Splash();
        f.initiate();
        new Main( f );
    }


    private void createDriDeviationTniConstraint(
            String mixid, Integer lifestageId, LinearProgram program, LpsolvePrintOut print ) {
        try {
            Future<List<Map<String, Object>>> taskRhs = BackgroundExec.submit( new DriDevTniRhsTask( mixid, lifestageId ) );
            List<Map<String, Object>> lst = taskRhs.get();
            lst.forEach( ( row ) -> {
                try {
                    String nutrientid = ( String ) row.get( "NUTRIENTID" );
                    Integer relationshipid = ( Integer ) row.get( "RELATIONSHIPID" );
                    Double b = ( Double ) row.get( "B" );
                    String nutrient = ( String ) row.get( "NUTRIENT" );
                    String nutrientlabel = ( String ) row.get( "NUTRIENTLABEL" );
                    String eq = ( String ) row.get( "EQ" );
                    Future<LhsContainer> taskLhs = BackgroundExec.submit( new DriDevTniLhsTask( mixid, nutrientid ) );
                    LhsContainer container = taskLhs.get();
                    double[] coefficients = container.getCoefficients();
                    program.addConstraint( coefficients, relationshipid, b );
                    StringBuilder constraintName = new StringBuilder();
                    constraintName.append( "Dri Deviation For " ).append( nutrient );
                    print.addDriDevQuantityConstraint( coefficients, relationshipid, b, constraintName.toString() );
                } catch ( Exception e ) {
                    LoggerImpl.INSTANCE.logProblem( e );
                }
            } );
        } catch ( Exception e ) {
            LoggerImpl.INSTANCE.logProblem( e );
        }
    }


    private void createDriDeviationSumDeficiencyConstraint(
            String mixid, int lifestyleid, LinearProgram program, LpsolvePrintOut print ) {
        try {
            Future<LhsContainer> taskLhs = BackgroundExec.submit( new DriDevSumDeficiencyLhsTask( mixid, lifestyleid ) );
            LhsContainer container = taskLhs.get();
            double[] coefficients = container.getCoefficients();
            int relationshipid = 3;
            int b = 0;
            program.addConstraint( coefficients, relationshipid, 0 );
            StringBuilder constraintName = new StringBuilder();
            constraintName.append( "Dri Deficiency" );
            print.addDriDevSumQuantityConstraint( coefficients, relationshipid, b, constraintName.toString() );
        } catch ( Exception e ) {
            LoggerImpl.INSTANCE.logProblem( e );
        }
    }


    private void createDriDeviationSumExcessConstraint(
            String mixid, int lifestyleid, LinearProgram program, LpsolvePrintOut print ) {
        try {
            Future<LhsContainer> taskLhs = BackgroundExec.submit( new DriDevSumExcessLhsTask( mixid, lifestyleid ) );
            LhsContainer container = taskLhs.get();
            double[] coefficients = container.getCoefficients();
            int relationshipid = 3;
            int b = 0;
            program.addConstraint( coefficients, relationshipid, 0 );
            StringBuilder constraintName = new StringBuilder();
            constraintName.append( "Dri Excess" );
            print.addDriDevSumQuantityConstraint( coefficients, relationshipid, b, constraintName.toString() );
        } catch ( Exception e ) {
            LoggerImpl.INSTANCE.logProblem( e );
        }
    }


    private void createULDeviationSumExcessConstraint(
            String mixid, int lifestyleid, LinearProgram program, LpsolvePrintOut print ) {
        // Add ul nutrient deficiency variables
        // Add ul nutrient excess variables
        // Add ul average deficiency variable
        // Add ul average excess variable
        // Food variables + 8 dri deficiency + 8 dri excess + 1 avg dri deficiency + 1
        // avg dri excess +
        // 8 UL deficiency + 8 UL excess + 1 avg UL deficiency + 1 avg UL excess
        try {
            StringBuilder sb = new StringBuilder();
            Future<LhsContainer> taskLhs = BackgroundExec.submit( new ULDevSumExcessLhsTask( mixid, lifestyleid ) );
            LhsContainer container = taskLhs.get();
            double[] coefficients = container.getCoefficients();
            int relationshipid = 3;
            int b = 0;
            program.addConstraint( coefficients, relationshipid, 0 );
            StringBuilder constraintName = new StringBuilder();
            constraintName.append( "UL Excess" );
            print.addDriDevSumQuantityConstraint( coefficients, relationshipid, b, constraintName.toString() );
        } catch ( Exception e ) {
            LoggerImpl.INSTANCE.logProblem( e );
        }
    }


    private JPanel getModelLogPanel() {
        JPanel pnl = new JPanel();
        FormLayout lyo = new FormLayout(
                "p,p:grow", // columns
                "8px,fill:28px,fill:p:grow" // rows
        );
        pnl.setLayout( lyo );
        tblLog = new TableLog();
        JScrollPane scrTable = new JScrollPane( tblLog );
        scrTable.setBorder( new TitledBorder( "Log" ) );
        pnl.add( new JLabel( "Search: " ), cc.xy( 1, 2 ) );
        pnl.add( tblLog.getSearchField(), cc.xy( 2, 2 ) );
        pnl.add( scrTable, cc.xyw( 1, 3, 2 ) );
        tblLog.addKeyListener( new KeyListener() {
            @Override
            public void keyPressed( KeyEvent keyEvent ) {
                if ( keyEvent.getKeyCode() == KeyEvent.VK_DELETE ) {
                    tblLog.clear();
                }
            }


            @Override
            public void keyReleased( KeyEvent keyEvent ) {
            }


            @Override
            public void keyTyped( KeyEvent keyEvent ) {
            }
        } );
        return pnl;
    }


    private void addLogEntry(
            String mix,
            String action,
            String type,
            String object,
            String mixid,
            String foodidA,
            String nutrientidA,
            String foodidB,
            String nutrientidB,
            Integer relationshipid,
            BigDecimal A,
            BigDecimal B ) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern( "dd-MM-yyyy HH:mm:ss" );
        String fnow = now.format( formatter );
        List row = new ArrayList();
        row.add( fnow );
        row.add( mix );
        row.add( action );
        row.add( type );
        row.add( object );
        row.add( mixid );
        row.add( foodidA );
        row.add( nutrientidA );
        row.add( foodidB );
        row.add( nutrientidB );
        row.add( relationshipid );
        row.add( A );
        row.add( B );
        tblLog.addRow( row );
    }


    private JPanel getFoodGroupsPanel() {
        tblSelectedFoods = new TableFood();
        tblFoodGroups = new TableGroups();
        tblFoodsInFoodGroup = new TableFood();
        JScrollPane scrSelectedFoods = new JScrollPane( tblSelectedFoods );
        scrSelectedFoods.setBorder( new TitledBorder( "Selected Food" ) );
        JScrollPane scrFoodGroups = new JScrollPane( tblFoodGroups );
        scrFoodGroups.setBorder( new TitledBorder( "Food Groups" ) );
        JScrollPane scrFoodsInFoodGroup = new JScrollPane( tblFoodsInFoodGroup );
        JTextField txtSearchFoodGroups = tblFoodGroups.getTxtSearch();
        JTextField txtSearchSelectedFoods = tblSelectedFoods.getTxtSearch();
        JTextField txtSearchFoodsInFoodGroup = tblFoodsInFoodGroup.getTxtSearch();
        JPanel pnlMain = new JPanel();
        JPanel pnlFoodGroups = new JPanel();
        JPanel pnlSelectedFoods = new JPanel();
        JPanel pnlFoodsInFoodGroup = new JPanel();
        JPanel pnlFoodGroupButtons = new JPanel();
        JPanel pnlFoodButtons = new JPanel();
        JPanel pnlButtons = new JPanel();
        FormLayout lyoMain = new FormLayout(
                "m:grow,8px,m:grow", // columns
                "fill:200px,8px,fill:min:grow,min" // rows
        );
        FormLayout lyoFoodGroups = new FormLayout(
                "min,min:grow", // columns
                "8px,fill:28px,fill:min:grow" // rows
        );
        FormLayout lyoSelectedFoods = new FormLayout(
                "min,min:grow", // columns
                "fill:28px,fill:min:grow" // rows
        );
        FormLayout lyoFoodsInFoodGroup = new FormLayout(
                "min,min:grow", // columns
                "fill:28px,fill:min:grow" // rows
        );
        FormLayout lyoButtons = new FormLayout(
                "m:grow,240px,150px,m:grow", // columns
                "min,8px" // rows
        );
        JLabel lblSearchFoodGroups = new JLabel( "Search: " );
        JLabel lblSearchSelectedFoods = new JLabel( "Search: " );
        JLabel lblSearchFoodsInFoodGroup = new JLabel( "Search: " );
        JButton btnAddFoodGroup = new JButton( "+" );
        JButton btnDeleteFoodGroup = new JButton( "-" );
        JButton btnRenameFoodGroup = new JButton( "r" );
        JButton btnDuplicateFoodGroup = new JButton( "d" );
        JButton btnAddFoodToFoodGroup = new JButton( "+" );
        JButton btnDeleteFoodFromFoodGroup = new JButton( "-" );
        pnlFoodGroups.setLayout( lyoFoodGroups );
        pnlFoodsInFoodGroup.setLayout( lyoFoodsInFoodGroup );
        lblSearchFoodGroups.setToolTipText(
                "Search field input should be a valid regex expression (case insensitive match)" );
        lblSearchSelectedFoods.setToolTipText(
                "Search field input should be a valid regex expression (case insensitive match)" );
        lblSearchFoodsInFoodGroup.setToolTipText(
                "Search field input should be a valid regex expression (case insensitive match)" );
        pnlFoodGroupButtons.add( btnAddFoodGroup );
        pnlFoodGroupButtons.add( btnDeleteFoodGroup );
        pnlFoodGroupButtons.add( btnRenameFoodGroup );
        pnlFoodGroupButtons.add( btnDuplicateFoodGroup );
        pnlFoodGroupButtons.setBorder( new TitledBorder( "Group" ) );
        pnlButtons.setLayout( lyoButtons );
        pnlButtons.add( pnlFoodGroupButtons, cc.xy( 2, 1 ) );
        pnlButtons.add( pnlFoodButtons, cc.xy( 3, 1 ) );
        pnlFoodButtons.add( btnAddFoodToFoodGroup );
        pnlFoodButtons.add( btnDeleteFoodFromFoodGroup );
        pnlFoodButtons.setBorder( new TitledBorder( "Food" ) );
        btnAddFoodGroup.setToolTipText( "Create food group" );
        btnDeleteFoodGroup.setToolTipText( "Delete food group" );
        btnRenameFoodGroup.setToolTipText( "Rename food group" );
        btnDuplicateFoodGroup.setToolTipText( "Duplicate food group" );
        btnAddFoodToFoodGroup.setToolTipText( "Add food item to food group" );
        btnDeleteFoodFromFoodGroup.setToolTipText( "Remove food item from food group" );
        scrFoodsInFoodGroup.setBorder( new TitledBorder( "Foods In Group" ) );
        pnlMain.setLayout( lyoMain );
        pnlSelectedFoods.setLayout( lyoSelectedFoods );
        pnlFoodGroups.add( lblSearchFoodGroups, cc.xy( 1, 2 ) );
        pnlFoodGroups.add( txtSearchFoodGroups, cc.xy( 2, 2 ) );
        pnlFoodGroups.add( scrFoodGroups, cc.xyw( 1, 3, 2 ) );
        pnlFoodsInFoodGroup.add( lblSearchFoodsInFoodGroup, cc.xy( 1, 1 ) );
        pnlFoodsInFoodGroup.add( txtSearchFoodsInFoodGroup, cc.xy( 2, 1 ) );
        pnlFoodsInFoodGroup.add( scrFoodsInFoodGroup, cc.xyw( 1, 2, 2 ) );
        pnlSelectedFoods.add( lblSearchSelectedFoods, cc.xy( 1, 1 ) );
        pnlSelectedFoods.add( txtSearchSelectedFoods, cc.xy( 2, 1 ) );
        pnlSelectedFoods.add( scrSelectedFoods, cc.xyw( 1, 2, 2 ) );
        pnlMain.add( pnlFoodGroups, cc.xyw( 1, 1, 3 ) );
        pnlMain.add( pnlSelectedFoods, cc.xy( 1, 3 ) );
        pnlMain.add( pnlFoodsInFoodGroup, cc.xy( 3, 3 ) );
        pnlMain.add( pnlButtons, cc.xyw( 1, 4, 3 ) );
        btnAddFoodGroup.addActionListener( ( ActionEvent evt ) -> {
            addFoodGroup();
        } );
        btnDeleteFoodGroup.addActionListener( ( ActionEvent evt ) -> {
            deleteFoodGroup();
        } );
        btnRenameFoodGroup.addActionListener( ( ActionEvent evt ) -> {
            renameFoodGroup();
        } );
        btnDuplicateFoodGroup.addActionListener( ( ActionEvent evt ) -> {
            duplicateFoodGroup();
        } );
        tblFoodGroups.getSelectionModel().addListSelectionListener( ( ListSelectionEvent a ) -> {
            if ( a.getValueIsAdjusting() ) {
                return;
            }
            if ( tblFoodGroups.isSelectionEmpty() ) {
                return;
            }
            TableGroups.Row foodgroup = tblFoodGroups.getSelectedValue();
            try {
                Future<List<List>> task
                        = BackgroundExec.submit( new FoodsInFoodGroupTask( selectedMixId, foodgroup.getGroupid() ) );
                List<List> categoryFoods = task.get();
                tblFoodsInFoodGroup.reload( categoryFoods );
            } catch ( Exception e ) {
                LoggerImpl.INSTANCE.logProblem( e );
            }
        } );
        btnAddFoodToFoodGroup.addActionListener( ( ActionEvent evt ) -> {
            addFoodToFoodGroup();
        } );
        btnDeleteFoodFromFoodGroup.addActionListener( ( ActionEvent evt ) -> {
            removeFoodFromFoodGroup();
        } );
        return pnlMain;
    }


    private void addFoodGroup() {
        JTextField txtInput = new JTextField();
        JComponent[] inputs = { new JLabel( "What is your new food group name?" ), txtInput };
        int optionValue = Message.showOptionDialogOkCancel( inputs, "New Food Group" );
        if ( optionValue == 0 ) {
            String foodgroupname = txtInput.getText();
            if ( foodgroupname != null && foodgroupname.length() > 0 ) {
                try {
                    Future<String> task = BackgroundExec.submit( new InsertFoodGroupTask( selectedMixId, foodgroupname ) );
                    String groupid = task.get();
                    if ( task.isDone() ) {
                        reloadGroups( selectedMixId );
                        int rowIndex = tblFoodGroups.find( groupid );
                        tblFoodGroups.selectRow( rowIndex );
                        tblFoodGroups.showRow( rowIndex );
                    }
                } catch ( Exception e ) {
                    LoggerImpl.INSTANCE.logProblem( e );
                }
            }
        }
    }


    private void deleteFoodGroup() {
        if ( !tblFoodGroups.isSelectionEmpty() ) {
            TableGroups.Row foodgroup = tblFoodGroups.getSelectedValue();
            try {
                Future<Boolean> task
                        = BackgroundExec.submit( new DeleteFoodGroupTask( selectedMixId, foodgroup.getGroupid() ) );
                task.get();
                if ( task.isDone() ) {
                    tblFoodsInFoodGroup.clear();
                    reloadGroups( selectedMixId );
                    Future<List<List>> task1 = BackgroundExec.submit( new GroupConstraintsTask( selectedMixId ) );
                    List<List> constraints = task1.get();
                    tblGroupQuantityConstraint.reload( constraints );
                    setConstraintCounts();
                }
            } catch ( Exception e ) {
                LoggerImpl.INSTANCE.logProblem( e );
            }
        }
    }


    private void renameFoodGroup() {
        if ( !tblFoodGroups.isSelectionEmpty() ) {
            JTextField input = new JTextField();
            JComponent[] inputs = { new JLabel( "What is your new food group name?" ), input };
            int optionValue = Message.showOptionDialogOkCancel( inputs, "Update Food Group" );
            if ( optionValue == 0 ) {
                String foodgroupname = input.getText();
                if ( foodgroupname != null && foodgroupname.length() > 0 ) {
                    TableGroups.Row foodgroup = tblFoodGroups.getSelectedValue();
                    try {
                        Future<Boolean> task = BackgroundExec.submit(
                                new UpdateFoodGroupTask( selectedMixId, foodgroup.getGroupid(), foodgroupname ) );
                        task.get();
                        if ( task.isDone() ) {
                            reloadGroups( selectedMixId );
                            int rowIndex = tblFoodGroups.find( foodgroup.getGroupid() );
                            tblFoodGroups.selectRow( rowIndex );
                            tblFoodGroups.showRow( rowIndex );
                            Future<List<List>> task1
                                    = BackgroundExec.submit( new GroupConstraintsTask( selectedMixId ) );
                            List<List> constraints = task1.get();
                            tblGroupQuantityConstraint.reload( constraints );
                        }
                    } catch ( Exception e ) {
                        LoggerImpl.INSTANCE.logProblem( e );
                    }
                }
            }
        }
    }


    private void duplicateFoodGroup() {
        if ( !tblFoodGroups.isSelectionEmpty() ) {
            TableGroups.Row foodgroup = tblFoodGroups.getSelectedValue();
            try {
                Future<String> task
                        = BackgroundExec.submit( new DuplicateFoodGroupTask( selectedMixId, foodgroup.getGroupid() ) );
                String foodgroupid = task.get();
                if ( task.isDone() ) {
                    reloadGroups( selectedMixId );
                    int rowIndex = tblFoodGroups.find( foodgroupid );
                    tblFoodGroups.selectRow( rowIndex );
                    tblFoodGroups.showRow( rowIndex );
                }
            } catch ( Exception e ) {
                LoggerImpl.INSTANCE.logProblem( e );
            }
        }
    }


    private void reloadGroups( String mixid ) {
        try {
            Future<List<List>> task1 = BackgroundExec.submit( new FoodGroupsTask( mixid ) );
            List<List> list01 = task1.get();
            tblFoodGroups.reload( list01 );
            Future<List<GroupDO>> task2 = BackgroundExec.submit( new FoodGroupsTaskGroupDO( mixid ) );
            List<GroupDO> list02 = task2.get();
            cmbFoodGroup.reload( list02 );
        } catch ( Exception e ) {
            LoggerImpl.INSTANCE.logProblem( e );
        }
    }


    private void addFoodToFoodGroup() {
        if ( tblSelectedFoods.isSelectionEmpty() ) {
            return;
        }
        if ( tblFoodGroups.isSelectionEmpty() ) {
            return;
        }
        try {
            TableGroups.Row foodgroup = tblFoodGroups.getSelectedValue();
            TableFood.Row food = tblSelectedFoods.getSelectedValue();
            Future<String> task1 = BackgroundExec.submit(
                    new InsertGroupFoodTask( selectedMixId, foodgroup.getGroupid(), food.getFoodid() ) );
            task1.get();
            Future<List<List>> task2
                    = BackgroundExec.submit( new FoodsInFoodGroupTask( selectedMixId, foodgroup.getGroupid() ) );
            List<List> foodsInFoodGroup = task2.get();
            tblFoodsInFoodGroup.reload( foodsInFoodGroup );
            int rowIndex = tblFoodsInFoodGroup.find( food.getFoodid() );
            tblFoodsInFoodGroup.selectRow( rowIndex );
            tblFoodsInFoodGroup.showRow( rowIndex );
        } catch ( Exception e ) {
            LoggerImpl.INSTANCE.logProblem( e );
        }
    }


    private void removeFoodFromFoodGroup() {
        if ( tblFoodGroups.isSelectionEmpty() ) {
            return;
        }
        if ( tblFoodsInFoodGroup.isSelectionEmpty() ) {
            return;
        }
        TableGroups.Row foodgroup = tblFoodGroups.getSelectedValue();
        TableFood.Row food = tblFoodsInFoodGroup.getSelectedValue();
        try {
            Future<Boolean> task1 = BackgroundExec.submit(
                    new DeleteFoodInFoodGroupTask( foodgroup.getGroupid(), selectedMixId, food.getFoodid() ) );
            task1.get();
            Future<List<List>> task2
                    = BackgroundExec.submit( new FoodsInFoodGroupTask( selectedMixId, foodgroup.getGroupid() ) );
            List<List> foodsInFoodGroup = task2.get();
            tblFoodsInFoodGroup.reload( foodsInFoodGroup );
        } catch ( Exception e ) {
            LoggerImpl.INSTANCE.logProblem( e );
        }
    }


    private JPanel getGroupQuantityConstraint() {
        JPanel pnl = new JPanel();
        FormLayout panelLayout = new FormLayout(
                "p,p,p:grow,p", // columns
                "p,p,fill:p:grow,min" // rows
        );
        pnl.setLayout( panelLayout );
        tblGroupQuantityConstraint = new TableGroupQuantityConstraint();
        JScrollPane spTable = new JScrollPane( tblGroupQuantityConstraint );
        Integer width = TableColumnWidth.Food.getWidth()
                + TableColumnWidth.Nutrient.getWidth()
                + 21
                + 90
                + TableColumnWidth.Scrollbar.getWidth();
        spTable.setPreferredSize( new Dimension( width, 0 ) );
        JPanel buttons = new JPanel();
        txtGroupQuantityValue.setPreferredSize( Dimensions.Quantity.get() );
        pnl.add( cmbFoodGroup, cc.xyw( 1, 1, 3 ) );
        pnl.add( btnGroupBlock, cc.xy( 4, 1 ) );
        pnl.add( cmbGroupNutrient, cc.xy( 1, 2 ) );
        pnl.add( cmbGroupRelationship, cc.xy( 2, 2 ) );
        pnl.add( txtGroupQuantityValue, cc.xyw( 3, 2, 2 ) );
        pnl.add( spTable, cc.xyw( 1, 3, 4 ) );
        buttons.add( btnAddGroupQuantityConstraint );
        buttons.add( btnDeleteGroupQuantityConstraint );
        pnl.add( buttons, cc.xyw( 1, 4, 4 ) );
        spTable.setBorder( new TitledBorder( "Group Constraints" ) );
        cmbGroupNutrient.setMaximumRowCount( 10 );
        cmbGroupRelationship.setMaximumRowCount( 3 );
        cmbFoodGroup.setMaximumRowCount( 10 );
        btnAddGroupQuantityConstraint.setToolTipText( "Add Constraint" );
        btnDeleteGroupQuantityConstraint.setToolTipText( "Delete Constraint" );
        btnAddGroupQuantityConstraint.addActionListener( ( ActionEvent evt ) -> {
            addGroupQuantityConstraint();
        } );
        btnDeleteGroupQuantityConstraint.addActionListener( ( ActionEvent evt ) -> {
            if ( tblGroupQuantityConstraint.isSelectionEmpty() ) {
                return;
            }
            deleteFoodGroupQuantityConstraint();
        } );
        btnGroupBlock.addActionListener( ( ActionEvent evt ) -> {
            blockGroup();
        } );
        tblGroupQuantityConstraint.getSelectionModel().addListSelectionListener( ( ListSelectionEvent e ) -> {
            if ( e.getValueIsAdjusting() ) {
                return;
            }
            if ( tblGroupQuantityConstraint.isSelectionEmpty() ) {
                return;
            }
            setFoodGroupQuantityConstraintGuiValues();
        } );
        return pnl;
    }


    private Double plusQuantity( Double oldq ) {
        Double total = 0.0;
        JTextField txtInput = new JTextField();
        JPanel pnl = new JPanel();
        txtInput.setPreferredSize( new Dimension( 50, 25 ) );
        pnl.add( new JLabel( "How much would like to add?" ) );
        pnl.add( txtInput );
        JComponent[] inputs = { pnl };
        int optionValue = Message.showOptionDialogOkCancel( inputs, "Plus" );
        if ( optionValue == 0 ) {
            String s = txtInput.getText();
            if ( s != null && s.length() > 0 ) {
                StringBuilder sb = new StringBuilder();
                NumberCheck checkNumber = new NumberCheck();
                checkNumber.addToUncheckedList( s );
                if ( checkNumber.pass() ) {
                    Double newq = Double.valueOf( s );
                    total = oldq + newq;
                } else {
                    Message.showMessage( "Numbers only" );
                }
            }
        }
        return total;
    }


    private void addGroupQuantityConstraint() {
        if ( checkFoodGroupConstraint() ) {
            NumberCheck numberCheck = new NumberCheck();
            numberCheck.addToUncheckedList( txtGroupQuantityValue.getText() );
            if ( numberCheck.pass() ) {
                GroupDO groupDO = cmbFoodGroup.getSelectedItem();
                NutrientDO nutrientDO = cmbGroupNutrient.getSelectedItem();
                RelationshipDO relationshipDO = cmbGroupRelationship.getSelectedItem();
                BigDecimal b = new BigDecimal( txtGroupQuantityValue.getText() );
                executeMergeGroupQuantityConstraintTasks( selectedMix, groupDO, nutrientDO, relationshipDO, b );
            } else {
                Message.showMessage( "Value must be a number greater than or equal to zero" );
            }
        }
    }


    private void executeMergeGroupQuantityConstraintTasks(
            MixDO mix, GroupDO groupDO, NutrientDO nutrientDO, RelationshipDO relationshipDO, BigDecimal b ) {
        try {
            Future<Boolean> task1 = BackgroundExec.submit( new MergeGroupConstraintTask(
                    mix.getMixid(),
                    groupDO.getGroupid(),
                    nutrientDO.getNutr_no(),
                    relationshipDO.getRelationshipid(),
                    b ) );
            task1.get();
            StringBuilder sb = new StringBuilder();
            sb.append( groupDO.getGroupname() );
            sb.append( " using " );
            sb.append( nutrientDO.getNutrdesc() );
            sb.append( " " );
            sb.append( relationshipDO.getName() );
            sb.append( " " );
            sb.append( ( new DecimalFormat( "###0.0" ) ).format( b ) );
            addLogEntry(
                    selectedMixName,
                    "Add",
                    "Group Quantity Constraint",
                    sb.toString(),
                    selectedMixId,
                    groupDO.getGroupid(),
                    nutrientDO.getNutr_no(),
                    "",
                    "",
                    relationshipDO.getRelationshipid(),
                    b,
                    null );
            Future<List<List>> task2 = BackgroundExec.submit( new GroupConstraintsTask( mix.getMixid() ) );
            List<List> constraints = task2.get();
            tblGroupQuantityConstraint.reload( constraints );
            setConstraintCounts();
        } catch ( Exception e ) {
            LoggerImpl.INSTANCE.logProblem( e );
        }
    }


    private Boolean checkFoodGroupConstraint() {
        boolean flag_isReady = false;
        boolean flag_listGroup = false;
        boolean flag_listNutrient = false;
        boolean flag_listRelationship = false;
        boolean flag_quantity = false;
        if ( !this.cmbFoodGroup.isSelectionEmpty() ) {
            flag_listGroup = true;
        } else {
            Message.showMessage( "Select group" );
        }
        if ( !this.cmbGroupNutrient.isSelectionEmpty() ) {
            flag_listNutrient = true;
        } else {
            Message.showMessage( "Select nutrient" );
        }
        if ( !cmbGroupRelationship.isSelectionEmpty() ) {
            flag_listRelationship = true;
        } else {
            Message.showMessage( "Select relationship" );
        }
        if ( !txtGroupQuantityValue.getText().isEmpty() ) {
            flag_quantity = true;
        } else {
            Message.showMessage( "Specify amount" );
        }
        if ( flag_listGroup && flag_listNutrient && flag_listRelationship && flag_quantity ) {
            flag_isReady = true;
        }
        return flag_isReady;
    }


    private void setFoodGroupQuantityConstraintGuiValues() {
        TableGroupQuantityConstraint.Row row = tblGroupQuantityConstraint.getSelectedValue();
        String groupid = row.getGroupid();
        String nutrientid = row.getNutrientid();
        Integer relationshipid = row.getRelationshipid();
        BigDecimal q = row.getB();
        int groupIndex = cmbFoodGroup.index( new GroupDO( groupid, "" ) );
        int nutrientIndex = cmbGroupNutrient.index( new NutrientDO( nutrientid, "", new BigDecimal( "-1" ) ) );
        int relationshipIndex = cmbGroupRelationship.index( new RelationshipDO( relationshipid, "" ) );
        cmbFoodGroup.setSelectedIndex( groupIndex );
        cmbGroupNutrient.setSelectedIndex( nutrientIndex );
        cmbGroupRelationship.setSelectedIndex( relationshipIndex );
        txtGroupQuantityValue.setText( ( new DecimalFormat( "###0.000" ) ).format( q ) );
    }


    private void deleteFoodGroupQuantityConstraint() {
        if ( !tblGroupQuantityConstraint.isSelectionEmpty() ) {
            TableGroupQuantityConstraint.Row row = tblGroupQuantityConstraint.getSelectedValue();
            String mixid = row.getMixid();
            String groupid = row.getGroupid();
            String nutrientid = row.getNutrientid();
            Integer relationshipid = row.getRelationshipid();
            try {
                Future<Boolean> task0 = BackgroundExec.submit( new DeleteFoodGroupConstraintTask( mixid, groupid, nutrientid, relationshipid ) );
                Boolean completed = task0.get();
                if ( !completed ) {
                    return;
                }
                StringBuilder sb = new StringBuilder();
                sb.append( row.getGroup() );
                sb.append( " using " );
                sb.append( row.getNutrient() );
                sb.append( " " );
                sb.append( row.getRelationship() );
                sb.append( " " );
                sb.append( ( new DecimalFormat( "###0.0" ) ).format( row.getB() ) );
                addLogEntry(
                        selectedMixName,
                        "Delete",
                        "Group Quantity Constraint",
                        sb.toString(),
                        selectedMixId,
                        row.getGroupid(),
                        row.getNutrientid(),
                        "",
                        "",
                        row.getRelationshipid(),
                        row.getB(),
                        null );
                Future<List<List>> task1 = BackgroundExec.submit( new GroupConstraintsTask( mixid ) );
                List<List> constraints = task1.get();
                tblGroupQuantityConstraint.reload( constraints );
                setConstraintCounts();
            } catch ( Exception e ) {
                LoggerImpl.INSTANCE.logProblem( e );
            }
        }
    }
}
