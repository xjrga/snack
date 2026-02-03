package io.github.xjrga.snack.csv;

import io.github.xjrga.snack.database.Connect;
import io.github.xjrga.snack.dataobject.MixDO;
import io.github.xjrga.snack.logger.LoggerImpl;
import io.github.xjrga.snack.other.Utilities;
import java.io.FileWriter;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

public class MixTotalsReport {

    private final Connection connection;


    public MixTotalsReport() {
        connection = Connect.getInstance().getConnection();
    }


    public void create( MixDO mixDataObject ) {
        try {
            String path = "models/mixtotals.csv";
            boolean exists = Files.exists( Path.of( path ) );
            String mixid = mixDataObject.getMixid();
            CallableStatement proc = connection.prepareCall( "{CALL public.MixTotals( ? )}" );
            proc.setString( 1, mixid );
            ResultSet rs = proc.executeQuery();
            StringBuilder comment = new StringBuilder();
            CSVFormat csvFormat = CSVFormat.DEFAULT;
            if ( !exists ) {
                csvFormat = CSVFormat.DEFAULT
                        .builder()
                        .setCommentMarker( '#' )
                        .setHeaderComments( "Mix Totals Report", comment.toString(), LocalDateTime.now() )
                        .setHeader( rs )
                        .get();
            }
            FileWriter fileWriter = new FileWriter( path, true );
            CSVPrinter csvPrinter = new CSVPrinter( fileWriter, csvFormat );
            while ( rs.next() ) {
                String x1 = rs.getString( 1 ); // mixid
                String x2 = rs.getString( 2 ); // mixname
                Timestamp x3 = rs.getTimestamp( 3 ); // timestamp
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
                BigDecimal x89 = rs.getBigDecimal( 89 );
                csvPrinter.printRecord(
                        x1,
                        x2,
                        x3,
                        Utilities.strip( x4 ),
                        Utilities.strip( x5 ),
                        Utilities.strip( x6 ),
                        Utilities.strip( x7 ),
                        Utilities.strip( x8 ),
                        Utilities.strip( x9 ),
                        Utilities.strip( x10 ),
                        Utilities.strip( x11 ),
                        Utilities.strip( x12 ),
                        Utilities.strip( x13 ),
                        Utilities.strip( x14 ),
                        Utilities.strip( x15 ),
                        Utilities.strip( x16 ),
                        Utilities.strip( x17 ),
                        Utilities.strip( x18 ),
                        Utilities.strip( x19 ),
                        Utilities.strip( x20 ),
                        Utilities.strip( x21 ),
                        Utilities.strip( x22 ),
                        Utilities.strip( x23 ),
                        Utilities.strip( x24 ),
                        Utilities.strip( x25 ),
                        Utilities.strip( x26 ),
                        Utilities.strip( x27 ),
                        Utilities.strip( x28 ),
                        Utilities.strip( x29 ),
                        Utilities.strip( x30 ),
                        Utilities.strip( x31 ),
                        Utilities.strip( x32 ),
                        Utilities.strip( x33 ),
                        Utilities.strip( x34 ),
                        Utilities.strip( x35 ),
                        Utilities.strip( x36 ),
                        Utilities.strip( x37 ),
                        Utilities.strip( x38 ),
                        Utilities.strip( x39 ),
                        Utilities.strip( x40 ),
                        Utilities.strip( x41 ),
                        Utilities.strip( x42 ),
                        Utilities.strip( x43 ),
                        Utilities.strip( x44 ),
                        Utilities.strip( x45 ),
                        Utilities.strip( x46 ),
                        Utilities.strip( x47 ),
                        Utilities.strip( x48 ),
                        Utilities.strip( x49 ),
                        Utilities.strip( x50 ),
                        Utilities.strip( x51 ),
                        Utilities.strip( x52 ),
                        Utilities.strip( x53 ),
                        Utilities.strip( x54 ),
                        Utilities.strip( x55 ),
                        Utilities.strip( x56 ),
                        Utilities.strip( x57 ),
                        Utilities.strip( x58 ),
                        Utilities.strip( x59 ),
                        Utilities.strip( x60 ),
                        Utilities.strip( x61 ),
                        Utilities.strip( x62 ),
                        Utilities.strip( x63 ),
                        Utilities.strip( x64 ),
                        Utilities.strip( x65 ),
                        Utilities.strip( x66 ),
                        Utilities.strip( x67 ),
                        Utilities.strip( x68 ),
                        Utilities.strip( x69 ),
                        Utilities.strip( x70 ),
                        Utilities.strip( x71 ),
                        Utilities.strip( x72 ),
                        Utilities.strip( x73 ),
                        Utilities.strip( x74 ),
                        Utilities.strip( x75 ),
                        Utilities.strip( x76 ),
                        Utilities.strip( x77 ),
                        Utilities.strip( x78 ),
                        Utilities.strip( x79 ),
                        Utilities.strip( x80 ),
                        Utilities.strip( x81 ),
                        Utilities.strip( x82 ),
                        Utilities.strip( x83 ),
                        Utilities.strip( x84 ),
                        Utilities.strip( x85 ),
                        Utilities.strip( x86 ),
                        Utilities.strip( x87 ),
                        Utilities.strip( x88 ),
                        Utilities.strip( x89 ) );
                csvPrinter.flush();
                csvPrinter.close();
            }
        } catch ( Exception e ) {
            LoggerImpl.INSTANCE.logProblem( e );
        }
    }
}
