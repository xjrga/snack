CREATE PROCEDURE FoodFact_Select_ForCheckCoefficient (
IN v_FoodId LONGVARCHAR,
IN v_Precision INTEGER
)
MODIFIES SQL DATA DYNAMIC RESULT SETS 1 BEGIN ATOMIC
DECLARE result CURSOR
FOR
SELECT b.NutrientId,
       a.Name,
       b.Name,
       Round(c.q,v_Precision) as Fact,
       Round(d.c,v_Precision) as Coefficient
FROM NutrientCategory a,
     Nutrient b,
     FoodFact c,
     FoodFactCoefficient d
WHERE a.NutrientCategoryId = b.NutrientCategoryId
AND   b.NutrientId = c.NutrientId
AND   b.NutrientId = d.NutrientId
AND   c.FoodId = d.FoodId
AND c.FoodId = v_FoodId;
OPEN result;
END;
/