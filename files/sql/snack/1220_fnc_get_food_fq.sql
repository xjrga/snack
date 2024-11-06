CREATE FUNCTION get_food_fq(
--
IN v_foodid LONGVARCHAR
--
) RETURNS DOUBLE
--
READS SQL DATA BEGIN ATOMIC
--
DECLARE fq DOUBLE;
--
SET fq = 0;
--
IF get_foodfact(v_foodid,'10009') > 0 THEN
--
SELECT
--eCarbs
get_foodfact(v_foodid,'10011') / get_foodfact(v_foodid,'10009') * 1.00 +
--eFat
get_foodfact(v_foodid,'10013') / get_foodfact(v_foodid,'10009') * 0.71 +
--eProtein
get_foodfact(v_foodid,'10012') / get_foodfact(v_foodid,'10009') * 0.81 +
--eAlcohol
get_foodfact(v_foodid,'10014') / get_foodfact(v_foodid,'10009') * 0.667
--
INTO fq
--
FROM (VALUES(0));
--
END IF;
--
RETURN fq;
--
END;
/
