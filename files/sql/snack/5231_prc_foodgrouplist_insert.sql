CREATE PROCEDURE FoodGroupList_Insert (
--
IN v_GroupId LONGVARCHAR,
--
IN v_MixId LONGVARCHAR,
--
IN v_FoodId LONGVARCHAR
--

)
MODIFIES SQL DATA BEGIN ATOMIC
INSERT INTO FoodGroupList (
GroupId,
MixId,
FoodId
) VALUES (
v_GroupId,
v_MixId,
v_FoodId
);
END;
/