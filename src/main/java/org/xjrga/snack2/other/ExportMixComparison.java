package io.github.xjrga.snack2.other;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import io.github.xjrga.snack2.data.DbLink;
import io.github.xjrga.snack2.dataobject.MixDataObject;
import io.github.xjrga.snack2.gui.Message;
import io.github.xjrga.snack2.model.TableModelMixComparison;

import javax.swing.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExportMixComparison {
    private final DbLink dbLink;
    private Cell cell;
    private CellStyle cellStyleColumnName;
    private CellStyle cellStyleMixName;
    private CellStyle cellStyleValue;
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

    public ExportMixComparison(DbLink dbLink) {
        this.dbLink = dbLink;
        initializeVariables();
        initializeMethods();
    }

    private void initializeVariables() {
        wb = new HSSFWorkbook();
        cellFormat = wb.createDataFormat();
        cellStyleValue = getCellStyleValue();
        fontBold = wb.createFont();
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
        sheetname = "Mix Comparison";
        s = wb.createSheet();
        rownum = 0;
    }

    private void initializeMethods() {
        fontBold.setBold(true);
        sb.append("mix_comparison_");
        sb.append(format);
        sb.append(".xls");
        filepath.append("files/");
        filepath.append(sb.toString());
        wb.setSheetName(0, sheetname);
    }

    public void print(TableModelMixComparison modelTableMixDiff, JList listCompareA, JList listCompareB) {
        if (!listCompareA.isSelectionEmpty() && !listCompareB.isSelectionEmpty()) {
            MixDataObject mix1 = (MixDataObject) listCompareA.getSelectedValue();
            MixDataObject mix2 = (MixDataObject) listCompareB.getSelectedValue();
            row = s.createRow(rownum++);
            cell = row.createCell(0);
            StringBuilder sb1 = new StringBuilder();
            sb1.append(mix1.getName());
            sb1.append(" minus ");
            sb1.append(mix2.getName());
            cell.setCellValue(sb1.toString());
            cell.setCellStyle(cellStyleMixName);
            row = s.createRow(rownum++);
            cell = row.createCell(0);
            cell.setCellValue("Nutrient");
            cell.setCellStyle(cellStyleColumnName);
            cell = row.createCell(1);
            cell.setCellValue(mix1.getName());
            cell.setCellStyle(cellStyleColumnName);
            cell = row.createCell(2);
            cell.setCellValue(mix2.getName());
            cell.setCellStyle(cellStyleColumnName);
            cell = row.createCell(3);
            cell.setCellValue("Difference");
            cell.setCellStyle(cellStyleColumnName);
        }
        for (int j = 0; j < modelTableMixDiff.getRowCount(); j++) {
            row = s.createRow(rownum++);
            cell = row.createCell(0);
            cell.setCellValue((String) modelTableMixDiff.getValueAt(j, 0));
            cell = row.createCell(1);
            cell.setCellValue((Double) modelTableMixDiff.getValueAt(j, 1));
            cell = row.createCell(2);
            cell.setCellValue((Double) modelTableMixDiff.getValueAt(j, 2));
            cell = row.createCell(3);
            cell.setCellValue((Double) modelTableMixDiff.getValueAt(j, 3));
            cell.setCellStyle(cellStyleValue);
        }
        try {
            out = new FileOutputStream(filepath.toString());
            wb.write(out);
            out.close();
        } catch (IOException e) {
            Log.getLog().start("files/exception.log");
            Log.getLog().logMessage(e.toString());
            Log.getLog().write();
            Log.getLog().close();
            e.printStackTrace();
        }
        JComponent[] inputs = new JComponent[]{
                new JLabel("Spreadsheet is ready")
        };
        Message.showOptionDialog(inputs, "Export Mix Comparison");
    }

    private CellStyle getCellStyleValue() {
        CellStyle cellStyleFoodItemValue = wb.createCellStyle();
        cellStyleFoodItemValue.setDataFormat(cellFormat.getFormat("0;[RED]-0"));
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
}
