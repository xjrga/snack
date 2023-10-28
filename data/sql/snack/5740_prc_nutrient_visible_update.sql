CREATE PROCEDURE Nutrient_Update (
IN v_NutrientId LONGVARCHAR,
IN v_Visible INTEGER
)
MODIFIES SQL DATA BEGIN ATOMIC
UPDATE
Nutrient
SET
Visible = v_Visible
WHERE
NutrientId = v_NutrientId;
END;
/
