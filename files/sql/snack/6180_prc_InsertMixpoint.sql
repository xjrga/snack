CREATE PROCEDURE InsertMixPoint (
--
IN v_MixId LONGVARCHAR,
IN v_i INTEGER,
IN v_q DECIMAL(11,5)
--
)
--
MODIFIES SQL DATA
BEGIN ATOMIC
--
INSERT INTO MixPoint (
MixId,
i,
q
) VALUES (
v_MixId,
v_i,
v_q
);
--
END;
/