package io.github.xjrga.snack.csv;

import io.github.xjrga.snack.database.Connect;
import io.github.xjrga.snack.dataobject.MixDO;
import io.github.xjrga.snack.logger.LoggerImpl;
import io.github.xjrga.snack.other.U;
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

    public void create(MixDO mixDataObject) {
        try {
            String path = "models/mixtotals.csv";
            boolean exists = Files.exists(Path.of(path));
            String mixid = mixDataObject.getMixid();
            CallableStatement proc = connection.prepareCall("{CALL public.MixTotals( ? )}");
            proc.setString(1, mixid);
            ResultSet rs = proc.executeQuery();
            StringBuilder comment = new StringBuilder();
            CSVFormat csvFormat = CSVFormat.DEFAULT;
            if (!exists) {
                csvFormat = CSVFormat.DEFAULT
                        .builder()
                        .setCommentMarker('#')
                        .setHeaderComments("Mix Totals Report", comment.toString(), LocalDateTime.now())
                        .setHeader(rs)
                        .get();
            }
            FileWriter fileWriter = new FileWriter(path, true);
            CSVPrinter csvPrinter = new CSVPrinter(fileWriter, csvFormat);
            while (rs.next()) {
                //mix_id
                String x1 = rs.getString(1);
                //mixname
                String x2 = rs.getString(2);
                //timestamp
                Timestamp x3 = rs.getTimestamp(3);
                //carbohydrates_carbs_by_diff
                BigDecimal x4 = rs.getBigDecimal(4);
                //carbohydrates_digestible
                BigDecimal x5 = rs.getBigDecimal(5);
                //carbohydrates_fiber
                BigDecimal x6 = rs.getBigDecimal(6);
                //carbohydrates_fiber_insoluble
                BigDecimal x7 = rs.getBigDecimal(7);
                //carbohydrates_fiber_soluble
                BigDecimal x8 = rs.getBigDecimal(8);
                //carbohydrates_fructose
                BigDecimal x9 = rs.getBigDecimal(9);
                //carbohydrates_glucose
                BigDecimal x10 = rs.getBigDecimal(10);
                //carbohydrates_glycemic_load
                BigDecimal x11 = rs.getBigDecimal(11);
                //carbohydrates_lactose
                BigDecimal x12 = rs.getBigDecimal(12);
                //carbohydrates_starch
                BigDecimal x13 = rs.getBigDecimal(13);
                //carbohydrates_sucrose
                BigDecimal x14 = rs.getBigDecimal(14);
                //carbohydrates_sugars
                BigDecimal x15 = rs.getBigDecimal(15);
                //energy_alcohol
                BigDecimal x16 = rs.getBigDecimal(16);
                //energy_carbohydrate
                BigDecimal x17 = rs.getBigDecimal(17);
                //energy_dha
                BigDecimal x18 = rs.getBigDecimal(18);
                //energy_digestible
                BigDecimal x19 = rs.getBigDecimal(19);
                //energy_epa
                BigDecimal x20 = rs.getBigDecimal(20);
                //energy_fat
                BigDecimal x21 = rs.getBigDecimal(21);
                //energy_fat_and_carbohydrate
                BigDecimal x22 = rs.getBigDecimal(22);
                //energy_gross
                BigDecimal x23 = rs.getBigDecimal(23);
                //energy_hcsfa
                BigDecimal x24 = rs.getBigDecimal(24);
                //energy_lcn3pufa
                BigDecimal x25 = rs.getBigDecimal(25);
                //energy_linoleic
                BigDecimal x26 = rs.getBigDecimal(26);
                //energy_linolenic
                BigDecimal x27 = rs.getBigDecimal(27);
                //energy_monounsaturated
                BigDecimal x28 = rs.getBigDecimal(28);
                //energy_polyunsaturated
                BigDecimal x29 = rs.getBigDecimal(29);
                //energy_protein
                BigDecimal x30 = rs.getBigDecimal(30);
                //energy_protein_and_carbohydrate
                BigDecimal x31 = rs.getBigDecimal(31);
                //energy_saturated
                BigDecimal x32 = rs.getBigDecimal(32);
                //fats_cholesterol
                BigDecimal x33 = rs.getBigDecimal(33);
                //fats_dha
                BigDecimal x34 = rs.getBigDecimal(34);
                //fats_epa
                BigDecimal x35 = rs.getBigDecimal(35);
                //fats_hcsfa
                BigDecimal x36 = rs.getBigDecimal(36);
                //fats_lauric
                BigDecimal x37 = rs.getBigDecimal(37);
                //fats_lcn3pufa
                BigDecimal x38 = rs.getBigDecimal(38);
                //fats_linoleic
                BigDecimal x39 = rs.getBigDecimal(39);
                //fats_linolenic
                BigDecimal x40 = rs.getBigDecimal(40);
                //fats_monounsaturated
                BigDecimal x41 = rs.getBigDecimal(41);
                //fats_myristic
                BigDecimal x42 = rs.getBigDecimal(42);
                //fats_palmitic
                BigDecimal x43 = rs.getBigDecimal(43);
                //fats_polyunsaturated
                BigDecimal x44 = rs.getBigDecimal(44);
                //fats_saturated
                BigDecimal x45 = rs.getBigDecimal(45);
                //fats_stearic
                BigDecimal x46 = rs.getBigDecimal(46);
                //fats_total
                BigDecimal x47 = rs.getBigDecimal(47);
                //minerals_calcium
                BigDecimal x48 = rs.getBigDecimal(48);
                //minerals_copper
                BigDecimal x49 = rs.getBigDecimal(49);
                //minerals_iron
                BigDecimal x50 = rs.getBigDecimal(50);
                //minerals_magnesium
                BigDecimal x51 = rs.getBigDecimal(51);
                //minerals_manganese
                BigDecimal x52 = rs.getBigDecimal(52);
                //minerals_phosphorus
                BigDecimal x53 = rs.getBigDecimal(53);
                //minerals_potassium
                BigDecimal x54 = rs.getBigDecimal(54);
                //minerals_selenium
                BigDecimal x55 = rs.getBigDecimal(55);
                //minerals_sodium
                BigDecimal x56 = rs.getBigDecimal(56);
                //minerals_zinc
                BigDecimal x57 = rs.getBigDecimal(57);
                //other_alcohol
                BigDecimal x58 = rs.getBigDecimal(58);
                //other_cost
                BigDecimal x59 = rs.getBigDecimal(59);
                //other_water
                BigDecimal x60 = rs.getBigDecimal(60);
                //other_weight
                BigDecimal x61 = rs.getBigDecimal(61);
                //phytonutrients_anthocyanins
                BigDecimal x62 = rs.getBigDecimal(62);
                //phytonutrients_beta_carotene
                BigDecimal x63 = rs.getBigDecimal(63);
                //phytonutrients_caffeine
                BigDecimal x64 = rs.getBigDecimal(64);
                //phytonutrients_carotenoids
                BigDecimal x65 = rs.getBigDecimal(65);
                //phytonutrients_flavanols
                BigDecimal x66 = rs.getBigDecimal(66);
                //phytonutrients_flavanones
                BigDecimal x67 = rs.getBigDecimal(67);
                //phytonutrients_flavones
                BigDecimal x68 = rs.getBigDecimal(68);
                //phytonutrients_flavonoids
                BigDecimal x69 = rs.getBigDecimal(69);
                //phytonutrients_flavonols
                BigDecimal x70 = rs.getBigDecimal(70);
                //phytonutrients_gamma_tocopherol
                BigDecimal x71 = rs.getBigDecimal(71);
                //phytonutrients_isoflavones
                BigDecimal x72 = rs.getBigDecimal(72);
                //phytonutrients_lutein_zeaxanthin
                BigDecimal x73 = rs.getBigDecimal(73);
                //phytonutrients_lycopene
                BigDecimal x74 = rs.getBigDecimal(74);
                //phytonutrients_phytosterols
                BigDecimal x75 = rs.getBigDecimal(75);
                //phytonutrients_theobromine
                BigDecimal x76 = rs.getBigDecimal(76);
                //protein_complete
                BigDecimal x77 = rs.getBigDecimal(77);
                //protein_total
                BigDecimal x78 = rs.getBigDecimal(78);
                //vitamins_choline
                BigDecimal x79 = rs.getBigDecimal(79);
                //vitamins_folate
                BigDecimal x80 = rs.getBigDecimal(80);
                //vitamins_niacin
                BigDecimal x81 = rs.getBigDecimal(81);
                //vitamins_pantothenic_acid
                BigDecimal x82 = rs.getBigDecimal(82);
                //vitamins_riboflavin
                BigDecimal x83 = rs.getBigDecimal(83);
                //vitamins_thiamin
                BigDecimal x84 = rs.getBigDecimal(84);
                //vitamins_vitamin_a
                BigDecimal x85 = rs.getBigDecimal(85);
                //vitamins_vitamin_b6
                BigDecimal x86 = rs.getBigDecimal(86);
                //vitamins_vitamin_b12
                BigDecimal x87 = rs.getBigDecimal(87);
                //vitamins_vitamin_c
                BigDecimal x88 = rs.getBigDecimal(88);
                //vitamins_vitamin_d
                BigDecimal x89 = rs.getBigDecimal(89);
                //vitamins_vitamin_e
                BigDecimal x90 = rs.getBigDecimal(90);
                //vitamins_vitamin_k
                BigDecimal x91 = rs.getBigDecimal(91);
                //
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
                        U.strip(x91));
                csvPrinter.flush();
                csvPrinter.close();
            }
        } catch (Exception e) {
            LoggerImpl.INSTANCE.logProblem(e);
        }
    }
}
