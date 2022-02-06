package io.github.xjrga.snack.other;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import io.github.xjrga.snack.data.DbLink;
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

public class ExportRdaCheck {

    private final DbLink dbLink;
    private Cell cell;
    private CellStyle cellStyleColumnName;
    private CellStyle cellStyleMixName;
    private CellStyle cellStyleMixValue;
    private CellStyle cellStylePctRdaValue;
    private CellStyle cellStylePctULValue;
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

    public ExportRdaCheck(DbLink dbLink) {
        this.dbLink = dbLink;
        initializeVariables();
        initializeMethods();
    }

    private void initializeVariables() {
        wb = new HSSFWorkbook();
        cell = null;
        cellFormat = wb.createDataFormat();
        fontBold = wb.createFont();
        cellStyleColumnName = getCellStyleColumnName();
        cellStyleMixName = getCellStyleMixName();
        cellStyleMixValue = getCellStyleMixValue();
        cellStylePctRdaValue = getCellStylePctRdaValue();
        cellStylePctULValue = getCellStylePctULValue();
        date = new Date();
        pattern = "yyyy-MMMMM-dd'_at_'HH-mm-ss";
        dateFormat = new SimpleDateFormat(pattern);
        filepath = new StringBuilder();
        format = dateFormat.format(date);
        row = null;
        rownum = 0;
        s = wb.createSheet();
        sb = new StringBuilder();
        sheetname = "RDA Check";
    }

    private void initializeMethods() {
        fontBold.setBold(true);
        sb.append("rda_check_");
        sb.append(format);
        sb.append(".xls");
        filepath.append("files/");
        filepath.append(sb.toString());
        wb.setSheetName(0, sheetname);
    }

    private CellStyle getCellStyleMixValue() {
        CellStyle cellStyleFoodItemValue = wb.createCellStyle();
        cellStyleFoodItemValue.setDataFormat(cellFormat.getFormat("[RED][<=0]0;0"));
        return cellStyleFoodItemValue;
    }

    private CellStyle getCellStylePctRdaValue() {
        CellStyle cellStyleFoodItemValue = wb.createCellStyle();
        cellStyleFoodItemValue.setDataFormat(cellFormat.getFormat("[RED][<100]0;0"));
        return cellStyleFoodItemValue;
    }

    private CellStyle getCellStylePctULValue() {
        CellStyle cellStyleFoodItemValue = wb.createCellStyle();
        cellStyleFoodItemValue.setDataFormat(cellFormat.getFormat("[RED][>100]0;0"));
        return cellStyleFoodItemValue;
    }

    private CellStyle getCellStyleColumnName() {
        CellStyle cellStyleColumnName = wb.createCellStyle();
        cellStyleColumnName.setBorderBottom(BorderStyle.THIN);
        cellStyleColumnName.setFont(fontBold);
        return cellStyleColumnName;
    }

    private CellStyle getCellStyleMixName() {
        CellStyle cellStyleMixName = wb.createCellStyle();
        cellStyleMixName.setFillPattern(FillPatternType.SPARSE_DOTS);
        cellStyleMixName.setFont(fontBold);
        return cellStyleMixName;
    }

    public void print(MixDataObject mixDataObject, Integer lifeStageId) {
        row = s.createRow(rownum++);
        cell = row.createCell(0);
        StringBuilder sb1 = new StringBuilder();
        sb1.append("RDA Check (");
        sb1.append(mixDataObject.getName());
        sb1.append(" )");
        cell.setCellValue(sb1.toString());
        cell.setCellStyle(cellStyleMixName);
        row = s.createRow(rownum++);
        cell = row.createCell(0);
        cell.setCellValue("Nutrient");
        cell.setCellStyle(cellStyleColumnName);
        cell = row.createCell(1);
        cell.setCellValue(mixDataObject.getName());
        cell.setCellStyle(cellStyleColumnName);
        cell = row.createCell(2);
        cell.setCellValue("RDA");
        cell.setCellStyle(cellStyleColumnName);
        cell = row.createCell(3);
        cell.setCellValue("% RDA");
        cell.setCellStyle(cellStyleColumnName);
        cell = row.createCell(4);
        cell.setCellValue("UL");
        cell.setCellStyle(cellStyleColumnName);
        cell = row.createCell(5);
        cell.setCellValue("% UL");
        cell.setCellStyle(cellStyleColumnName);
        try {
            LinkedList list = (LinkedList) dbLink.Mix_GetRdaDiff(mixDataObject.getMixId(), lifeStageId, 2);
            Iterator it = list.iterator();
            while (it.hasNext()) {
                HashMap rowm = (HashMap) it.next();
                String nutrient = (String) rowm.get("NAME");
                Double mix = (Double) rowm.get("MIX");
                Double rda = (Double) rowm.get("RDA");
                Double pctrda = (Double) rowm.get("PCTRDA");
                Double ul = (Double) rowm.get("UL");
                Double pctul = (Double) rowm.get("PCTUL");
                row = s.createRow(rownum++);
                cell = row.createCell(0);
                cell.setCellValue(nutrient);
                cell = row.createCell(1);
                cell.setCellValue(mix);
                cell.setCellStyle(cellStyleMixValue);
                cell = row.createCell(2);
                cell.setCellValue(rda);
                cell.setCellStyle(cellStyleMixValue);
                cell = row.createCell(3);
                cell.setCellValue(pctrda);
                cell.setCellStyle(cellStylePctRdaValue);
                cell = row.createCell(4);
                cell.setCellValue(ul);
                cell = row.createCell(5);
                cell.setCellValue(pctul);
                cell.setCellStyle(cellStylePctULValue);
            }
            try {
                out = new FileOutputStream(filepath.toString());
                wb.write(out);
                out.close();
            } catch (IOException e) {
            }
            JComponent[] inputs = new JComponent[]{
                new JLabel("Spreadsheet is ready")
            };
            Message.showOptionDialog(inputs, "Export RDA Check");
        } catch (SQLException e) {

//
        }
    }
}
