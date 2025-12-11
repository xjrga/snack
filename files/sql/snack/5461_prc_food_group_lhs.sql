CREATE PROCEDURE foodgroup_lhs (
--
IN v_mixid LONGVARCHAR,
--
IN v_groupid LONGVARCHAR,
--
IN v_nutrientid LONGVARCHAR,
--
IN v_relationshipid INTEGER
--
)
--
MODIFIES SQL DATA
DYNAMIC RESULT SETS 1
BEGIN ATOMIC
--
DECLARE result CURSOR
FOR
--
SELECT a.foodid AS name,
       IFNULL(b.c,0) AS c
FROM (SELECT foodid FROM mixfood WHERE mixid = v_mixid) a
  LEFT JOIN (SELECT mixid,
                    foodid,
                    c
             FROM foodgrouplist a,
                  foodfactcoefficient b
             WHERE a.foodid = b.foodid
             AND   a.mixid = v_mixid
             AND   a.groupid = v_groupid
             AND   b.nutrientid = v_nutrientid) b ON a.foodid = b.foodid
ORDER BY a.foodid;
--
OPEN result;
--
END
/