CREATE PROCEDURE Mix_Select_All_1 ()
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
WHERE Status = 1
ORDER BY Name;
--
OPEN result;
--
END;
/
