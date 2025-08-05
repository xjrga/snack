package io.github.xjrga.snack.datamodel;

import io.github.xjrga.snack.database.callable.BackgroundExec;
import io.github.xjrga.snack.database.callable.select.FoodStatisticsTask;
import io.github.xjrga.snack.logger.LoggerImpl;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;

public class FoodStats implements ReloadMixid {

	private StringBuilder sb;

	public FoodStats() {

	}

	public String get_stats() {

		return sb.toString();

	}

	@Override
	public void reload( String foodid ) {

		sb = new StringBuilder();

		try {

			Future<List<Map<String, BigDecimal>>> task = BackgroundExec.submit( new FoodStatisticsTask( foodid ) );
			List<Map<String, BigDecimal>> stats = task.get();
			DecimalFormat df = new DecimalFormat( "####.#" );
			stats.forEach( row -> {

				BigDecimal fatpct = row.get( "FATPCT" );
				BigDecimal carbpct = row.get( "CARBPCT" );
				BigDecimal proteinpct = row.get( "PROTEINPCT" );
				BigDecimal alcoholpct = row.get( "ALCOHOLPCT" );
				BigDecimal fq = row.get( "FQ" );
				BigDecimal satfatpct = row.get( "SATFATPCT" );
				BigDecimal monoufatpct = row.get( "MONOUFATPCT" );
				BigDecimal polyufatpct = row.get( "POLYUFATPCT" );
				BigDecimal essentialfatratio = row.get( "ESSENTIALFATRATIO" );
				BigDecimal electrolyteratio = row.get( "ELECTROLYTERATIO" );
				BigDecimal lapct = row.get( "LAPCT" );
				BigDecimal alapct = row.get( "ALAPCT" );
				BigDecimal psratio = row.get( "PSRATIO" );
				BigDecimal msratio = row.get( "MSRATIO" );
				sb.append( "Fat: " );
				sb.append( df.format( fatpct ) );
				sb.append( "%\n" );
				sb.append( "Carbohydrate: " );
				sb.append( df.format( carbpct ) );
				sb.append( "%\n" );
				sb.append( "Protein: " );
				sb.append( df.format( proteinpct ) );
				sb.append( "%\n" );
				sb.append( "Alcohol: " );
				sb.append( df.format( alcoholpct ) );
				sb.append( "%\n" );
				sb.append( "Saturated Fat: " );
				sb.append( df.format( satfatpct ) );
				sb.append( "%\n" );
				sb.append( "Polyunsaturated Fat: " );
				sb.append( df.format( polyufatpct ) );
				sb.append( "%\n" );
				sb.append( "Monounsaturated Fat: " );
				sb.append( df.format( monoufatpct ) );
				sb.append( "%\n" );
				sb.append( "Linoleic Acid: " );
				sb.append( df.format( lapct ) );
				sb.append( "%\n" );
				sb.append( "Alpha-linolenic Acid: " );
				sb.append( df.format( alapct ) );
				sb.append( "%\n" );
				sb.append( "Ratio PUFA/SFA: " );
				sb.append( df.format( psratio ) );
				sb.append( "\n" );
				sb.append( "Ratio MUFA/SFA: " );
				sb.append( df.format( msratio ) );
				sb.append( "\n" );
				sb.append( "Ratio LA/ALA: " );
				sb.append( df.format( essentialfatratio ) );
				sb.append( "\n" );
				sb.append( "Ratio K/Na: " );
				sb.append( df.format( electrolyteratio ) );
				sb.append( "\n" );
				sb.append( "Food Quotient (FQ): " );
				sb.append( df.format( fq ) );
				sb.append( "\n" );

			} );

		} catch (Exception e) {

			LoggerImpl.INSTANCE.logProblem( e );

		}

	}

}
