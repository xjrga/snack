package io.github.xjrga.snack.csv;

import io.github.xjrga.snack.database.Connect;
import io.github.xjrga.snack.dataobject.MixDO;
import io.github.xjrga.snack.logger.LoggerImpl;
import io.github.xjrga.snack.other.U;
import java.io.FileWriter;
import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

public class MixResultsReportDn {

    private final Connection connection;

    public MixResultsReportDn() {
        connection = Connect.getInstance().getConnection();
    }

    public void create(MixDO mixDataObject) {
        try (FileWriter fileWriter = new FileWriter("models/mixresultsdn.csv")) {
            String mixid = mixDataObject.getMixid();
            CallableStatement proc = connection.prepareCall("{CALL public.MixResult_Select_Exp( ? )}");
            proc.setString(1, mixid);
            ResultSet rs = proc.executeQuery();
            StringBuilder comment = new StringBuilder();
            comment.append("");
            CSVFormat csvFormat = CSVFormat.DEFAULT
                    .builder()
                    .setCommentMarker('#')
                    .setHeaderComments("Mix Results Report Denormalized", comment.toString(), LocalDateTime.now())
                    .setHeader(rs)
                    .get();
            CSVPrinter csvPrinter = new CSVPrinter(fileWriter, csvFormat);
            while (rs.next()) {
                String x1 = rs.getString(1); // mixid
                String x2 = rs.getString(2); // foodid
                String x3 = rs.getString(3); // foodname
                BigDecimal x4 = rs.getBigDecimal(4);
                BigDecimal x5 = rs.getBigDecimal(5);
                BigDecimal x6 = rs.getBigDecimal(6);
                BigDecimal x7 = rs.getBigDecimal(7);
                BigDecimal x8 = rs.getBigDecimal(8);
                BigDecimal x9 = rs.getBigDecimal(9);
                BigDecimal x10 = rs.getBigDecimal(10);
                BigDecimal x11 = rs.getBigDecimal(11);
                BigDecimal x12 = rs.getBigDecimal(12);
                BigDecimal x13 = rs.getBigDecimal(13);
                BigDecimal x14 = rs.getBigDecimal(14);
                BigDecimal x15 = rs.getBigDecimal(15);
                BigDecimal x16 = rs.getBigDecimal(16);
                BigDecimal x17 = rs.getBigDecimal(17);
                BigDecimal x18 = rs.getBigDecimal(18);
                BigDecimal x19 = rs.getBigDecimal(19);
                BigDecimal x20 = rs.getBigDecimal(20);
                BigDecimal x21 = rs.getBigDecimal(21);
                BigDecimal x22 = rs.getBigDecimal(22);
                BigDecimal x23 = rs.getBigDecimal(23);
                BigDecimal x24 = rs.getBigDecimal(24);
                BigDecimal x25 = rs.getBigDecimal(25);
                BigDecimal x26 = rs.getBigDecimal(26);
                BigDecimal x27 = rs.getBigDecimal(27);
                BigDecimal x28 = rs.getBigDecimal(28);
                BigDecimal x29 = rs.getBigDecimal(29);
                BigDecimal x30 = rs.getBigDecimal(30);
                BigDecimal x31 = rs.getBigDecimal(31);
                BigDecimal x32 = rs.getBigDecimal(32);
                BigDecimal x33 = rs.getBigDecimal(33);
                BigDecimal x34 = rs.getBigDecimal(34);
                BigDecimal x35 = rs.getBigDecimal(35);
                BigDecimal x36 = rs.getBigDecimal(36);
                BigDecimal x37 = rs.getBigDecimal(37);
                BigDecimal x38 = rs.getBigDecimal(38);
                BigDecimal x39 = rs.getBigDecimal(39);
                BigDecimal x40 = rs.getBigDecimal(40);
                BigDecimal x41 = rs.getBigDecimal(41);
                BigDecimal x42 = rs.getBigDecimal(42);
                BigDecimal x43 = rs.getBigDecimal(43);
                BigDecimal x44 = rs.getBigDecimal(44);
                BigDecimal x45 = rs.getBigDecimal(45);
                BigDecimal x46 = rs.getBigDecimal(46);
                BigDecimal x47 = rs.getBigDecimal(47);
                BigDecimal x48 = rs.getBigDecimal(48);
                BigDecimal x49 = rs.getBigDecimal(49);
                BigDecimal x50 = rs.getBigDecimal(50);
                BigDecimal x51 = rs.getBigDecimal(51);
                BigDecimal x52 = rs.getBigDecimal(52);
                BigDecimal x53 = rs.getBigDecimal(53);
                BigDecimal x54 = rs.getBigDecimal(54);
                BigDecimal x55 = rs.getBigDecimal(55);
                BigDecimal x56 = rs.getBigDecimal(56);
                BigDecimal x57 = rs.getBigDecimal(57);
                BigDecimal x58 = rs.getBigDecimal(58);
                BigDecimal x59 = rs.getBigDecimal(59);
                BigDecimal x60 = rs.getBigDecimal(60);
                BigDecimal x61 = rs.getBigDecimal(61);
                BigDecimal x62 = rs.getBigDecimal(62);
                BigDecimal x63 = rs.getBigDecimal(63);
                BigDecimal x64 = rs.getBigDecimal(64);
                BigDecimal x65 = rs.getBigDecimal(65);
                BigDecimal x66 = rs.getBigDecimal(66);
                BigDecimal x67 = rs.getBigDecimal(67);
                BigDecimal x68 = rs.getBigDecimal(68);
                BigDecimal x69 = rs.getBigDecimal(69);
                BigDecimal x70 = rs.getBigDecimal(70);
                BigDecimal x71 = rs.getBigDecimal(71);
                BigDecimal x72 = rs.getBigDecimal(72);
                BigDecimal x73 = rs.getBigDecimal(73);
                BigDecimal x74 = rs.getBigDecimal(74);
                BigDecimal x75 = rs.getBigDecimal(75);
                BigDecimal x76 = rs.getBigDecimal(76);
                BigDecimal x77 = rs.getBigDecimal(77);
                BigDecimal x78 = rs.getBigDecimal(78);
                BigDecimal x79 = rs.getBigDecimal(79);
                BigDecimal x80 = rs.getBigDecimal(80);
                BigDecimal x81 = rs.getBigDecimal(81);
                BigDecimal x82 = rs.getBigDecimal(82);
                BigDecimal x83 = rs.getBigDecimal(83);
                BigDecimal x84 = rs.getBigDecimal(84);
                BigDecimal x85 = rs.getBigDecimal(85);
                BigDecimal x86 = rs.getBigDecimal(86);
                BigDecimal x87 = rs.getBigDecimal(87);
                BigDecimal x88 = rs.getBigDecimal(88);
                BigDecimal x89 = rs.getBigDecimal(89);
                BigDecimal x90 = rs.getBigDecimal(90);
                BigDecimal x91 = rs.getBigDecimal(91);
                csvPrinter.printRecord(x1,
                        x2,
                        x3,
                        U.strip(x4),
                        U.strip(x5),
                        U.strip(x6),
                        U.strip(x7),
                        U.strip(x8),
                        U.strip(x9),
                        U.strip(x10),
                        U.strip(x11),
                        U.strip(x12),
                        U.strip(x13),
                        U.strip(x14),
                        U.strip(x15),
                        U.strip(x16),
                        U.strip(x17),
                        U.strip(x18),
                        U.strip(x19),
                        U.strip(x20),
                        U.strip(x21),
                        U.strip(x22),
                        U.strip(x23),
                        U.strip(x24),
                        U.strip(x25),
                        U.strip(x26),
                        U.strip(x27),
                        U.strip(x28),
                        U.strip(x29),
                        U.strip(x30),
                        U.strip(x31),
                        U.strip(x32),
                        U.strip(x33),
                        U.strip(x34),
                        U.strip(x35),
                        U.strip(x36),
                        U.strip(x37),
                        U.strip(x38),
                        U.strip(x39),
                        U.strip(x40),
                        U.strip(x41),
                        U.strip(x42),
                        U.strip(x43),
                        U.strip(x44),
                        U.strip(x45),
                        U.strip(x46),
                        U.strip(x47),
                        U.strip(x48),
                        U.strip(x49),
                        U.strip(x50),
                        U.strip(x51),
                        U.strip(x52),
                        U.strip(x53),
                        U.strip(x54),
                        U.strip(x55),
                        U.strip(x56),
                        U.strip(x57),
                        U.strip(x58),
                        U.strip(x59),
                        U.strip(x60),
                        U.strip(x61),
                        U.strip(x62),
                        U.strip(x63),
                        U.strip(x64),
                        U.strip(x65),
                        U.strip(x66),
                        U.strip(x67),
                        U.strip(x68),
                        U.strip(x69),
                        U.strip(x70),
                        U.strip(x71),
                        U.strip(x72),
                        U.strip(x73),
                        U.strip(x74),
                        U.strip(x75),
                        U.strip(x76),
                        U.strip(x77),
                        U.strip(x78),
                        U.strip(x79),
                        U.strip(x80),
                        U.strip(x81),
                        U.strip(x82),
                        U.strip(x83),
                        U.strip(x84),
                        U.strip(x85),
                        U.strip(x86),
                        U.strip(x87),
                        U.strip(x88),
                        U.strip(x89),
                        U.strip(x90),
                        U.strip(x91)
                );
            }
        } catch (Exception e) {
            LoggerImpl.INSTANCE.logProblem(e);
        }
    }
}
