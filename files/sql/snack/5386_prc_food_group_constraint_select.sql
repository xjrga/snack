CREATE PROCEDURE FoodGroupConstraint_Select (
IN v_MixId LONGVARCHAR
)
MODIFIES SQL DATA DYNAMIC RESULT SETS 1 BEGIN ATOMIC
DECLARE result CURSOR
FOR
SELECT
a.MixId,
a.GroupId,
a.NutrientId,
a.RelationshipId,
e.Name as Groups,
c.Name as Nutrient,
d.Name as Relationship,
CASE WHEN a.b IS NULL THEN 0 ELSE a.b END
FROM FoodGroupQuantityC a,
     Nutrient c,
     Relationship d,
     MixFoodGroup e
WHERE a.MixId = v_MixId
AND   a.mixid = e.mixid
AND   e.GroupId = a.GroupId
AND   c.NutrientId = a.NutrientId
AND   d.RelationshipId = a.RelationshipId
ORDER BY a.MixId,
         e.Name,
         c.Name,
         d.Name;
--
OPEN result;
--
END;
/
