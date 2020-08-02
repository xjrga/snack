CREATE TRIGGER FoodFact_RowLevelAfterUpdate_Trigger_02 AFTER UPDATE OF q ON FoodFact REFERENCING NEW ROW AS newrow OLD AS oldrow
--
FOR EACH ROW BEGIN ATOMIC
--
IF newrow.NutrientId = '10000' THEN
--
FOR SELECT nutrientid FROM nutrient DO
--
call FoodFactCoefficient_Update(newrow.FoodId,nutrientid);
--
END FOR;
--
ELSE
--
call FoodFactCoefficient_Update(newrow.FoodId,newrow.NutrientId);
--
END IF;
--
END;
/
