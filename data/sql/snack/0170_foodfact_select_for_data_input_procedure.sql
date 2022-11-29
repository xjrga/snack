CREATE PROCEDURE FoodFact_Select_ForDataInput (
IN v_FoodId LONGVARCHAR,
IN v_Precision INTEGER
)
MODIFIES SQL DATA DYNAMIC RESULT SETS 1 BEGIN ATOMIC
DECLARE result CURSOR
FOR
SELECT b.NutrientId,
       a.Name,
       b.Name,
       Round(c.q,v_Precision)
FROM NutrientCategory a,
     Nutrient b,
     FoodFact c
WHERE a.NutrientCategoryId = b.NutrientCategoryId
AND   b.NutrientId = c.NutrientId
AND c.FoodId = v_FoodId
AND (b.NutrientId != '10003' AND b.NutrientId != '10006' AND b.NutrientId != '10009' AND b.NutrientId != '10010' AND b.NutrientId != '10011' AND b.NutrientId != '10012' AND b.NutrientId != '10013' AND b.NutrientId != '10014')
ORDER BY a.Name,b.Name;
OPEN result;
END;
/