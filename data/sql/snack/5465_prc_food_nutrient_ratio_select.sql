CREATE PROCEDURE FoodNutrientRatio_Select (
IN v_MixId LONGVARCHAR
)
MODIFIES SQL DATA DYNAMIC RESULT SETS 1 BEGIN ATOMIC
DECLARE result CURSOR
FOR
SELECT
a.MixId,
a.Food_Id_1,
a.Nutrient_Id_1,
a.Food_Id_2,
a.Nutrient_Id_2,
a.RelationshipId,
b.Name as FoodA,
c.Name as NutrientA,
d.Name as FoodB,
e.Name as NutrientB,
a.A,
a.B,
f.Name as Relationship
FROM
FoodNutrientRatio a, Food b, Nutrient c, Food d, Nutrient e, Relationship f
WHERE
a.MixId = v_MixId
AND
a.Food_Id_1 = b.FoodId
AND
a.Nutrient_Id_1 = c.NutrientId
AND
a.Food_Id_2 = d.FoodId
AND
a.Nutrient_Id_2 = e.NutrientId
AND
a.relationshipid = f.relationshipid;
--
OPEN result;
--
END;
/
