CREATE PROCEDURE Units_insert (
--
IN v_UnitId INTEGER,
IN v_Name LONGVARCHAR,
IN v_Factor DOUBLE
--
)
--
MODIFIES SQL DATA
BEGIN ATOMIC
--
INSERT INTO Units (
UnitId,
Name,
Factor
) VALUES (
v_UnitId,
v_Name,
v_Factor
);
--
END;
/
