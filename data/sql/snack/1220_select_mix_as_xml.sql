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
--SELECT  '<mix>' +CHAR(10) + '<mixid>' + mixid + '</mixid>' +CHAR(10) + '<name>' + Name + '</name>' +CHAR(10) + '<nutrientid>' + Nutrientid + '</nutrientid>' +CHAR(10) + '<model>' + Model + '</model>' +CHAR(10) + '<note>' + Note + '</note>' +CHAR(10) + '</mix>' INTO doc FROM Mix WHERE mixid = v_MixId;
SELECT  '<mix>' +CHAR(10) + '<mixid>' + mixid + '</mixid>' +CHAR(10) + '<name>' + Name + '</name>' + CHAR(10) + '<nutrientid>' + Nutrientid + '</nutrientid>' + CHAR(10)  + '</mix>'  INTO doc FROM Mix WHERE mixid = v_MixId;
--
SET v_doc = doc + CHAR (10);
--
END
/