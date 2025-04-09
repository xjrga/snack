/*
 Problem:  ${data.problemName}
    Date:  ${data.problemDate}
  Author:  Generated By Snack Nutrition Software
*/

/* Food Count */
param     FOODS:= ${data.foodCount};

/* Meal Count */
param     MEALS := 1;

/* Nutrient Count */
param     NUTRIENTS := 58;

/* Lifestage Count */
param     LIFESTAGES := 22;

/* Dietary Reference Intake (DRI), d[lifestage,nutrient] */
param d{lifestage in 1..LIFESTAGES, nutrient in 1..NUTRIENTS};

/* Food Fact, f[food,nutrient] */
param f{food in 1..FOODS, nutrient in 1..NUTRIENTS};

/* Food Fact Coefficient, c[food,nutrient] */
param c{food in 1..FOODS, nutrient in 1..NUTRIENTS};

/* Amount of food in a meal, x[food,meal] */
var x{food in 1..FOODS, meal in 1..MEALS} >= 0;

<#list data.constraintsIterator as constraint>
${constraint.lhs}

</#list>
solve;

/* Mix Nutrition Report */

param file, symbolic := "${data.reportFileName}";

/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */


/* Variables - Nutrient Totals */

/* 1) Other, Weight (g) */
param weight := sum{food in 1..FOODS} sum{nutrient in {1}} c[food,nutrient] * sum{meal in 1..MEALS} x[food,meal];

/* 2) Protein, Complete Protein (g) */
param proteinComplete := sum{food in 1..FOODS} sum{nutrient in {2}} c[food,nutrient] * sum{meal in 1..MEALS} x[food,meal];

/* 3) Carbohydrates, Digestible (g) */
param carbohydrateDigestible := sum{food in 1..FOODS} sum{nutrient in {3}} c[food,nutrient] * sum{meal in 1..MEALS} x[food,meal];

/* 4) Other, Cost (g) */
param cost := sum{food in 1..FOODS} sum{nutrient in {4}} c[food,nutrient] * sum{meal in 1..MEALS} x[food,meal];

/* 5) Carbohydrates, Glycemic Load (g) */
param carbohydrateGL := sum{food in 1..FOODS} sum{nutrient in {5}} c[food,nutrient] * sum{meal in 1..MEALS} x[food,meal];

/* 6) Energy, Digestible (kcal) */
param energyDigestible := sum{food in 1..FOODS} sum{nutrient in {6}} c[food,nutrient] * sum{meal in 1..MEALS} x[food,meal];

/* 7) Energy, Fat and Carbohydrate (kcal) */
param energyFatAndCarbohydrate := sum{food in 1..FOODS} sum{nutrient in {7}} c[food,nutrient] * sum{meal in 1..MEALS} x[food,meal];

/* 8) Energy, Carbohydrate (kcal) */
param energyCarbohydrate := sum{food in 1..FOODS} sum{nutrient in {8}} c[food,nutrient] * sum{meal in 1..MEALS} x[food,meal];

/* 9) Energy, Protein (kcal) */
param energyProtein := sum{food in 1..FOODS} sum{nutrient in {9}} c[food,nutrient] * sum{meal in 1..MEALS} x[food,meal];

/* 10) Energy, Fat (kcal) */
param energyFat := sum{food in 1..FOODS} sum{nutrient in {10}} c[food,nutrient] * sum{meal in 1..MEALS} x[food,meal];

/* 11) Energy, Alcohol (kcal) */
param energyAlcohol := sum{food in 1..FOODS} sum{nutrient in {11}} c[food,nutrient] * sum{meal in 1..MEALS} x[food,meal];

/* 12) Fats, Hypercholesterolemic Fat (g) */
param sfaHC := sum{food in 1..FOODS} sum{nutrient in {12}} c[food,nutrient] * sum{meal in 1..MEALS} x[food,meal];

/* 13) Fats, Long Chain n-3 PUFA (g) */
param n3lcpufa := sum{food in 1..FOODS} sum{nutrient in {13}} c[food,nutrient] * sum{meal in 1..MEALS} x[food,meal];

/* 14) Protein, Total Protein (g) */
param protein := sum{food in 1..FOODS} sum{nutrient in {14}} c[food,nutrient] * sum{meal in 1..MEALS} x[food,meal];

/* 15) Fats, Total Fat (g) */
param fat := sum{food in 1..FOODS} sum{nutrient in {15}} c[food,nutrient] * sum{meal in 1..MEALS} x[food,meal];

/* 16) Carbohydrates, By Difference (g) */
param carbohydratesByDiff := sum{food in 1..FOODS} sum{nutrient in {16}} c[food,nutrient] * sum{meal in 1..MEALS} x[food,meal];

/* 17) Energy, Gross (kcal) */
param energyGross := sum{food in 1..FOODS} sum{nutrient in {17}} c[food,nutrient] * sum{meal in 1..MEALS} x[food,meal];

/* 18) Other, Alcohol (g) */
param alcohol := sum{food in 1..FOODS} sum{nutrient in {18}} c[food,nutrient] * sum{meal in 1..MEALS} x[food,meal];

/* 19) Other, Water (g) */
param water := sum{food in 1..FOODS} sum{nutrient in {19}} c[food,nutrient] * sum{meal in 1..MEALS} x[food,meal];

/* 20) Carbohydrates, Fiber (g) */
param fiber := sum{food in 1..FOODS} sum{nutrient in {20}} c[food,nutrient] * sum{meal in 1..MEALS} x[food,meal];

/* 21) Minerals, Calcium (mg) */
param calcium := sum{food in 1..FOODS} sum{nutrient in {21}} c[food,nutrient] * sum{meal in 1..MEALS} x[food,meal];

/* 22) Minerals, Iron (mg) */
param iron := sum{food in 1..FOODS} sum{nutrient in {22}} c[food,nutrient] * sum{meal in 1..MEALS} x[food,meal];

/* 23) Minerals, Magnesium (mg) */
param magnesium := sum{food in 1..FOODS} sum{nutrient in {23}} c[food,nutrient] * sum{meal in 1..MEALS} x[food,meal];

/* 24) Minerals, Phosphorus (mg) */
param phosphorus := sum{food in 1..FOODS} sum{nutrient in {24}} c[food,nutrient] * sum{meal in 1..MEALS} x[food,meal];

/* 25) Minerals, Potassium (mg) */
param potassium := sum{food in 1..FOODS} sum{nutrient in {25}} c[food,nutrient] * sum{meal in 1..MEALS} x[food,meal];

/* 26) Minerals, Sodium (mg) */
param sodium := sum{food in 1..FOODS} sum{nutrient in {26}} c[food,nutrient] * sum{meal in 1..MEALS} x[food,meal];

/* 27) Minerals, Zinc (mg) */
param zinc := sum{food in 1..FOODS} sum{nutrient in {27}} c[food,nutrient] * sum{meal in 1..MEALS} x[food,meal];

/* 28) Minerals, Copper (mg) */
param copper := sum{food in 1..FOODS} sum{nutrient in {28}} c[food,nutrient] * sum{meal in 1..MEALS} x[food,meal];

/* 29) Minerals, Manganese (mg) */
param manganese := sum{food in 1..FOODS} sum{nutrient in {29}} c[food,nutrient] * sum{meal in 1..MEALS} x[food,meal];

/* 30) Minerals, Selenium (µg) */
param selenium := sum{food in 1..FOODS} sum{nutrient in {30}} c[food,nutrient] * sum{meal in 1..MEALS} x[food,meal];

/* 31) Vitamins, A, RAE (µg) */
param vitaminA := sum{food in 1..FOODS} sum{nutrient in {31}} c[food,nutrient] * sum{meal in 1..MEALS} x[food,meal];

/* 32) Vitamins, E (mg) */
param vitaminE := sum{food in 1..FOODS} sum{nutrient in {32}} c[food,nutrient] * sum{meal in 1..MEALS} x[food,meal];

/* 33) Vitamins, D (µg) */
param vitaminD := sum{food in 1..FOODS} sum{nutrient in {33}} c[food,nutrient] * sum{meal in 1..MEALS} x[food,meal];

/* 34) Vitamins, C (mg) */
param vitaminC := sum{food in 1..FOODS} sum{nutrient in {34}} c[food,nutrient] * sum{meal in 1..MEALS} x[food,meal];

/* 35) Vitamins, Thiamin (mg) */
param thiamin := sum{food in 1..FOODS} sum{nutrient in {35}} c[food,nutrient] * sum{meal in 1..MEALS} x[food,meal];

/* 36) Vitamins, Riboflavin (mg) */
param riboflavin := sum{food in 1..FOODS} sum{nutrient in {36}} c[food,nutrient] * sum{meal in 1..MEALS} x[food,meal];

/* 37) Vitamins, Niacin (mg) */
param niacin := sum{food in 1..FOODS} sum{nutrient in {37}} c[food,nutrient] * sum{meal in 1..MEALS} x[food,meal];

/* 38) Vitamins, Pantothenic Acid (mg) */
param pantothenicAcid := sum{food in 1..FOODS} sum{nutrient in {38}} c[food,nutrient] * sum{meal in 1..MEALS} x[food,meal];

/* 39) Vitamins, B6 (mg) */
param vitaminB6 := sum{food in 1..FOODS} sum{nutrient in {39}} c[food,nutrient] * sum{meal in 1..MEALS} x[food,meal];

/* 40) Vitamins, B12 (µg) */
param vitaminB12 := sum{food in 1..FOODS} sum{nutrient in {40}} c[food,nutrient] * sum{meal in 1..MEALS} x[food,meal];

/* 41) Vitamins, Choline (mg) */
param choline := sum{food in 1..FOODS} sum{nutrient in {41}} c[food,nutrient] * sum{meal in 1..MEALS} x[food,meal];

/* 42) Vitamins, K (µg) */
param vitaminK := sum{food in 1..FOODS} sum{nutrient in {42}} c[food,nutrient] * sum{meal in 1..MEALS} x[food,meal];

/* 43) Vitamins, Folate, DFE (µg) */
param folate := sum{food in 1..FOODS} sum{nutrient in {43}} c[food,nutrient] * sum{meal in 1..MEALS} x[food,meal];

/* 44) Fats, Cholesterol (mg) */
param cholesterol := sum{food in 1..FOODS} sum{nutrient in {44}} c[food,nutrient] * sum{meal in 1..MEALS} x[food,meal];

/* 45) Fats, Saturated Fat, SFA (g) */
param sfa := sum{food in 1..FOODS} sum{nutrient in {45}} c[food,nutrient] * sum{meal in 1..MEALS} x[food,meal];

/* 46) Fats, Lauric Acid, 12:0 (g) */
param lauric := sum{food in 1..FOODS} sum{nutrient in {46}} c[food,nutrient] * sum{meal in 1..MEALS} x[food,meal];

/* 47) Fats, Myristic Acid, 14:0 (g) */
param myristic := sum{food in 1..FOODS} sum{nutrient in {47}} c[food,nutrient] * sum{meal in 1..MEALS} x[food,meal];

/* 48) Fats, Palmitic Acid, 16:0 (g) */
param palmitic := sum{food in 1..FOODS} sum{nutrient in {48}} c[food,nutrient] * sum{meal in 1..MEALS} x[food,meal];

/* 49) Fats, Stearic Acid, 18:0 (g) */
param stearic := sum{food in 1..FOODS} sum{nutrient in {49}} c[food,nutrient] * sum{meal in 1..MEALS} x[food,meal];

/* 50) Fats, Linoleic Acid, LA, 18:2 n-6 (g) */
param la := sum{food in 1..FOODS} sum{nutrient in {50}} c[food,nutrient] * sum{meal in 1..MEALS} x[food,meal];

/* 51) Fats, Alpha-linolenic Acid, ALA, 18:3 n-3 (g) */
param ala := sum{food in 1..FOODS} sum{nutrient in {51}} c[food,nutrient] * sum{meal in 1..MEALS} x[food,meal];

/* 52) Fats, Docosahexaenoic Acid, DHA, 22:6 n-3 (g) */
param dha := sum{food in 1..FOODS} sum{nutrient in {52}} c[food,nutrient] * sum{meal in 1..MEALS} x[food,meal];

/* 53) Fats, Eicosapentaenoic Acid, EPA, 20:5 n-3 (g) */
param epa := sum{food in 1..FOODS} sum{nutrient in {53}} c[food,nutrient] * sum{meal in 1..MEALS} x[food,meal];

/* 54) Fats, Monounsaturated Fat, MUFA (g) */
param mufa := sum{food in 1..FOODS} sum{nutrient in {54}} c[food,nutrient] * sum{meal in 1..MEALS} x[food,meal];

/* 55) Fats, Polyunsaturated Fat, PUFA (g) */
param pufa := sum{food in 1..FOODS} sum{nutrient in {55}} c[food,nutrient] * sum{meal in 1..MEALS} x[food,meal];

/* Other calculated values */
param energy_sfa := 9 * sfa;
param energy_pufa := 9 * pufa;
param energy_mufa := 9 * mufa;
param energy_la := 9 * la;
param energy_ala := 9 * ala;

/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

/* Create new file */
printf "%s","" > file;

/* Title */
printf "%s", "---------------------------------------------------------------" >> file;
printf "\n" >> file;
printf "%9s", "Problem: " >> file;
printf "%s", "${data.problemName}" >> file;
printf "\n" >> file;
printf "%9s", "Date: " >> file;
printf "%s", "${data.problemDate}" >> file;
printf "\n" >> file;
printf "%s ", "---------------------------------------------------------------" >> file;
printf "\n\n\n" >> file;

/* Mix Statistics */
printf "%s", "Mix Statistics" >> file;
printf "\n" >> file;
printf "%s", "---------------------------------------------------------------" >> file;
printf "\n\n" >> file;
printf "%27s", "Fat%: " >> file;
printf "%4.1f", energyFat / energyDigestible * 100 >> file;
printf "\n" >> file;
printf "%27s", "Carbohydrate%: " >> file;
printf "%4.1f", energyCarbohydrate / energyDigestible * 100 >> file;
printf "\n" >> file;
printf "%27s", "Protein%: " >> file;
printf "%4.1f", energyProtein / energyDigestible * 100 >> file;
printf "\n" >> file;
printf "%27s", "Alcohol%: " >> file;
printf "%4.1f", energyAlcohol / energyDigestible * 100 >> file;
printf "\n" >> file;
printf "%27s", "Saturated Fat%: " >> file;
printf "%4.1f", energy_sfa / energyDigestible * 100 >> file;
printf "\n" >> file;
printf "%27s", "Polyunsaturated Fat%: " >> file;
printf "%4.1f", energy_pufa / energyDigestible * 100 >> file;
printf "\n" >> file;
printf "%27s", "Monounsaturated Fat%: " >> file;
printf "%4.1f", energy_mufa / energyDigestible * 100 >> file;
printf "\n" >> file;
printf "%27s", "Linoleic Acid%: " >> file;
printf "%4.1f", energy_la / energyDigestible * 100 >> file;
printf "\n" >> file;
printf "%27s", "Alpha-Linolenic Acid%: " >> file;
printf "%4.1f", energy_ala / energyDigestible * 100 >> file;
printf "\n" >> file;
printf "%27s", "Ratio PUFA/SFA: " >> file;
printf "%4.1f", pufa / sfa >> file;
printf "\n" >> file;
printf "%27s", "Ratio MUFA/SFA: " >> file;
printf "%4.1f", mufa / sfa >> file;
printf "\n" >> file;
printf "%27s", "Ratio LA/ALA: " >> file;
printf "%4.1f", la / ala >> file;
printf "\n" >> file;
printf "%27s", "Ratio K/Na: " >> file;
printf "%4.1f", potassium / sodium >> file;
printf "\n" >> file;
printf "%27s", "Food Quotient: " >> file;
printf "%4.1f", (energyCarbohydrate / energyDigestible * 1.0) +  (energyFat / energyDigestible * 0.71) + (energyProtein / energyDigestible * 0.81) +  (energyAlcohol / energyDigestible * 0.667) >> file;
printf "\n\n\n" >> file;

printf "%s", "Daily Requirement Intake (Dri) For Males (31-50 y)" >> file;
printf "\n" >> file;
printf "%s", "---------------------------------------------------------------" >> file;
printf "\n\n" >> file;
printf "%30s %-10s %10s %10s", "", "Nutrient", "DRI", "%DRI" >> file;
printf "\n" >> file;
printf "%30s %s %s %s %s", " ", "----------", "----------", "----------" >> file;
printf "\n" >> file;

/*  2) Protein, Complete Protein (g) */
printf "%30s %10.1f %10.1f %10d", "Complete Protein (g):", proteinComplete, d[8,2], if d[8,2] <= 0 then 0 else proteinComplete / d[8,2] * 100 >> file;
printf "\n" >> file;

/* 19) Other, Water (g) */
printf "%30s %10.1f %10.1f %10d", "Water (g):", water, d[8,19], if d[8,19] <= 0 then 0 else water / d[8,19] * 100 >> file;
printf "\n" >> file;

/*  3) Carbohydrates, Digestible (g) */
printf "%30s %10.1f %10.1f %10d", "Carbohydrates (g):", carbohydrateDigestible, d[8,3], if d[8,3] <= 0 then 0 else carbohydrateDigestible / d[8,3] * 100 >> file;
printf "\n" >> file;

/* 20) Carbohydrates, Fiber (g) */
printf "%30s %10.1f %10.1f %10d", "Fiber (g):", fiber, d[8,20], if d[8,20] <= 0 then 0 else fiber / d[8,20] * 100 >> file;
printf "\n" >> file;

/* 51) Fats, Alpha-linolenic Acid, ALA, 18:3 n-3 (g) */
printf "%30s %10.1f %10.1f %10d", "Alpha-linolenic Acid (g):", ala, d[8,51], if d[8,51] <= 0 then 0 else ala / d[8,51] * 100 >> file;
printf "\n" >> file;

/* 50) Fats, Linoleic Acid, LA, 18:2 n-6 (g) */
printf "%30s %10.1f %10.1f %10d", "Linoleic Acid (g):", la, d[8,50], if d[8,50] <= 0 then 0 else la / d[8,50] * 100 >> file;
printf "\n" >> file;

/* 15) Fats, Total Fat (g) */
printf "%30s %10.1f %10.1f %10d", "Fat (g):", fat, d[8,15], if d[8,15] <= 0 then 0 else fat /  d[8,15] * 100 >> file;
printf "\n\n" >> file;

/* 21) Minerals, Calcium (mg) */
printf "%30s %10.1f %10.1f %10d", "Calcium (mg):", calcium, d[8,21], if d[8,21] <= 0 then 0 else calcium / d[8,21] * 100 >> file;
printf "\n" >> file;

/* 28) Minerals, Copper (mg) */
printf "%30s %10.1f %10.1f %10d", "Copper (mg):", copper, d[8,28], if d[8,28] <= 0 then 0 else copper / d[8,28] * 100 >> file;
printf "\n" >> file;

/* 22) Minerals, Iron (mg) */
printf "%30s %10.1f %10.1f %10d", "Iron (mg):", iron, d[8,22], if d[8,22] <= 0 then 0 else iron / d[8,22] * 100 >> file;
printf "\n" >> file;

/* 23) Minerals, Magnesium (mg) */
printf "%30s %10.1f %10.1f %10d", "Magnesium (mg):", magnesium, d[8,23], if d[8,23] <= 0 then 0 else magnesium / d[8,23] * 100 >> file;
printf "\n" >> file;

/* 29) Minerals, Manganese (mg) */
printf "%30s %10.1f %10.1f %10d", "Manganese (mg):", manganese, d[8,29], if d[8,29] <= 0 then 0 else manganese / d[8,29] * 100 >> file;
printf "\n" >> file;

/* 24) Minerals, Phosphorus (mg) */
printf "%30s %10.1f %10.1f %10d", "Phosphorus (mg):", phosphorus, d[8,24], if d[8,24] <= 0 then 0 else phosphorus / d[8,24] * 100 >> file;
printf "\n" >> file;

/* 25) Minerals, Potassium (mg) */
printf "%30s %10.1f %10.1f %10d", "Potassium (mg):", potassium, d[8,25], if d[8,25] <= 0 then 0 else potassium / d[8,25] * 100 >> file;
printf "\n" >> file;

/* 30) Minerals, Selenium (µg) */
printf "%31s %10.1f %10.1f %10d", "Selenium (µg):", selenium, d[8,30], if d[8,30] <= 0 then 0 else selenium / d[8,30] * 100 >> file;
printf "\n" >> file;

/* 26) Minerals, Sodium (mg) */
printf "%30s %10.1f %10.1f %10d", "Sodium (mg):", sodium, d[8,26], if d[8,26] <= 0 then 0 else sodium / d[8,26] * 100 >> file;
printf "\n" >> file;

/* 27) Minerals, Zinc (mg) */
printf "%30s %10.1f %10.1f %10d", "Zinc (mg):", zinc, d[8,27], if d[8,27] <= 0 then 0 else zinc / d[8,27] * 100 >> file;
printf "\n\n" >> file;

/* 31) Vitamins, A, RAE (µg) */
printf "%31s %10.1f %10.1f %10d", "Vitamin A, RAE (µg):", vitaminA, if d[8,31] <= 0 then 0 else d[8,31], vitaminA / d[8,31] * 100 >> file;
printf "\n" >> file;

/* 40) Vitamins, B12 (µg) */
printf "%31s %10.1f %10.1f %10d", "Vitamin B12 (µg):", vitaminB12, d[8,40], if d[8,40] <= 0 then 0 else vitaminB12 / d[8,40] * 100 >> file;
printf "\n" >> file;

/* 39) Vitamins, B6 (mg) */
printf "%30s %10.1f %10.1f %10d", "Vitamin B6 (mg):", vitaminB6, d[8,39], if d[8,39] <= 0 then 0 else vitaminB6 / d[8,39] * 100 >> file;
printf "\n" >> file;

/* 34) Vitamins, C (mg) */
printf "%30s %10.1f %10.1f %10d", "Vitamin C (mg):", vitaminC, d[8,34], if d[8,34] <= 0 then 0 else vitaminC / d[8,34] * 100 >> file;
printf "\n" >> file;

/* 41) Vitamins, Choline (mg) */
printf "%30s %10.1f %10.1f %10d", "Choline (mg):", choline, d[8,41], if d[8,41] <= 0 then 0 else choline / d[8,41] * 100 >> file;
printf "\n" >> file;

/* 33) Vitamins, D (µg) */
printf "%31s %10.1f %10.1f %10d", "Vitamin D (µg):", vitaminD, d[8,33], if d[8,33] <= 0 then 0 else vitaminD / d[8,33] * 100 >> file;
printf "\n" >> file;

/* 32) Vitamins, E (mg) */
printf "%30s %10.1f %10.1f %10d", "Vitamin E (mg):", vitaminE, d[8,32], if d[8,32] <= 0 then 0 else vitaminE / d[8,32] * 100 >> file;
printf "\n" >> file;

/* 43) Vitamins, Folate, DFE (µg) */
printf "%31s %10.1f %10.1f %10d", "Folate, DFE (µg):", folate, d[8,43], if d[8,43] <= 0 then 0 else folate / d[8,43] * 100 >> file;
printf "\n" >> file;

/* 42) Vitamins, K (µg) */
printf "%31s %10.1f %10.1f %10d", "Vitamin K (µg):", vitaminK, d[8,42], if d[8,42] <= 0 then 0 else vitaminK / d[8,42] * 100 >> file;
printf "\n" >> file;

/* 37) Vitamins, Niacin (mg) */
printf "%30s %10.1f %10.1f %10d", "Niacin (mg):", niacin, d[8,37], if d[8,37] <= 0 then 0 else niacin / d[8,37] * 100 >> file;
printf "\n" >> file;

/* 38) Vitamins, Pantothenic Acid (mg) */
printf "%30s %10.1f %10.1f %10d", "Pantothenic Acid (mg):", pantothenicAcid, d[8,38], if d[8,38] <= 0 then 0 else pantothenicAcid / d[8,38] * 100 >> file;
printf "\n" >> file;

/* 36) Vitamins, Riboflavin (mg) */
printf "%30s %10.1f %10.1f %10d", "Riboflavin (mg):", riboflavin, d[8,36], if d[8,36] <= 0 then 0 else riboflavin / d[8,36] * 100 >> file;
printf "\n" >> file;

/* 35) Vitamins, Thiamin (mg) */
printf "%30s %10.1f %10.1f %10d", "Thiamin (mg):", thiamin, d[8,35], if d[8,35] <= 0 then 0 else thiamin / d[8,35] * 100 >> file;
printf "\n\n\n" >> file;

/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

printf "%s", "Mix Quantities" >> file;
printf "\n" >> file;
printf "%s", "-------------------------------------------------------------->" >> file;
printf "\n\n" >> file;

/* Table Header - Nutrients */
printf "%13s","" >> file;
printf "%0s%22s","","Weight (g)" >> file;
printf "%0s%22s","","CompleteProt (g)" >> file;
printf "%0s%22s","","CarbsDigest (g)" >> file;
printf "%0s%22s","","Cost (g)" >> file;
printf "%0s%22s","","Glycemic Load (g)" >> file;
printf "%0s%22s","","eDigestible (kcal)" >> file;
printf "%0s%22s","","eFat&eCarbs (kcal)" >> file;
printf "%0s%22s","","eCarbohydrate (kcal)" >> file;
printf "%0s%22s","","eProtein (kcal)" >> file;
printf "%0s%22s","","eFat (kcal)" >> file;
printf "%0s%22s","","eAlcohol (kcal)" >> file;
printf "%0s%22s","","HCSFA (g)" >> file;
printf "%0s%22s","","n3LCPUFA (g)" >> file;
printf "%0s%22s","","Protein (g)" >> file;
printf "%0s%22s","","Fat (g)" >> file;
printf "%0s%22s","","CarbsByDiff (g)" >> file;
printf "%0s%22s","","eGross (kcal)" >> file;
printf "%0s%22s","","Alcohol (g)" >> file;
printf "%0s%22s","","Water (g)" >> file;
printf "%0s%22s","","Fiber (g)" >> file;
printf "%0s%22s","","Calcium (mg)" >> file;
printf "%0s%22s","","Iron (mg)" >> file;
printf "%0s%22s","","Magnesium (mg)" >> file;
printf "%0s%22s","","Phosphorus (mg)" >> file;
printf "%0s%22s","","Potassium (mg)" >> file;
printf "%0s%22s","","Sodium (mg)" >> file;
printf "%0s%22s","","Zinc (mg)" >> file;
printf "%0s%22s","","Copper (mg)" >> file;
printf "%0s%22s","","Manganese (mg)" >> file;
printf "%0s%23s","","Selenium (µg)" >> file;
printf "%0s%23s","","VitA, RAE (µg)" >> file;
printf "%0s%22s","","VitE (mg)" >> file;
printf "%0s%23s","","VitD (µg)" >> file;
printf "%0s%22s","","VitC (mg)" >> file;
printf "%0s%22s","","Thiamin (mg)" >> file;
printf "%0s%22s","","Riboflavin (mg)" >> file;
printf "%0s%22s","","Niacin (mg)" >> file;
printf "%0s%22s","","Pantothenic Acid (mg)" >> file;
printf "%0s%22s","","VitB6 (mg)" >> file;
printf "%0s%23s","","VitB12 (µg)" >> file;
printf "%0s%22s","","Choline (mg)" >> file;
printf "%0s%23s","","VitK (µg)" >> file;
printf "%0s%23s","","Folate, DFE (µg)" >> file;
printf "%0s%22s","","Cholesterol (mg)" >> file;
printf "%0s%22s","","SFA (g)" >> file;
printf "%0s%22s","","Lauric (g)" >> file;
printf "%0s%22s","","Myristic (g)" >> file;
printf "%0s%22s","","Palmitic (g)" >> file;
printf "%0s%22s","","Stearic (g)" >> file;
printf "%0s%22s","","LA (g)" >> file;
printf "%0s%22s","","ALA (g)" >> file;
printf "%0s%22s","","DHA (g)" >> file;
printf "%0s%22s","","EPA (g)" >> file;
printf "%0s%22s","","MUFA (g)" >> file;
printf "%0s%22s","","PUFA (g)" >> file;
printf "\n" >> file;

/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

/* Table Header - Nutrient by Meal */
printf "Nutrient by meal:\n\n" >> file;

/* Table Data - Nutrient by Meal */
for {meal in 1..MEALS} {
  printf "%13s", "meal "&meal >> file;
  for {nutrient in 1..NUTRIENTS} {
    printf "%0s%22.5f", "", sum{food in 1..FOODS} c[food,nutrient] * x[food,meal] >> file;
  }
  printf "\n" >> file;
}

/* Table Data - Nutrient by Meal Total */
printf "\n" >> file;
printf "%13s", "" >> file;
for {nutrient in 1..NUTRIENTS} {
  printf "%22s", "----------" >> file;
}
printf "\n" >> file;
printf "%13s", "Total" >> file;
for {nutrient in 1..NUTRIENTS} {
  printf "%0s%22.5f", "", sum{food in 1..FOODS, meal in 1..MEALS} c[food,nutrient] * x[food,meal] >> file;
}
printf "\n\n\n" >> file;

/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

/* Table Header - Nutrient by Food */
printf "Nutrient by food:\n\n" >> file;

/* Table Data - Nutrient by Food */
for {food in 1..FOODS} {
  printf "%13s", "food "&food >> file;
    for {nutrient in 1..NUTRIENTS} {
      printf "%0s%22.5f", "", sum{meal in 1..MEALS} c[food,nutrient] * x[food,meal] >> file;
    }
  printf "\n" >> file;
}

/* Table Data - Nutrient by Food Total */
printf "\n" >> file;
printf "%13s", "" >> file;
for {nutrient in 1..NUTRIENTS} {
  printf "%22s", "----------" >> file;
}
printf "\n" >> file;
printf "%13s", "Total" >> file;
for {nutrient in 1..NUTRIENTS} {
  printf "%0s%22.5f", "", sum{food in 1..FOODS, meal in 1..MEALS} c[food,nutrient] * x[food,meal] >> file;
}
printf "\n\n\n" >> file;

/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

/* Table Header - Nutrient by Meal by Food */
printf "Nutrient by meal by food:\n\n" >> file;

/* Table Data - Nutrient by Meal by Food */
for {meal in 1..MEALS} {
  for {food in 1..FOODS} {
  	printf "%6s %6s", "meal "&meal, "food "&food >> file;
    for {nutrient in 1..NUTRIENTS} {
    printf "%0s%22.5f", "", c[food,nutrient] * x[food,meal] >> file;
    }
    printf "\n" >> file;
  }
  printf "\n" >> file;
}

/* Table Data - Nutrient by Meal by Food Total */
printf "%13s", "" >> file;
for {nutrient in 1..NUTRIENTS} {
  printf "%22s", "----------" >> file;
}
printf "\n" >> file;

printf "%13s", "Total" >> file;
for {nutrient in 1..NUTRIENTS} {
  printf "%0s%22.5f", "", sum{food in 1..FOODS, meal in 1..MEALS} c[food,nutrient] * x[food,meal] >> file;
}
printf "\n\n\n" >> file;

/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

/* Table Header - Nutrient by Food by Meal */
printf "Nutrient by food by meal:\n\n" >> file;

/* Table Data - Nutrient by Food by Meal */
for {food in 1..FOODS} {
  for {meal in 1..MEALS} {
    printf "%6s %6s", "food "&food, "meal "&meal  >> file;
      for {nutrient in 1..NUTRIENTS} {
        printf "%0s%22.5f", "", c[food,nutrient] * x[food,meal] >> file;
      }
    printf "\n" >> file;
  }
printf "\n" >> file;
}

/* Table Data - Nutrient by Food by Meal Total */
printf "%13s", "" >> file;
for {nutrient in 1..NUTRIENTS} {
  printf "%22s", "----------" >> file;
}
printf "\n" >> file;

printf "%13s", "Total" >> file;
for {nutrient in 1..NUTRIENTS} {
  printf "%0s%22.5f", "", sum{food in 1..FOODS, meal in 1..MEALS} c[food,nutrient] * x[food,meal] >> file;
}
printf "\n\n\n" >> file;

/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

table result{food in 1..FOODS, nutrient in 1..NUTRIENTS, meal in 1..MEALS} OUT "CSV" "${data.cvsFileName}": food~FOOD, nutrient~NUTRIENT, meal~MEAL,  c[food,nutrient] * x[food,meal]~Q;

/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

data;

/* Food Fact Coefficient -> c[food,nutrient] */
${data.paramC}

/* Food Fact -> f[food,nutrient] */
${data.paramF}

/* Dietary Reference Intake (DRI) -> d[lifestage,nutrient] */
${data.paramD}

/*
Param C, F and D column:
  1) Other, Weight (g)
  2) Protein, Complete Protein (g)
  3) Carbohydrates, Digestible (g)
  4) Other, Cost (g)
  5) Carbohydrates, Glycemic Load (g)
  6) Energy, Digestible (kcal)
  7) Energy, Fat and Carbohydrate (kcal)
  8) Energy, Carbohydrate (kcal)
  9) Energy, Protein (kcal)
 10) Energy, Fat (kcal)
 11) Energy, Alcohol (kcal)
 12) Fats, Hypercholesterolemic Fat (g)
 13) Fats, Long Chain n-3 PUFA (g)
 14) Protein, Total Protein (g)
 15) Fats, Total Fat (g)
 16) Carbohydrates, By Difference (g)
 17) Energy, Gross (kcal)
 18) Other, Alcohol (g)
 19) Other, Water (g)
 20) Carbohydrates, Fiber (g)
 21) Minerals, Calcium (mg)
 22) Minerals, Iron (mg)
 23) Minerals, Magnesium (mg)
 24) Minerals, Phosphorus (mg)
 25) Minerals, Potassium (mg)
 26) Minerals, Sodium (mg)
 27) Minerals, Zinc (mg)
 28) Minerals, Copper (mg)
 29) Minerals, Manganese (mg)
 30) Minerals, Selenium (µg)
 31) Vitamins, A, RAE (µg)
 32) Vitamins, E (mg)
 33) Vitamins, D (µg)
 34) Vitamins, C (mg)
 35) Vitamins, Thiamin (mg)
 36) Vitamins, Riboflavin (mg)
 37) Vitamins, Niacin (mg)
 38) Vitamins, Pantothenic Acid (mg)
 39) Vitamins, B6 (mg)
 40) Vitamins, B12 (µg)
 41) Vitamins, Choline (mg)
 42) Vitamins, K (µg)
 43) Vitamins, Folate, DFE (µg)
 44) Fats, Cholesterol (mg)
 45) Fats, Saturated Fat, SFA (g)
 46) Fats, Lauric Acid, 12:0 (g)
 47) Fats, Myristic Acid, 14:0 (g)
 48) Fats, Palmitic Acid, 16:0 (g)
 49) Fats, Stearic Acid, 18:0 (g)
 50) Fats, Linoleic Acid, LA, 18:2 n-6 (g)
 51) Fats, Alpha-linolenic Acid, ALA, 18:3 n-3 (g)
 52) Fats, Docosahexaenoic Acid, DHA, 22:6 n-3 (g)
 53) Fats, Eicosapentaenoic Acid, EPA, 20:5 n-3 (g)
 54) Fats, Monounsaturated Fat, MUFA (g)
 55) Fats, Polyunsaturated Fat, PUFA (g)

Param C, F row:
${data.foodNameComment}

Param D row:
 1) Infants (0-6 mo)
 2) Infants (6-12 mo)
 3) Children (1-3 y)
 4) Children (4-8 y)
 5) Children (9-13 y)
 6) Males (14-18 y)
 7) Males (19-30 y)
 8) Males (31-50 y)
 9) Males (51-70 y)
10) Males (> 70 y)
11) Females (9-13 y)
12) Females (14-18 y)
13) Females (19-30 y)
14) Females (31-50 y)
15) Females (51-70 y)
16) Females (> 70 y)
17) Pregnancy (14-18 y)
18) Pregnancy (19-30 y)
19) Pregnancy (31-50 y)
20) Lactation (14-18 y)
21) Lactation (19-30 y)
22) Lactation (31-50 y)

US Department of Agriculture, Agricultural Research Service. 2016. Nutrient Data Laboratory. USDA National Nutrient Database for Standard Reference, Release 28 (Slightly revised). Version Current: May 2016.
http://www.ars.usda.gov/nea/bhnrc/mafcl

Nutrient Recommendations and Databases
https://ods.od.nih.gov/HealthInformation/nutrientrecommendations.aspx#dri
*/

end;
