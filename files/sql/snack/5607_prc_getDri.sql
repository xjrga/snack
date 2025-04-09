CREATE PROCEDURE getDri(
--
IN vNutrientid LONGVARCHAR,
--
IN vLifestageid LONGVARCHAR
--
)
--
MODIFIES SQL DATA DYNAMIC RESULT SETS 1 BEGIN ATOMIC
--
DECLARE result CURSOR
FOR
--
SELECT a.nutrientid,
       a.name,
       a.units,
       b.lifestageid,
       c.label,
       b.q
FROM nutrient a,
     rda b,
     rdalifestage c
WHERE a.nutrientid = b.nutrientid
AND b.lifestageid = c.lifestageid
AND   c.lifestageid = vLifestageid
AND a.nutrientid = vNutrientid;
--
OPEN result;
--
END;
/
