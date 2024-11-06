CREATE FUNCTION escape_xml_element_data (IN v_text LONGVARCHAR) RETURNS LONGVARCHAR
--
READS SQL DATA BEGIN ATOMIC
--
DECLARE v_clean LONGVARCHAR;
--
SET v_clean = REGEXP_REPLACE (v_text,'&','&amp;');
SET v_clean = REGEXP_REPLACE (v_clean,'<','&lt;');
SET v_clean = REGEXP_REPLACE (v_clean,'>','&gt;');
--
RETURN v_clean;

--
END;
/
