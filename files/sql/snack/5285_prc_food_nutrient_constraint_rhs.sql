CREATE PROCEDURE foodnutrient_rhs (
--
IN v_MixId LONGVARCHAR
--
)
--
MODIFIES SQL DATA DYNAMIC RESULT SETS 1 BEGIN ATOMIC
--
DECLARE result CURSOR
FOR
SELECT mixid,
       foodid,
       nutrientid,
       relationshipid,
       b,
       b.name as food,
       c.name as nutrient,
       d.name as eq
FROM foodnutrientconstraint a, food b, nutrient c, relationship d
WHERE mixid = v_mixid
AND a.foodid = b.foodid
AND a.nutrientid = c.nutrientid
AND a.relationshipid = d.relationshipid
ORDER BY foodid;
--
OPEN result;
--
END;
/
