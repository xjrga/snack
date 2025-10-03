CREATE PROCEDURE NutrientConstraint_Select (
IN v_MixId LONGVARCHAR
)
MODIFIES SQL DATA DYNAMIC RESULT SETS 1 BEGIN ATOMIC
DECLARE result CURSOR
FOR
SELECT
a.MixId,
a.NutrientId,
a.RelationshipId,
b.Name as Nutrient,
c.Name as Relationship,
a.b
FROM
NutrientQuantityC a, Nutrient b, Relationship c
WHERE
a.MixId = v_MixId
AND
a.nutrientid = b.nutrientid
AND
a.relationshipid = c.relationshipid
ORDER BY a.MixId,b.Name,c.Name;
--
OPEN result;
--
END;
/
