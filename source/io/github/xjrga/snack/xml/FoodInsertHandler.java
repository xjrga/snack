package io.github.xjrga.snack.xml;

import io.github.xjrga.snack.database.callable.FoodCreator;
import io.github.xjrga.snack.dataobject.Category;
import io.github.xjrga.snack.dataobject.Food;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class FoodInsertHandler extends DefaultHandler {

  private Category category;
  private Food food;
  private StringBuilder text;

  public FoodInsertHandler() {
    food = new Food();
    category = new Category();
    text = new StringBuilder();
  }

  @Override
  public void startElement(String uri, String localName, String qName, Attributes attributes)
      throws SAXException {
    text.setLength(0);
    switch (qName) {
      case "food" -> {
        food = new Food();
      }
      case "carbohydrates-carbs_by_diff" -> {
        food.setCarbohydrates_carbs_by_diff_nutr_no(attributes.getValue("nutr_no"));
      }
      case "carbohydrates-fiber_insoluble" -> {
        food.setCarbohydrates_fiber_insoluble_nutr_no(attributes.getValue("nutr_no"));
      }
      case "carbohydrates-fiber_soluble" -> {
        food.setCarbohydrates_fiber_soluble_nutr_no(attributes.getValue("nutr_no"));
      }
      case "carbohydrates-fiber" -> {
        food.setCarbohydrates_fiber_nutr_no(attributes.getValue("nutr_no"));
      }
      case "carbohydrates-fructose" -> {
        food.setCarbohydrates_fructose_nutr_no(attributes.getValue("nutr_no"));
      }
      case "carbohydrates-glucose" -> {
        food.setCarbohydrates_glucose_nutr_no(attributes.getValue("nutr_no"));
      }
      case "carbohydrates-glycemic_load" -> {
        food.setCarbohydrates_glycemic_load_nutr_no(attributes.getValue("nutr_no"));
      }
      case "carbohydrates-lactose" -> {
        food.setCarbohydrates_lactose_nutr_no(attributes.getValue("nutr_no"));
      }
      case "carbohydrates-starch" -> {
        food.setCarbohydrates_starch_nutr_no(attributes.getValue("nutr_no"));
      }
      case "carbohydrates-sucrose" -> {
        food.setCarbohydrates_sucrose_nutr_no(attributes.getValue("nutr_no"));
      }
      case "carbohydrates-sugars" -> {
        food.setCarbohydrates_sugars_nutr_no(attributes.getValue("nutr_no"));
      }
      case "energy-gross" -> {
        food.setEnergy_gross_nutr_no(attributes.getValue("nutr_no"));
      }
      case "fats-cholesterol" -> {
        food.setFats_cholesterol_nutr_no(attributes.getValue("nutr_no"));
      }
      case "fats-dha" -> {
        food.setFats_dha_nutr_no(attributes.getValue("nutr_no"));
      }
      case "fats-epa" -> {
        food.setFats_epa_nutr_no(attributes.getValue("nutr_no"));
      }
      case "fats-lauric" -> {
        food.setFats_lauric_nutr_no(attributes.getValue("nutr_no"));
      }
      case "fats-linoleic" -> {
        food.setFats_linoleic_nutr_no(attributes.getValue("nutr_no"));
      }
      case "fats-linolenic" -> {
        food.setFats_linolenic_nutr_no(attributes.getValue("nutr_no"));
      }
      case "fats-monounsaturated" -> {
        food.setFats_monounsaturated_nutr_no(attributes.getValue("nutr_no"));
      }
      case "fats-myristic" -> {
        food.setFats_myristic_nutr_no(attributes.getValue("nutr_no"));
      }
      case "fats-palmitic" -> {
        food.setFats_palmitic_nutr_no(attributes.getValue("nutr_no"));
      }
      case "fats-polyunsaturated" -> {
        food.setFats_polyunsaturated_nutr_no(attributes.getValue("nutr_no"));
      }
      case "fats-saturated" -> {
        food.setFats_saturated_nutr_no(attributes.getValue("nutr_no"));
      }
      case "fats-stearic" -> {
        food.setFats_stearic_nutr_no(attributes.getValue("nutr_no"));
      }
      case "fats-total" -> {
        food.setFats_total_nutr_no(attributes.getValue("nutr_no"));
      }
      case "minerals-calcium" -> {
        food.setMinerals_calcium_nutr_no(attributes.getValue("nutr_no"));
      }
      case "minerals-copper" -> {
        food.setMinerals_copper_nutr_no(attributes.getValue("nutr_no"));
      }
      case "minerals-iron" -> {
        food.setMinerals_iron_nutr_no(attributes.getValue("nutr_no"));
      }
      case "minerals-magnesium" -> {
        food.setMinerals_magnesium_nutr_no(attributes.getValue("nutr_no"));
      }
      case "minerals-manganese" -> {
        food.setMinerals_manganese_nutr_no(attributes.getValue("nutr_no"));
      }
      case "minerals-phosphorus" -> {
        food.setMinerals_phosphorus_nutr_no(attributes.getValue("nutr_no"));
      }
      case "minerals-potassium" -> {
        food.setMinerals_potassium_nutr_no(attributes.getValue("nutr_no"));
      }
      case "minerals-selenium" -> {
        food.setMinerals_selenium_nutr_no(attributes.getValue("nutr_no"));
      }
      case "minerals-sodium" -> {
        food.setMinerals_sodium_nutr_no(attributes.getValue("nutr_no"));
      }
      case "minerals-zinc" -> {
        food.setMinerals_zinc_nutr_no(attributes.getValue("nutr_no"));
      }
      case "other-alcohol" -> {
        food.setOther_alcohol_nutr_no(attributes.getValue("nutr_no"));
      }
      case "other-cost" -> {
        food.setOther_cost_nutr_no(attributes.getValue("nutr_no"));
      }
      case "other-water" -> {
        food.setOther_water_nutr_no(attributes.getValue("nutr_no"));
      }
      case "other-weight" -> {
        food.setOther_weight_nutr_no(attributes.getValue("nutr_no"));
      }
      case "phytonutrients-anthocyanins" -> {
        food.setPhytonutrients_anthocyanins_nutr_no(attributes.getValue("nutr_no"));
      }
      case "phytonutrients-caffeine" -> {
        food.setPhytonutrients_caffeine_nutr_no(attributes.getValue("nutr_no"));
      }
      case "phytonutrients-beta_carotene" -> {
        food.setPhytonutrients_beta_carotene_nutr_no(attributes.getValue("nutr_no"));
      }
      case "phytonutrients-carotenoids" -> {
        food.setPhytonutrients_carotenoids_nutr_no(attributes.getValue("nutr_no"));
      }
      case "phytonutrients-flavanols" -> {
        food.setPhytonutrients_flavanols_nutr_no(attributes.getValue("nutr_no"));
      }
      case "phytonutrients-flavanones" -> {
        food.setPhytonutrients_flavanones_nutr_no(attributes.getValue("nutr_no"));
      }
      case "phytonutrients-flavones" -> {
        food.setPhytonutrients_flavones_nutr_no(attributes.getValue("nutr_no"));
      }
      case "phytonutrients-flavonoids" -> {
        food.setPhytonutrients_flavonoids_nutr_no(attributes.getValue("nutr_no"));
      }
      case "phytonutrients-flavonols" -> {
        food.setPhytonutrients_flavonols_nutr_no(attributes.getValue("nutr_no"));
      }
      case "phytonutrients-isoflavones" -> {
        food.setPhytonutrients_isoflavones_nutr_no(attributes.getValue("nutr_no"));
      }
      case "phytonutrients-lutein_zeaxanthin" -> {
        food.setPhytonutrients_lutein_zeaxanthin_nutr_no(attributes.getValue("nutr_no"));
      }
      case "phytonutrients-lycopene" -> {
        food.setPhytonutrients_lycopene_nutr_no(attributes.getValue("nutr_no"));
      }
      case "phytonutrients-phytosterols" -> {
        food.setPhytonutrients_phytosterols_nutr_no(attributes.getValue("nutr_no"));
      }
      case "phytonutrients-theobromine" -> {
        food.setPhytonutrients_theobromine_nutr_no(attributes.getValue("nutr_no"));
      }
      case "protein-complete" -> {
        food.setProtein_complete_nutr_no(attributes.getValue("nutr_no"));
      }
      case "protein-total" -> {
        food.setProtein_total_nutr_no(attributes.getValue("nutr_no"));
      }
      case "vitamins-vitamin_a" -> {
        food.setVitamins_vitamin_a_nutr_no(attributes.getValue("nutr_no"));
      }
      case "vitamins-vitamin_b12" -> {
        food.setVitamins_vitamin_b12_nutr_no(attributes.getValue("nutr_no"));
      }
      case "vitamins-vitamin_b6" -> {
        food.setVitamins_vitamin_b6_nutr_no(attributes.getValue("nutr_no"));
      }
      case "vitamins-vitamin_c" -> {
        food.setVitamins_vitamin_c_nutr_no(attributes.getValue("nutr_no"));
      }
      case "vitamins-choline" -> {
        food.setVitamins_choline_nutr_no(attributes.getValue("nutr_no"));
      }
      case "vitamins-vitamin_d" -> {
        food.setVitamins_vitamin_d_nutr_no(attributes.getValue("nutr_no"));
      }
      case "vitamins-vitamin_e" -> {
        food.setVitamins_vitamin_e_nutr_no(attributes.getValue("nutr_no"));
      }
      case "vitamins-folate" -> {
        food.setVitamins_folate_nutr_no(attributes.getValue("nutr_no"));
      }
      case "vitamins-vitamin_k" -> {
        food.setVitamins_vitamin_k_nutr_no(attributes.getValue("nutr_no"));
      }
      case "vitamins-niacin" -> {
        food.setVitamins_niacin_nutr_no(attributes.getValue("nutr_no"));
      }
      case "vitamins-pantothenic_acid" -> {
        food.setVitamins_pantothenic_acid_nutr_no(attributes.getValue("nutr_no"));
      }
      case "vitamins-riboflavin" -> {
        food.setVitamins_riboflavin_nutr_no(attributes.getValue("nutr_no"));
      }
      case "vitamins-thiamin" -> {
        food.setVitamins_thiamin_nutr_no(attributes.getValue("nutr_no"));
      }
      case "category" -> {
        category = new Category();
      }
    }
  }

  @Override
  public void characters(char[] ch, int start, int length) throws SAXException {
    text.append(ch, start, length);
  }

  @Override
  public void endElement(String uri, String localName, String qName) throws SAXException {
    switch (qName) {
      case "food" -> {
        new FoodCreator(food).create();
      }
      case "food-id" -> {
        food.setFoodId(text.toString());
      }
      case "food-name" -> {
        food.setFoodName(text.toString());
      }
      case "carbohydrates-carbs_by_diff" -> {
        food.setCarbohydrates_carbs_by_diff_quantity(text.toString());
      }
      case "carbohydrates-fiber_insoluble" -> {
        food.setCarbohydrates_fiber_insoluble_quantity(text.toString());
      }
      case "carbohydrates-fiber_soluble" -> {
        food.setCarbohydrates_fiber_soluble_quantity(text.toString());
      }
      case "carbohydrates-fiber" -> {
        food.setCarbohydrates_fiber_quantity(text.toString());
      }
      case "carbohydrates-fructose" -> {
        food.setCarbohydrates_fructose_quantity(text.toString());
      }
      case "carbohydrates-glucose" -> {
        food.setCarbohydrates_glucose_quantity(text.toString());
      }
      case "carbohydrates-glycemic_load" -> {
        food.setCarbohydrates_glycemic_load_quantity(text.toString());
      }
      case "carbohydrates-lactose" -> {
        food.setCarbohydrates_lactose_quantity(text.toString());
      }
      case "carbohydrates-starch" -> {
        food.setCarbohydrates_starch_quantity(text.toString());
      }
      case "carbohydrates-sucrose" -> {
        food.setCarbohydrates_sucrose_quantity(text.toString());
      }
      case "carbohydrates-sugars" -> {
        food.setCarbohydrates_sugars_quantity(text.toString());
      }
      case "energy-gross" -> {
        food.setEnergy_gross_quantity(text.toString());
      }
      case "fats-cholesterol" -> {
        food.setFats_cholesterol_quantity(text.toString());
      }
      case "fats-dha" -> {
        food.setFats_dha_quantity(text.toString());
      }
      case "fats-epa" -> {
        food.setFats_epa_quantity(text.toString());
      }
      case "fats-lauric" -> {
        food.setFats_lauric_quantity(text.toString());
      }
      case "fats-linoleic" -> {
        food.setFats_linoleic_quantity(text.toString());
      }
      case "fats-linolenic" -> {
        food.setFats_linolenic_quantity(text.toString());
      }
      case "fats-monounsaturated" -> {
        food.setFats_monounsaturated_quantity(text.toString());
      }
      case "fats-myristic" -> {
        food.setFats_myristic_quantity(text.toString());
      }
      case "fats-palmitic" -> {
        food.setFats_palmitic_quantity(text.toString());
      }
      case "fats-polyunsaturated" -> {
        food.setFats_polyunsaturated_quantity(text.toString());
      }
      case "fats-saturated" -> {
        food.setFats_saturated_quantity(text.toString());
      }
      case "fats-stearic" -> {
        food.setFats_stearic_quantity(text.toString());
      }
      case "fats-total" -> {
        food.setFats_total_quantity(text.toString());
      }
      case "minerals-calcium" -> {
        food.setMinerals_calcium_quantity(text.toString());
      }
      case "minerals-copper" -> {
        food.setMinerals_copper_quantity(text.toString());
      }
      case "minerals-iron" -> {
        food.setMinerals_iron_quantity(text.toString());
      }
      case "minerals-magnesium" -> {
        food.setMinerals_magnesium_quantity(text.toString());
      }
      case "minerals-manganese" -> {
        food.setMinerals_manganese_quantity(text.toString());
      }
      case "minerals-phosphorus" -> {
        food.setMinerals_phosphorus_quantity(text.toString());
      }
      case "minerals-potassium" -> {
        food.setMinerals_potassium_quantity(text.toString());
      }
      case "minerals-selenium" -> {
        food.setMinerals_selenium_quantity(text.toString());
      }
      case "minerals-sodium" -> {
        food.setMinerals_sodium_quantity(text.toString());
      }
      case "minerals-zinc" -> {
        food.setMinerals_zinc_quantity(text.toString());
      }
      case "other-alcohol" -> {
        food.setOther_alcohol_quantity(text.toString());
      }
      case "other-cost" -> {
        food.setOther_cost_quantity(text.toString());
      }
      case "other-water" -> {
        food.setOther_water_quantity(text.toString());
      }
      case "other-weight" -> {
        food.setOther_weight_quantity(text.toString());
      }
      case "phytonutrients-anthocyanins" -> {
        food.setPhytonutrients_anthocyanins_quantity(text.toString());
      }
      case "phytonutrients-caffeine" -> {
        food.setPhytonutrients_caffeine_quantity(text.toString());
      }
      case "phytonutrients-beta_carotene" -> {
        food.setPhytonutrients_beta_carotene_quantity(text.toString());
      }
      case "phytonutrients-carotenoids" -> {
        food.setPhytonutrients_carotenoids_quantity(text.toString());
      }
      case "phytonutrients-flavanols" -> {
        food.setPhytonutrients_flavanols_quantity(text.toString());
      }
      case "phytonutrients-flavanones" -> {
        food.setPhytonutrients_flavanones_quantity(text.toString());
      }
      case "phytonutrients-flavones" -> {
        food.setPhytonutrients_flavones_quantity(text.toString());
      }
      case "phytonutrients-flavonoids" -> {
        food.setPhytonutrients_flavonoids_quantity(text.toString());
      }
      case "phytonutrients-flavonols" -> {
        food.setPhytonutrients_flavonols_quantity(text.toString());
      }
      case "phytonutrients-isoflavones" -> {
        food.setPhytonutrients_isoflavones_quantity(text.toString());
      }
      case "phytonutrients-lutein_zeaxanthin" -> {
        food.setPhytonutrients_lutein_zeaxanthin_quantity(text.toString());
      }
      case "phytonutrients-lycopene" -> {
        food.setPhytonutrients_lycopene_quantity(text.toString());
      }
      case "phytonutrients-phytosterols" -> {
        food.setPhytonutrients_phytosterols_quantity(text.toString());
      }
      case "phytonutrients-theobromine" -> {
        food.setPhytonutrients_theobromine_quantity(text.toString());
      }
      case "protein-complete" -> {
        food.setProtein_complete_quantity(text.toString());
      }
      case "protein-total" -> {
        food.setProtein_total_quantity(text.toString());
      }
      case "vitamins-vitamin_a" -> {
        food.setVitamins_vitamin_a_quantity(text.toString());
      }
      case "vitamins-vitamin_b12" -> {
        food.setVitamins_vitamin_b12_quantity(text.toString());
      }
      case "vitamins-vitamin_b6" -> {
        food.setVitamins_vitamin_b6_quantity(text.toString());
      }
      case "vitamins-vitamin_c" -> {
        food.setVitamins_vitamin_c_quantity(text.toString());
      }
      case "vitamins-choline" -> {
        food.setVitamins_choline_quantity(text.toString());
      }
      case "vitamins-vitamin_d" -> {
        food.setVitamins_vitamin_d_quantity(text.toString());
      }
      case "vitamins-vitamin_e" -> {
        food.setVitamins_vitamin_e_quantity(text.toString());
      }
      case "vitamins-folate" -> {
        food.setVitamins_folate_quantity(text.toString());
      }
      case "vitamins-vitamin_k" -> {
        food.setVitamins_vitamin_k_quantity(text.toString());
      }
      case "vitamins-niacin" -> {
        food.setVitamins_niacin_quantity(text.toString());
      }
      case "vitamins-pantothenic_acid" -> {
        food.setVitamins_pantothenic_acid_quantity(text.toString());
      }
      case "vitamins-riboflavin" -> {
        food.setVitamins_riboflavin_quantity(text.toString());
      }
      case "vitamins-thiamin" -> {
        food.setVitamins_thiamin_quantity(text.toString());
      }
      case "category" -> {
        food.addCategory(category);
      }
      case "category-id" -> {
        category.setCategoryId(text.toString());
      }
      case "category-name" -> {
        category.setCategoryName(text.toString());
      }
    }
  }
}
