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
            "Fluoride, F (mcg)",
            "Selenium, Se (mcg)",
            "Vitamin A (mcg)",
            "Vitamin D (mcg)",
            "Alpha-Tocopherol, Vitamin E (mg)",
            "Ascorbic Acid, Vitamin C (mg)",
            "Thiamin, Vitamin B1 (mg)",
            "Riboflavin, Vitamin B2 (mg)",
            "Niacin, Vitamin B3 (mg)",
            "Pantothenic Acid, Vitamin B5 (mg)",
            "Vitamin B6 (mg)",
            "Vitamin B12 (mcg)",
            "Choline, Vitamin B4 (mg)",
            "Vitamin K (mcg)",
            "Folate, Vitamin B9 (mcg)",
            "Cholesterol (mg)",
            "Saturated Fat (g)",
            "Docosahexaenoic Acid (g)",
            "Eicosapentaenoic Acid (g)",
            "Monounsaturated Fat (g)",
            "Polyunsaturated Fat (g)",
            "Linoleic Acid (g)",
            "Alpha-Linolenic Acid (g)",
            "Glycemic Load",
            "Water (g)",
            "Cost ($)"
        });
    }

    @Override
    public String getToolTipText(MouseEvent e) {
        return super.getToolTipText(e);
    }
}