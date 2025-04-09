package io.github.xjrga.snack.csv;

import io.github.xjrga.snack.database.Connect;
import io.github.xjrga.snack.dataobject.MixDO;
import io.github.xjrga.snack.logger.LoggerImpl;
import io.github.xjrga.snack.other.Utilities;
import java.io.FileWriter;
import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

public class MixResultsReport2 {

  enum Headers {
    MixId,
    FoodId,
    Food,
    Nutrient,
    q
  }

  private final Connection connection;

  public MixResultsReport2() {
    connection = Connect.getInstance().getConnection();
  }

  public void create(MixDO mixDataObject) {
    try (FileWriter fileWriter = new FileWriter("models/mixresults2.csv")) {
      String mixid = mixDataObject.getMixId();
      CallableStatement proc = connection.prepareCall("{CALL public.MixResult_Select( ? )}");
      proc.setString(1, mixid);
      ResultSet rs = proc.executeQuery();
      StringBuilder comment = new StringBuilder();
      comment.append("");
      CSVFormat csvFormat =
          CSVFormat.DEFAULT
              .builder()
              .setCommentMarker('#')
              .setHeaderComments("Mix Results Report #2", comment.toString(), LocalDateTime.now())
              // .setHeader(rs)
              .setHeader(Headers.class)
              .get();
      CSVPrinter csvPrinter = new CSVPrinter(fileWriter, csvFormat);
      String c1 = rs.getMetaData().getColumnName(1); // mixid
      String c2 = rs.getMetaData().getColumnName(2); // foodid
      String c3 = rs.getMetaData().getColumnName(3); // foodname
      String c4 = rs.getMetaData().getColumnName(4);
      String c5 = rs.getMetaData().getColumnName(5);
      String c6 = rs.getMetaData().getColumnName(6);
      String c7 = rs.getMetaData().getColumnName(7);
      String c8 = rs.getMetaData().getColumnName(8);
      String c9 = rs.getMetaData().getColumnName(9);
      String c10 = rs.getMetaData().getColumnName(10);
      String c11 = rs.getMetaData().getColumnName(11);
      String c12 = rs.getMetaData().getColumnName(12);
      String c13 = rs.getMetaData().getColumnName(13);
      String c14 = rs.getMetaData().getColumnName(14);
      String c15 = rs.getMetaData().getColumnName(15);
      String c16 = rs.getMetaData().getColumnName(16);
      String c17 = rs.getMetaData().getColumnName(17);
      String c18 = rs.getMetaData().getColumnName(18);
      String c19 = rs.getMetaData().getColumnName(19);
      String c20 = rs.getMetaData().getColumnName(20);
      String c21 = rs.getMetaData().getColumnName(21);
      String c22 = rs.getMetaData().getColumnName(22);
      String c23 = rs.getMetaData().getColumnName(23);
      String c24 = rs.getMetaData().getColumnName(24);
      String c25 = rs.getMetaData().getColumnName(25);
      String c26 = rs.getMetaData().getColumnName(26);
      String c27 = rs.getMetaData().getColumnName(27);
      String c28 = rs.getMetaData().getColumnName(28);
      String c29 = rs.getMetaData().getColumnName(29);
      String c30 = rs.getMetaData().getColumnName(30);
      String c31 = rs.getMetaData().getColumnName(31);
      String c32 = rs.getMetaData().getColumnName(32);
      String c33 = rs.getMetaData().getColumnName(33);
      String c34 = rs.getMetaData().getColumnName(34);
      String c35 = rs.getMetaData().getColumnName(35);
      String c36 = rs.getMetaData().getColumnName(36);
      String c37 = rs.getMetaData().getColumnName(37);
      String c38 = rs.getMetaData().getColumnName(38);
      String c39 = rs.getMetaData().getColumnName(39);
      String c40 = rs.getMetaData().getColumnName(40);
      String c41 = rs.getMetaData().getColumnName(41);
      String c42 = rs.getMetaData().getColumnName(42);
      String c43 = rs.getMetaData().getColumnName(43);
      String c44 = rs.getMetaData().getColumnName(44);
      String c45 = rs.getMetaData().getColumnName(45);
      String c46 = rs.getMetaData().getColumnName(46);
      String c47 = rs.getMetaData().getColumnName(47);
      String c48 = rs.getMetaData().getColumnName(48);
      String c49 = rs.getMetaData().getColumnName(49);
      String c50 = rs.getMetaData().getColumnName(50);
      String c51 = rs.getMetaData().getColumnName(51);
      String c52 = rs.getMetaData().getColumnName(52);
      String c53 = rs.getMetaData().getColumnName(53);
      String c54 = rs.getMetaData().getColumnName(54);
      String c55 = rs.getMetaData().getColumnName(55);
      String c56 = rs.getMetaData().getColumnName(56);
      String c57 = rs.getMetaData().getColumnName(57);
      String c58 = rs.getMetaData().getColumnName(58);
      String c59 = rs.getMetaData().getColumnName(59);
      String c60 = rs.getMetaData().getColumnName(60);
      String c61 = rs.getMetaData().getColumnName(61);
      String c62 = rs.getMetaData().getColumnName(62);
      String c63 = rs.getMetaData().getColumnName(63);
      String c64 = rs.getMetaData().getColumnName(64);
      String c65 = rs.getMetaData().getColumnName(65);
      String c66 = rs.getMetaData().getColumnName(66);
      String c67 = rs.getMetaData().getColumnName(67);
      String c68 = rs.getMetaData().getColumnName(68);
      String c69 = rs.getMetaData().getColumnName(69);
      String c70 = rs.getMetaData().getColumnName(70);
      String c71 = rs.getMetaData().getColumnName(71);
      String c72 = rs.getMetaData().getColumnName(72);
      String c73 = rs.getMetaData().getColumnName(73);
      String c74 = rs.getMetaData().getColumnName(74);
      String c75 = rs.getMetaData().getColumnName(75);
      String c76 = rs.getMetaData().getColumnName(76);
      String c77 = rs.getMetaData().getColumnName(77);
      String c78 = rs.getMetaData().getColumnName(78);
      String c79 = rs.getMetaData().getColumnName(79);
      String c80 = rs.getMetaData().getColumnName(80);
      while (rs.next()) {
        String x1 = rs.getString(1);
        String x2 = rs.getString(2);
        String x3 = rs.getString(3);
        BigDecimal x4 = rs.getBigDecimal(4);
        csvPrinter.printRecord(x1, x2, x3, c4, Utilities.strip(x4));
        BigDecimal x5 = rs.getBigDecimal(5);
        csvPrinter.printRecord(x1, x2, x3, c5, Utilities.strip(x5));
        BigDecimal x6 = rs.getBigDecimal(6);
        csvPrinter.printRecord(x1, x2, x3, c6, Utilities.strip(x6));
        BigDecimal x7 = rs.getBigDecimal(7);
        csvPrinter.printRecord(x1, x2, x3, c7, Utilities.strip(x7));
        BigDecimal x8 = rs.getBigDecimal(8);
        csvPrinter.printRecord(x1, x2, x3, c8, Utilities.strip(x8));
        BigDecimal x9 = rs.getBigDecimal(9);
        csvPrinter.printRecord(x1, x2, x3, c9, Utilities.strip(x9));
        BigDecimal x10 = rs.getBigDecimal(10);
        csvPrinter.printRecord(x1, x2, x3, c10, Utilities.strip(x10));
        BigDecimal x11 = rs.getBigDecimal(11);
        csvPrinter.printRecord(x1, x2, x3, c11, Utilities.strip(x11));
        BigDecimal x12 = rs.getBigDecimal(12);
        csvPrinter.printRecord(x1, x2, x3, c12, Utilities.strip(x12));
        BigDecimal x13 = rs.getBigDecimal(13);
        csvPrinter.printRecord(x1, x2, x3, c13, Utilities.strip(x13));
        BigDecimal x14 = rs.getBigDecimal(14);
        csvPrinter.printRecord(x1, x2, x3, c14, Utilities.strip(x14));
        BigDecimal x15 = rs.getBigDecimal(15);
        csvPrinter.printRecord(x1, x2, x3, c15, Utilities.strip(x15));
        BigDecimal x16 = rs.getBigDecimal(16);
        csvPrinter.printRecord(x1, x2, x3, c16, Utilities.strip(x16));
        BigDecimal x17 = rs.getBigDecimal(17);
        csvPrinter.printRecord(x1, x2, x3, c17, Utilities.strip(x17));
        BigDecimal x18 = rs.getBigDecimal(18);
        csvPrinter.printRecord(x1, x2, x3, c18, Utilities.strip(x18));
        BigDecimal x19 = rs.getBigDecimal(19);
        csvPrinter.printRecord(x1, x2, x3, c19, Utilities.strip(x19));
        BigDecimal x20 = rs.getBigDecimal(20);
        csvPrinter.printRecord(x1, x2, x3, c20, Utilities.strip(x20));
        BigDecimal x21 = rs.getBigDecimal(21);
        csvPrinter.printRecord(x1, x2, x3, c21, Utilities.strip(x21));
        BigDecimal x22 = rs.getBigDecimal(22);
        csvPrinter.printRecord(x1, x2, x3, c22, Utilities.strip(x22));
        BigDecimal x23 = rs.getBigDecimal(23);
        csvPrinter.printRecord(x1, x2, x3, c23, Utilities.strip(x23));
        BigDecimal x24 = rs.getBigDecimal(24);
        csvPrinter.printRecord(x1, x2, x3, c24, Utilities.strip(x24));
        BigDecimal x25 = rs.getBigDecimal(25);
        csvPrinter.printRecord(x1, x2, x3, c25, Utilities.strip(x25));
        BigDecimal x26 = rs.getBigDecimal(26);
        csvPrinter.printRecord(x1, x2, x3, c26, Utilities.strip(x26));
        BigDecimal x27 = rs.getBigDecimal(27);
        csvPrinter.printRecord(x1, x2, x3, c27, Utilities.strip(x27));
        BigDecimal x28 = rs.getBigDecimal(28);
        csvPrinter.printRecord(x1, x2, x3, c28, Utilities.strip(x28));
        BigDecimal x29 = rs.getBigDecimal(29);
        csvPrinter.printRecord(x1, x2, x3, c29, Utilities.strip(x29));
        BigDecimal x30 = rs.getBigDecimal(30);
        csvPrinter.printRecord(x1, x2, x3, c30, Utilities.strip(x30));
        BigDecimal x31 = rs.getBigDecimal(31);
        csvPrinter.printRecord(x1, x2, x3, c31, Utilities.strip(x31));
        BigDecimal x32 = rs.getBigDecimal(32);
        csvPrinter.printRecord(x1, x2, x3, c32, Utilities.strip(x32));
        BigDecimal x33 = rs.getBigDecimal(33);
        csvPrinter.printRecord(x1, x2, x3, c33, Utilities.strip(x33));
        BigDecimal x34 = rs.getBigDecimal(34);
        csvPrinter.printRecord(x1, x2, x3, c34, Utilities.strip(x34));
        BigDecimal x35 = rs.getBigDecimal(35);
        csvPrinter.printRecord(x1, x2, x3, c35, Utilities.strip(x35));
        BigDecimal x36 = rs.getBigDecimal(36);
        csvPrinter.printRecord(x1, x2, x3, c36, Utilities.strip(x36));
        BigDecimal x37 = rs.getBigDecimal(37);
        csvPrinter.printRecord(x1, x2, x3, c37, Utilities.strip(x37));
        BigDecimal x38 = rs.getBigDecimal(38);
        csvPrinter.printRecord(x1, x2, x3, c38, Utilities.strip(x38));
        BigDecimal x39 = rs.getBigDecimal(39);
        csvPrinter.printRecord(x1, x2, x3, c39, Utilities.strip(x39));
        BigDecimal x40 = rs.getBigDecimal(40);
        csvPrinter.printRecord(x1, x2, x3, c40, Utilities.strip(x40));
        BigDecimal x41 = rs.getBigDecimal(41);
        csvPrinter.printRecord(x1, x2, x3, c41, Utilities.strip(x41));
        BigDecimal x42 = rs.getBigDecimal(42);
        csvPrinter.printRecord(x1, x2, x3, c42, Utilities.strip(x42));
        BigDecimal x43 = rs.getBigDecimal(43);
        csvPrinter.printRecord(x1, x2, x3, c43, Utilities.strip(x43));
        BigDecimal x44 = rs.getBigDecimal(44);
        csvPrinter.printRecord(x1, x2, x3, c44, Utilities.strip(x44));
        BigDecimal x45 = rs.getBigDecimal(45);
        csvPrinter.printRecord(x1, x2, x3, c45, Utilities.strip(x45));
        BigDecimal x46 = rs.getBigDecimal(46);
        csvPrinter.printRecord(x1, x2, x3, c46, Utilities.strip(x46));
        BigDecimal x47 = rs.getBigDecimal(47);
        csvPrinter.printRecord(x1, x2, x3, c47, Utilities.strip(x47));
        BigDecimal x48 = rs.getBigDecimal(48);
        csvPrinter.printRecord(x1, x2, x3, c48, Utilities.strip(x48));
        BigDecimal x49 = rs.getBigDecimal(49);
        csvPrinter.printRecord(x1, x2, x3, c49, Utilities.strip(x49));
        BigDecimal x50 = rs.getBigDecimal(50);
        csvPrinter.printRecord(x1, x2, x3, c50, Utilities.strip(x50));
        BigDecimal x51 = rs.getBigDecimal(51);
        csvPrinter.printRecord(x1, x2, x3, c51, Utilities.strip(x51));
        BigDecimal x52 = rs.getBigDecimal(52);
        csvPrinter.printRecord(x1, x2, x3, c52, Utilities.strip(x52));
        BigDecimal x53 = rs.getBigDecimal(53);
        csvPrinter.printRecord(x1, x2, x3, c53, Utilities.strip(x53));
        BigDecimal x54 = rs.getBigDecimal(54);
        csvPrinter.printRecord(x1, x2, x3, c54, Utilities.strip(x54));
        BigDecimal x55 = rs.getBigDecimal(55);
        csvPrinter.printRecord(x1, x2, x3, c55, Utilities.strip(x55));
        BigDecimal x56 = rs.getBigDecimal(56);
        csvPrinter.printRecord(x1, x2, x3, c56, Utilities.strip(x56));
        BigDecimal x57 = rs.getBigDecimal(57);
        csvPrinter.printRecord(x1, x2, x3, c57, Utilities.strip(x57));
        BigDecimal x58 = rs.getBigDecimal(58);
        csvPrinter.printRecord(x1, x2, x3, c58, Utilities.strip(x58));
        BigDecimal x59 = rs.getBigDecimal(59);
        csvPrinter.printRecord(x1, x2, x3, c59, Utilities.strip(x59));
        BigDecimal x60 = rs.getBigDecimal(60);
        csvPrinter.printRecord(x1, x2, x3, c60, Utilities.strip(x60));
        BigDecimal x61 = rs.getBigDecimal(61);
        csvPrinter.printRecord(x1, x2, x3, c61, Utilities.strip(x61));
        BigDecimal x62 = rs.getBigDecimal(62);
        csvPrinter.printRecord(x1, x2, x3, c62, Utilities.strip(x62));
        BigDecimal x63 = rs.getBigDecimal(63);
        csvPrinter.printRecord(x1, x2, x3, c63, Utilities.strip(x63));
        BigDecimal x64 = rs.getBigDecimal(64);
        csvPrinter.printRecord(x1, x2, x3, c64, Utilities.strip(x64));
        BigDecimal x65 = rs.getBigDecimal(65);
        csvPrinter.printRecord(x1, x2, x3, c65, Utilities.strip(x65));
        BigDecimal x66 = rs.getBigDecimal(66);
        csvPrinter.printRecord(x1, x2, x3, c66, Utilities.strip(x66));
        BigDecimal x67 = rs.getBigDecimal(67);
        csvPrinter.printRecord(x1, x2, x3, c67, Utilities.strip(x67));
        BigDecimal x68 = rs.getBigDecimal(68);
        csvPrinter.printRecord(x1, x2, x3, c68, Utilities.strip(x68));
        BigDecimal x69 = rs.getBigDecimal(69);
        csvPrinter.printRecord(x1, x2, x3, c69, Utilities.strip(x69));
        BigDecimal x70 = rs.getBigDecimal(70);
        csvPrinter.printRecord(x1, x2, x3, c70, Utilities.strip(x70));
        BigDecimal x71 = rs.getBigDecimal(71);
        csvPrinter.printRecord(x1, x2, x3, c71, Utilities.strip(x71));
        BigDecimal x72 = rs.getBigDecimal(72);
        csvPrinter.printRecord(x1, x2, x3, c72, Utilities.strip(x72));
        BigDecimal x73 = rs.getBigDecimal(73);
        csvPrinter.printRecord(x1, x2, x3, c73, Utilities.strip(x73));
        BigDecimal x74 = rs.getBigDecimal(74);
        csvPrinter.printRecord(x1, x2, x3, c74, Utilities.strip(x74));
        BigDecimal x75 = rs.getBigDecimal(75);
        csvPrinter.printRecord(x1, x2, x3, c75, Utilities.strip(x75));
        BigDecimal x76 = rs.getBigDecimal(76);
        csvPrinter.printRecord(x1, x2, x3, c76, Utilities.strip(x76));
        BigDecimal x77 = rs.getBigDecimal(77);
        csvPrinter.printRecord(x1, x2, x3, c77, Utilities.strip(x77));
        BigDecimal x78 = rs.getBigDecimal(78);
        csvPrinter.printRecord(x1, x2, x3, c78, Utilities.strip(x78));
        BigDecimal x79 = rs.getBigDecimal(79);
        csvPrinter.printRecord(x1, x2, x3, c79, Utilities.strip(x79));
        BigDecimal x80 = rs.getBigDecimal(80);
        csvPrinter.printRecord(x1, x2, x3, c80, Utilities.strip(x80));
      }
    } catch (Exception e) {
      LoggerImpl.INSTANCE.logProblem(e);
    }
  }
}
