CREATE PROCEDURE FoodFact_HCSFA()
--
MODIFIES SQL DATA BEGIN ATOMIC
--
DECLARE v_NutrientIdB LONGVARCHAR;
--Fats, Saturated Fatty Acids, HC (g)
SET v_NutrientIdB = '10015';
--
FOR SELECT a.foodid,
       a.lauric + b.myristic + c.palmitic AS hcsfa
FROM (SELECT FOODID,Q AS lauric
      FROM FOODFACT
      WHERE NUTRIENTID = '611') a,
     (SELECT FOODID, Q AS myristic
      FROM FOODFACT
      WHERE NUTRIENTID = '612') b,
     (SELECT FOODID, Q AS palmitic
      FROM FOODFACT
      WHERE NUTRIENTID = '613') c
WHERE a.foodid = b.foodid
AND a.foodid = c.foodid
--
DO
--
CALL FoodFact_Merge (FOODID,v_NutrientIdB,hcsfa);
--
END FOR;
--
END;
/
