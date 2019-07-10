CREATE PROCEDURE NutrientConstraint_Copy (
--
IN v_MixId_Old INTEGER,
--
IN v_MixId_New INTEGER
--
)
--
modifies sql data BEGIN atomic
--
INSERT INTO NutrientConstraint
(
  mixid,
  nutrientid,
  relationshipid,
  b
)
SELECT v_MixId_New,
       nutrientid,
       relationshipid,
       b
FROM NutrientConstraint
WHERE mixid = v_MixId_Old;

--
END;
/