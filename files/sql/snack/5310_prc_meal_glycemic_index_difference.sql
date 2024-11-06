CREATE PROCEDURE Mix_getMealGIDiff (
--
IN v_MixId_1 LONGVARCHAR,
IN v_MixId_2 LONGVARCHAR,
IN v_Precision INTEGER
--
)
--
MODIFIES SQL DATA
DYNAMIC RESULT SETS 1
BEGIN ATOMIC
--
DECLARE result CURSOR
FOR
SELECT 'MealGI' AS nutrient,
       ROUND(a.mealgi,v_Precision) AS mix1,
       ROUND(b.mealgi,v_Precision) AS mix2,
       ROUND(a.mealgi - b.mealgi,v_Precision) AS diff       
FROM (SELECT getMealGI(v_MixId_1) AS mealgi FROM ( VALUES (0))) a,
     (SELECT getMealGI(v_MixId_2) AS mealgi FROM ( VALUES (0))) b;
--
OPEN result;
--
END;
/