CREATE FUNCTION get_dri (
--
IN v_LifeStageId INTEGER,
--
IN v_NutrientId LONGVARCHAR
--
)
--
RETURNS DOUBLE READS SQL DATA BEGIN ATOMIC
--
DECLARE v_c DOUBLE;

--
SELECT q INTO v_c  FROM rda WHERE lifestageid = v_LifeStageId AND nutrientid = v_NutrientId;
--
RETURN v_c;

END;
/
