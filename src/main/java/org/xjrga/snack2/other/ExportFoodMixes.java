package org.xjrga.snack2.other;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.xjrga.snack2.data.DbLink;
import org.xjrga.snack2.data.Nutrient;
import org.xjrga.snack2.dataobject.MixDataObject;
import org.xjrga.snack2.gui.Message;

import javax.swing.*;
import java.io.FileOutputStream;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class ExportFoodMixes {
    private final DbLink dbLink;
    private Cell rowCell;
    private CellStyle cellStyleColumnName;
    private CellStyle cellStyleFoodItemName;
    private CellStyle cellStyleFoodItemValue;
    private CellStyle cellStyleName;
    private CellStyle cellStyleTotalName;
    private CellStyle cellStyleTotalValue;
    private CellStyle cellStyleValue = null;
    private DataFormat cellFormat;
    private Date date;
    private FileOutputStream out;
    private Font fontBold;
    private int rownum;
    private Row row;
    private Sheet sheet;
    private SimpleDateFormat dateFormat;
    private String format;
    private String pattern;
    private String sheetname;
    private StringBuilder filepath;
    private StringBuilder sb;
    private Workbook wb;

    public ExportFoodMixes(DbLink dbLink) {
        this.dbLink = dbLink;
        initializeVariables();
        initializeMethods();
    }

    private void initializeVariables() {
        wb = new HSSFWorkbook();
        fontBold = wb.createFont();
        cellFormat = wb.createDataFormat();
        cellStyleColumnName = getCellStyleColumnName();
        cellStyleFoodItemName = getCellStyleFoodItemName();
        cellStyleFoodItemValue = getCellStyleFoodItemValue();
        cellStyleName = null;
        cellStyleTotalName = getCellStyleTotalName();
        cellStyleTotalValue = getCellStyleTotalValue();
        sheet = wb.createSheet();
        date = new Date();
        pattern = "yyyy-MMMMM-dd'_at_'HH-mm-ss";
        dateFormat = new SimpleDateFormat(pattern);
        format = dateFormat.format(date);
        out = null;
        rownum = 0;
        row = null;
        sheetname = "Mixes";
        filepath = new StringBuilder();
        sb = new StringBuilder();
    }

    private void initializeMethods() {
        fontBold.setBold(true);
        sb.append("mixes_");
        sb.append(format);
        sb.append(".xls");
        filepath.append("files/");
        filepath.append(sb.toString());
        wb.setSheetName(0, sheetname);
    }

    public void print() {
        try {
            LinkedList all = (LinkedList) dbLink.Mix_Select_All();
            Iterator iteratorMix = all.iterator();
            while (iteratorMix.hasNext()) {
                HashMap rowMap = (HashMap) iteratorMix.next();
                MixDataObject mixDataObject = new MixDataObject((int) rowMap.get("MIXID"), (String) rowMap.get("NAME"));
//Set mix name
                createNewRow();
                fillRowCellWithMixName(mixDataObject.getName());
                //Set column names
                createNewRow();
                //Name
                fillRowCellWithColumnName(0, "Name");
                //Weight
                fillRowCellWithColumnName(1, "Weight");
                //Energy
                fillRowCellWithColumnName(2, Nutrient.ENERGY.getName());
                //Protein
                fillRowCellWithColumnName(3, Nutrient.PROTEIN.getName());
                //Complete
                fillRowCellWithColumnName(4, Nutrient.COMPLETEPROTEIN.getName());
                //Incomplete
                fillRowCellWithColumnName(5, Nutrient.INCOMPLETEPROTEIN.getName());
                //Fat
                fillRowCellWithColumnName(6, Nutrient.FAT.getName());
                //Monounsaturated
                fillRowCellWithColumnName(7, Nutrient.MONOUNSATURATED.getName());
                //Polyunsaturated
                fillRowCellWithColumnName(8, Nutrient.POLYUNSATURATED.getName());
                //Saturated
                fillRowCellWithColumnName(9, Nutrient.SATURATED.getName());
                //Cholesterol
                fillRowCellWithColumnName(10, Nutrient.CHOLESTEROL.getName());
                //Linoleic
                fillRowCellWithColumnName(11, Nutrient.LINOLEIC.getName());
                //Alpha-Linolenic
                fillRowCellWithColumnName(12, Nutrient.ALPHALINOLENIC.getName());
                //DHA
                fillRowCellWithColumnName(13, Nutrient.DHA.getName());
                //EPA
                fillRowCellWithColumnName(14, Nutrient.EPA.getName());
                //Carbohydrate
                fillRowCellWithColumnName(15, Nutrient.DIGESTIBLECARBS.getName());
                //Fiber
                fillRowCellWithColumnName(16, Nutrient.FIBER.getName());
                //Sucrose
                fillRowCellWithColumnName(17, Nutrient.SUCROSE.getName());
                //Fructose
                fillRowCellWithColumnName(18, Nutrient.FRUCTOSE.getName());
                //Lactose
                fillRowCellWithColumnName(19, Nutrient.LACTOSE.getName());
                //Vitamin A
                fillRowCellWithColumnName(20, Nutrient.VITAMINA.getName());
                //Vitamin E
                fillRowCellWithColumnName(21, Nutrient.VITAMINE.getName());
                //Vitamin D
                fillRowCellWithColumnName(22, Nutrient.VITAMIND.getName());
                //Vitamin C
                fillRowCellWithColumnName(23, Nutrient.VITAMINC.getName());
                //Thiamin
                fillRowCellWithColumnName(24, Nutrient.THIAMIN.getName());
                //Riboflavin
                fillRowCellWithColumnName(25, Nutrient.RIBOFLAVIN.getName());
                //Niacin
                fillRowCellWithColumnName(26, Nutrient.NIACIN.getName());
                //Pantothenic
                fillRowCellWithColumnName(27, Nutrient.PANTOTHENIC.getName());
                //Vitamin B6
                fillRowCellWithColumnName(28, Nutrient.VITAMINB6.getName());
                //Vitamin B12
                fillRowCellWithColumnName(29, Nutrient.VITAMINB12.getName());
                //Choline
                fillRowCellWithColumnName(30, Nutrient.CHOLINE.getName());
                //Vitamin K
                fillRowCellWithColumnName(31, Nutrient.VITAMINK.getName());
                //Folate
                fillRowCellWithColumnName(32, Nutrient.FOLATE.getName());
                //Calcium
                fillRowCellWithColumnName(33, Nutrient.CALCIUM.getName());
                //Iron
                fillRowCellWithColumnName(34, Nutrient.IRON.getName());
                //Magnesium
                fillRowCellWithColumnName(35, Nutrient.MAGNESIUM.getName());
                //Phosphorus
                fillRowCellWithColumnName(36, Nutrient.PHOSPHORUS.getName());
                //Potassium
                fillRowCellWithColumnName(37, Nutrient.POTASSIUM.getName());
                //Sodium
                fillRowCellWithColumnName(38, Nutrient.SODIUM.getName());
                //Zinc
                fillRowCellWithColumnName(39, Nutrient.ZINC.getName());
                //Copper
                fillRowCellWithColumnName(40, Nutrient.COPPER.getName());
                //Fluoride
                fillRowCellWithColumnName(41, Nutrient.FLUORIDE.getName());
                //Manganese
                fillRowCellWithColumnName(42, Nutrient.MANGANESE.getName());
                //Selenium
                fillRowCellWithColumnName(43, Nutrient.SELENIUM.getName());
                //Alcohol
                fillRowCellWithColumnName(44, Nutrient.ALCOHOL.getName());
                //Water
                fillRowCellWithColumnName(45, Nutrient.WATER.getName());
                //Cost
                fillRowCellWithColumnName(46, "Cost ($)");
//Set nutrient values
                try {
                    LinkedList list = (LinkedList) dbLink.MixResultDW_Select(mixDataObject.getMixId(), 5);
                    Iterator iteratorFoodItems = list.iterator();
                    while (iteratorFoodItems.hasNext()) {
                        createNewRow();
                        HashMap rowm = (HashMap) iteratorFoodItems.next();
                        //Name
                        String Name = (String) rowm.get("Name");
                        //Make "Total" row bold
                        if (Name.equals("Total")) {
                            cellStyleName = cellStyleTotalName;
                            cellStyleValue = cellStyleTotalValue;
                            rownum++;
                        } else {
                            cellStyleName = cellStyleFoodItemName;
                            cellStyleValue = cellStyleFoodItemValue;
                        }
                        fillRowCellWithItemName(0, Name);
                        //Weight
                        Double Weight = (Double) rowm.get("Weight");
                        fillRowCellWithValue(Weight, 1);
                        //Energy
                        Double Energy = (Double) rowm.get("Energy");
                        fillRowCellWithValue(Energy, 2);
                        //Protein
                        Double Protein = (Double) rowm.get("Protein");
                        fillRowCellWithValue(Protein, 3);
                        //Complete
                        Double CompleteProtein = (Double) rowm.get("CompleteProtein");
                        fillRowCellWithValue(CompleteProtein, 4);
                        //Incomplete
                        Double IncompleteProtein = (Double) rowm.get("IncompleteProtein");
                        fillRowCellWithValue(IncompleteProtein, 5);
                        //Fat
                        Double Fat = (Double) rowm.get("Fat");
                        fillRowCellWithValue(Fat, 6);
                        //Monounsaturated
                        Double Monounsaturated = (Double) rowm.get("Monounsaturated");
                        fillRowCellWithValue(Monounsaturated, 7);
                        //Polyunsaturated
                        Double Polyunsaturated = (Double) rowm.get("Polyunsaturated");
                        fillRowCellWithValue(Polyunsaturated, 8);
                        //Saturated
                        Double Saturated = (Double) rowm.get("Saturated");
                        fillRowCellWithValue(Saturated, 9);
                        //Cholesterol
                        Double Cholesterol = (Double) rowm.get("Cholesterol");
                        fillRowCellWithValue(Cholesterol, 10);
                        //Linoleic
                        Double Linoleic = (Double) rowm.get("Linoleic");
                        fillRowCellWithValue(Linoleic, 11);
                        //Alpha-Linolenic
                        Double AlphaLinolenic = (Double) rowm.get("AlphaLinolenic");
                        fillRowCellWithValue(AlphaLinolenic, 12);
                        //DHA
                        Double DHA = (Double) rowm.get("DHA");
                        fillRowCellWithValue(DHA, 13);
                        //EPA
                        Double EPA = (Double) rowm.get("EPA");
                        fillRowCellWithValue(EPA, 14);
                        //Carbohydrate
                        Double DigestibleCarbohydrate = (Double) rowm.get("DigestibleCarbs");
                        fillRowCellWithValue(DigestibleCarbohydrate, 15);
                        //Fiber
                        Double Fiber = (Double) rowm.get("Fiber");
                        fillRowCellWithValue(Fiber, 16);
                        //Sucrose
                        Double Sucrose = (Double) rowm.get("Sucrose");
                        fillRowCellWithValue(Sucrose, 17);
                        //Fructose
                        Double Fructose = (Double) rowm.get("Fructose");
                        fillRowCellWithValue(Fructose, 18);
                        //Lactose
                        Double Lactose = (Double) rowm.get("Lactose");
                        fillRowCellWithValue(Lactose, 19);
                        //Vitamin A
                        Double VitaminA = (Double) rowm.get("VitaminA");
                        fillRowCellWithValue(VitaminA, 20);
                        //Vitamin E
                        Double VitaminE = (Double) rowm.get("VitaminE");
                        fillRowCellWithValue(VitaminE, 21);
                        //Vitamin D
                        Double VitaminD = (Double) rowm.get("VitaminD");
                        fillRowCellWithValue(VitaminD, 22);
                        //Vitamin C
                        Double VitaminC = (Double) rowm.get("VitaminC");
                        fillRowCellWithValue(VitaminC, 23);
                        //Thiamin
                        Double Thiamin = (Double) rowm.get("Thiamin");
                        fillRowCellWithValue(Thiamin, 24);
                        //Riboflavin
                        Double Riboflavin = (Double) rowm.get("Riboflavin");
                        fillRowCellWithValue(Riboflavin, 25);
                        //Niacin
                        Double Niacin = (Double) rowm.get("Niacin");
                        fillRowCellWithValue(Niacin, 26);
                        //Pantothenic
                        Double Pantothenic = (Double) rowm.get("Pantothenic");
                        fillRowCellWithValue(Pantothenic, 27);
                        //Vitamin B6
                        Double VitaminB6 = (Double) rowm.get("VitaminB6");
                        fillRowCellWithValue(VitaminB6, 28);
                        //Vitamin B12
                        Double VitaminB12 = (Double) rowm.get("VitaminB12");
                        fillRowCellWithValue(VitaminB12, 29);
                        //Choline
                        Double Choline = (Double) rowm.get("Choline");
                        fillRowCellWithValue(Choline, 30);
                        //Vitamin K
                        Double VitaminK = (Double) rowm.get("VitaminK");
                        fillRowCellWithValue(VitaminK, 31);
                        //Folate
                        Double Folate = (Double) rowm.get("Folate");
                        fillRowCellWithValue(Folate, 32);
                        //Calcium
                        Double Calcium = (Double) rowm.get("Calcium");
                        fillRowCellWithValue(Calcium, 33);
                        //Iron
                        Double Iron = (Double) rowm.get("Iron");
                        fillRowCellWithValue(Iron, 34);
                        //Magnesium
                        Double Magnesium = (Double) rowm.get("Magnesium");
                        fillRowCellWithValue(Magnesium, 35);
                        //Phosphorus
                        Double Phosphorus = (Double) rowm.get("Phosphorus");
                        fillRowCellWithValue(Phosphorus, 36);
                        //Potassium
                        Double Potassium = (Double) rowm.get("Potassium");
                        fillRowCellWithValue(Potassium, 37);
                        //Sodium
                        Double Sodium = (Double) rowm.get("Sodium");
                        fillRowCellWithValue(Sodium, 38);
                        //Zinc
                        Double Zinc = (Double) rowm.get("Zinc");
                        fillRowCellWithValue(Zinc, 39);
                        //Copper
                        Double Copper = (Double) rowm.get("Copper");
                        fillRowCellWithValue(Copper, 40);
                        //Fluoride
                        Double Fluoride = (Double) rowm.get("Fluoride");
                        fillRowCellWithValue(Fluoride, 41);
                        //Manganese
                        Double Manganese = (Double) rowm.get("Manganese");
                        fillRowCellWithValue(Manganese, 42);
                        //Selenium
                        Double Selenium = (Double) rowm.get("Selenium");
                        fillRowCellWithValue(Selenium, 43);
                        //Alcohol
                        Double Alcohol = (Double) rowm.get("Alcohol");
                        fillRowCellWithValue(Alcohol, 44);
                        //Water
                        Double Water = (Double) rowm.get("Water");
                        fillRowCellWithValue(Water, 45);
                        //Cost
                        Double Cost = (Double) rowm.get("Cost");
                        fillRowCellWithValue(Cost, 46);
                    }
                } catch (SQLException e) {
                    Log.getLog().start("files/exception.log");
                    Log.getLog().logMessage(e.toString());
                    Log.getLog().write();
                    Log.getLog().close();
                    e.printStackTrace();
                }
            }
            try {
                out = new FileOutputStream(filepath.toString());
                wb.write(out);
                out.close();
            } catch (Exception e) {
                Log.getLog().start("files/exception.log");
                Log.getLog().logMessage(e.toString());
                Log.getLog().write();
                Log.getLog().close();
                e.printStackTrace();
            }
            showMessage();
        } catch (SQLException e) {
            Log.getLog().start("files/exception.log");
            Log.getLog().logMessage(e.toString());
            Log.getLog().write();
            Log.getLog().close();
            e.printStackTrace();
        }
    }

    private void createNewRow() {
        row = sheet.createRow(rownum++);
    }

    private void fillRowCellWithMixName(String mixName) {
        rowCell = row.createCell(0);
        rowCell.setCellValue(mixName);
        rowCell.setCellStyle(getCellStyleMixName());
    }

    private void fillRowCellWithItemName(int i, String s) {
        rowCell = row.createCell(i);
        rowCell.setCellStyle(cellStyleName);
        rowCell.setCellValue(s);
    }

    private void fillRowCellWithColumnName(int i, String s) {
        rowCell = row.createCell(i);
        rowCell.setCellStyle(cellStyleColumnName);
        rowCell.setCellValue(s);
    }

    private void fillRowCellWithValue(Double value, int i) {
        rowCell = row.createCell(i);
        rowCell.setCellStyle(cellStyleValue);
        rowCell.setCellValue(value);
    }

    private void showMessage() {
        JComponent[] inputs = new JComponent[]{
                new JLabel("Spreadsheet is ready")
        };
        Message.showOptionDialog(inputs, "Export Food Mixes");
    }

    private CellStyle getCellStyleMixName() {
        CellStyle cellStyleMixName = wb.createCellStyle();
        cellStyleMixName.setFillPattern(FillPatternType.SPARSE_DOTS);
        cellStyleMixName.setFont(fontBold);
        return cellStyleMixName;
    }

    private CellStyle getCellStyleFoodItemName() {
        CellStyle cellStyleItemName = wb.createCellStyle();
        return cellStyleItemName;
    }

    private CellStyle getCellStyleTotalName() {
        CellStyle cellStyleTotalName = wb.createCellStyle();
        cellStyleTotalName.setBorderTop(BorderStyle.THIN);
        cellStyleTotalName.setFont(fontBold);
        return cellStyleTotalName;
    }

    private CellStyle getCellStyleColumnName() {
        CellStyle cellStyleColumnName = wb.createCellStyle();
        cellStyleColumnName.setBorderBottom(BorderStyle.THIN);
        cellStyleColumnName.setFont(fontBold);
        return cellStyleColumnName;
    }

    private CellStyle getCellStyleFoodItemValue() {
        CellStyle cellStyleFoodItemValue = wb.createCellStyle();
        cellStyleFoodItemValue.setDataFormat(cellFormat.getFormat("0;[RED]-0"));
        return cellStyleFoodItemValue;
    }

    private CellStyle getCellStyleTotalValue() {
        CellStyle cellStyleTotal = wb.createCellStyle();
        cellStyleTotal.setDataFormat(cellFormat.getFormat("0;[RED]-0"));
        cellStyleTotal.setBorderTop(BorderStyle.THIN);
        cellStyleTotal.setFont(fontBold);
        return cellStyleTotal;
    }
}
