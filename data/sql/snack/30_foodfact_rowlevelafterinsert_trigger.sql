CREATE TRIGGER FoodFact_RowLevelAfterInsert_Trigger
AFTER INSERT ON FoodFact REFERENCING NEW ROW AS newrow
FOR EACH ROW
BEGIN ATOMIC
DECLARE v_c DOUBLE;
set v_c = getFoodCoefficient(newrow.FoodId,newrow.NutrientId);
INSERT INTO FoodFactCoefficient VALUES (newrow.FoodId,newrow.NutrientId,v_c);
END;
/
