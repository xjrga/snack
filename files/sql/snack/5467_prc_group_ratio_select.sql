CREATE PROCEDURE GroupRatio_Select (
IN v_MixId LONGVARCHAR
)
MODIFIES SQL DATA DYNAMIC RESULT SETS 1 BEGIN ATOMIC
DECLARE result CURSOR
FOR
SELECT
	a.MixId,
	a.Group_Id_1,
	a.Nutrient_Id_1,
	a.Group_Id_2,
	a.Nutrient_Id_2,
	a.RelationshipId,
	b.Name AS GroupA,
	c.Name AS NutrientA,
	d.Name AS GroupB,
	e.Name AS NutrientB,
	a.A,
	a.B,
	f.Name AS Relationship
FROM
	FoodGroupRatioC a,
	MixFoodGroup b,
	Nutrient c,
	MixFoodGroup d,
	Nutrient e,
	Relationship f
WHERE
	a.MixId = v_MixId
	AND
a.Mixid = b.Mixid
	AND
a.Mixid = d.Mixid
	AND
a.Group_Id_1 = b.GroupId
	AND
a.Nutrient_Id_1 = c.NutrientId
	AND
a.Group_Id_2 = d.GroupId
	AND
a.Nutrient_Id_2 = e.NutrientId
	AND
a.relationshipid = f.relationshipid
ORDER BY
	a.MixId,
	b.Name,
	d.Name,
	c.Name,
	c.Name,
	e.Name,
	f.Name;
--
OPEN result;
--
END;
/
