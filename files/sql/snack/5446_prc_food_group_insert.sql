CREATE PROCEDURE FoodGroup_Insert (
--
OUT newid LONGVARCHAR,
--
IN v_MixId LONGVARCHAR,
--
IN v_Name LONGVARCHAR
--
)
--
MODIFIES SQL DATA BEGIN ATOMIC
--
DECLARE v_groupid LONGVARCHAR;
--
SELECT generateId() INTO v_groupid FROM (VALUES(0));
--
INSERT INTO MixFoodGroup (
MixId,
GroupId,
Name
) VALUES (
v_MixId,
v_groupid,
v_Name
);
--
SET newid = v_groupid;
--
END;
/