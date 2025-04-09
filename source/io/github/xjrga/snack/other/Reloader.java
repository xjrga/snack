package io.github.xjrga.snack.other;

import io.github.xjrga.snack.other.FoodFactIndexer;
import java.util.List;
import static java.util.stream.Collectors.toList;

/**
 * @author jr
 */
public class Reloader {

  private static <T> List<T> getValueAt(List<T> list, List<Integer> indexes) {
    return indexes.stream().map(i -> list.get(i)).collect(toList());
  }

  public static List<List> getEnergy(List list) {
    FoodFactIndexer indexes = new FoodFactIndexer();
    indexes.setMixid();
    indexes.setFoodid();
    indexes.setFoodname();
    indexes.setOther_weight();
    indexes.setEnergy_gross();
    indexes.setEnergy_digestible();
    indexes.setEnergy_fat();
    indexes.setEnergy_carbohydrate();
    indexes.setEnergy_fat_and_carbohydrate();
    indexes.setEnergy_protein();
    indexes.setEnergy_alcohol();
    return (List) list.stream().map(o -> getValueAt((List) o, indexes.get())).collect(toList());
  }

  public static List<List> getMass(List list) {
    FoodFactIndexer indexes = new FoodFactIndexer();
    indexes.setMixid();
    indexes.setFoodid();
    indexes.setFoodname();
    indexes.setOther_weight();
    indexes.setFats_total();
    indexes.setCarbohydrates_digestible();
    indexes.setProtein_total();
    indexes.setOther_alcohol();
    return (List) list.stream().map(o -> getValueAt((List) o, indexes.get())).collect(toList());
  }

  public static List<List> getProtein(List list) {
    FoodFactIndexer indexes = new FoodFactIndexer();
    indexes.setMixid();
    indexes.setFoodid();
    indexes.setFoodname();
    indexes.setOther_weight();
    indexes.setEnergy_protein();
    indexes.setProtein_total();
    indexes.setProtein_complete();
    return (List) list.stream().map(o -> getValueAt((List) o, indexes.get())).collect(toList());
  }

  public static List<List> getFat(List list) {
    FoodFactIndexer indexes = new FoodFactIndexer();
    indexes.setMixid();
    indexes.setFoodid();
    indexes.setFoodname();
    indexes.setOther_weight();
    indexes.setEnergy_fat();
    indexes.setFats_total();
    indexes.setFats_monounsaturated();
    indexes.setFats_polyunsaturated();
    indexes.setFats_saturated();
    indexes.setFats_cholesterol();
    return (List) list.stream().map(o -> getValueAt((List) o, indexes.get())).collect(toList());
  }

  public static List<List> getSaturatedFat(List list) {
    FoodFactIndexer indexes = new FoodFactIndexer();
    indexes.setMixid();
    indexes.setFoodid();
    indexes.setFoodname();
    indexes.setOther_weight();
    indexes.setFats_saturated();
    indexes.setFats_hcsfa();
    indexes.setFats_lauric();
    indexes.setFats_myristic();
    indexes.setFats_palmitic();
    indexes.setFats_stearic();
    return (List) list.stream().map(o -> getValueAt((List) o, indexes.get())).collect(toList());
  }

  public static List<List> getPolyunsaturatedFat(List list) {
    FoodFactIndexer indexes = new FoodFactIndexer();
    indexes.setMixid();
    indexes.setFoodid();
    indexes.setFoodname();
    indexes.setOther_weight();
    indexes.setFats_polyunsaturated();
    indexes.setFats_linoleic();
    indexes.setFats_linolenic();
    indexes.setFats_epa();
    indexes.setFats_dha();
    indexes.setFats_lcn3pufa();
    return (List) list.stream().map(o -> getValueAt((List) o, indexes.get())).collect(toList());
  }

  public static List<List> getCarbohydrates(List list) {
    FoodFactIndexer indexes = new FoodFactIndexer();
    indexes.setMixid();
    indexes.setFoodid();
    indexes.setFoodname();
    indexes.setOther_weight();
    indexes.setEnergy_carbohydrate();
    indexes.setCarbohydrates_carbs_by_diff();
    indexes.setCarbohydrates_fiber();
    indexes.setCarbohydrates_fiber_insoluble();
    indexes.setCarbohydrates_fiber_soluble();
    indexes.setCarbohydrates_digestible();
    indexes.setCarbohydrates_starch();
    indexes.setCarbohydrates_sugars();
    indexes.setCarbohydrates_sucrose();
    indexes.setCarbohydrates_lactose();
    indexes.setCarbohydrates_fructose();
    indexes.setCarbohydrates_glucose();
    indexes.setCarbohydrates_glycemic_load();
    return (List) list.stream().map(o -> getValueAt((List) o, indexes.get())).collect(toList());
  }

  public static List<List> getVitamins(List list) {
    FoodFactIndexer indexes = new FoodFactIndexer();
    indexes.setMixid();
    indexes.setFoodid();
    indexes.setFoodname();
    indexes.setOther_weight();
    indexes.setVitamins_vitamin_a();
    indexes.setVitamins_vitamin_d();
    indexes.setVitamins_vitamin_e();
    indexes.setVitamins_vitamin_c();
    indexes.setVitamins_thiamin();
    indexes.setVitamins_riboflavin();
    indexes.setVitamins_niacin();
    indexes.setVitamins_vitamin_b6();
    indexes.setVitamins_folate();
    indexes.setVitamins_vitamin_b12();
    indexes.setVitamins_vitamin_k();
    indexes.setVitamins_pantothenic_acid();
    indexes.setVitamins_choline();
    return (List) list.stream().map(o -> getValueAt((List) o, indexes.get())).collect(toList());
  }

  public static List<List> getMinerals(List list) {
    FoodFactIndexer indexes = new FoodFactIndexer();
    indexes.setMixid();
    indexes.setFoodid();
    indexes.setFoodname();
    indexes.setOther_weight();
    indexes.setMinerals_calcium();
    indexes.setMinerals_phosphorus();
    indexes.setMinerals_magnesium();
    indexes.setMinerals_iron();
    indexes.setMinerals_zinc();
    indexes.setMinerals_copper();
    indexes.setMinerals_manganese();
    indexes.setMinerals_selenium();
    return (List) list.stream().map(o -> getValueAt((List) o, indexes.get())).collect(toList());
  }

  public static List<List> getElectrolytes(List list) {
    FoodFactIndexer indexes = new FoodFactIndexer();
    indexes.setMixid();
    indexes.setFoodid();
    indexes.setFoodname();
    indexes.setOther_weight();
    indexes.setOther_water();
    indexes.setMinerals_potassium();
    indexes.setMinerals_sodium();
    return (List) list.stream().map(o -> getValueAt((List) o, indexes.get())).collect(toList());
  }

  public static List<List> getPhytonutrients(List list) {
    FoodFactIndexer indexes = new FoodFactIndexer();
    indexes.setMixid();
    indexes.setFoodid();
    indexes.setFoodname();
    indexes.setOther_weight();
    indexes.setPhytonutrients_flavonoids();
    indexes.setPhytonutrients_anthocyanins();
    indexes.setPhytonutrients_carotenoids();
    indexes.setPhytonutrients_flavanols();
    indexes.setPhytonutrients_flavanones();
    indexes.setPhytonutrients_flavones();
    indexes.setPhytonutrients_flavonols();
    indexes.setPhytonutrients_isoflavones();
    indexes.setPhytonutrients_phytosterols();
    indexes.setPhytonutrients_beta_carotene();
    indexes.setPhytonutrients_lutein_zeaxanthin();
    indexes.setPhytonutrients_lycopene();
    indexes.setPhytonutrients_caffeine();
    indexes.setPhytonutrients_theobromine();
    return (List) list.stream().map(o -> getValueAt((List) o, indexes.get())).collect(toList());
  }

  public static List<List> getCost(List list) {
    FoodFactIndexer indexes = new FoodFactIndexer();
    indexes.setMixid();
    indexes.setFoodid();
    indexes.setFoodname();
    indexes.setOther_weight();
    indexes.setOther_cost();
    return (List) list.stream().map(o -> getValueAt((List) o, indexes.get())).collect(toList());
  }

  public static List<List> getMealPlanCalories(List list) {
    ResultsByMealIndexer indexes = new ResultsByMealIndexer();
    indexes.setName();
    indexes.setWeight();
    indexes.setEgross();
    indexes.setEdigest();
    indexes.setEfat();
    indexes.setEcarbs();
    indexes.setEfatcarbs();
    indexes.setEprotein();
    indexes.setEalcohol();
    return (List) list.stream().map(o -> getValueAt((List) o, indexes.get())).collect(toList());
  }

  public static List<List> getMealPlanMacronutrients(List list) {
    ResultsByMealIndexer indexes = new ResultsByMealIndexer();
    indexes.setName();
    indexes.setWeight();
    indexes.setFat();
    indexes.setCarbs();
    indexes.setProtein();
    indexes.setComplete();
    indexes.setAlcohol();
    indexes.setFiber();
    indexes.setSodium();
    indexes.setPotassium();
    return (List) list.stream().map(o -> getValueAt((List) o, indexes.get())).collect(toList());
  }
}
