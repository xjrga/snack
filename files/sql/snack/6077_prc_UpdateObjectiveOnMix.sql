CREATE PROCEDURE UpdateObjectiveOnMix (
--
IN v_MixId LONGVARCHAR,
IN v_NutrientId LONGVARCHAR
--
)
--
MODIFIES SQL DATA
BEGIN ATOMIC
--
UPDATE
Mix
SET
NutrientId = v_NutrientId
WHERE
MixId = v_MixId;
END;
--
/