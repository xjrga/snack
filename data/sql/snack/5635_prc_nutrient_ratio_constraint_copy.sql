CREATE PROCEDURE NutrientRatio_Copy (
--
IN v_MixId_Old LONGVARCHAR,
--
IN v_MixId_New LONGVARCHAR
--
)
--
modifies sql data BEGIN atomic
--
INSERT INTO NutrientRatio
(
  mixid,
  nutrient_id_1,
  nutrient_id_2,
  relationshipid,
  a,
  b
)
SELECT v_MixId_New,
       nutrient_id_1,
       nutrient_id_2,
       relationshipid,
       a,
       b
FROM NutrientRatio
WHERE mixid = v_MixId_Old;

--
END;
/