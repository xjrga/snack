CREATE PROCEDURE FoodGroup_Delete (
--
IN v_MixId LONGVARCHAR,
--
IN v_GroupId LONGVARCHAR
--
)
--
MODIFIES SQL DATA BEGIN ATOMIC
--
DELETE FROM
MixFoodGroup
WHERE
MixId = v_MixId AND GroupId = v_GroupId;
--
END;
/