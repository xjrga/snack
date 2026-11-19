CREATE PROCEDURE GroupRatio_Copy (
--
IN v_MixId_Old LONGVARCHAR,
--
IN v_MixId_New LONGVARCHAR
--
)
--
modifies sql data BEGIN atomic
--
INSERT INTO FoodGroupRatioC
(
  mixid,
  group_id_1,
  nutrient_id_1,
  group_id_2,
  nutrient_id_2,
  relationshipid,
  a,
  b
)
SELECT v_MixId_New,
       group_id_1,
       nutrient_id_1,
       group_id_2,
       nutrient_id_2,
       relationshipid,
       a,
       b
FROM FoodGroupRatioC
WHERE mixid = v_MixId_Old;

--
END;
/
