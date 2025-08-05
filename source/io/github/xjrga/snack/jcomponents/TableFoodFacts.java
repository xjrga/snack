package io.github.xjrga.snack.jcomponents;

import io.github.xjrga.snack.interfaces.ShowCategory;
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
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableRowSorter;

/**
 * @author jr
 */
public class TableFoodFacts extends JTable implements ShowCategory {

	private TableRowSorter sorter;
	private JTextField txtSearch;
	private final DataModel dm;

	public TableFoodFacts() {

		txtSearch = new JTextField();
		dm = new DataModel();
		dm.addColumn( "Id" );
		dm.addColumn( "Food" );
		dm.addColumn( "Weight" );
		dm.addColumn( "eGross" );
		dm.addColumn( "eDigestible" );
		dm.addColumn( "eFat" );
		dm.addColumn( "eCarbs" );
		dm.addColumn( "eFat+" );
		dm.addColumn( "eProtein" );
		dm.addColumn( "eAlcohol" );
		dm.addColumn( "Fats" );
		dm.addColumn( "Carbs" );
		dm.addColumn( "Protein" );
		dm.addColumn( "Alcohol" );
		dm.addColumn( "eProtein" );
		dm.addColumn( "Protein" );
		dm.addColumn( "ProteinComplete" );
		dm.addColumn( "eFat" );
		dm.addColumn( "Fats" );
		dm.addColumn( "MUFA" );
		dm.addColumn( "PUFA" );
		dm.addColumn( "SFA" );
		dm.addColumn( "Cholesterol" );
		dm.addColumn( "SFA" );
		dm.addColumn( "HCSFA" );
		dm.addColumn( "Lauric" );
		dm.addColumn( "Myristic" );
		dm.addColumn( "Palmitic" );
		dm.addColumn( "Stearic" );
		dm.addColumn( "Cholesterol" );
		dm.addColumn( "PUFA" );
		dm.addColumn( "LA" );
		dm.addColumn( "ALA" );
		dm.addColumn( "EPA" );
		dm.addColumn( "DHA" );
		dm.addColumn( "LCN3PUFA" );
		dm.addColumn( "eCarbs" );
		dm.addColumn( "CarbsByDiff" );
		dm.addColumn( "Fiber" );
		dm.addColumn( "FiberIns" );
		dm.addColumn( "FiberSol" );
		dm.addColumn( "Carbs" );
		dm.addColumn( "Starch" );
		dm.addColumn( "Sugars" );
		dm.addColumn( "Sucrose" );
		dm.addColumn( "Lactose" );
		dm.addColumn( "Fructose" );
		dm.addColumn( "Glucose" );
		dm.addColumn( "GL" );
		dm.addColumn( "A" );
		dm.addColumn( "D" );
		dm.addColumn( "E" );
		dm.addColumn( "C" );
		dm.addColumn( "Thiamin" );
		dm.addColumn( "Riboflavin" );
		dm.addColumn( "Niacin" );
		dm.addColumn( "B6" );
		dm.addColumn( "Folate" );
		dm.addColumn( "B12" );
		dm.addColumn( "K" );
		dm.addColumn( "Pantothenic" );
		dm.addColumn( "Choline" );
		dm.addColumn( "Calcium" );
		dm.addColumn( "Phosphorus" );
		dm.addColumn( "Magnesium" );
		dm.addColumn( "Iron" );
		dm.addColumn( "Zinc" );
		dm.addColumn( "Copper" );
		dm.addColumn( "Manganese" );
		dm.addColumn( "Selenium" );
		dm.addColumn( "Potassium" );
		dm.addColumn( "Sodium" );
		dm.addColumn( "Flavonoids" );
		dm.addColumn( "Anthocyanins" );
		dm.addColumn( "Carotenoids" );
		dm.addColumn( "Flavanols" );
		dm.addColumn( "Flavanones" );
		dm.addColumn( "Flavones" );
		dm.addColumn( "Flavonols" );
		dm.addColumn( "Isoflavones" );
		dm.addColumn( "Phytosterols" );
		dm.addColumn( "BetaCarotene" );
		dm.addColumn( "Lutein+" );
		dm.addColumn( "Lycopene" );
		dm.addColumn( "Caffeine" );
		dm.addColumn( "Theobromine" );
		dm.addColumn( "Cost" );
		dm.addColumn( "Water" );
		setModel( dm );
		setSelectionMode( ListSelectionModel.SINGLE_SELECTION );
		setFillsViewportHeight( true );
		setAutoResizeMode( JTable.AUTO_RESIZE_OFF );
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
					rf = RowFilter.orFilter( filters );

				} catch (java.util.regex.PatternSyntaxException e) {

					LoggerImpl.INSTANCE.logProblem( e );

				}

				sorter.setRowFilter( rf );

			}
		} );

	}

	public boolean isSelectionEmpty() {

		int[] rows = getSelectedRows();
		return rows.length == 0;

	}

	public boolean isEmpty() {

		return !(getRowCount() > 0);

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

		ArrayList<Row> row = new ArrayList<>();

		if ( isSelectionEmpty() ) {

			return row;

		}

		int[] rows = this.getSelectedRows();

		for ( int i = 0; i < rows.length; i++ ) {

			Row foodfacts = getRow( i );
			row.add( foodfacts );

		}

		return row;

	}

	private Row getRow( int selectedRowNo ) {

		String id_food_id = ( String ) getValueAt( selectedRowNo, 0 );
		String id_food_name = ( String ) getValueAt( selectedRowNo, 1 );
		BigDecimal id_other_weight = ( BigDecimal ) getValueAt( selectedRowNo, 2 );
		BigDecimal energy_energy_gross = ( BigDecimal ) getValueAt( selectedRowNo, 3 );
		BigDecimal energy_energy_digestible = ( BigDecimal ) getValueAt( selectedRowNo, 4 );
		BigDecimal energy_energy_fat = ( BigDecimal ) getValueAt( selectedRowNo, 5 );
		BigDecimal energy_energy_carbohydrate = ( BigDecimal ) getValueAt( selectedRowNo, 6 );
		BigDecimal energy_energy_fat_and_carbohydrate = ( BigDecimal ) getValueAt( selectedRowNo, 7 );
		BigDecimal energy_energy_protein = ( BigDecimal ) getValueAt( selectedRowNo, 8 );
		BigDecimal energy_energy_alcohol = ( BigDecimal ) getValueAt( selectedRowNo, 9 );
		BigDecimal macronutrients_fats_total = ( BigDecimal ) getValueAt( selectedRowNo, 10 );
		BigDecimal macronutrients_carbohydrates_digestible = ( BigDecimal ) getValueAt( selectedRowNo, 11 );
		BigDecimal macronutrients_protein_total = ( BigDecimal ) getValueAt( selectedRowNo, 12 );
		BigDecimal macronutrients_other_alcohol = ( BigDecimal ) getValueAt( selectedRowNo, 13 );
		BigDecimal protein_energy_protein = ( BigDecimal ) getValueAt( selectedRowNo, 14 );
		BigDecimal protein_protein_total = ( BigDecimal ) getValueAt( selectedRowNo, 15 );
		BigDecimal protein_protein_complete = ( BigDecimal ) getValueAt( selectedRowNo, 16 );
		BigDecimal fats_energy_fat = ( BigDecimal ) getValueAt( selectedRowNo, 17 );
		BigDecimal fats_fats_total = ( BigDecimal ) getValueAt( selectedRowNo, 18 );
		BigDecimal fats_fats_monounsaturated = ( BigDecimal ) getValueAt( selectedRowNo, 19 );
		BigDecimal fats_fats_polyunsaturated = ( BigDecimal ) getValueAt( selectedRowNo, 20 );
		BigDecimal fats_fats_saturated = ( BigDecimal ) getValueAt( selectedRowNo, 21 );
		BigDecimal fats_fats_cholesterol = ( BigDecimal ) getValueAt( selectedRowNo, 22 );
		BigDecimal sfa_fats_saturated = ( BigDecimal ) getValueAt( selectedRowNo, 23 );
		BigDecimal sfa_fats_hcsfa = ( BigDecimal ) getValueAt( selectedRowNo, 24 );
		BigDecimal sfa_fats_lauric = ( BigDecimal ) getValueAt( selectedRowNo, 25 );
		BigDecimal sfa_fats_myristic = ( BigDecimal ) getValueAt( selectedRowNo, 26 );
		BigDecimal sfa_fats_palmitic = ( BigDecimal ) getValueAt( selectedRowNo, 27 );
		BigDecimal sfa_fats_stearic = ( BigDecimal ) getValueAt( selectedRowNo, 28 );
		BigDecimal sfa_fats_cholesterol = ( BigDecimal ) getValueAt( selectedRowNo, 29 );
		BigDecimal pufa_fats_polyunsaturated = ( BigDecimal ) getValueAt( selectedRowNo, 30 );
		BigDecimal pufa_fats_linoleic = ( BigDecimal ) getValueAt( selectedRowNo, 31 );
		BigDecimal pufa_fats_linolenic = ( BigDecimal ) getValueAt( selectedRowNo, 32 );
		BigDecimal pufa_fats_epa = ( BigDecimal ) getValueAt( selectedRowNo, 33 );
		BigDecimal pufa_fats_dha = ( BigDecimal ) getValueAt( selectedRowNo, 34 );
		BigDecimal pufa_fats_lcn3pufa = ( BigDecimal ) getValueAt( selectedRowNo, 35 );
		BigDecimal carbs_energy_carbohydrate = ( BigDecimal ) getValueAt( selectedRowNo, 36 );
		BigDecimal carbs_carbohydrates_carbs_by_diff = ( BigDecimal ) getValueAt( selectedRowNo, 37 );
		BigDecimal carbs_carbohydrates_fiber = ( BigDecimal ) getValueAt( selectedRowNo, 38 );
		BigDecimal carbs_carbohydrates_fiber_insoluble = ( BigDecimal ) getValueAt( selectedRowNo, 39 );
		BigDecimal carbs_carbohydrates_fiber_soluble = ( BigDecimal ) getValueAt( selectedRowNo, 40 );
		BigDecimal carbs_carbohydrates_digestible = ( BigDecimal ) getValueAt( selectedRowNo, 41 );
		BigDecimal carbs_carbohydrates_starch = ( BigDecimal ) getValueAt( selectedRowNo, 42 );
		BigDecimal carbs_carbohydrates_sugars = ( BigDecimal ) getValueAt( selectedRowNo, 43 );
		BigDecimal carbs_carbohydrates_sucrose = ( BigDecimal ) getValueAt( selectedRowNo, 44 );
		BigDecimal carbs_carbohydrates_lactose = ( BigDecimal ) getValueAt( selectedRowNo, 45 );
		BigDecimal carbs_carbohydrates_fructose = ( BigDecimal ) getValueAt( selectedRowNo, 46 );
		BigDecimal carbs_carbohydrates_glucose = ( BigDecimal ) getValueAt( selectedRowNo, 47 );
		BigDecimal carbs_carbohydrates_glycemic_load = ( BigDecimal ) getValueAt( selectedRowNo, 48 );
		BigDecimal vitamins_vitamins_vitamin_a = ( BigDecimal ) getValueAt( selectedRowNo, 49 );
		BigDecimal vitamins_vitamins_vitamin_d = ( BigDecimal ) getValueAt( selectedRowNo, 50 );
		BigDecimal vitamins_vitamins_vitamin_e = ( BigDecimal ) getValueAt( selectedRowNo, 51 );
		BigDecimal vitamins_vitamins_vitamin_c = ( BigDecimal ) getValueAt( selectedRowNo, 52 );
		BigDecimal vitamins_vitamins_thiamin = ( BigDecimal ) getValueAt( selectedRowNo, 53 );
		BigDecimal vitamins_vitamins_riboflavin = ( BigDecimal ) getValueAt( selectedRowNo, 54 );
		BigDecimal vitamins_vitamins_niacin = ( BigDecimal ) getValueAt( selectedRowNo, 55 );
		BigDecimal vitamins_vitamins_vitamin_b6 = ( BigDecimal ) getValueAt( selectedRowNo, 56 );
		BigDecimal vitamins_vitamins_folate = ( BigDecimal ) getValueAt( selectedRowNo, 57 );
		BigDecimal vitamins_vitamins_vitamin_b12 = ( BigDecimal ) getValueAt( selectedRowNo, 58 );
		BigDecimal vitamins_vitamins_vitamin_k = ( BigDecimal ) getValueAt( selectedRowNo, 59 );
		BigDecimal vitamins_vitamins_pantothenic_acid = ( BigDecimal ) getValueAt( selectedRowNo, 60 );
		BigDecimal vitamins_vitamins_choline = ( BigDecimal ) getValueAt( selectedRowNo, 61 );
		BigDecimal minerals_minerals_calcium = ( BigDecimal ) getValueAt( selectedRowNo, 62 );
		BigDecimal minerals_minerals_phosphorus = ( BigDecimal ) getValueAt( selectedRowNo, 63 );
		BigDecimal minerals_minerals_magnesium = ( BigDecimal ) getValueAt( selectedRowNo, 64 );
		BigDecimal minerals_minerals_iron = ( BigDecimal ) getValueAt( selectedRowNo, 65 );
		BigDecimal minerals_minerals_zinc = ( BigDecimal ) getValueAt( selectedRowNo, 66 );
		BigDecimal minerals_minerals_copper = ( BigDecimal ) getValueAt( selectedRowNo, 67 );
		BigDecimal minerals_minerals_manganese = ( BigDecimal ) getValueAt( selectedRowNo, 68 );
		BigDecimal minerals_minerals_selenium = ( BigDecimal ) getValueAt( selectedRowNo, 69 );
		BigDecimal electrolytes_minerals_potassium = ( BigDecimal ) getValueAt( selectedRowNo, 70 );
		BigDecimal electrolytes_minerals_sodium = ( BigDecimal ) getValueAt( selectedRowNo, 71 );
		BigDecimal phytonutrients_phytonutrients_flavonoids = ( BigDecimal ) getValueAt( selectedRowNo, 72 );
		BigDecimal phytonutrients_phytonutrients_anthocyanins = ( BigDecimal ) getValueAt( selectedRowNo, 73 );
		BigDecimal phytonutrients_phytonutrients_carotenoids = ( BigDecimal ) getValueAt( selectedRowNo, 74 );
		BigDecimal phytonutrients_phytonutrients_flavanols = ( BigDecimal ) getValueAt( selectedRowNo, 75 );
		BigDecimal phytonutrients_phytonutrients_flavanones = ( BigDecimal ) getValueAt( selectedRowNo, 76 );
		BigDecimal phytonutrients_phytonutrients_flavones = ( BigDecimal ) getValueAt( selectedRowNo, 77 );
		BigDecimal phytonutrients_phytonutrients_flavonols = ( BigDecimal ) getValueAt( selectedRowNo, 78 );
		BigDecimal phytonutrients_phytonutrients_isoflavones = ( BigDecimal ) getValueAt( selectedRowNo, 79 );
		BigDecimal phytonutrients_phytonutrients_phytosterols = ( BigDecimal ) getValueAt( selectedRowNo, 80 );
		BigDecimal phytonutrients_phytonutrients_beta_carotene = ( BigDecimal ) getValueAt( selectedRowNo, 81 );
		BigDecimal phytonutrients_phytonutrients_lutein_zeaxanthin = ( BigDecimal ) getValueAt( selectedRowNo, 82 );
		BigDecimal phytonutrients_phytonutrients_lycopene = ( BigDecimal ) getValueAt( selectedRowNo, 83 );
		BigDecimal phytonutrients_phytonutrients_caffeine = ( BigDecimal ) getValueAt( selectedRowNo, 84 );
		BigDecimal phytonutrients_phytonutrients_theobromine = ( BigDecimal ) getValueAt( selectedRowNo, 85 );
		BigDecimal other_other_cost = ( BigDecimal ) getValueAt( selectedRowNo, 86 );
		BigDecimal other_other_water = ( BigDecimal ) getValueAt( selectedRowNo, 87 );
		Row row = new Row();
		row.setId_food_id( id_food_id );
		row.setId_food_name( id_food_name );
		row.setId_other_weight( id_other_weight );
		row.setEnergy_energy_gross( energy_energy_gross );
		row.setEnergy_energy_digestible( energy_energy_digestible );
		row.setEnergy_energy_fat( energy_energy_fat );
		row.setEnergy_energy_carbohydrate( energy_energy_carbohydrate );
		row.setEnergy_energy_fat_and_carbohydrate( energy_energy_fat_and_carbohydrate );
		row.setEnergy_energy_protein( energy_energy_protein );
		row.setEnergy_energy_alcohol( energy_energy_alcohol );
		row.setMacronutrients_fats_total( macronutrients_fats_total );
		row.setMacronutrients_carbohydrates_digestible( macronutrients_carbohydrates_digestible );
		row.setMacronutrients_protein_total( macronutrients_protein_total );
		row.setMacronutrients_other_alcohol( macronutrients_other_alcohol );
		row.setProtein_energy_protein( protein_energy_protein );
		row.setProtein_protein_total( protein_protein_total );
		row.setProtein_protein_complete( protein_protein_complete );
		row.setFats_energy_fat( fats_energy_fat );
		row.setFats_fats_total( fats_fats_total );
		row.setFats_fats_monounsaturated( fats_fats_monounsaturated );
		row.setFats_fats_polyunsaturated( fats_fats_polyunsaturated );
		row.setFats_fats_saturated( fats_fats_saturated );
		row.setFats_fats_cholesterol( fats_fats_cholesterol );
		row.setSfa_fats_saturated( sfa_fats_saturated );
		row.setSfa_fats_hcsfa( sfa_fats_hcsfa );
		row.setSfa_fats_lauric( sfa_fats_lauric );
		row.setSfa_fats_myristic( sfa_fats_myristic );
		row.setSfa_fats_palmitic( sfa_fats_palmitic );
		row.setSfa_fats_stearic( sfa_fats_stearic );
		row.setSfa_fats_cholesterol( sfa_fats_cholesterol );
		row.setPufa_fats_polyunsaturated( pufa_fats_polyunsaturated );
		row.setPufa_fats_linoleic( pufa_fats_linoleic );
		row.setPufa_fats_linolenic( pufa_fats_linolenic );
		row.setPufa_fats_epa( pufa_fats_epa );
		row.setPufa_fats_dha( pufa_fats_dha );
		row.setPufa_fats_lcn3pufa( pufa_fats_lcn3pufa );
		row.setCarbs_energy_carbohydrate( carbs_energy_carbohydrate );
		row.setCarbs_carbohydrates_carbs_by_diff( carbs_carbohydrates_carbs_by_diff );
		row.setCarbs_carbohydrates_fiber( carbs_carbohydrates_fiber );
		row.setCarbs_carbohydrates_fiber_insoluble( carbs_carbohydrates_fiber_insoluble );
		row.setCarbs_carbohydrates_fiber_soluble( carbs_carbohydrates_fiber_soluble );
		row.setCarbs_carbohydrates_digestible( carbs_carbohydrates_digestible );
		row.setCarbs_carbohydrates_starch( carbs_carbohydrates_starch );
		row.setCarbs_carbohydrates_sugars( carbs_carbohydrates_sugars );
		row.setCarbs_carbohydrates_sucrose( carbs_carbohydrates_sucrose );
		row.setCarbs_carbohydrates_lactose( carbs_carbohydrates_lactose );
		row.setCarbs_carbohydrates_fructose( carbs_carbohydrates_fructose );
		row.setCarbs_carbohydrates_glucose( carbs_carbohydrates_glucose );
		row.setCarbs_carbohydrates_glycemic_load( carbs_carbohydrates_glycemic_load );
		row.setVitamins_vitamins_vitamin_a( vitamins_vitamins_vitamin_a );
		row.setVitamins_vitamins_vitamin_d( vitamins_vitamins_vitamin_d );
		row.setVitamins_vitamins_vitamin_e( vitamins_vitamins_vitamin_e );
		row.setVitamins_vitamins_vitamin_c( vitamins_vitamins_vitamin_c );
		row.setVitamins_vitamins_thiamin( vitamins_vitamins_thiamin );
		row.setVitamins_vitamins_riboflavin( vitamins_vitamins_riboflavin );
		row.setVitamins_vitamins_niacin( vitamins_vitamins_niacin );
		row.setVitamins_vitamins_vitamin_b6( vitamins_vitamins_vitamin_b6 );
		row.setVitamins_vitamins_folate( vitamins_vitamins_folate );
		row.setVitamins_vitamins_vitamin_b12( vitamins_vitamins_vitamin_b12 );
		row.setVitamins_vitamins_vitamin_k( vitamins_vitamins_vitamin_k );
		row.setVitamins_vitamins_pantothenic_acid( vitamins_vitamins_pantothenic_acid );
		row.setVitamins_vitamins_choline( vitamins_vitamins_choline );
		row.setMinerals_minerals_calcium( minerals_minerals_calcium );
		row.setMinerals_minerals_phosphorus( minerals_minerals_phosphorus );
		row.setMinerals_minerals_magnesium( minerals_minerals_magnesium );
		row.setMinerals_minerals_iron( minerals_minerals_iron );
		row.setMinerals_minerals_zinc( minerals_minerals_zinc );
		row.setMinerals_minerals_copper( minerals_minerals_copper );
		row.setMinerals_minerals_manganese( minerals_minerals_manganese );
		row.setMinerals_minerals_selenium( minerals_minerals_selenium );
		row.setElectrolytes_minerals_potassium( electrolytes_minerals_potassium );
		row.setElectrolytes_minerals_sodium( electrolytes_minerals_sodium );
		row.setPhytonutrients_phytonutrients_flavonoids( phytonutrients_phytonutrients_flavonoids );
		row.setPhytonutrients_phytonutrients_anthocyanins( phytonutrients_phytonutrients_anthocyanins );
		row.setPhytonutrients_phytonutrients_carotenoids( phytonutrients_phytonutrients_carotenoids );
		row.setPhytonutrients_phytonutrients_flavanols( phytonutrients_phytonutrients_flavanols );
		row.setPhytonutrients_phytonutrients_flavanones( phytonutrients_phytonutrients_flavanones );
		row.setPhytonutrients_phytonutrients_flavones( phytonutrients_phytonutrients_flavones );
		row.setPhytonutrients_phytonutrients_flavonols( phytonutrients_phytonutrients_flavonols );
		row.setPhytonutrients_phytonutrients_isoflavones( phytonutrients_phytonutrients_isoflavones );
		row.setPhytonutrients_phytonutrients_phytosterols( phytonutrients_phytonutrients_phytosterols );
		row.setPhytonutrients_phytonutrients_beta_carotene( phytonutrients_phytonutrients_beta_carotene );
		row.setPhytonutrients_phytonutrients_lutein_zeaxanthin( phytonutrients_phytonutrients_lutein_zeaxanthin );
		row.setPhytonutrients_phytonutrients_lycopene( phytonutrients_phytonutrients_lycopene );
		row.setPhytonutrients_phytonutrients_caffeine( phytonutrients_phytonutrients_caffeine );
		row.setPhytonutrients_phytonutrients_theobromine( phytonutrients_phytonutrients_theobromine );
		row.setOther_other_cost( other_other_cost );
		row.setOther_other_water( other_other_water );
		return row;

	}

	public JTextField getTxtSearch() {

		return txtSearch;

	}

	public void reload( List<List> data ) {

		dm.clear();
		dm.reload( data );

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

	public void roundUp() {

		roundQuantity( new RoundUpRenderer() );

	}

	public void roundDown() {

		roundQuantity( new RoundDownRenderer() );

	}

	private void roundQuantity( DefaultTableCellRenderer renderer ) {

		getColumnModel().getColumn( 2 ).setCellRenderer( renderer );
		getColumnModel().getColumn( 3 ).setCellRenderer( renderer );
		getColumnModel().getColumn( 4 ).setCellRenderer( renderer );
		getColumnModel().getColumn( 5 ).setCellRenderer( renderer );
		getColumnModel().getColumn( 6 ).setCellRenderer( renderer );
		getColumnModel().getColumn( 7 ).setCellRenderer( renderer );
		getColumnModel().getColumn( 8 ).setCellRenderer( renderer );
		getColumnModel().getColumn( 9 ).setCellRenderer( renderer );
		getColumnModel().getColumn( 10 ).setCellRenderer( renderer );
		getColumnModel().getColumn( 11 ).setCellRenderer( renderer );
		getColumnModel().getColumn( 12 ).setCellRenderer( renderer );
		getColumnModel().getColumn( 13 ).setCellRenderer( renderer );
		getColumnModel().getColumn( 14 ).setCellRenderer( renderer );
		getColumnModel().getColumn( 15 ).setCellRenderer( renderer );
		getColumnModel().getColumn( 16 ).setCellRenderer( renderer );
		getColumnModel().getColumn( 17 ).setCellRenderer( renderer );
		getColumnModel().getColumn( 18 ).setCellRenderer( renderer );
		getColumnModel().getColumn( 19 ).setCellRenderer( renderer );
		getColumnModel().getColumn( 20 ).setCellRenderer( renderer );
		getColumnModel().getColumn( 21 ).setCellRenderer( renderer );
		getColumnModel().getColumn( 22 ).setCellRenderer( renderer );
		getColumnModel().getColumn( 23 ).setCellRenderer( renderer );
		getColumnModel().getColumn( 24 ).setCellRenderer( renderer );
		getColumnModel().getColumn( 25 ).setCellRenderer( renderer );
		getColumnModel().getColumn( 26 ).setCellRenderer( renderer );
		getColumnModel().getColumn( 27 ).setCellRenderer( renderer );
		getColumnModel().getColumn( 28 ).setCellRenderer( renderer );
		getColumnModel().getColumn( 29 ).setCellRenderer( renderer );
		getColumnModel().getColumn( 30 ).setCellRenderer( renderer );
		getColumnModel().getColumn( 31 ).setCellRenderer( renderer );
		getColumnModel().getColumn( 32 ).setCellRenderer( renderer );
		getColumnModel().getColumn( 33 ).setCellRenderer( renderer );
		getColumnModel().getColumn( 34 ).setCellRenderer( renderer );
		getColumnModel().getColumn( 35 ).setCellRenderer( renderer );
		getColumnModel().getColumn( 36 ).setCellRenderer( renderer );
		getColumnModel().getColumn( 37 ).setCellRenderer( renderer );
		getColumnModel().getColumn( 38 ).setCellRenderer( renderer );
		getColumnModel().getColumn( 39 ).setCellRenderer( renderer );
		getColumnModel().getColumn( 40 ).setCellRenderer( renderer );
		getColumnModel().getColumn( 41 ).setCellRenderer( renderer );
		getColumnModel().getColumn( 42 ).setCellRenderer( renderer );
		getColumnModel().getColumn( 43 ).setCellRenderer( renderer );
		getColumnModel().getColumn( 44 ).setCellRenderer( renderer );
		getColumnModel().getColumn( 45 ).setCellRenderer( renderer );
		getColumnModel().getColumn( 46 ).setCellRenderer( renderer );
		getColumnModel().getColumn( 47 ).setCellRenderer( renderer );
		getColumnModel().getColumn( 48 ).setCellRenderer( renderer );
		getColumnModel().getColumn( 49 ).setCellRenderer( renderer );
		getColumnModel().getColumn( 50 ).setCellRenderer( renderer );
		getColumnModel().getColumn( 51 ).setCellRenderer( renderer );
		getColumnModel().getColumn( 52 ).setCellRenderer( renderer );
		getColumnModel().getColumn( 53 ).setCellRenderer( renderer );
		getColumnModel().getColumn( 54 ).setCellRenderer( renderer );
		getColumnModel().getColumn( 55 ).setCellRenderer( renderer );
		getColumnModel().getColumn( 56 ).setCellRenderer( renderer );
		getColumnModel().getColumn( 57 ).setCellRenderer( renderer );
		getColumnModel().getColumn( 58 ).setCellRenderer( renderer );
		getColumnModel().getColumn( 59 ).setCellRenderer( renderer );
		getColumnModel().getColumn( 60 ).setCellRenderer( renderer );
		getColumnModel().getColumn( 61 ).setCellRenderer( renderer );
		getColumnModel().getColumn( 62 ).setCellRenderer( renderer );
		getColumnModel().getColumn( 63 ).setCellRenderer( renderer );
		getColumnModel().getColumn( 64 ).setCellRenderer( renderer );
		getColumnModel().getColumn( 65 ).setCellRenderer( renderer );
		getColumnModel().getColumn( 66 ).setCellRenderer( renderer );
		getColumnModel().getColumn( 67 ).setCellRenderer( renderer );
		getColumnModel().getColumn( 68 ).setCellRenderer( renderer );
		getColumnModel().getColumn( 69 ).setCellRenderer( renderer );
		getColumnModel().getColumn( 70 ).setCellRenderer( renderer );
		getColumnModel().getColumn( 71 ).setCellRenderer( renderer );
		getColumnModel().getColumn( 72 ).setCellRenderer( renderer );
		getColumnModel().getColumn( 73 ).setCellRenderer( renderer );
		getColumnModel().getColumn( 74 ).setCellRenderer( renderer );
		getColumnModel().getColumn( 75 ).setCellRenderer( renderer );
		getColumnModel().getColumn( 76 ).setCellRenderer( renderer );
		getColumnModel().getColumn( 77 ).setCellRenderer( renderer );
		getColumnModel().getColumn( 78 ).setCellRenderer( renderer );
		getColumnModel().getColumn( 79 ).setCellRenderer( renderer );
		getColumnModel().getColumn( 80 ).setCellRenderer( renderer );
		getColumnModel().getColumn( 81 ).setCellRenderer( renderer );
		getColumnModel().getColumn( 82 ).setCellRenderer( renderer );
		getColumnModel().getColumn( 83 ).setCellRenderer( renderer );
		getColumnModel().getColumn( 84 ).setCellRenderer( renderer );
		getColumnModel().getColumn( 85 ).setCellRenderer( renderer );
		getColumnModel().getColumn( 86 ).setCellRenderer( renderer );
		getColumnModel().getColumn( 87 ).setCellRenderer( renderer );

		revalidate();
		repaint();

	}

	@Override
	public void showCategory( int ordinal ) {

		switch ( ordinal ) {

		case 0 -> adjustWidth( 2, 9 );
		case 1 -> adjustWidth( 10, 13 );
		case 2 -> adjustWidth( 14, 16 );
		case 3 -> adjustWidth( 17, 22 );
		case 4 -> adjustWidth( 23, 29 );
		case 5 -> adjustWidth( 30, 35 );
		case 6 -> adjustWidth( 36, 48 );
		case 7 -> adjustWidth( 49, 61 );
		case 8 -> adjustWidth( 62, 69 );
		case 9 -> adjustWidth( 70, 71 );
		case 10 -> adjustWidth( 72, 85 );
		case 11 -> adjustWidth( 86, 87 );

		default -> {

			System.out.println( "Default Option at TableFoodFacts" );

		}

		}

	}

	private void adjustWidth( int start, int end ) {

		TableColumnModel colModel = getColumnModel();

		for ( int i = 0; i < colModel.getColumnCount(); i++ ) {

			if ( i < start || i > end ) {

				getColumnModel().getColumn( i ).setMinWidth( 0 );
				getColumnModel().getColumn( i ).setPreferredWidth( 0 );

			} else {

				getColumnModel().getColumn( i ).setMinWidth( 75 );
				getColumnModel().getColumn( i ).setPreferredWidth( 75 );

			}

			if ( i == 0 ) {

				getColumnModel().getColumn( i ).setPreferredWidth( 75 );

			}

			if ( i == 1 ) {

				getColumnModel().getColumn( i ).setPreferredWidth( 500 );

			}

			if ( i == 2 ) {

				getColumnModel().getColumn( i ).setPreferredWidth( 75 );

			}

		}

	}

	public class Row {

		private String id_food_id;
		private String id_food_name;
		private BigDecimal id_other_weight;
		private BigDecimal energy_energy_gross;
		private BigDecimal energy_energy_digestible;
		private BigDecimal energy_energy_fat;
		private BigDecimal energy_energy_carbohydrate;
		private BigDecimal energy_energy_fat_and_carbohydrate;
		private BigDecimal energy_energy_protein;
		private BigDecimal energy_energy_alcohol;
		private BigDecimal macronutrients_fats_total;
		private BigDecimal macronutrients_carbohydrates_digestible;
		private BigDecimal macronutrients_protein_total;
		private BigDecimal macronutrients_other_alcohol;
		private BigDecimal protein_energy_protein;
		private BigDecimal protein_protein_total;
		private BigDecimal protein_protein_complete;
		private BigDecimal fats_energy_fat;
		private BigDecimal fats_fats_total;
		private BigDecimal fats_fats_monounsaturated;
		private BigDecimal fats_fats_polyunsaturated;
		private BigDecimal fats_fats_saturated;
		private BigDecimal fats_fats_cholesterol;
		private BigDecimal sfa_fats_saturated;
		private BigDecimal sfa_fats_hcsfa;
		private BigDecimal sfa_fats_lauric;
		private BigDecimal sfa_fats_myristic;
		private BigDecimal sfa_fats_palmitic;
		private BigDecimal sfa_fats_stearic;
		private BigDecimal sfa_fats_cholesterol;
		private BigDecimal pufa_fats_polyunsaturated;
		private BigDecimal pufa_fats_linoleic;
		private BigDecimal pufa_fats_linolenic;
		private BigDecimal pufa_fats_epa;
		private BigDecimal pufa_fats_dha;
		private BigDecimal pufa_fats_lcn3pufa;
		private BigDecimal carbs_energy_carbohydrate;
		private BigDecimal carbs_carbohydrates_carbs_by_diff;
		private BigDecimal carbs_carbohydrates_fiber;
		private BigDecimal carbs_carbohydrates_fiber_insoluble;
		private BigDecimal carbs_carbohydrates_fiber_soluble;
		private BigDecimal carbs_carbohydrates_digestible;
		private BigDecimal carbs_carbohydrates_starch;
		private BigDecimal carbs_carbohydrates_sugars;
		private BigDecimal carbs_carbohydrates_sucrose;
		private BigDecimal carbs_carbohydrates_lactose;
		private BigDecimal carbs_carbohydrates_fructose;
		private BigDecimal carbs_carbohydrates_glucose;
		private BigDecimal carbs_carbohydrates_glycemic_load;
		private BigDecimal vitamins_vitamins_vitamin_a;
		private BigDecimal vitamins_vitamins_vitamin_d;
		private BigDecimal vitamins_vitamins_vitamin_e;
		private BigDecimal vitamins_vitamins_vitamin_c;
		private BigDecimal vitamins_vitamins_thiamin;
		private BigDecimal vitamins_vitamins_riboflavin;
		private BigDecimal vitamins_vitamins_niacin;
		private BigDecimal vitamins_vitamins_vitamin_b6;
		private BigDecimal vitamins_vitamins_folate;
		private BigDecimal vitamins_vitamins_vitamin_b12;
		private BigDecimal vitamins_vitamins_vitamin_k;
		private BigDecimal vitamins_vitamins_pantothenic_acid;
		private BigDecimal vitamins_vitamins_choline;
		private BigDecimal minerals_minerals_calcium;
		private BigDecimal minerals_minerals_phosphorus;
		private BigDecimal minerals_minerals_magnesium;
		private BigDecimal minerals_minerals_iron;
		private BigDecimal minerals_minerals_zinc;
		private BigDecimal minerals_minerals_copper;
		private BigDecimal minerals_minerals_manganese;
		private BigDecimal minerals_minerals_selenium;
		private BigDecimal electrolytes_minerals_potassium;
		private BigDecimal electrolytes_minerals_sodium;
		private BigDecimal phytonutrients_phytonutrients_flavonoids;
		private BigDecimal phytonutrients_phytonutrients_anthocyanins;
		private BigDecimal phytonutrients_phytonutrients_carotenoids;
		private BigDecimal phytonutrients_phytonutrients_flavanols;
		private BigDecimal phytonutrients_phytonutrients_flavanones;
		private BigDecimal phytonutrients_phytonutrients_flavones;
		private BigDecimal phytonutrients_phytonutrients_flavonols;
		private BigDecimal phytonutrients_phytonutrients_isoflavones;
		private BigDecimal phytonutrients_phytonutrients_phytosterols;
		private BigDecimal phytonutrients_phytonutrients_beta_carotene;
		private BigDecimal phytonutrients_phytonutrients_lutein_zeaxanthin;
		private BigDecimal phytonutrients_phytonutrients_lycopene;
		private BigDecimal phytonutrients_phytonutrients_caffeine;
		private BigDecimal phytonutrients_phytonutrients_theobromine;
		private BigDecimal other_other_cost;
		private BigDecimal other_other_water;

		public Row() {

			id_food_id = "";
			id_food_name = "";
			id_other_weight = new BigDecimal( "0.0" );
			energy_energy_gross = new BigDecimal( "0.0" );
			energy_energy_digestible = new BigDecimal( "0.0" );
			energy_energy_fat = new BigDecimal( "0.0" );
			energy_energy_carbohydrate = new BigDecimal( "0.0" );
			energy_energy_fat_and_carbohydrate = new BigDecimal( "0.0" );
			energy_energy_protein = new BigDecimal( "0.0" );
			energy_energy_alcohol = new BigDecimal( "0.0" );
			macronutrients_fats_total = new BigDecimal( "0.0" );
			macronutrients_carbohydrates_digestible = new BigDecimal( "0.0" );
			macronutrients_protein_total = new BigDecimal( "0.0" );
			macronutrients_other_alcohol = new BigDecimal( "0.0" );
			protein_energy_protein = new BigDecimal( "0.0" );
			protein_protein_total = new BigDecimal( "0.0" );
			protein_protein_complete = new BigDecimal( "0.0" );
			fats_energy_fat = new BigDecimal( "0.0" );
			fats_fats_total = new BigDecimal( "0.0" );
			fats_fats_monounsaturated = new BigDecimal( "0.0" );
			fats_fats_polyunsaturated = new BigDecimal( "0.0" );
			fats_fats_saturated = new BigDecimal( "0.0" );
			fats_fats_cholesterol = new BigDecimal( "0.0" );
			sfa_fats_saturated = new BigDecimal( "0.0" );
			sfa_fats_hcsfa = new BigDecimal( "0.0" );
			sfa_fats_lauric = new BigDecimal( "0.0" );
			sfa_fats_myristic = new BigDecimal( "0.0" );
			sfa_fats_palmitic = new BigDecimal( "0.0" );
			sfa_fats_stearic = new BigDecimal( "0.0" );
			sfa_fats_cholesterol = new BigDecimal( "0.0" );
			pufa_fats_polyunsaturated = new BigDecimal( "0.0" );
			pufa_fats_linoleic = new BigDecimal( "0.0" );
			pufa_fats_linolenic = new BigDecimal( "0.0" );
			pufa_fats_epa = new BigDecimal( "0.0" );
			pufa_fats_dha = new BigDecimal( "0.0" );
			pufa_fats_lcn3pufa = new BigDecimal( "0.0" );
			carbs_energy_carbohydrate = new BigDecimal( "0.0" );
			carbs_carbohydrates_carbs_by_diff = new BigDecimal( "0.0" );
			carbs_carbohydrates_fiber = new BigDecimal( "0.0" );
			carbs_carbohydrates_fiber_insoluble = new BigDecimal( "0.0" );
			carbs_carbohydrates_fiber_soluble = new BigDecimal( "0.0" );
			carbs_carbohydrates_digestible = new BigDecimal( "0.0" );
			carbs_carbohydrates_starch = new BigDecimal( "0.0" );
			carbs_carbohydrates_sugars = new BigDecimal( "0.0" );
			carbs_carbohydrates_sucrose = new BigDecimal( "0.0" );
			carbs_carbohydrates_lactose = new BigDecimal( "0.0" );
			carbs_carbohydrates_fructose = new BigDecimal( "0.0" );
			carbs_carbohydrates_glucose = new BigDecimal( "0.0" );
			carbs_carbohydrates_glycemic_load = new BigDecimal( "0.0" );
			vitamins_vitamins_vitamin_a = new BigDecimal( "0.0" );
			vitamins_vitamins_vitamin_d = new BigDecimal( "0.0" );
			vitamins_vitamins_vitamin_e = new BigDecimal( "0.0" );
			vitamins_vitamins_vitamin_c = new BigDecimal( "0.0" );
			vitamins_vitamins_thiamin = new BigDecimal( "0.0" );
			vitamins_vitamins_riboflavin = new BigDecimal( "0.0" );
			vitamins_vitamins_niacin = new BigDecimal( "0.0" );
			vitamins_vitamins_vitamin_b6 = new BigDecimal( "0.0" );
			vitamins_vitamins_folate = new BigDecimal( "0.0" );
			vitamins_vitamins_vitamin_b12 = new BigDecimal( "0.0" );
			vitamins_vitamins_vitamin_k = new BigDecimal( "0.0" );
			vitamins_vitamins_pantothenic_acid = new BigDecimal( "0.0" );
			vitamins_vitamins_choline = new BigDecimal( "0.0" );
			minerals_minerals_calcium = new BigDecimal( "0.0" );
			minerals_minerals_phosphorus = new BigDecimal( "0.0" );
			minerals_minerals_magnesium = new BigDecimal( "0.0" );
			minerals_minerals_iron = new BigDecimal( "0.0" );
			minerals_minerals_zinc = new BigDecimal( "0.0" );
			minerals_minerals_copper = new BigDecimal( "0.0" );
			minerals_minerals_manganese = new BigDecimal( "0.0" );
			minerals_minerals_selenium = new BigDecimal( "0.0" );
			electrolytes_minerals_potassium = new BigDecimal( "0.0" );
			electrolytes_minerals_sodium = new BigDecimal( "0.0" );
			phytonutrients_phytonutrients_flavonoids = new BigDecimal( "0.0" );
			phytonutrients_phytonutrients_anthocyanins = new BigDecimal( "0.0" );
			phytonutrients_phytonutrients_carotenoids = new BigDecimal( "0.0" );
			phytonutrients_phytonutrients_flavanols = new BigDecimal( "0.0" );
			phytonutrients_phytonutrients_flavanones = new BigDecimal( "0.0" );
			phytonutrients_phytonutrients_flavones = new BigDecimal( "0.0" );
			phytonutrients_phytonutrients_flavonols = new BigDecimal( "0.0" );
			phytonutrients_phytonutrients_isoflavones = new BigDecimal( "0.0" );
			phytonutrients_phytonutrients_phytosterols = new BigDecimal( "0.0" );
			phytonutrients_phytonutrients_beta_carotene = new BigDecimal( "0.0" );
			phytonutrients_phytonutrients_lutein_zeaxanthin = new BigDecimal( "0.0" );
			phytonutrients_phytonutrients_lycopene = new BigDecimal( "0.0" );
			phytonutrients_phytonutrients_caffeine = new BigDecimal( "0.0" );
			phytonutrients_phytonutrients_theobromine = new BigDecimal( "0.0" );
			other_other_cost = new BigDecimal( "0.0" );
			other_other_water = new BigDecimal( "0.0" );

		}

		public String getId_food_id() {

			return id_food_id;

		}

		public void setId_food_id( String id_food_id ) {

			this.id_food_id = id_food_id;

		}

		public String getId_food_name() {

			return id_food_name;

		}

		public void setId_food_name( String id_food_name ) {

			this.id_food_name = id_food_name;

		}

		public BigDecimal getId_other_weight() {

			return id_other_weight;

		}

		public void setId_other_weight( BigDecimal id_other_weight ) {

			this.id_other_weight = id_other_weight;

		}

		public BigDecimal getEnergy_energy_gross() {

			return energy_energy_gross;

		}

		public void setEnergy_energy_gross( BigDecimal energy_energy_gross ) {

			this.energy_energy_gross = energy_energy_gross;

		}

		public BigDecimal getEnergy_energy_digestible() {

			return energy_energy_digestible;

		}

		public void setEnergy_energy_digestible( BigDecimal energy_energy_digestible ) {

			this.energy_energy_digestible = energy_energy_digestible;

		}

		public BigDecimal getEnergy_energy_fat() {

			return energy_energy_fat;

		}

		public void setEnergy_energy_fat( BigDecimal energy_energy_fat ) {

			this.energy_energy_fat = energy_energy_fat;

		}

		public BigDecimal getEnergy_energy_carbohydrate() {

			return energy_energy_carbohydrate;

		}

		public void setEnergy_energy_carbohydrate( BigDecimal energy_energy_carbohydrate ) {

			this.energy_energy_carbohydrate = energy_energy_carbohydrate;

		}

		public BigDecimal getEnergy_energy_fat_and_carbohydrate() {

			return energy_energy_fat_and_carbohydrate;

		}

		public void setEnergy_energy_fat_and_carbohydrate( BigDecimal energy_energy_fat_and_carbohydrate ) {

			this.energy_energy_fat_and_carbohydrate = energy_energy_fat_and_carbohydrate;

		}

		public BigDecimal getEnergy_energy_protein() {

			return energy_energy_protein;

		}

		public void setEnergy_energy_protein( BigDecimal energy_energy_protein ) {

			this.energy_energy_protein = energy_energy_protein;

		}

		public BigDecimal getEnergy_energy_alcohol() {

			return energy_energy_alcohol;

		}

		public void setEnergy_energy_alcohol( BigDecimal energy_energy_alcohol ) {

			this.energy_energy_alcohol = energy_energy_alcohol;

		}

		public BigDecimal getMacronutrients_fats_total() {

			return macronutrients_fats_total;

		}

		public void setMacronutrients_fats_total( BigDecimal macronutrients_fats_total ) {

			this.macronutrients_fats_total = macronutrients_fats_total;

		}

		public BigDecimal getMacronutrients_carbohydrates_digestible() {

			return macronutrients_carbohydrates_digestible;

		}

		public void setMacronutrients_carbohydrates_digestible( BigDecimal macronutrients_carbohydrates_digestible ) {

			this.macronutrients_carbohydrates_digestible = macronutrients_carbohydrates_digestible;

		}

		public BigDecimal getMacronutrients_protein_total() {

			return macronutrients_protein_total;

		}

		public void setMacronutrients_protein_total( BigDecimal macronutrients_protein_total ) {

			this.macronutrients_protein_total = macronutrients_protein_total;

		}

		public BigDecimal getMacronutrients_other_alcohol() {

			return macronutrients_other_alcohol;

		}

		public void setMacronutrients_other_alcohol( BigDecimal macronutrients_other_alcohol ) {

			this.macronutrients_other_alcohol = macronutrients_other_alcohol;

		}

		public BigDecimal getProtein_energy_protein() {

			return protein_energy_protein;

		}

		public void setProtein_energy_protein( BigDecimal protein_energy_protein ) {

			this.protein_energy_protein = protein_energy_protein;

		}

		public BigDecimal getProtein_protein_total() {

			return protein_protein_total;

		}

		public void setProtein_protein_total( BigDecimal protein_protein_total ) {

			this.protein_protein_total = protein_protein_total;

		}

		public BigDecimal getProtein_protein_complete() {

			return protein_protein_complete;

		}

		public void setProtein_protein_complete( BigDecimal protein_protein_complete ) {

			this.protein_protein_complete = protein_protein_complete;

		}

		public BigDecimal getFats_energy_fat() {

			return fats_energy_fat;

		}

		public void setFats_energy_fat( BigDecimal fats_energy_fat ) {

			this.fats_energy_fat = fats_energy_fat;

		}

		public BigDecimal getFats_fats_total() {

			return fats_fats_total;

		}

		public void setFats_fats_total( BigDecimal fats_fats_total ) {

			this.fats_fats_total = fats_fats_total;

		}

		public BigDecimal getFats_fats_monounsaturated() {

			return fats_fats_monounsaturated;

		}

		public void setFats_fats_monounsaturated( BigDecimal fats_fats_monounsaturated ) {

			this.fats_fats_monounsaturated = fats_fats_monounsaturated;

		}

		public BigDecimal getFats_fats_polyunsaturated() {

			return fats_fats_polyunsaturated;

		}

		public void setFats_fats_polyunsaturated( BigDecimal fats_fats_polyunsaturated ) {

			this.fats_fats_polyunsaturated = fats_fats_polyunsaturated;

		}

		public BigDecimal getFats_fats_saturated() {

			return fats_fats_saturated;

		}

		public void setFats_fats_saturated( BigDecimal fats_fats_saturated ) {

			this.fats_fats_saturated = fats_fats_saturated;

		}

		public BigDecimal getFats_fats_cholesterol() {

			return fats_fats_cholesterol;

		}

		public void setFats_fats_cholesterol( BigDecimal fats_fats_cholesterol ) {

			this.fats_fats_cholesterol = fats_fats_cholesterol;

		}

		public BigDecimal getSfa_fats_saturated() {

			return sfa_fats_saturated;

		}

		public void setSfa_fats_saturated( BigDecimal sfa_fats_saturated ) {

			this.sfa_fats_saturated = sfa_fats_saturated;

		}

		public BigDecimal getSfa_fats_hcsfa() {

			return sfa_fats_hcsfa;

		}

		public void setSfa_fats_hcsfa( BigDecimal sfa_fats_hcsfa ) {

			this.sfa_fats_hcsfa = sfa_fats_hcsfa;

		}

		public BigDecimal getSfa_fats_lauric() {

			return sfa_fats_lauric;

		}

		public void setSfa_fats_lauric( BigDecimal sfa_fats_lauric ) {

			this.sfa_fats_lauric = sfa_fats_lauric;

		}

		public BigDecimal getSfa_fats_myristic() {

			return sfa_fats_myristic;

		}

		public void setSfa_fats_myristic( BigDecimal sfa_fats_myristic ) {

			this.sfa_fats_myristic = sfa_fats_myristic;

		}

		public BigDecimal getSfa_fats_palmitic() {

			return sfa_fats_palmitic;

		}

		public void setSfa_fats_palmitic( BigDecimal sfa_fats_palmitic ) {

			this.sfa_fats_palmitic = sfa_fats_palmitic;

		}

		public BigDecimal getSfa_fats_stearic() {

			return sfa_fats_stearic;

		}

		public void setSfa_fats_stearic( BigDecimal sfa_fats_stearic ) {

			this.sfa_fats_stearic = sfa_fats_stearic;

		}

		public BigDecimal getSfa_fats_cholesterol() {

			return sfa_fats_cholesterol;

		}

		public void setSfa_fats_cholesterol( BigDecimal sfa_fats_cholesterol ) {

			this.sfa_fats_cholesterol = sfa_fats_cholesterol;

		}

		public BigDecimal getPufa_fats_polyunsaturated() {

			return pufa_fats_polyunsaturated;

		}

		public void setPufa_fats_polyunsaturated( BigDecimal pufa_fats_polyunsaturated ) {

			this.pufa_fats_polyunsaturated = pufa_fats_polyunsaturated;

		}

		public BigDecimal getPufa_fats_linoleic() {

			return pufa_fats_linoleic;

		}

		public void setPufa_fats_linoleic( BigDecimal pufa_fats_linoleic ) {

			this.pufa_fats_linoleic = pufa_fats_linoleic;

		}

		public BigDecimal getPufa_fats_linolenic() {

			return pufa_fats_linolenic;

		}

		public void setPufa_fats_linolenic( BigDecimal pufa_fats_linolenic ) {

			this.pufa_fats_linolenic = pufa_fats_linolenic;

		}

		public BigDecimal getPufa_fats_epa() {

			return pufa_fats_epa;

		}

		public void setPufa_fats_epa( BigDecimal pufa_fats_epa ) {

			this.pufa_fats_epa = pufa_fats_epa;

		}

		public BigDecimal getPufa_fats_dha() {

			return pufa_fats_dha;

		}

		public void setPufa_fats_dha( BigDecimal pufa_fats_dha ) {

			this.pufa_fats_dha = pufa_fats_dha;

		}

		public BigDecimal getPufa_fats_lcn3pufa() {

			return pufa_fats_lcn3pufa;

		}

		public void setPufa_fats_lcn3pufa( BigDecimal pufa_fats_lcn3pufa ) {

			this.pufa_fats_lcn3pufa = pufa_fats_lcn3pufa;

		}

		public BigDecimal getCarbs_energy_carbohydrate() {

			return carbs_energy_carbohydrate;

		}

		public void setCarbs_energy_carbohydrate( BigDecimal carbs_energy_carbohydrate ) {

			this.carbs_energy_carbohydrate = carbs_energy_carbohydrate;

		}

		public BigDecimal getCarbs_carbohydrates_carbs_by_diff() {

			return carbs_carbohydrates_carbs_by_diff;

		}

		public void setCarbs_carbohydrates_carbs_by_diff( BigDecimal carbs_carbohydrates_carbs_by_diff ) {

			this.carbs_carbohydrates_carbs_by_diff = carbs_carbohydrates_carbs_by_diff;

		}

		public BigDecimal getCarbs_carbohydrates_fiber() {

			return carbs_carbohydrates_fiber;

		}

		public void setCarbs_carbohydrates_fiber( BigDecimal carbs_carbohydrates_fiber ) {

			this.carbs_carbohydrates_fiber = carbs_carbohydrates_fiber;

		}

		public BigDecimal getCarbs_carbohydrates_fiber_insoluble() {

			return carbs_carbohydrates_fiber_insoluble;

		}

		public void setCarbs_carbohydrates_fiber_insoluble( BigDecimal carbs_carbohydrates_fiber_insoluble ) {

			this.carbs_carbohydrates_fiber_insoluble = carbs_carbohydrates_fiber_insoluble;

		}

		public BigDecimal getCarbs_carbohydrates_fiber_soluble() {

			return carbs_carbohydrates_fiber_soluble;

		}

		public void setCarbs_carbohydrates_fiber_soluble( BigDecimal carbs_carbohydrates_fiber_soluble ) {

			this.carbs_carbohydrates_fiber_soluble = carbs_carbohydrates_fiber_soluble;

		}

		public BigDecimal getCarbs_carbohydrates_digestible() {

			return carbs_carbohydrates_digestible;

		}

		public void setCarbs_carbohydrates_digestible( BigDecimal carbs_carbohydrates_digestible ) {

			this.carbs_carbohydrates_digestible = carbs_carbohydrates_digestible;

		}

		public BigDecimal getCarbs_carbohydrates_starch() {

			return carbs_carbohydrates_starch;

		}

		public void setCarbs_carbohydrates_starch( BigDecimal carbs_carbohydrates_starch ) {

			this.carbs_carbohydrates_starch = carbs_carbohydrates_starch;

		}

		public BigDecimal getCarbs_carbohydrates_sugars() {

			return carbs_carbohydrates_sugars;

		}

		public void setCarbs_carbohydrates_sugars( BigDecimal carbs_carbohydrates_sugars ) {

			this.carbs_carbohydrates_sugars = carbs_carbohydrates_sugars;

		}

		public BigDecimal getCarbs_carbohydrates_sucrose() {

			return carbs_carbohydrates_sucrose;

		}

		public void setCarbs_carbohydrates_sucrose( BigDecimal carbs_carbohydrates_sucrose ) {

			this.carbs_carbohydrates_sucrose = carbs_carbohydrates_sucrose;

		}

		public BigDecimal getCarbs_carbohydrates_lactose() {

			return carbs_carbohydrates_lactose;

		}

		public void setCarbs_carbohydrates_lactose( BigDecimal carbs_carbohydrates_lactose ) {

			this.carbs_carbohydrates_lactose = carbs_carbohydrates_lactose;

		}

		public BigDecimal getCarbs_carbohydrates_fructose() {

			return carbs_carbohydrates_fructose;

		}

		public void setCarbs_carbohydrates_fructose( BigDecimal carbs_carbohydrates_fructose ) {

			this.carbs_carbohydrates_fructose = carbs_carbohydrates_fructose;

		}

		public BigDecimal getCarbs_carbohydrates_glucose() {

			return carbs_carbohydrates_glucose;

		}

		public void setCarbs_carbohydrates_glucose( BigDecimal carbs_carbohydrates_glucose ) {

			this.carbs_carbohydrates_glucose = carbs_carbohydrates_glucose;

		}

		public BigDecimal getCarbs_carbohydrates_glycemic_load() {

			return carbs_carbohydrates_glycemic_load;

		}

		public void setCarbs_carbohydrates_glycemic_load( BigDecimal carbs_carbohydrates_glycemic_load ) {

			this.carbs_carbohydrates_glycemic_load = carbs_carbohydrates_glycemic_load;

		}

		public BigDecimal getVitamins_vitamins_vitamin_a() {

			return vitamins_vitamins_vitamin_a;

		}

		public void setVitamins_vitamins_vitamin_a( BigDecimal vitamins_vitamins_vitamin_a ) {

			this.vitamins_vitamins_vitamin_a = vitamins_vitamins_vitamin_a;

		}

		public BigDecimal getVitamins_vitamins_vitamin_d() {

			return vitamins_vitamins_vitamin_d;

		}

		public void setVitamins_vitamins_vitamin_d( BigDecimal vitamins_vitamins_vitamin_d ) {

			this.vitamins_vitamins_vitamin_d = vitamins_vitamins_vitamin_d;

		}

		public BigDecimal getVitamins_vitamins_vitamin_e() {

			return vitamins_vitamins_vitamin_e;

		}

		public void setVitamins_vitamins_vitamin_e( BigDecimal vitamins_vitamins_vitamin_e ) {

			this.vitamins_vitamins_vitamin_e = vitamins_vitamins_vitamin_e;

		}

		public BigDecimal getVitamins_vitamins_vitamin_c() {

			return vitamins_vitamins_vitamin_c;

		}

		public void setVitamins_vitamins_vitamin_c( BigDecimal vitamins_vitamins_vitamin_c ) {

			this.vitamins_vitamins_vitamin_c = vitamins_vitamins_vitamin_c;

		}

		public BigDecimal getVitamins_vitamins_thiamin() {

			return vitamins_vitamins_thiamin;

		}

		public void setVitamins_vitamins_thiamin( BigDecimal vitamins_vitamins_thiamin ) {

			this.vitamins_vitamins_thiamin = vitamins_vitamins_thiamin;

		}

		public BigDecimal getVitamins_vitamins_riboflavin() {

			return vitamins_vitamins_riboflavin;

		}

		public void setVitamins_vitamins_riboflavin( BigDecimal vitamins_vitamins_riboflavin ) {

			this.vitamins_vitamins_riboflavin = vitamins_vitamins_riboflavin;

		}

		public BigDecimal getVitamins_vitamins_niacin() {

			return vitamins_vitamins_niacin;

		}

		public void setVitamins_vitamins_niacin( BigDecimal vitamins_vitamins_niacin ) {

			this.vitamins_vitamins_niacin = vitamins_vitamins_niacin;

		}

		public BigDecimal getVitamins_vitamins_vitamin_b6() {

			return vitamins_vitamins_vitamin_b6;

		}

		public void setVitamins_vitamins_vitamin_b6( BigDecimal vitamins_vitamins_vitamin_b6 ) {

			this.vitamins_vitamins_vitamin_b6 = vitamins_vitamins_vitamin_b6;

		}

		public BigDecimal getVitamins_vitamins_folate() {

			return vitamins_vitamins_folate;

		}

		public void setVitamins_vitamins_folate( BigDecimal vitamins_vitamins_folate ) {

			this.vitamins_vitamins_folate = vitamins_vitamins_folate;

		}

		public BigDecimal getVitamins_vitamins_vitamin_b12() {

			return vitamins_vitamins_vitamin_b12;

		}

		public void setVitamins_vitamins_vitamin_b12( BigDecimal vitamins_vitamins_vitamin_b12 ) {

			this.vitamins_vitamins_vitamin_b12 = vitamins_vitamins_vitamin_b12;

		}

		public BigDecimal getVitamins_vitamins_vitamin_k() {

			return vitamins_vitamins_vitamin_k;

		}

		public void setVitamins_vitamins_vitamin_k( BigDecimal vitamins_vitamins_vitamin_k ) {

			this.vitamins_vitamins_vitamin_k = vitamins_vitamins_vitamin_k;

		}

		public BigDecimal getVitamins_vitamins_pantothenic_acid() {

			return vitamins_vitamins_pantothenic_acid;

		}

		public void setVitamins_vitamins_pantothenic_acid( BigDecimal vitamins_vitamins_pantothenic_acid ) {

			this.vitamins_vitamins_pantothenic_acid = vitamins_vitamins_pantothenic_acid;

		}

		public BigDecimal getVitamins_vitamins_choline() {

			return vitamins_vitamins_choline;

		}

		public void setVitamins_vitamins_choline( BigDecimal vitamins_vitamins_choline ) {

			this.vitamins_vitamins_choline = vitamins_vitamins_choline;

		}

		public BigDecimal getMinerals_minerals_calcium() {

			return minerals_minerals_calcium;

		}

		public void setMinerals_minerals_calcium( BigDecimal minerals_minerals_calcium ) {

			this.minerals_minerals_calcium = minerals_minerals_calcium;

		}

		public BigDecimal getMinerals_minerals_phosphorus() {

			return minerals_minerals_phosphorus;

		}

		public void setMinerals_minerals_phosphorus( BigDecimal minerals_minerals_phosphorus ) {

			this.minerals_minerals_phosphorus = minerals_minerals_phosphorus;

		}

		public BigDecimal getMinerals_minerals_magnesium() {

			return minerals_minerals_magnesium;

		}

		public void setMinerals_minerals_magnesium( BigDecimal minerals_minerals_magnesium ) {

			this.minerals_minerals_magnesium = minerals_minerals_magnesium;

		}

		public BigDecimal getMinerals_minerals_iron() {

			return minerals_minerals_iron;

		}

		public void setMinerals_minerals_iron( BigDecimal minerals_minerals_iron ) {

			this.minerals_minerals_iron = minerals_minerals_iron;

		}

		public BigDecimal getMinerals_minerals_zinc() {

			return minerals_minerals_zinc;

		}

		public void setMinerals_minerals_zinc( BigDecimal minerals_minerals_zinc ) {

			this.minerals_minerals_zinc = minerals_minerals_zinc;

		}

		public BigDecimal getMinerals_minerals_copper() {

			return minerals_minerals_copper;

		}

		public void setMinerals_minerals_copper( BigDecimal minerals_minerals_copper ) {

			this.minerals_minerals_copper = minerals_minerals_copper;

		}

		public BigDecimal getMinerals_minerals_manganese() {

			return minerals_minerals_manganese;

		}

		public void setMinerals_minerals_manganese( BigDecimal minerals_minerals_manganese ) {

			this.minerals_minerals_manganese = minerals_minerals_manganese;

		}

		public BigDecimal getMinerals_minerals_selenium() {

			return minerals_minerals_selenium;

		}

		public void setMinerals_minerals_selenium( BigDecimal minerals_minerals_selenium ) {

			this.minerals_minerals_selenium = minerals_minerals_selenium;

		}

		public BigDecimal getElectrolytes_minerals_potassium() {

			return electrolytes_minerals_potassium;

		}

		public void setElectrolytes_minerals_potassium( BigDecimal electrolytes_minerals_potassium ) {

			this.electrolytes_minerals_potassium = electrolytes_minerals_potassium;

		}

		public BigDecimal getElectrolytes_minerals_sodium() {

			return electrolytes_minerals_sodium;

		}

		public void setElectrolytes_minerals_sodium( BigDecimal electrolytes_minerals_sodium ) {

			this.electrolytes_minerals_sodium = electrolytes_minerals_sodium;

		}

		public BigDecimal getPhytonutrients_phytonutrients_flavonoids() {

			return phytonutrients_phytonutrients_flavonoids;

		}

		public void setPhytonutrients_phytonutrients_flavonoids( BigDecimal phytonutrients_phytonutrients_flavonoids ) {

			this.phytonutrients_phytonutrients_flavonoids = phytonutrients_phytonutrients_flavonoids;

		}

		public BigDecimal getPhytonutrients_phytonutrients_anthocyanins() {

			return phytonutrients_phytonutrients_anthocyanins;

		}

		public void setPhytonutrients_phytonutrients_anthocyanins(
				BigDecimal phytonutrients_phytonutrients_anthocyanins ) {

			this.phytonutrients_phytonutrients_anthocyanins = phytonutrients_phytonutrients_anthocyanins;

		}

		public BigDecimal getPhytonutrients_phytonutrients_carotenoids() {

			return phytonutrients_phytonutrients_carotenoids;

		}

		public void setPhytonutrients_phytonutrients_carotenoids(
				BigDecimal phytonutrients_phytonutrients_carotenoids ) {

			this.phytonutrients_phytonutrients_carotenoids = phytonutrients_phytonutrients_carotenoids;

		}

		public BigDecimal getPhytonutrients_phytonutrients_flavanols() {

			return phytonutrients_phytonutrients_flavanols;

		}

		public void setPhytonutrients_phytonutrients_flavanols( BigDecimal phytonutrients_phytonutrients_flavanols ) {

			this.phytonutrients_phytonutrients_flavanols = phytonutrients_phytonutrients_flavanols;

		}

		public BigDecimal getPhytonutrients_phytonutrients_flavanones() {

			return phytonutrients_phytonutrients_flavanones;

		}

		public void setPhytonutrients_phytonutrients_flavanones( BigDecimal phytonutrients_phytonutrients_flavanones ) {

			this.phytonutrients_phytonutrients_flavanones = phytonutrients_phytonutrients_flavanones;

		}

		public BigDecimal getPhytonutrients_phytonutrients_flavones() {

			return phytonutrients_phytonutrients_flavones;

		}

		public void setPhytonutrients_phytonutrients_flavones( BigDecimal phytonutrients_phytonutrients_flavones ) {

			this.phytonutrients_phytonutrients_flavones = phytonutrients_phytonutrients_flavones;

		}

		public BigDecimal getPhytonutrients_phytonutrients_flavonols() {

			return phytonutrients_phytonutrients_flavonols;

		}

		public void setPhytonutrients_phytonutrients_flavonols( BigDecimal phytonutrients_phytonutrients_flavonols ) {

			this.phytonutrients_phytonutrients_flavonols = phytonutrients_phytonutrients_flavonols;

		}

		public BigDecimal getPhytonutrients_phytonutrients_isoflavones() {

			return phytonutrients_phytonutrients_isoflavones;

		}

		public void setPhytonutrients_phytonutrients_isoflavones(
				BigDecimal phytonutrients_phytonutrients_isoflavones ) {

			this.phytonutrients_phytonutrients_isoflavones = phytonutrients_phytonutrients_isoflavones;

		}

		public BigDecimal getPhytonutrients_phytonutrients_phytosterols() {

			return phytonutrients_phytonutrients_phytosterols;

		}

		public void setPhytonutrients_phytonutrients_phytosterols(
				BigDecimal phytonutrients_phytonutrients_phytosterols ) {

			this.phytonutrients_phytonutrients_phytosterols = phytonutrients_phytonutrients_phytosterols;

		}

		public BigDecimal getPhytonutrients_phytonutrients_beta_carotene() {

			return phytonutrients_phytonutrients_beta_carotene;

		}

		public void setPhytonutrients_phytonutrients_beta_carotene(
				BigDecimal phytonutrients_phytonutrients_beta_carotene ) {

			this.phytonutrients_phytonutrients_beta_carotene = phytonutrients_phytonutrients_beta_carotene;

		}

		public BigDecimal getPhytonutrients_phytonutrients_lutein_zeaxanthin() {

			return phytonutrients_phytonutrients_lutein_zeaxanthin;

		}

		public void setPhytonutrients_phytonutrients_lutein_zeaxanthin(
				BigDecimal phytonutrients_phytonutrients_lutein_zeaxanthin ) {

			this.phytonutrients_phytonutrients_lutein_zeaxanthin = phytonutrients_phytonutrients_lutein_zeaxanthin;

		}

		public BigDecimal getPhytonutrients_phytonutrients_lycopene() {

			return phytonutrients_phytonutrients_lycopene;

		}

		public void setPhytonutrients_phytonutrients_lycopene( BigDecimal phytonutrients_phytonutrients_lycopene ) {

			this.phytonutrients_phytonutrients_lycopene = phytonutrients_phytonutrients_lycopene;

		}

		public BigDecimal getPhytonutrients_phytonutrients_caffeine() {

			return phytonutrients_phytonutrients_caffeine;

		}

		public void setPhytonutrients_phytonutrients_caffeine( BigDecimal phytonutrients_phytonutrients_caffeine ) {

			this.phytonutrients_phytonutrients_caffeine = phytonutrients_phytonutrients_caffeine;

		}

		public BigDecimal getPhytonutrients_phytonutrients_theobromine() {

			return phytonutrients_phytonutrients_theobromine;

		}

		public void setPhytonutrients_phytonutrients_theobromine(
				BigDecimal phytonutrients_phytonutrients_theobromine ) {

			this.phytonutrients_phytonutrients_theobromine = phytonutrients_phytonutrients_theobromine;

		}

		public BigDecimal getOther_other_cost() {

			return other_other_cost;

		}

		public void setOther_other_cost( BigDecimal other_other_cost ) {

			this.other_other_cost = other_other_cost;

		}

		public BigDecimal getOther_other_water() {

			return other_other_water;

		}

		public void setOther_other_water( BigDecimal other_other_water ) {

			this.other_other_water = other_other_water;

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
				return columnToolTips[realIndex];

			}
		};

	}

	protected String[] columnToolTips = new String[] {
			"Food Id",
			"Food Name",
			"Other, Weight (g), 10000, other-weight",
			"Energy, Gross (kcal), 208, energy-gross",
			"Energy, digestible (kcal), 10009, energy-digestible",
			"Energy, Fat (kcal), 10013, energy-fat",
			"Energy, Carbohydrate (kcal), 10011, energy-carbohydrate",
			"Energy, Fat and Carbohydrate (kcal), 10010, energy-fat_and_carbohydrate",
			"Energy, Protein (kcal), 10012, energy-protein",
			"Energy, alcohol (kcal), 10014, energy-alcohol",
			"Fats, Total Fat (g), 204, fats-total",
			"Carbohydrates, digestible (g), 10003, carbohydrates-digestible",
			"Protein, Total Protein (g), 203, protein-total",
			"Other, Alcohol (g), 221, other-alcohol",
			"Energy, Protein (kcal), 10012, energy-protein",
			"Protein, Total Protein (g), 203, protein-total",
			"Protein, Complete Protein (g), 10001, protein-complete",
			"Energy, Fat (kcal), 10013, energy-fat",
			"Fats, Total Fat (g), 204, fats-total",
			"Fats, Monounsaturated Fat, MUFA (g), 645, fats-monounsaturated",
			"Fats, Polyunsaturated Fat, PUFA (g), 646, fats-polyunsaturated",
			"Fats, Saturated Fat, SFA (g), 606, fats-saturated",
			"Fats, Cholesterol (mg), 601, fats-cholesterol",
			"Fats, Saturated Fat, SFA (g), 606, fats-saturated",
			"Fats, Hypercholesterolemic Fat (g), 10015, fats-hcsfa",
			"Fats, Lauric Acid, 12:0 (g), 611, fats-lauric",
			"Fats, Myristic Acid, 14:0 (g), 612, fats-myristic",
			"Fats, Palmitic Acid, 16:0 (g), 613, fats-palmitic",
			"Fats, Stearic Acid, 18:0 (g), 614, fats-stearic",
			"Fats, Cholesterol (mg), 601, fats-cholesterol",
			"Fats, Polyunsaturated Fat, PUFA (g), 646, fats-polyunsaturated",
			"Fats, Linoleic Acid, LA, 18:2 n-6 (g), 618, fats-linoleic",
			"Fats, Linolenic Acid, ALA, 18:3 n-3 (g), 619, fats-linolenic",
			"Fats, Eicosapentaenoic Acid, EPA, 20:5 n-3 (g), 629, fats-epa",
			"Fats, Docosahexaenoic Acid, DHA, 22:6 n-3 (g), 621, fats-dha",
			"Fats, Long Chain n-3 PUFA (g), 10016, fats-lcn3pufa",
			"Energy, Carbohydrate (kcal), 10011, energy-carbohydrate",
			"Carbohydrates, By Difference (g), 205, carbohydrates-carbs_by_diff",
			"Carbohydrates, Fiber (g), 291, carbohydrates-fiber",
			"Carbohydrates, Fiber, Insoluble (g), 10018, carbohydrates-fiber_insoluble",
			"Carbohydrates, Fiber, Soluble (g), 10017, carbohydrates-fiber_soluble",
			"Carbohydrates, digestible (g), 10003, carbohydrates-digestible",
			"Carbohydrates, Starch (g), 209, carbohydrates-starch",
			"Carbohydrates, Sugars (g), 269, carbohydrates-sugars",
			"Carbohydrates, Sucrose (g), 210, carbohydrates-sucrose",
			"Carbohydrates, Lactose (g), 213, carbohydrates-lactose",
			"Carbohydrates, Fructose (g), 212, carbohydrates-fructose",
			"Carbohydrates, Glucose (g), 211, carbohydrates-glucose",
			"Carbohydrates, Glycemic Load (g), 10006, carbohydrates-glycemic_load",
			"Vitamins, A, RAE (mcg), 320, vitamins-vitamin_a",
			"Vitamins, D (mcg), 328, vitamins-vitamin_d",
			"Vitamins, E (mg), 323, vitamins-vitamin_e",
			"Vitamins, C (mg), 401, vitamins-vitamin_c",
			"Vitamins, Thiamin (mg), 404, vitamins-thiamin",
			"Vitamins, Riboflavin (mg), 405, vitamins-riboflavin",
			"Vitamins, Niacin (mg), 406, vitamins-niacin",
			"Vitamins, B6 (mg), 415, vitamins-vitamin_b6",
			"Vitamins, Folate, DFE (mcg), 435, vitamins-folate",
			"Vitamins, B12 (mcg), 418, vitamins-vitamin_b12",
			"Vitamins, K (mcg), 430, vitamins-vitamin_k",
			"Vitamins, Pantothenic Acid (mg), 410, vitamins-pantothenic_acid",
			"Vitamins, Choline (mg), 421, vitamins-choline",
			"Minerals, Calcium (mg), 301, minerals-calcium",
			"Minerals, Phosphorus (mg), 305, minerals-phosphorus",
			"Minerals, Magnesium (mg), 304, minerals-magnesium",
			"Minerals, Iron (mg), 303, minerals-iron",
			"Minerals, Zinc (mg), 309, minerals-zinc",
			"Minerals, Copper (mg), 312, minerals-copper",
			"Minerals, Manganese (mg), 315, minerals-manganese",
			"Minerals, Selenium (mcg), 317, minerals-selenium",
			"Minerals, Potassium (mg), 306, minerals-potassium",
			"Minerals, Sodium (mg), 307, minerals-sodium",
			"Phytonutrients, Flavonoids (mg), 10026, phytonutrients-flavonoids",
			"Phytonutrients, Anthocyanins (mg), 10024, phytonutrients-anthocyanins",
			"Phytonutrients, Carotenoids (mcg), 10019, phytonutrients-carotenoids",
			"Phytonutrients, Flavanols (mg), 10022, phytonutrients-flavanols",
			"Phytonutrients, Flavanones (mg), 10023, phytonutrients-flavanones",
			"Phytonutrients, Flavones (mg), 10021, phytonutrients-flavones",
			"Phytonutrients, Flavonols (mg), 10020, phytonutrients-flavonols",
			"Phytonutrients, Isoflavones (mg), 10025, phytonutrients-isoflavones",
			"Phytonutrients, Phytosterols (mg), 636, phytonutrients-phytosterols",
			"Phytonutrients, Carotene, beta (mcg), 321, phytonutrients-beta_carotene",
			"Phytonutrients, Lutein + zeaxanthin (mcg), 338, phytonutrients-lutein_zeaxanthin",
			"Phytonutrients, Lycopene (mcg), 337, phytonutrients-lycopene",
			"Phytonutrients, Caffeine (mg), 262, phytonutrients-caffeine",
			"Phytonutrients, Theobromine (mg), 263, phytonutrients-theobromine",
			"Other, Cost ($), 10005, other-cost",
			"Other, Water (g), 255, other-water"
	};

}
