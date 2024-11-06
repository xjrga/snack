package io.github.xjrga.snack.other;

import io.github.xjrga.snack.database.DbLink;
import io.github.xjrga.snack.dataobject.MixDataObject;
import io.github.xjrga.snack.gui.Message;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import javax.swing.*;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

public class ExportMealPlan {
  private final DbLink dbLink;
  private Cell cell;
  private CellStyle cellStyleColumnName;
  private CellStyle cellStyleMixName;
  private CellStyle cellStyleMixValue;
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

  public ExportMealPlan(DbLink dbLink) {
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
    date = new Date();
    pattern = "yyyy-MMMMM-dd'_at_'HH-mm-ss";
    dateFormat = new SimpleDateFormat(pattern);
    filepath = new StringBuilder();
    format = dateFormat.format(date);
    row = null;
    rownum = 0;
    s = wb.createSheet();
    sb = new StringBuilder();
    sheetname = "Meal Plan";
  }

  private void initializeMethods() {
    fontBold.setBold(true);
    sb.append("meal_plan_");
    sb.append(format);
    sb.append(".xls");
    filepath.append("models/");
    filepath.append(sb.toString());
    wb.setSheetName(0, sheetname);
  }

  private CellStyle getCellStyleMixValue() {
    CellStyle cellStyleFoodItemValue = wb.createCellStyle();
    cellStyleFoodItemValue.setDataFormat(cellFormat.getFormat("[RED][<=0]0;0"));
    cellStyleFoodItemValue.setAlignment(HorizontalAlignment.RIGHT);
    return cellStyleFoodItemValue;
  }

  private CellStyle getCellStyleColumnName() {
    CellStyle cellStyleColumnName = wb.createCellStyle();
    cellStyleColumnName.setBorderBottom(BorderStyle.THIN);
    cellStyleColumnName.setFont(fontBold);
    cellStyleColumnName.setAlignment(HorizontalAlignment.RIGHT);
    return cellStyleColumnName;
  }

  private CellStyle getCellStyleMixName() {
    CellStyle cellStyleMixName = wb.createCellStyle();
    cellStyleMixName.setFillPattern(FillPatternType.SPARSE_DOTS);
    cellStyleMixName.setFont(fontBold);
    cellStyleMixName.setAlignment(HorizontalAlignment.RIGHT);
    return cellStyleMixName;
  }

  public void print(MixDataObject mixDataObject) {
    row = s.createRow(rownum++);
    cell = row.createCell(0);
    cell.setCellValue(mixDataObject.getName());
    cell.setCellStyle(cellStyleMixName);
    cell.setCellValue(mixDataObject.getName());
    row = s.createRow(rownum++);
    cell = row.createCell(0);
    cell.setCellValue("Meal");
    cell.setCellStyle(cellStyleColumnName);
    cell = row.createCell(1);
    cell.setCellValue("Food");
    cell.setCellStyle(cellStyleColumnName);
    cell = row.createCell(2);
    cell.setCellValue("%");
    cell.setCellStyle(cellStyleColumnName);
    cell = row.createCell(3);
    cell.setCellValue("Expected");
    cell.setCellStyle(cellStyleColumnName);
    cell = row.createCell(4);
    cell.setCellValue("Actual");
    cell.setCellStyle(cellStyleColumnName);
    try {
      LinkedList<HashMap> list =
          (LinkedList) dbLink.MealFoodPortion_select_all(mixDataObject.getMixId(), 5);
      list.forEach(
          rowm -> {
            String mixid = (String) rowm.get("MIXID");
            Integer mealid = (Integer) rowm.get("MEALID");
            String foodid = (String) rowm.get("FOODID");
            String meal = (String) rowm.get("MEAL");
            String food = (String) rowm.get("FOOD");
            Double pct = (Double) rowm.get("PCT");
            Double expectedwt = (Double) rowm.get("EXPECTEDWT");
            Double actualwt = (Double) rowm.get("ACTUALWT");
            row = s.createRow(rownum++);
            cell = row.createCell(0);
            cell.setCellValue(meal);
            cell = row.createCell(1);
            cell.setCellValue(food);
            cell.setCellStyle(cellStyleMixValue);
            cell = row.createCell(2);
            cell.setCellValue(pct);
            cell.setCellStyle(cellStyleMixValue);
            cell = row.createCell(3);
            cell.setCellValue(expectedwt);
            cell.setCellStyle(cellStyleMixValue);
            cell = row.createCell(4);
            cell.setCellValue(actualwt);
          });
      try {
        out = new FileOutputStream(filepath.toString());
        wb.write(out);
        out.close();
      } catch (IOException e) {
      }
      JComponent[] inputs = new JComponent[] {new JLabel("Spreadsheet is ready")};
      Message.showOptionDialog(inputs, "Export Meal Plan");
    } catch (SQLException e) {
      //
    }
  }
}
