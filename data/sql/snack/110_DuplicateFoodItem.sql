CREATE PROCEDURE DuplicateFoodItem (IN v_FoodId LONGVARCHAR)
--
MODIFIES SQL DATA BEGIN ATOMIC
--
DECLARE v_FoodIdNew LONGVARCHAR;
DECLARE v_FoodNom LONGVARCHAR;
DECLARE v_CategoryId LONGVARCHAR;
--
SET v_FoodIdNew = generateId('f','');
SET v_FoodNom = getFoodName(v_FoodId);
-- Other category is 5000
SET v_CategoryId = '5000';
--
call Food_Insert(v_FoodIdNew,v_FoodNom||'_duplicate');
call CategoryLink_Insert(v_FoodIdNew,v_CategoryId);
call DuplicateFoodFact(v_FoodId,v_FoodIdNew);
--
END;
/