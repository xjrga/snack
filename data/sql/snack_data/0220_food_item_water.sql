--FOOD ITEM: Water
--
--Insert food item
call Food_Insert('123456753','Water');
/
--Put in in a food category
call CategoryLink_Insert('123456753','1400');
/
--Zero out food item food fact
call FoodFact_ZeroOut_FoodId('123456753');
/
--Update food item food fact with whatever available values there are
--
--Weight (g)
call FoodFact_Merge('123456753','10000',1);
/
--Water (g)
call FoodFact_Merge('123456753','255',1);
/