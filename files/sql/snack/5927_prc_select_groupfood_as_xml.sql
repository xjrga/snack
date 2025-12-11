CREATE PROCEDURE Select_groupfood_as_xml (
--
OUT v_doc LONGVARCHAR,
--
IN v_MixId LONGVARCHAR
--
)
--
MODIFIES SQL DATA
--
BEGIN ATOMIC
--
DECLARE doc LONGVARCHAR;
--
SET doc = CHAR(10) + '<groupfood_list>' + CHAR(10);
--
FOR select mixid, groupid, foodid from foodgrouplist WHERE mixid = v_MixId DO
--
SET doc = doc +  '<groupfood>' + CHAR(10) + '<mix-id>' + mixid + '</mix-id>' + CHAR(10)  + '<group-id>' + groupid + '</group-id>' + CHAR(10) + '<food-id>' + foodid + '</food-id>' + CHAR(10)  + '</groupfood>' + CHAR (10);
--
END FOR;
--
SET doc = doc + '</groupfood_list>';
--
SET v_doc = doc;
--
END
/
