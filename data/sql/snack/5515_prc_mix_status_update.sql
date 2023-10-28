CREATE PROCEDURE Mix_Update_Status (
--
IN v_MixId LONGVARCHAR,
--
IN v_Status INTEGER
--
)
--
MODIFIES SQL DATA BEGIN ATOMIC
--
UPDATE
Mix
SET
Status = v_Status
WHERE
MixId = v_MixId;
--
END;
/
