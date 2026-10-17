CREATE PROCEDURE updateTniScore (
--
IN V_MixId LONGVARCHAR,
IN V_LifestageId INTEGER
--
)
--
MODIFIES SQL DATA
BEGIN ATOMIC
--
UPDATE
Mix
SET
MixCost = getCost(V_MixId),
TniScore = getTniScore(V_MixId, V_LifestageId)
WHERE
MixId = V_MixId;
END;
--
/