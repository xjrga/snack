CREATE PROCEDURE snack_mix_insertmix (
--
IN v_mixid LONGVARCHAR,
--
IN v_name LONGVARCHAR,
--
IN v_LifeStageId INTEGER,
--
IN v_model LONGVARCHAR
--
)
--
MODIFIES SQL DATA BEGIN ATOMIC
--
INSERT INTO mix (
mixid,
name,
lifestageid,
model
) VALUES (
v_mixid,
v_name,
v_LifeStageId,
v_model
);
--
END;
/

