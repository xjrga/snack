CREATE PROCEDURE Food_Put (
--
IN v_MixId LONGVARCHAR
--
)
--
MODIFIES SQL DATA BEGIN ATOMIC
--
DECLARE v_FoodId LONGVARCHAR;
DECLARE v_FoodName LONGVARCHAR;
DECLARE v_gi DOUBLE;
--
SET v_gi = 0;
--
SELECT Name INTO v_FoodName
FROM Mix
WHERE MixId = v_MixId;
SET v_FoodId = generateId();
--
CALL Food_Insert (v_FoodId,v_FoodName);
--
FOR
SELECT mixid,
       nutrientid,
       SUM(q) AS q
FROM mixresult
WHERE mixid = v_MixId
GROUP BY mixid,nutrientid DO
CALL FoodFact_Merge(v_FoodId,nutrientid,q);
END FOR;
--
SELECT getMealGI(v_MixId) INTO v_gi FROM (VALUES(0));
CALL GlycemicIndex_merge(v_FoodId,v_gi);
--
CALL CategoryLink_Insert (v_FoodId,'5000');
--
END;
/
