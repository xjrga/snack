package io.github.xjrga.snack.jpanels;

import io.github.xjrga.snack.interfaces.ShowCategory;
import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;
import static io.github.xjrga.snack.jpanels.NutrientCategorySelector.Nutrients.Calories;
import java.awt.event.ItemEvent;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;

/**
 * @author jr
 */
public class NutrientCategorySelector extends JPanel {

    private final CellConstraints cc;
    private final String[] text;
    private final JRadioButton option0;
    private final JRadioButton option1;
    private final JRadioButton option2;
    private final JRadioButton option3;
    private final JRadioButton option4;
    private final JRadioButton option5;
    private final JRadioButton option6;
    private final JRadioButton option7;
    private final JRadioButton option8;
    private final JRadioButton option9;
    private final JRadioButton option10;
    private final JRadioButton option11;
    private Nutrients option;
    private ShowCategory tbl;

    public enum Nutrients {
        Calories,
        Macronutrients,
        Protein,
        Fats,
        Saturated,
        Polyunsaturated,
        Carbohydrates,
        Vitamins,
        Minerals,
        Electrolytes,
        Phytonutrients,
        Other
    }

    public NutrientCategorySelector() {

        cc = new CellConstraints();
        text = new String[] {
            "Calories",
            "Macronutrients",
            "Protein",
            "Fats",
            "Saturated",
            "Polyunsaturated",
            "Carbohydrates",
            "Vitamins",
            "Minerals",
            "Electrolytes",
            "Phytonutrients",
            "Other"
        };

        FormLayout lyo = new FormLayout(
                "min", // columns
                "min,min,min,min,min,min,min,min,min,min,min,min" // rows
                );

        setLayout(lyo);
        setBorder(new TitledBorder("Nutrients"));

        option0 = new JRadioButton();
        option1 = new JRadioButton();
        option2 = new JRadioButton();
        option3 = new JRadioButton();
        option4 = new JRadioButton();
        option5 = new JRadioButton();
        option6 = new JRadioButton();
        option7 = new JRadioButton();
        option8 = new JRadioButton();
        option9 = new JRadioButton();
        option10 = new JRadioButton();
        option11 = new JRadioButton();

        option0.setText(text[0]);
        option1.setText(text[1]);
        option2.setText(text[2]);
        option3.setText(text[3]);
        option4.setText(text[4]);
        option5.setText(text[5]);
        option6.setText(text[6]);
        option7.setText(text[7]);
        option8.setText(text[8]);
        option9.setText(text[9]);
        option10.setText(text[10]);
        option11.setText(text[11]);

        add(option0, cc.xy(1, 1));
        add(option1, cc.xy(1, 2));
        add(option2, cc.xy(1, 3));
        add(option3, cc.xy(1, 4));
        add(option4, cc.xy(1, 5));
        add(option5, cc.xy(1, 6));
        add(option6, cc.xy(1, 7));
        add(option7, cc.xy(1, 8));
        add(option8, cc.xy(1, 9));
        add(option9, cc.xy(1, 10));
        add(option10, cc.xy(1, 11));
        add(option11, cc.xy(1, 12));

        ButtonGroup group = new ButtonGroup();
        group.add(option0);
        group.add(option1);
        group.add(option2);
        group.add(option3);
        group.add(option4);
        group.add(option5);
        group.add(option6);
        group.add(option7);
        group.add(option8);
        group.add(option9);
        group.add(option10);
        group.add(option11);

        option0.addItemListener((ItemEvent e) -> {
            JRadioButton source = (JRadioButton) e.getSource();

            if (e.getStateChange() == ItemEvent.SELECTED) {

                option = Nutrients.Calories;
                tbl.showCategory(option.ordinal());
            }
        });

        option1.addItemListener((ItemEvent e) -> {
            JRadioButton source = (JRadioButton) e.getSource();

            if (e.getStateChange() == ItemEvent.SELECTED) {

                option = Nutrients.Macronutrients;
                tbl.showCategory(option.ordinal());
            }
        });

        option2.addItemListener((ItemEvent e) -> {
            JRadioButton source = (JRadioButton) e.getSource();

            if (e.getStateChange() == ItemEvent.SELECTED) {

                option = Nutrients.Protein;
                tbl.showCategory(option.ordinal());
            }
        });

        option3.addItemListener((ItemEvent e) -> {
            JRadioButton source = (JRadioButton) e.getSource();

            if (e.getStateChange() == ItemEvent.SELECTED) {

                option = Nutrients.Fats;
                tbl.showCategory(option.ordinal());
            }
        });

        option4.addItemListener((ItemEvent e) -> {
            JRadioButton source = (JRadioButton) e.getSource();

            if (e.getStateChange() == ItemEvent.SELECTED) {

                option = Nutrients.Saturated;
                tbl.showCategory(option.ordinal());
            }
        });

        option5.addItemListener((ItemEvent e) -> {
            JRadioButton source = (JRadioButton) e.getSource();

            if (e.getStateChange() == ItemEvent.SELECTED) {

                option = Nutrients.Polyunsaturated;
                tbl.showCategory(option.ordinal());
            }
        });

        option6.addItemListener((ItemEvent e) -> {
            JRadioButton source = (JRadioButton) e.getSource();

            if (e.getStateChange() == ItemEvent.SELECTED) {

                option = Nutrients.Carbohydrates;
                tbl.showCategory(option.ordinal());
            }
        });

        option7.addItemListener((ItemEvent e) -> {
            JRadioButton source = (JRadioButton) e.getSource();

            if (e.getStateChange() == ItemEvent.SELECTED) {

                option = Nutrients.Vitamins;
                tbl.showCategory(option.ordinal());
            }
        });

        option8.addItemListener((ItemEvent e) -> {
            JRadioButton source = (JRadioButton) e.getSource();

            if (e.getStateChange() == ItemEvent.SELECTED) {

                option = Nutrients.Minerals;
                tbl.showCategory(option.ordinal());
            }
        });

        option9.addItemListener((ItemEvent e) -> {
            JRadioButton source = (JRadioButton) e.getSource();

            if (e.getStateChange() == ItemEvent.SELECTED) {

                option = Nutrients.Electrolytes;
                tbl.showCategory(option.ordinal());
            }
        });

        option10.addItemListener((ItemEvent e) -> {
            JRadioButton source = (JRadioButton) e.getSource();

            if (e.getStateChange() == ItemEvent.SELECTED) {

                option = Nutrients.Phytonutrients;
                tbl.showCategory(option.ordinal());
            }
        });

        option11.addItemListener((ItemEvent e) -> {
            JRadioButton source = (JRadioButton) e.getSource();

            if (e.getStateChange() == ItemEvent.SELECTED) {

                option = Nutrients.Other;
                tbl.showCategory(option.ordinal());
            }
        });
    }

    public NutrientCategorySelector(ShowCategory component) {

        this();
        tbl = component;
    }

    public Nutrients getOption() {

        return option;
    }

    public String getOptionText() {

        return option.name();
    }

    public void setSelected(Nutrients option) {

        switch (option) {
            case Calories -> option0.setSelected(true);
            case Macronutrients -> option1.setSelected(true);
            case Protein -> option2.setSelected(true);
            case Fats -> option3.setSelected(true);
            case Saturated -> option4.setSelected(true);
            case Polyunsaturated -> option5.setSelected(true);
            case Carbohydrates -> option6.setSelected(true);
            case Vitamins -> option7.setSelected(true);
            case Minerals -> option8.setSelected(true);
            case Electrolytes -> option9.setSelected(true);
            case Phytonutrients -> option10.setSelected(true);
            case Other -> {
                option11.setSelected(true);
            }
        }
    }

    public int getCount() {

        return text.length;
    }
}
