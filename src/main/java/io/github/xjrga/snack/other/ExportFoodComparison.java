package io.github.xjrga.snack.other;

import io.github.xjrga.snack.dataobject.FoodDataObject;
import io.github.xjrga.snack.gui.Message;
import io.github.xjrga.snack.model.TableModelFoodComparison;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

public class ExportFoodComparison {

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

    public ExportFoodComparison() {
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
        dateFormat = new SimpleDateFormat( pattern );
        date = new Date();
        format = dateFormat.format( date );
        row = null;
        cell = null;
        sheetname = "Food Comparison";
        s = wb.createSheet();
        rownum = 0;
    }

    private void initializeMethods() {
        fontBold.setBold( true );
        sb.append( "food_comparison_" );
        sb.append( format );
        sb.append( ".xls" );
        filepath.append( "model/" );
        filepath.append( sb.toString() );
        wb.setSheetName( 0, sheetname );
    }

    public void print( TableModelFoodComparison modelTableFoodDiff, JList listCompareA, JList listCompareB ) {
        if( !listCompareA.isSelectionEmpty() && !listCompareB.isSelectionEmpty() ) {
            FoodDataObject food_a = ( FoodDataObject ) listCompareA.getSelectedValue();
            FoodDataObject food_b = ( FoodDataObject ) listCompareB.getSelectedValue();
            row = s.createRow( rownum++ );
            cell = row.createCell( 0 );
            StringBuilder sb1 = new StringBuilder();
            sb1.append( food_a.getFoodName() );
            sb1.append( " minus " );
            sb1.append( food_b.getFoodName() );
            cell.setCellValue( sb1.toString() );
            cell.setCellStyle( cellStyleMixName );
            row = s.createRow( rownum++ );
            cell = row.createCell( 0 );
            cell.setCellValue( "Category" );
            cell.setCellStyle( cellStyleColumnName );
            cell = row.createCell( 1 );
            cell.setCellValue( "Nutrient" );
            cell.setCellStyle( cellStyleColumnName );
            cell = row.createCell( 2 );
            cell.setCellValue( food_a.getFoodName() );
            cell.setCellStyle( cellStyleColumnName );
            cell = row.createCell( 3 );
            cell.setCellValue( food_b.getFoodName() );
            cell.setCellStyle( cellStyleColumnName );
            cell = row.createCell( 4 );
            cell.setCellValue( "Difference" );
            cell.setCellStyle( cellStyleColumnName );
        }
        for( int j = 0; j < modelTableFoodDiff.getRowCount(); j++ ) {
            row = s.createRow( rownum++ );
            cell = row.createCell( 0 );
            cell.setCellValue( ( String ) modelTableFoodDiff.getValueAt( j, 0 ) );
            cell = row.createCell( 1 );
            cell.setCellValue( ( String ) modelTableFoodDiff.getValueAt( j, 1 ) );
            cell = row.createCell( 2 );
            cell.setCellValue( ( Double ) modelTableFoodDiff.getValueAt( j, 2 ) );
            cell = row.createCell( 3 );
            cell.setCellValue( ( Double ) modelTableFoodDiff.getValueAt( j, 3 ) );
            cell = row.createCell( 4 );
            cell.setCellValue( ( Double ) modelTableFoodDiff.getValueAt( j, 4 ) );
            cell.setCellStyle( cellStyleValue );
        }
        try {
            out = new FileOutputStream( filepath.toString() );
            wb.write( out );
            out.close();
        } catch( IOException e ) {

        }
        JComponent[] inputs = new JComponent[] {
            new JLabel( "Spreadsheet is ready" )
        };
        Message.showOptionDialog( inputs, "Export Food Comparison" );
    }

    private CellStyle getCellStyleValue() {
        CellStyle cellStyleFoodItemValue = wb.createCellStyle();
        cellStyleFoodItemValue.setDataFormat( cellFormat.getFormat( "0;[RED]-0" ) );
        cellStyleFoodItemValue.setAlignment( HorizontalAlignment.RIGHT );
        return cellStyleFoodItemValue;
    }

    private CellStyle getCellStyleColumnName() {
        CellStyle cellStyleColumnName = wb.createCellStyle();
        cellStyleColumnName.setBorderBottom( BorderStyle.THIN );
        cellStyleColumnName.setFont( fontBold );
        cellStyleColumnName.setAlignment( HorizontalAlignment.RIGHT );
        return cellStyleColumnName;
    }

    private CellStyle getCellStyleMixName() {
        CellStyle cellStyleMixName = wb.createCellStyle();
        cellStyleMixName.setFillPattern( FillPatternType.SPARSE_DOTS );
        cellStyleMixName.setFont( fontBold );
        cellStyleMixName.setAlignment( HorizontalAlignment.RIGHT );
        return cellStyleMixName;
    }
}
