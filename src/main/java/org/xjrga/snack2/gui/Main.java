package org.xjrga.snack2.gui;

import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.xjrga.snack2.data.DbLink;
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
import javax.swing.table.TableRowSorter;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    private final BufferedImage logo = ImageUtilities.readImage("resources/apple_red.png");
    private final DbLink dbLink = new DbLink();
    private final CellConstraints cc = new CellConstraints();
    private final ComboBoxModelFood cbmf_2 = new ComboBoxModelFood(dbLink);
    private final ComboBoxModelFood cbmf_3 = new ComboBoxModelFood(dbLink);
    private final ComboBoxModelFood cbmf_4 = new ComboBoxModelFood(dbLink);
    private final ComboBoxModelNutrients cbm_2 = new ComboBoxModelNutrients(dbLink);
    private final ComboBoxModelNutrients cbm_3 = new ComboBoxModelNutrients(dbLink);
    private final ComboBoxModelNutrients cbm_4 = new ComboBoxModelNutrients(dbLink);
    private final ComboBoxModelNutrients cbm_5 = new ComboBoxModelNutrients(dbLink);
    private final ComboBoxModelNutrients cbm_6 = new ComboBoxModelNutrients(dbLink);
    private final ComboBoxModelNutrients cbm_7 = new ComboBoxModelNutrients(dbLink);
    private final ComboBoxModelNutrients cmb_1 = new ComboBoxModelNutrients(dbLink);
    private final ComboBoxModelRelationships cbmr_7 = new ComboBoxModelRelationships(dbLink);
    private final ComboBoxModelRelationships cbmr_8 = new ComboBoxModelRelationships(dbLink);
    private final ComboBoxModelRelationships cbmr_9 = new ComboBoxModelRelationships(dbLink);
    private final JButton categories_add_btn = new JButton("+");
    private final JButton categories_delete_btn = new JButton("-");
    private final JButton categories_rename_btn = new JButton("u");
    private final JButton exchange_list_run_btn = new JButton("Run");
    private final JButton foodlist_add_btn = new JButton("+");
    private final JButton foodlist_delete_btn = new JButton("-");
    private final JButton foodlist_update_btn = new JButton("u");
    private final JButton food_nutrient_constraint_add_btn = new JButton("+");
    private final JButton food_nutrient_constraint_delete_btn = new JButton("-");
    private final JButton food_nutrient_ratio_add_btn = new JButton("+");
    private final JButton food_nutrient_ratio_delete_btn = new JButton("-");
    private final JButton nutrient_constraint_add_btn = new JButton("+");
    private final JButton nutrient_constraint_delete_btn = new JButton("-");
    private final JButton nutrient_ratio_add_btn = new JButton("+");
    private final JButton nutrient_ratio_delete_btn = new JButton("-");
    private final JComboBox exchange_list_nutrient_cb = new JComboBox();
    private final JComboBox facts_iscomplete_cb = new JComboBox();
    private final JComboBox food_nutrient_constraint_food_cb = new JComboBox();
    private final JComboBox food_nutrient_constraint_nutrient_cb = new JComboBox();
    private final JComboBox food_nutrient_constraint_relationship_cb = new JComboBox();
    private final JComboBox food_nutrient_ratio_food_a_cb = new JComboBox();
    private final JComboBox food_nutrient_ratio_food_b_cb = new JComboBox();
    private final JComboBox food_nutrient_ratio_nutrient_a_cb = new JComboBox();
    private final JComboBox food_nutrient_ratio_nutrient_b_cb = new JComboBox();
    private final JComboBox nutrient_constraint_nutrient_cb = new JComboBox();
    private final JComboBox nutrient_constraint_relationship_cb = new JComboBox();
    private final JComboBox nutrient_ratio_nutrient_a_cb = new JComboBox();
    private final JComboBox nutrient_ratio_nutrient_b_cb = new JComboBox();
    private final JFrame frame = new JFrame();
    private final JList categories_lst = new JList();
    private final JList compare_a_lst = new JList();
    private final JList compare_b_lst = new JList();
    private final JList list02 = new JList();
    private final JList mixesJournal = new JList();
    private final JList mixes = new JList();
    private final JList selectedFood = new JList();
    private final JMenuItem menubar_about_mnui = new JMenuItem();
    private final JMenuItem menubar_bmr_mnui = new JMenuItem();
    private final JMenuItem menubar_credits_mnui = new JMenuItem();
    private final JMenuItem menubar_exit_mnui = new JMenuItem();
    private final JMenuItem menubar_exportcompare_mnui = new JMenuItem();
    private final JMenuItem menubar_exportexchangelist_mnui = new JMenuItem();
    private final JMenuItem menubar_exportfoodjournal_mnui = new JMenuItem();
    private final JMenuItem menubar_exportfoodlist_mnui = new JMenuItem();
    private final JMenuItem menubar_guide_mnui = new JMenuItem();
    private final JMenu menubar_data_mnu = new JMenu();
    private final JMenu menubar_export_mnu = new JMenu();
    private final JMenu menubar_help_mnu = new JMenu();
    private final JMenu menubar_program_mnu = new JMenu();
    private final JMenu menubar_tools_mnu = new JMenu();
    private final JPanel statusBar = new JPanel();
    private final JTable compare_tbl = new JTable();
    private final JTable exchange_list_table = new JTable();
    private final JTable foodlist_tbl = new JTable();
    private final JTable food_nutrient_constraint_tbl = new JTable();
    private final JTable food_nutrient_ratio_table = new JTable();
    private final JTable nutrient_constraint_tbl = new JTable();
    private final JTable nutrient_ratio_tbl = new JTable();
    private final JTable tableJournal = new JTable();
    private final JTable tableResults = new JTable();
    private final JTextField exchange_list_quantity_txt = new JTextField();
    private final JTextField facts_alcohol_txt = new JTextField();
    private final JTextField facts_calcium_txt = new JTextField();
    private final JTextField facts_calories_txt = new JTextField();
    private final JTextField facts_carbohydrate_txt = new JTextField();
    private final JTextField facts_cholesterol_txt = new JTextField();
    private final JTextField facts_cost_txt = new JTextField();
    private final JTextField facts_fat_txt = new JTextField();
    private final JTextField facts_fiber_txt = new JTextField();
    private final JTextField facts_magnesium_txt = new JTextField();
    private final JTextField facts_monoufat_txt = new JTextField();
    private final JTextField facts_nom_txt = new JTextField();
    private final JTextField facts_polyufat_txt = new JTextField();
    private final JTextField facts_potassium_txt = new JTextField();
    private final JTextField facts_protein_txt = new JTextField();
    private final JTextField facts_quantity_txt = new JTextField();
    private final JTextField facts_satfat_txt = new JTextField();
    private final JTextField facts_sodium_txt = new JTextField();
    private final JTextField foodlist_search_txt = new JTextField();
    private final JTextField food_nutrient_constraint_quantity_txt = new JTextField();
    private final JTextField food_nutrient_ratio_quantity_a_txt = new JTextField();
    private final JTextField food_nutrient_ratio_quantity_b_txt = new JTextField();
    private final JTextField nutrient_constraint_quantity_txt = new JTextField();
    private final JTextField nutrient_ratio_nutrient_a_txt = new JTextField();
    private final JTextField nutrient_ratio_nutrient_b_txt = new JTextField();
    private final JTextPane model_txt = new JTextPane();
    private final JTree store = new JTree();
    private final ListModelCategory listModelCategory = new ListModelCategory(dbLink);
    private final ListModelFood2 listModelFood2 = new ListModelFood2(dbLink);
    private final ListModelFood listModelFood = new ListModelFood(dbLink);
    private final ListModelMix0 listModelMix0 = new ListModelMix0(dbLink);
    private final ListModelMix1 listModelMix1 = new ListModelMix1(dbLink);
    private final ListModelMix listModelMix = new ListModelMix(dbLink);
    private final ListModelSelectedFood listModelSelectedFood = new ListModelSelectedFood(dbLink);
    private final StringModelMixPct stringModelMixPct = new StringModelMixPct(dbLink);
    private final TableModelExchangeList tableModelExchangeList = new TableModelExchangeList(dbLink);
    private final TableModelFoodNutrientConstraints tableModelFoodNutrientConstraints = new TableModelFoodNutrientConstraints(dbLink);
    private final TableModelFoodNutrientRatioConstraints tableModelFoodNutrientRatioConstraints = new TableModelFoodNutrientRatioConstraints(dbLink);
    private final TableModelFood tableModelFoodList = new TableModelFood(dbLink);
    private final TableModelJournal tableModelJournal = new TableModelJournal(dbLink);
    private final TableModelMixDiff tableModelMixDiff = new TableModelMixDiff(dbLink);
    private final TableModelNutrientConstraints tableModelNutrientConstraints = new TableModelNutrientConstraints(dbLink);
    private final TableModelNutrientRatioConstraints tableModelNutrientRatioConstraints = new TableModelNutrientRatioConstraints(dbLink);
    private final TableModelResults modelResultsTable = new TableModelResults(dbLink);
    private final TableRowSorter sorter = new TableRowSorter<TableModelFood>(tableModelFoodList);
    private final TreeModelFood treeModel = new TreeModelFood(dbLink);
    private final JList list01 = new JList();
    private final JTable percent_nutrient_constraint_tbl = new JTable();
    private final JTextField percent_nutrient_constraint_quantity_txt = new JTextField();
    private final JComboBox percent_nutrient_constraint_food_cb = new JComboBox();
    private final JComboBox percent_nutrient_constraint_nutrient_cb = new JComboBox();
    private final JButton percent_nutrient_constraint_add_btn = new JButton("+");
    private final JButton percent_nutrient_constraint_delete_btn = new JButton("-");
    private final TableModelPercentNutrientConstraints tableModelPercentNutrientConstraints = new TableModelPercentNutrientConstraints(dbLink);
    private final JList highScore = new JList();
    private final DefaultListModel highScoreModel = new DefaultListModel();

    public Main() {
        FormLayout layout = new FormLayout("min:grow", //columns
                "fill:min:grow,1dlu,min" //rows
        );

        frame.setIconImage(logo);
        frame.setJMenuBar(getMenuBar());
        JTabbedPane mainTabbedPane = new JTabbedPane();
        mainTabbedPane.setTabPlacement(JTabbedPane.BOTTOM);
        mainTabbedPane.add(getSolve());
        mainTabbedPane.add(getFoodList());
        mainTabbedPane.add(getCategories());
        mainTabbedPane.add(getFoodJournal());
        mainTabbedPane.add(getFoodExchangeList());
        mainTabbedPane.add(getMixDiff());
        mainTabbedPane.setTitleAt(0, "Solve");
        mainTabbedPane.setToolTipTextAt(0, "Specify your mix problem here");
        mainTabbedPane.setTitleAt(1, "Food List");
        mainTabbedPane.setToolTipTextAt(1, "This is your list of favorite food items");
        mainTabbedPane.setTitleAt(2, "Food Category");
        mainTabbedPane.setToolTipTextAt(2, "This is your list of food categories");
        mainTabbedPane.setTitleAt(3, "Food Journal");
        mainTabbedPane.setToolTipTextAt(3, "This is your list of mixes");
        mainTabbedPane.setTitleAt(4, "Food Exchange");
        mainTabbedPane.setToolTipTextAt(4, "This shows you how much food contains a specific amount of nutrient");
        mainTabbedPane.setTitleAt(5, "Mix Δ");
        mainTabbedPane.setToolTipTextAt(5, "This is where you compare mixes");

        JPanel panelF = new JPanel();
        panelF.setLayout(layout);
        panelF.add(mainTabbedPane, cc.xy(1, 1));
        statusBar.setBorder(new LineBorder(Color.GRAY));
        statusBar.add(new Label(""));
        panelF.add(statusBar, cc.xy(1, 3));
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(panelF);

        frame.add(scrollPane);
        frame.setDefaultCloseOperation(3);
        Dimension size = new Dimension(1401, 780);
        frame.setSize(size);
        frame.setVisible(true);
        frame.setTitle("Snack");

        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                event_menubar_exit_mnui();
            }
        });

        frame.addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent e) {
                Dimension size = frame.getSize();
                //System.out.println(size.width + "," + size.height);
            }
        });

        cmb_1.reload();
        cbm_2.reload();
        cbm_3.reload();
        cbm_4.reload();
        cbm_5.reload();
        cbm_6.reload();
        cbmr_7.reload();
        cbmr_8.reload();
        cbmr_9.reload();
        listModelMix1.reload();
        //
        tableModelNutrientConstraints.reload(-1);
        resizeColumns_NutrientConstraintTableColumns();
        tableModelFoodNutrientConstraints.reload(-1);
        resizeColumns_FoodNutrientConstraintTableColumns();
        tableModelNutrientRatioConstraints.reload(-1);
        resizeColumns_NutrientRatioConstraintTableColumns();
        tableModelFoodNutrientRatioConstraints.reload(-1);
        resizeColumns_FoodNutrientRatioConstraintTableColumns();
        tableModelPercentNutrientConstraints.reload(-1);
        resizeColumns_PercentNutrientConstraintTableColumns();


    }

    public static void main(String[] args) {
        try {
            MetalLookAndFeel.setCurrentTheme(new Minimal());
            //MetalLookAndFeel.setCurrentTheme(new OceanTheme01());
            //MetalLookAndFeel.setCurrentTheme(new OceanTheme02());
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (ClassNotFoundException e) {

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        Main main = new Main();
    }

    private JMenuBar getMenuBar() {
        JMenuBar mnuBar = new JMenuBar();
        mnuBar.add(menubar_program_mnu);
        mnuBar.add(menubar_tools_mnu);
        mnuBar.add(menubar_data_mnu);
        mnuBar.add(menubar_help_mnu);
        menubar_program_mnu.add(menubar_exit_mnui);
        menubar_tools_mnu.add(menubar_bmr_mnui);
        menubar_data_mnu.add(menubar_export_mnu);
        menubar_export_mnu.add(menubar_exportfoodlist_mnui);
        menubar_export_mnu.add(menubar_exportfoodjournal_mnui);
        menubar_export_mnu.add(menubar_exportexchangelist_mnui);
        menubar_export_mnu.add(menubar_exportcompare_mnui);
        menubar_help_mnu.add(menubar_guide_mnui);
        menubar_help_mnu.add(menubar_credits_mnui);
        menubar_help_mnu.add(menubar_about_mnui);
        //setText
        menubar_program_mnu.setText("Program");
        menubar_tools_mnu.setText("Tools");
        menubar_data_mnu.setText("Data");
        menubar_help_mnu.setText("Help");
        menubar_exit_mnui.setText("Exit");
        menubar_bmr_mnui.setText("Calculate Basal Metabolic Rate");
        menubar_export_mnu.setText("Export");
        menubar_exportfoodlist_mnui.setText("Food List");
        menubar_exportfoodjournal_mnui.setText("Food Journal");
        menubar_exportexchangelist_mnui.setText("Food Exchange List");
        menubar_exportcompare_mnui.setText("Mix Δ");

        menubar_guide_mnui.setText("Guide");
        menubar_credits_mnui.setText("Credits");
        menubar_about_mnui.setText("About");

        menubar_bmr_mnui.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                event_menubar_bmr_mnui(e);
            }
        });

        menubar_exportfoodjournal_mnui.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                event_menubar_exportfoodjournal_mnui(e);
            }
        });

        menubar_exportfoodlist_mnui.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                event_menubar_exportfoodlist_mnui(e);
            }
        });

        menubar_exportcompare_mnui.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                event_menubar_exportcompare_mnui(e);
            }
        });

        menubar_exportexchangelist_mnui.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                event_menubar_exportexchangelist_mnui(e);
            }
        });

        menubar_guide_mnui.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                event_menubar_guide_mnui(e);
            }
        });

        menubar_credits_mnui.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                event_menubar_credits_mnui(e);
            }
        });

        menubar_about_mnui.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                event_menubar_about_mnui(e);
            }
        });

        menubar_exit_mnui.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                event_menubar_exit_mnui();
            }
        });

        return mnuBar;
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

        splitPane1.setLeftComponent(getMixes());
        splitPane1.setRightComponent(bottomTabPane);

        bottom.add(splitPane1, cc.xy(1, 1));

        bottomTabPane.add(getMixFood());
        bottomTabPane.add(getAmountOfNutrientConstraint());
        bottomTabPane.add(getPercentOfNutrientConstraint());
        bottomTabPane.add(getAmountOfFoodNutrientConstraint());
        bottomTabPane.add(getFoodNutrientRatioConstraint());
        bottomTabPane.add(getNutrientRatioConstraint());
        bottomTabPane.add(getModel());
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

        panel.add(splitPane, cc.xy(1, 1));

        mixes.addListSelectionListener(new ListSelectionListener() {

            public void valueChanged(ListSelectionEvent e) {
                event_mix_list(e);

            }
        });

        mixes.setModel(listModelMix1);

        return panel;
    }

    private JPanel getMixes() {
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

        JButton add = new JButton("+");
        JButton delete = new JButton("-");
        JButton update = new JButton("u");
        JButton duplicate = new JButton("d");
        JButton status = new JButton("h");
        JButton foodlist = new JButton("f");
        JButton mixfood_solve_btn = new JButton("Solve");

        add.setToolTipText("Add new mix");
        delete.setToolTipText("Delete mix");
        update.setToolTipText("Rename mix");
        duplicate.setToolTipText("Duplicate mix");
        status.setToolTipText("Hide mix");
        foodlist.setToolTipText("Use mix as food item");
        mixfood_solve_btn.setToolTipText("Find lowest calorie food combination");

        panelButtons.add(add, cc.xy(2, 1));
        panelButtons.add(delete, cc.xy(3, 1));
        panelButtons.add(update, cc.xy(4, 1));
        panelButtons.add(duplicate, cc.xy(5, 1));
        panelButtons.add(foodlist, cc.xy(7, 1));
        panelButtons.add(status, cc.xy(8, 1));
        panelButtons.add(mixfood_solve_btn, cc.xy(10, 1));

        JScrollPane s_mixes = new JScrollPane(mixes);
        panel.add(s_mixes, cc.xy(1, 1));
        panel.add(panelButtons, cc.xy(1, 2));

        add.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                event_panelmix_add_btn();
            }
        });

        delete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                event_panelmix_delete_btn();
            }
        });

        update.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                event_panelmix_update_btn();
            }
        });

        duplicate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                event_panelmix_duplicate_btn();
            }
        });

        status.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                event_panelmix_status_btn();
            }
        });

        foodlist.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                event_panelmix_fl_btn();
            }
        });

        mixfood_solve_btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                event_mixfood_solve_btn();
            }
        });

        return panel;
    }

    private void event_panelmix_status_btn() {
        if (isListMixSelected()) {
            try {
                MixDataObject mix = (MixDataObject) mixes.getSelectedValue();
                Integer mixId = mix.getMixId();
                dbLink.Mix_Update_Status(mixId, 0);
                //listModelMix0.reload();
                listModelMix1.reload();
                listModelMix.reload();
                mixId = -1;
                listModelSelectedFood.reload(mixId);
                tableModelNutrientConstraints.reload(mixId);
                resizeColumns_NutrientConstraintTableColumns();
                tableModelFoodNutrientConstraints.reload(mixId);
                resizeColumns_FoodNutrientConstraintTableColumns();
                tableModelNutrientRatioConstraints.reload(mixId);
                resizeColumns_NutrientRatioConstraintTableColumns();
                tableModelFoodNutrientRatioConstraints.reload(mixId);
                resizeColumns_FoodNutrientRatioConstraintTableColumns();
                tableModelPercentNutrientConstraints.reload(mixId);
                resizeColumns_PercentNutrientConstraintTableColumns();
                modelResultsTable.reload(mixId);
                resizeColumns_ResultsTable();
                model_txt.setText("");
                statusBar.removeAll();
                statusBar.add(new JLabel(stringModelMixPct.reload(mixId)));
                statusBar.revalidate();
                statusBar.repaint();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    private void event_panelmix_add_btn() {
        JTextField input = new JTextField();
        JComponent[] inputs = new JComponent[]{
                new JLabel("What is your new mix name?"),
                input
        };
        int optionValue = Message.showOptionDialog(inputs, "Create Mix");

        if (optionValue == 0) {
            CheckString checkString = new CheckString();
            checkString.addName(input.getText());

            if (checkString.pass()) {
                String mixnom = input.getText();
                String model = "";
                String nutrientid = "208";

                try {
                    Integer mixid = dbLink.Mix_Insert(mixnom);
                    dbLink.MixModel_Merge(mixid, nutrientid, model);
                    dbLink.Mix_Update_Status(mixid, 1);
                    reloadMixes();
                    model_txt.setText("");
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            } else {
                Message.showMessage("a-Z 0-9 . , ' % ( ) / & _ characters only");
            }
        }
    }

    private void reloadMixes() {
        //status = 1
        listModelMix1.reload();
        //status = 0 or 1
        listModelMix.reload();
        //status = 0
        listModelMix0.reload();
    }

    private void event_panelmix_delete_btn() {
        if (isListMixSelected()) {
            try {
                MixDataObject mix = (MixDataObject) mixes.getSelectedValue();
                Integer mixId = mix.getMixId();
                dbLink.Mix_Delete(mixId);
                listModelMix1.reload();
                listModelMix.reload();
                mixId = -1;
                listModelSelectedFood.reload(mixId);
                tableModelNutrientConstraints.reload(mixId);
                resizeColumns_NutrientConstraintTableColumns();
                tableModelFoodNutrientConstraints.reload(mixId);
                resizeColumns_FoodNutrientConstraintTableColumns();
                tableModelNutrientRatioConstraints.reload(mixId);
                resizeColumns_NutrientRatioConstraintTableColumns();
                tableModelFoodNutrientRatioConstraints.reload(mixId);
                resizeColumns_FoodNutrientRatioConstraintTableColumns();
                tableModelPercentNutrientConstraints.reload(mixId);
                resizeColumns_PercentNutrientConstraintTableColumns();
                modelResultsTable.reload(mixId);
                resizeColumns_ResultsTable();
                model_txt.setText("");
                cbmf_2.reload(mixId);
                cbmf_3.reload(mixId);
                cbmf_4.reload(mixId);
                statusBar.removeAll();
                statusBar.add(new JLabel(stringModelMixPct.reload(mixId)));
                statusBar.revalidate();
                statusBar.repaint();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        } else {
            Message.showMessage("Select mix.");
        }
    }


    private void event_panelmix_update_btn() {
        if (isListMixSelected()) {
            JTextField input = new JTextField();
            JComponent[] inputs = new JComponent[]{
                    new JLabel("What is your new mix name?"),
                    input
            };

            MixDataObject mix = (MixDataObject) mixes.getSelectedValue();
            input.setText(mix.getName());

            int optionValue = Message.showOptionDialog(inputs, "Update Mix");

            if (optionValue == 0) {
                CheckString checkString = new CheckString();
                checkString.addName(input.getText());

                if (checkString.pass()) {
                    try {
                        String mixnom = input.getText();
                        Integer mixId = mix.getMixId();
                        dbLink.Mix_Update(mixId, mixnom);
                        reloadMixes();
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                } else {
                    Message.showMessage("a-Z 0-9 . , ' % ( ) / & _ characters only");
                }
            }
        }
    }

    private void event_panelmix_duplicate_btn() {
        if (isListMixSelected()) {
            try {
                MixDataObject mix = (MixDataObject) mixes.getSelectedValue();
                Integer mixId = mix.getMixId();
                dbLink.Mix_Duplicate(mixId);
                //listModelMix0.reload();
                listModelMix1.reload();
                listModelMix.reload();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        } else {
            Message.showMessage("Select mix.");
        }
    }

    private void event_panelmix_fl_btn() {
        if (isListMixSelected()) {
            try {
                MixDataObject mixDataObject = (MixDataObject) mixes.getSelectedValue();
                dbLink.Food_Put(mixDataObject.getMixId());
                reloadFoodItems();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            Message.showMessage("Select mix.");
        }
    }

    private JPanel getMixDiff() {
        JPanel panel = new JPanel();

        JScrollPane scrollPaneA = new JScrollPane(compare_a_lst);
        JScrollPane scrollPaneB = new JScrollPane(compare_b_lst);
        JScrollPane scrollPaneC = new JScrollPane(compare_tbl);
        CellConstraints cc = new CellConstraints();

        //create layouts
        FormLayout layout = new FormLayout(
                "min:grow(.25),min:grow(.25),min:grow", //columns
                "fill:min:grow" //rows
        );

        //specify layouts
        panel.setLayout(layout);

        //place components
        panel.add(scrollPaneA, cc.xy(1, 1));
        panel.add(scrollPaneB, cc.xy(2, 1));
        panel.add(scrollPaneC, cc.xy(3, 1));

        layout.setColumnGroup(1, 2);

        //set groups
        //specify size
        //specify text
        scrollPaneA.setBorder(new TitledBorder("Mix 1"));
        scrollPaneB.setBorder(new TitledBorder("Mix 2"));
        scrollPaneC.setBorder(new TitledBorder("Mix Difference"));

        //listeners
        compare_a_lst.addListSelectionListener(new ListSelectionListener() {

            public void valueChanged(ListSelectionEvent e) {
                event_compare_a_list(e);
            }
        });

        compare_b_lst.addListSelectionListener(new ListSelectionListener() {

            public void valueChanged(ListSelectionEvent e) {
                event_compare_b_list(e);
            }
        });

        compare_a_lst.setModel(listModelMix);
        compare_b_lst.setModel(listModelMix);
        compare_tbl.setModel(tableModelMixDiff);
        compare_tbl.setFillsViewportHeight(true);
        compare_tbl.getTableHeader().setReorderingAllowed(false);

        listModelMix.reload();

        return panel;
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

        JButton btnStatus = new JButton("h");

        btnStatus.setToolTipText("Unhide");

        buttons.add(btnStatus, cc.xy(2, 1));

        JScrollPane mixesJournalSp = new JScrollPane(mixesJournal);
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

        btnStatus.addActionListener(e -> event_status_btn(e));

        tableJournal.getTableHeader().setReorderingAllowed(false);
        tableJournal.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tableJournal.setModel(tableModelJournal);
        tableJournal.setFillsViewportHeight(true);

        mixesJournal.addListSelectionListener(e -> event_mixesJournal_list(e));
        mixesJournal.setModel(listModelMix);

        listModelMix.reload();

        return panel;
    }

    private void event_mixesJournal_list(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()) {
            if (!mixesJournal.isSelectionEmpty()) {

                MixDataObject mixDataObject = (MixDataObject) mixesJournal.getSelectedValue();
                Integer mixId = mixDataObject.getMixId();
                //
                tableModelJournal.reload(mixId);
                resizeColumns_JournalTable();
            }
        }

    }

    private void event_status_btn(ActionEvent e) {
        if (!mixesJournal.isSelectionEmpty()) {
            try {
                MixDataObject mix = (MixDataObject) mixesJournal.getSelectedValue();
                Integer mixId = mix.getMixId();
                dbLink.Mix_Update_Status(mixId, 1);
                //listModelMix0.reload();
                listModelMix1.reload();
                listModelMix.reload();
                mixId = -1;
                //tableModelJournal.reload(mixId);
                listModelSelectedFood.reload(mixId);
                tableModelNutrientConstraints.reload(mixId);
                resizeColumns_NutrientConstraintTableColumns();
                tableModelFoodNutrientConstraints.reload(mixId);
                resizeColumns_FoodNutrientConstraintTableColumns();
                tableModelNutrientRatioConstraints.reload(mixId);
                resizeColumns_NutrientRatioConstraintTableColumns();
                tableModelFoodNutrientRatioConstraints.reload(mixId);
                resizeColumns_FoodNutrientRatioConstraintTableColumns();
                tableModelPercentNutrientConstraints.reload(mixId);
                resizeColumns_PercentNutrientConstraintTableColumns();
                modelResultsTable.reload(mixId);
                resizeColumns_ResultsTable();
                model_txt.setText("");
                statusBar.removeAll();
                statusBar.add(new JLabel(stringModelMixPct.reload(mixId)));
                statusBar.revalidate();
                statusBar.repaint();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
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
                "min:grow,min,min,min,min:grow", //columns
                "min" //rows
        );

        buttonPanel.setLayout(buttonPanelLayout);

        JScrollPane scrollPaneTable = new JScrollPane(foodlist_tbl);

        searchPanel.add(new JLabel("Search:"), cc.xy(1, 1));
        searchPanel.add(foodlist_search_txt, cc.xy(2, 1));


        buttonPanel.add(foodlist_add_btn, cc.xy(2, 1));
        buttonPanel.add(foodlist_delete_btn, cc.xy(3, 1));
        buttonPanel.add(foodlist_update_btn, cc.xy(4, 1));

        panel.add(searchPanel, cc.xy(1, 1));
        panel.add(scrollPaneTable, cc.xy(1, 2));
        panel.add(buttonPanel, cc.xy(1, 3));

        scrollPaneTable.setBorder(new TitledBorder("Food List"));

        foodlist_search_txt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                event_food_list_search_txt(e);
            }
        });

        foodlist_add_btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                event_foodlist_add_btn();
            }
        });

        foodlist_delete_btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                event_foodlist_delete_btn();
            }
        });

        foodlist_update_btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                event_foodlist_update_btn();
            }
        });

        foodlist_search_txt.getDocument().addDocumentListener(
                new DocumentListener() {
                    public void changedUpdate(DocumentEvent e) {
                        newFilter();
                    }

                    public void insertUpdate(DocumentEvent e) {
                        newFilter();
                    }

                    public void removeUpdate(DocumentEvent e) {
                        newFilter();
                    }
                });

        foodlist_tbl.getTableHeader().setReorderingAllowed(false);
        foodlist_tbl.setRowSorter(sorter);
        foodlist_tbl.setModel(tableModelFoodList);
        foodlist_tbl.setFillsViewportHeight(true);
        foodlist_tbl.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        tableModelFoodList.reload();

        return panel;
    }

    private void newFilter() {
        RowFilter<TableModelFood, Object> rf = null;
        try {
            ArrayList filters = new ArrayList();
            filters.add(RowFilter.regexFilter("(?i)" + foodlist_search_txt.getText(), 0));
            filters.add(RowFilter.regexFilter("(?i)" + foodlist_search_txt.getText(), 1));
            rf = RowFilter.orFilter((Iterable<? extends RowFilter<? super TableModelFood, ? super Object>>) filters);
        } catch (java.util.regex.PatternSyntaxException e) {
            return;
        }
        sorter.setRowFilter(rf);
    }

    private void event_foodlist_add_btn() {
        facts_nom_txt.setText("");
        facts_quantity_txt.setText("");
        facts_protein_txt.setText("");
        facts_fat_txt.setText("");
        facts_carbohydrate_txt.setText("");
        facts_calories_txt.setText("");
        facts_alcohol_txt.setText("");
        facts_fiber_txt.setText("");
        facts_calcium_txt.setText("");
        facts_magnesium_txt.setText("");
        facts_potassium_txt.setText("");
        facts_sodium_txt.setText("");
        facts_cholesterol_txt.setText("");
        facts_satfat_txt.setText("");
        facts_monoufat_txt.setText("");
        facts_polyufat_txt.setText("");
        facts_quantity_txt.setText("");
        facts_cost_txt.setText("");

        JComponent[] inputs = new JComponent[]{
                getNutritionalFacts()
        };
        int optionValue = Message.showOptionDialog(inputs, "Nutritional Facts");
        CheckString checkString = new CheckString();
        CheckNumber checkNumbers = new CheckNumber();

        checkString.addName(facts_nom_txt.getText());
        checkNumbers.addNumber(facts_quantity_txt.getText());
        checkNumbers.addNumber(facts_calories_txt.getText());
        checkNumbers.addNumber(facts_protein_txt.getText());
        checkNumbers.addNumber(facts_fat_txt.getText());
        checkNumbers.addNumber(facts_carbohydrate_txt.getText());
        checkNumbers.addNumber(facts_fiber_txt.getText());
        checkNumbers.addNumber(facts_satfat_txt.getText());
        checkNumbers.addNumber(facts_monoufat_txt.getText());
        checkNumbers.addNumber(facts_polyufat_txt.getText());
        checkNumbers.addNumber(facts_cholesterol_txt.getText());
        checkNumbers.addNumber(facts_sodium_txt.getText());
        checkNumbers.addNumber(facts_potassium_txt.getText());
        checkNumbers.addNumber(facts_calcium_txt.getText());
        checkNumbers.addNumber(facts_magnesium_txt.getText());
        checkNumbers.addNumber(facts_alcohol_txt.getText());
        checkNumbers.addNumber(facts_cost_txt.getText());

        if (optionValue == 0) {
            if (checkNumbers.pass() && checkString.pass()) {
                String v_foodnom = facts_nom_txt.getText();
                Double v_serving_size = Double.valueOf(facts_quantity_txt.getText());
                Double v_calories = Double.valueOf(facts_calories_txt.getText());
                Double v_protein = Double.valueOf(facts_protein_txt.getText());
                Double v_fat = Double.valueOf(facts_fat_txt.getText());
                Double v_carbohydrates = Double.valueOf(facts_carbohydrate_txt.getText());
                Double v_fiber = Double.valueOf(facts_fiber_txt.getText());
                Double v_saturated_fat = Double.valueOf(facts_satfat_txt.getText());
                Double v_monounsaturated_fat = Double.valueOf(facts_monoufat_txt.getText());
                Double v_polyunsaturated_fat = Double.valueOf(facts_polyufat_txt.getText());
                Double v_cholesterol = Double.valueOf(facts_cholesterol_txt.getText());
                Double v_sodium = Double.valueOf(facts_sodium_txt.getText());
                Double v_potassium = Double.valueOf(facts_potassium_txt.getText());
                Double v_calcium = Double.valueOf(facts_calcium_txt.getText());
                Double v_magnesium = Double.valueOf(facts_magnesium_txt.getText());
                Double v_alcohol = Double.valueOf(facts_alcohol_txt.getText());
                Double v_cost = Double.valueOf(facts_cost_txt.getText());
                String isComplete = (String) facts_iscomplete_cb.getSelectedItem();
                double v_complete_protein;
                double v_incomplete_protein;
                if (isComplete.equals("False")) {
                    v_complete_protein = 0.0;
                    v_incomplete_protein = v_protein;

                } else {

                    v_complete_protein = v_protein;
                    v_incomplete_protein = 0.0;

                }

                try {
                    dbLink.Food_Add_Details(v_foodnom, v_serving_size, v_calories, v_protein, v_fat, v_carbohydrates, v_fiber, v_saturated_fat, v_monounsaturated_fat, v_polyunsaturated_fat, v_cholesterol, v_sodium, v_potassium, v_calcium, v_magnesium, v_cost, v_complete_protein, v_incomplete_protein, v_alcohol);
                    reloadFoodItems();

                    if (!categories_lst.isSelectionEmpty()) {
                        FoodCategoryDataObject foodCategoryDataObject = (FoodCategoryDataObject) categories_lst.getSelectedValue();
                        listModelFood2.reload(foodCategoryDataObject.getFoodCategoryId());
                    }
                } catch (SQLException e) {
                    Message.showMessage(e.getMessage());
                }
            } else {
                Message.showMessage("Verify input values");
            }
        }
    }

    private void event_foodlist_update_btn() {
        int selectedRowNo = foodlist_tbl.getSelectedRow();

        if (selectedRowNo != -1) {
            String category = (String) foodlist_tbl.getValueAt(selectedRowNo, 0);
            String v_foodnom = (String) foodlist_tbl.getValueAt(selectedRowNo, 1);
            double v_protein = (double) foodlist_tbl.getValueAt(selectedRowNo, 2);
            double v_fat = (double) foodlist_tbl.getValueAt(selectedRowNo, 3);
            double v_carbohydrates = (double) foodlist_tbl.getValueAt(selectedRowNo, 4);
            double v_calories = (double) foodlist_tbl.getValueAt(selectedRowNo, 5);
            double v_alcohol = (double) foodlist_tbl.getValueAt(selectedRowNo, 6);
            double v_fiber = (double) foodlist_tbl.getValueAt(selectedRowNo, 7);
            double v_calcium = (double) foodlist_tbl.getValueAt(selectedRowNo, 8);
            double v_magnesium = (double) foodlist_tbl.getValueAt(selectedRowNo, 9);
            double v_potassium = (double) foodlist_tbl.getValueAt(selectedRowNo, 10);
            double v_sodium = (double) foodlist_tbl.getValueAt(selectedRowNo, 11);
            double v_cholesterol = (double) foodlist_tbl.getValueAt(selectedRowNo, 12);
            double v_saturated_fat = (double) foodlist_tbl.getValueAt(selectedRowNo, 13);
            double v_monounsaturated_fat = (double) foodlist_tbl.getValueAt(selectedRowNo, 14);
            double v_polyunsaturated_fat = (double) foodlist_tbl.getValueAt(selectedRowNo, 15);
            double v_serving_size = (double) foodlist_tbl.getValueAt(selectedRowNo, 16);
            double v_complete_protein = (double) foodlist_tbl.getValueAt(selectedRowNo, 17);
            double v_incomplete_protein = (double) foodlist_tbl.getValueAt(selectedRowNo, 18);
            double v_cost = (double) foodlist_tbl.getValueAt(selectedRowNo, 19);
            String foodcategoryid = (String) foodlist_tbl.getValueAt(selectedRowNo, 20);
            String v_foodid = (String) foodlist_tbl.getValueAt(selectedRowNo, 21);

            facts_nom_txt.setText(v_foodnom);
            facts_quantity_txt.setText(Double.toString(v_serving_size));
            facts_calories_txt.setText(Double.toString(v_calories));
            facts_protein_txt.setText(Double.toString(v_protein));
            facts_fat_txt.setText(Double.toString(v_fat));
            facts_carbohydrate_txt.setText(Double.toString(v_carbohydrates));
            facts_fiber_txt.setText(Double.toString(v_fiber));
            facts_satfat_txt.setText(Double.toString(v_saturated_fat));
            facts_monoufat_txt.setText(Double.toString(v_monounsaturated_fat));
            facts_polyufat_txt.setText(Double.toString(v_polyunsaturated_fat));
            facts_cholesterol_txt.setText(Double.toString(v_cholesterol));
            facts_alcohol_txt.setText(Double.toString(v_alcohol));
            facts_sodium_txt.setText(Double.toString(v_sodium));
            facts_potassium_txt.setText(Double.toString(v_potassium));
            facts_calcium_txt.setText(Double.toString(v_calcium));
            facts_magnesium_txt.setText(Double.toString(v_magnesium));
            facts_cost_txt.setText(Double.toString(v_cost));

            if (v_protein != 0) {

                if (v_complete_protein >= v_incomplete_protein) {
                    facts_iscomplete_cb.setSelectedItem("True");
                } else {
                    facts_iscomplete_cb.setSelectedItem("False");
                }

            } else {
                facts_iscomplete_cb.setSelectedItem("False");
            }

            JComponent[] inputs = new JComponent[]{
                    getNutritionalFacts()
            };

            int optionValue = Message.showOptionDialog(inputs, "Nutritional Facts");

            CheckNumber checkNumbers = new CheckNumber();
            CheckString checkString = new CheckString();

            checkString.addName(facts_nom_txt.getText());
            checkNumbers.addNumber(facts_quantity_txt.getText());
            checkNumbers.addNumber(facts_calories_txt.getText());
            checkNumbers.addNumber(facts_protein_txt.getText());
            checkNumbers.addNumber(facts_fat_txt.getText());
            checkNumbers.addNumber(facts_carbohydrate_txt.getText());
            checkNumbers.addNumber(facts_fiber_txt.getText());
            checkNumbers.addNumber(facts_satfat_txt.getText());
            checkNumbers.addNumber(facts_monoufat_txt.getText());
            checkNumbers.addNumber(facts_polyufat_txt.getText());
            checkNumbers.addNumber(facts_cholesterol_txt.getText());
            checkNumbers.addNumber(facts_sodium_txt.getText());
            checkNumbers.addNumber(facts_potassium_txt.getText());
            checkNumbers.addNumber(facts_calcium_txt.getText());
            checkNumbers.addNumber(facts_magnesium_txt.getText());
            checkNumbers.addNumber(facts_alcohol_txt.getText());
            checkNumbers.addNumber(facts_cost_txt.getText());

            if (optionValue == 0) {
                if (checkNumbers.pass() && checkString.pass()) {
                    try {
                        v_foodnom = facts_nom_txt.getText();
                        v_serving_size = Double.valueOf(facts_quantity_txt.getText());
                        v_calories = Double.valueOf(facts_calories_txt.getText());
                        v_protein = Double.valueOf(facts_protein_txt.getText());
                        v_fat = Double.valueOf(facts_fat_txt.getText());
                        v_carbohydrates = Double.valueOf(facts_carbohydrate_txt.getText());
                        v_fiber = Double.valueOf(facts_fiber_txt.getText());
                        v_saturated_fat = Double.valueOf(facts_satfat_txt.getText());
                        v_monounsaturated_fat = Double.valueOf(facts_monoufat_txt.getText());
                        v_polyunsaturated_fat = Double.valueOf(facts_polyufat_txt.getText());
                        v_cholesterol = Double.valueOf(facts_cholesterol_txt.getText());
                        v_sodium = Double.valueOf(facts_sodium_txt.getText());
                        v_potassium = Double.valueOf(facts_potassium_txt.getText());
                        v_calcium = Double.valueOf(facts_calcium_txt.getText());
                        v_magnesium = Double.valueOf(facts_magnesium_txt.getText());
                        v_alcohol = Double.valueOf(facts_alcohol_txt.getText());
                        v_cost = Double.valueOf(facts_cost_txt.getText());
                        String isComplete = (String) facts_iscomplete_cb.getSelectedItem();

                        if (isComplete.equals("False")) {
                            v_complete_protein = 0.0;
                            v_incomplete_protein = v_protein;

                        } else {

                            v_complete_protein = v_protein;
                            v_incomplete_protein = 0.0;

                        }

                        dbLink.Food_Update_Details(v_foodid, v_foodnom, v_serving_size, v_calories, v_protein, v_fat, v_carbohydrates, v_fiber, v_saturated_fat, v_monounsaturated_fat, v_polyunsaturated_fat, v_cholesterol, v_sodium, v_potassium, v_calcium, v_magnesium, v_cost, v_complete_protein, v_incomplete_protein, v_alcohol);
                        reloadFoodItems();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                } else {
                    Message.showMessage("Verify input values");
                }
            }
        }
    }

    private void reloadFoodItems() {
        tableModelFoodList.reload();
        treeModel.reload();
        listModelFood.reload();
    }

    private void event_foodlist_delete_btn() {
        int selectedRowNo = foodlist_tbl.getSelectedRow();

        if (selectedRowNo != -1) {
            String foodnom = (String) foodlist_tbl.getValueAt(selectedRowNo, 1);
            String foodid = (String) foodlist_tbl.getValueAt(selectedRowNo, 21);

            try {
                dbLink.Food_Delete(foodid);
                reloadFoodItems();

                if (!categories_lst.isSelectionEmpty()) {
                    FoodCategoryDataObject foodCategoryDataObject = (FoodCategoryDataObject) categories_lst.getSelectedValue();
                    listModelFood2.reload(foodCategoryDataObject.getFoodCategoryId());
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private JPanel getFoodExchangeList() {
        JPanel panel = new JPanel();

        FormLayout panelLayout = new FormLayout(
                "min,min:grow,2dlu,min,min:grow,min", //columns
                "1dlu,min,1dlu,fill:min:grow" //rows
        );

        panel.setLayout(panelLayout);

        JScrollPane exchange_list_sc = new JScrollPane(exchange_list_table);

        panel.add(new JLabel("Nutrient: "), cc.xy(1, 2));
        panel.add(exchange_list_nutrient_cb, cc.xy(2, 2));
        panel.add(new JLabel("Quantity: "), cc.xy(4, 2));
        panel.add(exchange_list_quantity_txt, cc.xy(5, 2));
        panel.add(exchange_list_run_btn, cc.xy(6, 2));
        panel.add(exchange_list_sc, cc.xyw(1, 4, 6));

        exchange_list_sc.setBorder(new TitledBorder("Food Exchange List"));

        exchange_list_table.setToolTipText("This quantity of food (g) contains specified quantity of nutrient");
        exchange_list_table.getTableHeader().setReorderingAllowed(false);

        exchange_list_run_btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                event_exchange_list_run_btn();
            }
        });


        exchange_list_nutrient_cb.setModel(cbm_7);
        cbm_7.reload();
        exchange_list_table.setModel(tableModelExchangeList);
        exchange_list_table.setFillsViewportHeight(true);
        resizeColumns_ExchangeTable();

        return panel;
    }

    private void event_menubar_exit_mnui() {
        ThreadGroup root = Thread.currentThread().getThreadGroup();
        Thread[] threads = new Thread[100];
        int numThreads = root.enumerate(threads);
        HashMap<String, Thread> threadMap = new HashMap();
        for (int i = 0; i < numThreads; i++) {
            if (threads[i].getName().matches("HSQLDB Timer.*")) {
                threadMap.put("HSQLDB Timer", threads[i]);
            } else {
                threadMap.put(threads[i].getName(), threads[i]);
            }
        }
        //System.out.println(threadMap.toString());
        dbLink.Shutdown();
        try {
            if (threadMap.get("HSQLDB Timer").isAlive()) {
                Thread.sleep(1000);
            }
            System.exit(0);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        /* *
        I noticed when using frame.dispose() that sometimes program remained alive. I would like to ensure
        that database is shutdown properly before terminating running java virtual machine.
        * */
    }

    private void event_menubar_bmr_mnui(ActionEvent e) {
        JTextField input = new JTextField();
        JComponent[] inputs = new JComponent[]{
                new JLabel("What is your lean body mass in pounds?"),
                input
        };
        JOptionPane optionPane = new JOptionPane(inputs, JOptionPane.PLAIN_MESSAGE, JOptionPane.DEFAULT_OPTION);
        JDialog dialog = optionPane.createDialog("Energy");
        dialog.setIconImage(logo);
        dialog.setVisible(true);

        String s = input.getText();

        if (s != null && s.length() > 0) {
            StringBuffer sb = new StringBuffer();
            CheckNumber checkNumber = new CheckNumber();
            checkNumber.addNumber(s);

            if (checkNumber.pass()) {
                Double weightinlbs = Double.valueOf(s);
                double rdee = new KatchMcArdleFormula(weightinlbs).getCalories();
                sb.append("Katch-McArdle Formula (Resting Daily Energy Expenditure)\n");
                sb.append(Math.round(rdee));
                sb.append(" Kcals");
                sb.append("\n");
                double rdee2 = new CunninghamFormula(weightinlbs).getCalories();
                sb.append("Cunningham Formula (Resting Metabolic Rate)\n");
                sb.append(Math.round(rdee2));
                sb.append(" Kcals");
                sb.append("\n");

                JTextArea textArea = new JTextArea(5, 40);
                textArea.setText(sb.toString());
                textArea.setEditable(false);
                optionPane = new JOptionPane(textArea, JOptionPane.PLAIN_MESSAGE, JOptionPane.DEFAULT_OPTION);
                dialog = optionPane.createDialog("Energy");
                dialog.setIconImage(logo);
                dialog.setVisible(true);
            } else {
                Message.showMessage("Numbers only");
            }
        }
    }

    private void event_menubar_copy_mnui(ActionEvent e) {

    }

    private void event_menubar_rename_mnui(ActionEvent e) {

    }

    private void event_menubar_exportfoodjournal_mnui(ActionEvent e) {
        StringBuilder sb = new StringBuilder();
        String pattern = "yyyy-MMMMM-dd'_at_'HH-mm-ss";
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        Date date = new Date();
        String format = dateFormat.format(date);
        sb.append("food_journal_");
        sb.append(format);
        sb.append(".xls");
        try {
            StringBuilder filepath = new StringBuilder();
            filepath.append("files/");
            filepath.append(sb.toString());
            FileOutputStream out = new FileOutputStream(filepath.toString());
            Workbook wb = new HSSFWorkbook();
            Row row = null;
            Cell cell = null;

            String sheetname = "food journal";
            Sheet s = wb.createSheet();
            wb.setSheetName(0, sheetname);

            int rownum = 0;

            for (int i = 0; i < listModelMix.size(); i++) {
                MixDataObject mixDataObject = (MixDataObject) listModelMix.getElementAt(i);
                row = s.createRow(rownum++);
                Cell rowCell = row.createCell(0);
                rowCell.setCellValue(mixDataObject.getName());

                row = s.createRow(rownum++);
                for (int j = 0; j < tableModelJournal.getColumnCount(); j++) {
                    rowCell = row.createCell(j);
                    rowCell.setCellValue(tableModelJournal.getColumnName(j));
                }

                //
                try {
                    LinkedList list = (LinkedList) dbLink.MixResultDW_Select(mixDataObject.getMixId());
                    Iterator it = list.iterator();

                    while (it.hasNext()) {

                        HashMap rowm = (HashMap) it.next();

                        String Name = (String) rowm.get("NAME");
                        Double Protein = (Double) rowm.get("PROTEIN");
                        Double Fat = (Double) rowm.get("FAT");
                        Double CarbsByDifference = (Double) rowm.get("CARBSBYDIFFERENCE");
                        Double Kcal = (Double) rowm.get("KCAL");
                        Double Alcohol = (Double) rowm.get("ALCOHOL");
                        Double Fiber = (Double) rowm.get("FIBER");
                        Double Calcium = (Double) rowm.get("CALCIUM");
                        Double Magnesium = (Double) rowm.get("MAGNESIUM");
                        Double Potassium = (Double) rowm.get("POTASSIUM");
                        Double Sodium = (Double) rowm.get("SODIUM");
                        Double Cholesterol = (Double) rowm.get("CHOLESTEROL");
                        Double SatFat = (Double) rowm.get("SATFAT");
                        Double Monoufat = (Double) rowm.get("MONOUFAT");
                        Double Polyufat = (Double) rowm.get("POLYUFAT");
                        Double Quantity = (Double) rowm.get("QUANTITY");
                        Double Complete = (Double) rowm.get("COMPLETE");
                        Double Incomplete = (Double) rowm.get("INCOMPLETE");
                        Double CarbsDigestible = (Double) rowm.get("CARBSDIGESTIBLE");
                        Double Cost = (Double) rowm.get("COST");


                        row = s.createRow(rownum++);

                        rowCell = row.createCell(0);
                        rowCell.setCellValue(Name);
                        rowCell = row.createCell(1);
                        rowCell.setCellValue(Quantity);
                        rowCell = row.createCell(2);
                        rowCell.setCellValue(Kcal);
                        rowCell = row.createCell(3);
                        rowCell.setCellValue(Protein);
                        rowCell = row.createCell(4);
                        rowCell.setCellValue(Complete);
                        rowCell = row.createCell(5);
                        rowCell.setCellValue(Incomplete);
                        rowCell = row.createCell(6);
                        rowCell.setCellValue(Fat);
                        rowCell = row.createCell(7);
                        rowCell.setCellValue(CarbsDigestible);
                        rowCell = row.createCell(8);
                        rowCell.setCellValue(Fiber);
                        rowCell = row.createCell(9);
                        rowCell.setCellValue(SatFat);
                        rowCell = row.createCell(10);
                        rowCell.setCellValue(Monoufat);
                        rowCell = row.createCell(11);
                        rowCell.setCellValue(Polyufat);
                        rowCell = row.createCell(12);
                        rowCell.setCellValue(Cholesterol);
                        rowCell = row.createCell(13);
                        rowCell.setCellValue(Alcohol);
                        rowCell = row.createCell(14);
                        rowCell.setCellValue(Sodium);
                        rowCell = row.createCell(15);
                        rowCell.setCellValue(Potassium);
                        rowCell = row.createCell(16);
                        rowCell.setCellValue(Calcium);
                        rowCell = row.createCell(17);
                        rowCell.setCellValue(Magnesium);
                        rowCell = row.createCell(18);
                        rowCell.setCellValue(Cost);

                    }
                } catch (SQLException exception) {
                    exception.printStackTrace();
                }
                //
            }

            try {
                wb.write(out);
                out.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            JComponent[] inputs = new JComponent[]{
                    new JLabel("Spreadsheet is ready")
            };

            Message.showOptionDialog(inputs, "Journal");
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    private void event_menubar_exportfoodlist_mnui(ActionEvent e) {
        StringBuilder sb = new StringBuilder();
        String pattern = "yyyy-MMMMM-dd'_at_'HH-mm-ss";
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        Date date = new Date();
        String format = dateFormat.format(date);
        sb.append("food_list_");
        sb.append(format);
        sb.append(".xls");

        try {
            StringBuilder filepath = new StringBuilder();
            filepath.append("files/");
            filepath.append(sb.toString());
            FileOutputStream out = new FileOutputStream(filepath.toString());
            Workbook wb = new HSSFWorkbook();
            Row row = null;
            Cell cell = null;

            String sheetname = "food list";
            Sheet s = wb.createSheet();
            wb.setSheetName(0, sheetname);

            int rownum = 0;
            row = s.createRow(rownum++);
            //Create cells
            Cell cell0 = row.createCell(0);
            Cell cell1 = row.createCell(1);
            Cell cell2 = row.createCell(2);
            Cell cell3 = row.createCell(3);
            Cell cell4 = row.createCell(4);
            Cell cell5 = row.createCell(5);
            Cell cell6 = row.createCell(6);
            Cell cell7 = row.createCell(7);
            Cell cell8 = row.createCell(8);
            Cell cell9 = row.createCell(9);
            Cell cell10 = row.createCell(10);
            Cell cell11 = row.createCell(11);
            Cell cell12 = row.createCell(12);
            Cell cell13 = row.createCell(13);
            Cell cell14 = row.createCell(14);
            Cell cell15 = row.createCell(15);
            Cell cell16 = row.createCell(16);
            Cell cell17 = row.createCell(17);
            Cell cell18 = row.createCell(18);
            Cell cell19 = row.createCell(19);
            Cell cell20 = row.createCell(20);
            Cell cell21 = row.createCell(21);
            //Set cell value
            cell0.setCellValue("CATEGORY");
            cell1.setCellValue("FOOD");
            cell2.setCellValue("PROTEIN");
            cell3.setCellValue("FAT");
            cell4.setCellValue("CARBSDIGESTIBLE");
            cell5.setCellValue("CALORIES");
            cell6.setCellValue("ALCOHOL");
            cell7.setCellValue("FIBER");
            cell8.setCellValue("CALCIUM");
            cell9.setCellValue("MAGNESIUM");
            cell10.setCellValue("POTASSIUM");
            cell11.setCellValue("SODIUM");
            cell12.setCellValue("CHOLESTEROL");
            cell13.setCellValue("SATFAT");
            cell14.setCellValue("MONOUFAT");
            cell15.setCellValue("POLYUFAT");
            cell16.setCellValue("QUANTITY");
            cell17.setCellValue("COMPLETE");
            cell18.setCellValue("INCOMPLETE");
            cell19.setCellValue("COST");
            cell20.setCellValue("FOODCATEGORYID");
            cell21.setCellValue("FOODID");

            LinkedList list = (LinkedList) dbLink.Food_Select_Details();

            Iterator it = list.iterator();

            while (it.hasNext()) {

                HashMap rowm = (HashMap) it.next();

                String category = (String) rowm.get("CATEGORY");
                String food = (String) rowm.get("FOOD");
                Double protein = (Double) rowm.get("PROTEIN");
                Double fat = (Double) rowm.get("FAT");
                Double carbsdigestible = (Double) rowm.get("CARBSDIGESTIBLE");
                Double calories = (Double) rowm.get("CALORIES");
                Double alcohol = (Double) rowm.get("ALCOHOL");
                Double fiber = (Double) rowm.get("FIBER");
                Double calcium = (Double) rowm.get("CALCIUM");
                Double magnesium = (Double) rowm.get("MAGNESIUM");
                Double potassium = (Double) rowm.get("POTASSIUM");
                Double sodium = (Double) rowm.get("SODIUM");
                Double cholesterol = (Double) rowm.get("CHOLESTEROL");
                Double satfat = (Double) rowm.get("SATFAT");
                Double monoufat = (Double) rowm.get("MONOUFAT");
                Double polyufat = (Double) rowm.get("POLYUFAT");
                Double quantity = (Double) rowm.get("QUANTITY");
                Double complete = (Double) rowm.get("COMPLETE");
                Double incomplete = (Double) rowm.get("INCOMPLETE");
                Double cost = (Double) rowm.get("COST");
                String foodcategoryid = (String) rowm.get("FOODCATEGORYID");
                String foodid = (String) rowm.get("FOODID");

                //Create new row
                row = s.createRow(rownum++);
                //Create new cells
                cell0 = row.createCell(0);
                cell1 = row.createCell(1);
                cell2 = row.createCell(2);
                cell3 = row.createCell(3);
                cell4 = row.createCell(4);
                cell5 = row.createCell(5);
                cell6 = row.createCell(6);
                cell7 = row.createCell(7);
                cell8 = row.createCell(8);
                cell9 = row.createCell(9);
                cell10 = row.createCell(10);
                cell11 = row.createCell(11);
                cell12 = row.createCell(12);
                cell13 = row.createCell(13);
                cell14 = row.createCell(14);
                cell15 = row.createCell(15);
                cell16 = row.createCell(16);
                cell17 = row.createCell(17);
                cell18 = row.createCell(18);
                cell19 = row.createCell(19);
                cell20 = row.createCell(20);
                cell21 = row.createCell(21);
                //Set cell value
                cell0.setCellValue(category);
                cell1.setCellValue(food);
                cell2.setCellValue(protein);
                cell3.setCellValue(fat);
                cell4.setCellValue(carbsdigestible);
                cell5.setCellValue(calories);
                cell6.setCellValue(alcohol);
                cell7.setCellValue(fiber);
                cell8.setCellValue(calcium);
                cell9.setCellValue(magnesium);
                cell10.setCellValue(potassium);
                cell11.setCellValue(sodium);
                cell12.setCellValue(cholesterol);
                cell13.setCellValue(satfat);
                cell14.setCellValue(monoufat);
                cell15.setCellValue(polyufat);
                cell16.setCellValue(quantity);
                cell17.setCellValue(complete);
                cell18.setCellValue(incomplete);
                cell19.setCellValue(cost);
                cell20.setCellValue(foodcategoryid);
                cell21.setCellValue(foodid);
            }

            wb.write(out);
            out.close();

            JComponent[] inputs = new JComponent[]{
                    new JLabel("Spreadsheet is ready")
            };

            Message.showOptionDialog(inputs, "Food List");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void event_menubar_exportcompare_mnui(ActionEvent e) {
        StringBuilder sb = new StringBuilder();
        String pattern = "yyyy-MMMMM-dd'_at_'HH-mm-ss";
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        Date date = new Date();
        String format = dateFormat.format(date);
        sb.append("food_diff_");
        sb.append(format);
        sb.append(".xls");

        try {
            StringBuilder filepath = new StringBuilder();
            filepath.append("files/");
            filepath.append(sb.toString());
            FileOutputStream out = new FileOutputStream(filepath.toString());
            Workbook wb = new HSSFWorkbook();
            Row row = null;
            Cell cell = null;

            String sheetname = "food diff";
            Sheet s = wb.createSheet();
            wb.setSheetName(0, sheetname);

            int rownum = 0;

            if (!compare_a_lst.isSelectionEmpty() && !compare_b_lst.isSelectionEmpty()) {
                MixDataObject mix1 = (MixDataObject) compare_a_lst.getSelectedValue();
                MixDataObject mix2 = (MixDataObject) compare_b_lst.getSelectedValue();
                row = s.createRow(rownum++);
                cell = row.createCell(0);
                StringBuilder sb1 = new StringBuilder();
                sb1.append(mix1.getName());
                sb1.append(" minus ");
                sb1.append(mix2.getName());
                cell.setCellValue(sb1.toString());

                row = s.createRow(rownum++);
                for (int j = 0; j < tableModelMixDiff.getColumnCount(); j++) {
                    cell = row.createCell(j);
                    cell.setCellValue(tableModelMixDiff.getColumnName(j));
                }
            }

            //
            for (int j = 0; j < tableModelMixDiff.getRowCount(); j++) {
                row = s.createRow(rownum++);
                cell = row.createCell(0);
                cell.setCellValue((String) tableModelMixDiff.getValueAt(j, 0));
                cell = row.createCell(1);
                cell.setCellValue((Double) tableModelMixDiff.getValueAt(j, 1));
                cell = row.createCell(2);
                cell.setCellValue((Double) tableModelMixDiff.getValueAt(j, 2));
                cell = row.createCell(3);
                cell.setCellValue((Double) tableModelMixDiff.getValueAt(j, 3));

            }
            //

            try {
                wb.write(out);
                out.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            JComponent[] inputs = new JComponent[]{
                    new JLabel("Spreadsheet is ready")
            };

            Message.showOptionDialog(inputs, "Food Delta");
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    private void event_menubar_exportexchangelist_mnui(ActionEvent e) {
        StringBuilder sb = new StringBuilder();
        String pattern = "yyyy-MMMMM-dd'_at_'HH-mm-ss";
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        Date date = new Date();
        String format = dateFormat.format(date);
        sb.append("food_exchange_");
        sb.append(format);
        sb.append(".xls");

        try {
            StringBuilder filepath = new StringBuilder();
            filepath.append("files/");
            filepath.append(sb.toString());
            FileOutputStream out = new FileOutputStream(filepath.toString());
            Workbook wb = new HSSFWorkbook();
            Row row = null;
            Cell cell = null;

            String sheetname = "food exchange";
            Sheet s = wb.createSheet();
            wb.setSheetName(0, sheetname);

            int rownum = 0;

            NutrientDataObject nutrientDataObject = (NutrientDataObject) exchange_list_nutrient_cb.getSelectedItem();

            //
            if (exchange_list_table.getRowCount() > 0) {
                row = s.createRow(rownum++);
                cell = row.createCell(0);
                StringBuilder sb1 = new StringBuilder();
                sb1.append("The food items below contain");
                sb1.append(" ");
                sb1.append(exchange_list_quantity_txt.getText());
                sb1.append(" of ");
                sb1.append(nutrientDataObject.getNutrdesc());
                cell.setCellValue(sb1.toString());
                row = s.createRow(rownum++);
                for (int i = 0; i < exchange_list_table.getColumnCount(); i++) {
                    cell = row.createCell(i);
                    cell.setCellValue(exchange_list_table.getColumnName(i));
                }
                for (int j = 0; j < exchange_list_table.getRowCount(); j++) {
                    row = s.createRow(rownum++);
                    cell = row.createCell(0);
                    cell.setCellValue((String) exchange_list_table.getValueAt(j, 0));
                    cell = row.createCell(1);
                    cell.setCellValue((Double) exchange_list_table.getValueAt(j, 1));
                }
            }
            //

            try {
                wb.write(out);
                out.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            JComponent[] inputs = new JComponent[]{
                    new JLabel("Spreadsheet is ready")
            };

            Message.showOptionDialog(inputs, "Food Exchange");
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    private void event_menubar_guide_mnui(ActionEvent e) {
        openUrl("http://x-jrga.github.io/snack2");
    }


    private void event_menubar_credits_mnui(ActionEvent e) {
        StringBuffer sb = new StringBuffer();

        sb.append("Snack uses the following libraries:");
        sb.append("\n\n");
        sb.append("commons-math3-3.6.1.jar");
        sb.append("\n");
        sb.append("hsqldb.jar (v2.5.0)");
        sb.append("\n");
        sb.append("jgoodies-common-1.8.0.jar");
        sb.append("\n");
        sb.append("jgoodies-forms-1.8.0.jar");
        sb.append("\n");
        sb.append("poi-4.1.0.jar");
        sb.append("\n\n");

        JTextArea textArea = new JTextArea();
        textArea.setText(sb.toString());
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(700, 433));

        JComponent[] inputs = new JComponent[]{
                scrollPane
        };

        Message.showOptionDialog(inputs, "Snack: Learning Software for Nutrition - Credits");
    }

    private void event_menubar_about_mnui(ActionEvent e) {
        StringBuffer sb = new StringBuffer();

        String txt =
                "Snack is learning software for nutrition, a meal design tool and calculator that could facilitate achieving your health goals and objectives by first helping you understand your food intake and second by allowing you to create new food combinations that meet specific requirements.\n\n" +
                        "Snack is a training program designed to find lowest calorie food combination. It lets you experiment and get faster, better, less expensive results so you can rapidly learn. Its intended audience is anyone with interest in nutrition.\n\n" +
                        "With Snack I can:\n" +
                        "* quantify food intake\n" +
                        "* prepare customized meals that meet specific requirements\n" +
                        "* quantify any popular diet for comparison and research purposes\n" +
                        "* facilitate learning/teaching anyone with interest in nutrition\n" +
                        "* track any nutrient, compound or value that has an impact on health\n" +
                        "* create food exchange lists\n" +
                        "* compare food intake options\n" +
                        "* keep a food journal and track progress\n" +
                        "* calculate food quotient\n" +
                        "* is free and open source software";

        sb.append(txt);
        sb.append("\n\n");
        sb.append("This is version 0.522");
        sb.append("\n\n");
        sb.append("Please send your comments and suggestions to snack.nutrition.software@gmail.com");
        sb.append("\n\n");
        sb.append("Software can be downloaded at https://sourceforge.net/projects/snackmix");

        JTextArea textArea = new JTextArea();
        textArea.setText(sb.toString());
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(700, 433));

        JComponent[] inputs = new JComponent[]{
                scrollPane
        };

        Message.showOptionDialog(inputs, "Snack: Learning Software for Nutrition - About");
    }

    private JPanel getResults() {
        JPanel panel = new JPanel();

        //create layouts
        FormLayout layout = new FormLayout(
                "min:grow,40dlu", //columns
                "fill:min:grow" //rows
        );

        panel.setLayout(layout);

        JScrollPane scrollPane = new JScrollPane(tableResults);
        JScrollPane highScorePane = new JScrollPane(highScore);

        panel.add(scrollPane, cc.xy(1, 1));
        panel.add(highScorePane, cc.xy(2, 1));

        scrollPane.setBorder(new TitledBorder("Mix Nutritional Facts"));
        highScorePane.setBorder(new TitledBorder("Calories"));
        highScorePane.setMinimumSize(new Dimension(0, 200));

        tableResults.setModel(modelResultsTable);
        tableResults.setFillsViewportHeight(true);
        tableResults.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tableResults.setTableHeader(new TableResultsHeader(tableResults.getColumnModel()));
        tableResults.getTableHeader().setReorderingAllowed(false);

        DefaultListCellRenderer renderer = (DefaultListCellRenderer) highScore.getCellRenderer();
        renderer.setHorizontalAlignment(SwingConstants.RIGHT);
        highScore.setModel(highScoreModel);

        highScore.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent keyEvent) {

            }

            @Override
            public void keyPressed(KeyEvent keyEvent) {
                if (keyEvent.getKeyCode() == KeyEvent.VK_DELETE) {
                    event_high_score_keypressed(keyEvent);
                }
            }

            @Override
            public void keyReleased(KeyEvent keyEvent) {

            }
        });

        return panel;
    }

    private void event_high_score_keypressed(KeyEvent keyEvent) {
        highScoreModel.clear();
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

        JScrollPane scrSelectedFood = new JScrollPane(selectedFood);
        scrSelectedFood.setBorder(new TitledBorder("Food"));

        JScrollPane s_store = new JScrollPane(store);
        s_store.setBorder(new TitledBorder("Store"));

        //database
        treeModel.reload();
        store.setModel(treeModel);

        JButton mixfood_add_btn = new JButton("+");
        JButton mixfood_delete_btn = new JButton("-");
        JButton mixfood_expand_btn = new JButton("e");
        JButton mixfood_collapse_btn = new JButton("c");

        buttons.add(mixfood_add_btn, cc.xy(1, 2));
        buttons.add(mixfood_delete_btn, cc.xy(1, 3));
        buttons.add(mixfood_expand_btn, cc.xy(1, 4));
        buttons.add(mixfood_collapse_btn, cc.xy(1, 5));

        panel.add(s_store, cc.xy(1, 1));
        panel.add(buttons, cc.xy(2, 1));
        panel.add(scrSelectedFood, cc.xy(3, 1));

        mixfood_add_btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                event_mixfood_add_btn();
            }
        });

        mixfood_delete_btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                event_mixfood_delete_btn();
            }
        });

        mixfood_expand_btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                event_mixfood_expand_btn();
            }
        });

        mixfood_collapse_btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                event_mixfood_collapse_btn();
            }
        });

        selectedFood.setModel(listModelSelectedFood);

        return panel;
    }

    private JPanel getAmountOfNutrientConstraint() {
        JPanel panel = new JPanel();

        FormLayout panelLayout = new FormLayout(
                "min,min,200px", //columns
                "min,fill:min:grow,min" //rows
        );

        panel.setLayout(panelLayout);

        JScrollPane constraintList = new JScrollPane(nutrient_constraint_tbl);
        JPanel buttons = new JPanel();

        nutrient_constraint_quantity_txt.setMinimumSize(new Dimension(100, 25));

        panel.add(nutrient_constraint_nutrient_cb, cc.xy(1, 1));
        panel.add(nutrient_constraint_relationship_cb, cc.xy(2, 1));
        panel.add(nutrient_constraint_quantity_txt, cc.xy(3, 1));
        panel.add(constraintList, cc.xyw(1, 2, 3));
        buttons.add(nutrient_constraint_add_btn);
        buttons.add(nutrient_constraint_delete_btn);
        panel.add(buttons, cc.xyw(1, 3, 3));

        constraintList.setBorder(new TitledBorder("Nutrient Constraints"));

        nutrient_constraint_nutrient_cb.setMaximumRowCount(10);
        nutrient_constraint_nutrient_cb.setModel(cmb_1);
        nutrient_constraint_relationship_cb.setMaximumRowCount(3);
        nutrient_constraint_relationship_cb.setModel(cbmr_7);
        nutrient_constraint_tbl.getTableHeader().setReorderingAllowed(false);
        nutrient_constraint_tbl.setModel(tableModelNutrientConstraints);

        nutrient_constraint_add_btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                event_nutrient_constraint_add_btn();
            }
        });

        nutrient_constraint_delete_btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                event_nutrient_constraint_delete_btn();
            }
        });

        nutrient_constraint_tbl.setFillsViewportHeight(true);

        return panel;
    }


    private JPanel getAmountOfFoodNutrientConstraint() {
        JPanel panel = new JPanel();

        FormLayout panelLayout = new FormLayout(
                "min,min,min,550px", //columns
                "min,min,fill:min:grow,min" //rows
        );

        panel.setLayout(panelLayout);

        JScrollPane spTable = new JScrollPane(food_nutrient_constraint_tbl);
        JPanel buttons = new JPanel();

        food_nutrient_constraint_quantity_txt.setMinimumSize(new Dimension(100, 25));

        panel.add(food_nutrient_constraint_food_cb, cc.xyw(1, 1, 4));
        panel.add(food_nutrient_constraint_nutrient_cb, cc.xy(1, 2));
        panel.add(food_nutrient_constraint_relationship_cb, cc.xy(2, 2));
        panel.add(food_nutrient_constraint_quantity_txt, cc.xy(3, 2));
        panel.add(spTable, cc.xyw(1, 3, 4));
        buttons.add(food_nutrient_constraint_add_btn);
        buttons.add(food_nutrient_constraint_delete_btn);
        panel.add(buttons, cc.xyw(1, 4, 4));

        spTable.setBorder(new TitledBorder("Food Nutrient Constraints"));

        food_nutrient_constraint_nutrient_cb.setMaximumRowCount(10);
        food_nutrient_constraint_nutrient_cb.setModel(cbm_2);

        food_nutrient_constraint_relationship_cb.setMaximumRowCount(3);
        food_nutrient_constraint_relationship_cb.setModel(cbmr_8);

        food_nutrient_constraint_food_cb.setMaximumRowCount(10);
        food_nutrient_constraint_food_cb.setModel(cbmf_2);

        food_nutrient_constraint_tbl.getTableHeader().setReorderingAllowed(false);
        food_nutrient_constraint_tbl.setModel(tableModelFoodNutrientConstraints);

        food_nutrient_constraint_add_btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                event_food_nutrient_constraint_add_btn();
            }
        });

        food_nutrient_constraint_delete_btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                event_food_nutrient_constraint_delete_btn();
            }
        });

        food_nutrient_constraint_tbl.setFillsViewportHeight(true);

        return panel;
    }

    private JPanel getNutrientRatioConstraint() {
        JPanel panel = new JPanel();

        FormLayout panelLayout = new FormLayout(
                "480px,min", //columns
                "min,min,fill:min:grow,min" //rows
        );

        panel.setLayout(panelLayout);

        JScrollPane spTable = new JScrollPane(nutrient_ratio_tbl);
        JPanel buttons = new JPanel();

        nutrient_ratio_nutrient_a_txt.setMinimumSize(new Dimension(100, 25));
        nutrient_ratio_nutrient_b_txt.setMinimumSize(new Dimension(100, 25));

        panel.add(nutrient_ratio_nutrient_a_cb, cc.xy(1, 1));
        panel.add(nutrient_ratio_nutrient_a_txt, cc.xy(2, 1));
        panel.add(nutrient_ratio_nutrient_b_cb, cc.xy(1, 2));
        panel.add(nutrient_ratio_nutrient_b_txt, cc.xy(2, 2));
        panel.add(spTable, cc.xyw(1, 3, 2));
        buttons.add(nutrient_ratio_add_btn);
        buttons.add(nutrient_ratio_delete_btn);
        panel.add(buttons, cc.xyw(1, 4, 2));

        spTable.setBorder(new TitledBorder("Nutrient Ratio Constraints"));

        nutrient_ratio_nutrient_a_cb.setMaximumRowCount(10);
        nutrient_ratio_nutrient_a_cb.setModel(cbm_3);
        nutrient_ratio_nutrient_b_cb.setMaximumRowCount(10);
        nutrient_ratio_nutrient_b_cb.setModel(cbm_4);
        nutrient_ratio_tbl.getTableHeader().setReorderingAllowed(false);
        nutrient_ratio_tbl.setModel(tableModelNutrientRatioConstraints);

        nutrient_ratio_add_btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                event_nutrient_ratio_add_btn();
            }
        });

        nutrient_ratio_delete_btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                event_nutrient_ratio_delete_btn();
            }
        });

        nutrient_ratio_tbl.setFillsViewportHeight(true);

        return panel;
    }

    private JPanel getFoodNutrientRatioConstraint() {
        JPanel panel = new JPanel();
        FormLayout panelLayout = new FormLayout(
                "min,min,min:grow", //columns
                "min,min,min,min,fill:min:grow,min" //rows
        );

        panel.setLayout(panelLayout);

        JScrollPane spTable = new JScrollPane(food_nutrient_ratio_table);
        JPanel buttons = new JPanel();

        food_nutrient_ratio_quantity_a_txt.setMinimumSize(new Dimension(100, 25));
        food_nutrient_ratio_quantity_b_txt.setMinimumSize(new Dimension(100, 25));

        panel.add(food_nutrient_ratio_food_a_cb, cc.xyw(1, 1, 3));
        panel.add(food_nutrient_ratio_nutrient_a_cb, cc.xy(1, 2));
        panel.add(food_nutrient_ratio_quantity_a_txt, cc.xy(2, 2));
        panel.add(food_nutrient_ratio_food_b_cb, cc.xyw(1, 3, 3));
        panel.add(food_nutrient_ratio_nutrient_b_cb, cc.xy(1, 4));
        panel.add(food_nutrient_ratio_quantity_b_txt, cc.xy(2, 4));
        panel.add(spTable, cc.xyw(1, 5, 3));
        buttons.add(food_nutrient_ratio_add_btn);
        buttons.add(food_nutrient_ratio_delete_btn);
        panel.add(buttons, cc.xyw(1, 6, 3));

        spTable.setBorder(new TitledBorder("Food Nutrient Ratio Constraints"));

        food_nutrient_ratio_nutrient_a_cb.setMaximumRowCount(10);
        food_nutrient_ratio_nutrient_a_cb.setModel(cbm_5);
        food_nutrient_ratio_nutrient_b_cb.setMaximumRowCount(10);
        food_nutrient_ratio_nutrient_b_cb.setModel(cbm_6);
        food_nutrient_ratio_food_a_cb.setMaximumRowCount(10);
        food_nutrient_ratio_food_a_cb.setModel(cbmf_3);
        food_nutrient_ratio_food_b_cb.setMaximumRowCount(10);
        food_nutrient_ratio_food_b_cb.setModel(cbmf_4);

        food_nutrient_ratio_table.getTableHeader().setReorderingAllowed(false);
        food_nutrient_ratio_table.setModel(tableModelFoodNutrientRatioConstraints);

        food_nutrient_ratio_add_btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                event_food_nutrient_ratio_add_btn();
            }
        });

        food_nutrient_ratio_delete_btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                event_food_nutrient_ratio_delete_btn();
            }
        });

        food_nutrient_ratio_table.setFillsViewportHeight(true);

        return panel;
    }

    private JPanel getPercentOfNutrientConstraint() {
        JPanel panel = new JPanel();

        FormLayout panelLayout = new FormLayout(
                "min,min,min,550px", //columns
                "min,min,fill:min:grow,min" //rows
        );

        panel.setLayout(panelLayout);

        JScrollPane spTable = new JScrollPane(percent_nutrient_constraint_tbl);
        JPanel buttons = new JPanel();

        percent_nutrient_constraint_quantity_txt.setMinimumSize(new Dimension(100, 25));

        panel.add(percent_nutrient_constraint_food_cb, cc.xyw(1, 1, 4));
        panel.add(percent_nutrient_constraint_nutrient_cb, cc.xy(1, 2));
        panel.add(percent_nutrient_constraint_quantity_txt, cc.xy(2, 2));
        panel.add(new JLabel("%"), cc.xy(3, 2));
        panel.add(spTable, cc.xyw(1, 3, 4));
        buttons.add(percent_nutrient_constraint_add_btn);
        buttons.add(percent_nutrient_constraint_delete_btn);
        panel.add(buttons, cc.xyw(1, 4, 4));

        spTable.setBorder(new TitledBorder("Percent of Nutrient Constraints"));

        percent_nutrient_constraint_nutrient_cb.setMaximumRowCount(10);
        percent_nutrient_constraint_nutrient_cb.setModel(cbm_2);

        percent_nutrient_constraint_food_cb.setMaximumRowCount(10);
        percent_nutrient_constraint_food_cb.setModel(cbmf_2);

        percent_nutrient_constraint_tbl.getTableHeader().setReorderingAllowed(false);
        percent_nutrient_constraint_tbl.setModel(tableModelPercentNutrientConstraints);

        percent_nutrient_constraint_add_btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                event_percent_nutrient_constraint_add_btn();
            }
        });

        percent_nutrient_constraint_delete_btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                event_percent_nutrient_constraint_delete_btn();
            }
        });

        percent_nutrient_constraint_tbl.setFillsViewportHeight(true);

        return panel;
    }

    private void event_percent_nutrient_constraint_delete_btn() {
        if (isListMixSelected()) {
            try {
                int selectedRow = percent_nutrient_constraint_tbl.getSelectedRow();
                Integer mixid = (Integer) percent_nutrient_constraint_tbl.getValueAt(selectedRow, 0);
                String foodid = (String) percent_nutrient_constraint_tbl.getValueAt(selectedRow, 1);
                String nutrientid = (String) percent_nutrient_constraint_tbl.getValueAt(selectedRow, 2);
                dbLink.PercentNutrientConstraint_Delete(mixid, foodid, nutrientid);
                tableModelPercentNutrientConstraints.reload(mixid);
                resizeColumns_PercentNutrientConstraintTableColumns();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }

    private void event_percent_nutrient_constraint_add_btn() {
        if (isListMixSelected()) {
            if (isItReadyToAddPercentNutrientConstraint()) {
                try {
                    MixDataObject mix = (MixDataObject) mixes.getSelectedValue();
                    FoodDataObject foodDataObject = (FoodDataObject) percent_nutrient_constraint_food_cb.getSelectedItem();
                    NutrientDataObject nutrientDataObject = (NutrientDataObject) percent_nutrient_constraint_nutrient_cb.getSelectedItem();
                    Integer b = Integer.parseInt(percent_nutrient_constraint_quantity_txt.getText());
                    dbLink.PercentNutrientConstraint_Merge(mix.getMixId(), foodDataObject.getFoodid(), nutrientDataObject.getNutr_no(), b);
                    tableModelPercentNutrientConstraints.reload(mix.getMixId());
                    resizeColumns_PercentNutrientConstraintTableColumns();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    private void resizeColumns_PercentNutrientConstraintTableColumns() {
        percent_nutrient_constraint_tbl.getColumnModel().getColumn(0).setMinWidth(0);
        percent_nutrient_constraint_tbl.getColumnModel().getColumn(0).setMaxWidth(0);
        percent_nutrient_constraint_tbl.getColumnModel().getColumn(1).setMinWidth(0);
        percent_nutrient_constraint_tbl.getColumnModel().getColumn(1).setMaxWidth(0);
        percent_nutrient_constraint_tbl.getColumnModel().getColumn(2).setMinWidth(0);
        percent_nutrient_constraint_tbl.getColumnModel().getColumn(2).setMaxWidth(0);
        percent_nutrient_constraint_tbl.getColumnModel().getColumn(3).setMinWidth(480);
        percent_nutrient_constraint_tbl.getColumnModel().getColumn(3).setMaxWidth(480);
        percent_nutrient_constraint_tbl.getColumnModel().getColumn(4).setMinWidth(250);
        percent_nutrient_constraint_tbl.getColumnModel().getColumn(4).setMaxWidth(250);
        percent_nutrient_constraint_tbl.getColumnModel().getColumn(5).setMinWidth(50);
        percent_nutrient_constraint_tbl.getColumnModel().getColumn(5).setMaxWidth(50);
    }

    private boolean isItReadyToAddPercentNutrientConstraint() {
        Boolean flag_isReady = false;
        Boolean flag_listFood = false;
        Boolean flag_listNutrient = false;
        Boolean flag_quantity = false;

        if (percent_nutrient_constraint_food_cb.getSelectedIndex() != -1) {
            flag_listFood = true;
        } else {
            Message.showMessage("Select food.");
        }

        if (percent_nutrient_constraint_nutrient_cb.getSelectedIndex() != -1) {
            flag_listNutrient = true;
        } else {
            Message.showMessage("Select nutrient.");
        }

        if (!percent_nutrient_constraint_quantity_txt.getText().isEmpty()) {
            flag_quantity = true;
        } else {
            Message.showMessage("Specify amount.");
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
        JScrollPane scrollPane = new JScrollPane(model_txt);
        scrollPane.setPreferredSize(new Dimension(0, 0));
        panel.add(scrollPane, cc.xy(1, 1));

        scrollPane.setBorder(new TitledBorder("Model"));

        return panel;
    }

    private void event_mix_list(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()) {
            if (isListMixSelected()) {

                MixDataObject mixDataObject = (MixDataObject) mixes.getSelectedValue();
                Integer mixId = mixDataObject.getMixId();
                //
                listModelSelectedFood.reload(mixId);
                //
                cbmf_2.reload(mixId);
                cbmf_3.reload(mixId);
                cbmf_4.reload(mixId);
                //
                tableModelNutrientConstraints.reload(mixId);
                resizeColumns_NutrientConstraintTableColumns();
                tableModelFoodNutrientConstraints.reload(mixId);
                resizeColumns_FoodNutrientConstraintTableColumns();
                tableModelNutrientRatioConstraints.reload(mixId);
                resizeColumns_NutrientRatioConstraintTableColumns();
                tableModelFoodNutrientRatioConstraints.reload(mixId);
                resizeColumns_FoodNutrientRatioConstraintTableColumns();
                tableModelPercentNutrientConstraints.reload(mixId);
                resizeColumns_PercentNutrientConstraintTableColumns();
                //
                modelResultsTable.reload(mixId);
                resizeColumns_ResultsTable();
                //
                model_txt.setText(getLinearProgrammingModel());

                statusBar.removeAll();
                statusBar.add(new JLabel(stringModelMixPct.reload(mixId)));
                statusBar.revalidate();
                statusBar.repaint();
            }
        }
    }

    private String getLinearProgrammingModel() {
        String model = "";

        if (isListMixSelected()) {

            MixDataObject mixDataObject = (MixDataObject) mixes.getSelectedValue();
            Integer mixId = mixDataObject.getMixId();

            try {
                LinkedList all = (LinkedList) dbLink.MixModel_Select(mixId);
                Iterator it = all.iterator();
                HashMap row = (HashMap) it.next();
                model = (String) row.get("MODEL");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return model;
    }

    private void resizeColumns_NutrientConstraintTableColumns() {
        nutrient_constraint_tbl.getColumnModel().getColumn(0).setMinWidth(0);
        nutrient_constraint_tbl.getColumnModel().getColumn(0).setMaxWidth(0);
        nutrient_constraint_tbl.getColumnModel().getColumn(1).setMinWidth(0);
        nutrient_constraint_tbl.getColumnModel().getColumn(1).setMaxWidth(0);
        nutrient_constraint_tbl.getColumnModel().getColumn(2).setMinWidth(0);
        nutrient_constraint_tbl.getColumnModel().getColumn(2).setMaxWidth(0);
        nutrient_constraint_tbl.getColumnModel().getColumn(3).setMinWidth(250);
        nutrient_constraint_tbl.getColumnModel().getColumn(3).setMaxWidth(250);
        nutrient_constraint_tbl.getColumnModel().getColumn(4).setMinWidth(40);
        nutrient_constraint_tbl.getColumnModel().getColumn(4).setMaxWidth(40);
        nutrient_constraint_tbl.getColumnModel().getColumn(5).setMinWidth(60);
        nutrient_constraint_tbl.getColumnModel().getColumn(5).setMaxWidth(60);
    }

    private void event_compare_a_list(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()) {
            if (!compare_a_lst.isSelectionEmpty() && !compare_b_lst.isSelectionEmpty()) {
                MixDataObject mix1 = (MixDataObject) compare_a_lst.getSelectedValue();
                Integer mixId1 = mix1.getMixId();
                MixDataObject mix2 = (MixDataObject) compare_b_lst.getSelectedValue();
                Integer mixId2 = mix2.getMixId();
                tableModelMixDiff.reload(mixId1, mixId2);
                resizeColumns_DiffTable();
            }

        }

    }

    private void event_compare_b_list(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()) {
            if (!compare_a_lst.isSelectionEmpty() && !compare_b_lst.isSelectionEmpty()) {
                MixDataObject mix1 = (MixDataObject) compare_a_lst.getSelectedValue();
                Integer mixId1 = mix1.getMixId();
                MixDataObject mix2 = (MixDataObject) compare_b_lst.getSelectedValue();
                Integer mixId2 = mix2.getMixId();
                tableModelMixDiff.reload(mixId1, mixId2);
                resizeColumns_DiffTable();
            }
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

        buttons00.add(categories_add_btn, cc.xy(2, 1));
        buttons00.add(categories_delete_btn, cc.xy(3, 1));
        buttons00.add(categories_rename_btn, cc.xy(4, 1));

        JScrollPane list00 = new JScrollPane(categories_lst);

        //

        JPanel buttons01 = new JPanel();

        FormLayout panelButtons01Layout = new FormLayout(
                "min:grow,min,min,min:grow", //columns
                "fill:min:grow" //rows
        );


        buttons01.setLayout(panelButtons01Layout);

        JButton button_add_food_to_category = new JButton("+");
        JButton button_delete_food_from_category = new JButton("-");

        buttons01.add(button_add_food_to_category, cc.xy(2, 1));
        buttons01.add(button_delete_food_from_category, cc.xy(3, 1));

        JScrollPane sp01 = new JScrollPane(list01);

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

        FormLayout layout01 = new FormLayout(
                "min:grow", //columns
                "fill:min:grow,min" //rows
        );

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

        JScrollPane sp02 = new JScrollPane(list02);
        JLabel label = new JLabel("Search: ");
        panel02.add(label, cc.xy(1, 1));
        JTextField searchField = new JTextField();
        panel02.add(searchField, cc.xy(2, 1));
        panel02.add(sp02, cc.xyw(1, 2, 2));
        panel02.setBorder(new TitledBorder("All Food Items"));

        //

        panel.add(panel00, cc.xy(1, 1));
        panel.add(panel01, cc.xy(2, 1));
        panel.add(panel02, cc.xy(3, 1));

        //

        categories_lst.setModel(listModelCategory);

        listModelCategory.reload();

        list01.setModel(listModelFood2);

        list02.setModel(listModelFood);

        listModelFood.reload();


        //

        categories_add_btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                event_categories_add_btn();
            }
        });

        categories_rename_btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                event_categories_rename_btn();
            }
        });

        categories_delete_btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                event_categories_delete_btn();
            }
        });

        categories_lst.addListSelectionListener(new ListSelectionListener() {

            public void valueChanged(ListSelectionEvent e) {
                event_categories_lst(e);

            }
        });

        button_add_food_to_category.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                event_add_food_to_category_btn();
            }
        });

        button_delete_food_from_category.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                event_delete_food_from_category_btn();
            }
        });

        searchField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                event_food_list_search(e);
            }
        });

        return panel;
    }

    private void event_food_list_search(ActionEvent e) {
        listModelFood.reload(((JTextField) e.getSource()).getText());
    }

    private void event_delete_food_from_category_btn() {
        if (!categories_lst.isSelectionEmpty()) {
            try {
                FoodCategoryDataObject foodCategoryDataObject = (FoodCategoryDataObject) categories_lst.getSelectedValue();
                int[] selectedRows = list01.getSelectedIndices();
                for (int i = 0; i < selectedRows.length; i++) {
                    FoodDataObject foodDataObject = (FoodDataObject) listModelFood2.get(selectedRows[i]);
                    dbLink.CategoryLink_Delete(foodCategoryDataObject.getFoodCategoryId(), foodDataObject.getFoodid());
                }
                tableModelFoodList.reload();
                treeModel.reload();
                listModelFood2.reload(foodCategoryDataObject.getFoodCategoryId());
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

    }

    private void event_add_food_to_category_btn() {
        if (!categories_lst.isSelectionEmpty()) {
            if (!list02.isSelectionEmpty()) {
                try {
                    FoodCategoryDataObject foodCategoryDataObject = (FoodCategoryDataObject) categories_lst.getSelectedValue();
                    int[] selectedRows = list02.getSelectedIndices();
                    for (int i = 0; i < selectedRows.length; i++) {
                        FoodDataObject foodDataObject = (FoodDataObject) listModelFood.get(selectedRows[i]);
                        Integer count = dbLink.CategoryLink_Count(foodCategoryDataObject.getFoodCategoryId(), foodDataObject.getFoodid());

                        if (count == 0) {
                            dbLink.CategoryLink_Insert(foodCategoryDataObject.getFoodCategoryId(), foodDataObject.getFoodid());
                            tableModelFoodList.reload();
                            treeModel.reload();
                            listModelFood2.reload(foodCategoryDataObject.getFoodCategoryId());
                        }
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void event_categories_lst(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()) {
            if (!categories_lst.isSelectionEmpty()) {
                FoodCategoryDataObject foodCategoryDataObject = (FoodCategoryDataObject) categories_lst.getSelectedValue();
                String foodCategoryId = foodCategoryDataObject.getFoodCategoryId();
                listModelFood2.reload(foodCategoryId);

            }
        }
    }

    private void event_food_list_search_txt(ActionEvent e) {
        //if (isListCategorySelected()) {}

    }

    private void event_exchange_list_run_btn() {
        NutrientDataObject nutrientDataObject = (NutrientDataObject) exchange_list_nutrient_cb.getSelectedItem();

        try {
            Double q = Double.parseDouble(exchange_list_quantity_txt.getText());
            tableModelExchangeList.reload(nutrientDataObject.getNutr_no(), q);
            resizeColumns_ExchangeTable();
        } catch (NumberFormatException e) {
            Message.showMessage(e.toString());
        }
    }

    private void event_mixfood_add_btn() {
        if (isListMixSelected()) {

            MixDataObject mix = (MixDataObject) mixes.getSelectedValue();

            DefaultMutableTreeNode node = (DefaultMutableTreeNode) store.getLastSelectedPathComponent();

            if (node == null) {
                //Nothing is selected.
                return;
            }

            FoodDataObject food = (FoodDataObject) node.getUserObject();

            if (node.isLeaf()) {

                try {
                    Integer mixId = mix.getMixId();
                    dbLink.MixFood_Insert(mixId, food.getFoodid());
                    listModelSelectedFood.reload(mixId);
                    cbmf_2.reload(mixId);
                    cbmf_3.reload(mixId);
                    cbmf_4.reload(mixId);
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
        } else {
            Message.showMessage("Select mix.");
        }
    }

    private void event_mixfood_delete_btn() {
        if (isListMixSelected()) {

            try {
                MixDataObject mix = (MixDataObject) mixes.getSelectedValue();
                FoodDataObject foodDataObject = (FoodDataObject) selectedFood.getSelectedValue();
                Integer mixId = mix.getMixId();
                dbLink.MixFood_Delete(mixId, foodDataObject.getFoodid());
                listModelSelectedFood.reload(mixId);
                //
                cbmf_2.reload(mixId);
                cbmf_3.reload(mixId);
                cbmf_4.reload(mixId);
                //
                tableModelNutrientConstraints.reload(mixId);
                resizeColumns_NutrientConstraintTableColumns();
                tableModelFoodNutrientConstraints.reload(mixId);
                resizeColumns_FoodNutrientConstraintTableColumns();
                tableModelNutrientRatioConstraints.reload(mixId);
                resizeColumns_NutrientRatioConstraintTableColumns();
                tableModelFoodNutrientRatioConstraints.reload(mixId);
                resizeColumns_FoodNutrientRatioConstraintTableColumns();
                tableModelPercentNutrientConstraints.reload(mixId);
                resizeColumns_PercentNutrientConstraintTableColumns();
                //
                modelResultsTable.reload(-1);
                resizeColumns_ResultsTable();

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

    }

    private void event_mixfood_expand_btn() {
        int rowCount = store.getRowCount();
        this.expandAllNodes(store, 0, rowCount);
    }

    private void expandAllNodes(JTree tree, int startingIndex, int rowCount) {
        for (int i = startingIndex; i < rowCount; ++i) {
            tree.expandRow(i);
        }
        if (tree.getRowCount() != rowCount) {
            expandAllNodes(tree, rowCount, tree.getRowCount());
        }
    }

    private void event_mixfood_collapse_btn() {
        int rowCount = store.getRowCount();
        for (int i = 1; i < rowCount; i++) {
            store.collapseRow(i);
        }
    }

    private void event_mixfood_solve_btn() {

        if (isListMixSelected()) {

            try {
                MixDataObject mix = (MixDataObject) mixes.getSelectedValue();

                LpModel lpModel = new LpModel();
                model_txt.setText("");

                Integer mixId = mix.getMixId();
                String mixName = mix.getName();

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

                    //int mixid = (int) o.get("MIX_ID");
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
                    //Integer mixid = (Integer) row.get("MIXID");
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
                    //Integer mixid = (Integer) row.get("MIXID");
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

                    //int mixid = (int) o.get("MIX_ID");
                    String foodid = (String) row.get("FOODID");
                    String nutrientid = (String) row.get("NUTRIENTID");
                    Integer relationshipid = 3;
                    Double b = (double) row.get("B");

                    lpModel.addConstraint(dbLink.percentnutrient_lhs(mixId, foodid, nutrientid, b), relationshipid, 0);
                }

                String model = lpModel.printModel();
                StringBuilder sb = new StringBuilder();
                sb.append(model);

                model_txt.setText(sb.toString());

                if (lpModel.solve()) {
                    double cost = lpModel.getCost();
                    double[] point = lpModel.getPoint();

                    DecimalFormat formatter = new DecimalFormat("#,###");
                    highScoreModel.addElement(formatter.format(cost));
                    highScore.ensureIndexIsVisible(highScoreModel.getSize() - 1);

                    sb.append("\n");
                    sb.append("/*");
                    sb.append("\n\n");
                    sb.append("Kcal: " + cost + "\n");

                    for (int i = 0; i < point.length; i++) {
                        double food_quantity_in_grams = point[i];
                        double food_quantity_in_ounces = food_quantity_in_grams / 28.3495;
                        sb.append(i);
                        sb.append(" = ");
                        sb.append(food_quantity_in_grams);
                        sb.append(" g ");
                        sb.append(" = ");
                        sb.append(food_quantity_in_ounces);
                        sb.append(" oz \n");
                    }

                    StringBuilder filename = new StringBuilder();
                    String pattern = "yyyy-MMMMM-dd'_at_'HH-mm-ss";
                    SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
                    Date date = new Date();
                    String format = dateFormat.format(date);
                    filename.append("mix_");
                    filename.append(format);
                    filename.append(".lp");

                    sb.append("\n");
                    sb.append("Run model on lp_solve to double check! File is located in files/ directory");
                    sb.append("\n\n");
                    sb.append("lp_solve -S3 " + filename.toString());
                    sb.append("\n\n");
                    sb.append("*/");

                    model_txt.setText(sb.toString());

                    Writer.writeToFile(filename.toString(), sb.toString());

                    LinkedList mixfoodlist = (LinkedList) dbLink.MixFood_Select(mixId);

                    for (int i = 0; i < mixfoodlist.size(); i++) {

                        HashMap row = (HashMap) mixfoodlist.get(i);
                        //int mixid = (int) row.get("MIX_ID");
                        String foodid = (String) row.get("FOODID");
                        double v = point[i];

                        dbLink.MixFood_Update(mixId, foodid, v);

                    }

                    //dbLink.MixResultDw_Merge_Total(mixId);
                    dbLink.MixModel_Merge(mixId, "208", sb.toString());

                    //
                    modelResultsTable.reload(mixId);
                    resizeColumns_ResultsTable();

                    statusBar.removeAll();
                    statusBar.add(new JLabel(stringModelMixPct.reload(mixId)));
                    statusBar.revalidate();
                    statusBar.repaint();

                    dbLink.Mix_Update_Time(mixId);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private void event_nutrient_constraint_add_btn() {
        if (isListMixSelected()) {

            if (isItReadyToAddNutrientConstraint()) {
                try {
                    MixDataObject mix = (MixDataObject) mixes.getSelectedValue();
                    NutrientDataObject nutrientDataObject = (NutrientDataObject) nutrient_constraint_nutrient_cb.getSelectedItem();
                    RelationshipDataObject relationshipDataObject = (RelationshipDataObject) nutrient_constraint_relationship_cb.getSelectedItem();
                    double b = Double.parseDouble(nutrient_constraint_quantity_txt.getText());
                    dbLink.NutrientConstraint_Merge(mix.getMixId(), nutrientDataObject.getNutr_no(), relationshipDataObject.getRelationshipid(), b);
                    tableModelNutrientConstraints.reload(mix.getMixId());
                    resizeColumns_NutrientConstraintTableColumns();
                } catch (SQLException e) {
                    e.printStackTrace();
                }


            }
        }
    }

    private Boolean isItReadyToAddNutrientConstraint() {

        Boolean flag_isReady = false;
        Boolean flag_listNutrient = false;
        Boolean flag_listNutrientRelationship = false;
        Boolean flag_textFieldNutrientConstraint = false;

        if (nutrient_constraint_nutrient_cb.getSelectedIndex() != -1) {
            flag_listNutrient = true;
        } else {
            Message.showMessage("Select nutrient.");
        }

        if (nutrient_constraint_relationship_cb.getSelectedIndex() != -1) {
            flag_listNutrientRelationship = true;
        } else {
            Message.showMessage("Select relationship.");
        }

        if (!nutrient_constraint_quantity_txt.getText().isEmpty()) {
            flag_textFieldNutrientConstraint = true;
        } else {
            Message.showMessage("Specify amount.");
        }

        if (flag_listNutrient && flag_listNutrientRelationship && flag_textFieldNutrientConstraint) {
            flag_isReady = true;
        }

        return flag_isReady;
    }

    private void event_nutrient_constraint_delete_btn() {
        if (isListMixSelected()) {

            try {
                int selectedRow = nutrient_constraint_tbl.getSelectedRow();
                Integer mixid = (Integer) nutrient_constraint_tbl.getValueAt(selectedRow, 0);
                String nutrientid = (String) nutrient_constraint_tbl.getValueAt(selectedRow, 1);
                Integer relationshipid = (Integer) nutrient_constraint_tbl.getValueAt(selectedRow, 2);
                dbLink.NutrientConstraint_Delete(mixid, nutrientid, relationshipid);
                tableModelNutrientConstraints.reload(mixid);
                resizeColumns_NutrientConstraintTableColumns();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

    }


    private void event_food_nutrient_constraint_add_btn() {

        if (isListMixSelected()) {

            if (isItReadyToAddFoodNutrientConstraint()) {
                try {
                    MixDataObject mix = (MixDataObject) mixes.getSelectedValue();
                    FoodDataObject foodDataObject = (FoodDataObject) food_nutrient_constraint_food_cb.getSelectedItem();
                    NutrientDataObject nutrientDataObject = (NutrientDataObject) food_nutrient_constraint_nutrient_cb.getSelectedItem();
                    RelationshipDataObject relationshipDataObject = (RelationshipDataObject) food_nutrient_constraint_relationship_cb.getSelectedItem();
                    double b = Double.parseDouble(food_nutrient_constraint_quantity_txt.getText());
                    dbLink.FoodNutrientConstraint_Merge(mix.getMixId(), foodDataObject.getFoodid(), nutrientDataObject.getNutr_no(), relationshipDataObject.getRelationshipid(), b);
                    tableModelFoodNutrientConstraints.reload(mix.getMixId());
                    resizeColumns_FoodNutrientConstraintTableColumns();
                } catch (SQLException e) {
                    e.printStackTrace();
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

        if (food_nutrient_constraint_food_cb.getSelectedIndex() != -1) {
            flag_listFood = true;
        } else {
            Message.showMessage("Select food.");
        }

        if (food_nutrient_constraint_nutrient_cb.getSelectedIndex() != -1) {
            flag_listNutrient = true;
        } else {
            Message.showMessage("Select nutrient.");
        }

        if (food_nutrient_constraint_relationship_cb.getSelectedIndex() != -1) {
            flag_listRelationship = true;
        } else {
            Message.showMessage("Select relationship.");
        }

        if (!food_nutrient_constraint_quantity_txt.getText().isEmpty()) {
            flag_quantity = true;
        } else {
            Message.showMessage("Specify amount.");
        }

        if (flag_listFood && flag_listNutrient && flag_listRelationship && flag_quantity) {
            flag_isReady = true;
        }

        return flag_isReady;
    }

    private void resizeColumns_FoodNutrientConstraintTableColumns() {

        food_nutrient_constraint_tbl.getColumnModel().getColumn(0).setMinWidth(0);
        food_nutrient_constraint_tbl.getColumnModel().getColumn(0).setMaxWidth(0);
        food_nutrient_constraint_tbl.getColumnModel().getColumn(1).setMinWidth(0);
        food_nutrient_constraint_tbl.getColumnModel().getColumn(1).setMaxWidth(0);
        food_nutrient_constraint_tbl.getColumnModel().getColumn(2).setMinWidth(0);
        food_nutrient_constraint_tbl.getColumnModel().getColumn(2).setMaxWidth(0);
        food_nutrient_constraint_tbl.getColumnModel().getColumn(3).setMinWidth(0);
        food_nutrient_constraint_tbl.getColumnModel().getColumn(3).setMaxWidth(0);
        food_nutrient_constraint_tbl.getColumnModel().getColumn(4).setMinWidth(480);
        food_nutrient_constraint_tbl.getColumnModel().getColumn(4).setMaxWidth(480);
        food_nutrient_constraint_tbl.getColumnModel().getColumn(5).setMinWidth(250);
        food_nutrient_constraint_tbl.getColumnModel().getColumn(5).setMaxWidth(250);
        food_nutrient_constraint_tbl.getColumnModel().getColumn(6).setMinWidth(30);
        food_nutrient_constraint_tbl.getColumnModel().getColumn(6).setMaxWidth(30);
        food_nutrient_constraint_tbl.getColumnModel().getColumn(7).setMinWidth(50);
        food_nutrient_constraint_tbl.getColumnModel().getColumn(7).setMaxWidth(50);


    }


    private void event_food_nutrient_constraint_delete_btn() {

        if (isListMixSelected()) {

            try {
                int selectedRow = food_nutrient_constraint_tbl.getSelectedRow();
                Integer mixid = (Integer) food_nutrient_constraint_tbl.getValueAt(selectedRow, 0);
                String foodid = (String) food_nutrient_constraint_tbl.getValueAt(selectedRow, 1);
                String nutrientid = (String) food_nutrient_constraint_tbl.getValueAt(selectedRow, 2);
                Integer relationshipid = (Integer) food_nutrient_constraint_tbl.getValueAt(selectedRow, 3);
                dbLink.FoodNutrientConstraint_Delete(mixid, foodid, nutrientid, relationshipid);
                tableModelFoodNutrientConstraints.reload(mixid);
                resizeColumns_FoodNutrientConstraintTableColumns();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }

    private void event_nutrient_ratio_add_btn() {
        if (isListMixSelected()) {
            if (isItReadyToAddNutrientRatioConstraint()) {
                try {
                    MixDataObject mix = (MixDataObject) mixes.getSelectedValue();
                    NutrientDataObject nutrientDataObjectA = (NutrientDataObject) nutrient_ratio_nutrient_a_cb.getSelectedItem();
                    NutrientDataObject nutrientDataObjectB = (NutrientDataObject) nutrient_ratio_nutrient_b_cb.getSelectedItem();
                    Integer a = Integer.parseInt(nutrient_ratio_nutrient_a_txt.getText());
                    Integer b = Integer.parseInt(nutrient_ratio_nutrient_b_txt.getText());
                    dbLink.NutrientRatio_Merge(mix.getMixId(), nutrientDataObjectA.getNutr_no(), nutrientDataObjectB.getNutr_no(), 3, a, b);
                    tableModelNutrientRatioConstraints.reload(mix.getMixId());
                    resizeColumns_NutrientRatioConstraintTableColumns();
                } catch (SQLException e) {
                    e.printStackTrace();
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

        if (nutrient_ratio_nutrient_a_cb.getSelectedIndex() != -1) {
            flag_listNutrientA = true;
        } else {
            Message.showMessage("Select nutrient A");
        }

        if (nutrient_ratio_nutrient_a_cb.getSelectedIndex() != -1) {
            flag_listNutrientB = true;
        } else {
            Message.showMessage("Select nutrient B");
        }

        if (!nutrient_ratio_nutrient_a_txt.getText().isEmpty()) {
            flag_quantityA = true;
        } else {
            Message.showMessage("Specify amount A");
        }

        if (!nutrient_ratio_nutrient_b_txt.getText().isEmpty()) {
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
        nutrient_ratio_tbl.getColumnModel().getColumn(0).setMinWidth(0);
        nutrient_ratio_tbl.getColumnModel().getColumn(0).setMaxWidth(0);
        nutrient_ratio_tbl.getColumnModel().getColumn(1).setMinWidth(0);
        nutrient_ratio_tbl.getColumnModel().getColumn(1).setMaxWidth(0);
        nutrient_ratio_tbl.getColumnModel().getColumn(2).setMinWidth(0);
        nutrient_ratio_tbl.getColumnModel().getColumn(2).setMaxWidth(0);
        nutrient_ratio_tbl.getColumnModel().getColumn(3).setMinWidth(0);
        nutrient_ratio_tbl.getColumnModel().getColumn(3).setMaxWidth(0);
        nutrient_ratio_tbl.getColumnModel().getColumn(4).setMinWidth(240);
        nutrient_ratio_tbl.getColumnModel().getColumn(4).setMaxWidth(240);
        nutrient_ratio_tbl.getColumnModel().getColumn(5).setMinWidth(240);
        nutrient_ratio_tbl.getColumnModel().getColumn(5).setMaxWidth(240);
    }

    private void resizeColumns_ResultsTable() {
        tableResults.getColumnModel().getColumn(0).setMinWidth(500);
        tableResults.getColumnModel().getColumn(0).setMaxWidth(500);
        tableResults.getColumnModel().getColumn(1).setMinWidth(75);
        tableResults.getColumnModel().getColumn(1).setMaxWidth(75);
        tableResults.getColumnModel().getColumn(2).setMinWidth(75);
        tableResults.getColumnModel().getColumn(2).setMaxWidth(75);
        tableResults.getColumnModel().getColumn(3).setMinWidth(75);
        tableResults.getColumnModel().getColumn(3).setMaxWidth(75);
        tableResults.getColumnModel().getColumn(4).setMinWidth(75);
        tableResults.getColumnModel().getColumn(4).setMaxWidth(75);
        tableResults.getColumnModel().getColumn(5).setMinWidth(75);
        tableResults.getColumnModel().getColumn(5).setMaxWidth(75);
        tableResults.getColumnModel().getColumn(6).setMinWidth(75);
        tableResults.getColumnModel().getColumn(6).setMaxWidth(75);
        tableResults.getColumnModel().getColumn(7).setMinWidth(75);
        tableResults.getColumnModel().getColumn(7).setMaxWidth(75);
        tableResults.getColumnModel().getColumn(8).setMinWidth(75);
        tableResults.getColumnModel().getColumn(8).setMaxWidth(75);
        tableResults.getColumnModel().getColumn(9).setMinWidth(75);
        tableResults.getColumnModel().getColumn(9).setMaxWidth(75);
        tableResults.getColumnModel().getColumn(10).setMinWidth(75);
        tableResults.getColumnModel().getColumn(10).setMaxWidth(75);
        tableResults.getColumnModel().getColumn(11).setMinWidth(75);
        tableResults.getColumnModel().getColumn(11).setMaxWidth(75);
        tableResults.getColumnModel().getColumn(12).setMinWidth(75);
        tableResults.getColumnModel().getColumn(12).setMaxWidth(75);
        tableResults.getColumnModel().getColumn(13).setMinWidth(75);
        tableResults.getColumnModel().getColumn(13).setMaxWidth(75);
        tableResults.getColumnModel().getColumn(14).setMinWidth(75);
        tableResults.getColumnModel().getColumn(14).setMaxWidth(75);
        tableResults.getColumnModel().getColumn(15).setMinWidth(75);
        tableResults.getColumnModel().getColumn(15).setMaxWidth(75);
        tableResults.getColumnModel().getColumn(16).setMinWidth(75);
        tableResults.getColumnModel().getColumn(16).setMaxWidth(75);
        tableResults.getColumnModel().getColumn(17).setMinWidth(75);
        tableResults.getColumnModel().getColumn(17).setMaxWidth(75);
    }

    private void resizeColumns_JournalTable() {
        tableJournal.getColumnModel().getColumn(0).setMinWidth(500);
        tableJournal.getColumnModel().getColumn(0).setMaxWidth(500);
        tableJournal.getColumnModel().getColumn(1).setMinWidth(75);
        tableJournal.getColumnModel().getColumn(1).setMaxWidth(75);
        tableJournal.getColumnModel().getColumn(2).setMinWidth(75);
        tableJournal.getColumnModel().getColumn(2).setMaxWidth(75);
        tableJournal.getColumnModel().getColumn(3).setMinWidth(75);
        tableJournal.getColumnModel().getColumn(3).setMaxWidth(75);
        tableJournal.getColumnModel().getColumn(4).setMinWidth(75);
        tableJournal.getColumnModel().getColumn(4).setMaxWidth(75);
        tableJournal.getColumnModel().getColumn(5).setMinWidth(75);
        tableJournal.getColumnModel().getColumn(5).setMaxWidth(75);
        tableJournal.getColumnModel().getColumn(6).setMinWidth(75);
        tableJournal.getColumnModel().getColumn(6).setMaxWidth(75);
        tableJournal.getColumnModel().getColumn(7).setMinWidth(75);
        tableJournal.getColumnModel().getColumn(7).setMaxWidth(75);
        tableJournal.getColumnModel().getColumn(8).setMinWidth(75);
        tableJournal.getColumnModel().getColumn(8).setMaxWidth(75);
        tableJournal.getColumnModel().getColumn(9).setMinWidth(75);
        tableJournal.getColumnModel().getColumn(9).setMaxWidth(75);
        tableJournal.getColumnModel().getColumn(10).setMinWidth(75);
        tableJournal.getColumnModel().getColumn(10).setMaxWidth(75);
        tableJournal.getColumnModel().getColumn(11).setMinWidth(75);
        tableJournal.getColumnModel().getColumn(11).setMaxWidth(75);
        tableJournal.getColumnModel().getColumn(12).setMinWidth(75);
        tableJournal.getColumnModel().getColumn(12).setMaxWidth(75);
        tableJournal.getColumnModel().getColumn(13).setMinWidth(75);
        tableJournal.getColumnModel().getColumn(13).setMaxWidth(75);
        tableJournal.getColumnModel().getColumn(14).setMinWidth(75);
        tableJournal.getColumnModel().getColumn(14).setMaxWidth(75);
        tableJournal.getColumnModel().getColumn(15).setMinWidth(75);
        tableJournal.getColumnModel().getColumn(15).setMaxWidth(75);
        tableJournal.getColumnModel().getColumn(16).setMinWidth(75);
        tableJournal.getColumnModel().getColumn(16).setMaxWidth(75);
        tableJournal.getColumnModel().getColumn(17).setMinWidth(75);
        tableJournal.getColumnModel().getColumn(17).setMaxWidth(75);
    }

    private void resizeColumns_DiffTable() {
        compare_tbl.getColumnModel().getColumn(0).setMinWidth(500);
        compare_tbl.getColumnModel().getColumn(0).setMaxWidth(500);
        compare_tbl.getColumnModel().getColumn(1).setMinWidth(75);
        compare_tbl.getColumnModel().getColumn(1).setMaxWidth(75);
        compare_tbl.getColumnModel().getColumn(2).setMinWidth(75);
        compare_tbl.getColumnModel().getColumn(2).setMaxWidth(75);
        compare_tbl.getColumnModel().getColumn(3).setMinWidth(75);
        compare_tbl.getColumnModel().getColumn(3).setMaxWidth(75);
    }

    private void resizeColumns_ExchangeTable() {
        exchange_list_table.getColumnModel().getColumn(0).setMinWidth(500);
        exchange_list_table.getColumnModel().getColumn(0).setMaxWidth(500);
        exchange_list_table.getColumnModel().getColumn(1).setMinWidth(75);
        exchange_list_table.getColumnModel().getColumn(1).setMaxWidth(75);
    }

    private void event_nutrient_ratio_delete_btn() {
        if (isListMixSelected()) {

            try {
                int selectedRow = nutrient_ratio_tbl.getSelectedRow();
                Integer mixid = (Integer) nutrient_ratio_tbl.getValueAt(selectedRow, 0);
                String nutrientidA = (String) nutrient_ratio_tbl.getValueAt(selectedRow, 1);
                String nutrientidB = (String) nutrient_ratio_tbl.getValueAt(selectedRow, 2);
                Integer relationshipid = (Integer) nutrient_ratio_tbl.getValueAt(selectedRow, 3);
                dbLink.NutrientRatio_Delete(mixid, nutrientidA, nutrientidB, relationshipid);
                tableModelNutrientRatioConstraints.reload(mixid);
                resizeColumns_NutrientRatioConstraintTableColumns();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }


    private void event_food_nutrient_ratio_add_btn() {

        if (isListMixSelected()) {

            if (isItReadyToAddFoodNutrientRatioConstraint()) {
                try {
                    MixDataObject mix = (MixDataObject) mixes.getSelectedValue();
                    FoodDataObject foodDataObjectA = (FoodDataObject) food_nutrient_ratio_food_a_cb.getSelectedItem();
                    NutrientDataObject nutrientDataObjectA = (NutrientDataObject) food_nutrient_ratio_nutrient_a_cb.getSelectedItem();
                    FoodDataObject foodDataObjectB = (FoodDataObject) food_nutrient_ratio_food_b_cb.getSelectedItem();
                    NutrientDataObject nutrientDataObjectB = (NutrientDataObject) food_nutrient_ratio_nutrient_b_cb.getSelectedItem();
                    Integer a = Integer.parseInt(food_nutrient_ratio_quantity_a_txt.getText());
                    Integer b = Integer.parseInt(food_nutrient_ratio_quantity_b_txt.getText());
                    dbLink.FoodNutrientRatio_Merge(mix.getMixId(), foodDataObjectA.getFoodid(), nutrientDataObjectA.getNutr_no(), foodDataObjectB.getFoodid(), nutrientDataObjectB.getNutr_no(), 3, a, b);
                    tableModelFoodNutrientRatioConstraints.reload(mix.getMixId());
                    resizeColumns_FoodNutrientRatioConstraintTableColumns();
                } catch (SQLException e) {
                    e.printStackTrace();
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

        if (food_nutrient_ratio_food_a_cb.getSelectedIndex() != -1) {
            flag_listFoodA = true;
        } else {
            Message.showMessage("Select food A.");
        }

        if (food_nutrient_ratio_nutrient_a_cb.getSelectedIndex() != -1) {
            flag_listNutrientA = true;
        } else {
            Message.showMessage("Select nutrient A.");
        }

        if (!food_nutrient_ratio_quantity_a_txt.getText().isEmpty()) {
            flag_quantityA = true;
        } else {
            Message.showMessage("Specify amount A.");
        }

        if (food_nutrient_ratio_food_b_cb.getSelectedIndex() != -1) {
            flag_listFoodB = true;
        } else {
            Message.showMessage("Select food B.");
        }

        if (food_nutrient_ratio_nutrient_b_cb.getSelectedIndex() != -1) {
            flag_listNutrientB = true;
        } else {
            Message.showMessage("Select nutrient B.");
        }

        if (!food_nutrient_ratio_quantity_b_txt.getText().isEmpty()) {
            flag_quantityB = true;
        } else {
            Message.showMessage("Specify amount B.");
        }

        if (flag_listFoodA && flag_listNutrientA && flag_quantityA && flag_listFoodB && flag_listNutrientB && flag_quantityB) {
            flag_isReady = true;
        }

        return flag_isReady;
    }

    private void resizeColumns_FoodNutrientRatioConstraintTableColumns() {
        food_nutrient_ratio_table.getColumnModel().getColumn(0).setMinWidth(0);
        food_nutrient_ratio_table.getColumnModel().getColumn(0).setMaxWidth(0);
        food_nutrient_ratio_table.getColumnModel().getColumn(1).setMinWidth(0);
        food_nutrient_ratio_table.getColumnModel().getColumn(1).setMaxWidth(0);
        food_nutrient_ratio_table.getColumnModel().getColumn(2).setMinWidth(0);
        food_nutrient_ratio_table.getColumnModel().getColumn(2).setMaxWidth(0);
        food_nutrient_ratio_table.getColumnModel().getColumn(3).setMinWidth(0);
        food_nutrient_ratio_table.getColumnModel().getColumn(3).setMaxWidth(0);
        food_nutrient_ratio_table.getColumnModel().getColumn(4).setMinWidth(0);
        food_nutrient_ratio_table.getColumnModel().getColumn(4).setMaxWidth(0);
        food_nutrient_ratio_table.getColumnModel().getColumn(5).setMinWidth(0);
        food_nutrient_ratio_table.getColumnModel().getColumn(5).setMaxWidth(0);
        //food_nutrient_ratio_table.getColumnModel().getColumn(6).setMinWidth(225);
        //food_nutrient_ratio_table.getColumnModel().getColumn(6).setMaxWidth(225);
        food_nutrient_ratio_table.getColumnModel().getColumn(7).setMinWidth(170);
        food_nutrient_ratio_table.getColumnModel().getColumn(7).setMaxWidth(170);
        //food_nutrient_ratio_table.getColumnModel().getColumn(8).setMinWidth(225);
        //food_nutrient_ratio_table.getColumnModel().getColumn(8).setMaxWidth(225);
        food_nutrient_ratio_table.getColumnModel().getColumn(9).setMinWidth(170);
        food_nutrient_ratio_table.getColumnModel().getColumn(9).setMaxWidth(170);
        food_nutrient_ratio_table.getColumnModel().getColumn(10).setMinWidth(60);
        food_nutrient_ratio_table.getColumnModel().getColumn(10).setMaxWidth(60);
        food_nutrient_ratio_table.getColumnModel().getColumn(11).setMinWidth(60);
        food_nutrient_ratio_table.getColumnModel().getColumn(11).setMaxWidth(60);
    }


    private void event_food_nutrient_ratio_delete_btn() {
        if (isListMixSelected()) {

            try {
                int selectedRow = food_nutrient_ratio_table.getSelectedRow();
                Integer mixid = (Integer) food_nutrient_ratio_table.getValueAt(selectedRow, 0);
                String foodidA = (String) food_nutrient_ratio_table.getValueAt(selectedRow, 1);
                String nutrientidA = (String) food_nutrient_ratio_table.getValueAt(selectedRow, 2);
                String foodidB = (String) food_nutrient_ratio_table.getValueAt(selectedRow, 3);
                String nutrientidB = (String) food_nutrient_ratio_table.getValueAt(selectedRow, 4);
                Integer relationshipid = (Integer) food_nutrient_ratio_table.getValueAt(selectedRow, 5);
                dbLink.FoodNutrientRatio_Delete(mixid, foodidA, nutrientidA, foodidB, nutrientidB, relationshipid);
                tableModelFoodNutrientRatioConstraints.reload(mixid);
                resizeColumns_FoodNutrientRatioConstraintTableColumns();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    private boolean isListMixSelected() {
        return !mixes.isSelectionEmpty();
    }

    private JPanel getNutritionalFacts() {
        JPanel panel = new JPanel();
        JPanel panelTextArea = new JPanel();

        facts_quantity_txt.setHorizontalAlignment(SwingConstants.RIGHT);
        facts_calories_txt.setHorizontalAlignment(SwingConstants.RIGHT);
        facts_protein_txt.setHorizontalAlignment(SwingConstants.RIGHT);
        facts_fat_txt.setHorizontalAlignment(SwingConstants.RIGHT);
        facts_carbohydrate_txt.setHorizontalAlignment(SwingConstants.RIGHT);
        facts_fiber_txt.setHorizontalAlignment(SwingConstants.RIGHT);
        facts_satfat_txt.setHorizontalAlignment(SwingConstants.RIGHT);
        facts_monoufat_txt.setHorizontalAlignment(SwingConstants.RIGHT);
        facts_polyufat_txt.setHorizontalAlignment(SwingConstants.RIGHT);
        facts_cholesterol_txt.setHorizontalAlignment(SwingConstants.RIGHT);
        facts_alcohol_txt.setHorizontalAlignment(SwingConstants.RIGHT);
        facts_sodium_txt.setHorizontalAlignment(SwingConstants.RIGHT);
        facts_potassium_txt.setHorizontalAlignment(SwingConstants.RIGHT);
        facts_calcium_txt.setHorizontalAlignment(SwingConstants.RIGHT);
        facts_magnesium_txt.setHorizontalAlignment(SwingConstants.RIGHT);
        facts_cost_txt.setHorizontalAlignment(SwingConstants.RIGHT);

        facts_nom_txt.setName("Name");
        facts_quantity_txt.setName("Serving Size");
        facts_calories_txt.setName("Calories");
        facts_protein_txt.setName("Protein");
        facts_fat_txt.setName("Fat");
        facts_carbohydrate_txt.setName("Carbohydrates");
        facts_fiber_txt.setName("Fiber");
        facts_satfat_txt.setName("Saturated Fat");
        facts_monoufat_txt.setName("Monounsaturated Fat");
        facts_polyufat_txt.setName("Polyunsaturated Fat");
        facts_cholesterol_txt.setName("Cholesterol");
        facts_alcohol_txt.setName("Alcohol");
        facts_sodium_txt.setName("Sodium");
        facts_potassium_txt.setName("Potassium");
        facts_calcium_txt.setName("Calcium");
        facts_magnesium_txt.setName("Magnesium");
        facts_cost_txt.setName("Cost");

        facts_carbohydrate_txt.setToolTipText("Digestible carbohydrates only");
        facts_iscomplete_cb.setToolTipText("Is the protein in this food complete?");

        //create layouts
        FormLayout panelLayout = new FormLayout(
                "min,min:grow,min", //columns
                "min,min,min,min,min,min,min,min,min,min,min,min,min,min,min,min,min,min,min" //rows
        );
        FormLayout panelButtonsLayout = new FormLayout(
                "min:grow,min,min,min,min:grow", //columns
                "fill:min:grow" //rows
        );
        FormLayout panelTextAreaLayout = new FormLayout(
                "min:grow,", //columns
                "fill:min:grow" //rows
        );

        //specify layouts
        panel.setLayout(panelLayout);
        panelTextArea.setLayout(panelTextAreaLayout);

        DefaultComboBoxModel comboBoxModelIsComplete = new DefaultComboBoxModel();
        facts_iscomplete_cb.setModel(comboBoxModelIsComplete);
        comboBoxModelIsComplete.addElement("True");
        comboBoxModelIsComplete.addElement("False");

        //
        panel.add(new JLabel("Name:"), cc.xy(1, 1));
        panel.add(facts_nom_txt, cc.xy(2, 1));

        panel.add(new JLabel("Serving Size:"), cc.xy(1, 2));
        panel.add(facts_quantity_txt, cc.xy(2, 2));
        panel.add(new JLabel("g"), cc.xy(3, 2));
        //
        panel.add(new JLabel("Calories:"), cc.xy(1, 3));
        panel.add(facts_calories_txt, cc.xy(2, 3));
        panel.add(new JLabel("Kcal"), cc.xy(3, 3));
        //
        panel.add(new JLabel("Protein:"), cc.xy(1, 4));
        panel.add(facts_protein_txt, cc.xy(2, 4));
        panel.add(new JLabel("g"), cc.xy(3, 4));
        //
        panel.add(new JLabel("Is Complete?:"), cc.xy(1, 5));
        panel.add(facts_iscomplete_cb, cc.xy(2, 5));
        //
        panel.add(new JLabel("Fat:"), cc.xy(1, 6));
        panel.add(facts_fat_txt, cc.xy(2, 6));
        panel.add(new JLabel("g"), cc.xy(3, 6));
        //
        panel.add(new JLabel("Carbohydrate:"), cc.xy(1, 7));
        panel.add(facts_carbohydrate_txt, cc.xy(2, 7));
        panel.add(new JLabel("g"), cc.xy(3, 7));
        //
        panel.add(new JLabel("Fiber:"), cc.xy(1, 8));
        panel.add(facts_fiber_txt, cc.xy(2, 8));
        panel.add(new JLabel("g"), cc.xy(3, 8));
        //
        panel.add(new JLabel("Saturated Fat:"), cc.xy(1, 9));
        panel.add(facts_satfat_txt, cc.xy(2, 9));
        panel.add(new JLabel("g"), cc.xy(3, 9));
        //
        panel.add(new JLabel("Monounsaturated Fat:"), cc.xy(1, 10));
        panel.add(facts_monoufat_txt, cc.xy(2, 10));
        panel.add(new JLabel("g"), cc.xy(3, 10));
        //
        panel.add(new JLabel("Polyunsaturated Fat:"), cc.xy(1, 11));
        panel.add(facts_polyufat_txt, cc.xy(2, 11));
        panel.add(new JLabel("g"), cc.xy(3, 11));
        //
        panel.add(new JLabel("Cholesterol:"), cc.xy(1, 12));
        panel.add(facts_cholesterol_txt, cc.xy(2, 12));
        panel.add(new JLabel("mg"), cc.xy(3, 12));
        //
        panel.add(new JLabel("Sodium:"), cc.xy(1, 13));
        panel.add(facts_sodium_txt, cc.xy(2, 13));
        panel.add(new JLabel("mg"), cc.xy(3, 13));
        //
        panel.add(new JLabel("Potassium:"), cc.xy(1, 14));
        panel.add(facts_potassium_txt, cc.xy(2, 14));
        panel.add(new JLabel("mg"), cc.xy(3, 14));
        //Calcium
        panel.add(new JLabel("Calcium:"), cc.xy(1, 15));
        panel.add(facts_calcium_txt, cc.xy(2, 15));
        panel.add(new JLabel("mg"), cc.xy(3, 15));
        //Magnesium
        panel.add(new JLabel("Magnesium:"), cc.xy(1, 16));
        panel.add(facts_magnesium_txt, cc.xy(2, 16));
        panel.add(new JLabel("mg"), cc.xy(3, 16));
        //
        panel.add(new JLabel("Alcohol:"), cc.xy(1, 17));
        panel.add(facts_alcohol_txt, cc.xy(2, 17));
        panel.add(new JLabel("g"), cc.xy(3, 17));
        //
        panel.add(new JLabel("Cost:"), cc.xy(1, 18));
        panel.add(facts_cost_txt, cc.xy(2, 18));
        panel.add(new JLabel("$"), cc.xy(3, 18));
        //
        panel.setBorder(new TitledBorder("Nutrition Facts Label"));
        panel.setPreferredSize(new Dimension(450, 530));


        return panel;
    }

    private void event_categories_add_btn() {
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
                    listModelCategory.reload();
                    tableModelFoodList.reload();
                    treeModel.reload();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    private void event_categories_rename_btn() {
        if (!categories_lst.isSelectionEmpty()) {
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
                        FoodCategoryDataObject foodCategoryDataObject = (FoodCategoryDataObject) categories_lst.getSelectedValue();
                        String foodCategoryId = foodCategoryDataObject.getFoodCategoryId();
                        dbLink.FoodCategory_Update(foodCategoryId, category_name);
                        listModelCategory.reload();
                        tableModelFoodList.reload();
                        treeModel.reload();
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }
    }

    private void event_categories_delete_btn() {
        if (!categories_lst.isSelectionEmpty()) {
            try {
                FoodCategoryDataObject foodCategoryDataObject = (FoodCategoryDataObject) categories_lst.getSelectedValue();
                String foodCategoryId = foodCategoryDataObject.getFoodCategoryId();
                dbLink.FoodCategory_Delete(foodCategoryId);
                listModelCategory.reload();
                tableModelFoodList.reload();
                treeModel.reload();
                listModelFood2.reload("-1");
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        }
    }

    private void openUrl(String url) {
        try {
            Desktop.getDesktop().browse(new URL(url).toURI());
        } catch (Exception ex) {
        }
    }


}
