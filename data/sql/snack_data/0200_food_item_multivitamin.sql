--FOOD ITEM: Generic Multivitamin
--
--Insert food item
call Food_Insert('123456789','Generic Multivitamin');
/
--Put in in a food category
call CategoryLink_Insert('123456789','6000');
/
--Zero out food item food fact
call FoodFact_ZeroOut_FoodId('123456789');
/
--Update food item food fact with whatever available values there are
--
--Weight (g)
call FoodFact_Merge('123456789','10000',1.4);
/
--Calcium (mg)
call FoodFact_Merge('123456789','301',220);
/
--Iron (mg)
call FoodFact_Merge('123456789','303',0);
/
--Magnesium (mg)
call FoodFact_Merge('123456789','304',50);
/
--Phosphorus (mg)
call FoodFact_Merge('123456789','305',20);
/
--Zinc (mg)
call FoodFact_Merge('123456789','309',11);
/
--Selenium (mcg)
call FoodFact_Merge('123456789','317',19);
/
--Vitamin A (mcg)
call FoodFact_Merge('123456789','320',750);
/
--Vitamin E (mg)
call FoodFact_Merge('123456789','323',50);
/
--Vitamin D (mcg)
call FoodFact_Merge('123456789','328',25);
/
--Vitamin C (mg)
call FoodFact_Merge('123456789','401',60);
/
--Thiamin (mg)
call FoodFact_Merge('123456789','404',1.5);
/
--Riboflavin (mg)
call FoodFact_Merge('123456789','405',1.7);
/
--Niacin (mg)
call FoodFact_Merge('123456789','406',20);
/
--Vitamin B6 (mg)
call FoodFact_Merge('123456789','415',3);
/
--Vitamin B12 (mcg)
call FoodFact_Merge('123456789','418',25);
/
--Vitamin K (mcg)
call FoodFact_Merge('123456789','430',30);
/
--Folate (mcg)
call FoodFact_Merge('123456789','435',680);
/
--Pantothenic acid (mg)
call FoodFact_Merge('123456789','410',10);
/
--Copper, Cu (mg)
call FoodFact_Merge('123456789','312',0.5);
/
--Manganese, Mn (mg)
call FoodFact_Merge('123456789','315',2.3);
/
--Potassium, K (mg)
call FoodFact_Merge('123456789','306',80);
/