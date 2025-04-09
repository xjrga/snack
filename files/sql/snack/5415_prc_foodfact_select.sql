CREATE PROCEDURE Food_Select_Details ()
--
MODIFIES SQL DATA DYNAMIC RESULT SETS 1 BEGIN ATOMIC
--
DECLARE result CURSOR
FOR
--
SELECT food_id,
       food_name,
       carbohydrates_carbs_by_diff,
       carbohydrates_fiber_insoluble,
       carbohydrates_fiber_soluble,
       carbohydrates_fiber,
       carbohydrates_fructose,
       carbohydrates_glucose,
       carbohydrates_glycemic_load,
       carbohydrates_lactose,
       carbohydrates_starch,
       carbohydrates_sucrose,
       carbohydrates_sugars,
       energy_gross,
       fats_cholesterol,
       fats_dha,
       fats_epa,
       fats_lauric,
       fats_linoleic,
       fats_linolenic,
       fats_monounsaturated,
       fats_myristic,
       fats_palmitic,
       fats_polyunsaturated,
       fats_saturated,
       fats_stearic,
       fats_total,
       minerals_calcium,
       minerals_copper,
       minerals_iron,
       minerals_magnesium,
       minerals_manganese,
       minerals_phosphorus,
       minerals_potassium,
       minerals_selenium,
       minerals_sodium,
       minerals_zinc,
       other_alcohol,
       other_cost,
       other_water,
       other_weight,
       phytonutrients_anthocyanins,
       phytonutrients_caffeine,
       phytonutrients_beta_carotene,
       phytonutrients_carotenoids,
       phytonutrients_flavanols,
       phytonutrients_flavanones,
       phytonutrients_flavones,
       phytonutrients_flavonoids,
       phytonutrients_flavonols,
       phytonutrients_isoflavones,
       phytonutrients_lutein_zeaxanthin,
       phytonutrients_lycopene,
       phytonutrients_phytosterols,
       phytonutrients_theobromine,
       protein_complete,
       protein_total,
       vitamins_vitamin_a,
       vitamins_vitamin_b12,
       vitamins_vitamin_b6,
       vitamins_vitamin_c,
       vitamins_choline,
       vitamins_vitamin_d,
       vitamins_vitamin_e,
       vitamins_folate,
       vitamins_vitamin_k,
       vitamins_niacin,
       vitamins_pantothenic_acid,
       vitamins_riboflavin,
       vitamins_thiamin,
       carbohydrates_digestible,
       energy_carbohydrate,
       energy_fat,
       energy_fat_and_carbohydrate,
       energy_protein,
       energy_alcohol,
       energy_digestible,
       fats_hcsfa,
       fats_lcn3pufa
FROM DnFoodFact;
--
OPEN result;
--
END;
/
