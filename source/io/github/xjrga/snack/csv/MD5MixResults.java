package io.github.xjrga.snack.csv;

import io.github.xjrga.snack.jcomponents.TableMixResults;
import io.github.xjrga.snack.logger.LoggerImpl;
import java.io.FileWriter;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

public class MD5MixResults {

    enum Headers {
        MixId,
        FoodId,
        FoodName,
        Md5
    }


    public MD5MixResults() {
    }


    public void create( TableMixResults table ) {
        LocalDateTime now = LocalDateTime.now();
        String pattern = "hh_mm_ss"; // Example: "03:45:22 PM"
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern( pattern );
        String format = now.format( formatter );
        StringBuilder fileName = new StringBuilder();
        fileName.append( "models/checksum_" );
        fileName.append( format );
        fileName.append( ".csv" );
        try ( FileWriter fileWriter = new FileWriter( fileName.toString() ) ) {
            StringBuilder comment = new StringBuilder();
            comment.append( "MD5" );
            CSVFormat csvFormat = CSVFormat.DEFAULT
                    .builder()
                    .setCommentMarker( '#' )
                    .setHeaderComments( "Mix Results", comment.toString(), LocalDateTime.now() )
                    .setHeader( Headers.class )
                    .get();
            CSVPrinter csvPrinter = new CSVPrinter( fileWriter, csvFormat );
            int rows = table.getRowCount();
            int columns = table.getColumnCount();
            for ( int row = 0; row < rows; row++ ) {
                StringBuilder sb = new StringBuilder();
                String mix_id = ( String ) table.getValueAt( row, 0 );
                String food_id = ( String ) table.getValueAt( row, 1 );
                String food_name = ( String ) table.getValueAt( row, 2 );
                for ( int column = 3; column < columns; column++ ) {
                    BigDecimal d = ( BigDecimal ) table.getValueAt( row, column );
                    sb.append( d.toPlainString() );
                }
                String md5Hex = DigestUtils.md5Hex( sb.toString() );
                csvPrinter.printRecord( mix_id, food_id, food_name, md5Hex );
            }
        } catch ( Exception e ) {
            LoggerImpl.INSTANCE.logProblem( e );
        }
    }
}
