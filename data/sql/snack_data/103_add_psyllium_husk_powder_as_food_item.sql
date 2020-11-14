--FOOD ITEM: Psyllium Husk Powder
--
--Insert food item
call Food_Insert('123496753','Psyllium Husk Powder');
/
--Put in in a food category
call CategoryLink_Insert('123496753','6000');
/
--Zero out food item food fact
call FoodFact_ZeroOut_FoodId('123496753');
/
--Update food item food fact with whatever available values there are
--
--Weight (g)
call FoodFact_Merge('123496753','10000',9);
/
--Energy (kcal)
call FoodFact_Merge('123496753','208',4);
/
--Sodium (mg)
call FoodFact_Merge('123496753','307',10);
/
--Carbohydrate, by difference (g)
call FoodFact_Merge('123496753','205',8);
/
--Fiber, total dietary (g)
call FoodFact_Merge('123496753','291',7);
/
--Digestible Carbohydrate (g)
call FoodFact_Merge('123496753','10003',1);
/
--Iron (mg)
call FoodFact_Merge('123496753','303',1.5);
/
--Potassium, K (mg)
call FoodFact_Merge('123496753','306',87);
/
--Fiber, Insoluble (g)
call FoodFact_Merge('123496753','10006',0.7875);
/
--Fiber, Soluble (g)
call FoodFact_Merge('123496753','10007',6.2125);
/
