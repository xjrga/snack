package io.github.xjrga.snack.other;

import io.github.xjrga.snack.data.DbLink;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;

public class Xml_food_send {
    public Xml_food_send( DbLink dbLink, String foodid, String path ) {
        try {
            String doc = dbLink.export_food( foodid );
            BufferedWriter writer = new BufferedWriter( new FileWriter( path ) );
            writer.write( Utilities.format_xml_doc( doc ) );
            writer.close();
        } catch ( SQLException | IOException ex ) {
        }
    }
}
