CREATE PROCEDURE pin_and_keep_constraints (
--
IN v_mixid LONGVARCHAR
--
)
--
MODIFIES SQL DATA  BEGIN ATOMIC
--
DELETE FROM FoodQuantityC WHERE MixId = v_mixid AND relationshipid = 3;
INSERT INTO FoodQuantityC
SELECT mixid,foodid,'10000' as nutrientid,3 as relationshipid,x as b
FROM mixfood
WHERE mixid = v_mixid;

--
END;
/
