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
import java.util.stream.Stream;
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
public class TableNutrientRatioConstraint extends JTable {

	private TableRowSorter sorter;
	private JTextField searchField;
	private DataModel dm;

	public TableNutrientRatioConstraint() {

		searchField = new JTextField();
		dm = new DataModel();
		dm.addColumn( "MixId" );
		dm.addColumn( "NutrientIdA" );
		dm.addColumn( "NutrientIdB" );
		dm.addColumn( "RelationshipId" );
		dm.addColumn( "NutrientA" );
		dm.addColumn( "A" );
		dm.addColumn( "Eq" );
		dm.addColumn( "NutrientB" );
		dm.addColumn( "B" );
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
					filters.add( RowFilter.regexFilter( "(?i)" + searchField.getText(), 4 ) );
					filters.add( RowFilter.regexFilter( "(?i)" + searchField.getText(), 6 ) );
					filters.add( RowFilter.regexFilter( "(?i)" + searchField.getText(), 7 ) );
					rf = RowFilter.orFilter( filters );

				} catch (java.util.regex.PatternSyntaxException e) {

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

		return !(getRowCount() > 0);

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

			Row row = getRow( selectedRows[i] );
			rows.add( row );

		}

		return rows;

	}

	private Row getRow( int selectedRowNo ) {

		String mixid = ( String ) getValueAt( selectedRowNo, 0 );
		String nutrientid1 = ( String ) getValueAt( selectedRowNo, 1 );
		String nutrientid2 = ( String ) getValueAt( selectedRowNo, 2 );
		Integer relationshipid = ( Integer ) getValueAt( selectedRowNo, 3 );
		String nutrienta = ( String ) getValueAt( selectedRowNo, 4 );
		BigDecimal a = ( BigDecimal ) getValueAt( selectedRowNo, 5 );
		String relationship = ( String ) getValueAt( selectedRowNo, 6 );
		String nutrientb = ( String ) getValueAt( selectedRowNo, 7 );
		BigDecimal b = ( BigDecimal ) getValueAt( selectedRowNo, 8 );
		Row row = new Row();
		row.setMixid( mixid );
		row.setNutrientaid( nutrientid1 );
		row.setNutrientbid( nutrientid2 );
		row.setRelationshipid( relationshipid );
		row.setNutrienta( nutrienta );
		row.setNutrientb( nutrientb );
		row.setA( a );
		row.setB( b );
		row.setRelationship( relationship );
		return row;

	}

	public JTextField getSearchField() {

		return searchField;

	}

	public void reload( List<List> data ) {

		dm.reload( data );
		adjustColumnWidth();

	}

	public void clear() {

		dm.clear();

	}

	private void adjustColumnWidth() {

		for ( int i = 0; i < 4; i++ ) {

			getColumnModel().getColumn( i ).setMinWidth( 0 );
			getColumnModel().getColumn( i ).setMaxWidth( 0 );

		}

		getColumnModel().getColumn( 4 ).setMinWidth( 350 );
		getColumnModel().getColumn( 5 ).setMinWidth( 90 );
		getColumnModel().getColumn( 6 ).setMinWidth( 21 );
		getColumnModel().getColumn( 6 ).setMaxWidth( 21 );
		getColumnModel().getColumn( 7 ).setMinWidth( 350 );
		getColumnModel().getColumn( 8 ).setMinWidth( 90 );

	}

	public void roundUp() {

		roundQuantity( new RoundUpRenderer() );

	}

	public void roundDown() {

		roundQuantity( new RoundDownRenderer() );

	}

	private void roundQuantity( DefaultTableCellRenderer renderer ) {

		getColumnModel().getColumn( 5 ).setCellRenderer( renderer );
		getColumnModel().getColumn( 8 ).setCellRenderer( renderer );
		revalidate();
		repaint();

	}

	public Stream getStream() {

		return dm.getStream();

	}

	public class Row {

		private String mixid;
		private String nutrientaid;
		private String nutrientbid;
		private Integer relationshipid;
		private String nutrienta;
		private String nutrientb;
		private BigDecimal a;
		private BigDecimal b;
		private String relationship;

		public Row() {

			mixid = null;
			nutrientaid = null;
			nutrientbid = null;
			relationshipid = null;
			nutrienta = null;
			nutrientb = null;
			a = null;
			b = null;
			relationship = null;

		}

		public String getMixid() {

			return mixid;

		}

		public void setMixid( String mixid ) {

			this.mixid = mixid;

		}

		public String getNutrientaid() {

			return nutrientaid;

		}

		public void setNutrientaid( String nutrientaid ) {

			this.nutrientaid = nutrientaid;

		}

		public String getNutrientbid() {

			return nutrientbid;

		}

		public void setNutrientbid( String nutrientbid ) {

			this.nutrientbid = nutrientbid;

		}

		public Integer getRelationshipid() {

			return relationshipid;

		}

		public void setRelationshipid( Integer relationshipid ) {

			this.relationshipid = relationshipid;

		}

		public String getNutrienta() {

			return nutrienta;

		}

		public void setNutrienta( String nutrienta ) {

			this.nutrienta = nutrienta;

		}

		public String getNutrientb() {

			return nutrientb;

		}

		public void setNutrientb( String nutrientb ) {

			this.nutrientb = nutrientb;

		}

		public BigDecimal getA() {

			return a;

		}

		public void setA( BigDecimal a ) {

			this.a = a;

		}

		public BigDecimal getB() {

			return b;

		}

		public void setB( BigDecimal b ) {

			this.b = b;

		}

		public String getRelationship() {

			return relationship;

		}

		public void setRelationship( String relationship ) {

			this.relationship = relationship;

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

			Class columnClass = String.class;

			switch ( c ) {

			case 3 -> {

				columnClass = Integer.class;

			}
			case 5, 8 -> {

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

		public Stream getStream() {

			return data.stream();

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
				return columnToolTips[realIndex];

			}
		};

	}

	protected String[] columnToolTips = new String[] {
			"MixId", "NutrientIdA", "NutrientIdA", "RelationshipId", "NutrientA", "A", "Eq", "NutrientB", "B"
	};

}
