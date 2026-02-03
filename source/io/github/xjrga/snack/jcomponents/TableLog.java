package io.github.xjrga.snack.jcomponents;

import io.github.xjrga.snack.logger.LoggerImpl;
import io.github.xjrga.snack.other.Reload;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
public class TableLog extends JTable {

    private TableRowSorter sorter;
    private JTextField searchField;
    private DataModel dm;


    public TableLog() {
        searchField = new JTextField();
        dm = new DataModel();
        dm.addColumn( "Timestamp" );
        dm.addColumn( "Mix" );
        dm.addColumn( "Action" );
        dm.addColumn( "Type" );
        dm.addColumn( "Object" );
        dm.addColumn( "MixId" );
        dm.addColumn( "FoodIdA" );
        dm.addColumn( "NutrientIdA" );
        dm.addColumn( "FoodIdB" );
        dm.addColumn( "NutrientIdB" );
        dm.addColumn( "RelationshipId" );
        dm.addColumn( "A" );
        dm.addColumn( "B" );
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
                    filters.add( RowFilter.regexFilter( "(?i)" + searchField.getText(), 0 ) );
                    filters.add( RowFilter.regexFilter( "(?i)" + searchField.getText(), 1 ) );
                    filters.add( RowFilter.regexFilter( "(?i)" + searchField.getText(), 2 ) );
                    filters.add( RowFilter.regexFilter( "(?i)" + searchField.getText(), 3 ) );
                    filters.add( RowFilter.regexFilter( "(?i)" + searchField.getText(), 4 ) );
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
    public boolean isCellEditable( int row, int col ) {
        return true;
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
        String fnow = ( String ) getValueAt( selectedRowNo, 0 );
        String mix = ( String ) getValueAt( selectedRowNo, 1 );
        String action = ( String ) getValueAt( selectedRowNo, 2 );
        String type = ( String ) getValueAt( selectedRowNo, 3 );
        String object = ( String ) getValueAt( selectedRowNo, 4 );
        String mixid = ( String ) getValueAt( selectedRowNo, 5 );
        String foodidA = ( String ) getValueAt( selectedRowNo, 6 );
        String nutrientidA = ( String ) getValueAt( selectedRowNo, 7 );
        String foodidB = ( String ) getValueAt( selectedRowNo, 8 );
        String nutrientidB = ( String ) getValueAt( selectedRowNo, 9 );
        Integer relationshipid = ( Integer ) getValueAt( selectedRowNo, 10 );
        BigDecimal A = ( BigDecimal ) getValueAt( selectedRowNo, 11 );
        BigDecimal B = ( BigDecimal ) getValueAt( selectedRowNo, 12 );
        Row row = new Row();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern( "MM-dd-yyyy HH:mm:ss" );
        LocalDateTime timestamp = LocalDateTime.parse( fnow, formatter );
        row.setTimestamp( timestamp );
        row.setMix( mix );
        row.setAction( action );
        row.setType( type );
        row.setObject( object );
        row.setMixid( mixid );
        row.setFoodidA( foodidA );
        row.setNutrientidA( nutrientidA );
        row.setFoodidB( foodidB );
        row.setNutrientidB( nutrientidB );
        row.setRelationshipid( relationshipid );
        row.setA( A );
        row.setB( B );
        return row;
    }


    public void addRow( List row ) {
        dm.addRow( row );
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
        getColumnModel().getColumn( 0 ).setMinWidth( 140 );
        getColumnModel().getColumn( 0 ).setMaxWidth( 140 );
        getColumnModel().getColumn( 4 ).setPreferredWidth( 1000 );
        getColumnModel().getColumn( 5 ).setMinWidth( 0 );
        getColumnModel().getColumn( 5 ).setMaxWidth( 0 );
        getColumnModel().getColumn( 6 ).setMinWidth( 0 );
        getColumnModel().getColumn( 6 ).setMaxWidth( 0 );
        getColumnModel().getColumn( 7 ).setMinWidth( 0 );
        getColumnModel().getColumn( 7 ).setMaxWidth( 0 );
        getColumnModel().getColumn( 8 ).setMinWidth( 0 );
        getColumnModel().getColumn( 8 ).setMaxWidth( 0 );
        getColumnModel().getColumn( 9 ).setMinWidth( 0 );
        getColumnModel().getColumn( 9 ).setMaxWidth( 0 );
        getColumnModel().getColumn( 10 ).setMinWidth( 0 );
        getColumnModel().getColumn( 10 ).setMaxWidth( 0 );
        getColumnModel().getColumn( 11 ).setMinWidth( 0 );
        getColumnModel().getColumn( 11 ).setMaxWidth( 0 );
        getColumnModel().getColumn( 12 ).setMinWidth( 0 );
        getColumnModel().getColumn( 12 ).setMaxWidth( 0 );
    }

    public class Row {

        private LocalDateTime timestamp;
        private String mix;
        private String action;
        private String type;
        private String object;
        private String mixid;
        private String foodidA;
        private String nutrientidA;
        private String foodidB;
        private String nutrientidB;
        private Integer relationshipid;
        private BigDecimal A;
        private BigDecimal B;


        public Row() {
            timestamp = LocalDateTime.now();
            mix = "";
            action = "";
            type = "";
            object = "";
            mixid = "";
            foodidA = "";
            nutrientidA = "";
            foodidB = "";
            nutrientidB = "";
            relationshipid = -1;
            A = new BigDecimal( "0.0" );
            B = new BigDecimal( "0.0" );
        }


        public LocalDateTime getTimestamp() {
            return timestamp;
        }


        public void setTimestamp( LocalDateTime timestamp ) {
            this.timestamp = timestamp;
        }


        public String getMix() {
            return mix;
        }


        public void setMix( String mixname ) {
            this.mix = mixname;
        }


        public String getAction() {
            return action;
        }


        public void setAction( String action ) {
            this.action = action;
        }


        public String getType() {
            return type;
        }


        public void setType( String type ) {
            this.type = type;
        }


        public String getObject() {
            return object;
        }


        public void setObject( String object ) {
            this.object = object;
        }


        public String getMixid() {
            return mixid;
        }


        public void setMixid( String mixid ) {
            this.mixid = mixid;
        }


        public String getFoodidA() {
            return foodidA;
        }


        public void setFoodidA( String foodidA ) {
            this.foodidA = foodidA;
        }


        public String getNutrientidA() {
            return nutrientidA;
        }


        public void setNutrientidA( String nutrientidA ) {
            this.nutrientidA = nutrientidA;
        }


        public String getFoodidB() {
            return foodidB;
        }


        public void setFoodidB( String foodidB ) {
            this.foodidB = foodidB;
        }


        public String getNutrientidB() {
            return nutrientidB;
        }


        public void setNutrientidB( String nutrientidB ) {
            this.nutrientidB = nutrientidB;
        }


        public Integer getRelationshipid() {
            return relationshipid;
        }


        public void setRelationshipid( Integer relationshipid ) {
            this.relationshipid = relationshipid;
        }


        public BigDecimal getA() {
            return A;
        }


        public void setA( BigDecimal A ) {
            this.A = A;
        }


        public BigDecimal getB() {
            return B;
        }


        public void setB( BigDecimal B ) {
            this.B = B;
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

    private class DataModel extends AbstractTableModel implements Reload {

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
            Class columnClass = String.class;
            switch ( c ) {
                case 0 -> {
                    columnClass = LocalDateTime.class;
                }
                case 10 -> {
                    columnClass = Integer.class;
                }
                case 11, 12 -> {
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
        }


        public void addRow( List row ) {
            data.add( row );
            setRowCount();
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
    protected String[] columnToolTips = new String[]{
        "Timestamp",
        "Mix",
        "Action",
        "Type",
        "Object",
        "MixId",
        "FoodIdA",
        "NutrientIdA",
        "FoodIdB",
        "NutrientIdB",
        "RelationshipId",
        "A",
        "B"
    };
}
