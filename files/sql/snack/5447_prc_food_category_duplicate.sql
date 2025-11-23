CREATE PROCEDURE duplicateCategory (
--
OUT newid LONGVARCHAR,
--
IN v_fromid LONGVARCHAR
--
)
--
MODIFIES SQL DATA BEGIN ATOMIC
--
DECLARE v_name LONGVARCHAR;
DECLARE v_id LONGVARCHAR;
--
SELECT name INTO v_name FROM FoodCategory WHERE foodcategoryid = v_fromid;
--
CALL FoodCategory_Insert_2(v_id,'Duplicate Of '||v_name);
--
INSERT INTO CategoryLink (
FoodCategoryId,
FoodId
)
SELECT v_id,foodid
FROM categorylink
WHERE foodcategoryid = v_fromid;
--
SET newid = v_id;
--
END;
/
