package io.github.xjrga.snack.jcomponents;

import io.github.xjrga.snack.logger.LoggerImpl;
import io.github.xjrga.snack.other.Reload;
import io.github.xjrga.snack.renderers.RoundDownRenderer;
import io.github.xjrga.snack.renderers.RoundUpRenderer;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.event.ChangeEvent;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableRowSorter;

/**
 * @author jr
 */
public class TableFoodFactInput extends JTable {

    private JTextField txtNutrientValueDisplay;
    private TableRowSorter sorter;
    private JTextField txtSearch;
    private final DataModel dm;

    public TableFoodFactInput() {
        txtSearch = new JTextField();
        dm = new DataModel();
        dm.addColumn( "NutrientId" );
        dm.addColumn( "Category" );
        dm.addColumn( "Nutrient" );
        dm.addColumn( "Weight" );
        setModel( dm );
        setSelectionMode( ListSelectionModel.SINGLE_SELECTION );
        setFillsViewportHeight( true );
        setAutoResizeMode( JTable.AUTO_RESIZE_ALL_COLUMNS );
        getTableHeader().setReorderingAllowed( false );
        sorter = new TableRowSorter<>( dm );
        setRowSorter( sorter );
        txtSearch.getDocument().addDocumentListener( new DocumentListener() {
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
                    filters.add( RowFilter.regexFilter( "(?i)" + txtSearch.getText(), 1 ) );
                    filters.add( RowFilter.regexFilter( "(?i)" + txtSearch.getText(), 2 ) );
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
        ArrayList<Row> foods = new ArrayList<>();
        if ( isSelectionEmpty() ) {
            return foods;
        }
        int[] rows = this.getSelectedRows();
        for ( int i = 0; i < rows.length; i++ ) {
            Row food = getRow( i );
            foods.add( food );
        }
        return foods;
    }

    private Row getRow( int selectedRowNo ) {
        String nutrientid = ( String ) getValueAt( selectedRowNo, 0 );
        String category = ( String ) getValueAt( selectedRowNo, 1 );
        String nutrient = ( String ) getValueAt( selectedRowNo, 2 );
        String weight = ( String ) getValueAt( selectedRowNo, 3 );
        Row foodfact = new Row();
        foodfact.setNutrientid( nutrientid );
        foodfact.setCategory( category );
        foodfact.setNutrient( nutrient );
        foodfact.setWeight( weight );
        return foodfact;
    }

    public JTextField getTxtSearch() {
        return txtSearch;
    }

    public void reload( List<List> data ) {
        dm.clear();
        dm.reload( data );
        adjustColumnWidth();
    }

    public void clear() {
        dm.clear();
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

    private void adjustColumnWidth() {
        getColumnModel().getColumn( 0 ).setMinWidth( 0 );
        getColumnModel().getColumn( 0 ).setMaxWidth( 0 );
        getColumnModel().getColumn( 1 ).setMinWidth( 150 );
        getColumnModel().getColumn( 2 ).setMinWidth( 300 );
    }

    public void roundUp() {
        getColumnModel().getColumn( 3 ).setCellRenderer( new RoundUpRenderer() );
        revalidate();
        repaint();
    }

    public void roundDown() {
        getColumnModel().getColumn( 3 ).setCellRenderer( new RoundDownRenderer() );
        revalidate();
        repaint();
    }

    @Override
    public void editingStopped( ChangeEvent e ) {
        String nutrientValue
                = ( new DecimalFormat( "###0.0" ) ).format( getCellEditor().getCellEditorValue() );
        txtNutrientValueDisplay.setText( nutrientValue );
        super.editingStopped( e );
    }

    public void updateNutrientValue( JTextField txtfld ) {
        txtNutrientValueDisplay = txtfld;
    }

    public class Row {

        private String nutrientid;
        private String category;
        private String nutrient;
        private String weight;

        public Row() {
        }

        public String getNutrientid() {
            return nutrientid;
        }

        public void setNutrientid( String nutrientid ) {
            this.nutrientid = nutrientid;
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

        public String getWeight() {
            return weight;
        }

        public void setWeight( String weight ) {
            this.weight = weight;
        }

        public boolean isNull() {
            return false;
        }
    }

    public class NullRow extends Row {

        @Override
        public boolean isNull() {
            return true;
        }
    }

    public class DataModel extends AbstractTableModel implements Reload {

        private List<List> data;
        private final List<String> columns;
        private int rowcount;

        public DataModel() {
            data = new ArrayList<>();
            columns = new ArrayList<>();
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
            Class returnValue = String.class;
            if ( c == 3 ) {
                returnValue = BigDecimal.class;
            }
            return returnValue;
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
            return true;
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

        @Override
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
    protected String[] columnToolTips = new String[]{ "NutrientId", "Category", "Nutrient", "Weight" };
}
