CREATE PROCEDURE pin_and_delete_constraints (
--
IN v_mixid LONGVARCHAR
--
)
--
MODIFIES SQL DATA  BEGIN ATOMIC
--
DELETE FROM NutrientQuantityC WHERE MixId = v_mixid;
DELETE FROM FoodQuantityC WHERE MixId = v_mixid;
DELETE FROM FoodRatioC WHERE MixId = v_mixid;
DELETE FROM NutrientRatioC WHERE MixId = v_mixid;
DELETE FROM FoodGroupQuantityC WHERE MixId = v_mixid;
INSERT INTO FoodQuantityC
SELECT mixid,foodid,'10000' as nutrientid,3 as relationshipid,x as b
FROM mixfood
WHERE mixid = v_mixid;

--
END;
/
