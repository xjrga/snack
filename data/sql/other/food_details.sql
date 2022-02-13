SELECT
       --Name
       b.name AS "Category",
       a.name AS "Name",
       --Mass
       ROUND(x0.q,0) AS "Weight",
       --Energy
       ROUND(x8.q,0) AS "EnergyGross",
       ROUND(x53.q,0) AS "EnergyDigestible",       
       ROUND(x55.q,0) AS "EnergyCarbohydrate",
       ROUND(x56.q,0) AS "EnergyProtein",
       ROUND(x57.q,0) AS "EnergyFat",
       ROUND(x58.q,0) AS "EnergyAlcohol",
       --Macronutrient
       ROUND(x6.q,0) AS "Fat",
       ROUND(x3.q,0) AS "DigestibleCarbs",
       ROUND(x5.q,0) AS "Protein",
       ROUND(x12.q,0) AS "Alcohol",
       --Protein       
       ROUND(x1.q,0) AS "CompleteProtein",       
       --Fiber
       ROUND(x7.q,0) AS "CarbsByDiff",
       ROUND(x16.q,0) AS "Fiber",
       --Minerals
       ROUND(x17.q,0) AS "Calcium",
       ROUND(x18.q,0) AS "Iron",
       ROUND(x19.q,0) AS "Magnesium",
       ROUND(x20.q,0) AS "Phosphorus",
       ROUND(x21.q,0) AS "Potassium",
       ROUND(x22.q,0) AS "Sodium",
       ROUND(x23.q,0) AS "Zinc",
       ROUND(x24.q,0) AS "Copper",
       ROUND(x25.q,0) AS "Fluoride",
       ROUND(x26.q,0) AS "Manganese",
       ROUND(x27.q,0) AS "Selenium",
       --Vitamins
       ROUND(x28.q,0) AS "VitaminA",
       ROUND(x29.q,0) AS "VitaminE",
       ROUND(x30.q,0) AS "VitaminD",
       ROUND(x33.q,0) AS "VitaminC",
       ROUND(x34.q,0) AS "Thiamin",
       ROUND(x35.q,0) AS "Riboflavin",
       ROUND(x36.q,0) AS "Niacin",
       ROUND(x37.q,0) AS "Pantothenic",
       ROUND(x38.q,0) AS "VitaminB6",
       ROUND(x39.q,0) AS "VitaminB12",
       ROUND(x14.q,0) AS "Choline",
       ROUND(x40.q,0) AS "VitaminK",
       ROUND(x41.q,0) AS "Folate",
       --Fatty Acids
       ROUND(x42.q,0) AS "Cholesterol",
       ROUND(x43.q,0) AS "Saturated",
       ROUND(x44.q,0) AS "DHA",
       ROUND(x45.q,0) AS "EPA",
       ROUND(x46.q,0) AS "Monounsaturated",
       ROUND(x47.q,0) AS "Polyunsaturated",
       ROUND(x48.q,0) AS "Linoleic",
       ROUND(x49.q,0) AS "AlphaLinolenic",
       --Glycemic
       ROUND(x50.q,0) AS "GlycemicLoad",
       --Other
       ROUND(x13.q,0) AS "Water",
       ROUND(x4.q,0) AS "Cost",
       --Ids
       b.foodcategoryid AS "CategoryId",
       a.foodid AS "FoodId"
FROM food a,
     foodcategory b,
     categorylink c,
     foodfact x0,
     foodfact x1,     
     foodfact x3,
     foodfact x4,
     foodfact x5,
     foodfact x6,
     foodfact x7,
     foodfact x8,     
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
     foodfact x53,     
     foodfact x55,
     foodfact x56,
     foodfact x57,
     foodfact x58
WHERE
(
b.foodcategoryid =  c.foodcategoryid AND
a.foodid = c.foodid AND
a.foodid = x0.foodid AND
a.foodid = x1.foodid AND
a.foodid = x3.foodid AND
a.foodid = x4.foodid AND
a.foodid = x5.foodid AND
a.foodid = x6.foodid AND
a.foodid = x7.foodid AND
a.foodid = x8.foodid AND
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
a.foodid = x53.foodid AND
a.foodid = x55.foodid AND
a.foodid = x56.foodid AND
a.foodid = x57.foodid AND
a.foodid = x58.foodid
)
AND
(
x0.nutrientid = '10000' AND
x1.nutrientid = '10001' AND
x3.nutrientid = '10003' AND
x4.nutrientid = '10005' AND
x5.nutrientid = '203' AND
x6.nutrientid = '204' AND
x7.nutrientid = '205' AND
x8.nutrientid = '208' AND
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
x48.nutrientid = '618' AND
x49.nutrientid = '619' AND
x50.nutrientid = '10006' AND
x53.nutrientid = '10009' AND
x55.nutrientid = '10011' AND
x56.nutrientid = '10012' AND
x57.nutrientid = '10013' AND
x58.nutrientid = '10014'
)
UNION
SELECT
       --Name
       NULL,
       a.name AS "Name",
       --Mass
       ROUND(x0.q,0) AS "Weight",
       --Energy
       ROUND(x8.q,0) AS "EnergyGross",
       ROUND(x53.q,0) AS "EnergyDigestible",       
       ROUND(x55.q,0) AS "EnergyCarbohydrate",
       ROUND(x56.q,0) AS "EnergyProtein",
       ROUND(x57.q,0) AS "EnergyFat",
       ROUND(x58.q,0) AS "EnergyAlcohol",
       --Macronutrient
       ROUND(x6.q,0) AS "Fat",
       ROUND(x3.q,0) AS "DigestibleCarbs",
       ROUND(x5.q,0) AS "Protein",
       ROUND(x12.q,0) AS "Alcohol",
       --Protein       
       ROUND(x1.q,0) AS "CompleteProtein",       
       --Fiber
       ROUND(x7.q,0) AS "CarbsByDiff",
       ROUND(x16.q,0) AS "Fiber",
       --Minerals
       ROUND(x17.q,0) AS "Calcium",
       ROUND(x18.q,0) AS "Iron",
       ROUND(x19.q,0) AS "Magnesium",
       ROUND(x20.q,0) AS "Phosphorus",
       ROUND(x21.q,0) AS "Potassium",
       ROUND(x22.q,0) AS "Sodium",
       ROUND(x23.q,0) AS "Zinc",
       ROUND(x24.q,0) AS "Copper",
       ROUND(x25.q,0) AS "Fluoride",
       ROUND(x26.q,0) AS "Manganese",
       ROUND(x27.q,0) AS "Selenium",
       --Vitamins
       ROUND(x28.q,0) AS "VitaminA",
       ROUND(x29.q,0) AS "VitaminE",
       ROUND(x30.q,0) AS "VitaminD",
       ROUND(x33.q,0) AS "VitaminC",
       ROUND(x34.q,0) AS "Thiamin",
       ROUND(x35.q,0) AS "Riboflavin",
       ROUND(x36.q,0) AS "Niacin",
       ROUND(x37.q,0) AS "Pantothenic",
       ROUND(x38.q,0) AS "VitaminB6",
       ROUND(x39.q,0) AS "VitaminB12",
       ROUND(x14.q,0) AS "Choline",
       ROUND(x40.q,0) AS "VitaminK",
       ROUND(x41.q,0) AS "Folate",
       --Fatty Acids
       ROUND(x42.q,0) AS "Cholesterol",
       ROUND(x43.q,0) AS "Saturated",
       ROUND(x44.q,0) AS "DHA",
       ROUND(x45.q,0) AS "EPA",
       ROUND(x46.q,0) AS "Monounsaturated",
       ROUND(x47.q,0) AS "Polyunsaturated",
       ROUND(x48.q,0) AS "Linoleic",
       ROUND(x49.q,0) AS "AlphaLinolenic",
       --Glycemic
       ROUND(x50.q,0) AS "GlycemicLoad",
       --Other
       ROUND(x13.q,0) AS "Water",
       ROUND(x4.q,0) AS "Cost",
       --Ids
       NULL,
       a.foodid AS "FoodId"
FROM (SELECT foodid,
             name
      FROM food
      WHERE foodid NOT IN (SELECT b.foodid
                           FROM categorylink a,
                                food b
                           WHERE a.foodid = b.foodid)) a,
     foodfact x0,
     foodfact x1,     
     foodfact x3,
     foodfact x4,
     foodfact x5,
     foodfact x6,
     foodfact x7,
     foodfact x8,     
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
     foodfact x53,     
     foodfact x55,
     foodfact x56,
     foodfact x57,
     foodfact x58
WHERE
(
a.foodid = x0.foodid AND
a.foodid = x1.foodid AND
a.foodid = x3.foodid AND
a.foodid = x4.foodid AND
a.foodid = x5.foodid AND
a.foodid = x6.foodid AND
a.foodid = x7.foodid AND
a.foodid = x8.foodid AND
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
a.foodid = x53.foodid AND
a.foodid = x55.foodid AND
a.foodid = x56.foodid AND
a.foodid = x57.foodid AND
a.foodid = x58.foodid
)
AND
(
x0.nutrientid = '10000' AND
x1.nutrientid = '10001' AND
x3.nutrientid = '10003' AND
x4.nutrientid = '10005' AND
x5.nutrientid = '203' AND
x6.nutrientid = '204' AND
x7.nutrientid = '205' AND
x8.nutrientid = '208' AND
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
x48.nutrientid = '618' AND
x49.nutrientid = '619' AND
x50.nutrientid = '10006' AND
x53.nutrientid = '10009' AND
x55.nutrientid = '10011' AND
x56.nutrientid = '10012' AND
x57.nutrientid = '10013' AND
x58.nutrientid = '10014'
);
