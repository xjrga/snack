CREATE PROCEDURE updateMix (
--
IN v_MixId LONGVARCHAR,
IN v_LifeStageId INTEGER,
IN v_Model LONGVARCHAR,
IN v_MixCost DECIMAL(11,5),
IN v_MixDeficiency DECIMAL(11,5),
IN v_MixExcess DECIMAL(11,5)
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
Model = v_Model,
MixCost = v_MixCost,
MixDeficiency = v_MixDeficiency,
MixExcess = v_MixExcess
WHERE
MixId = v_MixId;
END;
--
/
