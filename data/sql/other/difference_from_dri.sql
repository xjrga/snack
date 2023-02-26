SELECT 
       SUM(COMPLETEPROTEIN) as COMPLETEPROTEIN,
       SUM(DIGESTIBLECARBOHYDRATE) as DIGESTIBLECARBOHYDRATE,
       SUM(COST) as COST,
       SUM(PROTEIN) as PROTEIN,
       SUM(FAT) as FAT,
       SUM(CARBSBYDIFF) as CARBSBYDIFF,
       SUM(ENERGYGROSS) as ENERGYGROSS,
       SUM(ALCOHOL) as ALCOHOL,
       SUM(WATER) as WATER,
       SUM(FIBER) as FIBER,
       SUM(CALCIUM) as CALCIUM,
       SUM(IRON) as IRON,
       SUM(MAGNESIUM) as MAGNESIUM,
       SUM(PHOSPHORUS) as PHOSPHORUS,
       SUM(POTASSIUM) as POTASSIUM,
       SUM(SODIUM) as SODIUM,
       SUM(ZINC) as ZINC,
       SUM(COPPER) as COPPER,
       SUM(FLUORIDE) as FLUORIDE,
       SUM(MANGANESE) as MANGANESE,
       SUM(SELENIUM) as SELENIUM,
       SUM(VITAMINA) as VITAMINA,
       SUM(VITAMINE) as VITAMINE,
       SUM(VITAMIND) as VITAMIND,
       SUM(VITAMINC) as VITAMINC,
       SUM(THIAMIN) as THIAMIN,
       SUM(RIBOFLAVIN) as RIBOFLAVIN,
       SUM(NIACIN) as NIACIN,
       SUM(PANTOTHENICACID) as PANTOTHENICACID,
       SUM(VITAMINB6) as VITAMINB6,
       SUM(VITAMINB12) as VITAMINB12,
       SUM(CHOLINE) as CHOLINE,
       SUM(VITAMINK) as VITAMINK,
       SUM(FOLATE) as FOLATE,
       SUM(CHOLESTEROL) as CHOLESTEROL,
       SUM(SFA) as SFA,
       SUM(DHA) as DHA,
       SUM(EPA) as EPA,
       SUM(MUFA) as MUFA,
       SUM(PUFA) as PUFA,
       SUM(LINOLEICACID) as LINOLEICACID,
       SUM(ALPHALINOLENICACID) as ALPHALINOLENICACID,
       SUM(GLYCEMICLOAD) as GLYCEMICLOAD,
       SUM(ENERGYDIGESTIBLE) as ENERGYDIGESTIBLE,
       SUM(ENERGYCARBOHYDRATE) as ENERGYCARBOHYDRATE,
       SUM(ENERGYPROTEIN) as ENERGYPROTEIN,
       SUM(ENERGYFAT) as ENERGYFAT,
       SUM(ENERGYALCOHOL) as ENERGYALCOHOL,
       SUM(ENERGYFATCARBOHYDRATE) as ENERGYFATCARBOHYDRATE
FROM mixresultdn
WHERE mixid = '3095447282040756400089031771047848210020600797963753870097660549843180850086940447956713330069904881115284180086364196306006400'
AND   name LIKE 'Dummy%';
