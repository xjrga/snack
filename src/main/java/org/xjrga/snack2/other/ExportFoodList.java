package org.xjrga.snack2.other;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.xjrga.snack2.data.DbLink;
import org.xjrga.snack2.data.Nutrient;
import org.xjrga.snack2.dataobject.FoodDetailsDataObject;
import org.xjrga.snack2.gui.Message;

import javax.swing.*;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;

public class ExportFoodList {
    private final DbLink dbLink;
    private Cell rowCell;
    private CellStyle cellStyleColumnName;
    private CellStyle cellStyleFoodItem;
    private DataFormat cellFormat;
    private Date date;
    private FileOutputStream out;
    private Font fontBold;
    private int rownum;
    private Row row;
    private Sheet s;
    private SimpleDateFormat dateFormat;
    private String format;
    private String pattern;
    private String sheetname;
    private StringBuilder filepath;
    private StringBuilder sb;
    private Workbook wb;

    public ExportFoodList(DbLink dbLink) {
        this.dbLink = dbLink;
        initializeVariables();
        initializeMethods();
    }

    private void initializeVariables() {
        wb = new HSSFWorkbook();
        rowCell = null;
        fontBold = wb.createFont();
        cellFormat = wb.createDataFormat();
        pattern = "yyyy-MMMMM-dd'_at_'HH-mm-ss";
        dateFormat = new SimpleDateFormat(pattern);
        date = new Date();
        format = dateFormat.format(date);
        sb = new StringBuilder();
        filepath = new StringBuilder();
        row = null;
        sheetname = "Food List";
        s = wb.createSheet();
        rownum = 0;
        out = null;
        cellStyleColumnName = getCellStyleColumnName();
        cellStyleFoodItem = getCellStyleFoodItem();
    }

    private void initializeMethods() {
        fontBold.setBold(true);
        sb.append("food_");
        sb.append(format);
        sb.append(".xls");
        filepath.append("files/");
        filepath.append(sb.toString());
        wb.setSheetName(0, sheetname);
    }

    public void print() {
        try {
            int rownum = 0;
            row = s.createRow(rownum++);
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
            LinkedList list = (LinkedList) dbLink.Food_Select_Details(5);
            Iterator it = list.iterator();
            Cell rowCell;
            int colnum = 0;
            while (it.hasNext()) {
                row = s.createRow(rownum++);
                FoodDetailsDataObject fooddetailsDataObject = (FoodDetailsDataObject) it.next();
                //Name
                String Name = fooddetailsDataObject.getName();
                rowCell = row.createCell(colnum++);
                rowCell.setCellStyle(cellStyleFoodItem);
                rowCell.setCellValue(Name);
                //Weight
                Double Weight = fooddetailsDataObject.getWeight();
                rowCell = row.createCell(colnum++);
                rowCell.setCellStyle(cellStyleFoodItem);
                rowCell.setCellValue(Weight);
                //Energy
                Double Energy = fooddetailsDataObject.getEnergy();
                rowCell = row.createCell(colnum++);
                rowCell.setCellStyle(cellStyleFoodItem);
                rowCell.setCellValue(Energy);
                //Protein
                Double Protein = fooddetailsDataObject.getProtein();
                rowCell = row.createCell(colnum++);
                rowCell.setCellStyle(cellStyleFoodItem);
                rowCell.setCellValue(Protein);
                //Complete
                Double CompleteProtein = fooddetailsDataObject.getCompleteProtein();
                rowCell = row.createCell(colnum++);
                rowCell.setCellStyle(cellStyleFoodItem);
                rowCell.setCellValue(CompleteProtein);
                //Incomplete
                Double IncompleteProtein = fooddetailsDataObject.getIncompleteProtein();
                rowCell = row.createCell(colnum++);
                rowCell.setCellStyle(cellStyleFoodItem);
                rowCell.setCellValue(IncompleteProtein);
                //Fat
                Double Fat = fooddetailsDataObject.getFat();
                rowCell = row.createCell(colnum++);
                rowCell.setCellStyle(cellStyleFoodItem);
                rowCell.setCellValue(Fat);
                //Monounsaturated
                Double Monounsaturated = fooddetailsDataObject.getMonounsaturated();
                rowCell = row.createCell(colnum++);
                rowCell.setCellStyle(cellStyleFoodItem);
                rowCell.setCellValue(Monounsaturated);
                //Polyunsaturated
                Double Polyunsaturated = fooddetailsDataObject.getPolyunsaturated();
                rowCell = row.createCell(colnum++);
                rowCell.setCellStyle(cellStyleFoodItem);
                rowCell.setCellValue(Polyunsaturated);
                //Saturated
                Double Saturated = fooddetailsDataObject.getSaturated();
                rowCell = row.createCell(colnum++);
                rowCell.setCellStyle(cellStyleFoodItem);
                rowCell.setCellValue(Saturated);
                //Cholesterol
                Double Cholesterol = fooddetailsDataObject.getCholesterol();
                rowCell = row.createCell(colnum++);
                rowCell.setCellStyle(cellStyleFoodItem);
                rowCell.setCellValue(Cholesterol);
                //Linoleic
                Double Linoleic = fooddetailsDataObject.getLinoleic();
                rowCell = row.createCell(colnum++);
                rowCell.setCellStyle(cellStyleFoodItem);
                rowCell.setCellValue(Linoleic);
                //Alpha-Linolenic
                Double AlphaLinolenic = fooddetailsDataObject.getAlphaLinolenic();
                rowCell = row.createCell(colnum++);
                rowCell.setCellStyle(cellStyleFoodItem);
                rowCell.setCellValue(AlphaLinolenic);
                //DHA
                Double DHA = fooddetailsDataObject.getDHA();
                rowCell = row.createCell(colnum++);
                rowCell.setCellStyle(cellStyleFoodItem);
                rowCell.setCellValue(DHA);
                //EPA
                Double EPA = fooddetailsDataObject.getEPA();
                rowCell = row.createCell(colnum++);
                rowCell.setCellStyle(cellStyleFoodItem);
                rowCell.setCellValue(EPA);
                //Carbohydrate
                Double DigestibleCarbs = fooddetailsDataObject.getDigestibleCarbohydrate();
                rowCell = row.createCell(colnum++);
                rowCell.setCellStyle(cellStyleFoodItem);
                rowCell.setCellValue(DigestibleCarbs);
                //Fiber
                Double Fiber = fooddetailsDataObject.getFiber();
                rowCell = row.createCell(colnum++);
                rowCell.setCellStyle(cellStyleFoodItem);
                rowCell.setCellValue(Fiber);
                //Sucrose
                Double Sucrose = fooddetailsDataObject.getSucrose();
                rowCell = row.createCell(colnum++);
                rowCell.setCellStyle(cellStyleFoodItem);
                rowCell.setCellValue(Sucrose);
                //Fructose
                Double Fructose = fooddetailsDataObject.getFructose();
                rowCell = row.createCell(colnum++);
                rowCell.setCellStyle(cellStyleFoodItem);
                rowCell.setCellValue(Fructose);
                //Lactose
                Double Lactose = fooddetailsDataObject.getLactose();
                rowCell = row.createCell(colnum++);
                rowCell.setCellStyle(cellStyleFoodItem);
                rowCell.setCellValue(Lactose);
                //Vitamin A
                Double VitaminA = fooddetailsDataObject.getVitaminA();
                rowCell = row.createCell(colnum++);
                rowCell.setCellStyle(cellStyleFoodItem);
                rowCell.setCellValue(VitaminA);
                //Vitamin E
                Double VitaminE = fooddetailsDataObject.getVitaminE();
                rowCell = row.createCell(colnum++);
                rowCell.setCellStyle(cellStyleFoodItem);
                rowCell.setCellValue(VitaminE);
                //Vitamin D
                Double VitaminD = fooddetailsDataObject.getVitaminD();
                rowCell = row.createCell(colnum++);
                rowCell.setCellStyle(cellStyleFoodItem);
                rowCell.setCellValue(VitaminD);
                //Vitamin C
                Double VitaminC = fooddetailsDataObject.getVitaminC();
                rowCell = row.createCell(colnum++);
                rowCell.setCellStyle(cellStyleFoodItem);
                rowCell.setCellValue(VitaminC);
                //Thiamin
                Double Thiamin = fooddetailsDataObject.getThiamin();
                rowCell = row.createCell(colnum++);
                rowCell.setCellStyle(cellStyleFoodItem);
                rowCell.setCellValue(Thiamin);
                //Riboflavin
                Double Riboflavin = fooddetailsDataObject.getRiboflavin();
                rowCell = row.createCell(colnum++);
                rowCell.setCellStyle(cellStyleFoodItem);
                rowCell.setCellValue(Riboflavin);
                //Niacin
                Double Niacin = fooddetailsDataObject.getNiacin();
                rowCell = row.createCell(colnum++);
                rowCell.setCellStyle(cellStyleFoodItem);
                rowCell.setCellValue(Niacin);
                //Pantothenic Acid
                Double Pantothenic = fooddetailsDataObject.getPantothenic();
                rowCell = row.createCell(colnum++);
                rowCell.setCellStyle(cellStyleFoodItem);
                rowCell.setCellValue(Pantothenic);
                //Vitamin B6
                Double VitaminB6 = fooddetailsDataObject.getVitaminB6();
                rowCell = row.createCell(colnum++);
                rowCell.setCellStyle(cellStyleFoodItem);
                rowCell.setCellValue(VitaminB6);
                //Vitamin B12
                Double VitaminB12 = fooddetailsDataObject.getVitaminB12();
                rowCell = row.createCell(colnum++);
                rowCell.setCellStyle(cellStyleFoodItem);
                rowCell.setCellValue(VitaminB12);
                //Choline
                Double Choline = fooddetailsDataObject.getCholine();
                rowCell = row.createCell(colnum++);
                rowCell.setCellStyle(cellStyleFoodItem);
                rowCell.setCellValue(Choline);
                //Vitamin K
                Double VitaminK = fooddetailsDataObject.getVitaminK();
                rowCell = row.createCell(colnum++);
                rowCell.setCellStyle(cellStyleFoodItem);
                rowCell.setCellValue(VitaminK);
                //Folate
                Double Folate = fooddetailsDataObject.getFolate();
                rowCell = row.createCell(colnum++);
                rowCell.setCellStyle(cellStyleFoodItem);
                rowCell.setCellValue(Folate);
                //Calcium
                Double Calcium = fooddetailsDataObject.getCalcium();
                rowCell = row.createCell(colnum++);
                rowCell.setCellStyle(cellStyleFoodItem);
                rowCell.setCellValue(Calcium);
                //Iron
                Double Iron = fooddetailsDataObject.getIron();
                rowCell = row.createCell(colnum++);
                rowCell.setCellStyle(cellStyleFoodItem);
                rowCell.setCellValue(Iron);
                //Magnesium
                Double Magnesium = fooddetailsDataObject.getMagnesium();
                rowCell = row.createCell(colnum++);
                rowCell.setCellStyle(cellStyleFoodItem);
                rowCell.setCellValue(Magnesium);
                //Phosphorus
                Double Phosphorus = fooddetailsDataObject.getPhosphorus();
                rowCell = row.createCell(colnum++);
                rowCell.setCellStyle(cellStyleFoodItem);
                rowCell.setCellValue(Phosphorus);
                //Potassium
                Double Potassium = fooddetailsDataObject.getPotassium();
                rowCell = row.createCell(colnum++);
                rowCell.setCellStyle(cellStyleFoodItem);
                rowCell.setCellValue(Potassium);
                //Sodium
                Double Sodium = fooddetailsDataObject.getSodium();
                rowCell = row.createCell(colnum++);
                rowCell.setCellStyle(cellStyleFoodItem);
                rowCell.setCellValue(Sodium);
                //Zinc
                Double Zinc = fooddetailsDataObject.getZinc();
                rowCell = row.createCell(colnum++);
                rowCell.setCellStyle(cellStyleFoodItem);
                rowCell.setCellValue(Zinc);
                //Copper
                Double Copper = fooddetailsDataObject.getCopper();
                rowCell = row.createCell(colnum++);
                rowCell.setCellStyle(cellStyleFoodItem);
                rowCell.setCellValue(Copper);
                //Fluoride
                Double Fluoride = fooddetailsDataObject.getFluoride();
                rowCell = row.createCell(colnum++);
                rowCell.setCellStyle(cellStyleFoodItem);
                rowCell.setCellValue(Fluoride);
                //Manganese
                Double Manganese = fooddetailsDataObject.getManganese();
                rowCell = row.createCell(colnum++);
                rowCell.setCellStyle(cellStyleFoodItem);
                rowCell.setCellValue(Manganese);
                //Selenium
                Double Selenium = fooddetailsDataObject.getSelenium();
                rowCell = row.createCell(colnum++);
                rowCell.setCellStyle(cellStyleFoodItem);
                rowCell.setCellValue(Selenium);
                //Alcohol
                Double Alcohol = fooddetailsDataObject.getAlcohol();
                rowCell = row.createCell(colnum++);
                rowCell.setCellStyle(cellStyleFoodItem);
                rowCell.setCellValue(Alcohol);
                //Water
                Double Water = fooddetailsDataObject.getWater();
                rowCell = row.createCell(colnum++);
                rowCell.setCellStyle(cellStyleFoodItem);
                rowCell.setCellValue(Water);
                //Cost
                Double Cost = fooddetailsDataObject.getCost();
                rowCell = row.createCell(colnum++);
                rowCell.setCellStyle(cellStyleFoodItem);
                rowCell.setCellValue(Cost);
                colnum = 0;
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
        } catch (Exception e) {
            Log.getLog().start("files/exception.log");
            Log.getLog().logMessage(e.toString());
            Log.getLog().write();
            Log.getLog().close();
            e.printStackTrace();
        }
    }

    private void showMessage() {
        JComponent[] inputs = new JComponent[]{
                new JLabel("Spreadsheet is ready")
        };
        Message.showOptionDialog(inputs, "Export Food List");
    }

    private CellStyle getCellStyleColumnName() {
        CellStyle cellStyleColumnName = wb.createCellStyle();
        cellStyleColumnName.setBorderBottom(BorderStyle.THIN);
        cellStyleColumnName.setFont(fontBold);
        return cellStyleColumnName;
    }

    private CellStyle getCellStyleFoodItem() {
        CellStyle cellStyleFoodItemValue = wb.createCellStyle();
        cellStyleFoodItemValue.setDataFormat(cellFormat.getFormat("0;[RED]-0"));
        return cellStyleFoodItemValue;
    }

    private void fillRowCellWithColumnName(int i, String s) {
        rowCell = row.createCell(i);
        rowCell.setCellStyle(cellStyleColumnName);
        rowCell.setCellValue(s);
    }
}
