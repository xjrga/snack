package io.github.xjrga.snack.other;

import io.github.xjrga.snack.data.DbLink;
import io.github.xjrga.snack.data.Nutrient;
import io.github.xjrga.snack.gui.Message;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import javax.swing.*;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

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
    private Sheet sheet;
    private SimpleDateFormat dateFormat;
    private String format;
    private String pattern;
    private String sheetname;
    private StringBuilder filepath;
    private StringBuilder sb;
    private Workbook wb;

    public ExportFoodList( DbLink dbLink ) {
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
        dateFormat = new SimpleDateFormat( pattern );
        date = new Date();
        format = dateFormat.format( date );
        sb = new StringBuilder();
        filepath = new StringBuilder();
        row = null;
        sheetname = "Food List";
        sheet = wb.createSheet();
        rownum = 0;
        out = null;
        cellStyleColumnName = getCellStyleColumnName();
        cellStyleFoodItem = getCellStyleFoodItem();
    }

    private void initializeMethods() {
        fontBold.setBold( true );
        sb.append( "food_" );
        sb.append( format );
        sb.append( ".xls" );
        filepath.append( "model/" );
        filepath.append( sb.toString() );
        wb.setSheetName( 0, sheetname );
    }

    public void print() {
        try {
            //Name
            createNewRow();
            fillRowCellWithColumnName( 0, "Name" );
            //Rest of values
            for( Nutrient nutrient : Nutrient.values() ) {
                int number = nutrient.ordinal() + 1;
                fillRowCellWithColumnName( number, nutrient.getName() );
            }
            LinkedList list = ( LinkedList ) dbLink.Food_Select_Details( 5 );
            Iterator it = list.iterator();
            while( it.hasNext() ) {
                HashMap rowm = ( HashMap ) it.next();
                String Name = ( String ) rowm.get( "Name" );
                createNewRow();
                fillRowCellWithFoodValue( Name, 0 );
                //Rest of values
                for( Nutrient nutrient : Nutrient.values() ) {
                    Double value = ( Double ) rowm.get( nutrient.getLabel() );
                    int number = nutrient.ordinal() + 1;
                    fillRowCellWithFoodValue( value, number );
                }
            }
            try {
                out = new FileOutputStream( filepath.toString() );
                wb.write( out );
                out.close();
            } catch( IOException e ) {

            }
            showMessage();
        } catch( SQLException e ) {

        }
    }

    private void showMessage() {
        JComponent[] inputs = new JComponent[] {
            new JLabel( "Spreadsheet is ready" )
        };
        Message.showOptionDialog( inputs, "Export Food List" );
    }

    private void createNewRow() {
        row = sheet.createRow( rownum++ );
    }

    private CellStyle getCellStyleColumnName() {
        CellStyle cellStyleColumnName = wb.createCellStyle();
        cellStyleColumnName.setBorderBottom( BorderStyle.THIN );
        cellStyleColumnName.setFont( fontBold );
        cellStyleColumnName.setAlignment( HorizontalAlignment.RIGHT );
        return cellStyleColumnName;
    }

    private void fillRowCellWithColumnName( int i, String s ) {
        rowCell = row.createCell( i );
        rowCell.setCellStyle( cellStyleColumnName );
        rowCell.setCellValue( s );
    }

    private CellStyle getCellStyleFoodItem() {
        CellStyle cellStyleFoodItemValue = wb.createCellStyle();
        cellStyleFoodItemValue.setDataFormat( cellFormat.getFormat( "0;[RED]-0" ) );
        cellStyleFoodItemValue.setAlignment( HorizontalAlignment.RIGHT );
        return cellStyleFoodItemValue;
    }

    private void fillRowCellWithFoodValue( Double value, int i ) {
        rowCell = row.createCell( i );
        rowCell.setCellStyle( cellStyleFoodItem );
        rowCell.setCellValue( value );
    }

    private void fillRowCellWithFoodValue( String value, int i ) {
        rowCell = row.createCell( i );
        rowCell.setCellStyle( cellStyleFoodItem );
        rowCell.setCellValue( value );
    }
}
