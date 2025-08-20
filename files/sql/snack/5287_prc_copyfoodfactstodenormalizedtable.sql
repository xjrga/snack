CREATE PROCEDURE CopyFoodFactsToDenormalizedTable (
--
IN v_foodId LONGVARCHAR
--
)
--
MODIFIES SQL DATA
BEGIN ATOMIC
--
DELETE FROM DnFoodFact
WHERE food_id = v_FoodId;
--
INSERT INTO DnFoodFact (
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
phytonutrients_gamma_tocopherol,
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
SELECT x0.foodid,
       x0.name,
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
       x342.q AS phytonutrients_gamma_tocopherol,
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
--foodid , name
(SELECT foodid, name FROM food WHERE foodid = v_foodId) x0,
     --205, carbohydrates-carbs_by_diff
(SELECT foodid,
        q
 FROM foodfact
 WHERE nutrientid = '205'
 AND   foodid = v_foodId) x205,
     --10018, carbohydrates-fiber_insoluble
(SELECT foodid,
        q
 FROM foodfact
 WHERE nutrientid = '10018'
 AND   foodid = v_foodId) x10018,
     --10017, carbohydrates-fiber_soluble
(SELECT foodid,
        q
 FROM foodfact
 WHERE nutrientid = '10017'
 AND   foodid = v_foodId) x10017,
     --291, carbohydrates-fiber
(SELECT foodid,
        q
 FROM foodfact
 WHERE nutrientid = '291'
 AND   foodid = v_foodId) x291,
     --212, carbohydrates-fructose
(SELECT foodid,
        q
 FROM foodfact
 WHERE nutrientid = '212'
 AND   foodid = v_foodId) x212,
     --211, carbohydrates-glucose
(SELECT foodid,
        q
 FROM foodfact
 WHERE nutrientid = '211'
 AND   foodid = v_foodId) x211,
     --10006, carbohydrates-glycemic_load
(SELECT foodid,
        q
 FROM foodfact
 WHERE nutrientid = '10006'
 AND   foodid = v_foodId) x10006,
     --213, carbohydrates-lactose
(SELECT foodid,
        q
 FROM foodfact
 WHERE nutrientid = '213'
 AND   foodid = v_foodId) x213,
     --209, carbohydrates-starch
(SELECT foodid,
        q
 FROM foodfact
 WHERE nutrientid = '209'
 AND   foodid = v_foodId) x209,
     --210, carbohydrates-sucrose
(SELECT foodid,
        q
 FROM foodfact
 WHERE nutrientid = '210'
 AND   foodid = v_foodId) x210,
     --269, carbohydrates-sugars
(SELECT foodid,
        q
 FROM foodfact
 WHERE nutrientid = '269'
 AND   foodid = v_foodId) x269,
     --208, energy-gross
(SELECT foodid,
        q
 FROM foodfact
 WHERE nutrientid = '208'
 AND   foodid = v_foodId) x208,
     --601, fats-cholesterol
(SELECT foodid,
        q
 FROM foodfact
 WHERE nutrientid = '601'
 AND   foodid = v_foodId) x601,
     --621, fats-dha
(SELECT foodid,
        q
 FROM foodfact
 WHERE nutrientid = '621'
 AND   foodid = v_foodId) x621,
     --629, fats-epa
(SELECT foodid,
        q
 FROM foodfact
 WHERE nutrientid = '629'
 AND   foodid = v_foodId) x629,
     --611, fats-lauric
(SELECT foodid,
        q
 FROM foodfact
 WHERE nutrientid = '611'
 AND   foodid = v_foodId) x611,
     --618, fats-linoleic
(SELECT foodid,
        q
 FROM foodfact
 WHERE nutrientid = '618'
 AND   foodid = v_foodId) x618,
     --619, fats-linolenic
(SELECT foodid,
        q
 FROM foodfact
 WHERE nutrientid = '619'
 AND   foodid = v_foodId) x619,
     --645, fats-monounsaturated
(SELECT foodid,
        q
 FROM foodfact
 WHERE nutrientid = '645'
 AND   foodid = v_foodId) x645,
     --612, fats-myristic
(SELECT foodid,
        q
 FROM foodfact
 WHERE nutrientid = '612'
 AND   foodid = v_foodId) x612,
     --613, fats-palmitic
(SELECT foodid,
        q
 FROM foodfact
 WHERE nutrientid = '613'
 AND   foodid = v_foodId) x613,
     --646, fats-polyunsaturated
(SELECT foodid,
        q
 FROM foodfact
 WHERE nutrientid = '646'
 AND   foodid = v_foodId) x646,
     --606, fats-saturated
(SELECT foodid,
        q
 FROM foodfact
 WHERE nutrientid = '606'
 AND   foodid = v_foodId) x606,
     --614, fats-stearic
(SELECT foodid,
        q
 FROM foodfact
 WHERE nutrientid = '614'
 AND   foodid = v_foodId) x614,
     --204, fats-total
(SELECT foodid,
        q
 FROM foodfact
 WHERE nutrientid = '204'
 AND   foodid = v_foodId) x204,
     --301, minerals-calcium
(SELECT foodid,
        q
 FROM foodfact
 WHERE nutrientid = '301'
 AND   foodid = v_foodId) x301,
     --312, minerals-copper
(SELECT foodid,
        q
 FROM foodfact
 WHERE nutrientid = '312'
 AND   foodid = v_foodId) x312,
     --303, minerals-iron
(SELECT foodid,
        q
 FROM foodfact
 WHERE nutrientid = '303'
 AND   foodid = v_foodId) x303,
     --304, minerals-magnesium
(SELECT foodid,
        q
 FROM foodfact
 WHERE nutrientid = '304'
 AND   foodid = v_foodId) x304,
     --315, minerals-manganese
(SELECT foodid,
        q
 FROM foodfact
 WHERE nutrientid = '315'
 AND   foodid = v_foodId) x315,
     --305, minerals-phosphorus
(SELECT foodid,
        q
 FROM foodfact
 WHERE nutrientid = '305'
 AND   foodid = v_foodId) x305,
     --306, minerals-potassium
(SELECT foodid,
        q
 FROM foodfact
 WHERE nutrientid = '306'
 AND   foodid = v_foodId) x306,
     --317, minerals-selenium
(SELECT foodid,
        q
 FROM foodfact
 WHERE nutrientid = '317'
 AND   foodid = v_foodId) x317,
     --307, minerals-sodium
(SELECT foodid,
        q
 FROM foodfact
 WHERE nutrientid = '307'
 AND   foodid = v_foodId) x307,
     --309, minerals-zinc
(SELECT foodid,
        q
 FROM foodfact
 WHERE nutrientid = '309'
 AND   foodid = v_foodId) x309,
     --221, other-alcohol
(SELECT foodid,
        q
 FROM foodfact
 WHERE nutrientid = '221'
 AND   foodid = v_foodId) x221,
     --10005, other-cost
(SELECT foodid,
        q
 FROM foodfact
 WHERE nutrientid = '10005'
 AND   foodid = v_foodId) x10005,
     --255, other-water
(SELECT foodid,
        q
 FROM foodfact
 WHERE nutrientid = '255'
 AND   foodid = v_foodId) x255,
     --10000, other-weight
(SELECT foodid,
        q
 FROM foodfact
 WHERE nutrientid = '10000'
 AND   foodid = v_foodId) x10000,
     --10024, phytonutrients-anthocyanins
(SELECT foodid,
        q
 FROM foodfact
 WHERE nutrientid = '10024'
 AND   foodid = v_foodId) x10024,
     --262, phytonutrients-caffeine
(SELECT foodid,
        q
 FROM foodfact
 WHERE nutrientid = '262'
 AND   foodid = v_foodId) x262,
     --321, phytonutrients-beta_carotene
(SELECT foodid,
        q
 FROM foodfact
 WHERE nutrientid = '321'
 AND   foodid = v_foodId) x321,
     --10019, phytonutrients-carotenoids
(SELECT foodid,
        q
 FROM foodfact
 WHERE nutrientid = '10019'
 AND   foodid = v_foodId) x10019,
     --10022, phytonutrients-flavanols
(SELECT foodid,
        q
 FROM foodfact
 WHERE nutrientid = '10022'
 AND   foodid = v_foodId) x10022,
     --10023, phytonutrients-flavanones
(SELECT foodid,
        q
 FROM foodfact
 WHERE nutrientid = '10023'
 AND   foodid = v_foodId) x10023,
     --10021, phytonutrients-flavones
(SELECT foodid,
        q
 FROM foodfact
 WHERE nutrientid = '10021'
 AND   foodid = v_foodId) x10021,
     --10026, phytonutrients-flavonoids
(SELECT foodid,
        q
 FROM foodfact
 WHERE nutrientid = '10026'
 AND   foodid = v_foodId) x10026,
     --10020, phytonutrients-flavonols
(SELECT foodid,
        q
 FROM foodfact
 WHERE nutrientid = '10020'
 AND   foodid = v_foodId) x10020,
     --10025, phytonutrients-isoflavones
(SELECT foodid,
        q
 FROM foodfact
 WHERE nutrientid = '10025'
 AND   foodid = v_foodId) x10025,
     --338, phytonutrients-lutein_zeaxanthin
(SELECT foodid,
        q
 FROM foodfact
 WHERE nutrientid = '338'
 AND   foodid = v_foodId) x338,
     --337, phytonutrients-lycopene
(SELECT foodid,
        q
 FROM foodfact
 WHERE nutrientid = '337'
 AND   foodid = v_foodId) x337,
     --636, phytonutrients-phytosterols
(SELECT foodid,
        q
 FROM foodfact
 WHERE nutrientid = '636'
 AND   foodid = v_foodId) x636,
     --263, phytonutrients-theobromine
(SELECT foodid,
        q
 FROM foodfact
 WHERE nutrientid = '263'
 AND   foodid = v_foodId) x263,
     --342, phytonutrients-gamma_tocopherol
(SELECT foodid,
        q
 FROM foodfact
 WHERE nutrientid = '342'
 AND   foodid = v_foodId) x342,
     --10001, protein-complete
(SELECT foodid,
        q
 FROM foodfact
 WHERE nutrientid = '10001'
 AND   foodid = v_foodId) x10001,
     --203, protein-total
(SELECT foodid,
        q
 FROM foodfact
 WHERE nutrientid = '203'
 AND   foodid = v_foodId) x203,
     --320, vitamins-vitamin_a
(SELECT foodid,
        q
 FROM foodfact
 WHERE nutrientid = '320'
 AND   foodid = v_foodId) x320,
     --418, vitamins-vitamin_b12
(SELECT foodid,
        q
 FROM foodfact
 WHERE nutrientid = '418'
 AND   foodid = v_foodId) x418,
     --415, vitamins-vitamin_b6
(SELECT foodid,
        q
 FROM foodfact
 WHERE nutrientid = '415'
 AND   foodid = v_foodId) x415,
     --401, vitamins-vitamin_c
(SELECT foodid,
        q
 FROM foodfact
 WHERE nutrientid = '401'
 AND   foodid = v_foodId) x401,
     --421, vitamins-choline
(SELECT foodid,
        q
 FROM foodfact
 WHERE nutrientid = '421'
 AND   foodid = v_foodId) x421,
     --328, vitamins-vitamin_d
(SELECT foodid,
        q
 FROM foodfact
 WHERE nutrientid = '328'
 AND   foodid = v_foodId) x328,
     --323, vitamins-vitamin_e
(SELECT foodid,
        q
 FROM foodfact
 WHERE nutrientid = '323'
 AND   foodid = v_foodId) x323,
     --435, vitamins-folate
(SELECT foodid,
        q
 FROM foodfact
 WHERE nutrientid = '435'
 AND   foodid = v_foodId) x435,
     --430, vitamins-vitamin_k
(SELECT foodid,
        q
 FROM foodfact
 WHERE nutrientid = '430'
 AND   foodid = v_foodId) x430,
     --406, vitamins-niacin
(SELECT foodid,
        q
 FROM foodfact
 WHERE nutrientid = '406'
 AND   foodid = v_foodId) x406,
     --410, vitamins-pantothenic_acid
(SELECT foodid,
        q
 FROM foodfact
 WHERE nutrientid = '410'
 AND   foodid = v_foodId) x410,
     --405, vitamins-riboflavin
(SELECT foodid,
        q
 FROM foodfact
 WHERE nutrientid = '405'
 AND   foodid = v_foodId) x405,
     --404, vitamins-thiamin
(SELECT foodid,
        q
 FROM foodfact
 WHERE nutrientid = '404'
 AND   foodid = v_foodId) x404,
     --10003, carbohydrates-digestible
(SELECT foodid,
        q
 FROM foodfact
 WHERE nutrientid = '10003'
 AND   foodid = v_foodId) x10003,
     --10011, energy-carbohydrate
(SELECT foodid,
        q
 FROM foodfact
 WHERE nutrientid = '10011'
 AND   foodid = v_foodId) x10011,
     --10013, energy-fat
(SELECT foodid,
        q
 FROM foodfact
 WHERE nutrientid = '10013'
 AND   foodid = v_foodId) x10013,
     --10010, energy-fat_and_carbohydrate
(SELECT foodid,
        q
 FROM foodfact
 WHERE nutrientid = '10010'
 AND   foodid = v_foodId) x10010,
     --10012, energy-protein
(SELECT foodid,
        q
 FROM foodfact
 WHERE nutrientid = '10012'
 AND   foodid = v_foodId) x10012,
     --10014, energy-alcohol
(SELECT foodid,
        q
 FROM foodfact
 WHERE nutrientid = '10014'
 AND   foodid = v_foodId) x10014,
     --10009, energy-digestible
(SELECT foodid,
        q
 FROM foodfact
 WHERE nutrientid = '10009'
 AND   foodid = v_foodId) x10009,
     --10015, fats-hcsfa
(SELECT foodid,
        q
 FROM foodfact
 WHERE nutrientid = '10015'
 AND   foodid = v_foodId) x10015,
     --10016, fats-lcn3pufa
(SELECT foodid,
        q
 FROM foodfact
 WHERE nutrientid = '10016'
 AND   foodid = v_foodId) x10016;
--
END;
/
