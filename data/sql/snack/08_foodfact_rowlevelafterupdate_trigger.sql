CREATE TRIGGER FoodFact_RowLevelAfterUpdate_Trigger
AFTER UPDATE ON FoodFact REFERENCING NEW ROW AS newrow OLD as oldrow
FOR EACH ROW
BEGIN ATOMIC
--
DECLARE v_c DOUBLE;
--
SET v_c = getFoodCoefficient(newrow.FoodId,newrow.NutrientId);
--
UPDATE
FoodFactCoefficient
SET
c = v_c
WHERE
FoodId = newrow.FoodId
AND
NutrientId = newrow.NutrientId;
--
END;
/
