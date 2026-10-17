CREATE FUNCTION getTniScore (
--
IN V_MixId LONGVARCHAR,
IN V_LifestageId INTEGER
--
)
--
RETURNS DECIMAL(28,15) READS SQL DATA BEGIN ATOMIC
--
DECLARE tniscore DECIMAL(28,15);

--
SELECT
(1 - ((
getCalciumPctOfRda(V_MixId,V_LifestageId) +
getMagnesiumPctOfRda(V_MixId,V_LifestageId) +
getPotassiumPctOfRda(V_MixId,V_LifestageId) +
getVitAPctOfRda(V_MixId,V_LifestageId) +
getVitEPctOfRda(V_MixId,V_LifestageId) +
getVitDPctOfRda(V_MixId,V_LifestageId) +
getVitCPctOfRda(V_MixId,V_LifestageId) +
getCholinePctOfRda(V_MixId,V_LifestageId) ) / CAST (8.0 AS DECIMAL(25,18)))) * 100 INTO tniscore
FROM (VALUES(0));
--
RETURN tniscore;

END;
/