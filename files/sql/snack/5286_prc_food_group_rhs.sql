CREATE PROCEDURE foodgroup_rhs (
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

SELECT mixid,
       groupid,
       nutrientid,
       relationshipid,
       b,
       b.name AS groups,
       c.name AS nutrient,
       d.name AS eq
FROM FoodGroupQuantityC a,
     mixfoodgroup b,
     nutrient c,
     relationship d
WHERE mixid = v_mixid
AND   a.mixid = b.mixid
AND   a.groupid = b.groupid
AND   a.nutrientid = c.nutrientid
AND   a.relationshipid = d.relationshipid
ORDER BY groupid;
--
OPEN result;
--
END;
/
