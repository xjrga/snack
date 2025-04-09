CREATE PROCEDURE fill_DnMixResult (
--
IN v_MixId LONGVARCHAR
--
)
--
MODIFIES SQL DATA DYNAMIC RESULT SETS 1
--
BEGIN ATOMIC
--
INSERT INTO DnMixResult
(
mix_id,
food_id,
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
)
SELECT 
a.mixid,
a.foodid,
b.food_name,
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
FROM (SELECT 
x0.Mixid,
x0.Foodid,
x205.q AS carbohydrates_carbs_by_diff,
x10018.q AS carbohydrates_fiber_insoluble,
x10017.q AS carbohydrates_fiber_soluble,
x291.q AS carbohydrates_fiber,
x212.q AS carbohydrates_fructose,
x211.q AS carbohydrates_glucose,
x10006.q AS carbohydrates_glycemic_load,
x213.q AS carbohydrates_lactose,
x209.q AS carbohydrates_starch,
x210.q AS carbohydrates_sucrose,
x269.q AS carbohydrates_sugars,
x208.q AS energy_gross,
x601.q AS fats_cholesterol,
x621.q AS fats_dha,
x629.q AS fats_epa,
x611.q AS fats_lauric,
x618.q AS fats_linoleic,
x619.q AS fats_linolenic,
x645.q AS fats_monounsaturated,
x612.q AS fats_myristic,
x613.q AS fats_palmitic,
x646.q AS fats_polyunsaturated,
x606.q AS fats_saturated,
x614.q AS fats_stearic,
x204.q AS fats_total,
x301.q AS minerals_calcium,
x312.q AS minerals_copper,
x303.q AS minerals_iron,
x304.q AS minerals_magnesium,
x315.q AS minerals_manganese,
x305.q AS minerals_phosphorus,
x306.q AS minerals_potassium,
x317.q AS minerals_selenium,
x307.q AS minerals_sodium,
x309.q AS minerals_zinc,
x221.q AS other_alcohol,
x10005.q AS other_cost,
x255.q AS other_water,
x10000.q AS other_weight,
x10024.q AS phytonutrients_anthocyanins,
x262.q AS phytonutrients_caffeine,
x321.q AS phytonutrients_beta_carotene,
x10019.q AS phytonutrients_carotenoids,
x10022.q AS phytonutrients_flavanols,
x10023.q AS phytonutrients_flavanones,
x10021.q AS phytonutrients_flavones,
x10026.q AS phytonutrients_flavonoids,
x10020.q AS phytonutrients_flavonols,
x10025.q AS phytonutrients_isoflavones,
x338.q AS phytonutrients_lutein_zeaxanthin,
x337.q AS phytonutrients_lycopene,
x636.q AS phytonutrients_phytosterols,
x263.q AS phytonutrients_theobromine,
x10001.q AS protein_complete,
x203.q AS protein_total,
x320.q AS vitamins_vitamin_a,
x418.q AS vitamins_vitamin_b12,
x415.q AS vitamins_vitamin_b6,
x401.q AS vitamins_vitamin_c,
x421.q AS vitamins_choline,
x328.q AS vitamins_vitamin_d,
x323.q AS vitamins_vitamin_e,
x435.q AS vitamins_folate,
x430.q AS vitamins_vitamin_k,
x406.q AS vitamins_niacin,
x410.q AS vitamins_pantothenic_acid,
x405.q AS vitamins_riboflavin,
x404.q AS vitamins_thiamin,
x10003.q AS carbohydrates_digestible,
x10011.q AS energy_carbohydrate,
x10013.q AS energy_fat,
x10010.q AS energy_fat_and_carbohydrate,
x10012.q AS energy_protein,
x10014.q AS energy_alcohol,
x10009.q AS energy_digestible,
x10015.q AS fats_hcsfa,
x10016.q AS fats_lcn3pufa
      FROM
      --
(SELECT mixid, foodid FROM mixfood WHERE mixid = v_MixId) x0,
           --      
--205, carbohydrates-carbs_by_diff
(SELECT mixid,
        foodid,
        q
FROM mixresult
WHERE mixid = v_MixId
AND   nutrientid = '205') x205,
--10018, carbohydrates-fiber_insoluble
(SELECT mixid,
        foodid,
        q
FROM mixresult
WHERE mixid = v_MixId
AND   nutrientid = '10018') x10018,
--10017, carbohydrates-fiber_soluble
(SELECT mixid,
        foodid,
        q
FROM mixresult
WHERE mixid = v_MixId
AND   nutrientid = '10017') x10017,
--291, carbohydrates-fiber
(SELECT mixid,
        foodid,
        q
FROM mixresult
WHERE mixid = v_MixId
AND   nutrientid = '291') x291,
--212, carbohydrates-fructose
(SELECT mixid,
        foodid,
        q
FROM mixresult
WHERE mixid = v_MixId
AND   nutrientid = '212') x212,
--211, carbohydrates-glucose
(SELECT mixid,
        foodid,
        q
FROM mixresult
WHERE mixid = v_MixId
AND   nutrientid = '211') x211,
--10006, carbohydrates-glycemic_load
(SELECT mixid,
        foodid,
        q
FROM mixresult
WHERE mixid = v_MixId
AND   nutrientid = '10006') x10006,
--213, carbohydrates-lactose
(SELECT mixid,
        foodid,
        q
FROM mixresult
WHERE mixid = v_MixId
AND   nutrientid = '213') x213,
--209, carbohydrates-starch
(SELECT mixid,
        foodid,
        q
FROM mixresult
WHERE mixid = v_MixId
AND   nutrientid = '209') x209,
--210, carbohydrates-sucrose
(SELECT mixid,
        foodid,
        q
FROM mixresult
WHERE mixid = v_MixId
AND   nutrientid = '210') x210,
--269, carbohydrates-sugars
(SELECT mixid,
        foodid,
        q
FROM mixresult
WHERE mixid = v_MixId
AND   nutrientid = '269') x269,
--208, energy-gross
(SELECT mixid,
        foodid,
        q
FROM mixresult
WHERE mixid = v_MixId
AND   nutrientid = '208') x208,
--601, fats-cholesterol
(SELECT mixid,
        foodid,
        q
FROM mixresult
WHERE mixid = v_MixId
AND   nutrientid = '601') x601,
--621, fats-dha
(SELECT mixid,
        foodid,
        q
FROM mixresult
WHERE mixid = v_MixId
AND   nutrientid = '621') x621,
--629, fats-epa
(SELECT mixid,
        foodid,
        q
FROM mixresult
WHERE mixid = v_MixId
AND   nutrientid = '629') x629,
--611, fats-lauric
(SELECT mixid,
        foodid,
        q
FROM mixresult
WHERE mixid = v_MixId
AND   nutrientid = '611') x611,
--618, fats-linoleic
(SELECT mixid,
        foodid,
        q
FROM mixresult
WHERE mixid = v_MixId
AND   nutrientid = '618') x618,
--619, fats-linolenic
(SELECT mixid,
        foodid,
        q
FROM mixresult
WHERE mixid = v_MixId
AND   nutrientid = '619') x619,
--645, fats-monounsaturated
(SELECT mixid,
        foodid,
        q
FROM mixresult
WHERE mixid = v_MixId
AND   nutrientid = '645') x645,
--612, fats-myristic
(SELECT mixid,
        foodid,
        q
FROM mixresult
WHERE mixid = v_MixId
AND   nutrientid = '612') x612,
--613, fats-palmitic
(SELECT mixid,
        foodid,
        q
FROM mixresult
WHERE mixid = v_MixId
AND   nutrientid = '613') x613,
--646, fats-polyunsaturated
(SELECT mixid,
        foodid,
        q
FROM mixresult
WHERE mixid = v_MixId
AND   nutrientid = '646') x646,
--606, fats-saturated
(SELECT mixid,
        foodid,
        q
FROM mixresult
WHERE mixid = v_MixId
AND   nutrientid = '606') x606,
--614, fats-stearic
(SELECT mixid,
        foodid,
        q
FROM mixresult
WHERE mixid = v_MixId
AND   nutrientid = '614') x614,
--204, fats-total
(SELECT mixid,
        foodid,
        q
FROM mixresult
WHERE mixid = v_MixId
AND   nutrientid = '204') x204,
--301, minerals-calcium
(SELECT mixid,
        foodid,
        q
FROM mixresult
WHERE mixid = v_MixId
AND   nutrientid = '301') x301,
--312, minerals-copper
(SELECT mixid,
        foodid,
        q
FROM mixresult
WHERE mixid = v_MixId
AND   nutrientid = '312') x312,
--303, minerals-iron
(SELECT mixid,
        foodid,
        q
FROM mixresult
WHERE mixid = v_MixId
AND   nutrientid = '303') x303,
--304, minerals-magnesium
(SELECT mixid,
        foodid,
        q
FROM mixresult
WHERE mixid = v_MixId
AND   nutrientid = '304') x304,
--315, minerals-manganese
(SELECT mixid,
        foodid,
        q
FROM mixresult
WHERE mixid = v_MixId
AND   nutrientid = '315') x315,
--305, minerals-phosphorus
(SELECT mixid,
        foodid,
        q
FROM mixresult
WHERE mixid = v_MixId
AND   nutrientid = '305') x305,
--306, minerals-potassium
(SELECT mixid,
        foodid,
        q
FROM mixresult
WHERE mixid = v_MixId
AND   nutrientid = '306') x306,
--317, minerals-selenium
(SELECT mixid,
        foodid,
        q
FROM mixresult
WHERE mixid = v_MixId
AND   nutrientid = '317') x317,
--307, minerals-sodium
(SELECT mixid,
        foodid,
        q
FROM mixresult
WHERE mixid = v_MixId
AND   nutrientid = '307') x307,
--309, minerals-zinc
(SELECT mixid,
        foodid,
        q
FROM mixresult
WHERE mixid = v_MixId
AND   nutrientid = '309') x309,
--221, other-alcohol
(SELECT mixid,
        foodid,
        q
FROM mixresult
WHERE mixid = v_MixId
AND   nutrientid = '221') x221,
--10005, other-cost
(SELECT mixid,
        foodid,
        q
FROM mixresult
WHERE mixid = v_MixId
AND   nutrientid = '10005') x10005,
--255, other-water
(SELECT mixid,
        foodid,
        q
FROM mixresult
WHERE mixid = v_MixId
AND   nutrientid = '255') x255,
--10000, other-weight
(SELECT mixid,
        foodid,
        q
FROM mixresult
WHERE mixid = v_MixId
AND   nutrientid = '10000') x10000,
--10024, phytonutrients-anthocyanins
(SELECT mixid,
        foodid,
        q
FROM mixresult
WHERE mixid = v_MixId
AND   nutrientid = '10024') x10024,
--262, phytonutrients-caffeine
(SELECT mixid,
        foodid,
        q
FROM mixresult
WHERE mixid = v_MixId
AND   nutrientid = '262') x262,
--321, phytonutrients-beta_carotene
(SELECT mixid,
        foodid,
        q
FROM mixresult
WHERE mixid = v_MixId
AND   nutrientid = '321') x321,
--10019, phytonutrients-carotenoids
(SELECT mixid,
        foodid,
        q
FROM mixresult
WHERE mixid = v_MixId
AND   nutrientid = '10019') x10019,
--10022, phytonutrients-flavanols
(SELECT mixid,
        foodid,
        q
FROM mixresult
WHERE mixid = v_MixId
AND   nutrientid = '10022') x10022,
--10023, phytonutrients-flavanones
(SELECT mixid,
        foodid,
        q
FROM mixresult
WHERE mixid = v_MixId
AND   nutrientid = '10023') x10023,
--10021, phytonutrients-flavones
(SELECT mixid,
        foodid,
        q
FROM mixresult
WHERE mixid = v_MixId
AND   nutrientid = '10021') x10021,
--10026, phytonutrients-flavonoids
(SELECT mixid,
        foodid,
        q
FROM mixresult
WHERE mixid = v_MixId
AND   nutrientid = '10026') x10026,
--10020, phytonutrients-flavonols
(SELECT mixid,
        foodid,
        q
FROM mixresult
WHERE mixid = v_MixId
AND   nutrientid = '10020') x10020,
--10025, phytonutrients-isoflavones
(SELECT mixid,
        foodid,
        q
FROM mixresult
WHERE mixid = v_MixId
AND   nutrientid = '10025') x10025,
--338, phytonutrients-lutein_zeaxanthin
(SELECT mixid,
        foodid,
        q
FROM mixresult
WHERE mixid = v_MixId
AND   nutrientid = '338') x338,
--337, phytonutrients-lycopene
(SELECT mixid,
        foodid,
        q
FROM mixresult
WHERE mixid = v_MixId
AND   nutrientid = '337') x337,
--636, phytonutrients-phytosterols
(SELECT mixid,
        foodid,
        q
FROM mixresult
WHERE mixid = v_MixId
AND   nutrientid = '636') x636,
--263, phytonutrients-theobromine
(SELECT mixid,
        foodid,
        q
FROM mixresult
WHERE mixid = v_MixId
AND   nutrientid = '263') x263,
--10001, protein-complete
(SELECT mixid,
        foodid,
        q
FROM mixresult
WHERE mixid = v_MixId
AND   nutrientid = '10001') x10001,
--203, protein-total
(SELECT mixid,
        foodid,
        q
FROM mixresult
WHERE mixid = v_MixId
AND   nutrientid = '203') x203,
--320, vitamins-vitamin_a
(SELECT mixid,
        foodid,
        q
FROM mixresult
WHERE mixid = v_MixId
AND   nutrientid = '320') x320,
--418, vitamins-vitamin_b12
(SELECT mixid,
        foodid,
        q
FROM mixresult
WHERE mixid = v_MixId
AND   nutrientid = '418') x418,
--415, vitamins-vitamin_b6
(SELECT mixid,
        foodid,
        q
FROM mixresult
WHERE mixid = v_MixId
AND   nutrientid = '415') x415,
--401, vitamins-vitamin_c
(SELECT mixid,
        foodid,
        q
FROM mixresult
WHERE mixid = v_MixId
AND   nutrientid = '401') x401,
--421, vitamins-choline
(SELECT mixid,
        foodid,
        q
FROM mixresult
WHERE mixid = v_MixId
AND   nutrientid = '421') x421,
--328, vitamins-vitamin_d
(SELECT mixid,
        foodid,
        q
FROM mixresult
WHERE mixid = v_MixId
AND   nutrientid = '328') x328,
--323, vitamins-vitamin_e
(SELECT mixid,
        foodid,
        q
FROM mixresult
WHERE mixid = v_MixId
AND   nutrientid = '323') x323,
--435, vitamins-folate
(SELECT mixid,
        foodid,
        q
FROM mixresult
WHERE mixid = v_MixId
AND   nutrientid = '435') x435,
--430, vitamins-vitamin_k
(SELECT mixid,
        foodid,
        q
FROM mixresult
WHERE mixid = v_MixId
AND   nutrientid = '430') x430,
--406, vitamins-niacin
(SELECT mixid,
        foodid,
        q
FROM mixresult
WHERE mixid = v_MixId
AND   nutrientid = '406') x406,
--410, vitamins-pantothenic_acid
(SELECT mixid,
        foodid,
        q
FROM mixresult
WHERE mixid = v_MixId
AND   nutrientid = '410') x410,
--405, vitamins-riboflavin
(SELECT mixid,
        foodid,
        q
FROM mixresult
WHERE mixid = v_MixId
AND   nutrientid = '405') x405,
--404, vitamins-thiamin
(SELECT mixid,
        foodid,
        q
FROM mixresult
WHERE mixid = v_MixId
AND   nutrientid = '404') x404,
--10003, carbohydrates-digestible
(SELECT mixid,
        foodid,
        q
FROM mixresult
WHERE mixid = v_MixId
AND   nutrientid = '10003') x10003,
--10011, energy-carbohydrate
(SELECT mixid,
        foodid,
        q
FROM mixresult
WHERE mixid = v_MixId
AND   nutrientid = '10011') x10011,
--10013, energy-fat
(SELECT mixid,
        foodid,
        q
FROM mixresult
WHERE mixid = v_MixId
AND   nutrientid = '10013') x10013,
--10010, energy-fat_and_carbohydrate
(SELECT mixid,
        foodid,
        q
FROM mixresult
WHERE mixid = v_MixId
AND   nutrientid = '10010') x10010,
--10012, energy-protein
(SELECT mixid,
        foodid,
        q
FROM mixresult
WHERE mixid = v_MixId
AND   nutrientid = '10012') x10012,
--10014, energy-alcohol
(SELECT mixid,
        foodid,
        q
FROM mixresult
WHERE mixid = v_MixId
AND   nutrientid = '10014') x10014,
--10009, energy-digestible
(SELECT mixid,
        foodid,
        q
FROM mixresult
WHERE mixid = v_MixId
AND   nutrientid = '10009') x10009,
--10015, fats-hcsfa
(SELECT mixid,
        foodid,
        q
FROM mixresult
WHERE mixid = v_MixId
AND   nutrientid = '10015') x10015,
--10016, fats-lcn3pufa
(SELECT mixid,
        foodid,
        q
FROM mixresult
WHERE mixid = v_MixId
AND   nutrientid = '10016') x10016
      --      
WHERE x0.mixid = x205.mixid
AND x0.foodid = x205.foodid
AND x0.mixid = x10018.mixid
AND x0.foodid = x10018.foodid
AND x0.mixid = x10017.mixid
AND x0.foodid = x10017.foodid
AND x0.mixid = x291.mixid
AND x0.foodid = x291.foodid
AND x0.mixid = x212.mixid
AND x0.foodid = x212.foodid
AND x0.mixid = x211.mixid
AND x0.foodid = x211.foodid
AND x0.mixid = x10006.mixid
AND x0.foodid = x10006.foodid
AND x0.mixid = x213.mixid
AND x0.foodid = x213.foodid
AND x0.mixid = x209.mixid
AND x0.foodid = x209.foodid
AND x0.mixid = x210.mixid
AND x0.foodid = x210.foodid
AND x0.mixid = x269.mixid
AND x0.foodid = x269.foodid
AND x0.mixid = x208.mixid
AND x0.foodid = x208.foodid
AND x0.mixid = x601.mixid
AND x0.foodid = x601.foodid
AND x0.mixid = x621.mixid
AND x0.foodid = x621.foodid
AND x0.mixid = x629.mixid
AND x0.foodid = x629.foodid
AND x0.mixid = x611.mixid
AND x0.foodid = x611.foodid
AND x0.mixid = x618.mixid
AND x0.foodid = x618.foodid
AND x0.mixid = x619.mixid
AND x0.foodid = x619.foodid
AND x0.mixid = x645.mixid
AND x0.foodid = x645.foodid
AND x0.mixid = x612.mixid
AND x0.foodid = x612.foodid
AND x0.mixid = x613.mixid
AND x0.foodid = x613.foodid
AND x0.mixid = x646.mixid
AND x0.foodid = x646.foodid
AND x0.mixid = x606.mixid
AND x0.foodid = x606.foodid
AND x0.mixid = x614.mixid
AND x0.foodid = x614.foodid
AND x0.mixid = x204.mixid
AND x0.foodid = x204.foodid
AND x0.mixid = x301.mixid
AND x0.foodid = x301.foodid
AND x0.mixid = x312.mixid
AND x0.foodid = x312.foodid
AND x0.mixid = x303.mixid
AND x0.foodid = x303.foodid
AND x0.mixid = x304.mixid
AND x0.foodid = x304.foodid
AND x0.mixid = x315.mixid
AND x0.foodid = x315.foodid
AND x0.mixid = x305.mixid
AND x0.foodid = x305.foodid
AND x0.mixid = x306.mixid
AND x0.foodid = x306.foodid
AND x0.mixid = x317.mixid
AND x0.foodid = x317.foodid
AND x0.mixid = x307.mixid
AND x0.foodid = x307.foodid
AND x0.mixid = x309.mixid
AND x0.foodid = x309.foodid
AND x0.mixid = x221.mixid
AND x0.foodid = x221.foodid
AND x0.mixid = x10005.mixid
AND x0.foodid = x10005.foodid
AND x0.mixid = x255.mixid
AND x0.foodid = x255.foodid
AND x0.mixid = x10000.mixid
AND x0.foodid = x10000.foodid
AND x0.mixid = x10024.mixid
AND x0.foodid = x10024.foodid
AND x0.mixid = x262.mixid
AND x0.foodid = x262.foodid
AND x0.mixid = x321.mixid
AND x0.foodid = x321.foodid
AND x0.mixid = x10019.mixid
AND x0.foodid = x10019.foodid
AND x0.mixid = x10022.mixid
AND x0.foodid = x10022.foodid
AND x0.mixid = x10023.mixid
AND x0.foodid = x10023.foodid
AND x0.mixid = x10021.mixid
AND x0.foodid = x10021.foodid
AND x0.mixid = x10026.mixid
AND x0.foodid = x10026.foodid
AND x0.mixid = x10020.mixid
AND x0.foodid = x10020.foodid
AND x0.mixid = x10025.mixid
AND x0.foodid = x10025.foodid
AND x0.mixid = x338.mixid
AND x0.foodid = x338.foodid
AND x0.mixid = x337.mixid
AND x0.foodid = x337.foodid
AND x0.mixid = x636.mixid
AND x0.foodid = x636.foodid
AND x0.mixid = x263.mixid
AND x0.foodid = x263.foodid
AND x0.mixid = x10001.mixid
AND x0.foodid = x10001.foodid
AND x0.mixid = x203.mixid
AND x0.foodid = x203.foodid
AND x0.mixid = x320.mixid
AND x0.foodid = x320.foodid
AND x0.mixid = x418.mixid
AND x0.foodid = x418.foodid
AND x0.mixid = x415.mixid
AND x0.foodid = x415.foodid
AND x0.mixid = x401.mixid
AND x0.foodid = x401.foodid
AND x0.mixid = x421.mixid
AND x0.foodid = x421.foodid
AND x0.mixid = x328.mixid
AND x0.foodid = x328.foodid
AND x0.mixid = x323.mixid
AND x0.foodid = x323.foodid
AND x0.mixid = x435.mixid
AND x0.foodid = x435.foodid
AND x0.mixid = x430.mixid
AND x0.foodid = x430.foodid
AND x0.mixid = x406.mixid
AND x0.foodid = x406.foodid
AND x0.mixid = x410.mixid
AND x0.foodid = x410.foodid
AND x0.mixid = x405.mixid
AND x0.foodid = x405.foodid
AND x0.mixid = x404.mixid
AND x0.foodid = x404.foodid
AND x0.mixid = x10003.mixid
AND x0.foodid = x10003.foodid
AND x0.mixid = x10011.mixid
AND x0.foodid = x10011.foodid
AND x0.mixid = x10013.mixid
AND x0.foodid = x10013.foodid
AND x0.mixid = x10010.mixid
AND x0.foodid = x10010.foodid
AND x0.mixid = x10012.mixid
AND x0.foodid = x10012.foodid
AND x0.mixid = x10014.mixid
AND x0.foodid = x10014.foodid
AND x0.mixid = x10009.mixid
AND x0.foodid = x10009.foodid
AND x0.mixid = x10015.mixid
AND x0.foodid = x10015.foodid
AND x0.mixid = x10016.mixid
AND x0.foodid = x10016.foodid) a,
(SELECT foodid, name as food_name FROM food) b
WHERE a.foodid = b.foodid;
--
END;
/
