CREATE PROCEDURE MealFoodAllocation_insert (
IN v_MixId LONGVARCHAR,
IN v_MealId INTEGER,
IN v_FoodId LONGVARCHAR,
IN v_Pct DOUBLE,
IN v_ExpectedWt DOUBLE,
IN v_ActualWt DOUBLE
)
MODIFIES SQL DATA BEGIN ATOMIC
INSERT INTO MealFoodAllocation (
MixId,
MealId,
FoodId,
Pct,
ExpectedWt,
ActualWt
) VALUES (
v_MixId,
v_MealId,
v_FoodId,
v_Pct,
v_ExpectedWt,
v_ActualWt
);
END;
/

CREATE PROCEDURE MealFoodAllocation_merge_01 (
IN v_MixId LONGVARCHAR,
IN v_MealId INTEGER,
IN v_FoodId LONGVARCHAR,
IN v_Pct DOUBLE,
IN v_ExpectedWt DOUBLE,
IN v_ActualWt DOUBLE
)
MODIFIES SQL DATA BEGIN ATOMIC
MERGE INTO MealFoodAllocation USING ( VALUES (
v_MixId,
v_MealId,
v_FoodId,
v_Pct,
v_ExpectedWt,
v_ActualWt
) ) ON (
MixId = v_MixId AND
MealId = v_MealId AND
FoodId = v_FoodId
)
WHEN MATCHED THEN UPDATE SET
Pct = v_Pct
WHEN NOT MATCHED THEN INSERT VALUES
v_MixId,
v_MealId,
v_FoodId,
v_Pct,
v_ExpectedWt,
v_ActualWt;
END;
/