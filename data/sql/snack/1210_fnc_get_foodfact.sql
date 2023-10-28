CREATE FUNCTION get_foodfact (
--
IN v_foodid LONGVARCHAR,
--
IN v_nutrientid LONGVARCHAR
--

) RETURNS DOUBLE
--
READS SQL DATA BEGIN ATOMIC
--
DECLARE v_q DOUBLE;
--
SELECT q INTO v_q FROM FoodFact WHERE foodid = v_foodid AND nutrientid = v_nutrientid;
--
RETURN IFNULL(v_q,0);
--
END;
/
