CREATE PROCEDURE FoodFact_EnergyProtein ()
--
MODIFIES SQL DATA BEGIN ATOMIC
--
DECLARE v_NutrientIdA LONGVARCHAR;
DECLARE v_NutrientIdB LONGVARCHAR;
--Protein (g)
SET v_NutrientIdA = '203';
--Energy, protein (kcal)
SET v_NutrientIdB = '10012';
--
FOR SELECT FOODID, Q * 4.7 AS ENERGY FROM FOODFACT WHERE NUTRIENTID = v_NutrientIdA DO
--
CALL FoodFact_Merge (FOODID,v_NutrientIdB,ENERGY);
--
END FOR;
--
END;
/
