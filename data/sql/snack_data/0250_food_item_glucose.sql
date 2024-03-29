--FOOD ITEM: Glucose
--
--Insert food item
call Food_Insert('123456754','Glucose');
/
--Put in in a food category
call CategoryLink_Insert('123456754','6000');
/
--Zero out food item food fact
call FoodFact_ZeroOut_FoodId('123456754');
/
--'10000','Weight (g)'
call FoodFact_Merge('123456754','10000',100);
/
--'208','Energy (kcal)'
call FoodFact_Merge('123456754','208',400);
/
--'203','Protein (g)'
call FoodFact_Merge('123456754','203',0);
/
--'10001','Complete Protein (g)'
call FoodFact_Merge('123456754','10001',0);
/
--'204','Total lipid (Fat) (g)'
call FoodFact_Merge('123456754','204',0);
/
--'645','Fatty acids, total monounsaturated (g)'
call FoodFact_Merge('123456754','645',0);
/
--'646','Fatty acids, total polyunsaturated (g)'
call FoodFact_Merge('123456754','646',0);
/
--'606','Fatty acids, total saturated (g)'
call FoodFact_Merge('123456754','606',0);
/
--'601','Cholesterol (mg)'
call FoodFact_Merge('123456754','601',0);
/
--'621','22:6 n-3 (DHA) (g)'
call FoodFact_Merge('123456754','621',0);
/
--'629','20:5 n-3 (EPA) (g)'
call FoodFact_Merge('123456754','629',0);
/
--'205','Carbohydrate, by difference (g)'
call FoodFact_Merge('123456754','205',100);
/
--'10003','Digestible Carbohydrate (g)'
call FoodFact_Merge('123456754','10003',100);
/
--'291','Fiber, total dietary (g)'
call FoodFact_Merge('123456754','291',0);
/
--'320','Vitamin A, RAE (µg)'
call FoodFact_Merge('123456754','320',0);
/
--'323','Vitamin E (Alpha-Tocopherol) (mg)'
call FoodFact_Merge('123456754','323',0);
/
--'328','Vitamin D (D2 + D3) (µg)'
call FoodFact_Merge('123456754','328',0);
/
--'401','Vitamin C, total (Ascorbic Acid) (mg)'
call FoodFact_Merge('123456754','401',0);
/
--'404','Thiamin (mg)'
call FoodFact_Merge('123456754','404',0);
/
--'405','Riboflavin (mg)'
call FoodFact_Merge('123456754','405',0);
/
--'406','Niacin (mg)'
call FoodFact_Merge('123456754','406',0);
/
--'410','Pantothenic acid (mg)'
call FoodFact_Merge('123456754','410',0);
/
--'415','Vitamin B-6 (mg)'
call FoodFact_Merge('123456754','415',0);
/
--'418','Vitamin B-12 (µg)'
call FoodFact_Merge('123456754','418',0);
/
--'421','Choline, total (mg)'
call FoodFact_Merge('123456754','421',0);
/
--'430','Vitamin K (Phylloquinone) (µg)'
call FoodFact_Merge('123456754','430',0);
/
--'435','Folate, DFE (µg)'
call FoodFact_Merge('123456754','435',0);
/
--'301','Calcium, Ca (mg)'
call FoodFact_Merge('123456754','301',0);
/
--'303','Iron, Fe (mg)'
call FoodFact_Merge('123456754','303',0);
/
--'304','Magnesium, Mg (mg)'
call FoodFact_Merge('123456754','304',0);
/
--'305','Phosphorus, P (mg)'
call FoodFact_Merge('123456754','305',0);
/
--'306','Potassium, K (mg)'
call FoodFact_Merge('123456754','306',0);
/
--'307','Sodium, Na (mg)'
call FoodFact_Merge('123456754','307',0);
/
--'309','Zinc, Zn (mg)'
call FoodFact_Merge('123456754','309',0);
/
--'312','Copper, Cu (mg)'
call FoodFact_Merge('123456754','312',0);
/
--'315','Manganese, Mn (mg)'
call FoodFact_Merge('123456754','315',0);
/
--'317','Selenium, Se (µg)'
call FoodFact_Merge('123456754','317',0);
/
--'221','Alcohol, ethyl (g)'
call FoodFact_Merge('123456754','221',0);
/
--'255','Water (g)'
call FoodFact_Merge('123456754','255',0);
/
--'10005','Cost (g)'
call FoodFact_Merge('123456754','10005',0);
/
--Energy, alcohol (kcal)
call FoodFact_Merge('123456754','10014',0);
/
CALL CategoryLink_Insert('123456754','10000');
/