
CREATE PROCEDURE NutrientPercent_Copy (
--
IN v_MixId_Old LONGVARCHAR,
--
IN v_MixId_New LONGVARCHAR
--
)
--
modifies sql data BEGIN atomic
--
INSERT INTO PercentConstraint
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
FROM PercentConstraint
WHERE mixid = v_MixId_Old;

--
END;
/