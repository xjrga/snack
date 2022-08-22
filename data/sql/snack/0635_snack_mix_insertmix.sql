CREATE PROCEDURE snack_mix_insertmix (
--
IN v_mixid LONGVARCHAR,
--
IN v_name LONGVARCHAR,
--
IN v_status INTEGER,
--
IN v_nutrientid LONGVARCHAR,
--
IN v_model LONGVARCHAR
--
)
--
MODIFIES SQL DATA BEGIN ATOMIC
--
DECLARE v_adate DATE;
--
DECLARE v_atime TIME;
--
SELECT CURRENT_DATE INTO v_adate FROM (VALUES(0));
--
SELECT LOCALTIME INTO v_atime FROM (VALUES(0));
--
INSERT INTO mix (
mixid,
name,
adate,
atime,
status,
nutrientid,
model
) VALUES (
v_mixid,
v_name,
v_adate,
v_atime,
v_status,
v_nutrientid,
v_model
);
--
END;
/
--call snack_mix_insertmix('delete','delete',1,'10009','model');
--/
