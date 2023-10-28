CREATE PROCEDURE Mix_Insert (
--
OUT newid LONGVARCHAR,
--
IN v_Name LONGVARCHAR
--
)
--
MODIFIES SQL DATA BEGIN ATOMIC
--
DECLARE v_ADate DATE;
--
DECLARE v_ATime TIME;
--
DECLARE newid2 LONGVARCHAR;
--
SELECT CURRENT_DATE INTO v_ADate FROM (VALUES(0));
--
SELECT LOCALTIME INTO v_ATime FROM (VALUES(0));
--
SELECT generateId() INTO newid2 FROM (VALUES(0));
--
INSERT INTO Mix (
MixId,
Name,
ADate,
ATime
) VALUES (
newid2,
v_Name,
v_ADate,
v_ATime
);
--
SET newid = newid2;
--
END;
/