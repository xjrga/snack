package io.github.xjrga.snack.other;

import javax.swing.table.TableColumnModel;
import java.awt.event.MouseEvent;

public class TableHeaderFoodList extends MyTableHeader {

    public TableHeaderFoodList(TableColumnModel columnModel) {
        super(columnModel, new String[]{
            "FoodId",
            "Food Name",
            "Weight (g)",
            "Energy, gross (Kcal)",
            "Energy, digestible (Kcal)",
            "Energy, no protein (Kcal)",
            "Energy, fat (Kcal)",
            "Energy, carboydrate (Kcal)",
            "Energy, protein (Kcal)",
            "Energy, alcohol (Kcal)",
            "Total Fat (g)",
            "Digestible Carbohydrate (g)",
            "Protein (g)",
            "Alcohol, Ethyl (g)",
            "Sodium, Na (mg)",
            "Potassium, K (mg)",
            "Complete Protein (g)",
            "Carbohydrate By Difference (g)",
            "Fiber, Total (g)",
            "Calcium, Ca (mg)",
            "Phosphorus, P (mg)",
            "Magnesium, Mg (mg)",
            "Iron, Fe (mg)",
            "Zinc, Zn (mg)",
            "Copper, Cu (mg)",
            "Manganese, Mn (mg)",
            "Fluoride, F (µg)",
            "Selenium, Se (µg)",
            "Vitamin A, RAE (µg)",
            "Vitamin D (D2 + D3) (µg)",
            "Vitamin E (Alpha-Tocopherol) (mg)",
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
            "Cholesterol (mg)",
            "Saturated Fat (g)",
            "DHA (g)",
            "EPA (g)",
            "Monounsaturated Fat (g)",
            "Polyunsaturated Fat (g)",
            "Linoleic Acid (g)",
            "Alpha-Linolenic Acid (g)",
            "Glycemic Load",
            "Water (g)",
            "Cost ($)"
        });
    }

    public String getToolTipText(MouseEvent e) {
        return super.getToolTipText(e);
    }
}
