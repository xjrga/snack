package io.github.xjrga.snack.other;

import java.io.File;
import java.io.IOException;
import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import org.xml.sax.SAXException;

public class XmlDocValidator {
  private boolean valid;

  public XmlDocValidator(String schema_path, String xmldoc_path) {
    valid = false;
    Source xmlDoc = new StreamSource(new File(xmldoc_path));
    SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
    javax.xml.validation.Validator validator = null;
    try {
      Schema xmlSchema = schemaFactory.newSchema(new File(schema_path));
      validator = xmlSchema.newValidator();
    } catch (SAXException e) {
      e.printStackTrace();
      Log.Log2.append("Xml doc validation error: ");
      Log.Log2.append(e.getLocalizedMessage());
      Log.Log2.append("\n");
    } finally {
      try {
        validator.validate(xmlDoc);
        valid = true;
      } catch (SAXException | IOException e) {
        e.printStackTrace();
        Log.Log2.append("Xml doc validation error: ");
        Log.Log2.append(e.getLocalizedMessage());
        Log.Log2.append("\n");
      }
    }
  }

  public boolean isValid() {
    return valid;
  }
}
