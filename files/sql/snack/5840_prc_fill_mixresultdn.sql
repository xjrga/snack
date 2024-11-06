CREATE PROCEDURE fill_mixresultdn (
--
IN v_MixId LONGVARCHAR
--
)
--
MODIFIES SQL DATA DYNAMIC RESULT SETS 1
--
BEGIN ATOMIC
--
INSERT INTO mixresultdn
(
mixid,
foodid,
name,
weight,
completeprotein,
digestiblecarbohydrate,
cost,
protein,
fat,
carbsbydiff,
energygross,
alcohol,
water,
fiber,
calcium,
iron,
magnesium,
phosphorus,
potassium,
sodium,
zinc,
copper,
manganese,
selenium,
vitamina,
vitamine,
vitamind,
vitaminc,
thiamin,
riboflavin,
niacin,
pantothenicacid,
vitaminb6,
vitaminb12,
choline,
vitamink,
folate,
cholesterol,
sfa,
dha,
epa,
mufa,
pufa,
linoleicacid,
alphalinolenicacid,
glycemicload,
energydigestible,
energycarbohydrate,
energyprotein,
energyfat,
energyalcohol,
energyfatcarbohydrate,
lauric,
myristic,
palmitic,
stearic,
hcsfa
)
SELECT a.MixId,
       a.FoodId,
       b.Name,
       a.Weight,
       CompleteProtein,
       DigestibleCarbohydrate,
       Cost,
       Protein,
       Fat,
       CarbsByDiff,
       Energy,
       Alcohol,
       Water,
       Fiber,
       Calcium,
       Iron,
       Magnesium,
       Phosphorus,
       Potassium,
       Sodium,
       Zinc,
       Copper,
       Manganese,
       Selenium,
       VitaminA,
       VitaminE,
       VitaminD,
       VitaminC,
       Thiamin,
       Riboflavin,
       Niacin,
       Pantothenic,
       VitaminB6,
       VitaminB12,
       Choline,
       VitaminK,
       Folate,
       Cholesterol,
       Saturated,
       DHA,
       EPA,
       Monounsaturated,
       Polyunsaturated,
       Linoleic,
       AlphaLinolenic,
       GlycemicLoad,
       EnergyDigestible,
       EnergyCarbohydrate,
       EnergyProtein,
       EnergyFat,
       EnergyAlcohol,
       EnergyFatCarbohydrate,
       Lauric,
       Myristic,
       Palmitic,
       Stearic,
       HCSFA
FROM (SELECT x0.Mixid,
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
             x56.EnergyAlcohol,
             x57.EnergyFatCarbohydrate,
             x58.Lauric,
             x59.Myristic,
             x60.Palmitic,
             x61.Stearic,
             x62.HCSFA
      FROM
      --
      (SELECT mixid, foodid FROM mixfood WHERE mixid = v_MixId) x0,
           --
      --10000	Weight (g)
      (SELECT mixid,
              foodid,
              q AS Weight
       FROM mixresult
       WHERE mixid = v_MixId
       AND   nutrientid = '10000') x1,
           --
      --10001	Complete Protein (g)
      (SELECT mixid,
              foodid,
              q AS CompleteProtein
       FROM mixresult
       WHERE mixid = v_MixId
       AND   nutrientid = '10001') x2,
           --
      --10003	Digestible Carbohydrate (g)
      (SELECT mixid,
              foodid,
              q AS DigestibleCarbohydrate
       FROM mixresult
       WHERE mixid = v_MixId
       AND   nutrientid = '10003') x4,
           --
      --10005	Cost (g)
      (SELECT mixid,
              foodid,
              q AS Cost
       FROM mixresult
       WHERE mixid = v_MixId
       AND   nutrientid = '10005') x5,
           --
      --203	Protein (g)
      (SELECT mixid,
              foodid,
              q AS Protein
       FROM mixresult
       WHERE mixid = v_MixId
       AND   nutrientid = '203') x6,
           --
      --204	Total lipid (Fat) (g)
      (SELECT mixid,
              foodid,
              q AS Fat
       FROM mixresult
       WHERE mixid = v_MixId
       AND   nutrientid = '204') x7,
           --205	Carbohydrate, by difference (g)
      (SELECT mixid,
              foodid,
              q AS Carbsbydiff
       FROM mixresult
       WHERE mixid = v_MixId
       AND   nutrientid = '205') x8,
           --
      --208	Energy (kcal)
      (SELECT mixid,
              foodid,
              q AS Energy
       FROM mixresult
       WHERE mixid = v_MixId
       AND   nutrientid = '208') x9,
           --221	Alcohol, ethyl (g)
      (SELECT mixid,
              foodid,
              q AS Alcohol
       FROM mixresult
       WHERE mixid = v_MixId
       AND   nutrientid = '221') x13,
           --255	Water (g)
      (SELECT mixid,
              foodid,
              q AS Water
       FROM mixresult
       WHERE mixid = v_MixId
       AND   nutrientid = '255') x14,
           --291	Fiber, total dietary (g)
      (SELECT mixid,
              foodid,
              q AS Fiber
       FROM mixresult
       WHERE mixid = v_MixId
       AND   nutrientid = '291') x15,
           --301	Calcium, Ca (mg)
      (SELECT mixid,
              foodid,
              q AS Calcium
       FROM mixresult
       WHERE mixid = v_MixId
       AND   nutrientid = '301') x16,
           --303	Iron, Fe (mg)
      (SELECT mixid,
              foodid,
              q AS Iron
       FROM mixresult
       WHERE mixid = v_MixId
       AND   nutrientid = '303') x17,
           --304	Magnesium, Mg (mg)
      (SELECT mixid,
              foodid,
              q AS Magnesium
       FROM mixresult
       WHERE mixid = v_MixId
       AND   nutrientid = '304') x18,
           --305	Phosphorus, P (mg)
      (SELECT mixid,
              foodid,
              q AS Phosphorus
       FROM mixresult
       WHERE mixid = v_MixId
       AND   nutrientid = '305') x19,
           --306	Potassium, K (mg)
      (SELECT mixid,
              foodid,
              q AS Potassium
       FROM mixresult
       WHERE mixid = v_MixId
       AND   nutrientid = '306') x20,
           --307	Sodium, Na (mg)
      (SELECT mixid,
              foodid,
              q AS Sodium
       FROM mixresult
       WHERE mixid = v_MixId
       AND   nutrientid = '307') x21,
           --309	Zinc, Zn (mg)
      (SELECT mixid,
              foodid,
              q AS Zinc
       FROM mixresult
       WHERE mixid = v_MixId
       AND   nutrientid = '309') x22,
           --312	Copper, Cu (mg)
      (SELECT mixid,
              foodid,
              q AS Copper
       FROM mixresult
       WHERE mixid = v_MixId
       AND   nutrientid = '312') x23,
           --315	Manganese, Mn (mg)
      (SELECT mixid,
              foodid,
              q AS Manganese
       FROM mixresult
       WHERE mixid = v_MixId
       AND   nutrientid = '315') x25,
           --317	Selenium, Se (µg)
      (SELECT mixid,
              foodid,
              q AS Selenium
       FROM mixresult
       WHERE mixid = v_MixId
       AND   nutrientid = '317') x26,
           --320	Vitamin A, RAE (µg)
      (SELECT mixid,
              foodid,
              q AS VitaminA
       FROM mixresult
       WHERE mixid = v_MixId
       AND   nutrientid = '320') x27,
           --323	Vitamin E (Alpha-Tocopherol) (mg)
      (SELECT mixid,
              foodid,
              q AS VitaminE
       FROM mixresult
       WHERE mixid = v_MixId
       AND   nutrientid = '323') x28,
           --328	Vitamin D (D2 + D3) (µg)
      (SELECT mixid,
              foodid,
              q AS VitaminD
       FROM mixresult
       WHERE mixid = v_MixId
       AND   nutrientid = '328') x29,
           --401	Vitamin C, total (Ascorbic Acid) (mg)
      (SELECT mixid,
              foodid,
              q AS VitaminC
       FROM mixresult
       WHERE mixid = v_MixId
       AND   nutrientid = '401') x30,
           --404	Thiamin (mg)
      (SELECT mixid,
              foodid,
              q AS Thiamin
       FROM mixresult
       WHERE mixid = v_MixId
       AND   nutrientid = '404') x31,
           --405	Riboflavin (mg)
      (SELECT mixid,
              foodid,
              q AS Riboflavin
       FROM mixresult
       WHERE mixid = v_MixId
       AND   nutrientid = '405') x32,
           --406	Niacin (mg)
      (SELECT mixid,
              foodid,
              q AS Niacin
       FROM mixresult
       WHERE mixid = v_MixId
       AND   nutrientid = '406') x33,
           --410	Pantothenic acid (mg)
      (SELECT mixid,
              foodid,
              q AS Pantothenic
       FROM mixresult
       WHERE mixid = v_MixId
       AND   nutrientid = '410') x34,
           --415	Vitamin B-6 (mg)
      (SELECT mixid,
              foodid,
              q AS VitaminB6
       FROM mixresult
       WHERE mixid = v_MixId
       AND   nutrientid = '415') x35,
           --418	Vitamin B-12 (µg)
      (SELECT mixid,
              foodid,
              q AS VitaminB12
       FROM mixresult
       WHERE mixid = v_MixId
       AND   nutrientid = '418') x36,
           --421	Choline, total (mg)
      (SELECT mixid,
              foodid,
              q AS Choline
       FROM mixresult
       WHERE mixid = v_MixId
       AND   nutrientid = '421') x37,
           --430	Vitamin K (Phylloquinone) (µg)
      (SELECT mixid,
              foodid,
              q AS VitaminK
       FROM mixresult
       WHERE mixid = v_MixId
       AND   nutrientid = '430') x38,
           --435	Folate, DFE (µg)
      (SELECT mixid,
              foodid,
              q AS Folate
       FROM mixresult
       WHERE mixid = v_MixId
       AND   nutrientid = '435') x39,
           --601	Cholesterol (mg)
      (SELECT mixid,
              foodid,
              q AS Cholesterol
       FROM mixresult
       WHERE mixid = v_MixId
       AND   nutrientid = '601') x40,
           --606	Fatty acids, total saturated (g)
      (SELECT mixid,
              foodid,
              q AS Saturated
       FROM mixresult
       WHERE mixid = v_MixId
       AND   nutrientid = '606') x41,
           --621	22:6 n-3 (DHA) (g)
      (SELECT mixid,
              foodid,
              q AS DHA
       FROM mixresult
       WHERE mixid = v_MixId
       AND   nutrientid = '621') x42,
           --629	20:5 n-3 (EPA) (g)
      (SELECT mixid,
              foodid,
              q AS EPA
       FROM mixresult
       WHERE mixid = v_MixId
       AND   nutrientid = '629') x43,
           --645	Fatty acids, total monounsaturated (g)
      (SELECT mixid,
              foodid,
              q AS Monounsaturated
       FROM mixresult
       WHERE mixid = v_MixId
       AND   nutrientid = '645') x44,
           --646	Fatty acids, total polyunsaturated (g)
      (SELECT mixid,
              foodid,
              q AS Polyunsaturated
       FROM mixresult
       WHERE mixid = v_MixId
       AND   nutrientid = '646') x45,
           --618	18:2 undifferentiated (Linoleic) (g)
      (SELECT mixid,
              foodid,
              q AS Linoleic
       FROM mixresult
       WHERE mixid = v_MixId
       AND   nutrientid = '618') x46,
           --619	18:3 undifferentiated (Linolenic) (g)
      (SELECT mixid,
              foodid,
              q AS AlphaLinolenic
       FROM mixresult
       WHERE mixid = v_MixId
       AND   nutrientid = '619') x47,
           --10006	Glycemic Load
      (SELECT mixid,
              foodid,
              q AS GlycemicLoad
       FROM mixresult
       WHERE mixid = v_MixId
       AND   nutrientid = '10006') x50,
           --10009	Energy, digestible (kcal)
      (SELECT mixid,
              foodid,
              q AS EnergyDigestible
       FROM mixresult
       WHERE mixid = v_MixId
       AND   nutrientid = '10009') x51,
           --10011	Energy, carbohydrate (kcal)
      (SELECT mixid,
              foodid,
              q AS EnergyCarbohydrate
       FROM mixresult
       WHERE mixid = v_MixId
       AND   nutrientid = '10011') x53,
           --10012	Energy, protein (kcal)
      (SELECT mixid,
              foodid,
              q AS EnergyProtein
       FROM mixresult
       WHERE mixid = v_MixId
       AND   nutrientid = '10012') x54,
           --10013	Energy, fat (kcal)
      (SELECT mixid,
              foodid,
              q AS EnergyFat
       FROM mixresult
       WHERE mixid = v_MixId
       AND   nutrientid = '10013') x55,
           --10014	Energy, no alcohol (kcal)
      (SELECT mixid,
              foodid,
              q AS EnergyAlcohol
       FROM mixresult
       WHERE mixid = v_MixId
       AND   nutrientid = '10014') x56,
            --10010	Energy, fat and carbohydrate (kcal)
      (SELECT mixid,
              foodid,
              q AS EnergyFatCarbohydrate
       FROM mixresult
       WHERE mixid = v_MixId
       AND   nutrientid = '10010') x57,
           --611, Lauric, 12:0 (g)
      (SELECT mixid,
              foodid,
              q AS Lauric
       FROM mixresult
       WHERE mixid = v_MixId
       AND   nutrientid = '611') x58,
           --612, Myristic, 14:0 (g)
      (SELECT mixid,
              foodid,
              q AS Myristic
       FROM mixresult
       WHERE mixid = v_MixId
       AND   nutrientid = '612') x59,
           --613, Palmitic, 16:0 (g)
      (SELECT mixid,
              foodid,
              q AS Palmitic
       FROM mixresult
       WHERE mixid = v_MixId
       AND   nutrientid = '613') x60,
           --614, Stearic, 18:0 (g)
      (SELECT mixid,
              foodid,
              q AS Stearic
       FROM mixresult
       WHERE mixid = v_MixId
       AND   nutrientid = '614') x61,
         --10015, Fats, Saturated Fatty Acids, HC (g)
      (SELECT mixid,
              foodid,
              q AS HCSFA
       FROM mixresult
       WHERE mixid = v_MixId
       AND   nutrientid = '10015') x62
      --
      WHERE x0.mixid = x1.mixid
      AND   x0.foodid = x1.foodid
      AND   x0.mixid = x2.mixid
      AND   x0.foodid = x2.foodid
      AND   x0.mixid = x4.mixid
      AND   x0.foodid = x4.foodid
      AND   x0.mixid = x5.mixid
      AND   x0.foodid = x5.foodid
      AND   x0.mixid = x6.mixid
      AND   x0.foodid = x6.foodid
      AND   x0.mixid = x7.mixid
      AND   x0.foodid = x7.foodid
      AND   x0.mixid = x8.mixid
      AND   x0.foodid = x8.foodid
      AND   x0.mixid = x9.mixid
      AND   x0.foodid = x9.foodid
      AND   x0.mixid = x13.mixid
      AND   x0.foodid = x13.foodid
      AND   x0.mixid = x14.mixid
      AND   x0.foodid = x14.foodid
      AND   x0.mixid = x15.mixid
      AND   x0.foodid = x15.foodid
      AND   x0.mixid = x16.mixid
      AND   x0.foodid = x16.foodid
      AND   x0.mixid = x17.mixid
      AND   x0.foodid = x17.foodid
      AND   x0.mixid = x18.mixid
      AND   x0.foodid = x18.foodid
      AND   x0.mixid = x19.mixid
      AND   x0.foodid = x19.foodid
      AND   x0.mixid = x20.mixid
      AND   x0.foodid = x20.foodid
      AND   x0.mixid = x21.mixid
      AND   x0.foodid = x21.foodid
      AND   x0.mixid = x22.mixid
      AND   x0.foodid = x22.foodid
      AND   x0.mixid = x23.mixid
      AND   x0.foodid = x23.foodid
      AND   x0.mixid = x25.mixid
      AND   x0.foodid = x25.foodid
      AND   x0.mixid = x26.mixid
      AND   x0.foodid = x26.foodid
      AND   x0.mixid = x27.mixid
      AND   x0.foodid = x27.foodid
      AND   x0.mixid = x28.mixid
      AND   x0.foodid = x28.foodid
      AND   x0.mixid = x29.mixid
      AND   x0.foodid = x29.foodid
      AND   x0.mixid = x30.mixid
      AND   x0.foodid = x30.foodid
      AND   x0.mixid = x31.mixid
      AND   x0.foodid = x31.foodid
      AND   x0.mixid = x32.mixid
      AND   x0.foodid = x32.foodid
      AND   x0.mixid = x33.mixid
      AND   x0.foodid = x33.foodid
      AND   x0.mixid = x34.mixid
      AND   x0.foodid = x34.foodid
      AND   x0.mixid = x35.mixid
      AND   x0.foodid = x35.foodid
      AND   x0.mixid = x36.mixid
      AND   x0.foodid = x36.foodid
      AND   x0.mixid = x37.mixid
      AND   x0.foodid = x37.foodid
      AND   x0.mixid = x38.mixid
      AND   x0.foodid = x38.foodid
      AND   x0.mixid = x39.mixid
      AND   x0.foodid = x39.foodid
      AND   x0.mixid = x40.mixid
      AND   x0.foodid = x40.foodid
      AND   x0.mixid = x41.mixid
      AND   x0.foodid = x41.foodid
      AND   x0.mixid = x42.mixid
      AND   x0.foodid = x42.foodid
      AND   x0.mixid = x43.mixid
      AND   x0.foodid = x43.foodid
      AND   x0.mixid = x44.mixid
      AND   x0.foodid = x44.foodid
      AND   x0.mixid = x45.mixid
      AND   x0.foodid = x45.foodid
      AND   x0.mixid = x46.mixid
      AND   x0.foodid = x46.foodid
      AND   x0.mixid = x47.mixid
      AND   x0.foodid = x47.foodid
      AND   x0.mixid = x50.mixid
      AND   x0.foodid = x50.foodid
      AND   x0.mixid = x51.mixid
      AND   x0.foodid = x51.foodid
      AND   x0.mixid = x53.mixid
      AND   x0.foodid = x53.foodid
      AND   x0.mixid = x54.mixid
      AND   x0.foodid = x54.foodid
      AND   x0.mixid = x55.mixid
      AND   x0.foodid = x55.foodid
      AND   x0.mixid = x56.mixid
      AND   x0.foodid = x56.foodid
      AND   x0.mixid = x57.mixid
      AND   x0.foodid = x57.foodid
      AND   x0.mixid = x58.mixid
      AND   x0.foodid = x58.foodid
      AND   x0.mixid = x59.mixid
      AND   x0.foodid = x59.foodid
      AND   x0.mixid = x60.mixid
      AND   x0.foodid = x60.foodid
      AND   x0.mixid = x61.mixid
      AND   x0.foodid = x61.foodid
      AND   x0.mixid = x62.mixid
      AND   x0.foodid = x62.foodid) a,
     (SELECT foodid, name FROM food) b
WHERE a.foodid = b.foodid;
--
END;
/
