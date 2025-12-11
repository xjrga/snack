CREATE PROCEDURE GroupConstraint_Copy (
--
IN v_MixId_Old LONGVARCHAR,
--
IN v_MixId_New LONGVARCHAR
--
)
--
modifies sql data BEGIN atomic
--
INSERT INTO FoodGroupQuantityC
(
  mixid,
  groupid,
  nutrientid,
  relationshipid,
  b
)
SELECT v_MixId_New,
       groupid,
       nutrientid,
       relationshipid,
       b
FROM FoodGroupQuantityC
WHERE mixid = v_MixId_Old;

--
END;
/
