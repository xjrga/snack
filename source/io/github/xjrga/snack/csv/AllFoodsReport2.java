package io.github.xjrga.snack.csv;

import io.github.xjrga.snack.database.Connect;
import io.github.xjrga.snack.logger.LoggerImpl;
import java.io.FileWriter;
import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

public class AllFoodsReport2 {

    private final Connection connection;


    public AllFoodsReport2() {
        connection = Connect.getInstance().getConnection();
    }


    public void create() {
        try ( FileWriter fileWriter = new FileWriter( "models/allfoods2.csv" ) ) {
            CallableStatement proc = connection.prepareCall( "{CALL public.Food_Select_Details()}" );
            ResultSet rs = proc.executeQuery();
            StringBuilder comment = new StringBuilder();
            comment.append( "Nutritional Values For Common Foods And Products" );
            CSVFormat csvFormat = CSVFormat.DEFAULT
                    .builder()
                    .setCommentMarker( '#' )
                    .setHeaderComments( "All Foods Report #2", comment.toString(), LocalDateTime.now() )
                    .setHeader( rs )
                    .get();
            CSVPrinter csvPrinter = new CSVPrinter( fileWriter, csvFormat );
            while ( rs.next() ) {
                String x1 = rs.getString( 1 );
                String x2 = rs.getString( 2 );
                BigDecimal x3 = rs.getBigDecimal( 3 );
                BigDecimal x4 = rs.getBigDecimal( 4 );
                BigDecimal x5 = rs.getBigDecimal( 5 );
                BigDecimal x6 = rs.getBigDecimal( 6 );
                BigDecimal x7 = rs.getBigDecimal( 7 );
                BigDecimal x8 = rs.getBigDecimal( 8 );
                BigDecimal x9 = rs.getBigDecimal( 9 );
                BigDecimal x10 = rs.getBigDecimal( 10 );
                BigDecimal x11 = rs.getBigDecimal( 11 );
                BigDecimal x12 = rs.getBigDecimal( 12 );
                BigDecimal x13 = rs.getBigDecimal( 13 );
                BigDecimal x14 = rs.getBigDecimal( 14 );
                BigDecimal x15 = rs.getBigDecimal( 15 );
                BigDecimal x16 = rs.getBigDecimal( 16 );
                BigDecimal x17 = rs.getBigDecimal( 17 );
                BigDecimal x18 = rs.getBigDecimal( 18 );
                BigDecimal x19 = rs.getBigDecimal( 19 );
                BigDecimal x20 = rs.getBigDecimal( 20 );
                BigDecimal x21 = rs.getBigDecimal( 21 );
                BigDecimal x22 = rs.getBigDecimal( 22 );
                BigDecimal x23 = rs.getBigDecimal( 23 );
                BigDecimal x24 = rs.getBigDecimal( 24 );
                BigDecimal x25 = rs.getBigDecimal( 25 );
                BigDecimal x26 = rs.getBigDecimal( 26 );
                BigDecimal x27 = rs.getBigDecimal( 27 );
                BigDecimal x28 = rs.getBigDecimal( 28 );
                BigDecimal x29 = rs.getBigDecimal( 29 );
                BigDecimal x30 = rs.getBigDecimal( 30 );
                BigDecimal x31 = rs.getBigDecimal( 31 );
                BigDecimal x32 = rs.getBigDecimal( 32 );
                BigDecimal x33 = rs.getBigDecimal( 33 );
                BigDecimal x34 = rs.getBigDecimal( 34 );
                BigDecimal x35 = rs.getBigDecimal( 35 );
                BigDecimal x36 = rs.getBigDecimal( 36 );
                BigDecimal x37 = rs.getBigDecimal( 37 );
                BigDecimal x38 = rs.getBigDecimal( 38 );
                BigDecimal x39 = rs.getBigDecimal( 39 );
                BigDecimal x40 = rs.getBigDecimal( 40 );
                BigDecimal x41 = rs.getBigDecimal( 41 );
                BigDecimal x42 = rs.getBigDecimal( 42 );
                BigDecimal x43 = rs.getBigDecimal( 43 );
                BigDecimal x44 = rs.getBigDecimal( 44 );
                BigDecimal x45 = rs.getBigDecimal( 45 );
                BigDecimal x46 = rs.getBigDecimal( 46 );
                BigDecimal x47 = rs.getBigDecimal( 47 );
                BigDecimal x48 = rs.getBigDecimal( 48 );
                BigDecimal x49 = rs.getBigDecimal( 49 );
                BigDecimal x50 = rs.getBigDecimal( 50 );
                BigDecimal x51 = rs.getBigDecimal( 51 );
                BigDecimal x52 = rs.getBigDecimal( 52 );
                BigDecimal x53 = rs.getBigDecimal( 53 );
                BigDecimal x54 = rs.getBigDecimal( 54 );
                BigDecimal x55 = rs.getBigDecimal( 55 );
                BigDecimal x56 = rs.getBigDecimal( 56 );
                BigDecimal x57 = rs.getBigDecimal( 57 );
                BigDecimal x58 = rs.getBigDecimal( 58 );
                BigDecimal x59 = rs.getBigDecimal( 59 );
                BigDecimal x60 = rs.getBigDecimal( 60 );
                BigDecimal x61 = rs.getBigDecimal( 61 );
                BigDecimal x62 = rs.getBigDecimal( 62 );
                BigDecimal x63 = rs.getBigDecimal( 63 );
                BigDecimal x64 = rs.getBigDecimal( 64 );
                BigDecimal x65 = rs.getBigDecimal( 65 );
                BigDecimal x66 = rs.getBigDecimal( 66 );
                BigDecimal x67 = rs.getBigDecimal( 67 );
                BigDecimal x68 = rs.getBigDecimal( 68 );
                BigDecimal x69 = rs.getBigDecimal( 69 );
                BigDecimal x70 = rs.getBigDecimal( 70 );
                BigDecimal x71 = rs.getBigDecimal( 71 );
                BigDecimal x72 = rs.getBigDecimal( 72 );
                BigDecimal x73 = rs.getBigDecimal( 73 );
                BigDecimal x74 = rs.getBigDecimal( 74 );
                BigDecimal x75 = rs.getBigDecimal( 75 );
                BigDecimal x76 = rs.getBigDecimal( 76 );
                BigDecimal x77 = rs.getBigDecimal( 77 );
                BigDecimal x78 = rs.getBigDecimal( 78 );
                BigDecimal x79 = rs.getBigDecimal( 79 );
                BigDecimal x80 = rs.getBigDecimal( 80 );
                BigDecimal x81 = rs.getBigDecimal( 81 );
                BigDecimal x82 = rs.getBigDecimal( 82 );
                BigDecimal x83 = rs.getBigDecimal( 83 );
                BigDecimal x84 = rs.getBigDecimal( 84 );
                BigDecimal x85 = rs.getBigDecimal( 85 );
                BigDecimal x86 = rs.getBigDecimal( 86 );
                BigDecimal x87 = rs.getBigDecimal( 87 );
                BigDecimal x88 = rs.getBigDecimal( 88 );
                csvPrinter.printRecord(
                        x1, x2, x3, x4, x5, x6, x7, x8, x9, x10, x11, x12, x13, x14, x15, x16, x17, x18, x19, x20, x21,
                        x22, x23, x24, x25, x26, x27, x28, x29, x30, x31, x32, x33, x34, x35, x36, x37, x38, x39, x40,
                        x41, x42, x43, x44, x45, x46, x47, x48, x49, x50, x51, x52, x53, x54, x55, x56, x57, x58, x59,
                        x60, x61, x62, x63, x64, x65, x66, x67, x68, x69, x70, x71, x72, x73, x74, x75, x76, x77, x78,
                        x79, x80, x81, x82, x83, x84, x85, x86, x87, x88 );
            }
        } catch ( Exception e ) {
            LoggerImpl.INSTANCE.logProblem( e );
        }
    }
}
