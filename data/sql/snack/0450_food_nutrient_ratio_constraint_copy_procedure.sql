CREATE PROCEDURE FoodNutrientRatio (
--
IN v_MixId_Old INTEGER,
--
IN v_MixId_New INTEGER
--
)
--
modifies sql data BEGIN atomic
--
INSERT INTO FoodNutrientRatio
(
  mixid,
  food_id_1,
  nutrient_id_1,
  food_id_2,
  nutrient_id_2,
  relationshipid,
  a,
  b
)
SELECT v_MixId_New,
       food_id_1,
       nutrient_id_1,
       food_id_2,
       nutrient_id_2,
       relationshipid,
       a,
       b
FROM FoodNutrientRatio
WHERE mixid = v_MixId_Old;

--
END;
/
