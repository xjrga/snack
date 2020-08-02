CREATE PROCEDURE MixResultDW_Merge (
IN v_MixId INTEGER,
IN v_FoodId LONGVARCHAR
)
--
MODIFIES SQL DATA BEGIN ATOMIC
--
DECLARE v_Name LONGVARCHAR;
DECLARE v_Weight DOUBLE;
DECLARE v_CompleteProtein DOUBLE;
DECLARE v_IncompleteProtein DOUBLE;
DECLARE v_DigestibleCarbs DOUBLE;
DECLARE v_Cost DOUBLE;
DECLARE v_Protein DOUBLE;
DECLARE v_Fat DOUBLE;
DECLARE v_CarbsByDiff DOUBLE;
DECLARE v_Energy DOUBLE;
DECLARE v_Sucrose DOUBLE;
DECLARE v_Fructose DOUBLE;
DECLARE v_Lactose DOUBLE;
DECLARE v_Alcohol DOUBLE;
DECLARE v_Water DOUBLE;
DECLARE v_Fiber DOUBLE;
DECLARE v_Calcium DOUBLE;
DECLARE v_Iron DOUBLE;
DECLARE v_Magnesium DOUBLE;
DECLARE v_Phosphorus DOUBLE;
DECLARE v_Potassium DOUBLE;
DECLARE v_Sodium DOUBLE;
DECLARE v_Zinc DOUBLE;
DECLARE v_Copper DOUBLE;
DECLARE v_Fluoride DOUBLE;
DECLARE v_Manganese DOUBLE;
DECLARE v_Selenium DOUBLE;
DECLARE v_VitaminA DOUBLE;
DECLARE v_VitaminE DOUBLE;
DECLARE v_VitaminD DOUBLE;
DECLARE v_VitaminC DOUBLE;
DECLARE v_Thiamin DOUBLE;
DECLARE v_Riboflavin DOUBLE;
DECLARE v_Niacin DOUBLE;
DECLARE v_Pantothenic DOUBLE;
DECLARE v_VitaminB6 DOUBLE;
DECLARE v_VitaminB12 DOUBLE;
DECLARE v_Choline DOUBLE;
DECLARE v_VitaminK DOUBLE;
DECLARE v_Folate DOUBLE;
DECLARE v_Cholesterol DOUBLE;
DECLARE v_Saturated DOUBLE;
DECLARE v_DHA DOUBLE;
DECLARE v_EPA DOUBLE;
DECLARE v_Monounsaturated DOUBLE;
DECLARE v_Polyunsaturated DOUBLE;
DECLARE v_Linoleic DOUBLE;
DECLARE v_AlphaLinolenic DOUBLE;
--
SET v_Name =  getFoodName(v_FoodId);

SELECT x2.c * a.x AS "Weight",
       x3.c * a.x AS "CompleteProtein",
       x4.c * a.x AS "IncompleteProtein",
       x5.c * a.x AS "DigestibleCarbs",
       x6.c * a.x AS "Cost",
       x7.c * a.x AS "Protein",
       x8.c * a.x AS "Fat",
       x9.c * a.x AS "CarbsByDiff",
       x10.c * a.x AS "Energy",
       x11.c * a.x AS "Sucrose",
       x12.c * a.x AS "Fructose",
       x13.c * a.x AS "Lactose",
       x14.c * a.x AS "Alcohol",
       x15.c * a.x AS "Water",
       x18.c * a.x AS "Fiber",
       x19.c * a.x AS "Calcium",
       x20.c * a.x AS "Iron",
       x21.c * a.x AS "Magnesium",
       x22.c * a.x AS "Phosphorus",
       x23.c * a.x AS "Potassium",
       x24.c * a.x AS "Sodium",
       x25.c * a.x AS "Zinc",
       x26.c * a.x AS "Copper",
       x27.c * a.x AS "Fluoride",
       x28.c * a.x AS "Manganese",
       x29.c * a.x AS "Selenium",
       x30.c * a.x AS "VitaminA",
       x31.c * a.x AS "VitaminE",
       x32.c * a.x AS "VitaminD",
       x35.c * a.x AS "VitaminC",
       x36.c * a.x AS "Thiamin",
       x37.c * a.x AS "Riboflavin",
       x38.c * a.x AS "Niacin",
       x39.c * a.x AS "Pantothenic",
       x40.c * a.x AS "VitaminB6",
       x41.c * a.x AS "VitaminB12",
       x16.c * a.x AS "Choline",
       x42.c * a.x AS "VitaminK",
       x43.c * a.x AS "Folate",
       x44.c * a.x AS "Cholesterol",
       x45.c * a.x AS "Saturated",
       x46.c * a.x AS "DHA",
       x47.c * a.x AS "EPA",
       x48.c * a.x AS "Monounsaturated",
       x49.c * a.x AS "Polyunsaturated",
       x50.c * a.x AS "Linoleic",
       x51.c * a.x AS "AlphaLinolenic"
INTO
                v_Weight,
                v_CompleteProtein,
                v_IncompleteProtein,
                v_DigestibleCarbs,
                v_Cost,
                v_Protein,
                v_Fat,
                v_CarbsByDiff,
                v_Energy,
                v_Sucrose,
                v_Fructose,
                v_Lactose,
                v_Alcohol,
                v_Water,
                v_Fiber,
                v_Calcium,
                v_Iron,
                v_Magnesium,
                v_Phosphorus,
                v_Potassium,
                v_Sodium,
                v_Zinc,
                v_Copper,
                v_Fluoride,
                v_Manganese,
                v_Selenium,
                v_VitaminA,
                v_VitaminE,
                v_VitaminD,
                v_VitaminC,
                v_Thiamin,
                v_Riboflavin,
                v_Niacin,
                v_Pantothenic,
                v_VitaminB6,
                v_VitaminB12,
                v_Choline,
                v_VitaminK,
                v_Folate,
                v_Cholesterol,
                v_Saturated,
                v_DHA,
                v_EPA,
                v_Monounsaturated,
                v_Polyunsaturated,
                v_Linoleic,
                v_AlphaLinolenic
FROM mixfood a,
     foodfactcoefficient x2,
     foodfactcoefficient x3,
     foodfactcoefficient x4,
     foodfactcoefficient x5,
     foodfactcoefficient x6,
     foodfactcoefficient x7,
     foodfactcoefficient x8,
     foodfactcoefficient x9,
     foodfactcoefficient x10,
     foodfactcoefficient x11,
     foodfactcoefficient x12,
     foodfactcoefficient x13,
     foodfactcoefficient x14,
     foodfactcoefficient x15,
     foodfactcoefficient x18,
     foodfactcoefficient x19,
     foodfactcoefficient x20,
     foodfactcoefficient x21,
     foodfactcoefficient x22,
     foodfactcoefficient x23,
     foodfactcoefficient x24,
     foodfactcoefficient x25,
     foodfactcoefficient x26,
     foodfactcoefficient x27,
     foodfactcoefficient x28,
     foodfactcoefficient x29,
     foodfactcoefficient x30,
     foodfactcoefficient x31,
     foodfactcoefficient x32,
     foodfactcoefficient x35,
     foodfactcoefficient x36,
     foodfactcoefficient x37,
     foodfactcoefficient x38,
     foodfactcoefficient x39,
     foodfactcoefficient x40,
     foodfactcoefficient x41,
     foodfactcoefficient x16,
     foodfactcoefficient x42,
     foodfactcoefficient x43,
     foodfactcoefficient x44,
     foodfactcoefficient x45,
     foodfactcoefficient x46,
     foodfactcoefficient x47,
     foodfactcoefficient x48,
     foodfactcoefficient x49,
     foodfactcoefficient x50,
     foodfactcoefficient x51
WHERE
(
a.foodid = x2.foodid AND
a.foodid = x3.foodid AND
a.foodid = x4.foodid AND
a.foodid = x5.foodid AND
a.foodid = x6.foodid AND
a.foodid = x7.foodid AND
a.foodid = x8.foodid AND
a.foodid = x9.foodid AND
a.foodid = x10.foodid AND
a.foodid = x11.foodid AND
a.foodid = x12.foodid AND
a.foodid = x13.foodid AND
a.foodid = x14.foodid AND
a.foodid = x15.foodid AND
a.foodid = x18.foodid AND
a.foodid = x19.foodid AND
a.foodid = x20.foodid AND
a.foodid = x21.foodid AND
a.foodid = x22.foodid AND
a.foodid = x23.foodid AND
a.foodid = x24.foodid AND
a.foodid = x25.foodid AND
a.foodid = x26.foodid AND
a.foodid = x27.foodid AND
a.foodid = x28.foodid AND
a.foodid = x29.foodid AND
a.foodid = x30.foodid AND
a.foodid = x31.foodid AND
a.foodid = x32.foodid AND
a.foodid = x35.foodid AND
a.foodid = x36.foodid AND
a.foodid = x37.foodid AND
a.foodid = x38.foodid AND
a.foodid = x39.foodid AND
a.foodid = x40.foodid AND
a.foodid = x41.foodid AND
a.foodid = x16.foodid AND
a.foodid = x42.foodid AND
a.foodid = x43.foodid AND
a.foodid = x44.foodid AND
a.foodid = x45.foodid AND
a.foodid = x46.foodid AND
a.foodid = x47.foodid AND
a.foodid = x48.foodid AND
a.foodid = x49.foodid AND
a.foodid = x50.foodid AND
a.foodid = x51.foodid
)
AND
(
x2.nutrientid = '10000' AND
x3.nutrientid = '10001' AND
x4.nutrientid = '10002' AND
x5.nutrientid = '10003' AND
x6.nutrientid = '10005' AND
x7.nutrientid = '203' AND
x8.nutrientid = '204' AND
x9.nutrientid = '205' AND
x10.nutrientid = '208' AND
x11.nutrientid = '210' AND
x12.nutrientid = '212' AND
x13.nutrientid = '213' AND
x14.nutrientid = '221' AND
x15.nutrientid = '255' AND
x18.nutrientid = '291' AND
x19.nutrientid = '301' AND
x20.nutrientid = '303' AND
x21.nutrientid = '304' AND
x22.nutrientid = '305' AND
x23.nutrientid = '306' AND
x24.nutrientid = '307' AND
x25.nutrientid = '309' AND
x26.nutrientid = '312' AND
x27.nutrientid = '313' AND
x28.nutrientid = '315' AND
x29.nutrientid = '317' AND
x30.nutrientid = '320' AND
x31.nutrientid = '323' AND
x32.nutrientid = '328' AND
x35.nutrientid = '401' AND
x36.nutrientid = '404' AND
x37.nutrientid = '405' AND
x38.nutrientid = '406' AND
x39.nutrientid = '410' AND
x40.nutrientid = '415' AND
x41.nutrientid = '418' AND
x16.nutrientid = '421' AND
x42.nutrientid = '430' AND
x43.nutrientid = '435' AND
x44.nutrientid = '601' AND
x45.nutrientid = '606' AND
x46.nutrientid = '621' AND
x47.nutrientid = '629' AND
x48.nutrientid = '645' AND
x49.nutrientid = '646' AND
x50.nutrientid = '675' AND
x51.nutrientid = '851'
)
AND a.mixid = v_MixId
AND a.foodid = v_FoodId;
--
MERGE INTO MixResultDW USING ( VALUES (
v_MixId,
v_FoodId,
v_Name,
v_Weight,
v_CompleteProtein,
v_IncompleteProtein,
v_DigestibleCarbs,
v_Cost,
v_Protein,
v_Fat,
v_CarbsByDiff,
v_Energy,
v_Sucrose,
v_Fructose,
v_Lactose,
v_Alcohol,
v_Water,
v_Fiber,
v_Calcium,
v_Iron,
v_Magnesium,
v_Phosphorus,
v_Potassium,
v_Sodium,
v_Zinc,
v_Copper,
v_Fluoride,
v_Manganese,
v_Selenium,
v_VitaminA,
v_VitaminE,
v_VitaminD,
v_VitaminC,
v_Thiamin,
v_Riboflavin,
v_Niacin,
v_Pantothenic,
v_VitaminB6,
v_VitaminB12,
v_Choline,
v_VitaminK,
v_Folate,
v_Cholesterol,
v_Saturated,
v_DHA,
v_EPA,
v_Monounsaturated,
v_Polyunsaturated,
v_Linoleic,
v_AlphaLinolenic
) ) ON (
MixId = v_MixId
AND
FoodId = v_FoodId
)
WHEN MATCHED THEN UPDATE SET
Name = v_Name,
Weight = v_Weight,
CompleteProtein = v_CompleteProtein,
IncompleteProtein = v_IncompleteProtein,
DigestibleCarbohydrate = v_DigestibleCarbs,
Cost = v_Cost,
Protein = v_Protein,
Fat = v_Fat,
CarbsByDiff = v_CarbsByDiff,
Energy = v_Energy,
Sucrose = v_Sucrose,
Fructose = v_Fructose,
Lactose = v_Lactose,
Alcohol = v_Alcohol,
Water = v_Water,
Fiber = v_Fiber,
Calcium = v_Calcium,
Iron = v_Iron,
Magnesium = v_Magnesium,
Phosphorus = v_Phosphorus,
Potassium = v_Potassium,
Sodium = v_Sodium,
Zinc = v_Zinc,
Copper = v_Copper,
Fluoride = v_Fluoride,
Manganese = v_Manganese,
Selenium = v_Selenium,
VitaminA = v_VitaminA,
VitaminE = v_VitaminE,
VitaminD = v_VitaminD,
VitaminC = v_VitaminC,
Thiamin = v_Thiamin,
Riboflavin = v_Riboflavin,
Niacin = v_Niacin,
Pantothenic = v_Pantothenic,
VitaminB6 = v_VitaminB6,
VitaminB12 = v_VitaminB12,
Choline = v_Choline,
VitaminK = v_VitaminK,
Folate = v_Folate,
Cholesterol = v_Cholesterol,
Saturated = v_Saturated,
DHA = v_DHA,
EPA = v_EPA,
Monounsaturated = v_Monounsaturated,
Polyunsaturated = v_Polyunsaturated,
Linoleic = v_Linoleic,
AlphaLinolenic = v_AlphaLinolenic
WHEN NOT MATCHED THEN INSERT VALUES
v_MixId,
v_FoodId,
v_Name,
v_Weight,
v_CompleteProtein,
v_IncompleteProtein,
v_DigestibleCarbs,
v_Cost,
v_Protein,
v_Fat,
v_CarbsByDiff,
v_Energy,
v_Sucrose,
v_Fructose,
v_Lactose,
v_Alcohol,
v_Water,
v_Fiber,
v_Calcium,
v_Iron,
v_Magnesium,
v_Phosphorus,
v_Potassium,
v_Sodium,
v_Zinc,
v_Copper,
v_Fluoride,
v_Manganese,
v_Selenium,
v_VitaminA,
v_VitaminE,
v_VitaminD,
v_VitaminC,
v_Thiamin,
v_Riboflavin,
v_Niacin,
v_Pantothenic,
v_VitaminB6,
v_VitaminB12,
v_Choline,
v_VitaminK,
v_Folate,
v_Cholesterol,
v_Saturated,
v_DHA,
v_EPA,
v_Monounsaturated,
v_Polyunsaturated,
v_Linoleic,
v_AlphaLinolenic;
--
END;
/