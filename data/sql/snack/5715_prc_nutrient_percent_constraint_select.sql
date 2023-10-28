CREATE PROCEDURE PercentNutrientConstraint_Select (
IN v_MixId LONGVARCHAR
)
MODIFIES SQL DATA DYNAMIC RESULT SETS 1 BEGIN ATOMIC
DECLARE result CURSOR
FOR
SELECT
a.MixId,
a.FoodId,
a.NutrientId,
d.RelationshipId,
b.Name as Food,
c.Name as Nutrient,
a.b,
d.Name as Relationship
FROM
PercentConstraint a, Food b, Nutrient c, Relationship d
WHERE
a.MixId = v_MixId
AND
a.FoodId = b.FoodId
AND
a.NutrientId = c.NutrientId
AND
a.RelationshipId = d.relationshipid
ORDER BY
a.NutrientId,a.FoodId;
--
OPEN result;
--
END;
/