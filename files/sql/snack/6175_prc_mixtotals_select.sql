CREATE PROCEDURE MixTotals (
--
IN v_MixId LONGVARCHAR
--
)
--
MODIFIES SQL DATA
DYNAMIC RESULT SETS 1 
BEGIN ATOMIC
--
DECLARE result CURSOR
FOR
--
SELECT a.mix_id AS id,
       b.name AS name,
       now() AS date,
       SUM(other_weight) AS other_weight,
       SUM(energy_gross) AS energy_gross,
       SUM(energy_digestible) AS energy_digestible,
       SUM(energy_fat) AS energy_fat,
       SUM(energy_carbohydrate) AS energy_carbohydrate,
       SUM(energy_fat_and_carbohydrate) AS energy_fat_and_carbohydrate,
       SUM(energy_protein) AS energy_protein,
       SUM(energy_alcohol) AS energy_alcohol,
       SUM(fats_total) AS fats_total,
       SUM(carbohydrates_digestible) AS carbohydrates_digestible,
       SUM(protein_total) AS protein_total,
       SUM(other_alcohol) AS other_alcohol,
       SUM(energy_protein) AS energy_protein,
       SUM(protein_total) AS protein_total,
       SUM(protein_complete) AS protein_complete,
       SUM(energy_fat) AS energy_fat,
       SUM(fats_total) AS fats_total,
       SUM(fats_monounsaturated) AS fats_monounsaturated,
       SUM(fats_polyunsaturated) AS fats_polyunsaturated,
       SUM(fats_saturated) AS fats_saturated,
       SUM(fats_cholesterol) AS fats_cholesterol,
       SUM(fats_saturated) AS fats_saturated,
       SUM(fats_hcsfa) AS fats_hcsfa,
       SUM(fats_lauric) AS fats_lauric,
       SUM(fats_myristic) AS fats_myristic,
       SUM(fats_palmitic) AS fats_palmitic,
       SUM(fats_stearic) AS fats_stearic,
       SUM(fats_polyunsaturated) AS fats_polyunsaturated,
       SUM(fats_linoleic) AS fats_linoleic,
       SUM(fats_linolenic) AS fats_linolenic,
       SUM(fats_epa) AS fats_epa,
       SUM(fats_dha) AS fats_dha,
       SUM(fats_lcn3pufa) AS fats_lcn3pufa,
       SUM(energy_carbohydrate) AS energy_carbohydrate,
       SUM(carbohydrates_carbs_by_diff) AS carbohydrates_carbs_by_diff,
       SUM(carbohydrates_fiber) AS carbohydrates_fiber,
       SUM(carbohydrates_fiber_insoluble) AS carbohydrates_fiber_insoluble,
       SUM(carbohydrates_fiber_soluble) AS carbohydrates_fiber_soluble,
       SUM(carbohydrates_digestible) AS carbohydrates_digestible,
       SUM(carbohydrates_starch) AS carbohydrates_starch,
       SUM(carbohydrates_sugars) AS carbohydrates_sugars,
       SUM(carbohydrates_sucrose) AS carbohydrates_sucrose,
       SUM(carbohydrates_lactose) AS carbohydrates_lactose,
       SUM(carbohydrates_fructose) AS carbohydrates_fructose,
       SUM(carbohydrates_glucose) AS carbohydrates_glucose,
       SUM(carbohydrates_glycemic_load) AS carbohydrates_glycemic_load,
       SUM(vitamins_vitamin_a) AS vitamins_vitamin_a,
       SUM(vitamins_vitamin_d) AS vitamins_vitamin_d,
       SUM(vitamins_vitamin_e) AS vitamins_vitamin_e,
       SUM(vitamins_vitamin_c) AS vitamins_vitamin_c,
       SUM(vitamins_thiamin) AS vitamins_thiamin,
       SUM(vitamins_riboflavin) AS vitamins_riboflavin,
       SUM(vitamins_niacin) AS vitamins_niacin,
       SUM(vitamins_vitamin_b6) AS vitamins_vitamin_b6,
       SUM(vitamins_folate) AS vitamins_folate,
       SUM(vitamins_vitamin_b12) AS vitamins_vitamin_b12,
       SUM(vitamins_vitamin_k) AS vitamins_vitamin_k,
       SUM(vitamins_pantothenic_acid) AS vitamins_pantothenic_acid,
       SUM(vitamins_choline) AS vitamins_choline,
       SUM(minerals_calcium) AS minerals_calcium,
       SUM(minerals_phosphorus) AS minerals_phosphorus,
       SUM(minerals_magnesium) AS minerals_magnesium,
       SUM(minerals_iron) AS minerals_iron,
       SUM(minerals_zinc) AS minerals_zinc,
       SUM(minerals_copper) AS minerals_copper,
       SUM(minerals_manganese) AS minerals_manganese,
       SUM(minerals_selenium) AS minerals_selenium,
       SUM(minerals_potassium) AS minerals_potassium,
       SUM(minerals_sodium) AS minerals_sodium,
       SUM(phytonutrients_flavonoids) AS phytonutrients_flavonoids,
       SUM(phytonutrients_anthocyanins) AS phytonutrients_anthocyanins,
       SUM(phytonutrients_carotenoids) AS phytonutrients_carotenoids,
       SUM(phytonutrients_flavanols) AS phytonutrients_flavanols,
       SUM(phytonutrients_flavanones) AS phytonutrients_flavanones,
       SUM(phytonutrients_flavones) AS phytonutrients_flavones,
       SUM(phytonutrients_flavonols) AS phytonutrients_flavonols,
       SUM(phytonutrients_isoflavones) AS phytonutrients_isoflavones,
       SUM(phytonutrients_phytosterols) AS phytonutrients_phytosterols,
       SUM(phytonutrients_beta_carotene) AS phytonutrients_beta_carotene,
       SUM(phytonutrients_lutein_zeaxanthin) AS phytonutrients_lutein_zeaxanthin,
       SUM(phytonutrients_lycopene) AS phytonutrients_lycopene,
       SUM(phytonutrients_caffeine) AS phytonutrients_caffeine,
       SUM(phytonutrients_theobromine) AS phytonutrients_theobromine,
       SUM(phytonutrients_gamma_tocopherol) AS phytonutrients_gamma_tocopherol,
       SUM(other_cost) AS other_cost,
       SUM(other_water) AS other_water
FROM DnMixResult a,
     mix b
WHERE a.mix_id = v_MixId
AND   a.mix_id = b.mixid
GROUP BY a.mix_id,
         b.name;
--
OPEN result;
--
END;
/
