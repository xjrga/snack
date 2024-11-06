package io.github.xjrga.snack.other;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import io.github.xjrga.snack.database.DbLink;

public class XmlFoodSender {
  public XmlFoodSender(DbLink dbLink, String foodid, String path) {
    try {
      String doc = dbLink.export_food(foodid);
      BufferedWriter writer = new BufferedWriter(new FileWriter(path));
      writer.write(Utilities.format_xml_doc(doc));
      writer.close();
    } catch (SQLException | IOException ex) {
    }
  }
}
