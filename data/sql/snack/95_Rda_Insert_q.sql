CREATE PROCEDURE Rda_Insert_q (
IN v_NutrientId LONGVARCHAR,
IN v_LifeStageId INTEGER,
IN v_q DOUBLE
)
MODIFIES SQL DATA BEGIN ATOMIC
INSERT INTO Rda (
NutrientId,
LifeStageId,
q,
ul
) VALUES (
v_NutrientId,
v_LifeStageId,
v_q,
DEFAULT
);
END;
/