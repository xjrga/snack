package io.github.xjrga.snack.xml;

import io.github.xjrga.snack.gui.Message;
import io.github.xjrga.snack.logger.LoggerImpl;
import io.github.xjrga.snack.other.Utilities;
import java.io.File;
import java.net.URI;
import java.net.URL;
import javax.xml.XMLConstants;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import org.xml.sax.XMLReader;

public class FoodsImporter {

    public FoodsImporter() {
    }


    public boolean importFoodListUsingFile( String xml_doc_path, String xsd_doc_path ) {
        boolean completed = false;
        try {
            File xsd_doc_file = new File( xsd_doc_path );
            Source xml_doc_source = new StreamSource( new File( xml_doc_path ) );
            SchemaFactory schemaFactory = SchemaFactory.newInstance( XMLConstants.W3C_XML_SCHEMA_NS_URI );
            Schema schema = schemaFactory.newSchema( xsd_doc_file );
            // Validate
            Validator validator = schema.newValidator();
            validator.validate( xml_doc_source );
            // Parse
            SAXParserFactory spf = SAXParserFactory.newInstance();
            spf.setSchema( schema );
            SAXParser parser = spf.newSAXParser();
            XMLReader reader = parser.getXMLReader();
            reader.setContentHandler( new FoodInsertHandler() );
            // reader.setErrorHandler( new TestErrorHandler() );
            reader.parse( xml_doc_path );
            completed = true;
        } catch ( Exception e ) {
            LoggerImpl.INSTANCE.logProblem( e );
        }
        return completed;
    }


    public boolean importFoodListUsingUrl( String foodListSchema, String xml_doc_path ) {
        // String foodListSchema = "http://localhost:8080/schemas/foods.xsd";
        boolean completed = false;
        try {
            URL xsd_doc_url = URI.create( foodListSchema ).toURL();
            Source xml_doc_source = new StreamSource( new File( xml_doc_path ) );
            SchemaFactory schemaFactory = SchemaFactory.newInstance( XMLConstants.W3C_XML_SCHEMA_NS_URI );
            Schema schema = schemaFactory.newSchema( xsd_doc_url );
            // Validate
            Validator validator = schema.newValidator();
            validator.validate( xml_doc_source );
            // Parse
            SAXParserFactory spf = SAXParserFactory.newInstance();
            spf.setSchema( schema );
            SAXParser parser = spf.newSAXParser();
            XMLReader reader = parser.getXMLReader();
            reader.setContentHandler( new FoodInsertHandler() );
            // reader.setErrorHandler( new TestErrorHandler() );
            reader.parse( xml_doc_path );
            completed = true;
        } catch ( Exception e ) {
            LoggerImpl.INSTANCE.logProblem( e );
        }
        return completed;
    }


    public boolean importFoodListUsingResource( String foodListSchema, String xml_doc_path ) {
        Schema schema = null;
        boolean flag = true;
        // Validate
        try {
            URL xsd_doc_url = Utilities.getResourceAsUrl( foodListSchema );
            Source xml_doc_source = new StreamSource( new File( xml_doc_path ) );
            SchemaFactory schemaFactory = SchemaFactory.newInstance( XMLConstants.W3C_XML_SCHEMA_NS_URI );
            schema = schemaFactory.newSchema( xsd_doc_url );
            Validator validator = schema.newValidator();
            validator.validate( xml_doc_source );
        } catch ( Exception e ) {
            LoggerImpl.INSTANCE.logProblem( e );
            flag = false;
            Message.showMessagePad( 800, 300, "File is not valid.", e.getMessage() );
        }
        // Parse
        if ( flag ) {
            try {
                SAXParserFactory spf = SAXParserFactory.newInstance();
                spf.setSchema( schema );
                SAXParser parser = spf.newSAXParser();
                XMLReader reader = parser.getXMLReader();
                reader.setContentHandler( new FoodInsertHandler() );
                // reader.setErrorHandler( new TestErrorHandler() );
                reader.parse( xml_doc_path );
            } catch ( Exception e ) {
                LoggerImpl.INSTANCE.logProblem( e );
            }
        }
        return flag;
    }


    public boolean importFoodList( String xml_doc_path ) {
        boolean completed = false;
        try {
            SAXParserFactory spf = SAXParserFactory.newInstance();
            SAXParser parser = spf.newSAXParser();
            XMLReader reader = parser.getXMLReader();
            reader.setContentHandler( new FoodInsertHandler() );
            reader.parse( xml_doc_path );
            completed = true;
        } catch ( Exception e ) {
            LoggerImpl.INSTANCE.logProblem( e );
        }
        return completed;
    }
}
