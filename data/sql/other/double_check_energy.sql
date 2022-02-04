select a.MixId,
       a.FoodId,
       b.Name,
       Round(a.Weight,0) as Weight,
       Round(Energy,0) as Energy,
       Round(EnergyDigestible,0) as EnergyDigestible,       
       Round(EnergyFat,0) as EnergyFat,
       Round(EnergyCarbohydrate,0) as EnergyCarbohydrate,
       Round(EnergyProtein,0) as EnergyProtein,       
       Round(EnergyAlcohol,0) as EnergyAlcohol,
       Round(Fat,0) as Fat,
       Round(DigestibleCarbohydrate,0) as DigestibleCarbohydrate,
       Round(Protein,0) as Protein,
       Round(Alcohol,0) as Alcohol,       
       Round(CarbsByDiff,0) as CarbsByDiff,             
       Round(Fiber,0) as Fiber
from
(
select
       x0.Mixid,
       x0.Foodid,
       x1.Weight,
       x2.CompleteProtein,     
       x4.DigestibleCarbohydrate,
       x5.Cost,
       x6.Protein,
       x7.Fat,
       x8.CarbsByDiff,
       x9.Energy,
       x13.Alcohol,
       x14.Water,
       x15.Fiber,
       x16.Calcium,
       x17.Iron,
       x18.Magnesium,
       x19.Phosphorus,
       x20.Potassium,
       x21.Sodium,
       x22.Zinc,
       x23.Copper,
       x24.Fluoride,
       x25.Manganese,
       x26.Selenium,
       x27.VitaminA,
       x28.VitaminE,
       x29.VitaminD,
       x30.VitaminC,
       x31.Thiamin,
       x32.Riboflavin,
       x33.Niacin,
       x34.Pantothenic,
       x35.VitaminB6,
       x36.VitaminB12,
       x37.Choline,
       x38.VitaminK,
       x39.Folate,
       x40.Cholesterol,
       x41.Saturated,
       x42.DHA,
       x43.EPA,
       x44.Monounsaturated,
       x45.Polyunsaturated,
       x46.Linoleic,
       x47.AlphaLinolenic,
       x50.GlycemicLoad,
       x51.EnergyDigestible,       
       x53.EnergyCarbohydrate,
       x54.EnergyProtein,
       x55.EnergyFat,
       x56.EnergyAlcohol
from
--
(
select mixid,foodid from mixfood where mixid = 0
) x0,
--
--10000	Weight (g)
(
select mixid,foodid,q as Weight from mixresult
where mixid = 0
and nutrientid = '10000'
) x1,
--
--10001	Complete Protein (g)
(
select mixid,foodid,q as CompleteProtein from mixresult
where mixid = 0
and nutrientid = '10001'
) x2,
--
--10003	Digestible Carbohydrate (g)
(
select mixid,foodid,q as DigestibleCarbohydrate from mixresult
where mixid = 0
and nutrientid = '10003'
) x4,
--
--10005	Cost (g)
(
select mixid,foodid,q as Cost from mixresult
where mixid = 0
and nutrientid = '10005'
) x5,
--
--203	Protein (g)
(
select mixid,foodid,q as Protein from mixresult
where mixid = 0
and nutrientid = '203'
) x6,
--
--204	Total lipid (Fat) (g)
(
select mixid,foodid,q as Fat from mixresult
where mixid = 0
and nutrientid = '204'
) x7,
--205	Carbohydrate, by difference (g)
(
select mixid,foodid,q as Carbsbydiff from mixresult
where mixid = 0
and nutrientid = '205'
) x8,
--
--208	Energy (kcal)
(
select mixid,foodid,q as Energy from mixresult
where mixid = 0
and nutrientid = '208'
) x9,
--221	Alcohol, ethyl (g)
(
select mixid,foodid,q as Alcohol from mixresult
where mixid = 0
and nutrientid = '221'
) x13,
--255	Water (g)
(
select mixid,foodid,q as Water from mixresult
where mixid = 0
and nutrientid = '255'
) x14,
--291	Fiber, total dietary (g)
(
select mixid,foodid,q as Fiber from mixresult
where mixid = 0
and nutrientid = '291'
) x15,
--301	Calcium, Ca (mg)
(
select mixid,foodid,q as Calcium from mixresult
where mixid = 0
and nutrientid = '301'
) x16,
--303	Iron, Fe (mg)
(
select mixid,foodid,q as Iron from mixresult
where mixid = 0
and nutrientid = '303'
) x17,
--304	Magnesium, Mg (mg)
(
select mixid,foodid,q as Magnesium from mixresult
where mixid = 0
and nutrientid = '304'
) x18,
--305	Phosphorus, P (mg)
(
select mixid,foodid,q as Phosphorus from mixresult
where mixid = 0
and nutrientid = '305'
) x19,
--306	Potassium, K (mg)
(
select mixid,foodid,q as Potassium from mixresult
where mixid = 0
and nutrientid = '306'
) x20,
--307	Sodium, Na (mg)
(
select mixid,foodid,q as Sodium from mixresult
where mixid = 0
and nutrientid = '307'
) x21,
--309	Zinc, Zn (mg)
(
select mixid,foodid,q as Zinc from mixresult
where mixid = 0
and nutrientid = '309'
) x22,
--312	Copper, Cu (mg)
(
select mixid,foodid,q as Copper from mixresult
where mixid = 0
and nutrientid = '312'
) x23,
--313	Fluoride, F (µg)
(
select mixid,foodid,q as Fluoride from mixresult
where mixid = 0
and nutrientid = '313'
) x24,
--315	Manganese, Mn (mg)
(
select mixid,foodid,q as Manganese from mixresult
where mixid = 0
and nutrientid = '315'
) x25,
--317	Selenium, Se (µg)
(
select mixid,foodid,q as Selenium from mixresult
where mixid = 0
and nutrientid = '317'
) x26,
--320	Vitamin A, RAE (µg)
(
select mixid,foodid,q as VitaminA from mixresult
where mixid = 0
and nutrientid = '320'
) x27,
--323	Vitamin E (Alpha-Tocopherol) (mg)
(
select mixid,foodid,q as VitaminE from mixresult
where mixid = 0
and nutrientid = '323'
) x28,
--328	Vitamin D (D2 + D3) (µg)
(
select mixid,foodid,q as VitaminD from mixresult
where mixid = 0
and nutrientid = '328'
) x29,
--401	Vitamin C, total (Ascorbic Acid) (mg)
(
select mixid,foodid,q as VitaminC from mixresult
where mixid = 0
and nutrientid = '401'
) x30,
--404	Thiamin (mg)
(
select mixid,foodid,q as Thiamin from mixresult
where mixid = 0
and nutrientid = '404'
) x31,
--405	Riboflavin (mg)
(
select mixid,foodid,q as Riboflavin from mixresult
where mixid = 0
and nutrientid = '405'
) x32,
--406	Niacin (mg)
(
select mixid,foodid,q as Niacin from mixresult
where mixid = 0
and nutrientid = '406'
) x33,
--410	Pantothenic acid (mg)
(
select mixid,foodid,q as Pantothenic from mixresult
where mixid = 0
and nutrientid = '410'
) x34,
--415	Vitamin B-6 (mg)
(
select mixid,foodid,q as VitaminB6 from mixresult
where mixid = 0
and nutrientid = '415'
) x35,
--418	Vitamin B-12 (µg)
(
select mixid,foodid,q as VitaminB12 from mixresult
where mixid = 0
and nutrientid = '418'
) x36,
--421	Choline, total (mg)
(
select mixid,foodid,q as Choline from mixresult
where mixid = 0
and nutrientid = '421'
) x37,
--430	Vitamin K (Phylloquinone) (µg)
(
select mixid,foodid,q as VitaminK from mixresult
where mixid = 0
and nutrientid = '430'
) x38,
--435	Folate, DFE (µg)
(
select mixid,foodid,q as Folate from mixresult
where mixid = 0
and nutrientid = '435'
) x39,
--601	Cholesterol (mg)
(
select mixid,foodid,q as Cholesterol from mixresult
where mixid = 0
and nutrientid = '601'
) x40,
--606	Fatty acids, total saturated (g)
(
select mixid,foodid,q as Saturated from mixresult
where mixid = 0
and nutrientid = '606'
) x41,
--621	22:6 n-3 (DHA) (g)
(
select mixid,foodid,q as DHA from mixresult
where mixid = 0
and nutrientid = '621'
) x42,
--629	20:5 n-3 (EPA) (g)
(
select mixid,foodid,q as EPA from mixresult
where mixid = 0
and nutrientid = '629'
) x43,
--645	Fatty acids, total monounsaturated (g)
(
select mixid,foodid,q as Monounsaturated from mixresult
where mixid = 0
and nutrientid = '645'
) x44,
--646	Fatty acids, total polyunsaturated (g)
(
select mixid,foodid,q as Polyunsaturated from mixresult
where mixid = 0
and nutrientid = '646'
) x45,
--675	18:2 n-6 c,c (Linoleic) (g)
(
select mixid,foodid,q as Linoleic from mixresult
where mixid = 0
and nutrientid = '675'
) x46,
--851	18:3 n-3 c,c,c (Alpha-Linolenic) (g)
(
select mixid,foodid,q as AlphaLinolenic from mixresult
where mixid = 0
and nutrientid = '851'
) x47,
--10006	Glycemic Load
(
select mixid,foodid,q as GlycemicLoad from mixresult
where mixid = 0
and nutrientid = '10006'
) x50,
--10009	Energy, digestible (kcal)
(
select mixid,foodid,q as EnergyDigestible from mixresult
where mixid = 0
and nutrientid = '10009'
) x51,
--10011	Energy, carbohydrate (kcal)
(
select mixid,foodid,q as EnergyCarbohydrate from mixresult
where mixid = 0
and nutrientid = '10011'
) x53,
--10012	Energy, protein (kcal)
(
select mixid,foodid,q as EnergyProtein from mixresult
where mixid = 0
and nutrientid = '10012'
) x54,
--10013	Energy, fat (kcal)
(
select mixid,foodid,q as EnergyFat from mixresult
where mixid = 0
and nutrientid = '10013'
) x55,
--10014	Energy, no alcohol (kcal)
(
select mixid,foodid,q as EnergyAlcohol from mixresult
where mixid = 0
and nutrientid = '10014'
) x56
--
where x0.mixid = x1.mixid
and x0.foodid = x1.foodid
and x0.mixid = x2.mixid
and x0.foodid = x2.foodid
and x0.mixid = x4.mixid
and x0.foodid = x4.foodid
and x0.mixid = x5.mixid
and x0.foodid = x5.foodid
and x0.mixid = x6.mixid
and x0.foodid = x6.foodid
and x0.mixid = x7.mixid
and x0.foodid = x7.foodid
and x0.mixid = x8.mixid
and x0.foodid = x8.foodid
and x0.mixid = x9.mixid
and x0.foodid = x9.foodid
and x0.mixid = x13.mixid
and x0.foodid = x13.foodid
and x0.mixid = x14.mixid
and x0.foodid = x14.foodid
and x0.mixid = x15.mixid
and x0.foodid = x15.foodid
and x0.mixid = x16.mixid
and x0.foodid = x16.foodid
and x0.mixid = x17.mixid
and x0.foodid = x17.foodid
and x0.mixid = x18.mixid
and x0.foodid = x18.foodid
and x0.mixid = x19.mixid
and x0.foodid = x19.foodid
and x0.mixid = x20.mixid
and x0.foodid = x20.foodid
and x0.mixid = x21.mixid
and x0.foodid = x21.foodid
and x0.mixid = x22.mixid
and x0.foodid = x22.foodid
and x0.mixid = x23.mixid
and x0.foodid = x23.foodid
and x0.mixid = x24.mixid
and x0.foodid = x24.foodid
and x0.mixid = x25.mixid
and x0.foodid = x25.foodid
and x0.mixid = x26.mixid
and x0.foodid = x26.foodid
and x0.mixid = x27.mixid
and x0.foodid = x27.foodid
and x0.mixid = x28.mixid
and x0.foodid = x28.foodid
and x0.mixid = x29.mixid
and x0.foodid = x29.foodid
and x0.mixid = x30.mixid
and x0.foodid = x30.foodid
and x0.mixid = x31.mixid
and x0.foodid = x31.foodid
and x0.mixid = x32.mixid
and x0.foodid = x32.foodid
and x0.mixid = x33.mixid
and x0.foodid = x33.foodid
and x0.mixid = x34.mixid
and x0.foodid = x34.foodid
and x0.mixid = x35.mixid
and x0.foodid = x35.foodid
and x0.mixid = x36.mixid
and x0.foodid = x36.foodid
and x0.mixid = x37.mixid
and x0.foodid = x37.foodid
and x0.mixid = x38.mixid
and x0.foodid = x38.foodid
and x0.mixid = x39.mixid
and x0.foodid = x39.foodid
and x0.mixid = x40.mixid
and x0.foodid = x40.foodid
and x0.mixid = x41.mixid
and x0.foodid = x41.foodid
and x0.mixid = x42.mixid
and x0.foodid = x42.foodid
and x0.mixid = x43.mixid
and x0.foodid = x43.foodid
and x0.mixid = x44.mixid
and x0.foodid = x44.foodid
and x0.mixid = x45.mixid
and x0.foodid = x45.foodid
and x0.mixid = x46.mixid
and x0.foodid = x46.foodid
and x0.mixid = x47.mixid
and x0.foodid = x47.foodid
and x0.mixid = x50.mixid
and x0.foodid = x50.foodid
and x0.mixid = x51.mixid
and x0.foodid = x51.foodid
and x0.mixid = x53.mixid
and x0.foodid = x53.foodid
and x0.mixid = x54.mixid
and x0.foodid = x54.foodid
and x0.mixid = x55.mixid
and x0.foodid = x55.foodid
and x0.mixid = x56.mixid
and x0.foodid = x56.foodid
) a,
(
select foodid,name from food
) b
where a.foodid = b.foodid
--
union
--
select a.MixId,
       '',
       'Total',
       Round(sum(a.Weight),0),
       Round(sum(Energy),0),
       Round(sum(EnergyDigestible),0),       
       Round(sum(EnergyFat),0),
       Round(sum(EnergyCarbohydrate),0),
       Round(sum(EnergyProtein),0),       
       Round(sum(EnergyAlcohol),0),
       Round(sum(Fat),0),
       Round(sum(DigestibleCarbohydrate),0),      
       Round(sum(Protein),0),
       Round(sum(Alcohol),0),     
       Round(sum(CarbsByDiff),0),
       Round(sum(Fiber),0)       
from
(
select
       x0.Mixid,
       x0.Foodid,
       x1.Weight,
       x2.CompleteProtein,     
       x4.DigestibleCarbohydrate,
       x5.Cost,
       x6.Protein,
       x7.Fat,
       x8.CarbsByDiff,
       x9.Energy,
       x13.Alcohol,
       x14.Water,
       x15.Fiber,
       x16.Calcium,
       x17.Iron,
       x18.Magnesium,
       x19.Phosphorus,
       x20.Potassium,
       x21.Sodium,
       x22.Zinc,
       x23.Copper,
       x24.Fluoride,
       x25.Manganese,
       x26.Selenium,
       x27.VitaminA,
       x28.VitaminE,
       x29.VitaminD,
       x30.VitaminC,
       x31.Thiamin,
       x32.Riboflavin,
       x33.Niacin,
       x34.Pantothenic,
       x35.VitaminB6,
       x36.VitaminB12,
       x37.Choline,
       x38.VitaminK,
       x39.Folate,
       x40.Cholesterol,
       x41.Saturated,
       x42.DHA,
       x43.EPA,
       x44.Monounsaturated,
       x45.Polyunsaturated,
       x46.Linoleic,
       x47.AlphaLinolenic,
       x50.GlycemicLoad,
       x51.EnergyDigestible,       
       x53.EnergyCarbohydrate,
       x54.EnergyProtein,
       x55.EnergyFat,
       x56.EnergyAlcohol
from
--
(
select mixid,foodid from mixfood where mixid = 0
) x0,
--
--10000	Weight (g)
(
select mixid,foodid,q as Weight from mixresult
where mixid = 0
and nutrientid = '10000'
) x1,
--
--10001	Complete Protein (g)
(
select mixid,foodid,q as CompleteProtein from mixresult
where mixid = 0
and nutrientid = '10001'
) x2,
--
--10003	Digestible Carbohydrate (g)
(
select mixid,foodid,q as DigestibleCarbohydrate from mixresult
where mixid = 0
and nutrientid = '10003'
) x4,
--
--10005	Cost (g)
(
select mixid,foodid,q as Cost from mixresult
where mixid = 0
and nutrientid = '10005'
) x5,
--
--203	Protein (g)
(
select mixid,foodid,q as Protein from mixresult
where mixid = 0
and nutrientid = '203'
) x6,
--
--204	Total lipid (Fat) (g)
(
select mixid,foodid,q as Fat from mixresult
where mixid = 0
and nutrientid = '204'
) x7,
--205	Carbohydrate, by difference (g)
(
select mixid,foodid,q as Carbsbydiff from mixresult
where mixid = 0
and nutrientid = '205'
) x8,
--
--208	Energy (kcal)
(
select mixid,foodid,q as Energy from mixresult
where mixid = 0
and nutrientid = '208'
) x9,
--221	Alcohol, ethyl (g)
(
select mixid,foodid,q as Alcohol from mixresult
where mixid = 0
and nutrientid = '221'
) x13,
--255	Water (g)
(
select mixid,foodid,q as Water from mixresult
where mixid = 0
and nutrientid = '255'
) x14,
--291	Fiber, total dietary (g)
(
select mixid,foodid,q as Fiber from mixresult
where mixid = 0
and nutrientid = '291'
) x15,
--301	Calcium, Ca (mg)
(
select mixid,foodid,q as Calcium from mixresult
where mixid = 0
and nutrientid = '301'
) x16,
--303	Iron, Fe (mg)
(
select mixid,foodid,q as Iron from mixresult
where mixid = 0
and nutrientid = '303'
) x17,
--304	Magnesium, Mg (mg)
(
select mixid,foodid,q as Magnesium from mixresult
where mixid = 0
and nutrientid = '304'
) x18,
--305	Phosphorus, P (mg)
(
select mixid,foodid,q as Phosphorus from mixresult
where mixid = 0
and nutrientid = '305'
) x19,
--306	Potassium, K (mg)
(
select mixid,foodid,q as Potassium from mixresult
where mixid = 0
and nutrientid = '306'
) x20,
--307	Sodium, Na (mg)
(
select mixid,foodid,q as Sodium from mixresult
where mixid = 0
and nutrientid = '307'
) x21,
--309	Zinc, Zn (mg)
(
select mixid,foodid,q as Zinc from mixresult
where mixid = 0
and nutrientid = '309'
) x22,
--312	Copper, Cu (mg)
(
select mixid,foodid,q as Copper from mixresult
where mixid = 0
and nutrientid = '312'
) x23,
--313	Fluoride, F (µg)
(
select mixid,foodid,q as Fluoride from mixresult
where mixid = 0
and nutrientid = '313'
) x24,
--315	Manganese, Mn (mg)
(
select mixid,foodid,q as Manganese from mixresult
where mixid = 0
and nutrientid = '315'
) x25,
--317	Selenium, Se (µg)
(
select mixid,foodid,q as Selenium from mixresult
where mixid = 0
and nutrientid = '317'
) x26,
--320	Vitamin A, RAE (µg)
(
select mixid,foodid,q as VitaminA from mixresult
where mixid = 0
and nutrientid = '320'
) x27,
--323	Vitamin E (Alpha-Tocopherol) (mg)
(
select mixid,foodid,q as VitaminE from mixresult
where mixid = 0
and nutrientid = '323'
) x28,
--328	Vitamin D (D2 + D3) (µg)
(
select mixid,foodid,q as VitaminD from mixresult
where mixid = 0
and nutrientid = '328'
) x29,
--401	Vitamin C, total (Ascorbic Acid) (mg)
(
select mixid,foodid,q as VitaminC from mixresult
where mixid = 0
and nutrientid = '401'
) x30,
--404	Thiamin (mg)
(
select mixid,foodid,q as Thiamin from mixresult
where mixid = 0
and nutrientid = '404'
) x31,
--405	Riboflavin (mg)
(
select mixid,foodid,q as Riboflavin from mixresult
where mixid = 0
and nutrientid = '405'
) x32,
--406	Niacin (mg)
(
select mixid,foodid,q as Niacin from mixresult
where mixid = 0
and nutrientid = '406'
) x33,
--410	Pantothenic acid (mg)
(
select mixid,foodid,q as Pantothenic from mixresult
where mixid = 0
and nutrientid = '410'
) x34,
--415	Vitamin B-6 (mg)
(
select mixid,foodid,q as VitaminB6 from mixresult
where mixid = 0
and nutrientid = '415'
) x35,
--418	Vitamin B-12 (µg)
(
select mixid,foodid,q as VitaminB12 from mixresult
where mixid = 0
and nutrientid = '418'
) x36,
--421	Choline, total (mg)
(
select mixid,foodid,q as Choline from mixresult
where mixid = 0
and nutrientid = '421'
) x37,
--430	Vitamin K (Phylloquinone) (µg)
(
select mixid,foodid,q as VitaminK from mixresult
where mixid = 0
and nutrientid = '430'
) x38,
--435	Folate, DFE (µg)
(
select mixid,foodid,q as Folate from mixresult
where mixid = 0
and nutrientid = '435'
) x39,
--601	Cholesterol (mg)
(
select mixid,foodid,q as Cholesterol from mixresult
where mixid = 0
and nutrientid = '601'
) x40,
--606	Fatty acids, total saturated (g)
(
select mixid,foodid,q as Saturated from mixresult
where mixid = 0
and nutrientid = '606'
) x41,
--621	22:6 n-3 (DHA) (g)
(
select mixid,foodid,q as DHA from mixresult
where mixid = 0
and nutrientid = '621'
) x42,
--629	20:5 n-3 (EPA) (g)
(
select mixid,foodid,q as EPA from mixresult
where mixid = 0
and nutrientid = '629'
) x43,
--645	Fatty acids, total monounsaturated (g)
(
select mixid,foodid,q as Monounsaturated from mixresult
where mixid = 0
and nutrientid = '645'
) x44,
--646	Fatty acids, total polyunsaturated (g)
(
select mixid,foodid,q as Polyunsaturated from mixresult
where mixid = 0
and nutrientid = '646'
) x45,
--675	18:2 n-6 c,c (Linoleic) (g)
(
select mixid,foodid,q as Linoleic from mixresult
where mixid = 0
and nutrientid = '675'
) x46,
--851	18:3 n-3 c,c,c (Alpha-Linolenic) (g)
(
select mixid,foodid,q as AlphaLinolenic from mixresult
where mixid = 0
and nutrientid = '851'
) x47,
--10006	Glycemic Load
(
select mixid,foodid,q as GlycemicLoad from mixresult
where mixid = 0
and nutrientid = '10006'
) x50,
--10009	Energy, digestible (kcal)
(
select mixid,foodid,q as EnergyDigestible from mixresult
where mixid = 0
and nutrientid = '10009'
) x51,
--10011	Energy, carbohydrate (kcal)
(
select mixid,foodid,q as EnergyCarbohydrate from mixresult
where mixid = 0
and nutrientid = '10011'
) x53,
--10012	Energy, protein (kcal)
(
select mixid,foodid,q as EnergyProtein from mixresult
where mixid = 0
and nutrientid = '10012'
) x54,
--10013	Energy, fat (kcal)
(
select mixid,foodid,q as EnergyFat from mixresult
where mixid = 0
and nutrientid = '10013'
) x55,
--10014	Energy, no alcohol (kcal)
(
select mixid,foodid,q as EnergyAlcohol from mixresult
where mixid = 0
and nutrientid = '10014'
) x56
--
where x0.mixid = x1.mixid
and x0.foodid = x1.foodid
and x0.mixid = x2.mixid
and x0.foodid = x2.foodid
and x0.mixid = x4.mixid
and x0.foodid = x4.foodid
and x0.mixid = x5.mixid
and x0.foodid = x5.foodid
and x0.mixid = x6.mixid
and x0.foodid = x6.foodid
and x0.mixid = x7.mixid
and x0.foodid = x7.foodid
and x0.mixid = x8.mixid
and x0.foodid = x8.foodid
and x0.mixid = x9.mixid
and x0.foodid = x9.foodid
and x0.mixid = x13.mixid
and x0.foodid = x13.foodid
and x0.mixid = x14.mixid
and x0.foodid = x14.foodid
and x0.mixid = x15.mixid
and x0.foodid = x15.foodid
and x0.mixid = x16.mixid
and x0.foodid = x16.foodid
and x0.mixid = x17.mixid
and x0.foodid = x17.foodid
and x0.mixid = x18.mixid
and x0.foodid = x18.foodid
and x0.mixid = x19.mixid
and x0.foodid = x19.foodid
and x0.mixid = x20.mixid
and x0.foodid = x20.foodid
and x0.mixid = x21.mixid
and x0.foodid = x21.foodid
and x0.mixid = x22.mixid
and x0.foodid = x22.foodid
and x0.mixid = x23.mixid
and x0.foodid = x23.foodid
and x0.mixid = x24.mixid
and x0.foodid = x24.foodid
and x0.mixid = x25.mixid
and x0.foodid = x25.foodid
and x0.mixid = x26.mixid
and x0.foodid = x26.foodid
and x0.mixid = x27.mixid
and x0.foodid = x27.foodid
and x0.mixid = x28.mixid
and x0.foodid = x28.foodid
and x0.mixid = x29.mixid
and x0.foodid = x29.foodid
and x0.mixid = x30.mixid
and x0.foodid = x30.foodid
and x0.mixid = x31.mixid
and x0.foodid = x31.foodid
and x0.mixid = x32.mixid
and x0.foodid = x32.foodid
and x0.mixid = x33.mixid
and x0.foodid = x33.foodid
and x0.mixid = x34.mixid
and x0.foodid = x34.foodid
and x0.mixid = x35.mixid
and x0.foodid = x35.foodid
and x0.mixid = x36.mixid
and x0.foodid = x36.foodid
and x0.mixid = x37.mixid
and x0.foodid = x37.foodid
and x0.mixid = x38.mixid
and x0.foodid = x38.foodid
and x0.mixid = x39.mixid
and x0.foodid = x39.foodid
and x0.mixid = x40.mixid
and x0.foodid = x40.foodid
and x0.mixid = x41.mixid
and x0.foodid = x41.foodid
and x0.mixid = x42.mixid
and x0.foodid = x42.foodid
and x0.mixid = x43.mixid
and x0.foodid = x43.foodid
and x0.mixid = x44.mixid
and x0.foodid = x44.foodid
and x0.mixid = x45.mixid
and x0.foodid = x45.foodid
and x0.mixid = x46.mixid
and x0.foodid = x46.foodid
and x0.mixid = x47.mixid
and x0.foodid = x47.foodid
and x0.mixid = x50.mixid
and x0.foodid = x50.foodid
and x0.mixid = x51.mixid
and x0.foodid = x51.foodid
and x0.mixid = x53.mixid
and x0.foodid = x53.foodid
and x0.mixid = x54.mixid
and x0.foodid = x54.foodid
and x0.mixid = x55.mixid
and x0.foodid = x55.foodid
and x0.mixid = x56.mixid
and x0.foodid = x56.foodid
) a,
(
select foodid,name from food
) b
where a.foodid = b.foodid
group by a.MixId
order by a.Energy,a.Weight,b.Name;
