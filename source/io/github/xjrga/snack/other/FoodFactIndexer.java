package io.github.xjrga.snack.other;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FoodFactIndexer {

    private List<Integer> indexes;
    private HashMap<String, Integer> map;


    public FoodFactIndexer() {
        indexes = new ArrayList();
        map = new HashMap();
        map.put( "mix_id", 0 );
        map.put( "food_id", 1 );
        map.put( "food_name", 2 );
        map.put( "carbohydrates_carbs_by_diff", 3 );
        map.put( "carbohydrates_fiber_insoluble", 4 );
        map.put( "carbohydrates_fiber_soluble", 5 );
        map.put( "carbohydrates_fiber", 6 );
        map.put( "carbohydrates_fructose", 7 );
        map.put( "carbohydrates_glucose", 8 );
        map.put( "carbohydrates_glycemic_load", 9 );
        map.put( "carbohydrates_lactose", 10 );
        map.put( "carbohydrates_starch", 11 );
        map.put( "carbohydrates_sucrose", 12 );
        map.put( "carbohydrates_sugars", 13 );
        map.put( "energy_gross", 14 );
        map.put( "fats_cholesterol", 15 );
        map.put( "fats_dha", 16 );
        map.put( "fats_epa", 17 );
        map.put( "fats_lauric", 18 );
        map.put( "fats_linoleic", 19 );
        map.put( "fats_linolenic", 20 );
        map.put( "fats_monounsaturated", 21 );
        map.put( "fats_myristic", 22 );
        map.put( "fats_palmitic", 23 );
        map.put( "fats_polyunsaturated", 24 );
        map.put( "fats_saturated", 25 );
        map.put( "fats_stearic", 26 );
        map.put( "fats_total", 27 );
        map.put( "minerals_calcium", 28 );
        map.put( "minerals_copper", 29 );
        map.put( "minerals_iron", 30 );
        map.put( "minerals_magnesium", 31 );
        map.put( "minerals_manganese", 32 );
        map.put( "minerals_phosphorus", 33 );
        map.put( "minerals_potassium", 34 );
        map.put( "minerals_selenium", 35 );
        map.put( "minerals_sodium", 36 );
        map.put( "minerals_zinc", 37 );
        map.put( "other_alcohol", 38 );
        map.put( "other_cost", 39 );
        map.put( "other_water", 40 );
        map.put( "other_weight", 41 );
        map.put( "phytonutrients_anthocyanins", 42 );
        map.put( "phytonutrients_caffeine", 43 );
        map.put( "phytonutrients_beta_carotene", 44 );
        map.put( "phytonutrients_carotenoids", 45 );
        map.put( "phytonutrients_flavanols", 46 );
        map.put( "phytonutrients_flavanones", 47 );
        map.put( "phytonutrients_flavones", 48 );
        map.put( "phytonutrients_flavonoids", 49 );
        map.put( "phytonutrients_flavonols", 50 );
        map.put( "phytonutrients_isoflavones", 51 );
        map.put( "phytonutrients_lutein_zeaxanthin", 52 );
        map.put( "phytonutrients_lycopene", 53 );
        map.put( "phytonutrients_phytosterols", 54 );
        map.put( "phytonutrients_theobromine", 55 );
        map.put( "protein_complete", 56 );
        map.put( "protein_total", 57 );
        map.put( "vitamins_vitamin_a", 58 );
        map.put( "vitamins_vitamin_b12", 59 );
        map.put( "vitamins_vitamin_b6", 60 );
        map.put( "vitamins_vitamin_c", 61 );
        map.put( "vitamins_choline", 62 );
        map.put( "vitamins_vitamin_d", 63 );
        map.put( "vitamins_vitamin_e", 64 );
        map.put( "vitamins_folate", 65 );
        map.put( "vitamins_vitamin_k", 66 );
        map.put( "vitamins_niacin", 67 );
        map.put( "vitamins_pantothenic_acid", 68 );
        map.put( "vitamins_riboflavin", 69 );
        map.put( "vitamins_thiamin", 70 );
        map.put( "carbohydrates_digestible", 71 );
        map.put( "energy_carbohydrate", 72 );
        map.put( "energy_fat", 73 );
        map.put( "energy_fat_and_carbohydrate", 74 );
        map.put( "energy_protein", 75 );
        map.put( "energy_alcohol", 76 );
        map.put( "energy_digestible", 77 );
        map.put( "fats_hcsfa", 78 );
        map.put( "fats_lcn3pufa", 79 );
    }


    public void setMixid() {
        indexes.add( map.get( "mix_id" ) );
    }


    public void setFoodid() {
        indexes.add( map.get( "food_id" ) );
    }


    public void setFoodname() {
        indexes.add( map.get( "food_name" ) );
    }


    public void setCarbohydrates_carbs_by_diff() {
        indexes.add( map.get( "carbohydrates_carbs_by_diff" ) );
    }


    public void setCarbohydrates_fiber_insoluble() {
        indexes.add( map.get( "carbohydrates_fiber_insoluble" ) );
    }


    public void setCarbohydrates_fiber_soluble() {
        indexes.add( map.get( "carbohydrates_fiber_soluble" ) );
    }


    public void setCarbohydrates_fiber() {
        indexes.add( map.get( "carbohydrates_fiber" ) );
    }


    public void setCarbohydrates_fructose() {
        indexes.add( map.get( "carbohydrates_fructose" ) );
    }


    public void setCarbohydrates_glucose() {
        indexes.add( map.get( "carbohydrates_glucose" ) );
    }


    public void setCarbohydrates_glycemic_load() {
        indexes.add( map.get( "carbohydrates_glycemic_load" ) );
    }


    public void setCarbohydrates_lactose() {
        indexes.add( map.get( "carbohydrates_lactose" ) );
    }


    public void setCarbohydrates_starch() {
        indexes.add( map.get( "carbohydrates_starch" ) );
    }


    public void setCarbohydrates_sucrose() {
        indexes.add( map.get( "carbohydrates_sucrose" ) );
    }


    public void setCarbohydrates_sugars() {
        indexes.add( map.get( "carbohydrates_sugars" ) );
    }


    public void setEnergy_gross() {
        indexes.add( map.get( "energy_gross" ) );
    }


    public void setFats_cholesterol() {
        indexes.add( map.get( "fats_cholesterol" ) );
    }


    public void setFats_dha() {
        indexes.add( map.get( "fats_dha" ) );
    }


    public void setFats_epa() {
        indexes.add( map.get( "fats_epa" ) );
    }


    public void setFats_lauric() {
        indexes.add( map.get( "fats_lauric" ) );
    }


    public void setFats_linoleic() {
        indexes.add( map.get( "fats_linoleic" ) );
    }


    public void setFats_linolenic() {
        indexes.add( map.get( "fats_linolenic" ) );
    }


    public void setFats_monounsaturated() {
        indexes.add( map.get( "fats_monounsaturated" ) );
    }


    public void setFats_myristic() {
        indexes.add( map.get( "fats_myristic" ) );
    }


    public void setFats_palmitic() {
        indexes.add( map.get( "fats_palmitic" ) );
    }


    public void setFats_polyunsaturated() {
        indexes.add( map.get( "fats_polyunsaturated" ) );
    }


    public void setFats_saturated() {
        indexes.add( map.get( "fats_saturated" ) );
    }


    public void setFats_stearic() {
        indexes.add( map.get( "fats_stearic" ) );
    }


    public void setFats_total() {
        indexes.add( map.get( "fats_total" ) );
    }


    public void setMinerals_calcium() {
        indexes.add( map.get( "minerals_calcium" ) );
    }


    public void setMinerals_copper() {
        indexes.add( map.get( "minerals_copper" ) );
    }


    public void setMinerals_iron() {
        indexes.add( map.get( "minerals_iron" ) );
    }


    public void setMinerals_magnesium() {
        indexes.add( map.get( "minerals_magnesium" ) );
    }


    public void setMinerals_manganese() {
        indexes.add( map.get( "minerals_manganese" ) );
    }


    public void setMinerals_phosphorus() {
        indexes.add( map.get( "minerals_phosphorus" ) );
    }


    public void setMinerals_potassium() {
        indexes.add( map.get( "minerals_potassium" ) );
    }


    public void setMinerals_selenium() {
        indexes.add( map.get( "minerals_selenium" ) );
    }


    public void setMinerals_sodium() {
        indexes.add( map.get( "minerals_sodium" ) );
    }


    public void setMinerals_zinc() {
        indexes.add( map.get( "minerals_zinc" ) );
    }


    public void setOther_alcohol() {
        indexes.add( map.get( "other_alcohol" ) );
    }


    public void setOther_cost() {
        indexes.add( map.get( "other_cost" ) );
    }


    public void setOther_water() {
        indexes.add( map.get( "other_water" ) );
    }


    public void setOther_weight() {
        indexes.add( map.get( "other_weight" ) );
    }


    public void setPhytonutrients_anthocyanins() {
        indexes.add( map.get( "phytonutrients_anthocyanins" ) );
    }


    public void setPhytonutrients_caffeine() {
        indexes.add( map.get( "phytonutrients_caffeine" ) );
    }


    public void setPhytonutrients_beta_carotene() {
        indexes.add( map.get( "phytonutrients_beta_carotene" ) );
    }


    public void setPhytonutrients_carotenoids() {
        indexes.add( map.get( "phytonutrients_carotenoids" ) );
    }


    public void setPhytonutrients_flavanols() {
        indexes.add( map.get( "phytonutrients_flavanols" ) );
    }


    public void setPhytonutrients_flavanones() {
        indexes.add( map.get( "phytonutrients_flavanones" ) );
    }


    public void setPhytonutrients_flavones() {
        indexes.add( map.get( "phytonutrients_flavones" ) );
    }


    public void setPhytonutrients_flavonoids() {
        indexes.add( map.get( "phytonutrients_flavonoids" ) );
    }


    public void setPhytonutrients_flavonols() {
        indexes.add( map.get( "phytonutrients_flavonols" ) );
    }


    public void setPhytonutrients_isoflavones() {
        indexes.add( map.get( "phytonutrients_isoflavones" ) );
    }


    public void setPhytonutrients_lutein_zeaxanthin() {
        indexes.add( map.get( "phytonutrients_lutein_zeaxanthin" ) );
    }


    public void setPhytonutrients_lycopene() {
        indexes.add( map.get( "phytonutrients_lycopene" ) );
    }


    public void setPhytonutrients_phytosterols() {
        indexes.add( map.get( "phytonutrients_phytosterols" ) );
    }


    public void setPhytonutrients_theobromine() {
        indexes.add( map.get( "phytonutrients_theobromine" ) );
    }


    public void setProtein_complete() {
        indexes.add( map.get( "protein_complete" ) );
    }


    public void setProtein_total() {
        indexes.add( map.get( "protein_total" ) );
    }


    public void setVitamins_vitamin_a() {
        indexes.add( map.get( "vitamins_vitamin_a" ) );
    }


    public void setVitamins_vitamin_b12() {
        indexes.add( map.get( "vitamins_vitamin_b12" ) );
    }


    public void setVitamins_vitamin_b6() {
        indexes.add( map.get( "vitamins_vitamin_b6" ) );
    }


    public void setVitamins_vitamin_c() {
        indexes.add( map.get( "vitamins_vitamin_c" ) );
    }


    public void setVitamins_choline() {
        indexes.add( map.get( "vitamins_choline" ) );
    }


    public void setVitamins_vitamin_d() {
        indexes.add( map.get( "vitamins_vitamin_d" ) );
    }


    public void setVitamins_vitamin_e() {
        indexes.add( map.get( "vitamins_vitamin_e" ) );
    }


    public void setVitamins_folate() {
        indexes.add( map.get( "vitamins_folate" ) );
    }


    public void setVitamins_vitamin_k() {
        indexes.add( map.get( "vitamins_vitamin_k" ) );
    }


    public void setVitamins_niacin() {
        indexes.add( map.get( "vitamins_niacin" ) );
    }


    public void setVitamins_pantothenic_acid() {
        indexes.add( map.get( "vitamins_pantothenic_acid" ) );
    }


    public void setVitamins_riboflavin() {
        indexes.add( map.get( "vitamins_riboflavin" ) );
    }


    public void setVitamins_thiamin() {
        indexes.add( map.get( "vitamins_thiamin" ) );
    }


    public void setCarbohydrates_digestible() {
        indexes.add( map.get( "carbohydrates_digestible" ) );
    }


    public void setEnergy_carbohydrate() {
        indexes.add( map.get( "energy_carbohydrate" ) );
    }


    public void setEnergy_fat() {
        indexes.add( map.get( "energy_fat" ) );
    }


    public void setEnergy_fat_and_carbohydrate() {
        indexes.add( map.get( "energy_fat_and_carbohydrate" ) );
    }


    public void setEnergy_protein() {
        indexes.add( map.get( "energy_protein" ) );
    }


    public void setEnergy_alcohol() {
        indexes.add( map.get( "energy_alcohol" ) );
    }


    public void setEnergy_digestible() {
        indexes.add( map.get( "energy_digestible" ) );
    }


    public void setFats_hcsfa() {
        indexes.add( map.get( "fats_hcsfa" ) );
    }


    public void setFats_lcn3pufa() {
        indexes.add( map.get( "fats_lcn3pufa" ) );
    }


    public List<Integer> get() {
        return indexes;
    }
}
