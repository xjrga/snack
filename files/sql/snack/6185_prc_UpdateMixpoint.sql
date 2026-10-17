CREATE PROCEDURE UpdateMixPoint (
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
UPDATE
MixPoint
SET
q = v_q
WHERE
MixId = v_MixId AND
i = v_i;
END;
--
/