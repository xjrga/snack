CREATE PROCEDURE GroupList_Copy (
--
IN v_MixId_Old LONGVARCHAR,
--
IN v_MixId_New LONGVARCHAR
--
)
--
modifies sql data BEGIN atomic
--
INSERT INTO FoodGroupList
(
  mixid,
  groupid,
  foodid
)
SELECT v_MixId_New,
       groupid,
       foodid
FROM FoodGroupList
WHERE mixid = v_MixId_Old;
--
END;
/
