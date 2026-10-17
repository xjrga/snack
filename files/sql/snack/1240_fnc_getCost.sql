CREATE FUNCTION getCost (
--
IN V_MixId LONGVARCHAR
--
)
--
RETURNS DECIMAL(28,15) READS SQL DATA BEGIN ATOMIC
--
DECLARE excess DECIMAL(28,15);
DECLARE deficiency DECIMAL(28,15);
DECLARE cost DECIMAL(28,15);

--
SELECT q INTO excess FROM MixPoint WHERE MixId = V_MixId AND i = ((SELECT COUNT(*) FROM MixPoint WHERE MixId = V_MixId) - 1);
SELECT q INTO deficiency FROM MixPoint WHERE MixId = V_MixId AND i = ((SELECT COUNT(*) FROM MixPoint WHERE MixId = V_MixId) - 2);
SET cost = deficiency + excess;

RETURN cost;

END;
/