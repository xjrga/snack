CREATE PROCEDURE Select_mix_as_xml (
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
SET doc = '';
--
SELECT  '<mix>' +CHAR(10) + '<mix-id>' + mixid + '</mix-id>' +CHAR(10) + '<mix-name>' + escape_xml_element_data(Name) + '</mix-name>' + CHAR(10) + '<nutrient-id>' + nutrientid + '</nutrient-id>' + CHAR(10)  + '</mix>'  INTO doc FROM Mix WHERE mixid = v_MixId;
--
SET v_doc = doc + CHAR (10);
--
END
/