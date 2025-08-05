package io.github.xjrga.snack.csv;

import io.github.xjrga.snack.database.callable.BackgroundExec;
import io.github.xjrga.snack.database.callable.select.MealPlanUsageResultsTask;
import io.github.xjrga.snack.logger.LoggerImpl;
import io.github.xjrga.snack.other.Utilities;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.Future;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

public class MealPlanUsageReport {

	enum Headers {
		FoodId, Food, Grams, Ounces, Pounds, Kilograms
	}

	public MealPlanUsageReport() {

	}

	public void create() {

		try ( FileWriter fileWriter = new FileWriter( "models/mealplanusage.csv" ) ) {

			StringBuilder comment = new StringBuilder();
			comment.append( "Food quantity needed to follow a meal plan for chosen number of days" );
			CSVFormat csvFormat = CSVFormat.DEFAULT.builder().setCommentMarker( '#' )
					.setHeaderComments( "Meal Plan Usage Report", comment.toString(), LocalDateTime.now() )
					.setHeader( Headers.class ).get();
			CSVPrinter csvPrinter = new CSVPrinter( fileWriter, csvFormat );

			try {

				Future<List<List>> task = BackgroundExec.submit( new MealPlanUsageResultsTask() );
				List<List> results = task.get();
				results.forEach( row -> {

					try {

						String foodid = ( String ) row.get( 0 );
						String foodname = ( String ) row.get( 1 );
						BigDecimal g = (( BigDecimal ) row.get( 2 ));
						BigDecimal oz = (( BigDecimal ) row.get( 3 ));
						BigDecimal lb = (( BigDecimal ) row.get( 4 ));
						BigDecimal kg = (( BigDecimal ) row.get( 5 ));
						csvPrinter.printRecord( foodid, foodname, Utilities.strip( g ), Utilities.strip( oz ),
								Utilities.strip( lb ), Utilities.strip( kg ) );

					} catch (Exception e) {

						LoggerImpl.INSTANCE.logProblem( e );

					}

				} );

			} catch (Exception e) {

				LoggerImpl.INSTANCE.logProblem( e );

			}

		} catch (IOException e) {

			LoggerImpl.INSTANCE.logProblem( e );

		}

	}

}
