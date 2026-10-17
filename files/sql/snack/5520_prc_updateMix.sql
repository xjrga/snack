CREATE PROCEDURE updateMix (
--
IN v_MixId LONGVARCHAR,
IN v_LifeStageId INTEGER,
IN v_Model LONGVARCHAR
--
)
--
MODIFIES SQL DATA
BEGIN ATOMIC
--
UPDATE
Mix
SET
LifeStageId = v_LifeStageId,
Model = v_Model
WHERE
MixId = v_MixId;
END;
--
/
