CREATE PROCEDURE duplicateFoodGroup (
--
OUT newid LONGVARCHAR,
--
IN v_MixId LONGVARCHAR,
--
IN v_GroupId LONGVARCHAR
--

)
--
MODIFIES SQL DATA BEGIN ATOMIC
--
DECLARE v_name LONGVARCHAR;
DECLARE v_id LONGVARCHAR;
--
SELECT name INTO v_name FROM MixFoodGroup WHERE mixid = v_MixId AND groupid = v_GroupId;
--
CALL FoodGroup_Insert(v_id,v_MixId,'Duplicate Of '||v_name);
--
INSERT INTO FoodGroupList (
GroupId,
MixId,
FoodId
)
SELECT v_id,MixId,FoodId
FROM FoodGroupList
WHERE mixid = v_MixId AND groupid = v_GroupId;
--
SET newid = v_id;
--
END;
/
