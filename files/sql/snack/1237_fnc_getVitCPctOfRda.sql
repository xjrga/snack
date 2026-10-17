CREATE FUNCTION getVitCPctOfRda (
--
IN V_MixId LONGVARCHAR,
IN V_LifestageId INTEGER
--
)
--
RETURNS DECIMAL(28,15) READS SQL DATA BEGIN ATOMIC
--
DECLARE pct DECIMAL(28,15);

--
SELECT deficiency / dri INTO pct
FROM
(SELECT q AS deficiency FROM MixPoint WHERE MixId = V_MixId AND i = ((SELECT COUNT(*) FROM MixPoint WHERE MixId = V_MixId) - 13)) A,
(SELECT q AS dri FROM Rda WHERE LifestageId =  V_LifestageId AND NutrientId = '401') B;
--
RETURN pct;

END;
/