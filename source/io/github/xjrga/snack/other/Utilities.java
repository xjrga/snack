package io.github.xjrga.snack.other;

import io.github.xjrga.snack.dataobject.MixDO;
import io.github.xjrga.snack.logger.LoggerImpl;
import java.awt.Desktop;
import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringReader;
import java.math.BigDecimal;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.stream.StreamSource;
import org.apache.commons.math3.linear.ArrayRealVector;
import org.apache.commons.math3.linear.RealVector;
import org.apache.commons.math3.util.Precision;
import org.w3c.dom.Node;
import org.w3c.dom.bootstrap.DOMImplementationRegistry;
import org.w3c.dom.ls.DOMImplementationLS;
import org.w3c.dom.ls.LSSerializer;
import org.xml.sax.InputSource;

public class Utilities {

    public static void appendToFile( String filePath, String txt ) {
        try ( BufferedWriter out = new BufferedWriter( new FileWriter( filePath, true ) ) ) {
            out.write( txt );
        } catch ( IOException ex ) {
        }
    }

    public static double calculateDotProduct( RealVector v, double[] point ) {
        ArrayRealVector rvpoint = new ArrayRealVector( point );
        return v.dotProduct( rvpoint );
    }

    public static String convertFileToString( String path ) {
        String str = "";
        try {
            str = new String( Files.readAllBytes( Path.of( path ) ) );
        } catch ( IOException ex ) {
        }
        return str;
    }

    public static double[] doubleArray( int[] array ) {
        double[] darray = new double[ array.length ];
        for ( int i = 0; i < array.length; i++ ) {
            darray[ i ] = array[ i ];
        }
        return darray;
    }

    public static double[] doubleArray( List<Double> list ) {
        double[] arr = new double[ list.size() ];
        for ( int i = 0; i < arr.length; i++ ) {
            arr[ i ] = list.get( i );
        }
        return arr;
    }

    public static int[] intArray( List<Integer> list ) {
        int[] arr = new int[ list.size() ];
        for ( int i = 0; i < arr.length; i++ ) {
            arr[ i ] = list.get( i );
        }
        return arr;
    }

    public static String formatXmlDoc( String xml ) {
        String str = "";
        try {
            final InputSource src = new InputSource( new StringReader( xml ) );
            final Node document = DocumentBuilderFactory.newInstance()
                    .newDocumentBuilder()
                    .parse( src )
                    .getDocumentElement();
            final Boolean keepDeclaration = xml.startsWith( "<?xml" );
            final DOMImplementationRegistry registry = DOMImplementationRegistry.newInstance();
            final DOMImplementationLS impl = ( DOMImplementationLS ) registry.getDOMImplementation( "LS" );
            final LSSerializer writer = impl.createLSSerializer();
            writer.getDomConfig().setParameter( "format-pretty-print", Boolean.TRUE );
            writer.getDomConfig().setParameter( "xml-declaration", keepDeclaration );
            return writer.writeToString( document );
        } catch ( Exception e ) {
            LoggerImpl.INSTANCE.logProblem( e );
        }
        return str;
    }

    public static String formatDate( Date date ) {
        String pattern = "EEEE, MMMMM dd, yyyy' at 'HH:mm:ss";
        SimpleDateFormat dateFormat = new SimpleDateFormat( pattern );
        return dateFormat.format( date );
    }

    public static String formatDecimal( Double x ) {
        DecimalFormat formatter = new DecimalFormat( "####.###" );
        return formatter.format( x );
    }

    public static BufferedReader getBufferedReader( String path ) {
        return new BufferedReader(
                new InputStreamReader( ClassLoader.getSystemClassLoader().getResourceAsStream( path ) ) );
    }

    public static long getCurrentTimeMillis() {
        return System.currentTimeMillis();
    }

    public static String getCurrentTimeMillisTxt() {
        StringBuilder sb = new StringBuilder();
        sb.append( System.currentTimeMillis() );
        sb.setLength( sb.length() - 3 );
        return sb.toString();
    }

    public static Dimension getDimension( Integer width, Integer height ) {
        return new Dimension( width, height );
    }

    public static File getResourceAsFile( String path ) {
        return new File( Utilities.class.getClassLoader().getResource( path ).getFile() );
    }

    public static Path getResourceAsPath( String path ) {
        Path get = null;
        try {
            get = Paths.get(
                    Objects.requireNonNull( Utilities.class.getClassLoader().getResource( path ) )
                            .toURI() );
        } catch ( URISyntaxException e ) {
            LoggerImpl.INSTANCE.logProblem( e );
        }
        return get;
    }

    public static InputStream getResourceAsStream( String path ) {
        return Utilities.class.getResourceAsStream( path );
    }

    public static StreamSource getResourceAsStreamSource( String path ) {
        InputStream is = Utilities.class.getResourceAsStream( path );
        return new StreamSource( is );
    }

    public static String getResourceAsString( String path ) {
        InputStream is = Utilities.class.getResourceAsStream( path );
        StringBuilder sb = new StringBuilder();
        InputStreamReader isr = new InputStreamReader( is );
        try {
            int i;
            while ( ( i = isr.read() ) != -1 ) {
                sb.append( ( char ) i );
            }
            isr.close();
        } catch ( IOException e ) {
            LoggerImpl.INSTANCE.logProblem( e );
        }
        return sb.toString();
    }

    public static URL getResourceAsUrl( String resource_path ) {
        return Utilities.class.getResource( resource_path );
    }

    public static boolean isDoubleEqual( double value, double dot_product ) {
        boolean flag = false;
        double epsilon = 0.000001d;
        if ( Precision.equals( value, dot_product, epsilon ) ) {
            flag = true;
        }
        return flag;
    }

    public static void openUrl( String url ) {
        try {
            Desktop.getDesktop().browse( URI.create( url ) );
        } catch ( Exception e ) {
        }
    }

    public static String printDoubleArray( double[] array ) {
        StringBuilder sb = new StringBuilder();
        sb.append( "[" );
        for ( double element : array ) {
            sb.append( element );
            sb.append( ", " );
        }
        sb.setLength( sb.length() - 2 );
        sb.append( "]" );
        return sb.toString();
    }

    public static String printIntArray( int[] array ) {
        StringBuilder sb = new StringBuilder();
        sb.append( "[" );
        for ( int element : array ) {
            sb.append( element );
            sb.append( ", " );
        }
        sb.setLength( sb.length() - 2 );
        sb.append( "]" );
        return sb.toString();
    }

    public static String random() {
        StringBuilder sb = new StringBuilder();
        for ( int i = 0; i < 8; i++ ) {
            sb.append( Math.random() );
        }
        String replace = sb.toString().replace( ".", "" );
        return replace.substring( 0, 128 );
    }

    public static String sha256HashToHex( String s ) {
        StringBuilder sb = null;
        try {
            MessageDigest digest = MessageDigest.getInstance( "SHA-256" );
            byte[] encodedhash = digest.digest( s.getBytes( StandardCharsets.UTF_8 ) );
            sb = new StringBuilder( 2 * encodedhash.length );
            for ( byte b : encodedhash ) {
                sb.append( String.format( "%02x", b ) );
            }
        } catch ( NoSuchAlgorithmException ex ) {
        }
        return sb.toString();
    }

    public static void write( String filePath, String str ) {
        PrintWriter writer = null;
        try {
            writer = new PrintWriter( filePath );
            writer.println( str );
            writer.flush();
            writer.close();
        } catch ( FileNotFoundException e ) {
            LoggerImpl.INSTANCE.logProblem( e );
        } finally {
            writer.close();
        }
    }

    public static boolean lessThanOrEqualTo( BigDecimal n1, BigDecimal n2 ) {
        // if valueAt is less than 0.0 then it is -1
        return n1.compareTo( n2 ) <= 0;
    }

    public static boolean moreThanOrEqualTo( BigDecimal n1, BigDecimal n2 ) {
        // if valueAt is less than 0.0 then it is -1
        return n1.compareTo( n2 ) >= 0;
    }

    public static boolean lessThan( BigDecimal n1, BigDecimal n2 ) {
        // if valueAt is less than 0.0 then it is -1
        return n1.compareTo( n2 ) < 0;
    }

    public static boolean moreThan( BigDecimal n1, BigDecimal n2 ) {
        // if valueAt is less than 0.0 then it is -1
        return n1.compareTo( n2 ) > 0;
    }

    public static boolean equalTo( BigDecimal n1, BigDecimal n2 ) {
        // if valueAt is less than 0.0 then it is -1
        return n1.compareTo( n2 ) == 0;
    }

    public static String trim( BigDecimal n ) {
        return n.toPlainString().trim();
    }

    public static String strip( BigDecimal n ) {
        return n.stripTrailingZeros().toPlainString();
    }

    public static List<MixDO> createMixDOList( List<List> data ) {
        List<MixDO> list = new ArrayList<>();
        data.forEach( row -> {
            MixDO mix = new MixDO();
            mix.setMixid( ( String ) row.get( 0 ) );
            mix.setName( ( String ) row.get( 1 ) );
            mix.setLifestageid( ( Integer ) row.get( 2 ) );
            mix.setModel( ( String ) row.get( 3 ) );
            BigDecimal cost = ( BigDecimal ) row.get( 4 );
            mix.setCost( ( BigDecimal ) row.get( 4 ) );
            mix.setDeficiency( ( BigDecimal ) row.get( 5 ) );
            mix.setExcess( ( BigDecimal ) row.get( 6 ) );
            list.add( mix );
        } );
        return list;
    }
}
