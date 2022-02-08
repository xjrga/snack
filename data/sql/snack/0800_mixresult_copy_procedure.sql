CREATE PROCEDURE MixResult_Copy (
--
IN v_MixId_Old INTEGER,
--
IN v_MixId_New INTEGER
--
)
--
MODIFIES SQL DATA
BEGIN ATOMIC
--
INSERT INTO MixResult
(
  MixId,
  FoodId,
  NutrientId,
  q
)
SELECT v_MixId_New,
       FoodId,
       NutrientId,
       q
FROM MixResult
WHERE mixid = v_MixId_Old;
--
END;
/