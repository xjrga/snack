CREATE PROCEDURE Mix_Delete (
IN v_MixId LONGVARCHAR
)
MODIFIES SQL DATA BEGIN ATOMIC
DELETE FROM
Mix
WHERE
MixId = v_MixId;
END;
/
