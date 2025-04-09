CREATE PROCEDURE FoodFact_N3LCPUFA()
--
MODIFIES SQL DATA BEGIN ATOMIC
--
DECLARE v_NutrientIdB LONGVARCHAR;
--Fats, Long Chain n-3 PUFA (g)
SET v_NutrientIdB = '10016';
--
FOR SELECT a.foodid,
       a.epa + b.dha AS n3lcpufa
FROM (SELECT FOODID,Q AS epa
      FROM FOODFACT
      WHERE NUTRIENTID = '629') a,
     (SELECT FOODID, Q AS dha
      FROM FOODFACT
      WHERE NUTRIENTID = '621') b
WHERE a.foodid = b.foodid
--
DO
--
CALL FoodFact_Merge (FOODID,v_NutrientIdB,n3lcpufa);
--
END FOR;
--
END;
/
