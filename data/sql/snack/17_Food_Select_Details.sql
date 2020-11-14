CREATE PROCEDURE Food_Select_Details (
IN v_Precision INTEGER
)
--
MODIFIES SQL DATA DYNAMIC RESULT SETS 1 BEGIN ATOMIC
--
DECLARE result CURSOR
FOR
--
SELECT b.name AS "Category",
       a.name AS "Name",
       ROUND(x0.q,v_Precision) AS "Weight",
       ROUND(x1.q,v_Precision) AS "CompleteProtein",
       ROUND(x2.q,v_Precision) AS "IncompleteProtein",
       ROUND(x3.q,v_Precision) AS "DigestibleCarbs",
       ROUND(x4.q,v_Precision) AS "Cost",
       ROUND(x5.q,v_Precision) AS "Protein",
       ROUND(x6.q,v_Precision) AS "Fat",
       ROUND(x7.q,v_Precision) AS "CarbsByDiff",
       ROUND(x8.q,v_Precision) AS "Energy",
       ROUND(x9.q,v_Precision) AS "Sucrose",
       ROUND(x10.q,v_Precision) AS "Fructose",
       ROUND(x11.q,v_Precision) AS "Lactose",
       ROUND(x12.q,v_Precision) AS "Alcohol",
       ROUND(x13.q,v_Precision) AS "Water",
       ROUND(x16.q,v_Precision) AS "Fiber",
       ROUND(x17.q,v_Precision) AS "Calcium",
       ROUND(x18.q,v_Precision) AS "Iron",
       ROUND(x19.q,v_Precision) AS "Magnesium",
       ROUND(x20.q,v_Precision) AS "Phosphorus",
       ROUND(x21.q,v_Precision) AS "Potassium",
       ROUND(x22.q,v_Precision) AS "Sodium",
       ROUND(x23.q,v_Precision) AS "Zinc",
       ROUND(x24.q,v_Precision) AS "Copper",
       ROUND(x25.q,v_Precision) AS "Fluoride",
       ROUND(x26.q,v_Precision) AS "Manganese",
       ROUND(x27.q,v_Precision) AS "Selenium",
       ROUND(x28.q,v_Precision) AS "VitaminA",
       ROUND(x29.q,v_Precision) AS "VitaminE",
       ROUND(x30.q,v_Precision) AS "VitaminD",
       ROUND(x33.q,v_Precision) AS "VitaminC",
       ROUND(x34.q,v_Precision) AS "Thiamin",
       ROUND(x35.q,v_Precision) AS "Riboflavin",
       ROUND(x36.q,v_Precision) AS "Niacin",
       ROUND(x37.q,v_Precision) AS "Pantothenic",
       ROUND(x38.q,v_Precision) AS "VitaminB6",
       ROUND(x39.q,v_Precision) AS "VitaminB12",
       ROUND(x14.q,v_Precision) AS "Choline",
       ROUND(x40.q,v_Precision) AS "VitaminK",
       ROUND(x41.q,v_Precision) AS "Folate",
       ROUND(x42.q,v_Precision) AS "Cholesterol",
       ROUND(x43.q,v_Precision) AS "Saturated",
       ROUND(x44.q,v_Precision) AS "DHA",
       ROUND(x45.q,v_Precision) AS "EPA",
       ROUND(x46.q,v_Precision) AS "Monounsaturated",
       ROUND(x47.q,v_Precision) AS "Polyunsaturated",
       ROUND(x48.q,v_Precision) AS "Linoleic",
       ROUND(x49.q,v_Precision) AS "AlphaLinolenic",
       ROUND(x50.q,v_Precision) AS "FiberInsoluble",
       ROUND(x51.q,v_Precision) AS "FiberSoluble",
       ROUND(x52.q,v_Precision) AS "GlycemicIndex",
       b.foodcategoryid AS "CategoryId",
       a.foodid AS "FoodId"
FROM food a,
     foodcategory b,
     categorylink c,
     foodfact x0,
     foodfact x1,
     foodfact x2,
     foodfact x3,
     foodfact x4,
     foodfact x5,
     foodfact x6,
     foodfact x7,
     foodfact x8,
     foodfact x9,
     foodfact x10,
     foodfact x11,
     foodfact x12,
     foodfact x13,
     foodfact x16,
     foodfact x17,
     foodfact x18,
     foodfact x19,
     foodfact x20,
     foodfact x21,
     foodfact x22,
     foodfact x23,
     foodfact x24,
     foodfact x25,
     foodfact x26,
     foodfact x27,
     foodfact x28,
     foodfact x29,
     foodfact x30,
     foodfact x33,
     foodfact x34,
     foodfact x35,
     foodfact x36,
     foodfact x37,
     foodfact x38,
     foodfact x39,
     foodfact x14,
     foodfact x40,
     foodfact x41,
     foodfact x42,
     foodfact x43,
     foodfact x44,
     foodfact x45,
     foodfact x46,
     foodfact x47,
     foodfact x48,
     foodfact x49,
     foodfact x50,
     foodfact x51,
     foodfact x52
WHERE
(
b.foodcategoryid =  c.foodcategoryid AND
a.foodid = c.foodid AND
a.foodid = x0.foodid AND
a.foodid = x1.foodid AND
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
a.foodid = x16.foodid AND
a.foodid = x17.foodid AND
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
a.foodid = x33.foodid AND
a.foodid = x34.foodid AND
a.foodid = x35.foodid AND
a.foodid = x36.foodid AND
a.foodid = x37.foodid AND
a.foodid = x38.foodid AND
a.foodid = x39.foodid AND
a.foodid = x14.foodid AND
a.foodid = x40.foodid AND
a.foodid = x41.foodid AND
a.foodid = x42.foodid AND
a.foodid = x43.foodid AND
a.foodid = x44.foodid AND
a.foodid = x45.foodid AND
a.foodid = x46.foodid AND
a.foodid = x47.foodid AND
a.foodid = x48.foodid AND
a.foodid = x49.foodid AND
a.foodid = x50.foodid AND
a.foodid = x51.foodid AND
a.foodid = x52.foodid
)
AND
(
x0.nutrientid = '10000' AND
x1.nutrientid = '10001' AND
x2.nutrientid = '10002' AND
x3.nutrientid = '10003' AND
x4.nutrientid = '10005' AND
x5.nutrientid = '203' AND
x6.nutrientid = '204' AND
x7.nutrientid = '205' AND
x8.nutrientid = '208' AND
x9.nutrientid = '210' AND
x10.nutrientid = '212' AND
x11.nutrientid = '213' AND
x12.nutrientid = '221' AND
x13.nutrientid = '255' AND
x16.nutrientid = '291' AND
x17.nutrientid = '301' AND
x18.nutrientid = '303' AND
x19.nutrientid = '304' AND
x20.nutrientid = '305' AND
x21.nutrientid = '306' AND
x22.nutrientid = '307' AND
x23.nutrientid = '309' AND
x24.nutrientid = '312' AND
x25.nutrientid = '313' AND
x26.nutrientid = '315' AND
x27.nutrientid = '317' AND
x28.nutrientid = '320' AND
x29.nutrientid = '323' AND
x30.nutrientid = '328' AND
x33.nutrientid = '401' AND
x34.nutrientid = '404' AND
x35.nutrientid = '405' AND
x36.nutrientid = '406' AND
x37.nutrientid = '410' AND
x38.nutrientid = '415' AND
x39.nutrientid = '418' AND
x14.nutrientid = '421' AND
x40.nutrientid = '430' AND
x41.nutrientid = '435' AND
x42.nutrientid = '601' AND
x43.nutrientid = '606' AND
x44.nutrientid = '621' AND
x45.nutrientid = '629' AND
x46.nutrientid = '645' AND
x47.nutrientid = '646' AND
x48.nutrientid = '675' AND
x49.nutrientid = '851' AND
x50.nutrientid = '10006' AND
x51.nutrientid = '10007' AND
x52.nutrientid = '10008'
)
UNION
SELECT null,
       a.name AS "Name",
       ROUND(x0.q,v_Precision) AS "Weight",
       ROUND(x1.q,v_Precision) AS "CompleteProtein",
       ROUND(x2.q,v_Precision) AS "IncompleteProtein",
       ROUND(x3.q,v_Precision) AS "DigestibleCarbs",
       ROUND(x4.q,v_Precision) AS "Cost",
       ROUND(x5.q,v_Precision) AS "Protein",
       ROUND(x6.q,v_Precision) AS "Fat",
       ROUND(x7.q,v_Precision) AS "CarbsByDiff",
       ROUND(x8.q,v_Precision) AS "Energy",
       ROUND(x9.q,v_Precision) AS "Sucrose",
       ROUND(x10.q,v_Precision) AS "Fructose",
       ROUND(x11.q,v_Precision) AS "Lactose",
       ROUND(x12.q,v_Precision) AS "Alcohol",
       ROUND(x13.q,v_Precision) AS "Water",
       ROUND(x16.q,v_Precision) AS "Fiber",
       ROUND(x17.q,v_Precision) AS "Calcium",
       ROUND(x18.q,v_Precision) AS "Iron",
       ROUND(x19.q,v_Precision) AS "Magnesium",
       ROUND(x20.q,v_Precision) AS "Phosphorus",
       ROUND(x21.q,v_Precision) AS "Potassium",
       ROUND(x22.q,v_Precision) AS "Sodium",
       ROUND(x23.q,v_Precision) AS "Zinc",
       ROUND(x24.q,v_Precision) AS "Copper",
       ROUND(x25.q,v_Precision) AS "Fluoride",
       ROUND(x26.q,v_Precision) AS "Manganese",
       ROUND(x27.q,v_Precision) AS "Selenium",
       ROUND(x28.q,v_Precision) AS "VitaminA",
       ROUND(x29.q,v_Precision) AS "VitaminE",
       ROUND(x30.q,v_Precision) AS "VitaminD",
       ROUND(x33.q,v_Precision) AS "VitaminC",
       ROUND(x34.q,v_Precision) AS "Thiamin",
       ROUND(x35.q,v_Precision) AS "Riboflavin",
       ROUND(x36.q,v_Precision) AS "Niacin",
       ROUND(x37.q,v_Precision) AS "Pantothenic",
       ROUND(x38.q,v_Precision) AS "VitaminB6",
       ROUND(x39.q,v_Precision) AS "VitaminB12",
       ROUND(x14.q,v_Precision) AS "Choline",
       ROUND(x40.q,v_Precision) AS "VitaminK",
       ROUND(x41.q,v_Precision) AS "Folate",
       ROUND(x42.q,v_Precision) AS "Cholesterol",
       ROUND(x43.q,v_Precision) AS "Saturated",
       ROUND(x44.q,v_Precision) AS "DHA",
       ROUND(x45.q,v_Precision) AS "EPA",
       ROUND(x46.q,v_Precision) AS "Monounsaturated",
       ROUND(x47.q,v_Precision) AS "Polyunsaturated",
       ROUND(x48.q,v_Precision) AS "Linoleic",
       ROUND(x49.q,v_Precision) AS "AlphaLinolenic",
       ROUND(x50.q,v_Precision) AS "FiberInsoluble",
       ROUND(x51.q,v_Precision) AS "FiberSoluble",
       ROUND(x52.q,v_Precision) AS "GlycemicIndex",
       null,
       a.foodid AS "FoodId"
FROM (SELECT
foodid,
name
FROM food
WHERE foodid NOT IN (SELECT
                     b.foodid
                     FROM categorylink a,
                          food b
                     WHERE a.foodid = b.foodid)) a,
     foodfact x0,
     foodfact x1,
     foodfact x2,
     foodfact x3,
     foodfact x4,
     foodfact x5,
     foodfact x6,
     foodfact x7,
     foodfact x8,
     foodfact x9,
     foodfact x10,
     foodfact x11,
     foodfact x12,
     foodfact x13,
     foodfact x16,
     foodfact x17,
     foodfact x18,
     foodfact x19,
     foodfact x20,
     foodfact x21,
     foodfact x22,
     foodfact x23,
     foodfact x24,
     foodfact x25,
     foodfact x26,
     foodfact x27,
     foodfact x28,
     foodfact x29,
     foodfact x30,
     foodfact x33,
     foodfact x34,
     foodfact x35,
     foodfact x36,
     foodfact x37,
     foodfact x38,
     foodfact x39,
     foodfact x14,
     foodfact x40,
     foodfact x41,
     foodfact x42,
     foodfact x43,
     foodfact x44,
     foodfact x45,
     foodfact x46,
     foodfact x47,
     foodfact x48,
     foodfact x49,
     foodfact x50,
     foodfact x51,
     foodfact x52
WHERE
(
a.foodid = x0.foodid AND
a.foodid = x1.foodid AND
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
a.foodid = x16.foodid AND
a.foodid = x17.foodid AND
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
a.foodid = x33.foodid AND
a.foodid = x34.foodid AND
a.foodid = x35.foodid AND
a.foodid = x36.foodid AND
a.foodid = x37.foodid AND
a.foodid = x38.foodid AND
a.foodid = x39.foodid AND
a.foodid = x14.foodid AND
a.foodid = x40.foodid AND
a.foodid = x41.foodid AND
a.foodid = x42.foodid AND
a.foodid = x43.foodid AND
a.foodid = x44.foodid AND
a.foodid = x45.foodid AND
a.foodid = x46.foodid AND
a.foodid = x47.foodid AND
a.foodid = x48.foodid AND
a.foodid = x49.foodid AND
a.foodid = x50.foodid AND
a.foodid = x51.foodid AND
a.foodid = x52.foodid
)
AND
(
x0.nutrientid = '10000' AND
x1.nutrientid = '10001' AND
x2.nutrientid = '10002' AND
x3.nutrientid = '10003' AND
x4.nutrientid = '10005' AND
x5.nutrientid = '203' AND
x6.nutrientid = '204' AND
x7.nutrientid = '205' AND
x8.nutrientid = '208' AND
x9.nutrientid = '210' AND
x10.nutrientid = '212' AND
x11.nutrientid = '213' AND
x12.nutrientid = '221' AND
x13.nutrientid = '255' AND
x16.nutrientid = '291' AND
x17.nutrientid = '301' AND
x18.nutrientid = '303' AND
x19.nutrientid = '304' AND
x20.nutrientid = '305' AND
x21.nutrientid = '306' AND
x22.nutrientid = '307' AND
x23.nutrientid = '309' AND
x24.nutrientid = '312' AND
x25.nutrientid = '313' AND
x26.nutrientid = '315' AND
x27.nutrientid = '317' AND
x28.nutrientid = '320' AND
x29.nutrientid = '323' AND
x30.nutrientid = '328' AND
x33.nutrientid = '401' AND
x34.nutrientid = '404' AND
x35.nutrientid = '405' AND
x36.nutrientid = '406' AND
x37.nutrientid = '410' AND
x38.nutrientid = '415' AND
x39.nutrientid = '418' AND
x14.nutrientid = '421' AND
x40.nutrientid = '430' AND
x41.nutrientid = '435' AND
x42.nutrientid = '601' AND
x43.nutrientid = '606' AND
x44.nutrientid = '621' AND
x45.nutrientid = '629' AND
x46.nutrientid = '645' AND
x47.nutrientid = '646' AND
x48.nutrientid = '675' AND
x49.nutrientid = '851' AND
x50.nutrientid = '10006' AND
x51.nutrientid = '10007' AND
x52.nutrientid = '10008'
);
--
OPEN result;
--
END;
/
