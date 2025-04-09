CREATE FUNCTION getCategoryId (
--
IN v_foodid LONGVARCHAR
--
) RETURNS LONGVARCHAR
--
READS SQL DATA BEGIN ATOMIC 
--
DECLARE v_categoryid LONGVARCHAR;
--
SELECT a.foodcategoryid INTO v_categoryid
FROM foodcategory a,
     categorylink b
WHERE a.foodcategoryid = b.foodcategoryid
AND b.foodid = v_foodid;
--
RETURN v_categoryid;
--
END;
/