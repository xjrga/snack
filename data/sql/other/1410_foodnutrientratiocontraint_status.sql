CREATE PROCEDURE foodnutrientratioconstraint_status (
--
IN v_mixid LONGVARCHAR
--
)
--
MODIFIES SQL DATA DYNAMIC RESULT SETS 1 BEGIN ATOMIC
--
DECLARE result CURSOR
FOR
SELECT E.name as FoodA, F.name as NutrientA,A.a as RHSA, B.name as eq,G.name as FoodB, H.name as NutrientB, A.b as RHSB, A.b/D.b*C.a as VALUEA,CASE WHEN ABS(A.a - A.b/D.b*C.a) <.001 THEN 'Binding' ELSE 'Non-binding' END as status, ABS(A.a - A.b/D.b*C.a) as slack
FROM foodnutrientratio A, relationship B,(SELECT mixid, foodid, nutrientid, sum(q) as a FROM mixresult GROUP BY mixid, foodid, nutrientid) C,(SELECT mixid, foodid, nutrientid, sum(q) as b FROM mixresult GROUP BY mixid, foodid,nutrientid) D,
Food E, Nutrient F, Food G, Nutrient H
WHERE A.mixid = v_mixid
AND A.food_id_1 = (SELECT food_id_1 FROM foodnutrientratio A WHERE A.mixid = mixid AND food_id_1 = A.food_id_1 AND nutrient_id_1 = A.nutrient_id_1 AND food_id_2 = A.food_id_2 AND nutrient_id_2 = A.nutrient_id_2 AND relationshipid = B.relationshipid) 
AND A.nutrient_id_1 = (SELECT nutrient_id_1 FROM foodnutrientratio A WHERE A.mixid = mixid AND food_id_1 = A.food_id_1 AND nutrient_id_1 = A.nutrient_id_1 AND food_id_2 = A.food_id_2 AND nutrient_id_2 = A.nutrient_id_2 AND relationshipid = B.relationshipid)
AND A.food_id_2 =  (SELECT food_id_2 FROM foodnutrientratio A WHERE A.mixid = mixid AND food_id_1 = A.food_id_1 AND nutrient_id_1 = A.nutrient_id_1 AND food_id_2 = A.food_id_2 AND nutrient_id_2 = A.nutrient_id_2 AND relationshipid = B.relationshipid) 
AND A.nutrient_id_2 = (SELECT nutrient_id_2 FROM foodnutrientratio A WHERE A.mixid = mixid AND food_id_1 = A.food_id_1 AND nutrient_id_1 = A.nutrient_id_1 AND food_id_2 = A.food_id_2 AND nutrient_id_2 = A.nutrient_id_2 AND relationshipid = B.relationshipid)
AND A.relationshipid = B.relationshipid
AND A.mixid = C.mixid
AND A.food_id_1 = C.foodid
AND A.nutrient_id_1 = C.nutrientid
AND A.mixid = D.mixid
AND A.food_id_1 = D.foodid
AND A.nutrient_id_2 = D.nutrientid
AND A.food_id_1 = E.foodid
AND A.nutrient_id_1 = F.nutrientid
AND A.food_id_2 = G.foodid
AND A.nutrient_id_2 = H.nutrientid;

--
OPEN result;

--
END;
/
