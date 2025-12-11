CREATE PROCEDURE FoodGroup_Update (
--
IN v_MixId LONGVARCHAR,
--
IN v_GroupId LONGVARCHAR,
--
IN v_Name LONGVARCHAR
--
)
--
MODIFIES SQL DATA BEGIN ATOMIC
--
UPDATE
MixFoodGroup
SET
Name = v_Name
WHERE
MixId = v_MixId AND GroupId = v_GroupId;
--
END;
/