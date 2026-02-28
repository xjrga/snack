CREATE PROCEDURE MixResult_Select_Exp (
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
SELECT mix_id,
       food_id,
       food_name,
       carbohydrates_carbs_by_diff,
       carbohydrates_digestible,
       carbohydrates_fiber,
       carbohydrates_fiber_insoluble,
       carbohydrates_fiber_soluble,
       carbohydrates_fructose,
       carbohydrates_glucose,
       carbohydrates_glycemic_load,
       carbohydrates_lactose,
       carbohydrates_starch,
       carbohydrates_sucrose,
       carbohydrates_sugars,
       energy_alcohol,
       energy_carbohydrate,
       energy_dha,--
       energy_digestible,
       energy_epa,--
       energy_fat,
       energy_fat_and_carbohydrate,
       energy_gross,
       energy_hcsfa,--
       energy_lcn3pufa,--
       energy_linoleic,--
       energy_linolenic,--
       energy_monounsaturated,--
       energy_polyunsaturated,--
       energy_protein,
       energy_protein_and_carbohydrate,--
       energy_saturated,--
       fats_cholesterol,
       fats_dha,
       fats_epa,
       fats_hcsfa,
       fats_lauric,
       fats_lcn3pufa,
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
       phytonutrients_beta_carotene,
       phytonutrients_caffeine,
       phytonutrients_carotenoids,
       phytonutrients_flavanols,
       phytonutrients_flavanones,
       phytonutrients_flavones,
       phytonutrients_flavonoids,
       phytonutrients_flavonols,
       phytonutrients_gamma_tocopherol,
       phytonutrients_isoflavones,
       phytonutrients_lutein_zeaxanthin,
       phytonutrients_lycopene,
       phytonutrients_phytosterols,
       phytonutrients_theobromine,
       protein_complete,
       protein_total,
       vitamins_choline,
       vitamins_folate,
       vitamins_niacin,
       vitamins_pantothenic_acid,
       vitamins_riboflavin,
       vitamins_thiamin,
       vitamins_vitamin_a,
       vitamins_vitamin_b6,
       vitamins_vitamin_b12,
       vitamins_vitamin_c,
       vitamins_vitamin_d,
       vitamins_vitamin_e,
       vitamins_vitamin_k
FROM DnMixResult a,
     food b
WHERE a.mix_id = v_MixId
AND   a.food_id = b.foodid
UNION
SELECT a.mix_id,
       '',
       'Total',
       SUM(carbohydrates_carbs_by_diff),
       SUM(carbohydrates_digestible),
       SUM(carbohydrates_fiber),
       SUM(carbohydrates_fiber_insoluble),
       SUM(carbohydrates_fiber_soluble),
       SUM(carbohydrates_fructose),
       SUM(carbohydrates_glucose),
       SUM(carbohydrates_glycemic_load),
       SUM(carbohydrates_lactose),
       SUM(carbohydrates_starch),
       SUM(carbohydrates_sucrose),
       SUM(carbohydrates_sugars),
       SUM(energy_alcohol),
       SUM(energy_carbohydrate),
       SUM(energy_dha),--
       SUM(energy_digestible),
       SUM(energy_epa),--
       SUM(energy_fat),
       SUM(energy_fat_and_carbohydrate),
       SUM(energy_gross),
       SUM(energy_hcsfa),--
       SUM(energy_lcn3pufa),--
       SUM(energy_linoleic),--
       SUM(energy_linolenic),--
       SUM(energy_monounsaturated),--
       SUM(energy_polyunsaturated),--
       SUM(energy_protein),
       SUM(energy_protein_and_carbohydrate),--
       SUM(energy_saturated),--
       SUM(fats_cholesterol),
       SUM(fats_dha),
       SUM(fats_epa),
       SUM(fats_hcsfa),
       SUM(fats_lauric),
       SUM(fats_lcn3pufa),
       SUM(fats_linoleic),
       SUM(fats_linolenic),
       SUM(fats_monounsaturated),
       SUM(fats_myristic),
       SUM(fats_palmitic),
       SUM(fats_polyunsaturated),
       SUM(fats_saturated),
       SUM(fats_stearic),
       SUM(fats_total),
       SUM(minerals_calcium),
       SUM(minerals_copper),
       SUM(minerals_iron),
       SUM(minerals_magnesium),
       SUM(minerals_manganese),
       SUM(minerals_phosphorus),
       SUM(minerals_potassium),
       SUM(minerals_selenium),
       SUM(minerals_sodium),
       SUM(minerals_zinc),
       SUM(other_alcohol),
       SUM(other_cost),
       SUM(other_water),
       SUM(other_weight),
       SUM(phytonutrients_anthocyanins),
       SUM(phytonutrients_beta_carotene),
       SUM(phytonutrients_caffeine),
       SUM(phytonutrients_carotenoids),
       SUM(phytonutrients_flavanols),
       SUM(phytonutrients_flavanones),
       SUM(phytonutrients_flavones),
       SUM(phytonutrients_flavonoids),
       SUM(phytonutrients_flavonols),
       SUM(phytonutrients_gamma_tocopherol),
       SUM(phytonutrients_isoflavones),
       SUM(phytonutrients_lutein_zeaxanthin),
       SUM(phytonutrients_lycopene),
       SUM(phytonutrients_phytosterols),
       SUM(phytonutrients_theobromine),
       SUM(protein_complete),
       SUM(protein_total),
       SUM(vitamins_choline),
       SUM(vitamins_folate),
       SUM(vitamins_niacin),
       SUM(vitamins_pantothenic_acid),
       SUM(vitamins_riboflavin),
       SUM(vitamins_thiamin),
       SUM(vitamins_vitamin_a),
       SUM(vitamins_vitamin_b6),
       SUM(vitamins_vitamin_b12),
       SUM(vitamins_vitamin_c),
       SUM(vitamins_vitamin_d),
       SUM(vitamins_vitamin_e),
       SUM(vitamins_vitamin_k)
FROM DnMixResult a,
     food b
WHERE a.mix_id = v_MixId
AND   a.food_id = b.foodid
GROUP BY a.mix_id
ORDER BY energy_digestible,
         food_id DESC;
--
OPEN result;

END;
/
