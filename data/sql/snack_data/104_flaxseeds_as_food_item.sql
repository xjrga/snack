--FOOD ITEM: Seeds, flaxseed (EFAs)
--
--Insert food item
call Food_Insert('kVJIZFHV4H','Seeds, flaxseed (EFAs)');
/
--Put in in a food category
call CategoryLink_Insert('kVJIZFHV4H','1200');
/
--Zero out food item food fact
call FoodFact_ZeroOut_FoodId('kVJIZFHV4H');
/
--Update food item food fact with whatever available values there are
--
--'10000','Weight (g)'
call FoodFact_Merge('kVJIZFHV4H','10000',100);
/
--'208','Energy, gross (kcal)'
call FoodFact_Merge('kVJIZFHV4H','208',534);
/
--'203','Protein (g)'
call FoodFact_Merge('kVJIZFHV4H','203',18.29);
/
--'10001','Complete Protein (g)'
call FoodFact_Merge('kVJIZFHV4H','10001',0);
/
--'204','Total lipid (Fat) (g)'
call FoodFact_Merge('kVJIZFHV4H','204',42.16);
/
--'645','Fatty acids, total monounsaturated (g)'
call FoodFact_Merge('kVJIZFHV4H','645',7.52);
/
--'646','Fatty acids, total polyunsaturated (g)'
call FoodFact_Merge('kVJIZFHV4H','646',28.73);
/
--'606','Fatty acids, total saturated (g)'
call FoodFact_Merge('kVJIZFHV4H','606',3.66);
/
--'601','Cholesterol (mg)'
call FoodFact_Merge('kVJIZFHV4H','601',0);
/
--'675','18:2 n-6 c,c (Linoleic) (g)'
call FoodFact_Merge('kVJIZFHV4H','675',6.02888);
/
--'851','18:3 n-3 c,c,c (Alpha-Linolenic) (g)'
call FoodFact_Merge('kVJIZFHV4H','851',24.4528);
/
--'621','22:6 n-3 (DHA) (g)'
call FoodFact_Merge('kVJIZFHV4H','621',0);
/
--'629','20:5 n-3 (EPA) (g)'
call FoodFact_Merge('kVJIZFHV4H','629',0);
/
--'205','Carbohydrate, by difference (g)'
call FoodFact_Merge('kVJIZFHV4H','205',28.88);
/
--'10003','Digestible Carbohydrate (g)'
call FoodFact_Merge('kVJIZFHV4H','10003',1.58);
/
--'291','Fiber, total dietary (g)'
call FoodFact_Merge('kVJIZFHV4H','291',27.3);
/
--'320','Vitamin A, RAE (µg)'
call FoodFact_Merge('kVJIZFHV4H','320',0);
/
--'323','Vitamin E (Alpha-Tocopherol) (mg)'
call FoodFact_Merge('kVJIZFHV4H','323',0.31);
/
--'328','Vitamin D (D2 + D3) (µg)'
call FoodFact_Merge('kVJIZFHV4H','328',0);
/
--'401','Vitamin C, total (Ascorbic Acid) (mg)'
call FoodFact_Merge('kVJIZFHV4H','401',0.6);
/
--'404','Thiamin (mg)'
call FoodFact_Merge('kVJIZFHV4H','404',1.64);
/
--'405','Riboflavin (mg)'
call FoodFact_Merge('kVJIZFHV4H','405',0.16);
/
--'406','Niacin (mg)'
call FoodFact_Merge('kVJIZFHV4H','406',3.08);
/
--'410','Pantothenic acid (mg)'
call FoodFact_Merge('kVJIZFHV4H','410',0.98);
/
--'415','Vitamin B-6 (mg)'
call FoodFact_Merge('kVJIZFHV4H','415',0.47);
/
--'418','Vitamin B-12 (µg)'
call FoodFact_Merge('kVJIZFHV4H','418',0);
/
--'421','Choline, total (mg)'
call FoodFact_Merge('kVJIZFHV4H','421',78.7);
/
--'430','Vitamin K (Phylloquinone) (µg)'
call FoodFact_Merge('kVJIZFHV4H','430',4.3);
/
--'435','Folate, DFE (µg)'
call FoodFact_Merge('kVJIZFHV4H','435',87);
/
--'301','Calcium, Ca (mg)'
call FoodFact_Merge('kVJIZFHV4H','301',255);
/
--'303','Iron, Fe (mg)'
call FoodFact_Merge('kVJIZFHV4H','303',5.73);
/
--'304','Magnesium, Mg (mg)'
call FoodFact_Merge('kVJIZFHV4H','304',392);
/
--'305','Phosphorus, P (mg)'
call FoodFact_Merge('kVJIZFHV4H','305',642);
/
--'306','Potassium, K (mg)'
call FoodFact_Merge('kVJIZFHV4H','306',813);
/
--'307','Sodium, Na (mg)'
call FoodFact_Merge('kVJIZFHV4H','307',30);
/
--'309','Zinc, Zn (mg)'
call FoodFact_Merge('kVJIZFHV4H','309',4.34);
/
--'312','Copper, Cu (mg)'
call FoodFact_Merge('kVJIZFHV4H','312',1.22);
/
--'313','Fluoride, F (µg)'
call FoodFact_Merge('kVJIZFHV4H','313',0);
/
--'315','Manganese, Mn (mg)'
call FoodFact_Merge('kVJIZFHV4H','315',2.48);
/
--'317','Selenium, Se (µg)'
call FoodFact_Merge('kVJIZFHV4H','317',25.4);
/
--'221','Alcohol, ethyl (g)'
call FoodFact_Merge('kVJIZFHV4H','221',0);
/
--'255','Water (g)'
call FoodFact_Merge('kVJIZFHV4H','255',6.96);
/
--'10005','Cost (g)'
call FoodFact_Merge('kVJIZFHV4H','10005',0);
/
--Energy, digestible (kcal)
call FoodFact_Merge('kVJIZFHV4H','10009',458.92);
/
--Energy, no protein (kcal)
call FoodFact_Merge('kVJIZFHV4H','10010',385.76);
/
--Energy, carbohydrate (kcal)
call FoodFact_Merge('kVJIZFHV4H','10011',6.32);
/
--Energy, protein (kcal)
call FoodFact_Merge('kVJIZFHV4H','10012',73.16);
/
--Energy, fat (kcal)
call FoodFact_Merge('kVJIZFHV4H','10013',379.44);
/
--Energy, alcohol (kcal)
call FoodFact_Merge('kVJIZFHV4H','10014',0);
/