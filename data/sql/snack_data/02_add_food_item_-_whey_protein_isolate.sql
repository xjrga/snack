--delete from food where foodid = '95000';
--/
CALL Food_Insert_Default('95000','Whey Protein Isolate');
/
--CALL Food_Insert('95000','Whey Protein Isolate',100);
--/
--Protein
CALL FoodFact_Insert('95000','203',92.0);
/
--Fat
CALL FoodFact_Insert('95000','204',1.0);
/
--Calories
CALL FoodFact_Insert('95000','208',374.0);
/
--Alcohol
CALL FoodFact_Insert('95000','221',0.0);
/
--Fiber
CALL FoodFact_Insert('95000','291',0.0);
/
--Calcium
CALL FoodFact_Insert('95000','301',110);
/
--Magnesium
CALL FoodFact_Insert('95000','304',15);
/
--Potassium
CALL FoodFact_Insert('95000','306',110);
/
--Sodium
CALL FoodFact_Insert('95000','307',835);
/
--Cholesterol
CALL FoodFact_Insert('95000','601',10);
/
--Saturated Fat
CALL FoodFact_Insert('95000','606',0.0);
/
--Monounsaturated Fat
CALL FoodFact_Insert('95000','645',0.0);
/
--Polyunsaturated Fat
CALL FoodFact_Insert('95000','646',0.0);
/
--Quantity
CALL FoodFact_Insert('95000','10000',100);
/
--Complete Protein
CALL FoodFact_Insert('95000','10001',92.0);
/
--Incomplete Protein
CALL FoodFact_Insert('95000','10002',0.0);
/
--Digestible Carbohydrates
CALL FoodFact_Insert('95000','10003',0);
/
--Cost
CALL FoodFact_Insert('95000','10005',1.0);
/