package io.github.xjrga.snack.database.callable.select;

import io.github.xjrga.snack.database.Connect;
import io.github.xjrga.snack.logger.LoggerImpl;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * @author jr
 */
public class FoodFactsTask implements Callable<List<List>> {

    private final Connection connection;

    public FoodFactsTask() {
        connection = Connect.getInstance().getConnection();
    }

    @Override
    public List<List> call() {
        List<List> table = new ArrayList();
        try (CallableStatement proc = connection.prepareCall("{CALL public.Food_Select_Details_Exp()}")) {
            ResultSet rs = proc.executeQuery();
            while (rs.next()) {
                ArrayList row = new ArrayList();
                //Food
                //food_id
                row.add(rs.getString(1));
                //food_name
                row.add(rs.getString(2));
                //other_weight
                row.add(rs.getBigDecimal(60));
                //Calories
                //energy_gross
                row.add(rs.getBigDecimal(22));
                //energy_digestible
                row.add(rs.getBigDecimal(18));
                //energy_fat
                row.add(rs.getBigDecimal(20));
                //energy_carbohydrate
                row.add(rs.getBigDecimal(16));
                //energy_protein
                row.add(rs.getBigDecimal(29));
                //energy_alcohol
                row.add(rs.getBigDecimal(15));
                //Macronutrients
                //fats_total
                row.add(rs.getBigDecimal(46));
                //carbohydrates_digestible
                row.add(rs.getBigDecimal(4));
                //protein_total
                row.add(rs.getBigDecimal(77));
                //other_alcohol
                row.add(rs.getBigDecimal(57));
                //Protein
                //protein_total
                row.add(rs.getBigDecimal(77));
                //protein_complete
                row.add(rs.getBigDecimal(76));
                //Fats
                //fats_total
                row.add(rs.getBigDecimal(46));
                //fats_monounsaturated
                row.add(rs.getBigDecimal(40));
                //fats_polyunsaturated
                row.add(rs.getBigDecimal(43));
                //fats_saturated
                row.add(rs.getBigDecimal(44));
                //fats_cholesterol
                row.add(rs.getBigDecimal(32));
                //Saturated Fat
                //fats_saturated
                row.add(rs.getBigDecimal(44));
                //fats_hcsfa
                row.add(rs.getBigDecimal(35));
                //fats_lauric
                row.add(rs.getBigDecimal(36));
                //fats_myristic
                row.add(rs.getBigDecimal(41));
                //fats_palmitic
                row.add(rs.getBigDecimal(42));
                //fats_stearic
                row.add(rs.getBigDecimal(45));
                //fats_cholesterol
                row.add(rs.getBigDecimal(32));
                //Polyunsaturated Fat
                //fats_polyunsaturated
                row.add(rs.getBigDecimal(43));
                //fats_linoleic
                row.add(rs.getBigDecimal(38));
                //fats_linolenic
                row.add(rs.getBigDecimal(39));
                //fats_epa
                row.add(rs.getBigDecimal(34));
                //fats_dha
                row.add(rs.getBigDecimal(33));
                //fats_lcn3pufa
                row.add(rs.getBigDecimal(37));
                //Carbohydrates
                //carbohydrates_carbs_by_diff
                row.add(rs.getBigDecimal(3));
                //carbohydrates_fiber
                row.add(rs.getBigDecimal(5));
                //carbohydrates_fiber_insoluble
                row.add(rs.getBigDecimal(6));
                //carbohydrates_fiber_soluble
                row.add(rs.getBigDecimal(7));
                //carbohydrates_digestible
                row.add(rs.getBigDecimal(4));
                //carbohydrates_starch
                row.add(rs.getBigDecimal(12));
                //carbohydrates_sugars
                row.add(rs.getBigDecimal(14));
                //carbohydrates_sucrose
                row.add(rs.getBigDecimal(13));
                //carbohydrates_lactose
                row.add(rs.getBigDecimal(11));
                //carbohydrates_fructose
                row.add(rs.getBigDecimal(8));
                //carbohydrates_glucose
                row.add(rs.getBigDecimal(9));
                //carbohydrates_glycemic_load
                row.add(rs.getBigDecimal(10));
                //Vitamins
                //vitamins_vitamin_a
                row.add(rs.getBigDecimal(84));
                //vitamins_vitamin_d
                row.add(rs.getBigDecimal(88));
                //vitamins_vitamin_e
                row.add(rs.getBigDecimal(89));
                //vitamins_vitamin_c
                row.add(rs.getBigDecimal(87));
                //vitamins_thiamin
                row.add(rs.getBigDecimal(83));
                //vitamins_riboflavin
                row.add(rs.getBigDecimal(82));
                //vitamins_niacin
                row.add(rs.getBigDecimal(80));
                //vitamins_vitamin_b6
                row.add(rs.getBigDecimal(85));
                //vitamins_folate
                row.add(rs.getBigDecimal(79));
                //vitamins_vitamin_b12
                row.add(rs.getBigDecimal(86));
                //vitamins_vitamin_k
                row.add(rs.getBigDecimal(90));
                //vitamins_pantothenic_acid
                row.add(rs.getBigDecimal(81));
                //vitamins_choline
                row.add(rs.getBigDecimal(78));
                //Minerals
                //minerals_calcium
                row.add(rs.getBigDecimal(47));
                //minerals_phosphorus
                row.add(rs.getBigDecimal(52));
                //minerals_magnesium
                row.add(rs.getBigDecimal(50));
                //minerals_iron
                row.add(rs.getBigDecimal(49));
                //minerals_zinc
                row.add(rs.getBigDecimal(56));
                //minerals_copper
                row.add(rs.getBigDecimal(48));
                //minerals_manganese
                row.add(rs.getBigDecimal(51));
                //minerals_selenium
                row.add(rs.getBigDecimal(54));
                //Electrolytes
                //minerals_potassium
                row.add(rs.getBigDecimal(53));
                //minerals_sodium
                row.add(rs.getBigDecimal(55));
                //Phytonutrients
                //phytonutrients_flavonoids
                row.add(rs.getBigDecimal(68));
                //phytonutrients_carotenoids
                row.add(rs.getBigDecimal(64));
                //phytonutrients_phytosterols
                row.add(rs.getBigDecimal(74));
                //phytonutrients_anthocyanins
                row.add(rs.getBigDecimal(61));
                //phytonutrients_flavanols
                row.add(rs.getBigDecimal(65));
                //phytonutrients_flavanones
                row.add(rs.getBigDecimal(66));
                //phytonutrients_flavones
                row.add(rs.getBigDecimal(67));
                //phytonutrients_flavonols
                row.add(rs.getBigDecimal(69));
                //phytonutrients_isoflavones
                row.add(rs.getBigDecimal(71));
                //phytonutrients_beta_carotene
                row.add(rs.getBigDecimal(62));
                //phytonutrients_lutein_zeaxanthin
                row.add(rs.getBigDecimal(72));
                //phytonutrients_lycopene
                row.add(rs.getBigDecimal(73));
                //phytonutrients_caffeine
                row.add(rs.getBigDecimal(63));
                //phytonutrients_theobromine
                row.add(rs.getBigDecimal(75));
                //phytonutrients_gamma_tocopherol
                row.add(rs.getBigDecimal(70));
                //Other
                //other_cost
                row.add(rs.getBigDecimal(58));
                //other_water
                row.add(rs.getBigDecimal(59));
                //
                table.add(row);
            }
        } catch (Exception e) {
            LoggerImpl.INSTANCE.logProblem(e);
        } finally {
        }
        return table;
    }
}
