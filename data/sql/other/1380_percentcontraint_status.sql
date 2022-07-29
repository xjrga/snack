CREATE PROCEDURE percentconstraint_status (
--
IN v_mixid LONGVARCHAR
--
)
--
MODIFIES SQL DATA DYNAMIC RESULT SETS 1 BEGIN ATOMIC
--
DECLARE result CURSOR
FOR
SELECT C.name AS food,
       D.name AS nutrient,
       E.name AS equality,
       A.b AS rhs,
       B.value,
       CASE
         WHEN ABS(A.b - B.value) <.001 THEN 'Binding'
         ELSE 'Non-binding'
       END as status,
       ABS(A.b - B.value) as slack
FROM PERCENTCONSTRAINT A,
     (SELECT mixid,
             foodid,
             nutrientid,
             CASE
               WHEN total = 0 THEN 0
               ELSE value / total*100
             END AS value
      FROM (SELECT mixid, foodid, nutrientid, q AS value FROM mixresult) A,
           (SELECT mixid,
                   nutrientid,
                   SUM(q) AS total
            FROM mixresult
            GROUP BY mixid,
                     nutrientid) B
      WHERE A.mixid = B.mixid
      AND   A.nutrientid = B.nutrientid) B,
     FOOD C,
     NUTRIENT D,
     RELATIONSHIP E
WHERE A.mixid = B.mixid
AND   A.mixid = v_mixid
AND   A.foodid = B.foodid
AND   A.nutrientid = B.nutrientid
AND   A.foodid = C.foodid
AND   A.nutrientid = D.nutrientid
AND   A.relationshipid = E.relationshipid;
--
OPEN result;
--
END;
/

/
