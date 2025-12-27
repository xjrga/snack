package io.github.xjrga.snack.database.callable.insert;

import io.github.xjrga.snack.database.Connect;
import io.github.xjrga.snack.dataobject.Food;
import io.github.xjrga.snack.logger.LoggerImpl;
import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.Callable;

public class InsertFoodFactTask implements Callable<Boolean> {

    private final Connection connection;
    private final Food food;
    private CallableStatement proc = null;

    public InsertFoodFactTask( Food food ) {
        connection = Connect.getInstance().getConnection();
        this.food = food;
    }

    @Override
    public Boolean call() throws Exception {
        boolean completed = false;
        try {
            proc = connection.prepareCall( "{CALL public.FoodFact_insert( ?, ?, ? )}" );
            String foodid = food.getCheckSum();
            execute(
                    foodid,
                    food.getCarbohydrates_carbs_by_diff_nutr_no(),
                    food.getCarbohydrates_carbs_by_diff_quantity() );
            execute(
                    foodid,
                    food.getCarbohydrates_fiber_insoluble_nutr_no(),
                    food.getCarbohydrates_fiber_insoluble_quantity() );
            execute(
                    foodid,
                    food.getCarbohydrates_fiber_soluble_nutr_no(),
                    food.getCarbohydrates_fiber_soluble_quantity() );
            execute( foodid, food.getCarbohydrates_fiber_nutr_no(), food.getCarbohydrates_fiber_quantity() );
            execute( foodid, food.getCarbohydrates_fructose_nutr_no(), food.getCarbohydrates_fructose_quantity() );
            execute( foodid, food.getCarbohydrates_glucose_nutr_no(), food.getCarbohydrates_glucose_quantity() );
            execute(
                    foodid,
                    food.getCarbohydrates_glycemic_load_nutr_no(),
                    food.getCarbohydrates_glycemic_load_quantity() );
            execute( foodid, food.getCarbohydrates_lactose_nutr_no(), food.getCarbohydrates_lactose_quantity() );
            execute( foodid, food.getCarbohydrates_starch_nutr_no(), food.getCarbohydrates_starch_quantity() );
            execute( foodid, food.getCarbohydrates_sucrose_nutr_no(), food.getCarbohydrates_sucrose_quantity() );
            execute( foodid, food.getCarbohydrates_sugars_nutr_no(), food.getCarbohydrates_sugars_quantity() );
            execute( foodid, food.getEnergy_gross_nutr_no(), food.getEnergy_gross_quantity() );
            execute( foodid, food.getFats_cholesterol_nutr_no(), food.getFats_cholesterol_quantity() );
            execute( foodid, food.getFats_dha_nutr_no(), food.getFats_dha_quantity() );
            execute( foodid, food.getFats_epa_nutr_no(), food.getFats_epa_quantity() );
            execute( foodid, food.getFats_lauric_nutr_no(), food.getFats_lauric_quantity() );
            execute( foodid, food.getFats_linoleic_nutr_no(), food.getFats_linoleic_quantity() );
            execute( foodid, food.getFats_linolenic_nutr_no(), food.getFats_linolenic_quantity() );
            execute( foodid, food.getFats_monounsaturated_nutr_no(), food.getFats_monounsaturated_quantity() );
            execute( foodid, food.getFats_myristic_nutr_no(), food.getFats_myristic_quantity() );
            execute( foodid, food.getFats_palmitic_nutr_no(), food.getFats_palmitic_quantity() );
            execute( foodid, food.getFats_polyunsaturated_nutr_no(), food.getFats_polyunsaturated_quantity() );
            execute( foodid, food.getFats_saturated_nutr_no(), food.getFats_saturated_quantity() );
            execute( foodid, food.getFats_stearic_nutr_no(), food.getFats_stearic_quantity() );
            execute( foodid, food.getFats_total_nutr_no(), food.getFats_total_quantity() );
            execute( foodid, food.getMinerals_calcium_nutr_no(), food.getMinerals_calcium_quantity() );
            execute( foodid, food.getMinerals_copper_nutr_no(), food.getMinerals_copper_quantity() );
            execute( foodid, food.getMinerals_iron_nutr_no(), food.getMinerals_iron_quantity() );
            execute( foodid, food.getMinerals_magnesium_nutr_no(), food.getMinerals_magnesium_quantity() );
            execute( foodid, food.getMinerals_manganese_nutr_no(), food.getMinerals_manganese_quantity() );
            execute( foodid, food.getMinerals_phosphorus_nutr_no(), food.getMinerals_phosphorus_quantity() );
            execute( foodid, food.getMinerals_potassium_nutr_no(), food.getMinerals_potassium_quantity() );
            execute( foodid, food.getMinerals_selenium_nutr_no(), food.getMinerals_selenium_quantity() );
            execute( foodid, food.getMinerals_sodium_nutr_no(), food.getMinerals_sodium_quantity() );
            execute( foodid, food.getMinerals_zinc_nutr_no(), food.getMinerals_zinc_quantity() );
            execute( foodid, food.getOther_alcohol_nutr_no(), food.getOther_alcohol_quantity() );
            execute( foodid, food.getOther_cost_nutr_no(), food.getOther_cost_quantity() );
            execute( foodid, food.getOther_water_nutr_no(), food.getOther_water_quantity() );
            execute( foodid, food.getOther_weight_nutr_no(), food.getOther_weight_quantity() );
            execute(
                    foodid,
                    food.getPhytonutrients_anthocyanins_nutr_no(),
                    food.getPhytonutrients_anthocyanins_quantity() );
            execute( foodid, food.getPhytonutrients_caffeine_nutr_no(), food.getPhytonutrients_caffeine_quantity() );
            execute(
                    foodid,
                    food.getPhytonutrients_beta_carotene_nutr_no(),
                    food.getPhytonutrients_beta_carotene_quantity() );
            execute(
                    foodid,
                    food.getPhytonutrients_carotenoids_nutr_no(),
                    food.getPhytonutrients_carotenoids_quantity() );
            execute( foodid, food.getPhytonutrients_flavanols_nutr_no(), food.getPhytonutrients_flavanols_quantity() );
            execute( foodid, food.getPhytonutrients_flavanones_nutr_no(), food.getPhytonutrients_flavanones_quantity() );
            execute( foodid, food.getPhytonutrients_flavones_nutr_no(), food.getPhytonutrients_flavones_quantity() );
            execute( foodid, food.getPhytonutrients_flavonoids_nutr_no(), food.getPhytonutrients_flavonoids_quantity() );
            execute( foodid, food.getPhytonutrients_flavonols_nutr_no(), food.getPhytonutrients_flavonols_quantity() );
            execute(
                    foodid,
                    food.getPhytonutrients_isoflavones_nutr_no(),
                    food.getPhytonutrients_isoflavones_quantity() );
            execute(
                    foodid,
                    food.getPhytonutrients_lutein_zeaxanthin_nutr_no(),
                    food.getPhytonutrients_lutein_zeaxanthin_quantity() );
            execute( foodid, food.getPhytonutrients_lycopene_nutr_no(), food.getPhytonutrients_lycopene_quantity() );
            execute(
                    foodid,
                    food.getPhytonutrients_phytosterols_nutr_no(),
                    food.getPhytonutrients_phytosterols_quantity() );
            execute(
                    foodid,
                    food.getPhytonutrients_theobromine_nutr_no(),
                    food.getPhytonutrients_theobromine_quantity() );
            execute(
                    foodid,
                    food.getPhytonutrients_gamma_tocopherol_nutr_no(),
                    food.getPhytonutrients_gamma_tocopherol_quantity() );
            execute( foodid, food.getProtein_complete_nutr_no(), food.getProtein_complete_quantity() );
            execute( foodid, food.getProtein_total_nutr_no(), food.getProtein_total_quantity() );
            execute( foodid, food.getVitamins_vitamin_a_nutr_no(), food.getVitamins_vitamin_a_quantity() );
            execute( foodid, food.getVitamins_vitamin_b12_nutr_no(), food.getVitamins_vitamin_b12_quantity() );
            execute( foodid, food.getVitamins_vitamin_b6_nutr_no(), food.getVitamins_vitamin_b6_quantity() );
            execute( foodid, food.getVitamins_vitamin_c_nutr_no(), food.getVitamins_vitamin_c_quantity() );
            execute( foodid, food.getVitamins_choline_nutr_no(), food.getVitamins_choline_quantity() );
            execute( foodid, food.getVitamins_vitamin_d_nutr_no(), food.getVitamins_vitamin_d_quantity() );
            execute( foodid, food.getVitamins_vitamin_e_nutr_no(), food.getVitamins_vitamin_e_quantity() );
            execute( foodid, food.getVitamins_folate_nutr_no(), food.getVitamins_folate_quantity() );
            execute( foodid, food.getVitamins_vitamin_k_nutr_no(), food.getVitamins_vitamin_k_quantity() );
            execute( foodid, food.getVitamins_niacin_nutr_no(), food.getVitamins_niacin_quantity() );
            execute( foodid, food.getVitamins_pantothenic_acid_nutr_no(), food.getVitamins_pantothenic_acid_quantity() );
            execute( foodid, food.getVitamins_riboflavin_nutr_no(), food.getVitamins_riboflavin_quantity() );
            execute( foodid, food.getVitamins_thiamin_nutr_no(), food.getVitamins_thiamin_quantity() );
            proc.close();
            completed = true;
        } catch ( Exception e ) {
            LoggerImpl.INSTANCE.logProblem( e );
        }
        return completed;
    }

    private void execute( String foodid, String nutr_no, BigDecimal quantity ) {
        try {
            proc.setString( 1, foodid );
            proc.setString( 2, nutr_no );
            proc.setBigDecimal( 3, quantity );
            proc.execute();
        } catch ( SQLException e ) {
            LoggerImpl.INSTANCE.logProblem( e );
        }
    }
}
