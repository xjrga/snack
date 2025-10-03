CREATE PROCEDURE NutrientConstraint_Copy (
--
IN v_MixId_Old LONGVARCHAR,
--
IN v_MixId_New LONGVARCHAR
--
)
--
modifies sql data BEGIN atomic
--
INSERT INTO NutrientQuantityC
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
FROM NutrientQuantityC
WHERE mixid = v_MixId_Old;

--
END;
/