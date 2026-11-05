/*
    PROBLEM: Chicken, Rice And Veggies
       DATE: Wednesday, October 28, 2026 at 15:37:19
  OBJECTIVE: Minimize Dietary Reference Intakes deficiency and Upper Limit excess
*/

/*
VARIABLES

 1) Broccoli, cooked, boiled, drained, without salt
 2) Rice, brown, long-grain, cooked
 3) *Chicken, broiler or fryers, breast, skinless, boneless, meat only, cooked, grilled
 4) Deficiency - Minerals, Calcium (mg)
 5) Deficiency - Minerals, Magnesium (mg)
 6) Deficiency - Minerals, Potassium (mg)
 7) Deficiency - Minerals, Sodium (mg)
 8) Deficiency - Vitamins, A, RAE (mcg)
 9) Deficiency - Vitamins, E (mg)
10) Deficiency - Vitamins, D (mcg)
11) Deficiency - Vitamins, C (mg)
12) Deficiency - Vitamins, Choline (mg)
13) Excess - Minerals, Calcium (mg)
14) Excess - Minerals, Magnesium (mg)
15) Excess - Minerals, Potassium (mg)
16) Excess - Minerals, Sodium (mg)
17) Excess - Vitamins, A, RAE (mcg)
18) Excess - Vitamins, E (mg)
19) Excess - Vitamins, D (mcg)
20) Excess - Vitamins, C (mg)
21) Excess - Vitamins, Choline (mg)
22) Average Deficiency
23) Average Excess
*/

/* ----- OBJECTIVE FUNCTION ----- */

/* Minimize */

min:
  0 A01 + 0 B01 + 0 C01 + 0 D01 + 0 E01 + 0 F01 + 0 A02 + 0 B02 + 0 C02 + 0 D02 + 0 E02 + 0 F02 + 0 A03 + 0 B03 + 0 C03 + 0 D03 + 0 E03 + 0 F03 + 0 x04 + 0 x05 + 0 x06 + 0 x07 + 0 x08 + 0 x09 + 0 x10 + 0 x11 + 0 x12 + 0 x13 + 0 x14 + 0 x15 + 0 x16 + 0 x17 + 0 x18 + 0 x19 + 0 x20 + 0 x21 + 1 x22 + 1 x23 ;

/* ----- NUTRIENT DEFICIENCY AND EXCESS CONSTRAINTS ----- */

/* Deficiency And Excess - Minerals, Calcium (mg) */

  0.4 A01 + 0.4 B01 + 0.4 C01 + 0.4 D01 + 0.4 E01 + 0.4 F01 + 0.03 A02 + 0.03 B02 + 0.03 C02 + 0.03 D02 + 0.03 E02 + 0.03 F02 + 0.05 A03 + 0.05 B03 + 0.05 C03 + 0.05 D03 + 0.05 E03 + 0.05 F03 + 1 x04 + 0 x05 + 0 x06 + 0 x07 + 0 x08 + 0 x09 + 0 x10 + 0 x11 + 0 x12 - 1 x13 + 0 x14 + 0 x15 + 0 x16 + 0 x17 + 0 x18 + 0 x19 + 0 x20 + 0 x21 + 0 x22 + 0 x23  = 1000;

/* Deficiency And Excess - Minerals, Magnesium (mg) */

  0.21 A01 + 0.21 B01 + 0.21 C01 + 0.21 D01 + 0.21 E01 + 0.21 F01 + 0.39 A02 + 0.39 B02 + 0.39 C02 + 0.39 D02 + 0.39 E02 + 0.39 F02 + 0.34 A03 + 0.34 B03 + 0.34 C03 + 0.34 D03 + 0.34 E03 + 0.34 F03 + 0 x04 + 1 x05 + 0 x06 + 0 x07 + 0 x08 + 0 x09 + 0 x10 + 0 x11 + 0 x12 + 0 x13 - 1 x14 + 0 x15 + 0 x16 + 0 x17 + 0 x18 + 0 x19 + 0 x20 + 0 x21 + 0 x22 + 0 x23  = 420;

/* Deficiency And Excess - Minerals, Potassium (mg) */

  2.93 A01 + 2.93 B01 + 2.93 C01 + 2.93 D01 + 2.93 E01 + 2.93 F01 + 0.86 A02 + 0.86 B02 + 0.86 C02 + 0.86 D02 + 0.86 E02 + 0.86 F02 + 3.91 A03 + 3.91 B03 + 3.91 C03 + 3.91 D03 + 3.91 E03 + 3.91 F03 + 0 x04 + 0 x05 + 1 x06 + 0 x07 + 0 x08 + 0 x09 + 0 x10 + 0 x11 + 0 x12 + 0 x13 + 0 x14 - 1 x15 + 0 x16 + 0 x17 + 0 x18 + 0 x19 + 0 x20 + 0 x21 + 0 x22 + 0 x23  = 3400;

/* Deficiency And Excess - Minerals, Sodium (mg) */

  0.41 A01 + 0.41 B01 + 0.41 C01 + 0.41 D01 + 0.41 E01 + 0.41 F01 + 0.04 A02 + 0.04 B02 + 0.04 C02 + 0.04 D02 + 0.04 E02 + 0.04 F02 + 0.52 A03 + 0.52 B03 + 0.52 C03 + 0.52 D03 + 0.52 E03 + 0.52 F03 + 0 x04 + 0 x05 + 0 x06 + 1 x07 + 0 x08 + 0 x09 + 0 x10 + 0 x11 + 0 x12 + 0 x13 + 0 x14 + 0 x15 - 1 x16 + 0 x17 + 0 x18 + 0 x19 + 0 x20 + 0 x21 + 0 x22 + 0 x23  = 1500;

/* Deficiency And Excess - Vitamins, A, RAE (mcg) */

  0.77 A01 + 0.77 B01 + 0.77 C01 + 0.77 D01 + 0.77 E01 + 0.77 F01 + 0 A02 + 0 B02 + 0 C02 + 0 D02 + 0 E02 + 0 F02 + 0.1 A03 + 0.1 B03 + 0.1 C03 + 0.1 D03 + 0.1 E03 + 0.1 F03 + 0 x04 + 0 x05 + 0 x06 + 0 x07 + 1 x08 + 0 x09 + 0 x10 + 0 x11 + 0 x12 + 0 x13 + 0 x14 + 0 x15 + 0 x16 - 1 x17 + 0 x18 + 0 x19 + 0 x20 + 0 x21 + 0 x22 + 0 x23  = 900;

/* Deficiency And Excess - Vitamins, E (mg) */

  0.0145 A01 + 0.0145 B01 + 0.0145 C01 + 0.0145 D01 + 0.0145 E01 + 0.0145 F01 + 0.0017 A02 + 0.0017 B02 + 0.0017 C02 + 0.0017 D02 + 0.0017 E02 + 0.0017 F02 + 0.0054 A03 + 0.0054 B03 + 0.0054 C03 + 0.0054 D03 + 0.0054 E03 + 0.0054 F03 + 0 x04 + 0 x05 + 0 x06 + 0 x07 + 0 x08 + 1 x09 + 0 x10 + 0 x11 + 0 x12 + 0 x13 + 0 x14 + 0 x15 + 0 x16 + 0 x17 - 1 x18 + 0 x19 + 0 x20 + 0 x21 + 0 x22 + 0 x23  = 15;

/* Deficiency And Excess - Vitamins, D (mcg) */

  0 A01 + 0 B01 + 0 C01 + 0 D01 + 0 E01 + 0 F01 + 0 A02 + 0 B02 + 0 C02 + 0 D02 + 0 E02 + 0 F02 + 0 A03 + 0 B03 + 0 C03 + 0 D03 + 0 E03 + 0 F03 + 0 x04 + 0 x05 + 0 x06 + 0 x07 + 0 x08 + 0 x09 + 1 x10 + 0 x11 + 0 x12 + 0 x13 + 0 x14 + 0 x15 + 0 x16 + 0 x17 + 0 x18 - 1 x19 + 0 x20 + 0 x21 + 0 x22 + 0 x23  = 15;

/* Deficiency And Excess - Vitamins, C (mg) */

  0.649 A01 + 0.649 B01 + 0.649 C01 + 0.649 D01 + 0.649 E01 + 0.649 F01 + 0 A02 + 0 B02 + 0 C02 + 0 D02 + 0 E02 + 0 F02 + 0 A03 + 0 B03 + 0 C03 + 0 D03 + 0 E03 + 0 F03 + 0 x04 + 0 x05 + 0 x06 + 0 x07 + 0 x08 + 0 x09 + 0 x10 + 1 x11 + 0 x12 + 0 x13 + 0 x14 + 0 x15 + 0 x16 + 0 x17 + 0 x18 + 0 x19 - 1 x20 + 0 x21 + 0 x22 + 0 x23  = 90;

/* Deficiency And Excess - Vitamins, Choline (mg) */

  0.401 A01 + 0.401 B01 + 0.401 C01 + 0.401 D01 + 0.401 E01 + 0.401 F01 + 0.092 A02 + 0.092 B02 + 0.092 C02 + 0.092 D02 + 0.092 E02 + 0.092 F02 + 1.114 A03 + 1.114 B03 + 1.114 C03 + 1.114 D03 + 1.114 E03 + 1.114 F03 + 0 x04 + 0 x05 + 0 x06 + 0 x07 + 0 x08 + 0 x09 + 0 x10 + 0 x11 + 1 x12 + 0 x13 + 0 x14 + 0 x15 + 0 x16 + 0 x17 + 0 x18 + 0 x19 + 0 x20 - 1 x21 + 0 x22 + 0 x23  = 550;


/* ----- NUTRIENT AVERAGE DEFICIENCY AND EXCESS CONSTRAINTS ----- */

/* Average Excess - UL */

  0 A01 + 0 B01 + 0 C01 + 0 D01 + 0 E01 + 0 F01 + 0 A02 + 0 B02 + 0 C02 + 0 D02 + 0 E02 + 0 F02 + 0 A03 + 0 B03 + 0 C03 + 0 D03 + 0 E03 + 0 F03 + 0 x04 + 0 x05 + 0 x06 + 0 x07 + 0 x08 + 0 x09 + 0 x10 + 0 x11 + 0 x12 + 0.0005 x13 + 0.002857142857142857 x14 + 0 x15 + 0.000666666666666666 x16 + 0.000333333333333333 x17 + 0.001 x18 + 0.01 x19 + 0.0005 x20 + 0.000285714285714285 x21 + 0 x22 - 9 x23  = 0;

/* Average Deficiency - DRI */

  0 A01 + 0 B01 + 0 C01 + 0 D01 + 0 E01 + 0 F01 + 0 A02 + 0 B02 + 0 C02 + 0 D02 + 0 E02 + 0 F02 + 0 A03 + 0 B03 + 0 C03 + 0 D03 + 0 E03 + 0 F03 + 0.001 x04 + 0.00238095238095238 x05 + 0.000294117647058823 x06 + 0.000666666666666666 x07 + 0.001111111111111111 x08 + 0.06666666666666667 x09 + 0.06666666666666667 x10 + 0.011111111111111112 x11 + 0.001818181818181818 x12 + 0 x13 + 0 x14 + 0 x15 + 0 x16 + 0 x17 + 0 x18 + 0 x19 + 0 x20 + 0 x21 - 9 x22 + 0 x23  = 0;


/* ----- NUTRIENT CONSTRAINTS ----- */

/* Protein, Complete Protein (g) = 100 */

  0 A01 + 0 B01 + 0 C01 + 0 D01 + 0 E01 + 0 F01 + 0 A02 + 0 B02 + 0 C02 + 0 D02 + 0 E02 + 0 F02 + 0.3054 A03 + 0.3054 B03 + 0.3054 C03 + 0.3054 D03 + 0.3054 E03 + 0.3054 F03 + 0 x04 + 0 x05 + 0 x06 + 0 x07 + 0 x08 + 0 x09 + 0 x10 + 0 x11 + 0 x12 + 0 x13 + 0 x14 + 0 x15 + 0 x16 + 0 x17 + 0 x18 + 0 x19 + 0 x20 + 0 x21 + 0 x22 + 0 x23  = 100;

/* Energy, Digestible (Kcal) = 2000 */

  0.30396 A01 + 0.30396 B01 + 0.30396 C01 + 0.30396 D01 + 0.30396 E01 + 0.30396 F01 + 1.17528 A02 + 1.17528 B02 + 1.17528 C02 + 1.17528 D02 + 1.17528 E02 + 1.17528 F02 + 1.72068 A03 + 1.72068 B03 + 1.72068 C03 + 1.72068 D03 + 1.72068 E03 + 1.72068 F03 + 0 x04 + 0 x05 + 0 x06 + 0 x07 + 0 x08 + 0 x09 + 0 x10 + 0 x11 + 0 x12 + 0 x13 + 0 x14 + 0 x15 + 0 x16 + 0 x17 + 0 x18 + 0 x19 + 0 x20 + 0 x21 + 0 x22 + 0 x23  = 2000;

/* Carbohydrates, Fiber (g) = 40 */

  0.033 A01 + 0.033 B01 + 0.033 C01 + 0.033 D01 + 0.033 E01 + 0.033 F01 + 0.016 A02 + 0.016 B02 + 0.016 C02 + 0.016 D02 + 0.016 E02 + 0.016 F02 + 0 A03 + 0 B03 + 0 C03 + 0 D03 + 0 E03 + 0 F03 + 0 x04 + 0 x05 + 0 x06 + 0 x07 + 0 x08 + 0 x09 + 0 x10 + 0 x11 + 0 x12 + 0 x13 + 0 x14 + 0 x15 + 0 x16 + 0 x17 + 0 x18 + 0 x19 + 0 x20 + 0 x21 + 0 x22 + 0 x23  = 40;


/* ----- NUTRIENT RATIO CONSTRAINTS ----- */


/* ----- FOOD CONSTRAINTS ----- */


/* ----- FOOD RATIO CONSTRAINTS ----- */


/* ----- GROUP CONSTRAINTS ----- */


/* ----- MEALS CONSTRAINTS (EQUAL IN PROTEIN) -----

  0 A01 + 0 A02 + 0.3054 A03 - 0 B01 - 0 B02  - 0.3054 B03 = 0;  
  
  0 B01 + 0 B02 + 0.3054 B03 - 0 C01 - 0 C02  - 0.3054 C03 = 0;
  
  0 C01 + 0 A02 + 0.3054 C03 - 0 D01 - 0 D02  - 0.3054 D03 = 0;
  
  0 D01 + 0 D02 + 0.3054 D03 - 0 E01 - 0 E02  - 0.3054 E03 = 0;
  
  0 E01 + 0 E02 + 0.3054 E03 - 0 F01 - 0 F02  - 0.3054 F03 = 0;
*/
  
/* ----- MEALS CONSTRAINTS (EQUAL IN PROTEIN) ----- 

  0 A01 + 0 A02 + 0.3054 A03 - 0 B01 - 0 B02  - 0.3054 B03 = 0;  
  
  0 A01 + 0 A02 + 0.3054 A03 - 0 C01 - 0 C02  - 0.3054 C03 = 0;
  
  0 A01 + 0 A02 + 0.3054 A03 - 0 D01 - 0 D02  - 0.3054 D03 = 0;
  
  0 A01 + 0 A02 + 0.3054 A03 - 0 E01 - 0 E02  - 0.3054 E03 = 0;
  
  0 A01 + 0 A02 + 0.3054 A03 - 0 F01 - 0 F02  - 0.3054 F03 = 0;
*/

/* ----- MEALS CONSTRAINTS (EQUAL IN ENERGY) ----- 
  
  0.30396 A01 + 1.17528 A02 +  1.72068 A03 - 0.30396 B01 - 1.17528 B02 -  1.72068 B03 = 0;
  
  0.30396 A01 + 1.17528 A02 +  1.72068 A03 - 0.30396 C01 - 1.17528 C02 -  1.72068 C03 = 0;
  
  0.30396 A01 + 1.17528 A02 +  1.72068 A03 - 0.30396 D01 - 1.17528 D02 -  1.72068 D03 = 0;
  
  0.30396 A01 + 1.17528 A02 +  1.72068 A03 - 0.30396 E01 - 1.17528 E02 -  1.72068 E03 = 0;
  
  0.30396 A01 + 1.17528 A02 +  1.72068 A03 - 0.30396 F01 - 1.17528 F02 -  1.72068 F03 = 0;
*/
  
/* ----- MEALS CONSTRAINTS (EQUAL IN MASS) ----- 
  
  1 A01 + 1 A02 +  1 A03 - 1 B01 - 1 B02 -  1 B03 = 0;
  
  1 A01 + 1 A02 +  1 A03 - 1 C01 - 1 C02 -  1 C03 = 0;
  
  1 A01 + 1 A02 +  1 A03 - 1 D01 - 1 D02 -  1 D03 = 0;
  
  1 A01 + 1 A02 +  1 A03 - 1 E01 - 1 E02 -  1 E03 = 0;
  
  1 A01 + 1 A02 +  1 A03 - 1 F01 - 1 F02 -  1 F03 = 0;
*/

/* ----- MEAL-FOOD CONSTRAINTS (EQUAL IN MASS) ----- */

  /* Food 1 in Meal A = Food 1 in Meal B */
  
  1 A01 - 1 B01 = 0;
  
  1 B01 - 1 C01 = 0;
  
  1 C01 - 1 D01 = 0;
  
  1 D01 - 1 E01 = 0;
  
  1 E01 - 1 F01 = 0;
  
  
  1 A02 - 1 B02 = 0;
  
  1 B02 - 1 C02 = 0;
  
  1 C02 - 1 D02 = 0;
  
  1 D02 - 1 E02 = 0;
  
  1 E02 - 1 F02 = 0;
  
  
  1 A03 - 1 B03 = 0;
  
  1 B03 - 1 C03 = 0;
  
  1 C03 - 1 D03 = 0;
  
  1 D03 - 1 E03 = 0;
  
  1 E03 - 1 F03 = 0;

/*
Nutrient Constraints
Nutrient Ratio Constraints
Food Constraints
Food Ratio Constraints
Meal Constraints
Meal Ratio Constraints
Meal Food Constraints
Meal Food Ratio Constraints
Group Constraints

Equally distributed between two meals
*/

/* Model is feasible. A solution exists which satisfies all the constraints. */

