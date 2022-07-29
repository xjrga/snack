CREATE PROCEDURE nutrientconstraint_status (
--
IN v_mixid LONGVARCHAR
--
)
--
MODIFIES SQL DATA DYNAMIC RESULT SETS 1 BEGIN ATOMIC
--
DECLARE result CURSOR
FOR
SELECT d.name AS nutrient,
       c.name AS equality,
       a.b AS rhs,
       b.value,
       CASE
         WHEN ABS(a.b - b.value) <.001 THEN 'Binding'
         ELSE 'Non-binding'
       END as status,
       ABS(a.b - b.value) as slack
FROM NUTRIENTCONSTRAINT A,
     (SELECT mixid,
             nutrientid,
             SUM(q) AS value
      FROM mixresult
      WHERE mixid = v_mixid
      GROUP BY mixid,
               nutrientid) B,
     RELATIONSHIP C,
     NUTRIENT D
WHERE A.mixid = B.mixid
AND   A.nutrientid = B.nutrientid
AND   A.relationshipid = C.relationshipid
AND   A.nutrientid = D.nutrientid;
--
OPEN result;
--
END;
/

/

