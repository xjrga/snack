CREATE PROCEDURE FoodFact_EnergyDigestible ()
--
MODIFIES SQL DATA BEGIN ATOMIC
--
DECLARE v_NutrientIdA LONGVARCHAR;
DECLARE v_NutrientIdB LONGVARCHAR;
DECLARE v_NutrientIdC LONGVARCHAR;
DECLARE v_NutrientIdD LONGVARCHAR;
DECLARE v_NutrientIdE LONGVARCHAR;
DECLARE v_NutrientIdF LONGVARCHAR;
--Energy, fat (kcal)
SET v_NutrientIdA = '10013';
--Energy, carbohydrate (kcal)
SET v_NutrientIdB = '10011';
--Energy, protein (kcal)
SET v_NutrientIdC = '10012';
--Energy, alcohol (kcal)
SET v_NutrientIdD = '10014';
--Energy, digestible (kcal)
SET v_NutrientIdE = '10009';
--
FOR 
--
SELECT
--
       A.FOODID,
       A.ENERGYFAT + B.ENERGYCARBOHYDRATE + C.ENERGYPROTEIN + D.ENERGYALCOHOL AS ENERGYDIGESTIBLE,       
       A.ENERGYFAT,
       B.ENERGYCARBOHYDRATE,
       C.ENERGYPROTEIN,
       D.ENERGYALCOHOL
--
       FROM (SELECT FOODID,
                    Q AS ENERGYFAT
             FROM FOODFACT
             WHERE NUTRIENTID = '10013') A,
     (SELECT FOODID,
             Q AS ENERGYCARBOHYDRATE
      FROM FOODFACT
      WHERE NUTRIENTID = '10011') B,
     (SELECT FOODID,
             Q AS ENERGYPROTEIN
      FROM FOODFACT
      WHERE NUTRIENTID = '10012') C,
     (SELECT FOODID,
             Q AS ENERGYALCOHOL
      FROM FOODFACT
      WHERE NUTRIENTID = '10014') D
--
WHERE
--
A.FOODID = B.FOODID
AND   A.FOODID = C.FOODID
AND   A.FOODID = D.FOODID
--
DO
--
CALL FoodFact_Merge (FOODID,v_NutrientIdE,ENERGYDIGESTIBLE);
--
END FOR;
--
END;
/
