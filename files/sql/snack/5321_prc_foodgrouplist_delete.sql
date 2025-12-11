CREATE PROCEDURE FoodGroupList_Delete (
--
IN v_groupid LONGVARCHAR,
--
IN v_mixid LONGVARCHAR,
--
IN v_foodid LONGVARCHAR
--
)
--
MODIFIES SQL DATA BEGIN ATOMIC
--
DELETE FROM
--
FoodGroupList
--
WHERE
--
groupid = v_groupid
AND mixid = v_mixid
AND foodid = v_foodid;
--
END;
/
