package org.xjrga.snack2.gui;

import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;
import org.xjrga.snack2.data.DbLink;
import org.xjrga.snack2.model.ComboBoxModelNutrients;
import org.xjrga.snack2.model.ComboBoxModelRelationships;
import org.xjrga.snack2.model.TreeModelFood;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class Main
{
    private JTextField categories_category_txt = new JTextField();
    private JButton categories_delete_btn = new JButton("Delete");
    private JList categories_lst = new JList();
    private JButton categories_rename_btn = new JButton("Rename");
    private JButton categories_save_btn = new JButton("Save");
    private CellConstraints cc = new CellConstraints();
    private DefaultListModel compare_a_lstmodel = new DefaultListModel();
    private JList compare_a_lst = new JList();
    private DefaultListModel compare_b_lstmodel = new DefaultListModel();
    private JList compare_b_lst = new JList();
    private DefaultTableModel compare_tblmodel = new DefaultTableModel();
    private JTable compare_tbl = new JTable();
    private JTextField exchange_list_quantity_txt = new JTextField();
    private JButton exchange_list_run_btn = new JButton("Run");
    private JTable exchange_list_table = new JTable();
    private JTextField facts_calories_txt = new JTextField();
    private JTextField facts_carbohydrate_txt = new JTextField();
    private JComboBox facts_category_cb = new JComboBox();
    private JTextField facts_cholesterol_txt = new JTextField();
    private JButton facts_clear_btn = new JButton("Clear");
    private JTextField facts_cost_txt = new JTextField();
    private JTextField facts_fat_txt = new JTextField();
    private JTextField facts_fiber_txt = new JTextField();
    private JComboBox facts_iscomplete_cb = new JComboBox();
    private JTextField facts_monoufat_txt = new JTextField();
    private JTextField facts_nom_txt = new JTextField();
    private JTextArea facts_note_txt = new JTextArea();
    private JTextField facts_polyufat_txt = new JTextField();
    private JTextField facts_protein_txt = new JTextField();
    private JTextField facts_satfat_txt = new JTextField();
    private JButton facts_save_btn = new JButton("Save");
    private JTextField facts_servingsize_txt = new JTextField();
    private JTextField facts_sodium_txt = new JTextField();
    private JButton facts_update_btn = new JButton("Update");
    private JComboBox food_nutrient_constraint_relationship_cb = new JComboBox();
    private JButton food_nutrient_constraint_add_btn = new JButton("+");
    private JButton food_nutrient_constraint_delete_btn = new JButton("-");
    private JComboBox<Object> food_nutrient_constraint_food_cb = new JComboBox<>();
    private JComboBox<Object> food_nutrient_constraint_nutrient_cb = new JComboBox<>();
    private JTextField food_nutrient_constraint_quantity_txt = new JTextField();
    private JTable food_nutrient_constraint_tbl = new JTable();
    private JButton food_journal_delete_btn = new JButton("Delete");
    private JTable food_journal_table_1 = new JTable();
    private JTable food_journal_table_2 = new JTable();
    private JButton food_list_delete_btn = new JButton("Delete");
    private JTextField food_list_search_txt = new JTextField();
    private DefaultTableModel foodlist_tblmodel = new DefaultTableModel();
    private JTable food_list_tbl = new JTable();
    private JButton food_nutrient_ratio_add_btn = new JButton("+");
    private JButton food_nutrient_ratio_delete_btn = new JButton("-");
    private JComboBox<Object> food_nutrient_ratio_food_a_cb = new JComboBox<>();
    private JComboBox<Object> food_nutrient_ratio_food_b_cb = new JComboBox<>();
    private JComboBox<Object> food_nutrient_ratio_nutrient_a_cb = new JComboBox<>();
    private JComboBox<Object> food_nutrient_ratio_nutrient_b_cb = new JComboBox<>();
    private JTextField food_nutrient_ratio_quantity_a_txt = new JTextField();
    private JTextField food_nutrient_ratio_quantity_b_txt = new JTextField();
    private JTable food_nutrient_ratio_table = new JTable();
    private JFrame frame = new JFrame();
    private JMenuItem menubar_about_mnui = new JMenuItem();
    private JMenuItem menubar_addtofoodjournal_mnui = new JMenuItem();
    private JMenuItem menubar_addtofoodlist_mnui = new JMenuItem();
    private JMenu menubar_addto_mnu = new JMenu();
    private JMenuItem menubar_bmr_mnui = new JMenuItem();
    private JMenuItem menubar_copy_mnui = new JMenuItem();
    private JMenuItem menubar_credits_mnui = new JMenuItem();
    private JMenu menubar_data_mnu = new JMenu();
    private JMenuItem menubar_delete_mnui = new JMenuItem();
    private JMenuItem menubar_exit_mnui = new JMenuItem();
    private JMenuItem menubar_exportcompare_mnui = new JMenuItem();
    private JMenuItem menubar_exportexchangelist_mnui = new JMenuItem();
    private JMenuItem menubar_exportfoodjournal_mnui = new JMenuItem();
    private JMenuItem menubar_exportfoodlist_mnui = new JMenuItem();
    private JMenu menubar_export_mnu = new JMenu();
    private JMenuItem menubar_guide_mnui = new JMenuItem();
    private JMenu menubar_help_mnu = new JMenu();
    private JMenu menubar_mix_mnu = new JMenu();
    private JMenuItem menubar_new_mnui = new JMenuItem();
    private JMenu menubar_program_mnu = new JMenu();
    private JMenuItem menubar_rename_mnui = new JMenuItem();
    private JMenuItem menubar_sourceforge_mnui = new JMenuItem();
    private JMenu menubar_tools_mnu = new JMenu();
    private JMenuItem menubar_twitter_mnui = new JMenuItem();
    private JMenuItem menubar_usda_mnui = new JMenuItem();
    private JTextArea model_txt = new JTextArea();
    private JTextArea note_txt = new JTextArea();
    private JButton nutrient_constraint_add_btn = new JButton("+");
    private JButton nutrient_constraint_delete_btn = new JButton("-");
    private JComboBox<Object> nutrient_constraint_nutrient_cb = new JComboBox<>();
    private JTextField nutrient_constraint_quantity_txt = new JTextField();
    private JComboBox<Object> nutrient_constraint_relationship_cb = new JComboBox<>();
    private JTable nutrient_constraint_tbl = new JTable();
    private JButton nutrient_ratio_add_btn = new JButton("+");
    private JButton nutrient_ratio_delete_btn = new JButton("-");
    private JComboBox<Object> nutrient_ratio_nutrient_a_cb = new JComboBox<>();
    private JTextField nutrient_ratio_nutrient_a_txt = new JTextField();
    private JComboBox<Object> nutrient_ratio_nutrient_b_cb = new JComboBox<>();
    private JTextField nutrient_ratio_nutrient_b_txt = new JTextField();
    private JTable nutrient_ratio_tbl = new JTable();
    private JComboBox exchange_list_food_cb = new JComboBox();
    private DefaultTableModel main_table_model = new DefaultTableModel();
    private DefaultTableModel vitamins_table_model = new DefaultTableModel();
    private DefaultTableModel minerals_table_model = new DefaultTableModel();
    private DefaultTableModel flavonoids_table_model = new DefaultTableModel();
    private DefaultTableModel aminoacids_table_model = new DefaultTableModel();
    private DefaultTableModel other_table_model = new DefaultTableModel();
    private JComboBox food_constraint_relationship_cb = new JComboBox();
    private JButton food_constraint_add_btn = new JButton("+");
    private JButton food_constraint_delete_btn = new JButton("-");
    private JComboBox<Object> food_constraint_food_cb = new JComboBox<>();
    private JTextField food_constraint_quantity_txt = new JTextField();
    private JTable food_constraint_tbl = new JTable();
    private JButton food_ratio_add_btn = new JButton("+");
    private JButton food_ratio_delete_btn = new JButton("-");
    private JComboBox<Object> food_ratio_food_a_cb = new JComboBox<>();
    private JComboBox<Object> food_ratio_food_b_cb = new JComboBox<>();
    private JComboBox<Object> food_ratio_nutrient_a_cb = new JComboBox<>();
    private JComboBox<Object> food_ratio_nutrient_b_cb = new JComboBox<>();
    private JTextField food_ratio_quantity_a_txt = new JTextField();
    private JTextField food_ratio_quantity_b_txt = new JTextField();
    private JTable food_ratio_table = new JTable();
    private DbLink dbLink = new DbLink();
    private ComboBoxModelNutrients cmb_1 = new ComboBoxModelNutrients(dbLink);
    private ComboBoxModelNutrients cbm_2 = new ComboBoxModelNutrients(dbLink);
    private ComboBoxModelNutrients cbm_3 = new ComboBoxModelNutrients(dbLink);
    private ComboBoxModelNutrients cbm_4 = new ComboBoxModelNutrients(dbLink);
    private ComboBoxModelNutrients cbm_5 = new ComboBoxModelNutrients(dbLink);
    private ComboBoxModelNutrients cbm_6 = new ComboBoxModelNutrients(dbLink);
    private ComboBoxModelRelationships cbm_7 = new ComboBoxModelRelationships(dbLink);
    private ComboBoxModelRelationships cbm_8 = new ComboBoxModelRelationships(dbLink);
    private ComboBoxModelRelationships cbm_9 = new ComboBoxModelRelationships(dbLink);

    public Main()
    {

        FormLayout layout = new FormLayout("min:grow", //columns
                "fill:min:grow,1dlu,min" //rows
        );

        frame.setLayout(layout);
        frame.setJMenuBar(getMenuBar());
        JStatusBar statusBar = new JStatusBar();
        JLabel leftLabel = new JLabel("Your application is about to self destruct.");
        statusBar.addMessageLabel(leftLabel);
        JLabel dateLabel = new JLabel("12/31/99");
        statusBar.addLabel(dateLabel);
        JLabel timeLabel = new JLabel("11:59 PM");
        statusBar.addLabel(timeLabel);
        JTabbedPane mainTabbedPane = new JTabbedPane();
        mainTabbedPane.setTabPlacement(JTabbedPane.BOTTOM);
        mainTabbedPane.add(getSolve());
        mainTabbedPane.add(getCompare());
        mainTabbedPane.add(getFoodJournal());
        mainTabbedPane.add(getFoodList());
        mainTabbedPane.add(getExchangeList());
        mainTabbedPane.setTitleAt(0, "Solve");
        mainTabbedPane.setTitleAt(1, "Compare");
        mainTabbedPane.setTitleAt(2, "Food Journal");
        mainTabbedPane.setTitleAt(3, "Food List");
        mainTabbedPane.setTitleAt(4, "Exchange List");
        frame.add(mainTabbedPane, cc.xy(1, 1));
        frame.add(statusBar, cc.xy(1, 3));
        frame.setDefaultCloseOperation(3);
        Dimension size = new Dimension(1400, 780);
        frame.setSize(size);
        frame.setVisible(true);
        frame.setTitle("Snack");

        frame.addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent e)
            {
                event_menubar_exit_mnui();
            }
        });

        frame.addComponentListener(new ComponentAdapter()
        {
            public void componentResized(ComponentEvent e)
            {
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
        cbm_7.reload();
        cbm_8.reload();
        cbm_9.reload();

    }

    private JMenuBar getMenuBar()
    {
        JMenuBar mnuBar = new JMenuBar();
        mnuBar.add(menubar_program_mnu);
        mnuBar.add(menubar_tools_mnu);
        mnuBar.add(menubar_mix_mnu);
        mnuBar.add(menubar_data_mnu);
        mnuBar.add(menubar_help_mnu);
        menubar_program_mnu.add(menubar_exit_mnui);
        menubar_tools_mnu.add(menubar_bmr_mnui);
        menubar_mix_mnu.add(menubar_new_mnui);
        menubar_mix_mnu.add(menubar_copy_mnui);
        menubar_mix_mnu.add(menubar_rename_mnui);
        menubar_mix_mnu.add(menubar_delete_mnui);
        menubar_mix_mnu.add(menubar_addto_mnu);
        menubar_addto_mnu.add(menubar_addtofoodjournal_mnui);
        menubar_addto_mnu.add(menubar_addtofoodlist_mnui);
        menubar_data_mnu.add(menubar_export_mnu);
        menubar_export_mnu.add(menubar_exportfoodjournal_mnui);
        menubar_export_mnu.add(menubar_exportfoodlist_mnui);
        menubar_export_mnu.add(menubar_exportcompare_mnui);
        menubar_export_mnu.add(menubar_exportexchangelist_mnui);
        menubar_help_mnu.add(menubar_guide_mnui);
        menubar_help_mnu.add(menubar_twitter_mnui);
        menubar_help_mnu.add(menubar_sourceforge_mnui);
        menubar_help_mnu.add(menubar_usda_mnui);
        menubar_help_mnu.add(menubar_credits_mnui);
        menubar_help_mnu.add(menubar_about_mnui);
        //setText
        menubar_program_mnu.setText("Program");
        menubar_tools_mnu.setText("Tools");
        menubar_mix_mnu.setText("Mix");
        menubar_data_mnu.setText("Data");
        menubar_help_mnu.setText("Help");
        menubar_exit_mnui.setText("Exit");
        menubar_bmr_mnui.setText("Calculate Basal Metabolic Rate");
        menubar_new_mnui.setText("New");
        menubar_copy_mnui.setText("Copy");
        menubar_rename_mnui.setText("Rename");
        menubar_delete_mnui.setText("Delete");
        menubar_addto_mnu.setText("Add To");
        menubar_addtofoodjournal_mnui.setText("Food Journal");
        menubar_addtofoodlist_mnui.setText("Food List");
        menubar_export_mnu.setText("Export");
        menubar_exportfoodjournal_mnui.setText("Food Journal");
        menubar_exportfoodlist_mnui.setText("Food List");
        menubar_exportcompare_mnui.setText("Mix Comparison");
        menubar_exportexchangelist_mnui.setText("Food Exchange List");
        menubar_guide_mnui.setText("Guide");
        menubar_usda_mnui.setText("USDA Food Composition Databases");
        menubar_twitter_mnui.setText("Snack at Twitter");
        menubar_sourceforge_mnui.setText("Snack at Sourceforge");
        menubar_credits_mnui.setText("Credits");
        menubar_about_mnui.setText("About");

        menubar_bmr_mnui.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                event_menubar_bmr_mnui(e);
            }
        });

        menubar_new_mnui.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                event_menubar_new_mnui(e);
            }
        });

        menubar_copy_mnui.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                event_menubar_copy_mnui(e);
            }
        });

        menubar_rename_mnui.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                event_menubar_rename_mnui(e);
            }
        });

        menubar_delete_mnui.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                event_menubar_delete_mnui(e);
            }
        });


        menubar_addtofoodjournal_mnui.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                event_menubar_addtofoodjournal_mnui(e);
            }
        });

        menubar_addtofoodlist_mnui.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                event_menubar_addtofoodlist_mnui(e);
            }
        });


        menubar_exportfoodjournal_mnui.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                event_menubar_exportfoodjournal_mnui(e);
            }
        });

        menubar_exportfoodlist_mnui.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                event_menubar_exportfoodlist_mnui(e);
            }
        });

        menubar_exportcompare_mnui.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                event_menubar_exportcompare_mnui(e);
            }
        });

        menubar_exportexchangelist_mnui.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                event_menubar_exportexchangelist_mnui(e);
            }
        });

        menubar_guide_mnui.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                event_menubar_guide_mnui(e);
            }
        });

        menubar_usda_mnui.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                event_menubar_usda_mnui(e);
            }
        });

        menubar_twitter_mnui.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                event_menubar_twitter_mnui(e);
            }
        });

        menubar_sourceforge_mnui.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                event_menubar_sourceforge_mnui(e);
            }
        });

        menubar_credits_mnui.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                event_menubar_credits_mnui(e);
            }
        });

        menubar_about_mnui.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                event_menubar_about_mnui(e);
            }
        });

        menubar_exit_mnui.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                event_menubar_exit_mnui();
            }
        });

        return mnuBar;
    }

    private void event_menubar_about_mnui(ActionEvent e)
    {

    }

    private void event_menubar_credits_mnui(ActionEvent e)
    {

    }

    private void event_menubar_sourceforge_mnui(ActionEvent e)
    {

    }

    private void event_menubar_twitter_mnui(ActionEvent e)
    {

    }

    private void event_menubar_usda_mnui(ActionEvent e)
    {

    }

    private void event_menubar_guide_mnui(ActionEvent e)
    {

    }

    private void event_menubar_exportexchangelist_mnui(ActionEvent e)
    {

    }

    private void event_menubar_exportcompare_mnui(ActionEvent e)
    {

    }

    private void event_menubar_exportfoodlist_mnui(ActionEvent e)
    {

    }

    private void event_menubar_exportfoodjournal_mnui(ActionEvent e)
    {

    }

    private void event_menubar_addtofoodlist_mnui(ActionEvent e)
    {

    }

    private void event_menubar_addtofoodjournal_mnui(ActionEvent e)
    {

    }

    private void event_menubar_delete_mnui(ActionEvent e)
    {

    }

    private void event_menubar_rename_mnui(ActionEvent e)
    {

    }

    private void event_menubar_copy_mnui(ActionEvent e)
    {

    }

    private void event_menubar_new_mnui(ActionEvent e)
    {

    }

    private void event_menubar_bmr_mnui(ActionEvent e)
    {

    }

    private JPanel getSolve()
    {
        FormLayout panelLayout = new FormLayout("min:grow", //columns
                "fill:min:grow" //rows
        );

        FormLayout bottomLayout = new FormLayout("min:grow", //columns
                "fill:min:grow" //rows
        );

        JPanel panel = new JPanel();
        JTabbedPane top = new JTabbedPane();
        JPanel bottom = new JPanel();

        panel.setLayout(panelLayout);
        bottom.setLayout(bottomLayout);

        top.setBorder(new TitledBorder("Results"));
        top.setTabPlacement(JTabbedPane.BOTTOM);
        top.add(getMain());
        top.add(getVitamins());
        top.add(getMinerals());
        top.add(getFlavonoids());
        top.add(getOther());
        top.setTitleAt(0, "Main");
        top.setTitleAt(1, "Vitamins");
        top.setTitleAt(2, "Minerals");
        top.setTitleAt(3, "Flavonoids");
        top.setTitleAt(4, "Other");

        JSplitPane splitPane = new JSplitPane();
        splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
        splitPane.setResizeWeight(.5d);
        splitPane.setTopComponent(top);
        splitPane.setBottomComponent(bottom);

        JSplitPane splitPane1 = new JSplitPane();
        splitPane1.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
        splitPane1.setResizeWeight(.1d);

        JList<Object> mixes = new JList<>();
        JScrollPane s_mixes = new JScrollPane(mixes);
        s_mixes.setBorder(new TitledBorder("Mixes"));
        bottom.add(s_mixes, cc.xy(1, 1));

        JTabbedPane bottomTabPane = new JTabbedPane();
        bottomTabPane.setBorder(new TitledBorder("Model Definition"));
        bottomTabPane.setTabPlacement(JTabbedPane.BOTTOM);
        splitPane1.setLeftComponent(s_mixes);
        splitPane1.setRightComponent(bottomTabPane);

        bottom.add(splitPane1, cc.xy(1, 1));

        bottomTabPane.add(getMixFood());
        bottomTabPane.add(getNutrientConstraint());
        bottomTabPane.add(getFoodConstraint());
        bottomTabPane.add(getFoodNutrientConstraint());
        bottomTabPane.add(getNutrientRatioConstraint());
        bottomTabPane.add(getFoodRatioConstraint());
        bottomTabPane.add(getFoodNutrientRatioConstraint());
        bottomTabPane.add(getModel());
        bottomTabPane.add(getNote());
        bottomTabPane.setTitleAt(0, "Mix Food");
        bottomTabPane.setTitleAt(1, "Nutrient");
        bottomTabPane.setTitleAt(2, "Food");
        bottomTabPane.setTitleAt(3, "Food Nutrient");
        bottomTabPane.setTitleAt(4, "Nutrient Ratio");
        bottomTabPane.setTitleAt(5, "Food Ratio");
        bottomTabPane.setTitleAt(6, "Food Nutrient Ratio");
        bottomTabPane.setTitleAt(7, "Model");
        bottomTabPane.setTitleAt(8, "Note");

        panel.add(splitPane, cc.xy(1, 1));

        return panel;
    }

    private JPanel getCompare()
    {
        JPanel panel = new JPanel();

        JScrollPane scrollPaneA = new JScrollPane(compare_a_lst);
        JScrollPane scrollPaneB = new JScrollPane(compare_b_lst);
        JScrollPane scrollPaneC = new JScrollPane(compare_tbl);
        CellConstraints cc = new CellConstraints();

        //create layouts
        FormLayout layout = new FormLayout(
                "min:grow,min:grow,min:grow", //columns
                "fill:min:grow" //rows
        );

        //specify layouts
        panel.setLayout(layout);

        //place components
        panel.add(scrollPaneA, cc.xy(1, 1));
        panel.add(scrollPaneB, cc.xy(2, 1));
        panel.add(scrollPaneC, cc.xy(3, 1));

        //set groups
        //specify size
        //specify text
        scrollPaneA.setBorder(new TitledBorder("Mix 1"));
        scrollPaneB.setBorder(new TitledBorder("Mix 2"));
        scrollPaneC.setBorder(new TitledBorder("Mix Difference"));

        //link model_txt
        compare_a_lst.setModel(compare_a_lstmodel);
        compare_b_lst.setModel(compare_b_lstmodel);
        compare_tbl.setModel(compare_tblmodel);

        //listeners
        compare_a_lst.addListSelectionListener(new ListSelectionListener()
        {

            public void valueChanged(ListSelectionEvent e)
            {
                event_compare_a_list();
            }
        });

        compare_b_lst.addListSelectionListener(new ListSelectionListener()
        {

            public void valueChanged(ListSelectionEvent e)
            {
                event_compare_b_list();
            }
        });

        return panel;
    }

    private void event_compare_b_list()
    {

    }

    private void event_compare_a_list()
    {

    }

    private JPanel getFoodJournal()
    {
        JPanel panel = new JPanel();

        JSplitPane splitPane = new JSplitPane();
        JPanel foodJournalWrapperPanel = new JPanel();

        JScrollPane foodJournalScrollPane = new JScrollPane(food_journal_table_1);
        JScrollPane foodJournalDetailsScrollPane = new JScrollPane(food_journal_table_2);

        //create layouts
        FormLayout panelFoodJournalLayout = new FormLayout(
                "min:grow", //columns
                "fill:pref:grow" //rows
        );
        FormLayout foodJournalWrapperPanelLayout = new FormLayout(
                "min:grow,min", //columns
                "fill:min:grow,min" //rows
        );

        //specify layouts
        panel.setLayout(panelFoodJournalLayout);
        foodJournalWrapperPanel.setLayout(foodJournalWrapperPanelLayout);

        //place components
        splitPane.setLeftComponent(foodJournalWrapperPanel);
        splitPane.setRightComponent(foodJournalDetailsScrollPane);
        panel.add(splitPane, cc.xy(1, 1));
        foodJournalWrapperPanel.add(foodJournalScrollPane, cc.xyw(1, 1, 2));
        foodJournalWrapperPanel.add(food_journal_delete_btn, cc.xy(2, 2));

        foodJournalWrapperPanel.setBorder(new TitledBorder("Food Journal"));
        foodJournalDetailsScrollPane.setBorder(new TitledBorder("Food Journal Details"));

        splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
        splitPane.setResizeWeight(.5d);

        food_journal_table_1.getSelectionModel().addListSelectionListener(new ListSelectionListener()
        {
            public void valueChanged(ListSelectionEvent event)
            {
                event_food_journal_table_1(event);
            }
        });

        food_journal_delete_btn.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                event_food_journal_delete_btn();
            }
        });

        return panel;
    }

    private void event_food_journal_table_1(ListSelectionEvent event)
    {
        if (event.getValueIsAdjusting())
        {
            return;
        }

        int selectedRowNo = food_journal_table_1.getSelectedRow();

        if (selectedRowNo != -1)
        {


        }
    }

    private void event_food_journal_delete_btn()
    {

    }

    private JPanel getFoodList()
    {
        JPanel panel = new JPanel();

        JPanel panelFoodListSearch = new JPanel();
        JPanel searchPanel = new JPanel();
        food_list_tbl.setModel(foodlist_tblmodel);
        JScrollPane scrollPaneTable = new JScrollPane(food_list_tbl);
        JSplitPane splitPane = new JSplitPane();
        JTabbedPane tabbedPane = new JTabbedPane();

        //create layouts
        FormLayout panelFoodListLayout = new FormLayout(
                "min:grow", //columns
                "fill:min:grow" //rows
        );
        FormLayout panelFoodListSearchLayout = new FormLayout(
                "min:grow,min", //columns
                "min,fill:min:grow,min" //rows
        );
        FormLayout searchPanelLayout = new FormLayout(
                "min,min:grow", //columns
                "min" //rows
        );

        //specify layouts
        panel.setLayout(panelFoodListLayout);
        panelFoodListSearch.setLayout(panelFoodListSearchLayout);
        searchPanel.setLayout(searchPanelLayout);

        //place components
        panel.add(splitPane, cc.xy(1, 1));
        //
        //tabbedPane.add("Facts", getFacts());
        tabbedPane.add("Facts", getInput());
        tabbedPane.add("Categories", getCategories());
        splitPane.setLeftComponent(tabbedPane);
        splitPane.setRightComponent(panelFoodListSearch);
        searchPanel.add(new JLabel("Search:"), cc.xy(1, 1));
        searchPanel.add(food_list_search_txt, cc.xy(2, 1));
        panelFoodListSearch.add(searchPanel, cc.xyw(1, 1, 2));
        panelFoodListSearch.add(scrollPaneTable, cc.xyw(1, 2, 2));
        panelFoodListSearch.add(food_list_delete_btn, cc.xy(2, 3));

        //set groups
        //specify size
        food_list_delete_btn.setMinimumSize(new Dimension(80, 28));

        //specify text
        scrollPaneTable.setBorder(new TitledBorder("Food List"));

        //specify other
        splitPane.setDividerLocation(375);

        food_list_search_txt.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                event_food_list_search_txt(e);
            }
        });


        food_list_delete_btn.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                event_food_list_delete_btn();
            }
        });


        return panel;
    }

    private void event_food_list_search_txt(ActionEvent e)
    {
        //if (isListCategorySelected()) {}

    }

    private void event_food_list_delete_btn()
    {

    }

    private JPanel getExchangeList()
    {
        JPanel panel = new JPanel();

        FormLayout panelLayout = new FormLayout(
                "min,min:grow,2dlu,min,min:grow,min", //columns
                "1dlu,min,1dlu,fill:min:grow" //rows
        );

        panel.setLayout(panelLayout);

        JScrollPane exchange_list_sc = new JScrollPane(exchange_list_table);

        panel.add(new JLabel("Food Item: "), cc.xy(1, 2));
        panel.add(exchange_list_food_cb, cc.xy(2, 2));
        panel.add(new JLabel("Quantity (g): "), cc.xy(4, 2));
        panel.add(exchange_list_quantity_txt, cc.xy(5, 2));
        panel.add(exchange_list_run_btn, cc.xy(6, 2));
        panel.add(exchange_list_sc, cc.xyw(1, 4, 6));

        exchange_list_sc.setBorder(new TitledBorder("Food Exchange List"));

        exchange_list_table.setToolTipText("This quantity of food (g) contains specified quantity of nutrient");

        exchange_list_run_btn.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                event_exchange_list_run_btn();
            }
        });


        return panel;
    }

    private void event_exchange_list_run_btn()
    {

    }

    private JPanel getMain()
    {
        JPanel panel = new JPanel();

        //create layouts
        FormLayout layout = new FormLayout(
                "min:grow", //columns
                "fill:min:grow" //rows
        );

        panel.setLayout(layout);

        JTable table = new JTable();
        table.setModel(main_table_model);

        JScrollPane scrollPane = new JScrollPane(table);

        panel.add(scrollPane, cc.xy(1, 1));

        scrollPane.setBorder(new TitledBorder("Main"));

        return panel;
    }

    private JPanel getVitamins()
    {
        JPanel panel = new JPanel();

        //create layouts
        FormLayout layout = new FormLayout(
                "min:grow", //columns
                "fill:min:grow" //rows
        );

        panel.setLayout(layout);

        JTable table = new JTable();
        table.setModel(vitamins_table_model);

        JScrollPane scrollPane = new JScrollPane(table);

        panel.add(scrollPane, cc.xy(1, 1));

        scrollPane.setBorder(new TitledBorder("Vitamins"));

        return panel;
    }

    private JPanel getMinerals()
    {
        JPanel panel = new JPanel();

        //create layouts
        FormLayout layout = new FormLayout(
                "min:grow", //columns
                "fill:min:grow" //rows
        );

        panel.setLayout(layout);

        JTable table = new JTable();
        table.setModel(minerals_table_model);

        JScrollPane scrollPane = new JScrollPane(table);

        panel.add(scrollPane, cc.xy(1, 1));

        scrollPane.setBorder(new TitledBorder("Minerals"));

        return panel;
    }

    private JPanel getFlavonoids()
    {
        JPanel panel = new JPanel();

        //create layouts
        FormLayout layout = new FormLayout(
                "min:grow", //columns
                "fill:min:grow" //rows
        );

        panel.setLayout(layout);

        JTable table = new JTable();
        table.setModel(flavonoids_table_model);

        JScrollPane scrollPane = new JScrollPane(table);

        panel.add(scrollPane, cc.xy(1, 1));

        scrollPane.setBorder(new TitledBorder("Flavonoids"));

        return panel;
    }

    private JPanel getAminoAcids()
    {
        JPanel panel = new JPanel();

        //create layouts
        FormLayout layout = new FormLayout(
                "min:grow", //columns
                "fill:min:grow" //rows
        );

        panel.setLayout(layout);

        JTable table = new JTable();
        table.setModel(aminoacids_table_model);

        JScrollPane scrollPane = new JScrollPane(table);

        panel.add(scrollPane, cc.xy(1, 1));

        scrollPane.setBorder(new TitledBorder("Amino Acids"));

        return panel;
    }

    private JPanel getOther()
    {
        JPanel panel = new JPanel();

        //create layouts
        FormLayout layout = new FormLayout(
                "min:grow", //columns
                "fill:min:grow" //rows
        );

        panel.setLayout(layout);

        JTable table = new JTable();
        table.setModel(other_table_model);

        JScrollPane scrollPane = new JScrollPane(table);

        panel.add(scrollPane, cc.xy(1, 1));

        scrollPane.setBorder(new TitledBorder("Other"));

        return panel;
    }

    private JPanel getMixFood()
    {
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

        JList selectedFood = new JList();
        JScrollPane scrSelectedFood = new JScrollPane(selectedFood);
        scrSelectedFood.setBorder(new TitledBorder("Food"));

        JTree store = new JTree();
        JScrollPane s_store = new JScrollPane(store);
        s_store.setBorder(new TitledBorder("Store"));

        //database
        TreeModelFood treeModel = new TreeModelFood(dbLink);
        treeModel.reload();
        store.setModel(treeModel);

        JButton mixfood_add_btn = new JButton("+");
        JButton mixfood_delete_btn = new JButton("-");
        JButton mixfood_expand_btn = new JButton("e");
        JButton mixfood_collapse_btn = new JButton("c");
        JButton mixfood_solve_btn = new JButton("Solve");

        buttons.add(mixfood_add_btn, cc.xy(1, 2));
        buttons.add(mixfood_delete_btn, cc.xy(1, 3));
        buttons.add(mixfood_expand_btn, cc.xy(1, 4));
        buttons.add(mixfood_collapse_btn, cc.xy(1, 5));
        buttons.add(mixfood_solve_btn, cc.xy(1, 6));

        panel.add(s_store, cc.xy(1, 1));
        panel.add(buttons, cc.xy(2, 1));
        panel.add(scrSelectedFood, cc.xy(3, 1));

        mixfood_add_btn.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                event_mixfood_add_btn();
            }
        });

        mixfood_delete_btn.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                event_mixfood_delete_btn();
            }
        });

        mixfood_expand_btn.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                event_mixfood_expand_btn();
            }
        });

        mixfood_collapse_btn.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                event_mixfood_collapse_btn();
            }
        });

        mixfood_solve_btn.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                event_mixfood_solve_btn();
            }
        });

        return panel;
    }

    private void event_mixfood_solve_btn()
    {

    }

    private void event_mixfood_collapse_btn()
    {

    }

    private void event_mixfood_expand_btn()
    {

    }

    private void event_mixfood_delete_btn()
    {

    }

    private void event_mixfood_add_btn()
    {

    }

    private JPanel getNutrientConstraint()
    {
        JPanel panel = new JPanel();

        FormLayout panelLayout = new FormLayout(
                "min:grow,min:grow", //columns
                "fill:min:grow" //rows
        );

        panel.setLayout(panelLayout);

        JPanel panel1 = new JPanel();

        FormLayout panel1Layout = new FormLayout(
                "min:grow,min:grow", //columns
                "min,min,min" //rows
        );

        panel1.setLayout(panel1Layout);

        JPanel panel2 = new JPanel();

        FormLayout panel2Layout = new FormLayout(
                "min:grow", //columns
                "fill:min:grow,min" //rows
        );

        panel2.setLayout(panel2Layout);

        JPanel panelQuantity = new JPanel();

        FormLayout panelQuantityLayout = new FormLayout(
                "min:grow", //columns
                "fill:min:grow" //rows
        );

        panelQuantity.setLayout(panelQuantityLayout);

        JPanel panelButtons = new JPanel();

        FormLayout panelButtonsLayout = new FormLayout(
                "min:grow,min,min,min:grow", //columns
                "min" //rows
        );

        panelButtons.setLayout(panelButtonsLayout);

        JPanel pnlRelationships = new JPanel();

        FormLayout pnlRelationshipsLayout = new FormLayout(
                "fill:min:grow", //columns
                "min" //rows
        );

        pnlRelationships.setLayout(pnlRelationshipsLayout);

        JPanel pnlFood = new JPanel();

        FormLayout panelLayoutAB = new FormLayout(
                "min,min:grow", //columns
                "min" //rows
        );

        pnlFood.setLayout(panelLayoutAB);

        JScrollPane constraintList = new JScrollPane(nutrient_constraint_tbl);

        pnlFood.setBorder(new TitledBorder("Food"));

        JLabel lblNutrient = new JLabel("Nutrient:");
        lblNutrient.setHorizontalAlignment(JLabel.RIGHT);

        pnlFood.add(lblNutrient, cc.xy(1, 1));
        pnlFood.add(nutrient_constraint_nutrient_cb, cc.xy(2, 1));

        pnlRelationships.add(nutrient_constraint_relationship_cb, cc.xy(1, 1));
        pnlRelationships.setBorder(new TitledBorder("Relationship"));

        panel1.add(pnlFood, cc.xyw(1, 1, 2));
        panel1.add(pnlRelationships, cc.xy(1, 2));
        panel1.add(panelQuantity, cc.xy(2, 2));

        panel2.add(constraintList, cc.xy(1, 1));
        panel2.add(panelButtons, cc.xy(1, 2));

        panel.add(panel1, cc.xy(1, 1));
        panel.add(panel2, cc.xy(2, 1));

        panelLayout.setColumnGroup(1, 2);

        panelQuantity.add(nutrient_constraint_quantity_txt, cc.xy(1, 1));

        panelButtons.add(nutrient_constraint_add_btn, cc.xy(2, 1));
        panelButtons.add(nutrient_constraint_delete_btn, cc.xy(3, 1));

        panelQuantity.setBorder(new TitledBorder("Quantity"));
        constraintList.setBorder(new TitledBorder("Nutrient Constraints"));

        nutrient_constraint_nutrient_cb.setMaximumRowCount(10);
        nutrient_constraint_nutrient_cb.setModel(cmb_1);

        nutrient_constraint_relationship_cb.setMaximumRowCount(3);
        nutrient_constraint_relationship_cb.setModel(cbm_7);

        nutrient_constraint_add_btn.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                event_nutrient_constraint_add_btn();
            }
        });

        nutrient_constraint_delete_btn.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                event_nutrient_constraint_delete_btn();
            }
        });


        return panel;
    }

    private void event_nutrient_constraint_delete_btn()
    {

    }

    private void event_nutrient_constraint_add_btn()
    {

    }

    private JPanel getFoodNutrientConstraint()
    {
        JPanel panel = new JPanel();

        FormLayout panelLayout = new FormLayout(
                "min:grow,min:grow", //columns
                "fill:min:grow" //rows
        );

        panel.setLayout(panelLayout);

        JPanel panel1 = new JPanel();

        FormLayout panel1Layout = new FormLayout(
                "min:grow,min:grow", //columns
                "min,min,min" //rows
        );

        panel1.setLayout(panel1Layout);

        JPanel panel2 = new JPanel();

        FormLayout panel2Layout = new FormLayout(
                "min:grow", //columns
                "fill:min:grow,min" //rows
        );

        panel2.setLayout(panel2Layout);

        JPanel panelQuantity = new JPanel();

        FormLayout panelQuantityLayout = new FormLayout(
                "min:grow", //columns
                "fill:min:grow" //rows
        );

        panelQuantity.setLayout(panelQuantityLayout);

        JPanel panelButtons = new JPanel();

        FormLayout panelButtonsLayout = new FormLayout(
                "min:grow,min,min,min:grow", //columns
                "min" //rows
        );

        panelButtons.setLayout(panelButtonsLayout);

        JPanel pnlRelationships = new JPanel();

        FormLayout pnlRelationshipsLayout = new FormLayout(
                "fill:min:grow", //columns
                "min" //rows
        );

        pnlRelationships.setLayout(pnlRelationshipsLayout);

        JPanel pnlFood = new JPanel();

        FormLayout panelLayoutAB = new FormLayout(
                "min,min:grow", //columns
                "min,min" //rows
        );

        pnlFood.setLayout(panelLayoutAB);

        JScrollPane constraintList = new JScrollPane(food_nutrient_constraint_tbl);

        pnlFood.setBorder(new TitledBorder("Food"));

        JLabel lblFood = new JLabel("Food:");
        lblFood.setHorizontalAlignment(JLabel.RIGHT);
        JLabel lblFoodNutrient = new JLabel("Nutrient:");
        lblFoodNutrient.setHorizontalAlignment(JLabel.RIGHT);

        pnlFood.add(lblFood, cc.xy(1, 1));
        pnlFood.add(food_nutrient_constraint_food_cb, cc.xy(2, 1));
        pnlFood.add(lblFoodNutrient, cc.xy(1, 2));
        pnlFood.add(food_nutrient_constraint_nutrient_cb, cc.xy(2, 2));

        pnlRelationships.add(food_nutrient_constraint_relationship_cb, cc.xy(1, 1));
        pnlRelationships.setBorder(new TitledBorder("Relationship"));

        panel1.add(pnlFood, cc.xyw(1, 1, 2));
        panel1.add(pnlRelationships, cc.xy(1, 2));
        panel1.add(panelQuantity, cc.xy(2, 2));

        panel2.add(constraintList, cc.xy(1, 1));
        panel2.add(panelButtons, cc.xy(1, 2));

        panel.add(panel1, cc.xy(1, 1));
        panel.add(panel2, cc.xy(2, 1));

        panelLayout.setColumnGroup(1, 2);

        panelQuantity.add(food_nutrient_constraint_quantity_txt, cc.xy(1, 1));

        panelButtons.add(food_nutrient_constraint_add_btn, cc.xy(2, 1));
        panelButtons.add(food_nutrient_constraint_delete_btn, cc.xy(3, 1));

        panelQuantity.setBorder(new TitledBorder("Quantity"));
        constraintList.setBorder(new TitledBorder("Food Nutrient Constraints"));

        food_nutrient_constraint_nutrient_cb.setMaximumRowCount(10);
        food_nutrient_constraint_nutrient_cb.setModel(cbm_2);

        food_nutrient_constraint_relationship_cb.setMaximumRowCount(3);
        food_nutrient_constraint_relationship_cb.setModel(cbm_8);

        food_nutrient_constraint_add_btn.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                event_food_nutrient_constraint_add_btn();
            }
        });

        food_nutrient_constraint_delete_btn.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                event_food_nutrient_constraint_delete_btn();
            }
        });

        return panel;
    }

    private void event_food_nutrient_constraint_delete_btn()
    {

    }

    private void event_food_nutrient_constraint_add_btn()
    {

    }

    private JPanel getNutrientRatioConstraint()
    {
        JPanel panel = new JPanel();

        JPanel panel1 = new JPanel();
        JPanel panelA = new JPanel();
        JPanel panelB = new JPanel();

        JPanel panel2 = new JPanel();
        JPanel panelRatio = new JPanel();
        JScrollPane constraintList = new JScrollPane(nutrient_ratio_tbl);
        JPanel panelButtons = new JPanel();

        FormLayout panelLayout = new FormLayout(
                "min:grow,min:grow", //columns
                "fill:min:grow" //rows
        );

        panel.setLayout(panelLayout);

        FormLayout panel1Layout = new FormLayout(
                "min:grow,min", //columns
                "min,min,min" //rows
        );

        panel1.setLayout(panel1Layout);

        FormLayout panel2Layout = new FormLayout(
                "min:grow", //columns
                "fill:min:grow,min" //rows
        );

        panel2.setLayout(panel2Layout);

        FormLayout panelLayoutAB = new FormLayout(
                "min,min:grow", //columns
                "min" //rows
        );

        panelA.setLayout(panelLayoutAB);
        panelB.setLayout(panelLayoutAB);

        FormLayout panelRatioLayout = new FormLayout(
                "min:grow,min,min,min,min,min", //columns
                "min" //rows
        );

        panelRatio.setLayout(panelRatioLayout);

        FormLayout panelButtonsLayout = new FormLayout(
                "min:grow,min,min,min:grow", //columns
                "min" //rows
        );

        panelButtons.setLayout(panelButtonsLayout);

        panelA.setBorder(new TitledBorder("Nutrient A"));
        panelB.setBorder(new TitledBorder("Nutrient B"));

        JLabel labelA = new JLabel("A:");
        JLabel labelB = new JLabel("B:");

        JLabel lblFoodANutrient = new JLabel("Nutrient:");
        lblFoodANutrient.setHorizontalAlignment(JLabel.RIGHT);

        JLabel lblFoodBNutrient = new JLabel("Nutrient:");
        lblFoodBNutrient.setHorizontalAlignment(JLabel.RIGHT);

        panelA.add(lblFoodANutrient, cc.xy(1, 1));
        panelA.add(nutrient_ratio_nutrient_a_cb, cc.xy(2, 1));

        panelB.add(lblFoodBNutrient, cc.xy(1, 1));
        panelB.add(nutrient_ratio_nutrient_b_cb, cc.xy(2, 1));

        panelRatio.add(labelA, cc.xy(2, 1));
        panelRatio.add(nutrient_ratio_nutrient_a_txt, cc.xy(3, 1));
        panelRatio.add(new Label(" / "), cc.xy(4, 1));
        panelRatio.add(labelB, cc.xy(5, 1));
        panelRatio.add(nutrient_ratio_nutrient_b_txt, cc.xy(6, 1));

        panel1.add(panelA, cc.xyw(1, 1, 2));
        panel1.add(panelB, cc.xyw(1, 2, 2));
        panel1.add(panelRatio, cc.xy(2, 3));

        panelButtons.add(nutrient_ratio_add_btn, cc.xy(2, 1));
        panelButtons.add(nutrient_ratio_delete_btn, cc.xy(3, 1));

        panel2.add(constraintList, cc.xy(1, 1));
        panel2.add(panelButtons, cc.xy(1, 2));

        panel.add(panel1, cc.xy(1, 1));
        panel.add(panel2, cc.xy(2, 1));

        panelLayout.setColumnGroup(1, 2);

        nutrient_ratio_nutrient_a_txt.setMinimumSize(new Dimension(50, 28));
        nutrient_ratio_nutrient_b_txt.setMinimumSize(new Dimension(50, 28));

        constraintList.setBorder(new TitledBorder("Nutrient Ratio Constraints"));
        panelRatio.setBorder(new TitledBorder("Ratio"));

        nutrient_ratio_nutrient_a_cb.setMaximumRowCount(10);
        nutrient_ratio_nutrient_a_cb.setModel(cbm_3);
        nutrient_ratio_nutrient_b_cb.setMaximumRowCount(10);
        nutrient_ratio_nutrient_b_cb.setModel(cbm_4);

        nutrient_ratio_add_btn.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                event_nutrient_ratio_add_btn();
            }
        });

        nutrient_ratio_delete_btn.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                event_nutrient_ratio_delete_btn();
            }
        });

        return panel;
    }

    private void event_nutrient_ratio_add_btn()
    {


    }

    private void event_nutrient_ratio_delete_btn()
    {


    }

    private JPanel getFoodNutrientRatioConstraint()
    {
        JPanel panel = new JPanel();

        JPanel panel1 = new JPanel();
        JPanel panelA = new JPanel();
        JPanel panelB = new JPanel();

        JPanel panel2 = new JPanel();
        JPanel panelRatio = new JPanel();
        JScrollPane constraintList = new JScrollPane(food_nutrient_ratio_table);
        JPanel panelButtons = new JPanel();

        FormLayout panelLayout = new FormLayout(
                "min:grow,min:grow", //columns
                "fill:min:grow" //rows
        );

        panel.setLayout(panelLayout);

        FormLayout panel1Layout = new FormLayout(
                "min:grow,min", //columns
                "min,min,min" //rows
        );

        panel1.setLayout(panel1Layout);

        FormLayout panel2Layout = new FormLayout(
                "min:grow", //columns
                "fill:min:grow,min" //rows
        );

        panel2.setLayout(panel2Layout);

        FormLayout panelLayoutAB = new FormLayout(
                "min,min:grow", //columns
                "min,min" //rows
        );

        panelA.setLayout(panelLayoutAB);
        panelB.setLayout(panelLayoutAB);

        FormLayout panelRatioLayout = new FormLayout(
                "min:grow,min,min,min,min,min", //columns
                "min" //rows
        );

        panelRatio.setLayout(panelRatioLayout);

        FormLayout panelButtonsLayout = new FormLayout(
                "min:grow,min,min,min:grow", //columns
                "min" //rows
        );

        panelButtons.setLayout(panelButtonsLayout);

        panelA.setBorder(new TitledBorder("Food A"));
        panelB.setBorder(new TitledBorder("Food B"));

        JLabel labelA = new JLabel("A:");
        JLabel labelB = new JLabel("B:");

        JLabel lblFoodA = new JLabel("Food A:");
        lblFoodA.setHorizontalAlignment(JLabel.RIGHT);
        JLabel lblFoodANutrient = new JLabel("Nutrient:");
        lblFoodANutrient.setHorizontalAlignment(JLabel.RIGHT);

        JLabel lblFoodB = new JLabel("Food B:");
        lblFoodB.setHorizontalAlignment(JLabel.RIGHT);
        JLabel lblFoodBNutrient = new JLabel("Nutrient:");
        lblFoodBNutrient.setHorizontalAlignment(JLabel.RIGHT);

        panelA.add(lblFoodA, cc.xy(1, 1));
        panelA.add(food_nutrient_ratio_food_a_cb, cc.xy(2, 1));
        panelA.add(lblFoodANutrient, cc.xy(1, 2));
        panelA.add(food_nutrient_ratio_nutrient_a_cb, cc.xy(2, 2));

        panelB.add(lblFoodB, cc.xy(1, 1));
        panelB.add(food_nutrient_ratio_food_b_cb, cc.xy(2, 1));
        panelB.add(lblFoodBNutrient, cc.xy(1, 2));
        panelB.add(food_nutrient_ratio_nutrient_b_cb, cc.xy(2, 2));

        panelRatio.add(labelA, cc.xy(2, 1));
        panelRatio.add(food_nutrient_ratio_quantity_a_txt, cc.xy(3, 1));
        panelRatio.add(new Label(" / "), cc.xy(4, 1));
        panelRatio.add(labelB, cc.xy(5, 1));
        panelRatio.add(food_nutrient_ratio_quantity_b_txt, cc.xy(6, 1));

        panel1.add(panelA, cc.xyw(1, 1, 2));
        panel1.add(panelB, cc.xyw(1, 2, 2));
        panel1.add(panelRatio, cc.xy(2, 3));

        panelButtons.add(food_nutrient_ratio_add_btn, cc.xy(2, 1));
        panelButtons.add(food_nutrient_ratio_delete_btn, cc.xy(3, 1));

        panel2.add(constraintList, cc.xy(1, 1));
        panel2.add(panelButtons, cc.xy(1, 2));

        panel.add(panel1, cc.xy(1, 1));
        panel.add(panel2, cc.xy(2, 1));

        panelLayout.setColumnGroup(1, 2);

        food_nutrient_ratio_quantity_a_txt.setMinimumSize(new Dimension(50, 28));
        food_nutrient_ratio_quantity_b_txt.setMinimumSize(new Dimension(50, 28));

        constraintList.setBorder(new TitledBorder("Food Nutrient Ratio Constraints"));
        panelRatio.setBorder(new TitledBorder("Ratio"));

        food_nutrient_ratio_nutrient_a_cb.setMaximumRowCount(10);
        food_nutrient_ratio_nutrient_a_cb.setModel(cbm_5);
        food_nutrient_ratio_nutrient_b_cb.setMaximumRowCount(10);
        food_nutrient_ratio_nutrient_b_cb.setModel(cbm_6);

        food_nutrient_ratio_add_btn.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                event_food_nutrient_ratio_add_btn();
            }
        });

        food_nutrient_ratio_delete_btn.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                event_food_nutrient_ratio_delete_btn();
            }
        });

        return panel;
    }

    private void event_food_nutrient_ratio_add_btn()
    {

    }

    private void event_food_nutrient_ratio_delete_btn()
    {

    }

    private JPanel getModel()
    {
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
        panel.add(scrollPane, cc.xy(1, 1));

        //set groups
        //specify size
        //specify text
        scrollPane.setBorder(new TitledBorder("Model"));

        return panel;
    }

    private JPanel getNote()
    {
        JPanel panel = new JPanel();

        //create layouts
        FormLayout layout = new FormLayout(
                "min:grow", //columns
                "fill:pref:grow" //rows
        );

        //specify layouts
        panel.setLayout(layout);

        //place components
        //note_txt = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(note_txt);
        panel.add(scrollPane, cc.xy(1, 1));

        //set groups
        //specify size
        //specify text
        scrollPane.setBorder(new TitledBorder("Note"));

        return panel;
    }

    private Component getFacts()
    {
        JPanel panel = new JPanel();

        JPanel panelButtons = new JPanel();
        JPanel panelTextArea = new JPanel();

        facts_servingsize_txt.setHorizontalAlignment(SwingConstants.RIGHT);
        facts_calories_txt.setHorizontalAlignment(SwingConstants.RIGHT);
        facts_fat_txt.setHorizontalAlignment(SwingConstants.RIGHT);
        facts_carbohydrate_txt.setHorizontalAlignment(SwingConstants.RIGHT);
        facts_fiber_txt.setHorizontalAlignment(SwingConstants.RIGHT);
        facts_protein_txt.setHorizontalAlignment(SwingConstants.RIGHT);
        facts_satfat_txt.setHorizontalAlignment(SwingConstants.RIGHT);
        facts_monoufat_txt.setHorizontalAlignment(SwingConstants.RIGHT);
        facts_polyufat_txt.setHorizontalAlignment(SwingConstants.RIGHT);
        facts_cholesterol_txt.setHorizontalAlignment(SwingConstants.RIGHT);
        facts_sodium_txt.setHorizontalAlignment(SwingConstants.RIGHT);
        facts_cost_txt.setHorizontalAlignment(SwingConstants.RIGHT);

        //create layouts
        FormLayout panelLayout = new FormLayout(
                "min,min:grow,min", //columns
                "min,min,min,min,min,min,min,min,min,min,min,min,min,min,min,fill:min:grow,center:min" //rows
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
        panelButtons.setLayout(panelButtonsLayout);
        panelTextArea.setLayout(panelTextAreaLayout);

        //place components
        panel.add(new JLabel("Category:"), cc.xy(1, 1));
        panel.add(facts_category_cb, cc.xy(2, 1));
        panel.add(new JLabel("Nom:"), cc.xy(1, 2));
        panel.add(facts_nom_txt, cc.xy(2, 2));
        //
        panel.add(new JLabel("Serving Size:"), cc.xy(1, 3));
        panel.add(facts_servingsize_txt, cc.xy(2, 3));
        panel.add(new JLabel("g"), cc.xy(3, 3));
        //
        panel.add(new JLabel("Calories:"), cc.xy(1, 4));
        panel.add(facts_calories_txt, cc.xy(2, 4));
        panel.add(new JLabel("Kcal"), cc.xy(3, 4));
        //
        panel.add(new JLabel("Fat:"), cc.xy(1, 5));
        panel.add(facts_fat_txt, cc.xy(2, 5));
        panel.add(new JLabel("g"), cc.xy(3, 5));
        //
        panel.add(new JLabel("Carbohydrate:"), cc.xy(1, 6));
        panel.add(facts_carbohydrate_txt, cc.xy(2, 6));
        panel.add(new JLabel("g"), cc.xy(3, 6));
        //
        panel.add(new JLabel("Fiber:"), cc.xy(1, 7));
        panel.add(facts_fiber_txt, cc.xy(2, 7));
        panel.add(new JLabel("g"), cc.xy(3, 7));
        //
        panel.add(new JLabel("Protein:"), cc.xy(1, 8));
        panel.add(facts_protein_txt, cc.xy(2, 8));
        panel.add(new JLabel("g"), cc.xy(3, 8));
        //
        panel.add(new JLabel("Is Complete?:"), cc.xy(1, 9));
        panel.add(facts_iscomplete_cb, cc.xy(2, 9));
        //
        panel.add(new JLabel("Saturated Fat:"), cc.xy(1, 10));
        panel.add(facts_satfat_txt, cc.xy(2, 10));
        panel.add(new JLabel("g"), cc.xy(3, 10));
        //
        panel.add(new JLabel("Monounsaturated Fat:"), cc.xy(1, 11));
        panel.add(facts_monoufat_txt, cc.xy(2, 11));
        panel.add(new JLabel("g"), cc.xy(3, 11));
        //
        panel.add(new JLabel("Polyunsaturated Fat:"), cc.xy(1, 12));
        panel.add(facts_polyufat_txt, cc.xy(2, 12));
        panel.add(new JLabel("g"), cc.xy(3, 12));
        //
        panel.add(new JLabel("Cholesterol:"), cc.xy(1, 13));
        panel.add(facts_cholesterol_txt, cc.xy(2, 13));
        panel.add(new JLabel("g"), cc.xy(3, 13));
        //
        panel.add(new JLabel("Sodium:"), cc.xy(1, 14));
        panel.add(facts_sodium_txt, cc.xy(2, 14));
        panel.add(new JLabel("mg"), cc.xy(3, 14));
        //
        panel.add(new JLabel("Cost:"), cc.xy(1, 15));
        panel.add(facts_cost_txt, cc.xy(2, 15));
        panel.add(new JLabel("$"), cc.xy(3, 15));
        //
        panelTextArea.setBorder(new TitledBorder("Note"));
        panelTextArea.add(facts_note_txt, cc.xy(1, 1));
        panel.add(panelTextArea, cc.xyw(1, 16, 2));
        panelButtons.add(facts_clear_btn, cc.xy(2, 1));
        panelButtons.add(facts_save_btn, cc.xy(3, 1));
        panelButtons.add(facts_update_btn, cc.xy(4, 1));
        panel.add(panelButtons, cc.xyw(1, 17, 2));

        panel.setBorder(new TitledBorder("Nutrition Facts Label"));

        facts_clear_btn.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                event_facts_clear_btn_clear_btn();
            }
        });

        facts_save_btn.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                event_facts_save_btn_clear_btn();
            }
        });

        facts_update_btn.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                event_facts_update_btn_clear_btn();
            }
        });

        return panel;
    }

    private void event_facts_update_btn_clear_btn()
    {

    }

    private void event_facts_save_btn_clear_btn()
    {

    }

    private void event_facts_clear_btn_clear_btn()
    {

    }

    private Component getCategories()
    {
        JPanel panel = new JPanel();

        FormLayout layout = new FormLayout(
                "min,min:grow", //columns
                "fill:min:grow,min,min" //rows
        );

        panel.setLayout(layout);

        JPanel panelButtons = new JPanel();

        FormLayout panelButtonsLayout = new FormLayout(
                "min:grow,min,min,min,min:grow", //columns
                "fill:min:grow" //rows
        );

        panelButtons.setLayout(panelButtonsLayout);

        panelButtons.add(categories_save_btn, cc.xy(2, 1));
        panelButtons.add(categories_rename_btn, cc.xy(3, 1));
        panelButtons.add(categories_delete_btn, cc.xy(4, 1));
        panel.add(new JScrollPane(categories_lst), cc.xyw(1, 1, 2));
        panel.add(new JLabel("Category:"), cc.xy(1, 2));
        panel.add(categories_category_txt, cc.xy(2, 2));
        panel.add(panelButtons, cc.xyw(1, 3, 2));

        panel.setBorder(new TitledBorder("Food Categories"));

        categories_save_btn.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                event_categories_save_btn();
            }
        });

        categories_rename_btn.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                event_categories_rename_btn();
            }
        });

        categories_delete_btn.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                event_categories_delete_btn();
            }
        });

        return panel;
    }

    private void event_categories_delete_btn()
    {

    }

    private void event_categories_rename_btn()
    {

    }

    private void event_categories_save_btn()
    {

    }

    private void event_menubar_exit_mnui()
    {
        frame.dispose();
        //dbLink.Shutdown();
    }

    public static void main(String[] args)
    {
        try
        {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
            //UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            //UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
            //UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
            //UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (InstantiationException e)
        {
            e.printStackTrace();
        }
        catch (IllegalAccessException e)
        {
            e.printStackTrace();
        }
        catch (UnsupportedLookAndFeelException e)
        {
            e.printStackTrace();
        }

        Main main = new Main();
    }

    private JTabbedPane getInput(){

        JTabbedPane top = new JTabbedPane();

        top.setBorder(new TitledBorder("Input"));
        top.setTabPlacement(JTabbedPane.BOTTOM);
        top.add(getFacts());
        top.add(getVitamins());
        top.add(getMinerals());
        top.add(getFlavonoids());
        top.add(getOther());
        top.setTitleAt(0, "Main");
        top.setTitleAt(1, "Vitamins");
        top.setTitleAt(2, "Minerals");
        top.setTitleAt(3, "Flavonoids");
        top.setTitleAt(4, "Other");

        return top;
    }

    private JPanel getFoodConstraint()
    {
        JPanel panel = new JPanel();

        FormLayout panelLayout = new FormLayout(
                "min:grow,min:grow", //columns
                "fill:min:grow" //rows
        );

        panel.setLayout(panelLayout);

        JPanel panel1 = new JPanel();

        FormLayout panel1Layout = new FormLayout(
                "min:grow,min:grow", //columns
                "min,min,min" //rows
        );

        panel1.setLayout(panel1Layout);

        JPanel panel2 = new JPanel();

        FormLayout panel2Layout = new FormLayout(
                "min:grow", //columns
                "fill:min:grow,min" //rows
        );

        panel2.setLayout(panel2Layout);

        JPanel panelQuantity = new JPanel();

        FormLayout panelQuantityLayout = new FormLayout(
                "min:grow", //columns
                "fill:min:grow" //rows
        );

        panelQuantity.setLayout(panelQuantityLayout);

        JPanel panelButtons = new JPanel();

        FormLayout panelButtonsLayout = new FormLayout(
                "min:grow,min,min,min:grow", //columns
                "min" //rows
        );

        panelButtons.setLayout(panelButtonsLayout);

        JPanel pnlRelationships = new JPanel();

        FormLayout pnlRelationshipsLayout = new FormLayout(
                "fill:min:grow", //columns
                "min" //rows
        );

        pnlRelationships.setLayout(pnlRelationshipsLayout);

        JPanel pnlFood = new JPanel();

        FormLayout panelLayoutAB = new FormLayout(
                "min,min:grow", //columns
                "min" //rows
        );

        pnlFood.setLayout(panelLayoutAB);

        JScrollPane constraintList = new JScrollPane(food_constraint_tbl);

        pnlFood.setBorder(new TitledBorder("Food"));

        JLabel lblFood = new JLabel("Food:");
        lblFood.setHorizontalAlignment(JLabel.RIGHT);
        JLabel lblFoodNutrientClass = new JLabel("Nutrient Class:");
        lblFoodNutrientClass.setHorizontalAlignment(JLabel.RIGHT);
        JLabel lblFoodNutrient = new JLabel("Nutrient:");
        lblFoodNutrient.setHorizontalAlignment(JLabel.RIGHT);

        pnlFood.add(lblFood, cc.xy(1, 1));
        pnlFood.add(food_constraint_food_cb, cc.xy(2, 1));

        pnlRelationships.add(food_constraint_relationship_cb, cc.xy(1, 1));
        pnlRelationships.setBorder(new TitledBorder("Relationship"));

        panel1.add(pnlFood, cc.xyw(1, 1, 2));
        panel1.add(pnlRelationships, cc.xy(1, 2));
        panel1.add(panelQuantity, cc.xy(2, 2));

        panel2.add(constraintList, cc.xy(1, 1));
        panel2.add(panelButtons, cc.xy(1, 2));

        panel.add(panel1, cc.xy(1, 1));
        panel.add(panel2, cc.xy(2, 1));

        panelLayout.setColumnGroup(1, 2);

        panelQuantity.add(food_constraint_quantity_txt, cc.xy(1, 1));

        panelButtons.add(food_constraint_add_btn, cc.xy(2, 1));
        panelButtons.add(food_constraint_delete_btn, cc.xy(3, 1));

        panelQuantity.setBorder(new TitledBorder("Quantity"));
        constraintList.setBorder(new TitledBorder("Food Constraints"));

        food_constraint_relationship_cb.setMaximumRowCount(3);
        food_constraint_relationship_cb.setModel(cbm_9);

        food_constraint_add_btn.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                event_food_constraint_add_btn();
            }
        });

        food_constraint_delete_btn.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                event_food_constraint_delete_btn();
            }
        });

        return panel;
    }

    private void event_food_constraint_delete_btn()
    {

    }

    private void event_food_constraint_add_btn()
    {

    }

    private JPanel getFoodRatioConstraint()
    {
        JPanel panel = new JPanel();

        JPanel panel1 = new JPanel();
        JPanel panelA = new JPanel();
        JPanel panelB = new JPanel();

        JPanel panel2 = new JPanel();
        JPanel panelRatio = new JPanel();
        JScrollPane constraintList = new JScrollPane(food_ratio_table);
        JPanel panelButtons = new JPanel();

        FormLayout panelLayout = new FormLayout(
                "min:grow,min:grow", //columns
                "fill:min:grow" //rows
        );

        panel.setLayout(panelLayout);

        FormLayout panel1Layout = new FormLayout(
                "min:grow,min", //columns
                "min,min,min" //rows
        );

        panel1.setLayout(panel1Layout);

        FormLayout panel2Layout = new FormLayout(
                "min:grow", //columns
                "fill:min:grow,min" //rows
        );

        panel2.setLayout(panel2Layout);

        FormLayout panelLayoutAB = new FormLayout(
                "min,min:grow", //columns
                "min" //rows
        );

        panelA.setLayout(panelLayoutAB);
        panelB.setLayout(panelLayoutAB);

        FormLayout panelRatioLayout = new FormLayout(
                "min:grow,min,min,min,min,min", //columns
                "min" //rows
        );

        panelRatio.setLayout(panelRatioLayout);

        FormLayout panelButtonsLayout = new FormLayout(
                "min:grow,min,min,min:grow", //columns
                "min" //rows
        );

        panelButtons.setLayout(panelButtonsLayout);

        panelA.setBorder(new TitledBorder("Food A"));
        panelB.setBorder(new TitledBorder("Food B"));

        JLabel labelA = new JLabel("A:");
        JLabel labelB = new JLabel("B:");

        JLabel lblFoodA = new JLabel("Food A:");
        lblFoodA.setHorizontalAlignment(JLabel.RIGHT);
        JLabel lblFoodANutrientClass = new JLabel("Nutrient Class:");
        lblFoodANutrientClass.setHorizontalAlignment(JLabel.RIGHT);
        JLabel lblFoodANutrient = new JLabel("Nutrient:");
        lblFoodANutrient.setHorizontalAlignment(JLabel.RIGHT);

        JLabel lblFoodB = new JLabel("Food B:");
        lblFoodB.setHorizontalAlignment(JLabel.RIGHT);
        JLabel lblFoodBNutrientClass = new JLabel("Nutrient Class:");
        lblFoodBNutrientClass.setHorizontalAlignment(JLabel.RIGHT);
        JLabel lblFoodBNutrient = new JLabel("Nutrient:");
        lblFoodBNutrient.setHorizontalAlignment(JLabel.RIGHT);

        panelA.add(lblFoodA, cc.xy(1, 1));
        panelA.add(this.food_ratio_food_a_cb, cc.xy(2, 1));

        panelB.add(lblFoodB, cc.xy(1, 1));
        panelB.add(food_ratio_food_b_cb, cc.xy(2, 1));

        panelRatio.add(labelA, cc.xy(2, 1));
        panelRatio.add(food_ratio_quantity_a_txt, cc.xy(3, 1));
        panelRatio.add(new Label(" / "), cc.xy(4, 1));
        panelRatio.add(labelB, cc.xy(5, 1));
        panelRatio.add(food_ratio_quantity_b_txt, cc.xy(6, 1));

        panel1.add(panelA, cc.xyw(1, 1, 2));
        panel1.add(panelB, cc.xyw(1, 2, 2));
        panel1.add(panelRatio, cc.xy(2, 3));

        panelButtons.add(food_ratio_add_btn, cc.xy(2, 1));
        panelButtons.add(food_ratio_delete_btn, cc.xy(3, 1));

        panel2.add(constraintList, cc.xy(1, 1));
        panel2.add(panelButtons, cc.xy(1, 2));

        panel.add(panel1, cc.xy(1, 1));
        panel.add(panel2, cc.xy(2, 1));

        panelLayout.setColumnGroup(1, 2);

        food_ratio_quantity_a_txt.setMinimumSize(new Dimension(50, 28));
        food_ratio_quantity_b_txt.setMinimumSize(new Dimension(50, 28));

        constraintList.setBorder(new TitledBorder("Food Ratio Constraints"));
        panelRatio.setBorder(new TitledBorder("Ratio"));

        food_ratio_add_btn.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                event_food_ratio_add_btn();
            }
        });

        food_ratio_delete_btn.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                event_food_ratio_delete_btn();
            }
        });

        return panel;
    }

    private void event_food_ratio_delete_btn()
    {

    }

    private void event_food_ratio_add_btn()
    {

    }

}
