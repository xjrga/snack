CREATE PROCEDURE getMixCoefficients (
--
IN v_mixid LONGVARCHAR
--
)
--
MODIFIES SQL DATA DYNAMIC RESULT SETS 1 BEGIN ATOMIC
--
DECLARE result CURSOR
FOR
--
SELECT b.foodid,
       b.nutrientid,
       getfoodcoefficient(b.foodid,b.nutrientid) as c
FROM mixfood a,
     foodfactcoefficient b,
     (SELECT nutrientid
      FROM (SELECT nutrientid
            FROM nutrientconstraint
            WHERE mixid =mixid
            UNION
            SELECT nutrient_id_1
            FROM nutrientratio
            WHERE mixid =mixid
            UNION
            SELECT nutrient_id_2
            FROM nutrientratio
            WHERE mixid =mixid
            UNION
            SELECT nutrientid
            FROM foodnutrientconstraint
            WHERE mixid =mixid
            UNION
            SELECT nutrient_id_1
            FROM foodnutrientratio
            WHERE mixid =mixid
            UNION
            SELECT nutrient_id_2
            FROM foodnutrientratio
            WHERE mixid =mixid)) c
WHERE a.foodid = b.foodid
AND   b.nutrientid = c.nutrientid
AND   a.mixid =mixid
ORDER BY b.foodid,b.nutrientid;
--
OPEN result;
--
END;
/
