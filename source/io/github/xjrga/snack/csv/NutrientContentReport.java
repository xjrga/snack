package io.github.xjrga.snack.csv;

import io.github.xjrga.snack.database.callable.BackgroundExec;
import io.github.xjrga.snack.database.callable.select.NutrientContainingFoodsTask;
import io.github.xjrga.snack.dataobject.NutrientDO;
import io.github.xjrga.snack.logger.LoggerImpl;
import io.github.xjrga.snack.other.Utilities;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.Future;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

public class NutrientContentReport {

	enum Headers {
		Food, Weight, Calories
	}

	public NutrientContentReport() {

	}

	public void create( JTextField textFieldNutrientLookup, JComboBox comboBoxNutrientLookupListNutrient ) {

		try ( FileWriter fileWriter = new FileWriter( "models/nutrientcontent.csv" ) ) {

			NutrientDO nutrientDO = ( NutrientDO ) comboBoxNutrientLookupListNutrient.getSelectedItem();
			StringBuilder comment = new StringBuilder();
			comment.append( "How to get " );
			comment.append( textFieldNutrientLookup.getText() );
			comment.append( " of " );
			comment.append( nutrientDO.getNutrdesc() );
			comment.append( " per day?" );
			CSVFormat csvFormat = CSVFormat.DEFAULT.builder().setCommentMarker( '#' )
					.setHeaderComments( "Nutrient Content Report", comment.toString(), LocalDateTime.now() )
					.setHeader( Headers.class ).get();
			CSVPrinter csvPrinter = new CSVPrinter( fileWriter, csvFormat );

			try {

				String nutrientid = nutrientDO.getNutr_no();
				BigDecimal dri = new BigDecimal( textFieldNutrientLookup.getText() );
				Future<List<List>> task = BackgroundExec.submit( new NutrientContainingFoodsTask( nutrientid, dri ) );
				List<List> results = task.get();
				results.forEach( row -> {

					try {

						String food = ( String ) row.get( 0 );
						BigDecimal weight = ( BigDecimal ) row.get( 1 );
						BigDecimal calories = ( BigDecimal ) row.get( 2 );
						csvPrinter.printRecord( food, Utilities.strip( weight ), Utilities.strip( calories ) );

					} catch (IOException e) {

						LoggerImpl.INSTANCE.logProblem( e );

					}

				} );

			} catch (Exception e) {

				LoggerImpl.INSTANCE.logProblem( e );

			}

		} catch (Exception e) {

			LoggerImpl.INSTANCE.logProblem( e );

		}

	}

}
