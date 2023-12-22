CREATE PROCEDURE Mix_Select_All_0 ()
--
MODIFIES SQL DATA DYNAMIC RESULT SETS 1 BEGIN ATOMIC
--
DECLARE result CURSOR
FOR
SELECT MixId,
       Name,
       Status,
       NutrientId,
       Model
FROM Mix
WHERE Status = 0
ORDER BY Name;
--
OPEN result;
--
END;
/