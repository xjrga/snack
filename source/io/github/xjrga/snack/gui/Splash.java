package io.github.xjrga.snack.gui;

import io.github.xjrga.snack.logger.LoggerImpl;
import io.github.xjrga.snack.other.ElapsedTime;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

/**
 * @author jr
 */
public class Splash extends JFrame {

	private final JLabel lbl;
	private Thread t;

	public Splash() {

		setSize( new Dimension( 300, 50 ) );
		lbl = new JLabel();
		lbl.setHorizontalAlignment( JLabel.CENTER );
		add( lbl );
		setTitle( " Snack is loading your food items" );
		setVisible( true );
		toFront();

	}

	public void initiate() {

		ElapsedTime startupTime = new ElapsedTime();
		startupTime.start();
		Runnable r = () -> {

			startupTime.end();
			lbl.setText( String.format( "%,.0f s", startupTime.getElapsedTimeInSeconds() ) );

		};
		t = new Thread() {
			@Override
			public void run() {

				while ( !isInterrupted() ) {

					if ( startupTime.getElapsedTimeInSeconds() > 30 ) {

						halt();

					}

					SwingUtilities.invokeLater( r );

					try {

						Thread.sleep( 1000L );

					} catch (InterruptedException e) {

						Thread.currentThread().interrupt();

					}

				}

			}
		};
		t.start();

	}

	public void halt() {

		dispose();
		t.interrupt();

	}

}
