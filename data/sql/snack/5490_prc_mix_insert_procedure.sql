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
DECLARE newid2 LONGVARCHAR;
--
SELECT generateId() INTO newid2 FROM (VALUES(0));
--
INSERT INTO Mix (
MixId,
Name
) VALUES (
newid2,
v_Name
);
--
SET newid = newid2;
--
END;
/