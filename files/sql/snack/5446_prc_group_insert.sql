CREATE PROCEDURE Group_Insert (
--
IN v_MixId LONGVARCHAR,
--
IN v_GroupId LONGVARCHAR,
--
IN v_Name LONGVARCHAR
--
)
--
MODIFIES SQL DATA
BEGIN ATOMIC
--
INSERT INTO MixFoodGroup (
MixId,
GroupId,
Name
) VALUES (
v_MixId,
v_GroupId,
v_Name
);
--
END;
/