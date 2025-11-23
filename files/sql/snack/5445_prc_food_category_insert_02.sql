CREATE PROCEDURE FoodCategory_Insert_2 (
--
OUT newid LONGVARCHAR,
--
IN v_Name LONGVARCHAR
--
)
--
MODIFIES SQL DATA BEGIN ATOMIC
--
DECLARE v_id LONGVARCHAR;
--
SELECT generateId() INTO v_id FROM (VALUES(0));
--
INSERT INTO FoodCategory (
FoodCategoryId,
Name
) VALUES (
v_id,
v_Name
);
--
SET newid = v_id;
--
END;
/