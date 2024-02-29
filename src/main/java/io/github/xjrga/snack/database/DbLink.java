package io.github.xjrga.snack.database;

import io.github.xjrga.snack.dataobject.FoodDataObject;
import io.github.xjrga.snack.dataobject.FoodFactSelectForCheckCoefficientsDataObject;
import io.github.xjrga.snack.dataobject.FoodFactSelectForDataInputDataObject;
import io.github.xjrga.snack.dataobject.MixFoodFactCoefficient;
import io.github.xjrga.snack.sql.Allocate;
import io.github.xjrga.snack.sql.CalculateRemainingPercentage;
import io.github.xjrga.snack.sql.CategoryLinkCount;
import io.github.xjrga.snack.sql.CategoryLinkDelete;
import io.github.xjrga.snack.sql.CategoryLinkInsert;
import io.github.xjrga.snack.sql.DuplicateFoodItem;
import io.github.xjrga.snack.sql.ElectrolyteRatioDifference;
import io.github.xjrga.snack.sql.EssentialFatsDifference;
import io.github.xjrga.snack.sql.FoodCategoryDelete;
import io.github.xjrga.snack.sql.FoodCategoryInsert;
import io.github.xjrga.snack.sql.FoodCategoryInsert2;
import io.github.xjrga.snack.sql.FoodCategorySelectAll;
import io.github.xjrga.snack.sql.FoodCategoryUpdate;
import io.github.xjrga.snack.sql.FoodDelete;
import io.github.xjrga.snack.sql.FoodDifferences;
import io.github.xjrga.snack.sql.FoodExport;
import io.github.xjrga.snack.sql.FoodFactCalculatedQuantitiesUpdate;
import io.github.xjrga.snack.sql.FoodFactMerge;
import io.github.xjrga.snack.sql.FoodFactSelectCheckCoefficients;
import io.github.xjrga.snack.sql.FoodFactSelectDataInput;
import io.github.xjrga.snack.sql.FoodFq;
import io.github.xjrga.snack.sql.FoodInsertTemp;
import io.github.xjrga.snack.sql.FoodNutrientConstraintDelete;
import io.github.xjrga.snack.sql.FoodNutrientConstraintMerge;
import io.github.xjrga.snack.sql.FoodNutrientConstraintSelect;
import io.github.xjrga.snack.sql.FoodNutrientLhs;
import io.github.xjrga.snack.sql.FoodNutrientRatioDelete;
import io.github.xjrga.snack.sql.FoodNutrientRatioLhs;
import io.github.xjrga.snack.sql.FoodNutrientRatioMerge;
import io.github.xjrga.snack.sql.FoodNutrientRatioRhs;
import io.github.xjrga.snack.sql.FoodNutrientRatioSelect;
import io.github.xjrga.snack.sql.FoodNutrientRhs;
import io.github.xjrga.snack.sql.FoodPut;
import io.github.xjrga.snack.sql.FoodQuotientDifferences;
import io.github.xjrga.snack.sql.FoodSelect;
import io.github.xjrga.snack.sql.FoodSelectAll;
import io.github.xjrga.snack.sql.FoodSelectAll2;
import io.github.xjrga.snack.sql.FoodSelectAllLike;
import io.github.xjrga.snack.sql.FoodSelectByCategory;
import io.github.xjrga.snack.sql.FoodSelectDetails;
import io.github.xjrga.snack.sql.FoodStatistics;
import io.github.xjrga.snack.sql.FoodUpdate;
import io.github.xjrga.snack.sql.GetMixCoefficients;
import io.github.xjrga.snack.sql.GlycemicIndexMerge;
import io.github.xjrga.snack.sql.GlycemicIndexSelect;
import io.github.xjrga.snack.sql.MealDelete;
import io.github.xjrga.snack.sql.MealFoodPortionDelete;
import io.github.xjrga.snack.sql.MealFoodPortionInsert;
import io.github.xjrga.snack.sql.MealFoodPortionInsertAndCalculate;
import io.github.xjrga.snack.sql.MealFoodPortionUpdateActualWt;
import io.github.xjrga.snack.sql.MealFoodPortionUpdatePct;
import io.github.xjrga.snack.sql.MealGIDifferences;
import io.github.xjrga.snack.sql.MealInsert;
import io.github.xjrga.snack.sql.MealInsert02;
import io.github.xjrga.snack.sql.MealPortionSelectAll;
import io.github.xjrga.snack.sql.MealSelectAll;
import io.github.xjrga.snack.sql.MealUpdate;
import io.github.xjrga.snack.sql.MixCostMerge;
import io.github.xjrga.snack.sql.MixDelete;
import io.github.xjrga.snack.sql.MixDifferences;
import io.github.xjrga.snack.sql.MixDuplicate;
import io.github.xjrga.snack.sql.MixExport;
import io.github.xjrga.snack.sql.MixFoodDelete;
import io.github.xjrga.snack.sql.MixFoodInsert;
import io.github.xjrga.snack.sql.MixFoodSelect;
import io.github.xjrga.snack.sql.MixFoodSelectAllByFoodid;
import io.github.xjrga.snack.sql.MixFoodSelectAllByName;
import io.github.xjrga.snack.sql.MixFoodUpdate;
import io.github.xjrga.snack.sql.MixGetMealGi;
import io.github.xjrga.snack.sql.MixInsert;
import io.github.xjrga.snack.sql.MixResultSelect;
import io.github.xjrga.snack.sql.MixResultSelectPct;
import io.github.xjrga.snack.sql.MixSelectAll;
import io.github.xjrga.snack.sql.MixUpdateName;
import io.github.xjrga.snack.sql.MixUpdateNutrientId;
import io.github.xjrga.snack.sql.MixUpdateOther;
import io.github.xjrga.snack.sql.MufaRatioDifference;
import io.github.xjrga.snack.sql.NutrientConstraintDelete;
import io.github.xjrga.snack.sql.NutrientConstraintMerge;
import io.github.xjrga.snack.sql.NutrientConstraintSelect;
import io.github.xjrga.snack.sql.NutrientLhs;
import io.github.xjrga.snack.sql.NutrientLookup;
import io.github.xjrga.snack.sql.NutrientRatioDelete;
import io.github.xjrga.snack.sql.NutrientRatioLhs;
import io.github.xjrga.snack.sql.NutrientRatioMerge;
import io.github.xjrga.snack.sql.NutrientRatioRhs;
import io.github.xjrga.snack.sql.NutrientRatioSelect;
import io.github.xjrga.snack.sql.NutrientRhs;
import io.github.xjrga.snack.sql.NutrientSelectAll;
import io.github.xjrga.snack.sql.NutrientSelectAllVisible;
import io.github.xjrga.snack.sql.NutrientToPctSelect;
import io.github.xjrga.snack.sql.NutrientUpdate;
import io.github.xjrga.snack.sql.ObjectiveLhs;
import io.github.xjrga.snack.sql.PercentNutrientConstraintDelete;
import io.github.xjrga.snack.sql.PercentNutrientConstraintMerge;
import io.github.xjrga.snack.sql.PercentNutrientConstraintSelect;
import io.github.xjrga.snack.sql.PercentNutrientLhs;
import io.github.xjrga.snack.sql.PercentNutrientRhs;
import io.github.xjrga.snack.sql.PinMix;
import io.github.xjrga.snack.sql.PufaRatioDifference;
import io.github.xjrga.snack.sql.RdaDifferences;
import io.github.xjrga.snack.sql.RdaLifeStageSelectAll;
import io.github.xjrga.snack.sql.RelationshipSelectAll;
import io.github.xjrga.snack.sql.ResultsByMealSelect;
import io.github.xjrga.snack.sql.Shutdown;
import io.github.xjrga.snack.sql.SnackFoodInsert;
import io.github.xjrga.snack.sql.SnackMixInsertMix;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class DbLink {
  private final Connection connection;

  public DbLink() {
    connection = Connect.getInstance().getConnection();
  }

  public List<Map<String, Object>> Food_Select_All() {
    return (new FoodSelectAll()).execute();
  }

  public List<Map<String, Object>> Food_Select_All_2() {
    return (new FoodSelectAll2()).execute();
  }

  public List<Map<String, Object>> Nutrient_Select_All() {
    return (new NutrientSelectAll()).execute();
  }

  public List<Map<String, Object>> Nutrient_To_Pct_Select() throws SQLException {
    return (new NutrientToPctSelect()).execute();
  }

  public List<Map<String, Object>> Nutrient_Select_All_Visible() throws SQLException {
    return (new NutrientSelectAllVisible()).execute();
  }

  public List<Map<String, Object>> RdaLifeStage_Select_All() throws SQLException {
    return (new RdaLifeStageSelectAll()).execute();
  }

  public List<Map<String, Object>> Meal_Select_All(String mixid) throws SQLException {
    return (new MealSelectAll()).execute(mixid);
  }

  public List<Map<String, Object>> results_by_meal_select(String mixid, Integer precision)
      throws SQLException {
    return (new ResultsByMealSelect()).execute(mixid, precision);
  }

  public Double calculate_remaining_percentage(String mixid, String foodid, Integer precision)
      throws SQLException {
    return (new CalculateRemainingPercentage()).execute(mixid, foodid, precision);
  }

  public void MealFoodPortion_update_pct(String mixid, Integer mealid, String foodid, Double pct)
      throws SQLException {
    (new MealFoodPortionUpdatePct()).execute(mixid, mealid, foodid, pct);
  }

  public void MealFoodPortion_update_actualwt(
      String mixid, Integer mealid, String foodid, Double actualwt) throws SQLException {
    (new MealFoodPortionUpdateActualWt()).execute(mixid, mealid, foodid, actualwt);
  }

  public void MealFoodPortion_delete(String mixid, Integer mealid, String foodid)
      throws SQLException {
    (new MealFoodPortionDelete()).execute(mixid, mealid, foodid);
  }

  public void MealFoodPortion_insert_and_calculate(
      String mixid, Integer mealid, String foodid, Double pct) throws SQLException {
    (new MealFoodPortionInsertAndCalculate()).execute(mixid, mealid, foodid, pct);
  }

  public void MealFoodPortion_insert(
      String mixid, Integer mealid, String foodid, Double pct, Double expectedwt, Double actualwt) {
    (new MealFoodPortionInsert()).execute(mixid, mealid, foodid, pct, expectedwt, actualwt);
  }

  public List<Map<String, Object>> MealFoodPortion_select_all(String mixid, Integer precision)
      throws SQLException {
    return (new MealPortionSelectAll()).execute(mixid, precision);
  }

  public List<Map<String, Object>> Relationship_Select_All() throws SQLException {
    return (new RelationshipSelectAll()).execute();
  }

  public List<Map<String, Object>> Mix_Select_All() throws SQLException {
    return (new MixSelectAll()).execute();
  }

  public String Mix_Insert(String name) throws SQLException {
    return (new MixInsert()).execute(name);
  }

  public boolean snack_mix_insertmix(String mixid, String name, String nutrientid, String model) {
    return (Boolean) (new SnackMixInsertMix()).execute(mixid, name, nutrientid, model);
  }

  public void MixFood_Insert(String mixid, String foodid) {
    (new MixFoodInsert()).execute(mixid, foodid);
  }

  public List<Map<String, String>> MixFood_Select_All_By_Foodid(String mixid) throws SQLException {
    return (new MixFoodSelectAllByFoodid()).execute(mixid);
  }

  public List<Map<String, Object>> MixFood_Select_All_By_Name(String mixid) throws SQLException {
    return (new MixFoodSelectAllByName()).execute(mixid);
  }

  public void MixFood_Delete(String mixid, String foodid) throws SQLException {
    (new MixFoodDelete()).execute(mixid, foodid);
  }

  public void Mix_Delete(String mixid) throws SQLException {
    (new MixDelete()).execute(mixid);
  }

  public void NutrientConstraint_Merge(
      String mixid, String nutrientid, Integer relationshipid, Double b) {
    (new NutrientConstraintMerge()).execute(mixid, nutrientid, relationshipid, b);
  }

  public void GlycemicIndex_Merge(String FoodId, Double gi) {
    (new GlycemicIndexMerge()).execute(FoodId, gi);
  }

  public void foodfact_calculated_quantities_update(String foodid) {
    (new FoodFactCalculatedQuantitiesUpdate()).execute(foodid);
  }

  public List<Map<String, Object>> GlycemicIndex_Select(String foodid) throws SQLException {
    return (new GlycemicIndexSelect()).execute(foodid);
  }

  public List<Map<String, Object>> NutrientConstraint_Select(String mixid) throws SQLException {
    return (new NutrientConstraintSelect()).execute(mixid);
  }

  public void NutrientConstraint_Delete(String mixid, String nutrientid, Integer relationshipid)
      throws SQLException {
    (new NutrientConstraintDelete()).execute(mixid, nutrientid, relationshipid);
  }

  public void FoodNutrientConstraint_Merge(
      String mixid, String foodid, String nutrientid, Integer relationshipid, Double b) {
    (new FoodNutrientConstraintMerge()).execute(mixid, foodid, nutrientid, relationshipid, b);
  }

  public List<Map<String, Object>> FoodNutrientConstraint_Select(String mixid) throws SQLException {
    return (new FoodNutrientConstraintSelect()).execute(mixid);
  }

  public void Meal_insert(String mixid, String name, Integer order) throws SQLException {
    (new MealInsert()).execute(mixid, name, order);
  }

  public void Meal_insert_02(String mixid, Integer mealid, String name, Integer order) {
    (new MealInsert02()).execute(mixid, mealid, name, order);
  }

  public void Meal_delete(String mixid, Integer mealid) throws SQLException {
    (new MealDelete()).execute(mixid, mealid);
  }

  public void Meal_update(String mixid, Integer mealid, String name, Integer order)
      throws SQLException {
    (new MealUpdate()).execute(mixid, mealid, name, order);
  }

  public void FoodNutrientConstraint_Delete(
      String mixid, String foodid, String nutrientid, Integer relationtionshipid)
      throws SQLException {
    (new FoodNutrientConstraintDelete()).execute(mixid, foodid, nutrientid, relationtionshipid);
  }

  public List<Map<String, Object>> NutrientRatio_Select(String mixid) throws SQLException {
    return (new NutrientRatioSelect()).execute(mixid);
  }

  public void NutrientRatio_Merge(
      String mixid,
      String nutrientid1,
      String nutrientid2,
      Integer relationshipid,
      Double A,
      Double B) {
    (new NutrientRatioMerge()).execute(mixid, nutrientid1, nutrientid2, relationshipid, A, B);
  }

  public void NutrientRatio_Delete(
      String mixid, String nutrientid1, String nutrientid2, Integer relationshipid)
      throws SQLException {
    (new NutrientRatioDelete()).execute(mixid, nutrientid1, nutrientid2, relationshipid);
  }

  public void FoodNutrientRatio_Merge(
      String mixid,
      String foodid1,
      String nutrientid1,
      String foodid2,
      String nutrientid2,
      Integer relationshipid,
      Double A,
      Double B) {
    (new FoodNutrientRatioMerge())
        .execute(mixid, foodid1, nutrientid1, foodid2, nutrientid2, relationshipid, A, B);
  }

  public List<Map<String, Object>> FoodNutrientRatio_Select(String mixid) throws SQLException {
    return (new FoodNutrientRatioSelect()).execute(mixid);
  }

  public void FoodNutrientRatio_Delete(
      String mixid,
      String foodid1,
      String nutrientid1,
      String foodid2,
      String nutrientid2,
      Integer relationshipid)
      throws SQLException {
    (new FoodNutrientRatioDelete())
        .execute(mixid, foodid1, nutrientid1, foodid2, nutrientid2, relationshipid);
  }

  public double[] objective_lhs(String MixId) throws SQLException {
    return (new ObjectiveLhs()).execute(MixId);
  }

  public List nutrient_rhs(String mixid) throws SQLException {
    return (new NutrientRhs()).execute(mixid);
  }

  public double[] nutrient_lhs(String mixid, String nutrientid, Integer relationshipid)
      throws SQLException {
    return (new NutrientLhs()).execute(mixid, nutrientid, relationshipid);
  }

  public List foodnutrient_rhs(String mixid) throws SQLException {
    return (new FoodNutrientRhs()).execute(mixid);
  }

  public double[] foodnutrient_lhs(
      String mixid, String foodid, String nutrientid, Integer relationshipid) throws SQLException {
    return (new FoodNutrientLhs()).execute(mixid, foodid, nutrientid, relationshipid);
  }

  public List foodnutrientratio_rhs(String mixid) throws SQLException {
    return (new FoodNutrientRatioRhs()).execute(mixid);
  }

  public double[] foodnutrientratio_lhs(
      String mixid,
      String foodid1,
      String nutrientid1,
      String foodid2,
      String nutrientid2,
      Integer relationshipid)
      throws SQLException {
    return (new FoodNutrientRatioLhs())
        .execute(mixid, foodid1, nutrientid1, foodid2, nutrientid2, relationshipid);
  }

  public List nutrientratio_rhs(String mixid) throws SQLException {
    return (new NutrientRatioRhs()).execute(mixid);
  }

  public double[] nutrientratio_lhs(
      String mixid, String nutrientid1, String nutrientid2, Integer relationshipid)
      throws SQLException {
    return (new NutrientRatioLhs()).execute(mixid, nutrientid1, nutrientid2, relationshipid);
  }

  public List<Map<String, Object>> MixFood_Select(String mixid) throws SQLException {
    return (new MixFoodSelect()).execute(mixid);
  }

  public void MixFood_Update(String mixid, String foodid, Double x) throws SQLException {
    (new MixFoodUpdate()).execute(mixid, foodid, x);
  }

  public void Mix_Update_Name(String MixId, String Name) throws SQLException {
    (new MixUpdateName()).execute(MixId, Name);
  }

  public void Mix_Update_NutrientId(String mixid, String nutrientid) throws SQLException {
    (new MixUpdateNutrientId()).execute(mixid, nutrientid);
  }

  public void Mix_Update_Other(String mixid, String model) throws SQLException {
    (new MixUpdateOther()).execute(mixid, model);
  }

  public List<Map<String, Object>> MixResult_Select(String mixid, Integer precision)
      throws SQLException {
    return (new MixResultSelect()).execute(mixid, precision);
  }

  public List<Map<String, Object>> Food_Select_Details(Integer precision) throws SQLException {
    return (new FoodSelectDetails()).execute(precision);
  }

  public List<Map<String, Object>> FoodCategory_Select_All() throws SQLException {
    return (new FoodCategorySelectAll()).execute();
  }

  public List<Map<String, Object>> Food_Select_By_Category(String FoodCategoryId)
      throws SQLException {
    return (new FoodSelectByCategory()).execute(FoodCategoryId);
  }

  public void FoodCategory_Insert(String categoryid, String categoryname) {
    (new FoodCategoryInsert()).execute(categoryid, categoryname);
  }

  public void FoodCategory_Insert_2(String categoryname) throws SQLException {
    (new FoodCategoryInsert2()).execute(categoryname);
  }

  public void FoodCategory_Delete(String categoryid) throws SQLException {
    (new FoodCategoryDelete()).execute(categoryid);
  }

  public void FoodCategory_Update(String categoryid, String categoryname) throws SQLException {
    (new FoodCategoryUpdate()).execute(categoryid, categoryname);
  }

  public void CategoryLink_Insert(String categoryid, String foodid) {
    (new CategoryLinkInsert()).execute(categoryid, foodid);
  }

  public void CategoryLink_Delete(String categoryid, String foodid) throws SQLException {
    (new CategoryLinkDelete()).execute(categoryid, foodid);
  }

  public void Food_Delete(String foodid) throws SQLException {
    (new FoodDelete()).execute(foodid);
  }

  public List<Map<String, Object>> MixResult_Select_Pct(String mixid, Integer precision)
      throws SQLException {
    return (new MixResultSelectPct()).execute(mixid, precision);
  }

  public List<Map<String, Object>> get_food_statistics(String foodid) throws SQLException {
    return (new FoodStatistics()).execute(foodid);
  }

  public void Mix_Duplicate(String mixid) throws SQLException {
    (new MixDuplicate()).execute(mixid);
  }

  public List<Map<String, Object>> get_food_differences(
      String foodida, String foodidb, Integer precision) throws SQLException {
    return (new FoodDifferences()).execute(foodida, foodidb, precision);
  }

  public List<Map<String, Object>> Mix_GetDiff(String mixid1, String mixid2, Integer precision)
      throws SQLException {
    LinkedList<Map<String, Object>> list = new LinkedList<>();
    return (new MixDifferences()).execute(mixid1, mixid2, precision);
  }

  public List<Map<String, Object>> Mix_GetRdaDiff(
      String mixid, Integer lifestage, Integer precision) throws SQLException {
    return (new RdaDifferences()).execute(mixid, lifestage, precision);
  }

  public List<Map<String, Object>> Mix_GetFQDiff(String mixid1, String mixid2) throws SQLException {
    return (new FoodQuotientDifferences()).execute(mixid1, mixid2);
  }

  public List<Map<String, Object>> Mix_GetMealGIDiff(
      String mixid1, String mixid2, Integer precision) throws SQLException {
    return (new MealGIDifferences()).execute(mixid1, mixid2, precision);
  }

  public List<Map<String, Object>> Mix_get_essential_fat_ratio_diff(
      String mixid1, String mixid2, Integer precision) throws SQLException {
    return (new EssentialFatsDifference()).execute(mixid1, mixid2, precision);
  }

  public List<Map<String, Object>> Mix_get_electrolyte_ratio_diff(
      String mixid1, String mixid2, Integer precision) throws SQLException {
    return (new ElectrolyteRatioDifference()).execute(mixid1, mixid2, precision);
  }

  public List<Map<String, Object>> Mix_get_polyufat_ratio_diff(
      String mixid1, String mixid2, Integer precision) throws SQLException {
    return (new PufaRatioDifference()).execute(mixid1, mixid2, precision);
  }

  public List<Map<String, Object>> Mix_get_monoufat_ratio_diff(
      String mixid1, String mixid2, Integer precision) throws SQLException {
    return (new MufaRatioDifference()).execute(mixid1, mixid2, precision);
  }

  public List<Map<String, Object>> Nutrient_Lookup_List(
      String nutrientid, Double value, Integer precision) throws SQLException {
    return (new NutrientLookup()).execute(nutrientid, value, precision);
  }

  public void Food_Put(String mixid) throws SQLException {
    (new FoodPut()).execute(mixid);
  }

  public Integer CategoryLink_Count(String FoodId, String FoodCategoryId) throws SQLException {
    return (new CategoryLinkCount()).execute(FoodId, FoodCategoryId);
  }

  public List<Map<String, Object>> Food_Select_All_Like(String txt) throws SQLException {
    return (new FoodSelectAllLike()).execute(txt);
  }

  public void PercentNutrientConstraint_Merge(
      String mixId, String foodid, String nutrno, Integer relationshipid, Double b) {
    (new PercentNutrientConstraintMerge()).execute(mixId, foodid, nutrno, relationshipid, b);
  }

  public void PercentNutrientConstraint_Delete(
      String mixid, String foodid, String nutrientid, Integer relationshipid) throws SQLException {
    (new PercentNutrientConstraintDelete()).execute(mixid, foodid, nutrientid, relationshipid);
  }

  public List<Map<String, Object>> PercentNutrientConstraint_Select(String mixid)
      throws SQLException {
    return (new PercentNutrientConstraintSelect()).execute(mixid);
  }

  public List percentnutrient_rhs(String mixid) throws SQLException {
    return (new PercentNutrientRhs()).execute(mixid);
  }

  public double[] percentnutrient_lhs(String mixid, String foodid, String nutrientid, Double b)
      throws SQLException {
    return (new PercentNutrientLhs()).execute(mixid, foodid, nutrientid, b);
  }

  public void Nutrient_Update(String nutrientid, Integer visible) throws SQLException {
    (new NutrientUpdate()).execute(nutrientid, visible);
  }

  public String Food_Insert_Temp(String foodname) throws SQLException {
    return (new FoodInsertTemp()).execute(foodname);
  }

  public boolean snack_food_insertfood(String foodid, String foodname) {
    return (Boolean) (new SnackFoodInsert()).execute(foodid, foodname);
  }

  public void Food_Update(FoodDataObject foodDataObject) throws SQLException {
    (new FoodUpdate()).execute(foodDataObject);
  }

  public List<FoodDataObject> Food_Select(FoodDataObject foodDataObject) throws SQLException {
    return (new FoodSelect()).execute(foodDataObject);
  }

  public List<FoodFactSelectForDataInputDataObject> FoodFact_Select_ForDataInput(
      String foodid, Integer precision) throws SQLException {
    return (new FoodFactSelectDataInput()).execute(foodid, precision);
  }

  public List<FoodFactSelectForCheckCoefficientsDataObject> FoodFact_Select_ForCheckCoefficients(
      String foodid, Integer precision) throws SQLException {
    return (new FoodFactSelectCheckCoefficients()).execute(foodid, precision);
  }

  public void FoodFact_Merge(String foodid, String nutrientid, Double q) {
    (new FoodFactMerge()).execute(foodid, nutrientid, q);
  }

  public void DuplicateFoodItem(String foodid) throws SQLException {
    (new DuplicateFoodItem()).execute(foodid);
  }

  public Double get_food_fq(String foodid) throws SQLException {
    return (new FoodFq()).execute(foodid);
  }

  public String export_food(String foodid) throws SQLException {
    return (new FoodExport()).execute(foodid);
  }

  public List Mix_GetMealGi(String mixid, Integer precision) throws SQLException {
    return (new MixGetMealGi()).execute(mixid, precision);
  }

  public void MixCost_Merge(String mixid, double cost) throws SQLException {
    (new MixCostMerge()).execute(mixid, cost);
  }

  public String export_mix(String mixid) throws SQLException {
    return (new MixExport()).execute(mixid);
  }

  public void pin_mix(String mixid) throws SQLException {
    (new PinMix()).execute(mixid);
  }

  public void allocate(String mixid) throws SQLException {
    (new Allocate()).execute(mixid);
  }

  public List<MixFoodFactCoefficient> getMixCoefficients(String mixid) throws SQLException {
    return (new GetMixCoefficients()).execute(mixid);
  }

  public void shutdown() {
    (new Shutdown()).execute();
  }
}
