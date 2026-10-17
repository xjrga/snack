package io.github.xjrga.snack.csv;

import io.github.xjrga.snack.completablefuture.records.Records.FoodDetails;
import io.github.xjrga.snack.database.Connect;
import io.github.xjrga.snack.logger.LoggerImpl;
import io.github.xjrga.snack.other.U;
import java.io.FileWriter;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

public class AllFoodsReportDn {

    private final Connection connection;

    public AllFoodsReportDn() {
        connection = Connect.getInstance().getConnection();
    }

    public void create() {
        try (FileWriter fileWriter = new FileWriter("models/allfoodsdn.csv")) {
            CallableStatement proc = connection.prepareCall("{CALL public.Food_Select_Details_Exp()}");
            ResultSet rs = proc.executeQuery();
            StringBuilder comment = new StringBuilder();
            comment.append("Nutritional Values For Common Foods And Products");
            CSVFormat csvFormat = CSVFormat.DEFAULT
                    .builder()
                    .setCommentMarker('#')
                    .setHeaderComments("All Foods Report Denormalized", comment.toString(), LocalDateTime.now())
                    .setHeader(rs)
                    .get();
            CSVPrinter csvPrinter = new CSVPrinter(fileWriter, csvFormat);
            while (rs.next()) {
                FoodDetails food = new FoodDetails(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getBigDecimal(3),
                        rs.getBigDecimal(4),
                        rs.getBigDecimal(5),
                        rs.getBigDecimal(6),
                        rs.getBigDecimal(7),
                        rs.getBigDecimal(8),
                        rs.getBigDecimal(9),
                        rs.getBigDecimal(10),
                        rs.getBigDecimal(11),
                        rs.getBigDecimal(12),
                        rs.getBigDecimal(13),
                        rs.getBigDecimal(14),
                        rs.getBigDecimal(15),
                        rs.getBigDecimal(16),
                        rs.getBigDecimal(17),
                        rs.getBigDecimal(18),
                        rs.getBigDecimal(19),
                        rs.getBigDecimal(20),
                        rs.getBigDecimal(21),
                        rs.getBigDecimal(22),
                        rs.getBigDecimal(23),
                        rs.getBigDecimal(24),
                        rs.getBigDecimal(25),
                        rs.getBigDecimal(26),
                        rs.getBigDecimal(27),
                        rs.getBigDecimal(28),
                        rs.getBigDecimal(29),
                        rs.getBigDecimal(30),
                        rs.getBigDecimal(31),
                        rs.getBigDecimal(32),
                        rs.getBigDecimal(33),
                        rs.getBigDecimal(34),
                        rs.getBigDecimal(35),
                        rs.getBigDecimal(36),
                        rs.getBigDecimal(37),
                        rs.getBigDecimal(38),
                        rs.getBigDecimal(39),
                        rs.getBigDecimal(40),
                        rs.getBigDecimal(41),
                        rs.getBigDecimal(42),
                        rs.getBigDecimal(43),
                        rs.getBigDecimal(44),
                        rs.getBigDecimal(45),
                        rs.getBigDecimal(46),
                        rs.getBigDecimal(47),
                        rs.getBigDecimal(48),
                        rs.getBigDecimal(49),
                        rs.getBigDecimal(50),
                        rs.getBigDecimal(51),
                        rs.getBigDecimal(52),
                        rs.getBigDecimal(53),
                        rs.getBigDecimal(54),
                        rs.getBigDecimal(55),
                        rs.getBigDecimal(56),
                        rs.getBigDecimal(57),
                        rs.getBigDecimal(58),
                        rs.getBigDecimal(59),
                        rs.getBigDecimal(60),
                        rs.getBigDecimal(61),
                        rs.getBigDecimal(62),
                        rs.getBigDecimal(63),
                        rs.getBigDecimal(64),
                        rs.getBigDecimal(65),
                        rs.getBigDecimal(66),
                        rs.getBigDecimal(67),
                        rs.getBigDecimal(68),
                        rs.getBigDecimal(69),
                        rs.getBigDecimal(70),
                        rs.getBigDecimal(71),
                        rs.getBigDecimal(72),
                        rs.getBigDecimal(73),
                        rs.getBigDecimal(74),
                        rs.getBigDecimal(75),
                        rs.getBigDecimal(76),
                        rs.getBigDecimal(77),
                        rs.getBigDecimal(78),
                        rs.getBigDecimal(79),
                        rs.getBigDecimal(80),
                        rs.getBigDecimal(81),
                        rs.getBigDecimal(82),
                        rs.getBigDecimal(83),
                        rs.getBigDecimal(84),
                        rs.getBigDecimal(85),
                        rs.getBigDecimal(86),
                        rs.getBigDecimal(87),
                        rs.getBigDecimal(88),
                        rs.getBigDecimal(89),
                        rs.getBigDecimal(90)
                );
                csvPrinter.printRecord(food.food_id(),
                        food.food_name(),
                        U.strip(food.carbohydrates_carbs_by_diff()),
                        U.strip(food.carbohydrates_digestible()),
                        U.strip(food.carbohydrates_fiber()),
                        U.strip(food.carbohydrates_fiber_insoluble()),
                        U.strip(food.carbohydrates_fiber_soluble()),
                        U.strip(food.carbohydrates_fructose()),
                        U.strip(food.carbohydrates_glucose()),
                        U.strip(food.carbohydrates_glycemic_load()),
                        U.strip(food.carbohydrates_lactose()),
                        U.strip(food.carbohydrates_starch()),
                        U.strip(food.carbohydrates_sucrose()),
                        U.strip(food.carbohydrates_sugars()),
                        U.strip(food.energy_alcohol()),
                        U.strip(food.energy_carbohydrate()),
                        U.strip(food.energy_dha()),
                        U.strip(food.energy_digestible()),
                        U.strip(food.energy_epa()),
                        U.strip(food.energy_fat()),
                        U.strip(food.energy_fat_and_carbohydrate()),
                        U.strip(food.energy_gross()),
                        U.strip(food.energy_hcsfa()),
                        U.strip(food.energy_lcn3pufa()),
                        U.strip(food.energy_linoleic()),
                        U.strip(food.energy_linolenic()),
                        U.strip(food.energy_monounsaturated()),
                        U.strip(food.energy_polyunsaturated()),
                        U.strip(food.energy_protein()),
                        U.strip(food.energy_protein_and_carbohydrate()),
                        U.strip(food.energy_saturated()),
                        U.strip(food.fats_cholesterol()),
                        U.strip(food.fats_dha()),
                        U.strip(food.fats_epa()),
                        U.strip(food.fats_hcsfa()),
                        U.strip(food.fats_lauric()),
                        U.strip(food.fats_lcn3pufa()),
                        U.strip(food.fats_linoleic()),
                        U.strip(food.fats_linolenic()),
                        U.strip(food.fats_monounsaturated()),
                        U.strip(food.fats_myristic()),
                        U.strip(food.fats_palmitic()),
                        U.strip(food.fats_polyunsaturated()),
                        U.strip(food.fats_saturated()),
                        U.strip(food.fats_stearic()),
                        U.strip(food.fats_total()),
                        U.strip(food.minerals_calcium()),
                        U.strip(food.minerals_copper()),
                        U.strip(food.minerals_iron()),
                        U.strip(food.minerals_magnesium()),
                        U.strip(food.minerals_manganese()),
                        U.strip(food.minerals_phosphorus()),
                        U.strip(food.minerals_potassium()),
                        U.strip(food.minerals_selenium()),
                        U.strip(food.minerals_sodium()),
                        U.strip(food.minerals_zinc()),
                        U.strip(food.other_alcohol()),
                        U.strip(food.other_cost()),
                        U.strip(food.other_water()),
                        U.strip(food.other_weight()),
                        U.strip(food.phytonutrients_anthocyanins()),
                        U.strip(food.phytonutrients_beta_carotene()),
                        U.strip(food.phytonutrients_caffeine()),
                        U.strip(food.phytonutrients_carotenoids()),
                        U.strip(food.phytonutrients_flavanols()),
                        U.strip(food.phytonutrients_flavanones()),
                        U.strip(food.phytonutrients_flavones()),
                        U.strip(food.phytonutrients_flavonoids()),
                        U.strip(food.phytonutrients_flavonols()),
                        U.strip(food.phytonutrients_gamma_tocopherol()),
                        U.strip(food.phytonutrients_isoflavones()),
                        U.strip(food.phytonutrients_lutein_zeaxanthin()),
                        U.strip(food.phytonutrients_lycopene()),
                        U.strip(food.phytonutrients_phytosterols()),
                        U.strip(food.phytonutrients_theobromine()),
                        U.strip(food.protein_complete()),
                        U.strip(food.protein_total()),
                        U.strip(food.vitamins_choline()),
                        U.strip(food.vitamins_folate()),
                        U.strip(food.vitamins_niacin()),
                        U.strip(food.vitamins_pantothenic_acid()),
                        U.strip(food.vitamins_riboflavin()),
                        U.strip(food.vitamins_thiamin()),
                        U.strip(food.vitamins_vitamin_a()),
                        U.strip(food.vitamins_vitamin_b6()),
                        U.strip(food.vitamins_vitamin_b12()),
                        U.strip(food.vitamins_vitamin_c()),
                        U.strip(food.vitamins_vitamin_d()),
                        U.strip(food.vitamins_vitamin_e()),
                        U.strip(food.vitamins_vitamin_k())
                );
            }
        } catch (Exception e) {
            LoggerImpl.INSTANCE.logProblem(e);
        }
    }
}
