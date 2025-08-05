package io.github.xjrga.snack.csv;

import io.github.xjrga.snack.database.Connect;
import io.github.xjrga.snack.dataobject.LifeStageDO;
import io.github.xjrga.snack.dataobject.MixDO;
import io.github.xjrga.snack.logger.LoggerImpl;
import io.github.xjrga.snack.other.Utilities;
import java.io.FileWriter;
import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

public class DriReport {

	private final Connection connection;

	public DriReport() {

		connection = Connect.getInstance().getConnection();

	}

	public void create( MixDO mixDataObject, LifeStageDO obj ) {

		try ( FileWriter fileWriter = new FileWriter( "models/dri.csv" ) ) {

			int lifestageid = obj.getLifeStageId();
			String mixid = mixDataObject.getMixid();
			CallableStatement proc = connection.prepareCall( "{CALL public.Mix_getDriDiff( ?, ? )}" );
			proc.setString( 1, mixid );
			proc.setInt( 2, lifestageid );
			ResultSet rs = proc.executeQuery();
			StringBuilder comment = new StringBuilder();
			comment.append( "For " );
			comment.append( obj.getLabel() );
			CSVFormat csvFormat = CSVFormat.DEFAULT.builder().setCommentMarker( '#' )
					.setHeaderComments( "Daily Reference Intake Report", comment.toString(), LocalDateTime.now() )
					.setHeader( rs ).get();
			CSVPrinter csvPrinter = new CSVPrinter( fileWriter, csvFormat );

			while ( rs.next() ) {

				String nutrientid = rs.getString( 1 );
				String name = rs.getString( 2 );
				BigDecimal mixq = rs.getBigDecimal( 3 );
				BigDecimal dri = rs.getBigDecimal( 4 );
				BigDecimal pctdri = rs.getBigDecimal( 5 );
				BigDecimal driul = rs.getBigDecimal( 6 );
				BigDecimal pctdriul = rs.getBigDecimal( 7 );
				csvPrinter.printRecord( nutrientid, name, Utilities.strip( mixq ), Utilities.strip( dri ),
						Utilities.strip( pctdri ), Utilities.strip( driul ), Utilities.strip( pctdriul ) );

			}

		} catch (Exception e) {

			LoggerImpl.INSTANCE.logProblem( e );

		}

	}

}
