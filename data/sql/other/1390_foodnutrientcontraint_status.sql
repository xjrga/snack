CREATE PROCEDURE foodnutrientconstraint_status (
--
IN v_mixid LONGVARCHAR
--
)
--
MODIFIES SQL DATA DYNAMIC RESULT SETS 1 BEGIN ATOMIC
--
DECLARE result CURSOR
FOR
SELECT d.name AS food,
       e.name as nutrient,
       c.name AS equality,
       a.b AS rhs,
       b.value,
       CASE
         WHEN ABS(a.b - b.value) <.001 THEN 'Binding'
         ELSE 'Non-binding'
       END as status,
       ABS(a.b - b.value) as slack
FROM FOODNUTRIENTCONSTRAINT A,
     (SELECT mixid,
             foodid,
             nutrientid,
             SUM(q) AS value
      FROM mixresult
      WHERE mixid = v_mixid
      GROUP BY mixid,
               foodid,
               nutrientid) B,
     RELATIONSHIP C,
     FOOD D,
     NUTRIENT E
WHERE A.mixid = B.mixid
AND   A.foodid = B.foodid
AND   A.nutrientid = B.nutrientid
AND   A.relationshipid = C.relationshipid
AND   A.foodid = D.foodid
AND   A.nutrientid = E.nutrientid;
--
OPEN result;
--
END;
/

/

