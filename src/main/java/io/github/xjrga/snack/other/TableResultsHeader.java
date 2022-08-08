package io.github.xjrga.snack.other;

import java.awt.event.MouseEvent;
import javax.swing.table.TableColumnModel;

public class TableResultsHeader extends MyTableHeader {

    public TableResultsHeader(TableColumnModel columnModel) {
        super(columnModel, new String[]{
            "Name",
            "Protein",
            "Fat",
            "Carbohydrate By Difference",
            "Energy",
            "Sucrose",
            "Fructose",
            "Lactose",
            "Alcohol",
            "Water",
            "Caffeine",
            "Theobromine",
            "Fiber",
            "Calcium",
            "Iron",
            "Magnesium",
            "Phosphorus",
            "Potassium",
            "Sodium",
            "Zinc",
            "Copper",
            "Manganese",
            "Selenium",
            "Vitamin A",
            "Vitamin E",
            "Vitamin D",
            "Lutein",
            "Vitamin C",
            "Thiamin",
            "Riboflavin",
            "Niacin",
            "Pantothenic Acid",
            "Vitamin B6",
            "Vitamin B12",
            "Vitamin K",
            "Folate",
            "Tryptophan",
            "Threonine",
            "Isoleucine",
            "Leucine",
            "Lysine",
            "Methionine",
            "Cystine",
            "Phenylalanine",
            "Tyrosine",
            "Valine",
            "Arginine",
            "Histidine",
            "Alanine",
            "Aspartic",
            "Glutamic",
            "Glycine",
            "Proline",
            "Serine",
            "Hydroxyproline",
            "Cholesterol",
            "Saturated",
            "Docosahexaenoic",
            "Eicosapentaenoic",
            "Monounsaturated",
            "Polyunsaturated",
            "Linoleic",
            "Alpha Linolenic",
            "Weight",
            "Complete Protein",
            "Incomplete Protein",
            "Digestible Carbohydrate",
            "Cost"
        });
    }

    @Override
    public String getToolTipText(MouseEvent e) {
        return super.getToolTipText(e);
    }
}
