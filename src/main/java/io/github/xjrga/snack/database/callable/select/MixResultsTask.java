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
public class MixResultsTask implements Callable<List<List>> {

    private final Connection connection;
    private final String mixid;

    public MixResultsTask(String mixid) {
        connection = Connect.getInstance().getConnection();
        this.mixid = mixid;
    }

    @Override
    public List<List> call() {
        List<List> lst = new ArrayList();
        try {
            CallableStatement proc = connection.prepareCall("{CALL public.MixResult_Select( ? )}");
            proc.setString(1, mixid);
            ResultSet rs = proc.executeQuery();
            while (rs.next()) {
                ArrayList row = new ArrayList();
                //Mix
                //mix_id
                row.add(rs.getString(1));
                //food_id
                row.add(rs.getString(2));
                //food_name
                row.add(rs.getString(3));
                //other_weight
                row.add(rs.getBigDecimal(50));
                //Calories
                //energy_gross
                row.add(rs.getBigDecimal(20));
                //energy_digestible
                row.add(rs.getBigDecimal(18));
                //energy_fat
                row.add(rs.getBigDecimal(19));
                //energy_carbohydrate
                row.add(rs.getBigDecimal(17));
                //energy_protein
                row.add(rs.getBigDecimal(21));
                //energy_alcohol
                row.add(rs.getBigDecimal(16));
                //Macronutrients
                //fats_total
                row.add(rs.getBigDecimal(36));
                //carbohydrates_digestible
                row.add(rs.getBigDecimal(5));
                //protein_total
                row.add(rs.getBigDecimal(67));
                //other_alcohol
                row.add(rs.getBigDecimal(47));
                //Protein
                //protein_total
                row.add(rs.getBigDecimal(67));
                //protein_complete
                row.add(rs.getBigDecimal(66));
                //Fats
                //fats_total
                row.add(rs.getBigDecimal(36));
                //fats_monounsaturated
                row.add(rs.getBigDecimal(30));
                //fats_polyunsaturated
                row.add(rs.getBigDecimal(33));
                //fats_saturated
                row.add(rs.getBigDecimal(34));
                //fats_cholesterol
                row.add(rs.getBigDecimal(22));
                //Saturated Fat
                //fats_saturated
                row.add(rs.getBigDecimal(34));
                //fats_hcsfa
                row.add(rs.getBigDecimal(25));
                //fats_lauric
                row.add(rs.getBigDecimal(26));
                //fats_myristic
                row.add(rs.getBigDecimal(31));
                //fats_palmitic
                row.add(rs.getBigDecimal(32));
                //fats_stearic
                row.add(rs.getBigDecimal(35));
                //fats_cholesterol
                row.add(rs.getBigDecimal(22));
                //Polyunsaturated Fat
                //fats_polyunsaturated
                row.add(rs.getBigDecimal(33));
                //fats_linoleic
                row.add(rs.getBigDecimal(28));
                //fats_linolenic
                row.add(rs.getBigDecimal(29));
                //fats_epa
                row.add(rs.getBigDecimal(24));
                //fats_dha
                row.add(rs.getBigDecimal(23));
                //fats_lcn3pufa
                row.add(rs.getBigDecimal(27));
                //Carbohydrates
                //carbohydrates_carbs_by_diff
                row.add(rs.getBigDecimal(4));
                //carbohydrates_fiber
                row.add(rs.getBigDecimal(6));
                //carbohydrates_fiber_insoluble
                row.add(rs.getBigDecimal(7));
                //carbohydrates_fiber_soluble
                row.add(rs.getBigDecimal(8));
                //carbohydrates_digestible
                row.add(rs.getBigDecimal(5));
                //carbohydrates_starch
                row.add(rs.getBigDecimal(13));
                //carbohydrates_sugars
                row.add(rs.getBigDecimal(15));
                //carbohydrates_sucrose
                row.add(rs.getBigDecimal(14));
                //carbohydrates_lactose
                row.add(rs.getBigDecimal(12));
                //carbohydrates_fructose
                row.add(rs.getBigDecimal(9));
                //carbohydrates_glucose
                row.add(rs.getBigDecimal(10));
                //carbohydrates_glycemic_load
                row.add(rs.getBigDecimal(11));
                //Vitamins
                //vitamins_vitamin_a
                row.add(rs.getBigDecimal(74));
                //vitamins_vitamin_d
                row.add(rs.getBigDecimal(78));
                //vitamins_vitamin_e
                row.add(rs.getBigDecimal(79));
                //vitamins_vitamin_c
                row.add(rs.getBigDecimal(77));
                //vitamins_thiamin
                row.add(rs.getBigDecimal(73));
                //vitamins_riboflavin
                row.add(rs.getBigDecimal(72));
                //vitamins_niacin
                row.add(rs.getBigDecimal(70));
                //vitamins_vitamin_b6
                row.add(rs.getBigDecimal(76));
                //vitamins_folate
                row.add(rs.getBigDecimal(69));
                //vitamins_vitamin_b12
                row.add(rs.getBigDecimal(75));
                //vitamins_vitamin_k
                row.add(rs.getBigDecimal(80));
                //vitamins_pantothenic_acid
                row.add(rs.getBigDecimal(71));
                //vitamins_choline
                row.add(rs.getBigDecimal(68));
                //Minerals
                //minerals_calcium
                row.add(rs.getBigDecimal(37));
                //minerals_phosphorus
                row.add(rs.getBigDecimal(42));
                //minerals_magnesium
                row.add(rs.getBigDecimal(40));
                //minerals_iron
                row.add(rs.getBigDecimal(39));
                //minerals_zinc
                row.add(rs.getBigDecimal(46));
                //minerals_copper
                row.add(rs.getBigDecimal(38));
                //minerals_manganese
                row.add(rs.getBigDecimal(41));
                //minerals_selenium
                row.add(rs.getBigDecimal(44));
                //Electrolytes
                //minerals_potassium
                row.add(rs.getBigDecimal(43));
                //minerals_sodium
                row.add(rs.getBigDecimal(45));
                //Phytonutrients
                //phytonutrients_flavonoids
                row.add(rs.getBigDecimal(58));
                //phytonutrients_carotenoids
                row.add(rs.getBigDecimal(54));
                //phytonutrients_phytosterols
                row.add(rs.getBigDecimal(64));
                //phytonutrients_anthocyanins
                row.add(rs.getBigDecimal(51));
                //phytonutrients_flavanols
                row.add(rs.getBigDecimal(55));
                //phytonutrients_flavanones
                row.add(rs.getBigDecimal(56));
                //phytonutrients_flavones
                row.add(rs.getBigDecimal(57));
                //phytonutrients_flavonols
                row.add(rs.getBigDecimal(59));
                //phytonutrients_isoflavones
                row.add(rs.getBigDecimal(61));
                //phytonutrients_beta_carotene
                row.add(rs.getBigDecimal(52));
                //phytonutrients_lutein_zeaxanthin
                row.add(rs.getBigDecimal(62));
                //phytonutrients_lycopene
                row.add(rs.getBigDecimal(63));
                //phytonutrients_caffeine
                row.add(rs.getBigDecimal(53));
                //phytonutrients_theobromine
                row.add(rs.getBigDecimal(65));
                //phytonutrients_gamma_tocopherol
                row.add(rs.getBigDecimal(60));
                //Other
                //other_cost
                row.add(rs.getBigDecimal(48));
                //other_water
                row.add(rs.getBigDecimal(49));
                //
                lst.add(row);
            }
        } catch (Exception e) {
            LoggerImpl.INSTANCE.logProblem(e);
        }
        return lst;
    }
}
