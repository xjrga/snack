CREATE PROCEDURE Mix_Copy (
--
OUT newid INTEGER,
--
IN v_MixId_Old INTEGER
--
)
--
MODIFIES SQL DATA BEGIN ATOMIC
--
DECLARE v_Name_Old LONGVARCHAR;
--
DECLARE v_ADate DATE;
--
DECLARE v_ATime TIME;
--
SELECT Name INTO v_Name_Old FROM Mix WHERE MixId = v_MixId_Old;
--
SELECT CURRENT_DATE INTO v_ADate FROM (VALUES(0));
--
SELECT LOCALTIME INTO v_ATime FROM (VALUES(0));
--
INSERT INTO Mix (
MixId,
Name,
ADate,
ATime,
Status
) VALUES (
DEFAULT,
v_Name_Old||'_copy',
v_ADate,
v_ATime,
1
);
--
SET newid = IDENTITY();
--
END;
/