CREATE PROCEDURE dridev_tni_rhs (
--
IN v_mixid LONGVARCHAR,
IN v_lifestageid INTEGER
--
)
--
MODIFIES SQL DATA DYNAMIC RESULT SETS 1 BEGIN ATOMIC
--
DECLARE result CURSOR
FOR
--Total Nutrient Index (Ca,Mg,K, VitA, VitE, VitD, VitC, Choline)
SELECT v_mixid AS mixid,
       nutrientid,
       relationshipid,
       d.q AS b,
       b.name AS nutrient,
       b.label AS nutrientlabel,
       c.name AS eq
FROM nutrient b,
     relationship c,
     rda d
WHERE relationshipid = 3
AND b.tni = 1
AND b.nutrientid = d.nutrientid
AND d.lifestageid = v_lifestageid
ORDER BY nutrientid;
--
OPEN result;
--
END;
/
