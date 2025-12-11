CREATE PROCEDURE Select_group_as_xml (
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
SET doc = CHAR(10) + '<group_list>' + CHAR(10);
--
FOR select mixid, groupid, name from mixfoodgroup where mixid = v_MixId order by name DO
--
SET doc = doc +  '<group>' + CHAR(10) + '<mix-id>' + mixid + '</mix-id>' + CHAR(10)  + '<group-id>' + groupid + '</group-id>' + CHAR(10) + '<group-name>' + escape_xml_element_data(name) + '</group-name>' + CHAR(10)  + '</group>' + CHAR (10);
--
END FOR;
--
SET doc = doc + '</group_list>';
--
SET v_doc = doc;
--
END
/
