CREATE PROCEDURE snack_mix_insertmix (
--
IN v_mixid LONGVARCHAR,
--
IN v_name LONGVARCHAR,
--
IN v_nutrientid LONGVARCHAR,
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
nutrientid,
model
) VALUES (
v_mixid,
v_name,
v_nutrientid,
v_model
);
--
END;
/

