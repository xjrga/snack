package io.github.xjrga.snack.jcomponents;

import io.github.xjrga.snack.datamodel.TableCategoryDataModel;
import io.github.xjrga.snack.records.TableCategoryRow;
import io.github.xjrga.snack.logger.LoggerImpl;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableRowSorter;

/**
 * @author jr
 */
public class TableCategory extends JTable {

    private TableRowSorter sorter;
    private JTextField searchTextField;
    private TableCategoryDataModel dm;


    public TableCategory() {
        searchTextField = new JTextField();
        dm = new TableCategoryDataModel();
        setModel( dm );
        setSelectionMode( ListSelectionModel.SINGLE_SELECTION );
        setFillsViewportHeight( true );
        setAutoResizeMode( JTable.AUTO_RESIZE_ALL_COLUMNS );
        getTableHeader().setReorderingAllowed( false );
        sorter = new TableRowSorter<>( dm );
        setRowSorter( sorter );
        searchTextField.getDocument().addDocumentListener( new DocumentListener() {
            @Override
            public void changedUpdate( DocumentEvent e ) {
                filter();
            }


            @Override
            public void insertUpdate( DocumentEvent e ) {
                filter();
            }


            @Override
            public void removeUpdate( DocumentEvent e ) {
                filter();
            }


            private void filter() {
                RowFilter<Object, Object> rf = null;
                try {
                    List<RowFilter<Object, Object>> filters = new ArrayList<>();
                    filters.add( RowFilter.regexFilter( "(?i)" + searchTextField.getText(), 0 ) );
                    filters.add( RowFilter.regexFilter( "(?i)" + searchTextField.getText(), 1 ) );
                    rf = RowFilter.orFilter( filters );
                } catch ( java.util.regex.PatternSyntaxException e ) {
                    LoggerImpl.INSTANCE.logProblem( e );
                }
                sorter.setRowFilter( rf );
            }
        } );
        adjustColumnWidth();
    }


    @Override
    public void setValueAt( Object aValue, int row, int column ) {
        dm.setValueAt( aValue, convertRowIndexToModel( row ), convertColumnIndexToModel( column ) );
    }


    public void selectRow( int RowNo ) {
        setRowSelectionInterval( RowNo, RowNo );
    }


    public void showRow( int RowNo ) {
        Rectangle rect = getCellRect( RowNo, 0, true );
        scrollRectToVisible( rect );
    }


    public boolean isSelectionEmpty() {
        int[] rows = getSelectedRows();
        return rows.length == 0;
    }


    public boolean isEmpty() {
        return !( getRowCount() > 0 );
    }


    public TableCategoryRow getSelectedValue() {
        if ( isEmpty() ) {
            return new TableCategoryRow( "", "" );
        }
        if ( isSelectionEmpty() ) {
            return new TableCategoryRow( "", "" );
        }
        int row = getSelectedRow();
        return getRow( row );
    }


    public List<TableCategoryRow> getSelectedValues() {
        int[] selectedRows = getSelectedRows();
        ArrayList<TableCategoryRow> rows = new ArrayList<TableCategoryRow>();
        if ( getSelectedRowCount() == 0 ) {
            return rows;
        }
        for ( int i = 0; i < selectedRows.length; i++ ) {
            TableCategoryRow row = getRow( selectedRows[ i ] );
            rows.add( row );
        }
        return rows;
    }


    private TableCategoryRow getRow( int selectedRowNo ) {
        String foodid = ( String ) getValueAt( selectedRowNo, 0 );
        String foodname = ( String ) getValueAt( selectedRowNo, 1 );
        TableCategoryRow category = new TableCategoryRow( foodid, foodname );
        return category;
    }


    public JTextField getTxtSearch() {
        return searchTextField;
    }


    public void reload( List<TableCategoryRow> data ) {
        dm.clear();
        dm.reload( data );
        adjustColumnWidth();
    }


    private void adjustColumnWidth() {
        getColumnModel().getColumn( 0 ).setMinWidth( 0 );
        getColumnModel().getColumn( 0 ).setMaxWidth( 0 );
    }


    public void clear() {
        dm.clear();
    }


    @Override
    protected JTableHeader createDefaultTableHeader() {
        return new JTableHeader( columnModel ) {
            @Override
            public String getToolTipText( MouseEvent e ) {
                java.awt.Point p = e.getPoint();
                int index = columnModel.getColumnIndexAtX( p.x );
                if ( index == -1 ) {
                    return "";
                }
                int realIndex = columnModel.getColumn( index ).getModelIndex();
                return columnToolTips[ realIndex ];
            }
        };
    }


    public int find( String id ) {
        int index = 0;
        int r = this.getRowCount();
        for ( int j = 0; j < r; j++ ) {
            if ( id.equals( getValueAt( j, 0 ) ) ) {
                index = j;
            }
        }
        return index;
    }
    protected String[] columnToolTips = new String[]{ "Category Id", "Category Name" };
}
