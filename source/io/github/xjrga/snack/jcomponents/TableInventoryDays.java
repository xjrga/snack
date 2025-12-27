package io.github.xjrga.snack.jcomponents;

import io.github.xjrga.snack.logger.LoggerImpl;
import io.github.xjrga.snack.other.Reload;
import io.github.xjrga.snack.renderers.RoundDownRenderer;
import io.github.xjrga.snack.renderers.RoundUpRenderer;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableRowSorter;

/**
 * @author jr
 */
public class TableInventoryDays extends JTable {

    private TableRowSorter sorter;
    private JTextField searchField;
    private DataModel dm;

    public TableInventoryDays() {
        searchField = new JTextField();
        dm = new DataModel();
        dm.addColumn( "MixId" );
        dm.addColumn( "Mix" );
        dm.addColumn( "Days" );
        setModel( dm );
        setSelectionMode( ListSelectionModel.SINGLE_SELECTION );
        setFillsViewportHeight( true );
        setAutoResizeMode( JTable.AUTO_RESIZE_ALL_COLUMNS );
        getTableHeader().setReorderingAllowed( false );
        sorter = new TableRowSorter<>( dm );
        setRowSorter( sorter );
        searchField.getDocument().addDocumentListener( new DocumentListener() {
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
                    filters.add( RowFilter.regexFilter( "(?i)" + searchField.getText(), 1 ) );
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

    public Row getSelectedValue() {
        if ( isEmpty() ) {
            return new NullRow();
        }
        if ( isSelectionEmpty() ) {
            return new NullRow();
        }
        int row = getSelectedRow();
        return getRow( row );
    }

    public List<Row> getSelectedValues() {
        int[] selectedRows = getSelectedRows();
        ArrayList<Row> rows = new ArrayList<Row>();
        if ( getSelectedRowCount() == 0 ) {
            return rows;
        }
        for ( int i = 0; i < selectedRows.length; i++ ) {
            Row row = getRow( selectedRows[ i ] );
            rows.add( row );
        }
        return rows;
    }

    private Row getRow( int selectedRowNo ) {
        String mixid = ( String ) getValueAt( selectedRowNo, 0 );
        String mix = ( String ) getValueAt( selectedRowNo, 1 );
        BigDecimal d = ( BigDecimal ) getValueAt( selectedRowNo, 2 );
        Row row = new Row();
        row.setMixid( mixid );
        row.setMix( mix );
        row.setD( d );
        return row;
    }

    public JTextField getSearchField() {
        return searchField;
    }

    public void reload( List<List> data ) {
        dm.clear();
        dm.reload( data );
        adjustColumnWidth();
    }

    public void clear() {
        dm.clear();
    }

    private void adjustColumnWidth() {
        getColumnModel().getColumn( 0 ).setMinWidth( 0 );
        getColumnModel().getColumn( 0 ).setMaxWidth( 0 );
        getColumnModel().getColumn( 2 ).setMinWidth( 75 );
        getColumnModel().getColumn( 2 ).setMaxWidth( 75 );
    }

    public void roundUp() {
        roundQuantity( new RoundUpRenderer() );
    }

    public void roundDown() {
        roundQuantity( new RoundDownRenderer() );
    }

    private void roundQuantity( DefaultTableCellRenderer renderer ) {
        getColumnModel().getColumn( 2 ).setCellRenderer( renderer );
        revalidate();
        repaint();
    }

    public class Row {

        private String mixid;
        private String mix;
        private BigDecimal d;

        public Row() {
            mixid = null;
            mix = null;
            d = null;
        }

        public String getMixid() {
            return mixid;
        }

        public void setMixid( String mixid ) {
            this.mixid = mixid;
        }

        public String getMix() {
            return mix;
        }

        public void setMix( String mix ) {
            this.mix = mix;
        }

        public BigDecimal getD() {
            return d;
        }

        public void setD( BigDecimal d ) {
            this.d = d;
        }

        public boolean isNull() {
            return false;
        }
    }

    public class NullRow extends Row {

        public boolean isNull() {
            return true;
        }
    }

    private class DataModel extends AbstractTableModel implements Reload {

        private List<List> data;
        private List<String> columns;
        private int rowcount;

        public DataModel() {
            data = new ArrayList<List>();
            columns = new ArrayList<String>();
            setRowCount();
        }

        public void addColumn( String col ) {
            columns.add( col );
        }

        @Override
        public void addTableModelListener( TableModelListener l ) {
            super.addTableModelListener( l );
        }

        @Override
        public Class<?> getColumnClass( int c ) {
            Class columnClass = BigDecimal.class;
            switch ( c ) {
                case 0, 1 -> {
                    columnClass = String.class;
                }
            }
            return columnClass;
        }

        @Override
        public int getColumnCount() {
            return columns.size();
        }

        @Override
        public String getColumnName( int c ) {
            return columns.get( c );
        }

        @Override
        public int getRowCount() {
            return rowcount;
        }

        @Override
        public Object getValueAt( int r, int c ) {
            if ( data.isEmpty() ) {
                return "";
            }
            return data.get( r ).get( c );
        }

        @Override
        public boolean isCellEditable( int r, int c ) {
            return false;
        }

        @Override
        public void removeTableModelListener( TableModelListener l ) {
            super.removeTableModelListener( l );
        }

        @Override
        public void setValueAt( Object o, int r, int c ) {
            data.get( r ).set( c, o );
            fireTableCellUpdated( r, c );
            ;
        }

        public void reload( List<List> data ) {
            this.data = data;
            setRowCount();
            fireTableDataChanged();
        }

        @Override
        public void clear() {
            data.clear();
            setRowCount();
            fireTableDataChanged();
        }

        private void setRowCount() {
            rowcount = data.size();
        }
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
    protected String[] columnToolTips = new String[]{ "MixId", "Mix", "Days" };
}
