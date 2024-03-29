package io.github.xjrga.snack.other;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import io.github.xjrga.snack.database.DbLink;

public class XmlMixSender {
  public XmlMixSender(DbLink dbLink, String mixid, String path) {
    try {
      String doc = dbLink.export_mix(mixid);
      BufferedWriter writer = new BufferedWriter(new FileWriter(path));
      writer.write(Utilities.format_xml_doc(doc));
      writer.close();
    } catch (SQLException | IOException ex) {
    }
  }
}
