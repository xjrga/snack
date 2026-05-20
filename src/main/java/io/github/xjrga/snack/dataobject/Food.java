package io.github.xjrga.snack.dataobject;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import org.apache.commons.codec.digest.DigestUtils;

public class Food {

    private String Carbohydrates_carbs_by_diff_nutr_no;
    private BigDecimal Carbohydrates_carbs_by_diff_quantity;
    private String Carbohydrates_fiber_insoluble_nutr_no;
    private BigDecimal Carbohydrates_fiber_insoluble_quantity;
    private String Carbohydrates_fiber_nutr_no;
    private BigDecimal Carbohydrates_fiber_quantity;
    private String Carbohydrates_fiber_soluble_nutr_no;
    private BigDecimal Carbohydrates_fiber_soluble_quantity;
    private String Carbohydrates_fructose_nutr_no;
    private BigDecimal Carbohydrates_fructose_quantity;
    private String Carbohydrates_glucose_nutr_no;
    private BigDecimal Carbohydrates_glucose_quantity;
    private String Carbohydrates_glycemic_load_nutr_no;
    private BigDecimal Carbohydrates_glycemic_load_quantity;
    private String Carbohydrates_lactose_nutr_no;
    private BigDecimal Carbohydrates_lactose_quantity;
    private String Carbohydrates_starch_nutr_no;
    private BigDecimal Carbohydrates_starch_quantity;
    private String Carbohydrates_sucrose_nutr_no;
    private BigDecimal Carbohydrates_sucrose_quantity;
    private String Carbohydrates_sugars_nutr_no;
    private BigDecimal Carbohydrates_sugars_quantity;
    private List<Category> categories;
    private String Energy_gross_nutr_no;
    private BigDecimal Energy_gross_quantity;
    private String Fats_cholesterol_nutr_no;
    private BigDecimal Fats_cholesterol_quantity;
    private String Fats_dha_nutr_no;
    private BigDecimal Fats_dha_quantity;
    private String Fats_epa_nutr_no;
    private BigDecimal Fats_epa_quantity;
    private String Fats_lauric_nutr_no;
    private BigDecimal Fats_lauric_quantity;
    private String Fats_linoleic_nutr_no;
    private BigDecimal Fats_linoleic_quantity;
    private String Fats_linolenic_nutr_no;
    private BigDecimal Fats_linolenic_quantity;
    private String Fats_monounsaturated_nutr_no;
    private BigDecimal Fats_monounsaturated_quantity;
    private String Fats_myristic_nutr_no;
    private BigDecimal Fats_myristic_quantity;
    private String Fats_palmitic_nutr_no;
    private BigDecimal Fats_palmitic_quantity;
    private String Fats_polyunsaturated_nutr_no;
    private BigDecimal Fats_polyunsaturated_quantity;
    private String Fats_saturated_nutr_no;
    private BigDecimal Fats_saturated_quantity;
    private String Fats_stearic_nutr_no;
    private BigDecimal Fats_stearic_quantity;
    private String Fats_total_nutr_no;
    private BigDecimal Fats_total_quantity;
    private String FoodId;
    private String FoodName;
    private String Minerals_calcium_nutr_no;
    private BigDecimal Minerals_calcium_quantity;
    private String Minerals_copper_nutr_no;
    private BigDecimal Minerals_copper_quantity;
    private String Minerals_iron_nutr_no;
    private BigDecimal Minerals_iron_quantity;
    private String Minerals_magnesium_nutr_no;
    private BigDecimal Minerals_magnesium_quantity;
    private String Minerals_manganese_nutr_no;
    private BigDecimal Minerals_manganese_quantity;
    private String Minerals_phosphorus_nutr_no;
    private BigDecimal Minerals_phosphorus_quantity;
    private String Minerals_potassium_nutr_no;
    private BigDecimal Minerals_potassium_quantity;
    private String Minerals_selenium_nutr_no;
    private BigDecimal Minerals_selenium_quantity;
    private String Minerals_sodium_nutr_no;
    private BigDecimal Minerals_sodium_quantity;
    private String Minerals_zinc_nutr_no;
    private BigDecimal Minerals_zinc_quantity;
    private String Other_alcohol_nutr_no;
    private BigDecimal Other_alcohol_quantity;
    private String Other_cost_nutr_no;
    private BigDecimal Other_cost_quantity;
    private String Other_water_nutr_no;
    private BigDecimal Other_water_quantity;
    private String Other_weight_nutr_no;
    private BigDecimal Other_weight_quantity;
    private String Phytonutrients_anthocyanins_nutr_no;
    private BigDecimal Phytonutrients_anthocyanins_quantity;
    private String Phytonutrients_beta_carotene_nutr_no;
    private BigDecimal Phytonutrients_beta_carotene_quantity;
    private String Phytonutrients_caffeine_nutr_no;
    private BigDecimal Phytonutrients_caffeine_quantity;
    private String Phytonutrients_carotenoids_nutr_no;
    private BigDecimal Phytonutrients_carotenoids_quantity;
    private String Phytonutrients_flavanols_nutr_no;
    private BigDecimal Phytonutrients_flavanols_quantity;
    private String Phytonutrients_flavanones_nutr_no;
    private BigDecimal Phytonutrients_flavanones_quantity;
    private String Phytonutrients_flavones_nutr_no;
    private BigDecimal Phytonutrients_flavones_quantity;
    private String Phytonutrients_flavonoids_nutr_no;
    private BigDecimal Phytonutrients_flavonoids_quantity;
    private String Phytonutrients_flavonols_nutr_no;
    private BigDecimal Phytonutrients_flavonols_quantity;
    private String Phytonutrients_isoflavones_nutr_no;
    private BigDecimal Phytonutrients_isoflavones_quantity;
    private String Phytonutrients_lutein_zeaxanthin_nutr_no;
    private BigDecimal Phytonutrients_lutein_zeaxanthin_quantity;
    private String Phytonutrients_lycopene_nutr_no;
    private BigDecimal Phytonutrients_lycopene_quantity;
    private String Phytonutrients_phytosterols_nutr_no;
    private BigDecimal Phytonutrients_phytosterols_quantity;
    private String Phytonutrients_theobromine_nutr_no;
    private BigDecimal Phytonutrients_theobromine_quantity;
    private String Phytonutrients_gamma_tocopherol_nutr_no;
    private BigDecimal Phytonutrients_gamma_tocopherol_quantity;
    private String Protein_complete_nutr_no;
    private BigDecimal Protein_complete_quantity;
    private String Protein_total_nutr_no;
    private BigDecimal Protein_total_quantity;
    private String Vitamins_choline_nutr_no;
    private BigDecimal Vitamins_choline_quantity;
    private String Vitamins_folate_nutr_no;
    private BigDecimal Vitamins_folate_quantity;
    private String Vitamins_niacin_nutr_no;
    private BigDecimal Vitamins_niacin_quantity;
    private String Vitamins_pantothenic_acid_nutr_no;
    private BigDecimal Vitamins_pantothenic_acid_quantity;
    private String Vitamins_riboflavin_nutr_no;
    private BigDecimal Vitamins_riboflavin_quantity;
    private String Vitamins_thiamin_nutr_no;
    private BigDecimal Vitamins_thiamin_quantity;
    private String Vitamins_vitamin_a_nutr_no;
    private BigDecimal Vitamins_vitamin_a_quantity;
    private String Vitamins_vitamin_b12_nutr_no;
    private BigDecimal Vitamins_vitamin_b12_quantity;
    private String Vitamins_vitamin_b6_nutr_no;
    private BigDecimal Vitamins_vitamin_b6_quantity;
    private String Vitamins_vitamin_c_nutr_no;
    private BigDecimal Vitamins_vitamin_c_quantity;
    private String Vitamins_vitamin_d_nutr_no;
    private BigDecimal Vitamins_vitamin_d_quantity;
    private String Vitamins_vitamin_e_nutr_no;
    private BigDecimal Vitamins_vitamin_e_quantity;
    private String Vitamins_vitamin_k_nutr_no;
    private BigDecimal Vitamins_vitamin_k_quantity;


    public Food() {
        FoodId = "";
        FoodName = "";
        Carbohydrates_carbs_by_diff_nutr_no = "";
        Carbohydrates_carbs_by_diff_quantity = new BigDecimal( "0.0" );
        Carbohydrates_fiber_nutr_no = "";
        Carbohydrates_fiber_quantity = new BigDecimal( "0.0" );
        Carbohydrates_fiber_insoluble_nutr_no = "";
        Carbohydrates_fiber_insoluble_quantity = new BigDecimal( "0.0" );
        Carbohydrates_fiber_soluble_nutr_no = "";
        Carbohydrates_fiber_soluble_quantity = new BigDecimal( "0.0" );
        Carbohydrates_fructose_nutr_no = "";
        Carbohydrates_fructose_quantity = new BigDecimal( "0.0" );
        Carbohydrates_glucose_nutr_no = "";
        Carbohydrates_glucose_quantity = new BigDecimal( "0.0" );
        Carbohydrates_glycemic_load_nutr_no = "";
        Carbohydrates_glycemic_load_quantity = new BigDecimal( "0.0" );
        Carbohydrates_lactose_nutr_no = "";
        Carbohydrates_lactose_quantity = new BigDecimal( "0.0" );
        Carbohydrates_starch_nutr_no = "";
        Carbohydrates_starch_quantity = new BigDecimal( "0.0" );
        Carbohydrates_sucrose_nutr_no = "";
        Carbohydrates_sucrose_quantity = new BigDecimal( "0.0" );
        Carbohydrates_sugars_nutr_no = "";
        Carbohydrates_sugars_quantity = new BigDecimal( "0.0" );
        Energy_gross_nutr_no = "";
        Energy_gross_quantity = new BigDecimal( "0.0" );
        Fats_linolenic_nutr_no = "";
        Fats_linolenic_quantity = new BigDecimal( "0.0" );
        Fats_cholesterol_nutr_no = "";
        Fats_cholesterol_quantity = new BigDecimal( "0.0" );
        Fats_dha_nutr_no = "";
        Fats_dha_quantity = new BigDecimal( "0.0" );
        Fats_epa_nutr_no = "";
        Fats_epa_quantity = new BigDecimal( "0.0" );
        Fats_lauric_nutr_no = "";
        Fats_lauric_quantity = new BigDecimal( "0.0" );
        Fats_linoleic_nutr_no = "";
        Fats_linoleic_quantity = new BigDecimal( "0.0" );
        Fats_monounsaturated_nutr_no = "";
        Fats_monounsaturated_quantity = new BigDecimal( "0.0" );
        Fats_myristic_nutr_no = "";
        Fats_myristic_quantity = new BigDecimal( "0.0" );
        Fats_palmitic_nutr_no = "";
        Fats_palmitic_quantity = new BigDecimal( "0.0" );
        Fats_polyunsaturated_nutr_no = "";
        Fats_polyunsaturated_quantity = new BigDecimal( "0.0" );
        Fats_saturated_nutr_no = "";
        Fats_saturated_quantity = new BigDecimal( "0.0" );
        Fats_stearic_nutr_no = "";
        Fats_stearic_quantity = new BigDecimal( "0.0" );
        Fats_total_nutr_no = "";
        Fats_total_quantity = new BigDecimal( "0.0" );
        Minerals_calcium_nutr_no = "";
        Minerals_calcium_quantity = new BigDecimal( "0.0" );
        Minerals_copper_nutr_no = "";
        Minerals_copper_quantity = new BigDecimal( "0.0" );
        Minerals_iron_nutr_no = "";
        Minerals_iron_quantity = new BigDecimal( "0.0" );
        Minerals_magnesium_nutr_no = "";
        Minerals_magnesium_quantity = new BigDecimal( "0.0" );
        Minerals_manganese_nutr_no = "";
        Minerals_manganese_quantity = new BigDecimal( "0.0" );
        Minerals_phosphorus_nutr_no = "";
        Minerals_phosphorus_quantity = new BigDecimal( "0.0" );
        Minerals_potassium_nutr_no = "";
        Minerals_potassium_quantity = new BigDecimal( "0.0" );
        Minerals_selenium_nutr_no = "";
        Minerals_selenium_quantity = new BigDecimal( "0.0" );
        Minerals_sodium_nutr_no = "";
        Minerals_sodium_quantity = new BigDecimal( "0.0" );
        Minerals_zinc_nutr_no = "";
        Minerals_zinc_quantity = new BigDecimal( "0.0" );
        Other_alcohol_nutr_no = "";
        Other_alcohol_quantity = new BigDecimal( "0.0" );
        Other_cost_nutr_no = "";
        Other_cost_quantity = new BigDecimal( "0.0" );
        Other_water_nutr_no = "";
        Other_water_quantity = new BigDecimal( "0.0" );
        Other_weight_nutr_no = "";
        Other_weight_quantity = new BigDecimal( "0.0" );
        Phytonutrients_anthocyanins_nutr_no = "";
        Phytonutrients_anthocyanins_quantity = new BigDecimal( "0.0" );
        Phytonutrients_caffeine_nutr_no = "";
        Phytonutrients_caffeine_quantity = new BigDecimal( "0.0" );
        Phytonutrients_beta_carotene_nutr_no = "";
        Phytonutrients_beta_carotene_quantity = new BigDecimal( "0.0" );
        Phytonutrients_carotenoids_nutr_no = "";
        Phytonutrients_carotenoids_quantity = new BigDecimal( "0.0" );
        Phytonutrients_flavanols_nutr_no = "";
        Phytonutrients_flavanols_quantity = new BigDecimal( "0.0" );
        Phytonutrients_flavanones_nutr_no = "";
        Phytonutrients_flavanones_quantity = new BigDecimal( "0.0" );
        Phytonutrients_flavones_nutr_no = "";
        Phytonutrients_flavones_quantity = new BigDecimal( "0.0" );
        Phytonutrients_flavonoids_nutr_no = "";
        Phytonutrients_flavonoids_quantity = new BigDecimal( "0.0" );
        Phytonutrients_flavonols_nutr_no = "";
        Phytonutrients_flavonols_quantity = new BigDecimal( "0.0" );
        Phytonutrients_isoflavones_nutr_no = "";
        Phytonutrients_isoflavones_quantity = new BigDecimal( "0.0" );
        Phytonutrients_lutein_zeaxanthin_nutr_no = "";
        Phytonutrients_lutein_zeaxanthin_quantity = new BigDecimal( "0.0" );
        Phytonutrients_lycopene_nutr_no = "";
        Phytonutrients_lycopene_quantity = new BigDecimal( "0.0" );
        Phytonutrients_phytosterols_nutr_no = "";
        Phytonutrients_phytosterols_quantity = new BigDecimal( "0.0" );
        Phytonutrients_theobromine_nutr_no = "";
        Phytonutrients_theobromine_quantity = new BigDecimal( "0.0" );
        Phytonutrients_gamma_tocopherol_nutr_no = "";
        Phytonutrients_gamma_tocopherol_quantity = new BigDecimal( "0.0" );
        Protein_complete_nutr_no = "";
        Protein_complete_quantity = new BigDecimal( "0.0" );
        Protein_total_nutr_no = "";
        Protein_total_quantity = new BigDecimal( "0.0" );
        Vitamins_vitamin_a_nutr_no = "";
        Vitamins_vitamin_a_quantity = new BigDecimal( "0.0" );
        Vitamins_vitamin_b12_nutr_no = "";
        Vitamins_vitamin_b12_quantity = new BigDecimal( "0.0" );
        Vitamins_vitamin_b6_nutr_no = "";
        Vitamins_vitamin_b6_quantity = new BigDecimal( "0.0" );
        Vitamins_vitamin_c_nutr_no = "";
        Vitamins_vitamin_c_quantity = new BigDecimal( "0.0" );
        Vitamins_choline_nutr_no = "";
        Vitamins_choline_quantity = new BigDecimal( "0.0" );
        Vitamins_vitamin_d_nutr_no = "";
        Vitamins_vitamin_d_quantity = new BigDecimal( "0.0" );
        Vitamins_vitamin_e_nutr_no = "";
        Vitamins_vitamin_e_quantity = new BigDecimal( "0.0" );
        Vitamins_folate_nutr_no = "";
        Vitamins_folate_quantity = new BigDecimal( "0.0" );
        Vitamins_vitamin_k_nutr_no = "";
        Vitamins_vitamin_k_quantity = new BigDecimal( "0.0" );
        Vitamins_niacin_nutr_no = "";
        Vitamins_niacin_quantity = new BigDecimal( "0.0" );
        Vitamins_pantothenic_acid_nutr_no = "";
        Vitamins_pantothenic_acid_quantity = new BigDecimal( "0.0" );
        Vitamins_riboflavin_nutr_no = "";
        Vitamins_riboflavin_quantity = new BigDecimal( "0.0" );
        Vitamins_thiamin_nutr_no = "";
        Vitamins_thiamin_quantity = new BigDecimal( "0.0" );
        categories = new ArrayList<>();
    }


    public void addCategory( Category category ) {
        categories.add( category );
    }


    public String getCarbohydrates_carbs_by_diff_nutr_no() {
        return Carbohydrates_carbs_by_diff_nutr_no;
    }


    public BigDecimal getCarbohydrates_carbs_by_diff_quantity() {
        return Carbohydrates_carbs_by_diff_quantity;
    }


    public String getCarbohydrates_fiber_insoluble_nutr_no() {
        return Carbohydrates_fiber_insoluble_nutr_no;
    }


    public BigDecimal getCarbohydrates_fiber_insoluble_quantity() {
        return Carbohydrates_fiber_insoluble_quantity;
    }


    public String getCarbohydrates_fiber_nutr_no() {
        return Carbohydrates_fiber_nutr_no;
    }


    public BigDecimal getCarbohydrates_fiber_quantity() {
        return Carbohydrates_fiber_quantity;
    }


    public String getCarbohydrates_fiber_soluble_nutr_no() {
        return Carbohydrates_fiber_soluble_nutr_no;
    }


    public BigDecimal getCarbohydrates_fiber_soluble_quantity() {
        return Carbohydrates_fiber_soluble_quantity;
    }


    public String getCarbohydrates_fructose_nutr_no() {
        return Carbohydrates_fructose_nutr_no;
    }


    public BigDecimal getCarbohydrates_fructose_quantity() {
        return Carbohydrates_fructose_quantity;
    }


    public String getCarbohydrates_glucose_nutr_no() {
        return Carbohydrates_glucose_nutr_no;
    }


    public BigDecimal getCarbohydrates_glucose_quantity() {
        return Carbohydrates_glucose_quantity;
    }


    public String getCarbohydrates_glycemic_load_nutr_no() {
        return Carbohydrates_glycemic_load_nutr_no;
    }


    public BigDecimal getCarbohydrates_glycemic_load_quantity() {
        return Carbohydrates_glycemic_load_quantity;
    }


    public String getCarbohydrates_lactose_nutr_no() {
        return Carbohydrates_lactose_nutr_no;
    }


    public BigDecimal getCarbohydrates_lactose_quantity() {
        return Carbohydrates_lactose_quantity;
    }


    public String getCarbohydrates_starch_nutr_no() {
        return Carbohydrates_starch_nutr_no;
    }


    public BigDecimal getCarbohydrates_starch_quantity() {
        return Carbohydrates_starch_quantity;
    }


    public String getCarbohydrates_sucrose_nutr_no() {
        return Carbohydrates_sucrose_nutr_no;
    }


    public BigDecimal getCarbohydrates_sucrose_quantity() {
        return Carbohydrates_sucrose_quantity;
    }


    public String getCarbohydrates_sugars_nutr_no() {
        return Carbohydrates_sugars_nutr_no;
    }


    public BigDecimal getCarbohydrates_sugars_quantity() {
        return Carbohydrates_sugars_quantity;
    }


    public Iterator<Category> getCategoryIterator() {
        return categories.iterator();
    }


    public String getEnergy_gross_nutr_no() {
        return Energy_gross_nutr_no;
    }


    public BigDecimal getEnergy_gross_quantity() {
        return Energy_gross_quantity;
    }


    public String getFats_cholesterol_nutr_no() {
        return Fats_cholesterol_nutr_no;
    }


    public BigDecimal getFats_cholesterol_quantity() {
        return Fats_cholesterol_quantity;
    }


    public String getFats_dha_nutr_no() {
        return Fats_dha_nutr_no;
    }


    public BigDecimal getFats_dha_quantity() {
        return Fats_dha_quantity;
    }


    public String getFats_epa_nutr_no() {
        return Fats_epa_nutr_no;
    }


    public BigDecimal getFats_epa_quantity() {
        return Fats_epa_quantity;
    }


    public String getFats_lauric_nutr_no() {
        return Fats_lauric_nutr_no;
    }


    public BigDecimal getFats_lauric_quantity() {
        return Fats_lauric_quantity;
    }


    public String getFats_linoleic_nutr_no() {
        return Fats_linoleic_nutr_no;
    }


    public BigDecimal getFats_linoleic_quantity() {
        return Fats_linoleic_quantity;
    }


    public String getFats_linolenic_nutr_no() {
        return Fats_linolenic_nutr_no;
    }


    public BigDecimal getFats_linolenic_quantity() {
        return Fats_linolenic_quantity;
    }


    public String getFats_monounsaturated_nutr_no() {
        return Fats_monounsaturated_nutr_no;
    }


    public BigDecimal getFats_monounsaturated_quantity() {
        return Fats_monounsaturated_quantity;
    }


    public String getFats_myristic_nutr_no() {
        return Fats_myristic_nutr_no;
    }


    public BigDecimal getFats_myristic_quantity() {
        return Fats_myristic_quantity;
    }


    public String getFats_palmitic_nutr_no() {
        return Fats_palmitic_nutr_no;
    }


    public BigDecimal getFats_palmitic_quantity() {
        return Fats_palmitic_quantity;
    }


    public String getFats_polyunsaturated_nutr_no() {
        return Fats_polyunsaturated_nutr_no;
    }


    public BigDecimal getFats_polyunsaturated_quantity() {
        return Fats_polyunsaturated_quantity;
    }


    public String getFats_saturated_nutr_no() {
        return Fats_saturated_nutr_no;
    }


    public BigDecimal getFats_saturated_quantity() {
        return Fats_saturated_quantity;
    }


    public String getFats_stearic_nutr_no() {
        return Fats_stearic_nutr_no;
    }


    public BigDecimal getFats_stearic_quantity() {
        return Fats_stearic_quantity;
    }


    public String getFats_total_nutr_no() {
        return Fats_total_nutr_no;
    }


    public BigDecimal getFats_total_quantity() {
        return Fats_total_quantity;
    }


    public String getFoodId() {
        return FoodId;
    }


    public String getFoodName() {
        return FoodName;
    }


    public String getMinerals_calcium_nutr_no() {
        return Minerals_calcium_nutr_no;
    }


    public BigDecimal getMinerals_calcium_quantity() {
        return Minerals_calcium_quantity;
    }


    public String getMinerals_copper_nutr_no() {
        return Minerals_copper_nutr_no;
    }


    public BigDecimal getMinerals_copper_quantity() {
        return Minerals_copper_quantity;
    }


    public String getMinerals_iron_nutr_no() {
        return Minerals_iron_nutr_no;
    }


    public BigDecimal getMinerals_iron_quantity() {
        return Minerals_iron_quantity;
    }


    public String getMinerals_magnesium_nutr_no() {
        return Minerals_magnesium_nutr_no;
    }


    public BigDecimal getMinerals_magnesium_quantity() {
        return Minerals_magnesium_quantity;
    }


    public String getMinerals_manganese_nutr_no() {
        return Minerals_manganese_nutr_no;
    }


    public BigDecimal getMinerals_manganese_quantity() {
        return Minerals_manganese_quantity;
    }


    public String getMinerals_phosphorus_nutr_no() {
        return Minerals_phosphorus_nutr_no;
    }


    public BigDecimal getMinerals_phosphorus_quantity() {
        return Minerals_phosphorus_quantity;
    }


    public String getMinerals_potassium_nutr_no() {
        return Minerals_potassium_nutr_no;
    }


    public BigDecimal getMinerals_potassium_quantity() {
        return Minerals_potassium_quantity;
    }


    public String getMinerals_selenium_nutr_no() {
        return Minerals_selenium_nutr_no;
    }


    public BigDecimal getMinerals_selenium_quantity() {
        return Minerals_selenium_quantity;
    }


    public String getMinerals_sodium_nutr_no() {
        return Minerals_sodium_nutr_no;
    }


    public BigDecimal getMinerals_sodium_quantity() {
        return Minerals_sodium_quantity;
    }


    public String getMinerals_zinc_nutr_no() {
        return Minerals_zinc_nutr_no;
    }


    public BigDecimal getMinerals_zinc_quantity() {
        return Minerals_zinc_quantity;
    }


    public String getOther_alcohol_nutr_no() {
        return Other_alcohol_nutr_no;
    }


    public BigDecimal getOther_alcohol_quantity() {
        return Other_alcohol_quantity;
    }


    public String getOther_cost_nutr_no() {
        return Other_cost_nutr_no;
    }


    public BigDecimal getOther_cost_quantity() {
        return Other_cost_quantity;
    }


    public String getOther_water_nutr_no() {
        return Other_water_nutr_no;
    }


    public BigDecimal getOther_water_quantity() {
        return Other_water_quantity;
    }


    public String getOther_weight_nutr_no() {
        return Other_weight_nutr_no;
    }


    public BigDecimal getOther_weight_quantity() {
        return Other_weight_quantity;
    }


    public String getPhytonutrients_anthocyanins_nutr_no() {
        return Phytonutrients_anthocyanins_nutr_no;
    }


    public BigDecimal getPhytonutrients_anthocyanins_quantity() {
        return Phytonutrients_anthocyanins_quantity;
    }


    public String getPhytonutrients_beta_carotene_nutr_no() {
        return Phytonutrients_beta_carotene_nutr_no;
    }


    public BigDecimal getPhytonutrients_beta_carotene_quantity() {
        return Phytonutrients_beta_carotene_quantity;
    }


    public String getPhytonutrients_caffeine_nutr_no() {
        return Phytonutrients_caffeine_nutr_no;
    }


    public BigDecimal getPhytonutrients_caffeine_quantity() {
        return Phytonutrients_caffeine_quantity;
    }


    public String getPhytonutrients_carotenoids_nutr_no() {
        return Phytonutrients_carotenoids_nutr_no;
    }


    public BigDecimal getPhytonutrients_carotenoids_quantity() {
        return Phytonutrients_carotenoids_quantity;
    }


    public String getPhytonutrients_flavanols_nutr_no() {
        return Phytonutrients_flavanols_nutr_no;
    }


    public BigDecimal getPhytonutrients_flavanols_quantity() {
        return Phytonutrients_flavanols_quantity;
    }


    public String getPhytonutrients_flavanones_nutr_no() {
        return Phytonutrients_flavanones_nutr_no;
    }


    public BigDecimal getPhytonutrients_flavanones_quantity() {
        return Phytonutrients_flavanones_quantity;
    }


    public String getPhytonutrients_flavones_nutr_no() {
        return Phytonutrients_flavones_nutr_no;
    }


    public BigDecimal getPhytonutrients_flavones_quantity() {
        return Phytonutrients_flavones_quantity;
    }


    public String getPhytonutrients_flavonoids_nutr_no() {
        return Phytonutrients_flavonoids_nutr_no;
    }


    public BigDecimal getPhytonutrients_flavonoids_quantity() {
        return Phytonutrients_flavonoids_quantity;
    }


    public String getPhytonutrients_flavonols_nutr_no() {
        return Phytonutrients_flavonols_nutr_no;
    }


    public BigDecimal getPhytonutrients_flavonols_quantity() {
        return Phytonutrients_flavonols_quantity;
    }


    public String getPhytonutrients_isoflavones_nutr_no() {
        return Phytonutrients_isoflavones_nutr_no;
    }


    public BigDecimal getPhytonutrients_isoflavones_quantity() {
        return Phytonutrients_isoflavones_quantity;
    }


    public String getPhytonutrients_lutein_zeaxanthin_nutr_no() {
        return Phytonutrients_lutein_zeaxanthin_nutr_no;
    }


    public BigDecimal getPhytonutrients_lutein_zeaxanthin_quantity() {
        return Phytonutrients_lutein_zeaxanthin_quantity;
    }


    public String getPhytonutrients_lycopene_nutr_no() {
        return Phytonutrients_lycopene_nutr_no;
    }


    public BigDecimal getPhytonutrients_lycopene_quantity() {
        return Phytonutrients_lycopene_quantity;
    }


    public String getPhytonutrients_phytosterols_nutr_no() {
        return Phytonutrients_phytosterols_nutr_no;
    }


    public BigDecimal getPhytonutrients_phytosterols_quantity() {
        return Phytonutrients_phytosterols_quantity;
    }


    public String getPhytonutrients_theobromine_nutr_no() {
        return Phytonutrients_theobromine_nutr_no;
    }


    public BigDecimal getPhytonutrients_theobromine_quantity() {
        return Phytonutrients_theobromine_quantity;
    }


    public String getPhytonutrients_gamma_tocopherol_nutr_no() {
        return Phytonutrients_gamma_tocopherol_nutr_no;
    }


    public BigDecimal getPhytonutrients_gamma_tocopherol_quantity() {
        return Phytonutrients_gamma_tocopherol_quantity;
    }


    public String getProtein_complete_nutr_no() {
        return Protein_complete_nutr_no;
    }


    public BigDecimal getProtein_complete_quantity() {
        return Protein_complete_quantity;
    }


    public String getProtein_total_nutr_no() {
        return Protein_total_nutr_no;
    }


    public BigDecimal getProtein_total_quantity() {
        return Protein_total_quantity;
    }


    public String getVitamins_choline_nutr_no() {
        return Vitamins_choline_nutr_no;
    }


    public BigDecimal getVitamins_choline_quantity() {
        return Vitamins_choline_quantity;
    }


    public String getVitamins_folate_nutr_no() {
        return Vitamins_folate_nutr_no;
    }


    public BigDecimal getVitamins_folate_quantity() {
        return Vitamins_folate_quantity;
    }


    public String getVitamins_niacin_nutr_no() {
        return Vitamins_niacin_nutr_no;
    }


    public BigDecimal getVitamins_niacin_quantity() {
        return Vitamins_niacin_quantity;
    }


    public String getVitamins_pantothenic_acid_nutr_no() {
        return Vitamins_pantothenic_acid_nutr_no;
    }


    public BigDecimal getVitamins_pantothenic_acid_quantity() {
        return Vitamins_pantothenic_acid_quantity;
    }


    public String getVitamins_riboflavin_nutr_no() {
        return Vitamins_riboflavin_nutr_no;
    }


    public BigDecimal getVitamins_riboflavin_quantity() {
        return Vitamins_riboflavin_quantity;
    }


    public String getVitamins_thiamin_nutr_no() {
        return Vitamins_thiamin_nutr_no;
    }


    public BigDecimal getVitamins_thiamin_quantity() {
        return Vitamins_thiamin_quantity;
    }


    public String getVitamins_vitamin_a_nutr_no() {
        return Vitamins_vitamin_a_nutr_no;
    }


    public BigDecimal getVitamins_vitamin_a_quantity() {
        return Vitamins_vitamin_a_quantity;
    }


    public String getVitamins_vitamin_b12_nutr_no() {
        return Vitamins_vitamin_b12_nutr_no;
    }


    public BigDecimal getVitamins_vitamin_b12_quantity() {
        return Vitamins_vitamin_b12_quantity;
    }


    public String getVitamins_vitamin_b6_nutr_no() {
        return Vitamins_vitamin_b6_nutr_no;
    }


    public BigDecimal getVitamins_vitamin_b6_quantity() {
        return Vitamins_vitamin_b6_quantity;
    }


    public String getVitamins_vitamin_c_nutr_no() {
        return Vitamins_vitamin_c_nutr_no;
    }


    public BigDecimal getVitamins_vitamin_c_quantity() {
        return Vitamins_vitamin_c_quantity;
    }


    public String getVitamins_vitamin_d_nutr_no() {
        return Vitamins_vitamin_d_nutr_no;
    }


    public BigDecimal getVitamins_vitamin_d_quantity() {
        return Vitamins_vitamin_d_quantity;
    }


    public String getVitamins_vitamin_e_nutr_no() {
        return Vitamins_vitamin_e_nutr_no;
    }


    public BigDecimal getVitamins_vitamin_e_quantity() {
        return Vitamins_vitamin_e_quantity;
    }


    public String getVitamins_vitamin_k_nutr_no() {
        return Vitamins_vitamin_k_nutr_no;
    }


    public BigDecimal getVitamins_vitamin_k_quantity() {
        return Vitamins_vitamin_k_quantity;
    }


    public void setCarbohydrates_carbs_by_diff_nutr_no( String Carbohydrates_carbs_by_diff_nutr_no ) {
        this.Carbohydrates_carbs_by_diff_nutr_no = Carbohydrates_carbs_by_diff_nutr_no;
    }


    public void setCarbohydrates_carbs_by_diff_quantity( String Carbohydrates_carbs_by_diff_quantity ) {
        this.Carbohydrates_carbs_by_diff_quantity = new BigDecimal( Carbohydrates_carbs_by_diff_quantity );
    }


    public void setCarbohydrates_carbs_by_diff_quantity( BigDecimal Carbohydrates_carbs_by_diff_quantity ) {
        this.Carbohydrates_carbs_by_diff_quantity = Carbohydrates_carbs_by_diff_quantity;
    }


    public void setCarbohydrates_fiber_insoluble_nutr_no( String Carbohydrates_fiber_insoluble_nutr_no ) {
        this.Carbohydrates_fiber_insoluble_nutr_no = Carbohydrates_fiber_insoluble_nutr_no;
    }


    public void setCarbohydrates_fiber_insoluble_quantity( String Carbohydrates_fiber_insoluble_quantity ) {
        this.Carbohydrates_fiber_insoluble_quantity = new BigDecimal( Carbohydrates_fiber_insoluble_quantity );
    }


    public void setCarbohydrates_fiber_insoluble_quantity( BigDecimal Carbohydrates_fiber_insoluble_quantity ) {
        this.Carbohydrates_fiber_insoluble_quantity = Carbohydrates_fiber_insoluble_quantity;
    }


    public void setCarbohydrates_fiber_nutr_no( String Carbohydrates_fiber_nutr_no ) {
        this.Carbohydrates_fiber_nutr_no = Carbohydrates_fiber_nutr_no;
    }


    public void setCarbohydrates_fiber_quantity( String Carbohydrates_fiber_quantity ) {
        this.Carbohydrates_fiber_quantity = new BigDecimal( Carbohydrates_fiber_quantity );
    }


    public void setCarbohydrates_fiber_quantity( BigDecimal Carbohydrates_fiber_quantity ) {
        this.Carbohydrates_fiber_quantity = Carbohydrates_fiber_quantity;
    }


    public void setCarbohydrates_fiber_soluble_nutr_no( String Carbohydrates_fiber_soluble_nutr_no ) {
        this.Carbohydrates_fiber_soluble_nutr_no = Carbohydrates_fiber_soluble_nutr_no;
    }


    public void setCarbohydrates_fiber_soluble_quantity( String Carbohydrates_fiber_soluble_quantity ) {
        this.Carbohydrates_fiber_soluble_quantity = new BigDecimal( Carbohydrates_fiber_soluble_quantity );
    }


    public void setCarbohydrates_fiber_soluble_quantity( BigDecimal Carbohydrates_fiber_soluble_quantity ) {
        this.Carbohydrates_fiber_soluble_quantity = Carbohydrates_fiber_soluble_quantity;
    }


    public void setCarbohydrates_fructose_nutr_no( String Carbohydrates_fructose_nutr_no ) {
        this.Carbohydrates_fructose_nutr_no = Carbohydrates_fructose_nutr_no;
    }


    public void setCarbohydrates_fructose_quantity( String Carbohydrates_fructose_quantity ) {
        this.Carbohydrates_fructose_quantity = new BigDecimal( Carbohydrates_fructose_quantity );
    }


    public void setCarbohydrates_fructose_quantity( BigDecimal Carbohydrates_fructose_quantity ) {
        this.Carbohydrates_fructose_quantity = Carbohydrates_fructose_quantity;
    }


    public void setCarbohydrates_glucose_nutr_no( String Carbohydrates_glucose_nutr_no ) {
        this.Carbohydrates_glucose_nutr_no = Carbohydrates_glucose_nutr_no;
    }


    public void setCarbohydrates_glucose_quantity( String Carbohydrates_glucose_quantity ) {
        this.Carbohydrates_glucose_quantity = new BigDecimal( Carbohydrates_glucose_quantity );
    }


    public void setCarbohydrates_glucose_quantity( BigDecimal Carbohydrates_glucose_quantity ) {
        this.Carbohydrates_glucose_quantity = Carbohydrates_glucose_quantity;
    }


    public void setCarbohydrates_glycemic_load_nutr_no( String Carbohydrates_glycemic_load_nutr_no ) {
        this.Carbohydrates_glycemic_load_nutr_no = Carbohydrates_glycemic_load_nutr_no;
    }


    public void setCarbohydrates_glycemic_load_quantity( String Carbohydrates_glycemic_load_quantity ) {
        this.Carbohydrates_glycemic_load_quantity = new BigDecimal( Carbohydrates_glycemic_load_quantity );
    }


    public void setCarbohydrates_glycemic_load_quantity( BigDecimal Carbohydrates_glycemic_load_quantity ) {
        this.Carbohydrates_glycemic_load_quantity = Carbohydrates_glycemic_load_quantity;
    }


    public void setCarbohydrates_lactose_nutr_no( String Carbohydrates_lactose_nutr_no ) {
        this.Carbohydrates_lactose_nutr_no = Carbohydrates_lactose_nutr_no;
    }


    public void setCarbohydrates_lactose_quantity( String Carbohydrates_lactose_quantity ) {
        this.Carbohydrates_lactose_quantity = new BigDecimal( Carbohydrates_lactose_quantity );
    }


    public void setCarbohydrates_lactose_quantity( BigDecimal Carbohydrates_lactose_quantity ) {
        this.Carbohydrates_lactose_quantity = Carbohydrates_lactose_quantity;
    }


    public void setCarbohydrates_starch_nutr_no( String Carbohydrates_starch_nutr_no ) {
        this.Carbohydrates_starch_nutr_no = Carbohydrates_starch_nutr_no;
    }


    public void setCarbohydrates_starch_quantity( String Carbohydrates_starch_quantity ) {
        this.Carbohydrates_starch_quantity = new BigDecimal( Carbohydrates_starch_quantity );
    }


    public void setCarbohydrates_starch_quantity( BigDecimal Carbohydrates_starch_quantity ) {
        this.Carbohydrates_starch_quantity = Carbohydrates_starch_quantity;
    }


    public void setCarbohydrates_sucrose_nutr_no( String Carbohydrates_sucrose_nutr_no ) {
        this.Carbohydrates_sucrose_nutr_no = Carbohydrates_sucrose_nutr_no;
    }


    public void setCarbohydrates_sucrose_quantity( String Carbohydrates_sucrose_quantity ) {
        this.Carbohydrates_sucrose_quantity = new BigDecimal( Carbohydrates_sucrose_quantity );
    }


    public void setCarbohydrates_sucrose_quantity( BigDecimal Carbohydrates_sucrose_quantity ) {
        this.Carbohydrates_sucrose_quantity = Carbohydrates_sucrose_quantity;
    }


    public void setCarbohydrates_sugars_nutr_no( String Carbohydrates_sugars_nutr_no ) {
        this.Carbohydrates_sugars_nutr_no = Carbohydrates_sugars_nutr_no;
    }


    public void setCarbohydrates_sugars_quantity( String Carbohydrates_sugars_quantity ) {
        this.Carbohydrates_sugars_quantity = new BigDecimal( Carbohydrates_sugars_quantity );
    }


    public void setCarbohydrates_sugars_quantity( BigDecimal Carbohydrates_sugars_quantity ) {
        this.Carbohydrates_sugars_quantity = Carbohydrates_sugars_quantity;
    }


    public void setEnergy_gross_nutr_no( String Energy_gross_nutr_no ) {
        this.Energy_gross_nutr_no = Energy_gross_nutr_no;
    }


    public void setEnergy_gross_quantity( String Energy_gross_quantity ) {
        this.Energy_gross_quantity = new BigDecimal( Energy_gross_quantity );
    }


    public void setEnergy_gross_quantity( BigDecimal Energy_gross_quantity ) {
        this.Energy_gross_quantity = Energy_gross_quantity;
    }


    public void setFats_cholesterol_nutr_no( String Fats_cholesterol_nutr_no ) {
        this.Fats_cholesterol_nutr_no = Fats_cholesterol_nutr_no;
    }


    public void setFats_cholesterol_quantity( String Fats_cholesterol_quantity ) {
        this.Fats_cholesterol_quantity = new BigDecimal( Fats_cholesterol_quantity );
    }


    public void setFats_cholesterol_quantity( BigDecimal Fats_cholesterol_quantity ) {
        this.Fats_cholesterol_quantity = Fats_cholesterol_quantity;
    }


    public void setFats_dha_nutr_no( String Fats_dha_nutr_no ) {
        this.Fats_dha_nutr_no = Fats_dha_nutr_no;
    }


    public void setFats_dha_quantity( String Fats_dha_quantity ) {
        this.Fats_dha_quantity = new BigDecimal( Fats_dha_quantity );
    }


    public void setFats_dha_quantity( BigDecimal Fats_dha_quantity ) {
        this.Fats_dha_quantity = Fats_dha_quantity;
    }


    public void setFats_epa_nutr_no( String Fats_epa_nutr_no ) {
        this.Fats_epa_nutr_no = Fats_epa_nutr_no;
    }


    public void setFats_epa_quantity( String Fats_epa_quantity ) {
        this.Fats_epa_quantity = new BigDecimal( Fats_epa_quantity );
    }


    public void setFats_epa_quantity( BigDecimal Fats_epa_quantity ) {
        this.Fats_epa_quantity = Fats_epa_quantity;
    }


    public void setFats_lauric_nutr_no( String Fats_lauric_nutr_no ) {
        this.Fats_lauric_nutr_no = Fats_lauric_nutr_no;
    }


    public void setFats_lauric_quantity( String Fats_lauric_quantity ) {
        this.Fats_lauric_quantity = new BigDecimal( Fats_lauric_quantity );
    }


    public void setFats_lauric_quantity( BigDecimal Fats_lauric_quantity ) {
        this.Fats_lauric_quantity = Fats_lauric_quantity;
    }


    public void setFats_linoleic_nutr_no( String Fats_linoleic_nutr_no ) {
        this.Fats_linoleic_nutr_no = Fats_linoleic_nutr_no;
    }


    public void setFats_linoleic_quantity( String Fats_linoleic_quantity ) {
        this.Fats_linoleic_quantity = new BigDecimal( Fats_linoleic_quantity );
    }


    public void setFats_linoleic_quantity( BigDecimal Fats_linoleic_quantity ) {
        this.Fats_linoleic_quantity = Fats_linoleic_quantity;
    }


    public void setFats_linolenic_nutr_no( String Fats_linolenic_nutr_no ) {
        this.Fats_linolenic_nutr_no = Fats_linolenic_nutr_no;
    }


    public void setFats_linolenic_quantity( String Fats_linolenic_quantity ) {
        this.Fats_linolenic_quantity = new BigDecimal( Fats_linolenic_quantity );
    }


    public void setFats_linolenic_quantity( BigDecimal Fats_linolenic_quantity ) {
        this.Fats_linolenic_quantity = Fats_linolenic_quantity;
    }


    public void setFats_monounsaturated_nutr_no( String Fats_monounsaturated_nutr_no ) {
        this.Fats_monounsaturated_nutr_no = Fats_monounsaturated_nutr_no;
    }


    public void setFats_monounsaturated_quantity( String Fats_monounsaturated_quantity ) {
        this.Fats_monounsaturated_quantity = new BigDecimal( Fats_monounsaturated_quantity );
    }


    public void setFats_monounsaturated_quantity( BigDecimal Fats_monounsaturated_quantity ) {
        this.Fats_monounsaturated_quantity = Fats_monounsaturated_quantity;
    }


    public void setFats_myristic_nutr_no( String Fats_myristic_nutr_no ) {
        this.Fats_myristic_nutr_no = Fats_myristic_nutr_no;
    }


    public void setFats_myristic_quantity( String Fats_myristic_quantity ) {
        this.Fats_myristic_quantity = new BigDecimal( Fats_myristic_quantity );
    }


    public void setFats_myristic_quantity( BigDecimal Fats_myristic_quantity ) {
        this.Fats_myristic_quantity = Fats_myristic_quantity;
    }


    public void setFats_palmitic_nutr_no( String Fats_palmitic_nutr_no ) {
        this.Fats_palmitic_nutr_no = Fats_palmitic_nutr_no;
    }


    public void setFats_palmitic_quantity( String Fats_palmitic_quantity ) {
        this.Fats_palmitic_quantity = new BigDecimal( Fats_palmitic_quantity );
    }


    public void setFats_palmitic_quantity( BigDecimal Fats_palmitic_quantity ) {
        this.Fats_palmitic_quantity = Fats_palmitic_quantity;
    }


    public void setFats_polyunsaturated_nutr_no( String Fats_polyunsaturated_nutr_no ) {
        this.Fats_polyunsaturated_nutr_no = Fats_polyunsaturated_nutr_no;
    }


    public void setFats_polyunsaturated_quantity( String Fats_polyunsaturated_quantity ) {
        this.Fats_polyunsaturated_quantity = new BigDecimal( Fats_polyunsaturated_quantity );
    }


    public void setFats_polyunsaturated_quantity( BigDecimal Fats_polyunsaturated_quantity ) {
        this.Fats_polyunsaturated_quantity = Fats_polyunsaturated_quantity;
    }


    public void setFats_saturated_nutr_no( String Fats_saturated_nutr_no ) {
        this.Fats_saturated_nutr_no = Fats_saturated_nutr_no;
    }


    public void setFats_saturated_quantity( String Fats_saturated_quantity ) {
        this.Fats_saturated_quantity = new BigDecimal( Fats_saturated_quantity );
    }


    public void setFats_saturated_quantity( BigDecimal Fats_saturated_quantity ) {
        this.Fats_saturated_quantity = Fats_saturated_quantity;
    }


    public void setFats_stearic_nutr_no( String Fats_stearic_nutr_no ) {
        this.Fats_stearic_nutr_no = Fats_stearic_nutr_no;
    }


    public void setFats_stearic_quantity( String Fats_stearic_quantity ) {
        this.Fats_stearic_quantity = new BigDecimal( Fats_stearic_quantity );
    }


    public void setFats_stearic_quantity( BigDecimal Fats_stearic_quantity ) {
        this.Fats_stearic_quantity = Fats_stearic_quantity;
    }


    public void setFats_total_nutr_no( String Fats_total_nutr_no ) {
        this.Fats_total_nutr_no = Fats_total_nutr_no;
    }


    public void setFats_total_quantity( String Fats_total_quantity ) {
        this.Fats_total_quantity = new BigDecimal( Fats_total_quantity );
    }


    public void setFats_total_quantity( BigDecimal Fats_total_quantity ) {
        this.Fats_total_quantity = Fats_total_quantity;
    }


    public void setFoodId( String FoodId ) {
        this.FoodId = FoodId;
    }


    public void setFoodName( String FoodName ) {
        this.FoodName = FoodName;
    }


    public void setMinerals_calcium_nutr_no( String Minerals_calcium_nutr_no ) {
        this.Minerals_calcium_nutr_no = Minerals_calcium_nutr_no;
    }


    public void setMinerals_calcium_quantity( String Minerals_calcium_quantity ) {
        this.Minerals_calcium_quantity = new BigDecimal( Minerals_calcium_quantity );
    }


    public void setMinerals_calcium_quantity( BigDecimal Minerals_calcium_quantity ) {
        this.Minerals_calcium_quantity = Minerals_calcium_quantity;
    }


    public void setMinerals_copper_nutr_no( String Minerals_copper_nutr_no ) {
        this.Minerals_copper_nutr_no = Minerals_copper_nutr_no;
    }


    public void setMinerals_copper_quantity( String Minerals_copper_quantity ) {
        this.Minerals_copper_quantity = new BigDecimal( Minerals_copper_quantity );
    }


    public void setMinerals_copper_quantity( BigDecimal Minerals_copper_quantity ) {
        this.Minerals_copper_quantity = Minerals_copper_quantity;
    }


    public void setMinerals_iron_nutr_no( String Minerals_iron_nutr_no ) {
        this.Minerals_iron_nutr_no = Minerals_iron_nutr_no;
    }


    public void setMinerals_iron_quantity( String Minerals_iron_quantity ) {
        this.Minerals_iron_quantity = new BigDecimal( Minerals_iron_quantity );
    }


    public void setMinerals_iron_quantity( BigDecimal Minerals_iron_quantity ) {
        this.Minerals_iron_quantity = Minerals_iron_quantity;
    }


    public void setMinerals_magnesium_nutr_no( String Minerals_magnesium_nutr_no ) {
        this.Minerals_magnesium_nutr_no = Minerals_magnesium_nutr_no;
    }


    public void setMinerals_magnesium_quantity( String Minerals_magnesium_quantity ) {
        this.Minerals_magnesium_quantity = new BigDecimal( Minerals_magnesium_quantity );
    }


    public void setMinerals_magnesium_quantity( BigDecimal Minerals_magnesium_quantity ) {
        this.Minerals_magnesium_quantity = Minerals_magnesium_quantity;
    }


    public void setMinerals_manganese_nutr_no( String Minerals_manganese_nutr_no ) {
        this.Minerals_manganese_nutr_no = Minerals_manganese_nutr_no;
    }


    public void setMinerals_manganese_quantity( String Minerals_manganese_quantity ) {
        this.Minerals_manganese_quantity = new BigDecimal( Minerals_manganese_quantity );
    }


    public void setMinerals_manganese_quantity( BigDecimal Minerals_manganese_quantity ) {
        this.Minerals_manganese_quantity = Minerals_manganese_quantity;
    }


    public void setMinerals_phosphorus_nutr_no( String Minerals_phosphorus_nutr_no ) {
        this.Minerals_phosphorus_nutr_no = Minerals_phosphorus_nutr_no;
    }


    public void setMinerals_phosphorus_quantity( String Minerals_phosphorus_quantity ) {
        this.Minerals_phosphorus_quantity = new BigDecimal( Minerals_phosphorus_quantity );
    }


    public void setMinerals_phosphorus_quantity( BigDecimal Minerals_phosphorus_quantity ) {
        this.Minerals_phosphorus_quantity = Minerals_phosphorus_quantity;
    }


    public void setMinerals_potassium_nutr_no( String Minerals_potassium_nutr_no ) {
        this.Minerals_potassium_nutr_no = Minerals_potassium_nutr_no;
    }


    public void setMinerals_potassium_quantity( String Minerals_potassium_quantity ) {
        this.Minerals_potassium_quantity = new BigDecimal( Minerals_potassium_quantity );
    }


    public void setMinerals_potassium_quantity( BigDecimal Minerals_potassium_quantity ) {
        this.Minerals_potassium_quantity = Minerals_potassium_quantity;
    }


    public void setMinerals_selenium_nutr_no( String Minerals_selenium_nutr_no ) {
        this.Minerals_selenium_nutr_no = Minerals_selenium_nutr_no;
    }


    public void setMinerals_selenium_quantity( String Minerals_selenium_quantity ) {
        this.Minerals_selenium_quantity = new BigDecimal( Minerals_selenium_quantity );
    }


    public void setMinerals_selenium_quantity( BigDecimal Minerals_selenium_quantity ) {
        this.Minerals_selenium_quantity = Minerals_selenium_quantity;
    }


    public void setMinerals_sodium_nutr_no( String Minerals_sodium_nutr_no ) {
        this.Minerals_sodium_nutr_no = Minerals_sodium_nutr_no;
    }


    public void setMinerals_sodium_quantity( String Minerals_sodium_quantity ) {
        this.Minerals_sodium_quantity = new BigDecimal( Minerals_sodium_quantity );
    }


    public void setMinerals_sodium_quantity( BigDecimal Minerals_sodium_quantity ) {
        this.Minerals_sodium_quantity = Minerals_sodium_quantity;
    }


    public void setMinerals_zinc_nutr_no( String Minerals_zinc_nutr_no ) {
        this.Minerals_zinc_nutr_no = Minerals_zinc_nutr_no;
    }


    public void setMinerals_zinc_quantity( String Minerals_zinc_quantity ) {
        this.Minerals_zinc_quantity = new BigDecimal( Minerals_zinc_quantity );
    }


    public void setMinerals_zinc_quantity( BigDecimal Minerals_zinc_quantity ) {
        this.Minerals_zinc_quantity = Minerals_zinc_quantity;
    }


    public void setOther_alcohol_nutr_no( String Other_alcohol_nutr_no ) {
        this.Other_alcohol_nutr_no = Other_alcohol_nutr_no;
    }


    public void setOther_alcohol_quantity( String Other_alcohol_quantity ) {
        this.Other_alcohol_quantity = new BigDecimal( Other_alcohol_quantity );
    }


    public void setOther_alcohol_quantity( BigDecimal Other_alcohol_quantity ) {
        this.Other_alcohol_quantity = Other_alcohol_quantity;
    }


    public void setOther_cost_nutr_no( String Other_cost_nutr_no ) {
        this.Other_cost_nutr_no = Other_cost_nutr_no;
    }


    public void setOther_cost_quantity( String Other_cost_quantity ) {
        this.Other_cost_quantity = new BigDecimal( Other_cost_quantity );
    }


    public void setOther_cost_quantity( BigDecimal Other_cost_quantity ) {
        this.Other_cost_quantity = Other_cost_quantity;
    }


    public void setOther_water_nutr_no( String Other_water_nutr_no ) {
        this.Other_water_nutr_no = Other_water_nutr_no;
    }


    public void setOther_water_quantity( String Other_water_quantity ) {
        this.Other_water_quantity = new BigDecimal( Other_water_quantity );
    }


    public void setOther_water_quantity( BigDecimal Other_water_quantity ) {
        this.Other_water_quantity = Other_water_quantity;
    }


    public void setOther_weight_nutr_no( String Other_weight_nutr_no ) {
        this.Other_weight_nutr_no = Other_weight_nutr_no;
    }


    public void setOther_weight_quantity( String Other_weight_quantity ) {
        this.Other_weight_quantity = new BigDecimal( Other_weight_quantity );
    }


    public void setOther_weight_quantity( BigDecimal Other_weight_quantity ) {
        this.Other_weight_quantity = Other_weight_quantity;
    }


    public void setPhytonutrients_anthocyanins_nutr_no( String Phytonutrients_anthocyanins_nutr_no ) {
        this.Phytonutrients_anthocyanins_nutr_no = Phytonutrients_anthocyanins_nutr_no;
    }


    public void setPhytonutrients_anthocyanins_quantity( String Phytonutrients_anthocyanins_quantity ) {
        this.Phytonutrients_anthocyanins_quantity = new BigDecimal( Phytonutrients_anthocyanins_quantity );
    }


    public void setPhytonutrients_anthocyanins_quantity( BigDecimal Phytonutrients_anthocyanins_quantity ) {
        this.Phytonutrients_anthocyanins_quantity = Phytonutrients_anthocyanins_quantity;
    }


    public void setPhytonutrients_beta_carotene_nutr_no( String Phytonutrients_beta_carotene_nutr_no ) {
        this.Phytonutrients_beta_carotene_nutr_no = Phytonutrients_beta_carotene_nutr_no;
    }


    public void setPhytonutrients_beta_carotene_quantity( String Phytonutrients_beta_carotene_quantity ) {
        this.Phytonutrients_beta_carotene_quantity = new BigDecimal( Phytonutrients_beta_carotene_quantity );
    }


    public void setPhytonutrients_beta_carotene_quantity( BigDecimal Phytonutrients_beta_carotene_quantity ) {
        this.Phytonutrients_beta_carotene_quantity = Phytonutrients_beta_carotene_quantity;
    }


    public void setPhytonutrients_caffeine_nutr_no( String Phytonutrients_caffeine_nutr_no ) {
        this.Phytonutrients_caffeine_nutr_no = Phytonutrients_caffeine_nutr_no;
    }


    public void setPhytonutrients_caffeine_quantity( String Phytonutrients_caffeine_quantity ) {
        this.Phytonutrients_caffeine_quantity = new BigDecimal( Phytonutrients_caffeine_quantity );
    }


    public void setPhytonutrients_caffeine_quantity( BigDecimal Phytonutrients_caffeine_quantity ) {
        this.Phytonutrients_caffeine_quantity = Phytonutrients_caffeine_quantity;
    }


    public void setPhytonutrients_carotenoids_nutr_no( String Phytonutrients_carotenoids_nutr_no ) {
        this.Phytonutrients_carotenoids_nutr_no = Phytonutrients_carotenoids_nutr_no;
    }


    public void setPhytonutrients_carotenoids_quantity( String Phytonutrients_carotenoids_quantity ) {
        this.Phytonutrients_carotenoids_quantity = new BigDecimal( Phytonutrients_carotenoids_quantity );
    }


    public void setPhytonutrients_carotenoids_quantity( BigDecimal Phytonutrients_carotenoids_quantity ) {
        this.Phytonutrients_carotenoids_quantity = Phytonutrients_carotenoids_quantity;
    }


    public void setPhytonutrients_flavanols_nutr_no( String Phytonutrients_flavanols_nutr_no ) {
        this.Phytonutrients_flavanols_nutr_no = Phytonutrients_flavanols_nutr_no;
    }


    public void setPhytonutrients_flavanols_quantity( String Phytonutrients_flavanols_quantity ) {
        this.Phytonutrients_flavanols_quantity = new BigDecimal( Phytonutrients_flavanols_quantity );
    }


    public void setPhytonutrients_flavanols_quantity( BigDecimal Phytonutrients_flavanols_quantity ) {
        this.Phytonutrients_flavanols_quantity = Phytonutrients_flavanols_quantity;
    }


    public void setPhytonutrients_flavanones_nutr_no( String Phytonutrients_flavanones_nutr_no ) {
        this.Phytonutrients_flavanones_nutr_no = Phytonutrients_flavanones_nutr_no;
    }


    public void setPhytonutrients_flavanones_quantity( String Phytonutrients_flavanones_quantity ) {
        this.Phytonutrients_flavanones_quantity = new BigDecimal( Phytonutrients_flavanones_quantity );
    }


    public void setPhytonutrients_flavanones_quantity( BigDecimal Phytonutrients_flavanones_quantity ) {
        this.Phytonutrients_flavanones_quantity = Phytonutrients_flavanones_quantity;
    }


    public void setPhytonutrients_flavones_nutr_no( String Phytonutrients_flavones_nutr_no ) {
        this.Phytonutrients_flavones_nutr_no = Phytonutrients_flavones_nutr_no;
    }


    public void setPhytonutrients_flavones_quantity( String Phytonutrients_flavones_quantity ) {
        this.Phytonutrients_flavones_quantity = new BigDecimal( Phytonutrients_flavones_quantity );
    }


    public void setPhytonutrients_flavones_quantity( BigDecimal Phytonutrients_flavones_quantity ) {
        this.Phytonutrients_flavones_quantity = Phytonutrients_flavones_quantity;
    }


    public void setPhytonutrients_flavonoids_nutr_no( String Phytonutrients_flavonoids_nutr_no ) {
        this.Phytonutrients_flavonoids_nutr_no = Phytonutrients_flavonoids_nutr_no;
    }


    public void setPhytonutrients_flavonoids_quantity( String Phytonutrients_flavonoids_quantity ) {
        this.Phytonutrients_flavonoids_quantity = new BigDecimal( Phytonutrients_flavonoids_quantity );
    }


    public void setPhytonutrients_flavonoids_quantity( BigDecimal Phytonutrients_flavonoids_quantity ) {
        this.Phytonutrients_flavonoids_quantity = Phytonutrients_flavonoids_quantity;
    }


    public void setPhytonutrients_flavonols_nutr_no( String Phytonutrients_flavonols_nutr_no ) {
        this.Phytonutrients_flavonols_nutr_no = Phytonutrients_flavonols_nutr_no;
    }


    public void setPhytonutrients_flavonols_quantity( String Phytonutrients_flavonols_quantity ) {
        this.Phytonutrients_flavonols_quantity = new BigDecimal( Phytonutrients_flavonols_quantity );
    }


    public void setPhytonutrients_flavonols_quantity( BigDecimal Phytonutrients_flavonols_quantity ) {
        this.Phytonutrients_flavonols_quantity = Phytonutrients_flavonols_quantity;
    }


    public void setPhytonutrients_isoflavones_nutr_no( String Phytonutrients_isoflavones_nutr_no ) {
        this.Phytonutrients_isoflavones_nutr_no = Phytonutrients_isoflavones_nutr_no;
    }


    public void setPhytonutrients_isoflavones_quantity( String Phytonutrients_isoflavones_quantity ) {
        this.Phytonutrients_isoflavones_quantity = new BigDecimal( Phytonutrients_isoflavones_quantity );
    }


    public void setPhytonutrients_isoflavones_quantity( BigDecimal Phytonutrients_isoflavones_quantity ) {
        this.Phytonutrients_isoflavones_quantity = Phytonutrients_isoflavones_quantity;
    }


    public void setPhytonutrients_lutein_zeaxanthin_nutr_no( String Phytonutrients_lutein_zeaxanthin_nutr_no ) {
        this.Phytonutrients_lutein_zeaxanthin_nutr_no = Phytonutrients_lutein_zeaxanthin_nutr_no;
    }


    public void setPhytonutrients_lutein_zeaxanthin_quantity( String Phytonutrients_lutein_zeaxanthin_quantity ) {
        this.Phytonutrients_lutein_zeaxanthin_quantity = new BigDecimal( Phytonutrients_lutein_zeaxanthin_quantity );
    }


    public void setPhytonutrients_lutein_zeaxanthin_quantity( BigDecimal Phytonutrients_lutein_zeaxanthin_quantity ) {
        this.Phytonutrients_lutein_zeaxanthin_quantity = Phytonutrients_lutein_zeaxanthin_quantity;
    }


    public void setPhytonutrients_lycopene_nutr_no( String Phytonutrients_lycopene_nutr_no ) {
        this.Phytonutrients_lycopene_nutr_no = Phytonutrients_lycopene_nutr_no;
    }


    public void setPhytonutrients_lycopene_quantity( String Phytonutrients_lycopene_quantity ) {
        this.Phytonutrients_lycopene_quantity = new BigDecimal( Phytonutrients_lycopene_quantity );
    }


    public void setPhytonutrients_lycopene_quantity( BigDecimal Phytonutrients_lycopene_quantity ) {
        this.Phytonutrients_lycopene_quantity = Phytonutrients_lycopene_quantity;
    }


    public void setPhytonutrients_phytosterols_nutr_no( String Phytonutrients_phytosterols_nutr_no ) {
        this.Phytonutrients_phytosterols_nutr_no = Phytonutrients_phytosterols_nutr_no;
    }


    public void setPhytonutrients_phytosterols_quantity( String Phytonutrients_phytosterols_quantity ) {
        this.Phytonutrients_phytosterols_quantity = new BigDecimal( Phytonutrients_phytosterols_quantity );
    }


    public void setPhytonutrients_phytosterols_quantity( BigDecimal Phytonutrients_phytosterols_quantity ) {
        this.Phytonutrients_phytosterols_quantity = Phytonutrients_phytosterols_quantity;
    }


    public void setPhytonutrients_theobromine_nutr_no( String Phytonutrients_theobromine_nutr_no ) {
        this.Phytonutrients_theobromine_nutr_no = Phytonutrients_theobromine_nutr_no;
    }


    public void setPhytonutrients_theobromine_quantity( String Phytonutrients_theobromine_quantity ) {
        this.Phytonutrients_theobromine_quantity = new BigDecimal( Phytonutrients_theobromine_quantity );
    }


    public void setPhytonutrients_theobromine_quantity( BigDecimal Phytonutrients_theobromine_quantity ) {
        this.Phytonutrients_theobromine_quantity = Phytonutrients_theobromine_quantity;
    }


    public void setPhytonutrients_gamma_tocopherol_nutr_no( String Phytonutrients_gamma_tocopherol_nutr_no ) {
        this.Phytonutrients_gamma_tocopherol_nutr_no = Phytonutrients_gamma_tocopherol_nutr_no;
    }


    public void setPhytonutrients_gamma_tocopherol_quantity( String Phytonutrients_gamma_tocopherol_quantity ) {
        this.Phytonutrients_gamma_tocopherol_quantity = new BigDecimal( Phytonutrients_gamma_tocopherol_quantity );
    }


    public void setPhytonutrients_gamma_tocopherol_quantity( BigDecimal Phytonutrients_gamma_tocopherol_quantity ) {
        this.Phytonutrients_gamma_tocopherol_quantity = Phytonutrients_gamma_tocopherol_quantity;
    }


    public void setProtein_complete_nutr_no( String Protein_complete_nutr_no ) {
        this.Protein_complete_nutr_no = Protein_complete_nutr_no;
    }


    public void setProtein_complete_quantity( String Protein_complete_quantity ) {
        this.Protein_complete_quantity = new BigDecimal( Protein_complete_quantity );
    }


    public void setProtein_complete_quantity( BigDecimal Protein_complete_quantity ) {
        this.Protein_complete_quantity = Protein_complete_quantity;
    }


    public void setProtein_total_nutr_no( String Protein_total_nutr_no ) {
        this.Protein_total_nutr_no = Protein_total_nutr_no;
    }


    public void setProtein_total_quantity( String Protein_total_quantity ) {
        this.Protein_total_quantity = new BigDecimal( Protein_total_quantity );
    }


    public void setProtein_total_quantity( BigDecimal Protein_total_quantity ) {
        this.Protein_total_quantity = Protein_total_quantity;
    }


    public void setVitamins_choline_nutr_no( String Vitamins_choline_nutr_no ) {
        this.Vitamins_choline_nutr_no = Vitamins_choline_nutr_no;
    }


    public void setVitamins_choline_quantity( String Vitamins_choline_quantity ) {
        this.Vitamins_choline_quantity = new BigDecimal( Vitamins_choline_quantity );
    }


    public void setVitamins_choline_quantity( BigDecimal Vitamins_choline_quantity ) {
        this.Vitamins_choline_quantity = Vitamins_choline_quantity;
    }


    public void setVitamins_folate_nutr_no( String Vitamins_folate_nutr_no ) {
        this.Vitamins_folate_nutr_no = Vitamins_folate_nutr_no;
    }


    public void setVitamins_folate_quantity( String Vitamins_folate_quantity ) {
        this.Vitamins_folate_quantity = new BigDecimal( Vitamins_folate_quantity );
    }


    public void setVitamins_folate_quantity( BigDecimal Vitamins_folate_quantity ) {
        this.Vitamins_folate_quantity = Vitamins_folate_quantity;
    }


    public void setVitamins_niacin_nutr_no( String Vitamins_niacin_nutr_no ) {
        this.Vitamins_niacin_nutr_no = Vitamins_niacin_nutr_no;
    }


    public void setVitamins_niacin_quantity( String Vitamins_niacin_quantity ) {
        this.Vitamins_niacin_quantity = new BigDecimal( Vitamins_niacin_quantity );
    }


    public void setVitamins_niacin_quantity( BigDecimal Vitamins_niacin_quantity ) {
        this.Vitamins_niacin_quantity = Vitamins_niacin_quantity;
    }


    public void setVitamins_pantothenic_acid_nutr_no( String Vitamins_pantothenic_acid_nutr_no ) {
        this.Vitamins_pantothenic_acid_nutr_no = Vitamins_pantothenic_acid_nutr_no;
    }


    public void setVitamins_pantothenic_acid_quantity( String Vitamins_pantothenic_quantity ) {
        Vitamins_pantothenic_acid_quantity = new BigDecimal( Vitamins_pantothenic_quantity );
    }


    public void setVitamins_pantothenic_acid_quantity( BigDecimal Vitamins_pantothenic_quantity ) {
        Vitamins_pantothenic_acid_quantity = Vitamins_pantothenic_quantity;
    }


    public void setVitamins_riboflavin_nutr_no( String Vitamins_riboflavin_nutr_no ) {
        this.Vitamins_riboflavin_nutr_no = Vitamins_riboflavin_nutr_no;
    }


    public void setVitamins_riboflavin_quantity( String Vitamins_riboflavin_quantity ) {
        this.Vitamins_riboflavin_quantity = new BigDecimal( Vitamins_riboflavin_quantity );
    }


    public void setVitamins_riboflavin_quantity( BigDecimal Vitamins_riboflavin_quantity ) {
        this.Vitamins_riboflavin_quantity = Vitamins_riboflavin_quantity;
    }


    public void setVitamins_thiamin_nutr_no( String Vitamins_thiamin_nutr_no ) {
        this.Vitamins_thiamin_nutr_no = Vitamins_thiamin_nutr_no;
    }


    public void setVitamins_thiamin_quantity( String Vitamins_thiamin_quantity ) {
        this.Vitamins_thiamin_quantity = new BigDecimal( Vitamins_thiamin_quantity );
    }


    public void setVitamins_thiamin_quantity( BigDecimal Vitamins_thiamin_quantity ) {
        this.Vitamins_thiamin_quantity = Vitamins_thiamin_quantity;
    }


    public void setVitamins_vitamin_a_nutr_no( String Vitamins_vitamin_a_nutr_no ) {
        this.Vitamins_vitamin_a_nutr_no = Vitamins_vitamin_a_nutr_no;
    }


    public void setVitamins_vitamin_a_quantity( String Vitamins_vitamin_a_quantity ) {
        this.Vitamins_vitamin_a_quantity = new BigDecimal( Vitamins_vitamin_a_quantity );
    }


    public void setVitamins_vitamin_a_quantity( BigDecimal Vitamins_vitamin_a_quantity ) {
        this.Vitamins_vitamin_a_quantity = Vitamins_vitamin_a_quantity;
    }


    public void setVitamins_vitamin_b12_nutr_no( String Vitamins_vitamin_b12_nutr_no ) {
        this.Vitamins_vitamin_b12_nutr_no = Vitamins_vitamin_b12_nutr_no;
    }


    public void setVitamins_vitamin_b12_quantity( String Vitamins_vitamin_b12_quantity ) {
        this.Vitamins_vitamin_b12_quantity = new BigDecimal( Vitamins_vitamin_b12_quantity );
    }


    public void setVitamins_vitamin_b12_quantity( BigDecimal Vitamins_vitamin_b12_quantity ) {
        this.Vitamins_vitamin_b12_quantity = Vitamins_vitamin_b12_quantity;
    }


    public void setVitamins_vitamin_b6_nutr_no( String Vitamins_vitamin_b6_nutr_no ) {
        this.Vitamins_vitamin_b6_nutr_no = Vitamins_vitamin_b6_nutr_no;
    }


    public void setVitamins_vitamin_b6_quantity( String Vitamins_vitamin_b6_quantity ) {
        this.Vitamins_vitamin_b6_quantity = new BigDecimal( Vitamins_vitamin_b6_quantity );
    }


    public void setVitamins_vitamin_b6_quantity( BigDecimal Vitamins_vitamin_b6_quantity ) {
        this.Vitamins_vitamin_b6_quantity = Vitamins_vitamin_b6_quantity;
    }


    public void setVitamins_vitamin_c_nutr_no( String Vitamins_vitamin_c_nutr_no ) {
        this.Vitamins_vitamin_c_nutr_no = Vitamins_vitamin_c_nutr_no;
    }


    public void setVitamins_vitamin_c_quantity( String Vitamins_vitamin_c_quantity ) {
        this.Vitamins_vitamin_c_quantity = new BigDecimal( Vitamins_vitamin_c_quantity );
    }


    public void setVitamins_vitamin_c_quantity( BigDecimal Vitamins_vitamin_c_quantity ) {
        this.Vitamins_vitamin_c_quantity = Vitamins_vitamin_c_quantity;
    }


    public void setVitamins_vitamin_d_nutr_no( String Vitamins_vitamin_d_nutr_no ) {
        this.Vitamins_vitamin_d_nutr_no = Vitamins_vitamin_d_nutr_no;
    }


    public void setVitamins_vitamin_d_quantity( String Vitamins_vitamin_d_quantity ) {
        this.Vitamins_vitamin_d_quantity = new BigDecimal( Vitamins_vitamin_d_quantity );
    }


    public void setVitamins_vitamin_d_quantity( BigDecimal Vitamins_vitamin_d_quantity ) {
        this.Vitamins_vitamin_d_quantity = Vitamins_vitamin_d_quantity;
    }


    public void setVitamins_vitamin_e_nutr_no( String Vitamins_vitamin_e_nutr_no ) {
        this.Vitamins_vitamin_e_nutr_no = Vitamins_vitamin_e_nutr_no;
    }


    public void setVitamins_vitamin_e_quantity( String Vitamins_vitamin_e_quantity ) {
        this.Vitamins_vitamin_e_quantity = new BigDecimal( Vitamins_vitamin_e_quantity );
    }


    public void setVitamins_vitamin_e_quantity( BigDecimal Vitamins_vitamin_e_quantity ) {
        this.Vitamins_vitamin_e_quantity = Vitamins_vitamin_e_quantity;
    }


    public void setVitamins_vitamin_k_nutr_no( String Vitamins_vitamin_k_nutr_no ) {
        this.Vitamins_vitamin_k_nutr_no = Vitamins_vitamin_k_nutr_no;
    }


    public void setVitamins_vitamin_k_quantity( String Vitamins_vitamin_k_quantity ) {
        this.Vitamins_vitamin_k_quantity = new BigDecimal( Vitamins_vitamin_k_quantity );
    }


    public void setVitamins_vitamin_k_quantity( BigDecimal Vitamins_vitamin_k_quantity ) {
        this.Vitamins_vitamin_k_quantity = Vitamins_vitamin_k_quantity;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append( "Food{" );
        sb.append( "FoodId=" ).append( FoodId );
        sb.append( ", FoodName=" ).append( FoodName );
        sb.append( ", Carbohydrates_carbs_by_diff_quantity=" ).append( Carbohydrates_carbs_by_diff_quantity );
        sb.append( ", Carbohydrates_fiber_quantity=" ).append( Carbohydrates_fiber_quantity );
        sb.append( ", Carbohydrates_fiber_insoluble_quantity=" ).append( Carbohydrates_fiber_insoluble_quantity );
        sb.append( ", Carbohydrates_fiber_soluble_quantity=" ).append( Carbohydrates_fiber_soluble_quantity );
        sb.append( ", Carbohydrates_fructose_quantity=" ).append( Carbohydrates_fructose_quantity );
        sb.append( ", Carbohydrates_glucose_quantity=" ).append( Carbohydrates_glucose_quantity );
        sb.append( ", Carbohydrates_glycemic_load_quantity=" ).append( Carbohydrates_glycemic_load_quantity );
        sb.append( ", Carbohydrates_lactose_quantity=" ).append( Carbohydrates_lactose_quantity );
        sb.append( ", Carbohydrates_starch_quantity=" ).append( Carbohydrates_starch_quantity );
        sb.append( ", Carbohydrates_sucrose_quantity=" ).append( Carbohydrates_sucrose_quantity );
        sb.append( ", Carbohydrates_sugars_quantity=" ).append( Carbohydrates_sugars_quantity );
        sb.append( ", Energy_gross_quantity=" ).append( Energy_gross_quantity );
        sb.append( ", Fats_linolenic_quantity=" ).append( Fats_linolenic_quantity );
        sb.append( ", Fats_cholesterol_quantity=" ).append( Fats_cholesterol_quantity );
        sb.append( ", Fats_dha_quantity=" ).append( Fats_dha_quantity );
        sb.append( ", Fats_epa_quantity=" ).append( Fats_epa_quantity );
        sb.append( ", Fats_lauric_quantity=" ).append( Fats_lauric_quantity );
        sb.append( ", Fats_linoleic_quantity=" ).append( Fats_linoleic_quantity );
        sb.append( ", Fats_monounsaturated_quantity=" ).append( Fats_monounsaturated_quantity );
        sb.append( ", Fats_myristic_quantity=" ).append( Fats_myristic_quantity );
        sb.append( ", Fats_palmitic_quantity=" ).append( Fats_palmitic_quantity );
        sb.append( ", Fats_polyunsaturated_quantity=" ).append( Fats_polyunsaturated_quantity );
        sb.append( ", Fats_saturated_quantity=" ).append( Fats_saturated_quantity );
        sb.append( ", Fats_stearic_quantity=" ).append( Fats_stearic_quantity );
        sb.append( ", Fats_total_quantity=" ).append( Fats_total_quantity );
        sb.append( ", Minerals_calcium_quantity=" ).append( Minerals_calcium_quantity );
        sb.append( ", Minerals_copper_quantity=" ).append( Minerals_copper_quantity );
        sb.append( ", Minerals_iron_quantity=" ).append( Minerals_iron_quantity );
        sb.append( ", Minerals_magnesium_quantity=" ).append( Minerals_magnesium_quantity );
        sb.append( ", Minerals_manganese_quantity=" ).append( Minerals_manganese_quantity );
        sb.append( ", Minerals_phosphorus_quantity=" ).append( Minerals_phosphorus_quantity );
        sb.append( ", Minerals_potassium_quantity=" ).append( Minerals_potassium_quantity );
        sb.append( ", Minerals_selenium_quantity=" ).append( Minerals_selenium_quantity );
        sb.append( ", Minerals_sodium_quantity=" ).append( Minerals_sodium_quantity );
        sb.append( ", Minerals_zinc_quantity=" ).append( Minerals_zinc_quantity );
        sb.append( ", Other_alcohol_quantity=" ).append( Other_alcohol_quantity );
        sb.append( ", Other_cost_quantity=" ).append( Other_cost_quantity );
        sb.append( ", Other_water_quantity=" ).append( Other_water_quantity );
        sb.append( ", Other_weight_quantity=" ).append( Other_weight_quantity );
        sb.append( ", Phytonutrients_anthocyanins_quantity=" ).append( Phytonutrients_anthocyanins_quantity );
        sb.append( ", Phytonutrients_caffeine_quantity=" ).append( Phytonutrients_caffeine_quantity );
        sb.append( ", Phytonutrients_beta_carotene_quantity=" ).append( Phytonutrients_beta_carotene_quantity );
        sb.append( ", Phytonutrients_carotenoids_quantity=" ).append( Phytonutrients_carotenoids_quantity );
        sb.append( ", Phytonutrients_flavanols_quantity=" ).append( Phytonutrients_flavanols_quantity );
        sb.append( ", Phytonutrients_flavanones_quantity=" ).append( Phytonutrients_flavanones_quantity );
        sb.append( ", Phytonutrients_flavones_quantity=" ).append( Phytonutrients_flavones_quantity );
        sb.append( ", Phytonutrients_flavonoids_quantity=" ).append( Phytonutrients_flavonoids_quantity );
        sb.append( ", Phytonutrients_flavonols_quantity=" ).append( Phytonutrients_flavonols_quantity );
        sb.append( ", Phytonutrients_isoflavones_quantity=" ).append( Phytonutrients_isoflavones_quantity );
        sb.append( ", Phytonutrients_lutein_zeaxanthin_quantity=" ).append( Phytonutrients_lutein_zeaxanthin_quantity );
        sb.append( ", Phytonutrients_lycopene_quantity=" ).append( Phytonutrients_lycopene_quantity );
        sb.append( ", Phytonutrients_phytosterols_quantity=" ).append( Phytonutrients_phytosterols_quantity );
        sb.append( ", Phytonutrients_theobromine_quantity=" ).append( Phytonutrients_theobromine_quantity );
        sb.append( ", Phytonutrients_gamma_tocopherol_quantity=" ).append( Phytonutrients_gamma_tocopherol_quantity );
        sb.append( ", Protein_complete_quantity=" ).append( Protein_complete_quantity );
        sb.append( ", Protein_total_quantity=" ).append( Protein_total_quantity );
        sb.append( ", Vitamins_vitamin_a_quantity=" ).append( Vitamins_vitamin_a_quantity );
        sb.append( ", Vitamins_vitamin_b12_quantity=" ).append( Vitamins_vitamin_b12_quantity );
        sb.append( ", Vitamins_vitamin_b6_quantity=" ).append( Vitamins_vitamin_b6_quantity );
        sb.append( ", Vitamins_vitamin_c_quantity=" ).append( Vitamins_vitamin_c_quantity );
        sb.append( ", Vitamins_choline_quantity=" ).append( Vitamins_choline_quantity );
        sb.append( ", Vitamins_vitamin_d_quantity=" ).append( Vitamins_vitamin_d_quantity );
        sb.append( ", Vitamins_vitamin_e_quantity=" ).append( Vitamins_vitamin_e_quantity );
        sb.append( ", Vitamins_folate_quantity=" ).append( Vitamins_folate_quantity );
        sb.append( ", Vitamins_vitamin_k_quantity=" ).append( Vitamins_vitamin_k_quantity );
        sb.append( ", Vitamins_niacin_quantity=" ).append( Vitamins_niacin_quantity );
        sb.append( ", Vitamins_pantothenic_acid_quantity=" ).append( Vitamins_pantothenic_acid_quantity );
        sb.append( ", Vitamins_riboflavin_quantity=" ).append( Vitamins_riboflavin_quantity );
        sb.append( ", Vitamins_thiamin_quantity=" ).append( Vitamins_thiamin_quantity );
        sb.append( ", Carbohydrates_carbs_by_diff_nutr_no=" ).append( Carbohydrates_carbs_by_diff_nutr_no );
        sb.append( ", Carbohydrates_fiber_nutr_no=" ).append( Carbohydrates_fiber_nutr_no );
        sb.append( ", Carbohydrates_fiber_insoluble_nutr_no=" ).append( Carbohydrates_fiber_insoluble_nutr_no );
        sb.append( ", Carbohydrates_fiber_soluble_nutr_no=" ).append( Carbohydrates_fiber_soluble_nutr_no );
        sb.append( ", Carbohydrates_fructose_nutr_no=" ).append( Carbohydrates_fructose_nutr_no );
        sb.append( ", Carbohydrates_glucose_nutr_no=" ).append( Carbohydrates_glucose_nutr_no );
        sb.append( ", Carbohydrates_glycemic_load_nutr_no=" ).append( Carbohydrates_glycemic_load_nutr_no );
        sb.append( ", Carbohydrates_lactose_nutr_no=" ).append( Carbohydrates_lactose_nutr_no );
        sb.append( ", Carbohydrates_starch_nutr_no=" ).append( Carbohydrates_starch_nutr_no );
        sb.append( ", Carbohydrates_sucrose_nutr_no=" ).append( Carbohydrates_sucrose_nutr_no );
        sb.append( ", Carbohydrates_sugars_nutr_no=" ).append( Carbohydrates_sugars_nutr_no );
        sb.append( ", Energy_gross_nutr_no=" ).append( Energy_gross_nutr_no );
        sb.append( ", Fats_linolenic_nutr_no=" ).append( Fats_linolenic_nutr_no );
        sb.append( ", Fats_cholesterol_nutr_no=" ).append( Fats_cholesterol_nutr_no );
        sb.append( ", Fats_dha_nutr_no=" ).append( Fats_dha_nutr_no );
        sb.append( ", Fats_epa_nutr_no=" ).append( Fats_epa_nutr_no );
        sb.append( ", Fats_lauric_nutr_no=" ).append( Fats_lauric_nutr_no );
        sb.append( ", Fats_linoleic_nutr_no=" ).append( Fats_linoleic_nutr_no );
        sb.append( ", Fats_monounsaturated_nutr_no=" ).append( Fats_monounsaturated_nutr_no );
        sb.append( ", Fats_myristic_nutr_no=" ).append( Fats_myristic_nutr_no );
        sb.append( ", Fats_palmitic_nutr_no=" ).append( Fats_palmitic_nutr_no );
        sb.append( ", Fats_polyunsaturated_nutr_no=" ).append( Fats_polyunsaturated_nutr_no );
        sb.append( ", Fats_saturated_nutr_no=" ).append( Fats_saturated_nutr_no );
        sb.append( ", Fats_stearic_nutr_no=" ).append( Fats_stearic_nutr_no );
        sb.append( ", Fats_total_nutr_no=" ).append( Fats_total_nutr_no );
        sb.append( ", Minerals_calcium_nutr_no=" ).append( Minerals_calcium_nutr_no );
        sb.append( ", Minerals_copper_nutr_no=" ).append( Minerals_copper_nutr_no );
        sb.append( ", Minerals_iron_nutr_no=" ).append( Minerals_iron_nutr_no );
        sb.append( ", Minerals_magnesium_nutr_no=" ).append( Minerals_magnesium_nutr_no );
        sb.append( ", Minerals_manganese_nutr_no=" ).append( Minerals_manganese_nutr_no );
        sb.append( ", Minerals_phosphorus_nutr_no=" ).append( Minerals_phosphorus_nutr_no );
        sb.append( ", Minerals_potassium_nutr_no=" ).append( Minerals_potassium_nutr_no );
        sb.append( ", Minerals_selenium_nutr_no=" ).append( Minerals_selenium_nutr_no );
        sb.append( ", Minerals_sodium_nutr_no=" ).append( Minerals_sodium_nutr_no );
        sb.append( ", Minerals_zinc_nutr_no=" ).append( Minerals_zinc_nutr_no );
        sb.append( ", Other_alcohol_nutr_no=" ).append( Other_alcohol_nutr_no );
        sb.append( ", Other_cost_nutr_no=" ).append( Other_cost_nutr_no );
        sb.append( ", Other_water_nutr_no=" ).append( Other_water_nutr_no );
        sb.append( ", Other_weight_nutr_no=" ).append( Other_weight_nutr_no );
        sb.append( ", Phytonutrients_anthocyanins_nutr_no=" ).append( Phytonutrients_anthocyanins_nutr_no );
        sb.append( ", Phytonutrients_caffeine_nutr_no=" ).append( Phytonutrients_caffeine_nutr_no );
        sb.append( ", Phytonutrients_beta_carotene_nutr_no=" ).append( Phytonutrients_beta_carotene_nutr_no );
        sb.append( ", Phytonutrients_carotenoids_nutr_no=" ).append( Phytonutrients_carotenoids_nutr_no );
        sb.append( ", Phytonutrients_flavanols_nutr_no=" ).append( Phytonutrients_flavanols_nutr_no );
        sb.append( ", Phytonutrients_flavanones_nutr_no=" ).append( Phytonutrients_flavanones_nutr_no );
        sb.append( ", Phytonutrients_flavones_nutr_no=" ).append( Phytonutrients_flavones_nutr_no );
        sb.append( ", Phytonutrients_flavonoids_nutr_no=" ).append( Phytonutrients_flavonoids_nutr_no );
        sb.append( ", Phytonutrients_flavonols_nutr_no=" ).append( Phytonutrients_flavonols_nutr_no );
        sb.append( ", Phytonutrients_isoflavones_nutr_no=" ).append( Phytonutrients_isoflavones_nutr_no );
        sb.append( ", Phytonutrients_lutein_zeaxanthin_nutr_no=" ).append( Phytonutrients_lutein_zeaxanthin_nutr_no );
        sb.append( ", Phytonutrients_lycopene_nutr_no=" ).append( Phytonutrients_lycopene_nutr_no );
        sb.append( ", Phytonutrients_phytosterols_nutr_no=" ).append( Phytonutrients_phytosterols_nutr_no );
        sb.append( ", Phytonutrients_theobromine_nutr_no=" ).append( Phytonutrients_theobromine_nutr_no );
        sb.append( ", Phytonutrients_gamma_tocopherol_nutr_no=" ).append( Phytonutrients_gamma_tocopherol_nutr_no );
        sb.append( ", Protein_complete_nutr_no=" ).append( Protein_complete_nutr_no );
        sb.append( ", Protein_total_nutr_no=" ).append( Protein_total_nutr_no );
        sb.append( ", Vitamins_vitamin_a_nutr_no=" ).append( Vitamins_vitamin_a_nutr_no );
        sb.append( ", Vitamins_vitamin_b12_nutr_no=" ).append( Vitamins_vitamin_b12_nutr_no );
        sb.append( ", Vitamins_vitamin_b6_nutr_no=" ).append( Vitamins_vitamin_b6_nutr_no );
        sb.append( ", Vitamins_vitamin_c_nutr_no=" ).append( Vitamins_vitamin_c_nutr_no );
        sb.append( ", Vitamins_choline_nutr_no=" ).append( Vitamins_choline_nutr_no );
        sb.append( ", Vitamins_vitamin_d_nutr_no=" ).append( Vitamins_vitamin_d_nutr_no );
        sb.append( ", Vitamins_vitamin_e_nutr_no=" ).append( Vitamins_vitamin_e_nutr_no );
        sb.append( ", Vitamins_folate_nutr_no=" ).append( Vitamins_folate_nutr_no );
        sb.append( ", Vitamins_vitamin_k_nutr_no=" ).append( Vitamins_vitamin_k_nutr_no );
        sb.append( ", Vitamins_niacin_nutr_no=" ).append( Vitamins_niacin_nutr_no );
        sb.append( ", Vitamins_pantothenic_acid_nutr_no=" ).append( Vitamins_pantothenic_acid_nutr_no );
        sb.append( ", Vitamins_riboflavin_nutr_no=" ).append( Vitamins_riboflavin_nutr_no );
        sb.append( ", Vitamins_thiamin_nutr_no=" ).append( Vitamins_thiamin_nutr_no );
        sb.append( ", categories=" ).append( categories );
        sb.append( '}' );
        return sb.toString();
    }


    public String getCheckSum() {
        ArrayList<BigDecimal> foodfacts = new ArrayList();
        StringBuilder sb = new StringBuilder();
        foodfacts.add( Carbohydrates_carbs_by_diff_quantity );
        foodfacts.add( Carbohydrates_fiber_insoluble_quantity );
        foodfacts.add( Carbohydrates_fiber_quantity );
        foodfacts.add( Carbohydrates_fiber_soluble_quantity );
        foodfacts.add( Carbohydrates_fructose_quantity );
        foodfacts.add( Carbohydrates_glucose_quantity );
        foodfacts.add( Carbohydrates_glycemic_load_quantity );
        foodfacts.add( Carbohydrates_lactose_quantity );
        foodfacts.add( Carbohydrates_starch_quantity );
        foodfacts.add( Carbohydrates_sucrose_quantity );
        foodfacts.add( Carbohydrates_sugars_quantity );
        foodfacts.add( Energy_gross_quantity );
        foodfacts.add( Fats_cholesterol_quantity );
        foodfacts.add( Fats_dha_quantity );
        foodfacts.add( Fats_epa_quantity );
        foodfacts.add( Fats_lauric_quantity );
        foodfacts.add( Fats_linoleic_quantity );
        foodfacts.add( Fats_linolenic_quantity );
        foodfacts.add( Fats_monounsaturated_quantity );
        foodfacts.add( Fats_myristic_quantity );
        foodfacts.add( Fats_palmitic_quantity );
        foodfacts.add( Fats_polyunsaturated_quantity );
        foodfacts.add( Fats_saturated_quantity );
        foodfacts.add( Fats_stearic_quantity );
        foodfacts.add( Fats_total_quantity );
        foodfacts.add( Minerals_calcium_quantity );
        foodfacts.add( Minerals_copper_quantity );
        foodfacts.add( Minerals_iron_quantity );
        foodfacts.add( Minerals_magnesium_quantity );
        foodfacts.add( Minerals_manganese_quantity );
        foodfacts.add( Minerals_phosphorus_quantity );
        foodfacts.add( Minerals_potassium_quantity );
        foodfacts.add( Minerals_selenium_quantity );
        foodfacts.add( Minerals_sodium_quantity );
        foodfacts.add( Minerals_zinc_quantity );
        foodfacts.add( Other_alcohol_quantity );
        foodfacts.add( Other_cost_quantity );
        foodfacts.add( Other_water_quantity );
        foodfacts.add( Other_weight_quantity );
        foodfacts.add( Phytonutrients_anthocyanins_quantity );
        foodfacts.add( Phytonutrients_beta_carotene_quantity );
        foodfacts.add( Phytonutrients_caffeine_quantity );
        foodfacts.add( Phytonutrients_carotenoids_quantity );
        foodfacts.add( Phytonutrients_flavanols_quantity );
        foodfacts.add( Phytonutrients_flavanones_quantity );
        foodfacts.add( Phytonutrients_flavones_quantity );
        foodfacts.add( Phytonutrients_flavonoids_quantity );
        foodfacts.add( Phytonutrients_flavonols_quantity );
        foodfacts.add( Phytonutrients_isoflavones_quantity );
        foodfacts.add( Phytonutrients_lutein_zeaxanthin_quantity );
        foodfacts.add( Phytonutrients_lycopene_quantity );
        foodfacts.add( Phytonutrients_phytosterols_quantity );
        foodfacts.add( Phytonutrients_theobromine_quantity );
        foodfacts.add( Phytonutrients_gamma_tocopherol_quantity );
        foodfacts.add( Protein_complete_quantity );
        foodfacts.add( Protein_total_quantity );
        foodfacts.add( Vitamins_choline_quantity );
        foodfacts.add( Vitamins_folate_quantity );
        foodfacts.add( Vitamins_niacin_quantity );
        foodfacts.add( Vitamins_pantothenic_acid_quantity );
        foodfacts.add( Vitamins_riboflavin_quantity );
        foodfacts.add( Vitamins_thiamin_quantity );
        foodfacts.add( Vitamins_vitamin_a_quantity );
        foodfacts.add( Vitamins_vitamin_b6_quantity );
        foodfacts.add( Vitamins_vitamin_b12_quantity );
        foodfacts.add( Vitamins_vitamin_c_quantity );
        foodfacts.add( Vitamins_vitamin_d_quantity );
        foodfacts.add( Vitamins_vitamin_e_quantity );
        foodfacts.add( Vitamins_vitamin_k_quantity );
        foodfacts.forEach( d -> sb.append( d.stripTrailingZeros().toPlainString() ) );
        return DigestUtils.md5Hex( sb.toString() );
    }


    public int getCategoryCount() {
        return categories.size();
    }


    public String printCategories() {
        return categories.toString();
    }


    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode( getCheckSum() );
        return hash;
    }


    @Override
    public boolean equals( Object obj ) {
        if ( this == obj ) {
            return true;
        }
        if ( obj == null ) {
            return false;
        }
        if ( getClass() != obj.getClass() ) {
            return false;
        }
        final Food other = ( Food ) obj;
        return Objects.equals( this.getCheckSum(), other.getCheckSum() );
    }


    public void clear() {
        FoodId = "";
        FoodName = "";
        Carbohydrates_carbs_by_diff_nutr_no = "";
        Carbohydrates_carbs_by_diff_quantity = new BigDecimal( "0.0" );
        Carbohydrates_fiber_nutr_no = "";
        Carbohydrates_fiber_quantity = new BigDecimal( "0.0" );
        Carbohydrates_fiber_insoluble_nutr_no = "";
        Carbohydrates_fiber_insoluble_quantity = new BigDecimal( "0.0" );
        Carbohydrates_fiber_soluble_nutr_no = "";
        Carbohydrates_fiber_soluble_quantity = new BigDecimal( "0.0" );
        Carbohydrates_fructose_nutr_no = "";
        Carbohydrates_fructose_quantity = new BigDecimal( "0.0" );
        Carbohydrates_glucose_nutr_no = "";
        Carbohydrates_glucose_quantity = new BigDecimal( "0.0" );
        Carbohydrates_glycemic_load_nutr_no = "";
        Carbohydrates_glycemic_load_quantity = new BigDecimal( "0.0" );
        Carbohydrates_lactose_nutr_no = "";
        Carbohydrates_lactose_quantity = new BigDecimal( "0.0" );
        Carbohydrates_starch_nutr_no = "";
        Carbohydrates_starch_quantity = new BigDecimal( "0.0" );
        Carbohydrates_sucrose_nutr_no = "";
        Carbohydrates_sucrose_quantity = new BigDecimal( "0.0" );
        Carbohydrates_sugars_nutr_no = "";
        Carbohydrates_sugars_quantity = new BigDecimal( "0.0" );
        Energy_gross_nutr_no = "";
        Energy_gross_quantity = new BigDecimal( "0.0" );
        Fats_linolenic_nutr_no = "";
        Fats_linolenic_quantity = new BigDecimal( "0.0" );
        Fats_cholesterol_nutr_no = "";
        Fats_cholesterol_quantity = new BigDecimal( "0.0" );
        Fats_dha_nutr_no = "";
        Fats_dha_quantity = new BigDecimal( "0.0" );
        Fats_epa_nutr_no = "";
        Fats_epa_quantity = new BigDecimal( "0.0" );
        Fats_lauric_nutr_no = "";
        Fats_lauric_quantity = new BigDecimal( "0.0" );
        Fats_linoleic_nutr_no = "";
        Fats_linoleic_quantity = new BigDecimal( "0.0" );
        Fats_monounsaturated_nutr_no = "";
        Fats_monounsaturated_quantity = new BigDecimal( "0.0" );
        Fats_myristic_nutr_no = "";
        Fats_myristic_quantity = new BigDecimal( "0.0" );
        Fats_palmitic_nutr_no = "";
        Fats_palmitic_quantity = new BigDecimal( "0.0" );
        Fats_polyunsaturated_nutr_no = "";
        Fats_polyunsaturated_quantity = new BigDecimal( "0.0" );
        Fats_saturated_nutr_no = "";
        Fats_saturated_quantity = new BigDecimal( "0.0" );
        Fats_stearic_nutr_no = "";
        Fats_stearic_quantity = new BigDecimal( "0.0" );
        Fats_total_nutr_no = "";
        Fats_total_quantity = new BigDecimal( "0.0" );
        Minerals_calcium_nutr_no = "";
        Minerals_calcium_quantity = new BigDecimal( "0.0" );
        Minerals_copper_nutr_no = "";
        Minerals_copper_quantity = new BigDecimal( "0.0" );
        Minerals_iron_nutr_no = "";
        Minerals_iron_quantity = new BigDecimal( "0.0" );
        Minerals_magnesium_nutr_no = "";
        Minerals_magnesium_quantity = new BigDecimal( "0.0" );
        Minerals_manganese_nutr_no = "";
        Minerals_manganese_quantity = new BigDecimal( "0.0" );
        Minerals_phosphorus_nutr_no = "";
        Minerals_phosphorus_quantity = new BigDecimal( "0.0" );
        Minerals_potassium_nutr_no = "";
        Minerals_potassium_quantity = new BigDecimal( "0.0" );
        Minerals_selenium_nutr_no = "";
        Minerals_selenium_quantity = new BigDecimal( "0.0" );
        Minerals_sodium_nutr_no = "";
        Minerals_sodium_quantity = new BigDecimal( "0.0" );
        Minerals_zinc_nutr_no = "";
        Minerals_zinc_quantity = new BigDecimal( "0.0" );
        Other_alcohol_nutr_no = "";
        Other_alcohol_quantity = new BigDecimal( "0.0" );
        Other_cost_nutr_no = "";
        Other_cost_quantity = new BigDecimal( "0.0" );
        Other_water_nutr_no = "";
        Other_water_quantity = new BigDecimal( "0.0" );
        Other_weight_nutr_no = "";
        Other_weight_quantity = new BigDecimal( "0.0" );
        Phytonutrients_anthocyanins_nutr_no = "";
        Phytonutrients_anthocyanins_quantity = new BigDecimal( "0.0" );
        Phytonutrients_caffeine_nutr_no = "";
        Phytonutrients_caffeine_quantity = new BigDecimal( "0.0" );
        Phytonutrients_beta_carotene_nutr_no = "";
        Phytonutrients_beta_carotene_quantity = new BigDecimal( "0.0" );
        Phytonutrients_carotenoids_nutr_no = "";
        Phytonutrients_carotenoids_quantity = new BigDecimal( "0.0" );
        Phytonutrients_flavanols_nutr_no = "";
        Phytonutrients_flavanols_quantity = new BigDecimal( "0.0" );
        Phytonutrients_flavanones_nutr_no = "";
        Phytonutrients_flavanones_quantity = new BigDecimal( "0.0" );
        Phytonutrients_flavones_nutr_no = "";
        Phytonutrients_flavones_quantity = new BigDecimal( "0.0" );
        Phytonutrients_flavonoids_nutr_no = "";
        Phytonutrients_flavonoids_quantity = new BigDecimal( "0.0" );
        Phytonutrients_flavonols_nutr_no = "";
        Phytonutrients_flavonols_quantity = new BigDecimal( "0.0" );
        Phytonutrients_isoflavones_nutr_no = "";
        Phytonutrients_isoflavones_quantity = new BigDecimal( "0.0" );
        Phytonutrients_lutein_zeaxanthin_nutr_no = "";
        Phytonutrients_lutein_zeaxanthin_quantity = new BigDecimal( "0.0" );
        Phytonutrients_lycopene_nutr_no = "";
        Phytonutrients_lycopene_quantity = new BigDecimal( "0.0" );
        Phytonutrients_phytosterols_nutr_no = "";
        Phytonutrients_phytosterols_quantity = new BigDecimal( "0.0" );
        Phytonutrients_theobromine_nutr_no = "";
        Phytonutrients_theobromine_quantity = new BigDecimal( "0.0" );
        Phytonutrients_gamma_tocopherol_nutr_no = "";
        Phytonutrients_gamma_tocopherol_quantity = new BigDecimal( "0.0" );
        Protein_complete_nutr_no = "";
        Protein_complete_quantity = new BigDecimal( "0.0" );
        Protein_total_nutr_no = "";
        Protein_total_quantity = new BigDecimal( "0.0" );
        Vitamins_vitamin_a_nutr_no = "";
        Vitamins_vitamin_a_quantity = new BigDecimal( "0.0" );
        Vitamins_vitamin_b12_nutr_no = "";
        Vitamins_vitamin_b12_quantity = new BigDecimal( "0.0" );
        Vitamins_vitamin_b6_nutr_no = "";
        Vitamins_vitamin_b6_quantity = new BigDecimal( "0.0" );
        Vitamins_vitamin_c_nutr_no = "";
        Vitamins_vitamin_c_quantity = new BigDecimal( "0.0" );
        Vitamins_choline_nutr_no = "";
        Vitamins_choline_quantity = new BigDecimal( "0.0" );
        Vitamins_vitamin_d_nutr_no = "";
        Vitamins_vitamin_d_quantity = new BigDecimal( "0.0" );
        Vitamins_vitamin_e_nutr_no = "";
        Vitamins_vitamin_e_quantity = new BigDecimal( "0.0" );
        Vitamins_folate_nutr_no = "";
        Vitamins_folate_quantity = new BigDecimal( "0.0" );
        Vitamins_vitamin_k_nutr_no = "";
        Vitamins_vitamin_k_quantity = new BigDecimal( "0.0" );
        Vitamins_niacin_nutr_no = "";
        Vitamins_niacin_quantity = new BigDecimal( "0.0" );
        Vitamins_pantothenic_acid_nutr_no = "";
        Vitamins_pantothenic_acid_quantity = new BigDecimal( "0.0" );
        Vitamins_riboflavin_nutr_no = "";
        Vitamins_riboflavin_quantity = new BigDecimal( "0.0" );
        Vitamins_thiamin_nutr_no = "";
        Vitamins_thiamin_quantity = new BigDecimal( "0.0" );
        categories = new ArrayList<>();
    }
}
