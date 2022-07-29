CREATE PROCEDURE nutrientratioconstraint_status (
--
IN v_mixid LONGVARCHAR
--
)
--
MODIFIES SQL DATA DYNAMIC RESULT SETS 1 BEGIN ATOMIC
--
DECLARE result CURSOR
FOR
SELECT  E.name as NutrientA, A.a as RHSA, B.name as eq, F.name as NutrientB, A.b as RHSB, A.b/D.b*C.a as ValueA,CASE WHEN ABS(A.a - A.b/D.b*C.a) <.001 THEN 'Binding' ELSE 'Non-binding' END as status, ABS(A.a - A.b/D.b*C.a) as slack
FROM nutrientratio A, relationship B,(SELECT mixid, nutrientid, sum(q) as a FROM mixresult GROUP BY mixid, nutrientid) C,(SELECT mixid, nutrientid, sum(q) as b FROM mixresult GROUP BY mixid, nutrientid) D, Nutrient E, Nutrient F
WHERE A.mixid = v_mixid
AND A.nutrient_id_1 = (SELECT nutrient_id_1 FROM nutrientratio A WHERE A.mixid = mixid AND nutrient_id_1 = A.nutrient_id_1 AND nutrient_id_2 = A.nutrient_id_2 AND relationshipid = B.relationshipid)
AND A.nutrient_id_2 = (SELECT nutrient_id_2 FROM nutrientratio A WHERE A.mixid = mixid AND nutrient_id_1 = A.nutrient_id_1 AND nutrient_id_2 = A.nutrient_id_2 AND relationshipid = B.relationshipid)
AND A.relationshipid = B.relationshipid
AND A.mixid = C.mixid
AND A.nutrient_id_1 = C.nutrientid
AND A.mixid = D.mixid
AND A.nutrient_id_2 = D.nutrientid
AND A.nutrient_id_1 = E.nutrientid
AND A.nutrient_id_2 = F.nutrientid;
--
OPEN result;

--
END;
/
