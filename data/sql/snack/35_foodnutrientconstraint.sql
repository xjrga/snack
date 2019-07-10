CREATE PROCEDURE FoodNutrientConstraint (
--
IN v_MixId_Old INTEGER,
--
IN v_MixId_New INTEGER
--
)
--
modifies sql data BEGIN atomic
--
INSERT INTO FoodNutrientConstraint
(
  mixid,
  foodid,
  nutrientid,
  relationshipid,
  b
)
SELECT v_MixId_New,
       foodid,
       nutrientid,
       relationshipid,
       b
FROM FoodNutrientConstraint
WHERE mixid = v_MixId_Old;

--
END;
/
