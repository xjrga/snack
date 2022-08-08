CREATE PROCEDURE FoodFact_EnergyNoProtein ()
--
MODIFIES SQL DATA BEGIN ATOMIC
--
DECLARE v_NutrientIdB LONGVARCHAR;
--Energy, fat and carbohydrate (kcal)
SET v_NutrientIdB = '10010';
--
FOR SELECT a.foodid,
       energyfat + energycarbs AS energy
FROM (SELECT FOODID,Q AS ENERGYFAT
      FROM FOODFACT
      WHERE NUTRIENTID = '10013') a,
     (SELECT FOODID, Q AS ENERGYCARBS
      FROM FOODFACT
      WHERE NUTRIENTID = '10011') b
WHERE a.foodid = b.foodid DO
--
CALL FoodFact_Merge (FOODID,v_NutrientIdB,ENERGY);
--
END FOR;
--
END;
/
