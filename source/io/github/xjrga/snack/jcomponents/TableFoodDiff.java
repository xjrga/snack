package io.github.xjrga.snack.jcomponents;

import io.github.xjrga.snack.logger.LoggerImpl;
import io.github.xjrga.snack.other.Reload;
import io.github.xjrga.snack.renderers.RoundDownRenderer;
import io.github.xjrga.snack.renderers.RoundDownRendererNE;
import io.github.xjrga.snack.renderers.RoundUpRenderer;
import io.github.xjrga.snack.renderers.RoundUpRendererNE;
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
import javax.swing.table.JTableHeader;
import javax.swing.table.TableRowSorter;

/**
 * @author jr
 */
public class TableFoodDiff extends JTable {

    private TableRowSorter sorter;
    private JTextField searchField;
    private DataModel dm;


    public TableFoodDiff() {
        searchField = new JTextField();
        dm = new DataModel();
        dm.addColumn( "Category" );
        dm.addColumn( "Nutrient" );
        dm.addColumn( "Food A" );
        dm.addColumn( "Food B" );
        dm.addColumn( "Diff" );
        setModel( dm );
        setSelectionMode( ListSelectionModel.SINGLE_SELECTION );
        setFillsViewportHeight( true );
        setAutoResizeMode( JTable.AUTO_RESIZE_OFF );
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


    public boolean isSelectionEmpty() {
        int[] rows = getSelectedRows();
        return rows.length == 0;
    }


    public boolean isEmpty() {
        return !( getRowCount() > 0 );
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


    public Row getSelectedValue() {
        if ( isEmpty() ) {
            return new NullRow();
        }
        if ( isSelectionEmpty() ) {
            return new NullRow();
        }
        return getRow( getSelectedRow() );
    }


    public List<Row> getSelectedValues() {
        ArrayList<Row> results = new ArrayList<Row>();
        if ( isSelectionEmpty() ) {
            return results;
        }
        int[] rows = this.getSelectedRows();
        for ( int i = 0; i < rows.length; i++ ) {
            Row foodfacts = getRow( i );
            results.add( foodfacts );
        }
        return results;
    }


    private Row getRow( int selectedRowNo ) {
        String category = ( String ) getValueAt( selectedRowNo, 0 );
        String nutrient = ( String ) getValueAt( selectedRowNo, 1 );
        BigDecimal foodaq = ( BigDecimal ) getValueAt( selectedRowNo, 2 );
        BigDecimal foodbq = ( BigDecimal ) getValueAt( selectedRowNo, 3 );
        BigDecimal diff = ( BigDecimal ) getValueAt( selectedRowNo, 4 );
        Row row = new Row();
        row.setCategory( category );
        row.setNutrient( nutrient );
        row.setFoodaq( foodaq );
        row.setFoodbq( foodbq );
        row.setDiff( diff );
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
        getColumnModel().getColumn( 0 ).setPreferredWidth( 120 );
        getColumnModel().getColumn( 1 ).setPreferredWidth( 300 );
        for ( int i = 2; i < 5; i++ ) {
            getColumnModel().getColumn( i ).setPreferredWidth( 75 );
        }
    }


    public int find( String id ) {
        int index = 0;
        int r = this.getRowCount();
        for ( int j = 0; j < r; j++ ) {
            if ( id.equals( getValueAt( j, 1 ) ) ) {
                index = j;
            }
        }
        return index;
    }


    public void roundUp() {
        RoundUpRenderer renderer = new RoundUpRenderer();
        getColumnModel().getColumn( 2 ).setCellRenderer( renderer );
        getColumnModel().getColumn( 3 ).setCellRenderer( renderer );
        getColumnModel().getColumn( 4 ).setCellRenderer( new RoundUpRendererNE() );
        revalidate();
        repaint();
    }


    public void roundDown() {
        RoundDownRenderer renderer = new RoundDownRenderer();
        getColumnModel().getColumn( 2 ).setCellRenderer( renderer );
        getColumnModel().getColumn( 3 ).setCellRenderer( renderer );
        getColumnModel().getColumn( 4 ).setCellRenderer( new RoundDownRendererNE() );
        revalidate();
        repaint();
    }

    public class Row {

        private String category;
        private String nutrient;
        private BigDecimal foodaq;
        private BigDecimal foodbq;
        private BigDecimal diff;


        public Row() {
            category = "";
            nutrient = "";
            foodaq = new BigDecimal( "0.0" );
            foodbq = new BigDecimal( "0.0" );
            diff = new BigDecimal( "0.0" );
        }


        public String getCategory() {
            return category;
        }


        public void setCategory( String category ) {
            this.category = category;
        }


        public String getNutrient() {
            return nutrient;
        }


        public void setNutrient( String nutrient ) {
            this.nutrient = nutrient;
        }


        public BigDecimal getFoodaq() {
            return foodaq;
        }


        public void setFoodaq( BigDecimal foodaq ) {
            this.foodaq = foodaq;
        }


        public BigDecimal getFoodbq() {
            return foodbq;
        }


        public void setFoodbq( BigDecimal foodbq ) {
            this.foodbq = foodbq;
        }


        public BigDecimal getDiff() {
            return diff;
        }


        public void setDiff( BigDecimal diff ) {
            this.diff = diff;
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
            fireTableDataChanged();
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
    protected String[] columnToolTips
            = new String[]{ "Food Category", "Nutrient", "Food A", "Food B", "Nutrient Amount Difference" };
}
