CREATE PROCEDURE Mix_Select_All()
MODIFIES SQL DATA DYNAMIC RESULT SETS 1 BEGIN ATOMIC
--
DECLARE result CURSOR
FOR
SELECT MixId,
       Name,
       LifeStageId,
       Model,
       MixCost
FROM Mix
ORDER BY Name;
--
OPEN result;
--
END;
/
