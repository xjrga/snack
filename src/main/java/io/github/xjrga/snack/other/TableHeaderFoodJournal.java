package io.github.xjrga.snack.other;

import javax.swing.table.TableColumnModel;
import java.awt.event.MouseEvent;

public class TableHeaderFoodJournal extends MyTableHeader {

    public TableHeaderFoodJournal(TableColumnModel columnModel) {
        super(columnModel, new String[]{
            "Food Name",
            "Weight (g)",
            "Energy Digestible (Kcal)",
            "Protein (g)",
            "Complete Protein (g)",
            "Incomplete Protein (g)",
            "Total Fat (g)",
            "Monounsaturated Fat (g)",
            "Polyunsaturated Fat (g)",
            "Saturated Fat (g)",
            "Cholesterol (mg)",
            "Linoleic Acid (g)",
            "Alpha-Linolenic Acid (g)",
            "DHA (g)",
            "EPA (g)",
            "Digestible Carbohydrate (g)",
            "Fiber, Total (g)",
            "Sucrose (g)",
            "Fructose (g)",
            "Lactose (g)",
            "Vitamin A, RAE (µg)",
            "Vitamin E (Alpha-Tocopherol) (mg)",
            "Vitamin D (D2 + D3) (µg)",
            "Vitamin C (Ascorbic Acid) (mg)",
            "Thiamin (mg)",
            "Riboflavin (mg)",
            "Niacin (mg)",
            "Pantothenic Acid (mg)",
            "Vitamin B6 (mg)",
            "Vitamin B12 (µg)",
            "Choline (mg)",
            "Vitamin K (µg)",
            "Folate, DFE (µg)",
            "Calcium, Ca (mg)",
            "Iron, Fe (mg)",
            "Magnesium, Mg (mg)",
            "Phosphorus, P (mg)",
            "Potassium, K (mg)",
            "Sodium, Na (mg)",
            "Zinc, Zn (mg)",
            "Copper, Cu (mg)",
            "Fluoride, F (µg)",
            "Manganese, Mn (mg)",
            "Selenium, Se (µg)",
            "Alcohol, Ethyl (g)",
            "Water (g)",
            "Cost ($)",
            "Percent of Total Carbohydrate (%)",
            "Glycemic Index",
            "Glycemic Load",
            "Contribution to Glycemic Index of Meal"
        });
    }

    @Override
    public String getToolTipText(MouseEvent e) {
        return super.getToolTipText(e);
    }
}
