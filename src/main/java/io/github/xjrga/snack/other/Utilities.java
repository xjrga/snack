package io.github.xjrga.snack.other;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import org.w3c.dom.Node;
import org.w3c.dom.bootstrap.DOMImplementationRegistry;
import org.w3c.dom.ls.DOMImplementationLS;
import org.w3c.dom.ls.LSSerializer;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class Utilities {

    public Utilities() {
    }

    public static String sha256_hash_to_hex( String s ) {
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

    public static String random() {
        StringBuilder sb = new StringBuilder();
        for ( int i = 0; i < 8; i++ ) {
            sb.append( Math.random() );
        }
        String replace = sb.toString().replace( ".", "" );
        return replace.substring( 0, 128 );
    }

    private String convert_to_hex_02( byte[] hash ) {
        StringBuilder sb = new StringBuilder( 2 * hash.length );
        for ( byte b : hash ) {
            sb.append( String.format( "%02x", b ) );
        }
        return sb.toString();
    }

    private String convert_to_hex_03( byte[] hash ) {
        StringBuilder sb = new StringBuilder( 2 * hash.length );
        for ( byte b : hash ) {
            sb.append( Integer.toString( (b & 0xff) + 0x100, 16 ).substring( 1 ) );
        }
        return sb.toString();
    }

    public static String format_xml_doc( String xml ) {
        try {
            final InputSource src = new InputSource( new StringReader( xml ) );
            final Node document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse( src ).getDocumentElement();
            final Boolean keepDeclaration = xml.startsWith( "<?xml" );
            final DOMImplementationRegistry registry = DOMImplementationRegistry.newInstance();
            final DOMImplementationLS impl = ( DOMImplementationLS ) registry.getDOMImplementation( "LS" );
            final LSSerializer writer = impl.createLSSerializer();
            writer.getDomConfig().setParameter( "format-pretty-print", Boolean.TRUE );
            writer.getDomConfig().setParameter( "xml-declaration", keepDeclaration );
            return writer.writeToString( document );
        } catch ( Exception e ) {
            throw new RuntimeException( e );
        }
    }

    public static boolean validate_xml_doc( String schema_path, String xmldoc_path ) {
        boolean result = false;
        Source xmlDoc = new StreamSource( new File( xmldoc_path ) );
        SchemaFactory schemaFactory = SchemaFactory.newInstance( XMLConstants.W3C_XML_SCHEMA_NS_URI );
        Validator validator = null;
        try {
            Schema xmlSchema = schemaFactory.newSchema( new File( schema_path ) );
            validator = xmlSchema.newValidator();
        } catch ( SAXException e ) {
            Log.Log2.append( "Xml doc validation error: " );
            Log.Log2.append( e.getLocalizedMessage() );
            Log.Log2.append( "\n" );
        } finally {
            try {
                validator.validate( xmlDoc );
                result = true;
            } catch ( SAXException | IOException e ) {
                Log.Log2.append( "Xml doc validation error: " );
                Log.Log2.append( e.getLocalizedMessage() );
                Log.Log2.append( "\n" );
            }
        }
        return result;
    }

    public static double[] convert_to_double_array( int[] array ) {
        double[] darray = new double[ array.length ];
        for ( int i = 0; i < array.length; i++ ) {
            darray[ i ] = array[ i ];
        }
        return darray;
    }

    public static double[] convert_to_double_array( List<Double> list ) {
        double[] arr = new double[ list.size() ];
        for ( int i = 0; i < arr.length; i++ ) {
            arr[ i ] = list.get( i );
        }
        return arr;
    }

    public static String print_double_array( double[] array ) {
        StringBuilder sb = new StringBuilder();
        sb.append( "[" );
        for ( int i = 0; i < array.length; i++ ) {
            sb.append( array[ i ] );
            sb.append( ", " );
        }
        sb.setLength( sb.length() - 1 );
        sb.append( "]" );
        return sb.toString();
    }

    public static void write_to_file( String filePath, String txt ) {
        try ( BufferedWriter out = new BufferedWriter( new FileWriter( filePath, true ) ) ) {
            out.write( txt );
        } catch ( IOException ex ) {
        }
    }

}
