package io.github.xjrga.snack.other;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import io.github.xjrga.snack.data.DbLink;
import io.github.xjrga.snack.data.Nutrient;
import io.github.xjrga.snack.dataobject.MixDataObject;
import io.github.xjrga.snack.gui.Message;

import javax.swing.*;
import java.io.FileOutputStream;
import java.io.IOException;
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
                //Rest of values
                for (Nutrient nutrient : Nutrient.values()) {
                    int number = nutrient.ordinal() + 1;
                    fillRowCellWithColumnName(number, nutrient.getName());
                }
                //Set nutrient values
                try {
                    LinkedList list = (LinkedList) dbLink.MixResult_Select(mixDataObject.getMixId(), 5);
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
                        //Rest of values
                        for (Nutrient nutrient : Nutrient.values()) {
                            Double value = (Double) rowm.get(nutrient.getLabel());
                            int number = nutrient.ordinal() + 1;
                            fillRowCellWithValue(value, number);
                        }
                    }
                } catch (SQLException e) {

                }
            }
            try {
                out = new FileOutputStream(filepath.toString());
                wb.write(out);
                out.close();
            } catch (IOException e) {

            }
            showMessage();
        } catch (SQLException e) {

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

    public void hello() {
        for (Nutrient nutrient : Nutrient.values()) {
            System.out.println(nutrient.getLabel());
            System.out.println(nutrient.ordinal());
        }
    }

    public static void main(String[] args) {
        DbLink dbLink = new DbLink();
        ExportFoodMixes a = new ExportFoodMixes(dbLink);
        a.hello();
    }

}
