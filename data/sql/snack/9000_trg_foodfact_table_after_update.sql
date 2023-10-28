CREATE TRIGGER FoodFact_RowLevelAfterUpdate_Trigger AFTER UPDATE OF q ON FoodFact REFERENCING NEW ROW AS newrow OLD AS oldrow
--
FOR EACH ROW
BEGIN ATOMIC
--
DECLARE v_c DOUBLE;
--
IF newrow.NutrientId = '10000' THEN
--
FOR SELECT nutrientid FROM nutrient DO
--
SET v_c = getFoodCoefficient(newrow.FoodId,nutrientid);
--
call FoodFactCoefficient_Merge(newrow.FoodId,nutrientid,v_c);
--
END FOR;
--
ELSE
--
SET v_c = getFoodCoefficient(newrow.FoodId,newrow.NutrientId);
--
CALL FoodFactCoefficient_Merge(newrow.FoodId,newrow.NutrientId, v_c);
--
END IF;
--
END;
/
