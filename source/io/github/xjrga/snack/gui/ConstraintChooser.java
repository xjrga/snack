package io.github.xjrga.snack.gui;

import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;
import io.github.xjrga.snack.database.callable.BackgroundExec;
import io.github.xjrga.snack.database.callable.select.NutrientsTask;
import io.github.xjrga.snack.database.callable.update.UpdateNutrientTask;
import io.github.xjrga.snack.logger.LoggerImpl;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

/**
 * @author jr
 */
public class ConstraintChooser {

	private final CellConstraints cc;
	private final List<JCheckBox> chkBoxes;

	public ConstraintChooser() {

		cc = new CellConstraints();
		chkBoxes = new ArrayList();

		try {

			Future<List<Map<String, Object>>> task = BackgroundExec.submit( new NutrientsTask() );
			List<Map<String, Object>> list = task.get();

			if ( list.isEmpty() ) {

				return;

			}

			list.forEach( row -> {

				String nutrientid = ( String ) row.get( "NUTRIENTID" );
				String name = ( String ) row.get( "NAME" );
				int visible = ( int ) row.get( "VISIBLE" );
				JCheckBox chk = new JCheckBox();
				chk.setName( nutrientid );
				chk.setText( name );
				chk.setSelected( visible == 1 );
				chkBoxes.add( chk );

			} );
			chkBoxes.sort( new ABComparator() );

		} catch (Exception e) {

			LoggerImpl.INSTANCE.logProblem( e );

		}

	}

	public void show() {

		JComponent[] inputs = {
				panel()
		};
		int optionValue = createDialog( inputs, "Nutrients, Energies and Cost Constraints" );

		if ( optionValue == -1 || optionValue == 2 ) {

			return;

		}

		chkBoxes.forEach( ( JCheckBox o ) -> {

			if ( o.isSelected() ) {

				try {

					Future<Boolean> task = BackgroundExec.submit( new UpdateNutrientTask( o.getName(), 1 ) );
					Boolean completed = task.get();

					if ( !completed ) {

						return;

					}

				} catch (Exception e) {

					LoggerImpl.INSTANCE.logProblem( e );

				}

			} else {

				try {

					Future<Boolean> task = BackgroundExec.submit( new UpdateNutrientTask( o.getName(), 0 ) );
					Boolean completed = task.get();

					if ( !completed ) {

						return;

					}

				} catch (Exception e) {

					LoggerImpl.INSTANCE.logProblem( e );

				}

			}

		} );

	}

	private JPanel panel() {

		JPanel pnl = new JPanel();
		FormLayout lyo = new FormLayout( "4px,min:grow,4px", // columns
				"4px,30px,fill:min:grow,4px" // rows
		);
		JPanel pnl01 = new JPanel();
		FormLayout lyo01 = new FormLayout( "min,min", // columns
				"min,min,min,min,min,min,min,min,min,min,min,min,min,min,min,min,min,min,min,min,min,min,min,min,min,min,min,min,min,min,min,min,min,min,min,min,min,min,min,min,min,min,min,min,min,min,min,min,min,min,min,min,min,min,min,min,min,min,min,min,min,min,min,min,min,min,min,min,min,min,min,min,min,min,min,min,min,min,min,min" // rows
		);
		pnl.setLayout( lyo );
		JScrollPane scr = new JScrollPane( pnl01 );
		pnl.add( radioButtons(), cc.xy( 2, 2 ) );
		pnl.add( scr, cc.xy( 2, 3 ) );
		pnl01.setLayout( lyo01 );
		JCheckBox[] arr = chkBoxes.toArray( new JCheckBox[0] );

		for ( int i = 0; i < arr.length; i++ ) {

			JCheckBox chk = arr[i];
			JLabel lbl = new JLabel();
			lbl.setText( chk.getText() );
			lbl.setHorizontalAlignment( SwingConstants.RIGHT );
			chk.setText( "" );
			pnl01.add( lbl, cc.xy( 1, i + 1 ) );
			pnl01.add( chk, cc.xy( 2, i + 1 ) );

		}

		return pnl;

	}

	private JPanel radioButtons() {

		JPanel pnl = new JPanel();
		FormLayout lyo = new FormLayout( "p,p", // columns
				"fill:p:grow" // rows
		);
		pnl.setLayout( lyo );
		JRadioButton radSelect = new JRadioButton();
		JRadioButton radDeselect = new JRadioButton();
		radSelect.setText( "Select" );
		radSelect.setSelected( true );
		radDeselect.setText( "Deselect" );
		pnl.add( radSelect, cc.xy( 1, 1 ) );
		pnl.add( radDeselect, cc.xy( 2, 1 ) );
		ButtonGroup group = new ButtonGroup();
		group.add( radSelect );
		group.add( radDeselect );
		radSelect.addActionListener( ( ActionEvent e ) -> {

			chkBoxes.forEach( ( JCheckBox o ) -> {

				o.setSelected( true );

			} );

		} );
		radDeselect.addActionListener( ( ActionEvent e ) -> {

			chkBoxes.forEach( ( JCheckBox o ) -> {

				o.setSelected( false );

			} );

		} );
		return pnl;

	}

	private int createDialog( JComponent[] inputs, String title ) {

		JOptionPane optionPane = new JOptionPane( inputs, JOptionPane.PLAIN_MESSAGE, JOptionPane.OK_CANCEL_OPTION );
		JDialog dialog = optionPane.createDialog( title );
		dialog.setMinimumSize( new Dimension( 400, 600 ) );
		dialog.setLocation( 550, 50 );
		dialog.setVisible( true );
		// 0 - Ok
		// 2 - Cancel
		// null - x
		Object optionValue = optionPane.getValue();
		int value = -1;

		if ( optionValue != null ) {

			value = ( int ) optionValue;

		}

		dialog.dispose();
		return value;

	}

	private class ABComparator implements Comparator<JCheckBox> {

		@Override
		public int compare( JCheckBox a, JCheckBox b ) {

			return a.getText().compareToIgnoreCase( b.getText() );

		}

	}

}
