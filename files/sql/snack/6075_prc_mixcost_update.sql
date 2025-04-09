CREATE PROCEDURE MixCost_update (
--
IN v_MixId LONGVARCHAR,
--IN v_Name LONGVARCHAR,
--IN v_NutrientId LONGVARCHAR,
--IN v_Model LONGVARCHAR,
IN v_MixCost DECIMAL(11,5)
--
)
--
MODIFIES SQL DATA
BEGIN ATOMIC
--
UPDATE
Mix
SET
--Name = v_Name,
--NutrientId = v_NutrientId,
--Model = v_Model,
MixCost = v_MixCost
WHERE
MixId = v_MixId;
END;
--
/