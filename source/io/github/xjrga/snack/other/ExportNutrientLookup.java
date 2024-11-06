package io.github.xjrga.snack.other;

import io.github.xjrga.snack.database.DbLink;
import io.github.xjrga.snack.dataobject.NutrientDataObject;
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

public class ExportNutrientLookup {
  private final DbLink dbLink;
  private Cell cell;
  private CellStyle cellStyleColumnName;
  private CellStyle cellStyleMixName;
  private CellStyle cellStyleValue;
  private DataFormat cellFormat;
  private Date date;
  private FileOutputStream out;
  private Font fontBold;
  private Font fontItalic;
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

  public ExportNutrientLookup(DbLink dbLink) {
    this.dbLink = dbLink;
    initializeVariables();
    initializeMethods();
  }

  private void initializeVariables() {
    wb = new HSSFWorkbook();
    cellFormat = wb.createDataFormat();
    cellStyleValue = getCellStyleValue();
    fontBold = wb.createFont();
    fontItalic = wb.createFont();
    cellStyleColumnName = getCellStyleColumnName();
    cellStyleMixName = getCellStyleMixName();
    filepath = new StringBuilder();
    sb = new StringBuilder();
    pattern = "yyyy-MMMMM-dd'_at_'HH-mm-ss";
    dateFormat = new SimpleDateFormat(pattern);
    date = new Date();
    format = dateFormat.format(date);
    row = null;
    cell = null;
    sheetname = "Nutrient Lookup";
    s = wb.createSheet();
    rownum = 0;
  }

  private void initializeMethods() {
    fontBold.setBold(true);
    fontItalic.setItalic(true);
    sb.append("nutrient_lookup_");
    sb.append(format);
    sb.append(".xls");
    filepath.append("models/");
    filepath.append(sb.toString());
    wb.setSheetName(0, sheetname);
  }

  private CellStyle getCellStyleValue() {
    CellStyle cellStyleFoodItemValue = wb.createCellStyle();
    cellStyleFoodItemValue.setDataFormat(cellFormat.getFormat("0;[RED]-0"));
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
    cellStyleMixName.setFont(fontItalic);
    cellStyleMixName.setAlignment(HorizontalAlignment.RIGHT);
    return cellStyleMixName;
  }

  public void print(
      JTextField textFieldNutrientLookup, JComboBox comboBoxNutrientLookupListNutrient) {
    NutrientDataObject nutrientDataObject =
        (NutrientDataObject) comboBoxNutrientLookupListNutrient.getSelectedItem();
    row = s.createRow(rownum++);
    cell = row.createCell(0);
    StringBuilder sb1 = new StringBuilder();
    sb1.append("This amount of food gives you ");
    sb1.append(textFieldNutrientLookup.getText());
    sb1.append(" of ");
    sb1.append(nutrientDataObject.getNutrdesc());
    cell.setCellValue(sb1.toString());
    cell.setCellStyle(cellStyleMixName);
    row = s.createRow(rownum++);
    cell = row.createCell(0);
    cell.setCellValue("Food");
    cell.setCellStyle(cellStyleColumnName);
    cell = row.createCell(1);
    cell.setCellValue("Weight (g)");
    cell.setCellStyle(cellStyleColumnName);
    cell = row.createCell(2);
    cell.setCellValue("Calories (kcal)");
    cell.setCellStyle(cellStyleColumnName);
    try {
      LinkedList<HashMap> list =
          (LinkedList)
              dbLink.Nutrient_Lookup_List(
                  nutrientDataObject.getNutr_no(),
                  Double.valueOf(textFieldNutrientLookup.getText()),
                  5);
      list.forEach(
          rowm -> {
            String foodname = (String) rowm.get("NAME");
            Double calories = (Double) rowm.get("CALORIES");
            Double weight = (Double) rowm.get("WEIGHT");
            row = s.createRow(rownum++);
            cell = row.createCell(0);
            cell.setCellStyle(cellStyleValue);
            cell.setCellValue(foodname);
            cell = row.createCell(1);
            cell.setCellValue(weight);
            cell.setCellStyle(cellStyleValue);
            cell = row.createCell(2);
            cell.setCellValue(calories);
            cell.setCellStyle(cellStyleValue);
          });
    } catch (SQLException e) {
    }
    try {
      out = new FileOutputStream(filepath.toString());
      wb.write(out);
      out.close();
    } catch (IOException e) {
    }
    JComponent[] inputs = new JComponent[] {new JLabel("Spreadsheet is ready")};
    Message.showOptionDialog(inputs, "Export Nutrient Lookup");
  }
}
