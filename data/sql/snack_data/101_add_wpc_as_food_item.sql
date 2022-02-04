--FOOD ITEM: Whey Protein Concentrate
--
--Insert food item
call Food_Insert('123456790','Whey Protein Concentrate');
/
--Put in in a food category
call CategoryLink_Insert('123456790','9000');
/
--Zero out food item food fact
call FoodFact_ZeroOut_FoodId('123456790');
/
--Update food item food fact with whatever available values there are
--
--Weight (g)
call FoodFact_Merge('123456790','10000',100);
/
--Sodium (mg)
call FoodFact_Merge('123456790','307',175);
/
--Calcium (mg)
call FoodFact_Merge('123456790','301',550);
/
--Potassium, K (mg)
call FoodFact_Merge('123456790','306',530);
/
--Phosphorus (mg)
call FoodFact_Merge('123456790','305',350);
/
--Magnesium (mg)
call FoodFact_Merge('123456790','304',60);
/
--Iron (mg)
call FoodFact_Merge('123456790','303',0.7);
/
--Protein (g)
call FoodFact_Merge('123456790','203',80);
/
--Complete Protein (g)
call FoodFact_Merge('123456790','10001',80);
/
--Fat (g)
call FoodFact_Merge('123456790','204',6);
/
--Cholesterol (mg)
call FoodFact_Merge('123456790','601',215);
/
--Energy, gross (kcal)
call FoodFact_Merge('123456790','208',385);
/
--Saturated Fat (g)
call FoodFact_Merge('123456790','606',2.10);
/
--Monounsaturated Fat (g)
call FoodFact_Merge('123456790','645',1.10);
/
--Polyunsaturated Fat (g)
call FoodFact_Merge('123456790','646',0.7);
/
--Water (g)
call FoodFact_Merge('123456790','255',5);
/
--Energy, digestible (kcal)
call FoodFact_Merge('123456790','10009',394);
/
--Energy, carbohydrate (kcal)
call FoodFact_Merge('123456790','10011',20);
/
--Energy, protein (kcal)
call FoodFact_Merge('123456790','10012',320);
/
--Energy, fat (kcal)
call FoodFact_Merge('123456790','10013',54);
/
--Energy, alcohol (kcal)
call FoodFact_Merge('123456790','10014',0);
/