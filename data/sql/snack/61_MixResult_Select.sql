CREATE PROCEDURE MixResult_Select (
IN v_MixId INTEGER,
IN v_Precision INTEGER
)
MODIFIES SQL DATA DYNAMIC RESULT SETS 1 BEGIN ATOMIC
DECLARE result CURSOR
FOR
select a.MixId,
       a.FoodId,
       b.Name,
       Round(a.Weight,v_Precision) as Weight,
       Round(CompleteProtein,v_Precision) as CompleteProtein,
       Round(IncompleteProtein,v_Precision) as IncompleteProtein,
       Round(DigestibleCarbohydrate,v_Precision) as DigestibleCarbohydrate,
       Round(Cost,v_Precision) as Cost,
       Round(Protein,v_Precision) as Protein,
       Round(Fat,v_Precision) as Fat,
       Round(CarbsByDiff,v_Precision) as CarbsByDiff,
       Round(Energy,v_Precision) as Energy,
       Round(Sucrose,v_Precision) as Sucrose,
       Round(Fructose,v_Precision) as Fructose,
       Round(Lactose,v_Precision) as Lactose,
       Round(Alcohol,v_Precision) as Alcohol,
       Round(Water,v_Precision) as Water,
       Round(Fiber,v_Precision) as Fiber,
       Round(Calcium,v_Precision) as Calcium,
       Round(Iron,v_Precision) as Iron,
       Round(Magnesium,v_Precision) as Magnesium,
       Round(Phosphorus,v_Precision) as Phosphorus,
       Round(Potassium,v_Precision) as Potassium,
       Round(Sodium,v_Precision) as Sodium,
       Round(Zinc,v_Precision) as Zinc,
       Round(Copper,v_Precision) as Copper,
       Round(Fluoride,v_Precision) as Fluoride,
       Round(Manganese,v_Precision) as Manganese,
       Round(Selenium,v_Precision) as Selenium,
       Round(VitaminA,v_Precision) as VitaminA,
       Round(VitaminE,v_Precision) as VitaminE,
       Round(VitaminD,v_Precision) as VitaminD,
       Round(VitaminC,v_Precision) as VitaminC,
       Round(Thiamin,v_Precision) as Thiamin,
       Round(Riboflavin,v_Precision) as Riboflavin,
       Round(Niacin,v_Precision) as Niacin,
       Round(Pantothenic,v_Precision) as Pantothenic,
       Round(VitaminB6,v_Precision) as VitaminB6,
       Round(VitaminB12,v_Precision) as VitaminB12,
       Round(Choline,v_Precision) as Choline,
       Round(VitaminK,v_Precision) as VitaminK,
       Round(Folate,v_Precision) as Folate,
       Round(Cholesterol,v_Precision) as Cholesterol,
       Round(Saturated,v_Precision) as Saturated,
       Round(DHA,v_Precision) as DHA,
       Round(EPA,v_Precision) as EPA,
       Round(Monounsaturated,v_Precision) as Monounsaturated,
       Round(Polyunsaturated,v_Precision) as Polyunsaturated,
       Round(Linoleic,v_Precision) as Linoleic,
       Round(AlphaLinolenic,v_Precision) as AlphaLinolenic,
       Round(FiberInsoluble,v_Precision) as FiberInsoluble,
       Round(FiberSoluble,v_Precision) as FiberSoluble,
       Round(GlycemicLoad,v_Precision) as GlycemicLoad
from
(
select
       x0.Mixid,
       x0.Foodid,
       x1.Weight,
       x2.CompleteProtein,
       x3.IncompleteProtein,
       x4.DigestibleCarbohydrate,
       x5.Cost,
       x6.Protein,
       x7.Fat,
       x8.CarbsByDiff,
       x9.Energy,
       x10.Sucrose,
       x11.Fructose,
       x12.Lactose,
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
       x48.FiberInsoluble,
       x49.FiberSoluble,
       x50.GlycemicLoad
from
--
(
select mixid,foodid from mixfood where mixid = v_MixId
) x0,
--
--10000	Weight (g)
(
select mixid,foodid,q as Weight from mixresult
where mixid = v_MixId
and nutrientid = '10000'
) x1,
--
--10001	Complete Protein (g)
(
select mixid,foodid,q as CompleteProtein from mixresult
where mixid = v_MixId
and nutrientid = '10001'
) x2,
--
--10002	Incomplete Protein (g)
(
select mixid,foodid,q as IncompleteProtein from mixresult
where mixid = v_MixId
and nutrientid = '10002'
) x3,
--
--10003	Digestible Carbohydrate (g)
(
select mixid,foodid,q as DigestibleCarbohydrate from mixresult
where mixid = v_MixId
and nutrientid = '10003'
) x4,
--
--10005	Cost (g)
(
select mixid,foodid,q as Cost from mixresult
where mixid = v_MixId
and nutrientid = '10005'
) x5,
--
--203	Protein (g)
(
select mixid,foodid,q as Protein from mixresult
where mixid = v_MixId
and nutrientid = '203'
) x6,
--
--204	Total lipid (Fat) (g)
(
select mixid,foodid,q as Fat from mixresult
where mixid = v_MixId
and nutrientid = '204'
) x7,
--205	Carbohydrate, by difference (g)
(
select mixid,foodid,q as Carbsbydiff from mixresult
where mixid = v_MixId
and nutrientid = '205'
) x8,
--
--208	Energy (kcal)
(
select mixid,foodid,q as Energy from mixresult
where mixid = v_MixId
and nutrientid = '208'
) x9,
--210	Sucrose (g)
(
select mixid,foodid,q as Sucrose from mixresult
where mixid = v_MixId
and nutrientid = '210'
) x10,
--212	Fructose (g)
(
select mixid,foodid,q as Fructose from mixresult
where mixid = v_MixId
and nutrientid = '212'
) x11,
--213	Lactose (g)
(
select mixid,foodid,q as Lactose from mixresult
where mixid = v_MixId
and nutrientid = '213'
) x12,
--221	Alcohol, ethyl (g)
(
select mixid,foodid,q as Alcohol from mixresult
where mixid = v_MixId
and nutrientid = '221'
) x13,
--255	Water (g)
(
select mixid,foodid,q as Water from mixresult
where mixid = v_MixId
and nutrientid = '255'
) x14,
--291	Fiber, total dietary (g)
(
select mixid,foodid,q as Fiber from mixresult
where mixid = v_MixId
and nutrientid = '291'
) x15,
--301	Calcium, Ca (mg)
(
select mixid,foodid,q as Calcium from mixresult
where mixid = v_MixId
and nutrientid = '301'
) x16,
--303	Iron, Fe (mg)
(
select mixid,foodid,q as Iron from mixresult
where mixid = v_MixId
and nutrientid = '303'
) x17,
--304	Magnesium, Mg (mg)
(
select mixid,foodid,q as Magnesium from mixresult
where mixid = v_MixId
and nutrientid = '304'
) x18,
--305	Phosphorus, P (mg)
(
select mixid,foodid,q as Phosphorus from mixresult
where mixid = v_MixId
and nutrientid = '305'
) x19,
--306	Potassium, K (mg)
(
select mixid,foodid,q as Potassium from mixresult
where mixid = v_MixId
and nutrientid = '306'
) x20,
--307	Sodium, Na (mg)
(
select mixid,foodid,q as Sodium from mixresult
where mixid = v_MixId
and nutrientid = '307'
) x21,
--309	Zinc, Zn (mg)
(
select mixid,foodid,q as Zinc from mixresult
where mixid = v_MixId
and nutrientid = '309'
) x22,
--312	Copper, Cu (mg)
(
select mixid,foodid,q as Copper from mixresult
where mixid = v_MixId
and nutrientid = '312'
) x23,
--313	Fluoride, F (µg)
(
select mixid,foodid,q as Fluoride from mixresult
where mixid = v_MixId
and nutrientid = '313'
) x24,
--315	Manganese, Mn (mg)
(
select mixid,foodid,q as Manganese from mixresult
where mixid = v_MixId
and nutrientid = '315'
) x25,
--317	Selenium, Se (µg)
(
select mixid,foodid,q as Selenium from mixresult
where mixid = v_MixId
and nutrientid = '317'
) x26,
--320	Vitamin A, RAE (µg)
(
select mixid,foodid,q as VitaminA from mixresult
where mixid = v_MixId
and nutrientid = '320'
) x27,
--323	Vitamin E (Alpha-Tocopherol) (mg)
(
select mixid,foodid,q as VitaminE from mixresult
where mixid = v_MixId
and nutrientid = '323'
) x28,
--328	Vitamin D (D2 + D3) (µg)
(
select mixid,foodid,q as VitaminD from mixresult
where mixid = v_MixId
and nutrientid = '328'
) x29,
--401	Vitamin C, total (Ascorbic Acid) (mg)
(
select mixid,foodid,q as VitaminC from mixresult
where mixid = v_MixId
and nutrientid = '401'
) x30,
--404	Thiamin (mg)
(
select mixid,foodid,q as Thiamin from mixresult
where mixid = v_MixId
and nutrientid = '404'
) x31,
--405	Riboflavin (mg)
(
select mixid,foodid,q as Riboflavin from mixresult
where mixid = v_MixId
and nutrientid = '405'
) x32,
--406	Niacin (mg)
(
select mixid,foodid,q as Niacin from mixresult
where mixid = v_MixId
and nutrientid = '406'
) x33,
--410	Pantothenic acid (mg)
(
select mixid,foodid,q as Pantothenic from mixresult
where mixid = v_MixId
and nutrientid = '410'
) x34,
--415	Vitamin B-6 (mg)
(
select mixid,foodid,q as VitaminB6 from mixresult
where mixid = v_MixId
and nutrientid = '415'
) x35,
--418	Vitamin B-12 (µg)
(
select mixid,foodid,q as VitaminB12 from mixresult
where mixid = v_MixId
and nutrientid = '418'
) x36,
--421	Choline, total (mg)
(
select mixid,foodid,q as Choline from mixresult
where mixid = v_MixId
and nutrientid = '421'
) x37,
--430	Vitamin K (Phylloquinone) (µg)
(
select mixid,foodid,q as VitaminK from mixresult
where mixid = v_MixId
and nutrientid = '430'
) x38,
--435	Folate, DFE (µg)
(
select mixid,foodid,q as Folate from mixresult
where mixid = v_MixId
and nutrientid = '435'
) x39,
--601	Cholesterol (mg)
(
select mixid,foodid,q as Cholesterol from mixresult
where mixid = v_MixId
and nutrientid = '601'
) x40,
--606	Fatty acids, total saturated (g)
(
select mixid,foodid,q as Saturated from mixresult
where mixid = v_MixId
and nutrientid = '606'
) x41,
--621	22:6 n-3 (DHA) (g)
(
select mixid,foodid,q as DHA from mixresult
where mixid = v_MixId
and nutrientid = '621'
) x42,
--629	20:5 n-3 (EPA) (g)
(
select mixid,foodid,q as EPA from mixresult
where mixid = v_MixId
and nutrientid = '629'
) x43,
--645	Fatty acids, total monounsaturated (g)
(
select mixid,foodid,q as Monounsaturated from mixresult
where mixid = v_MixId
and nutrientid = '645'
) x44,
--646	Fatty acids, total polyunsaturated (g)
(
select mixid,foodid,q as Polyunsaturated from mixresult
where mixid = v_MixId
and nutrientid = '646'
) x45,
--675	18:2 n-6 c,c (Linoleic) (g)
(
select mixid,foodid,q as Linoleic from mixresult
where mixid = v_MixId
and nutrientid = '675'
) x46,
--851	18:3 n-3 c,c,c (Alpha-Linolenic) (g)
(
select mixid,foodid,q as AlphaLinolenic from mixresult
where mixid = v_MixId
and nutrientid = '851'
) x47,
--10006	Fiber, Insoluble (g)
(
select mixid,foodid,q as FiberInsoluble from mixresult
where mixid = v_MixId
and nutrientid = '10006'
) x48,
--10007	Fiber, Soluble (g)
(
select mixid,foodid,q as FiberSoluble from mixresult
where mixid = v_MixId
and nutrientid = '10007'
) x49,
--10008	Glycemic Load
(
select mixid,foodid,q as GlycemicLoad from mixresult
where mixid = v_MixId
and nutrientid = '10008'
) x50
--
where x0.mixid = x1.mixid
and x0.foodid = x1.foodid
and x0.mixid = x2.mixid
and x0.foodid = x2.foodid
and x0.mixid = x3.mixid
and x0.foodid = x3.foodid
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
and x0.mixid = x10.mixid
and x0.foodid = x10.foodid
and x0.mixid = x11.mixid
and x0.foodid = x11.foodid
and x0.mixid = x12.mixid
and x0.foodid = x12.foodid
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
and x0.mixid = x48.mixid
and x0.foodid = x48.foodid
and x0.mixid = x49.mixid
and x0.foodid = x49.foodid
and x0.mixid = x50.mixid
and x0.foodid = x50.foodid
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
       Round(sum(a.Weight),v_Precision),
       Round(sum(CompleteProtein),v_Precision),
       Round(sum(IncompleteProtein),v_Precision),
       Round(sum(DigestibleCarbohydrate),v_Precision),
       Round(sum(Cost),v_Precision),
       Round(sum(Protein),v_Precision),
       Round(sum(Fat),v_Precision),
       Round(sum(CarbsByDiff),v_Precision),
       Round(sum(Energy),v_Precision),
       Round(sum(Sucrose),v_Precision),
       Round(sum(Fructose),v_Precision),
       Round(sum(Lactose),v_Precision),
       Round(sum(Alcohol),v_Precision),
       Round(sum(Water),v_Precision),
       Round(sum(Fiber),v_Precision),
       Round(sum(Calcium),v_Precision),
       Round(sum(Iron),v_Precision),
       Round(sum(Magnesium),v_Precision),
       Round(sum(Phosphorus),v_Precision),
       Round(sum(Potassium),v_Precision),
       Round(sum(Sodium),v_Precision),
       Round(sum(Zinc),v_Precision),
       Round(sum(Copper),v_Precision),
       Round(sum(Fluoride),v_Precision),
       Round(sum(Manganese),v_Precision),
       Round(sum(Selenium),v_Precision),
       Round(sum(VitaminA),v_Precision),
       Round(sum(VitaminE),v_Precision),
       Round(sum(VitaminD),v_Precision),
       Round(sum(VitaminC),v_Precision),
       Round(sum(Thiamin),v_Precision),
       Round(sum(Riboflavin),v_Precision),
       Round(sum(Niacin),v_Precision),
       Round(sum(Pantothenic),v_Precision),
       Round(sum(VitaminB6),v_Precision),
       Round(sum(VitaminB12),v_Precision),
       Round(sum(Choline),v_Precision),
       Round(sum(VitaminK),v_Precision),
       Round(sum(Folate),v_Precision),
       Round(sum(Cholesterol),v_Precision),
       Round(sum(Saturated),v_Precision),
       Round(sum(DHA),v_Precision),
       Round(sum(EPA),v_Precision),
       Round(sum(Monounsaturated),v_Precision),
       Round(sum(Polyunsaturated),v_Precision),
       Round(sum(Linoleic),v_Precision),
       Round(sum(AlphaLinolenic),v_Precision),
       Round(sum(FiberInsoluble),v_Precision),
       Round(sum(FiberSoluble),v_Precision),
       Round(sum(GlycemicLoad),v_Precision)
from
(
select
       x0.Mixid,
       x0.Foodid,
       x1.Weight,
       x2.CompleteProtein,
       x3.IncompleteProtein,
       x4.DigestibleCarbohydrate,
       x5.Cost,
       x6.Protein,
       x7.Fat,
       x8.CarbsByDiff,
       x9.Energy,
       x10.Sucrose,
       x11.Fructose,
       x12.Lactose,
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
       x48.FiberInsoluble,
       x49.FiberSoluble,
       x50.GlycemicLoad
from
--
(
select mixid,foodid from mixfood where mixid = v_MixId
) x0,
--
--10000	Weight (g)
(
select mixid,foodid,q as Weight from mixresult
where mixid = v_MixId
and nutrientid = '10000'
) x1,
--
--10001	Complete Protein (g)
(
select mixid,foodid,q as CompleteProtein from mixresult
where mixid = v_MixId
and nutrientid = '10001'
) x2,
--
--10002	Incomplete Protein (g)
(
select mixid,foodid,q as IncompleteProtein from mixresult
where mixid = v_MixId
and nutrientid = '10002'
) x3,
--
--10003	Digestible Carbohydrate (g)
(
select mixid,foodid,q as DigestibleCarbohydrate from mixresult
where mixid = v_MixId
and nutrientid = '10003'
) x4,
--
--10005	Cost (g)
(
select mixid,foodid,q as Cost from mixresult
where mixid = v_MixId
and nutrientid = '10005'
) x5,
--
--203	Protein (g)
(
select mixid,foodid,q as Protein from mixresult
where mixid = v_MixId
and nutrientid = '203'
) x6,
--
--204	Total lipid (Fat) (g)
(
select mixid,foodid,q as Fat from mixresult
where mixid = v_MixId
and nutrientid = '204'
) x7,
--205	Carbohydrate, by difference (g)
(
select mixid,foodid,q as Carbsbydiff from mixresult
where mixid = v_MixId
and nutrientid = '205'
) x8,
--
--208	Energy (kcal)
(
select mixid,foodid,q as Energy from mixresult
where mixid = v_MixId
and nutrientid = '208'
) x9,
--210	Sucrose (g)
(
select mixid,foodid,q as Sucrose from mixresult
where mixid = v_MixId
and nutrientid = '210'
) x10,
--212	Fructose (g)
(
select mixid,foodid,q as Fructose from mixresult
where mixid = v_MixId
and nutrientid = '212'
) x11,
--213	Lactose (g)
(
select mixid,foodid,q as Lactose from mixresult
where mixid = v_MixId
and nutrientid = '213'
) x12,
--221	Alcohol, ethyl (g)
(
select mixid,foodid,q as Alcohol from mixresult
where mixid = v_MixId
and nutrientid = '221'
) x13,
--255	Water (g)
(
select mixid,foodid,q as Water from mixresult
where mixid = v_MixId
and nutrientid = '255'
) x14,
--291	Fiber, total dietary (g)
(
select mixid,foodid,q as Fiber from mixresult
where mixid = v_MixId
and nutrientid = '291'
) x15,
--301	Calcium, Ca (mg)
(
select mixid,foodid,q as Calcium from mixresult
where mixid = v_MixId
and nutrientid = '301'
) x16,
--303	Iron, Fe (mg)
(
select mixid,foodid,q as Iron from mixresult
where mixid = v_MixId
and nutrientid = '303'
) x17,
--304	Magnesium, Mg (mg)
(
select mixid,foodid,q as Magnesium from mixresult
where mixid = v_MixId
and nutrientid = '304'
) x18,
--305	Phosphorus, P (mg)
(
select mixid,foodid,q as Phosphorus from mixresult
where mixid = v_MixId
and nutrientid = '305'
) x19,
--306	Potassium, K (mg)
(
select mixid,foodid,q as Potassium from mixresult
where mixid = v_MixId
and nutrientid = '306'
) x20,
--307	Sodium, Na (mg)
(
select mixid,foodid,q as Sodium from mixresult
where mixid = v_MixId
and nutrientid = '307'
) x21,
--309	Zinc, Zn (mg)
(
select mixid,foodid,q as Zinc from mixresult
where mixid = v_MixId
and nutrientid = '309'
) x22,
--312	Copper, Cu (mg)
(
select mixid,foodid,q as Copper from mixresult
where mixid = v_MixId
and nutrientid = '312'
) x23,
--313	Fluoride, F (µg)
(
select mixid,foodid,q as Fluoride from mixresult
where mixid = v_MixId
and nutrientid = '313'
) x24,
--315	Manganese, Mn (mg)
(
select mixid,foodid,q as Manganese from mixresult
where mixid = v_MixId
and nutrientid = '315'
) x25,
--317	Selenium, Se (µg)
(
select mixid,foodid,q as Selenium from mixresult
where mixid = v_MixId
and nutrientid = '317'
) x26,
--320	Vitamin A, RAE (µg)
(
select mixid,foodid,q as VitaminA from mixresult
where mixid = v_MixId
and nutrientid = '320'
) x27,
--323	Vitamin E (Alpha-Tocopherol) (mg)
(
select mixid,foodid,q as VitaminE from mixresult
where mixid = v_MixId
and nutrientid = '323'
) x28,
--328	Vitamin D (D2 + D3) (µg)
(
select mixid,foodid,q as VitaminD from mixresult
where mixid = v_MixId
and nutrientid = '328'
) x29,
--401	Vitamin C, total (Ascorbic Acid) (mg)
(
select mixid,foodid,q as VitaminC from mixresult
where mixid = v_MixId
and nutrientid = '401'
) x30,
--404	Thiamin (mg)
(
select mixid,foodid,q as Thiamin from mixresult
where mixid = v_MixId
and nutrientid = '404'
) x31,
--405	Riboflavin (mg)
(
select mixid,foodid,q as Riboflavin from mixresult
where mixid = v_MixId
and nutrientid = '405'
) x32,
--406	Niacin (mg)
(
select mixid,foodid,q as Niacin from mixresult
where mixid = v_MixId
and nutrientid = '406'
) x33,
--410	Pantothenic acid (mg)
(
select mixid,foodid,q as Pantothenic from mixresult
where mixid = v_MixId
and nutrientid = '410'
) x34,
--415	Vitamin B-6 (mg)
(
select mixid,foodid,q as VitaminB6 from mixresult
where mixid = v_MixId
and nutrientid = '415'
) x35,
--418	Vitamin B-12 (µg)
(
select mixid,foodid,q as VitaminB12 from mixresult
where mixid = v_MixId
and nutrientid = '418'
) x36,
--421	Choline, total (mg)
(
select mixid,foodid,q as Choline from mixresult
where mixid = v_MixId
and nutrientid = '421'
) x37,
--430	Vitamin K (Phylloquinone) (µg)
(
select mixid,foodid,q as VitaminK from mixresult
where mixid = v_MixId
and nutrientid = '430'
) x38,
--435	Folate, DFE (µg)
(
select mixid,foodid,q as Folate from mixresult
where mixid = v_MixId
and nutrientid = '435'
) x39,
--601	Cholesterol (mg)
(
select mixid,foodid,q as Cholesterol from mixresult
where mixid = v_MixId
and nutrientid = '601'
) x40,
--606	Fatty acids, total saturated (g)
(
select mixid,foodid,q as Saturated from mixresult
where mixid = v_MixId
and nutrientid = '606'
) x41,
--621	22:6 n-3 (DHA) (g)
(
select mixid,foodid,q as DHA from mixresult
where mixid = v_MixId
and nutrientid = '621'
) x42,
--629	20:5 n-3 (EPA) (g)
(
select mixid,foodid,q as EPA from mixresult
where mixid = v_MixId
and nutrientid = '629'
) x43,
--645	Fatty acids, total monounsaturated (g)
(
select mixid,foodid,q as Monounsaturated from mixresult
where mixid = v_MixId
and nutrientid = '645'
) x44,
--646	Fatty acids, total polyunsaturated (g)
(
select mixid,foodid,q as Polyunsaturated from mixresult
where mixid = v_MixId
and nutrientid = '646'
) x45,
--675	18:2 n-6 c,c (Linoleic) (g)
(
select mixid,foodid,q as Linoleic from mixresult
where mixid = v_MixId
and nutrientid = '675'
) x46,
--851	18:3 n-3 c,c,c (Alpha-Linolenic) (g)
(
select mixid,foodid,q as AlphaLinolenic from mixresult
where mixid = v_MixId
and nutrientid = '851'
) x47,
--10006	Fiber, Insoluble (g)
(
select mixid,foodid,q as FiberInsoluble from mixresult
where mixid = v_MixId
and nutrientid = '10006'
) x48,
--10007	Fiber, Soluble (g)
(
select mixid,foodid,q as FiberSoluble from mixresult
where mixid = v_MixId
and nutrientid = '10007'
) x49,
--10008	Glycemic Load
(
select mixid,foodid,q as GlycemicLoad from mixresult
where mixid = v_MixId
and nutrientid = '10008'
) x50
--
where x0.mixid = x1.mixid
and x0.foodid = x1.foodid
and x0.mixid = x2.mixid
and x0.foodid = x2.foodid
and x0.mixid = x3.mixid
and x0.foodid = x3.foodid
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
and x0.mixid = x10.mixid
and x0.foodid = x10.foodid
and x0.mixid = x11.mixid
and x0.foodid = x11.foodid
and x0.mixid = x12.mixid
and x0.foodid = x12.foodid
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
and x0.mixid = x48.mixid
and x0.foodid = x48.foodid
and x0.mixid = x49.mixid
and x0.foodid = x49.foodid
and x0.mixid = x50.mixid
and x0.foodid = x50.foodid
) a,
(
select foodid,name from food
) b
where a.foodid = b.foodid
group by a.MixId
order by a.Energy,a.Weight,b.Name;
--
OPEN result;
END;
/