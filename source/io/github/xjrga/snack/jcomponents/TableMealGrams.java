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
public class TableMealGrams extends JTable {

    private TableRowSorter sorter;
    private JTextField searchField;
    private DataModel dm;

    public TableMealGrams() {
        searchField = new JTextField();
        dm = new DataModel();
        dm.addColumn( "Meal" );
        dm.addColumn( "Weight" );
        dm.addColumn( "Fat" );
        dm.addColumn( "Carbs" );
        dm.addColumn( "Protein" );
        dm.addColumn( "Complete" );
        dm.addColumn( "Alcohol" );
        dm.addColumn( "Fiber" );
        dm.addColumn( "Sodium" );
        dm.addColumn( "Potassium" );
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
                    filters.add( RowFilter.regexFilter( "(?i)" + searchField.getText(), 0 ) );
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
        String meal = ( String ) getValueAt( selectedRowNo, 0 );
        BigDecimal weight = ( BigDecimal ) getValueAt( selectedRowNo, 1 );
        BigDecimal fat = ( BigDecimal ) getValueAt( selectedRowNo, 2 );
        BigDecimal carbs = ( BigDecimal ) getValueAt( selectedRowNo, 3 );
        BigDecimal protein = ( BigDecimal ) getValueAt( selectedRowNo, 4 );
        BigDecimal complete = ( BigDecimal ) getValueAt( selectedRowNo, 5 );
        BigDecimal alcohol = ( BigDecimal ) getValueAt( selectedRowNo, 6 );
        BigDecimal fiber = ( BigDecimal ) getValueAt( selectedRowNo, 7 );
        BigDecimal sodium = ( BigDecimal ) getValueAt( selectedRowNo, 8 );
        BigDecimal potassium = ( BigDecimal ) getValueAt( selectedRowNo, 9 );
        Row row = new Row();
        row.setMeal( meal );
        row.setWeight( weight );
        row.setFat( fat );
        row.setCarbs( carbs );
        row.setProtein( protein );
        row.setComplete( complete );
        row.setAlcohol( alcohol );
        row.setFiber( fiber );
        row.setSodium( sodium );
        row.setPotassium( potassium );
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
        getColumnModel().getColumn( 0 ).setMinWidth( 200 );
    }

    public void roundUp() {
        roundQuantity( new RoundUpRenderer() );
    }

    public void roundDown() {
        roundQuantity( new RoundDownRenderer() );
    }

    private void roundQuantity( DefaultTableCellRenderer renderer ) {
        getColumnModel().getColumn( 1 ).setCellRenderer( renderer );
        getColumnModel().getColumn( 2 ).setCellRenderer( renderer );
        getColumnModel().getColumn( 3 ).setCellRenderer( renderer );
        getColumnModel().getColumn( 4 ).setCellRenderer( renderer );
        getColumnModel().getColumn( 5 ).setCellRenderer( renderer );
        getColumnModel().getColumn( 6 ).setCellRenderer( renderer );
        getColumnModel().getColumn( 7 ).setCellRenderer( renderer );
        getColumnModel().getColumn( 8 ).setCellRenderer( renderer );
        getColumnModel().getColumn( 9 ).setCellRenderer( renderer );
        revalidate();
        repaint();
    }

    public class Row {

        private String meal;
        private BigDecimal weight;
        private BigDecimal fat;
        private BigDecimal carbs;
        private BigDecimal protein;
        private BigDecimal complete;
        private BigDecimal alcohol;
        private BigDecimal fiber;
        private BigDecimal sodium;
        private BigDecimal potassium;

        public Row() {
            meal = null;
            weight = null;
            fat = null;
            carbs = null;
            protein = null;
            complete = null;
            alcohol = null;
            fiber = null;
            sodium = null;
            potassium = null;
        }

        public String getMeal() {
            return meal;
        }

        public void setMeal( String meal ) {
            this.meal = meal;
        }

        public BigDecimal getWeight() {
            return weight;
        }

        public void setWeight( BigDecimal weight ) {
            this.weight = weight;
        }

        public BigDecimal getFat() {
            return fat;
        }

        public void setFat( BigDecimal fat ) {
            this.fat = fat;
        }

        public BigDecimal getCarbs() {
            return carbs;
        }

        public void setCarbs( BigDecimal carbs ) {
            this.carbs = carbs;
        }

        public BigDecimal getProtein() {
            return protein;
        }

        public void setProtein( BigDecimal protein ) {
            this.protein = protein;
        }

        public BigDecimal getComplete() {
            return complete;
        }

        public void setComplete( BigDecimal complete ) {
            this.complete = complete;
        }

        public BigDecimal getAlcohol() {
            return alcohol;
        }

        public void setAlcohol( BigDecimal alcohol ) {
            this.alcohol = alcohol;
        }

        public BigDecimal getFiber() {
            return fiber;
        }

        public void setFiber( BigDecimal fiber ) {
            this.fiber = fiber;
        }

        public BigDecimal getSodium() {
            return sodium;
        }

        public void setSodium( BigDecimal sodium ) {
            this.sodium = sodium;
        }

        public BigDecimal getPotassium() {
            return potassium;
        }

        public void setPotassium( BigDecimal potassium ) {
            this.potassium = potassium;
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
                case 0 -> {
                    columnClass = String.class;
                }
                case 1 -> {
                    columnClass = BigDecimal.class;
                }
                case 2 -> {
                    columnClass = BigDecimal.class;
                }
                case 3 -> {
                    columnClass = BigDecimal.class;
                }
                case 4 -> {
                    columnClass = BigDecimal.class;
                }
                case 5 -> {
                    columnClass = BigDecimal.class;
                }
                case 6 -> {
                    columnClass = BigDecimal.class;
                }
                case 7 -> {
                    columnClass = BigDecimal.class;
                }
                case 8 -> {
                    columnClass = BigDecimal.class;
                }
                case 9 -> {
                    columnClass = BigDecimal.class;
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
    protected String[] columnToolTips = new String[]{
        "Meal", "Weight", "Fat", "Carbs", "Protein", "Complete", "Alcohol", "Fiber", "Sodium", "Potassium"
    };
}
