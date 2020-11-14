CREATE FUNCTION getGIFromGL (
--
IN v_FoodId LONGVARCHAR
--
)
--
RETURNS DOUBLE READS SQL DATA BEGIN ATOMIC
--
DECLARE v_gi DOUBLE;
--
SELECT CASE WHEN b.q <= 0 OR b.q IS NULL THEN 0 ELSE (a.q*100) / b.q END INTO v_gi
FROM (SELECT *
      FROM foodfact
      WHERE foodid = v_FoodId
      AND   nutrientid = '10008') a,
     (SELECT *
      FROM foodfact
      WHERE foodid = v_FoodId
      AND   nutrientid = '10003') b
WHERE a.foodid = b.foodid;
--
RETURN v_gi;
--
END;
/