package io.github.xjrga.snack.csv;

import io.github.xjrga.snack.database.Connect;
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

public class AllFoodsReport1 {

    private final Connection connection;

    public AllFoodsReport1() {
        connection = Connect.getInstance().getConnection();
    }

    public void create() {
        try ( FileWriter fileWriter = new FileWriter( "models/allfoods1.csv" ) ) {
            CallableStatement proc = connection.prepareCall( "{CALL public.getNutrients()}" );
            ResultSet rs = proc.executeQuery();
            StringBuilder comment = new StringBuilder();
            comment.append( "Nutritional Values For Common Foods And Products" );
            CSVFormat csvFormat = CSVFormat.DEFAULT
                    .builder()
                    .setCommentMarker( '#' )
                    .setHeaderComments( "All Foods Report #1", comment.toString(), LocalDateTime.now() )
                    .setHeader( rs )
                    .get();
            CSVPrinter csvPrinter = new CSVPrinter( fileWriter, csvFormat );
            while ( rs.next() ) {
                String foodid = rs.getString( 1 );
                String nutrientid = rs.getString( 2 );
                String food = rs.getString( 3 );
                String nutrient = rs.getString( 4 );
                BigDecimal q = rs.getBigDecimal( 5 );
                String units = rs.getString( 6 );
                Integer dri = rs.getInt( 7 );
                csvPrinter.printRecord( foodid, nutrientid, food, nutrient, Utilities.strip( q ), units, dri );
            }
        } catch ( Exception e ) {
            LoggerImpl.INSTANCE.logProblem( e );
        }
    }
}
