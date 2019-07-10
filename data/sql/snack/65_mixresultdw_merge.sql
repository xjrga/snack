CREATE PROCEDURE MixResultDW_Merge (
IN v_MixId INTEGER,
IN v_FoodId VARCHAR(8000)
)
--
MODIFIES SQL DATA BEGIN ATOMIC
--
DECLARE v_Name VARCHAR(8000);
DECLARE v_Protein DOUBLE;
DECLARE v_Fat DOUBLE;
DECLARE v_CarbsByDifference DOUBLE;
DECLARE v_Kcal DOUBLE;
DECLARE v_Alcohol DOUBLE;
DECLARE v_Fiber DOUBLE;
DECLARE v_Calcium DOUBLE;
DECLARE v_Magnesium DOUBLE;
DECLARE v_Potassium DOUBLE;
DECLARE v_Sodium DOUBLE;
DECLARE v_Cholesterol DOUBLE;
DECLARE v_SatFat DOUBLE;
DECLARE v_Monoufat DOUBLE;
DECLARE v_Polyufat DOUBLE;
DECLARE v_Quantity DOUBLE;
DECLARE v_Complete DOUBLE;
DECLARE v_Incomplete DOUBLE;
DECLARE v_CarbsDigestible DOUBLE;
DECLARE v_Cost DOUBLE;
--
--
SET v_Name =  getFoodName(v_FoodId);
SET v_Protein =  getmixresultvalue(v_MixId,v_FoodId,'203');
SET v_Fat =  getmixresultvalue(v_MixId,v_FoodId,'204');
SET v_CarbsByDifference =  getmixresultvalue(v_MixId,v_FoodId,'205');
SET v_Kcal =  getmixresultvalue(v_MixId,v_FoodId,'208');
SET v_Alcohol =  getmixresultvalue(v_MixId,v_FoodId,'221');
SET v_Fiber =  getmixresultvalue(v_MixId,v_FoodId,'291');
SET v_Calcium =  getmixresultvalue(v_MixId,v_FoodId,'301');
SET v_Magnesium =  getmixresultvalue(v_MixId,v_FoodId,'304');
SET v_Potassium =  getmixresultvalue(v_MixId,v_FoodId,'306');
SET v_Sodium =  getmixresultvalue(v_MixId,v_FoodId,'307');
SET v_Cholesterol =  getmixresultvalue(v_MixId,v_FoodId,'601');
SET v_SatFat =  getmixresultvalue(v_MixId,v_FoodId,'606');
SET v_Monoufat =  getmixresultvalue(v_MixId,v_FoodId,'645');
SET v_Polyufat =  getmixresultvalue(v_MixId,v_FoodId,'646');
SET v_Quantity =  getmixresultvalue(v_MixId,v_FoodId,'10000');
SET v_Complete =  getmixresultvalue(v_MixId,v_FoodId,'10001');
SET v_Incomplete =  getmixresultvalue(v_MixId,v_FoodId,'10002');
SET v_CarbsDigestible =  getmixresultvalue(v_MixId,v_FoodId,'10003');
SET v_Cost =  getmixresultvalue(v_MixId,v_FoodId,'10005');
--
MERGE INTO MixResultDW USING ( VALUES (
v_MixId,
v_FoodId,
v_Name,
v_Protein,
v_Fat,
v_CarbsByDifference,
v_Kcal,
v_Alcohol,
v_Fiber,
v_Calcium,
v_Magnesium,
v_Potassium,
v_Sodium,
v_Cholesterol,
v_SatFat,
v_Monoufat,
v_Polyufat,
v_Quantity,
v_Complete,
v_Incomplete,
v_CarbsDigestible,
v_Cost
) ) ON (
MixId = v_MixId
AND
FoodId = v_FoodId
)
WHEN MATCHED THEN UPDATE SET
Name = v_Name,
Protein = v_Protein,
Fat = v_Fat,
CarbsByDifference = v_CarbsByDifference,
Kcal = v_Kcal,
Alcohol = v_Alcohol,
Fiber = v_Fiber,
Calcium = v_Calcium,
Magnesium = v_Magnesium,
Potassium = v_Potassium,
Sodium = v_Sodium,
Cholesterol = v_Cholesterol,
SatFat = v_SatFat,
Monoufat = v_Monoufat,
Polyufat = v_Polyufat,
Quantity = v_Quantity,
Complete = v_Complete,
Incomplete = v_Incomplete,
CarbsDigestible = v_CarbsDigestible,
Cost = v_Cost
WHEN NOT MATCHED THEN INSERT VALUES
v_MixId,
v_FoodId,
v_Name,
v_Protein,
v_Fat,
v_CarbsByDifference,
v_Kcal,
v_Alcohol,
v_Fiber,
v_Calcium,
v_Magnesium,
v_Potassium,
v_Sodium,
v_Cholesterol,
v_SatFat,
v_Monoufat,
v_Polyufat,
v_Quantity,
v_Complete,
v_Incomplete,
v_CarbsDigestible,
v_Cost;
--
END;
/